package semplest.test.unittest;

import java.util.ArrayList;
import java.util.HashMap;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;

import semplest.other.Money;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidSimulatorObject;
import semplest.server.protocol.adengine.BidSimulatorObject.BidPoint;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.api.GoogleAdwordsServiceClient;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;

import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.mcm.Account;

public class GoogleServiceTest {
	
	GoogleAdwordsServiceImpl test = new GoogleAdwordsServiceImpl();
	
	private int errorCounter = 0;
	private int sleepTime = 100;
	
	private String accountID = "7250251887";	
	
	
	public static void main(String[] args){
		GoogleServiceTest t = new GoogleServiceTest();
		//int ret = t.Test_CreateOneAccountService();
		//t.cleanUp();
	}
	
	public int Test_getReportForAccount(){
		//getReportForAccount
		System.out.println("------------------------------------------------------------");
		System.out.println("getReportForAccount:");		
		try{
			ReportObject[] ret = test.getReportForAccount(new SemplestString().toSemplestString(accountID));
			System.out.println("OK");	
			for(ReportObject r : ret){
				System.out.println("->");										
				System.out.println("AccountID = " + r.getAccountID());
				System.out.println("keyword = " + r.getKeyword());
				System.out.println("ApprovalStatus = " + r.getApprovalStatus());		
				System.out.println("BidMatchType = " + r.getBidMatchType());
				System.out.println("AverageCPC = " + r.getAverageCPC());
				System.out.println("AveragePosition = " + r.getAveragePosition());
				System.out.println("CampaignID = " + r.getCampaignID());
				System.out.println("FirstPageCPC = " + r.getFirstPageCPC());
				System.out.println("MicroBidAmount = " + r.getMicroBidAmount());
				System.out.println("MicroCost = " + r.getMicroCost());
				System.out.println("NumberClick = " + r.getNumberClick());
				System.out.println("NumberImpressions = " + r.getNumberImpressions());
				System.out.println("QualityScore = " + r.getQualityScore());
				System.out.println("CreatedDate = " + r.getCreatedDate());
				System.out.println("TransactionDate = " + r.getTransactionDate());
			}
		}
		catch(Exception e){
			errorHandler(e);
			return 1;
		}
		return 0;
	}
	
	public int Test_CreateOneAccountService(){
		//CreateOneAccountService
		System.out.println("------------------------------------------------------------");
		System.out.println("getAccountById:");		
		try{
			Account acc = test.CreateOneAccountService(null, null, "semplest_unit_test", "semplest_unit_test");
			System.out.println("OK");	
			System.out.println("accountId = " + acc.getCustomerId()
					+ "; Login = " + acc.getLogin());
		}
		catch(Exception e){
			errorHandler(e);
			return 1;
		}
		return 0;
	}
	
	public int Test_GoogleService_Standalone(){		
		
		GoogleAdwordsServiceImpl test = new GoogleAdwordsServiceImpl();
		errorCounter = 0;
		
		try{
			String now = String.valueOf(System.currentTimeMillis());
			Long campaignID = 0L;
			Long adGroupID = 0L;
			Long AdID = 0L;
			Long keywordID = 0L;
		
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                        Google Service Test (Standalone)                          #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");						
			
			//CreateOneCampaignForAccount
			System.out.println("------------------------------------------------------------");
			System.out.println("CreateOneCampaignForAccount:");		
			try{
				String campaignName = "test_" + now;
				Campaign cpn = test.CreateOneCampaignForAccount(accountID, campaignName, CampaignStatus.PAUSED, BudgetBudgetPeriod.DAILY, new Money(10000000L));
				System.out.println("OK");	
				System.out.println("campaignId = " + cpn.getId());
				System.out.println("campaign name = " + cpn.getName());
				
				campaignID = cpn.getId();
			}
			catch(Exception e){
				errorHandler(e);
			}		
			Thread.sleep(sleepTime);
			
			//deleteCampaign
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteCampaign:");		
			try{
				String campaignName = "temp_" + now;
				Campaign cpn1 = test.CreateOneCampaignForAccount(accountID, campaignName, CampaignStatus.PAUSED, BudgetBudgetPeriod.DAILY, new Money(2050000L));
				System.out.println("created a temp campaign " + cpn1.getId() + ", and we'll delete it now.");
				boolean ret = test.deleteCampaign(accountID, cpn1.getId());
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//changeCampaignStatus
			System.out.println("------------------------------------------------------------");
			System.out.println("changeCampaignStatus:");		
			try{
				boolean ret = test.changeCampaignStatus(accountID, campaignID, CampaignStatus.ACTIVE);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//changeCampaignBudget
			System.out.println("------------------------------------------------------------");
			System.out.println("changeCampaignBudget:");		
			try{
				boolean ret = test.changeCampaignBudget(accountID, campaignID, new Money(10550000L));
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//UpdateCampaignName
			System.out.println("------------------------------------------------------------");
			System.out.println("UpdateCampaignName:");		
			try{
				String campaignName = "update_" + now;
				boolean ret = test.UpdateCampaignName(accountID, campaignID, campaignName);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getCampaignsByAccountId
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignsByAccountId:");		
			try{
				ArrayList<HashMap<String, String>> ret = test.getCampaignsByAccountId(accountID, false);
				System.out.println("OK");	
				for(HashMap<String, String> map : ret){
					System.out.println("campaignId = " + map.get("Id"));
				}				
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//AddAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("AddAdGroup:");		
			try{
				String AdGroupName = "test_" + now;
				adGroupID = test.AddAdGroup(accountID, campaignID, AdGroupName, AdGroupStatus.PAUSED);
				System.out.println("OK");	
				System.out.println("adGroupId = " + adGroupID);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//addTextAd
			System.out.println("------------------------------------------------------------");
			System.out.println("addTextAd:");		
			try{
				String headline = "test_" + now;
				AdID = test.addTextAd(accountID, adGroupID, headline, "unit test", "standalone", "http://www.semplest.com", "http://www.semplest.com");
				System.out.println("OK");	
				System.out.println("adId = " + AdID);
			}
			catch(Exception e){
				errorHandler(e);
			}	
			Thread.sleep(sleepTime);
			
			//getAdGroupsByCampaignId
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupsByCampaignId:");		
			try{
				GoogleAdGroupObject[] adGrps = test.getAdGroupsByCampaignId(accountID, campaignID, false);
				System.out.println("OK");	
				for(GoogleAdGroupObject a : adGrps){
					System.out.println("adGroupId = " + a.getAdGroupID());
				}				
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//updateAD
			System.out.println("------------------------------------------------------------");
			System.out.println("updateAD:");		
			try{
				boolean ret = test.updateAD(accountID, adGroupID, AdID, "update headline", "updateAD", "unit test", "http://www.google.com", "http://www.gmail.com");
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//deleteAD
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAD:");		
			try{
				boolean ret = test.deleteAD(accountID, adGroupID, AdID);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//deleteAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdGroup:");		
			try{
				Long tempAdGroup = test.AddAdGroup(accountID, campaignID, "temp", AdGroupStatus.PAUSED);
				System.out.println("created a temp adGroup " + tempAdGroup + ", and we'll delete it now.");
				boolean ret = test.deleteAdGroup(accountID, tempAdGroup);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//GetRelatedKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("GetRelatedKeywords:");		
			try{
				GoogleRelatedKeywordObject keywords = test.GetRelatedKeywords("wedding", KeywordMatchType.BROAD, 10);
				System.out.println("OK");	
				for(String s : keywords.getKeywords()){
					System.out.println("keyword = " + s);
				}				
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//GetRelatedKeywordsForURL
			System.out.println("------------------------------------------------------------");
			System.out.println("GetRelatedKeywordsForURL:");		
			try{
				GoogleRelatedKeywordObject keywords = test.GetRelatedKeywordsForURL("http://www.theknot.com/", "wedding", KeywordMatchType.BROAD, 10);
				System.out.println("OK");	
				for(String s : keywords.getKeywords()){
					System.out.println("keyword = " + s);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getAllAdGroupKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("getAllAdGroupKeywords:");		
			try{
				String[] keywords = test.getAllAdGroupKeywords(accountID, adGroupID, true);
				System.out.println("OK");	
				for(String s : keywords){
					System.out.println("keyword = " + s);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getAllBiddableAdGroupCriteria
			System.out.println("------------------------------------------------------------");
			System.out.println("getAllBiddableAdGroupCriteria:");		
			try{
				KeywordDataObject[] ret = test.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);
				System.out.println("OK");	
				for(KeywordDataObject k : ret){
					System.out.println("->");
					System.out.println("keyword = " + k.getKeyword());
					System.out.println("MicroBidAmount = " + k.getMicroBidAmount());
					System.out.println("FirstPageCpc = " + k.getFirstPageCpc());
					System.out.println("QualityScore = " + k.getQualityScore());
					System.out.println("ApprovalStatus = " + k.getApprovalStatus());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//addKeyWordToAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("addKeyWordToAdGroup:");		
			try{
				KeywordDataObject k = test.addKeyWordToAdGroup(accountID, adGroupID, "wedding", KeywordMatchType.BROAD, 2150000L);
				System.out.println("OK");	
				System.out.println("keywordId = " + k.getBidID());
				System.out.println("keyword = " + k.getKeyword());
				System.out.println("MicroBidAmount = " + k.getMicroBidAmount());
				System.out.println("FirstPageCpc = " + k.getFirstPageCpc());
				System.out.println("QualityScore = " + k.getQualityScore());
				System.out.println("ApprovalStatus = " + k.getApprovalStatus());		
				
				keywordID = k.getBidID();
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//setBidForKeyWord
			System.out.println("------------------------------------------------------------");
			System.out.println("setBidForKeyWord:");		
			try{
				KeywordDataObject k = test.setBidForKeyWord(accountID, keywordID, adGroupID, 3500000L);
				System.out.println("OK");	
				System.out.println("keywordId = " + k.getBidID());
				System.out.println("keyword = " + k.getKeyword());
				System.out.println("MicroBidAmount = " + k.getMicroBidAmount());
				System.out.println("FirstPageCpc = " + k.getFirstPageCpc());
				System.out.println("QualityScore = " + k.getQualityScore());
				System.out.println("ApprovalStatus = " + k.getApprovalStatus());			
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getTrafficEstimationForKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("getTrafficEstimationForKeywords:");		
			try{
				HashMap<String, Long> KeywordWithBid = new HashMap<String, Long>();
				KeywordWithBid.put("wedding", 2300000L);
				KeywordWithBid.put("bridal", 3400000L);
				KeywordWithBid.put("flower", 4500000L);
				TrafficEstimatorObject ret = test.getTrafficEstimationForKeywords(accountID,campaignID, KeywordMatchType.BROAD, KeywordWithBid);
				System.out.println("OK");	
				for(String s:ret.getListOfKeywords()){
					System.out.println("keyword = " + s);
					for(Long b:ret.getBidList(s, MatchType.Broad.getValue())){
						System.out.println("bidAmount = " + b);
						System.out.println("AveClickPerDay = " + ret.getAveClickPerDay(s, MatchType.Broad.getValue(), b));
						System.out.println("AveCPC = " + ret.getAveCPC(s, MatchType.Broad.getValue(), b));
						System.out.println("AvePosition = " + ret.getAvePosition(s, MatchType.Broad.getValue(), b));
						System.out.println("AveTotalDailyMicroCost = " + ret.getAveTotalDailyMicroCost(s, MatchType.Broad.getValue(), b));
					}
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getBidLandscapeForKeyword
			System.out.println("------------------------------------------------------------");
			System.out.println("getBidLandscapeForKeyword:");		
			try{
				BidSimulatorObject[] ret = test.getBidLandscapeForKeyword(accountID, adGroupID, keywordID);
				System.out.println("OK");	
				for(BidSimulatorObject b : ret){
					System.out.println("->");										
					System.out.println("AdGroupId = " + b.getAdGroupId());
					System.out.println("CriterionId = " + b.getCriterionId());
					System.out.println("StartDate = " + b.getStartDate());		
					System.out.println("EndDate = " + b.getEndDate());
					BidPoint bp = b.getBidPoint(1230000L);
					System.out.println("BidPoint -- " 
							+ "bid =" + bp.getBid()
							+ "; clicks =" + bp.getClicks()
							+ "; impression =" + bp.getImpressions()
							+ "; cost =" + bp.getCost()
							+ "; marginalcpc =" + bp.getMarginalCpc()
							);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getBidLandscapeForAdgroup
			System.out.println("------------------------------------------------------------");
			System.out.println("getBidLandscapeForAdgroup:");		
			try{
				BidSimulatorObject[] ret = test.getBidLandscapeForAdgroup(accountID, adGroupID);
				System.out.println("OK");	
				for(BidSimulatorObject b : ret){
					System.out.println("->");										
					System.out.println("AdGroupId = " + b.getAdGroupId());
					System.out.println("CriterionId = " + b.getCriterionId());
					System.out.println("StartDate = " + b.getStartDate());		
					System.out.println("EndDate = " + b.getEndDate());
					BidPoint bp = b.getBidPoint(1230000L);
					System.out.println("BidPoint -- " 
							+ "bid =" + bp.getBid()
							+ "; clicks =" + bp.getClicks()
							+ "; impression =" + bp.getImpressions()
							+ "; cost =" + bp.getCost()
							+ "; marginalcpc =" + bp.getMarginalCpc()
							);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getAllAdGroupCriteria
			System.out.println("------------------------------------------------------------");
			System.out.println("getAllAdGroupCriteria:");		
			try{
				AdGroupCriterion[] ret = test.getAllAdGroupCriteria(accountID, adGroupID, true);
				System.out.println("OK");	
				for(AdGroupCriterion a : ret){
					System.out.println("->");										
					System.out.println("AdGroupId = " + a.getAdGroupId());
					System.out.println("AdGroupCriterionType = " + a.getAdGroupCriterionType());
					System.out.println("CriterionId = " + a.getCriterion().getId());		
					System.out.println("CriterionType = " + a.getCriterion().getCriterionType());
					System.out.println("CriterionUse = " + a.getCriterionUse().getValue());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getReportForAccount
			System.out.println("------------------------------------------------------------");
			System.out.println("getReportForAccount:");		
			try{
				ReportObject[] ret = test.getReportForAccount(new SemplestString().toSemplestString(accountID));
				System.out.println("OK");	
				for(ReportObject r : ret){
					System.out.println("->");										
					System.out.println("AccountID = " + r.getAccountID());
					System.out.println("keyword = " + r.getKeyword());
					System.out.println("ApprovalStatus = " + r.getApprovalStatus());		
					System.out.println("BidMatchType = " + r.getBidMatchType());
					System.out.println("AverageCPC = " + r.getAverageCPC());
					System.out.println("AveragePosition = " + r.getAveragePosition());
					System.out.println("CampaignID = " + r.getCampaignID());
					System.out.println("FirstPageCPC = " + r.getFirstPageCPC());
					System.out.println("MicroBidAmount = " + r.getMicroBidAmount());
					System.out.println("MicroCost = " + r.getMicroCost());
					System.out.println("NumberClick = " + r.getNumberClick());
					System.out.println("NumberImpressions = " + r.getNumberImpressions());
					System.out.println("QualityScore = " + r.getQualityScore());
					System.out.println("CreatedDate = " + r.getCreatedDate());
					System.out.println("TransactionDate = " + r.getTransactionDate());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			
			//---Methods not ready. to be implemented.
			//addAccountBudget
			//getClientAccounts
			//getAccountBudgets
			//updateAccountBudget
			//getAdsByAdGroupId
			//addAccountBudget
			//updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			cleanUp();
		}
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                    Google Service Test (Standalone) FAILED!                      #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                    Google Service Test (Standalone) PASSED!                      #");
			System.out.println("####################################################################################");
		}
		
		return errorCounter;
		
	}
	
	public int Test_GoogleService_Service(){		
		
		GoogleAdwordsServiceClient test = new GoogleAdwordsServiceClient(null);
		
		errorCounter = 0;
		
		try{
			String now = String.valueOf(System.currentTimeMillis());
			Long campaignID = 0L;
			Long adGroupID = 0L;
			Long AdID = 0L;
			Long keywordID = 0L;
		
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                         Google Service Test (Service)                            #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");						
			
			//CreateOneCampaignForAccount
			System.out.println("------------------------------------------------------------");
			System.out.println("CreateOneCampaignForAccount:");		
			try{
				String campaignName = "test_" + now;
				Campaign cpn = test.CreateOneCampaignForAccount(accountID, campaignName, CampaignStatus.PAUSED, BudgetBudgetPeriod.DAILY, new Money(10000000L));
				System.out.println("OK");	
				System.out.println("campaignId = " + cpn.getId());
				System.out.println("campaign name = " + cpn.getName());
				
				campaignID = cpn.getId();
			}
			catch(Exception e){
				errorHandler(e);
			}		
			Thread.sleep(sleepTime);
			
			//deleteCampaign
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteCampaign:");		
			try{
				String campaignName = "temp_" + now;
				Campaign cpn1 = test.CreateOneCampaignForAccount(accountID, campaignName, CampaignStatus.PAUSED, BudgetBudgetPeriod.DAILY, new Money(2050000L));
				System.out.println("created a temp campaign " + cpn1.getId() + ", and we'll delete it now.");
				boolean ret = test.deleteCampaign(accountID, cpn1.getId());
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//changeCampaignStatus
			System.out.println("------------------------------------------------------------");
			System.out.println("changeCampaignStatus:");		
			try{
				boolean ret = test.changeCampaignStatus(accountID, campaignID, CampaignStatus.ACTIVE);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//changeCampaignBudget
			System.out.println("------------------------------------------------------------");
			System.out.println("changeCampaignBudget:");		
			try{
				boolean ret = test.changeCampaignBudget(accountID, campaignID, new Money(10550000L));
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//UpdateCampaignName
			System.out.println("------------------------------------------------------------");
			System.out.println("UpdateCampaignName:");		
			try{
				String campaignName = "update_" + now;
				boolean ret = test.UpdateCampaignName(accountID, campaignID, campaignName);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getCampaignsByAccountId
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignsByAccountId:");		
			try{
				ArrayList<HashMap<String, String>> ret = test.getCampaignsByAccountId(accountID, false);
				System.out.println("OK");	
				for(HashMap<String, String> map : ret){
					System.out.println("campaignId = " + map.get("Id"));
				}				
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//AddAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("AddAdGroup:");		
			try{
				String AdGroupName = "test_" + now;
				adGroupID = test.AddAdGroup(accountID, campaignID, AdGroupName, AdGroupStatus.PAUSED);
				System.out.println("OK");	
				System.out.println("adGroupId = " + adGroupID);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//addTextAd
			System.out.println("------------------------------------------------------------");
			System.out.println("addTextAd:");		
			try{
				String headline = "test_" + now;
				AdID = test.addTextAd(accountID, adGroupID, headline, "unit test", "standalone", "http://www.semplest.com", "http://www.semplest.com");
				System.out.println("OK");	
				System.out.println("adId = " + AdID);
			}
			catch(Exception e){
				errorHandler(e);
			}	
			Thread.sleep(sleepTime);
			
			//getAdGroupsByCampaignId
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupsByCampaignId:");		
			try{
				GoogleAdGroupObject[] adGrps = test.getAdGroupsByCampaignId(accountID, campaignID, false);
				System.out.println("OK");	
				for(GoogleAdGroupObject a : adGrps){
					System.out.println("adGroupId = " + a.getAdGroupID());
				}				
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//updateAD
			System.out.println("------------------------------------------------------------");
			System.out.println("updateAD:");		
			try{
				boolean ret = test.updateAD(accountID, adGroupID, AdID, "update headline", "updateAD", "unit test", "http://www.google.com", "http://www.gmail.com");
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//deleteAD
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAD:");		
			try{
				boolean ret = test.deleteAD(accountID, adGroupID, AdID);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//deleteAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdGroup:");		
			try{
				Long tempAdGroup = test.AddAdGroup(accountID, campaignID, "temp", AdGroupStatus.PAUSED);
				System.out.println("created a temp adGroup " + tempAdGroup + ", and we'll delete it now.");
				boolean ret = test.deleteAdGroup(accountID, tempAdGroup);
				System.out.println("OK");	
				System.out.println("successful = " + ret);
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//GetRelatedKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("GetRelatedKeywords:");		
			try{
				GoogleRelatedKeywordObject keywords = test.GetRelatedKeywords("wedding", KeywordMatchType.BROAD, 10);
				System.out.println("OK");	
				for(String s : keywords.getKeywords()){
					System.out.println("keyword = " + s);
				}				
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//GetRelatedKeywordsForURL
			System.out.println("------------------------------------------------------------");
			System.out.println("GetRelatedKeywordsForURL:");		
			try{
				GoogleRelatedKeywordObject keywords = test.GetRelatedKeywordsForURL("http://www.theknot.com/", "wedding", KeywordMatchType.BROAD, 10);
				System.out.println("OK");	
				for(String s : keywords.getKeywords()){
					System.out.println("keyword = " + s);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getAllAdGroupKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("getAllAdGroupKeywords:");		
			try{
				String[] keywords = test.getAllAdGroupKeywords(accountID, adGroupID, true);
				System.out.println("OK");	
				for(String s : keywords){
					System.out.println("keyword = " + s);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getAllBiddableAdGroupCriteria
			System.out.println("------------------------------------------------------------");
			System.out.println("getAllBiddableAdGroupCriteria:");		
			try{
				KeywordDataObject[] ret = test.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);
				System.out.println("OK");	
				for(KeywordDataObject k : ret){
					System.out.println("->");
					System.out.println("keyword = " + k.getKeyword());
					System.out.println("MicroBidAmount = " + k.getMicroBidAmount());
					System.out.println("FirstPageCpc = " + k.getFirstPageCpc());
					System.out.println("QualityScore = " + k.getQualityScore());
					System.out.println("ApprovalStatus = " + k.getApprovalStatus());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//addKeyWordToAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("addKeyWordToAdGroup:");		
			try{
				KeywordDataObject k = test.addKeyWordToAdGroup(accountID, adGroupID, "wedding", KeywordMatchType.BROAD, 2150000L);
				System.out.println("OK");	
				System.out.println("keywordId = " + k.getBidID());
				System.out.println("keyword = " + k.getKeyword());
				System.out.println("MicroBidAmount = " + k.getMicroBidAmount());
				System.out.println("FirstPageCpc = " + k.getFirstPageCpc());
				System.out.println("QualityScore = " + k.getQualityScore());
				System.out.println("ApprovalStatus = " + k.getApprovalStatus());		
				
				keywordID = k.getBidID();
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//setBidForKeyWord
			System.out.println("------------------------------------------------------------");
			System.out.println("setBidForKeyWord:");		
			try{
				KeywordDataObject k = test.setBidForKeyWord(accountID, keywordID, adGroupID, 3500000L);
				System.out.println("OK");	
				System.out.println("keywordId = " + k.getBidID());
				System.out.println("keyword = " + k.getKeyword());
				System.out.println("MicroBidAmount = " + k.getMicroBidAmount());
				System.out.println("FirstPageCpc = " + k.getFirstPageCpc());
				System.out.println("QualityScore = " + k.getQualityScore());
				System.out.println("ApprovalStatus = " + k.getApprovalStatus());			
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getTrafficEstimationForKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("getTrafficEstimationForKeywords:");		
			try{
				HashMap<String, Long> KeywordWithBid = new HashMap<String, Long>();
				KeywordWithBid.put("wedding", 2300000L);
				KeywordWithBid.put("bridal", 3400000L);
				KeywordWithBid.put("flower", 4500000L);
				TrafficEstimatorObject ret = test.getTrafficEstimationForKeywords(accountID,campaignID, KeywordMatchType.BROAD, KeywordWithBid);
				System.out.println("OK");	
				for(String s:ret.getListOfKeywords()){
					System.out.println("keyword = " + s);
					for(Long b:ret.getBidList(s, MatchType.Broad.getValue())){
						System.out.println("bidAmount = " + b);
						System.out.println("AveClickPerDay = " + ret.getAveClickPerDay(s, MatchType.Broad.getValue(), b));
						System.out.println("AveCPC = " + ret.getAveCPC(s, MatchType.Broad.getValue(), b));
						System.out.println("AvePosition = " + ret.getAvePosition(s, MatchType.Broad.getValue(), b));
						System.out.println("AveTotalDailyMicroCost = " + ret.getAveTotalDailyMicroCost(s, MatchType.Broad.getValue(), b));
					}
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getBidLandscapeForKeyword
			System.out.println("------------------------------------------------------------");
			System.out.println("getBidLandscapeForKeyword:");		
			try{
				BidSimulatorObject[] ret = test.getBidLandscapeForKeyword(accountID, adGroupID, keywordID);
				System.out.println("OK");	
				for(BidSimulatorObject b : ret){
					System.out.println("->");										
					System.out.println("AdGroupId = " + b.getAdGroupId());
					System.out.println("CriterionId = " + b.getCriterionId());
					System.out.println("StartDate = " + b.getStartDate());		
					System.out.println("EndDate = " + b.getEndDate());
					BidPoint bp = b.getBidPoint(1230000L);
					System.out.println("BidPoint -- " 
							+ "bid =" + bp.getBid()
							+ "; clicks =" + bp.getClicks()
							+ "; impression =" + bp.getImpressions()
							+ "; cost =" + bp.getCost()
							+ "; marginalcpc =" + bp.getMarginalCpc()
							);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getBidLandscapeForAdgroup
			System.out.println("------------------------------------------------------------");
			System.out.println("getBidLandscapeForAdgroup:");		
			try{
				BidSimulatorObject[] ret = test.getBidLandscapeForAdgroup(accountID, adGroupID);
				System.out.println("OK");	
				for(BidSimulatorObject b : ret){
					System.out.println("->");										
					System.out.println("AdGroupId = " + b.getAdGroupId());
					System.out.println("CriterionId = " + b.getCriterionId());
					System.out.println("StartDate = " + b.getStartDate());		
					System.out.println("EndDate = " + b.getEndDate());
					BidPoint bp = b.getBidPoint(1230000L);
					System.out.println("BidPoint -- " 
							+ "bid =" + bp.getBid()
							+ "; clicks =" + bp.getClicks()
							+ "; impression =" + bp.getImpressions()
							+ "; cost =" + bp.getCost()
							+ "; marginalcpc =" + bp.getMarginalCpc()
							);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getAllAdGroupCriteria
			System.out.println("------------------------------------------------------------");
			System.out.println("getAllAdGroupCriteria:");		
			try{
				AdGroupCriterion[] ret = test.getAllAdGroupCriteria(accountID, adGroupID, true);
				System.out.println("OK");	
				for(AdGroupCriterion a : ret){
					System.out.println("->");										
					System.out.println("AdGroupId = " + a.getAdGroupId());
					System.out.println("AdGroupCriterionType = " + a.getAdGroupCriterionType());
					System.out.println("CriterionId = " + a.getCriterion().getId());		
					System.out.println("CriterionType = " + a.getCriterion().getCriterionType());
					System.out.println("CriterionUse = " + a.getCriterionUse().getValue());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			//getReportForAccount
			System.out.println("------------------------------------------------------------");
			System.out.println("getReportForAccount:");		
			try{
				ReportObject[] ret = test.getReportForAccount(new SemplestString().toSemplestString(accountID));
				System.out.println("OK");	
				for(ReportObject r : ret){
					System.out.println("->");										
					System.out.println("AccountID = " + r.getAccountID());
					System.out.println("keyword = " + r.getKeyword());
					System.out.println("ApprovalStatus = " + r.getApprovalStatus());		
					System.out.println("BidMatchType = " + r.getBidMatchType());
					System.out.println("AverageCPC = " + r.getAverageCPC());
					System.out.println("AveragePosition = " + r.getAveragePosition());
					System.out.println("CampaignID = " + r.getCampaignID());
					System.out.println("FirstPageCPC = " + r.getFirstPageCPC());
					System.out.println("MicroBidAmount = " + r.getMicroBidAmount());
					System.out.println("MicroCost = " + r.getMicroCost());
					System.out.println("NumberClick = " + r.getNumberClick());
					System.out.println("NumberImpressions = " + r.getNumberImpressions());
					System.out.println("QualityScore = " + r.getQualityScore());
					System.out.println("CreatedDate = " + r.getCreatedDate());
					System.out.println("TransactionDate = " + r.getTransactionDate());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			Thread.sleep(sleepTime);
			
			
			//---Methods not ready. to be implemented.
			//addAccountBudget
			//getClientAccounts
			//getAccountBudgets
			//updateAccountBudget
			//getAdsByAdGroupId
			//addAccountBudget
			//updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			cleanUp();
		}
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                     Google Service Test (Service) FAILED!                        #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                     Google Service Test (Service) PASSED!                        #");
			System.out.println("####################################################################################");
		}
		
		return errorCounter;
		
	}
	
	
	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		StackTraceElement[] ste = e.getStackTrace();
		for(StackTraceElement s : ste){
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println();
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}
	
	public void cleanUp(){
		try{
			System.out.println(" ");
			System.out.println("------------------------------------------------------------");
			System.out.println("clean up and finish the test...");
			
			ArrayList<HashMap<String, String>> ret = test.getCampaignsByAccountId(accountID, true);
			for(HashMap<String, String> map : ret){
				test.deleteCampaign(accountID, Long.valueOf(map.get("Id")));
			}				
			
			System.out.println("clean up done");
		}
		catch(Exception e2){
			System.out.println("clean up failed. please inactive the campaigns manually on UI (to avoid possible charge on your account)!");
		}
	}

}
