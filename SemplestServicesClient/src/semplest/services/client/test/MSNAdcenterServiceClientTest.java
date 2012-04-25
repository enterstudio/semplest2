package semplest.services.client.test;

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
import semplest.services.client.api.MSNAdcenterServiceClient;
/**
 * This test has been generated to create campaigns using MSN  and test the data obtained from them.
 * @author lluis
 *
 */

public class MSNAdcenterServiceClientTest {

	private static String BASEURLTEST = "http://localhost:9898/semplest";
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClientTest.class);
	//Parameters to create campaign and adds
	String accountName = "_SummitFloristNJ";
	String url = "www.summithillsfloristnj.com";
	String productSubcategory = "Wedding Flowers";
	double msnMonthlyBudget = 50.0; //In dolars
			
	//Add1
	String adTitle1 =  "NJ Wedding Floral Artists";
	String adText1 = "Invest 30 minutes to book your wedding.10% Confidence discount.";
	//Add2
	String adTitle2 =  "Easy Elegance Tabletops";
	String adText2 = "Inexpensive blooms turned into platinum wedding flowers.15% off now!";
	
	//Accounts and campaigns
	Long accountID = 1613923L;
	Long campaignID = 120123568L;
	Long adGroupID = 728133376L;	
	Long addID1 = 907897094L; 
	Long addID2 = 907897096L;
	
	public static void main(String[] args)
	{
		
		try
		{
			MSNAdcenterServiceClientTest msn = new MSNAdcenterServiceClientTest();
			msn.createCampaign();
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void createCampaign() throws Exception{
		//Parameters to create campaign and adds
		
		//MSN service instance
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(BASEURLTEST);
						
		
		//createAccount
		SemplestString in = new SemplestString();
		in.setSemplestString(accountName);
		MsnManagementIds account = test.createAccount(in);
		logger.info("AccountID: "+account.getAccountId());	
		accountID = account.getAccountId();
		
		
		//createCampaign
		CampaignStatus cpst = null;
		campaignID = test.createCampaign(accountID,productSubcategory, BudgetLimitType.DailyBudgetStandard, (msnMonthlyBudget/4), msnMonthlyBudget, cpst.Paused);
		logger.info("campaignID: "+campaignID);	
		//createAdGroup
		adGroupID = test.createAdGroup(accountID, campaignID);
		logger.info("adGroupID: "+adGroupID);	
		//createAds
		addID1 = test.createAd(accountID, adGroupID, adTitle1, adText1, url, url);
		addID2 = test.createAd(accountID, adGroupID, adTitle2, adText2, url, url);
		logger.info("adID1: "+addID1);	
		logger.info("adID2: "+addID2);
	}
	
}
