package semplest.test.unittest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.service.scheduler.CreateSchedulerAndTask;

public class SchedulerServiceTest {

	public static ClassPathXmlApplicationContext appContext = null;
	
	private int errorCounter = 0;
	
	public static void main(String[] args){
		try{
			SchedulerServiceTest test = new SchedulerServiceTest();		
			
			for(int i = 0; i < 15; i++){
				test.TestCase3("[ #" + i +" ]");
				//Thread.sleep(2000);
			}
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
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #1-email 1", "nan@semplest.com", "nan@semplest.com", "Expected Output: Get two emails immediately.");
			//SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #1-email 2", "nan@semplest.com", "nan@semplest.com", "Expected Output: Get two emails immediately.");
			listOfTasks.add(mailTask1);
			//listOfTasks.add(mailTask2);
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
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
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #2-email 1", "nan@semplest.com", "nan@semplest.com", "now = " + now.toString() + "\nExpected Output: Get two emails every 10 mins.");
			//SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #2-email 2", "nan@semplest.com", "nan@semplest.com", "now = " + now.toString() + "\nExpected Output: Get two emails every 10 mins.");
			listOfTasks.add(mailTask1);
			//listOfTasks.add(mailTask2);			
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", now, null, ProtocolEnum.ScheduleFrequency.TenMinutes.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase3(String index){
		try{						
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			Calendar cal = Calendar.getInstance();
			Date now = cal.getTime();
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			
			SemplestSchedulerTaskObject case3task = CreateSchedulerAndTask.getTestTask(index + now.toString());	
			listOfTasks.add(case3task);			
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "Test#"+index, now, null, ProtocolEnum.ScheduleFrequency.TenMinutes.name(), true, false, null, null, null, null);			
			
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
			
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "TestServiceTest", now, null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
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
