package semplest.services.client.api;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.TaskOutput;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class ServiceRun
{
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(ServiceRun.class);

	public String runMethod(String baseURL, String serviceName, String methodName, String jsonStr, String timeoutMS) throws Exception
	{
		ClientResponse response = null;
		Client client = null;
		String ret = null;
		try
		{
			client = Client.create();
			MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
			queryParams.add("jsonStr", jsonStr);
			queryParams.add("service", serviceName);
			queryParams.add("method", methodName);
			if (timeoutMS != null)
			{
				queryParams.add("timeout", timeoutMS);
			}
			WebResource webResource = client.resource(baseURL);
			webResource = webResource.queryParams(queryParams);
			// client response
			response = webResource.get(ClientResponse.class);
			ret = response.getEntity(String.class);
			logger.debug(response.getClientResponseStatus().getStatusCode() + ":" + ret);
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
			if (response != null)
			{
				response.close();
			}
			if (client != null)
			{
				client.destroy();
			}

		}

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

	public Class<?> getReturnType(Class c, String method)
	{
		Method[] allMethods = c.getDeclaredMethods();
		for (Method m : allMethods)
		{
			if (m.getName().equals(method))
			{
				return m.getReturnType();
			}
		}
		return null;
	}

	public TaskOutput RunTask(Class taskClass, String baseurl, String SERVICEOFFERED, String method, String jsonParameters, String timeoutMS)
			throws Exception
	{

		TaskOutput out = new TaskOutput();
		String returnData = runMethod(baseurl, SERVICEOFFERED, method, jsonParameters, timeoutMS);
		Class returnType = getReturnType(taskClass, method);
		if (returnType != null)
		{
			Object result = gson.fromJson(returnData, returnType);
			out.setIsSuccessful(true);
			out.setResult(result);
			out.setReturnType(returnType);
		}
		else
		{
			out.setIsSuccessful(false);
			out.setErrorMessage("Error running RunTask " + SERVICEOFFERED + ":" + method + ": " + jsonParameters);
		}
		return out;

	}

}
