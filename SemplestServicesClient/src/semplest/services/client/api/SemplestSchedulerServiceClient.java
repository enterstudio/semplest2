package semplest.services.client.api;

import java.util.Date;
import java.util.HashMap;

import com.google.gson.Gson;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestSchedulerInterface;

public class SemplestSchedulerServiceClient extends ServiceRun implements SemplestSchedulerInterface,SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.service.scheduler.SemplestSchedulerService";
	private static String BASEURLTEST = "http://localhost:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static ProtocolJSON protocolJson = new ProtocolJSON();

	private String baseurl;
	
	public static void main(String[] args)
	{
		try
		{
			SemplestSchedulerServiceClient client = new SemplestSchedulerServiceClient(null);
			client.NewSchedule(2, new java.util.Date(), false);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SemplestSchedulerServiceClient(String baseurl)
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
	public TaskOutput RunTask(String method, String jsonParameters, String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean NewSchedule(Integer ScheduleID, Date StartTime, Boolean IsDelete) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("ScheduleID", String.valueOf(ScheduleID));
		jsonHash.put("StartTime", StartTime.toString());
		jsonHash.put("IsDelete", String.valueOf(IsDelete));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "NewSchedule", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	

}
