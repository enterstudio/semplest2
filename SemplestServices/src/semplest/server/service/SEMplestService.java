package semplest.server.service;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.client.nio.NIOClient;
import semplest.client.nio.NIOResponseHandler;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;
import semplest.server.service.queue.ServiceActiveMQConnection;

import com.google.gson.Gson;

public class SEMplestService
{
	public static Properties properties = null;
	private ESBConnectionData connectionData = null;
	private NIOClient nioClient = null;
	private NIOResponseHandler handler = null;
	private ServiceActiveMQConnection mq = null;
	private ProtocolJSON json = new ProtocolJSON();
	private static final Logger logger = Logger.getLogger(SEMplestService.class);

	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	public static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
	public static ExecutorService executor = null;
	private static String INITMETHODNAME = "initializeService";

	private ServiceInterface service;

	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			// startup the service by registering the instance with the semplest ESB
			String serviceNameOverride = null;
			if (args.length == 1)
			{
				serviceNameOverride = args[0];
			}
			SEMplestService service = new SEMplestService();
			service.configureLogging();
			if (service.readProperties(serviceNameOverride))
			{
				service.initializeService(service);
				logger.info("called Init Service");
				executor = Executors.newFixedThreadPool(service.connectionData.getNumberServiceThreads());
				if (service.registerServiceWithESB())
				{
					logger.info("Registered Service");
					
					
				}
			}
		}
		catch (Exception e)
		{
			logger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	
	//Call the initializeService method on the Service
	private void initializeService(SEMplestService service) throws Exception
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
			connectionData.setServerURI(properties.getProperty("ESBServerIP"));
			connectionData.setServerport(properties.getProperty("ESBServerPort"));
			connectionData.setPingFrequencyMS(Integer.parseInt(properties.getProperty("PingFrequencyMS")));
			connectionData.setServiceOffered(properties.getProperty("semplest.service"));
			connectionData.setNumberServiceThreads(Integer.parseInt(properties.getProperty("NumberServiceThreads")));
			if (ServiceNameOveride != null)
			{
				connectionData.setServiceName(ServiceNameOveride);
				properties.setProperty("ServiceName", ServiceNameOveride);
			}
			else
			{
				connectionData.setServiceName(properties.getProperty("ServiceName"));
			}
			logger.info("Read in Properites for service " + connectionData.getServiceName() + ":" + connectionData.getServiceOffered());
			return true;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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
			logger.debug("Reg with ESB " + connectionData.getServerURI() + ":" + connectionData.getServerport());
			// create a Thread to connect via socket
			nioClient = new NIOClient(connectionData.getServerURI(), connectionData.getServerport());
			Thread t = new Thread(nioClient);
			t.setDaemon(true);
			t.start();
			handler = new NIOResponseHandler();
			//add shutdown hook
			ServiceShutdown shutdown = new ServiceShutdown(nioClient, connectionData.getServiceName(), connectionData.getServiceOffered());
			Thread shutdownHook = new Thread(shutdown);
			Runtime.getRuntime().addShutdownHook(shutdownHook);
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
					PingService ping = new PingService(nioClient, new NIOResponseHandler(), connectionData.getServiceName(),
							connectionData.getPingFrequencyMS());
					Thread pingThread = new Thread(ping);
					pingThread.setPriority(Thread.MAX_PRIORITY);
					pingThread.start();
				}
				// create a connection to the destination queue
				mq = new ServiceActiveMQConnection(data.getmessageQueueIP(), data.getmessageQueuePort());
				mq.createProducer(data.getServiceSendQueueName());
				mq.createConsumer(data.getServiceRecQueueName());
				
				logger.info("Service registered " + data.getServiceSendQueueName());
				

			}
			logger.debug("Done wit Reg to ESB");
			return true;
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
