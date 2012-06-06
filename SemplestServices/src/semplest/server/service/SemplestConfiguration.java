package semplest.server.service;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestErrorHandler;

public class SemplestConfiguration implements Runnable
{
	private final Object obj;
	private static final Logger logger = Logger.getLogger(SemplestConfiguration.class);
	private SemplestErrorHandler errorHandler = new SemplestErrorHandler();

	public static HashMap<String, Object> configData = null;
	
	public SemplestConfiguration (Object obj)
	{
		this.obj = obj;
	}
	@Override
	public void run()
	{
		try
		{
			configData = SemplestDB.loadConfigurationData();
			Iterator<String> configIT = configData.keySet().iterator();
			while (configIT.hasNext())
			{
				String key = configIT.next();
				if (configData.get(key) != null)
				{
					logger.info(key + "=" + configData.get(key).toString());
				}
				else
				{
					logger.info(key + "= null");
				}
			}
			
		}
		catch (Exception e)
		{
			logger.error("FAILED TO LOAD CONFIGUATION");
			configData = null;
			e.printStackTrace();
			errorHandler.logToDatabase(new Exception("FAILED TO LOAD CONFIGUATION - " + e.getMessage(), e));
		}
		synchronized(obj)
		{
			obj.notify();
		}
		
	}

}
