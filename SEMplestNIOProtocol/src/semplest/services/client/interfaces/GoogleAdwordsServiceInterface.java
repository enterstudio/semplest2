package semplest.services.client.interfaces;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;

import com.google.api.adwords.v201109.cm.AdGroup;
import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BiddableAdGroupCriterion;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.mcm.Account;


/*
 * interface for Adwords API 8.5
 */
public interface GoogleAdwordsServiceInterface
{
	//management console (mcm)
	public abstract Account CreateOneAccountService(String currencyCode, String dateTimeZone,String companyName, String descriptiveName) throws Exception;
	//Campaign Data Management (cm)
	public abstract Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period,Money budgetAmount) throws Exception;
	public abstract Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status) throws Exception;
	public abstract Boolean addTextAd(String accountID, Long addGroupID, String headline, String description1, String description2, String displayURL, String url) throws Exception;
	public abstract AdGroup[] getAdGroupsByCampaignId(String customerID, Long campaignID, Boolean includeDeleted) throws Exception;
	public abstract Campaign[] getCampaignsByAccountId(String accountID, Boolean includeDeleted) throws Exception;
	
	
	public abstract void resumeCampaignById(String customerId, long campaignId) throws Exception;
	public abstract AdGroupCriterion[] getAllAdGroupCriteria(String customerId, Long adGroupId) throws Exception;
	public abstract BiddableAdGroupCriterion[] getAllBiddableAdGroupCriteria(String customerId, Long adGroupId) throws Exception;
	public abstract String[] getAllAdGroupKeywords(String customerId, Long adGroupId) throws Exception;
	//public GeoTargetList getCampaignGeoTargets(String customerId, long campaignId) throws Exception;
	//optimization (o)
	
	//Account Management API Usage
	public abstract void addAccountBudget(Money money, String customerId, String orderId) throws Exception;
	public abstract String[] getClientAccounts() throws Exception;
	public abstract Budget[] getAccountBudgets(String customerId) throws Exception;
	public abstract void updateAccountBudget(Budget budgetForUpdate, Money money, String customerId, String orderId) throws Exception;
	public abstract AdGroupAd[] getAdsByAdGroupId(String customerId, long adGroupId) throws Exception;

	
	
	//public AccountInfo getAccountInfo(String customerId) throws Exception;
	public abstract void addAccountBudget(DateTimeFloored start, DateTimeCeiling end, Money budget, String string) throws Exception;
	public abstract void updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget(Budget budgetForUpdate, DateTimeCeiling end, Money newBudgetAmount, String string) throws Exception;
	//Utility
	
	/*
	 * LEFT OUT GoogleCloudReportService and GoogleCloudBulkMutateService
	 */
}
