package semplest.server.queue.test;

import org.apache.log4j.Logger;

public class TestMQ
{
	private static final Logger logger = Logger.getLogger(TestMQ.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			TestActiveMQBroker MQBroker = new TestActiveMQBroker("Test", "localhost", "8888");
			MQBroker.run();
			
			//create client1
			TestCreateMQSession client1 = new TestCreateMQSession("localhost","8888");
			client1.createMQQueue("client1" ,"TestQueue", true);
			//
			TestCreateMQSession client2 = new TestCreateMQSession("localhost","8888");
			client2.createMQQueue("client2","TestQueue", false);
			
			client1.sendTextMessage("Hello from Client1");
			
			
			

			
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}

	}

}
