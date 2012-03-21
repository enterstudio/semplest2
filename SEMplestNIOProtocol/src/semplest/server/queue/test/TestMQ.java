package semplest.server.queue.test;


public class TestMQ
{

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
			System.out.println("Broker Error " + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
