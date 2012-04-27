package semplest.server.service;

import java.io.IOException;

import org.apache.log4j.Logger;

import semplest.client.nio.NIOClient;
import semplest.client.nio.NIOResponseHandler;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class PingService implements Runnable
{
	private final int frequencyMS;
	private final NIOClient nio;
	private final NIOResponseHandler handler;
	private final String serviceName;
	ProtocolSocketDataObject pingData = null;
	private ProtocolJSON json = new ProtocolJSON();
	static final Logger logger = Logger.getLogger(PingService.class);
	
	public PingService(NIOClient nio, NIOResponseHandler handler, String serviceName, int frequencyMS)
	{
		this.frequencyMS = frequencyMS;
		this.nio = nio;
		this.handler = handler;
		this.serviceName = serviceName;
		
		pingData = new ProtocolSocketDataObject();
		pingData.setHeader(ProtocolJSON.SEMplest_PING);
		pingData.setclientServiceName(serviceName);
		
	}
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				logger.debug("Send Ping");
				String jsonStr = json.createJSONFromSocketDataObj(pingData);
				byte[] returnData =ProtocolJSON.createBytePacketFromString(jsonStr);
				nio.send(returnData, handler);
				byte[] response = handler.waitForResponse();
				Thread.sleep(frequencyMS);
			}
		}
		catch (InterruptedException e)
		{
			logger.info("Ping Service failed for " + this.serviceName);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
