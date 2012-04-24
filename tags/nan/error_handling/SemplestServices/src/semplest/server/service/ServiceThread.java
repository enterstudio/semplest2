package semplest.server.service;

import java.util.HashMap;

import javax.jms.JMSException;

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
	private static Gson gson = new Gson();
	

	
	public ServiceThread(ServiceActiveMQConnection cn,SemplestServiceTemplate myService,String methodName,String jsonStr, String uniqueID)
	{
		this.cn = cn;
		this.myService = myService;
		this.methodName = methodName;
		this.jsonStr = jsonStr;
		this.uniqueID = uniqueID;
		logger.debug(uniqueID + "Starting thread to execute: " + methodName + ":" + jsonStr);
	}
	@Override
	public void run()
	{
		String result = null;
		try
		{
			logger.debug("Run Service" +  methodName + ":" + uniqueID);
			result = myService.getService().ServiceGet(methodName, jsonStr);
			
			if (result == null)
			{
				result = getErrorInJson(result, null);
			}
			else
			{
				//send back result in hashmap
				HashMap<String, String> res = new HashMap<String, String>();
				res.put("result",result);
				result = gson.toJson(res);
			}
			logger.debug("result = " + result + " ByteMessage Type=" + methodName + ":" + uniqueID);
			//put Json result back onto Queue
			
		}
		
		catch (Exception e)
		{
			result = getErrorInJson("", e);
			logger.error("Error running Service: " + methodName + ":" + jsonStr);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//put result on message queue
		try
		{
			cn.sendMessage(ProtocolJSON.createBytePacketFromString(result), uniqueID);
		}
		catch (JMSException e)
		{
			logger.error("maessage queue connection error" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getErrorInJson(String result, Exception e)
	{
		HashMap<String, String> errorMap = new HashMap<String, String>();
		if (result == null)
		{
			errorMap.put("errorMessage", "Null Result");
			errorMap.put("errorType", "Null");
		}
		else
		{
			errorMap.put("errorMessage", e.getCause().getMessage());
			errorMap.put("errorType", "Exception");
		}
		
		errorMap.put("errorID", uniqueID);
		return gson.toJson(errorMap);
	}

}
