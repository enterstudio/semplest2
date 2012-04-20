package semplest.service.scheduler;

import java.util.HashMap;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import semplest.services.client.interfaces.SemplestSchedulerInterface;

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
	}

	public String NewSchedule(String json) throws Exception
	{
		logger.debug("call deleteAd(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer ScheduleID = Integer.parseInt(data.get("ScheduleID"));
		Integer CustomerID = Integer.parseInt(data.get("CustomerID"));
		Integer ProductGroupID = Integer.parseInt(data.get("ProductGroupID"));
		Integer PromotionID = Integer.parseInt(data.get("PromotionID"));
		Integer UserID = Integer.parseInt(data.get("UserID"));
		Boolean IsDelete = Boolean.getBoolean(data.get("IsDelete"));
		java.util.Date StartTime = new  java.util.Date(data.get("StartTime"));
		
		Boolean del =  NewSchedule(ScheduleID, CustomerID, ProductGroupID, PromotionID,UserID,StartTime,IsDelete);
		// convert result to Json String
		return gson.toJson(del);
	}
	@Override
	public Boolean NewSchedule(Integer ScheduleID, Integer CustomerID, Integer ProductGroupID, Integer PromotionID,Integer UserID, java.util.Date StartTime,Boolean IsDelete) throws Exception
	{
		SchedulerRecord newschedule = new SchedulerRecord();
		newschedule.setCustomerID(CustomerID);
		newschedule.setDelete(IsDelete);
		newschedule.setProductGroupID(ProductGroupID);
		newschedule.setPromotionID(PromotionID);
		newschedule.setScheduleID(ScheduleID);
		newschedule.setUserID(UserID);
		newschedule.setTimeToRunInMS(StartTime.getTime());
		SemplestSchedulerServiceImpl.messageBroker.newMessageFromDB(newschedule);
		return true;
	}

}
