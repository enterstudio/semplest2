package semplest.server.service;

import java.net.Socket;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;
import semplest.server.service.queue.ServiceActiveMQConnection;
import semplest.util.SemplestErrorHandler;

public class PingService implements Runnable
{
	private Socket pingSocket;
	private ESBConnectionData connectionData = null;
	private final int frequencyMS;
	private final String serviceName;
	private ServiceActiveMQConnection mq = null;
	ProtocolSocketDataObject pingData = null;
	private ProtocolJSON json = new ProtocolJSON();
	private ServiceShutdown shutdown = null;
	//static final Logger logger = Logger.getLogger(PingService.class);
	static final Logger logger = Logger.getLogger("PingLogger");
	
	/*
	 * parameters for reconnecting to the ActiveMQ on TCP failure
	 */
	public static String data_getmessageQueueIP;
	public static String data_getmessageQueuePort;
	public static String data_getServiceSendQueueName;
	public static String data_getServiceRecQueueName;

	//
	public static void main(String[] args)
	{

	}

	public PingService(ESBConnectionData connectionData)
	{
		this.connectionData = connectionData;
		this.frequencyMS = connectionData.getPingFrequencyMS();
		this.serviceName = connectionData.getServiceName();
		//
		pingData = new ProtocolSocketDataObject();
		pingData.setHeader(ProtocolJSON.SEMplest_PING);
		pingData.setclientServiceName(serviceName);

	}

	@Override
	public void run()
	{
		try
		{
			// Registration loop
			while (true)
			{
				if (registerServiceWithESB())
				{
					byte[] bytes = new byte[500]; // 178 bytes coming back in
													// response
					String jsonStr = json.createJSONFromSocketDataObj(pingData);
					byte[] returnData = ProtocolJSON.createBytePacketFromString(jsonStr);
					// Starting pinging until there is an error
					int retry = 0;
					while (true)
					{
						try
						{
							if (retry < 3)
							{
								logger.debug("Send Ping");
								pingSocket.getOutputStream().write(returnData);
								pingSocket.getOutputStream().flush();
								// wait for return data
								int numBytes = pingSocket.getInputStream().read(bytes);
								if (numBytes <= 0 || pingSocket == null || pingSocket.isClosed() || !pingSocket.isConnected())
								{
									throw new Exception("No Longer Connected...");
								}
								logger.debug("Read bytes pingSocket = " + numBytes + ":" + bytes.toString());
								Thread.sleep(frequencyMS);
							}
							else
							{
								pingSocket = null;
								logger.error("Unable to PIng the ESB Server...it may be down?  Will try to register again in 5 seconds");
								Thread.sleep(5000);
								break;
							}
						}
						catch (Exception e)
						{
							retry++;
							logger.info("Ping Service failed for " + this.serviceName + " will try again....in 5 seconds " + retry + ":" + e.getMessage());
							Thread.sleep(5000);
							connectSocket();
							logger.error("Problem", e);
						}
					}

				}
				else
				{
					logger.error("Unable to register...will try again in 10 seconds");
					Thread.sleep(10000);
				}
			}
		}
		catch (Exception e)
		{
			logger.error("Unexpected Error in Ping Service...Terminating");
			SemplestErrorHandler.logToDatabase(new Exception("Unexpected Error in Ping Service...Waiting 10 sec and try to register again - " + e.getMessage(), e));
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e1)
			{
				logger.error(e1.getMessage(), e1);
			}
		}
	}
	
	private boolean connectSocket()
	{
		if (pingSocket == null || pingSocket.isClosed() || !pingSocket.isConnected())
		{
			try
			{
				pingSocket = new Socket(connectionData.getServerURI(), Integer.parseInt(connectionData.getServerport()));
				pingSocket.setSoTimeout(2*frequencyMS); //set timeout

				return true;
			}
			catch (Exception e)
			{
				logger.error("Error connecting socket " + e.getMessage(), e);
				SemplestErrorHandler.logToDatabase(new Exception("Error connecting socket - " + e.getMessage(), e));
				return false;
			}
			
		}
		else if (pingSocket != null && pingSocket.isConnected())
		{
			return true;
		}
		else
		{
			logger.error("Socket not connected...");
			SemplestErrorHandler.logToDatabase(new Exception("Socket not connected"));
			return false;		
		}
	}

	private boolean registerServiceWithESB()
	{

		try
		{
			logger.debug("Reg with ESB " + connectionData.getServerURI() + ":" + connectionData.getServerport());
			// create a Thread to connect via socket
			if (!connectSocket())
			{
				return false;
			}

			// add shutdown hook
			if (shutdown == null)
			{
				shutdown = new ServiceShutdown(pingSocket, connectionData.getServiceName(), connectionData.getServiceOffered());
				Thread shutdownHook = new Thread(shutdown);
				Runtime.getRuntime().addShutdownHook(shutdownHook);
			}
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
			pingSocket.getOutputStream().write(regPacket);
			pingSocket.getOutputStream().flush();
			// wait synchronously for response
			byte[] response = new byte[8192];
			int num = pingSocket.getInputStream().read(response); //Throws Timeout exception
			// create ProtocolSocketDataObject from response
			ProtocolSocketDataObject data = json.createSocketDataObjFromJSON(ProtocolJSON.convertbytesToString(response));
			logger.debug("Response REC - " + data.getclientServiceName() + ":" + data.getServiceOffered() + ": ping Freq=" + data.getPingFrequency()
					+ ": Header=" + data.getheader());
			if (data.getheader() == ProtocolJSON.SEMplest_REGISTER)
			{
				// create a connection to the destination queue
				logger.debug("setting up MQ IP: " + data.getmessageQueueIP() + ":" + data.getmessageQueuePort() + " sendQ="
						+ data.getServiceSendQueueName() + " RecQ=" + data.getServiceRecQueueName());
				//handle the reconnect
				if (mq != null)
				{
					logger.info("Closing out the MQ connection");
					mq.closeMQ();
					mq = null;
				}
				//Save for reconnect
				data_getmessageQueueIP = data.getmessageQueueIP();
				data_getmessageQueuePort = data.getmessageQueuePort();
				data_getServiceSendQueueName = data.getServiceSendQueueName();
				data_getServiceRecQueueName = data.getServiceRecQueueName();
				//connect
				mq = new ServiceActiveMQConnection(data.getmessageQueueIP(), data.getmessageQueuePort());
				mq.createProducer(data.getServiceSendQueueName());
				mq.createConsumer(data.getServiceRecQueueName());

				logger.info("Service registered " + data.getServiceSendQueueName());
			}
			else if (data.getheader() == ProtocolJSON.SEMplest_ERROR)
			{
				logger.error("ERROR Returned from ESB " + data.getError());
				SemplestErrorHandler.logToDatabase(new Exception("ERROR Returned from ESB " + data.getError()));
				return false;
			}
			else
			{
				logger.error("ERROR - The Data Header rec from ESB was not SEMplest REGISTER");
				SemplestErrorHandler.logToDatabase(new Exception("ERROR - The Data Header rec from ESB was not SEMplest REGISTER"));
				return false;
			}
			logger.debug("Done with Reg to ESB");
			return true;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			SemplestErrorHandler.logToDatabase(new Exception("registerServiceWithESB - " + e.getMessage(), e));
			return false;
		}
	}

}
