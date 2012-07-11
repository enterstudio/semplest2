package semplest.services.client.api;

import java.util.HashMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestMailServiceInterface;

import com.google.gson.Gson;

public class SemplestMailServiceClient extends ServiceRun implements SemplestMailServiceInterface, SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.server.service.mail.SemplestMailService";
	private static String BASEURLTEST = "http://vmdevjava1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(SemplestMailServiceClient.class);

	private String baseurl;

	public static void main(String[] args)
	{

		try
		{
			SemplestMailServiceClient client = new SemplestMailServiceClient(BASEURLTEST);
			String msgSubject = "Error Running Schedule - scheduleJobPK=12185";
			String emailFrom = "development@semplest.com";
			String emailTo = "development@semplest.com";
			String msgTxt = "ScheduleID= 1122 Task Failed: semplest.services.client.api.SemplestAdEngineServiceClient:AddPromotionToAdEngine:{\"productGroupID\":\"289\",\"adEngines\":\"[\\\"Google\\\"]\",\"customerID\":\"48\",\"promotionID\":\"309\"}";
			Boolean ret = client.SendEmail(msgSubject, emailFrom, emailTo, msgTxt, "text/plain; charset=ISO-8859-1"); //ProtocolEnum.EmailType.PlanText.name());
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
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
	public Boolean SendEmail(String subject, String from, String recipient, String msgTxt, String msgType) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("subject", subject);
		jsonHash.put("from", from);
		jsonHash.put("recipient", recipient);
		jsonHash.put("msgTxt", msgTxt);
		jsonHash.put("msgType", msgType);
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

	@Override
	public Boolean scheduleSendEmail(String subject, String from, String recipient, String msgTxt, String msgType) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String checkStatus(String timeout) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("input", timeout);
		String json = protocolJson.createJSONHashmap(jsonHash);
		String ret = runMethod(baseurl,SERVICEOFFERED, "checkStatus", json, timeout);
		return ret;
	}
}
