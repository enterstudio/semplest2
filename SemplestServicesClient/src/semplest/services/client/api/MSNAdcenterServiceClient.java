package semplest.services.client.api;

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
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;

import com.google.gson.Gson;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.Target;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class MSNAdcenterServiceClient extends ServiceRun implements MsnAdcenterServiceInterface
{

	private static String SERVICEOFFERED = "semplest.service.msn.adcenter.MSNAdcenterService";
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClient.class);
	
	private final String baseurl;
	
	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();
			MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(BASEURLTEST);
			AdGroup[] res = test.getAdGroupsByCampaignId(800609L, 50346956L);
			System.out.println(res[0].getName());
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
	public Account getAccountById(Long accountId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long createCampaign(Long accountId, String campaignName, double dailyBudget, double monthlyBudget, CampaignStatus CampaignStatus)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Campaign getCampaignById(Long accountId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Campaign[] getCampaignsByAccountId(Long accountId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void pauseCampaignById(Long accountId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pauseCampaignsByAccountId(Long accountId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resumeCampaignById(Long accountId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCampaignById(Long accountId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCampaignBudget(Long accountId, Long campaignId, double dailyBudget, double monthlyBudget) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createAdGroup(Long accountId, Long campaignId) throws Exception
	{
		// TODO Auto-generated method stub
		return 0;
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
			logger.debug("Name = " + adgroups[i].getName());
		}
		return adgroups;
	}

	@Override
	public AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception
	{
			return null;	
	}

	@Override
	public void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		
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
	public MsnManagementIds createAccount(String[] name) throws Exception
	{
		//Only name[0] is a valid parameter for the actual method!
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("name", name[0]);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createAccount", json, null);
		MsnManagementIds mngId = gson.fromJson(returnData, MsnManagementIds.class);
		logger.debug("accountId = " + mngId.getAccountId() 
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
