package semplest.services.client.test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.api.SemplestMailServiceClient;
import semplest.services.client.api.ServiceRun;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.TestService2Interface;
import semplest.services.client.interfaces.TestServiceInterface;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class TestService2Client extends ServiceRun implements TestService2Interface, SchedulerTaskRunnerInterface
{
	private static final Logger logger = Logger.getLogger(TestService2Client.class);
	private static String timeoutMS = "40000";
	private static String SERVICEOFFERED = "semplest.test.TestService2";
	private static String BASEURLTEST = "http://localhost:9898/semplest"; // VMJAVA1
	
	private String baseurl;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		

	}

	public TestService2Client(String baseurl)
	{
		if (baseurl == null)
		{
			this.baseurl = BASEURLTEST;
		}
		else
		{
			this.baseurl = baseurl;
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
				jsonHash.put("uniqueID", String.valueOf(uniqueID));
				String json = protocolJson.createJSONHashmap(jsonHash);
				return runMethod("http://localhost:9898/semplest", "semplest.test.TestService2", "TestMethod", json, "100000");
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
	public TaskOutput RunTask(String method, String jsonParameters,String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), BASEURLTEST, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}

}
