package semplest.client.test.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ServiceClient implements Runnable
{

	private static int num = 25;
	private static int numRuns = 500;
	private static int numThreads = 5;
	private static Integer total = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		for (int j = 0; j < numRuns; j++)
		{
			for (int i = 0; i < num; i++)
			{
				ServiceClient cli = new ServiceClient();
				executor.submit(cli);
			}
			
			try
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();

	}

	@Override
	public void run()
	{
		/*
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:9898/semplest/TestService/TestMethod?jsonStr={ \"param1\" : \"data\" }");
		String s = webResource.get(String.class);
		*/
		Client client = Client.create();
		MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
		queryParams.add("jsonStr", "{ \"test:\" : \"This is a test\" }");

		queryParams.add("service", "semplest.test.TestService");
		queryParams.add("method", "TestMethod");
		
		WebResource webResource = client.resource("http://VMJAVA1:9898/semplest");
		String s = webResource.queryParams(queryParams).get(String.class);
		/*
		 * ClientResponse response =
		 * webResource.accept("text/plain").get(ClientResponse.class); int
		 * status = response.getStatus(); String textEntity =
		 * response.getEntity(String.class);
		 */

		synchronized(total)
		{
			total++;
			System.out.println(total.intValue() + ":" + s);
		}
	}

}
