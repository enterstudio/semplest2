package semplest.test.other;

import java.util.HashMap;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.api.ServiceRun;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.TestService2Interface;


public class TestService2Client extends ServiceRun implements TestService2Interface, SchedulerTaskRunnerInterface
{

	private static String timeoutMS = "40000";
	private static String SERVICEOFFERED = "semplest.test.TestService2";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	
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
			ProtocolJSON protocolJson = new ProtocolJSON();
			HashMap<String, String> jsonHash = new HashMap<String, String>();
			jsonHash.put("uniqueID", String.valueOf(uniqueID));
			String json = protocolJson.createJSONHashmap(jsonHash);
			return runMethod("http://VMDEVJAVA1:9898/semplest", "semplest.test.TestService2", "TestMethod", json, "100000");
		}
		catch (Exception e)
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
