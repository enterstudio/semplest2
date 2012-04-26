package semplest.service.bidding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import semplest.bidding.test.ioUtils;


import semplest.server.protocol.google.GoogleAdGroupObject;

import semplest.server.protocol.adengine.BidObject;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.NetworkSetting;
import semplest.server.protocol.ProtocolEnum.MatchType;

import semplest.server.protocol.adengine.TrafficEstimatorObject;


import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.interfaces.SemplestBiddingInterface;

//import semplest.services.client.api.GoogleAdwordsServiceClient;

import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.gson.Gson;





public class BidGeneratorServiceImpl implements SemplestBiddingInterface {
	
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidGeneratorServiceImpl.class);
	


	@Override
	public void initializeService(String input) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void getBidsInitial(String json) throws Exception
	{
		logger.debug("call  getBidsInitial(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		String searchEngine = data.get("searchEngine");
		getBidsInitial( accountID, campaignID, adGroupID, searchEngine);
//		return gson.toJson(res);
	}
	
	@Override
	public void getBidsInitial(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		if (!AdEngine.existsAdEngine(searchEngine))
		{
			throw new Exception(searchEngine + " Not Found");
		}
		if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name())){
			getBidsInitialGoogle(accountID, campaignID, adGroupID);
		} else if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.MSN.name())){
			// getBidsInitialMSN(accountID, campaignID, adGroupID);
		} 
	}
	
	
	public void getBidsUpdate(String json) throws Exception
	{
		logger.debug("call  getBidsUpdate(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		String searchEngine = data.get("searchEngine");
//		ArrayList<BidObject> res = 
		getBidsUpdate( accountID, campaignID, adGroupID, searchEngine);
//		return gson.toJson(res);
	}
	
	@Override
	public void getBidsUpdate(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		if (!AdEngine.existsAdEngine(searchEngine))
		{
			throw new Exception(searchEngine + " Not Found");
		}
		
		if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name())){
			// getBidsUpdateGoogle(accountID, campaignID, adGroupID);
		} else if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.MSN.name())){
			// getBidsUpdateMSN(accountID, campaignID, adGroupID);
		}
	}
	

	public String GetMonthlyBudgetPerSE(String json) throws Exception
	{
		logger.debug("call  getBid(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		ArrayList<String> searchEngine = gson.fromJson(data.get("searchEngine"),ArrayList.class);
		Double TotalMonthlyBudget = Double.parseDouble(data.get("TotalMonthlyBudget"));
		HashMap<String,Double> res = GetMonthlyBudgetPerSE(accountID,campaignID,adGroupID, searchEngine, TotalMonthlyBudget);
		return gson.toJson(res);
	}

	@Override
	public HashMap<String,Double> GetMonthlyBudgetPerSE (String accountID, Long campaignID, Long adGroupID, 
			ArrayList<String> searchEngine,	Double TotalMonthlyBudget)  throws Exception  {
		
		HashSet<String> setSE = new HashSet<String>(); 
		for (String s : searchEngine){
			if(setSE.contains(s)){
				throw new Exception("Search engine "+s+" appears twice!!");
			} else {
				setSE.add(s);
			}
			if (!AdEngine.existsAdEngine(s)){
				throw new Exception(s + " Not Found");
			}
		}
		
		
		HashMap<String,Double> budgetMap = new HashMap<String,Double>();

		switch (searchEngine.size()) {
		case 2:
			if(searchEngine.get(0).equalsIgnoreCase("Google") && searchEngine.get(1).equalsIgnoreCase("MSN") ||
					searchEngine.get(0).equalsIgnoreCase("MSN") && searchEngine.get(1).equalsIgnoreCase("Geogle") ) {
				budgetMap.put("Google", new Double(0.7*TotalMonthlyBudget));
				budgetMap.put("MSN", new Double(0.3*TotalMonthlyBudget));
				break;
			}
			throw new Exception("Invalid combination of search engine options!");
		case 1:
			budgetMap.put(searchEngine.get(0), new Double(TotalMonthlyBudget));
		default:
			throw new Exception("Invalid number of search engines.. Received "+searchEngine.size()+" search engine names!");
		}

		
		return budgetMap;
	}


	public String getBid(String json) throws Exception
	{
		logger.debug("call  getBid(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		ArrayList<String> keywords = gson.fromJson(data.get("keywords"), ArrayList.class);
		HashMap<String,Double> res = getBid(accountID,campaignID,adGroupID, keywords);
		return gson.toJson(res);
	}
	
	
	
	
	@Override
	public HashMap<String,Double> getBid(String accountID,
			Long campaignID, Long adGroupID, ArrayList<String> keywords)
			throws Exception {
		
		throw new Exception("getBid(...) method is no longer in use! Use either getBidsInitial(...) or getBidsUpdate(...) instead.");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* ************************************** The long methods follow ******************************************* */
	
	
	
	
	
	
	
	private void getBidsInitialGoogle(String accountID,
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
		
		
		BidObject[] bidObjects = null;
		BidObject bidObject;
		TrafficEstimatorObject o;

		int k;
		
		
		
		try {
			bidObjects = client.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		HashMap<String,Double> firstPageCPCMap = new HashMap<String,Double>();
		HashMap<String,Double> qualityScoreMap = new HashMap<String,Double>();
		HashMap<String,String> statusMap = new HashMap<String,String>();
		
		HashSet<String> compKeywords = new HashSet<String>(); // competitive
		HashSet<String> nonCompKeywords = new HashSet<String>(); // non-competitive
		HashSet<String> noInfoKeywords = new HashSet<String>(); // non-competitive

		
		for(int i=0; i<bidObjects.length; i++){
			bidObject = bidObjects[i];
			if(bidObject.getFirstPageCpc()==null){
				noInfoKeywords.add(bidObject.getKeyword());
			} else {
				// logger.info((i+1)+": "+bidObject.getKeyword()+": "+bidObject.getFirstPageCpc()*1e-6 + ": " + bidObject.getQualityScore()+ ", Status: "+ bidObject.getStatus());
				firstPageCPCMap.put(bidObject.getKeyword(), new Double(bidObject.getFirstPageCpc()*1e-6));
				qualityScoreMap.put(bidObject.getKeyword(), new Double(Math.pow(bidObject.getQualityScore(),1)));
				statusMap.put(bidObject.getKeyword(), bidObject.getApprovalStatus());
				if(bidObject.isIsEligibleForShowing()) {
					compKeywords.add(bidObject.getKeyword());
				} else {
					nonCompKeywords.add(bidObject.getKeyword());
				} 	
			}
		} // for(int i=0; i<bidObjects.length; i++)
		
		

		
				
		// ************************************************************************** 
		
		// B. Gather traffic estimator data
		
		
		// first competitive keywords
		HashMap<String,EstimatorData> clickDataMap = new HashMap<String,EstimatorData>();
		HashMap<String,EstimatorData> costDataMap = new HashMap<String,EstimatorData>();
		
		// get info for the first page CPC point
		HashMap<String, Double> bids = new HashMap<String, Double>();
		for (String s : compKeywords){
			bids.put(s, firstPageCPCMap.get(s)+0.1);
		}
		System.out.println("Number of initial competitive keywords: "+bids.size());

		
		k=0;
		while(true) {
			Thread.sleep(500+k*3000);
			try {
				o = getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, bids, client);
//				o = client.getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, bids);
				break;
			} catch (Exception e) {
				System.out.println("Received exception : will retry..., k="+(k+1));
				k++;
			}
		}
		
		String[] words = o.getListOfKeywords();
		for (int i=0; i < words.length; i++)
		{
			HashMap<Double, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i]);
			Iterator<Double> bidIT = points.keySet().iterator();
			while(bidIT.hasNext())
			{
				Double abid= bidIT.next();
//				if(points.get(abid).getMaxAveCPC()/1e6 < 1e-2){
				if(points.get(abid).getMaxTotalDailyMicroCost()/1e6 < 1e-3){
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
		bids = new HashMap<String, Double>();
		for (String s : compKeywords){
			bids.put(s, firstPageCPCMap.get(s)+0.6);
		}
		k=0;
		while(true) {
			Thread.sleep(500+k*3000);
			try {
				o = getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, bids, client);
				break;
			} catch (Exception e) {
				System.out.println("Received exception : will retry..., k="+(k+1));
				k++;
			}
		}
		words = o.getListOfKeywords();
		for (int i=0; i < words.length; i++)
		{
			HashMap<Double, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i]);
			Iterator<Double> bidIT = points.keySet().iterator();
			while(bidIT.hasNext())
			{
				Double abid= bidIT.next();
				
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
			bids = new HashMap<String, Double>();
			for (String s : compKeywords){
				bids.put(s, firstPageCPCMap.get(s)+0.8*j);
			}
			System.out.println("j="+j);
			k=0;
			while(true) {
				Thread.sleep(1500+k*3000);
				try {
					o = getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, bids, client);
					break;
				} catch (Exception e) {
					System.out.println("Received exception : will retry..., k="+(k+1));
					k++;
				}
			}
			words = o.getListOfKeywords();
			for (int i=0; i < words.length; i++)
			{
				HashMap<Double, TrafficEstimatorObject.BidData> points = o.getMapOfPoints(words[i]);
				Iterator<Double> bidIT = points.keySet().iterator();
				while(bidIT.hasNext())
				{
					Double abid= bidIT.next();

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
						firstPageCPCMap.get(s)));
				
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
//		for(int i=0; i<bidObjects.length; i++){
//			bidObject = bidObjects[i];
////			client.getBidLandscapeForKeyword(accountID, adGroupID, bidObjects[i].getBidID());
//			if (compBidData.containsKey(bidObject.getKeyword())){
//				bidData.put(bidObject.getKeyword(),compBidData.get(bidObject.getKeyword()));
//				/*
//				try {
//					bidObject=client.setBidForKeyWord(accountID, bidObject.getBidID(), adGroupID, 
//							(((Long) new Double(compBidData.get(bidObject.getKeyword())*1e6).longValue())/10000L)*10000L );
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
//		for(int i=0; i<bidObjects.length; i++){
//			bidObject = bidObjects[i];
////			client.getBidLandscapeForKeyword(accountID, adGroupID, bidObjects[i].getBidID());
//			if (nonCompKeywords.contains(bidObject.getKeyword())){
//				bidData.put(bidObject.getKeyword(),(bidObject.getFirstPageCpc()+addValue)*1e-6);
//				/*
//				try {
//					bidObject=client.setBidForKeyWord(accountID, bidObject.getBidID(), adGroupID,bidObject.getFirstPageCpc()+addValue );
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
	
	
	
	private void addWords(String accountID,
//			Long campaignID, Long adGroupID, ArrayList<String> keywords, Long maxCPC, GoogleAdwordsServiceClient client){
		Long campaignID, Long adGroupID, ArrayList<String> keywords, Long maxCPC, GoogleAdwordsServiceImpl client){


		for(String word : keywords){
			try {
				client.addKeyWordToAdGroup(accountID, adGroupID, word , KeywordMatchType.EXACT, maxCPC);
//				logger.info(bidObject.getKeyword()+": "+bidObject.getFirstPageCpc()*1e-6 + ": " + bidObject.getQualityScore());
				logger.info("Added keyword: "+word+"to the account.");
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Couldn't add keyword: "+word+"to the account. Exception received.");
			}
		}

	}
	
	private TrafficEstimatorObject getTrafficEstimationForKeywords(String accountID, Long campaignID, KeywordMatchType matchType,
			HashMap<String, Double> KeywordWithBid, GoogleAdwordsServiceImpl client) throws Exception {
//		HashMap<String, Double> KeywordWithBid, GoogleAdwordsServiceClient client) throws Exception {
		
		TrafficEstimatorObject o = null, o2;
		int i=0, k;
		boolean firstLoop = true;
		
		HashMap<String,Double> newKeywordWithBid = new HashMap<String,Double>();
		Iterator it = KeywordWithBid.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry me = (Map.Entry) it.next();
			String s = (String) me.getKey();
			newKeywordWithBid.put(s,KeywordWithBid.get(s));
			i++;
			if(i%500==0 || (!it.hasNext())){
				k=0;
				while(true) {
					Thread.sleep(1500+k*3000);
					try {
						o2 = client.getTrafficEstimationForKeywords(accountID, campaignID, matchType, newKeywordWithBid);
						break;
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("Received exception : will retry..., k="+(k+1));
						k++;
					}
				}
				newKeywordWithBid.clear();
				if(firstLoop){
					o=o2;
					firstLoop=false;
				} else {
					o.addGoogleTrafficEstimatorObject(o2);
				}
			} // if(i/500==0) 
		} // while(it.hasNext())
		
		
		return o;
		
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



			BidGeneratorServiceImpl bidGenerator = new BidGeneratorServiceImpl();
			//			bidGenerator.getBid(accountID, campaignID, adGroupID, keywords);
			bidGenerator.getBidsInitialGoogle(accountID, campaignID, adGroupID);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}