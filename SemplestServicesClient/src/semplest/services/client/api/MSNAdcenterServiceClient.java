package semplest.services.client.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.joda.time.DateTime;

import semplest.other.KeywordEstimate;
import semplest.other.Maybe;
import semplest.other.Money;
import semplest.other.MsnCloudKeywordProxy;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.msn.MsnAccountObject;
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;

import com.google.gson.Gson;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class MSNAdcenterServiceClient extends ServiceRun implements MsnAdcenterServiceInterface
{

	private static String SERVICEOFFERED = "semplest.service.msn.adcenter.MSNAdcenterService";
	//private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";
	private static String BASEURLTEST = "http://localhost:9898/semplest";
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClient.class);
	
	private final String baseurl;
	
	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();
			MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(BASEURLTEST);
								
			/*	
			//createAccount
			SemplestString in = new SemplestString();
			in.setSemplestString("acc_nan");
			MsnManagementIds ret = test.createAccount(in);			
			
			//getAccountById
			MsnAccountObject ret = test.getAccountById(1595249L);
				
			//createCampaign
			CampaignStatus cpst = null;
			Long ret = test.createCampaign(1595249L, "msn_test_nan", 0.01, 5.00, cpst.Paused);
			
			//getCampaignById
			Campaign ret = test.getCampaignById(1595249L, 130129414L);
			
			//getCampaignsByAccountId
			Campaign[] ret = test.getCampaignsByAccountId(1595249L);
			
			//pauseCampaignById
			test.pauseCampaignById(1595249L, 130129414L);
			
			//pauseCampaignsByAccountId
			test.pauseCampaignsByAccountId(1595249L);
			
			//resumeCampaignById
			test.resumeCampaignById(new Long(1595249), new Long(130129414));  //resume
			Campaign ret1 = test.getCampaignById(new Long(1595249), new Long(130129414));  //check it
			test.pauseCampaignById(new Long(1595249), new Long(130129414));  //stop it (don't wanna waste money by mistake)
			Campaign ret2 = test.getCampaignById(new Long(1595249), new Long(130129414));  //check it
			
			//deleteCampaignById
			  //create a new campaign and then delete it
			CampaignStatus cpst = null;
			Long ret1 = test.createCampaign(new Long(1595249), "msn_test_nan_3", 0.01, 5.00, cpst.Paused);  //create a campaign
			Campaign[] ret2 = test.getCampaignsByAccountId(new Long(1595249));  //list all campaigns
			test.deleteCampaignById(new Long(1595249), ret2[(ret2.length-1)].getId());  //delete the last campaign
			Campaign[] ret3 = test.getCampaignsByAccountId(new Long(1595249));  //list all campaigns
			
			//updateCampaignBudget
			Campaign ret = test.getCampaignById(new Long(1595249), new Long(130129414));  //original value
			test.updateCampaignBudget(new Long(1595249), new Long(130129414), 1.00, 10.00);
			Campaign ret2 = test.getCampaignById(new Long(1595249), new Long(130129414));  //updated value
			
			//setCampaignStateTargets
			//String[] list = {"US-NY", "US-MA"};
			//List<String> states = Arrays.asList(list);
			//test.setCampaignStateTargets(new Long(1595249), new Long(13061731), new Long(130129414), states);
			
			//getCampaignTargets
			Target ret = test.getCampaignTargets(1595249L, 13061731L, 130129414L);
			StateTargetBid[] bids = ret.getLocation().getStateTarget().getBids();
			for(StateTargetBid b:bids){
				logger.debug("state = " + b.getState());
			}
			
			//deleteCampaignTargets
			Target ret = test.getCampaignTargets(1595249L, 13061731L, 130129426L);  //check before change
			if(ret!=null) logger.debug("Target is not null");
			test.deleteCampaignTargets(1595249L, 13061731L, 130129426L);
			ret = test.getCampaignTargets(1595249L, 13061731L, 130129426L);  //check after change
			if(ret==null) logger.debug("Target is null");
			
			//createAdGroup
			long ret = test.createAdGroup(1595249L, 130129414L);
			
			//getAdGroupsByCampaignId
			AdGroup[] ret = test.getAdGroupsByCampaignId(1595249L, 130129414L);
			
			//getAdGroupById
			AdGroup ret = test.getAdGroupById(1595249L, 130129414L, 754813047L);
			*/
			//deleteAdGroupById
			long ret1 = test.createAdGroup(1595249L, 130129414L);  //add a group
			AdGroup[] ret2 = test.getAdGroupsByCampaignId(1595249L, 130129414L);  //check the list
			test.deleteAdGroupById(1595249L, 130129414L, ret1);  //delete the group
			ret2 = test.getAdGroupsByCampaignId(1595249L, 130129414L);  //check the list
			
			
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public MSNAdcenterServiceClient(String baseurl)
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
	/*
	private String runMethod(String methodName, String jsonStr)
	{
		Client client = Client.create();
		MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
		queryParams.add("jsonStr", jsonStr);
		queryParams.add("service", SERVICEOFFERED);
		queryParams.add("method", methodName);
		queryParams.add("timeout", "5000");
		WebResource webResource = client.resource(baseURL);
		return   webResource.queryParams(queryParams).get(String.class);
	}
	*/
	@Override
	public boolean isProduction()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTimeout(int millis)
	{
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public MsnAccountObject getAccountById(Long accountId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAccountById", json, null);
		MsnAccountObject account = gson.fromJson(returnData, MsnAccountObject.class);
		logger.debug("getAccountById: Name = " + account.getName()
				+ "; ParentCustomerId = " + account.getParentCustomerId()
				+ "; PrimaryUserId = " + account.getPrimaryUserId());
		return account;
	}

	@Override
	public Long createCampaign(Long accountId, String campaignName, double dailyBudget, double monthlyBudget, CampaignStatus CampaignStatus)
			throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignName", campaignName);
		jsonHash.put("dailyBudget", Double.toString(dailyBudget));
		jsonHash.put("monthlyBudget", Double.toString(monthlyBudget));
		jsonHash.put("CampaignStatus", CampaignStatus.toString());
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createCampaign", json, null);
		Long campaignId = gson.fromJson(returnData, Long.class);		
		logger.debug("createCampaign: campaignId = " + campaignId.toString());		
		return campaignId;
	}

	@Override
	public Campaign getCampaignById(Long accountId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getCampaignById", json, null);
		Campaign campaign = gson.fromJson(returnData, Campaign.class);		
		logger.debug("getCampaignById: " + ": Name = " + campaign.getName()
				+ "; DailyBudget = " + campaign.getDailyBudget().toString()
				+ "; MonthlyBudget = " + campaign.getMonthlyBudget().toString()
				+ "; CampaignStatus = " + campaign.getStatus().toString());		
		return campaign;
	}

	@Override
	public Campaign[] getCampaignsByAccountId(Long accountId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getCampaignsByAccountId", json, null);
		Campaign[] campaigns = gson.fromJson(returnData, Campaign[].class);	
		logger.debug("getCampaignsByAccountId: numOfCampaigns = " + campaigns.length);
		for (int i = 0; i < campaigns.length; i++)
		{
			logger.debug(i + ": Name = " + campaigns[i].getName()
					+ "; DailyBudget = " + campaigns[i].getDailyBudget().toString()
					+ "; MonthlyBudget = " + campaigns[i].getMonthlyBudget().toString()
					+ "; CampaignStatus = " + campaigns[i].getStatus().toString());		
		}		
		return campaigns;
	}

	@Override
	public void pauseCampaignById(Long accountId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "pauseCampaignById", json, null);
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("pauseCampaignById: (if successful returns 0) " + ret);					
	}

	@Override
	public void pauseCampaignsByAccountId(Long accountId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "pauseCampaignsByAccountId", json, null);
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("pauseCampaignsByAccountId: (if successful returns 0) " + ret);			
	}

	@Override
	public void resumeCampaignById(Long accountId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "resumeCampaignById", json, null);
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("resumeCampaignById: (if successful returns 0) " + ret);
	}

	@Override
	public void deleteCampaignById(Long accountId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteCampaignById", json, null);
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("deleteCampaignById: (if successful returns 0) " + ret);
	}

	@Override
	public void updateCampaignBudget(Long accountId, Long campaignId, double dailyBudget, double monthlyBudget) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		jsonHash.put("dailyBudget", Double.toString(dailyBudget));
		jsonHash.put("monthlyBudget", Double.toString(monthlyBudget));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "updateCampaignBudget", json, null);
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("updateCampaignBudget: (if successful returns 0) " + ret);
	}

	@Override
	public void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String stateslist = "";
		for (int i = 0; i < states.size()-1; i++){
			stateslist += states.get(i) + ",";
		}
		stateslist += states.get(states.size()-1);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		jsonHash.put("states", stateslist);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "setCampaignStateTargets", json, null);
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("setCampaignStateTargets: (if successful returns 0) " + ret);
	}

	@Override
	public void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteCampaignTargets", json, null);		
		int ret = gson.fromJson(returnData, int.class);		
		logger.debug("deleteCampaignTargets: (if successful returns 0) " + ret);
		
	}

	@Override
	public Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getCampaignTargets", json, null);		
		Target ret = gson.fromJson(returnData, Target.class);		
		logger.debug("getCampaignTargets: ok");
		return ret;
	}

	@Override
	public long createAdGroup(Long accountId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createAdGroup", json, null);
		long ret = gson.fromJson(returnData, long.class);		
		logger.debug("createAdGroup: adGroupId = " + ret);
		return ret;
	}

	@Override
	public AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAdGroupsByCampaignId", json, null);
		AdGroup[] adgroups = gson.fromJson(returnData, AdGroup[].class);
		for (int i = 0; i < adgroups.length; i++)
		{
			logger.debug("getAdGroupsByCampaignId: Name = " + adgroups[i].getName()
					+ "; adGroupId = " + adgroups[i].getId());
		}
		return adgroups;
	}

	@Override
	public AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAdGroupById", json, null);
		AdGroup ret = gson.fromJson(returnData, AdGroup.class);
		logger.debug("getAdGroupById: Id = " + ret.getId()
				+ "; Name = " + ret.getName());
		return ret;
	}

	@Override
	public void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteAdGroupById", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("deleteAdGroupById: (if successful returns 0) " + ret);
	}

	@Override
	public void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws Exception
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ad getAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public long createKeyword(Long accountId, Long adGroupId, String text, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid,
			Bid phraseMatchBid) throws Exception
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Maybe<Keyword> getKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid,
			Bid phraseMatchBid) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateKeywordBidsByIds(Long accountId, Long adGroupId, long[] keywordId, Bid[] broadMatchBid, Bid[] contentMatchBid,
			Bid[] exactMatchBid, Bid[] phraseMatchBid) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeywordEstimatedPosition[] getKeywordEstimateByBids(String[] keywords, Money bid) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String[]> getReportData(String reportId, Long accountId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestCampaignReport(Long accountId, int campaignId, int days, ReportAggregation aggregation)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MsnManagementIds createAccount(SemplestString name) throws Exception
	{
		//Only name[0] is a valid parameter for the actual method!
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("name", name.getSemplestString());
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createAccount", json, null);
		MsnManagementIds mngId = gson.fromJson(returnData, MsnManagementIds.class);
		logger.debug("createAccount: accountId = " + mngId.getAccountId() 
				+ "; customerId = " + mngId.getCustomerId()
				+ "; userId = " + mngId.getUserId());

		return mngId;
	}

	@Override
	public long[] createKeywords(Long accountId, Long adGroupId, MsnCloudKeywordProxy... keywords) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeywordEstimate getKeywordEstimateByBid(Long accountId, String keyword, double broadMatchBid, double exactMatchBid, double phraseMatchBid)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeywordEstimate[] getKeywordEstimateByBids(Long accountId, String[] keywords, double[] broadMatchBids, double[] exactMatchBids,
			double[] phraseMatchBids) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

}
