package semplest.keywords.crawl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.CrawlFeedback;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class CrawlDataCleanerDriver
{
	public static void main(final String[] args) throws Exception
	{
		new ClassPathXmlApplicationContext("Service.xml");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		
		final List<String> urls = Arrays.asList("http://www.cnn.com", "http://www.bbc.com", "http://www.cnn.com");
		final List<CrawlFeedback> batch = new ArrayList<CrawlFeedback>();
		final String dir = "Z:\\temp\\";
		final String fs3Dir = "\\\\fs3\\Semplest\\temp\\";
		for (final String url : urls)
		{
			final String content = crawlUtils.htmlText(url);
			final String sanitizedUrl = SemplestUtils.sanitizeString(url);
			final String fileName = dir + sanitizedUrl + ".txt"; 
			final String fs3FileName = fs3Dir + sanitizedUrl + ".txt"; 
			storeInFile(content, fileName);
			final String feedback = "Good";
			final CrawlFeedback entry = new CrawlFeedback(url, fs3FileName, feedback);
			batch.add(entry);			
		}
		SemplestDB.storeCrawlFeedbackBatch(batch);
	} 	
	
	public static void storeInFile(final String content, final String fileName) throws IOException
	{
    BufferedWriter writer = null;
    final FileWriter fileWriter = new FileWriter(fileName);
    writer = new BufferedWriter(fileWriter);
    writer.write(content);    
    writer.close();
    fileWriter.close();
	}
}
