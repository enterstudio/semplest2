package semplest.server.queue.test;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;

public class TestActiveMQBroker implements Runnable
{
	private BrokerService broker = null;
	private ActiveMQQueue queue = null;
	private Destination queueDestination = null;
	private MessageProducer producer = null;
	private Session session = null;
	

	private final String brokerName;
	private final String host;
	private final String port;
	//private final String queueName;
	public TestActiveMQBroker(String brokerName, String host, String port)
	{
		this.port = port;
		this.host = host;
		this.brokerName = brokerName;
	}
	public void run()
	{
		try
		{
			broker = new BrokerService();
			broker.setBrokerName(brokerName);
			broker.setUseShutdownHook(false);
			
			
			//Add Queue
			//queue = new ActiveMQQueue("jms/" + queueName);

			
			//Add plugin
			//broker.setPlugins(new BrokerPlugin[]{new JaasAuthenticationPlugin()});
			//Add a network connection
			//NetworkConnector connector = answer.addNetworkConnector("static://"+"tcp://somehost:61616");
			//connector.setDuplex(true);
			broker.addConnector("tcp://" + host + ":" + port);
			broker.start();
			
			

			
		}
		catch (Exception e)
		{
			System.out.println("Broker Error " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	
	public MessageProducer createQueue(String queueName)
	{
		try
		{
			//create a connection 
			Context ctx = new InitialContext();
			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://" + host + ":" + port) ; // + "?wireFormat=openwire&wireFormat.tightEncodingEnabled=true");
			QueueConnection cn = cf.createQueueConnection();
			cn.start();
			
			session = cn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			queueDestination = session.createQueue(queueName);
			return session.createProducer(queueDestination);
		}
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void sendTextMessage(String text) throws JMSException
	{
		TextMessage mess = session.createTextMessage(text);
		producer.send(mess);
				
	}

	*/
	

}
