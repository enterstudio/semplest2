package semplest.service.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.ScheduleJobObj;
import semplest.server.service.springjdbc.storedproc.GetNextScheduleJobSP;
import semplest.services.client.interfaces.SemplestSchedulerInterface;
import semplest.util.SemplestUtils;

import com.google.gson.Gson;

public class SemplestSchedulerServiceImpl implements SemplestSchedulerInterface
{
	private static final Logger logger = Logger.getLogger(SemplestSchedulerServiceImpl.class);
	private static Gson gson = new Gson();
	private static SemplestMessageBroker messageBroker = null;
	
	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		/*
		 * 
		 */
		Object lock = new Object();
		Vector<SchedulerRecord> recordMessageList = new Vector<SchedulerRecord>();
		//Start the Scheduler
		SemplestScheduler scheduler = new SemplestScheduler(lock,recordMessageList);
		scheduler.start();
		messageBroker = new SemplestMessageBroker(scheduler);
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
		logger.debug("call NewSchedule(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer scheduleJobID = Integer.parseInt(data.get("scheduleJobID"));
		final Integer ScheduleID = Integer.parseInt(data.get("ScheduleID"));
		final Boolean IsDelete = Boolean.getBoolean(data.get("IsDelete"));
		final String startTimeString = data.get("StartTime");
		final java.util.Date startTime = SemplestUtils.DATE_FORMAT_YYYYMMDD_HHmmss.parse(startTimeString);		
		final Boolean result = NewSchedule(scheduleJobID,ScheduleID,startTime,IsDelete);
		return gson.toJson(result);
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
	
	public String checkStatus(String json) throws Exception{
		return checkStatus(null, null);
	}
	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		return ServiceStatus.Up.getServiceStatusValue();
	}
}
