package semplest.test;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import semplest.server.service.SemplestConfiguration;
import semplest.service.scheduler.SemplestSchedulerService;
import semplest.services.client.interfaces.TestServiceInterface;


public class TestService2Impl implements TestServiceInterface
{
	private static final Logger logger = Logger.getLogger(TestService2Impl.class);
	
	@Override
	public String TestMethod(String jsonStr)
	{
		
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			logger.error("Problem", e);
		}
		
		long total =  System.currentTimeMillis() - start;
		//interpret the jsoStr for the method
		return "Result from " + jsonStr + " time ms=" + String.valueOf(total);
	}
	private void doWork()
	{
		for (int i=0; i<100000; i++) 
		{
			double x  = 1.0;
			x = Math.pow(x, 2.0);
		}
		
	}
	@Override
	public void initializeService(String input) throws Exception {
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		
	}

}
