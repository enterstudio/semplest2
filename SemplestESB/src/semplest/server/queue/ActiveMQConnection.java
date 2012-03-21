package semplest.server.queue;

import java.util.HashMap;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.jms.connection.CachingConnectionFactory;

public class ActiveMQConnection
{
	private QueueConnection cn = null;
	private QueueSession session = null;
	private Destination producerDestination = null;
	private MessageConsumer consumer = null;


	private ActiveMQConnectionFactory cf = null;
	private CachingConnectionFactory cacheCF = null;
	// private MessageProducer producer = null;
	// private MessageConsumer consumer = null;

	private HashMap<String, MessageProducer> producerListByQueue = new HashMap<String, MessageProducer>();
	private HashMap<String, Queue> consumerQueueListByQueueName = new HashMap<String, Queue>();
	
	static final Logger logger = Logger.getLogger(ActiveMQConnection.class);

	public ActiveMQConnection(String host, String port) throws JMSException
	{
		// Context ctx = new InitialContext();
		cf = new ActiveMQConnectionFactory("tcp://" + host + ":" + port);
		
		cacheCF = new CachingConnectionFactory();
		cacheCF.setTargetConnectionFactory(cf);
		cacheCF.setSessionCacheSize(100);
		cacheCF.setExceptionListener(new JmsExceptionListener());

		// + "?wireFormat=openwire&wireFormat.tightEncodingEnabled=true");
		cn = cacheCF.createQueueConnection();
		cn.start();
		session = cn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public void createProducerAndConsumerQueue(String queueName, String consumerQueue) throws JMSException
	{
		producerDestination = session.createQueue(queueName);
		MessageProducer producer = session.createProducer(producerDestination);
		producerListByQueue.put(queueName, producer);
		createConsumer(consumerQueue);
	}

	public void sendMessage(String queueName, String methodName, byte[] byteData, String correlationID) throws JMSException
	{
		MessageProducer producer = null;
		if ((producer = getMessageProducerByQueue(queueName)) != null)
		{
			BytesMessage mess = session.createBytesMessage();
			mess.writeBytes(byteData);
			if (correlationID != null)
			{
				mess.setJMSCorrelationID(correlationID);
			}
			if (methodName != null)
			{
				mess.setStringProperty("method", methodName);
			}
			producer.send(mess);
		}
		else
		{
			throw new JMSException("The queue " + queueName + " does not have a JMS producer"); 
		}
	}

	
	public void createConsumer(String queueName) throws JMSException
	{
		Destination consumerDestination = session.createQueue(queueName);
		consumer = session.createConsumer(consumerDestination);
		consumer.setMessageListener(new QueueListener());
		//consumerListByQueue.put(queueName, consumer);
	}
	

	public QueueReceiver createConsumerForReturnMessage(String queueName, String uniqueID) throws JMSException
	{
		
		return session.createReceiver(consumerQueueListByQueueName.get(queueName), "JMSCorrelationID='" + uniqueID + "'");
	}

	public MessageProducer getMessageProducerByQueue(String queueName)
	{
		if (producerListByQueue.containsKey(queueName))
		{
			return producerListByQueue.get(queueName);
		}
		else
		{
			return null;
		}
	}
}
