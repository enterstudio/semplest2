package semplest.server.service;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.net.Socket;
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
				service.setUpConfigurationParameters();
				logger.info("called Init Service");
				executor = Executors.newFixedThreadPool(service.connectionData.getNumberServiceThreads());
				/*
				if (service.registerServiceWithESB())
				{
					logger.info("Registered Service");
				}
				*/
				//Create a thread to register and ping
				PingService ping = new PingService(service.connectionData);
				Thread pingThread = new Thread(ping);
				pingThread.setPriority(Thread.MAX_PRIORITY);
				pingThread.start();
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
		connectionData.setServerURI((String) SemplestConfiguration.configData.get("ServiceESBServerIP")); // properties.getProperty("ESBServerIP"));
		connectionData.setServerport(String.valueOf((Integer) SemplestConfiguration.configData.get("ServiceESBServerPort"))); //properties.getProperty("ESBServerPort"));
		connectionData.setPingFrequencyMS((Integer) SemplestConfiguration.configData.get("ServicePingFrequencyMS")); //Integer.parseInt(properties.getProperty("PingFrequencyMS")));
		connectionData.setNumberServiceThreads((Integer) SemplestConfiguration.configData.get("ServiceNumberServiceThreads")); //Integer.parseInt(properties.getProperty("NumberServiceThreads"))); //
		connectionData.setESBPingWaitMS((Integer) SemplestConfiguration.configData.get("ServiceESBPingWaitMS"));
		logger.info("Setup Config Parameters");
	}

	public void configureLogging()
	{
		// BasicConfigurator.configure();
		PropertyConfigurator.configure(LOG4JPROPSFILE);
		logger.info("Starting log4j....");
	}

	/*
	private boolean registerServiceWithESB()
	{

		try
		{
			logger.debug("Reg with ESB " + connectionData.getServerURI() + ":" + connectionData.getServerport());
			// create a Thread to connect via socket
			Socket socket = new Socket(connectionData.getServerURI(), Integer.parseInt(connectionData.getServerport()));
			
			//add shutdown hook
			ServiceShutdown shutdown = new ServiceShutdown(socket, connectionData.getServiceName(), connectionData.getServiceOffered());
			Thread shutdownHook = new Thread(shutdown);
			Runtime.getRuntime().addShutdownHook(shutdownHook);
			// create the register packet
			ProtocolSocketDataObject regdata = new ProtocolSocketDataObject();
			regdata.setHeader(ProtocolJSON.SEMplest_REGISTER);
			regdata.setclientServiceName(connectionData.getServiceName());
			regdata.setServiceOffered(connectionData.getServiceOffered());
			regdata.setPingFrequency(connectionData.getESBPingWaitMS());

			// convert to JSON
			String jsonStr = json.createJSONFromSocketDataObj(regdata);
			byte[] regPacket = ProtocolJSON.createBytePacketFromString(jsonStr);
			logger.debug("Send regPacket " + jsonStr);
			// send the Registration pacjket
			socket.getOutputStream().write(regPacket);
			socket.getOutputStream().flush();
			// wait synchronously for response
			byte[] response = new byte[1024];
			int num = socket.getInputStream().read(response);
			// create ProtocolSocketDataObject from response
			ProtocolSocketDataObject data = json.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(response));
			logger.debug("Response REC - " + data.getclientServiceName() + ":" + data.getServiceOffered() + ": ping Freq=" + data.getPingFrequency() + ": Header=" + data.getheader());
			if (data.getheader() == ProtocolJSON.SEMplest_REGISTER)
			{
				// create a Ping thread
				if (connectionData.getPingFrequencyMS() > 0)
				{
					logger.debug("Start Pinging....with Frequency=" + connectionData.getPingFrequencyMS());
					PingService ping = new PingService(socket, connectionData.getServiceName(),connectionData.getPingFrequencyMS());
					Thread pingThread = new Thread(ping);
					pingThread.setPriority(Thread.MAX_PRIORITY);
					pingThread.start();
				}
				// create a connection to the destination queue
				logger.debug("setting up MQ IP: " + data.getmessageQueueIP() + ":" + data.getmessageQueuePort() + " sendQ=" + data.getServiceSendQueueName() + " RecQ=" +  data.getServiceRecQueueName());
				mq = new ServiceActiveMQConnection(data.getmessageQueueIP(), data.getmessageQueuePort());
				mq.createProducer(data.getServiceSendQueueName());
				mq.createConsumer(data.getServiceRecQueueName());
				
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
	*/

}
