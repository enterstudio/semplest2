package semplest.server.service.springjdbc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.batch.retry.RetryCallback;
import org.springframework.batch.retry.RetryContext;
import org.springframework.batch.retry.policy.SimpleRetryPolicy;
import org.springframework.batch.retry.support.RetryTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.protocol.CustomOperation;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.PromotionBiddingType;
import semplest.server.protocol.ProtocolEnum.ScheduleFrequency;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.PromotionStatus;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.SemplestBiddingHistory;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.server.protocol.adengine.TrafficEstimatorDataObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject.BidData;
import semplest.server.protocol.bidding.BiddingParameters;
import semplest.server.protocol.google.GoogleAdIdSemplestAdIdPair;
import semplest.server.protocol.google.UpdateAdRequest;
import semplest.server.service.springjdbc.helper.AllBidRSExtactor;
import semplest.server.service.springjdbc.helper.AllBiddableRSExtractor;
import semplest.server.service.springjdbc.helper.ScheduleTaskRowMapper;
import semplest.server.service.springjdbc.storedproc.AddAdvertisingEngineAccountSP;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.AddKeywordBidDataSP;
import semplest.server.service.springjdbc.storedproc.AddReportDataSP;
import semplest.server.service.springjdbc.storedproc.AddScheduleSP;
import semplest.server.service.springjdbc.storedproc.AddTaskSP;
import semplest.server.service.springjdbc.storedproc.GetBiddableAdGroupCriteriaSP;
import semplest.server.service.springjdbc.storedproc.GetLatestTrafficEstimatorSP;
import semplest.server.service.springjdbc.storedproc.SetPromotionBiddingSP;
import semplest.server.service.springjdbc.storedproc.UpdateDefaultBidForKeywordsSP;
import semplest.util.SemplestUtils;

public class SemplestDB extends BaseDB
{
	private static final Logger logger = Logger.getLogger(SemplestDB.class);

	public static final String SQL_SET_AD_ID_FOR_AD_GROUP = "insert into AdvertisingEngineAds(AdvertisingEngineAdPK, AdvertisingEngineFK, PromotionAdsFK) "
			+ "select ?, ae.AdvertisingEnginePK, ? from AdvertisingEngine ae where ae.AdvertisingEngine = ?";

	public static final String SQL_MARK_AD_DELETED = "update  PromotionAds " + "set  IsDeleted = 1, " + "DeletedDate = ? " + "from  PromotionAds p, "
			+ "AdvertisingEngineAds a " + "where  p.PromotionAdsPK = a.PromotionAdsFK " + "and  a.AdvertisingEngineAdPK = ?";

	public static final String SQL_UPDATE_AD_ENGINE_AD_ID = "update AdvertisingEngineAds " + "set AdvertisingEngineAdPK = ? "
			+ "from AdvertisingEngineAds aea, " + "AdvertisingEngine e " + "where	  aea.PromotionAdsFK = ? "
			+ "and aea.AdvertisingEngineAdPK = ? and aea.AdvertisingEngineFK = e.AdvertisingEnginePK and e.AdvertisingEngine = ?";

	public static final String SQL_DELETE_AD_ENGINE_AD_ID = "delete   AdvertisingEngineAds " + "from	  AdvertisingEngineAds aea, "
			+ "AdvertisingEngine e " + "where	  aea.PromotionAdsFK = ? " + "and	  aea.AdvertisingEngineFK = e.AdvertisingEnginePK "
			+ "and   e.AdvertisingEngine = ?";

	public static final String SQL_MARK_KEYWORD_DELETED = "update PromotionKeywordAssociation " + "set IsDeleted = 1, " + "Comment = ? "
			+ "where KeywordFK = ?" + "  and PromotionFK = ?";

	public static <T> T executeRetryOnDeadlock(final CustomOperation<T> customOperation, final int maxNumRetries) throws Exception
	{
		final SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		final List<Class<? extends Throwable>> retryableExceptionClasses = new ArrayList<Class<? extends Throwable>>();
		retryableExceptionClasses.add(org.springframework.dao.DeadlockLoserDataAccessException.class);
		final RetryTemplate template = new RetryTemplate();
		retryPolicy.setRetryableExceptionClasses(retryableExceptionClasses);
		retryPolicy.setMaxAttempts(maxNumRetries);
		template.setRetryPolicy(retryPolicy);
		try
		{
			final T results = template.execute(new RetryCallback<T>()
			{
				public T doWithRetry(RetryContext context) throws Exception
				{
					logger.info("Attempt #" + context.getRetryCount() + 1);
					final T results = customOperation.performCustomOperation();
					return results;
				}
			});
			return results;
		}
		catch (Exception e)
		{
			throw new Exception("Problem performing operation even after max " + maxNumRetries + " retries", e);
		}
	}

	public static void testDeadlockHandling() throws Exception
	{
		/*
		 * final String sql1 = "begin tran " +
		 * "update TableA set name = 'krish' where id = 1 " +
		 * "waitfor delay '00:00:10' " +
		 * "update TableB set name = 'krishna' where id = 2 " + "commit";
		 */
		final String sql2 = "begin tran " + "update TableB set name = 'krishna' where id = 2 " + "waitfor delay '00:00:10' "
				+ "update TableA set name = 'krish' where id = 1 " + "commit";

		final int maxRetries = 4;
		final SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		final List<Class<? extends Throwable>> retryableExceptionClasses = new ArrayList<Class<? extends Throwable>>();
		retryableExceptionClasses.add(org.springframework.dao.DeadlockLoserDataAccessException.class);

		final RetryTemplate template = new RetryTemplate();
		retryPolicy.setRetryableExceptionClasses(retryableExceptionClasses);
		retryPolicy.setMaxAttempts(maxRetries);
		template.setRetryPolicy(retryPolicy);
		try
		{
			/*
			 * Run this manually in SQL Management Studio, then run this method,
			 * which would cause a deadlock
			 * 
			 * begin tran update TableA set name = 'krish' where id = 1 waitfor
			 * delay '00:00:10' update TableB set name = 'krishna' where id = 2
			 * commit
			 */
			template.execute(new RetryCallback<Object>()
			{
				public Object doWithRetry(RetryContext context) throws Exception
				{
					logger.info("Attempt #" + context.getRetryCount() + 1);
					/*
					 * final Thread t1 = new Thread(new Runnable() {public void
					 * run(){logger.info("Running thread 1");
					 * jdbcTemplate.execute(sql1);}}); final Thread t2 = new
					 * Thread(new Runnable() {public void
					 * run(){logger.info("Running thread 2");
					 * jdbcTemplate.execute(sql2);}}); t1.start(); t2.start();
					 */
					jdbcTemplate.execute(sql2);
					// throw new
					// DeadlockLoserDataAccessException("some error message",
					// new Exception("this is the cause"));
					return new Object();
				}
			});
		}
		catch (Exception e)
		{
			throw new Exception("Problem performing operations even after max " + maxRetries + " retries", e);
		}
	}

	public static void updatePromotionStatus(final Integer promotionID, final List<AdEngine> adEngines, final PromotionStatus promotionStatus)
	{
		for (final AdEngine adEngine : adEngines)
		{
			SemplestDB.updatePromotionStatus(promotionID, adEngine, promotionStatus);
		}
	}

	public static Map<AdEngine, PromotionStatus> getPromotionStatus(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		final Map<AdEngine, PromotionStatus> promotionStatusMap = new HashMap<AdEngine, PromotionStatus>();
		for (final AdEngine adEngine : adEngines)
		{
			final PromotionStatus promotionStatus = getPromotionStatus(promotionID, adEngine);
			promotionStatusMap.put(adEngine, promotionStatus);
		}
		return promotionStatusMap;
	}

	public static PromotionStatus getPromotionStatus(final Integer promotionID, final AdEngine adEngine) throws Exception
	{
		final Integer promotionStatusCode = executeRetryOnDeadlock(new CustomOperation<Integer>()
		{
			public Integer performCustomOperation()
			{
				return jdbcTemplate.queryForInt(
						"select PromotionStatusFK from PromotionAdEngineStatus where PromotionFK = ? and AdvertisingEngineFK = ?", new Object[]
						{ promotionID, adEngine.getCode() });
			}
		}, SemplestUtils.DEFAULT_RETRY_COUNT);
		if (PromotionStatus.isValidPromotionStatus(promotionStatusCode))
		{
			return PromotionStatus.fromValue(promotionStatusCode);
		}
		else
		{
			return null;
		}
	}

	public static void updatePromotionStatus(final Integer promotionID, final AdEngine adEngine, final PromotionStatus promotionStatus)
	{
		logger.info("Will set PromotionStatus to [" + promotionStatus + "] for PromotionID [" + promotionID + "] and AdEngine [" + adEngine + "]");
		final Integer promotionStatusCode = promotionStatus.getPk();
		final Integer adEngineCode = adEngine.getCode();
		jdbcTemplate.update("if exists(select 1 from PromotionAdEngineStatus where PromotionFK = ? and AdvertisingEngineFK = ?) " + "begin "
				+ "update PromotionAdEngineStatus set PromotionStatusFK = ? where PromotionFK = ? and AdvertisingEngineFK = ? " + "end " + "else "
				+ "begin " + "insert into PromotionAdEngineStatus (PromotionFK, PromotionStatusFK, AdvertisingEngineFK) values (?, ?, ?) " + "end",
				new Object[]
				{ promotionID, adEngineCode, promotionStatusCode, promotionID, adEngineCode, promotionID, promotionStatusCode, adEngineCode });
	}

	public static void SetCurrentDailyBudget(Double currentDailyBudget, Integer promotionID, String adEngine) throws Exception
	{
		String strSQL = "update AdvertisingEnginePromotion set CurrentDailyBudget = ? " + "from AdvertisingEnginePromotion aep  "
				+ "inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK "
				+ "where ae.AdvertisingEngine = ? and aep.PromotionFK = ?";
		jdbcTemplate.update(strSQL, new Object[]
		{ currentDailyBudget, adEngine, promotionID });

	}

	public static Double GetCurrentDailyBudget(Integer promotionID, AdEngine adEngine) throws Exception
	{
		logger.info("Will try to get current daily budget for PromotionID [" + promotionID + "], AdEngine [" + adEngine + "]");
		String strSQL = "select aep.CurrentDailyBudget from AdvertisingEnginePromotion aep "
				+ "inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK "
				+ "where ae.AdvertisingEngine = ? and aep.PromotionFK = ?";
		Double CurrentDailyBudget;
		try
		{
			CurrentDailyBudget = (Double) jdbcTemplate.queryForObject(strSQL, new Object[]
			{ adEngine.toString(), promotionID }, Double.class);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
		catch (Exception e)
		{
			throw e;
		}
		return CurrentDailyBudget;

	}

	/*
	 * Configuration
	 */
	public static HashMap<String, Object> loadConfigurationData() throws Exception
	{
		final String strSQL = "select * from Configuration";
		final List<Map<String, Object>> res = jdbcTemplate.queryForList(strSQL);
		if (res != null)
		{
			return (HashMap<String, Object>) res.get(0);
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

	private static final RowMapper<BiddingParameters> BiddingParametersObjMapper = new BeanPropertyRowMapper<BiddingParameters>(
			BiddingParameters.class);

	public static BiddingParameters getBiddingParameters() throws Exception
	{
		String strSQL = "select c.SemplestBiddingBudgetMultFactor, c.SemplestBiddingInitialBidBoostFactor,	c.SemplestBiddingPercentileValue, c.SemplestBiddingMarginFactor from Configuration c";
		return jdbcTemplate.queryForObject(strSQL, BiddingParametersObjMapper);
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

	public static Integer disableSchedule(Integer ScheduleID ) throws Exception
	{
		String strSQL = "update Schedule set IsEnabled = 0 from Schedule s where s.SchedulePK = ?";

		return jdbcTemplate.update(strSQL, new Object[]
		{ ScheduleID });
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

	/*
	 * select pb.PromotionFK,pb.BidCompleted,
	 * ae.AdvertisingEngine,sbt.SemplestBidType from PromotionBidding pb left
	 * join SemplestBidType sbt on sbt.SemplestBidTypePK = pb.SemplestBidTypeFK
	 * inner join AdvertisingEngine ae on ae.AdvertisingEnginePK =
	 * pb.AdvertisingEngineFK where pb.PromotionFK = 4 and ae.AdvertisingEngine
	 * = 'Google'
	 */
	private static final RowMapper<SemplestBiddingHistory> semplestBiddingHistoryObjMapper = new BeanPropertyRowMapper<SemplestBiddingHistory>(
			SemplestBiddingHistory.class);

	public static List<SemplestBiddingHistory> getSemplestBiddingHistory(int PromotionID, AdEngine advertisingEngine) throws Exception
	{
		String strSQL = "select pb.PromotionFK,pb.BidCompleted, ae.AdvertisingEngine,sbt.SemplestBidType from PromotionBidding pb "
				+ "left join SemplestBidType sbt on sbt.SemplestBidTypePK = pb.SemplestBidTypeFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = pb.AdvertisingEngineFK "
				+ "where pb.PromotionFK = ? and ae.AdvertisingEngine = ? order by pb.BidCompleted DESC";
		try
		{
			return jdbcTemplate.query(strSQL, new Object[]
			{ PromotionID, advertisingEngine.name() }, semplestBiddingHistoryObjMapper);
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

	public static void setSemplestBiddingHistory(Integer PromotionID, AdEngine advertisingEngine, PromotionBiddingType promotionBiddingType)
			throws Exception
	{
		SetPromotionBiddingSP setPromotionBiddingSP = new SetPromotionBiddingSP();
		Integer res = setPromotionBiddingSP.execute(PromotionID, advertisingEngine.name(), promotionBiddingType.name());
		logger.info("Added BiddingHistory for promoID=" + PromotionID + " AdEngine=" + advertisingEngine.name() + ":" + promotionBiddingType.name());
	}

	private static final RowMapper<DefaultBidObject> defaultBidObjectMapper = new BeanPropertyRowMapper<DefaultBidObject>(DefaultBidObject.class);
	public static DefaultBidObject getDefaultBid(int promotionID, AdEngine adEngine) throws Exception
	{
		String strSQL = "select aep.MicroDefaultBid, aep.DefaultBidEditedDate from AdvertisingEnginePromotion aep  "
				+ "inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK "
				+ "where aep.PromotionFK = ? and ae.AdvertisingEngine = ?";

		
		List<DefaultBidObject> defaultBidObjects = jdbcTemplate.query(strSQL, new Object[]
					{ promotionID, adEngine.name() }, defaultBidObjectMapper);
		if (defaultBidObjects.size() > 0)
		{
			return defaultBidObjects.get(0);
		}
		else
		{
			return null;
		}
	}

	public static void storeDefaultBid(int promotionID, AdEngine adEngine, Long microDefaultBid) throws Exception
	{
		Integer microBid = microDefaultBid.intValue();
		String sql = "update AdvertisingEnginePromotion set MicroDefaultBid = ?  , DefaultBidEditedDate = current_timestamp from AdvertisingEnginePromotion aep  "
				+ "inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK "
				+ "where aep.PromotionFK = ? and ae.AdvertisingEngine = ?";

		jdbcTemplate.update(sql, new Object[]
		{ microBid, promotionID, adEngine.name() });

	}

	public static void UpdateDefaultBidForKeywords(int promotionID, AdEngine adEngine) throws Exception
	{
		UpdateDefaultBidForKeywordsSP updateDefBiAmounts = new UpdateDefaultBidForKeywordsSP();
		Boolean ret = updateDefBiAmounts.execute(promotionID, adEngine.name());
	}

	public static void storeTargetedDailyBudget(int promotionID, AdEngine adEngine, Long TargetedDailyMicroBudget, Integer TargetedDailyClicks)
			throws Exception
	{
		jdbcTemplate.update(
				"insert into TargetedDailyBudget(PromotionFK, AdvertisingEngineFK,TargetedDailyMicroBudget,TargetedDailyClicks,CreatedDate) "
						+ "select ?,a.AdvertisingEnginePK,?,?,CURRENT_TIMESTAMP from AdvertisingEngine a where a.AdvertisingEngine = ?", new Object[]
				{ promotionID, TargetedDailyMicroBudget, TargetedDailyClicks, adEngine.name() });

	}

	public static void storeTrafficEstimatorData(int promotionID, AdEngine adEngine, TrafficEstimatorObject trafficEstimatorObj) throws Exception
	{
		// AddTrafficEstimatorSP addTrafficEstSP = new AddTrafficEstimatorSP();
		final int maxInBatch = 10000;
		List<TrafficDataObj> trafficDataList = new ArrayList<TrafficDataObj>();
		java.util.Date date = new java.util.Date();
		Timestamp ts = new Timestamp(date.getTime());

		HashMap<String, HashMap<String, HashMap<Long, BidData>>> trafficData = trafficEstimatorObj.getBidDataMap();
		// go through each keyword
		if (trafficData.keySet().isEmpty())
		{
			return;
		}
		Iterator<String> keywords = trafficData.keySet().iterator();
		int counter = 0;
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
							++counter;
							if (counter % 1000 == 0)
							{
								logger.info("Batched up " + counter + " traffic estimate items for eventual persisting to db");
							}
							// add the data to the DB
							// int PromotionID, String Keyword, String
							// AdvertisingEngine, String BidType, Integer
							// MicroBid, Float AveMicroCost,
							// Float AveNumberClicks, Float AvePosition, Float
							// AveCPC, java.util.Date currentTime
							TrafficDataObj trafficDataObj = new TrafficDataObj();
							trafficDataObj.setAdvertisingEngine(adEngine.name());
							trafficDataObj.setPromotionID(promotionID);
							trafficDataObj.setAveCPC(trafficEstimatorObj.getAveCPC(keyword, matchType, microBid).floatValue());
							trafficDataObj.setAveMicroCost(trafficEstimatorObj.getAveTotalDailyMicroCost(keyword, matchType, microBid).floatValue());
							trafficDataObj.setAveNumberClicks(trafficEstimatorObj.getAveClickPerDay(keyword, matchType, microBid).floatValue());
							trafficDataObj.setAvePosition(trafficEstimatorObj.getAvePosition(keyword, matchType, microBid).floatValue());
							trafficDataObj.setBidType(matchType);
							trafficDataObj.setKeyword(keyword);
							trafficDataObj.setMicroBid(microBid.intValue());
							trafficDataList.add(trafficDataObj);
							if (counter == maxInBatch)
							{
								trafficEstimatorBatch(trafficDataList, ts);
								trafficDataList.clear();
								counter = 0;
							}
							/*
							 * Boolean ret =
							 * addTrafficEstSP.execute(promotionID, keyword,
							 * adEngine.name(), matchType, microBid.intValue(),
							 * trafficEstimatorObj
							 * .getAveTotalDailyMicroCost(keyword, matchType,
							 * microBid).floatValue(),
							 * trafficEstimatorObj.getAveClickPerDay(keyword,
							 * matchType, microBid).floatValue(),
							 * trafficEstimatorObj.getAvePosition(keyword,
							 * matchType, microBid).floatValue(),
							 * trafficEstimatorObj.getAveCPC(keyword, matchType,
							 * microBid).floatValue(), ts);
							 */
						}
					}
				}
			}
		}
		// call the last batch add
		trafficEstimatorBatch(trafficDataList, ts);
	}

	private static void trafficEstimatorBatch(final List<TrafficDataObj> trafficDataList, final Timestamp ts) throws Exception
	{
		logger.info("Will try to persist " + trafficDataList.size() + " items of Traffic Data");
		String sql = "{call AddTrafficEstimator(?,?,?,?,?,?,?,?,?,?)}";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		{

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				TrafficDataObj trafficData = trafficDataList.get(i);
				ps.setInt(1, trafficData.getPromotionID());
				ps.setString(2, trafficData.getKeyword());
				ps.setString(3, trafficData.getAdvertisingEngine());

				ps.setString(4, trafficData.getBidType());
				ps.setInt(5, trafficData.getMicroBid());
				ps.setFloat(6, trafficData.getAveMicroCost());
				ps.setFloat(7, trafficData.getAveNumberClicks());
				ps.setFloat(8, trafficData.getAvePosition());
				ps.setFloat(9, trafficData.getAveCPC());
				ps.setTimestamp(10, ts);
			}

			@Override
			public int getBatchSize()
			{
				return trafficDataList.size();
			}
		});
		logger.info("Persist complete");
	}

	public static void storeKeywordDataObjects(int promotionID, AdEngine adEngine, List<KeywordDataObject> keywordDataObjectList) throws Exception
	{
		final AddKeywordBidDataSP addKeywordBidDataSP = new AddKeywordBidDataSP();
		Integer counter = 0;
		if (keywordDataObjectList != null && !keywordDataObjectList.isEmpty())
		{
			final int size = keywordDataObjectList.size();
			for (final KeywordDataObject kdObj : keywordDataObjectList)
			{
				Integer firstpgcpc = null;
				if (kdObj.getFirstPageCpc() != null)
				{
					firstpgcpc = kdObj.getFirstPageCpc().intValue();
				}
				logger.debug(++counter + " of " + size + ": PromotionID [" + promotionID + "] " + kdObj);
				// int PromotionID, String Keyword, String AdvertisingEngine,
				// String BidType, Integer QualityScore, String ApprovalStatus,
				// Integer
				// FirstPageMicroCpc, Boolean IsEligibleForShowing
				final Integer res = addKeywordBidDataSP.execute(promotionID, kdObj.getKeyword(), adEngine, kdObj.getMatchType(),
						kdObj.getQualityScore(), kdObj.getApprovalStatus(), firstpgcpc, kdObj.isIsEligibleForShowing());
				if (res == null || res == 0)
				{
					logger.warn("KeywordBidData not stored for " + kdObj);
				}

			}
		}
	}

	private static final RowMapper<BidElement> bidElementMapper = new BeanPropertyRowMapper<BidElement>(BidElement.class);

	public static List<BidElement> getLatestBids(int promotionID, AdEngine searchEngine) throws Exception
	{
		String strSQL = "select kb.KeywordAdEngineID, k.Keyword,kb.MicroBidAmount,bt.BidType [matchType],kb.CompetitionType, kb.StartDate, kb.EndDate, "
				+ " kb.isActive, kb.isDefaultValue, pka.IsNegative from Promotion p  "
				+ "inner join KeywordBid kb on kb.PromotionFK = p.PromotionPK "
				+ "inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.keywordFK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
				+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
				+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
				+ "where p.PromotionPK = ? and kb.MicroBidAmount != -1 and ae.AdvertisingEngine = ? and kb.IsActive = 1";
		try
		{
			return jdbcTemplate.query(strSQL, new Object[]
			{ promotionID, searchEngine.name() }, bidElementMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}

	public static HashMap<String, ArrayList<BidElement>> getAllBids(int promotionID, AdEngine searchEngine, Date startDate, Date endDate)
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
				{ promotionID, searchEngine.name(), startDateSQL }, new AllBidRSExtactor());
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
				{ promotionID, searchEngine.name(), startDateSQL, endDateSQL }, new AllBidRSExtactor());
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
	public static List<KeywordDataObject> getLatestBiddableAdGroupCriteria(Integer promotionID, AdEngine advertisingEngine) throws Exception
	{
		GetBiddableAdGroupCriteriaSP getLatestBiddableAdGroupCriteria = new GetBiddableAdGroupCriteriaSP();
		return getLatestBiddableAdGroupCriteria.execute(promotionID, advertisingEngine);
	}

	public static HashMap<String, ArrayList<KeywordDataObject>> getAllBiddableAdGroupCriteria(Integer promotionID, AdEngine adEngine, Date startDate,
			Date endDate) throws Exception
	{
		String strSQL = null;
		if (endDate == null)
		{
			strSQL = "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,mkbd.ApprovalStatus, bt.BidType ,mkbd.FirstPageMicroCPC, "
					+ "mkbd.QualityScore,mkbd.IsEligibleForShowing, pka.IsNegative,mkbd.CreatedDate from Keyword k inner join KeywordBid kb on k.KeywordPK = kb.KeywordFK "
					+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK inner join Promotion p on p.PromotionPK = kb.PromotionFK "
					+ "inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.KeywordFK "
					+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
					+ "left join  (select kbd.KeywordBidFK,kbd.ApprovalStatus ,kbd.FirstPageMicroCPC,kbd.QualityScore,kbd.IsEligibleForShowing,kbd.CreatedDate from KeywordBidData kbd "
					+ "inner join KeywordBid kb on kb.KeywordBidPK = kbd.KeywordBidFK "
					+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
					+ "where kb.PromotionFK = ? and ae.AdvertisingEngine = ? and kb.IsActive = 1 and kbd.CreatedDate >= ?) mkbd "
					+ "on mkbd.KeywordBidFK = kb.KeywordBidPK " + "where kb.PromotionFK = ? and kb.IsActive = 1 and ae.AdvertisingEngine = ?";

			try
			{
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine.name(), startDate, promotionID, adEngine.name() }, new AllBiddableRSExtractor());
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
			strSQL = "select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,mkbd.ApprovalStatus, bt.BidType ,mkbd.FirstPageMicroCPC, "
					+ "mkbd.QualityScore,mkbd.IsEligibleForShowing, pka.IsNegative,mkbd.CreatedDate from Keyword k inner join KeywordBid kb on k.KeywordPK = kb.KeywordFK "
					+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK inner join Promotion p on p.PromotionPK = kb.PromotionFK "
					+ "inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.KeywordFK "
					+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
					+ "left join  (select kbd.KeywordBidFK,kbd.ApprovalStatus ,kbd.FirstPageMicroCPC,kbd.QualityScore,kbd.IsEligibleForShowing,kbd.CreatedDate from KeywordBidData kbd "
					+ "inner join KeywordBid kb on kb.KeywordBidPK = kbd.KeywordBidFK "
					+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
					+ "where kb.PromotionFK = ? and ae.AdvertisingEngine = ? and kb.IsActive = 1 and kbd.CreatedDate >= ? and kbd.CreatedDate <= ?) mkbd "
					+ "on mkbd.KeywordBidFK = kb.KeywordBidPK " + "where kb.PromotionFK = ? and kb.IsActive = 1 and ae.AdvertisingEngine = ?";
			try
			{
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine.name(), startDate, endDate, promotionID, adEngine.name() }, new AllBiddableRSExtractor());
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
	public static List<TrafficEstimatorDataObject> getLatestTrafficEstimatorForKeyword(Integer promotionID, String keyword, AdEngine advertisingEngine)
			throws Exception
	{
		GetLatestTrafficEstimatorSP trafficEst = new GetLatestTrafficEstimatorSP();
		return trafficEst.execute(promotionID, keyword, advertisingEngine);
	}

	public static List<TrafficEstimatorDataObject> getLatestTrafficEstimator(Integer promotionID, AdEngine advertisingEngine) throws Exception
	{
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
			logger.error("getBudget " + e.getMessage(), e);
			return null;
		}
		catch (Exception e)
		{
			logger.error("getBudget " + e.getMessage(), e);
			throw e;
		}
	}

	public static void storeBidObjects(int promotionID, AdEngine advertisingEngine, List<BidElement> bidObjects) throws Exception
	{
		if (bidObjects != null && bidObjects.size() > 0)
		{
			AddBidSP addBid = new AddBidSP();
			for (BidElement bid : bidObjects)
			{
				try
				{
					Integer id = addBid.execute(promotionID, bid.getKeywordAdEngineID(), bid.getKeyword(), bid.getMicroBidAmount().intValue(),
							bid.getMatchType(), advertisingEngine, bid.getIsNegative(), bid.getCompetitionType(), bid.getIsDefaultValue());
					logger.info("Added Keyword " + bid.getKeyword() + " MicroBid " + bid.getMicroBidAmount());
				}
				catch (Exception e)
				{
					logger.error("Strore Bid Object Error " + bid.getKeyword() + ":" + e.getMessage(), e);
					logger.error("Problem", e);
					throw e;
				}
			}
		}
	}

	/*
	 * Report calls
	 */

	public static Integer storeAdvertisingEngineReportData(Integer promotionID, AdEngine adEngine, ReportObject[] reportObjList) throws Exception
	{
		logger.info("Will try to store AdEngine Bid Performance Report for PormotionID [" + promotionID + "], AdEngine [" + adEngine + "], <Report Items>");
		Integer numInserted = 0;
		if (reportObjList == null || reportObjList.length == 0)
		{
			logger.info("Report is empty, nothing to do");
		}
		else
		{
			logger.info("Report data to store:\n" + SemplestUtils.getEasilyReadableString(Arrays.asList(reportObjList)));
			AddReportDataSP setReportSP = new AddReportDataSP();
			for (int i = 0; i < reportObjList.length; i++)
			{
				ReportObject rptObj = reportObjList[i];
				// Integer PromotionID, String Keyword,String AdvertisingEngine,
				// Date TransactionDate, Integer MicroBidAmount,
				// Integer NumberImpressions, Integer NumberClick, Float
				// AveragePosition, Long AverageCPC,String BidType, Integer
				// QualityScore, String
				// ApprovalStatus,
				// Integer FirstPageMicroCpc, Integer MicroCost
				logger.info("Will try to insert: " + rptObj);
				Integer id = setReportSP.execute(promotionID, rptObj.getKeyword(), adEngine, rptObj.getTransactionDate(), rptObj.getMicroBidAmount()
						.intValue(), rptObj.getNumberImpressions(), rptObj.getNumberClick(), rptObj.getAveragePosition(), rptObj.getAverageCPC(),
						rptObj.getBidMatchType(), rptObj.getQualityScore(), rptObj.getApprovalStatus(), rptObj.getFirstPageCPC().intValue(), rptObj
								.getMicroCost().intValue());
				if (id == 0)
				{
					logger.info("Already inserted");
				}
				else
				{
					logger.info("Inserted ID = " + id);
					++numInserted;
				}
			}
		}
		return numInserted;
	}

	private static final RowMapper<ReportObject> reportObjectjMapper = new BeanPropertyRowMapper<ReportObject>(ReportObject.class);

	public static List<ReportObject> getReportData(int promotionID, AdEngine adEngine, java.util.Date startDate, java.util.Date endDate)
			throws Exception
	{
		String strSQL = null;
		try
		{
			java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
			if (endDate == null)
			{
				strSQL = "select aep.AdvertisingEngineAccountFK [AccountID],aep.AdvertisingEngineCampaignPK [CampaignID],k.Keyword,aerd.TransactionDate,aerd.MicroBidAmount, "
						+ "bt.BidType [BidMatchType],aerd.NumberImpressions, aerd.NumberClick,aerd.AveragePosition,aerd.AverageCPC,aerd.QualityScore,aerd.ApprovalStatus,aerd.FirstPageMicroCPC,aerd.CreatedDate,aerd.MicroCost, kb.KeywordAdEngineID [keywordID]  "
						+ "from AdvertisingEngineReportData aerd "
						+ "inner join KeywordBid kb on kb.KeywordBidPK = aerd.KeywordBidFK "
						+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
						+ "inner join Promotion p on p.PromotionPK = kb.PromotionFK "
						+ "inner join AdvertisingEnginePromotion aep on p.PromotionPK = aep.PromotionFK "
						+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
						+ "where p.PromotionPK = ? and ae.AdvertisingEngine = ? and aerd.TransactionDate >= ?";
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine.name(), startDateSQL }, reportObjectjMapper);
			}
			else
			{
				java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
				strSQL = "select aep.AdvertisingEngineAccountFK [AccountID],aep.AdvertisingEngineCampaignPK [CampaignID],k.Keyword,aerd.TransactionDate,aerd.MicroBidAmount, "
						+ "bt.BidType [BidMatchType],aerd.NumberImpressions, aerd.NumberClick,aerd.AveragePosition,aerd.AverageCPC,aerd.QualityScore,aerd.ApprovalStatus,aerd.FirstPageMicroCPC,aerd.CreatedDate,aerd.MicroCost, kb.KeywordAdEngineID [keywordID]  "
						+ "from AdvertisingEngineReportData aerd "
						+ "inner join KeywordBid kb on kb.KeywordBidPK = aerd.KeywordBidFK "
						+ "inner join Keyword k on k.KeywordPK = kb.KeywordFK "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK "
						+ "inner join Promotion p on p.PromotionPK = kb.PromotionFK "
						+ "inner join AdvertisingEnginePromotion aep on p.PromotionPK = aep.PromotionFK "
						+ "inner join BidType bt on bt.BidTypePK = kb.BidTypeFK "
						+ "where p.PromotionPK = ? and ae.AdvertisingEngine = ? and aerd.TransactionDate >= ? and aerd.TransactionDate <= ?";
				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine.name(), startDateSQL, endDateSQL }, reportObjectjMapper);
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

	private static final RowMapper<TargetedDailyBudget> targetedDailyBudgetMapper = new BeanPropertyRowMapper<TargetedDailyBudget>(
			TargetedDailyBudget.class);

	public static TargetedDailyBudget getLatestTargetedDailyBudget(int promotionID, AdEngine adEngine) throws Exception
	{
		String strSQL = "select top 1 tdb.TargetedDailyMicroBudget, tdb.TargetedDailyClicks,tdb.CreatedDate from TargetedDailyBudget tdb "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = tdb.AdvertisingEngineFK "
				+ "where tdb.PromotionFK = ? and ae.AdvertisingEngine = ? order by tdb.CreatedDate DESC";

		try
		{
			return jdbcTemplate.queryForObject(strSQL, new Object[]
			{ promotionID, adEngine.name() }, targetedDailyBudgetMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	/*
	public static List<User> getUsers(final Boolean isActive, final Boolean isRegistered, final java.util.Date lastEmailReminderDate)
	{
		logger.info("Will try to get Users for IsActive [" + isActive + "], IsRegistered [" + isRegistered + "], LastEmailReminderDate [" + lastEmailReminderDate + "]");
	}
*/
	public static List<TargetedDailyBudget> getAllTargetedDailyBudget(int promotionID, AdEngine adEngine, java.util.Date startDate,
			java.util.Date endDate) throws Exception
	{
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
				{ promotionID, adEngine.name(), startDateSQL }, targetedDailyBudgetMapper);
			}
			else
			{
				java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
				strSQL = "select tdb.TargetedDailyMicroBudget, tdb.TargetedDailyClicks,tdb.CreatedDate from TargetedDailyBudget tdb "
						+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = tdb.AdvertisingEngineFK "
						+ "where tdb.PromotionFK = ? and ae.AdvertisingEngine = ? and tdb.CreatedDate >= ? and tdb.CreatedDate <= ?";

				return jdbcTemplate.query(strSQL, new Object[]
				{ promotionID, adEngine.name(), startDateSQL, endDateSQL }, targetedDailyBudgetMapper);
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

	public static AdEngineID getAdEngineID(Integer promotionID, AdEngine adEngine) throws Exception
	{
		String strSQL = "select aec.AdvertisingEngineAccountPK [AccountID], aep.AdvertisingEngineCampaignPK [CampaignID], aep.AdvertisingEngineAdGroupID [AdGroupID] from Customer c "
				+ "inner join AdvertisingEngineAccount aec on aec.CustomerFK = c.CustomerPK "
				+ "inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aec.AdvertisingEngineFK "
				+ "inner join AdvertisingEnginePromotion aep on aec.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "inner join Promotion p on aep.PromotionFK = p.PromotionPK where p.PromotionPK = ? and ae.AdvertisingEngine = ?";
		try
		{
			return jdbcTemplate.queryForObject(strSQL, new Object[]
			{ promotionID, adEngine.name() }, adEngineObjMapper);
		}
		catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}

	private static final RowMapper<AdvertisingEnginePromotionObj> advertisingEnginePromotionObjMapper = new BeanPropertyRowMapper<AdvertisingEnginePromotionObj>(
			AdvertisingEnginePromotionObj.class);

	public static List<AdvertisingEnginePromotionObj> getAdvertisingEnginePromotion(Long advertisingEngineAccountID) throws Exception
	{
		String strSQL = "Select ap.AdvertisingEngineAccountFK [AdvertisingEngineAccountID],ap.AdvertisingEngineCampaignPK [AdvertisingEngineCampaignID],"
				+ "ap.PromotionFK [PromotionID], ap.IsSearchNetwork,ap.IsDisplayNetwork,ap.MicroDefaultBid,ap.AdvertisingEngineAdGroupID, ap.AdvertisingEngineBudget, ap.CurrentDailyBudget "
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
		String strSQL = "select aep.AdvertisingEngineAccountFK [AdvertisingEngineAccountID], aep.AdvertisingEngineCampaignPK [AdvertisingEngineCampaignID], "
				+ "p.PromotionPK [PromotionID], aep.IsSearchNetwork, aep.IsDisplayNetwork, aep.MicroDefaultBid, aep.AdvertisingEngineAdGroupID,  aep.AdvertisingEngineBudget, aep.CurrentDailyBudget from AdvertisingEnginePromotion aep "
				+ "inner join Promotion p on p.PromotionPK = aep.PromotionFK "
				+ "inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK "
				+ "where aea.AdvertisingEngineAccountPK = ? and p.PromotionPK = ?";
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
	/*
	 * public static List<Map<String, Object>> getAdEngineAccount(int
	 * customerID, String adEngine) throws Exception { String strSQL =
	 * "select a.AdvertisingEngineAccountPK [AccountID], c.Name [CustomerName] from Customer c "
	 * + "left join AdvertisingEngineAccount a on c.CustomerPK = a.CustomerFK "
	 * +
	 * "left join AdvertisingEngine ae on ae.AdvertisingEnginePK = a.AdvertisingEngineFK "
	 * +
	 * "where c.CustomerPK = ? and (ae.AdvertisingEngine is null or ae.AdvertisingEngine = ?)"
	 * ;
	 * 
	 * try { return jdbcTemplate.queryForList(strSQL, new Object[]{customerID,
	 * adEngine.name()}); } catch (EmptyResultDataAccessException e) { return
	 * null; } catch (Exception e) { throw e; }
	 * 
	 * }
	 */

	public static void addAdEngineAccountID(int customerID, String accountNumber, Long accountID, AdEngine adEngine) throws Exception
	{
		AddAdvertisingEngineAccountSP addAccount = new AddAdvertisingEngineAccountSP();
		Boolean r = addAccount.execute(accountID, adEngine.name(), customerID, accountNumber);
	}

	public static Integer addPromotionToAdEngineAccountID(int promotionID, Long adEngineAccountID, Long adEngineCampaignID,
			Long advertisingEngineAdGroupID, Double advertisingEngineBudget, Double currentDailyBudget) throws Exception
	{
		String strSQL = "insert into AdvertisingEnginePromotion(AdvertisingEngineCampaignPK,PromotionFK,AdvertisingEngineAccountFK,IsSearchNetwork,IsDisplayNetwork,AdvertisingEngineBudget, AdvertisingEngineAdGroupID, CurrentDailyBudget) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(strSQL, new Object[]
		{ adEngineCampaignID, promotionID, adEngineAccountID, 1, 0, advertisingEngineBudget, advertisingEngineAdGroupID, currentDailyBudget });
	}

	public static Integer setAdvertisingEngineAdGroupID(Long adEngineCampaignID, Long advertisingEngineAdGroupID) throws Exception
	{
		String strSQL = "update AdvertisingEnginePromotion set AdvertisingEngineAdGroupID = ? "
				+ "from AdvertisingEnginePromotion aep where aep.AdvertisingEngineCampaignPK = ?";

		return jdbcTemplate.update(strSQL, new Object[]
		{ advertisingEngineAdGroupID, adEngineCampaignID });

	}

	public static Integer setAdIDForAdGroup(Long advertisingEngineAdPK, AdEngine advertisingEngine, Integer promotionAdsFK) throws Exception
	{
		return jdbcTemplate.update(SQL_SET_AD_ID_FOR_AD_GROUP, new Object[]
		{ advertisingEngineAdPK, promotionAdsFK, advertisingEngine.name() });
	}

	public static Map<Integer, Integer> getDeletedAdMappingCountMap(final List<Integer> deletedAdIds, int[] rowCounts)
	{
		final Map<Integer, Integer> deletedAdIdRowCountMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < rowCounts.length; ++i)
		{
			final int rowCount = rowCounts[i];
			final Integer deletedAdId = deletedAdIds.get(i);
			deletedAdIdRowCountMap.put(deletedAdId, rowCount);
		}
		return deletedAdIdRowCountMap;
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

	public static Map<Entry<Integer, String>, Integer> getKeywordIdCommentToRowCountMap(final List<Entry<Integer, String>> entryList, int[] rowCounts)
	{
		final Map<Entry<Integer, String>, Integer> keywordIdCommentToRowCountMap = new HashMap<Entry<Integer, String>, Integer>();
		for (int i = 0; i < rowCounts.length; ++i)
		{
			final int rowCount = rowCounts[i];
			final Entry<Integer, String> entry = entryList.get(i);
			keywordIdCommentToRowCountMap.put(entry, rowCount);
		}
		return keywordIdCommentToRowCountMap;
	}

	public static Map<Entry<UpdateAdRequest, Long>, Integer> getOldNewAdIdRowCountMap(
			final List<Entry<UpdateAdRequest, Long>> updateRequestToNewAdIdList, int[] rowCounts)
	{
		final Map<Entry<UpdateAdRequest, Long>, Integer> idPairMap = new HashMap<Entry<UpdateAdRequest, Long>, Integer>();
		for (int i = 0; i < rowCounts.length; ++i)
		{
			final int rowCount = rowCounts[i];
			final Entry<UpdateAdRequest, Long> updateRequestNewIdPair = updateRequestToNewAdIdList.get(i);
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

	public static Map<GoogleAdIdSemplestAdIdPair, Integer> setAdIDForAdGroupBulk(final List<GoogleAdIdSemplestAdIdPair> idPairs,
			final AdEngine advertisingEngine) throws Exception
	{
		final int[] rowCounts = jdbcTemplate.batchUpdate(SQL_SET_AD_ID_FOR_AD_GROUP, new BatchPreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				ps.setLong(1, idPairs.get(i).getGoogleAdId());
				ps.setInt(2, idPairs.get(i).getSemplestAdId());
				ps.setString(3, advertisingEngine.name());
			}

			public int getBatchSize()
			{
				return idPairs.size();
			}
		});
		return getIdPairRowCountMap(idPairs, rowCounts);
	}

	public static Map<Entry<Integer, String>, Integer> removeKeywordFromAdEngine(final Map<Integer, String> keywordIdToCommentMap,
			final Integer promotionID, final AdEngine adEngine)
	{
		logger.info("Will try to remove " + keywordIdToCommentMap.size() + " keywords from AdEngine [" + adEngine + "]:\n"
				+ SemplestUtils.getEasilyReadableString(keywordIdToCommentMap));
		final Set<Entry<Integer, String>> entrySet = keywordIdToCommentMap.entrySet();
		final List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>(entrySet);
		final String sql = "update 	PromotionKeywordAssociation " + "set 	IsTarget" + adEngine.name() + " = 0, " + "Comment = ? "
				+ "where  KeywordFK = ?" + "and  PromotionFK = ?";
		final int[] rowCounts = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				final Entry<Integer, String> entry = entryList.get(i);
				final Integer keywordId = entry.getKey();
				final String comment = entry.getValue();
				ps.setString(1, comment);
				ps.setInt(2, keywordId);
				ps.setInt(3, promotionID);
			}

			public int getBatchSize()
			{
				return entryList.size();
			}
		});
		return getKeywordIdCommentToRowCountMap(entryList, rowCounts);
	}

	public static Map<Entry<Integer, String>, Integer> markKeywordDeletedBulk(final Map<Integer, String> keywordIdToCommentMap,
			final Integer promotionID)
	{
		logger.info("Will try to mark " + keywordIdToCommentMap.size() + " keywords as deleted:\n"
				+ SemplestUtils.getEasilyReadableString(keywordIdToCommentMap));
		final Set<Entry<Integer, String>> entrySet = keywordIdToCommentMap.entrySet();
		final List<Entry<Integer, String>> entryList = new ArrayList<Entry<Integer, String>>(entrySet);
		final int[] rowCounts = jdbcTemplate.batchUpdate(SQL_MARK_KEYWORD_DELETED, new BatchPreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				final Entry<Integer, String> entry = entryList.get(i);
				final Integer keywordId = entry.getKey();
				final String comment = entry.getValue();
				ps.setString(1, comment);
				ps.setInt(2, keywordId);
				ps.setInt(3, promotionID);
			}

			public int getBatchSize()
			{
				return entryList.size();
			}
		});
		return getKeywordIdCommentToRowCountMap(entryList, rowCounts);
	}

	public static Map<Entry<UpdateAdRequest, Long>, Integer> updateAdIDForAdGroupBulk(final Map<UpdateAdRequest, Long> oldToNewAdIdMap,
			final AdEngine advertisingEngine) throws Exception
	{
		final Set<Entry<UpdateAdRequest, Long>> entries = oldToNewAdIdMap.entrySet();
		final List<Entry<UpdateAdRequest, Long>> entryList = new ArrayList<Entry<UpdateAdRequest, Long>>(entries);
		final int[] rowCounts = jdbcTemplate.batchUpdate(SQL_UPDATE_AD_ENGINE_AD_ID, new BatchPreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				final Entry<UpdateAdRequest, Long> entry = entryList.get(i);
				final UpdateAdRequest updateRequest = entry.getKey();
				final Long newAdID = entry.getValue();
				final Integer promotionAdId = updateRequest.getPromotionAdID();
				final Long oldAdID = updateRequest.getAdId();
				ps.setLong(1, newAdID);
				ps.setInt(2, promotionAdId);
				ps.setLong(3, oldAdID);
				ps.setString(4, advertisingEngine.name());
			}

			public int getBatchSize()
			{
				return oldToNewAdIdMap.size();
			}
		});
		return getOldNewAdIdRowCountMap(entryList, rowCounts);
	}

	public static Integer updateAdIDForAdGroup(Long newAdvertisingEngineAdPK, Long oldAdvertisingEngineAdPK, String advertisingEngine,
			Integer promotionAdsFK) throws Exception
	{
		return jdbcTemplate.update(SQL_UPDATE_AD_ENGINE_AD_ID, new Object[]
		{ newAdvertisingEngineAdPK, promotionAdsFK, oldAdvertisingEngineAdPK, advertisingEngine });
	}

	public static Integer deleteAdIDForAdGroup(AdEngine advertisingEngine, Integer promotionAdsFK) throws Exception
	{

		return jdbcTemplate.update(SQL_DELETE_AD_ENGINE_AD_ID, new Object[]
		{ promotionAdsFK, advertisingEngine.name() });
	}

	public static Integer markPromotionAdDeleted(final java.util.Date date, final Long advertisingEngineAdID) throws Exception
	{
		return jdbcTemplate.update(SQL_MARK_AD_DELETED, new Object[]
		{ date, advertisingEngineAdID });
	}

	public static Map<Integer, Integer> deleteAdIDForAdGroupBulk(final List<Integer> promotionAdIds, final AdEngine advertisingEngine)
			throws Exception
	{
		final int[] rowCounts = jdbcTemplate.batchUpdate(SQL_DELETE_AD_ENGINE_AD_ID, new BatchPreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				final Integer promotionAdId = promotionAdIds.get(i);
				ps.setInt(1, promotionAdId);
				ps.setString(2, advertisingEngine.name());
			}

			public int getBatchSize()
			{
				return promotionAdIds.size();
			}
		});
		return getDeletedAdMappingCountMap(promotionAdIds, rowCounts);
	}

	public static Map<Long, Integer> markPromotionAdDeletedBulk(final java.util.Date date, final List<Long> deletedAdIds) throws Exception
	{
		final int[] rowCounts = jdbcTemplate.batchUpdate(SQL_MARK_AD_DELETED, new BatchPreparedStatementSetter()
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
		final String strSQL = "update   PromotionAds " + "set   IsDeleted = 1,  " + "DeletedDate = ?  " + "where	PromotionAdsPK = ?";
		return jdbcTemplate.update(strSQL, new Object[]
		{ deletedDate, promotionAdsPK });
	}

	public static Integer updatePromotionToAdEngineAccountID(Long adEngineCampaignID, boolean IsSearchNetwork, boolean IsDisplayNetwork,
			Double AdvertisingEngineBudget, Double currentDailyBudget) throws Exception
	{
		String strSQL = "update AdvertisingEnginePromotion set IsSearchNetwork = ?, IsDisplayNetwork = ?,AdvertisingEngineBudget = ?,  CurrentDailyBudget = ? where AdvertisingEngineCampaignPK = ?";
		return jdbcTemplate.update(strSQL, new Object[]
		{ IsSearchNetwork, IsDisplayNetwork, AdvertisingEngineBudget, adEngineCampaignID, currentDailyBudget });
	}

	public static void logError(Exception e, String errorSource)
	{
		try
		{
			final StackTraceElement[] ste = e.getStackTrace();
			final StackTraceElement err = ste[ste.length - 1];
			final String errorClass = err.getClassName();
			final StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			final String stackTraceString = sw.toString();
			final String errDetails = SemplestUtils.getTrimmedNonNullString(stackTraceString);
			final String sql = "INSERT Error(ErrorSource,ErrorClass,ErrorMessage,ErrorDetails,CreatedDate) VALUES (?, ?, ?, ?, ?)";
			final String errMsg = SemplestUtils.getTrimmedNonNullString(e.getMessage());
			jdbcTemplate.update(sql, new Object[]
			{ errorSource, errorClass, errMsg, errDetails, new java.util.Date() });
		}
		catch (Exception e1)
		{
			logger.error("logError: " + e1.getMessage(), e1);
		}
	}

}
