package semplest.server.service.springjdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.ScheduleFrequency;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.server.protocol.adengine.TrafficEstimatorDataObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject.BidData;
import semplest.server.protocol.google.GoogleAdIdSemplestAdIdPair;
import semplest.server.protocol.google.GoogleUpdateAdRequest;
import semplest.server.service.springjdbc.helper.AllBidRSExtactor;
import semplest.server.service.springjdbc.helper.AllBiddableRSExtractor;
import semplest.server.service.springjdbc.helper.ScheduleTaskRowMapper;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.AddKeywordBidDataSP;
import semplest.server.service.springjdbc.storedproc.AddReportDataSP;
import semplest.server.service.springjdbc.storedproc.AddScheduleSP;
import semplest.server.service.springjdbc.storedproc.AddTaskSP;
import semplest.server.service.springjdbc.storedproc.AddTrafficEstimatorSP;
import semplest.server.service.springjdbc.storedproc.GetBiddableAdGroupCriteriaSP;
import semplest.server.service.springjdbc.storedproc.GetLatestTrafficEstimatorSP;
import semplest.server.service.springjdbc.storedproc.UpdateDefaultBidForKeywordsSP;

public class SemplestDB extends BaseDB
{
	private static final Logger logger = Logger.getLogger(SemplestDB.class);
	
	public static final String SQL_SET_AD_ID_FOR_AD_GROUP = "insert into AdvertisingEngineAds(AdvertisingEngineAdPK, AdvertisingEngineFK, PromotionAdsFK) " +
	        											    "select ?, ae.AdvertisingEnginePK, ? from AdvertisingEngine ae where ae.AdvertisingEngine = ?";
	
	public static final String SQL_MARK_AD_DELETED = "update  PromotionAds " +
													    "set  IsDeleted = 1, " +
															 "DeletedDate = ? " +
													   "from  PromotionAds p, " +
															 "AdvertisingEngineAds a " +
													  "where  p.PromotionAdsPK = a.PromotionAdsFK " +
														"and  a.AdvertisingEngineAdPK = ?";
	
	public static final String SQL_UPDATE_AD_ENGINE_AD_ID = "update   AdvertisingEngineAds " + 	
															   "set	  AdvertisingEngineAdPK = ? " +  	
														      "from	  AdvertisingEngineAds aea, " +  
														  		     "AdvertisingEngine e " + 
														     "where	  aea.PromotionAdsFK = ? " + 
														       "and   aea.AdvertisingEngineAdPK = ? " + 
														  	   "and	  aea.AdvertisingEngineFK = e.AdvertisingEnginePK " + 
														  	   "and   e.AdvertisingEngine = ?";
	/*
	 * Configuration
	 */
	public static HashMap<String,Object> loadConfigurationData() throws Exception
	{
		final String strSQL = "select * from Configuration";
		final List<Map<String, Object>> res = jdbcTemplate.queryForList(strSQL);
		if (res != null)
		{
			return (HashMap<String,Object>) res.get(0);
		}
		else
		{
			return null;
		}
	}
	
	public static List<Integer> getPromotionIdsForProductGroup(final Integer ProductGroupID) throws Exception
	{
		final String strSQL = "select PromotionPK from Promotion where ProductGroupFK = ?";
		final List<Integer> promotionIds = jdbcTemplate.queryForList(strSQL, Integer.class, ProductGroupID);
		return promotionIds;
	}
	
	/*
	 * Customer
	 */
	private static final RowMapper<CustomerObj> CustomerObjMapper = new BeanPropertyRowMapper<CustomerObj>(CustomerObj.class);

	public static List<CustomerObj> getAllCustomers() throws Exception
	{

		String strSQL = "select c.CustomerPK, c.Name, c.TotalTargetCycleBudget, cct.ProductGroupCycleType, cct.CycleInDays, bt.BillType, c.CreatedDate, c.EditedDate from Customer c "
				+ "inner join ProductGroupCycleType cct on c.ProductGroupCycleTypeFK = cct.ProductGroupCycleTypePK "
				+ "inner join BillType bt on c.BillTypeFK = bt.BillTypePK";
		try
		{
			return jdbcTemplate.query(strSQL, CustomerObjMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}// new
																// CustomerRowMapper());
	}

	/*
	 * public void startTransaction() { jdbcTemplate }
	 */

	/*
	 * Scheduler Calls
	 */
	public static List<TaskRunnerObj> getScheduleTasks(Integer SchedulerPK) throws Exception
	{
		try
		{
			String strSQL = "select t.ServiceName,t.MethodName,t.Parameters,s.SchedulePK,st.TaskExecutionOrder from Schedule s "
					+ "inner join ScheduleTaskAssociation st on s.SchedulePK = st.ScheduleFK " + "inner join Task t on t.TaskPK = st.TaskFK "
					+ "where s.SchedulePK = ? and s.IsEnabled = 1 " + "order by st.TaskExecutionOrder";
			return jdbcTemplate.query(strSQL, new Object[]
			{ SchedulerPK }, new ScheduleTaskRowMapper());
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static Integer addSchedule(String ScheduleName, Date StartTime, Date EndDate, String Frequency, boolean isEnabled, boolean isInactive,
			Integer PromotionID, Integer CustomerID, Integer ProductGroupID, Integer UserID) throws Exception
	{

		if (ScheduleFrequency.existsFrequency(Frequency))
		{
			AddScheduleSP addsched = new AddScheduleSP();
			Integer scheduleID = addsched.execute(ScheduleName, StartTime, EndDate, Frequency, isEnabled, isInactive, PromotionID, CustomerID,
					ProductGroupID, UserID);
			return scheduleID;
		}
		else
		{
			throw new Exception("Frequency " + Frequency + " is not valid");
		}

	}

	/*
	 * public static int getFrequencyID(String Frequency) { SqlFunction sf = new
	 * SqlFunction(jdbcTemplate.getDataSource(),
	 * "select FrequencyPK from Frequency f where f.Frequency = '" + Frequency +
	 * "'"); sf.compile(); return sf.run();
	 * 
	 * }
	 */

	public static void associateTaskToSchedule(int ScheduleFK, int TaskFK, int TaskExecutionOrder) throws Exception
	{
		jdbcTemplate.update("insert into ScheduleTaskAssociation(ScheduleFK,TaskFK,TaskExecutionOrder) values (?,?,?)", new Object[]
		{ ScheduleFK, TaskFK, TaskExecutionOrder });
	}

	public static void deleteTask(Integer taskID) throws Exception
	{
		jdbcTemplate.update("delete Task where TaskPK = ?", new Object[]
		{ taskID });
	}

	/*
	 * Note Task execution order is determined by order of
	 * ArrayList<SemplestSchedulerTaskObject> scheduleTaskObjList
	 */
	public static void createTaskAndAssociateToSchedule(int ScheduleFK, List<SemplestSchedulerTaskObject> scheduleTaskObjList) throws Exception
	{
		AddTaskSP addTask = new AddTaskSP();
		int i = 0;
		for (SemplestSchedulerTaskObject taskObj : scheduleTaskObjList)
		{
			Integer taskID = addTask.execute(taskObj.getClientServiceName(), taskObj.getMethodName(), taskObj.getParameters());
			if (taskID != null)
			{
				associateTaskToSchedule(ScheduleFK, taskID, i);
			}
			i++;
		}
	}

	/*
	 * Bidding calls
	 */

	public static Long getDefaultBid(int promotionID, String adEngine) throws Exception
	{
		String sql = "select aep.MicroDefaultBid from AdvertisingEnginePromotion aep  "
				+ "inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK "
				+ "where aep.PromotionFK = ? and ae.AdvertisingEngine = ?";

		Integer defBid;
		try
		{
			defBid = (Integer) jdbcTemplate.queryForObject(sql, new Object[]
			{ promotionID, adEngine }, Integer.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
		if (defBid != null)
		{
			return new Long(defBid);
		}
		else
		{
			return null;
		}

	}
	
	public static void storeDefaultBid(int promotionID, String adEngine, Long microDefaultBid) throws Exception
	{
		Integer microBid =  microDefaultBid.intValue();
		String sql = "update AdvertisingEnginePromotion set MicroDefaultBid = ?  " +
				"from AdvertisingEnginePromotion aep  " +
				"inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK " +
				"inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK " +
				"where aep.PromotionFK = ? and ae.AdvertisingEngine = ?";

		jdbcTemplate.update(sql, new Object[]
		{ microBid, promotionID, adEngine });

	}
	
	public static void UpdateDefaultBidForKeywords(int promotionID, String adEngine) throws Exception
	{
		UpdateDefaultBidForKeywordsSP updateDefBiAmounts = new UpdateDefaultBidForKeywordsSP();
		updateDefBiAmounts.execute(promotionID, adEngine);
	}

	public static void storeTargetedDailyBudget(int promotionID, String AdEngine, Long TargetedDailyMicroBudget, Integer TargetedDailyClicks)
			throws Exception
	{
		jdbcTemplate.update(
				"insert into TargetedDailyBudget(PromotionFK, AdvertisingEngineFK,TargetedDailyMicroBudget,TargetedDailyClicks,CreatedDate) "
						+ "select ?,a.AdvertisingEnginePK,?,?,CURRENT_TIMESTAMP from AdvertisingEngine a where a.AdvertisingEngine = ?", new Object[]
				{ promotionID, TargetedDailyMicroBudget, TargetedDailyClicks, AdEngine });

	}

	public static void storeTrafficEstimatorData(int promotionID, String AdEngine, TrafficEstimatorObject trafficEstimatorObj) throws Exception
	{
		AddTrafficEstimatorSP addTrafficEstSP = new AddTrafficEstimatorSP();
		HashMap<String, HashMap<String, HashMap<Long, BidData>>> trafficData = trafficEstimatorObj.getBidDataMap();
		// go through each keyword
		if (trafficData.keySet().isEmpty())
		{
			return;
		}
		Iterator<String> keywords = trafficData.keySet().iterator();
		while (keywords.hasNext())
		{
			String keyword = keywords.next();
			HashMap<String, HashMap<Long, BidData>> matchTypeMap = trafficData.get(keyword);
			// go through match types
			if (matchTypeMap != null && matchTypeMap.size() > 0)
			{
				Iterator<String> matchTypes = matchTypeMap.keySet().iterator();
				while (matchTypes.hasNext())
				{
					String matchType = matchTypes.next();
					// get the map of points
					HashMap<Long, BidData> biddata = matchTypeMap.get(matchType);
					if (biddata != null && biddata.size() > 0)
					{
						Iterator<Long> microbids = biddata.keySet().iterator();
						while (microbids.hasNext())
						{
							Long microBid = microbids.next();
							// add the data to the DB
							addTrafficEstSP.execute(promotionID, keyword, AdEngine, matchType, microBid,
									trafficEstimatorObj.getAveTotalDailyMicroCost(keyword, matchType, microBid),
									trafficEstimatorObj.getAveClickPerDay(keyword, matchType, microBid),
									trafficEstimatorObj.getAvePosition(keyword, matchType, microBid),
									trafficEstimatorObj.getAveCPC(keyword, matchType, microBid));
						}
					}
				}
			}
		}
	}

	public static void storeKeywordDataObjects(int promotionID, String AdEngine, ArrayList<KeywordDataObject> keywordDataObjectList) throws Exception
	{
		AddKeywordBidDataSP addKeywordBidDataSP = new AddKeywordBidDataSP();
		if (keywordDataObjectList != null && keywordDataObjectList.size() > 0)
		{
			for (int i = 0; i < keywordDataObjectList.size(); i++)
			{
				KeywordDataObject kdObj = keywordDataObjectList.get(i);
				
				Integer firstpgcpc = null;
				if (kdObj.getFirstPageCpc() != null)
				{
					firstpgcpc = kdObj.getFirstPageCpc().intValue();
				}
				logger.debug(promotionID + ":" + kdObj.getKeyword() + ":" + AdEngine  + ":" + kdObj.getMatchType()  + ":" + kdObj.getQualityScore()  + ":" +
						kdObj.getApprovalStatus() + ":" + firstpgcpc + ":" + kdObj.isIsEligibleForShowing());
				//int PromotionID, String Keyword, String AdvertisingEngine, String BidType, Integer QualityScore, String ApprovalStatus, Integer FirstPageMicroCpc, Boolean IsEligibleForShowing
				Integer res = addKeywordBidDataSP.execute(promotionID, kdObj.getKeyword(), AdEngine, kdObj.getMatchType(), kdObj.getQualityScore(),
						kdObj.getApprovalStatus(), firstpgcpc, kdObj.isIsEligibleForShowing());
				if (res == null || res == 0)
				{
					logger.warn("KeywordBidData not stored for " + kdObj.getKeyword() + ":" + kdObj.getMatchType());
				}
					
			}
		}
	}

	private static final RowMapper<BidElement> bidElementMapper = new BeanPropertyRowMapper<BidElement>(BidElement.class);

	public static List<BidElement> getLatestBids(int promotionID, String searchEngine) throws Exception
	{
		String strSQL = "select kb.KeywordAdEngineID, k.Keyword,kb.MicroBidAmount,bt.BidType [matchType],kb.CompetitionType, kb.StartDate, kb.EndDate, " 
				+ " kb.isActive, kb.isDefaultValue from Promotion p  "
				+ "inner join KeywordBid kb on kb.PromotionFK = p.PromotionPK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
				+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK " 
				+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
				+ "where p.PromotionPK = ? and kb.MicroBidAmount != -1 and ae.AdvertisingEngine = ? and kb.IsActive = 1";
		try
		{
			return jdbcTemplate.query(strSQL, new Object[]
			{ promotionID, searchEngine }, bidElementMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static HashMap<String, ArrayList<BidElement>> getAllBids(int promotionID, String searchEngine, Date startDate, Date endDate)
			throws Exception
	{

		try
		{
			String strSQL = null;
			java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
			if (endDate == null)
			{
				strSQL = "select kb.KeywordAdEngineID, k.Keyword, kb.MicroBidAmount, bt.BidType, kb.CompetitionType,kb.StartDate, kb.EndDate, kb.IsDefaultValue, kb.IsActive from KeywordBid kb "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
						+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
						+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
						+ "where kb.PromotionFK = ?  and kb.MicroBidAmount != -1 and ae.AdvertisingEngine = ? and kb.StartDate >= ? "
						+ "order by k.Keyword";
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, searchEngine, startDateSQL }, new AllBidRSExtactor());
			}
			else
			{
				java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
				strSQL = "select kb.KeywordAdEngineID, k.Keyword, kb.MicroBidAmount, bt.BidType, kb.CompetitionType,kb.StartDate, kb.EndDate, kb.IsDefaultValue, kb.IsActive from KeywordBid kb "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
						+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
						+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
						+ "where kb.PromotionFK = ? and kb.MicroBidAmount != -1 and ae.AdvertisingEngine = ? and (kb.StartDate >= ? and kb.EndDate <= ?)"
						+ "order by k.Keyword";
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, searchEngine, startDateSQL, endDateSQL }, new AllBidRSExtactor());
			}
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}

	}

	

	/*
	 * This get the last created KeywordBid Data for all keywords associated
	 * with campaign
	 */
	public static List<KeywordDataObject> getLatestBiddableAdGroupCriteria(Integer promotionID, String advertisingEngine) throws Exception
	{
		if (!AdEngine.existsAdEngine(advertisingEngine))
		{
			throw new Exception(advertisingEngine + " Not Found");
		}
		
	
		GetBiddableAdGroupCriteriaSP getLatestBiddableAdGroupCriteria = new GetBiddableAdGroupCriteriaSP();
		return getLatestBiddableAdGroupCriteria.execute(promotionID, advertisingEngine);
		
	}

	public static HashMap<String, ArrayList<KeywordDataObject>> getAllBiddableAdGroupCriteria(Integer promotionID, String adEngine, Date startDate,
			Date endDate) throws Exception
	{
		String strSQL= null;
		if (endDate == null)
		{
			strSQL = "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,mkbd.ApprovalStatus, bt.BidType ,mkbd.FirstPageMicroCPC, " +
					"mkbd.QualityScore,mkbd.IsEligibleForShowing, pka.IsNegative,mkbd.CreatedDate from Keyword k inner join KeywordBid kb on k.KeywordPK = kb.KeywordFK " +
					"inner join BidType bt on bt.BidTypePK = kb.BidTypeFK inner join Promotion p on p.PromotionPK = kb.PromotionFK " +
					"inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.KeywordFK " +
					"inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK " +
					"left join  (select kbd.KeywordBidFK,kbd.ApprovalStatus ,kbd.FirstPageMicroCPC,kbd.QualityScore,kbd.IsEligibleForShowing,kbd.CreatedDate from KeywordBidData kbd " +
					"inner join KeywordBid kb on kb.KeywordBidPK = kbd.KeywordBidFK " +
					"inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK " +
					"where kb.PromotionFK = ? and ae.AdvertisingEngine = ? and kb.IsActive = 1 and kbd.CreatedDate >= ?) mkbd " +
					"on mkbd.KeywordBidFK = kb.KeywordBidPK " +
					"where kb.PromotionFK = ? and kb.IsActive = 1 and ae.AdvertisingEngine = ?";
			

			try
			{
				return jdbcTemplate.query(strSQL, new Object[]
					{ promotionID, adEngine,startDate,  promotionID, adEngine }, new AllBiddableRSExtractor());
			}
			catch (EmptyResultDataAccessException e)
			{
				return null;
			}
			catch (Exception e)
			{
				throw e;
			}
		}
		else
		{
			strSQL = "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,mkbd.ApprovalStatus, bt.BidType ,mkbd.FirstPageMicroCPC, " +
					"mkbd.QualityScore,mkbd.IsEligibleForShowing, pka.IsNegative,mkbd.CreatedDate from Keyword k inner join KeywordBid kb on k.KeywordPK = kb.KeywordFK " +
					"inner join BidType bt on bt.BidTypePK = kb.BidTypeFK inner join Promotion p on p.PromotionPK = kb.PromotionFK " +
					"inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.KeywordFK " +
					"inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK " +
					"left join  (select kbd.KeywordBidFK,kbd.ApprovalStatus ,kbd.FirstPageMicroCPC,kbd.QualityScore,kbd.IsEligibleForShowing,kbd.CreatedDate from KeywordBidData kbd " +
					"inner join KeywordBid kb on kb.KeywordBidPK = kbd.KeywordBidFK " +
					"inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK " +
					"where kb.PromotionFK = ? and ae.AdvertisingEngine = ? and kb.IsActive = 1 and kbd.CreatedDate >= ? and kbd.CreatedDate <= ?) mkbd " +
					"on mkbd.KeywordBidFK = kb.KeywordBidPK " +
					"where kb.PromotionFK = ? and kb.IsActive = 1 and ae.AdvertisingEngine = ?";
			try
			{
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine, startDate, endDate, promotionID, adEngine }, new AllBiddableRSExtractor());
			}
			catch (EmptyResultDataAccessException e)
			{
				return null;
			}
			catch (Exception e)
			{
				throw e;
			}
		}
	}

	

	/*
	 * This get the last created Traffic Estimator Data for one keyword
	 * associated with campaign
	 */
	public static List<TrafficEstimatorDataObject> getLatestTrafficEstimatorForKeyword(Integer promotionID, String keyword, String advertisingEngine)
			throws Exception
	{
		if (!AdEngine.existsAdEngine(advertisingEngine))
		{
			throw new Exception(advertisingEngine + " Not Found");
		}
		GetLatestTrafficEstimatorSP trafficEst = new GetLatestTrafficEstimatorSP();
		return trafficEst.execute(promotionID, keyword, advertisingEngine);
	}
	
	public static List<TrafficEstimatorDataObject> getLatestTrafficEstimator(Integer promotionID, String advertisingEngine)
			throws Exception
	{
		if (!AdEngine.existsAdEngine(advertisingEngine))
		{
			throw new Exception(advertisingEngine + " Not Found");
		}
		GetLatestTrafficEstimatorSP trafficEst = new GetLatestTrafficEstimatorSP();
		return trafficEst.execute(promotionID, null, advertisingEngine);
	}

	/*
	 * public static List<TrafficEstimatorDataObject>
	 * getAllTrafficEstimatorForKeyword(Integer promotionID, String keyword,
	 * String adEngine, Date startDate, Date endDate ) { String strSQL = null;
	 * java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime()); if
	 * (endDate == null) { strSQL =
	 * "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,te.MicroBid, te.AveMicroCost, te.AveNumberClicks, te.AvePosition,te.AveCPC ,b.BidType,p.IsNegative, te.CreatedDate  "
	 * + "from KeywordBid kb  " +
	 * "inner join PromotionKeywordAssociation pka on pka.PromotionFK = kb.PromotionFK "
	 * +
	 * "inner join Keyword k on k.KeywordPK = pka.KeywordFK inner join PromotionKeywordAssociation p on p.KeywordFK = k.KeywordPK "
	 * + "inner join BidType b on b.BidTypePK = kb.BidTypeFK  " +
	 * "inner join TrafficEstimator te on te.KeywordBidFK = kb.KeywordBidPK " +
	 * "inner join AdvertisingEngine a on a.AdvertisingEnginePK = kb.AdvertisingEngineFK "
	 * +
	 * "where pka.PromotionFK = ?  and k.Keyword = ? and a.AdvertisingEngine = ? and te.CreatedDate >= ? "
	 * ;
	 * 
	 * return jdbcTemplate.query(strSQL, new Object[] { promotionID, keyword,
	 * adEngine, startDateSQL },trafficEstDataObjMapper); } else { java.sql.Date
	 * endDateSQL = new java.sql.Date(endDate.getTime()); strSQL =
	 * "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,te.MicroBid, te.AveMicroCost, te.AveNumberClicks, te.AvePosition,te.AveCPC ,b.BidType,p.IsNegative, te.CreatedDate  "
	 * + "from KeywordBid kb  " +
	 * "inner join PromotionKeywordAssociation pka on pka.PromotionFK = kb.PromotionFK "
	 * +
	 * "inner join Keyword k on k.KeywordPK = pka.KeywordFK inner join PromotionKeywordAssociation p on p.KeywordFK = k.KeywordPK "
	 * + "inner join BidType b on b.BidTypePK = kb.BidTypeFK  " +
	 * "inner join TrafficEstimator te on te.KeywordBidFK = kb.KeywordBidPK " +
	 * "inner join AdvertisingEngine a on a.AdvertisingEnginePK = kb.AdvertisingEngineFK "
	 * +
	 * "where pka.PromotionFK = ?  and k.Keyword = ? and a.AdvertisingEngine = ? and te.CreatedDate >= ? and te.CreatedDate <= ?"
	 * ; return jdbcTemplate.query(strSQL, new Object[] { promotionID, keyword,
	 * adEngine, startDateSQL, endDateSQL }, trafficEstDataObjMapper); } }
	 */
	private static final RowMapper<BudgetObject> BudgetObjMapper = new BeanPropertyRowMapper<BudgetObject>(BudgetObject.class);

	public static BudgetObject getBudget(int promotionID) throws Exception
	{

		String strSQL = "select p.RemainingBudgetInCycle, DATEDIFF(dd,CURRENT_TIMESTAMP, p.CycleEndDate) [RemainingDays] from Promotion p where PromotionPK = ?";
		try
		{
			return jdbcTemplate.queryForObject(strSQL, new Object[]
			{ promotionID }, BudgetObjMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			logger.error("getBudget " + e.getMessage());
			return null;
		}
		catch (Exception e)
		{
			logger.error("getBudget " + e.getMessage());
			throw e;
		}
	}

	public static void storeBidObjects(int promotionID, String advertisingEngine, ArrayList<BidElement> bidObjects) throws Exception
	{
		if (!AdEngine.existsAdEngine(advertisingEngine))
		{
			throw new Exception(advertisingEngine + " Not Found");
		}
		if (bidObjects != null && bidObjects.size() > 0)
		{
			AddBidSP addBid = new AddBidSP();
			for (BidElement bid : bidObjects)
			{
				try
				{
					addBid.execute(promotionID, bid.getKeywordAdEngineID(), bid.getKeyword(), bid.getMicroBidAmount(), bid.getMatchType(),
							advertisingEngine, bid.getIsNegative());
					logger.info("Added Keyword " + bid.getKeyword() + " MicroBid " + bid.getMicroBidAmount());
				}
				catch (Exception e)
				{
					logger.error("Strore Bid Object Error " + bid.getKeyword() + ":" + e.getMessage());
					e.printStackTrace();
					throw e;
				}
			}
		}
	}

	/*
	 * Report calls
	 */

	public static void storeAdvertisingEngineReportData(Integer promotionID, String adEngine, ReportObject[] reportObjList) throws Exception
	{
		AddReportDataSP setReportSP = new AddReportDataSP();
		for (int i=0; i < reportObjList.length; i++)
		{
			ReportObject rptObj = reportObjList[i];
			//Integer PromotionID, String Keyword,String AdvertisingEngine, Date TransactionDate, Integer MicroBidAmount, 
			//Integer NumberImpressions, Integer NumberClick, Float AveragePosition, Long AverageCPC,String BidType, Integer QualityScore, String ApprovalStatus,
			//Integer FirstPageMicroCpc, Integer MicroCost
			Integer id = setReportSP.execute(promotionID, rptObj.getKeyword(),adEngine, rptObj.getTransactionDate(), 
					rptObj.getMicroBidAmount().intValue(),  rptObj.getNumberImpressions(), rptObj.getNumberClick(), rptObj.getAveragePosition(), rptObj.getAverageCPC(),rptObj.getBidMatchType(), 
					rptObj.getQualityScore(), rptObj.getApprovalStatus(), rptObj.getFirstPageCPC().intValue(),
					rptObj.getMicroCost().intValue());
			if (id == 0)
			{
				logger.info(rptObj.getKeyword() + " already inserted");
			}
			else
			{
				logger.info(rptObj.getKeyword() + " inserted ID = " + id);
			}
		}
	}

	private static final RowMapper<ReportObject> reportObjectjMapper = new BeanPropertyRowMapper<ReportObject>(ReportObject.class);

	public static List<ReportObject> getReportData(int promotionID, String adEngine, java.util.Date startDate, java.util.Date endDate)
			throws Exception
	{

		if (!AdEngine.existsAdEngine(adEngine))
		{
			throw new Exception(adEngine + " Not Found");
		}
		String strSQL = null;
		try
		{
			java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
			if (endDate == null)
			{
				strSQL = "select aep.AdvertisingEngineAccountFK [AccountID],aep.AdvertisingEngineCampaignPK [CampaignID],k.Keyword,aerd.TransactionDate,aerd.MicroBidAmount, "
						+ "bt.BidType,aerd.NumberImpressions, aerd.NumberClick,aerd.AveragePosition,aerd.AverageCPC,aerd.QualityScore,aerd.ApprovalStatus,aerd.FirstPageMicroCPC,aerd.CreatedDate,aerd.MicroCost  "
						+ "from AdvertisingEngineReportData aerd "
						+ "inner join KeywordBid kb on kb.KeywordBidPK = aerd.KeywordBidFK "
						+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
						+ "inner join Promotion p on p.PromotionPK = kb.PromotionFK "
						+ "inner join AdvertisingEnginePromotion aep on p.PromotionPK = aep.PromotionFK "
						+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
						+ "where p.PromotionPK = ? and ae.AdvertisingEngine = ? and aerd.CreatedDate >= ?";
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine, startDateSQL }, reportObjectjMapper);
			}
			else
			{
				java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
				strSQL = "select aep.AdvertisingEngineAccountFK [AccountID],aep.AdvertisingEngineCampaignPK [CampaignID],k.Keyword,aerd.TransactionDate,aerd.MicroBidAmount, "
						+ "bt.BidType,aerd.NumberImpressions, aerd.NumberClick,aerd.AveragePosition,aerd.AverageCPC,aerd.QualityScore,aerd.ApprovalStatus,aerd.FirstPageMicroCPC,aerd.CreatedDate,aerd.MicroCost  "
						+ "from AdvertisingEngineReportData aerd "
						+ "inner join KeywordBid kb on kb.KeywordBidPK = aerd.KeywordBidFK "
						+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
						+ "inner join Promotion p on p.PromotionPK = kb.PromotionFK "
						+ "inner join AdvertisingEnginePromotion aep on p.PromotionPK = aep.PromotionFK "
						+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
						+ "where p.PromotionPK = ? and ae.AdvertisingEngine = ? and aerd.CreatedDate >= ? and aerd.CreatedDate <= ?";
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine, startDateSQL, endDateSQL }, reportObjectjMapper);
			}
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	private static final RowMapper<TargetedDailyBudget> targetedDailyBudgetMapper = new BeanPropertyRowMapper<TargetedDailyBudget>(TargetedDailyBudget.class);

	public static TargetedDailyBudget getLatestTargetedDailyBudget(int promotionID, String adEngine) throws Exception
	{

		if (!AdEngine.existsAdEngine(adEngine))
		{
			throw new Exception(adEngine + " Not Found");
		}
		String strSQL = "select top 1 tdb.TargetedDailyMicroBudget, tdb.TargetedDailyClicks,tdb.CreatedDate from TargetedDailyBudget tdb "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = tdb.AdvertisingEngineFK "
				+ "where tdb.PromotionFK = ? and ae.AdvertisingEngine = ? order by tdb.CreatedDate DESC";

		try
		{
			return jdbcTemplate.queryForObject(strSQL, new Object[]
			{ promotionID, adEngine }, targetedDailyBudgetMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static List<TargetedDailyBudget> getAllTargetedDailyBudget(int promotionID, String adEngine, java.util.Date startDate,
			java.util.Date endDate) throws Exception
	{

		if (!AdEngine.existsAdEngine(adEngine))
		{
			throw new Exception(adEngine + " Not Found");
		}
		String strSQL = null;
		try
		{
			java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
			if (endDate == null)
			{
				strSQL = "select tdb.TargetedDailyMicroBudget, tdb.TargetedDailyClicks,tdb.CreatedDate from TargetedDailyBudget tdb "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = tdb.AdvertisingEngineFK "
						+ "where tdb.PromotionFK = ? and ae.AdvertisingEngine = ? and tdb.CreatedDate >= ?";

				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine, startDateSQL }, targetedDailyBudgetMapper);
			}
			else
			{
				java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
				strSQL = "select tdb.TargetedDailyMicroBudget, tdb.TargetedDailyClicks,tdb.CreatedDate from TargetedDailyBudget tdb "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = tdb.AdvertisingEngineFK "
						+ "where tdb.PromotionFK = ? and ae.AdvertisingEngine = ? and tdb.CreatedDate >= ? and tdb.CreatedDate <= ?";

				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine, startDateSQL, endDateSQL }, targetedDailyBudgetMapper);
			}
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/*
	 * Account calls
	 */
	private static final RowMapper<AdEngineID> adEngineObjMapper = new BeanPropertyRowMapper<AdEngineID>(AdEngineID.class);

	public static AdEngineID getAdEngineID(Integer promotionID, String adEngine) throws Exception
	{
		String strSQL = "select aec.AdvertisingEngineAccountPK [AccountID], aep.AdvertisingEngineCampaignPK [CampaignID], aep.AdvertisingEngineAdGroupID [AdGroupID] from Customer c "
				+ "inner join AdvertisingEngineAccount aec on aec.CustomerFK = c.CustomerPK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aec.AdvertisingEngineFK "
				+ "inner join AdvertisingEnginePromotion aep on aec.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join Promotion p on aep.PromotionFK = p.PromotionPK where p.PromotionPK = ? and ae.AdvertisingEngine = ?";
		try
		{
			return jdbcTemplate.queryForObject(strSQL, new Object[]
			{ promotionID, adEngine }, adEngineObjMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	private static final RowMapper<AdvertisingEnginePromotionObj> advertisingEnginePromotionObjMapper = new BeanPropertyRowMapper<AdvertisingEnginePromotionObj>(AdvertisingEnginePromotionObj.class);

	public static List<AdvertisingEnginePromotionObj> getAdvertisingEnginePromotion(Long advertisingEngineAccountID) throws Exception
	{
		String strSQL = "Select ap.AdvertisingEngineAccountFK [AdvertisingEngineAccountID],ap.AdvertisingEngineCampaignPK [AdvertisingEngineCampaignID],"
				+ "ap.PromotionFK [PromotionID], ap.IsSearchNetwork,ap.IsDisplayNetwork,ap.MicroDefaultBid,ap.AdvertisingEngineAdGroupID "
				+ "from AdvertisingEnginePromotion ap where ap.AdvertisingEngineAccountFK = ?";
		try
		{
			return jdbcTemplate.query(strSQL, new Object[]
			{ advertisingEngineAccountID }, advertisingEnginePromotionObjMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	/*
	 * Get campaign for a given 
	 */
	public static AdvertisingEnginePromotionObj getAdvertisingEngineCampaign(Long advertisingEngineAccountID, int promotionID) throws Exception
	{
		String strSQL = "select aep.AdvertisingEngineAccountFK [AdvertisingEngineAccountID], aep.AdvertisingEngineCampaignPK [AdvertisingEngineCampaignID], " +
				"p.PromotionPK [PromotionID], aep.IsSearchNetwork, aep.IsDisplayNetwork, aep.MicroDefaultBid, aep.AdvertisingEngineAdGroupID from AdvertisingEnginePromotion aep " +
				"inner join Promotion p on p.PromotionPK = aep.PromotionFK " +
				"inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK " +
				"where aea.AdvertisingEngineAccountPK = ? and p.PromotionPK = ?";
		try
		{
			return jdbcTemplate.queryForObject(strSQL, new Object[]
			{ advertisingEngineAccountID, promotionID }, advertisingEnginePromotionObjMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	/*
	 * return Hashmap - Keys: AccountID, CustomerName
	 */
	public static List<Map<String, Object>> getAdEngineAccount(int customerID, String adEngine) throws Exception
	{
		String strSQL = "select a.AdvertisingEngineAccountPK [AccountID], c.Name [CustomerName] from Customer c "
				+ "left join AdvertisingEngineAccount a on c.CustomerPK = a.CustomerFK "
				+ "left join AdvertisingEngine ae on ae.AdvertisingEnginePK = a.AdvertisingEngineFK "
				+ "where c.CustomerPK = ? and (ae.AdvertisingEngine is null or ae.AdvertisingEngine = ?)";

		try
		{
			return jdbcTemplate.queryForList(strSQL, new Object[]{customerID, adEngine});
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}

	}

	public static Integer addAdEngineAccountID(int customerID, Long accountID, String adEngine) throws Exception
	{
		String strSQL = "insert into AdvertisingEngineAccount(AdvertisingEngineAccountPK,AdvertisingEngineFK,CustomerFK) "
				+ "select ? ,ae.AdvertisingEnginePK, ? from AdvertisingEngine ae where ae.AdvertisingEngine = ?";

		try
		{
			return jdbcTemplate.update(strSQL, new Object[]
			{ accountID, customerID, adEngine });
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}

	}

	public static Integer addPromotionToAdEngineAccountID(int promotionID, Long adEngineAccountID, Long adEngineCampaignID, Long advertisingEngineAdGroupID) throws Exception
	{
		String strSQL = "insert into AdvertisingEnginePromotion(AdvertisingEngineCampaignPK,PromotionFK,AdvertisingEngineAccountFK,IsSearchNetwork,IsDisplayNetwork,AdvertisingEngineBudget, AdvertisingEngineAdGroupID) "
				+ "VALUES (?,?,?,?,?,?,?)";

		return jdbcTemplate.update(strSQL, new Object[]
		{ adEngineCampaignID, promotionID, adEngineAccountID, 1, 0, 0.0, advertisingEngineAdGroupID });

	}

	public static Integer setAdvertisingEngineAdGroupID(Long adEngineCampaignID,Long advertisingEngineAdGroupID) throws Exception
	{
		String strSQL = "update AdvertisingEnginePromotion set AdvertisingEngineAdGroupID = ? " +
				"from AdvertisingEnginePromotion aep where aep.AdvertisingEngineCampaignPK = ?";

		return jdbcTemplate.update(strSQL, new Object[]
		{ advertisingEngineAdGroupID, adEngineCampaignID });

	}
	
	public static Integer setAdIDForAdGroup(Long advertisingEngineAdPK, String advertisingEngine, Integer promotionAdsFK) throws Exception
	{		
		return jdbcTemplate.update(SQL_SET_AD_ID_FOR_AD_GROUP, new Object[]{advertisingEngineAdPK, promotionAdsFK, advertisingEngine});
	}
	
	public static Map<Long, Integer> getDeletedAdIdRowCountMap(final List<Long> deletedAdIds, int[] rowCounts)
	{
		final Map<Long, Integer> deletedAdIdRowCountMap = new HashMap<Long, Integer>();
		for (int i = 0; i < rowCounts.length; ++i)
		{
			final int rowCount = rowCounts[i];
			final Long deletedAdId = deletedAdIds.get(i);
			deletedAdIdRowCountMap.put(deletedAdId, rowCount);
		}
		return deletedAdIdRowCountMap;
	}
	
	public static Map<Entry<GoogleUpdateAdRequest, Long>, Integer> getOldNewAdIdRowCountMap(final List<Entry<GoogleUpdateAdRequest, Long>> updateRequestToNewAdIdList, int[] rowCounts)
	{
		final Map<Entry<GoogleUpdateAdRequest, Long>, Integer> idPairMap = new HashMap<Entry<GoogleUpdateAdRequest, Long>, Integer>();
		for (int i = 0; i < rowCounts.length; ++i)
		{
			final int rowCount = rowCounts[i];
			final Entry<GoogleUpdateAdRequest, Long> updateRequestNewIdPair = updateRequestToNewAdIdList.get(i);
			idPairMap.put(updateRequestNewIdPair, rowCount);
		}
		return idPairMap;
	}
	
	public static Map<GoogleAdIdSemplestAdIdPair, Integer> getIdPairRowCountMap(final List<GoogleAdIdSemplestAdIdPair> idPairs, int[] rowCounts)
	{
		final Map<GoogleAdIdSemplestAdIdPair, Integer> idPairRowCountMap = new HashMap<GoogleAdIdSemplestAdIdPair, Integer>();
		for (int i = 0; i < rowCounts.length; ++i)
		{
			final int rowCount = rowCounts[i];
			final GoogleAdIdSemplestAdIdPair idPair = idPairs.get(i);
			idPairRowCountMap.put(idPair, rowCount);
		}
		return idPairRowCountMap;
	}
	
	public static Map<GoogleAdIdSemplestAdIdPair, Integer> setAdIDForAdGroupBulk(final List<GoogleAdIdSemplestAdIdPair> idPairs, final String advertisingEngine) throws Exception
	{	
		final int[] rowCounts =  jdbcTemplate.batchUpdate(SQL_SET_AD_ID_FOR_AD_GROUP,
 											             new BatchPreparedStatementSetter() 
														 {
											              	public void setValues(PreparedStatement ps, int i) throws SQLException 
											              	{
												                ps.setLong(1, idPairs.get(i).getGoogleAdId());
												                ps.setInt(2, idPairs.get(i).getSemplestAdId());
												                ps.setString(3, advertisingEngine);
											              	}	
											              
											              	public int getBatchSize() 
											              	{
											              		return idPairs.size();
											              	}
											             });
		return getIdPairRowCountMap(idPairs, rowCounts);
	}
	
	public static Map<Entry<GoogleUpdateAdRequest, Long>, Integer> updateAdIDForAdGroupBulk(final Map<GoogleUpdateAdRequest, Long> oldToNewAdIdMap, final String advertisingEngine) throws Exception
	{
		final Set<Entry<GoogleUpdateAdRequest, Long>> entries = oldToNewAdIdMap.entrySet();
		final List<Entry<GoogleUpdateAdRequest, Long>> entryList = new ArrayList<Entry<GoogleUpdateAdRequest, Long>>(entries);
		final int[] rowCounts =  jdbcTemplate.batchUpdate(SQL_UPDATE_AD_ENGINE_AD_ID,
 											             new BatchPreparedStatementSetter() 
														 {
											              	public void setValues(PreparedStatement ps, int i) throws SQLException 
											              	{
											              		final Entry<GoogleUpdateAdRequest, Long> entry = entryList.get(i);
											              		final GoogleUpdateAdRequest updateRequest = entry.getKey();											              		
											              		final Long newAdID = entry.getValue();	
											              		final Integer promotionAdId = updateRequest.getPromotionAdID();
											              		final Long oldAdID = updateRequest.getAdId();
												                ps.setLong(1, newAdID);
												                ps.setInt(2, promotionAdId);
												                ps.setLong(3, oldAdID);
												                ps.setString(4, advertisingEngine);
											              	}	
											              
											              	public int getBatchSize() 
											              	{
											              		return oldToNewAdIdMap.size();
											              	}
											             });
		return getOldNewAdIdRowCountMap(entryList, rowCounts);
	}
	
	public static Integer updateAdIDForAdGroup(Long newAdvertisingEngineAdPK, Long oldAdvertisingEngineAdPK, String advertisingEngine, Integer promotionAdsFK) throws Exception
	{
		final String strSQL = "update   AdvertisingEngineAds " + 	
								 "set	AdvertisingEngineAdPK = ? " +  	
							    "from	AdvertisingEngineAds aea, " +  
							  		   "AdvertisingEngine e " + 
							   "where	aea.PromotionAdsFK = ? " + 
							     "and 	aea.AdvertisingEngineAdPK = ? " + 
							  	 "and	aea.AdvertisingEngineFK = e.AdvertisingEnginePK " + 
							  	 "and 	e.AdvertisingEngine = ?";
		return jdbcTemplate.update(strSQL, new Object[]{newAdvertisingEngineAdPK, promotionAdsFK, oldAdvertisingEngineAdPK, advertisingEngine});
	}
	
	public static Integer deleteAdIDForAdGroup(Long advertisingEngineAdPK, String advertisingEngine, Integer promotionAdsFK) throws Exception
	{
		final String strSQL = "delete  	AdvertisingEngineAds " + 	
							    "from	AdvertisingEngineAds aea, " +  
							  		   "AdvertisingEngine e " + 
							   "where	aea.PromotionAdsFK = ? " + 
							     "and 	aea.AdvertisingEngineAdPK = ? " + 
							  	 "and	aea.AdvertisingEngineFK = e.AdvertisingEnginePK " + 
							  	 "and 	e.AdvertisingEngine = ?";
		return jdbcTemplate.update(strSQL, new Object[]{promotionAdsFK, advertisingEngineAdPK, advertisingEngine});
	}
	
	public static Map<Long, Integer> markPromotionAdDeletedBulk(final java.util.Date date, final List<Long> deletedAdIds) throws Exception
	{	
		final int[] rowCounts =  jdbcTemplate.batchUpdate(SQL_MARK_AD_DELETED,
 											             new BatchPreparedStatementSetter() 
														 {
											              	public void setValues(PreparedStatement ps, int i) throws SQLException 
											              	{
												                ps.setTimestamp(1, new Timestamp(date.getTime()));
												                ps.setLong(2, deletedAdIds.get(i));
											              	}	
											              
											              	public int getBatchSize() 
											              	{
											              		return deletedAdIds.size();
											              	}
											             });
		return getDeletedAdIdRowCountMap(deletedAdIds, rowCounts);
	}
	
	public static Integer markPromotionAdDeleted(Integer promotionAdsPK, java.util.Date deletedDate) throws Exception
	{
		final String strSQL = "update   PromotionAds " + 
								 "set   IsDeleted = 1,  " + 
									   "DeletedDate = ?  " + 
								"where	PromotionAdsPK = ?";
		return jdbcTemplate.update(strSQL, new Object[]{deletedDate, promotionAdsPK});
	}
	
	public static Integer updatePromotionToAdEngineAccountID(Long adEngineCampaignID, boolean IsSearchNetwork, boolean IsDisplayNetwork,
			Double AdvertisingEngineBudget) throws Exception
	{
		String strSQL = "update AdvertisingEnginePromotion set IsSearchNetwork = ?, IsDisplayNetwork = ?,AdvertisingEngineBudget = ? where AdvertisingEngineCampaignPK = ?";

		return jdbcTemplate.update(strSQL, new Object[]{ IsSearchNetwork, IsDisplayNetwork, AdvertisingEngineBudget, adEngineCampaignID });

	}
	
	public static void logError(Exception e, String errorSource){		
		
		try
		{
		StackTraceElement[] ste = e.getStackTrace();
		StackTraceElement err = ste[ste.length-1];		
		String errorClass = err.getClassName();
		StringBuilder sb = new StringBuilder();
			if(ste.length > 5){
				//if the nested error is too long, record only the first 5 and the last one
				for(int i = 0; i < 5; i++){
					sb.append(ste[i].getFileName() + ":" + ste[i].getLineNumber() + "; ");					
				}
				sb.append("... ");
				sb.append(ste[ste.length-1].getFileName() + ":" + ste[ste.length-1].getLineNumber() + ";");
			}
			else{
		for(StackTraceElement s : ste){
			sb.append(s.getFileName() + ":" + s.getLineNumber() + "; "); 
		}
			}
			String errDetails = sb.toString();
		
		String sql = "INSERT Error(ErrorSource,ErrorClass,ErrorMessage,ErrorDetails,CreatedDate) " +
				"VALUES (?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, new Object[]
					{errorSource, errorClass, e.getMessage(), errDetails, new java.util.Date()});
		}
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error("logError: " + e.getMessage() , e1);
		}
	}

}
