package semplest.server.service.adengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.springjdbc.AdvertisingEnginePromotionObj;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddKeywordBidDataSP;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.server.service.springjdbc.storedproc.GetKeywordForAdEngineSP;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;

import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.gson.Gson;

public class SemplestAdengineServiceImpl implements SemplestAdengineServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestAdengineServiceImpl.class);
	private static Gson gson = new Gson();
	private String esbURL = "http://VMJAVA1:9898/semplest";
	

	@Override
	public void initializeService(String input) throws Exception
	{
		// call the DB to get the config
		
	}

	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID, Long productGroupID, Integer PromotionID, ArrayList<String> adEngineList)
			throws Exception
	{
		SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient(esbURL);
		//get the AdEngine Initial Data
		HashMap<String,AdEngineInitialData>  adEngineInitialMap = bidClient.getInitialValues(PromotionID, adEngineList);
		GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP();
		//setup the budget for each ad engine
		HashMap<String, Double> remainingBudgetMap = setupAdEngineBudget(PromotionID, adEngineList,bidClient);
		String companyName = null;
		//Get all common info - promotion data,  Ads, Geotargeting
		GetAllPromotionDataSP getPromoDataSP  = new GetAllPromotionDataSP();
		getPromoDataSP.execute(PromotionID);
		//for each ad Engine
		for (String advertisingEngine : adEngineList)
		{
			Long accountID = null;
			AdEngineInitialData  adEngineInitialData = adEngineInitialMap.get(advertisingEngine);
			if (!AdEngine.existsAdEngine(advertisingEngine))
			{
				throw new Exception(advertisingEngine + " Not Found");
			}
			//see if there is an account on ad engine - call returns two kets: AccountID and CustomerName
			List<LinkedHashMap<String, Object>> AdEngineAccoutRow = SemplestDB.getAdEngineAccount(customerID,advertisingEngine);
			companyName = (String) AdEngineAccoutRow.get(0).get("CustomerName");
			if  (AdEngineAccoutRow.get(0).get("AccountID") == null)
			{
				//create a new account on the search engine 
				accountID = createAdEngineAccount(advertisingEngine, companyName);
				//store the account ID for the customer
				SemplestDB.addAdEngineAccountID(customerID, accountID,  advertisingEngine);
				logger.debug("Created Account for " + companyName + ":" + String.valueOf(accountID));
			}
			else
			{
				accountID = new Long((Integer) AdEngineAccoutRow.get(0).get("AccountID"));
				logger.debug("Found Account for " + companyName + ":" + String.valueOf(accountID));
			}
			//if no campaign then add SINCE this is create there should be no campaign
			AdvertisingEnginePromotionObj promotionDataList =  SemplestDB.getAdvertisingEngineCampaign(accountID, PromotionID);
			if (promotionDataList != null)
			{
				throw new Exception("A Campaign has already been created for the Promotion " + PromotionID);
			}
			else
			{
				//create campaign on ad engine
				Double budget = remainingBudgetMap.get(advertisingEngine);
				Long campaignID = createCampaign(String.valueOf(accountID),PromotionID,customerID, advertisingEngine, budget.longValue() * 1000000L, getPromoDataSP,adEngineInitialData.getDefaultMicroBid());
				//Store campaignID
				SemplestDB.addPromotionToAdEngineAccountID(PromotionID, accountID, campaignID, null);
				//create the Ad Engine AdGroup
				AdgroupData adGroupData = createAdGroupAndAds(String.valueOf(accountID), campaignID ,advertisingEngine, AdGroupStatus.ENABLED, getPromoDataSP);
				//store the result in the DB: AdGroupID, AdID
				storeAdGroupData(advertisingEngine, campaignID, adGroupData);
				//Ad the Keywords to the Adgroup with default bid
				List<KeywordProbabilityObject> keywordList = getKeywords.execute(PromotionID, (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ? true : false , (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true : false);
				//add all the keywords with default value
				addKeywordsToAdGroup(String.valueOf(accountID),PromotionID, adGroupData.getAdGroupID(), advertisingEngine,  keywordList, KeywordMatchType.fromString(adEngineInitialData.getSemplestMatchType().getSearchEngineMatchType(adEngineInitialData.getSemplestMatchType().name(), advertisingEngine)), null);
				//call the initial bidding service
				bidClient.getBidsInitial(String.valueOf(accountID), campaignID, adGroupData.getAdGroupID(), advertisingEngine);
				//schedule the on-going bidding
			}
		}
		 
		return true;
	}
	
	/*
	 * store the adGroupID and AdIDs
	 */
	private void storeAdGroupData(String advertisingEngine, Long campaignID, AdgroupData adGroupData) throws Exception
	{
		SemplestDB.setAdvertisingEngineAdGroupID(campaignID, adGroupData.getAdGroupID());
		List<AdsObject> adList = adGroupData.getAds();
		for (AdsObject adObj : adList)
		{
			SemplestDB.setAdIDForAdGroup(adObj.getAdEngineAdID(), advertisingEngine, adObj.getPromotionAdsPK());
		}
	}
	private void addKeywordsToAdGroup(String accountID, Integer promotionID, Long adGroupID, String adEngine,  List<KeywordProbabilityObject> keywordList, KeywordMatchType matchType,Long microBidAmount) throws Exception
	{
		AddKeywordBidDataSP addKeywordBidDataSP = new AddKeywordBidDataSP();
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			//assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			for (KeywordProbabilityObject keywordObj : keywordList)
			{
				KeywordDataObject keywordDataObj = google.addKeyWordToAdGroup(accountID, adGroupID, keywordObj.getKeyword(), matchType, microBidAmount);
				//Store result in DB including AdEngine KeywordID
				addKeywordBidDataSP.execute(promotionID, keywordDataObj.getBidID(), keywordDataObj.getKeyword(), keywordDataObj.getMicroBidAmount(), keywordDataObj.getMatchType(), adEngine);
			}
		}
		
	}
	private HashMap<String, Double> setupAdEngineBudget(Integer PromotionID, ArrayList<String> adEngineList, SemplestBiddingServiceClient bidClient) throws Exception
	{
		HashMap<String, Double> remainingBudgetMap = new HashMap<String, Double>();
		//Get the split
		
		HashMap<String, Integer> AdEngineBudgetPercent = bidClient.GetMonthlyBudgetPercentPerSE(PromotionID, adEngineList);
		//get remaining Budget
		BudgetObject remainingBudget =  SemplestDB.getBudget(PromotionID);
		Iterator<String> adEngineIT = AdEngineBudgetPercent.keySet().iterator();
		
		while(adEngineIT.hasNext())
		{
			String adEng = adEngineIT.next();
			Double budgetSplit = remainingBudget.getRemainingBudgetInCycle() * (0.01 *  AdEngineBudgetPercent.get(adEng));
			remainingBudgetMap.put(adEng, budgetSplit);
		}	
		return remainingBudgetMap;
	}
	private AdgroupData createAdGroupAndAds(String accountID, Long campaignID ,String adEngine, AdGroupStatus status, GetAllPromotionDataSP getPromoDataSP) throws Exception
	{
		AdgroupData adGrpData = new AdgroupData();
		List<AdsObject> adList =  getPromoDataSP.getAds();
		List<GeoTargetObject> geoTargetList = getPromoDataSP.getGeoTargets();
		PromotionObj promotionData = getPromoDataSP.getPromotionData();
		Long adGroupID = null;
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			adGroupID =  google.AddAdGroup(accountID, campaignID, promotionData.getPromotionName() + "_AdGroup", status);
			adGrpData.setAdGroupID(adGroupID);
			for (AdsObject ad : adList )
			{
				Long adID =  google.addTextAd(accountID, adGroupID, ad.getAdTitle(), ad.getAdText(), null, promotionData.getLandingPageURL(),  promotionData.getLandingPageURL());
				ad.setAdEngineAdID(adID);
			}
			adGrpData.setAds(adList);
			//AD GEOTARGET HERE
			
			
		}
		return adGrpData;
	}
	private class AdgroupData
	{
		private Long adGroupID;
		private List<AdsObject> ads = new ArrayList<AdsObject>();
		private List<GeoTargetObject> geoTargetList = new ArrayList<GeoTargetObject>();
		public Long getAdGroupID()
		{
			return adGroupID;
		}
		public void setAdGroupID(Long adGroupID)
		{
			this.adGroupID = adGroupID;
		}
		public List<AdsObject> getAds()
		{
			return ads;
		}
		public void setAds(List<AdsObject> ads)
		{
			this.ads = ads;
		}
		public List<GeoTargetObject> getGeoTargetList()
		{
			return geoTargetList;
		}
		public void setGeoTargetList(List<GeoTargetObject> geoTargetList)
		{
			this.geoTargetList = geoTargetList;
		}
		
		
	}
	/*
	 * Assumes Daily budget **NEED TO ADD DEFAULT MICROBID
	 */
	private Long createCampaign(String accountID,Integer promotionID, Integer customerID, String adEngine, Long microbudgetAmount, GetAllPromotionDataSP getPromoDataSP, Long defaultMicroBid) throws Exception
	{
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			//assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			//get the promotion name/ campaign name,  Budget period,
			Campaign campaign =  google.CreateOneCampaignForAccount(accountID, getPromoDataSP.getPromotionData().getPromotionName(), CampaignStatus.ACTIVE, 
					BudgetBudgetPeriod.DAILY,microbudgetAmount/30L);
			return campaign.getId();
		}
		
		else if (adEngine.equalsIgnoreCase(AdEngine.MSN.name()))
		{
			
		}
		else
		{
			//throw new Exception(adEngine + " Not found to create account");
		}
		
		return null;
	}
	private Long createAdEngineAccount(String adEngine, String companyName) throws Exception
	{
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			//assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			Account account =  google.CreateOneAccountService(null, null, companyName, "Semplest account for " + companyName);
			return account.getCustomerId();
		}
		else if (adEngine.equalsIgnoreCase(AdEngine.MSN.name()))
		{
			//assume US dollars US timezone
			SemplestString company = new SemplestString();
			MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			company.setSemplestString(companyName + "_Semplest" );
			MsnManagementIds  id = msn.createAccount(company);
			return id.getCustomerId();
		}
		else
		{
			throw new Exception(adEngine + " Not found to create account");
		}
			
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
	public Boolean UpdateGeoTargeting(Integer customerID, Integer productGroupID, Integer GeoTargetingID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
