package semplest.test.unittest;

import java.util.ArrayList;
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
		
		SchedulerServiceTest test = new SchedulerServiceTest();
		test.TestCase5();
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
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #1-email 1", "nan@semplest.com", "nan@semplest.com", "Scheduler Test - Test Case 1 - email 1");
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #1-email 2", "nan@semplest.com", "nan@semplest.com", "Scheduler Test - Test Case 1 - email 2");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
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
			System.out.println("Description: Schedule two email tasks daily.");
			System.out.println("Expected Output: Get two emails daily.");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #2-email 1", "nan@semplest.com", "nan@semplest.com", "Scheduler Test - Test Case 2 - email 1");
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #2-email 2", "nan@semplest.com", "nan@semplest.com", "Scheduler Test - Test Case 2 - email 2");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase3(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #3:");
			System.out.println("Description: Schedule one good email task followed by a bad task, and then another good task.");
			System.out.println("Expected Output: should get the 1st and 3rd email tasks (and skip the 2nd one? or retry it?)");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			//good puppy
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #3-email 1", "nan@semplest.com", "nan@semplest.com", "I'm the good puppy");
			//bad puppy
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #3-email 2", "nan@semplest,com", "nan@semplest.com", "I'm the bad puppy");
			//good puppy
			SemplestSchedulerTaskObject mailTask3 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #3-email 3", "nan@semplest.com", "nan@semplest.com", "I'm the good puppy");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
			listOfTasks.add(mailTask3);
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase4(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #4:");
			System.out.println("Description: It's a follow-up for Case #3. Send new good tasks to the scheduler, and see if it could run them.");
			System.out.println("Expected Output: get the new emails");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #4-email 1", "nan@semplest.com", "nan@semplest.com", "good");
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #4-email 2", "nan@semplest.com", "nan@semplest.com", "good");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
		}
		catch(Exception e){
			errorHandler(e);
		}
	}
	
	public void TestCase5(){
		try{			
			System.out.println("============================================================");
			System.out.println("Test Case #5:");
			System.out.println("Description: It's a follow-up of Case #3. Schedule the Case #3 daily, and see if the bad task would block good tasks in future running.");
			System.out.println("Expected Output: should get the 1st and 3rd email tasks daily. (At least the 1st email daily.)");
			System.out.println("------------------------------------------------------------");
			
			BasicConfigurator.configure();
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			//good puppy
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #5-email 1", "nan@semplest.com", "nan@semplest.com", "I'm the good daily puppy");
			//bad puppy
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #5-email 2", "nan@semplest,com", "nan@semplest.com", "I'm the bad daily puppy");
			//good puppy
			SemplestSchedulerTaskObject mailTask3 = CreateSchedulerAndTask.getSendMailTask("[SchedulerTest]Test Case #5-email 3", "nan@semplest.com", "nan@semplest.com", "I'm the good daily puppy");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
			listOfTasks.add(mailTask3);
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
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
