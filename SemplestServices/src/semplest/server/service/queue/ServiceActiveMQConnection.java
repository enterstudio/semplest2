package semplest.server.service.queue;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.jms.connection.CachingConnectionFactory;

public class ServiceActiveMQConnection
{
	private QueueConnection cn = null;
	private QueueSession session = null;
	private Destination producerDestination = null;
	private Destination consumerDestination = null;

	private ActiveMQConnectionFactory cf = null;
	private CachingConnectionFactory cacheCF = null;
	private MessageProducer producer = null;
	private MessageConsumer consumer = null;
	private String producerQueueName = null;
	
	static final Logger logger = Logger.getLogger(ServiceActiveMQConnection.class); 


	/*
	 * creates a connection and session for the service
	 */
	public ServiceActiveMQConnection(String host, String port) throws JMSException
	{
		//Context ctx = new InitialContext();
		cf = new ActiveMQConnectionFactory("tcp://" + host + ":" + port);
		cacheCF = new CachingConnectionFactory();
		cacheCF.setTargetConnectionFactory(cf);
		cacheCF.setSessionCacheSize(1);
		cacheCF.setExceptionListener(new JmsExceptionListener());

		// + "?wireFormat=openwire&wireFormat.tightEncodingEnabled=true");
		cn = cacheCF.createQueueConnection();
		cn.start();
		session = cn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	}
	/*
	 * producer used to return result to the client
	 */
	public void createProducer(String queueName) throws JMSException
	{
		producerDestination = session.createQueue(queueName);
		producer = session.createProducer(producerDestination);
		producerQueueName = queueName;
	}
	/*
	 * JSON message sent as byte[]
	 */
	public void sendMessage(byte[] byteData, String correlationID) throws JMSException
	{
		BytesMessage mess = session.createBytesMessage();
		mess.writeBytes(byteData);
		if (correlationID != null)
		{
			mess.setJMSCorrelationID(correlationID);
			logger.debug("Service sends mess " + correlationID + " on queue " + producerQueueName);
		}
		producer.send(mess);
	}
	/*
	 * Service consumer is async with service messages passed to the ServiceQueueLister
	 */
	public void createConsumer(String queueName) throws JMSException
	{
		consumerDestination = session.createQueue(queueName);
		consumer = session.createConsumer(consumerDestination);
		consumer.setMessageListener(new ServiceQueueListener(this));
		logger.debug("Service sets consumr queue " + queueName);
	}
	
	public void closeMQ()
	{
		try
		{
			if (producer != null)
			{
				producer.close();
				producer = null;
				
			}
			if (consumer != null)
			{
				consumer.close();
				consumer = null;
			}
			if (session != null)
			{
				session.close();
				session = null;
			}
			if (cn != null)
			{
				cn.close();
				cn = null;
			}
			if (cacheCF != null)
			{
				cacheCF.destroy();
			}
			
		}
		catch (JMSException e)
		{
			logger.error("Error closing MQProducer:" + e.getMessage(), e);
		}
	}
	
}
