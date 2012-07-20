package semplest.server.service;

import java.util.HashMap;

import javax.jms.JMSException;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.service.queue.ServiceActiveMQConnection;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestErrorHandler;

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
		try
		{
			String result = null;
			try
			{
				logger.debug("Run Service [" +  methodName + "], Unique ID [" + uniqueID + "], JSON [" + jsonStr + "]");
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
				SemplestErrorHandler.logToDatabase(new Exception("Error running Service: " + methodName + ":" + jsonStr + " - " + e.getMessage(), e));
			}
			//put result on message queue
			try
			{
				cn.sendMessage(ProtocolJSON.createBytePacketFromString(result), uniqueID);
			}
			catch (JMSException e)
			{
				logger.error("maessage queue connection error" + e.getMessage(), e);
				SemplestErrorHandler.logToDatabase(new Exception("maessage queue connection error - " + e.getMessage(), e));
			}
		}
		catch (Exception e)
		{
			final String errMsg = "Problem while running Service Thread";
			logger.error(errMsg);
			throw new RuntimeException(errMsg, e);
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
