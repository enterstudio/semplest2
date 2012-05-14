package semplest.service.bidding;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.bidding.estimation.EstimatorData;
import semplest.bidding.optimization.CampaignBid;
import semplest.bidding.optimization.KeyWord;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
//import semplest.server.protocol.ProtocolEnum.SemplestMatchType;
//import semplest.server.protocol.ProtocolEnum.SemplestCompetitionType;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;

import com.google.api.adwords.v201109.cm.KeywordMatchType;
//import com.google.gson.Gson;

public class BidGeneratorObj {
	
	
	private String google = ProtocolEnum.AdEngine.Google.name();
	private String msn = ProtocolEnum.AdEngine.MSN.name();
	
	private String networkSetting = ProtocolEnum.NetworkSetting.SearchOnly.name();
	
	
	//private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidGeneratorObj.class);
	
	

	private int maxRetry = 10; // maximum number of times we will
	private int sleepPeriod = 500; // in millisecond
	private int sleepBackOffTime = 1000; // after k-th failure wait for sleepPeriod + k*sleepBackOffTime ms
	
	private Long maxMicroBid = 3000000L; 
	private Long stepAboveFpCPC = 500000L;
	private Long defaultMicroBid = 1000000L;
	private Long maxDefaultMicroBid = 1500000L; 

	
	// traffic estimator bid steps
	private Long stepFirst = 100000L; 
	private Long stepSecond = 600000L;
	private Long stepRest = 800000L;

	
	private String googleAccountID = null;
	private Long msnAccountID = null;
	private Long campaignID;
	private Long adGroupID;
	
	private GoogleAdwordsServiceImpl clientGoogle;
	private KeywordDataObject[] keywordDataObjs;
	private KeywordDataObject keywordDataObj;
	
	private HashMap<String,Long> wordIDMap;
	private HashMap<String,Long> wordBidMap;

	
	private HashMap<String,Long> firstPageCPCMap;
	private HashMap<String,Double> qualityScoreMap;
	
	private HashSet<String> compKeywords; // competitive
	private HashSet<String> nonCompKeywords; // non-competitive
	private HashSet<String> noInfoKeywords; // competitive but no-info
	private HashSet<String> notSelectedKeywords; // competitive but not selected by optimizer
	
	/*
	private HashMap<String,Long> compKeywordBids; // competitive
	private HashMap<String,Long> nonCompKeywordBids; // non-competitive
	private HashMap<String,Long> noInfoKeywordBids; // competitive but no-info
	private HashMap<String,Long> notSelectedKeywordBids; // competitive but not selected by optimizer
		*/
		
	private HashMap<String,EstimatorData> clickDataMap = new HashMap<String,EstimatorData>();
	private HashMap<String,EstimatorData> costDataMap = new HashMap<String,EstimatorData>();
	
	public BidGeneratorObj(){ // constructor
		try
		{
			clientGoogle = new GoogleAdwordsServiceImpl();
		}
		catch (Exception e)
		{
			logger.error("Unable to create Google Client " + e.getMessage());
			e.printStackTrace();
		}
		
		wordIDMap = new HashMap<String,Long>();
		wordBidMap = new HashMap<String,Long>();


		firstPageCPCMap = new HashMap<String,Long>();
		qualityScoreMap = new HashMap<String,Double>();
		
		compKeywords = new HashSet<String>(); // competitive
		nonCompKeywords = new HashSet<String>(); // non-competitive
		noInfoKeywords = new HashSet<String>(); // competitive but no-info
		notSelectedKeywords = new HashSet<String>(); // competitive but not selected by optimizer
		
		/*
		compKeywordBids = new HashMap<String,Long>(); // competitive
		nonCompKeywordBids = new HashMap<String,Long>(); // non-competitive
		noInfoKeywordBids = new HashMap<String,Long>(); // competitive but no-info
		notSelectedKeywordBids = new HashMap<String,Long>(); // competitive but not selected by optimizer
		*/
		
		
		clickDataMap = new HashMap<String,EstimatorData>();
		costDataMap = new HashMap<String,EstimatorData>();
	}
	
	
	public HashMap<String,AdEngineInitialData> getInitialValues(Integer promotionID, 
			ArrayList<String> searchEngine) throws Exception{
		
		HashMap<String,AdEngineInitialData> initValues = new HashMap<String,AdEngineInitialData>();
		for (String se : searchEngine) {
			if (!AdEngine.existsAdEngine(se)){
				throw new Exception("Ad engine "+ se + " Not Found");
			}
			// Long defaultMicroBid = 1000000L; // $1.00
			AdEngineInitialData adEngineInitialDataObject = new AdEngineInitialData();
			adEngineInitialDataObject.setSemplestMatchType(ProtocolEnum.SemplestMatchType.Exact.name());
			adEngineInitialDataObject.setDefaultMicroBid(defaultMicroBid);
			adEngineInitialDataObject.setNetworkSetting(networkSetting);
//			adEngineInitialDataObject.setBiddingMethod(biddingMethod)
			// SemplestDB.storeDefaultBid(promotionID, se, defaultMicroBid);
			initValues.put(se, adEngineInitialDataObject);
		}
		
		return initValues;
	}
	
	
	
	public Boolean setBidsInitial(Integer promotionID, String searchEngine, BudgetObject budgetData) throws Exception {
		
		/* ******************************************************************************************* */
		// declarations
		int k;
		TrafficEstimatorObject o = null, o2 = null;

		logger.info("setBidsInitial called for ad engine "+searchEngine);
		
		/* ******************************************************************************************* */
		// 0. Check if Ad engine name is valid
		if (!AdEngine.existsAdEngine(searchEngine)){
			throw new Exception("Ad engine "+ searchEngine + " Not Found");
		}
		
		
		/* ******************************************************************************************* */
		// 1. Database call: get campaign specific IDs	
		try{ 
			AdEngineID adEngineInfo = SemplestDB.getAdEngineID(promotionID, searchEngine); 
			if (searchEngine.equalsIgnoreCase(google)){
				googleAccountID = String.valueOf(adEngineInfo.getAccountID());
			} else if(searchEngine.equalsIgnoreCase(msn)){
				msnAccountID = adEngineInfo.getAccountID();
			} else {
				throw new Exception("Ad engine type "+searchEngine+" is not yet implemented!!");
			}
			campaignID = adEngineInfo.getCampaignID();
			adGroupID = adEngineInfo.getAdGroupID();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to get AdEngineID from the database.");
		}
		
		logger.info("Got campaign related IDs from the database" + " Google Account" + googleAccountID +  ":" + "CampaignID = " + String.valueOf(campaignID) + ":" + String.valueOf(adGroupID));

		
		
		
		
		/* ******************************************************************************************* */
		// 2. Database call: get remaining days and budget
		// now get it as function argument
		//BudgetObject budgetData = SemplestDB.getBudget(promotionID);
		Double remBudget = budgetData.getRemainingBudgetInCycle();
		Integer remDays = budgetData.getRemainingDays();
		double targetDailyBudget = (remBudget/remDays)*7; // use weekly budget as target daily budget

		
		
		/* ******************************************************************************************* */
		// 3. [google] API call: get adgroup criterion for all keywords
		if(searchEngine.equalsIgnoreCase(google)){
			k=1;
			while(true) {
				Thread.sleep(sleepPeriod+k*sleepBackOffTime);
				try {
					keywordDataObjs = clientGoogle.getAllBiddableAdGroupCriteria(googleAccountID, adGroupID, true);
					break;
				} catch (Exception e) {
					if (k<=maxRetry) {
						e.printStackTrace();
						logger.info("Received exception getAllBiddableAdGroupCriteria AccountID = " + googleAccountID + " AdGroupID = " + String.valueOf(adGroupID) + ": will retry..., k="+k);
						k++;				
					} else {
						e.printStackTrace();
						throw new Exception("Failed to get BiddableAdGroupCriteria from Google after "+k+" efforts");
					}
				} // try-catch
			} // while(true)
			
			for(KeywordDataObject b: keywordDataObjs){
				wordIDMap.put(b.getKeyword(),b.getBidID());
			}
			
			logger.info("Got biddable adgroup criterion from Google.");
		} // if(searchEngine.equalsIgnoreCase(google))
		

		
		
		
		/* ******************************************************************************************* */
		// 4. [google] Decide competitive, non-competitive and no-info
		if(searchEngine.equalsIgnoreCase(google)){
			for(int i=0; i<keywordDataObjs.length; i++){
				keywordDataObj = keywordDataObjs[i];
				if(keywordDataObj.getFirstPageCpc()==null){
					// logger.info((i+1)+": Received no firstPageCPC info for "+keywordDataObj.getKeyword());
					noInfoKeywords.add(keywordDataObj.getKeyword());
				} else {
					// logger.info((i+1)+": "+keywordDataObj.getKeyword()+": "+
					//		keywordDataObj.getFirstPageCpc()*1e-6 + ": " + keywordDataObj.getQualityScore());
					firstPageCPCMap.put(keywordDataObj.getKeyword(), new Long(keywordDataObj.getFirstPageCpc()));
					qualityScoreMap.put(keywordDataObj.getKeyword(), new Double(Math.pow(keywordDataObj.getQualityScore(),1)));
					if(keywordDataObj.isIsEligibleForShowing()) {
						compKeywords.add(keywordDataObj.getKeyword());
					} else {
						nonCompKeywords.add(keywordDataObj.getKeyword());
					} 
				} // if(keywordDataObj.getFirstPageCpc()==null)
			} // for(int i=0; i<keywordDataObjs.length; i++)
			
			logger.info("Decided competitive keywords");
		} // if(searchEngine.equalsIgnoreCase(google))
		
		
		
		/* ******************************************************************************************* */
		// 5. SE API call: get traffic estimator data
		
                       /* *************************************** */
		//    a. [google] only competitive keywords
		//        i. some keywords are pushed back to non-competitive category if
		//           information available is not useful
		
		if(searchEngine.equalsIgnoreCase(google)){
			if (compKeywords.size()>0) {
				try {
					o = getTrafficEstimatorDataForGoogle();
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Failed to get Google traffic estimator data.");
				}
			}
		} // if(searchEngine.equalsIgnoreCase(google))
		
		                /* *************************************** */
		//    b. [msn] for all keywords and compute firstPage CPC from the data
		
		if(searchEngine.equalsIgnoreCase(msn)){
			throw new Exception("Method not implemented for MSN yet!!");
		} // if(searchEngine.equalsIgnoreCase(msn))
		
		logger.info("Got traffic estimator data.");

		
		
		
		
		/* ******************************************************************************************* */
		// 6. [google] Compute bids for competitive keywords
		
		// TODO: bidOptimizer to be added
		// for the time being put all keywords to the category of keywords not selected by optimizer
		
		// imp: consider the case that compKeywords is empty
		
		for(String s : compKeywords){
			notSelectedKeywords.add(s);
		}
		compKeywords.clear();
		
		logger.info("Computed bids for competitive keywords.");
		
		
		
		/* ******************************************************************************************* */
		// 7. [google] Compute bids for competitive keywords which optimizer didn't select
		//    a. Bid $0.5 above firstPage CPC if below $3.00		
		for(String s : notSelectedKeywords){
			wordBidMap.put(s,Math.min(firstPageCPCMap.get(s)+stepAboveFpCPC,maxMicroBid));
		}
		logger.info("Computed bids for competitive keywords which optimizer didn't select for bidding.");
				
		
		/* ******************************************************************************************* */
		// 8. Compute bits for all other keywords with firstPage CPC
		for(String s : nonCompKeywords){
			wordBidMap.put(s,Math.min(firstPageCPCMap.get(s)+stepAboveFpCPC,maxMicroBid));
		}
		logger.info("Computed bids for rest of the keywords with first page cpc.");
		
		/* ******************************************************************************************* */
		// 9. For the rest of keywords without firstPage CPC leave out for bidding with default bid 
		
		
		for(String s : noInfoKeywords){
			wordBidMap.put(s,null); // bid using default bid
		}
		
		logger.info("Left the remaining keywords for default bidding");
		
		
		
		
		/* ******************************************************************************************* */
		// 10. Use traffic estimator to compute average CPC based on these bids and use that as default bid for the campaign
		//    a. [google] use only competitive (both used and unused by optimizer) keywords
		//    b. [msn] use all keywords
		
		
		// defaultMicroBid = 1000000L;
		Long totalDailyCost = 0L;
		Float totalDailyClick = 0F;
		
		if(searchEngine.equalsIgnoreCase(google)){
			try{
				o2 = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, 
						KeywordMatchType.EXACT,	wordBidMap);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Failed to get Google traffic estimator data.");
			}
			if (o2!=null) {
				String[] words = o2.getListOfKeywords();
				for (int i=0; i < words.length; i++)
				{
					HashMap<Long, TrafficEstimatorObject.BidData> points = o2.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
					Iterator<Long> bidIT = points.keySet().iterator();
					while(bidIT.hasNext())
					{
						Long abid= bidIT.next();
						totalDailyClick += (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2;
						totalDailyCost += (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/2;
					}
				}
				if(totalDailyClick>0.01){
					defaultMicroBid = (((Long) new Double(totalDailyCost.doubleValue()/totalDailyClick).longValue())/10000L)*10000L;
					defaultMicroBid = Math.min(defaultMicroBid, maxDefaultMicroBid);
				}
			}
			
		} // if(searchEngine.equalsIgnoreCase(google))
		
		logger.info("Computed expected cpc and set default bid at that value");
		
		/* ******************************************************************************************* */
		// 11. [google] Database call: write adgroup criterion
		if(searchEngine.equalsIgnoreCase(google)){
			try {
				SemplestDB.storeKeywordDataObjects(promotionID, google,
						new ArrayList<KeywordDataObject>(Arrays.asList(keywordDataObjs)));
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Failed to store Google adGroupCriterion data to database.");
			}
		} // if(searchEngine.equalsIgnoreCase(google))
		
		logger.info("Stored adgroup criterion data to database for Google");
		
		
		/* ******************************************************************************************* */
		// 12. Database call: write traffic estimator data
		if(searchEngine.equalsIgnoreCase(google)){
			if(o!=null) {
				SemplestDB.storeTrafficEstimatorData(promotionID, google, o);
			}
		} // if(searchEngine.equalsIgnoreCase(google))
		
		if(searchEngine.equalsIgnoreCase(msn)){
			throw new Exception("Method not implemented for MSN yet!!");
		} // if(searchEngine.equalsIgnoreCase(msn))
		logger.info("Stored traffic estimator data to database");

		
		
		
		/* ******************************************************************************************* */
		// 13. Database call: write default bid for campaign
		// remember to update the bids for the words with default bid with database
		
		
		if(defaultMicroBid != SemplestDB.getDefaultBid(promotionID, searchEngine)) {
			SemplestDB.storeDefaultBid(promotionID, searchEngine, defaultMicroBid);
			SemplestDB.UpdateDefaultBidForKeywords(promotionID, searchEngine);
		}
		
		logger.info("Stroed default bid to databse and requested for updating all bids for keywords with default bid.");
		
		
		
		
		/* ******************************************************************************************* */
		// 14. Database call: write bid, matchType, competition status
		ArrayList<BidElement> bidsMatchType = new ArrayList<BidElement>();
		
		String competitiveType="";
		String matchType = ProtocolEnum.SemplestMatchType.Exact.name(); 
		Boolean isActive = true;
		Boolean isNegative = false;
		
		Iterator<String> keyIT = wordBidMap.keySet().iterator();
		while(keyIT.hasNext())
		{
			// TODO: Add Enum
			String word = keyIT.next();
			if (compKeywords.contains(word)){
				competitiveType = ProtocolEnum.SemplestCompetitionType.Comp.name();
			} else if (notSelectedKeywords.contains(word)){
				competitiveType = ProtocolEnum.SemplestCompetitionType.NotSelected.name();
			} else if (nonCompKeywords.contains(word)){
				competitiveType = ProtocolEnum.SemplestCompetitionType.NonComp.name();
			} else if(noInfoKeywords.contains(word)){
				competitiveType = ProtocolEnum.SemplestCompetitionType.NoInfo.name();
			} else {
				throw new Exception("Unknown competition type. Internal error in bidding service!");
			}
			bidsMatchType.add(new BidElement(word, wordIDMap.get(word), 
					(wordBidMap.get(word)==null) ? defaultMicroBid : wordBidMap.get(word), 
					matchType, competitiveType, wordBidMap.get(word)==null, isActive, isNegative)); 
		}
		
		
		try{
			SemplestDB.storeBidObjects(promotionID, searchEngine, bidsMatchType);
			logger.info("Stroed bid data to the databse");
		} catch (Exception e) {
			logger.info("ERROR: Unable to store bid data to the database.");
			e.printStackTrace();
			throw new Exception("Failed to store bid data to the database.");
		}
		
		
		

		
		/* ******************************************************************************************* */
		// 15. Database call: write targeted daily budget etc
		try{
			SemplestDB.storeTargetedDailyBudget(promotionID, searchEngine, totalDailyCost, totalDailyClick.intValue());
			logger.info("Stroed targeted daily budget data to the databse");
		} catch (Exception e) {
			logger.info("ERROR: Unable to store targeted daily budget data to the database.");
			e.printStackTrace();
			throw new Exception("Failed to store targeted daily budget data to the database.");
		}

		

		
		/* ******************************************************************************************* */
		// 16. SE API call: Update matchType, bid for keywords
		if(searchEngine.equalsIgnoreCase(google)){
			keyIT = wordBidMap.keySet().iterator();
			while(keyIT.hasNext())
			{
				String word = keyIT.next();
				k=1;
				while(true) {
					Thread.sleep(sleepPeriod+k*sleepBackOffTime);
					try {
						clientGoogle.setBidForKeyWord(googleAccountID, wordIDMap.get(word), adGroupID,wordBidMap.get(word));
						break;
					} catch (Exception e) {
						if (k<=maxRetry) {
							e.printStackTrace();
							logger.info("Received exception : will retry..., k="+k);
							k++;				
						} else {
							e.printStackTrace();
							throw new Exception("Failed to update bids for keyword "+word);
						}
					} // try-catch
				} // while(true) 
			}
		} // if(searchEngine.equalsIgnoreCase(google))
		
		if(searchEngine.equalsIgnoreCase(msn)){
			throw new Exception("Method not implemented for MSN yet!!");
		} // if(searchEngine.equalsIgnoreCase(msn))
		
		logger.info("Updated bids and match type for keywords via the search engine API.");

		
		
		
		
		/* ******************************************************************************************* */
		// 17. SE API call: Update default bid for campaign
		if(searchEngine.equalsIgnoreCase(google)){
			k=1;
			while(true) {
				Thread.sleep(sleepPeriod+k*sleepBackOffTime);
				try {
					clientGoogle.updateDefaultBid(googleAccountID, adGroupID, defaultMicroBid);
					break;
				} catch (Exception e) {
					if (k<=maxRetry) {
						e.printStackTrace();
						logger.info("Received exception : will retry..., k="+k);
						k++;				
					} else {
						e.printStackTrace();
						throw new Exception("Failed to update default microBid via Google API.");
					}
				} // try-catch
			} // while(true) 
		}
		logger.info("Updated the default bid via search engine API.");
		
		
		
		return new Boolean(true);
		
	} // setBidsInitial()
	
	




	public Boolean setBidsUpdate(Integer promotionID, String searchEngine, BudgetObject budgetData) throws Exception {
		
		logger.info("setBidsUpdate called. presently not doing anything!!");
		// throw new Exception("setBidsUpdate not yet implemented!!");	
		
		return new Boolean(true);
	} // setBidsUpdate()

	
	

	
	private TrafficEstimatorObject getTrafficEstimatorDataForGoogle() throws Exception{
		
		// declare the variables
		TrafficEstimatorObject o;
		int k;

		// get info for the first page CPC point
		HashMap<String, Long> bids = new HashMap<String, Long>();
		for (String s : compKeywords){
			bids.put(s, firstPageCPCMap.get(s)+stepFirst); // stepFirst above fp CPC
		}
		System.out.println("Number of initial competitive keywords: "+bids.size());

		
		k=1;
		while(true) {
			Thread.sleep(sleepPeriod+k*sleepBackOffTime);
			try {
				o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
				break;
			} catch (Exception e) {
				if (k<=maxRetry) {
					e.printStackTrace();
					logger.info("Received exception : will retry..., k="+k);
					k++;				
				} else {
					e.printStackTrace();
					throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
				}
			}
		}
		
		String[] words = o.getListOfKeywords();
		for (int i=0; i < words.length; i++)
		{
			HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
			Iterator<Long> bidIT = points.keySet().iterator();
			while(bidIT.hasNext())
			{
				Long abid= bidIT.next();
				if(points.get(abid).getMaxTotalDailyMicroCost() < 10000L){
//					 System.out.println("Moving keyword \""+words[i]+"\" to non-competitive category from competitive category.");
//					 System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());
					compKeywords.remove(words[i]);
					nonCompKeywords.add(words[i]);
					continue;
				} else {
					System.out.println(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);

//					 System.out.println("Got valid data from traffic estimator for keyword \""+words[i]+"\".");
//					 System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());
					
					EstimatorData clickDataObj = new EstimatorData();
					clickDataObj.addData(abid/1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2);
					clickDataMap.put(words[i], clickDataObj);
					
					EstimatorData costDataObj = new EstimatorData();
					costDataObj.addData(abid/1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/(2*1e6));
					costDataMap.put(words[i], costDataObj);
				}
			}
		}
		System.out.println("Number of intermediate competitive keywords: "+compKeywords.size());

		
		// get the second point
		bids = new HashMap<String, Long>();
		for (String s : compKeywords){
			bids.put(s, firstPageCPCMap.get(s)+stepSecond);
		}
		k=1;
		while(true) {
			Thread.sleep(sleepPeriod+k*sleepBackOffTime);
			try {
				o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
				break;
			} catch (Exception e) {
				if (k<=maxRetry) {
					e.printStackTrace();
					logger.info("Received exception : will retry..., k="+k);
					k++;				
				} else {
					e.printStackTrace();
					throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
				}
			}
		}
		words = o.getListOfKeywords();
		for (int i=0; i < words.length; i++)
		{
			HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
			Iterator<Long> bidIT = points.keySet().iterator();
			while(bidIT.hasNext())
			{
				Long abid= bidIT.next();
				
				// System.out.println("Got valid data from traffic estimator for keyword \""+words[i]+"\".");
				// System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());

				EstimatorData clickDataObj = clickDataMap.get(words[i]);
				clickDataObj.addData(abid/1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2);
				clickDataMap.put(words[i], clickDataObj);

				EstimatorData costDataObj = costDataMap.get(words[i]);
				costDataObj.addData(abid/1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/(2*1e6));
				costDataMap.put(words[i], costDataObj);
				
				System.out.println(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);


				/*
				// now check if we are getting the same data 
				double [] bidArray = costDataMap.get(words[i]).getBidArray();
				Arrays.sort(bidArray);
				double [] costArray = costDataMap.get(words[i]).getData(bidArray);
				if (Math.abs(costArray[0]-costArray[costArray.length-1])<1e-6){
					// System.out.println("Moving keyword \""+words[i]+"\" to non-competitive category from competitive category.");
					compKeywords.remove(words[i]);
					nonCompKeywords.add(words[i]);
					clickDataMap.remove(words[i]);
					costDataMap.remove(words[i]);
					continue;
				}
				*/

			}
		}
		

		
		
		// get the next 4 points uniformly (for the time being)
		for( int j=2; j<8; j++) {
			bids = new HashMap<String, Long>();
			for (String s : compKeywords){
				bids.put(s, firstPageCPCMap.get(s)+j*stepRest);
			}
			System.out.println("j="+j);
			k=1;
			while(true) {
				Thread.sleep(sleepPeriod+k*sleepBackOffTime);
				try {
					o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
					break;
				} catch (Exception e) {
					if (k<=maxRetry) {
						e.printStackTrace();
						logger.info("Received exception : will retry..., k="+k);
						k++;				
					} else {
						e.printStackTrace();
						throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
					}
				}
			}
			words = o.getListOfKeywords();
			for (int i=0; i < words.length; i++)
			{
				HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
				Iterator<Long> bidIT = points.keySet().iterator();
				while(bidIT.hasNext())
				{
					Long abid= bidIT.next();

					// System.out.println("Got valid data from traffic estimator for keyword \""+words[i]+"\".");
					// System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());

					EstimatorData clickDataObj = clickDataMap.get(words[i]);
					clickDataObj.addData(abid/1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2);
					clickDataMap.put(words[i], clickDataObj);

					EstimatorData costDataObj = costDataMap.get(words[i]);
					costDataObj.addData(abid/1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/(2*1e6));
					costDataMap.put(words[i], costDataObj);
					
					System.out.println(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);


				}
			}
		} // for( int j=0; j<4; j++)
		
		

		for (int i=0; i < words.length; i++) {
			// now check if we are getting the same data 
			double [] bidArray = costDataMap.get(words[i]).getBidArray();
			Arrays.sort(bidArray);
			double [] costArray = costDataMap.get(words[i]).getData(bidArray);
//			if (Math.abs(costArray[0]-costArray[costArray.length-1])<1e-6){
			if (costArray[costArray.length-1]<costArray[0]+1e-4){
				 System.out.println("Moving keyword \""+words[i]+"\" to non-competitive category from competitive category.");
				compKeywords.remove(words[i]);
				nonCompKeywords.add(words[i]);
				clickDataMap.remove(words[i]);
				costDataMap.remove(words[i]);
				continue;
			}
		}
		
		System.out.println("Number of final competitive keywords: "+compKeywords.size());
		
		return o;
	}

	
	
	private TrafficEstimatorObject getTrafficEstimationForKeywordsGoogle(String accountID, Long campaignID, KeywordMatchType matchType,
			HashMap<String, Long> KeywordWithBid) throws Exception {
//			HashMap<String, Long> KeywordWithBid, GoogleAdwordsServiceImpl client) throws Exception {
//		HashMap<String, Double> KeywordWithBid, GoogleAdwordsServiceClient client) throws Exception {
		
		TrafficEstimatorObject o = null, o2 = null;
		int i=0, k;
		boolean firstLoop = true;
		
		HashMap<String,Long> newKeywordWithBid = new HashMap<String,Long>();
		Iterator it = KeywordWithBid.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry me = (Map.Entry) it.next();
			String s = (String) me.getKey();
			if (KeywordWithBid.get(s) != null){
				newKeywordWithBid.put(s,KeywordWithBid.get(s));
				i++;
			}
			if((i%500==0 && i>0) || (!it.hasNext())){
				k=1;
				while(true) {
					try {
						if(newKeywordWithBid.size()>0){
							Thread.sleep(sleepPeriod+k*sleepBackOffTime);
							o2 = clientGoogle.getTrafficEstimationForKeywords(accountID, campaignID, matchType, newKeywordWithBid);
						}
						break;
					} catch (Exception e) {
						if (k<=maxRetry) {
							e.printStackTrace();
							logger.info("Received exception : will retry..., k="+k);
							k++;				
						} else {
							e.printStackTrace();
							throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
						}
					}
				}
				newKeywordWithBid.clear();
				if(firstLoop || o==null){
					o=o2;
					firstLoop=false;
				} else {
					o.addGoogleTrafficEstimatorObject(o2,KeywordMatchType.EXACT.getValue());
				}
			} // if(i/500==0) 
		} // while(it.hasNext())
		
		
		return o;
		
	}
	
	public void getBidsInitialGoogle(String accountID,
			Long campaignID, Long adGroupID) throws Exception {	
		
		logger.info("Computing initial bids for Google campaign...");

		
		// ************************************************************************** 
		
		
//		GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);
		GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();
		
		CampaignBid bidOptimizer = new CampaignBid();


		HashMap<String,Double> bidData = new HashMap<String,Double>();
		
		// A0. Add the keywords to the campaign
		
//		Long maxCPC = 1000000L; // bid in microBidAmount;
//		addWords(accountID,	campaignID, adGroupID, keywords, maxCPC);
		
		
		
		// A. get the bid information from ad campaign
		
		// first get static information from GOOGLE: first page CPC and quality score
		// and form competitive and non-competitive groups 
		
		
		KeywordDataObject[] keywordDataObjs = null;
		KeywordDataObject keywordDataObj;
		TrafficEstimatorObject o;

		int k;
		
		
		
		try {
			keywordDataObjs = client.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		HashMap<String,Long> firstPageCPCMap = new HashMap<String,Long>();
		HashMap<String,Double> qualityScoreMap = new HashMap<String,Double>();
		HashMap<String,String> statusMap = new HashMap<String,String>();
		
		HashSet<String> compKeywords = new HashSet<String>(); // competitive
		HashSet<String> nonCompKeywords = new HashSet<String>(); // non-competitive
		HashSet<String> noInfoKeywords = new HashSet<String>(); // non-competitive

		
		for(int i=0; i<keywordDataObjs.length; i++){
			keywordDataObj = keywordDataObjs[i];
			if(keywordDataObj.getFirstPageCpc()==null){
				noInfoKeywords.add(keywordDataObj.getKeyword());
			} else {
				// logger.info((i+1)+": "+keywordDataObj.getKeyword()+": "+keywordDataObj.getFirstPageCpc()*1e-6 + ": " + keywordDataObj.getQualityScore()+ ", Status: "+ keywordDataObj.getStatus());
				firstPageCPCMap.put(keywordDataObj.getKeyword(), new Long(keywordDataObj.getFirstPageCpc()));
				qualityScoreMap.put(keywordDataObj.getKeyword(), new Double(Math.pow(keywordDataObj.getQualityScore(),1)));
				statusMap.put(keywordDataObj.getKeyword(), keywordDataObj.getApprovalStatus());
				if(keywordDataObj.isIsEligibleForShowing()) {
					compKeywords.add(keywordDataObj.getKeyword());
				} else {
					nonCompKeywords.add(keywordDataObj.getKeyword());
				} 	
			}
		} // for(int i=0; i<keywordDataObjs.length; i++)
		
		

		
				
		// ************************************************************************** 
		
		// B. Gather traffic estimator data
		
		
		// first competitive keywords
		HashMap<String,EstimatorData> clickDataMap = new HashMap<String,EstimatorData>();
		HashMap<String,EstimatorData> costDataMap = new HashMap<String,EstimatorData>();
		
		// get info for the first page CPC point
		HashMap<String, Long> bids = new HashMap<String, Long>();
		for (String s : compKeywords){
			bids.put(s, firstPageCPCMap.get(s)+100000L); // $0.10 above fp CPC
		}
		System.out.println("Number of initial competitive keywords: "+bids.size());

		
		k=1;
		while(true) {
			Thread.sleep(sleepPeriod+k*sleepBackOffTime);
			try {
				o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
				break;
			} catch (Exception e) {
				if (k<=maxRetry) {
					e.printStackTrace();
					logger.info("Received exception : will retry..., k="+k);
					k++;				
				} else {
					e.printStackTrace();
					throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
				}
			}
		}
		
		String[] words = o.getListOfKeywords();
		for (int i=0; i < words.length; i++)
		{
			HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
			Iterator<Long> bidIT = points.keySet().iterator();
			while(bidIT.hasNext())
			{
				Long abid= bidIT.next();
				if(points.get(abid).getMaxTotalDailyMicroCost() < 10000L){
//					 System.out.println("Moving keyword \""+words[i]+"\" to non-competitive category from competitive category.");
//					 System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());
					compKeywords.remove(words[i]);
					nonCompKeywords.add(words[i]);
					continue;
				} else {
					System.out.println(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);

//					 System.out.println("Got valid data from traffic estimator for keyword \""+words[i]+"\".");
//					 System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());
					
					EstimatorData clickDataObj = new EstimatorData();
					clickDataObj.addData(abid/1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2);
					clickDataMap.put(words[i], clickDataObj);
					
					EstimatorData costDataObj = new EstimatorData();
					costDataObj.addData(abid/1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/(2*1e6));
					costDataMap.put(words[i], costDataObj);
				}
			}
		}
		System.out.println("Number of intermediate competitive keywords: "+compKeywords.size());

		
		// get the second point
		bids = new HashMap<String, Long>();
		for (String s : compKeywords){
			bids.put(s, firstPageCPCMap.get(s)+600000L);
		}
		k=1;
		while(true) {
			Thread.sleep(sleepPeriod+k*sleepBackOffTime);
			try {
				o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
				break;
			} catch (Exception e) {
				if (k<=maxRetry) {
					e.printStackTrace();
					logger.info("Received exception : will retry..., k="+k);
					k++;				
				} else {
					e.printStackTrace();
					throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
				}
			}
		}
		words = o.getListOfKeywords();
		for (int i=0; i < words.length; i++)
		{
			HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
			Iterator<Long> bidIT = points.keySet().iterator();
			while(bidIT.hasNext())
			{
				Long abid= bidIT.next();
				
				// System.out.println("Got valid data from traffic estimator for keyword \""+words[i]+"\".");
				// System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());

				EstimatorData clickDataObj = clickDataMap.get(words[i]);
				clickDataObj.addData(abid/1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2);
				clickDataMap.put(words[i], clickDataObj);

				EstimatorData costDataObj = costDataMap.get(words[i]);
				costDataObj.addData(abid/1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/(2*1e6));
				costDataMap.put(words[i], costDataObj);
				
				System.out.println(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);


				/*
				// now check if we are getting the same data 
				double [] bidArray = costDataMap.get(words[i]).getBidArray();
				Arrays.sort(bidArray);
				double [] costArray = costDataMap.get(words[i]).getData(bidArray);
				if (Math.abs(costArray[0]-costArray[costArray.length-1])<1e-6){
					// System.out.println("Moving keyword \""+words[i]+"\" to non-competitive category from competitive category.");
					compKeywords.remove(words[i]);
					nonCompKeywords.add(words[i]);
					clickDataMap.remove(words[i]);
					costDataMap.remove(words[i]);
					continue;
				}
				*/

			}
		}
		

		
		
		// get the next 4 points uniformly (for the time being)
		for( int j=2; j<8; j++) {
			bids = new HashMap<String, Long>();
			for (String s : compKeywords){
				bids.put(s, firstPageCPCMap.get(s)+j*800000L);
			}
			System.out.println("j="+j);
			k=1;
			while(true) {
				Thread.sleep(sleepPeriod+k*sleepBackOffTime);
				try {
					o = getTrafficEstimationForKeywordsGoogle(googleAccountID, campaignID, KeywordMatchType.EXACT, bids);
					break;
				} catch (Exception e) {
					if (k<=maxRetry) {
						e.printStackTrace();
						logger.info("Received exception : will retry..., k="+k);
						k++;				
					} else {
						e.printStackTrace();
						throw new Exception("Failed to get traffic estimator data from Google after "+k+" efforts");
					}
				}
			}
			words = o.getListOfKeywords();
			for (int i=0; i < words.length; i++)
			{
				HashMap<Long, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i],KeywordMatchType.EXACT.getValue());
				Iterator<Long> bidIT = points.keySet().iterator();
				while(bidIT.hasNext())
				{
					Long abid= bidIT.next();

					// System.out.println("Got valid data from traffic estimator for keyword \""+words[i]+"\".");
					// System.out.println(words[i] + ": " + abid/1e6 + ": " + points.get(abid).getMaxAveCPC()/1e6 + ": " + points.get(abid).getMaxClickPerDay());

					EstimatorData clickDataObj = clickDataMap.get(words[i]);
					clickDataObj.addData(abid/1e6, (points.get(abid).getMaxClickPerDay() + points.get(abid).getMinClickPerDay())/2);
					clickDataMap.put(words[i], clickDataObj);

					EstimatorData costDataObj = costDataMap.get(words[i]);
					costDataObj.addData(abid/1e6, (points.get(abid).getMaxTotalDailyMicroCost() + points.get(abid).getMinTotalDailyMicroCost())/(2*1e6));
					costDataMap.put(words[i], costDataObj);
					
					System.out.println(words[i]+":: Total daily cost: $"+points.get(abid).getMaxTotalDailyMicroCost()/1e6);


				}
			}
		} // for( int j=0; j<4; j++)
		
		

		for (int i=0; i < words.length; i++) {
			// now check if we are getting the same data 
			double [] bidArray = costDataMap.get(words[i]).getBidArray();
			Arrays.sort(bidArray);
			double [] costArray = costDataMap.get(words[i]).getData(bidArray);
//			if (Math.abs(costArray[0]-costArray[costArray.length-1])<1e-6){
			if (costArray[costArray.length-1]<costArray[0]+1e-4){
				 System.out.println("Moving keyword \""+words[i]+"\" to non-competitive category from competitive category.");
				compKeywords.remove(words[i]);
				nonCompKeywords.add(words[i]);
				clickDataMap.remove(words[i]);
				costDataMap.remove(words[i]);
				continue;
			}
		}
		
		System.out.println("Number of final competitive keywords: "+compKeywords.size());

		
		// ************************************************************************** 

		// C. Compute bids for competitive keywords 
		
			
		for (String s : compKeywords){
			double [] bidArray = costDataMap.get(s).getBidArray();
			Arrays.sort(bidArray);
//			System.out.println(s);
			try {
				bidOptimizer.addKeyWord(new KeyWord(s, qualityScoreMap.get(s).doubleValue(), bidArray, 
						clickDataMap.get(s).getData(bidArray), null, null, costDataMap.get(s).getData(bidArray), 
						firstPageCPCMap.get(s)*1e-6));
				
//				double [] costArray = costDataMap.get(s).getData(bidArray);
//				for(int i=0; i<costArray.length; i++){
//					System.out.println(bidArray[i]+ ": "+costArray[i]);
//				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		try
		{
			FileOutputStream fileOut = new FileOutputStream("/tmp/piperhall.ser.obj");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bidOptimizer);
			out.close();
			fileOut.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
//		bidOptimizer = null;
//		try
//        {
//           FileInputStream fileIn = new FileInputStream("/tmp/bloom.ser.obj");
//           ObjectInputStream in = new ObjectInputStream(fileIn);
//           bidOptimizer = (CampaignBid) in.readObject();
//           in.close();
//           fileIn.close();
//           System.out.println("Yahoo ... have deserialized!");
//       }catch(IOException e)
//       {
//           e.printStackTrace();
//       }catch(ClassNotFoundException c)
//       {
//           System.out.println("CampaignBid class not found");
//           c.printStackTrace();
//       }
		
		
		
		bidOptimizer.setDailyBudget(30.0);
		HashMap<String,Double> compBidData= bidOptimizer.optimizeBids();

		

		
//		// update bids at google adwords account
//
//		for(int i=0; i<keywordDataObjs.length; i++){
//			keywordDataObj = keywordDataObjs[i];
////			client.getBidLandscapeForKeyword(accountID, adGroupID, keywordDataObjs[i].getBidID());
//			if (compBidData.containsKey(keywordDataObj.getKeyword())){
//				bidData.put(keywordDataObj.getKeyword(),compBidData.get(keywordDataObj.getKeyword()));
//				/*
//				try {
//					keywordDataObj=client.setBidForKeyWord(accountID, keywordDataObj.getBidID(), adGroupID, 
//							(((Long) new Double(compBidData.get(keywordDataObj.getKeyword())*1e6).longValue())/10000L)*10000L );
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Thread.sleep(500);
//				*/
//			}
//		}
		

		
		 // ************************************************************************** 

		
//		// E. bid by a pre-determined strategy for the keywords that are non-competitive
//		
//		// TBD: 1. random or aim for first/top page? do we get any other information like bid for first or top page?
//		
////		Long addValue = 500000L;
//		Long addValue = (Long) new Double(0.5*1e6).longValue();
//		for(int i=0; i<keywordDataObjs.length; i++){
//			keywordDataObj = keywordDataObjs[i];
////			client.getBidLandscapeForKeyword(accountID, adGroupID, keywordDataObjs[i].getBidID());
//			if (nonCompKeywords.contains(keywordDataObj.getKeyword())){
//				bidData.put(keywordDataObj.getKeyword(),(keywordDataObj.getFirstPageCpc()+addValue)*1e-6);
//				/*
//				try {
//					keywordDataObj=client.setBidForKeyWord(accountID, keywordDataObj.getBidID(), adGroupID,keywordDataObj.getFirstPageCpc()+addValue );
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Thread.sleep(500);
//				*/
//			}
//		}
		
		
		
		 // ************************************************************************** 
		
		// F. compute optimal bids for the competitive keywords
		

		/*
		for(String s : keywords){
			if (!bidData.containsKey(s)) {
				bidData.put(s, new Double(1.0));
			}
		}
		*/
		

	}
	
	


	
	public static void main(String[] args){
		

//		String accountID = "2188810777"; // small campaign : 100 words
//		String accountID = "9544523876";
		String accountID = "1283163526"; // large capmaign : 1500 words
		
//		String accountID = "4764852610"; // teststudiobloom;
//		String accountID = "9036397375"; // bethflowers
//		String accountID = "6870692153"; // piperhall
		
//		String accountID = "1851386728"; // ParkWinters



		BasicConfigurator.configure();
		
		/*
		
////		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywords.txt");
//		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb.txt");
		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb500.txt");
		ArrayList<String> keywords = new ArrayList<String>();

		for (String line : lines){
			line=line.replaceFirst("\\S+\\s+", "") ; // for the new format
			keywords.add(line.replaceAll("\n",""));
//			System.out.println(line);
		}
		
//		System.exit(0);
		
		*/

		try {

			//			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);
			GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();


			ArrayList<HashMap<String, String>> campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);
			Long campaignID = new Long(campaignsByAccountId.get(0).get("Id"));
			System.out.println(campaignID);

			GoogleAdGroupObject[] adGroups = null;

			try {
				adGroups = client.getAdGroupsByCampaignId(accountID, campaignID, false);
				for (int i=0; i< adGroups.length; i++)
					System.out.println(adGroups[i].getAdGroupName()+": "+adGroups[i].getAdGroupID());
			} catch (Exception e) {
				e.printStackTrace();
			}

			Long adGroupID = adGroups[0].getAdGroupID();



			BidGeneratorObj bidGenerator = new BidGeneratorObj();
			//			bidGenerator.getBid(accountID, campaignID, adGroupID, keywords);
			bidGenerator.getBidsInitialGoogle(accountID, campaignID, adGroupID);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







	
}
