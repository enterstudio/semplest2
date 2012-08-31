package semplest.keywords.memorysegm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class MultiThreadTest implements Runnable
{

	private static final Logger logger = Logger.getLogger(MultiThreadTest.class);
	CatSplitter splitter;
	int threadCount;

	MultiThreadTest(String catSplitterpath, int threadCount) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		this.splitter = CatSplitter.loadSerializedCatSplitter(catSplitterpath);
		this.threadCount = threadCount;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				long delay = (long) (Math.random() * 5000);
				Thread.sleep(delay);
				logger.info("Iterating thread " + threadCount);
				String[] cats = splitter.getAllCats();
				int[] randInd = CatSplitter.randIndexArray(3, cats.length - 100);
				ArrayList<String> categories = new ArrayList<String>();
				for (int i = 0; i < 100; i++)
				{
					categories.add(cats[i + randInd[0]]);
					categories.add(cats[i + randInd[1]]);
					categories.add(cats[i + randInd[2]]);
				}
				splitter.getCatData(categories);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
				logger.error("Problem", e);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
				logger.error("Problem", e);
			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++)
		{
			threads[i] = new Thread(new MultiThreadTest("/home/lluis/Documents/splitTest/arts/arts.spl", i));
			threads[i].start();
		}
	}

}
