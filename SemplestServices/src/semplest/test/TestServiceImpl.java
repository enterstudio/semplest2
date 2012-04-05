package semplest.test;

import semplest.services.client.interfaces.TestServiceInterface;


public class TestServiceImpl implements TestServiceInterface
{

	@Override
	public String TestMethod(String jsonStr) throws Exception
	{
		
		long start = System.currentTimeMillis();
		for (int i =0; i < 2000; i++) doWork();
		long total =  System.currentTimeMillis() - start;
		if (total > 0) throw new Exception("Error");
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
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

}
