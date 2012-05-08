package semplest.server.service;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import semplest.server.service.springjdbc.SemplestDB;

public class SemplestConfiguration implements Runnable
{
	private static final Logger logger = Logger.getLogger(SemplestConfiguration.class);

	public static HashMap<String, Object> configData = null;
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
			Thread.sleep(0);
		}
		catch (Exception e)
		{
			logger.error("FAILED TO LOAD CONFIGUATION");
			configData = null;
			e.printStackTrace();
		}
		
	}

}
