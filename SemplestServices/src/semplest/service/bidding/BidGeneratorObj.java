package semplest.service.bidding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.bidding.estimation.EstimatorData;
import semplest.bidding.optimization.BidOptimizer;
import semplest.bidding.optimization.CampaignBid;
import semplest.bidding.optimization.KeyWord;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorDataObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject.BidData;
import semplest.server.protocol.bidding.BiddingParameters;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleSetBidForKeywordRequest;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.DefaultBidObject;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.Keyword;

public class BidGeneratorObj
{
	private String networkSetting = ProtocolEnum.NetworkSetting.SearchOnly.name();

	// private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidGeneratorObj.class);

	private int maxRetry;// = 10; // maximum number of times we will
	private int sleepPeriod;// = 500; // in millisecond
	private int sleepBackOffTime;// = 1000; // after k-th failure wait for
									// sleepPeriod + k*sleepBackOffTime ms

	private Long maxMicroBid;// = 3000000L;
	private Long stepAboveFpCPC;// = 500000L;
	private Long defaultMicroBid;// = 1000000L;
	private Long maxDefaultMicroBid;// = 1500000L;

	// traffic estimator bid steps
	private Long stepFirst;// = 100000L;
	private Long stepSecond;// = 600000L;
	private Long stepRest;// = 800000L;
	
	Double googlePercent;
	Double budgetFactor;
	

	private String googleAccountID = null;
	private Long msnAccountID = null;
	private Long campaignID;
	private Long adGroupID;
	
	private boolean isFirstCall = true;
	private double clickFactor = 10.0;
	
	double percentileValue;
	double marginFactor=1.0;
	double budgetBoost=1.0;
	double bidBoostFactor=1.1;

	private GoogleAdwordsServiceImpl clientGoogle;
	private MsnCloudServiceImpl msnClient;
	private KeywordDataObject[] keywordDataObjs;
	private KeywordDataObject keywordDataObj;

	private HashMap<String, Long> wordIDMap;
	private HashMap<String, Long> wordBidMap;

	private HashMap<String, Long> firstPageCPCMap;
	private HashMap<String, Double> qualityScoreMap;

	private HashSet<String> compKeywords; // competitive
	private HashSet<String> nonCompKeywords; // non-competitive
	private HashSet<String> noInfoKeywords; // competitive but no-info
	private HashSet<String> notSelectedKeywords; // competitive but not selected
													// by optimizer

	/*
	 * private HashMap<String,Long> compKeywordBids; // competitive private
	 * HashMap<String,Long> nonCompKeywordBids; // non-competitive private
	 * HashMap<String,Long> noInfoKeywordBids; // competitive but no-info
	 * private HashMap<String,Long> notSelectedKeywordBids; // competitive but
	 * not selected by optimizer
	 */

	private HashMap<String, EstimatorData> clickDataMap;
	private HashMap<String, EstimatorData> costDataMap;
	private HashMap<String, EstimatorData> cpcDataMap;


	public BidGeneratorObj() throws Exception
	{ // constructor
		try
		{
			clientGoogle = new GoogleAdwordsServiceImpl();
			msnClient = new MsnCloudServiceImpl();

		}
		catch (Exception e)
		{
			logger.error("Unable to create Google Client " + e.getMessage(), e);
			throw new Exception("Unable to create Google Client " + e.getMessage(), e);
		}

		try
		{
			Thread.sleep(1000);
		}
		catch (Exception e)
		{
			logger.error("Unable to sleep! May have error in default config values! " + e.getMessage(), e);
		}
		maxRetry = (Integer) SemplestConfiguration.configData.get("SemplestBiddingMaxRetry");
		sleepPeriod = (Integer) SemplestConfiguration.configData.get("SemplestBiddingSleepPeriod");
		sleepBackOffTime = (Integer) SemplestConfiguration.configData.get("SemplestBiddingSleepBackOffTime");

		maxMicroBid = (Long) SemplestConfiguration.configData.get("SemplestBiddingMaxMicroBid");
		stepAboveFpCPC = (Long) SemplestConfiguration.configData.get("SemplestBiddingStepAboveFpCPC");
		defaultMicroBid = (Long) SemplestConfiguration.configData.get("SemplestBiddingDefaultMicroBid");
		maxDefaultMicroBid = (Long) SemplestConfiguration.configData.get("SemplestBiddingMaxDefaultMicroBid");

		stepFirst = (Long) SemplestConfiguration.configData.get("SemplestBiddingStepFirst");
		stepSecond = (Long) SemplestConfiguration.configData.get("SemplestBiddingStepSecond");
		stepRest = (Long) SemplestConfiguration.configData.get("SemplestBiddingStepRest");
		
		msnAccountID = (Long) SemplestConfiguration.configData.get("MSNTrafficEstAccountID");
		
		final Integer googlePercentInteger = (Integer)SemplestConfiguration.configData.get("SemplestBiddingGooglePercent");		
		googlePercent =  Double.valueOf("" + googlePercentInteger);
		budgetFactor = (Double)SemplestConfiguration.configData.get("SemplestBiddingBudgetMultFactor");
		
		final Float budgetBoostFactorDouble = (Float) SemplestConfiguration.configData.get("SemplestBiddingInitialBidBoostFactor"); 
		budgetBoost = budgetBoostFactorDouble.doubleValue();
		
		final Float bidBoostFactorFloat = (Float) SemplestConfiguration.configData.get("SemplestBiddingInitialBidBoostFactor");
		bidBoostFactor = bidBoostFactorFloat.doubleValue();
		
		final Integer percentileValInteger = (Integer) SemplestConfiguration.configData.get("SemplestBiddingPercentileValue"); 
		percentileValue = percentileValInteger.doubleValue();
		
		final Double marginFactorDouble = (Double) SemplestConfiguration.configData.get("SemplestBiddingMarginFactor"); 
		marginFactor = marginFactorDouble.doubleValue();
		
		

		 

		wordIDMap = new HashMap<String, Long>();
		wordBidMap = new HashMap<String, Long>();

		firstPageCPCMap = new HashMap<String, Long>();
		qualityScoreMap = new HashMap<String, Double>();

		compKeywords = new HashSet<String>(); // competitive
		nonCompKeywords = new HashSet<String>(); // non-competitive
		noInfoKeywords = new HashSet<String>(); // competitive but no-info
		notSelectedKeywords = new HashSet<String>(); // competitive but not
														// selected by optimizer

		/*
		 * compKeywordBids = new HashMap<String,Long>(); // competitive
		 * nonCompKeywordBids = new HashMap<String,Long>(); // non-competitive
		 * noInfoKeywordBids = new HashMap<String,Long>(); // competitive but
		 * no-info notSelectedKeywordBids = new HashMap<String,Long>(); //
		 * competitive but not selected by optimizer
		 */

		clickDataMap = new HashMap<String, EstimatorData>();
		costDataMap = new HashMap<String, EstimatorData>();
		cpcDataMap = new HashMap<String, EstimatorData>();
	}

	//public Map<AdEngine, AdEngineInitialData> getInitialValues(Integer promotionID, List<AdEngine> searchEngine) throws Exception
	public Map<AdEngine, AdEngineInitialData> getInitialValues(Integer promotionID, List<AdEngine> searchEngine, Double totalMonthlyBudget) throws Exception
	{
		
		// Right now always split 70-30 or 100 -- to be changed later -- controlled via database now
		HashSet<AdEngine> setSE = new HashSet<AdEngine>(); 
		for (AdEngine s : searchEngine){
			if(setSE.contains(s)){
				throw new Exception("[PromotionID: "+promotionID+"]" + "Ad engine "+s+" appears twice!!");
			} else {
				setSE.add(s);
			}
		}

		HashMap<AdEngine,Double> budgetMap = new HashMap<AdEngine,Double>();

		switch (searchEngine.size()) {
			case 2:
				if(searchEngine.get(0) == AdEngine.Google && searchEngine.get(1) == AdEngine.MSN ||
				   searchEngine.get(0) == AdEngine.MSN && searchEngine.get(1) == AdEngine.Google)  
				{
					budgetMap.put(AdEngine.Google, new Double(googlePercent));
					budgetMap.put(AdEngine.MSN, new Double(100.0-googlePercent));
					break;
				}
				throw new Exception("[PromotionID: "+promotionID+"]" + "Invalid combination of Ad engine options!");
			case 1:
				budgetMap.put(searchEngine.get(0), new Double(100.0));
				break;
			default:
				throw new Exception("[PromotionID: "+promotionID+"]" + "Invalid number of Ad engines.. Received "+searchEngine.size()+" Ad engine names!");
		}

		
		final Map<AdEngine, AdEngineInitialData> initValues = new HashMap<AdEngine, AdEngineInitialData>();
		for (AdEngine se : searchEngine)
		{
			// Long defaultMicroBid = 1000000L; // $1.00
			AdEngineInitialData adEngineInitialDataObject = new AdEngineInitialData();
			adEngineInitialDataObject.setSemplestMatchType(ProtocolEnum.SemplestMatchType.Exact.name());
			adEngineInitialDataObject.setNetworkSetting(networkSetting);
			
			double seMonthlyBudget = totalMonthlyBudget*budgetMap.get(se)/100.0 * budgetBoost;
			double seDailyBudget = seMonthlyBudget/30*budgetFactor;
			
			adEngineInitialDataObject.setMonthlyBudget(seMonthlyBudget);
			adEngineInitialDataObject.setDailyBudget(seDailyBudget);
			
			long defBid = Math.min(defaultMicroBid, (new Double(seDailyBudget*0.95*1e-6)).longValue()/10000L * 10000L);
			
			adEngineInitialDataObject.setDefaultMicroBid(defBid);

			//SemplestDB.storeDefaultBid(promotionID, se, defBid);
			initValues.put(se, adEngineInitialDataObject);
		}
		return initValues;
	}
	
	public Boolean setBidsInitialWeek(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception {
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "setBidsInitialWeek called for ad engine " + searchEngine);
		
		/* ******************************************************************************************* */
		// 1. Database call: get campaign specific IDs
		try {
			AdEngineID adEngineInfo = SemplestDB.getAdEngineID(promotionID,
					searchEngine);
			if (searchEngine == AdEngine.Google) {
				googleAccountID = String.valueOf(adEngineInfo.getAccountID());
			} else if (searchEngine == AdEngine.MSN) {
				msnAccountID = adEngineInfo.getAccountID();
			}
			campaignID = adEngineInfo.getCampaignID();
			adGroupID = adEngineInfo.getAdGroupID();
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to get AdEngineID from the database. " + e.getMessage(), e);
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get AdEngineID from the database. " + e.getMessage(), e);
		}

		if (searchEngine == AdEngine.Google) {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got campaign related IDs from the database" + " Google Account " + googleAccountID + ":" + "CampaignID = " + campaignID + ":" + adGroupID);
		} else if (searchEngine == AdEngine.MSN) {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got campaign related IDs from the database" + " MSN Account " + msnAccountID + ":" + "CampaignID = " + campaignID + ":" + adGroupID);
		}
		
		

		/* ******************************************************************************************* */
		// 2. Database call: get present bid info
		
		// get present bid status from database
		ArrayList<BidElement> bidData;
		try {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to get the bid data from the database.");
			bidData = (ArrayList<BidElement>) SemplestDB.getLatestBids(promotionID, searchEngine);
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got " + bidData.size() + " bid data from the database.");
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to get the bid data from the database. "+ e.getMessage(), e);
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get the bid data from the database. "+ e.getMessage(), e);
		}
		
		// create a hash map for faster access
		HashMap<String,BidElement> kwBidElementMap = new HashMap<String,BidElement>();
		for(BidElement b : bidData){
			kwBidElementMap.put(b.getKeyword(), b);
		}

		
		
		/* ******************************************************************************************* */
		// 3. Database call: get report data 
		
//		//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//		//Date startDate = df.parse("05/01/2012");
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.DAY_OF_MONTH, -1);
//		Date startDate = cal.getTime();
//		//cal.add(Calendar.DAY_OF_MONTH, -1);
//		//Date endDate = cal.getTime();
//		//Date endDate = new Date(); //df.parse("07/21/2012");
//		
//		
//		// get report from the database
//		List<ReportObject> reportObjListYesterday;
//		try {
//			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to get the report data from the database.");
//			reportObjListYesterday = SemplestDB.getReportData(promotionID, searchEngine, startDate, startDate);
//			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got report data from the database with "+reportObjListYesterday.size()+" entries.");
//		} catch (Exception e) {
//			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to get the report data from the database. "+ e.getMessage(), e);
//			// e.printStackTrace();
//			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get the report data from the database. "+ e.getMessage(), e);
//		}
		
		
		
		ReportObject[] reportObjArray = null;
		List<ReportObject> reportObjListYesterday = null;
		try {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to get the report data via API call.");
			if(searchEngine.equals(AdEngine.Google)){
				final Date now = new Date();
				SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
				final Calendar cal = Calendar.getInstance();
				cal.setTime(now);
				cal.add(Calendar.DAY_OF_MONTH, -1);
				reportObjArray = clientGoogle.getReportForAccount(googleAccountID, YYYYMMDD.format(cal.getTime()), YYYYMMDD.format(now));
			} else {
				final DateTime lastday = new DateTime(System.currentTimeMillis());
				final DateTime firstday = lastday.minusDays(1);
				reportObjArray = msnClient.getKeywordReport(msnAccountID, campaignID, firstday, lastday);
			}
			if(reportObjArray!=null && reportObjArray.length > 0){
				reportObjListYesterday = new ArrayList<ReportObject>(Arrays.asList(reportObjArray));
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got report data from the database with "+reportObjListYesterday.size()+" entries.");
			} else {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "No report data found.");
			}
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to get the report data via API call. "+ e.getMessage(), e);
			// e.printStackTrace();
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get the report data via API call. "+ e.getMessage(), e);
		}
		
		

		
				
		
		/* ******************************************************************************************* */
		// 4. Update bids according to the new logic 
		
		
		DefaultBidObject presentDefaultBidObject = SemplestDB.getDefaultBid(promotionID, searchEngine);
		final Date lastDefaultBidUpdated = presentDefaultBidObject.getDefaultBidEditedDate();
		final Date today = new Date();
		Long diff = today.getTime() - lastDefaultBidUpdated.getTime();
		long daysSinceDefaultBidUpdated = diff / (1000 * 60 * 60 * 24);
		
		// map to store bids that need to go to search engine
		HashMap<String,Long> wordBidMap = new HashMap<String,Long>();

		// data that needs to change in the database
		ArrayList<BidElement> bidDataToDatabase = new ArrayList<BidElement>();

		// keywords that need to be paused
		HashMap<Long,Boolean> pauseMap = new HashMap<Long,Boolean>();
		HashSet<String> pausedSet = new HashSet<String>();
		
				
		double maxBid = SemplestDB.GetCurrentDailyBudget(promotionID, searchEngine);
		if(maxBid<=0.05) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Daily budget is too low to do anything with this adgroup...");
			return true;
			//throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Daily budget is too low to do anything with this adgroup...");
		}
		final Double maxBidDouble = new Double(maxBid * 0.95 * 1e6);
		final Long maxBidDoubleLong = maxBidDouble.longValue();
		Long maxBidL = new Long(maxBidDoubleLong / 10000L * 10000L);
		
		
		BiddingParameters  bidParams = SemplestDB.getBiddingParameters();
		bidBoostFactor = bidParams.getSemplestBiddingInitialBidBoostFactor().doubleValue();
		

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Going to read the report for all the keywords that had impressions.");
		
		
		if(reportObjListYesterday!=null && reportObjListYesterday.size()>0){
			for (ReportObject r : reportObjListYesterday){
				if(r.getCampaignID().longValue() == campaignID.longValue()){
					logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + r);

					Date bidStartDate = kwBidElementMap.get(r.getKeyword()).getStartDate();
					if(bidStartDate==null){
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Bid start date cannot be null for keyword "+kwBidElementMap.get(r.getKeyword()).getKeyword());
						throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Bid start date cannot be null for keyword "+kwBidElementMap.get(r.getKeyword()).getKeyword());
					}
					long daysSinceBidUpdated = ((Long)(today.getTime() - bidStartDate.getTime()))/ (1000 * 60 * 60 * 24);

					if(kwBidElementMap.get(r.getKeyword()).getIsActive()){
						if(r.getAveragePosition()<=4 || r.getMicroBidAmount() > (94*maxBidL) / 100){
							pauseMap.put(kwBidElementMap.get(r.getKeyword()).getKeywordAdEngineID(), false);
							pausedSet.add(r.getKeyword());
							kwBidElementMap.get(r.getKeyword()).setIsActive(false);
							bidDataToDatabase.add(kwBidElementMap.get(r.getKeyword()));
							logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Pausing keyword " + r.getKeyword());

							if(kwBidElementMap.get(r.getKeyword()).getIsDefaultValue()){ // if the KW is running on default bid, update the bid value before pausing
								wordBidMap.put(r.getKeyword(), r.getMicroBidAmount());
								kwBidElementMap.get(r.getKeyword()).setMicroBidAmount(r.getMicroBidAmount());
								kwBidElementMap.get(r.getKeyword()).setIsDefaultValue(false);
								logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Moving bid on keyword " + r.getKeyword() +" to non-default bid");
							}
						} else if (daysSinceBidUpdated >=2 ) {
							long b = Math.min(maxBidL, (((long) (kwBidElementMap.get(r.getKeyword()).getMicroBidAmount()* Math.pow(bidBoostFactor,(r.getAveragePosition()-1)/2)))/10000L) * 10000L);
							wordBidMap.put(r.getKeyword(), b);
							kwBidElementMap.get(r.getKeyword()).setMicroBidAmount(b);
							kwBidElementMap.get(r.getKeyword()).setIsDefaultValue(false);
							bidDataToDatabase.add(kwBidElementMap.get(r.getKeyword()));
							logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Increasing bid for keyword " + r.getKeyword() +" to "+ wordBidMap.get(r.getKeyword()));
						}
					}
				}
			}
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Done with all the keywords that had impressions.");
		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Didn't find any keyword that had impressions.");
		}
		
		
		
		
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Going to look into the keywords that didn't have impressions.");
		for(BidElement bData : bidData){
			if(pausedSet.contains(bData.getKeyword()) || wordBidMap.containsKey(bData.getKeyword())){
				continue;
			}
			Date bidStartDate = bData.getStartDate();
			if(bidStartDate==null){
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Bid start date cannot be null for keyword "+bData.getKeyword());
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Bid start date cannot be null for keyword "+bData.getKeyword());
			}
			long daysSinceBidUpdated = ((Long)(today.getTime() - bidStartDate.getTime()))/ (1000 * 60 * 60 * 24);
			if(!bData.getIsDefaultValue() && bData.getIsActive() && daysSinceBidUpdated >=2){
				long b = Math.min(maxBidL, (((long) (bData.getMicroBidAmount()* Math.pow(bidBoostFactor,2)))/10000L) * 10000L);
				wordBidMap.put(bData.getKeyword(),b);
				bData.setMicroBidAmount(b);
				bidDataToDatabase.add(bData);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Increasing bid for keyword " + bData.getKeyword() +" to "+ wordBidMap.get(bData.getKeyword()));
			}
		}
		
		/* ******************************************************************************************* */
		// 5. Database call: store bid data
		try {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write " +bidDataToDatabase.size() + "  bid data to the database...");
			SemplestDB.storeBidObjects(promotionID, searchEngine,bidDataToDatabase);
			//SemplestDB.storeBidObjects(promotionID, searchEngine,bidData);
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stroed bid data to the database for "+ bidDataToDatabase.size() + " keywords.");
			//logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stroed bid data to the database for "+ bidData.size() + " keywords.");

		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to store bid data to the database. "+ e.getMessage(), e);
			// e.printStackTrace();
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to store bid data to the database. "+ e.getMessage(), e);
		}
		
		
		/* ******************************************************************************************* */
		// 6. Database call: compute and update default bid of the adgroup
		//DefaultBidObject presentDefaultBidObject = SemplestDB.getDefaultBid(promotionID, searchEngine);
		if(daysSinceDefaultBidUpdated >=2) {
			long presentDefaultMicroBid = presentDefaultBidObject.getMicroDefaultBid();
			defaultMicroBid = Math.min(maxBidL, (((long) (presentDefaultMicroBid * Math.pow(bidBoostFactor,2))) / 10000L) * 10000L);

			try {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write the default bid of " + defaultMicroBid + " to the database.");
				SemplestDB.storeDefaultBid(promotionID, searchEngine, defaultMicroBid);
				SemplestDB.UpdateDefaultBidForKeywords(promotionID, searchEngine);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Written default bid to the database.");

			} catch (Exception e) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to write the default bid to the database. "+ e.getMessage(), e);
				// e.printStackTrace();
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to write the default bid to the database. "+ e.getMessage(), e);
			}
		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Too soon to update default bid.");
		}
		
		/* ******************************************************************************************* */
		// 7. SE API call: Update matchType, bid for keywords
		if (searchEngine == AdEngine.Google)
		{
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update bids with Google for " + wordBidMap.size() + " keywords.");

			final List<GoogleSetBidForKeywordRequest> requests = new ArrayList<GoogleSetBidForKeywordRequest>(); 
			final Set<Entry<String, Long>> entrySet = wordBidMap.entrySet();
			for (final Entry<String, Long> entry : entrySet)
			{
				final String word = entry.getKey();
				//final Long keywordID = wordIDMap.get(word);
				final Long keywordID = kwBidElementMap.get(word).getKeywordAdEngineID();

				final Long microBidAmount = wordBidMap.get(word);
				if(microBidAmount==null){
					continue; // don't write via API is the bid is null
				}
				final GoogleSetBidForKeywordRequest request = new GoogleSetBidForKeywordRequest(adGroupID, word, keywordID, microBidAmount);
				requests.add(request);
			}
			final int batchSize = 500;
			final List<List<GoogleSetBidForKeywordRequest>> requestBatches = SemplestUtils.getBatches(requests, batchSize);
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Broke up " + requests.size() + " GoogleSetBidForKeywordRequests into " + requestBatches.size() + " batches of " + batchSize);
			for(final List<GoogleSetBidForKeywordRequest> requestBatch : requestBatches)
			{
				clientGoogle.setBidForKeyWords(googleAccountID, requestBatch);
			}
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids with Google for " + wordBidMap.size() + " keywords.");

		} 

		if (searchEngine == AdEngine.MSN) {
			
			try {
				ArrayList<BidElement> bidDataToMSN = new ArrayList<BidElement>();
				final Set<Entry<String, Long>> entrySet = wordBidMap.entrySet();
				for (final Entry<String, Long> entry : entrySet){
					final String word = entry.getKey();
					bidDataToMSN.add(kwBidElementMap.get(word));
					if(kwBidElementMap.get(word).getIsDefaultValue()){
						kwBidElementMap.get(word).setMicroBidAmount(null);
					}
				}
				
				/*
				//for(BidElement b : bidData){
				for(BidElement b : bidDataToDatabase){
					if(b.getIsDefaultValue()){
						b.setMicroBidAmount(null);
					}
				}
				*/
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update bids with MSN for " + bidDataToMSN.size() + " keywords.");
				//msnClient.updateKeywordBidsByIds(msnAccountID, adGroupID, bidData);
				//msnClient.updateKeywordBidsByIds(msnAccountID, adGroupID, bidDataToDatabase);
				msnClient.updateKeywordBidsByIds(msnAccountID, adGroupID, bidDataToMSN);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids with MSN for " + bidDataToMSN.size() + " keywords.");

			} catch (Exception e) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to update bids to MSN. "+ e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update bids to MSN. "+ e.getMessage(), e);
			}

		} // if(searchEngine.equalsIgnoreCase(msn))

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids and match type for keywords via the search engine API.");

		/* ******************************************************************************************* */
		// 8. SE API call: Update default bid for campaign
		if(daysSinceDefaultBidUpdated >=2) {

			if (searchEngine == AdEngine.Google){
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update default bid via search engine API. The default bid is "+defaultMicroBid);

				int k = 0;
				while (true) {
					Thread.sleep(sleepPeriod + k * sleepBackOffTime);
					try {
						clientGoogle.updateDefaultBid(googleAccountID, adGroupID, defaultMicroBid);
						break;
					} catch (Exception e) {
						if (k <= maxRetry) {
							// e.printStackTrace();
							logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
							k++;
						} else {
							// e.printStackTrace();
							logger.error( "[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update default microBid via Google API. " + e.getMessage(), e);
							throw new Exception( "[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update default microBid via Google API. " + e.getMessage(), e);
						}
					} // try-catch
				} // while(true)
			}
			if(searchEngine == AdEngine.MSN){
				try{
					logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update default bid via search engine API. The default bid is "+defaultMicroBid);
					msnClient.updateAdGroupDefaultBids(msnAccountID, campaignID, adGroupID, Math.max(defaultMicroBid.doubleValue()*1e-6, 0.05), 0.05, 0.05);
				} catch(Exception e){
					logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via MSN API. " + e.getMessage(), e);
					throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via MSN API. " + e.getMessage(), e);
				}
			}

			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated the default bid via search engine API. The default bid is "+defaultMicroBid);

		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Too soon to update default bid.");
		}

		
		/* ******************************************************************************************* */
		// 9. SE API call: Pause the selected keywords 
		
		if( pauseMap.size()>0){
		if (searchEngine == AdEngine.Google){
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to pause " + pauseMap.size() + " keywords");
			int k = 0;
			while (true) {
				Thread.sleep(sleepPeriod + k * sleepBackOffTime);
				try {
					clientGoogle.updateKeywordStatus(googleAccountID, campaignID, adGroupID, pauseMap);
					break;
				} catch (Exception e) {
					if (k <= maxRetry) {
						// e.printStackTrace();
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
						k++;
					} else {
						// e.printStackTrace();
						logger.error( "[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to pause " + pauseMap.size() + " keywords via Google API. " + e.getMessage(), e);
						throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to pause " + pauseMap.size() + " keywords via Google API. " + e.getMessage(), e);
					}
				} // try-catch
			} // while(true)
		}
		if(searchEngine == AdEngine.MSN){
			try{
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to pause " + pauseMap.size() + " keywords");
				msnClient.updateKeywordStatus(msnAccountID, adGroupID, pauseMap);
			} catch(Exception e){
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to pause " + pauseMap.size() + " keywords via MSN API. " + e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to pause " + pauseMap.size() + " keywords via MSN API. " + e.getMessage(), e);
			}
		}
		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "No keywords to pause at this time.");
		}
					
		return true;
	}
	
	

	public Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception
	{

		/* ******************************************************************************************* */
		// declarations
		int k;
		TrafficEstimatorObject o = null;

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "setBidsInitial called for ad engine " + searchEngine);


		/* ******************************************************************************************* */
		// 1. Database call: get campaign specific IDs
		try {
			AdEngineID adEngineInfo = SemplestDB.getAdEngineID(promotionID,
					searchEngine);
			if (searchEngine == AdEngine.Google) {
				googleAccountID = String.valueOf(adEngineInfo.getAccountID());
			} else if (searchEngine == AdEngine.MSN) {
				msnAccountID = adEngineInfo.getAccountID();
			}
			campaignID = adEngineInfo.getCampaignID();
			adGroupID = adEngineInfo.getAdGroupID();
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + 
					"Failed to get AdEngineID from the database. "
							+ e.getMessage(), e);
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get AdEngineID from the database. "
					+ e.getMessage(), e);
		}

		if (searchEngine == AdEngine.Google) {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got campaign related IDs from the database"
					+ " Google Account " + googleAccountID + ":"
					+ "CampaignID = " + campaignID + ":" + adGroupID);
		} else if (searchEngine == AdEngine.MSN) {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got campaign related IDs from the database"
					+ " MSN Account " + msnAccountID + ":" + "CampaignID = "
					+ campaignID + ":" + adGroupID);
		}

		/* ******************************************************************************************* */
		// 2. Database call: get remaining days and budget
		// now get it as function argument
		// BudgetObject budgetData = SemplestDB.getBudget(promotionID);
		
		
		// **** THE VALUE WE ARE GETTING FROM ADENGINE IS INCORRECT *****
		Double remBudget = budgetData.getRemainingBudgetInCycle();
		Integer remDays = budgetData.getRemainingDays();
		double targetDailyBudget = (remBudget / remDays) * 7; // use weekly
																// budget as
																// target daily
																// budget

		/* ******************************************************************************************* */
		// 3. [google] API call: get adgroup criterion for all keywords
		if (searchEngine == AdEngine.Google)
		{
			k = 0;
			while (true) {
				Thread.sleep(sleepPeriod + k * sleepBackOffTime);
				try {
					keywordDataObjs = clientGoogle.getAllBiddableAdGroupCriteria(googleAccountID, adGroupID, true);
					break;
				} catch (Exception e) {
					if (k <= maxRetry) {
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Received exception getAllBiddableAdGroupCriteria AccountID = "
								+ googleAccountID + " AdGroupID = "+ String.valueOf(adGroupID)+ ": will retry..., k=" + k
								+ e.getMessage(), e);
						k++;
					} else {
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get BiddableAdGroupCriteria from Google after "+ k + " efforts " + e.getMessage(), e);
						throw new Exception("Failed to get BiddableAdGroupCriteria from Google after "+ k + " efforts " + e.getMessage(), e);
					}
				} // try-catch
			} // while(true)

			for (KeywordDataObject b : keywordDataObjs)
			{
				wordIDMap.put(b.getKeyword(), b.getBidID());
			}

			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got biddable adgroup criterion from Google.");
		} // if(searchEngine.equalsIgnoreCase(google))

		/* ******************************************************************************************* */
		// 4. [google] Decide competitive, non-competitive and no-info
		if (searchEngine == AdEngine.Google)
		{
			for (int i = 0; i < keywordDataObjs.length; i++)
			{
				keywordDataObj = keywordDataObjs[i];
				if (keywordDataObj.getFirstPageCpc() == null)
				{
					// logger.info((i+1)+": Received no firstPageCPC info for "+keywordDataObj.getKeyword());
					//noInfoKeywords.add(keywordDataObj.getKeyword());
				}
				else
				{
					// logger.info((i+1)+": "+keywordDataObj.getKeyword()+": "+
					// keywordDataObj.getFirstPageCpc()*1e-6 + ": " +
					// keywordDataObj.getQualityScore());
					firstPageCPCMap.put(keywordDataObj.getKeyword(), new Long(keywordDataObj.getFirstPageCpc()));
					qualityScoreMap.put(keywordDataObj.getKeyword(), new Double(Math.pow(keywordDataObj.getQualityScore(), 1)));
					/*
					if (keywordDataObj.isIsEligibleForShowing())
					{
						compKeywords.add(keywordDataObj.getKeyword());
					}
					else
					{
						nonCompKeywords.add(keywordDataObj.getKeyword());
					}
					*/
				} // if(keywordDataObj.getFirstPageCpc()==null)
			} // for(int i=0; i<keywordDataObjs.length; i++)

			logger.info("Created maps for FP CPC and QS.");
		} // if(searchEngine.equalsIgnoreCase(google))

		/* ******************************************************************************************* */
		// 5. SE API call: get traffic estimator data

		/* *************************************** */
		// a. [google] only competitive keywords
		// i. some keywords are pushed back to non-competitive category if
		// information available is not useful

		if (searchEngine == AdEngine.Google)
		{
			
			try{ 
				Keyword[] kwList = new Keyword[keywordDataObjs.length]; //msnClient.getKeywordByAdGroupId(msnAccountID, adGroupID);
				for(int i=0; i<keywordDataObjs.length; i++){
					kwList[i] = new Keyword();
					kwList[i].setText(keywordDataObjs[i].getKeyword());
				}
				o = getTrafficEstimatorDataForMSN(kwList);
				
				String [] keyListTE = o.getListOfKeywords();
				for(String s : keyListTE){
					compKeywords.add(s);
				}
				for(Keyword kw : kwList){
					String s = kw.getText();
					//wordIDMap.put(s, kw.getId());
					if(!compKeywords.contains(s)){
						nonCompKeywords.add(s);
					}
				}
				
			} catch (Exception e) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get MSN traffic estimator data for using in Google campaign. " + e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get MSN traffic estimator data for using in Google campaign. " + e.getMessage(), e);
			}
			
			
			
			
			/*
			if (compKeywords.size() > 0) {
				try {
					logger.info("Attenpting to get traffic estimator info.");
					o = getTrafficEstimatorDataForGoogle();
				}
				catch (Exception e) {
					logger.error("Failed to get Google traffic estimator data. " + e.getMessage(), e);
					throw new Exception("Failed to get Google traffic estimator data. " + e.getMessage(), e);
				}
				logger.info("Got traffic estimator data.");
			}else {
				logger.info("No traffic estimator data to be fetched.");
			}
			*/
		} // if(searchEngine.equalsIgnoreCase(google))

		/* *************************************** */
		// b. [msn] for all keywords and compute firstPage CPC from the data

		if (searchEngine == AdEngine.MSN){
			try{ 
				Keyword[] kwList = msnClient.getKeywordByAdGroupId(msnAccountID, adGroupID);
				o = getTrafficEstimatorDataForMSN(kwList);
				
				String [] keyListTE = o.getListOfKeywords();
				for(String s : keyListTE){
					compKeywords.add(s);
				}
				for(Keyword kw : kwList){
					String s = kw.getText();
					wordIDMap.put(s, kw.getId());
					if(!compKeywords.contains(s)){
						nonCompKeywords.add(s);
					}
				}
				
			} catch (Exception e) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get MSN keywords and traffic estimator data. " + e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get MSN keywords and traffic estimator data. " + e.getMessage(), e);
			}
		} // if(searchEngine.equalsIgnoreCase(msn))
		
		
		
		
		/*
		
		if (searchEngine == AdEngine.MSN)
		{

			// /////////////////////////////////////// HACK
			// ////////////////////////////////////////////////
			// ////////////////////////// THIS IS A TEMPORARY HACK FOR MSN
			// /////////////////////////////////

			Keyword[] kwList = null;
			try
			{
				kwList = msnClient.getKeywordByAdGroupId(msnAccountID, adGroupID);
			}
			catch (Exception e)
			{
				logger.error("ERROR: Unable to get keywords from MSN. " + e.getMessage(), e);
				throw new Exception("Unable to get keywords from MSN. " + e.getMessage(), e);
			}

			ArrayList<BidElement> bidsMatchTypeMSN_Temp = new ArrayList<BidElement>();
			for (Keyword w : kwList)
			{
				logger.info("Keyword: " + w.getText() + " " + w.getBroadMatchBid().getAmount() + " " + w.getExactMatchBid().getAmount() + " "
						+ w.getPhraseMatchBid().getAmount() + ", Keyword ID: " + w.getId());

				String matchType = ProtocolEnum.SemplestMatchType.Exact.name();
				if (w.getExactMatchBid().getAmount() == null || w.getExactMatchBid().getAmount() < 0.0001)
				{
					logger.error("In phase beta only EXACT match is supported!!!");
					throw new Exception("In phase beta only EXACT match is supported!!!");
				}
				String competitiveType = ProtocolEnum.SemplestCompetitionType.Comp.name();
				Boolean isDefaultValue = false;
				Boolean isActive = true;
				Boolean isNegative = false;
				

				bidsMatchTypeMSN_Temp.add(new BidElement(w.getText(), w.getId(), 1000000L, matchType, competitiveType, isDefaultValue, isActive,
						isNegative));

			}

			try
			{
				if (bidsMatchTypeMSN_Temp.size() > 0)
				{
					SemplestDB.storeBidObjects(promotionID, searchEngine, bidsMatchTypeMSN_Temp);
					logger.info("Stroed bid data to the databse for " + bidsMatchTypeMSN_Temp.size() + " keywords.");
				}
				else
				{
					logger.info("No bid data to write to the databse");
				}
			}
			catch (Exception e)
			{
				logger.error("ERROR: Unable to store bid data to the database. " + e.getMessage(), e);
				throw new Exception("Failed to store bid data to the database. " + e.getMessage(), e);
			}

			try
			{
				msnClient.updateKeywordBidsByIds(msnAccountID, adGroupID, bidsMatchTypeMSN_Temp);
			}
			catch (Exception e)
			{
				logger.error("ERROR: Unable to update bids to MSN. " + e.getMessage(), e);
				throw new Exception("Failed to update bids to MSN. " + e.getMessage(), e);
			}

			
			 final String msg ="Method NOT CORRECTLY implemented for MSN yet!! The present code is a temporary fix for integration testing!"; 
			 logger.info(msg);
			 

			return new Boolean(true);

		} // if(searchEngine.equalsIgnoreCase(msn))
		
		
		*/
		
		
		
		/* ******************************************************************************************* */
		// XX. Database call: get traffic estimator data from database
		
		/*
		List<TrafficEstimatorDataObject> teList = SemplestDB.getLatestTrafficEstimator(promotionID, searchEngine);
		System.out.println("Number of entries retrieved: "+teList.size());
		HashSet<String> teWordSet = new HashSet<String>();
		HashMap<String,ArrayList<Double>> teWordClickMap = new HashMap<String,ArrayList<Double>>();
		HashMap<String,ArrayList<Double>> teWordCPCMap = new HashMap<String,ArrayList<Double>>();
		HashMap<String,ArrayList<Double>> teWordCostMap = new HashMap<String,ArrayList<Double>>();
		HashMap<String,ArrayList<Double>> teWordBidMap = new HashMap<String,ArrayList<Double>>();

		for(TrafficEstimatorDataObject te : teList){
			
			if(!teWordSet.contains(te.getKeyword())) {
				teWordSet.add(te.getKeyword());
				teWordClickMap.put(te.getKeyword(), new ArrayList<Double>());
				teWordCPCMap.put(te.getKeyword(), new ArrayList<Double>());
				teWordCostMap.put(te.getKeyword(), new ArrayList<Double>());
				teWordBidMap.put(te.getKeyword(), new ArrayList<Double>());

			}
			teWordClickMap.get(te.getKeyword()).add(new Double(te.getAveNumberClicks()));
			teWordCPCMap.get(te.getKeyword()).add(new Double(te.getAveCPC()));
			teWordCostMap.get(te.getKeyword()).add(new Double(te.getAveMicroCost()*1e-6));
			teWordBidMap.get(te.getKeyword()).add(new Double(((double) te.getMicroBid() )*1e-6));

		}
		*/
		

		/* ******************************************************************************************* */
		// 6. [google] Compute bids for competitive keywords

		// TODO: bidOptimizer to be added
		// for the time being put all keywords to the category of keywords not
		// selected by optimizer

		// imp: consider the case that compKeywords is empty
		
		
		BidOptimizer bidOptimizer = new BidOptimizer();


		for (String s : compKeywords)
		{
			double[] bidArray = costDataMap.get(s).getBidArray();
			Arrays.sort(bidArray);
			//public KeyWord(String name, double score, double[] bid, double[] Clicks,
			//	      double[] CPC, double[] Pos, double[] DCost, Double cutoff, Double clickFactor)
			bidOptimizer.addKeyWord(new KeyWord(s, (qualityScoreMap.get(s)==null ? 10.0 : qualityScoreMap.get(s).doubleValue()), bidArray, clickDataMap.get(s).getData(bidArray), 
					cpcDataMap.get(s).getData(bidArray), null, costDataMap.get(s).getData(bidArray), 0.05 ,clickFactor));
			//notSelectedKeywords.add(s);
		}
		//compKeywords.clear();
		
		Long totalDailyCost = 0L;
		Float totalDailyClick = 0F;
		
		if(compKeywords.size()>0){
			bidOptimizer.setDailyBudget(targetDailyBudget);
			//HashMap<String,Double> bidData = bidOptimizer.optimizeBids();
			
			
			double maxBid = SemplestDB.GetCurrentDailyBudget(promotionID, searchEngine);
			if(maxBid<=0.05) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Daily budget is too low to do anything with this adgroup...");
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Daily budget is too low to do anything with this adgroup...");
			}
			maxBid*=0.95;
			
			
			BiddingParameters  bidParams = SemplestDB.getBiddingParameters();
			percentileValue = bidParams.getSemplestBiddingPercentileValue().doubleValue();
			marginFactor = bidParams.getSemplestBiddingMarginFactor().doubleValue();
			
			HashMap<String,Double> bidData = bidOptimizer.getCPCPercentilePoint(percentileValue, marginFactor,maxBid);
			defaultMicroBid = (new Double(bidOptimizer.getTargetCPC()*1e6).longValue())/10000L*10000L;
			totalDailyCost = new Double(bidOptimizer.getTotalDailyCost()*1e6).longValue();
			totalDailyClick = new Float(bidOptimizer.getTotalDailyClicks());
			
			
			Iterator<String> wordIT = bidData.keySet().iterator();
			while (wordIT.hasNext()){
				String s = wordIT.next();
				wordBidMap.put(s, (new Double(bidData.get(s)*1e6).longValue())/10000L*10000L);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Microbid for keyword "+s+" is "+wordBidMap.get(s));
			}
			
		}
		

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Computed bids for competitive keywords.");
		//logger.info("No competitive keywords.");

		/* ******************************************************************************************* */
		// 7. [google] Compute bids for competitive keywords which optimizer didn't select
		// a. Bid $0.5 above firstPage CPC if below $3.00
//		if (notSelectedKeywords.size() > 0)
//		{
//			for (String s : notSelectedKeywords){
//				//wordBidMap.put(s, Math.min(firstPageCPCMap.get(s) + stepAboveFpCPC, maxMicroBid));
//				//wordBidMap.put(s, defaultMicroBid);
//				wordBidMap.put(s, null);
//				logger.info("Microbid for keyword "+s+" is "+wordBidMap.get(s));
//
//			}
//			logger.info("Computed bids for competitive keywords which optimizer didn't select for bidding.");
//		}

		/* ******************************************************************************************* */
		// 8. Compute bits for all other keywords with firstPage CPC
		if (nonCompKeywords.size() > 0)
		{
			for (String s : nonCompKeywords)
			{
				//wordBidMap.put(s, Math.min(firstPageCPCMap.get(s) + stepAboveFpCPC, maxMicroBid));
				//wordBidMap.put(s, defaultMicroBid);
				wordBidMap.put(s, null);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Microbid for keyword "+s+" is "+wordBidMap.get(s));


			}
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Computed bids for non-competitive keywords.");
		}

		/* ******************************************************************************************* */
		// 9. For the rest of keywords without firstPage CPC leave out for
		// bidding with default bid

//		if (noInfoKeywords.size() > 0)
//		{
//			for (String s : noInfoKeywords)
//			{
//				wordBidMap.put(s, null); // bid using default bid
//				logger.info("Microbid for keyword "+s+" is "+defaultMicroBid);
//
//			}
//			logger.info("Left the remaining keywords for default bidding");
//		}

		/* ******************************************************************************************* */
		// 10. Use traffic estimator to compute average CPC based on these bids
		// and use that as default bid for the campaign
		// a. [google] use only competitive (both used and unused by optimizer)
		// keywords
		// b. [msn] use all keywords

		
		/*
		// defaultMicroBid = 1000000L;
		Long totalDailyCost = 0L;
		Float totalDailyClick = 0F;

		if (searchEngine == AdEngine.Google)
		{
			try
			{
				o2 = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, wordBidMap);
			}
			catch (Exception e)
			{
				logger.error("Failed to get Google traffic estimator data. " + e.getMessage(), e);
				// e.printStackTrace();
				throw new Exception("Failed to get Google traffic estimator data. " + e.getMessage(), e);
			}
			if (o2 != null)
			{
				String[] words = o2.getListOfKeywords();
				for (int i = 0; i < words.length; i++)
				{
					HashMap<Long, TrafficEstimatorObject.BidData> points = o2.getMapOfPoints(words[i], KeywordMatchType.EXACT.getValue());
					Iterator<Long> bidIT = points.keySet().iterator();
					while (bidIT.hasNext())
					{
						Long abid = bidIT.next();
						totalDailyClick += (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay()) / 2;
						totalDailyCost += (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost()) / 2;
					}
				}
				if (totalDailyClick > 0.01)
				{
					defaultMicroBid = (((Long) new Double(totalDailyCost.doubleValue() / totalDailyClick).longValue()) / 10000L) * 10000L;
					defaultMicroBid = Math.min(defaultMicroBid, maxDefaultMicroBid);
				}
			}

		} // if(searchEngine.equalsIgnoreCase(google))

		logger.info("Computed expected cpc and set default bid at " + defaultMicroBid);
		
		*/

		/* ******************************************************************************************* */
		// 11. [google] Database call: write adgroup criterion
		if (keywordDataObjs != null && keywordDataObjs.length > 0) {
			if (searchEngine == AdEngine.Google) {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write adgroup criterion data to database for Google.");
				try {
					SemplestDB.storeKeywordDataObjects(promotionID,AdEngine.Google, new ArrayList<KeywordDataObject>(Arrays.asList(keywordDataObjs)));
				} catch (Exception e) {
					logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to store Google adGroupCriterion data to database. "+ e.getMessage(), e);
					throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to store Google adGroupCriterion data to database. "+ e.getMessage(), e);
				}
			} // if(searchEngine.equalsIgnoreCase(google))

			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stored adgroup criterion data to database for Google");
		}
		
		/* ******************************************************************************************* */
		// 12. Database call: write traffic estimator data

		if (o != null) 
		{
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write traffic estimator data to the database for PromotionID [" + promotionID + "], AdEngine [" + searchEngine + "]");
			try {
				SemplestDB.storeTrafficEstimatorData(promotionID, searchEngine,o);
			} catch (Exception e) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to write traffic estimator data for PromotionID [" + promotionID + "], AdEngine [" + searchEngine + "]" + e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to write traffic estimator data "+ e.getMessage(), e);
			}
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stored traffic estimator data to database for PromotionID [" + promotionID + "], AdEngine [" + searchEngine + "]");
		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "No traffic estimator data to write to the database for PromotionID [" + promotionID + "], AdEngine [" + searchEngine + "]");
		}


		


		/* ******************************************************************************************* */
		// 13. Database call: write bid, matchType, competition status
		ArrayList<BidElement> bidsMatchType = new ArrayList<BidElement>();

		String competitiveType = "";
		String matchType = ProtocolEnum.SemplestMatchType.Exact.name();
		Boolean isActive = true;
		Boolean isNegative = false;

		Iterator<String> keyIT = wordBidMap.keySet().iterator();
		while (keyIT.hasNext()) {
			// TODO: Add Enum
			String word = keyIT.next();
			if (compKeywords.contains(word)) {
				competitiveType = ProtocolEnum.SemplestCompetitionType.Comp
						.name();
			} else if (notSelectedKeywords.contains(word)) {
				competitiveType = ProtocolEnum.SemplestCompetitionType.NotSelected
						.name();
			} else if (nonCompKeywords.contains(word)) {
				competitiveType = ProtocolEnum.SemplestCompetitionType.NonComp
						.name();
			} else if (noInfoKeywords.contains(word)) {
				competitiveType = ProtocolEnum.SemplestCompetitionType.NoInfo
						.name();
			} else {
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + 
						"Unknown competition type. Internal error in bidding service!");
			}
			bidsMatchType.add(new BidElement(word, wordIDMap.get(word),
					(wordBidMap.get(word) == null) ? defaultMicroBid
							: wordBidMap.get(word), matchType, competitiveType,
					wordBidMap.get(word) == null, isActive, isNegative));
		}

		try {
			if (bidsMatchType.size() > 0) {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write the bid data to the database...");
				SemplestDB.storeBidObjects(promotionID, searchEngine,
						bidsMatchType);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stroed bid data to the databse for "
						+ bidsMatchType.size() + " keywords.");
			} else {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "No bid data to write to the databse");
			}
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to store bid data to the database. "
					+ e.getMessage(), e);
			// e.printStackTrace();
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to store bid data to the database. "
					+ e.getMessage(), e);
		}
		
		
		
		

		/* ******************************************************************************************* */
		// 14. Database call: write default bid for campaign
		// remember to update the bids for the words with default bid with
		// database

		if (defaultMicroBid != SemplestDB.getDefaultBid(promotionID, searchEngine).getMicroDefaultBid())
		{
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write the default bid to the database.");
			SemplestDB.storeDefaultBid(promotionID, searchEngine, defaultMicroBid);
			SemplestDB.UpdateDefaultBidForKeywords(promotionID, searchEngine);
		}

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stroed default bid " + defaultMicroBid + " to databse and requested for updating all bids for keywords with default bid.");
		
		

		/* ******************************************************************************************* */
		// 15. Database call: write targeted daily budget etc
		try {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to store targeted daily budget data to the database.");
			SemplestDB.storeTargetedDailyBudget(promotionID, searchEngine,
					totalDailyCost, totalDailyClick.intValue());
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stroed targeted daily budget data to the databse.");
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + 
					"ERROR: Unable to store targeted daily budget data to the database. "
							+ e.getMessage(), e);
			// e.printStackTrace();
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + 
					"Failed to store targeted daily budget data to the database."
							+ e.getMessage(), e);
		}

		/* ******************************************************************************************* */
		// 16. SE API call: Update matchType, bid for keywords
		if (searchEngine == AdEngine.Google)
		{
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update bids with Google.");

			final List<GoogleSetBidForKeywordRequest> requests = new ArrayList<GoogleSetBidForKeywordRequest>(); 
			final Set<Entry<String, Long>> entrySet = wordBidMap.entrySet();
			for (final Entry<String, Long> entry : entrySet)
			{
				final String word = entry.getKey();
				final Long keywordID = wordIDMap.get(word);
				final Long microBidAmount = wordBidMap.get(word);
				if(microBidAmount==null){
					continue; // don't write via API is the bid is null
				}
				final GoogleSetBidForKeywordRequest request = new GoogleSetBidForKeywordRequest(adGroupID, word, keywordID, microBidAmount);
				requests.add(request);
			}
			final int batchSize = 500;
			final List<List<GoogleSetBidForKeywordRequest>> requestBatches = SemplestUtils.getBatches(requests, batchSize);
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Broke up " + requests.size() + " GoogleSetBidForKeywordRequests into " + requestBatches.size() + " batches of " + batchSize);
			for(final List<GoogleSetBidForKeywordRequest> requestBatch : requestBatches)
			{
				clientGoogle.setBidForKeyWords(googleAccountID, requestBatch);
			}
		} 

		if (searchEngine == AdEngine.MSN) {
			
			try {
				for(BidElement b : bidsMatchType){
					if(b.getIsDefaultValue()){
						b.setMicroBidAmount(null);
					}
				}
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update bids with MSN.");
				msnClient.updateKeywordBidsByIds(msnAccountID, adGroupID, bidsMatchType);
			} catch (Exception e) {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to update bids to MSN. "+ e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update bids to MSN. "+ e.getMessage(), e);
			}

		} // if(searchEngine.equalsIgnoreCase(msn))

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids and match type for keywords via the search engine API.");

		/* ******************************************************************************************* */
		// 17. SE API call: Update default bid for campaign
		if (searchEngine == AdEngine.Google){
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update default bid via search engine API. The default bid is "+defaultMicroBid);

			k = 0;
			while (true) {
				Thread.sleep(sleepPeriod + k * sleepBackOffTime);
				try {
					clientGoogle.updateDefaultBid(googleAccountID, adGroupID, defaultMicroBid);
					break;
				} catch (Exception e) {
					if (k <= maxRetry) {
						// e.printStackTrace();
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
						k++;
					} else {
						// e.printStackTrace();
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via Google API. " + e.getMessage(), e);
						throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via Google API. " + e.getMessage(), e);
					}
				} // try-catch
			} // while(true)
		}
		if(searchEngine == AdEngine.MSN){
			try{
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update default bid via search engine API. The default bid is "+defaultMicroBid);
				msnClient.updateAdGroupDefaultBids(msnAccountID, campaignID, adGroupID, Math.max(defaultMicroBid.doubleValue()*1e-6, 0.05), 0.05, 0.05);
			} catch(Exception e){
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via MSN API. " + e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via MSN API. " + e.getMessage(), e);
			}
		}
		
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated the default bid via search engine API. The default bid is "+defaultMicroBid);

		return new Boolean(true);

	} // setBidsInitial()
	
	
	
	

	public Boolean setBidsUpdate(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception {
		isFirstCall = false;
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "setBidsUpdate called!!");

		GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(promotionID);
		PromotionObj promotion = getPromoDataSP.getPromotionData();
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Promotion creation date: " + promotion.getCreatedDate());
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Promotion start date: "
				+ promotion.getPromotionStartDate());
		Date d = promotion.getPromotionStartDate();
		Date today = new Date();
		Long diff = today.getTime() - d.getTime();
		long age = diff / (1000 * 60 * 60 * 24);

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "The campaign started " + age + " day(s) ago.");

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Executing update bids method...");
		//return setBidsInitialWeek(promotionID, searchEngine, budgetData);
		if (age <=10 ) {
			if(age%2==0){
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Executing update bids method...");
				return setBidsInitialWeek(promotionID, searchEngine, budgetData);
			} else {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "setBidsUpdate not doing anything TODAY!!");
				return new Boolean(true);
			}
		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Logic to bid after 10th day is not implemented yet!!");
			return new Boolean(true);
		}
	} // setBidsUpdate()

	
	private TrafficEstimatorObject getTrafficEstimatorDataForMSN(Keyword[] kwList) throws Exception {
		TrafficEstimatorObject o=new TrafficEstimatorObject(), o2=null;
		ArrayList<Double> b = new ArrayList<Double>();
		ArrayList<String> keywords;
		
		b.add(0.05);
		double bid = 0.25;
		while(bid<10){
			b.add(bid);
			bid+=1.00;
		}
		
		Long[] bidsMoney = new Long[b.size()]; 
	    for(int f =0 ; f< b.size();f++){
	    	long bidL = (long) (b.get(f)*1000000);
	    	bidsMoney[f] = new Long(bidL);
	    }
		
	    int i=0; 
    	keywords = new ArrayList<String>();

	    while(i<kwList.length){
		      
	    	keywords.add(kwList[i].getText());
	    	i++;
	    	
	    	if(keywords.size()==1000 || i==kwList.length){
	    		try{
	    			o2 = msnClient.getKeywordEstimateByBids(msnAccountID, 
	    					keywords.toArray(new String[keywords.size()]), bidsMoney, MatchType.Exact);
	    		} catch (Exception e){
	    			logger.error( "Failed to get traffic estimator data via MSN API. " + e.getMessage(), e);
					throw new Exception( "Failed to get traffic estimator data via MSN API. " + e.getMessage(), e);
	    		}
	    		o.addGoogleTrafficEstimatorObject(o2, MatchType.Exact.toString());
	        	keywords = new ArrayList<String>();
	    	} 
	    }
	    
	    
	    for(String s : o.getListOfKeywords()){
			logger.info("Got Traffic estimator data for keyword "+s);
			
			EstimatorData clickDataObj = new EstimatorData();
			EstimatorData costDataObj = new EstimatorData();
			EstimatorData cpcDataObj = new EstimatorData();
			
			String matchType = ProtocolEnum.SemplestMatchType.Exact.name();
			HashMap<Long,BidData> points = o.getMapOfPoints(s, matchType);
			for(long abid : points.keySet()){
				clickDataObj.addData(abid / 1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay()) / 2);
				costDataObj.addData(abid / 1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/ (2 * 1e6));
				cpcDataObj.addData(abid / 1e6, (points.get(abid).getMaxAveCPC() + points.get(abid).getMinAveCPC())/ (2 * 1e6));
			}
			clickDataMap.put(s, clickDataObj);
			costDataMap.put(s, costDataObj);
			cpcDataMap.put(s, cpcDataObj);
	    }
	    
		return o;
	}
	
	private TrafficEstimatorObject getTrafficEstimatorDataForGoogle() throws Exception
	{

		// declare the variables
		TrafficEstimatorObject o, o2;
		int k;

		// get info for the first page CPC point
		HashMap<String, Long> bids = new HashMap<String, Long>();
		for (String s : compKeywords)
		{
			//bids.put(s, firstPageCPCMap.get(s) + stepFirst); // stepFirst above fp CPC
			bids.put(s, 500000L + stepFirst); // stepFirst above fp CPC

		}
		logger.info("Number of initial competitive keywords: " + bids.size());

		k = 0;
		while (true)
		{
			Thread.sleep(sleepPeriod + k * sleepBackOffTime);
			try
			{
				logger.info("Fetching traffic estimator data for Point 1");
				o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
				o2 = o;
				break;
			}
			catch (Exception e)
			{
				if (k <= maxRetry)
				{
					// e.printStackTrace();
					logger.error("Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
					k++;
				}
				else
				{
					// e.printStackTrace();
					logger.error("Failed to get traffic estimator data from Google after " + k + " efforts ." + e.getMessage(), e);
					throw new Exception("Failed to get traffic estimator data from Google after " + k + " efforts ." + e.getMessage(), e);
				}
			}
		}

		String[] words = o.getListOfKeywords();
		for (int i = 0; i < words.length; i++)
		{
			HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i], KeywordMatchType.EXACT.getValue());
			Iterator<Long> bidIT = points.keySet().iterator();
			while (bidIT.hasNext())
			{
				Long abid = bidIT.next();
//				if (points.get(abid).getMaxTotalDailyMicroCost() < 10000L)
//				{
//					
//					logger.info("Moving keyword \"" + words[i] + "\" to non-competitive category from competitive category.");
//					logger.info(words[i] + ": " + abid / 1e6 + ": " + points.get(abid).getMaxAveCPC() / 1e6 + ": "
//							+ points.get(abid).getMaxClickPerDay());
//					compKeywords.remove(words[i]);
//					nonCompKeywords.add(words[i]);
//					continue;
//					
//				}
//				else
//				{
					// logger.info(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);

					logger.info("Got valid data from traffic estimator for keyword \"" + words[i] + "\".");
					logger.info(words[i] + ": " + abid / 1e6 + ": " + points.get(abid).getMaxAveCPC() / 1e6 + ": "
							+ points.get(abid).getMaxClickPerDay());

					EstimatorData clickDataObj = new EstimatorData();
					clickDataObj.addData(abid / 1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay()) / 2);
					clickDataMap.put(words[i], clickDataObj);

					EstimatorData costDataObj = new EstimatorData();
					costDataObj.addData(abid / 1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())
							/ (2 * 1e6));
					costDataMap.put(words[i], costDataObj);
					
					EstimatorData cpcDataObj = new EstimatorData();
					cpcDataObj.addData(abid / 1e6, (points.get(abid).getMaxAveCPC() + points.get(abid).getMinAveCPC())
							/ (2 * 1e6));
					cpcDataMap.put(words[i], cpcDataObj);
//				}
			}
		}
		logger.info("Number of intermediate competitive keywords: " + compKeywords.size());
		if(compKeywords.size()==0){
			return o;
		}

		// get the second point
		bids = new HashMap<String, Long>();
		for (String s : compKeywords)
		{
			//bids.put(s, firstPageCPCMap.get(s) + stepSecond);
			bids.put(s, 500000L + stepSecond);
		}
		k = 0;
		while (true)
		{
			Thread.sleep(sleepPeriod + k * sleepBackOffTime);
			try
			{
				logger.info("Fetching traffic estimator data for Point 2");
				o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
				o2.addGoogleTrafficEstimatorObject(o, KeywordMatchType.EXACT.toString());
				break;
			}
			catch (Exception e)
			{
				if (k <= maxRetry)
				{
					// e.printStackTrace();
					logger.error("Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
					k++;
				}
				else
				{
					// e.printStackTrace();
					logger.error("Failed to get traffic estimator data from Google after " + k + " efforts " + e.getMessage(), e);
					throw new Exception("Failed to get traffic estimator data from Google after " + k + " efforts " + e.getMessage(), e);
				}
			}
		}

		words = o.getListOfKeywords();
		for (int i = 0; i < words.length; i++)
		{
			HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i], KeywordMatchType.EXACT.getValue());
			Iterator<Long> bidIT = points.keySet().iterator();
			while (bidIT.hasNext())
			{
				Long abid = bidIT.next();

				logger.info("Got valid data from traffic estimator for keyword \"" + words[i] + "\".");
				logger.info(words[i] + ": " + abid / 1e6 + ": " + points.get(abid).getMaxAveCPC() / 1e6 + ": " + points.get(abid).getMaxClickPerDay());

				EstimatorData clickDataObj = clickDataMap.get(words[i]);
				clickDataObj.addData(abid / 1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay()) / 2);
				clickDataMap.put(words[i], clickDataObj);

				EstimatorData costDataObj = costDataMap.get(words[i]);
				costDataObj.addData(abid / 1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())
						/ (2 * 1e6));
				costDataMap.put(words[i], costDataObj);
				
				EstimatorData cpcDataObj = cpcDataMap.get(words[i]);
				cpcDataObj.addData(abid / 1e6, (points.get(abid).getMaxAveCPC() + points.get(abid).getMinAveCPC())
						/ (2 * 1e6));
				cpcDataMap.put(words[i], cpcDataObj);

				logger.info(words[i] + ":: Total daily cost: $" + points.get(abid).getMaxTotalDailyMicroCost() / 1e6);

				/*
				 * // now check if we are getting the same data double []
				 * bidArray = costDataMap.get(words[i]).getBidArray();
				 * Arrays.sort(bidArray); double [] costArray =
				 * costDataMap.get(words[i]).getData(bidArray); if
				 * (Math.abs(costArray[0]-costArray[costArray.length-1])<1e-6){
				 * // System.out.println("Moving keyword \""+words[i]+
				 * "\" to non-competitive category from competitive category.");
				 * compKeywords.remove(words[i]); nonCompKeywords.add(words[i]);
				 * clickDataMap.remove(words[i]); costDataMap.remove(words[i]);
				 * continue; }
				 */

			}
		}

		// get the next 4 points uniformly (for the time being)
		for (int j = 2; j < 8; j++)
		{
			bids = new HashMap<String, Long>();
			for (String s : compKeywords)
			{
				//bids.put(s, firstPageCPCMap.get(s) + j * stepRest);
				bids.put(s, 500000L + j * stepRest);
			}
			System.out.println("j=" + j);
			k = 0;
			while (true)
			{
				Thread.sleep(sleepPeriod + k * sleepBackOffTime);
				try
				{
					logger.info("Fetching traffic estimator data for Point " + (j + 1));
					o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
					o2.addGoogleTrafficEstimatorObject(o, KeywordMatchType.EXACT.toString());
					break;
				}
				catch (Exception e)
				{
					if (k <= maxRetry)
					{
						// e.printStackTrace();
						logger.error("Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
						k++;
					}
					else
					{
						// e.printStackTrace();
						logger.error("Failed to get traffic estimator data from Google after " + k + " efforts " + e.getMessage(), e);
						throw new Exception("Failed to get traffic estimator data from Google after " + k + " efforts " + e.getMessage(), e);
					}
				}
			}
			words = o.getListOfKeywords();
			for (int i = 0; i < words.length; i++)
			{
				HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i], KeywordMatchType.EXACT.getValue());
				Iterator<Long> bidIT = points.keySet().iterator();
				while (bidIT.hasNext())
				{
					Long abid = bidIT.next();

					logger.info("Got valid data from traffic estimator for keyword \"" + words[i] + "\".");
					logger.info(words[i] + ": " + abid / 1e6 + ": " + points.get(abid).getMaxAveCPC() / 1e6 + ": "
							+ points.get(abid).getMaxClickPerDay());

					EstimatorData clickDataObj = clickDataMap.get(words[i]);
					clickDataObj.addData(abid / 1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay()) / 2);
					clickDataMap.put(words[i], clickDataObj);

					EstimatorData costDataObj = costDataMap.get(words[i]);
					costDataObj.addData(abid / 1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())
							/ (2 * 1e6));
					costDataMap.put(words[i], costDataObj);
					
					EstimatorData cpcDataObj = cpcDataMap.get(words[i]);
					cpcDataObj.addData(abid / 1e6, (points.get(abid).getMaxAveCPC() + points.get(abid).getMinAveCPC())
							/ (2 * 1e6));
					cpcDataMap.put(words[i], cpcDataObj);

					logger.info(words[i] + ":: Total daily cost: $" + points.get(abid).getMaxTotalDailyMicroCost() / 1e6);

				}
			}
		} // for( int j=0; j<4; j++)

		for (int i = 0; i < words.length; i++)
		{
			// now check if we are getting the same data
			double[] bidArray = costDataMap.get(words[i]).getBidArray();
			Arrays.sort(bidArray);
			double[] cpcArray = cpcDataMap.get(words[i]).getData(bidArray);
			// if (Math.abs(costArray[0]-costArray[costArray.length-1])<1e-6){
			if (cpcArray[cpcArray.length - 1] < cpcArray[0] + 1e-4)
			{
				logger.info("Moving keyword \"" + words[i] + "\" to non-competitive category from competitive category.");
				compKeywords.remove(words[i]);
				nonCompKeywords.add(words[i]);
				clickDataMap.remove(words[i]);
				costDataMap.remove(words[i]);
				cpcDataMap.remove(words[i]);
				continue;
			}
		}

		logger.info("Number of final competitive keywords: " + compKeywords.size());

		return o2;
	}

	private TrafficEstimatorObject getTrafficEstimationForKeywordsGoogle(String accountID, Long campaignID, KeywordMatchType matchType,
			HashMap<String, Long> KeywordWithBid) throws Exception
	{
		// HashMap<String, Long> KeywordWithBid, GoogleAdwordsServiceImpl
		// client) throws Exception {
		// HashMap<String, Double> KeywordWithBid, GoogleAdwordsServiceClient
		// client) throws Exception {

		TrafficEstimatorObject o = null, o2 = null;
		int i = 0, k;
		boolean firstLoop = true;

		HashMap<String, Long> newKeywordWithBid = new HashMap<String, Long>();
		Iterator it = KeywordWithBid.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry me = (Map.Entry) it.next();
			String s = (String) me.getKey();
			if (KeywordWithBid.get(s) != null)
			{
				newKeywordWithBid.put(s, KeywordWithBid.get(s));
				i++;
			}
			if ((i % 500 == 0 && i > 0) || (!it.hasNext()))
			{
				k = 0;
				while (true)
				{
					try
					{
						if (newKeywordWithBid.size() > 0)
						{
							Thread.sleep(sleepPeriod + k * sleepBackOffTime);
							logger.info("Calling Google API for traffic estimator data.");
							o2 = clientGoogle.getTrafficEstimationForKeywords(accountID, campaignID, matchType, newKeywordWithBid);
							logger.info("Returned from Google API call.");
						}
						break;
					}
					catch (Exception e)
					{
						if (k <= maxRetry)
						{
							// e.printStackTrace();
							logger.error("Received exception : will retry..., k=" + k + " " + e.getMessage(), e);
							k++;
						}
						else
						{
							// e.printStackTrace();
							logger.error("Failed to get traffic estimator data from Google after " + k + " efforts " + e.getMessage(), e);
							throw new Exception("Failed to get traffic estimator data from Google after " + k + " efforts " + e.getMessage(), e);
						}
					}
				}
				newKeywordWithBid.clear();
				if (firstLoop || o == null)
				{
					o = o2;
					firstLoop = false;
					logger.info("First loop for this bid point.");
				}
				else
				{
					o.addGoogleTrafficEstimatorObject(o2, KeywordMatchType.EXACT.getValue());
					logger.info("Added data for this bid point.");
				}
			} // if(i/500==0)
		} // while(it.hasNext())

		return o;

	}

	

	public static void main(String[] args)
	{

		// String accountID = "2188810777"; // small campaign : 100 words
		// String accountID = "9544523876";
		// String accountID = "1283163526526"; // large capmaign : 1500 words

		// String accountID = "4764852610"; // teststudiobloom;
		// String accountID = "9036397375"; // bethflowers
		// String accountID = "6870692153"; // piperhall

		// String accountID = "1851386728"; // ParkWinters

		BasicConfigurator.configure();

		/*
		 * 
		 * //// ArrayList<String> lines =
		 * ioUtils.readFile("/semplest/data/biddingTest/Test1/keywords.txt"); //
		 * ArrayList<String> lines =
		 * ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb.txt"
		 * ); ArrayList<String> lines =
		 * ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb500.txt"
		 * ); ArrayList<String> keywords = new ArrayList<String>();
		 * 
		 * for (String line : lines){ line=line.replaceFirst("\\S+\\s+", "") ;
		 * // for the new format keywords.add(line.replaceAll("\n","")); //
		 * System.out.println(line); }
		 * 
		 * // System.exit(0);
		 */

		/*
		 * 
		 * try {
		 * 
		 * // GoogleAdwordsServiceClient client = new
		 * GoogleAdwordsServiceClient(null); GoogleAdwordsServiceImpl client =
		 * new GoogleAdwordsServiceImpl();
		 * 
		 * 
		 * ArrayList<HashMap<String, String>> campaignsByAccountId =
		 * client.getCampaignsByAccountId(accountID, false); Long campaignID =
		 * new Long(campaignsByAccountId.get(0).get("Id"));
		 * System.out.println(campaignID);
		 * 
		 * GoogleAdGroupObject[] adGroups = null;
		 * 
		 * try { adGroups = client.getAdGroupsByCampaignId(accountID,
		 * campaignID, false); for (int i=0; i< adGroups.length; i++)
		 * System.out.
		 * println(adGroups[i].getAdGroupName()+": "+adGroups[i].getAdGroupID
		 * ()); } catch (Exception e) { logger.info("Problem", e); }
		 * 
		 * Long adGroupID = adGroups[0].getAdGroupID();
		 * 
		 * 
		 * 
		 * BidGeneratorObj bidGenerator = new BidGeneratorObj(); //
		 * bidGenerator.getBid(accountID, campaignID, adGroupID, keywords);
		 * bidGenerator.getBidsInitialGoogle(accountID, campaignID, adGroupID);
		 * 
		 * } catch (Exception e) { logger.info("Problem", e); }
		 */

		try
		{

			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}

			
			//System.out.println("Testing inital bidding!");

			BidGeneratorObj bidObject = new BidGeneratorObj();

			
			AdEngine searchEngine = AdEngine.MSN;
			
			
			Integer promotionID = new Integer(136);
			BudgetObject budgetData = new BudgetObject();
			budgetData.setRemainingBudgetInCycle(100.0);
			budgetData.setRemainingDays(31);
			//bidObject.setBidsInitial(promotionID, searchEngine, budgetData);
			//bidObject.setBidsUpdate(promotionID, searchEngine, budgetData);
			bidObject.setBidsInitialWeek(promotionID, searchEngine, budgetData);


			
			AdEngineID adEngineInfo = SemplestDB.getAdEngineID(promotionID, searchEngine);
			
			String accountID = null;
			Long msnAccountID = null;
			if(searchEngine.equals(AdEngine.Google)){
				accountID = String.valueOf(adEngineInfo.getAccountID());
			} else {
				msnAccountID = adEngineInfo.getAccountID();
			}

			long campaignID = adEngineInfo.getCampaignID();
			long adGroupID = adEngineInfo.getAdGroupID();
			
			if(searchEngine.equals(AdEngine.Google)){
				System.out.println("Google "+accountID+" "+campaignID+" "+adGroupID);
			} else {
				System.out.println("MSN "+msnAccountID+" "+campaignID+" "+adGroupID);
			}
			
		
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			//Date startDate = df.parse("05/01/2012");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date startDate = cal.getTime();
			//cal.add(Calendar.DAY_OF_MONTH, -1);
			//Date endDate = cal.getTime();
			//Date endDate = new Date(); //df.parse("07/21/2012");
			
			
//			// get report from the database
//			List<ReportObject> reportObjListYesterday;
//			try {
//				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to get the report data from the database.");
//				reportObjListYesterday = SemplestDB.getReportData(promotionID, searchEngine, startDate, startDate);
//				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got report data from the database with "+reportObjListYesterday.size()+" entries.");
//			} catch (Exception e) {
//				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to get the report data from the database. "+ e.getMessage(), e);
//				// e.printStackTrace();
//				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get the report data from the database. "+ e.getMessage(), e);
//			}
			
			
//			Integer promotionID = new Integer(33);
//			BudgetObject budgetData = new BudgetObject();
//			budgetData.setRemainingBudgetInCycle(45.0);
//			budgetData.setRemainingDays(31);
//			bidObject.setBidsInitial(promotionID, ProtocolEnum.AdEngine.MSN, budgetData);

			
//			long presentDefaultMicroBid = SemplestDB.getDefaultBid(promotionID, searchEngine).getMicroDefaultBid();
//			SemplestDB.storeDefaultBid(promotionID, searchEngine, presentDefaultMicroBid);
//			SemplestDB.UpdateDefaultBidForKeywords(promotionID, searchEngine);
//			
//			
//			Date today = new Date();
//			
//			List<BidElement> bidData = SemplestDB.getLatestBids(promotionID, searchEngine);
//			for(BidElement b : bidData){
//				
//				Date d = b.getStartDate();
//				Long diff = today.getTime() - d.getTime();
//				long unchangedForDays = diff / (1000 * 60 * 60 * 24);
//				if(b.getIsDefaultValue() && b.getIsActive()){
//					System.out.println(b.getKeyword()+": "+b.getMicroBidAmount()+", "+unchangedForDays+", "+b.getStartDate());
//				}
////				if(unchangedForDays>=2){
////					System.out.println(b.getKeyword()+": "+b.getMicroBidAmount()+", "+unchangedForDays+", "+b.getStartDate());
////				}
//			}
			

			
			
//			SemplestDB.storeBidObjects(promotionID, ProtocolEnum.AdEngine.Google,  bidData );
//			bidData = (ArrayList<BidElement>) SemplestDB.getLatestBids(promotionID, ProtocolEnum.AdEngine.Google);
//
//			for(BidElement b : bidData){
//				System.out.println(b.getKeyword()+": "+b.getCompetitionType()+", "+b.getMicroBidAmount());
//			}
			


			
//			ReportObject[] reportObjList = null;
//						
//			if(searchEngine.equals(AdEngine.Google)){
//				Date now = new Date();
//				SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(now);
//				cal.add(Calendar.DAY_OF_MONTH, -1);
//				GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();
//				reportObjList = client.getReportForAccount(accountID, YYYYMMDD.format(cal.getTime()), YYYYMMDD.format(now));
//			} else {
//				MsnCloudServiceImpl msnClient = new MsnCloudServiceImpl();
//				//reportObjListMSN = msnClient.getKeywordReport(msnAccountID, campaignID, YYYYMMDD.format(cal.getTime()), YYYYMMDD.format(now));
//			}
//
//			
//			System.out.println("Number of report entries: "+reportObjList.length);
			
			/*
			System.out.println(SemplestDB.getDefaultBid(promotionID, searchEngine).getDefaultBidEditedDate());
			SemplestDB.storeDefaultBid(promotionID, searchEngine, SemplestDB.getDefaultBid(promotionID, searchEngine).getMicroDefaultBid());
			System.out.println(SemplestDB.getDefaultBid(promotionID, searchEngine).getDefaultBidEditedDate());
			*/
	
			
			/*
			GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			PromotionObj promotion = getPromoDataSP.getPromotionData();
			System.out.println(promotion.getCreatedDate());
			System.out.println(promotion.getPromotionStartDate());
			Date d = promotion.getPromotionStartDate();
			Date today = new Date();
			Long diff = today.getTime() - d.getTime();
			//System.out.println(d.getDate());

		    System.out.println("The 21st century (up to " + today + ") is "
		        + (diff / (1000 * 60 * 60 * 24)) + " days old.");
			*/
			
			
		
			
		}
		catch (Exception e)
		{
			logger.info("Problem", e);
		}

	}

}
