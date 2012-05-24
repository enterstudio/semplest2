package SocketServer;

import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class PingService implements Runnable
{
	private final int frequencyMS;
	private final String serviceName;
	private final String ESBServer;
	private final int ESBPort;
	ProtocolSocketDataObject pingData = null;
	private ProtocolJSON json = new ProtocolJSON();
	static final Logger logger = Logger.getLogger(PingService.class);
	
	//
	Socket pingSocket = null;
	
	public PingService(Socket socket,String ESBServer, int ESBPort, String serviceName, int frequencyMS)
	{
		this.frequencyMS = frequencyMS;
		this.serviceName = serviceName;
		this.ESBServer = ESBServer;
		this.ESBPort = ESBPort;
		
		pingData = new ProtocolSocketDataObject();
		pingData.setHeader(ProtocolJSON.SEMplest_PING);
		pingData.setclientServiceName(serviceName);
		
	}
	@Override
	public void run()
	{
		try
		{
			pingSocket = new Socket(ESBServer, ESBPort);
			byte[] bytes = new byte[200]; //178 bytes coming back in response
			String jsonStr = json.createJSONFromSocketDataObj(pingData);
			logger.info("JSON for ping: " + jsonStr);
			byte[] returnData = ProtocolJSON.createBytePacketFromString(jsonStr);
			while (true)
			{
				logger.info("Send Ping");
				pingSocket.getOutputStream().flush();
				pingSocket.getOutputStream().write(returnData);
				//Thread.sleep(500);
				pingSocket.getOutputStream().flush();
				//wait for return data
				int numBytes = pingSocket.getInputStream().read(bytes);
				logger.info("Read bytes ServerSocket = " + numBytes + ":" + bytes.toString());
				Thread.sleep(frequencyMS);
			}
		}
		catch (InterruptedException e)
		{
			logger.info("Ping Service failed for " + this.serviceName);
			e.printStackTrace();
		}
		catch (IOException e)
		{
			logger.info("Ping Service failed for " + this.serviceName);
			e.printStackTrace();
		}
		
	}

}
