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
	
	static
	{
		try
		{	
			//String PROPSFILE = "/semplest/Crawler/crawler.properties";
			String PROPSFILE = "c:\\BerkeleyDB\\crawler.properties";
			properties = new Properties();
			properties.load(new FileInputStream(PROPSFILE));
			
			BerkeleyDbDirectory = properties.getProperty("berkeleyDb.directory");
			BerkeleyDbID = properties.getProperty("berkeleyDb.id");
			MasterLogFile = properties.getProperty("crawler.masterLog");
			WorkerLogFile = properties.getProperty("crawler.workerLog");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
