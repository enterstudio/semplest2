package semplest.server.service;

import java.io.FileInputStream;
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

public class SEMplestService
{
	private Properties properties = null;
	private ESBConnectionData connectionData = null;
	private NIOClient nioClient = null;
	private NIOResponseHandler handler = null;
	private ServiceActiveMQConnection mq = null;
	private ProtocolJSON json = new ProtocolJSON();
	static final Logger logger = Logger.getLogger(SEMplestService.class);

	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	public static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
	public static ExecutorService executor = null;

	private ServiceInterface service;

	

	/**
	 * @param args
	 */
	public static void main(String[] args)
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
			executor = Executors.newFixedThreadPool(service.connectionData.getNumberServiceThreads());
			if (service.registerServiceWithESB())
			{
				logger.info("Registered Service");
			}
		}
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
			// create a Thread to connect via socket
			nioClient = new NIOClient(connectionData.getServerURI(), connectionData.getServerport());
			Thread t = new Thread(nioClient);
			t.setDaemon(true);
			t.start();
			handler = new NIOResponseHandler();
			// create the register packet
			ProtocolSocketDataObject regdata = new ProtocolSocketDataObject();
			regdata.setHeader(ProtocolJSON.SEMplest_REGISTER);
			regdata.setclientServiceName(connectionData.getServiceName());
			regdata.setServiceOffered(connectionData.getServiceOffered());
			regdata.setPingFrequency(connectionData.getPingFrequencyMS());

			// convert to JSON
			String jsonStr = json.createJSONFromSocketDataObj(regdata);
			byte[] regPacket = ProtocolJSON.createBytePacketFromString(jsonStr);
			// send the Registration pacjket
			nioClient.send(regPacket, handler);
			// wait synchronously for response
			byte[] response = handler.waitForResponse();
			// create ProtocolSocketDataObject from response
			ProtocolSocketDataObject data = json.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(response));
			if (data.getheader() == ProtocolJSON.SEMplest_REGISTER)
			{
				// create a connection to the destination queue
				mq = new ServiceActiveMQConnection(data.getmessageQueueIP(), data.getmessageQueuePort());
				mq.createProducer(data.getServiceSendQueueName());
				mq.createConsumer(data.getServiceRecQueueName());
				// create a MQ message
				/*
				 * ProtocolMQDataObject mqData = new ProtocolMQDataObject();
				 * mqData.setTypeOP(ProtocolJSON.SEMplest_ACK); jsonStr =
				 * json.createJSONFromMQDataObj(mqData);
				 * mq.sendMessage(ProtocolJSON
				 * .createBytePacketFromString(jsonStr), null);
				 */
				logger.info("Server registered " + data.getServiceSendQueueName());
				// create a Pi thread
				if (connectionData.getPingFrequencyMS() > 0)
				{
					PingService ping = new PingService(nioClient, new NIOResponseHandler(), connectionData.getServiceName(),
							connectionData.getPingFrequencyMS());
					Thread pingThread = new Thread(ping);
					pingThread.setPriority(Thread.MAX_PRIORITY);
					pingThread.start();
				}

			}
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
