package semplest.services.client.api;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import semplest.server.protocol.TaskOutput;


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
	
	public Class<?> getReturnType(Class c,String method)
	{
		Method[] allMethods= c.getDeclaredMethods();
		for (Method m : allMethods)
		{
			if (m.getName().equals(method))
			{
				return m.getReturnType();
			}
		}
		return null;
	}
	public TaskOutput RunTask(Class taskClass, String baseurl, String SERVICEOFFERED, String method, String jsonParameters,String timeoutMS) throws Exception
	{
		
		TaskOutput out = new TaskOutput();
		String returnData = runMethod(baseurl, SERVICEOFFERED, method, jsonParameters, timeoutMS);
		Class returnType = getReturnType(taskClass,method);
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
