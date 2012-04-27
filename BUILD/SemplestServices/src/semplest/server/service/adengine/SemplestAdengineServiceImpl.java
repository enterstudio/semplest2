package semplest.server.service.adengine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.SemplestString;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;

import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.gson.Gson;

public class SemplestAdengineServiceImpl implements SemplestAdengineServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestAdengineServiceImpl.class);
	private static Gson gson = new Gson();
	

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID, Long productGroupID, Integer PromotionID, ArrayList<String> adEngineList)
			throws Exception
	{
		String companyName = null;
		//for each ad Engine
		for (String advertisingEngine : adEngineList)
		{
			Long accountID = null;
			if (!AdEngine.existsAdEngine(advertisingEngine))
			{
				throw new Exception(advertisingEngine + " Not Found");
			}
			//see if there is an account on ad engine - call returns two kets: AccountID and CustomerName
			List<LinkedHashMap<String, Object>> AdEngineAccoutRow =SemplestDB.getAdEngineAccount(customerID,advertisingEngine);
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
			//if no promo group then add
			Long prodGroupID = null;
			if (productGroupID == null)
			{
				//create the campaign
				prodGroupID = createCampaign(accountID, advertisingEngine);
				//store new product group for ad engine 
				
			}
			else
			{
				prodGroupID = productGroupID;
			}
			//create the Ad Engine AdGroup
			
		}
		 
		return null;
	}
	private Long createCampaign(Long accountID, String adEngine)
	{
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			//assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			Long campaignID =  0l;
					//google.CreateOneCampaignForAccount(accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period,Money budgetAmount)
			return campaignID;
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
