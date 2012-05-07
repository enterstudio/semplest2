package semplest.test.other;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.service.scheduler.CreateSchedulerAndTask;
import semplest.services.client.api.SemplestSchedulerServiceClient;


public class SchedulerServiceTest
{
	public static ClassPathXmlApplicationContext appContext = null;	

	public static void main(String[] args)
	{
		SchedulerServiceTest test = new SchedulerServiceTest();
		test.Test_SchedulerService();
			
	}
	
	public void Test_SchedulerClient(){
		try
		{
			SemplestSchedulerServiceClient test = new SemplestSchedulerServiceClient(null);
			
			Date tempTime = new Date();
			tempTime.setTime((new Date().getTime()-86400000));
			test.NewSchedule(20, 30, tempTime, false);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Test_SchedulerService(){
		try{
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("Test Scheduler mailTask1", "nan@semplest.com", "nan@semplest.com", "Hello");
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("Test Scheduler mailTask2", "mitch@semplest.com", "mitch@semplest.com", "Hello");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
			Date tempTime = new Date();
			tempTime.setTime((new Date().getTime()-86400000));
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", tempTime, null,ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
