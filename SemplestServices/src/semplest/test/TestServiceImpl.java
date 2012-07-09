package semplest.test;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.TestServiceInterface;


public class TestServiceImpl implements TestServiceInterface
{
	private static final Logger logger = Logger.getLogger(TestServiceImpl.class);
	
	@Override
	public String TestMethod(String jsonStr)
	{
		
		long start = System.currentTimeMillis();
		//for (int i =0; i < 2000; i++) doWork();		
		// nan's test
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
		
	@Override
	public String checkStatus(String input) throws Exception {
		return ServiceStatus.Good.getServiceStatusValue();
	}
}
