package semplest.services.client.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.ProtocolEnum.AdEngine;

import com.google.gson.Gson;

public class SemplestAdEngineServiceClient extends ServiceRun
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
		// scheduleAddAd
		final Integer customerID_ScheduleAddAd = 12;
		final Integer promotionID_ScheduleAddAd = 62;
		final Integer promotionAdID_ScheduleAddAd = 218;
		final List<String> adEngines_ScheduleAddAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleAddAd(customerID_ScheduleAddAd, promotionID_ScheduleAddAd, promotionAdID_ScheduleAddAd, adEngines_ScheduleAddAd);
			
		// AddAd
		final Integer promotionID_AddAd = 62;
		final Integer promotionAdID_AddAd = 218;
		final List<String> adEngines_AddAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testAddAd(promotionID_AddAd, promotionAdID_AddAd, adEngines_AddAd);

		// scheduleDeleteAd
		final Integer customerID_scheduleDeleteAd = 12;
		final Integer promotionID_scheduleDeleteAd = 62;
		final Integer promotionAdID_scheduleDeleteAd = 218;
		final List<String> adEngines_scheduleDeleteAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleDeleteAd(customerID_scheduleDeleteAd, promotionID_scheduleDeleteAd, promotionAdID_scheduleDeleteAd, adEngines_scheduleDeleteAd);

		// DeleteAd
		final Integer promotionID_DeleteAd = 62;
		final Integer promotionAdID_DeleteAd = 218;
		final List<String> adEngines_DeleteAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testDeleteAd(promotionID_DeleteAd, promotionAdID_DeleteAd, adEngines_DeleteAd);
		
		// scheduleUpdateAd
		final Integer customerID_scheduleUpdateAd = 12;
		final Integer promotionID_scheduleUpdateAd = 62;
		final Integer promotionAdID_scheduleUpdateAd = 218;
		final List<String> adEngines_scheduleUpdateAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleUpdateAd(customerID_scheduleUpdateAd, promotionID_scheduleUpdateAd, promotionAdID_scheduleUpdateAd, adEngines_scheduleUpdateAd);
*/
		// UpdateAd
		final Integer promotionID_UpdateAd = 62;
		final Integer promotionAdID_UpdateAd = 218;
		final List<String> adEngines_UpdateAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testUpdateAd(promotionID_UpdateAd, promotionAdID_UpdateAd, adEngines_UpdateAd);
/*
		// scheduleUpdateGeoTargeting
		final Integer customerID_scheduleUpdateGeoTargeting = 12;
		final Integer promotionID_scheduleUpdateGeoTargeting = 62;
		final List<String> adEngines_scheduleUpdateGeoTargeting = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleUpdateGeoTargeting(customerID_scheduleUpdateGeoTargeting, promotionID_scheduleUpdateGeoTargeting, adEngines_scheduleUpdateGeoTargeting);

		// UpdateGeoTargeting
		final Integer promotionID_UpdateGeoTargeting = 62;
		final List<String> adEngines_UpdateGeoTargeting = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testUpdateGeoTargeting(promotionID_UpdateGeoTargeting, adEngines_UpdateGeoTargeting);
		
		// scheduleChangePromotionStartDate
		final Integer customerID_scheduleChangePromotionStartDate = 12;
		final Integer promotionID_scheduleChangePromotionStartDate = 62;
		final java.util.Date newStartDate_scheduleChangePromotionStartDate = new java.util.Date();
		final List<String> adEngines_scheduleChangePromotionStartDate = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleChangePromotionStartDate(customerID_scheduleChangePromotionStartDate, promotionID_scheduleChangePromotionStartDate, newStartDate_scheduleChangePromotionStartDate, adEngines_scheduleChangePromotionStartDate);

		// ChangePromotionStartDate
		final Integer promotionID_ChangePromotionStartDate = 62;
		final java.util.Date newStartDate_ChangePromotionStartDate = new java.util.Date();
		final List<String> adEngines_ChangePromotionStartDate = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testChangePromotionStartDate(promotionID_ChangePromotionStartDate, newStartDate_ChangePromotionStartDate, adEngines_ChangePromotionStartDate);

		// scheduleUpdateBudget
		final Integer customerID_scheduleUpdateBudget = 12;
		final Integer promotionID_scheduleUpdateBudget = 62;
		final Double changeInBudget_scheduleUpdateBudget = -5.25;
		final List<String> adEngines_scheduleUpdateBudget = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleUpdateBudget(customerID_scheduleUpdateBudget, promotionID_scheduleUpdateBudget, changeInBudget_scheduleUpdateBudget, adEngines_scheduleUpdateBudget);

		// UpdateBudget
		final Integer promotionID_UpdateBudget = 62;
		final Double changeInBudget_UpdateBudget = -5.25;
		final List<String> adEngines_UpdateBudget = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testUpdateBudget(promotionID_UpdateBudget, changeInBudget_UpdateBudget, adEngines_UpdateBudget);

		// schedulePausePromotion
		final Integer customerID_schedulePausePromotion = 12;
		final Integer promotionID_schedulePausePromotion = 62;
		final List<String> adEngines_schedulePausePromotion = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testSchedulePausePromotion(customerID_schedulePausePromotion, promotionID_schedulePausePromotion, adEngines_schedulePausePromotion);

		// schedulePausePromotion
		final Integer promotionID_PausePromotion = 62;
		final List<String> adEngines_PausePromotion = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testPausePromotion(promotionID_PausePromotion, adEngines_PausePromotion);
		
		// scheduleAddPromotionToAdEngine
		final Integer customerID_scheduleAddPromotionToAdEngine = 12;
		final Integer productGroupID_scheduleAddPromotionToAdEngine = 76;
		final Integer promotionID_scheduleAddPromotionToAdEngine = 62;
		final ArrayList<String> adEngines_scheduleAddPromotionToAdEngine = new ArrayList(Arrays.asList(new String[]{AdEngine.Google.name()}));
		client.testScheduleAddPromotionToAdEngine(customerID_scheduleAddPromotionToAdEngine, productGroupID_scheduleAddPromotionToAdEngine, promotionID_scheduleAddPromotionToAdEngine, adEngines_scheduleAddPromotionToAdEngine);
			
		// AddPromotionToAdEngine
		final Integer customerID_AddPromotionToAdEngine = 12;
		final Integer productGroupID_AddPromotionToAdEngine = 76;
		final Integer promotionID_AddPromotionToAdEngine = 62;
		final ArrayList<String> adEngines_AddPromotionToAdEngine = new ArrayList(Arrays.asList(new String[]{AdEngine.Google.name()}));
		client.testAddPromotionToAdEngine(customerID_AddPromotionToAdEngine, productGroupID_AddPromotionToAdEngine, promotionID_AddPromotionToAdEngine, adEngines_AddPromotionToAdEngine);

		// scheduleDeleteKeyword
		final Integer customerID_scheduleDeleteKeyword = 12;
		final Integer promotionID_scheduleDeleteKeyword = 62;
		final String keyword_scheduleDeleteKeyword = "SomeKeyword123";
		final List<String> adEngines_scheduleDeleteKeyword = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleDeleteKeyword(customerID_scheduleDeleteKeyword, promotionID_scheduleDeleteKeyword, keyword_scheduleDeleteKeyword, adEngines_scheduleDeleteKeyword);

		// DeleteKeyword
		final Integer promotionID_scheduleDeleteKeyword = 62;
		final String keyword_scheduleDeleteKeyword = "SomeKeyword123";
		final List<String> adEngines_scheduleDeleteKeyword = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testDeleteKeyword(promotionID_scheduleDeleteKeyword, keyword_scheduleDeleteKeyword, adEngines_scheduleDeleteKeyword);

		// scheduleRefreshSiteLinksForAd
		final Integer customerID_scheduleRefreshSiteLinksForAd = 12;
		final Integer promotionID_scheduleRefreshSiteLinksForAd = 62;
		final Integer promotionAdID_scheduleRefreshSiteLinksForAd = 218;
		final List<String> adEngines_scheduleRefreshSiteLinksForAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleRefreshSiteLinksForAd(customerID_scheduleRefreshSiteLinksForAd, promotionID_scheduleRefreshSiteLinksForAd, promotionAdID_scheduleRefreshSiteLinksForAd, adEngines_scheduleRefreshSiteLinksForAd);

		// RefreshSiteLinksForAd
		final Integer promotionID_RefreshSiteLinksForAd = 62;
		final Integer promotionAdID_RefreshSiteLinksForAd = 218;
		final List<String> adEngines_RefreshSiteLinksForAd = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testRefreshSiteLinksForAd(promotionID_RefreshSiteLinksForAd, promotionAdID_RefreshSiteLinksForAd, adEngines_RefreshSiteLinksForAd);

		// schedulePauseProductGroup
		final Integer customerID_schedulePauseProductGroup = 12;
		final Integer productGroupID_schedulePauseProductGroup = 76;
		final List<String> adEngines_schedulePauseProductGroup = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testSchedulePauseProductGroup(customerID_schedulePauseProductGroup, productGroupID_schedulePauseProductGroup, adEngines_schedulePauseProductGroup);
			
		// PauseProductGroup
		final Integer customerID_PauseProductGroup = 12;
		final Integer productGroupID_PauseProductGroup = 76;
		final List<String> adEngines_PauseProductGroup = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testSchedulePauseProductGroup(customerID_PauseProductGroup, productGroupID_PauseProductGroup, adEngines_PauseProductGroup);		

		// scheduleUnpausePromotion
		final Integer customerID_scheduleUnpausePromotion = 12;
		final Integer promotionID_scheduleUnpausePromotion = 62;
		final List<String> adEngines_scheduleUnpausePromotion = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testScheduleUnpausePromotion(customerID_scheduleUnpausePromotion, promotionID_scheduleUnpausePromotion, adEngines_scheduleUnpausePromotion);
		
		// UnpausePromotion
		final Integer promotionID_UnpausePromotion = 62;
		final List<String> adEngines_UnpausePromotion = Arrays.asList(new String[]{AdEngine.Google.name()});
		client.testUnpausePromotion(promotionID_UnpausePromotion, adEngines_UnpausePromotion);
*/		
	}
	
	public void testScheduleAddAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final String methodName = "scheduleAddAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testAddAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final String methodName = "AddAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleDeleteAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleDeleteAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}

	public void testDeleteAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		final String methodName = "DeleteAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleUpdateAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleUpdateAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testUpdateAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception 
	{
		final String methodName = "UpdateAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleUpdateGeoTargeting(Integer customerID, Integer PromotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleUpdateGeoTargeting";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(PromotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testUpdateGeoTargeting(Integer PromotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "UpdateGeoTargeting";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("PromotionID", Integer.toString(PromotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleChangePromotionStartDate(Integer customerID, Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleChangePromotionStartDate";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String newStartDateString = DATE_FORMAT_YYYYMMDD.format(newStartDate);
		jsonHash.put("newStartDate", newStartDateString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception 
	{
		final String methodName = "ChangePromotionStartDate";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String newStartDateString = DATE_FORMAT_YYYYMMDD.format(newStartDate);
		jsonHash.put("newStartDate", newStartDateString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleUpdateBudget(Integer customerID, Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleUpdateBudget";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();	
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("changeInBudget", Double.toString(changeInBudget));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testUpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception 
	{
		final String methodName = "UpdateBudget";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();	
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("changeInBudget", Double.toString(changeInBudget));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
		
	public void testSchedulePausePromotion(Integer customerID, Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "schedulePausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testPausePromotion(Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "PausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleUnpausePromotion(Integer customerID, Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleUnpausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testUnpausePromotion(Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "UnpausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleDeleteKeyword(Integer customerID, Integer promotionID, String keyword, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleDeleteKeyword";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("keyword", keyword);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}

	public void testDeleteKeyword(Integer promotionID, String keyword, List<String> adEngines) throws Exception 
	{
		final String methodName = "DeleteKeyword";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("keyword", keyword);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
		
	public void testScheduleRefreshSiteLinksForAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception 
	{
		final String methodName = "scheduleRefreshSiteLinksForAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testRefreshSiteLinksForAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception 
	{
		final String methodName = "RefreshSiteLinksForAd";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("promotionAdID", Integer.toString(promotionAdID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testSchedulePauseProductGroup(Integer customerID, Integer productGroupID, List<String> adEngines) throws Exception 
	{
		final String methodName = "schedulePauseProductGroup";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));		
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testPauseProductGroup(Integer productGroupID, List<String> adEngines) throws Exception
	{
		final String methodName = "PauseProductGroup";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("productGroupID", Integer.toString(productGroupID));		
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testScheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		final String methodName = "scheduleAddPromotionToAdEngine";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		final String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");		
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		final String methodName = "AddPromotionToAdEngine";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		final String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");		
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
	}
	
	public void testExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		final String methodName = "ExecuteBidProcess";
		HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessully)
		{
			throw new Exception(methodName + " failed");
		}
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
	
	public TaskOutput RunTask(String method, String jsonParameters,String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}

}
