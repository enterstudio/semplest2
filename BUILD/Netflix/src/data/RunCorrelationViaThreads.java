package data;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class RunCorrelationViaThreads
{

	private NetflixData data = null;
	private Thread[] threads = null;
	
	private static int numberThreads = 4;
	
	

	public RunCorrelationViaThreads(NetflixData data)
	{
		this.data = data;
		threads = new Thread[numberThreads];
	}

	public HashMap<Integer, HashMap<Integer, Double>> runCorrelation()
	{
		HashMap<Integer, HashMap<Integer, Double>> corr = new HashMap<Integer, HashMap<Integer, Double>>();
		int batch = data.getMovieIDList().size() / numberThreads;
		CountDownLatch signal = new CountDownLatch(numberThreads);
		
		int start = 0;
		int end = start + batch;
		for (int i = 0; i < numberThreads; i++)
		{
			//calc index for each thread
			threads[i] = new Thread(new CorrelationThread(data, corr,start,end, signal), "thread" + i);
			start = end + 1;
			end = end + batch;
			if (end >  data.getMovieIDList().size())
			{
				end =  data.getMovieIDList().size();
			}
		}
		for (int i = 0; i < numberThreads; i++)
		{
			threads[i].start();
		}
		try
		{
			signal.await();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return corr;
	}

}
