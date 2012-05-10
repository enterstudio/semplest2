package semplest.server.service.adengine;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.SemplestMatchType;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.AdvertisingEnginePromotionObj;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.AddReportDataSP;
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
	private SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	private String esbURL = "http://VMDEVJAVA1:9898/semplest";

	//CustomerID = 2	State Farm	coffee machine	promotionID = 4	ProductGroupID=37	coffee machine
	public static void main(String[] args)
	{
		try
		{
			
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			/*
			GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP();
			String advertisingEngine = "Google";
			List<KeywordProbabilityObject> keywordList = getKeywords.execute(4, (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ? true : false , (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true : false);
			keywordList.size();
			*/
			ArrayList<String> adEngList = new ArrayList<String>();
			adEngList.add("Google");
			SemplestAdengineServiceImpl adEng = new SemplestAdengineServiceImpl();
			//Long micro = adEng.calculateDailyMicroBudgetFromMonthly(new Double(25.0), 30);
			//String u = adEng.getURL("www.xyz.com");
			//Tovah Photography 2	47	Photography	58	38	Event and portrait photos
			adEng.AddPromotionToAdEngine(47, 58, 38, adEngList);
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		SemplestConfiguration configDB = new SemplestConfiguration();
		Thread configThread = new Thread(configDB);
		configThread.start();
		
	}

	public String AddPromotionToAdEngine(String json) throws Exception
	{
		logger.debug("call  AddPromotionToAdEngine(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer customerID = Integer.parseInt(data.get("customerID"));
		Integer productGroupID = Integer.parseInt(data.get("productGroupID"));
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		ArrayList<String> adEngineList = gson.fromJson(data.get("adEngineList"), ArrayList.class);
		Boolean res =AddPromotionToAdEngine(customerID, productGroupID, promotionID, adEngineList);
		return gson.toJson(res);
	}
	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList)
			throws Exception
	{
		SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient(esbURL);
		//get the AdEngine Initial Data
		HashMap<String,AdEngineInitialData>  adEngineInitialMap = bidClient.getInitialValues(PromotionID, adEngineList);
		//
		GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP();
		//setup the budget for each ad engine
		HashMap<String, HashMap<String ,Object>> remainingBudgetDaysMap = setupAdEngineBudget(PromotionID, adEngineList,bidClient);
		
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
				accountID = (Long) AdEngineAccoutRow.get(0).get("AccountID");
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
				Double budget = (Double) remainingBudgetDaysMap.get(advertisingEngine).get("RemainingBudgetInCycle");
				Integer daysLeft = (Integer) remainingBudgetDaysMap.get(advertisingEngine).get("RemainingDays");
				Long campaignID =  createCampaign(String.valueOf(accountID),PromotionID,customerID, advertisingEngine, budget, getPromoDataSP, daysLeft); //86970657L;
				// TEST Long campaignID = 567L;
				//Store campaignID
				SemplestDB.addPromotionToAdEngineAccountID(PromotionID, accountID, campaignID, null);
				//create the Ad Engine AdGroup
				AdgroupData adGroupData = createAdGroupAndAds(String.valueOf(accountID), campaignID ,advertisingEngine, AdGroupStatus.ENABLED, getPromoDataSP,adEngineInitialData.getDefaultMicroBid());
				//store the result in the DB: AdGroupID, AdID
				storeAdGroupData(advertisingEngine, campaignID, adGroupData);
				//Ad the Keywords to the Adgroup with default bid
				List<KeywordProbabilityObject> keywordList = getKeywords.execute(PromotionID, (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ? true : false , (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true : false);
				//add all the keywords with default value
				addKeywordsToAdGroup(String.valueOf(accountID),campaignID,PromotionID, adGroupData.getAdGroupID(), advertisingEngine,  keywordList, KeywordMatchType.fromString(SemplestMatchType.getSearchEngineMatchType(adEngineInitialData.getSemplestMatchType(), advertisingEngine)), null);
				//call the initial bidding service
				bidClient.getBidsInitial(String.valueOf(accountID), campaignID, adGroupData.getAdGroupID(), advertisingEngine);
				//schedule the on-going bidding
				scheduleOngoingBidding(PromotionID, adEngineList);
			}
		}
		 
		return true;
	}
	
	private void scheduleOngoingBidding(int promotionID, ArrayList<String> adEngineList)
	{
		for(String adEngine : adEngineList)
		{
			if (adEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name()))
			{
				//
			}
		}
		
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
	private void addKeywordsToAdGroup(String accountID, Long campaignID, Integer promotionID, Long adGroupID, String adEngine,  List<KeywordProbabilityObject> keywordList, KeywordMatchType matchType,Long microBidAmount) throws Exception
	{
		AddBidSP addKeywordBidSP = new AddBidSP();
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			//assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			for (KeywordProbabilityObject keywordObj : keywordList)
			{
				KeywordDataObject keywordDataObj = null;
				if (keywordObj.getIsNegative())
				{
					keywordDataObj = google.addNegativeKeyWordToAdGroup(accountID, campaignID, keywordObj.getKeyword(), matchType);
				}
				else
				{
					keywordDataObj = google.addKeyWordToAdGroup(accountID, adGroupID, keywordObj.getKeyword(), matchType, microBidAmount);
				}

				//Store result in DB including AdEngine KeywordID
				//int PromotionPK, Long KeywordAdEngineID, String Keyword, Integer MicroBidAmount, String BidType, String AdvertisingEngine, Boolean IsNegative
				addKeywordBidSP.execute(promotionID, keywordDataObj.getBidID(), keywordDataObj.getKeyword(), keywordDataObj.getMicroBidAmount().intValue(), keywordDataObj.getMatchType(), adEngine, keywordObj.getIsNegative());
				Thread.sleep(500);  //Wait for google
			}
		}
		
	}
	private HashMap<String, HashMap<String ,Object>> setupAdEngineBudget(Integer PromotionID, ArrayList<String> adEngineList, SemplestBiddingServiceClient bidClient) throws Exception
	{
		HashMap<String, HashMap<String ,Object>> remainingBudgetDaysMap = new HashMap<String, HashMap<String , Object>>();
		//Get the split
		
		HashMap<String, Double> AdEngineBudgetPercent = bidClient.GetMonthlyBudgetPercentPerSE(PromotionID, adEngineList);
		//get remaining Budget
		BudgetObject remainingBudget =  SemplestDB.getBudget(PromotionID);
		Iterator<String> adEngineIT = AdEngineBudgetPercent.keySet().iterator();
		
		while(adEngineIT.hasNext())
		{
			String adEng = adEngineIT.next();
			Double budgetSplit = remainingBudget.getRemainingBudgetInCycle() * (0.01 *  AdEngineBudgetPercent.get(adEng));
			HashMap<String , Object> data = new HashMap<String , Object>();
			data.put("RemainingBudgetInCycle", budgetSplit);
			data.put("RemainingDays", remainingBudget.getRemainingDays());
			remainingBudgetDaysMap.put(adEng,data);
		}	
		return remainingBudgetDaysMap;
	}
	private AdgroupData createAdGroupAndAds(String accountID, Long campaignID ,String adEngine, AdGroupStatus status, GetAllPromotionDataSP getPromoDataSP, Long defaultMicroBid) throws Exception
	{
		
		AdgroupData adGrpData = new AdgroupData();
		List<AdsObject> adList =  getPromoDataSP.getAds();
		PromotionObj promotionData = getPromoDataSP.getPromotionData();
		Long adGroupID = null;
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			adGroupID =  google.AddAdGroup(accountID, campaignID, promotionData.getPromotionName() + "_AdGroup", status, defaultMicroBid);
			adGrpData.setAdGroupID(adGroupID);
			for (AdsObject ad : adList )
			{
				Long adID = google.addTextAd(accountID, adGroupID, ad.getAdTitle(), ad.getAdTextLine1(), ad.getAdTextLine2(), promotionData.getLandingPageURL(), promotionData.getLandingPageURL());
				ad.setAdEngineAdID(adID);
			}
			adGrpData.setAds(adList);
			//AD GEOTARGET HERE
			List<GeoTargetObject> geoObjList = getPromoDataSP.getGeoTargets();
			for (GeoTargetObject geoObj : geoObjList)
			{
				google.setGeoTarget(accountID, campaignID,  geoObj.getRadius(),  geoObj.getAddress(),  geoObj.getCity(),  geoObj.getState(),  geoObj.getZip());
			}
			
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
	private Long createCampaign(String accountID,Integer promotionID, Integer customerID, String adEngine, Double monthlyBudgetAmount, GetAllPromotionDataSP getPromoDataSP, Integer remainingDaysInCycle) throws Exception
	{
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			//assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			//get the promotion name/ campaign name,  Budget period,
			Long microbudgetAmount = calculateDailyMicroBudgetFromMonthly(monthlyBudgetAmount,remainingDaysInCycle); 
			Campaign campaign =  google.CreateOneCampaignForAccount(accountID, getPromoDataSP.getPromotionData().getPromotionName(), CampaignStatus.ACTIVE, 
					BudgetBudgetPeriod.DAILY,microbudgetAmount);
			return campaign.getId();
		}
		
		else if (adEngine.equalsIgnoreCase(AdEngine.MSN.name()))
		{
			return null;
		}
		else
		{
			throw new Exception(adEngine + " Not found to create account");
		}
		
		
	}
	/*
	 * 
	 */
	private Long calculateDailyMicroBudgetFromMonthly(Double monthlyBudget, Integer remainingDaysInCycle)
	{
		Double daily = ((7.0*monthlyBudget)/remainingDaysInCycle.doubleValue()) * 100. ;
		//calculate 
		BigDecimal bd = new BigDecimal(daily); 
		return (bd.longValue() * 10000L);
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
	
	/*
	 * This executes the bidding process synchronously
	 * 
	 */

	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID, String adEngine) throws Exception
	{
		GetAllPromotionDataSP getPromoDataSP  = new GetAllPromotionDataSP();
		getPromoDataSP.execute(PromotionID);
		PromotionObj promoObj = getPromoDataSP.getPromotionData();
		/*
		 * look back 5 days to get the transactions
		 */
		Calendar cal = Calendar.getInstance();
		Date now = new Date();
		cal.add(Calendar.DAY_OF_MONTH, -5);
		
		if (adEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name()))
		{
			//go get the report from Google
			SemplestString semplstStr = new SemplestString();
			semplstStr.setSemplestString(promoObj.getAdvertisingEngineAccountPK().toString());
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			try
			{
				ReportObject[] getReportData = google.getReportForAccount(promoObj.getAdvertisingEngineAccountPK().toString(),YYYYMMDD.format(cal.getTime()) , YYYYMMDD.format(now));
				AddReportDataSP addReportData = new AddReportDataSP();
				//go through all the report objects and add to DB
				for (int i = 0; i < getReportData.length; i++)
				{
					//check to see 
					if (getReportData[i].getCampaignID().equals(promoObj.getAdvertisingEngineCampaignPK()))
					{
						//store the report data in AdvertisingEngineReportData
						addReportData.execute(PromotionID, getReportData[i].getKeyword(),adEngine, getReportData[i].getTransactionDate(), 
								getReportData[i].getMicroBidAmount(), getReportData[i].getNumberImpressions(), getReportData[i].getNumberClick(), getReportData[i].getAveragePosition(), 
								getReportData[i].getAverageCPC(), getReportData[i].getBidMatchType(), getReportData[i].getQualityScore(), getReportData[i].getApprovalStatus(), 
								getReportData[i].getFirstPageCPC(), getReportData[i].getMicroCost());
					}
				}
			}
			catch (Exception e)
			{
				logger.error("Unable to download Report for account " + promoObj.getAdvertisingEngineAccountPK().toString());
			}
		}
		
		return true;
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
