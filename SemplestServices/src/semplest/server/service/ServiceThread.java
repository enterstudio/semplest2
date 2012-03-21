package semplest.server.service;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.service.queue.ServiceActiveMQConnection;

import com.google.gson.Gson;

public class ServiceThread implements Runnable
{

	private final String methodName;
	private final String jsonStr;
	private final String uniqueID;
	private final SemplestServiceTemplate myService;
	private final ServiceActiveMQConnection cn;
	private static final Logger logger = Logger.getLogger(ServiceThread.class);
	

	
	public ServiceThread(ServiceActiveMQConnection cn,SemplestServiceTemplate myService,String methodName,String jsonStr, String uniqueID)
	{
		this.cn = cn;
		this.myService = myService;
		this.methodName = methodName;
		this.jsonStr = jsonStr;
		this.uniqueID = uniqueID;
	}
	@Override
	public void run()
	{
		try
		{
			String result = myService.getService().ServiceGet(methodName, jsonStr);
			
			if (result == null)
			{
				result = "Error";
			}
			logger.debug("result = " + result + " ByteMessage Type=" + methodName + ":" + uniqueID);
			//put Json result back onto Queue
			cn.sendMessage(ProtocolJSON.createBytePacketFromString(result), uniqueID);
		}
		catch (Exception e)
		{
			logger.error("Error running Service: " + methodName + ":" + jsonStr);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
