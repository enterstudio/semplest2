package semplest.server.service;

import java.net.Socket;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.ProtocolSocketDataObject;
import semplest.server.service.springjdbc.SemplestDB;

public class ServiceShutdown implements Runnable
{
	private final Socket socket;
	private final String serviceName;
	private final String serviceOffered;
	private ProtocolJSON json = null;
	private static final Logger logger = Logger.getLogger(ServiceShutdown.class);
	
	public ServiceShutdown(Socket socket, String serviceName, String serviceOffered)
	{
		this.socket = socket;
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
			socket.getOutputStream().write(regPacket);
			Thread.sleep(500);
		}
		catch (Exception e)
		{
			logger.error(e);
			e.printStackTrace();
			errorHandler(new Exception("ServiceShutdown: " + e.getMessage(), e));
		}
		
	}
	
	private void errorHandler(Exception e){
		String serviceName = SEMplestService.properties.getProperty("ServiceName");
		SemplestDB db = new SemplestDB();
		db.logError(e, serviceName);
	}

}
