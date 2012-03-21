package semplest.service.google.adwords;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;

import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.lib.AdWordsServiceLogger;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.utils.MapUtils;
import com.google.api.adwords.v201109.cm.AdGroup;
import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupAdOperation;
import com.google.api.adwords.v201109.cm.AdGroupAdReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupAdServiceInterface;
import com.google.api.adwords.v201109.cm.AdGroupOperation;
import com.google.api.adwords.v201109.cm.AdGroupReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupServiceInterface;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetDeliveryMethod;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignOperation;
import com.google.api.adwords.v201109.cm.CampaignReturnValue;
import com.google.api.adwords.v201109.cm.CampaignServiceInterface;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.ManualCPC;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.cm.Operator;
import com.google.api.adwords.v201109.cm.Paging;
import com.google.api.adwords.v201109.cm.TextAd;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.api.adwords.v201109.mcm.CreateAccountOperation;
import com.google.api.adwords.v201109.mcm.CreateAccountServiceInterface;
import com.google.api.adwords.v201109.o.Attribute;
import com.google.api.adwords.v201109.o.BulkOpportunityPage;
import com.google.api.adwords.v201109.o.BulkOpportunitySelector;
import com.google.api.adwords.v201109.o.BulkOpportunityServiceInterface;
import com.google.api.adwords.v201109.o.IntegerAttribute;
import com.google.api.adwords.v201109.o.KeywordAttribute;
import com.google.api.adwords.v201109.o.LongAttribute;
import com.google.api.adwords.v201109.o.Opportunity;
import com.google.api.adwords.v201109.o.OpportunityAttributeType;
import com.google.api.adwords.v201109.o.OpportunityIdea;
import com.google.api.adwords.v201109.o.OpportunityIdeaType;
import com.google.api.adwords.v201109.o.OpportunityIdeaTypeAttribute;
import com.google.gson.Gson;

public class GoogleAdwordsServiceImpl implements GoogleAdwordsServiceInterface
{
	private static final Logger logger = Logger.getLogger(GoogleAdwordsServiceImpl.class);
	private static Gson gson = new Gson();
	// THis needs to be read from the Database
	private static String email = "adwords@semplest.com";
	private static String password = "ic0system";
	private static String userAgent = "Icosystem";
	private static String developerToken = "2H8l6aUm6K_Q44vDvxs3Og";
	private static boolean useSandbox = true;

	public String CreateOneAccountService(String json) throws Exception
	{
		logger.debug("call CreateOneAccountService(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class); // protocolJson.getHashMapFromJson(json);
		Account account = CreateOneAccountService(data.get("currencyCode"), data.get("dateTimeZone"), data.get("companyName"),
				data.get("descriptiveName"));
		// convert result to Json String
		return gson.toJson(account);
	}

	@Override
	public Account CreateOneAccountService(String currencyCode, String dateTimeZone, String companyName, String descriptiveName) throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
		// Get the AccountService.
		CreateAccountServiceInterface createAccountService = user.getService(AdWordsService.V201109.CREATE_ACCOUNT_SERVICE);
		// Create account.
		Account account = new Account();
		if (currencyCode == null)
		{
			currencyCode = "USD";
		}
		if (dateTimeZone == null)
		{
			dateTimeZone = "America/New_York";
		}
		account.setCurrencyCode(currencyCode);
		account.setDateTimeZone(dateTimeZone);
		account.setCompanyName(companyName);
		// Create operations.
		CreateAccountOperation operation = new CreateAccountOperation();
		operation.setOperand(account);
		operation.setDescriptiveName(descriptiveName);
		operation.setOperator(Operator.ADD);

		CreateAccountOperation[] operations = new CreateAccountOperation[]
		{ operation };
		// Add account.
		Account[] result = createAccountService.mutate(operations);
		// Display accounts.
		return result[0];

	}

	public String CreateOneCampaignForAccount(String json) throws Exception
	{
		logger.debug("call CreateOneAccountService(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Money budget = new Money(null, Long.parseLong(data.get("budgetAmount"))); // set
																					// MicroAmount
		Campaign campaign = CreateOneCampaignForAccount(data.get("accountID"), data.get("campaignName"),
				CampaignStatus.fromString(data.get("campaignStatus")), BudgetBudgetPeriod.fromString(data.get("period")), budget);
		// convert result to Json String
		return gson.toJson(campaign);
	}

	@Override
	public Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period,
			Money budgetAmount) throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);

		CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);
		Campaign campaign = new Campaign();
		campaign.setName(campaignName);
		if (campaignStatus == null)
		{
			campaignStatus = CampaignStatus.PAUSED;
		}
		campaign.setStatus(campaignStatus);
		campaign.setBiddingStrategy(new ManualCPC());

		Budget budget = new Budget();
		if (period == null)
		{
			period = BudgetBudgetPeriod.MONTHLY;
		}
		budget.setPeriod(period);
		budget.setAmount(budgetAmount);
		budget.setDeliveryMethod(BudgetBudgetDeliveryMethod.STANDARD);
		campaign.setBudget(budget);

		CampaignOperation Coperation = new CampaignOperation();
		Coperation.setOperand(campaign);

		Coperation.setOperator(Operator.ADD);
		CampaignOperation[] Coperations = new CampaignOperation[]
		{ Coperation };

		CampaignReturnValue Cresult = campaignService.mutate(Coperations);

		if (Cresult != null && Cresult.getValue() != null)
		{
			return Cresult.getValue()[0];
		}
		else
		{
			System.out.println("No campaigns were added.");
			return null;
		}
	}
	public String AddAdGroup(String json) throws Exception
	{
		logger.debug("call AddAdGroup" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = AddAdGroup(data.get("accountID"),campaignID, data.get("AdGroupName"), AdGroupStatus.fromString(data.get("status")));
		// convert result to Json String
		return gson.toJson(adGroupID);
	}
	@Override
	public Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status) throws Exception
	{     
		AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);    
		// Get the AdGroupService.        
		AdGroupServiceInterface adGroupService = user.getService(AdWordsService.V201109.ADGROUP_SERVICE);          
		long campaignId = campaignID;          
		// Create ad group.       
		AdGroup adGroup = new AdGroup();        
		adGroup.setName(AdGroupName);        
		adGroup.setStatus(status);        
		adGroup.setCampaignId(campaignId);                 
		// Create operations.        
		AdGroupOperation operation = new AdGroupOperation();        
		operation.setOperand(adGroup);       
		operation.setOperator(Operator.ADD);         
		AdGroupOperation[] operations = new AdGroupOperation[]{operation};          
		// Add ad group.       
		AdGroupReturnValue result = adGroupService.mutate(operations);  
		if (result != null && result.getValue() != null)
		{
			return result.getValue()[0].getId();
		}
		else
		{
			return null;
		}
	}

	public String addTextAd(String json) throws Exception
	{
		logger.debug("call addTextAd" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long addGroupID = Long.parseLong(data.get("addGroupID")); 
		Boolean res = addTextAd(data.get("accountID"),addGroupID, data.get("headline"),data.get("description1"),data.get("description2"),data.get("displayURL"),data.get("url"));
		// convert result to Json String
		return gson.toJson(res);
	}
	@Override
	public boolean addTextAd(String accountID, Long addGroupID, String headline, String description1, String description2, String displayURL, String url) throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);          
		// Get the AdGroupAdService.        
		AdGroupAdServiceInterface adGroupAdService =  user.getService(AdWordsService.V201109.ADGROUP_AD_SERVICE);          
		long adGroupId = addGroupID;                 
		// Create text ad.        
		TextAd textAd = new TextAd();        
		textAd.setHeadline(headline);        
		textAd.setDescription1(description1);        
		textAd.setDescription2(description2);        
		textAd.setDisplayUrl(displayURL);        
		textAd.setUrl(url);          
		// Create ad group ad.        
		AdGroupAd textAdGroupAd = new AdGroupAd();        
		textAdGroupAd.setAdGroupId(adGroupId);        
		textAdGroupAd.setAd(textAd); 
		// Create operations.       
		AdGroupAdOperation textAdGroupAdOperation = new AdGroupAdOperation();        
		textAdGroupAdOperation.setOperand(textAdGroupAd);        
		textAdGroupAdOperation.setOperator(Operator.ADD);  

		AdGroupAdOperation[] operations = new AdGroupAdOperation[] {textAdGroupAdOperation};
		AdGroupAdReturnValue result = adGroupAdService.mutate(operations);  
		if (result != null && result.getValue() != null)
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public static void main(String[] args)
	{
		try
		{
			// Log SOAP XML request and response.
			AdWordsServiceLogger.log();
			// Get AdWordsUser from "~/adwords.properties".
			AdWordsUser user = new AdWordsUser(email, password, "6048920973", userAgent, developerToken, useSandbox);
			// Get the BulkOpportunityService.
			BulkOpportunityServiceInterface service = user.getService(AdWordsService.V201109.BULK_OPPORTUNITY_SERVICE);
			// Create selector.
			BulkOpportunitySelector selector = new BulkOpportunitySelector();
			selector.setRequestedAttributeTypes(new OpportunityAttributeType[]
			{ OpportunityAttributeType.ADGROUP_ID, OpportunityAttributeType.AVERAGE_MONTHLY_SEARCHES, OpportunityAttributeType.CAMPAIGN_ID,
					OpportunityAttributeType.IDEA_TYPE, OpportunityAttributeType.KEYWORD });
			selector.setIdeaTypes(new OpportunityIdeaType[]
			{ OpportunityIdeaType.KEYWORD });
			// Set selector paging.
			Paging paging = new Paging();
			paging.setStartIndex(0);
			paging.setNumberResults(10);
			selector.setPaging(paging);
			// Get keyword opportunities.
			BulkOpportunityPage page = service.get(selector);
			// Display related keyword opportunities.
			if (page != null && page.getEntries() != null)
			{
				for (Opportunity entry : page.getEntries())
				{
					for (OpportunityIdea idea : entry.getOpportunityIdeas())
					{
						Map<OpportunityAttributeType, Attribute> data = MapUtils.toMap(idea.getData());
						OpportunityIdeaType ideaType = ((OpportunityIdeaTypeAttribute) data.get(OpportunityAttributeType.IDEA_TYPE)).getValue();
						String keywordText = ((KeywordAttribute) data.get(OpportunityAttributeType.KEYWORD)).getValue().getText();
						Long campaignId = ((LongAttribute) data.get(OpportunityAttributeType.CAMPAIGN_ID)).getValue();
						Long adGroupId = ((LongAttribute) data.get(OpportunityAttributeType.ADGROUP_ID)).getValue();
						Integer averageMonthlySearches = ((IntegerAttribute) data.get(OpportunityAttributeType.AVERAGE_MONTHLY_SEARCHES)).getValue();
						System.out.printf("%s opportunity for Campaign %d and AdGroup %d:" + " %s with %d average monthly searches\n", ideaType,
								campaignId, adGroupId, keywordText, averageMonthlySearches);
					}
				}
			}
			else
			{
				System.out.println("No keyword opportunities were found.");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
