package semplest.test.unittest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.EmailType;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.service.scheduler.CreateSchedulerAndTask;

public class SchedulerServiceTest {

	public static ClassPathXmlApplicationContext appContext = null;
	
	private int errorCounter = 0;
	
	private static String url = "http://VMJAVA1:9898/semplest";
	private String serverName = "TEST";
	private String emailPrefix = "[Scheduler - " + serverName + "] ";
	
	public static void main(String[] args){
		try{
			SchedulerServiceTest test = new SchedulerServiceTest();		
			
			test.TestCase5();
			
			//test.TestCase1();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Test_SchedulerService(){
		
		System.out.println("####################################################################################");
		System.out.println("#                                                                                  #");
		System.out.println("#                             Scheduler Service Test                               #");
		System.out.println("#                                                                                  #");
		System.out.println("####################################################################################");	
		
		
	}
	
	public void TestCase1(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #1:");
			System.out.println("Description: Schedule two email tasks immediately.");
			System.out.println("Expected Output: Get two emails immediately.");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #1-email 1", "nan@semplest.com", "nan@semplest.com", "Expected Output: Get two emails immediately.", EmailType.PlanText.getEmailValue());
			//SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #1-email 2", "nan@semplest.com", "nan@semplest.com", "Expected Output: Get two emails immediately.", EmailType.PlanText.getEmailValue());
			listOfTasks.add(mailTask1);
			//listOfTasks.add(mailTask2);
			CreateSchedulerAndTask.createScheduleAndRun(url, listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase2(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #2:");
			System.out.println("Description: Schedule email task with frequency of 10 mins.");
			System.out.println("Expected Output: Get email every 10 mins.");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			Calendar cal = Calendar.getInstance();
			Date now = cal.getTime();
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #2-email 1", "nan@semplest.com", "nan@semplest.com", "now = " + now.toString() + "\nExpected Output: Get two emails every 10 mins.", EmailType.PlanText.getEmailValue());
			//SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #2-email 2", "nan@semplest.com", "nan@semplest.com", "now = " + now.toString() + "\nExpected Output: Get two emails every 10 mins.", EmailType.PlanText.getEmailValue());
			listOfTasks.add(mailTask1);
			//listOfTasks.add(mailTask2);			
			CreateSchedulerAndTask.createScheduleAndRun(url, listOfTasks, "MailScheduleTest", now, null, ProtocolEnum.ScheduleFrequency.TenMinutes.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase3(String index){
		try{						
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");			
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			
			SemplestSchedulerTaskObject case3task = CreateSchedulerAndTask.getTestTask(index);	
			listOfTasks.add(case3task);			
			CreateSchedulerAndTask.createScheduleAndRun(url, listOfTasks, "Test#"+index, new Date(), null, ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);			
			
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase4(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #4:");
			System.out.println("Description: Schedule one job of TestService2.");
			System.out.println("Expected Output: Having the right output.");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			Calendar cal = Calendar.getInstance();
			Date now = cal.getTime();
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject case4task1 = CreateSchedulerAndTask.getTestTask("1234567");
			
			listOfTasks.add(case4task1);
			
			CreateSchedulerAndTask.createScheduleAndRun(url, listOfTasks, "TestServiceTest", now, null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase5(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #5:");
			System.out.println("Description: Daily email task");
			System.out.println("Expected Output: Get email every day at morning, afternoon and evening.");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			Calendar cal = Calendar.getInstance();		
			
			//morning
			cal.set(2012, 6, 8, 8, 30, 0);
			Date morning = cal.getTime();
			ArrayList<SemplestSchedulerTaskObject> morningTask = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject morningMail = CreateSchedulerAndTask.getSendMailTask(emailPrefix + "Good Morning!", "nan@semplest.com", "nan@semplest.com", "Good Morning! I'm doing fine. \n\nBest,\nSemplestScheduler", EmailType.PlanText.getEmailValue());
			morningTask.add(morningMail);				
			CreateSchedulerAndTask.createScheduleAndRun(url, morningTask, "SchedulerDailyMorning", morning, null, ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
			Thread.sleep(5000);
			
			//afternoon
			cal.set(2012, 6, 8, 13, 00, 0);
			Date afternoon = cal.getTime();
			ArrayList<SemplestSchedulerTaskObject> afternoonTask = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject afternoonMail = CreateSchedulerAndTask.getSendMailTask(emailPrefix + "Good Afternoon!", "nan@semplest.com", "nan@semplest.com", "Good Afternoon! I'm doing fine. \n\nBest,\nSemplestScheduler", EmailType.PlanText.getEmailValue());
			afternoonTask.add(afternoonMail);				
			CreateSchedulerAndTask.createScheduleAndRun(url, afternoonTask, "SchedulerDailyAfternoon", afternoon, null, ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
			Thread.sleep(5000);
			
			//evening
			cal.set(2012, 6, 8, 17, 30, 0);
			Date evening = cal.getTime();
			ArrayList<SemplestSchedulerTaskObject> eveningTask = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject eveningMail = CreateSchedulerAndTask.getSendMailTask(emailPrefix + "Good Evening!", "nan@semplest.com", "nan@semplest.com", "Good Evening! I'm doing fine. \n\nBest,\nSemplestScheduler", EmailType.PlanText.getEmailValue());
			eveningTask.add(eveningMail);				
			CreateSchedulerAndTask.createScheduleAndRun(url, eveningTask, "SchedulerDailyEvening", evening, null, ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
			
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	
	
	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		StackTraceElement[] ste = e.getStackTrace();
		for(StackTraceElement s : ste){
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println();
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}

}
