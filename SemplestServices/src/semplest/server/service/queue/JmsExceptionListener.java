package semplest.server.service.queue;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

import org.apache.log4j.Logger;

import semplest.server.service.PingService;
import semplest.util.SemplestErrorHandler;

public class JmsExceptionListener implements ExceptionListener
{
	private static final Logger logger = Logger.getLogger(JmsExceptionListener.class);
	private ServiceActiveMQConnection mq = null;

	public void onException(final JMSException e)
	{
		logger.error("Problem", e);
		try
		{
			SemplestErrorHandler.logToDatabase(new Exception("JMSException: " + e.getMessage(), e));
		}
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// trying to reconnect to the ActiveMQ every 5 seconds until successful...Do not give up since service is down without connection
		boolean tryToReconnect = true;
		while (tryToReconnect)
		{
			try
			{
				mq = new ServiceActiveMQConnection(PingService.data_getmessageQueueIP, PingService.data_getmessageQueuePort);
				mq.createProducer(PingService.data_getServiceSendQueueName);
				mq.createConsumer(PingService.data_getServiceRecQueueName);
				tryToReconnect = false;
				logger.info("Service registered Consumer=" + PingService.data_getServiceRecQueueName);
			}
			catch (Exception e1)
			{
				logger.error("Unable to reconnect to ActiveMQ..Wait 5 sec and try again", e1);
				try
				{
					Thread.sleep(5000);
				}
				catch (InterruptedException e2)
				{
					logger.error("Delay error " , e2);
				}
			}
		}
	}

}
