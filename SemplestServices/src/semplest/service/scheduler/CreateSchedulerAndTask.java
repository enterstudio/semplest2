package semplest.service.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.microsoft.adcenter.v8.ReportAggregation;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.SemplestString;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddScheduleJobSP;
import semplest.services.client.api.SemplestSchedulerServiceClient;

/*
 * Object contains all services that can be scheduled to run by scheduler
 */
public class CreateSchedulerAndTask
{
	
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	
	public static SemplestSchedulerTaskObject getSendMailTask(String subject, String from, String recipient, String msgTxt)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("Email").getClientServiceNameValue());
		//method
		taskObj.setMethodName("SendEmail");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("subject", subject);
		jsonHash.put("from", from);
		jsonHash.put("recipient", recipient);
		jsonHash.put("msgTxt", msgTxt);
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	public static SemplestSchedulerTaskObject getGoogleReportTask(SemplestString accountID)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("GoogleReport").getClientServiceNameValue());
		//method
		taskObj.setMethodName("getReportForAccount");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID.getSemplestString());
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	public static SemplestSchedulerTaskObject getMsnReportTask(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("MsnReport").getClientServiceNameValue());
		//method
		taskObj.setMethodName("getKeywordReport");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId));
		jsonHash.put("campaignId", Long.toString(campaignId));
		jsonHash.put("firstDay", gson.toJson(firstDay));
		jsonHash.put("lastDay", gson.toJson(lastDay));
		jsonHash.put("aggregation", gson.toJson(aggregation));
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	/*
	 * method creates a new schedule and associated the tasks, add a new job to the database and run it
	 * THIS NEEDS TO BE IN TRANACTION*******
	 */
	public static Boolean createScheduleAndRun(ArrayList<SemplestSchedulerTaskObject> tasks, String ScheduleName, Date StartTime, Date EndDate, String Frequency, boolean isEnabled, boolean isInactive, Integer PromotionID, 
			Integer CustomerID, Integer ProductGroupID, Integer UserID) throws Exception
	{
		if (tasks == null  || tasks.size() == 0)
		{
			throw new Exception ("No Tasks to Run for Schedule " + ScheduleName);
		}
			
		//create the schedule
		Integer scheduleID = SemplestDB.addSchedule(ScheduleName, StartTime, EndDate, Frequency, isEnabled, isInactive, PromotionID, CustomerID, ProductGroupID, UserID);
		if (scheduleID == null)
		{
			throw new Exception ("Unable to create Schedule " + ScheduleName);
		}
		SemplestDB.createTaskAndAssociateToSchedule(scheduleID, tasks);
		AddScheduleJobSP addJob = new AddScheduleJobSP();
		Integer jobID = addJob.execute(scheduleID, StartTime);
		if (jobID == null)
		{
			throw new Exception ("Unable to create job for Schedule " + ScheduleName + " scheduleID=" + scheduleID);
		}
		//run the schedule
		SemplestSchedulerServiceClient client = new SemplestSchedulerServiceClient(null);
		Boolean res = client.NewSchedule(jobID,scheduleID, StartTime, false);
		return res;
	}

}
