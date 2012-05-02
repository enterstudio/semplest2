package semplest.service.bidding;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;





import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
//import semplest.server.protocol.ProtocolEnum.NetworkSetting;
//import semplest.server.protocol.ProtocolEnum.MatchType;

//import semplest.server.protocol.adengine.TrafficEstimatorObject;


import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.interfaces.SemplestBiddingInterface;


import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.gson.Gson;





public class BidGeneratorServiceImpl implements SemplestBiddingInterface {
	
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidGeneratorServiceImpl.class);
	


	@Override
	public void initializeService(String input) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public String GetMonthlyBudgetPercentPerSE(String json) throws Exception
	{
		logger.debug("call  GetMonthlyBudgetPercentPerSE(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		ArrayList<String> searchEngine = gson.fromJson(data.get("searchEngine"),ArrayList.class);
		HashMap<String,Integer> res = GetMonthlyBudgetPercentPerSE(promotionID, searchEngine);
		return gson.toJson(res);
	}
	@Override
	public HashMap<String,Integer> GetMonthlyBudgetPercentPerSE (Integer promotionID, 
			ArrayList<String> searchEngine)  throws Exception  {
		
		return BidSplitter.GetMonthlyBudgetPercentPerSE (promotionID, searchEngine);

	}
	
	public void setBidsInitial(String json) throws Exception
	{
		logger.debug("call  setBidsInitial(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		String searchEngine = data.get("searchEngine");
		setBidsInitial( promotionID, searchEngine);
	}
	@Override
	public void setBidsInitial(Integer promotionID, String searchEngine) throws Exception {
		if (!AdEngine.existsAdEngine(searchEngine))
		{
			throw new Exception(searchEngine + " Not Found");
		}
		BidGeneratorObj.setBidsInitial(promotionID, searchEngine);
	}
	
	
	public void setBidsUpdate(String json) throws Exception
	{
		logger.debug("call  setBidsUpdate(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		String searchEngine = data.get("searchEngine");
		setBidsInitial( promotionID, searchEngine);
	}
	@Override
	public void setBidsUpdate(Integer promotionID, String searchEngine) throws Exception {
		if (!AdEngine.existsAdEngine(searchEngine))
		{
			throw new Exception(searchEngine + " Not Found");
		}
		BidGeneratorObj.setBidsUpdate(promotionID, searchEngine);
	}
	
	
	
	
	
	
	
	/* *********************************** OLD METHODS ********************************** */
	/* ***************************** WILL BE REMOVED IN FUTURE ************************** */

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