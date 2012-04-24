package semplest.test;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.springjdbc.SemplestDB;

public class TestSpringJDBC
{
	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	public static ClassPathXmlApplicationContext appContext = null;

	public static void main(String[] args)
	{
		try
		{
			/*Properties properties = new Properties();
			FileInputStream is = new FileInputStream(PROPSFILE);
			properties.load(is);
			is.close();
			*/
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			SemplestDB op = new SemplestDB();
			Integer i = op.addSchedule("TestSchedule", new Date(),null, "Now",true, false, null, null,null, null);
			System.out.println(i);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
