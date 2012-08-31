package semplest.test.other;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import semplest.test.scalability.KeywordTestThread;

public class SCtest
{

	public static void main(String args[])
	{

		try
		{
			System.out.println("Start Time: " + new Date());
			System.out.println(" ");

			// Start to Test
			ExecutorService executor = Executors.newCachedThreadPool();

			// Test Service

			int sleepSecs = 30;
			String url;

			url = "http://VMDEVJAVA1:9898/semplest";
			executor.execute(new KeywordTestPerServerThread(sleepSecs, url));

			url = "http://VMJAVA1:9898/semplest";
			executor.execute(new KeywordTestPerServerThread(sleepSecs, url));

			url = "http://NY-semplestDev2:9898/semplest";
			executor.execute(new KeywordTestPerServerThread(sleepSecs, url));

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
