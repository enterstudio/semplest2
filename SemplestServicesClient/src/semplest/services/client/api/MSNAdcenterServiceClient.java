package semplest.services.client.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedPositionAndTraffic;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.joda.time.DateTime;

import semplest.other.KeywordEstimate;
import semplest.other.Maybe;
import semplest.other.Money;
import semplest.other.MsnCloudKeywordProxy;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.msn.*;
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;

import com.google.gson.Gson;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class MSNAdcenterServiceClient extends ServiceRun implements MsnAdcenterServiceInterface, SchedulerTaskRunnerInterface
{

	private static String SERVICEOFFERED = "semplest.service.msn.adcenter.MSNAdcenterService";
	//private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";
	private static String BASEURLTEST = "http://localhost:9898/semplest";
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClient.class);
	private static String separator = "#";
	
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
			Target ret = test.getCampaignTargets(1595249L, 13061731L, 130129426L);  //check before change
			if(ret != null){
				//delete target if there's already one associated to the entity
				test.deleteCampaignTargets(1595249L, 13061731L, 130129426L);
			}
			String[] list = {"US-NY", "US-MA", "US-CA", "US-FL"};
			List<String> states = Arrays.asList(list);
			test.setCampaignStateTargets(1595249L, 13061731L, 130129426L, states);
			ret = test.getCampaignTargets(1595249L, 13061731L, 130129426L);  //check after change
			StateTargetBid[] bids = ret.getLocation().getStateTarget().getBids();
			for(StateTargetBid b:bids){
				logger.info("state = " + b.getState());
			}
			
			//getCampaignTargets
			Target ret = test.getCampaignTargets(1595249L, 13061731L, 130129414L);
			StateTargetBid[] bids = ret.getLocation().getStateTarget().getBids();
			for(StateTargetBid b:bids){
				logger.info("state = " + b.getState());
			}
			
			//deleteCampaignTargets
			Target ret = test.getCampaignTargets(1595249L, 13061731L, 130129426L);  //check before change
			if(ret!=null) logger.info("Target is not null");
			test.deleteCampaignTargets(1595249L, 13061731L, 130129426L);
			ret = test.getCampaignTargets(1595249L, 13061731L, 130129426L);  //check after change
			if(ret==null) logger.info("Target is null");
			
			//createAdGroup
			long ret = test.createAdGroup(1595249L, 130129414L);
			
			//getAdGroupsByCampaignId
			AdGroup[] ret = test.getAdGroupsByCampaignId(1595249L, 130129414L);
			
			//getAdGroupById
			AdGroup ret = test.getAdGroupById(1595249L, 130129414L, 754813047L);
			
			//deleteAdGroupById
			long ret1 = test.createAdGroup(1595249L, 130129414L);  //add a group
			AdGroup[] ret2 = test.getAdGroupsByCampaignId(1595249L, 130129414L);  //check the list
			test.deleteAdGroupById(1595249L, 130129414L, ret1);  //delete the group
			ret2 = test.getAdGroupsByCampaignId(1595249L, 130129414L);  //check the list
			
			//setAdGroupStateTargets, deleteAdGroupTargets and getAdGroupTargets
			Target ret = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);  //check before change
			if(ret != null){
				//delete target if there's already one associated to the entity
				test.deleteAdGroupTargets(1595249L, 13061731L, 754813047L);
			}
			String[] list = {"US-NY", "US-MA", "US-CA", "US-FL"};
			List<String> states = Arrays.asList(list);
			test.setAdGroupStateTargets(1595249L, 13061731L, 754813047L, states);			
			ret = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);  //check after change
			StateTargetBid[] bids = ret.getLocation().getStateTarget().getBids();
			for(StateTargetBid b:bids){
				logger.info("state = " + b.getState());
			}
			//===Use this test to get format of City string and MetroArea string. (need to set things up on the website before run this)
			Target ret2 = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);
			StateTargetBid[] bids = ret2.getLocation().getStateTarget().getBids();
			for(StateTargetBid b:bids){
				logger.info("state = " + b.getState());
			}
			CityTargetBid[] bids1 = ret2.getLocation().getCityTarget().getBids();
			for(CityTargetBid b:bids1){
				logger.info("city = " + b.getCity());
			}
			MetroAreaTargetBid[] bids2 = ret2.getLocation().getMetroAreaTarget().getBids();
			for(MetroAreaTargetBid b:bids2){
				logger.info("MetroArea = " + b.getMetroArea());
			}
			
			//setAdGroupCityTargets
			Target ret = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);  //check before change
			if(ret != null){
				//delete target if there's already one associated to the entity
				test.deleteAdGroupTargets(1595249L, 13061731L, 754813047L);
			} 
			String[] list = {"Brookline, Boston MA US", "Newton, Boston MA US", "Wellesley, Boston MA US"};
			List<String> states = Arrays.asList(list);
			test.setAdGroupCityTargets(1595249L, 13061731L, 754813047L, states);			
			Target ret2 = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);  //check after change
			CityTargetBid[] bids = ret2.getLocation().getCityTarget().getBids();
			for(CityTargetBid b:bids){
				logger.info("city = " + b.getCity());
			}			
			
			//setAdGroupMetroAreaTargets
			Target ret = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);  //check before change
			if(ret != null){
				//delete target if there's already one associated to the entity
				test.deleteAdGroupTargets(1595249L, 13061731L, 754813047L);
			} 
			String[] list = {"Brooklyn, NY US", "New York, NY US"};
			List<String> metros = Arrays.asList(list);
			test.setAdGroupMetroAreaTargets(1595249L, 13061731L, 754813047L, metros);			
			Target ret2 = test.getAdGroupTargets(1595249L, 13061731L, 754813047L);  //check after change
			MetroAreaTargetBid[] bids = ret2.getLocation().getMetroAreaTarget().getBids();
			for(MetroAreaTargetBid b:bids){
				logger.info("city = " + b.getMetroArea());
			}	
			
			//createAd
			long ret = test.createAd(1595249L, 754813047L, "nan ad test 1", "semplest test num 1", "https://www.semplest.com/", "https://www.semplest.com/");
			
			//getAdById
			Ad ret = test.getAdById(1595249L, 754813047L, 937776925L);
			logger.info("AdId = " + ret.getId()
					+ "; status = " + ret.getStatus().getValue()
					+ "; EditorialStatus = " + ret.getEditorialStatus().getValue()
					+ "; Type = " + ret.getType().getValue());
			MobileAd ret1 = (MobileAd)ret;
			logger.info("Title = " + ret1.getTitle()
					+ "; Text = " + ret1.getText()
					+ "; DisplayUrl = " + ret1.getDisplayUrl()
					+ "; DestinationUrl = " + ret1.getDestinationUrl());
			
			//getAdsByAdGroupId
			Ad[] ret = test.getAdsByAdGroupId(1595249L, 754813047L);
			for (Ad x : ret){
				MobileAd a = (MobileAd) x;
				logger.info("Id = " + a.getId()
						+ "; Title = " + a.getTitle()
						+ "; Text = " + a.getText()
						+ "; DisplayUrl = " + a.getDisplayUrl()
						+ "; DestinationUrl = " + a.getDestinationUrl());
			}
			
			//updateAdById
			  //check before update
			Ad ret = test.getAdById(1595249L, 754813047L, 937776925L);
			MobileAd a = (MobileAd) ret;
			logger.info("Id = " + a.getId()
					+ "; Title = " + a.getTitle()
					+ "; Text = " + a.getText()
					+ "; DisplayUrl = " + a.getDisplayUrl()
					+ "; DestinationUrl = " + a.getDestinationUrl());
			  //update
			test.updateAdById(1595249L, 754813047L, 937776925L, "nan ad test 1", "semplest test num 1", "https://adcenter.microsoft.com/", "https://adcenter.microsoft.com/");
			  //check after update
			ret = test.getAdById(1595249L, 754813047L, 937776925L);
			a = (MobileAd) ret;
			logger.info("Id = " + a.getId()
					+ "; Title = " + a.getTitle()
					+ "; Text = " + a.getText()
					+ "; DisplayUrl = " + a.getDisplayUrl()
					+ "; DestinationUrl = " + a.getDestinationUrl());
			
			//pauseAdById
			test.pauseAdById(1595249L, 754813047L, 937776925L);  //pause the Ad
			  //Check current status
			Ad ret = test.getAdById(1595249L, 754813047L, 937776925L);
			logger.info("AdId = " + ret.getId()
					+ "; status = " + ret.getStatus().getValue());
			
			//resumeAdById
			test.resumeAdById(1595249L, 754813047L, 937776925L);  //resume the Ad
			  //Check current status
			Ad ret = test.getAdById(1595249L, 754813047L, 937776925L);
			logger.info("AdId = " + ret.getId()
					+ "; status = " + ret.getStatus().getValue());
			test.pauseAdById(1595249L, 754813047L, 937776925L);  //you'd better pause it after test
			
			//deleteAdById
			  //create a new Ad first
			long ret1 = test.createAd(1595249L, 754813047L, "nan ad test 3", "semplest test num 3", "https://www.semplest.com/", "https://www.semplest.com/");
			  //list all Ads
			Ad[] ret2 = test.getAdsByAdGroupId(1595249L, 754813047L);
			for (Ad x : ret2){
				MobileAd a = (MobileAd) x;
				logger.info("Id = " + a.getId());
			}
			  //now delete the last Ad
			test.deleteAdById(1595249L, 754813047L, ret1);
			  //list all current Ads
			ret2 = test.getAdsByAdGroupId(1595249L, 754813047L);
			for (Ad x : ret2){
				MobileAd a = (MobileAd) x;
				logger.info("Id = " + a.getId());
			}
			
			//createKeyword, getKeywordById
			  //createKeyword
			Bid broadMatchBid = new Bid();
			broadMatchBid.setAmount(2.00);
			Bid contentMatchBid = new Bid();
			contentMatchBid.setAmount(2.01);
			Bid exactMatchBid = new Bid();
			exactMatchBid.setAmount(2.02);
			Bid phraseMatchBid = new Bid();
			phraseMatchBid.setAmount(2.03);
			long ret = test.createKeyword(1595249L, 754813047L, "nan keyword test 2", broadMatchBid, contentMatchBid, exactMatchBid, phraseMatchBid);			
			  //getKeywordById
			Keyword ret2 = test.getKeywordById(1595249L, 754813047L, ret);
			if(ret2 != null){
				logger.info("Id = " + ret2.getId()
						+ "; text = " + ret2.getText());
			}
			
			//createKeywords
			Keyword[] keywords = new Keyword[2];
			keywords[0] = new Keyword();
			keywords[1] = new Keyword();
			keywords[0].setText("nan keyword test 4");
			keywords[1].setText("nan keyword test 5");
			Bid broadMatchBid1 = new Bid();
			broadMatchBid1.setAmount(3.01);
			Bid broadMatchBid2 = new Bid();
			broadMatchBid2.setAmount(3.01);
			keywords[0].setBroadMatchBid(broadMatchBid1);						
			keywords[1].setBroadMatchBid(broadMatchBid2);			
			long[] ret = test.createKeywords(1595249L, 754813047L, keywords);
			
			//getKeywordByAdGroupId
			Keyword[] ret2 = test.getKeywordByAdGroupId(1595249L, 754813047L);
			
			//updateKeywordBidById
			  //check before update
			Keyword ret = test.getKeywordById(1595249L, 754813047L, 8099371830L);
			if(ret != null){
				logger.info("Id = " + ret.getId()
						+ "; broadMatchBid = " + ret.getBroadMatchBid().getAmount()
						+ "; contentMatchBid = " + ret.getContentMatchBid().getAmount()
						+ "; exactMatchBid = " + ret.getExactMatchBid().getAmount()
						+ "; phraseMatchBid = " + ret.getPhraseMatchBid().getAmount());
			}
			  //update
			Bid broadMatchBid = new Bid();
			broadMatchBid.setAmount(5.00);
			Bid contentMatchBid = new Bid();
			contentMatchBid.setAmount(5.01);
			Bid exactMatchBid = new Bid();
			exactMatchBid.setAmount(5.02);
			Bid phraseMatchBid = new Bid();
			phraseMatchBid.setAmount(5.03);
			test.updateKeywordBidById(1595249L, 754813047L, 8099371830L, broadMatchBid, contentMatchBid, exactMatchBid, phraseMatchBid);
			  //check after update
			ret = test.getKeywordById(1595249L, 754813047L, 8099371830L);
			if(ret != null){
				logger.info("Id = " + ret.getId()
						+ "; broadMatchBid = " + ret.getBroadMatchBid().getAmount()
						+ "; contentMatchBid = " + ret.getContentMatchBid().getAmount()
						+ "; exactMatchBid = " + ret.getExactMatchBid().getAmount()
						+ "; phraseMatchBid = " + ret.getPhraseMatchBid().getAmount());
			}
			
			//updateKeywordBidsByIds
			long[] keywordId = new long[2];
			keywordId[0] = 8099371836L;
			keywordId[1] = 8099436288L;
			Bid[] broadMatchBid = new Bid[2];
			broadMatchBid[0] = new Bid();
			broadMatchBid[0].setAmount(6.01);
			broadMatchBid[1] = new Bid();
			broadMatchBid[1].setAmount(7.01);
			Bid[] contentMatchBid = broadMatchBid;
			Bid[] exactMatchBid = broadMatchBid;
			Bid[] phraseMatchBid = broadMatchBid;			
			test.updateKeywordBidsByIds(1595249L, 754813047L, keywordId, broadMatchBid, contentMatchBid, exactMatchBid, phraseMatchBid);
			  //check the updated values
			Keyword ret = test.getKeywordById(1595249L, 754813047L, 8099371836L);
			if(ret != null){
				logger.info("Id = " + ret.getId()
						+ "; broadMatchBid = " + ret.getBroadMatchBid().getAmount()
						+ "; contentMatchBid = " + ret.getContentMatchBid().getAmount()
						+ "; exactMatchBid = " + ret.getExactMatchBid().getAmount()
						+ "; phraseMatchBid = " + ret.getPhraseMatchBid().getAmount());
			}
			ret = test.getKeywordById(1595249L, 754813047L, 8099436288L);
			if(ret != null){
				logger.info("Id = " + ret.getId()
						+ "; broadMatchBid = " + ret.getBroadMatchBid().getAmount()
						+ "; contentMatchBid = " + ret.getContentMatchBid().getAmount()
						+ "; exactMatchBid = " + ret.getExactMatchBid().getAmount()
						+ "; phraseMatchBid = " + ret.getPhraseMatchBid().getAmount());
			}
			
			//pauseKeywordById
			test.pauseKeywordById(1595249L, 754813047L, 8099371830L);
			  //check it
			Keyword ret = test.getKeywordById(1595249L, 754813047L, 8099371830L);
			if(ret != null){
				logger.info("Id = " + ret.getId()
						+ "; broadMatchBid = " + ret.getBroadMatchBid().getAmount()
						+ "; status = " + ret.getStatus());
			}
			
			//deleteKeywordById
			test.deleteKeywordById(1595249L, 754813047L, 8099436289L);
			
			//deleteKeywordsById
			long[] keywordIds = new long[2];
			keywordIds[0] = 8099371836L;
			keywordIds[1] = 8099436288L;
			test.deleteKeywordsById(1595249L, 754813047L, keywordIds);
			
			//getKeywordEstimateByBids
			String[] keywords = new String[2];
			keywords[0] = "flower";
			keywords[1] = "rose";
			Money bid = new Money(7000000);
			KeywordEstimatedPosition[] ret = test.getKeywordEstimateByBids(1595249L, keywords, bid);
			for(KeywordEstimatedPosition k : ret){
				EstimatedPositionAndTraffic[] pts = k.getEstimatedPositions();
				logger.info("keyword = " + k.getKeyword());
				if(pts != null){
					for(EstimatedPositionAndTraffic pt : pts){
						logger.info("EstimatedPositionAndTraffic: " 
								+ "\nAverageCPC = " + pt.getAverageCPC()
								+ "\nCTR = " + pt.getCTR()
								+ "\nMaxClicksPerWeek = " + pt.getMaxClicksPerWeek()
								+ "\nMaxImpressionsPerWeek = " + pt.getMaxImpressionsPerWeek()
								+ "\nMaxTotalCostPerWeek = " + pt.getMaxTotalCostPerWeek()
								+ "\nMinClicksPerWeek = " + pt.getMinClicksPerWeek()
								+ "\nMinImpressionsPerWeek = " + pt.getMinImpressionsPerWeek()
								+ "\nMinTotalCostPerWeek = " + pt.getMinTotalCostPerWeek());
					}
				}
			}
			
			//requestCampaignReport
			String ret = test.requestCampaignReport(1595249L, 130129414L, 10, ReportAggregation.fromString(ReportAggregation._Daily));
			
			//requestKeywordReport
			DateTime firstDay = new DateTime(2012,3,1,0,0,0,0);
			DateTime lastDay = new DateTime(2012,3,31,0,0,0,0);
			String ret = test.requestKeywordReport(1595249L, 130129414L, firstDay, lastDay, ReportAggregation.fromString(ReportAggregation._Daily));		
					
			//getReportData
			Map<String, String[]> ret = test.getReportData("1901813874", 1595249L);
			Set<String> keys = ret.keySet();
			Collection<String[]> values = ret.values();
			logger.info(keys.toString());
			logger.info(values.toString());
			*/
			
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
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAccountById", json, null);
		MsnAccountObject account = gson.fromJson(returnData, MsnAccountObject.class);
		logger.debug("getAccountById: Name = " + account.getName()
				+ "; ParentCustomerId = " + account.getParentCustomerId()
				+ "; PrimaryUserId = " + account.getPrimaryUserId());
		return account.toAccount();
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
		if (campaigns == null)
			return null;
		logger.debug("getCampaignsByAccountId: numOfCampaigns = " + campaigns.length);
		for (int i = 0; i < campaigns.length; i++)
		{
			logger.debug(i + ": Name = " + campaigns[i].getName()
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
			stateslist += states.get(i) + separator;
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
		if (adgroups == null)
			return null;
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
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String stateslist = "";
		for (int i = 0; i < states.size()-1; i++){
			stateslist += states.get(i) + separator;
		}
		stateslist += states.get(states.size()-1);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("states", stateslist);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "setAdGroupStateTargets", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("setAdGroupStateTargets: (if successful returns 0) " + ret);
	}

	@Override
	public void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String citylist = "";
		for (int i = 0; i < cities.size()-1; i++){
			citylist += cities.get(i) + separator;
		}
		citylist += cities.get(cities.size()-1);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("cities", citylist);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "setAdGroupCityTargets", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("setAdGroupCityTargets: (if successful returns 0) " + ret);
	}

	@Override
	public void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String metroTargetsList = "";
		for (int i = 0; i < metroTargets.size()-1; i++){
			metroTargetsList += metroTargets.get(i) + separator;
		}
		metroTargetsList += metroTargets.get(metroTargets.size()-1);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("msnAdGroupId", Long.toString(msnAdGroupId));
		jsonHash.put("metroTargets", metroTargetsList);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "setAdGroupMetroAreaTargets", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("setAdGroupMetroAreaTargets: (if successful returns 0) " + ret);
	}

	@Override
	public void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteAdGroupTargets", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("deleteAdGroupTargets: (if successful returns 0) " + ret);
	}

	@Override
	public Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("customerId", Long.toString(customerId));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAdGroupTargets", json, null);
		Target ret = gson.fromJson(returnData, Target.class);
		logger.debug("getAdGroupTargets: ok");
		return ret;
	}

	@Override
	public long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("title", title);
		jsonHash.put("text", text);
		jsonHash.put("displayUrl", displayUrl);
		jsonHash.put("destinationUrl", destinationUrl);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createAd", json, null);
		long ret = gson.fromJson(returnData, long.class);
		logger.debug("createAd: AdId = " + ret);
		return ret;
	}

	@Override
	public Ad getAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("adId", Long.toString(adId));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAdById", json, null);
		MsnAdObject ret = gson.fromJson(returnData, MsnAdObject.class);
		logger.debug("getAdById: ok");
		return ret.toAd();
	}

	@Override
	public Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAdsByAdGroupId", json, null);
		MsnAdObject[] ret = gson.fromJson(returnData, MsnAdObject[].class);
		if (ret == null)
			return null;
		logger.debug("getAdsByAdGroupId: ok");
		//depack to Ad
		Ad[] ret1 = new Ad[ret.length];
		for (int i = 0; i < ret.length; i++){
			ret1[i] = new Ad();
			ret1[i] = ret[i].toAd();
		}
		return ret1;
	}

	@Override
	public void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl)
			throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("adId", Long.toString(adId));
		jsonHash.put("title", title);
		jsonHash.put("text", text);
		jsonHash.put("displayUrl", displayUrl);
		jsonHash.put("destinationUrl", destinationUrl);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "updateAdById", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("updateAdById: (if successful returns 0) " + ret);
	}

	@Override
	public void pauseAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("adId", Long.toString(adId));		
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "pauseAdById", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("pauseAdById: (if successful returns 0) " + ret);
	}

	@Override
	public void resumeAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("adId", Long.toString(adId));		
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "resumeAdById", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("resumeAdById: (if successful returns 0) " + ret);
	}

	@Override
	public void deleteAdById(Long accountId, Long adGroupId, long adId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("adId", Long.toString(adId));		
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteAdById", json, null);
		int ret = gson.fromJson(returnData, int.class);
		logger.debug("deleteAdById: (if successful returns 0) " + ret);
	}

	@Override
	public long createKeyword(Long accountId, Long adGroupId, String text, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid,
			Bid phraseMatchBid) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String broadMatchBidStr = gson.toJson(broadMatchBid);
		String contentMatchBidStr = gson.toJson(contentMatchBid);
		String exactMatchBidStr = gson.toJson(exactMatchBid);
		String phraseMatchBidStr = gson.toJson(phraseMatchBid);		
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("text", text);
		jsonHash.put("broadMatchBid", broadMatchBidStr);
		jsonHash.put("contentMatchBid", contentMatchBidStr);
		jsonHash.put("exactMatchBid", exactMatchBidStr);
		jsonHash.put("phraseMatchBid", phraseMatchBidStr);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createKeyword", json, null);
		long ret = gson.fromJson(returnData, long.class);
		logger.debug("createKeyword: KeywordId = " + ret);
		return ret;
	}

	@Override
	public Keyword getKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywordId", Long.toString(keywordId));		
		String json = gson.toJson(jsonHash);
		
		MsnKeywordObject ret = null;
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getKeywordById", json, null);
		ret = gson.fromJson(returnData, MsnKeywordObject.class);
		logger.debug("getKeywordById: ok");
		return ret.toKeyword();
	}

	@Override
	public Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));		
		String json = gson.toJson(jsonHash);
		
		MsnKeywordObject[] ret1 = null;
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getKeywordByAdGroupId", json, null);
		ret1 = gson.fromJson(returnData, MsnKeywordObject[].class);
		if (ret1 == null)
			return null;
		Keyword[] ret = new Keyword[ret1.length];
		logger.debug("getKeywordByAdGroupId: num of keywords = " + ret1.length);
		for (int i = 0; i < ret1.length; i++){
			ret[i] = new Keyword();
			ret[i] = ret1[i].toKeyword();
			logger.debug("Id = " + ret[i].getId()
					+ "; Text = " + ret[i].getText());
		}		
		return ret;
	}

	@Override
	public void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid,
			Bid phraseMatchBid) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String broadMatchBidStr = gson.toJson(broadMatchBid);
		String contentMatchBidStr = gson.toJson(contentMatchBid);
		String exactMatchBidStr = gson.toJson(exactMatchBid);
		String phraseMatchBidStr = gson.toJson(phraseMatchBid);		
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywordId", Long.toString(keywordId));
		jsonHash.put("broadMatchBid", broadMatchBidStr);
		jsonHash.put("contentMatchBid", contentMatchBidStr);
		jsonHash.put("exactMatchBid", exactMatchBidStr);
		jsonHash.put("phraseMatchBid", phraseMatchBidStr);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "updateKeywordBidById", json, null);
		long ret = gson.fromJson(returnData, long.class);
		logger.debug("updateKeywordBidById: (if successful returns 0) " + ret);
	}

	@Override
	public void updateKeywordBidsByIds(Long accountId, Long adGroupId, long[] keywordId, Bid[] broadMatchBid, Bid[] contentMatchBid,
			Bid[] exactMatchBid, Bid[] phraseMatchBid) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String keywordIdStr = gson.toJson(keywordId);
		String broadMatchBidStr = gson.toJson(broadMatchBid);
		String contentMatchBidStr = gson.toJson(contentMatchBid);
		String exactMatchBidStr = gson.toJson(exactMatchBid);
		String phraseMatchBidStr = gson.toJson(phraseMatchBid);		
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywordId", keywordIdStr);
		jsonHash.put("broadMatchBid", broadMatchBidStr);
		jsonHash.put("contentMatchBid", contentMatchBidStr);
		jsonHash.put("exactMatchBid", exactMatchBidStr);
		jsonHash.put("phraseMatchBid", phraseMatchBidStr);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "updateKeywordBidsByIds", json, null);
		long ret = gson.fromJson(returnData, long.class);
		logger.debug("updateKeywordBidsByIds: (if successful returns 0) " + ret);
	}

	@Override
	public void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywordId", Long.toString(keywordId));		
		String json = gson.toJson(jsonHash);
		
		int ret = -1;
		String returnData = runMethod(baseurl,SERVICEOFFERED, "pauseKeywordById", json, null);
		ret = gson.fromJson(returnData, int.class);
		logger.debug("pauseKeywordById: (if successful returns 0) " + ret);
	}

	@Override
	public void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywordId", Long.toString(keywordId));		
		String json = gson.toJson(jsonHash);
		
		int ret = -1;
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteKeywordById", json, null);
		ret = gson.fromJson(returnData, int.class);
		logger.debug("deleteKeywordById: (if successful returns 0) " + ret);
	}

	@Override
	public void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String keywordIdsStr = gson.toJson(keywordIds);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywordIds", keywordIdsStr);		
		String json = gson.toJson(jsonHash);
		
		int ret = -1;
		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteKeywordsById", json, null);
		ret = gson.fromJson(returnData, int.class);
		logger.debug("deleteKeywordsById: (if successful returns 0) " + ret);
	}

	@Override
	public KeywordEstimatedPosition[] getKeywordEstimateByBids(Long accountId, String[] keywords, Money bid) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String keywordsList = "";
		for (int i = 0; i < keywords.length-1; i++){
			keywordsList += keywords[i] + separator;
		}
		keywordsList += keywords[keywords.length-1];
		String bidStr = gson.toJson(bid);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("keywords", keywordsList);
		jsonHash.put("bid", bidStr);		
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getKeywordEstimateByBids", json, null);
		KeywordEstimatedPosition[] ret = gson.fromJson(returnData, KeywordEstimatedPosition[].class);
		if (ret == null)
			return null;
		logger.debug("getKeywordEstimateByBids: ok");

		return ret;
	}

	@Override
	public Map<String, String[]> getReportData(String reportId, Long accountId) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("reportId", reportId);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		String json = gson.toJson(jsonHash);
		
		ProtocolJSON protocolJson = new ProtocolJSON();
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getReportData", json, null);
		HashMap<String,String[]> ret = protocolJson.getHashMapFromJson(returnData);
		logger.debug("getReportData: ok");
		
		return ret;
	}

	@Override
	public String requestCampaignReport(Long accountId, Long campaignId, int daysInReport, ReportAggregation aggregation) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String aggregationStr = gson.toJson(aggregation);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId));
		jsonHash.put("daysInReport", Integer.toString(daysInReport));
		jsonHash.put("aggregation", aggregationStr);		
		String json = gson.toJson(jsonHash);
		
		String returnData = "";
		returnData = runMethod(baseurl,SERVICEOFFERED, "requestCampaignReport", json, null);
		String ret = returnData;
		logger.debug("requestCampaignReport: reportID = " + ret);

		return ret;		
		
	}

	@Override
	public String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String aggregationStr = gson.toJson(aggregation);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("campaignId", Long.toString(campaignId));
		jsonHash.put("firstDay", firstDay.toString());
		jsonHash.put("lastDay", lastDay.toString());
		jsonHash.put("aggregation", aggregationStr);		
		String json = gson.toJson(jsonHash);
		
		String returnData = "";
		returnData = runMethod(baseurl,SERVICEOFFERED, "requestKeywordReport", json, null);
		String ret = returnData;
		logger.debug("requestKeywordReport: reportID = " + ret);

		return ret;		
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
	public long[] createKeywords(Long accountId, Long adGroupId, Keyword... keywords) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String keywordsList = "";
		for (int i = 0; i < keywords.length-1; i++){
			keywordsList += gson.toJson(keywords[i]) + separator;
		}
		keywordsList += gson.toJson(keywords[keywords.length-1]);
		jsonHash.put("accountId", Long.toString(accountId.longValue()));
		jsonHash.put("adGroupId", Long.toString(adGroupId.longValue()));
		jsonHash.put("keywords", keywordsList);
		String json = gson.toJson(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "createKeywords", json, null);
		long[] ret = gson.fromJson(returnData, long[].class);
		if (ret == null)
			return null;
		for (long r:ret){
			logger.debug("createKeywords: Id = " + r);
		}
		return ret;
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
	@Override
	public TaskOutput RunTask(String method, String jsonParameters, String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}

}
