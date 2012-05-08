package semplest.services.client.api;

import java.util.HashMap;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestMailServiceInterface;

import com.google.gson.Gson;

public class SemplestMailServiceClient extends ServiceRun implements SemplestMailServiceInterface, SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.server.service.mail.SemplestMailService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();

	private String baseurl;

	public static void main(String[] args)
	{

		try
		{
			SemplestMailServiceClient client = new SemplestMailServiceClient("http://VMJAVA1:9898/semplest");
			Boolean ret = client.SendEmail("Test", "mberg@semplest.com", "mitch@semplest.com", "Hello there");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public SemplestMailServiceClient(String baseurl)
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
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean SendEmail(String subject, String from, String recipient, String msgTxt) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("subject", subject);
		jsonHash.put("from", from);
		jsonHash.put("recipient", recipient);
		jsonHash.put("msgTxt", msgTxt);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "SendEmail", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public TaskOutput RunTask(String method, String jsonParameters,String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}
}
