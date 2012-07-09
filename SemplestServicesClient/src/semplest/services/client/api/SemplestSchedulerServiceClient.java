package semplest.services.client.api;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestSchedulerInterface;

public class SemplestSchedulerServiceClient extends ServiceRun implements SemplestSchedulerInterface
{
	private static String SERVICEOFFERED = "semplest.service.scheduler.SemplestSchedulerService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static final Logger logger = Logger.getLogger(SemplestSchedulerServiceClient.class);
	private String baseurl;
	
	public static void main(String[] args)
	{
		try
		{
			java.util.Date startTime = null;
			try
			{
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
				c.add(Calendar.MILLISECOND, 20000);
				startTime = c.getTime();
			}
			catch (Exception e2)
			{
				logger.error("Error Getting StartTime" + e2.getMessage(), e2);
			}
			SemplestSchedulerServiceClient client = new SemplestSchedulerServiceClient(null);
			client.NewSchedule(1,1, startTime, false);
			//client.NewSchedule(2,3, new Date(), false);
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
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
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean NewSchedule(Integer scheduleJobID, Integer ScheduleID, Date StartTime, Boolean IsDelete) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("scheduleJobID", String.valueOf(scheduleJobID));
		jsonHash.put("ScheduleID", String.valueOf(ScheduleID));
		jsonHash.put("StartTime", StartTime.toString());
		jsonHash.put("IsDelete", String.valueOf(IsDelete));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "NewSchedule", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public String checkStatus(String input) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("input", input);
		String json = protocolJson.createJSONHashmap(jsonHash);
		String ret = runMethod(baseurl,SERVICEOFFERED, "checkStatus", json, timeoutMS);
		return ret;
	}

}
