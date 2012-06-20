package semplest.services.client.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
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
		final SemplestAdEngineServiceClient client = new SemplestAdEngineServiceClient("http://VMDEVJAVA1:9898/semplest");
		//final SemplestAdEngineServiceClient client = new SemplestAdEngineServiceClient("http://172.18.9.26:9898/semplest");
/*
		// scheduleAddAds
		final Integer customerID_ScheduleAddAds = 12;
		final Integer promotionID_ScheduleAddAds = 62;
		final List<Integer> promotionAdIds_ScheduleAddAds = Arrays.asList(218);
		final List<String> adEngines_ScheduleAddAds = Arrays.asList(AdEngine.Google.name());
		client.scheduleAddAds(customerID_ScheduleAddAds, promotionID_ScheduleAddAds, promotionAdIds_ScheduleAddAds, adEngines_ScheduleAddAds);

		// AddAds
		final Integer promotionID_AddAds = 62;
		final List<Integer> promotionAdIs_AddAds = Arrays.asList(218);
		final List<String> adEngines_AddAds = Arrays.asList(AdEngine.Google.name());
		client.AddAds(promotionID_AddAds, promotionAdIs_AddAds, adEngines_AddAds);
		
		// scheduleDeleteAds
		final Integer customerID_scheduleDeleteAds = 12;
		final Integer promotionID_scheduleDeleteAds = 62;
		final List<Integer> promotionAdIds_scheduleDeleteAds = Arrays.asList(218);
		final List<String> adEngines_scheduleDeleteAds = Arrays.asList(AdEngine.Google.name());
		client.scheduleDeleteAds(customerID_scheduleDeleteAds, promotionID_scheduleDeleteAds, promotionAdIds_scheduleDeleteAds, adEngines_scheduleDeleteAds);

		// DeleteAds
		final Integer promotionID_DeleteAds = 62;
		final List<Integer> promotionAdIds_DeleteAds = Arrays.asList(218);
		final List<String> adEngines_DeleteAds = Arrays.asList(AdEngine.Google.name());
		client.DeleteAds(promotionID_DeleteAds, promotionAdIds_DeleteAds, adEngines_DeleteAds);

		// scheduleUpdateAds
		final Integer customerID_scheduleUpdateAds = 12;
		final Integer promotionID_scheduleUpdateAds = 62;
		final List<Integer> promotionAdIds_scheduleUpdateAds = Arrays.asList(218);
		final List<String> adEngines_scheduleUpdateAds = Arrays.asList(AdEngine.Google.name());
		client.scheduleUpdateAds(customerID_scheduleUpdateAds, promotionID_scheduleUpdateAds, promotionAdIds_scheduleUpdateAds, adEngines_scheduleUpdateAds);
		
		// UpdateAds
		final Integer promotionID_UpdateAds = 62;
		final List<Integer> promotionAdIds_UpdateAds = Arrays.asList(218);
		final List<String> adEngines_UpdateAds = Arrays.asList(AdEngine.Google.name());
		client.UpdateAds(promotionID_UpdateAds, promotionAdIds_UpdateAds, adEngines_UpdateAds);

		// scheduleUpdateGeoTargeting
		final Integer customerID_scheduleUpdateGeoTargeting = 12;
		final Integer promotionID_scheduleUpdateGeoTargeting = 62;
		final List<String> adEngines_scheduleUpdateGeoTargeting = Arrays.asList(AdEngine.Google.name());
		client.scheduleUpdateGeoTargeting(customerID_scheduleUpdateGeoTargeting, promotionID_scheduleUpdateGeoTargeting, adEngines_scheduleUpdateGeoTargeting);

		// UpdateGeoTargeting
		final Integer promotionID_UpdateGeoTargeting = 62;
		final List<String> adEngines_UpdateGeoTargeting = Arrays.asList(AdEngine.Google.name());
		client.UpdateGeoTargeting(promotionID_UpdateGeoTargeting, adEngines_UpdateGeoTargeting);
		
		// scheduleChangePromotionStartDate
		final Integer customerID_scheduleChangePromotionStartDate = 12;
		final Integer promotionID_scheduleChangePromotionStartDate = 62;
		final java.util.Date newStartDate_scheduleChangePromotionStartDate = new java.util.Date();
		final List<String> adEngines_scheduleChangePromotionStartDate = Arrays.asList(AdEngine.Google.name());
		client.scheduleChangePromotionStartDate(customerID_scheduleChangePromotionStartDate, promotionID_scheduleChangePromotionStartDate, newStartDate_scheduleChangePromotionStartDate, adEngines_scheduleChangePromotionStartDate);

		// ChangePromotionStartDate
		final Integer promotionID_ChangePromotionStartDate = 62;
		final java.util.Date newStartDate_ChangePromotionStartDate = new java.util.Date();
		final List<String> adEngines_ChangePromotionStartDate = Arrays.asList(AdEngine.Google.name());
		client.ChangePromotionStartDate(promotionID_ChangePromotionStartDate, newStartDate_ChangePromotionStartDate, adEngines_ChangePromotionStartDate);

		// scheduleUpdateBudget
		final Integer customerID_scheduleUpdateBudget = 12;
		final Integer promotionID_scheduleUpdateBudget = 62;
		final Double changeInBudget_scheduleUpdateBudget = -16.75;
		final List<String> adEngines_scheduleUpdateBudget = Arrays.asList(AdEngine.Google.name());
		client.scheduleUpdateBudget(customerID_scheduleUpdateBudget, promotionID_scheduleUpdateBudget, changeInBudget_scheduleUpdateBudget, adEngines_scheduleUpdateBudget);

		// UpdateBudget
		final Integer promotionID_UpdateBudget = 62;
		final Double changeInBudget_UpdateBudget = -5.25;
		final List<String> adEngines_UpdateBudget = Arrays.asList(AdEngine.Google.name());
		client.UpdateBudget(promotionID_UpdateBudget, changeInBudget_UpdateBudget, adEngines_UpdateBudget);

		// schedulePausePromotion
		final Integer customerID_schedulePausePromotion = 12;
		final Integer promotionID_schedulePausePromotion = 62;
		final List<String> adEngines_schedulePausePromotion = Arrays.asList(AdEngine.Google.name());
		client.schedulePausePromotion(customerID_schedulePausePromotion, promotionID_schedulePausePromotion, adEngines_schedulePausePromotion);

		// schedulePausePromotion
		final Integer promotionID_PausePromotion = 62;
		final List<String> adEngines_PausePromotion = Arrays.asList(AdEngine.Google.name());
		client.PausePromotion(promotionID_PausePromotion, adEngines_PausePromotion);
	
		// scheduleAddPromotionToAdEngine
		final Integer customerID_scheduleAddPromotionToAdEngine = 12;
		final Integer productGroupID_scheduleAddPromotionToAdEngine = 76;
		final Integer promotionID_scheduleAddPromotionToAdEngine = 62;
		final ArrayList<String> adEngines_scheduleAddPromotionToAdEngine = new ArrayList<String>(Arrays.asList(new String[]{AdEngine.Google.name()}));
		client.scheduleAddPromotionToAdEngine(customerID_scheduleAddPromotionToAdEngine, productGroupID_scheduleAddPromotionToAdEngine, promotionID_scheduleAddPromotionToAdEngine, adEngines_scheduleAddPromotionToAdEngine);
			
		// AddPromotionToAdEngine
		final Integer customerID_AddPromotionToAdEngine = 12;
		final Integer productGroupID_AddPromotionToAdEngine = 76;
		final Integer promotionID_AddPromotionToAdEngine = 62;
		final ArrayList<String> adEngines_AddPromotionToAdEngine = new ArrayList<String>(Arrays.asList(AdEngine.Google.name()));
		client.AddPromotionToAdEngine(customerID_AddPromotionToAdEngine, productGroupID_AddPromotionToAdEngine, promotionID_AddPromotionToAdEngine, adEngines_AddPromotionToAdEngine);

		// scheduleDeleteKeywords
		final Integer customerID_scheduleDeleteKeywords = 12;
		final Integer promotionID_scheduleDeleteKeywords = 62;
		final List<Integer> keywordIds_scheduleDeleteKeywords = Arrays.asList(12095);
		final List<String> adEngines_scheduleDeleteKeywords = Arrays.asList(AdEngine.Google.name());
		client.scheduleDeleteKeywords(customerID_scheduleDeleteKeywords,  promotionID_scheduleDeleteKeywords, keywordIds_scheduleDeleteKeywords, adEngines_scheduleDeleteKeywords);

		// DeleteKeywords
		final Integer promotionID_DeleteKeywords = 62;
		final List<Integer> keywordIds_DeleteKeywords = Arrays.asList(37);
		final List<String> adEngines_DeleteKeywords = Arrays.asList(AdEngine.Google.name());
		client.DeleteKeywords(promotionID_DeleteKeywords, keywordIds_DeleteKeywords, adEngines_DeleteKeywords);

		// scheduleRefreshSiteLinks
		final Integer customerID_scheduleRefreshSiteLinks = 12;
		final Integer promotionID_scheduleRefreshSiteLinks = 62;
		final List<String> adEngines_scheduleRefreshSiteLinks = Arrays.asList(AdEngine.Google.name());
		client.scheduleRefreshSiteLinks(customerID_scheduleRefreshSiteLinks, promotionID_scheduleRefreshSiteLinks, adEngines_scheduleRefreshSiteLinks);
		
		// RefreshSiteLinks
		final Integer promotionID_RefreshSiteLinksForAd = 62;
		final List<String> adEngines_RefreshSiteLinksForAd = Arrays.asList(AdEngine.Google.name());
		client.RefreshSiteLinks(promotionID_RefreshSiteLinksForAd, adEngines_RefreshSiteLinksForAd);
	
		// schedulePauseProductGroups
		final Integer customerID_schedulePauseProductGroups = 12;
		final List<Integer> productGroupIds_schedulePauseProductGroups = Arrays.asList(76);
		final List<String> adEngines_schedulePauseProductGroups = Arrays.asList(AdEngine.Google.name());
		client.schedulePauseProductGroups(customerID_schedulePauseProductGroups, productGroupIds_schedulePauseProductGroups, adEngines_schedulePauseProductGroups);
				
		// PauseProductGroups
		final List<Integer> productGroupIds_PauseProductGroups = Arrays.asList(76);
		final List<String> adEngines_PauseProductGroups = Arrays.asList(AdEngine.Google.name());
		client.PauseProductGroups(productGroupIds_PauseProductGroups, adEngines_PauseProductGroups);		

		// scheduleUnpausePromotion
		final Integer customerID_scheduleUnpausePromotion = 12;
		final Integer promotionID_scheduleUnpausePromotion = 62;
		final List<String> adEngines_scheduleUnpausePromotion = Arrays.asList(AdEngine.Google.name());
		client.scheduleUnpausePromotion(customerID_scheduleUnpausePromotion, promotionID_scheduleUnpausePromotion, adEngines_scheduleUnpausePromotion);

		// UnpausePromotion
		final Integer promotionID_UnpausePromotion = 62;
		final List<String> adEngines_UnpausePromotion = Arrays.asList(AdEngine.Google.name());
		client.UnpausePromotion(promotionID_UnpausePromotion, adEngines_UnpausePromotion);
		
		// scheduleUnpausePromotion
		final Integer customerID_scheduleAddKeywords = 12;
		final Integer promotionID_scheduleAddKeywords = 62;
		final List<Integer> keywordIds_scheduleAddKeywords = Arrays.asList(12241, 12242);
		final List<String> adEngines_scheduleAddKeywords = Arrays.asList(AdEngine.Google.name());
		client.scheduleAddKeywords(customerID_scheduleAddKeywords, promotionID_scheduleAddKeywords, keywordIds_scheduleAddKeywords, adEngines_scheduleAddKeywords);

		// UnpausePromotion
		final Integer promotionID_AddKeywords = 62;
		final List<String> adEngines_AddKeywords = Arrays.asList(AdEngine.Google.name());
		final List<Integer> keywordIds_AddKeywords = Arrays.asList(12241, 12242);
		client.AddKeywords(promotionID_AddKeywords, keywordIds_AddKeywords, adEngines_AddKeywords);

		// scheduleAddNegativeKeywords
		final Integer customerID_scheduleAddNegativeKeywords = 12;
		final Integer promotionID_scheduleAddNegativeKeywords = 62;
		final KeywordIdRemoveOppositePair pair1_scheduleAddNegativeKeywords = new KeywordIdRemoveOppositePair(12241, false);
		final KeywordIdRemoveOppositePair pair2_scheduleAddNegativeKeywords = new KeywordIdRemoveOppositePair(12242, false);
		final List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs_scheduleAddNegativeKeywords = new ArrayList<KeywordIdRemoveOppositePair>();
		keywordIdRemoveOppositePairs_scheduleAddNegativeKeywords.add(pair1_scheduleAddNegativeKeywords);
		keywordIdRemoveOppositePairs_scheduleAddNegativeKeywords.add(pair2_scheduleAddNegativeKeywords);
		final List<String> adEngines_scheduleAddNegativeKeywords = Arrays.asList(AdEngine.Google.name());
		client.scheduleAddNegativeKeywords(customerID_scheduleAddNegativeKeywords, promotionID_scheduleAddNegativeKeywords, keywordIdRemoveOppositePairs_scheduleAddNegativeKeywords, adEngines_scheduleAddNegativeKeywords);

		// AddNegativeKeywords
		final Integer promotionID_AddNegativeKeywords = 62;
		final KeywordIdRemoveOppositePair pair1_AddNegativeKeywords = new KeywordIdRemoveOppositePair(12241, true);
		final KeywordIdRemoveOppositePair pair2_scheduleAddNegativeKeywords = new KeywordIdRemoveOppositePair(12242, false);
		final List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs_AddNegativeKeywords = new ArrayList<KeywordIdRemoveOppositePair>();
		keywordIdRemoveOppositePairs_AddNegativeKeywords.add(pair1_AddNegativeKeywords);
		keywordIdRemoveOppositePairs_AddNegativeKeywords.add(pair2_scheduleAddNegativeKeywords);
		final List<String> adEngines_AddNegativeKeywords = Arrays.asList(AdEngine.Google.name());
		client.AddNegativeKeywords(promotionID_AddNegativeKeywords, keywordIdRemoveOppositePairs_AddNegativeKeywords, adEngines_AddNegativeKeywords);

		// ExecuteBidProcess
		final Integer promotionID_ExecuteBidProcess = 62;
		final ArrayList<String> adEngines_ExecuteBidProcess = new ArrayList<String>(Arrays.asList(AdEngine.Google.name()));
		client.ExecuteBidProcess(promotionID_ExecuteBidProcess, adEngines_ExecuteBidProcess);
		
		// scheduleUnpausePromotion
		final Integer customerID_scheduleDeleteNegativeKeywords = 12;
		final Integer promotionID_scheduleDeleteNegativeKeywords = 62;
		final List<Integer> keywordIds_scheduleDeleteNegativeKeywords = Arrays.asList(12241, 12242);
		final List<String> adEngines_scheduleDeleteNegativeKeywords = Arrays.asList(AdEngine.Google.name());
		client.scheduleDeleteNegativeKeywords(customerID_scheduleDeleteNegativeKeywords, promotionID_scheduleDeleteNegativeKeywords, keywordIds_scheduleDeleteNegativeKeywords, adEngines_scheduleDeleteNegativeKeywords);

		// UnpausePromotion
		final Integer promotionID_DeleteNegativeKeywords = 62;
		final List<String> adEngines_DeleteNegativeKeywords = Arrays.asList(AdEngine.Google.name());
		final List<Integer> keywordIds_DeleteNegativeKeywords = Arrays.asList(12241, 12242);
		client.DeleteNegativeKeywords(promotionID_DeleteNegativeKeywords, keywordIds_DeleteNegativeKeywords, adEngines_DeleteNegativeKeywords);

		// scheduleAddPromotionToAdEngine - MSN
		final Integer customerID_scheduleAddPromotionToAdEngineMSN = 12;
		final Integer productGroupID_scheduleAddPromotionToAdEngineMSN = 76;
		final Integer promotionID_scheduleAddPromotionToAdEngineMSN = 62;
		final ArrayList<String> adEngines_scheduleAddPromotionToAdEngineMSN = new ArrayList<String>(Arrays.asList(new String[]{AdEngine.MSN.name()}));
		client.scheduleAddPromotionToAdEngine(customerID_scheduleAddPromotionToAdEngineMSN, productGroupID_scheduleAddPromotionToAdEngineMSN, promotionID_scheduleAddPromotionToAdEngineMSN, adEngines_scheduleAddPromotionToAdEngineMSN);
*/
		// AddPromotionToAdEngine - MSN
		final Integer customerID_AddPromotionToAdEngineMSN = 12;
		final Integer productGroupID_AddPromotionToAdEngineMSN = 76;
		final Integer promotionID_AddPromotionToAdEngineMSN = 62;
		final ArrayList<String> adEngines_AddPromotionToAdEngineMSN = new ArrayList<String>(Arrays.asList(AdEngine.MSN.name()));
		client.AddPromotionToAdEngine(customerID_AddPromotionToAdEngineMSN, productGroupID_AddPromotionToAdEngineMSN, promotionID_AddPromotionToAdEngineMSN, adEngines_AddPromotionToAdEngineMSN);
/**/		
	}
	
	@Override
	public Boolean scheduleDeleteNegativeKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<String> adEngines)
	{
		final String methodName = "scheduleDeleteNegativeKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsStr = gson.toJson(keywordIds, List.class);		
		jsonHash.put("keywordIds", keywordIdsStr);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}

	@Override
	public Boolean DeleteNegativeKeywords(Integer promotionID, List<Integer> keywordIds, List<String> adEngines) throws Exception
	{
		final String methodName = "DeleteNegativeKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsString = gson.toJson(keywordIds, List.class);
		jsonHash.put("keywordIds", keywordIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleAddNegativeKeywords(Integer customerID, Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines)
	{
		final String methodName = "scheduleAddNegativeKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdRemoveOppositePairsStr = gson.toJson(keywordIdRemoveOppositePairs, List.class);		
		jsonHash.put("keywordIdRemoveOppositePairs", keywordIdRemoveOppositePairsStr);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}

	@Override
	public Boolean AddNegativeKeywords(Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines)
			throws Exception
	{
		final String methodName = "AddNegativeKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdRemoveOppositePairsString = gson.toJson(keywordIdRemoveOppositePairs, List.class);
		jsonHash.put("keywordIdRemoveOppositePairs", keywordIdRemoveOppositePairsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleAddKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<String> adEngines)
	{
		final String methodName = "scheduleAddKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsStr = gson.toJson(keywordIds, List.class);		
		jsonHash.put("keywordIds", keywordIdsStr);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}

	@Override
	public Boolean AddKeywords(Integer promotionID, List<Integer> keywordIds, List<String> adEngines) throws Exception
	{
		final String methodName = "AddKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsString = gson.toJson(keywordIds, List.class);
		jsonHash.put("keywordIds", keywordIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleAddAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) 
	{
		final String methodName = "scheduleAddAds";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsStr = gson.toJson(promotionAdIds, List.class);		
		jsonHash.put("promotionAdIds", promotionAdIdsStr);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean AddAds(Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) throws Exception
	{
		final String methodName = "AddAds";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);
		jsonHash.put("promotionAdIds", promotionAdIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleDeleteAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines)
	{
		final String methodName = "scheduleDeleteAds";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));		
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);
		jsonHash.put("promotionAdIds", promotionAdIdsString);			
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}

	@Override
	public Boolean DeleteAds(Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) throws Exception
	{
		final String methodName = "DeleteAds";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));		
		final String promotionAdIdsStr = gson.toJson(promotionAdIds, List.class);		
		jsonHash.put("promotionAdIds", promotionAdIdsStr);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleUpdateAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines)  
	{
		final String methodName = "scheduleUpdateAds";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);
		jsonHash.put("promotionAdIds", promotionAdIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean UpdateAds(Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) throws Exception 
	{
		final String methodName = "UpdateAds";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);
		jsonHash.put("promotionAdIds", promotionAdIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleUpdateGeoTargeting(Integer customerID, Integer PromotionID, List<String> adEngines)  
	{
		final String methodName = "scheduleUpdateGeoTargeting";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(PromotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean UpdateGeoTargeting(Integer PromotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "UpdateGeoTargeting";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(PromotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleChangePromotionStartDate(Integer customerID, Integer promotionID, java.util.Date newStartDate, List<String> adEngines)  
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
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception 
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
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleUpdateBudget(Integer customerID, Integer promotionID, Double changeInBudget, List<String> adEngines)  
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
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception 
	{
		final String methodName = "UpdateBudget";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();	
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("changeInBudget", Double.toString(changeInBudget));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
		
	@Override
	public Boolean schedulePausePromotion(Integer customerID, Integer promotionID, List<String> adEngines)  
	{
		final String methodName = "schedulePausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean PausePromotion(Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "PausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleUnpausePromotion(Integer customerID, Integer promotionID, List<String> adEngines)  
	{
		final String methodName = "scheduleUnpausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean UnpausePromotion(Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "UnpausePromotion";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleDeleteKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds , List<String> adEngines)  
	{
		final String methodName = "scheduleDeleteKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsStr = gson.toJson(keywordIds, List.class);
		jsonHash.put("keywordIds", keywordIdsStr);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}

	@Override
	public Boolean DeleteKeywords(Integer promotionID, List<Integer> keywordIds, List<String> adEngines) throws Exception 
	{
		final String methodName = "DeleteKeywords";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsString = gson.toJson(keywordIds, List.class);
		jsonHash.put("keywordIds", keywordIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
		
	@Override
	public Boolean scheduleRefreshSiteLinks(Integer customerID, Integer promotionID, List<String> adEngines)  
	{
		final String methodName = "scheduleRefreshSiteLinks";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean RefreshSiteLinks(Integer promotionID, List<String> adEngines) throws Exception 
	{
		final String methodName = "RefreshSiteLinks";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean schedulePauseProductGroups(Integer customerID, List<Integer> productGroupIds, List<String> adEngines)  
	{
		final String methodName = "schedulePauseProductGroups";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("productGroupIds", gson.toJson(productGroupIds, List.class));		
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean PauseProductGroups(List<Integer> productGroupIds, List<String> adEngines) throws Exception
	{
		final String methodName = "PauseProductGroups";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		final String productGroupIdsStr = gson.toJson(productGroupIds, List.class);		
		jsonHash.put("productGroupIds", productGroupIdsStr);		
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean scheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, List<String> adEngineList) 
	{
		final String methodName = "scheduleAddPromotionToAdEngine";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		final String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngines",adEngineListStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");		
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, List<String> adEngineList) throws Exception
	{
		final String methodName = "AddPromotionToAdEngine";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		final String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngines",adEngineListStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");		
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}
	
	
	public Boolean scheduleExecuteBidProcess(Integer promotionID, ArrayList<String> adEngineList)  
	{
		final String methodName = "scheduleAddPromotionToAdEngine";
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngines",adEngineListStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");		
		try
		{
			final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
			final Boolean result = gson.fromJson(returnData, Boolean.class);
			return result;
		}
		catch (Exception e)
		{
			logger.error("Problem performing " + methodName, e);
			return false;
		}
	}

	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		final String methodName = "ExecuteBidProcess";
		HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		String adEngineListStr = gson.toJson(adEngineList, ArrayList.class);
		jsonHash.put("adEngines",adEngineListStr);
		String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("JSON [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, methodName, json, timeoutMS);
		final Boolean processedSuccessfully = gson.fromJson(returnData, Boolean.class);
		if (!processedSuccessfully)
		{
			logger.error("Problem performing [" + methodName + "]");
		}
		return processedSuccessfully;
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

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	
}
