package semplest.server.service.springjdbc;

import java.util.Date;

public class ScheduleOperations extends BaseDB
{

	public static Integer addSchedule(String ScheduleName, Date StartTime, Date EndDate, String Frequency, boolean isEnabled, boolean isInactive, Integer PromotionID, Integer CustomerID, Integer ProductGroupID, Integer UserID) throws Exception
	{

		
		if (ScheduleFrequency.existsFrequency(Frequency))
		{
			AddScheduleSP addsched = new AddScheduleSP();
			Integer scheduleID = addsched.execute(ScheduleName, StartTime, EndDate, Frequency,isEnabled,  isInactive, PromotionID, CustomerID, ProductGroupID, UserID);
			return scheduleID;
		}
		else
		{
			throw new Exception("Frequency " + Frequency + " is not valid");
		}

	}
	/*
	public static int getFrequencyID(String Frequency)
	{
		SqlFunction sf = new SqlFunction(jdbcTemplate.getDataSource(), "select FrequencyPK from Frequency f where f.Frequency = '" +  Frequency + "'");
	    sf.compile();
	    return sf.run();

	}
	*/

	public static void addTask(String ServiceClientName, String MethodName, String jsonParameters) throws Exception
	{

		jdbcTemplate.update("insert into Task(ServiceName,MethodName,Parameters) values (?,?,?)", new Object[]
		{ ServiceClientName, MethodName, jsonParameters });

	}

	public static void deleteTask(Integer taskID) throws Exception
	{
		jdbcTemplate.update("delete Task where TaskPK = ?", new Object[]
		{ taskID });
	}

	public enum ScheduleFrequency
	{
		Now, Daily, Weekly, Monthly;
		public static boolean existsFrequency(String freq)
		{
			if (freq != null)
			{
				for (ScheduleFrequency val : ScheduleFrequency.values())
				{
					if (val.name().equalsIgnoreCase(freq))
					{
						return true;

					}
				}

			}
			return false;
		}
	}

}
