package semplest.service.scheduler;

import java.util.HashMap;
import java.util.Vector;

import org.apache.log4j.Logger;

import semplest.server.service.springjdbc.ScheduleJobObj;
import semplest.server.service.springjdbc.storedproc.GetNextScheduleJobSP;
import semplest.services.client.interfaces.SemplestSchedulerInterface;

import com.google.gson.Gson;

public class SemplestSchedulerServiceImpl implements SemplestSchedulerInterface
{
	private static final Logger logger = Logger.getLogger(SemplestSchedulerServiceImpl.class);
	private static Gson gson = new Gson();
	private static SemplestMessageBroker messageBroker = null;
	
	@Override
	public void initializeService(String input) throws Exception
	{
		Object lock = new Object();
		Vector<SchedulerRecord> recordMessageList = new Vector<SchedulerRecord>();
		//Start the Scheduler
		SemplestScheduler scheduler = new SemplestScheduler(lock,recordMessageList);
		scheduler.start();
		messageBroker = new SemplestMessageBroker(lock, scheduler);
		messageBroker.start();
		logger.info("Started Semplest Scheduler Service");
		//load the next schedule from the DB
		GetNextScheduleJobSP nextsch = new GetNextScheduleJobSP();
		ScheduleJobObj res = nextsch.execute();
		if (res != null)
		{
			SchedulerRecord scheduleRecord = new SchedulerRecord();
			scheduleRecord.setIsDelete(false);
			scheduleRecord.setScheduleID(res.getScheduleFK());
			scheduleRecord.setScheduleJobID(res.getScheduleJobPK());
			scheduleRecord.setTimeToRunInMS(res.getExecutionStartTime().getTime());
			scheduler.receiveSchedulerRecord(scheduleRecord);
		}
	}

	public String NewSchedule(String json) throws Exception
	{
		logger.debug("call deleteAd(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer scheduleJobID = Integer.parseInt(data.get("scheduleJobID"));
		Integer ScheduleID = Integer.parseInt(data.get("ScheduleID"));
		Boolean IsDelete = Boolean.getBoolean(data.get("IsDelete"));
		java.util.Date StartTime = new  java.util.Date(data.get("StartTime"));
		
		Boolean del =  NewSchedule(scheduleJobID,ScheduleID,StartTime,IsDelete);
		// convert result to Json String
		return gson.toJson(del);
	}
	@Override
	public Boolean NewSchedule(Integer scheduleJobID,Integer ScheduleID, java.util.Date StartTime,Boolean IsDelete) throws Exception
	{
		SchedulerRecord newschedule = new SchedulerRecord();
		newschedule.setScheduleJobID(scheduleJobID);
		newschedule.setIsDelete(IsDelete);
		newschedule.setScheduleID(ScheduleID);
		newschedule.setTimeToRunInMS(StartTime.getTime());
		SemplestSchedulerServiceImpl.messageBroker.newMessageFromWebService(newschedule);
		return true;
	}

}
