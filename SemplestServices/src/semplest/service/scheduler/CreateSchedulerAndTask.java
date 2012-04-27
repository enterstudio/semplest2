package semplest.service.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddScheduleJobSP;
import semplest.services.client.api.SemplestSchedulerServiceClient;

/*
 * Object contains all services that can be scheduled to run by scheduler
 */
public class CreateSchedulerAndTask
{
	
	private static ProtocolJSON protocolJson = new ProtocolJSON();
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
