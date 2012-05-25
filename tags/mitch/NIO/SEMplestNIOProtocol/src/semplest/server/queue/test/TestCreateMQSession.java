package semplest.server.queue.test;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TestCreateMQSession
{
	private ActiveMQConnectionFactory cf = null;
	private QueueConnection cn = null;
	private Session session = null;
	private Destination queueDestination = null;
	private MessageProducer producer = null;
	private MessageConsumer consumer = null;
	
	public TestCreateMQSession(String host, String port) throws JMSException
	{
		cf = new ActiveMQConnectionFactory("tcp://" + host + ":" + port) ; // + "?wireFormat=openwire&wireFormat.tightEncodingEnabled=true");
		cn = cf.createQueueConnection();
		
		session = cn.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}
	public void createMQQueue(String clientName, String queueName, boolean isSender) throws JMSException
	{
		queueDestination = session.createQueue(queueName);
		if (isSender)
		{
			producer = session.createProducer(queueDestination);
		}
		else
		{
			consumer = session.createConsumer(queueDestination);
			consumer.setMessageListener(new TestQueueListener(clientName));
		}
		cn.start();
		
		
	}
	public void sendTextMessage(String text) throws JMSException
	{
		TextMessage mess = session.createTextMessage(text);
		producer.send(mess);
				
	}
	
}
