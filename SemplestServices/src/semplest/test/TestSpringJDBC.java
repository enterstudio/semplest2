package semplest.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.springjdbc.CustomerDB;
import semplest.server.service.springjdbc.CustomerObj;

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
			System.out.println(e.getMessage());
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
