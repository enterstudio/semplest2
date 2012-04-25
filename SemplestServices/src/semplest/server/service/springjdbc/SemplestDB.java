package semplest.server.service.springjdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.protocol.adengine.BidObject;
import semplest.server.service.springjdbc.helper.ScheduleTaskRowMapper;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.AddScheduleSP;



import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.MatchType;
import semplest.server.protocol.ProtocolEnum.ScheduleFrequency;;


public class SemplestDB extends BaseDB
{
	private static final Logger logger = Logger.getLogger(SemplestDB.class);
	
	/*
	 * Customer
	 */
	private static final RowMapper<CustomerObj> CustomerObjMapper = new BeanPropertyRowMapper(CustomerObj.class); 
	/*
	 * customer
	 */
    public static List<CustomerObj> getAllCustomers()
    {
    	
    	String strSQL = "select c.CustomerPK, c.Name, c.TotalTargetCycleBudget, cct.ProductGroupCycleType, cct.CycleInDays, bt.BillType, c.CreatedDate, c.EditedDate from Customer c " +
    			"inner join ProductGroupCycleType cct on c.ProductGroupCycleTypeFK = cct.ProductGroupCycleTypePK " +
    			"inner join BillType bt on c.BillTypeFK = bt.BillTypePK";
    	return jdbcTemplate.query(strSQL, CustomerObjMapper); //new CustomerRowMapper());
    }
	/*
	 * Scheduler Calls
	 */
    public static List<TaskRunnerObj> getScheduleTasks(Integer SchedulerPK)
    {
    	try
		{
			String strSQL = "select t.ServiceName,t.MethodName,t.Parameters,s.SchedulePK,st.TaskExecutionOrder from Schedule s " +
					"inner join ScheduleTaskAssociation st on s.SchedulePK = st.ScheduleFK " +
					"inner join Task t on t.TaskPK = st.TaskFK " +
					"where s.SchedulePK = ? and s.IsEnabled = 1 " +
					"order by st.TaskExecutionOrder";
			return jdbcTemplate.query(strSQL, new Object[] {SchedulerPK}, new ScheduleTaskRowMapper());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
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
	
	public static void storeBidObjects(Long productGroupID, Long promotionID, ArrayList<BidObject> bidObjects, String advertisingEngine) throws Exception
	{
		if (!AdEngine.existsAdEngine(advertisingEngine))
		{
			throw new Exception(advertisingEngine + " Not Found");
		}
		if (bidObjects != null && bidObjects.size() > 0)
		{
			AddBidSP addBid = new AddBidSP();
			for (BidObject bid : bidObjects)
			{
				try
				{
					addBid.execute(productGroupID, promotionID, bid.getBidID(),bid.getKeyword(), bid.getMicroBidAmount(), bid.getApprovalStatus(), bid.getMatchType(), bid.getFirstPageCpc(), 
							bid.getQualityScore(), bid.isIsEligibleForShowing(), true, bid.isNegative(), advertisingEngine, bid.getSemplestProbability());
					logger.info("Added Keyword " + bid.getKeyword() + " MicroBid " + bid.getMicroBidAmount());
				}
				catch (Exception e)
				{
					logger.error("Strore Bid Object Error " + bid.getKeyword() + ":" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
	}
	
	private static final RowMapper<BidObject> bidObjMapper = new BeanPropertyRowMapper(BidObject.class);
	
	public static List<BidObject> getBidObjects(Long promotionID,String advertisingEngine) throws Exception
	{
		if (!AdEngine.existsAdEngine(advertisingEngine))
		{
			throw new Exception(advertisingEngine + " Not Found");
		}
		String strSQL = "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,ki.ApprovalStatus,b.BidType, ki.FirstPageMicroCPC, " +
				"ki.QualityScore,ki.IsEligibleForShowing,p.IsNegative,ki.SemplestProbability from PromotionKeywordAssociation pka " +
				"inner join Keyword k on k.KeywordPK = pka.KeywordFK inner join PromotionKeywordAssociation p on p.KeywordFK = k.KeywordPK " +
				"inner join KeywordBid kb on kb.KeywordFK = k.KeywordPK " +
				"inner join BidType b on b.BidTypePK = kb.BidTypeFK " +
				"left join KeywordInitialBidData ki on ki.KeywordBidFK = kb.KeywordBidPK " +
				"inner join AdvertisingEngine a on a.AdvertisingEnginePK = kb.AdvertisingEngineFK " +
				"where pka.PromotionFK = ? and a.AdvertisingEngine = ? and kb.IsActive = 1";
    	return jdbcTemplate.query(strSQL, new Object[]{promotionID, advertisingEngine},bidObjMapper);
	}
	
	
	

	

}
