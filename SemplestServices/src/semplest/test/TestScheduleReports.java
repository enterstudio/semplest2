package semplest.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.SemplestString;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.service.scheduler.CreateSchedulerAndTask;


public class TestScheduleReports
{
	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	public static ClassPathXmlApplicationContext appContext = null;

	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();

			appContext = new ClassPathXmlApplicationContext("Service.xml");
			List ll= SemplestDB.getAdEngineAccount(2, "Google");
			//Test Scheduler
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			
			SemplestString ss = new SemplestString();
			SemplestSchedulerTaskObject reportTask1 = CreateSchedulerAndTask.getGoogleReportTask(ss.toSemplestString("2188810777"));
			listOfTasks.add(reportTask1);
			CreateSchedulerAndTask.createScheduleAndRun("http://VMDEVJAVA1:9898/semplest",listOfTasks, "GoogleReportScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
			
		}
		catch (Exception e)
		{
			System.out.println("ERROR" + e.getMessage());
		}
		
	}
}
