package semplest.services.client.test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.api.ServiceRun;
import semplest.services.client.interfaces.TestServiceInterface;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class TestServiceClient extends ServiceRun implements TestServiceInterface
{

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
		try
		{
			TestServiceInterface test = new TestServiceClient();
			int i = 0;
			while (true)
			{
				long startTime = System.currentTimeMillis();
				System.out.println(test.TestMethod(String.valueOf(i)) + " Took " + String.valueOf((System.currentTimeMillis() - startTime)));
				i++;
				Thread.sleep(50);

			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
				return runMethod("http://VMDEVJAVA1:9898/semplest", "semplest.test.TestService", "TestMethod", json, "30000");
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}

}
