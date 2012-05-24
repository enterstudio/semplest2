package semplest.server.service;


import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import semplest.client.nio.NIOClient;
import semplest.client.nio.NIOResponseHandler;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;
import semplest.server.service.queue.ServiceActiveMQConnection;

import com.google.gson.Gson;

public class SEMplestServiceNioDebug implements Runnable
{
	public static Properties properties = null;
	private ESBConnectionData connectionData = null;
	private NIOClient nioClient = null;
	private NIOResponseHandler handler = null;
	private ServiceActiveMQConnection mq = null;
	private ProtocolJSON json = new ProtocolJSON();
	private static final Logger logger = Logger.getLogger(SEMplestServiceNioDebug.class);

	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	//public static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
	public static ExecutorService executor = null;
	private static String INITMETHODNAME = "initializeService";

	private ServiceInterface service;

	public void run()
	{
		try
		{
			// startup the service by registering the instance with the semplest ESB
			String serviceNameOverride = "SemplestTestServiceJulian";
			SEMplestServiceNioDebug service = new SEMplestServiceNioDebug();
			service.setUpConfigurationParameters();
			if (service.registerServiceWithESB())
			{
				logger.info("Registered Service");
				
				
			}
			/*service.configureLogging();
			
			if (service.readProperties(serviceNameOverride))
			{
				service.initializeService(service);
				service.setUpConfigurationParameters();
				logger.info("called Init Service");
				executor = Executors.newFixedThreadPool(service.connectionData.getNumberServiceThreads());
				if (service.registerServiceWithESB())
				{
					logger.info("Registered Service");
					
					
				}
			}
			*/
		}
		catch (Exception e)
		{
			logger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		final SEMplestServiceNioDebug service1 = new SEMplestServiceNioDebug();
		service1.run();
		/*
		final SEMplestServiceNioDebug service2 = new SEMplestServiceNioDebug();
		(new Thread(service1)).start();
		(new Thread(service2)).start();*/
	}
	
	//Call the initializeService method on the Service
	private void initializeService(SEMplestServiceNioDebug service) throws Exception
	{
		Class initClass = Class.forName(service.connectionData.getServiceOffered());
		Constructor constructor =initClass.getConstructor();
		ServiceInterface myService = (ServiceInterface) constructor.newInstance();
		String empty = ""; //new String[] {};
		Gson gson = new Gson();
		String json = gson.toJson(empty);
		String ret = myService.ServiceGet(INITMETHODNAME, json);
		logger.debug("Ret = " + ret);
	}

	private boolean readProperties(String ServiceNameOveride)
	{
		try
		{
			properties = new Properties();
			FileInputStream is = new FileInputStream(PROPSFILE);
			properties.load(is);
			is.close();

			connectionData = new ESBConnectionData();
			connectionData.setServiceOffered(properties.getProperty("semplest.service"));
			if (ServiceNameOveride != null)
			{
				connectionData.setServiceName(ServiceNameOveride);
				properties.setProperty("ServiceName", ServiceNameOveride);
			}
			else
			{
				connectionData.setServiceName(properties.getProperty("ServiceName"));
			}
			logger.info("Configuration for service " + connectionData.getServiceName() + ":" + connectionData.getServiceOffered());
			return true;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private void setUpConfigurationParameters()
	{
		/*
		 onnectionData.setServerURI((String) SemplestConfiguration.configData.get("ServiceESBServerIP")); // properties.getProperty("ESBServerIP"));	
		connectionData.setServerport(String.valueOf((Integer) SemplestConfiguration.configData.get("ServiceESBServerPort"))); //properties.getProperty("ESBServerPort"));
		connectionData.setPingFrequencyMS((Integer) SemplestConfiguration.configData.get("ServicePingFrequencyMS")); //Integer.parseInt(properties.getProperty("PingFrequencyMS")));
		connectionData.setNumberServiceThreads((Integer) SemplestConfiguration.configData.get("ServiceNumberServiceThreads")); //Integer.parseInt(properties.getProperty("NumberServiceThreads"))); //
		*/
		connectionData = new ESBConnectionData();
		connectionData.setServiceOffered("semplest.service");
		
		connectionData.setServiceName("TESTINGNIO");
		connectionData.setServerURI("localhost"); // properties.getProperty("ESBServerIP"));
		connectionData.setServerport("" + 9090); //properties.getProperty("ESBServerPort"));
		connectionData.setPingFrequencyMS(100); //Integer.parseInt(properties.getProperty("PingFrequencyMS")));
		connectionData.setNumberServiceThreads(100); //Integer.parseInt(properties.getProperty("NumberServiceThreads"))); //
		
		/*
		 * InetAddress hostAddress = null
		 * int port = 9090
		 * ProcessRequestWorker worker = 
		 * ESBServer esbServer = null
		 */
		
		logger.info("Setup Config Parameters");
	}

	public void configureLogging()
	{
		// BasicConfigurator.configure();
		PropertyConfigurator.configure(LOG4JPROPSFILE);
		logger.info("Starting log4j....");
	}

	private boolean registerServiceWithESB()
	{

		try
		{
			BasicConfigurator.configure();
			logger.debug("Reg with ESB " + connectionData.getServerURI() + ":" + connectionData.getServerport());
			// create a Thread to connect via socket
			nioClient = new NIOClient(connectionData.getServerURI(), connectionData.getServerport());
			Thread t = new Thread(nioClient);
			t.setDaemon(true);
			t.start();
			
			handler = new NIOResponseHandler();
			//add shutdown hook
			//ServiceShutdown shutdown = new ServiceShutdown(nioClient, connectionData.getServiceName(), connectionData.getServiceOffered());
			//Thread shutdownHook = new Thread(shutdown);
			//Runtime.getRuntime().addShutdownHook(shutdownHook);			
			// create the register packet
			ProtocolSocketDataObject regdata = new ProtocolSocketDataObject();
			regdata.setHeader(ProtocolJSON.SEMplest_REGISTER);
			regdata.setclientServiceName(connectionData.getServiceName());
			regdata.setServiceOffered(connectionData.getServiceOffered());
			regdata.setPingFrequency(connectionData.getPingFrequencyMS());

			// convert to JSON
			String jsonStr = json.createJSONFromSocketDataObj(regdata);
			byte[] regPacket = ProtocolJSON.createBytePacketFromString(jsonStr);
			logger.debug("Send regPacket " + jsonStr);
			// send the Registration pacjket
			nioClient.send(regPacket, handler);
			// wait synchronously for response
			byte[] response = handler.waitForResponse();
			// create ProtocolSocketDataObject from response
			ProtocolSocketDataObject data = json.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(response));
			logger.debug("Response REC - " + data.getclientServiceName() + ":" + data.getServiceOffered() + ": ping Freq=" + data.getPingFrequency() + ": Header=" + data.getheader());
			if (data.getheader() == ProtocolJSON.SEMplest_REGISTER)
			{
				// create a Pi thread
				if (connectionData.getPingFrequencyMS() > 0)
				{
					logger.debug("Start Pinging....with Frequency=" + connectionData.getPingFrequencyMS());
					PingService ping = new PingService(connectionData.getServerURI(), Integer.parseInt(connectionData.getServerport()), connectionData.getServiceName(),
							connectionData.getPingFrequencyMS());
					Thread pingThread = new Thread(ping);
					pingThread.setPriority(Thread.MAX_PRIORITY);
					pingThread.start();
				}
				// create a connection to the destination queue
				logger.debug("setting up MQ IP: " + data.getmessageQueueIP() + ":" + data.getmessageQueuePort() + " sendQ=" + data.getServiceSendQueueName() + " RecQ=" +  data.getServiceRecQueueName());
				//mq = new ServiceActiveMQConnection(data.getmessageQueueIP(), data.getmessageQueuePort());
				//mq.createProducer(data.getServiceSendQueueName());
				//mq.createConsumer(data.getServiceRecQueueName());
				
				logger.info("Service registered " + data.getServiceSendQueueName());
				

			}
			else
			{
				logger.error("ERROR - The Data Header rec from ESB was not SEMplest REGISTER");
				return false;
			}
			logger.debug("Done with Reg to ESB");
			return true;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
