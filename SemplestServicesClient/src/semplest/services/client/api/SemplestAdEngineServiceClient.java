package semplest.services.client.api;

import java.util.ArrayList;
import java.util.Date;
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
			*/	
		
		//
		// UpdateAd
		//		
		final Integer promotionID_UpdateAd = 62;
		final Integer promotionAdID_UpdateAd = 218;
		final List<String> adEngines_UpdateAd = new ArrayList<String>();
		adEngines_UpdateAd.add(AdEngine.Google.name());
		//adEngines_UpdateAd.add(AdEngine.MSN.name());
		client.UpdateAd(promotionID_UpdateAd, promotionAdID_UpdateAd, adEngines_UpdateAd);
		
		/*
		//
		// DeleteAd
		//
		final Integer promotionID_DeleteAd = 62;
		final Integer promotionAdID_DeleteAd = 218;
		final List<String> adEngines_DeleteAd = new ArrayList<String>();
		adEngines_DeleteAd.add(AdEngine.Google.name());
		client.DeleteAd(promotionID_DeleteAd, promotionAdID_DeleteAd, adEngines_DeleteAd);
		
		*/	
		
		// 9824192 old, 9824193 new (30 in semplest, 10 in google)
		// added: 9824192
		
		
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
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("productGroupID", Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		String adEngineListStr = gson.toJson(adEngineList,ArrayList.class);
		jsonHash.put("adEngineList",adEngineListStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "AddPromotionToAdEngine", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean PausePromotion(Integer customerID, Integer promotionID, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean PauseProductGroup(Integer customerID, Integer productGroupID, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
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
		String returnData = runMethod(baseurl, SERVICEOFFERED, "DeleteAd", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean DeleteSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID, Integer SiteLinkID, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateGeoTargeting(Integer PromotionID, List<String> adEngines) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("PromotionID", Integer.toString(PromotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
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
	public Boolean UpdateSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID, Integer SiteLinkID, String siteLink, List<String> adEngines)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ChangePromotionStartDate(Integer promotionID, Date newStartDate, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DeleteKeyword(Integer promotionID, String Keyword, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
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
	public Boolean AddSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
