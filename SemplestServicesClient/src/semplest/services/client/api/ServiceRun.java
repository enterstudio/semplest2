package semplest.services.client.api;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ServiceRun
{
	public String runMethod(String baseURL, String serviceName, String methodName, String jsonStr, String timeoutMS)
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
		return webResource.queryParams(queryParams).get(String.class);
	}

}
