package semplest.crawl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.keyword.Domain;
import semplest.server.keyword.UrlData;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class CrawlRequestGenerator
{
	private static final Logger log = Logger.getLogger(CrawlRequestGenerator.class);
	
  private final Connection connection;
  private final Session session;
	
	public CrawlRequestGenerator() throws Exception
	{
		PropertyConfigurator.configure("properties/log4j_server.properties");
		BasicConfigurator.configure();	
		new ClassPathXmlApplicationContext("Service.xml");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
    connection = connectionFactory.createConnection();
    connection.start();
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
  }
	
	public static List<Domain> getDomains() throws Exception
	{
		final long timeBefore = System.currentTimeMillis();
		final List<Domain> domains = SemplestDB.getDomains();
		final long timeAfter = System.currentTimeMillis();
		final long timeDiff = timeAfter - timeBefore;
		final long timeDiffSeconds = timeDiff / SemplestUtils.SECOND;
		log.info("Found " + domains.size() + " domains, which took " + timeDiffSeconds + " seconds");
		return domains;
	}
	
	public static List<UrlData> getUrlDatas() throws Exception
	{
		final long timeBefore = System.currentTimeMillis();
		final List<UrlData> urlDatas = SemplestDB.getUrlDatas();
		final long timeAfter = System.currentTimeMillis();
		final long timeDiff = timeAfter - timeBefore;
		final long timeDiffSeconds = timeDiff / SemplestUtils.SECOND;
		log.info("Found " + urlDatas.size() + " URL Datas, which took " + timeDiffSeconds + " seconds");
		return urlDatas;
	}
	
	public static Map<Integer, List<UrlData>> getDomainIdVsUrlDataMap(final List<UrlData> urlDatas) throws Exception
	{
		final long timeBefore = System.currentTimeMillis();
		final Map<Integer, List<UrlData>> domainIdVsUrlDataMap = new HashMap<Integer, List<UrlData>>();
		for (final UrlData urlData : urlDatas)
		{
			final Integer domainFK = urlData.getDomainFk();
			final List<UrlData> existingUrlDatas = domainIdVsUrlDataMap.get(domainFK);
			if (existingUrlDatas == null)
			{
				final List<UrlData> newUrlDatas = new ArrayList<UrlData>();
				newUrlDatas.add(urlData);
				domainIdVsUrlDataMap.put(domainFK, newUrlDatas);
			}
			else
			{
				existingUrlDatas.add(urlData);
			}
		}		
		final long timeAfter = System.currentTimeMillis();
		final long timeDiff = timeAfter - timeBefore;
		final long timeDiffSeconds = timeDiff / SemplestUtils.SECOND;
		log.info("Generated Map of " + domainIdVsUrlDataMap.size() + " DomainID <-> URL Datas map, which took " + timeDiffSeconds + " seconds");
		return domainIdVsUrlDataMap;
	}
	
	public static void backfillUrlDatas(final List<Domain> domains, final List<UrlData> urlDatas) throws Exception
	{
		final Map<Integer, List<UrlData>> domainIdVsUrlDataMap	= getDomainIdVsUrlDataMap(urlDatas);	
		for (final Domain domain : domains)
		{
			final int domainId = domain.getPk();
			final List<UrlData> urlDatasForId = domainIdVsUrlDataMap.get(domainId);
			if (urlDatasForId != null && !urlDatasForId.isEmpty())
			{
				domain.setUrlDatas(urlDatasForId);
			}
		}
	}
	
	public void engage() throws Exception 
	{ 
		try
		{
			final List<Domain> domains = getDomains();
			final List<UrlData> urlDatas = getUrlDatas();
			backfillUrlDatas(domains, urlDatas);
			final int batchSize = 10;
			final List<List<Domain>> domainBatches = SemplestUtils.getBatches(domains, batchSize);
			log.info("Generated " + domainBatches.size() + " batches Domains, each of at most size " + batchSize);
			int counter = 0;
			for (final List<Domain> domainBatch : domainBatches)
			{
				log.info("Batch #" + ++counter);
				sendBatch(domainBatch);
			}
		}
		finally 
		{
			if (session != null)
			{
				session.close();
			}
			if (connection != null)
			{
				connection.close();
			}
		}
	}
	
	public void sendBatch(final List<Domain> domainBatch) throws Exception
	{
		try 
		{
      final Destination destination = session.createQueue("CrawlRequest");
      final MessageProducer producer = session.createProducer(destination);
      producer.setDeliveryMode(DeliveryMode.PERSISTENT);
      final ObjectMessage message = session.createObjectMessage((Serializable)domainBatch);
      producer.send(message);
	  }
	  catch (Exception e) 
	  {
	      final String errMsg = "Problem sending this batch of domains via JMS [" + domainBatch + "]";
	      log.error(errMsg, e);
	      throw new Exception (errMsg, e);
	  }
	}
	
	public static void main(final String[] args)  
	{
		try
		{			
			final long startTime = System.currentTimeMillis();
			log.info("Start time: " + new Date());
			final CrawlRequestGenerator generator = new CrawlRequestGenerator();
			generator.engage();
			log.info("Finish time: " + new Date());
			final long finishTime = System.currentTimeMillis();
			final long duration = finishTime - startTime;
			final long mins = duration / SemplestUtils.MINUTE;
			log.info("Duration: " + mins + " mins");
		}
		catch (Exception e)
		{			
			final String errMsg = "Problem running CrawlRequestGenerator";
			log.error(errMsg, e);
			System.exit(-1);
		}	
	}
}
