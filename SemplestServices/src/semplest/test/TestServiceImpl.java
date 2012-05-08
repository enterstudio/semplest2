package semplest.test;

import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.TestServiceInterface;


public class TestServiceImpl implements TestServiceInterface
{

	@Override
	public String TestMethod(String jsonStr)
	{
		
		long start = System.currentTimeMillis();
		for (int i =0; i < 2000; i++) doWork();
		long total =  System.currentTimeMillis() - start;
		//interpret the jsoStr for the method
		return "Result from " + jsonStr + " time ms=" + String.valueOf(total);
	}
	private void doWork()
	{
		for (int i=0; i<10000; i++)
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
		SemplestConfiguration configDB = new SemplestConfiguration();
		Thread configThread = new Thread(configDB);
		configThread.start();
		
	}


}
