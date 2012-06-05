package semplest.services.client.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;

import com.google.gson.Gson;

public class SemplestAdEngineServiceClient extends ServiceRun implements SemplestAdengineServiceInterface, SchedulerTaskRunnerInterface
{
	private static final Logger logger = Logger.getLogger(SemplestAdEngineServiceClient.class);
	
	public static final DateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	
	private static String SERVICEOFFERED = "semplest.server.service.adengine.SemplestAdengineService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private String baseurl;
	
	public static void main(String[] args) throws Exception
	{
		BasicConfigurator.configure();
		final SemplestAdEngineServiceClient client = new SemplestAdEngineServiceClient(null);

		/*		
		
		//
		// UpdateGeoTargeting
		//
		final Integer PromotionID = 62;
		final List<String> adEngines = new ArrayList<String>();
		adEngines.add(AdEngine.Google.name());
		client.UpdateGeoTargeting(PromotionID, adEngines);
	
		
		//
		// AddAd
		//
		final Integer promotionID_AddAd = 62;
		final Integer promotionAdID_AddAd = 218;
		final List<String> adEngines_AddAd = new ArrayList<String>();
		adEngines_AddAd.add(AdEngine.Google.name());
		client.AddAd(promotionID_AddAd, promotionAdID_AddAd, adEngines_AddAd);

		
		//
		// UpdateAd
		//		
		final Integer promotionID_UpdateAd = 62;
		final Integer promotionAdID_UpdateAd = 218;
		final List<String> adEngines_UpdateAd = new ArrayList<String>();
		adEngines_UpdateAd.add(AdEngine.Google.name());
		//adEngines_UpdateAd.add(AdEngine.MSN.name());
		client.UpdateAd(promotionID_UpdateAd, promotionAdID_UpdateAd, adEngines_UpdateAd);
		
			
		//
		// DeleteAd
		//
		final Integer promotionID_DeleteAd = 62;
		final Integer promotionAdID_DeleteAd = 218;
		final List<String> adEngines_DeleteAd = new ArrayList<String>();
		adEngines_DeleteAd.add(AdEngine.Google.name());
		client.DeleteAd(promotionID_DeleteAd, promotionAdID_DeleteAd, adEngines_DeleteAd);		
		// 9824192 old, 9824193 new (30 in semplest, 10 in google)
		// added: 9824192
		
		
		//
		// DeleteAdEngineAd
		//
		final Integer customerID_DeleteAdEngineAd = 10;
		final Integer promotionID_DeleteAdEngineAd = 62;
		final Integer promotionAdID_DeleteAdEngineAd = 218; 
		final List<String> adEngines_DeleteAdEngineAd = new ArrayList<String>();
		adEngines_DeleteAdEngineAd.add(AdEngine.Google.name());
		client.DeleteAdEngineAd(customerID_DeleteAdEngineAd, promotionID_DeleteAdEngineAd, promotionAdID_DeleteAdEngineAd, adEngines_DeleteAdEngineAd);
		 
		
		//
		// UpdateBudget
		//
		final Integer promotionID_UpdateBudget = 62; 
		final Double changeInBudget_UpdateBudget = 10d; 
		final List<String> adEngines_UpdateBudget = new ArrayList<String>();
		adEngines_UpdateBudget.add(AdEngine.Google.name());
		client.UpdateBudget(promotionID_UpdateBudget, changeInBudget_UpdateBudget, adEngines_UpdateBudget);
		// current: 6250000                 campaign: 637295; ad group: 3066031127
		
		
		//
		// ChangePromotionStartDate
		//
		final Integer promotionID_ChangePromotionStartDate = 62; 
		final List<String> adEngines_ChangePromotionStartDate = new ArrayList<String>();
		final java.util.Date newStartDate_ChangePromotionStartDate = new java.util.Date();
		adEngines_ChangePromotionStartDate.add(AdEngine.Google.name());
		client.ChangePromotionStartDate(promotionID_ChangePromotionStartDate, newStartDate_ChangePromotionStartDate, adEngines_ChangePromotionStartDate);

		
		//
		// DeleteKeyword
		//
		final Integer promotionID_DeleteKeyword = 62;
		final String keyword_DeleteKeyword = "HelloKeyword";
		final List<String> adEngines_DeleteKeyword = new ArrayList<String>();
		adEngines_DeleteKeyword.add(AdEngine.Google.name());
		client.DeleteKeyword(promotionID_DeleteKeyword, keyword_DeleteKeyword, adEngines_DeleteKeyword);
		
		
		//
		// PausePromotion
		//
		final Integer promotionID_PausePromotion = 62; 
		final List<String> adEngines_PausePromotion = new ArrayList<String>();
		adEngines_PausePromotion.add(AdEngine.Google.name());
		client.PausePromotion(promotionID_PausePromotion, adEngines_PausePromotion);
	
		
		//
		// UnpausePromotion
		//
		final Integer promotionID_UnpausePromotion = 62; 
		final List<String> adEngines_UnpausePromotion = new ArrayList<String>();
		adEngines_UnpausePromotion.add(AdEngine.Google.name());
		client.UnpausePromotion(promotionID_UnpausePromotion, adEngines_UnpausePromotion);		
		
		
		//
		// RefreshSiteLinksForAd
		//
		final Integer promotionID_RefreshSiteLinksForAd = 62;
		final Integer promotionAdID_RefreshSiteLinksForAd = 218;
		final List<String> adEngines_RefreshSiteLinksForAd = new ArrayList<String>();
		adEngines_RefreshSiteLinksForAd.add(AdEngine.Google.name());
		client.RefreshSiteLinksForAd(promotionID_RefreshSiteLinksForAd, promotionAdID_RefreshSiteLinksForAd, adEngines_RefreshSiteLinksForAd);
		*/
		
		//
		// PauseProductGroup
		//
		final Integer productGroupID_PauseProductGroup = 76;
		final List<String> adEngines_PauseProductGroup = new ArrayList<String>();
		adEngines_PauseProductGroup.add(AdEngine.Google.name());
		client.PauseProductGroup(productGroupID_PauseProductGroup, adEngines_PauseProductGroup);
		
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	
	public SemplestAdEngineServiceClient(String baseurl)
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
	public Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList)
			throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		final String adEngineListStr = gson.toJson(adEngineList,ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "AddPromotionToAdEngine", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean PausePromotion(Integer promotionID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("PromotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "PausePromotion", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	
	@Override
	public Boolean UnpausePromotion(Integer promotionID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("PromotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "UnpausePromotion", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean PauseProductGroup(Integer productGroupID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("productGroupID", Integer.toString(productGroupID));		
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("PauseProductGroup JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "PauseProductGroup", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	
	@Override
	public Boolean DeleteAdEngineAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("DeleteAd JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "DeleteAdEngineAd", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean DeleteAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("DeleteAd JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "DeleteAd", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean UpdateGeoTargeting(Integer PromotionID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("PromotionID", Integer.toString(PromotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "UpdateGeoTargeting", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "ExecuteBidProcess", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public TaskOutput RunTask(String method, String jsonParameters,String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}

	@Override
	public Boolean UpdateAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("DeleteAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "UpdateAd", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("changeInBudget", Double.toString(changeInBudget));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("DeleteAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "UpdateBudget", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String newStartDateString = DATE_FORMAT_YYYYMMDD.format(newStartDate);
		jsonHash.put("newStartDate", newStartDateString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "ChangePromotionStartDate", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	
	@Override
	public Boolean DeleteKeyword(Integer promotionID, String keyword, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("keyword", keyword);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "DeleteKeyword", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean AddAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "AddAd", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	
	@Override
	public Boolean RefreshSiteLinksForAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("AddAd JSON [" + json + "]");
		String returnData = runMethod(baseurl, SERVICEOFFERED, "RefreshSiteLinksForAd", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

}
