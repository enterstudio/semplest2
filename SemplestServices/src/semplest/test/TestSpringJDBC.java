package semplest.test;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.service.springjdbc.AdEngineAccountObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.GetAdEngineAccountSP;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;


public class TestSpringJDBC
{
	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	public static ClassPathXmlApplicationContext appContext = null;

	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();
			/*Properties properties = new Properties();
			FileInputStream is = new FileInputStream(PROPSFILE);
			properties.load(is);
			is.close();
			*/
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			GetAllPromotionDataSP sp = new GetAllPromotionDataSP();
			sp.execute(60);
			//GetAdEngineAccountSP sp = new  GetAdEngineAccountSP();
			//AdEngineAccountObj r = sp.execute(12, "MSN"); 
			
			
			AdEngineID a = SemplestDB.getAdEngineID(62, AdEngine.Google);
			a.getAccountID();
			
			HashMap<String, Object> configData = SemplestDB.loadConfigurationData();
			Iterator<String> configIT = configData.keySet().iterator();
			while (configIT.hasNext())
			{
				String key = configIT.next();
				if (configData.get(key) != null)
				{
					System.out.println(key + "=" + configData.get(key).toString());
				}
				else
				{
					System.out.println(key + "= null");
				}
			}
			
			//List ll= SemplestDB.getAdEngineAccount(2, "Google");
			//List<LinkedHashMap<String, Object>> AdEngineAccoutRow =SemplestDB.getAdEngineAccount(2, "Google");
			
			//String companyName = (String) AdEngineAccoutRow.get(0).get("CustomerName");
			//System.out.println("companyName=" + companyName);
			//Test Scheduler
			/*
			ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
			SemplestSchedulerTaskObject mailTask1 = CreateSchedulerAndTask.getSendMailTask("Test Scheduler mailTask1", "nan@semplest.com", "nan@semplest.com", "Hello");
			SemplestSchedulerTaskObject mailTask2 = CreateSchedulerAndTask.getSendMailTask("Test Scheduler mailTask2", "mitch@semplest.com", "mitch@semplest.com", "Hello");
			listOfTasks.add(mailTask1);
			listOfTasks.add(mailTask2);
			CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, "MailScheduleTest", new Date(), null,ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, null, null, null, null);
			*/
			
			
			//SemplestDB op = new SemplestDB();
			//List ll= SemplestDB.getAdEngineAccount(2, "Google");
			//System.out.println("AdEngineAccount ");
			/*
			SemplestAdengineServiceImpl ad = new SemplestAdengineServiceImpl();
			 ArrayList<String> l =  new ArrayList<String>();
			 l.add("Google");
			ad.AddPromotionToAdEngine(2, 1, 1 ,l);
			*/
			/*
			Integer ret = SemplestDB.addAdEngineAccountID(12, 343434L, "Google");
			if (ret.intValue() > 0)
			{
				System.out.println("added");
			}
			*/
			
			//List<BidObject> bids = op.getBidObjects(2L, ProtocolEnum.AdEngine.Google.name());
			//Integer i = op.addSchedule("TestSchedule", new Date(),null, "Now",true, false, null, null,null, null);
			//if (bids != null && !bids.isEmpty()) System.out.println(bids.get(0).getMicroBidAmount());
			/*
			GetNextScheduleJobSP nextsch = new GetNextScheduleJobSP();
			ScheduleJobObj res = nextsch.execute();
			if (res != null)
			{
				System.out.println(res.getScheduleJobPK() + ":" + res.getScheduleFK() + ":" + res.getExecutionStartTime());
			}
			*/
			/*
			CustomerDB cust = new CustomerDB();
			List<CustomerObj> customers = cust.getAllCustomers();
			if (!customers.isEmpty())
			{
				System.out.println(customers.get(0).getCustomerPK() + ":" + customers.get(0).getCreatedDate().toString());
			}
			else
			{
				System.out.println("No customers found");
			}
			SetScheduleJobCompleteSP sp  = new SetScheduleJobCompleteSP();
			Map res = sp.execute(2, 1);
			*/
			/*
			TaskRunnerDB tasks = new TaskRunnerDB();
			List<TaskRunnerObj> l = tasks.getScheduleTasks(2);
			if (!l.isEmpty())
			{
				for (int i = 0; i < l.size(); i++)
				{
					TaskRunnerObj j = l.get(i);
					System.out.println(j.getServiceName() + ":" + j.getMethodName() + ":" + j.getParameters());
				}
			}
			else
			{
				System.out.println("No tasks found");
			}
			*/
		}
		catch (Exception e)
		{
			System.out.println("ERROR" + e.getMessage());
		}
		/*
		catch (FileNotFoundException e)
		{
			logger.error("Problem", e);
		}
		catch (IOException e)
		{
			logger.error("Problem", e);
		}
		*/
	}
}
