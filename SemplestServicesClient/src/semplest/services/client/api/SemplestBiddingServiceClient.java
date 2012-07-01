package semplest.services.client.api;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestBiddingInterface;
import semplest.util.SemplestUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SemplestBiddingServiceClient extends ServiceRun implements SemplestBiddingInterface, SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.service.bidding.BidGeneratorService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String DEFAULTBIDTIMEOUT = "3600000";
	
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(SemplestBiddingServiceClient.class);
	private String baseurl = null;
	private String timeoutMS = null;
	
	
	//public static ClassPathXmlApplicationContext appContext = null;


	public static void main(String[] args)
	{
		try
		{
			
			BasicConfigurator.configure();
 
			SemplestBiddingServiceClient client = new SemplestBiddingServiceClient(null, null);
			BudgetObject budgetData = new BudgetObject();
			budgetData.setRemainingBudgetInCycle(75.00);
			budgetData.setRemainingDays(31);
			
			//client.setBidsInitial(60, "Google", budgetData);
			
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}
		
	}
	public SemplestBiddingServiceClient(String baseurl, String timeoutMS)
	{
		if (baseurl == null)
		{
			this.baseurl = BASEURLTEST;
		}
		else
		{
			this.baseurl = baseurl;
		}
		if (timeoutMS == null)
		{
			this.timeoutMS =DEFAULTBIDTIMEOUT;
		}
		else
		{
			this.timeoutMS = timeoutMS;
		}
	}
	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}
	
	@Override
	public Map<AdEngine,AdEngineInitialData> getInitialValues(Integer promotionID, List<AdEngine> searchEngines) throws Exception 
	{	
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		final String searchEngStr = gson.toJson(searchEngines);
		jsonHash.put("searchEngine", searchEngStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "getInitialValues", json, timeoutMS);
		final Type type = new TypeToken<Map<AdEngine,AdEngineInitialData>>(){}.getType();
		return gson.fromJson(returnData, type);		
	}
	
	@Override
	public Map<AdEngine, Double> GetMonthlyBudgetPercentPerSE(Integer promotionID, List<AdEngine> searchEngine) throws Exception 
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		String searchEngStr = gson.toJson(searchEngine);
		jsonHash.put("searchEngine", searchEngStr);
		String json = protocolJson.createJSONHashmap(jsonHash);
		String returnData = runMethod(baseurl, SERVICEOFFERED, "GetMonthlyBudgetPercentPerSE", json, timeoutMS);
		return gson.fromJson(returnData, SemplestUtils.TYPE_MAP_OF_ADENGINE_TO_DOUBLE);
	}
	
	@Override
	public Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		jsonHash.put("searchEngine", searchEngine.name());
		jsonHash.put("budgetData", gson.toJson(budgetData, BudgetObject.class));
		String json = protocolJson.createJSONHashmap(jsonHash);
		String returnData = runMethod(baseurl, SERVICEOFFERED, "setBidsInitial", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	
	@Override
	public Boolean setBidsUpdate(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception {
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", String.valueOf(promotionID));
		jsonHash.put("searchEngine", searchEngine.name());
		jsonHash.put("budgetData", gson.toJson(budgetData, BudgetObject.class));
		String json = protocolJson.createJSONHashmap(jsonHash);
		String returnData = runMethod(baseurl, SERVICEOFFERED, "setBidsUpdate", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public HashMap<String, Double> getBid(String accountID, Long campaignID, Long adGroupID, List<String> keywords) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String keyLevelStr = gson.toJson(keywords);
		jsonHash.put("keywords",keyLevelStr);
		String json = protocolJson.createJSONHashmap(jsonHash);
		String returnData = runMethod(baseurl, SERVICEOFFERED, "getBid", json, timeoutMS);
		final Type type = new TypeToken<Map<String, Double>>(){}.getType();
		return gson.fromJson(returnData, type);
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
	public void getBidsInitialNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception 
	{	
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("searchEngine", searchEngine.name());
		String json = protocolJson.createJSONHashmap(jsonHash);
		runMethod(baseurl, SERVICEOFFERED, "getBidsInitialNaive", json, timeoutMS);
	}
	
	@Override
	public void getBidsUpdateNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception 
	{	
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("searchEngine", searchEngine.name());
		String json = protocolJson.createJSONHashmap(jsonHash);
		runMethod(baseurl, SERVICEOFFERED, "getBidsUpdateNaive", json, timeoutMS);
	}




}
