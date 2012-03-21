package semplest.services.client.interfaces;

import com.google.api.adwords.v201109.cm.AdGroupStatus;
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
	public abstract boolean addTextAd(String accountID, Long addGroupID, String headline, String description1, String description2, String displayURL, String url) throws Exception;
	//optimization (o)
	
	//Account Management API Usage
	
	//Utility
}
