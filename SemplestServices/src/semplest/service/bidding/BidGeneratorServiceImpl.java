package semplest.service.bidding;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.service.SemplestConfiguration;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.interfaces.SemplestBiddingInterface;
import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.gson.Gson;





public class BidGeneratorServiceImpl implements SemplestBiddingInterface {
	
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidGeneratorServiceImpl.class);
	

	

	@Override
	public void initializeService(String input) throws Exception {
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		
	}
	
	
	public String GetMonthlyBudgetPercentPerSE(String json) throws Exception
	{
		logger.debug("call  GetMonthlyBudgetPercentPerSE(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> searchEngineStrings = gson.fromJson(data.get("searchEngine"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(searchEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(searchEngineStrings);
		final HashMap<AdEngine,Double> res = GetMonthlyBudgetPercentPerSE(promotionID, adEngines);
		return gson.toJson(res);
	}
	
	@Override
	public HashMap<AdEngine,Double> GetMonthlyBudgetPercentPerSE (Integer promotionID, List<AdEngine> searchEngine)  throws Exception  
	{
		return BidSplitter.GetMonthlyBudgetPercentPerSE(promotionID, searchEngine);
	}
	
	public String getInitialValues(String json) throws Exception 
	{
		logger.debug("call  setInitialDefaultBid(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Double totalMonthlyBudget = Double.parseDouble(data.get("totalMonthlyBudget"));
		final List<String> searchEngineStrings = gson.fromJson(data.get("searchEngine"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(searchEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(searchEngineStrings);
		final Map<AdEngine,AdEngineInitialData> res = getInitialValues(promotionID, adEngines, totalMonthlyBudget);
		return gson.toJson(res);
	}
	
	@Override
	public Map<AdEngine,AdEngineInitialData> getInitialValues(Integer promotionID, List<AdEngine> searchEngine, Double totalMonthlyBudget) throws Exception 
	{
		//BidGeneratorObj bidGeneratorObj = new BidGeneratorObj();
		//return bidGeneratorObj.getInitialValues(promotionID, searchEngine, totalMonthlyBudget);
		BidObject bidObj = new BidObject();
		return bidObj.getInitialValues(promotionID, searchEngine, totalMonthlyBudget);
	}
	
	public String setBidsInitial(String json) throws Exception
	{
		logger.debug("call  setBidsInitial(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String searchEngine = data.get("searchEngine");		
		AdEngine.validateAdEngine(searchEngine);
		final AdEngine adEngine = AdEngine.valueOf(searchEngine);
		final BudgetObject budgetData = gson.fromJson(data.get("budgetData"),BudgetObject.class);
		final Boolean res = setBidsInitial( promotionID, adEngine, budgetData);
		return gson.toJson(res);
	}
	
	@Override
	public Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception 
	{
		//final BidGeneratorObj bidGeneratorObj = new BidGeneratorObj();
		//final Boolean res = bidGeneratorObj.setBidsInitial(promotionID, searchEngine, budgetData);
		final BidObject bidObj = new BidObject();
		final Boolean res = bidObj.setBidsInitial(promotionID, searchEngine, budgetData);
		return res;
	}
		
	public String setBidsUpdate(String json) throws Exception
	{
		logger.debug("call  setBidsUpdate(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String searchEngine = data.get("searchEngine");
		AdEngine.validateAdEngine(searchEngine);
		final AdEngine adEngine = AdEngine.valueOf(searchEngine);
		final BudgetObject budgetData = gson.fromJson(data.get("budgetData"),BudgetObject.class);
		final Boolean res = setBidsUpdate(promotionID, adEngine, budgetData);
		return gson.toJson(res);
	}
	@Override
	public Boolean setBidsUpdate(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception 
	{
		//BidGeneratorObj bidGeneratorObj = new BidGeneratorObj();
		//Boolean res = bidGeneratorObj.setBidsUpdate(promotionID, searchEngine, budgetData);
		// bidGeneratorObj.setBidsInitial(promotionID, searchEngine, BudgetObject budgetData);
		//return res;	
		logger.info("[PromotionID: "+promotionID+ "-"+searchEngine.name()+"]"+ " bids update is not doing anything right now.");
		return true;
	}
	
	
	
	
	
	
	
	/* *********************************** OLD METHODS ********************************** */
	/* ***************************** WILL BE REMOVED IN FUTURE ************************** */


	
	// ----------------------------------
	// Naive bidder
	public void getBidsInitialNaive(String json) throws Exception
	{
		logger.debug("call getBidsInitial(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String accountID = data.get("accountID");
		final Long campaignID = Long.parseLong(data.get("campaignID")); 
		final Long adGroupID = Long.parseLong(data.get("adGroupID"));
		final String searchEngine = data.get("searchEngine");
		AdEngine.validateAdEngine(searchEngine);
		final AdEngine adEngine = AdEngine.valueOf(searchEngine);
		getBidsInitialNaive(accountID, campaignID, adGroupID, adEngine);
//		return gson.toJson(res);
	}
	
	@Override
	public void getBidsInitialNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception 
	{
		if (searchEngine == AdEngine.Google)
		{
			getBidsInitialGoogleNaive(accountID, campaignID, adGroupID);
		} 
		else if(searchEngine == AdEngine.MSN)
		{
			// getBidsInitialMSN(accountID, campaignID, adGroupID);
		} 
	}
	
	
	public void getBidsUpdateNaive(String json) throws Exception
	{
		logger.debug("call getBidsUpdate(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String accountID = data.get("accountID");
		final Long campaignID = Long.parseLong(data.get("campaignID")); 
		final Long adGroupID = Long.parseLong(data.get("adGroupID"));
		final String searchEngine = data.get("searchEngine");
		AdEngine.validateAdEngine(searchEngine);
		final AdEngine adEngine = AdEngine.valueOf(searchEngine);
		getBidsUpdateNaive(accountID, campaignID, adGroupID, adEngine);
	}
	
	@Override
	public void getBidsUpdateNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception 
	{	
		if(searchEngine == AdEngine.Google)
		{
			getBidsUpdateGoogleNaive(accountID, campaignID, adGroupID);
		} 
		else if(searchEngine == AdEngine.MSN)
		{
			// getBidsUpdateMSN(accountID, campaignID, adGroupID);
		}
	}
	
	// End Naive Bidder-------------------------------------------------


	public String getBid(String json) throws Exception
	{
		logger.debug("call  getBid(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String accountID = data.get("accountID");
		final Long campaignID = Long.parseLong(data.get("campaignID")); 
		final Long adGroupID = Long.parseLong(data.get("adGroupID"));
		final List<String> keywords = gson.fromJson(data.get("keywords"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		final Map<String,Double> res = getBid(accountID, campaignID, adGroupID, keywords);
		return gson.toJson(res);
	}
	
	
	@Override
	public Map<String,Double> getBid(String accountID, Long campaignID, Long adGroupID, List<String> keywords) throws Exception 
	{
		throw new Exception("getBid(...) method is no longer in use! Use either setBidsInitial(...) or setBidsUpdate(...) instead.");		
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
				logger.error("Couldn't add keyword: "+word+"to the account. Exception received. "+e.getMessage(), e);
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
	
	
	
	
	
	
	public static ClassPathXmlApplicationContext appContext = null;

	public static void main(String [] args){
		// test 

		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}

			/*Properties properties = new Properties();
		FileInputStream is = new FileInputStream(PROPSFILE);
		properties.load(is);
		is.close();
			 */	


			BidGeneratorServiceImpl client = new BidGeneratorServiceImpl ();
			Integer promotionID = new Integer(60); 
			//Integer promotionID = new Integer(71); 
			String searchEngine = "Google";
			BudgetObject budgetData = new BudgetObject();
			budgetData.setRemainingBudgetInCycle(75.0);
			budgetData.setRemainingDays(31);
		
			//client.setBidsInitial(promotionID, searchEngine, budgetData);
		} catch (Exception e) {
			logger.info("Problem", e);
		}
	}
	
	public String checkStatus(String json) throws Exception{
		return checkStatus(null, null);
	}
	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		return ServiceStatus.Up.getServiceStatusValue();
	}


}