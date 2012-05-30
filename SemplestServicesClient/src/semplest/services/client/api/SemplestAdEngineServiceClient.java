package semplest.services.client.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.TaskOutput;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;

import com.google.gson.Gson;

public class SemplestAdEngineServiceClient extends ServiceRun implements SemplestAdengineServiceInterface, SchedulerTaskRunnerInterface
{
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
		//final String accountId = "54101"; 
		//final Long campaignId = 647605L;
		final Integer PromotionID = 62;
		client.UpdateGeoTargeting(PromotionID);
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
	public Boolean PausePromotion(Integer customerID, Integer promotionID, String adEngine) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean PauseProductGroup(Integer customerID, Integer productGroupID, String adEngine) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DeleteAd(Integer customerID, Integer promotionID, Integer promotionAdID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DeleteSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID, Integer SiteLinkID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateGeoTargeting(Integer PromotionID) throws Exception
	{
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		//jsonHash.put("accountId", accountId);
		//jsonHash.put("campaignId", Long.toString(campaignId));
		jsonHash.put("PromotionID", Integer.toString(PromotionID));
		final String json = protocolJson.createJSONHashmap(jsonHash);
		String returnData = runMethod(baseurl, SERVICEOFFERED, "UpdateGeoTargeting", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}

	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		
		jsonHash.put("promotionID",Integer.toString(PromotionID));
		String adEngineListStr = gson.toJson(adEngineList,ArrayList.class);
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
	public Boolean UpdateAd(Integer customerID, Integer promotionID, Integer promotionAdID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID, Integer SiteLinkID, String siteLink)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean UpdateBudget(Integer promotionID, Double changeInBudget) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean ChangePromotionStartDate(Integer promotionID, Date newStartDate) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean DeleteKeyword(Integer promotionID, String Keyword) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean AddAd(Integer customerID, Integer promotionID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean AddSiteLinkForAd(Integer customerID, Integer promotionID, Integer promotionAdID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
