package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestBiddingInterface;

import com.google.gson.Gson;

public class SemplestBiddingServiceClient extends ServiceRun implements SemplestBiddingInterface, SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.service.bidding.BidGeneratorService";
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(SemplestBiddingServiceClient.class);
	private String baseurl = null;

	public static void main(String[] args)
	{
		try
		{
			String cust = "0";
			Long camp = 1L;
			Long ad = 2L;
			ArrayList<String> keywords = new  ArrayList<String>();
			keywords.add("peanut butter"); 
			keywords.add("ice"); 
			SemplestBiddingServiceClient client = new SemplestBiddingServiceClient(null);
			HashMap<String, Double> res = client.getBid(cust, camp, ad, keywords);
			System.out.println(String.valueOf(res.get("ice")));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public SemplestBiddingServiceClient(String baseurl)
	{
		if (baseurl == null)
		{
			this.baseurl = BASEURLTEST;
		}
		else
		{
			this.baseurl = baseurl;
		}
	}
	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public void setInitialDefaultBid(Integer promotionID,
			ArrayList<String> searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		String searchEngStr = gson.toJson(searchEngine, ArrayList.class);
		jsonHash.put("searchEngine", searchEngStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		runMethod(BASEURLTEST, SERVICEOFFERED, "setInitialDefaultBid", json, timeoutMS);
		
	}
	@Override
	public HashMap<String, Integer> GetMonthlyBudgetPercentPerSE(Integer promotionID, ArrayList<String> searchEngine)
			throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		String searchEngStr = gson.toJson(searchEngine, ArrayList.class);
		jsonHash.put("searchEngine", searchEngStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "GetMonthlyBudgetPercentPerSE", json, timeoutMS);
		return gson.fromJson(returnData, HashMap.class);
	}
	@Override
	public void setBidsInitial(Integer promotionID, String searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		jsonHash.put("searchEngine", searchEngine);
		String json = protocolJson.createJSONHashmap(jsonHash);
		runMethod(BASEURLTEST, SERVICEOFFERED, "setBidsInitial", json, timeoutMS);
	}
	@Override
	public void setBidsUpdate(Integer promotionID, String searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		jsonHash.put("searchEngine", String.valueOf(searchEngine));
		String json = protocolJson.createJSONHashmap(jsonHash);
		runMethod(BASEURLTEST, SERVICEOFFERED, "setBidsUpdate", json, timeoutMS);
	}

	@Override
	public HashMap<String, Double> getBid(String accountID, Long campaignID, Long adGroupID, ArrayList<String> keywords) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String keyLevelStr = gson.toJson(keywords, ArrayList.class);
		jsonHash.put("keywords",keyLevelStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getBid", json, timeoutMS);
		return gson.fromJson(returnData, HashMap.class);
	}
	@Override
	public TaskOutput RunTask(String method, String jsonParameters, String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}

	@Override
	public void getBidsInitial(String accountID,
			Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("searchEngine", String.valueOf(searchEngine));
		String json = protocolJson.createJSONHashmap(jsonHash);

		runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsInitial", json, timeoutMS);
//		String returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsInitial", json, timeoutMS);
//		return gson.fromJson(returnData, ArrayList.class);
	}
	@Override
	public void getBidsUpdate(String accountID,
			Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("searchEngine", String.valueOf(searchEngine));
		String json = protocolJson.createJSONHashmap(jsonHash);

		runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsUpdate", json, timeoutMS);
//		String returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsUpdate", json, timeoutMS);
//		return gson.fromJson(returnData, ArrayList.class);
	}
	@Override
	public void getBidsInitialNaive(String accountID,
			Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("searchEngine", String.valueOf(searchEngine));
		String json = protocolJson.createJSONHashmap(jsonHash);

		runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsInitialNaive", json, timeoutMS);

	}
	@Override
	public void getBidsUpdateNaive(String accountID,
			Long campaignID, Long adGroupID, String searchEngine) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("searchEngine", String.valueOf(searchEngine));
		String json = protocolJson.createJSONHashmap(jsonHash);

		runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsUpdateNaive", json, timeoutMS);
//		String returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getBidsUpdate", json, timeoutMS);
//		return gson.fromJson(returnData, ArrayList.class);
	}




}
