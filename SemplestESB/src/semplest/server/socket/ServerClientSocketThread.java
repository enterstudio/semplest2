package semplest.server.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import semplest.server.ESB.ESBServer;
import semplest.server.ESB.ServiceRegistrationData;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class ServerClientSocketThread implements Runnable
{
	private Socket socket;
	//private ServicePingHandler pingHandler = null;
	private ProtocolJSON json = new ProtocolJSON();
	private DataInputStream in = null;
	private byte[] returnPingData = null;
	private static final Logger logger = Logger.getLogger(ServerClientSocketThread.class);

	public ServerClientSocketThread(Socket socket)
	{
		this.socket = socket;
		try
		{
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			// preset data returned by ping to client
			ProtocolSocketDataObject returndata = new ProtocolSocketDataObject();
			returndata.setHeader(ProtocolJSON.SEMplest_PING);
			String jsonStr = json.createJSONFromSocketDataObj(returndata);
			returnPingData = ProtocolJSON.createBytePacketFromString(jsonStr);
		}
		catch (IOException e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		ByteBuffer readBuffer = ByteBuffer.allocate(8192);

		logger.info("start client thread");
		while (true)
		{

			try
			{
				logger.info("Wait for data....");

				int num = in.read(readBuffer.array());
				if (num > 0)
				{
					logger.info("Read Data..." + num);
					ProtocolSocketDataObject socketDataObject = json
							.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(readBuffer.array()));
					readBuffer.flip();
					byte typeRequest = socketDataObject.getheader();
					try
					{
						if (typeRequest == ProtocolJSON.SEMplest_REGISTER)
						{
							logger.info("Reg");
							RegisterClient(socketDataObject);
						}
						else if (typeRequest == ProtocolJSON.SEMplest_PING)
						{
							logger.info("Ping");
							ClientPing(socketDataObject);
						}
						else if (typeRequest == ProtocolJSON.SEMplest_SHUTDOWN)
						{
							ShutdownFromClient(socketDataObject);
						}
						else
						{
							logger.error("Unknown Request Type..." + typeRequest);
						}
					}
					catch (JsonParseException e)
					{
						logger.error("JsonParseException in ServerClientSocketThread " + e.getMessage());
						e.printStackTrace();
						break;
					}
					catch (JsonMappingException e)
					{
						logger.error("JsonMappingException in ServerClientSocketThread " + e.getMessage());
						e.printStackTrace();
						break;
					}

					catch (JMSException e)
					{
						logger.error("JMSException in ServerClientSocketThread " + e.getMessage());
						e.printStackTrace();
						break;
					}
				}
			}
			catch (IOException e)
			{
				logger.error("IOEXCEPTION in ServerClientSocketThread " + e.getMessage());
				e.printStackTrace();
				return;
			}

		}

	}

	public void RegisterClient(ProtocolSocketDataObject response) throws JsonParseException, JsonMappingException, IOException, JMSException
	{

		// ProtocolSocketDataObject response =
		// json.createSocketDataObjFromJSON(data.toString());
		String clientServiceName = response.getclientServiceName();
		String serviceOffered = response.getServiceOffered();
		int pingFreqMS = response.getPingFrequency();
		logger.debug("Registered Client " + clientServiceName + " service offered=" + serviceOffered + ":" + pingFreqMS );

		ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
		// Make sure not already registered
		if (!serviceRegistrationMap.containsKey(clientServiceName))
		{
			// add Queue to ActiveMQ
			String serviceSendQueueName = clientServiceName + "_Send";
			String serviceRecQueueName = clientServiceName + "_Rec";
			// ESB produces messages on the Serive Rec Queue
			ESBServer.esb.getMQConnection().createProducerAndConsumerQueue(serviceRecQueueName, serviceSendQueueName);
			// ESB Rec messares on the Service send queue
			// this.esbServer.getMQConnection().createConsumer(serviceSendQueueName);
			ServiceRegistrationData regData = new ServiceRegistrationData();
			regData.setMessageProducer(ESBServer.esb.getMQConnection().getMessageProducerByQueue(serviceRecQueueName));
			regData.setESBRecQueueName(serviceSendQueueName);
			regData.setESBSendQueueName(serviceRecQueueName);
			regData.setRegTime(new java.util.Date());
			regData.setServiceOffered(serviceOffered);
			// create thread for handling ping
			ServicePingHandler pingHandler = new ServicePingHandler(clientServiceName, serviceOffered, pingFreqMS);
			regData.setPingHandler(pingHandler);
			Thread pingThread = new Thread(pingHandler);
			pingThread.setPriority(Thread.MAX_PRIORITY);
			pingThread.start();
			serviceRegistrationMap.put(clientServiceName, regData);
			ESBServer.esb.setServiceNameList(serviceOffered, clientServiceName);
			// setup currentServiceIndexMap
			if (!ESBServer.esb.getCurrentServiceIndexMap().containsKey(serviceOffered))
			{
				AtomicInteger currentServiceIndex = new AtomicInteger(0);
				ESBServer.esb.getCurrentServiceIndexMap().put(serviceOffered, currentServiceIndex);
			}
			// send back queue name for client to connect to as new destination
			ProtocolSocketDataObject returndata = new ProtocolSocketDataObject();
			returndata.setHeader(ProtocolJSON.SEMplest_REGISTER);
			returndata.setServiceSendQueueName(serviceSendQueueName);
			returndata.setServiceRecQueueName(serviceRecQueueName);
			returndata.setmessageQueueIP(ESBServer.esb.getServerData().getBrokerIP());
			returndata.setmessageQueuePort(ESBServer.esb.getServerData().getBrokerPort());
			String jsonStr = json.createJSONFromSocketDataObj(returndata);
			byte[] returnData = ProtocolJSON.createBytePacketFromString(jsonStr);
			send(returnData);
			logger.info("Register " + clientServiceName);
		}
		else
		// already registered
		{
			logger.info("Already Registered " + clientServiceName);
		}

	}

	public void ShutdownFromClient(ProtocolSocketDataObject socketDataObject)
	{
		String client = socketDataObject.getclientServiceName();
		logger.debug("Received Shutdown request from " + client);
		ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
		Vector<String> servicesList = ESBServer.esb.getServiceNameList(serviceRegistrationMap.get(client).getServiceOffered());
		if (serviceRegistrationMap.containsKey(client))
		{
			serviceRegistrationMap.remove(client);
			logger.debug(client + "removed in registrationMap size=" + serviceRegistrationMap.size());
			if (servicesList.contains(client))
			{
				servicesList.remove(client);
			}
			logger.debug("Removed: " + client);
		}
		else
		{
			logger.debug(client + "not in registrationMap");
		}
	}

	public void ClientPing(ProtocolSocketDataObject socketDataObject)
	{

		try
		{
			ConcurrentHashMap<String, ServiceRegistrationData> serviceRegistrationMap = ESBServer.esb.getServiceRegistrationMap();
			// Vector<String> servicesList = ESBServer.esb.getServicesList();
			logger.info("PING " + socketDataObject.getclientServiceName() + " serviceRegistrationMap size" + serviceRegistrationMap.size());
			ServiceRegistrationData regData = serviceRegistrationMap.get(socketDataObject.getclientServiceName());
			if (regData == null)
			{
				logger.error("Registration Data for:" + socketDataObject.getclientServiceName() + " is NULL");
			}
			else
			{
				regData.getPingHandler().handleResponse(socketDataObject.getclientServiceName());
				logger.debug("Send response back to Client: " + socketDataObject.getclientServiceName());
				send(returnPingData);
			}
		}
		catch (Exception e)
		{
			logger.error("Error ping " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void send(byte[] returnData) throws IOException
	{
		socket.getOutputStream().write(returnData);
		socket.getOutputStream().flush();

	}

}
