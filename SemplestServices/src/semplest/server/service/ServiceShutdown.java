package semplest.server.service;

import java.io.IOException;

import org.apache.log4j.Logger;

import semplest.client.nio.NIOClient;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;

public class ServiceShutdown implements Runnable
{

	private final NIOClient nio;
	private final String serviceName;
	private final String serviceOffered;
	private ProtocolJSON json = null;
	private static final Logger logger = Logger.getLogger(ServiceShutdown.class);
	
	public ServiceShutdown(NIOClient nio, String serviceName, String serviceOffered)
	{
		this.nio = nio;
		this.serviceName = serviceName;
		this.serviceOffered = serviceOffered;
		json = new ProtocolJSON();
		//logger.info("STARTING Shutting down service....");
	}
	@Override
	public void run()
	{
		try
		{
			logger.info("Shutting down service....");
			ProtocolSocketDataObject regdata = new ProtocolSocketDataObject();
			regdata.setHeader(ProtocolJSON.SEMplest_SHUTDOWN);
			regdata.setclientServiceName(serviceName);
			regdata.setServiceOffered(serviceOffered);
			String jsonStr = json.createJSONFromSocketDataObj(regdata);
			byte[] regPacket = ProtocolJSON.createBytePacketFromString(jsonStr);
			nio.send(regPacket, null);
			Thread.sleep(500);
		}
		catch (Exception e)
		{
			logger.error(e);
			e.printStackTrace();
		}
		
	}

}
