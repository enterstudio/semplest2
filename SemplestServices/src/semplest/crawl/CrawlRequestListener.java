package semplest.crawl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.keyword.Domain;
import semplest.server.keyword.UrlData;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class CrawlRequestListener implements ExceptionListener, Runnable
{
	private static final Logger log = Logger.getLogger(CrawlRequestListener.class);
	
	private static final Map<String, Exception> BAD_URL_VS_EXCEPTION_MAP = new HashMap<String, Exception>();
	
	private static int NUM_URLS_PROCESSED = 0;
	
	public static void main(final String[] args)
	{		
		try
		{
			PropertyConfigurator.configure("properties/log4j_server.properties");
			BasicConfigurator.configure();	
			for (int i = 0; i < 400; ++i)
			{
				final Thread thread = new Thread(new CrawlRequestListener());
				thread.start();
			}
		}
		catch (Exception e)
		{
			log.error("Problem runnign CrawlRequestListener");
			System.exit(-1);
		}
	}
	
	public CrawlRequestListener() throws InterruptedException
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
	}
		
	public synchronized void onException(JMSException e) 
	{
		log.error("JMS Exception occured.  Shutting down client.", e);
		System.exit(1);
	}
	
	public static void process(final List<Domain> domains) throws Exception 
	{
		for (final Domain domainData : domains)
		{
			final String domain = domainData.getDomain();
			final List<UrlData> urlDatas = domainData.getUrlDatas();
			if (urlDatas == null || urlDatas.isEmpty())
			{
				log.info("No URL Datas for domain [" + domain + "], so will not crawl");	
			}
			else
			{
				for (final UrlData urlData : urlDatas)
				{
					final String url = urlData.getUrl();
					if (url == null || url.trim().isEmpty() || !url.trim().startsWith("http"))
					{
						log.info("URL [" + url + "] is not viable for crawl because it doesn't start with 'http' nor 'https'");
					}
					final String crawlContent = getCrawlContent(url);
					if (crawlContent == null || crawlContent.trim().isEmpty())
					{
						log.info("No content found in URL [" + url + "]");
					}
					else
					{
						final int urlDataPk = urlData.getPk();
						try
						{						
							SemplestDB.saveCrawlContent(urlDataPk, crawlContent);
						}
						catch (Exception e)
						{
							final String errMsg = "Problem crawling UrlData [" + urlData + "]";
							log.error(errMsg, e);
							throw new Exception(errMsg, e);
						}
					}
				}
			}
		}
	}
	
	public static String getCrawlContent(final String url)
	{
		log.info("Will try to crawl URL [" + url + "]");		
		try
		{			
			final Document doc = Jsoup.connect(url).followRedirects(true).timeout(20 * SemplestUtils.SECOND).get();
			final String docContent = doc.toString();
			++NUM_URLS_PROCESSED;
			return docContent;
		}
		catch (IOException e)
		{
			log.error("Problem getting crawl content for URL [" + url + "]", e);
			++NUM_URLS_PROCESSED;
			BAD_URL_VS_EXCEPTION_MAP.put(url, e);
			if (BAD_URL_VS_EXCEPTION_MAP.size() % 50 == 0)
			{
				log.info("So far processed " + NUM_URLS_PROCESSED + " URLs, of which " + BAD_URL_VS_EXCEPTION_MAP.size() + " are bad");
			}
			return "";
		}
	}
		
	@Override
	public void run() 
	{
		Session session = null;  	
  	MessageConsumer consumer = null;
  	Connection connection = null;
    try 
    {
    	final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
    	connection = connectionFactory.createConnection();
    	connection.start();
    	connection.setExceptionListener(this);
    	session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    	final Destination destination = session.createQueue("CrawlRequest");
    	consumer = session.createConsumer(destination);
    	while (true)
    	{    		
				final Message message = consumer.receive();
			  if (message instanceof ObjectMessage) 
				{
					final ObjectMessage objectMessage = (ObjectMessage) message;
					try 
					{
						final List<Domain> domains = (List<Domain>) objectMessage.getObject();
						process(domains);
					} 
					catch (JMSException e) 
					{
						final String errMsg = "Problem extracting List<Domain> from this JMS ObjectMessage [" + message + "]";
						log.error(errMsg, e); 
					}
				} 
				else  
				{
					log.error("Problem extracting List<Domain> from this JMS ObjectMessage [" + message + "] becauae it's not of type ObjectMessage");
				}
    	}      
    }     
    catch (Exception e) 
    {
    	log.error("Problem trying to run message consumer", e);
    }
    finally
    {
    	if (consumer != null)
    	{
    		try
				{
					consumer.close();
				}
				catch (JMSException e)
				{
					log.error("Problem closing JMS Consumer.  Logging but otherwise ignoring.");
				}
    	}
    	if (session != null)
    	{
    		try
				{
					session.close();
				}
				catch (JMSException e)
				{
					log.error("Problem closing JMS Session.  Logging but otherwise ignoring.");
				}
    	}
    	if (connection != null)
    	{
    		try
				{
					connection.close();
				}
				catch (JMSException e)
				{
					log.error("Problem closing JMS Connection.  Logging but otherwise ignoring.");
				}
    	}
    }
	}
	
}
