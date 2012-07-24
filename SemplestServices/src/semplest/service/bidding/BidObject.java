package semplest.service.bidding;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
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
import semplest.bidding.optimization.KeyWord;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.PromotionBiddingType;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.SemplestBiddingHistory;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject.BidData;
import semplest.server.protocol.bidding.AdEngineBidHistoryData;
import semplest.server.protocol.bidding.BiddingParameters;
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
import com.microsoft.adcenter.v8.Keyword;

public class BidObject
{
	private String networkSetting = ProtocolEnum.NetworkSetting.SearchOnly.name();

	// private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidObject.class);

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
	int targetPosition = 3;

	private GoogleAdwordsServiceImpl clientGoogle;
	private MsnCloudServiceImpl msnClient;
	private KeywordDataObject[] keywordDataObjs;
	private KeywordDataObject keywordDataObj;

	//private HashMap<String, Long> wordIDMap;
	//private HashMap<String, Long> wordBidMap;
	private Map<Long,Double> wordIDBidMap;

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
	
	final String exactString = ProtocolEnum.SemplestMatchType.Exact.name();
	final String phraseString = ProtocolEnum.SemplestMatchType.Phrase.name();
	final String broadString = ProtocolEnum.SemplestMatchType.Broad.name();
	
	final String compeWordStr = ProtocolEnum.SemplestCompetitionType.Comp.name();
	final String nonCompeWordStr = ProtocolEnum.SemplestCompetitionType.NonComp.name();



	public BidObject() throws Exception
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
		
		//final Integer targetPositionInteger = (Integer) SemplestConfiguration.configData.get("SemplestBiddingTargetPosition");
		//targetPosition = targetPositionInteger.intValue();
		
		

		 

		//wordIDMap = new HashMap<String, Long>();
		//wordBidMap = new HashMap<String, Long>();
		//wordIDBidMap = new HashMap<Long,Double>();

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
			adEngineInitialDataObject.setSemplestMatchType(exactString);
			adEngineInitialDataObject.setNetworkSetting(networkSetting);
			
			double seMonthlyBudget = totalMonthlyBudget*budgetMap.get(se)/100.0 * budgetBoost;
			double seDailyBudget = seMonthlyBudget/30*budgetFactor;
			
			adEngineInitialDataObject.setMonthlyBudget(seMonthlyBudget);
			adEngineInitialDataObject.setDailyBudget(seDailyBudget);
			
			long defBid = Math.max(50000L,Math.min(defaultMicroBid, (new Double(seDailyBudget*0.95*1e-6)).longValue()/10000L * 10000L));
			
			adEngineInitialDataObject.setDefaultMicroBid(defBid);

			//SemplestDB.storeDefaultBid(promotionID, se, defBid);
			initValues.put(se, adEngineInitialDataObject);
		}
		return initValues;
	}
	

	
	


	
	
	

	public Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception
	{

		/* ******************************************************************************************* */

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "setBidsInitial called for ad engine " + searchEngine);


		/* ******************************************************************************************* */
		// 1. Database call: get campaign specific IDs
		
		getCampaignIDsFromDatabase(promotionID, searchEngine);
		
		
		
		
		/* ******************************************************************************************* */
		// 2. Database call: get present bid info
		
		// get present bid status from database
		List<BidElement> bidElementList = getBidDataFromDatabase(promotionID, searchEngine);

		// create a hash map for faster access
		HashMap<Long,BidElement> kwIDBidElementMap = new HashMap<Long,BidElement>();
		for(BidElement b : bidElementList){
			if(b.getIsActive()){
				kwIDBidElementMap.put(b.getKeywordAdEngineID(), b.clone());
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + kwIDBidElementMap.get(b.getKeywordAdEngineID()));
			}
		}


		
		
		/* ******************************************************************************************* */
		// 3. MSN call to get average statistics
		
		// Remember that is data is fetched for a specific targetPosition 
		BiddingParameters  bidParams = SemplestDB.getBiddingParameters();
		targetPosition = bidParams.getBiddingServiceTargetPosition();
		List<AdEngineBidHistoryData>  historyDataList = getBidHistoryData(promotionID, searchEngine, kwIDBidElementMap);
		
		
		
		
		/* ******************************************************************************************* */
		// 4. Sort the words based on CPC
		
		Collections.sort(historyDataList); // the comparator uses CPC values for compareTo
		
		
		
		
		/* ******************************************************************************************* */
		// 5. Compute bids
		
		// the following method call updates the wordIDBidMap with appropriate bids
		// sets bids for all unused keywords at the max CPC seen so far
		double computedDefaultBid = computeBidsGreedy(promotionID, searchEngine, historyDataList, kwIDBidElementMap);
		defaultMicroBid = getMicroBid(computedDefaultBid);
		
		
		
		
		
		/* ******************************************************************************************* */
		// 6. Database call: store bid data
		
		//storeBidDataToDatabase(promotionID, searchEngine, kwIDBidElementMap);
		
		
		
		
		/* ******************************************************************************************* */
		// 7. Database call: update default bid 
		
		//updateDefaultBidInDatabase(promotionID, searchEngine);

		
		
		
		/* ******************************************************************************************* */
		// 8. SE API call: Update matchType, bid for keywords
		
		//updateBidswithSE(promotionID, searchEngine, kwIDBidElementMap);
		
		
		
		
		/* ******************************************************************************************* */
		// 9. SE API call: Update default bid for campaign
		
		//updateDefaultBidWithSE(promotionID, searchEngine, computedDefaultBid);

			


		/* ******************************************************************************************* */
		// 10. Write to database: Initital bidding is done
		
		//SemplestDB.setSemplestBiddingHistory(promotionID, searchEngine, PromotionBiddingType.Initial);
		
		
		
		

		
		
		return new Boolean(true);

	} // setBidsInitial()
	
	
	
	

	private void updateDefaultBidWithSE(Integer promotionID, AdEngine searchEngine, Double computedDefaultBid) throws Exception {
		if (searchEngine == AdEngine.Google){
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update default bid via search engine API. The default bid is "+defaultMicroBid);

			try {
				clientGoogle.updateDefaultBid(googleAccountID, adGroupID, Math.max(50000L,defaultMicroBid));
			} catch (Exception e) {
				logger.error( "[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update default microBid via Google API. " + e.getMessage(), e);
				throw new Exception( "[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update default microBid via Google API. " + e.getMessage(), e);

			} // try-catch
		}
	
		if(searchEngine == AdEngine.MSN){
			try{
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update default bid via search engine API. The default bid is $"+computedDefaultBid);
				msnClient.updateAdGroupDefaultBids(msnAccountID, campaignID, adGroupID, computedDefaultBid, computedDefaultBid, computedDefaultBid);
			} catch(Exception e){
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via MSN API. " + e.getMessage(), e);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" +  "Failed to update default microBid via MSN API. " + e.getMessage(), e);
			}
		}

		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated the default bid via search engine API. The default bid is "+defaultMicroBid);

	
		
	}

	private void updateBidswithDatabase(Integer promotionID, AdEngine searchEngine, HashMap<Long, BidElement> kwIDBidElementMap) throws Exception {
		if(wordIDBidMap.size()>0) {
			if (searchEngine == AdEngine.Google)
			{
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update bids with Google for " + wordIDBidMap.size() + " keywords.");

				final List<GoogleSetBidForKeywordRequest> requests = new ArrayList<GoogleSetBidForKeywordRequest>(); 
				final Set<Entry<Long, Double>> entrySet = wordIDBidMap.entrySet();
				for (final Entry<Long, Double> entry : entrySet)
				{
					final Long keywordID = entry.getKey();
					final String word = kwIDBidElementMap.get(keywordID).getKeyword();

					final Long microBidAmount = getMicroBid(wordIDBidMap.get(keywordID));
					final GoogleSetBidForKeywordRequest request = new GoogleSetBidForKeywordRequest(adGroupID, word, keywordID, microBidAmount);
					requests.add(request);
				}
				final int batchSize = 500;
				final List<List<GoogleSetBidForKeywordRequest>> requestBatches = SemplestUtils.getBatches(requests, batchSize);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Broke up " + requests.size() + " GoogleSetBidForKeywordRequests into " + requestBatches.size() + " batches of " + batchSize);
				for(final List<GoogleSetBidForKeywordRequest> requestBatch : requestBatches)
				{
					try{
						clientGoogle.setBidForKeyWords(googleAccountID, requestBatch);
					} catch (Exception e){
						logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Unable to update Google API."+ e.getMessage(), e);
						throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Unable to update Google API."+ e.getMessage(), e);
					}
				}
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids with Google for " + wordIDBidMap.size() + " keywords.");

			} 

			if (searchEngine == AdEngine.MSN) {

				try {
					List<BidElement> bidDataToMSN = new ArrayList<BidElement>();
					final Set<Entry<Long, Double>> entrySet = wordIDBidMap.entrySet();
					for (final Entry<Long, Double> entry : entrySet){
						final Long wordID = entry.getKey();
						bidDataToMSN.add(kwIDBidElementMap.get(wordID));
						logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Keyword: "+kwIDBidElementMap.get(wordID).getKeyword()+", Microbid: "+kwIDBidElementMap.get(wordID).getMicroBidAmount()+", Kyeword ID: "+wordID);
					}

					logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to update bids with MSN for " + bidDataToMSN.size() + " keywords.");
					msnClient.updateKeywordBidsByIds(msnAccountID, adGroupID, bidDataToMSN);
					logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids with MSN for " + bidDataToMSN.size() + " keywords.");

				} catch (Exception e) {
					logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to update bids to MSN. "+ e.getMessage(), e);
					throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to update bids to MSN. "+ e.getMessage(), e);
				}

			} // if(searchEngine.equalsIgnoreCase(msn))

			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Updated bids and match type for keywords via the search engine API.");
		} else {
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "No bids to update via the search engine API.");
		}

		
		
	}

	private void updateDefaultBidInDatabase(Integer promotionID, AdEngine searchEngine) throws Exception {
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
		
	}

	private void storeBidDataToDatabase(Integer promotionID, AdEngine searchEngine, HashMap<Long, BidElement> kwIDBidElementMap) throws Exception {
		try {
			if(kwIDBidElementMap!=null && kwIDBidElementMap.size()>0){
				List<BidElement> bidElementList = new ArrayList<BidElement>();
				for(long l : kwIDBidElementMap.keySet()){
					bidElementList.add(kwIDBidElementMap.get(l));
				}
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to write " +kwIDBidElementMap.size() + "  bid data to the database...");
				SemplestDB.storeBidObjects(promotionID, searchEngine,bidElementList);
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Stroed bid data to the database for "+ bidElementList.size() + " keywords.");
			} else {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "No bid data to write to the database.");
			}
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to store bid data to the database. "+ e.getMessage(), e);
			// e.printStackTrace();
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to store bid data to the database. "+ e.getMessage(), e);
		}
		
	}

	private double computeBidsGreedy(Integer promotionID, AdEngine searchEngine, List<AdEngineBidHistoryData> historyDataList, 
			HashMap<Long, BidElement> kwIDBidElementMap) throws Exception {
		
		wordIDBidMap = new HashMap<Long,Double>();

		if(historyDataList.size()!=kwIDBidElementMap.keySet().size()){
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Was expecting historyDataList and kwIDBidElementMap to have same size!");
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Was expecting historyDataList and kwIDBidElementMap to have same size!");
		}
		// construct 3 different maps for word to ID map
		HashMap<String, Long> exactWordIDMap = new HashMap<String, Long>();
		HashMap<String, Long> phraseWordIDMap = new HashMap<String, Long>();
		HashMap<String, Long> broadWordIDMap = new HashMap<String, Long>();
		for(long l : kwIDBidElementMap.keySet()){
			if(kwIDBidElementMap.get(l).getMatchType().equalsIgnoreCase(exactString)){
				exactWordIDMap.put(kwIDBidElementMap.get(l).getKeyword(), l);
			} else if(kwIDBidElementMap.get(l).getMatchType().equalsIgnoreCase(phraseString)){
				phraseWordIDMap.put(kwIDBidElementMap.get(l).getKeyword(), l);
			} else if(kwIDBidElementMap.get(l).getMatchType().equalsIgnoreCase(broadString)){
				broadWordIDMap.put(kwIDBidElementMap.get(l).getKeyword(), l);
			} else {
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Invalid matchtype: "+kwIDBidElementMap.get(l));
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Invalid matchtype: "+kwIDBidElementMap.get(l));
			}
		}
		
		double dailyBudget = 0.0;
		try{
			dailyBudget = SemplestDB.GetCurrentDailyBudget(promotionID, searchEngine);
		} catch (Exception e) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Unable to get the daily budget from the database. "+ e.getMessage(), e);
			// e.printStackTrace();
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Failed to get the daily budget from the database. "+ e.getMessage(), e);
		}
		double maxBid = dailyBudget;
		if(maxBid<=0.05) {
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Daily budget is too low to do anything with this adgroup...");
			//return true;
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Daily budget is too low to do anything with this adgroup...");
		}
		final Double maxBidDouble = new Double(maxBid * 0.95);
		
				
		double amountSpent = 0.0;
		final double daysInMonth = 30.0;
		double maxBidValue = 0.0;
		double computedDefaultBid = 0.0;
		
		List<Double> bidsList = new ArrayList<Double>();
		
		for(int i=0; i<historyDataList.size(); i++){
			AdEngineBidHistoryData statData = historyDataList.get(i);
			
			
			Long wordID = null;
			if(statData.getMatchType().equalsIgnoreCase(exactString)){
				wordID=exactWordIDMap.get(statData.getKeyword());
			} else if(statData.getMatchType().equalsIgnoreCase(phraseString)){
				wordID=phraseWordIDMap.get(statData.getKeyword());
			} else if(statData.getMatchType().equalsIgnoreCase(broadString)){
				wordID=broadWordIDMap.get(statData.getKeyword());
			}
			if(wordID==null){
				logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "ERROR: Couldn't find word ID for "+statData);
				throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Couldn't find word ID for "+statData);
			}
			
			if(statData.getAvgBid()==null || statData.getAvgCPC()==null || statData.getClicks()==null || statData.getAvgCPC() < 0.01){
				kwIDBidElementMap.get(wordID).setCompetitionType(nonCompeWordStr);
				continue;
			} else {
				kwIDBidElementMap.get(wordID).setCompetitionType(compeWordStr);
			}
			
			//logger.info(statData.getAvgCPC()+", "+statData.getAvgBid());
			
			double bidValue = Math.min(maxBidDouble, statData.getAvgBid());
			amountSpent+=statData.getAvgCPC() * (bidValue/statData.getAvgBid()) * statData.getClicks()/daysInMonth; // check

			wordIDBidMap.put(wordID, bidValue);
			kwIDBidElementMap.get(wordID).setMicroBidAmount(getMicroBid(bidValue));
			kwIDBidElementMap.get(wordID).setIsDefaultValue(false);
			bidsList.add(bidValue);
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Bid for " + kwIDBidElementMap.get(wordID).getKeyword()+": "+bidValue);
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Budget used so far $"+amountSpent+" of total daily budget $"+dailyBudget);

			
			if(bidValue>maxBidValue){
				maxBidValue = bidValue;
			}
			if(amountSpent>=dailyBudget){
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Expected cost "+ amountSpent +"exceeds daily budget "+ dailyBudget +". Hence breaking.");
				break;
			} 	
		}
		
		Collections.sort(bidsList);
		computedDefaultBid = bidsList.get(bidsList.size()/2);
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Now going to set default bid " + computedDefaultBid + " for all other keywords.");
		for(long l : kwIDBidElementMap.keySet()){
			if(!wordIDBidMap.containsKey(l)){
				kwIDBidElementMap.get(l).setMicroBidAmount(getMicroBid(computedDefaultBid));
				kwIDBidElementMap.get(l).setIsDefaultValue(true);
			}
		}
		
		return Math.max(0.05, computedDefaultBid);
	}

	private Long getMicroBid(double bidValue) {
		return new Long((new Double(bidValue*1e6)).longValue() / 10000L * 10000L);
	}

	private List<AdEngineBidHistoryData> getBidHistoryData(Integer promotionID, AdEngine searchEngine, HashMap<Long, BidElement> kwIDBidElementMap) throws Exception{
		Map<String, ProtocolEnum.SemplestMatchType> keywordMatchType = new HashMap<String, ProtocolEnum.SemplestMatchType>();
		for(Long l : kwIDBidElementMap.keySet()){
			String matchTypeString = kwIDBidElementMap.get(l).getMatchType();
			ProtocolEnum.SemplestMatchType matchType = null;
			if(matchTypeString.equalsIgnoreCase(exactString)){
				matchType = ProtocolEnum.SemplestMatchType.Exact;
			}
			if(matchTypeString.equalsIgnoreCase(phraseString)){
				matchType = ProtocolEnum.SemplestMatchType.Phrase;
			}
			if(matchTypeString.equalsIgnoreCase(broadString)){
				matchType = ProtocolEnum.SemplestMatchType.Broad;
			}
			keywordMatchType.put(kwIDBidElementMap.get(l).getKeyword(), matchType);
		}
		List<AdEngineBidHistoryData> historyData = null; 
		try{
			logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Trying to get bid history data from MSN for "+ keywordMatchType.size()+ " words.");
			historyData = msnClient.getBidHistoryData(keywordMatchType, targetPosition);
			if(historyData!=null) {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Got bid history data from MSN for "+ historyData.size()+ " words.");
			} else {
				logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Bid history call returned null.");
			}
		} catch(Exception e){
			logger.error("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Unable to get bid history data from MSN.");
			throw new Exception("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]" + "Unable to get bid history data from MSN.");
		}
		return historyData;
	}

	private List<BidElement> getBidDataFromDatabase(Integer promotionID, AdEngine searchEngine) throws Exception {
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
		return bidData;
	}

	private void getCampaignIDsFromDatabase(Integer promotionID, AdEngine searchEngine) throws Exception{
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
		
	}

	
	
	


	

	public static void main(String[] args)  throws CloneNotSupportedException
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

			BidObject bidObject = new BidObject();

			
			AdEngine searchEngine = AdEngine.Google;
			
			
			Integer promotionID = new Integer(175);
			BudgetObject budgetData = new BudgetObject();
			budgetData.setRemainingBudgetInCycle(100.0);
			budgetData.setRemainingDays(31);
			bidObject.setBidsInitial(promotionID, searchEngine, budgetData);
			//bidObject.setBidsUpdate(promotionID, searchEngine, budgetData);
			//bidObject.setBidsInitialWeek(promotionID, searchEngine, budgetData);


			List<SemplestBiddingHistory> bidHistory= SemplestDB.getSemplestBiddingHistory(promotionID, searchEngine);
			System.out.println(bidHistory.size());
//			System.out.println(bidHistory.get(0).getSemplestBidType()+": "+bidHistory.get(0).getBidCompleted());
//			
//			Date now = new Date();
//			Date initialBidDate = bidHistory.get(0).getBidCompleted();
//			System.out.println(initialBidDate.compareTo(now));
//			System.out.println(now.compareTo(initialBidDate));
//
//			System.out.println(now.after(initialBidDate));
//			System.out.println(now.before(initialBidDate));

			
			
			/*
			
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
			
			
			List<BidElement> bidData = SemplestDB.getLatestBids(promotionID, searchEngine);
			System.out.println(bidData.size());

			HashSet<String> wordSet = new HashSet<String>();
			for(BidElement b : bidData){
				wordSet.add(b.getKeyword());
				System.out.println(b.getKeyword()+": "+b.getKeywordAdEngineID());
			}
			System.out.println(wordSet.size());
		

			 */
			
			
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(new Date());
//			cal.add(Calendar.DAY_OF_MONTH, -1);
//			Date startDate = cal.getTime();
			
			
			
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

					
//			List<BidElement> bidData = SemplestDB.getLatestBids(promotionID, searchEngine);
//			System.out.println(bidData.size());
//
//			for(BidElement b : bidData){
//				System.out.println(b.getKeyword()+": "+b.getKeywordAdEngineID()+", "+b.getStartDate());
//				
////				Date d = b.getStartDate();
////				Long diff = today.getTime() - d.getTime();
////				long unchangedForDays = diff / (1000 * 60 * 60 * 24);
////				if(b.getIsDefaultValue() && b.getIsActive()){
////					System.out.println(b.getKeyword()+": "+b.getMicroBidAmount()+", "+unchangedForDays+", "+b.getStartDate());
////				}
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





