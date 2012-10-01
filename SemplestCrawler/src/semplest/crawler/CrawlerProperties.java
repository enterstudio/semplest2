package semplest.crawler;

import java.io.FileInputStream;
import java.util.Properties;

public class CrawlerProperties 
{	
	public static Properties properties;
	
	public static String BerkeleyDbDirectory;
	public static String BerkeleyDbID;
	public static String MasterLogFile;
	public static String WorkerLogFile;
	public static Integer BucketNumber;
	public static Integer BucketSize;
	public static Integer SleepIntervalBetweenUrls;
	public static String AkkaMessageFrameSize;
	public static Integer ResultCollectingInterval;
	public static Integer AskForWorkInterval;
	public static Integer ResultBufferSize;
	
	static
	{
		try
		{	
			String PROPSFILE = "/semplest/Crawler/crawler.properties";
			//String PROPSFILE = "c:\\BerkeleyDB\\crawler.properties";
			properties = new Properties();
			properties.load(new FileInputStream(PROPSFILE));
			
			BerkeleyDbDirectory = properties.getProperty("berkeleyDb.directory");
			BerkeleyDbID = properties.getProperty("berkeleyDb.id");
			MasterLogFile = properties.getProperty("crawler.masterLog");
			WorkerLogFile = properties.getProperty("crawler.workerLog");
			BucketNumber = Integer.valueOf(properties.getProperty("work.bucketNumber"));
			BucketSize = Integer.valueOf(properties.getProperty("work.bucketSize"));
			SleepIntervalBetweenUrls = Integer.valueOf(properties.getProperty("worker.sleepBetweenUrls"));
			AkkaMessageFrameSize = properties.getProperty("akka.messageFrameSize");
			ResultCollectingInterval = Integer.valueOf(properties.getProperty("master.resultCollectingInterval"));
			AskForWorkInterval = Integer.valueOf(properties.getProperty("worker.askForWorkInterval"));
			ResultBufferSize = Integer.valueOf(properties.getProperty("master.resultBufferSize"));
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
