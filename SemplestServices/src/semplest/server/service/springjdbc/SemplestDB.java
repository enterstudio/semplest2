package semplest.server.service.springjdbc;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import semplest.server.protocol.adengine.BidObject;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.AddScheduleSP;

public class SemplestDB extends BaseDB
{
	

	private static final Logger logger = Logger.getLogger(SemplestDB.class);
	/*
	 * Scheduler Calls
	 */
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

	public static void associateTaskToSchedule(int ScheduleFK, int TaskFK, int TaskExecutionOrder) throws Exception
	{
		jdbcTemplate.update("ScheduleTaskAssociation(ScheduleFK,TaskFK,TaskExecutionOrder) values (?,?,?)", new Object[]
		{ ScheduleFK, TaskFK, TaskExecutionOrder });
	}

	public static void deleteTask(Integer taskID) throws Exception
	{
		jdbcTemplate.update("delete Task where TaskPK = ?", new Object[]
		{ taskID });
	}

	

	
	/*
	 * Bidding calls
	 */
	
	public static void storeBidObjects(Long productGroupID, Long adGroupID, ArrayList<BidObject> bidObjects, AdEngine advertisingEngine)
	{
		if (bidObjects != null && bidObjects.size() > 0)
		{
			AddBidSP addBid = new AddBidSP();
			for (BidObject bid : bidObjects)
			{
				try
				{
					addBid.execute(productGroupID, adGroupID, bid.getBidID(),bid.getKeyword(), bid.getMicroBidAmount(), bid.getApprovalStatus(), bid.getMatchType(), bid.getFirstPageCpc(), 
							bid.getQualityScore(), bid.getStatus(), true, bid.isNegative(), advertisingEngine.name());
				}
				catch (Exception e)
				{
					logger.error("Strore Bid Object Error " + bid.getKeyword() + ":" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/*
	 * ENUMS
	 */
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
	public enum AdEngine
	{
		MSN,Google;
		public static boolean existsFrequency(String adEngine)
		{
			if (adEngine != null)
			{
				for (AdEngine val : AdEngine.values())
				{
					if (val.name().equalsIgnoreCase(adEngine))
					{
						return true;

					}
				}

			}
			return false;
		}
	}
	

}
