package semplest.services.client.test;

import javax.ws.rs.core.MultivaluedMap;

import semplest.services.client.interfaces.TestServiceInterface;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class TestServiceClient implements TestServiceInterface
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		/*
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:9898/semplest/TestMethod");
		String s = webResource.get(String.class);
		System.out.println(s);
		*/
		TestServiceInterface test = new TestServiceClient();
		System.out.println(test.TestMethod("5"));

	}

	@Override
	public String TestMethod(String uniqueID)
	{
		try
		{
			Client client = Client.create();
			MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
			
			queryParams.add("jsonStr", "{ \"test:\" : \"This is a test\" }");
			queryParams.add("service", "semplest.test.TestService");
			queryParams.add("method", "TestMethod");

			WebResource webResource = client.resource("http://VMJAVA1:9898/semplest");
			return   webResource.queryParams(queryParams).get(String.class);
		}
		catch (UniformInterfaceException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
