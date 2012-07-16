package semplest.services.client.test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.api.ServiceRun;
import semplest.services.client.interfaces.TestServiceInterface;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class TestServiceClient extends ServiceRun implements TestServiceInterface, Runnable
{
	private static final Logger logger = Logger.getLogger(TestServiceClient.class);
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/*
		 * Client client = Client.create(); WebResource webResource =
		 * client.resource("http://localhost:9898/semplest/TestMethod"); String
		 * s = webResource.get(String.class); System.out.println(s);
		 */
		/*int numThreads = 4;
		Thread[] threads = new Thread[numThreads];
		for (int i= 0; i < numThreads; i++)
		{
			TestServiceClient test = new TestServiceClient();
			threads[i] = new Thread(test);
			threads[i].start();
			
		}*/
		
		TestServiceClient test = new TestServiceClient();
		test.TestMethod("test");
		

	}

	@Override
	public String TestMethod(String uniqueID)
	{
		try
		{
			try
			{
				ProtocolJSON protocolJson = new ProtocolJSON();
				HashMap<String, String> jsonHash = new HashMap<String, String>();
				jsonHash.put("customerID", String.valueOf(uniqueID));
				String json = protocolJson.createJSONHashmap(jsonHash);
				return runMethod("http://172.18.9.26:9898/semplest", "semplest.test.TestService", "TestMethod", json, "30000"); //172.18.9.26
			}
			catch (Exception e)
			{
				logger.error("Problem", e);
			}

			/*
			 * String returnData = runMethod(BASEURLTEST, SERVICEOFFERED,
			 * "getBid", json, timeoutMS); return gson.fromJson(returnData,
			 * HashMap.class);
			 * 
			 * Client client = Client.create(); MultivaluedMap<String,String>
			 * queryParams = new MultivaluedMapImpl();
			 * 
			 * queryParams.add("jsonStr", "{ \"test:\" : \"This is a test\" }");
			 * queryParams.add("service", "semplest.test.TestService");
			 * queryParams.add("method", "TestMethod");
			 * 
			 * WebResource webResource =
			 * client.resource("http://VMJAVA1:9898/semplest"); return
			 * webResource.queryParams(queryParams).get(String.class);
			 */
		}
		catch (UniformInterfaceException e)
		{
			logger.error("Problem", e);
		}
		return null;
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void run()
	{
		try
		{
			
			int i = 0;
			while (true)
			{
				long startTime = System.currentTimeMillis();
				System.out.println(this.TestMethod(String.valueOf(i)) + " Took " + String.valueOf((System.currentTimeMillis() - startTime)));
				i++;
				Thread.sleep(0);

			}
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}
		
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
