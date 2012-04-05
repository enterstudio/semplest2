package semplest.services.client.api;

import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ServiceRun
{
	private static Gson gson = new Gson();
	public String runMethod(String baseURL, String serviceName, String methodName, String jsonStr, String timeoutMS) throws Exception
	{
		Client client = Client.create();
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("jsonStr", jsonStr);
		queryParams.add("service", serviceName);
		queryParams.add("method", methodName);
		if (timeoutMS != null)
		{
			queryParams.add("timeout", timeoutMS);
		}
		WebResource webResource = client.resource(baseURL);
		String ret = webResource.queryParams(queryParams).get(String.class);
		HashMap<String, String> resultMap = gson.fromJson(ret, HashMap.class);
		if (resultMap.containsKey("errorID"))
		{
			throw new Exception(resultMap.get("errorID") + ":" + resultMap.get("errorMessage"));
		}
		else
		{
			return resultMap.get("result");
		}
	}

}
