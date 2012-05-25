package semplest.server.ESB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.servlet.AsyncContext;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import semplest.server.nio.NIOServer;
import semplest.server.nio.ProcessRequestWorker;
import semplest.server.queue.ActiveMQConnection;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class ESBServer
{
	private Properties properties = null;
	private static final String SERVERPROPSFILE = "properties/system.properties";
	private static final String LOG4JSERVERPROPSFILE = "properties/log4j_server.properties";
	public static ESBServer esb = null;
	
	private ESBServerData serverData = null;
	private Server webServer = null; // Jetty Server
	private ActiveMQBroker MQBroker = null;
	private ActiveMQConnection MQConnection = null;
	//servicesMap for each serviceOffered have list of serviceNames
	private ConcurrentHashMap<String, Vector<String>> servicesMap = new ConcurrentHashMap<String, Vector<String>>();
	//for each serviceName - serviceRegistration Data
	private ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = new ConcurrentHashMap<String, ServiceRegistrationData>();
	private ConcurrentHashMap<String, AtomicInteger> currentServiceIndexMap = new ConcurrentHashMap<String, AtomicInteger>();
	//private AtomicInteger currentServiceIndex = new AtomicInteger(0);
	private ConcurrentHashMap<String, AsyncContext> ServletAsynchContextMap = new ConcurrentHashMap<String, AsyncContext>();
	
	private static final Logger logger = Logger.getLogger(ESBServer.class); 
	private Executor executor = null;


	public boolean readProperties() throws IOException
	{
		
		properties = new Properties();
		FileInputStream is = new FileInputStream(SERVERPROPSFILE);
		properties.load(is);
		is.close();


		serverData = new ESBServerData();
		serverData.setBrokerName(properties.getProperty("BrokerName"));
		serverData.setBrokerPort(properties.getProperty("BrokerPort"));
		serverData.setBrokerIP(properties.getProperty("BrokerIP"));
		serverData.setRegServicePort(properties.getProperty("RegServicePort"));
		serverData.setWebServerPort(properties.getProperty("WebServerPort"));
		serverData.setAsynchServletCorePoolSize(Integer.parseInt(properties.getProperty("AsynchServletCorePoolSize")));
		serverData.setAsynchServletMaxPoolSize(Integer.parseInt(properties.getProperty("AsynchServletMaxPoolSize")));
		serverData.setAsynchServletMaxWorkInQueue(Integer.parseInt(properties.getProperty("AsynchServletMaxWorkInQueue")));
		serverData.setAsynchCallDefaultTimeoutMS(Integer.parseInt(properties.getProperty("AsynchCallDefaultTimeoutMS")));
		serverData.setHeaderBufferSize(Integer.parseInt(properties.getProperty("HeaderBufferSize")));
		logger.info("Read properties file...");
		return true;

	}
	
	public void configureLogging()
	{
		//BasicConfigurator.configure();
		// Configured Log4j
		PropertyConfigurator.configure(LOG4JSERVERPROPSFILE);

		logger.info("Starting log4j....");
	}

	public boolean createRegistrationServer()
	{
		try
		{
			logger.debug("Starting NIO reg Server...");
			// create the NIO server to handle incoming registration
			ProcessRequestWorker worker = new ProcessRequestWorker();
			new Thread(worker).start();
			new Thread(new NIOServer(null, Integer.parseInt(serverData.getRegServicePort()), worker, this)).start();
			logger.debug("NIO Started...");
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public void startMQ(String brokerName, String brokerIP, String brokerPort) throws JMSException
	{
		logger.debug("Starting ActiveMQ...");
		MQBroker = new ActiveMQBroker(brokerName, brokerIP, brokerPort);
		MQBroker.run();
		MQConnection = new ActiveMQConnection(brokerIP, brokerPort);
		logger.debug("ActiveMQ Started...");
	}

	public void runServletContainer() throws Exception
	{
		//setup the executor for the servlet
		logger.debug("Starting Servlet Container...");
		executor = new ThreadPoolExecutor(serverData.getAsynchServletCorePoolSize(), serverData.getAsynchServletMaxPoolSize(), 50000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(serverData.getAsynchServletMaxWorkInQueue()));
		Server server = new Server(Integer.parseInt(serverData.getWebServerPort()));
		server.getConnectors()[0].setRequestHeaderSize(serverData.getHeaderBufferSize());
		server.getConnectors()[0].setResponseBufferSize(serverData.getHeaderBufferSize());
		
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
		//sh.setInitParameter("com.sun.jersey.config.property.packages", serverData.getJerseyPackage());
		sh.setAsyncSupported(true);
		// un-comment these to enable tracing of requests and responses
		// sh.setInitParameter("com.sun.jersey.config.feature.Debug", "true");
		// sh.setInitParameter("com.sun.jersey.config.feature.Trace", "true");//
		// sh.setInitParameter("com.sun.jersey.spi.container.ContainerRequestFilters",
		// "com.sun.jersey.api.container.filter.LoggingFilter");
		// sh.setInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters",
		// "com.sun.jersey.api.container.filter.LoggingFilter");
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		context.addServlet(sh, "/*");
		context.addServlet("semplest.server.ESB.AsyncServlet", "/*");
		server.setHandler(context);
		logger.debug("Servlet Container Start...");
		server.start();
		server.join();
	}

	public static void main(String[] args) throws Exception
	{

		try
		{

			esb = new ESBServer();
			esb.configureLogging();
			logger.info("Starting Semplest ESB Server....");
			if (esb.readProperties())
			{
				// Start the ActiveMQ on the local server
				esb.startMQ(esb.serverData.getBrokerName(), esb.serverData.getBrokerIP(), esb.serverData.getBrokerPort());
				// Use NIO to startup a registration server
				esb.createRegistrationServer();
				// startup Jersey and Jetty Servlet container
				esb.runServletContainer();
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Stopping server...");
			if (esb.webServer != null)
			{
				esb.webServer.stop();
			}
		}

	}

	public ESBServerData getServerData()
	{
		return serverData;
	}

	public ActiveMQConnection getMQConnection()
	{
		return MQConnection;
	}

	public Vector<String> getServiceNameList(String serviceOffered)
	{
		if (this.servicesMap.containsKey(serviceOffered))
		{
			return this.servicesMap.get(serviceOffered);
		}
		else
		{
			logger.debug("No List of ServiceNames for " + serviceOffered);
			return null;
		}
	}
	public void setServiceNameList(String serviceOffered, String serviceName)
	{
		if (this.servicesMap.containsKey(serviceOffered))
		{
			Vector<String> list = this.servicesMap.get(serviceOffered);
			list.add(serviceName);
		}
		else
		{
			Vector<String> list = new Vector<String>();
			list.add(serviceName);
			servicesMap.put(serviceOffered, list);
		}
	}

	
	public ConcurrentHashMap<String, ServiceRegistrationData> getServiceRegistrationMap()
	{
		return serviceRegistrationMap;
	}
	public String getServiceOfferedFromRegMap(String serviceName)
	{
		if (serviceRegistrationMap.containsKey(serviceName))
		{
			return serviceRegistrationMap.get(serviceName).getServiceOffered();
		}
		else
		{
			return null;
		}
	}

	/*
	public void setServiceRegistrationMap(ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap)
	{
		this.serviceRegistrationMap = serviceRegistrationMap;
	}
	*/

	public int readCurrentServiceIndexAndIncrement(String serviceOffered) throws Exception
	{
		if (currentServiceIndexMap.containsKey(serviceOffered))
		{
			return currentServiceIndexMap.get(serviceOffered).incrementAndGet();
		}
		else
		{
			throw new Exception("No Service for " + serviceOffered + " Available");
		}
	}

	public Executor getExecutor()
	{
		return executor;
	}

	public ConcurrentHashMap<String, AsyncContext> getServletAsynchContextMap()
	{
		return ServletAsynchContextMap;
	}

	public void setServletAsynchContextMap(ConcurrentHashMap<String, AsyncContext> servletAsynchContextMap)
	{
		ServletAsynchContextMap = servletAsynchContextMap;
	}

	public ConcurrentHashMap<String, AtomicInteger> getCurrentServiceIndexMap()
	{
		return currentServiceIndexMap;
	}
}
