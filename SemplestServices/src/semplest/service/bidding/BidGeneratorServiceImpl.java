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
			// getBidsInitialGoogle(accountID, campaignID, adGroupID);
			BidGeneratorObj bidGenerator = new BidGeneratorObj();
			bidGenerator.getBidsInitialGoogle(accountID, campaignID, adGroupID);
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
	
	// ----------------------------------
	// Naive bidder
	public void getBidsInitialNaive(String json) throws Exception
	{
		logger.debug("call  getBidsInitial(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		String searchEngine = data.get("searchEngine");
		getBidsInitialNaive( accountID, campaignID, adGroupID, searchEngine);
//		return gson.toJson(res);
	}
	
	@Override
	public void getBidsInitialNaive(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		if (!AdEngine.existsAdEngine(searchEngine))
		{
			throw new Exception(searchEngine + " Not Found");
		}
		if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name())){
			getBidsInitialGoogleNaive(accountID, campaignID, adGroupID);
		} else if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.MSN.name())){
			// getBidsInitialMSN(accountID, campaignID, adGroupID);
		} 
	}
	
	
	public void getBidsUpdateNaive(String json) throws Exception
	{
		logger.debug("call  getBidsUpdate(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		String searchEngine = data.get("searchEngine");
		getBidsUpdateNaive( accountID, campaignID, adGroupID, searchEngine);
	}
	
	@Override
	public void getBidsUpdateNaive(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		if (!AdEngine.existsAdEngine(searchEngine))
		{
			throw new Exception(searchEngine + " Not Found");
		}
		
		if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name())){
			getBidsUpdateGoogleNaive(accountID, campaignID, adGroupID);
		} else if(searchEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.MSN.name())){
			// getBidsUpdateMSN(accountID, campaignID, adGroupID);
		}
	}
	
	// End Naive Bidder-------------------------------------------------

	public String GetMonthlyBudgetPerSE(String json) throws Exception
	{
		logger.debug("call  getBid(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		ArrayList<String> searchEngine = gson.fromJson(data.get("searchEngine"),ArrayList.class);
		Double TotalMonthlyBudget = Double.parseDouble(data.get("TotalMonthlyBudget"));
		HashMap<String,Double> res = GetMonthlyBudgetPerSE(searchEngine, TotalMonthlyBudget);
		return gson.toJson(res);
	}

	@Override
	public HashMap<String,Double> GetMonthlyBudgetPerSE (ArrayList<String> searchEngine, 
			Double TotalMonthlyBudget)  throws Exception  {
		
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
	
	
	//--------------------------- -------------------
	// Details for Naive bidder 
	private void getBidsInitialGoogleNaive(String accountID, Long campaignID, Long adGroupID) throws Exception {	
		logger.info("Naive Bidder: Computing initial bids for Google campaign...");
	}
	private void getBidsUpdateGoogleNaive(String accountID, Long campaignID, Long adGroupID) throws Exception {	
		
		logger.info("Naive bidder: Updating bids for Google campaign...");
	}
	
	//------------- End Naive bidder
	


}