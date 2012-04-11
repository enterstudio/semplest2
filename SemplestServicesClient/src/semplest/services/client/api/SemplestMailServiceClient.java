package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;

import com.google.gson.Gson;

import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.interfaces.SemplestMailServiceInterface;

public class SemplestMailServiceClient extends ServiceRun implements SemplestMailServiceInterface
{
	private static String SERVICEOFFERED = "semplest.server.service.mail.SemplestMailService";
	private static String BASEURLTEST = "http://localhost:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();

	private String baseurl;

	public static void main(String[] args)
	{

		try
		{
			SemplestMailServiceClient client = new SemplestMailServiceClient(null);
			Boolean ret = client.SendEmail("Test", "mitch@semplest.com", "mitch@semplest.com", "Hello there");
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

}
