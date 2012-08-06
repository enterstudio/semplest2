package semplest.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.MSNGeotargetObject;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.TrafficDataObj;

public class TestSpringJDBC extends BaseDB
{
	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";

	public static ClassPathXmlApplicationContext appContext = null;

	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();
			/*
			 * Properties properties = new Properties(); FileInputStream is =
			 * new FileInputStream(PROPSFILE); properties.load(is); is.close();
			 */
			appContext = new ClassPathXmlApplicationContext("Service.xml");
			// BiddingParameters p = SemplestDB.getBiddingParameters();
			/*
			List<BidElement> bids = new ArrayList<BidElement>();
			BidElement b = new BidElement();
			b.setKeyword("coffee machine");
			b.setMatchType("Phrase");
			bids.add(b);
			b = new BidElement();
			b.setKeyword("espresso coffee3");
			b.setMatchType("Phrase");
			bids.add(b);
			SemplestDB.setBidInactive(4, "Google", bids);
			*/
			List<MSNGeotargetObject> res = SemplestDB.getMsnLocation(true,"NY", null,null,null);
			// GetAllPromotionDataSP sp = new GetAllPromotionDataSP();
			// sp.execute(235);
			//List<String> test = SemplestDB.getPromotionCategory(1);
			for (MSNGeotargetObject s : res)
			{
				System.out.println(s.getName() + ":" + s.getMSNName());
			}
			
			
			// System.out.println(p.getSemplestBiddingBudgetMultFactor() + ":" + p.getSemplestBiddingInitialBidBoostFactor() + ";" + p.getSemplestBiddingMarginFactor() + ";" + p.getSemplestBiddingPercentileValue());
			/*
			java.util.Date date = new java.util.Date();
			Timestamp ts = new Timestamp(date.getTime());

			
			List<TrafficDataObj> trafficDataList = new ArrayList<TrafficDataObj>();

			Long start = System.currentTimeMillis();
			for (int j = 1; j <= 4; j++)
			{
				for (int i = 83000; i < 88000; i++)
				{
					TrafficDataObj o = new TrafficDataObj();
					o.setAdvertisingEngine("Google");
					o.setPromotionID(71);
					o.setAveCPC(0.1f + .1f * i);
					o.setAveMicroCost(0.5f + .1f * i);
					o.setAveNumberClicks(1.0f + .1f * i);
					o.setAvePosition(2.4f + .1f * i);
					o.setBidType(ProtocolEnum.SemplestMatchType.Exact.name());
					o.setKeyword("personal wedding sites");
					o.setMicroBid(50000 + i * j);
					trafficDataList.add(o);
				}
				trafficEstimatorBatch(trafficDataList, ts);
				trafficDataList.clear();
				Long ms = System.currentTimeMillis() - start;
				System.out.println("Took ms = " + j + ":"  + ms + " sec=" + ms / 1000.);
			}
			

			Long ms = System.currentTimeMillis() - start;
			System.out.println("Took ms = " + ms + " sec=" + ms / 1000.);*/
			/*
			 * GetAllPromotionDataSP sp = new GetAllPromotionDataSP();
			 * sp.execute(60); // GetAdEngineAccountSP sp = new
			 * GetAdEngineAccountSP(); // AdEngineAccountObj r = sp.execute(12,
			 * "MSN");
			 * 
			 * AdEngineID a = SemplestDB.getAdEngineID(62, AdEngine.Google);
			 * a.getAccountID();
			 * 
			 * HashMap<String, Object> configData =
			 * SemplestDB.loadConfigurationData(); Iterator<String> configIT =
			 * configData.keySet().iterator(); while (configIT.hasNext()) {
			 * String key = configIT.next(); if (configData.get(key) != null) {
			 * System.out.println(key + "=" + configData.get(key).toString()); }
			 * else { System.out.println(key + "= null"); } }
			 */
			// List ll= SemplestDB.getAdEngineAccount(2, "Google");
			// List<LinkedHashMap<String, Object>> AdEngineAccoutRow
			// =SemplestDB.getAdEngineAccount(2, "Google");

			// String companyName = (String)
			// AdEngineAccoutRow.get(0).get("CustomerName");
			// System.out.println("companyName=" + companyName);
			// Test Scheduler
			/*
			 * ArrayList<SemplestSchedulerTaskObject> listOfTasks = new
			 * ArrayList<SemplestSchedulerTaskObject>();
			 * SemplestSchedulerTaskObject mailTask1 =
			 * CreateSchedulerAndTask.getSendMailTask
			 * ("Test Scheduler mailTask1", "nan@semplest.com",
			 * "nan@semplest.com", "Hello"); SemplestSchedulerTaskObject
			 * mailTask2 =
			 * CreateSchedulerAndTask.getSendMailTask("Test Scheduler mailTask2"
			 * , "mitch@semplest.com", "mitch@semplest.com", "Hello");
			 * listOfTasks.add(mailTask1); listOfTasks.add(mailTask2);
			 * CreateSchedulerAndTask.createScheduleAndRun(listOfTasks,
			 * "MailScheduleTest", new Date(),
			 * null,ProtocolEnum.ScheduleFrequency.Daily.name(), true, false,
			 * null, null, null, null);
			 */

			// SemplestDB op = new SemplestDB();
			// List ll= SemplestDB.getAdEngineAccount(2, "Google");
			// System.out.println("AdEngineAccount ");
			/*
			 * SemplestAdengineServiceImpl ad = new
			 * SemplestAdengineServiceImpl(); ArrayList<String> l = new
			 * ArrayList<String>(); l.add("Google");
			 * ad.AddPromotionToAdEngine(2, 1, 1 ,l);
			 */
			/*
			 * Integer ret = SemplestDB.addAdEngineAccountID(12, 343434L,
			 * "Google"); if (ret.intValue() > 0) { System.out.println("added");
			 * }
			 */

			// List<BidObject> bids = op.getBidObjects(2L,
			// ProtocolEnum.AdEngine.Google.name());
			// Integer i = op.addSchedule("TestSchedule", new Date(),null,
			// "Now",true, false, null, null,null, null);
			// if (bids != null && !bids.isEmpty())
			// System.out.println(bids.get(0).getMicroBidAmount());
			/*
			 * GetNextScheduleJobSP nextsch = new GetNextScheduleJobSP();
			 * ScheduleJobObj res = nextsch.execute(); if (res != null) {
			 * System.out.println(res.getScheduleJobPK() + ":" +
			 * res.getScheduleFK() + ":" + res.getExecutionStartTime()); }
			 */
			/*
			 * CustomerDB cust = new CustomerDB(); List<CustomerObj> customers =
			 * cust.getAllCustomers(); if (!customers.isEmpty()) {
			 * System.out.println(customers.get(0).getCustomerPK() + ":" +
			 * customers.get(0).getCreatedDate().toString()); } else {
			 * System.out.println("No customers found"); }
			 * SetScheduleJobCompleteSP sp = new SetScheduleJobCompleteSP(); Map
			 * res = sp.execute(2, 1);
			 */
			/*
			 * TaskRunnerDB tasks = new TaskRunnerDB(); List<TaskRunnerObj> l =
			 * tasks.getScheduleTasks(2); if (!l.isEmpty()) { for (int i = 0; i
			 * < l.size(); i++) { TaskRunnerObj j = l.get(i);
			 * System.out.println(j.getServiceName() + ":" + j.getMethodName() +
			 * ":" + j.getParameters()); } } else {
			 * System.out.println("No tasks found"); }
			 */
		}
		catch (Exception e)
		{
			System.out.println("ERROR" + e.getMessage());
		}
		/*
		 * catch (FileNotFoundException e) { logger.error("Problem", e); } catch
		 * (IOException e) { logger.error("Problem", e); }
		 */
	}

	/*
	 * create object to hold TrafficData
	 */
	/*
	 * declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
	 * declareParameter(new SqlParameter("Keyword", Types.VARCHAR));
	 * declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
	 * declareParameter(new SqlParameter("BidType", Types.VARCHAR));
	 * declareParameter(new SqlParameter("MicroBid", Types.INTEGER));
	 * declareParameter(new SqlParameter("AveMicroCost", Types.FLOAT));
	 * declareParameter(new SqlParameter("AveNumberClicks", Types.FLOAT));
	 * declareParameter(new SqlParameter("AvePosition", Types.FLOAT));
	 * declareParameter(new SqlParameter("AveCPC", Types.FLOAT));
	 * declareParameter(new SqlParameter("currentTime", Types.TIMESTAMP));
	 */
	public static void trafficEstimatorBatch(final List<TrafficDataObj> trafficDataList, final Timestamp ts) throws Exception
	{

		String sql = "{call AddTrafficEstimator(?,?,?,?,?,?,?,?,?,?)}";
		// JdbcTemplate template = new JdbcTemplate();
		// template.setDataSource(dataSource)
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
	}
}
