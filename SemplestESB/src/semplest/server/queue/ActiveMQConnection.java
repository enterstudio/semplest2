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
	private HashMap<String, MessageConsumer> consumerListByQueue = new HashMap<String, MessageConsumer>();

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
		logger.debug("Started MQ connection..host = " + host + " port=" + port);
		session = cn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		logger.debug("create MQ session...");
	}

	public void createProducerAndConsumerQueue(String queueName, String consumerQueue) throws JMSException
	{
		// check for reconnect
		boolean createProducer = true;
		boolean createConsumer = true;
		if (producerListByQueue.containsKey(queueName))
		{
			MessageProducer p = producerListByQueue.get(queueName);
			if (p != null && p.getDestination() != null)
			{
				logger.info("MessageProducer already Exists for " + queueName);
				createProducer = false;
			}
		}
		if (createProducer)
		{
			logger.debug("createProducerAndConsumerQueue producer=" + queueName + " consumer=" + consumerQueue);
			producerDestination = session.createQueue(queueName);
			logger.debug("create producer destination");
			MessageProducer producer = session.createProducer(producerDestination);
			producerListByQueue.put(queueName, producer);
			logger.debug("Created and store MessageProducer...");
		}
		if (consumerListByQueue.containsKey(consumerQueue))
		{
			MessageConsumer c = consumerListByQueue.get(consumerQueue);
			if (c != null && c.getMessageListener() != null)
			{
				logger.info("MessageConsumer already Exists for " + consumerQueue);
				createConsumer = false;
			}
		}
		if (createConsumer)
		{
			createConsumer(consumerQueue);
		}
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
		logger.debug("createConsumer " + queueName);
		Destination consumerDestination = session.createQueue(queueName);
		consumer = session.createConsumer(consumerDestination);
		consumer.setMessageListener(new QueueListener());
		logger.debug("created consumer with a new Queue Listener");
		consumerListByQueue.put(queueName, consumer);
	}

	public QueueReceiver createConsumerForReturnMessage(String queueName, String uniqueID) throws JMSException
	{

		return session.createReceiver(consumerQueueListByQueueName.get(queueName), "JMSCorrelationID='" + uniqueID + "'");
	}

	public synchronized MessageProducer getMessageProducerByQueue(String queueName)
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
