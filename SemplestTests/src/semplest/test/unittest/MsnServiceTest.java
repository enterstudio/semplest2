package semplest.test.unittest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.joda.time.DateTime;

import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.AdStatus;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.CityTargetBid;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.KeywordStatus;
import com.microsoft.adcenter.v8.MetroAreaTargetBid;
import com.microsoft.adcenter.v8.MobileAd;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.StateTargetBid;
import com.microsoft.adcenter.v8.Target;
import com.microsoft.adcenter.v8.TextAd;

import semplest.other.Money;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject.BidData;
import semplest.service.msn.adcenter.MsnCloudException;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.api.MSNAdcenterServiceClient;


public class MsnServiceTest {
	
	MsnCloudServiceImpl test = new MsnCloudServiceImpl();
	
	private int errorCounter = 0;
	
	public static Long accountId = 1629687L;	
	public static Long customerId = 13068662L;
	public static Long userId = 1701206L;
	
	public static String eol = System.getProperty("line.separator");
	
	private String vMsg = "Verification FAILED! ";
	
	public static void main(String args[]){
		MsnServiceTest t = new MsnServiceTest();
		t.Test_MsnServices_Standalone();
	}
	
	public int Test_MsnReport(){
		
		try{			
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                            MsnAdcenter Report Test                               #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");	
			
			//getKeywordReport
			MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
			//MsnCloudServiceImpl test = new MsnCloudServiceImpl();
			
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordReport:");
			
			DateTime firstDay = new DateTime(2012,5,1,0,0,0,0);
			DateTime lastDay = new DateTime(2012,5,17,0,0,0,0);
			Long test_accountId = 1643878L;//1617055L;
			Long test_campaignId = 110151829L;//130140291L;
			ReportObject[] ret = test.getKeywordReport(test_accountId, test_campaignId, firstDay, lastDay);			
			System.out.println("OK");
			System.out.println("test accountId is " + test_accountId);
			System.out.println("test campaignId is " + test_campaignId);
			
			if(ret == null){
				errorHandler(new Exception(vMsg + "Empty report data returned."));
			}
			else{
				//print out only the first and last transactions
				System.out.println("Num of Transactions in the report = " + ret.length);				
				System.out.println(" ");
				System.out.println("*** Print out the first transaction ***");
				ReportObject t = ret[0];
				System.out.println("Keyword = " + t.getKeyword());
				System.out.println("BidAmount = " + t.getMicroBidAmount());
				System.out.println("BidMatchType = " + t.getBidMatchType());
				System.out.println("NumberImpressions = " + t.getNumberImpressions());
				System.out.println("NumberClick = " + t.getNumberClick());
				System.out.println("AveragePosition = " + t.getAveragePosition());
				System.out.println("QualityScore = " + t.getQualityScore());
				System.out.println("AverageCPC = " + t.getAverageCPC());
				System.out.println("CreatedDate = " + t.getTransactionDate());
				System.out.println("TransactionDate = " + t.getTransactionDate());
				System.out.println(" ");
				System.out.println("*** Print out the first transaction ***");
				t = ret[ret.length-1];
				System.out.println("Keyword = " + t.getKeyword());
				System.out.println("BidAmount = " + t.getMicroBidAmount());
				System.out.println("BidMatchType = " + t.getBidMatchType());
				System.out.println("NumberImpressions = " + t.getNumberImpressions());
				System.out.println("NumberClick = " + t.getNumberClick());
				System.out.println("AveragePosition = " + t.getAveragePosition());
				System.out.println("QualityScore = " + t.getQualityScore());
				System.out.println("AverageCPC = " + t.getAverageCPC());
				System.out.println("CreatedDate = " + t.getTransactionDate());
				System.out.println("TransactionDate = " + t.getTransactionDate());
				
				/*
				for(ReportObject t: kwreport){
					System.out.println("->");
					System.out.println("Keyword = " + t.getKeyword());
					System.out.println("BidAmount = " + t.getMicroBidAmount());
					System.out.println("BidMatchType = " + t.getBidMatchType());
					System.out.println("NumberImpressions = " + t.getNumberImpressions());
					System.out.println("NumberClick = " + t.getNumberClick());
					System.out.println("AveragePosition = " + t.getAveragePosition());
					System.out.println("QualityScore = " + t.getQualityScore());
					System.out.println("AverageCPC = " + t.getAverageCPC());
					System.out.println("CreatedDate = " + t.getTransactionDate());						
				}
				*/
			}			
			
			/*
			//print out original report data -- if you need to look at the original report data that msn gives back
			String ret1 = MsnService.requestKeywordReport(1617082L, 110138069L, firstDay, lastDay, ReportAggregation.Daily);					
			//getReportData
			Map<String, String[]> ret2 = MsnService.getReportData(ret1, 1617082L);
			for(String s: ret2.keySet()){
				System.out.println(s);
				String[] data = ret2.get(s);
				for(String d: data){
					System.out.println(d);
				}
				System.out.println("=============");
			}
			*/	
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
			
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                          MsnAdcenter Report Test FAILED!                         #");
			System.out.println("####################################################################################");
			
			return 1;
		}
		
		System.out.println(" ");
		System.out.println("####################################################################################");
		System.out.println("#                          MsnAdcenter Report Test PASSED!                         #");
		System.out.println("####################################################################################");
		
		return 0;
	}
	
	public int Test_createAccount(){
		
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		try{
			System.out.println("------------------------------------------------------------");
			System.out.println("createAccount:");
			SemplestString in = new SemplestString();		
			//in.setSemplestString("s_" + System.currentTimeMillis());
			in.setSemplestString("Kpqwyuddd-Mark-s-Spo");
			System.out.println("account name = "+ in.getSemplestString());
			MsnManagementIds ret = test.createAccount(in);		
			System.out.println("OK");
			System.out.println("AccountId = "+ ret.getAccountId());
			System.out.println("CustomerId = "+ ret.getCustomerId());
			System.out.println("UserId = "+ ret.getUserId());
			
			accountId = ret.getAccountId();
			customerId = ret.getCustomerId();
			userId = ret.getUserId();
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
			
			return 1;
		}
		return 0;
	}
	
	public int Test_MsnServices_Standalone() {
		
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		errorCounter = 0;

		Long campaignId = 0L;
		Long adGroupId = 0L;
		Long adId = 0L;
		Long keywordId = 0L;
		
		String now = String.valueOf(System.currentTimeMillis());
		
		try{
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                           MsnAdcenter Test (Impl)                                #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");	
			
			//Test_createAccount();	
			
			//getAccountById			
			System.out.println("------------------------------------------------------------");
			System.out.println("getAccountById:");
			try{
				Account acc = test.getAccountById(accountId);
				System.out.println("OK");
				System.out.println("account name = " + acc.getName());
				System.out.println("account Id = " + acc.getId());
				
				//verify result
				if((acc == null) || (acc.getName() == null) || (acc.getId() == null))
					errorHandler(new Exception(vMsg + "No account data returned."));
				
			}
			catch(MsnCloudException e){
				errorHandler(e);
			}			
						
			//createCampaign
			System.out.println("------------------------------------------------------------");
			System.out.println("createCampaign:");
			try{
				Double dailyBudget1 = 1.00;
				Double monthlyBudget1 = 5.00;
				String campaignName1 = "unit_test_campaign1" + now;
				System.out.println("createCampaign(" + accountId + ", " + campaignName1 + ", " + BudgetLimitType.DailyBudgetStandard + ", " + dailyBudget1 + ", " + monthlyBudget1 + ", " + CampaignStatus.Active + ")");
				campaignId = test.createCampaign(accountId, campaignName1, BudgetLimitType.DailyBudgetStandard, dailyBudget1, monthlyBudget1, CampaignStatus.Active);
				System.out.println("OK");
				System.out.println("campaignId = " + campaignId);
				
				//verify result
				if(campaignId == 0L)
					errorHandler(new Exception(vMsg + "No campaign ID returned."));
			}
			catch(MsnCloudException e){
				errorHandler(e);
			}
			
			//getCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignById:");
			try{
				Campaign cp = test.getCampaignById(accountId, campaignId);
				System.out.println("OK");
				System.out.println("campaign name = " + cp.getName());
				System.out.println("campaign Id = " + cp.getId());
				System.out.println("budget type = " + cp.getBudgetType());
				System.out.println("daily budget = " + cp.getDailyBudget());
				System.out.println("monthly budget = " + cp.getMonthlyBudget());
				
				//verify result
				if((cp == null) || (cp.getName() == null) || (cp.getId() == null))
					errorHandler(new Exception(vMsg + "No campaign data returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getCampaignsByAccountId
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignsByAccountId:");
			try{
				Campaign[] cps = test.getCampaignsByAccountId(accountId);
				System.out.println("OK");
				for(Campaign c:cps){
					System.out.println("campaign Id = " + c.getId());
				}
				
				//verify result
				if(cps.length == 0)
					errorHandler(new Exception(vMsg + "No campaign returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//resumeCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("resumeCampaignById:");
			try{
				test.resumeCampaignById(accountId, campaignId);  //resume
				System.out.println("OK");
				Campaign cp1 = test.getCampaignById(accountId, campaignId);  //check it
				System.out.println("status = " + cp1.getStatus());
				
				//verify result
				if(!cp1.getStatus().getValue().equalsIgnoreCase(CampaignStatus.Active.getValue()))
					errorHandler(new Exception(vMsg + "Campaign is not Actived."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//pauseCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseCampaignById:");
			try{
				test.pauseCampaignById(accountId, campaignId);
				System.out.println("OK");
				Campaign cp1 = test.getCampaignById(accountId, campaignId);  //check it
				System.out.println("status = " + cp1.getStatus());
				
				//verify result
				if(!cp1.getStatus().getValue().equalsIgnoreCase(CampaignStatus.Paused.getValue()))
					errorHandler(new Exception(vMsg + "Campaign is not Paused."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//pauseCampaignsByAccountId
			//test.pauseCampaignsByAccountId(1595249L);
					
			//deleteCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteCampaignById:");
			try{
				String tempCampaignName = "temp campaign" + now;
				Long tmpId = test.createCampaign(accountId, tempCampaignName, BudgetLimitType.DailyBudgetStandard, 1.00, 5.00, CampaignStatus.Paused);
				System.out.println("created temp campaign " + tmpId + "and now delete it.");
				test.deleteCampaignById(accountId, tmpId);
				System.out.println("OK");
				
				
				//verify result
				Campaign cp = test.getCampaignById(accountId, tmpId);
				if(cp != null)
					errorHandler(new Exception(vMsg + "Campaign is not deleted."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(MsnCloudException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//updateCampaignBudget
			System.out.println("------------------------------------------------------------");
			System.out.println("updateCampaignBudget:");
			try{
				//update daily budget
				double dailyBudget = 2.00;
				System.out.println("Update Daily Budget.");
				test.updateCampaignBudget(accountId, campaignId, BudgetLimitType.DailyBudgetStandard, dailyBudget, 5.00);
				System.out.println("OK");
				Campaign ret1 = test.getCampaignById(accountId, campaignId);	
				System.out.println(ret1.getBudgetType());
				System.out.println(ret1.getDailyBudget());

				//verify result
				Campaign[] cps1 = test.getCampaignsByAccountId(accountId);
				for(Campaign c:cps1){
					if(c.getId() == campaignId)
						if(c.getDailyBudget() != dailyBudget)
							errorHandler(new Exception(vMsg + "DailyBudget isn't updated correctly. " + c.getDailyBudget() + " != " + dailyBudget));
				}
				
				//update monthly budget
				System.out.println("Update Monthly Budget.");
				double monthlyBudget = 10.00;
				test.updateCampaignBudget(accountId, campaignId, BudgetLimitType.MonthlyBudgetSpendUntilDepleted, 1.00, monthlyBudget);
				System.out.println("OK");
				Campaign ret2 = test.getCampaignById(accountId, campaignId);	
				System.out.println(ret2.getBudgetType());
				System.out.println(ret1.getMonthlyBudget());
				
				//verify result
				Campaign[] cps2 = test.getCampaignsByAccountId(accountId);
				for(Campaign c:cps2){
					if(c.getId() == campaignId)
						if(c.getMonthlyBudget() != monthlyBudget)
							errorHandler(new Exception(vMsg + "MonthlyBudget isn't updated correctly. " + c.getMonthlyBudget() + " != " + monthlyBudget));
				}
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			
			//setCampaignStateTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setCampaignStateTargets:");
			try{
				Target tgt1 = test.getCampaignTargets(accountId, customerId, campaignId); 
				if(tgt1 != null){
					//delete target if there's already one associated to the entity
					test.deleteCampaignTargets(accountId, customerId, campaignId);
				}
				String[] list = {"US-NY", "US-MA", "US-CA", "US-FL"};
				System.out.println("Set State Targets: " + list.toString());
				List<String> states = Arrays.asList(list);
				test.setCampaignStateTargets(accountId, customerId, campaignId, states);
				System.out.println("OK");
				
				//verify results
				Target tgt2 = test.getCampaignTargets(accountId, customerId, campaignId);
				StateTargetBid[] bids = tgt2.getLocation().getStateTarget().getBids();
				int c = 0;
				for(StateTargetBid b:bids){
					if(b.getState().equals("US-NY")) c++;
					if(b.getState().equals("US-MA")) c++;
					if(b.getState().equals("US-CA")) c++;
					if(b.getState().equals("US-FL")) c++;
				}
				if(c!=4)
					errorHandler(new Exception(vMsg + "State Targets are not set correctly."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//getCampaignTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignTargets:");
			try{				
				Target tgt2 = test.getCampaignTargets(accountId, customerId, campaignId);
				System.out.println("OK");
				StateTargetBid[] bids = tgt2.getLocation().getStateTarget().getBids();
				for(StateTargetBid b:bids){
					System.out.println("state = " + b.getState());
				}
				
				//verify results
				int c = 0;
				for(StateTargetBid b:bids){
					if(b.getState().equals("US-NY")) c++;
					if(b.getState().equals("US-MA")) c++;
					if(b.getState().equals("US-CA")) c++;
					if(b.getState().equals("US-FL")) c++;
				}
				if(c!=4)
					errorHandler(new Exception(vMsg + "State Targets are not got correctly."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			
			//deleteCampaignTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteCampaignTargets:");
			try{
				Target tgt3 = test.getCampaignTargets(accountId, customerId, campaignId);  //check before change
				if(tgt3!=null) System.out.println("Target is not null");
				test.deleteCampaignTargets(accountId, customerId, campaignId);
				System.out.println("OK");
				tgt3 = test.getCampaignTargets(accountId, customerId, campaignId);  //check after change
				if(tgt3==null) System.out.println("Target is null");
				
				//verify result
				if(tgt3 != null)
					errorHandler(new Exception(vMsg + "State Targets aren't deleted."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("createAdGroup:");
			try{
				adGroupId = test.createAdGroup(accountId, campaignId);
				System.out.println("OK");
				System.out.println("adGroupId = " + adGroupId);
				
				//verify result
				if(adGroupId == 0L)
					errorHandler(new Exception(vMsg + "No AdGroup ID returned."));
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdGroupsByCampaignId
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupsByCampaignId:");
			try{
				AdGroup[] adgrps = test.getAdGroupsByCampaignId(accountId, campaignId);
				System.out.println("OK");
				for(AdGroup a: adgrps){
					System.out.println("adId = " + a.getId());
				}
				
				//verify result
				if(adgrps.length == 0)
					errorHandler(new Exception(vMsg + "No AdGroup returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//getAdGroupById
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupById:");
			try{
				AdGroup adgrp = test.getAdGroupById(accountId, campaignId, adGroupId);
				System.out.println("OK");
				System.out.println("adId = " + adgrp.getId());
				
				//verify result
				if(!adgrp.getId().equals(adGroupId))
					errorHandler(new Exception(vMsg + "AdGroup data returned doesn't match. " + adgrp.getId() + " != " + adGroupId));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//deleteAdGroupById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdGroupById:");
			try{
				long adgrpid = test.createAdGroup(accountId, campaignId);  //add a group
				System.out.println("created a temp ad group id=" + adgrpid + ", and now we'll delete it.");
				test.deleteAdGroupById(1595249L, 130129414L, adgrpid);  //delete the group
				System.out.println("OK");
				
				//verify result
				AdGroup adgrp = test.getAdGroupById(accountId, campaignId, adgrpid);
				if(adgrp != null)
					errorHandler(new Exception(vMsg + "AdGroup is not deleted"));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			/*
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
			*/
			
			//setAdGroupStateTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setAdGroupStateTargets:");
			try{
				Target tgt4 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check before change
				if(tgt4 != null){
					//delete target if there's already one associated to the entity
					test.deleteAdGroupTargets(accountId, customerId, adGroupId);
					System.out.println("deleteAdGroupTargets OK");
				}
				String[] list1 = {"US-NY", "US-MA", "US-CA", "US-FL"};
				List<String> states1 = Arrays.asList(list1);
				test.setAdGroupStateTargets(accountId, customerId, adGroupId, states1);			
				System.out.println("setAdGroupStateTargets OK");
				
				//verify results
				tgt4 = test.getAdGroupTargets(accountId, customerId, adGroupId);
				StateTargetBid[] bids1 = tgt4.getLocation().getStateTarget().getBids();
				int c = 0;
				for(StateTargetBid b:bids1){
					if(b.getState().equals("US-NY")) c++;
					if(b.getState().equals("US-MA")) c++;
					if(b.getState().equals("US-CA")) c++;
					if(b.getState().equals("US-FL")) c++;
				}
				if(c!=4)
					errorHandler(new Exception(vMsg + "State Targets aren't set correctly."));				
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdGroupTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupTargets:");
			try{
				Target tgt4 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				System.out.println("getAdGroupTargets OK");
				StateTargetBid[] bids1 = tgt4.getLocation().getStateTarget().getBids();
				for(StateTargetBid b:bids1){
					System.out.println("state = " + b.getState());
				}
				
				//verify results
				int c = 0;
				for(StateTargetBid b:bids1){
					if(b.getState().equals("US-NY")) c++;
					if(b.getState().equals("US-MA")) c++;
					if(b.getState().equals("US-CA")) c++;
					if(b.getState().equals("US-FL")) c++;
				}
				if(c!=4)
					errorHandler(new Exception(vMsg + "State Targets aren't got correctly."));				
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//deleteAdGroupTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdGroupTargets:");
			try{				
				test.deleteAdGroupTargets(accountId, customerId, adGroupId);
				System.out.println("deleteAdGroupTargets OK");
				
				//verify result
				Target tgt4 = test.getAdGroupTargets(accountId, customerId, adGroupId);
				if(tgt4 != null)
					errorHandler(new Exception(vMsg + "Targets are not deleted."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}			
			
			//setAdGroupCityTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setAdGroupCityTargets:");
			try{
				Target tat5 = test.getAdGroupTargets(accountId, campaignId, adGroupId);  //check before change
				if(tat5 != null){
					//delete target if there's already one associated to the entity
					test.deleteAdGroupTargets(accountId, customerId, adGroupId);
				} 
				String[] list2 = {"Brookline, Boston MA US", "Newton, Boston MA US", "Wellesley, Boston MA US"};
				List<String> cities = Arrays.asList(list2);
				test.setAdGroupCityTargets(accountId, customerId, adGroupId, cities);			
				System.out.println("OK");
				
				//verify results
				tat5 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				CityTargetBid[] bids2 = tat5.getLocation().getCityTarget().getBids();
				for(CityTargetBid b:bids2){
					System.out.println("city = " + b.getCity());
				}			
				int c = 0;
				for(CityTargetBid t:bids2){
					if(t.getCity().equals("Brookline, Boston MA US")) c++;
					if(t.getCity().equals("Newton, Boston MA US")) c++;
					if(t.getCity().equals("Wellesley, Boston MA US")) c++;
				}
				if(c!=3)
					errorHandler(new Exception(vMsg + "City Targets are not set correctly."));
				
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//setAdGroupMetroAreaTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setAdGroupMetroAreaTargets:");
			try{
				Target tgt6 = test.getAdGroupTargets(accountId, campaignId, adGroupId);  //check before change
				if(tgt6 != null){
					//delete target if there's already one associated to the entity
					test.deleteAdGroupTargets(accountId, customerId, adGroupId);
				} 
				String[] list3 = {"Brooklyn, NY US", "New York, NY US"};
				List<String> metros = Arrays.asList(list3);
				test.setAdGroupMetroAreaTargets(accountId, customerId, adGroupId, metros);			
				System.out.println("OK");
				
				//verify results
				tgt6 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				MetroAreaTargetBid[] bids3 = tgt6.getLocation().getMetroAreaTarget().getBids();
				for(MetroAreaTargetBid b:bids3){
					System.out.println("city = " + b.getMetroArea());
				}	
				int c = 0;
				for(MetroAreaTargetBid m:bids3){
					if(m.getMetroArea().equals("Brooklyn, NY US")) c++;
					if(m.getMetroArea().equals("New York, NY US")) c++;
				}
				if(c!=2)
					errorHandler(new Exception(vMsg + "Metro Area Targets are not set correctly."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//createAd
			System.out.println("------------------------------------------------------------");
			System.out.println("createAd:");
			try{
				String adName = "unit_test_ad" + now;
				adId = test.createAd(accountId, adGroupId, adName, "test content", "https://www.semplest.com/", "https://www.semplest.com/");
				System.out.println("OK");
				System.out.println("adId = " + adId);
				
				//verify result
				if(adId == 0L)
					errorHandler(new Exception(vMsg + "No Ad ID returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//getAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdById:");
			try{
				Ad ad1 = test.getAdById(accountId, adGroupId, adId);
				System.out.println("OK");
				System.out.println("AdId = " + ad1.getId()
						+ "; status = " + ad1.getStatus().getValue()
						+ "; EditorialStatus = " + ad1.getEditorialStatus().getValue()
						+ "; Type = " + ad1.getType().getValue());
				TextAd ad2 = (TextAd)ad1;
				System.out.println("Title = " + ad2.getTitle()
						+ "; Text = " + ad2.getText()
						+ "; DisplayUrl = " + ad2.getDisplayUrl()
						+ "; DestinationUrl = " + ad2.getDestinationUrl());
				
				//verify result
				if(!ad1.getId().equals(adId))
					errorHandler(new Exception(vMsg + "Ad Data returned incorrectly."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdsByAdGroupId			
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdsByAdGroupId:");
			try{
				String adName = "ad2" + now;
				adId = test.createAd(accountId, adGroupId, adName, "test2 content", "https://www.semplest2.com/", "https://www.semplest2.com/");
				Ad[] ad3 = test.getAdsByAdGroupId(accountId, adGroupId);
				System.out.println("OK");
				for (Ad x : ad3){
					TextAd a = (TextAd) x;
					System.out.println("Id = " + a.getId()
							+ "; Title = " + a.getTitle()
							+ "; Text = " + a.getText()
							+ "; DisplayUrl = " + a.getDisplayUrl()
							+ "; DestinationUrl = " + a.getDestinationUrl());
				} 		
				
				//verify result
				if(ad3.length == 0)
					errorHandler(new Exception(vMsg + "No Ad returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//updateAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("updateAdById:");
			try{
				String adTitle = "unit_test_ad_update";
				test.updateAdById(accountId, adGroupId, adId, adTitle, "update content", "https://adcenter.microsoft.com/", "https://adcenter.microsoft.com/");
				System.out.println("OK");
				
				//verify result
				TextAd ad1 = (TextAd)test.getAdById(accountId, adGroupId, adId);				
				if(!ad1.getTitle().equalsIgnoreCase(adTitle))
					errorHandler(new Exception(vMsg + "Ad is not updated correctly. " + ad1.getTitle() + " != " + adTitle));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//pauseAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseAdById:");
			try{
				test.pauseAdById(accountId, adGroupId, adId);
				System.out.println("OK");
				
				//verify result
				Ad ad = test.getAdById(accountId, adGroupId, adId);
				if(!ad.getStatus().getValue().equalsIgnoreCase(AdStatus.Paused.getValue()))
					errorHandler(new Exception(vMsg + "Ad is not Paused."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//resumeAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("resumeAdById:");
			try{
				test.resumeAdById(accountId, adGroupId, adId);  //resume the Ad
				System.out.println("OK");
				
				//verify result
				Ad ad = test.getAdById(accountId, adGroupId, adId);
				if(!ad.getStatus().getValue().equalsIgnoreCase(AdStatus.Active.getValue()))
					errorHandler(new Exception(vMsg + "Ad is not Actived."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//deleteAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdById:");
			try{
				test.deleteAdById(accountId, adGroupId, adId);
				System.out.println("OK");
				
				//verify result
				Ad ad = test.getAdById(accountId, adGroupId, adId);				
				if(ad != null)
					errorHandler(new Exception(vMsg + "Ad is not deleted."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createKeyword
			System.out.println("------------------------------------------------------------");
			System.out.println("createKeyword:");
			try{
				Bid broadMatchBid = new Bid();
				broadMatchBid.setAmount(2.00);
				Bid contentMatchBid = new Bid();
				contentMatchBid.setAmount(2.01);
				Bid exactMatchBid = new Bid();
				exactMatchBid.setAmount(2.02);
				Bid phraseMatchBid = new Bid();
				phraseMatchBid.setAmount(2.03);
				keywordId = test.createKeyword(accountId, adGroupId, "nan keyword test", MatchType.Exact, null);						
				System.out.println("OK");
				
				if(keywordId == 0L)
					errorHandler(new Exception(vMsg + "No keyword Id returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch (Exception e)
			{
				errorHandler(e);
			}
			
			 //getKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordById:");
			try{
				Keyword kw1 = test.getKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
				if(kw1 != null){
					System.out.println("Id = " + kw1.getId()
							+ "; text = " + kw1.getText());
				}
				
				//verify result
				if((kw1==null) || (kw1.getId() == null) || (kw1.getText() == null))
					errorHandler(new Exception(vMsg + "No keyword data returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("createKeywords:");
			try{
				Keyword[] keywords = new Keyword[2];
				keywords[0] = new Keyword();
				keywords[1] = new Keyword();
				keywords[0].setText("nan keyword test 1");
				keywords[1].setText("nan keyword test 2");
				Bid broadMatchBid1 = new Bid();
				broadMatchBid1.setAmount(3.01);
				Bid broadMatchBid2 = new Bid();
				broadMatchBid2.setAmount(3.01);
				keywords[0].setBroadMatchBid(broadMatchBid1);						
				keywords[1].setBroadMatchBid(broadMatchBid2);			
				long[] kwids = test.createKeywords(accountId, adGroupId, keywords);
				System.out.println("OK");
				for(long k: kwids){
					System.out.println("keyword Id = " + k);
				}
				
				//verify result
				if(kwids.length != 2)
					errorHandler(new Exception(vMsg + "No keyword IDs returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			
			//getKeywordByAdGroupId
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordByAdGroupId:");
			try{
				Keyword[] kws1 = test.getKeywordByAdGroupId(accountId, adGroupId);
				System.out.println("OK");
				for(Keyword k: kws1){
					System.out.println("keyword Id = " + k.getId());
				}
				
				//verify result
				if(kws1.length == 0)
					errorHandler(new Exception(vMsg + "No keywords returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//updateKeywordBidById
			System.out.println("------------------------------------------------------------");
			System.out.println("updateKeywordBidById:");
			try{
				Bid broadMatchBid = new Bid();
				broadMatchBid.setAmount(5.00);
				Bid contentMatchBid = new Bid();
				contentMatchBid.setAmount(5.01);
				Bid exactMatchBid = new Bid();
				exactMatchBid.setAmount(5.02);
				Bid phraseMatchBid = new Bid();
				phraseMatchBid.setAmount(5.03);
				test.updateKeywordBidById(accountId, adGroupId, keywordId, MatchType.Broad, broadMatchBid);
				test.updateKeywordBidById(accountId, adGroupId, keywordId, MatchType.Content, contentMatchBid);
				test.updateKeywordBidById(accountId, adGroupId, keywordId, MatchType.Exact, exactMatchBid);
				test.updateKeywordBidById(accountId, adGroupId, keywordId, MatchType.Phrase, phraseMatchBid);
				System.out.println("OK");
				
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//updateKeywordBidsByIds
			System.out.println("------------------------------------------------------------");
			System.out.println("updateKeywordBidsByIds:");
			try{
				Keyword[] kws = test.getKeywordByAdGroupId(accountId, adGroupId);
				List<BidElement> bidList = new ArrayList<BidElement>();
				int j = 0;
				for(Keyword k : kws){
					BidElement be  = new BidElement();
					be.setKeyword(k.getText());
					be.setKeywordAdEngineID(k.getId());
					be.setMatchType("Excact");
					be.setMicroBidAmount(new Long(j*1000000+5000));
					j++;
				}
				test.updateKeywordBidsByIds(accountId, adGroupId, bidList);
				
				System.out.println("OK");	
				
				//verify result
				Keyword[] kws2 = test.getKeywordByAdGroupId(accountId, adGroupId);
				for(int i = 0; i<kws2.length; i++){
					if(kws2[i].getBroadMatchBid().getAmount().equals(new Long(i*1000000+5000)))
						errorHandler(new Exception(vMsg + "Bid amount not updated correctly."));
					break;
				}	
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			
			//pauseKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseKeywordById:");
			try{
				test.pauseKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
				
				//verify result
				Keyword kw1 = test.getKeywordById(accountId, adGroupId, keywordId);
				if(!kw1.getStatus().getValue().equalsIgnoreCase(KeywordStatus.Paused.getValue()))
					errorHandler(new Exception(vMsg + "Keyword is not Paused."));				
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}			
			
			//deleteKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteKeywordById:");
			try{
				test.deleteKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
				
				//verify result
				Keyword kw1 = test.getKeywordById(accountId, adGroupId, keywordId);
				if(kw1 != null)
					errorHandler(new Exception(vMsg + "Keyword is not deleted."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}	
			
			//deleteKeywordsById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteKeywordById:");
			try{
				Keyword[] kws1 = test.getKeywordByAdGroupId(accountId, adGroupId);
				int size = kws1.length;
				long[] kwid = new long[size];
				for(int i = 0; i<size; i++){
					kwid[i] = kws1[i].getId();
				}				
				test.deleteKeywordsById(accountId, adGroupId, kwid);
				System.out.println("OK");
				
				//verify result
				for(long id : kwid){
					if(test.getKeywordById(accountId, adGroupId, id) != null)
						errorHandler(new Exception(vMsg + "Keyword is not deleted."));
					break;
				}
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getKeywordEstimateByBids
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordEstimateByBids:");
			try{
				String[] kws2 = new String[2];
				kws2[0] = "flower";
				kws2[1] = "rose";
				Long[] bid = new Long[]{6000000L, 7000000L};
				
				Long test_accountId = 1617055L;
				TrafficEstimatorObject kep = test.getKeywordEstimateByBids(test_accountId, kws2, bid, MatchType.Exact);
				System.out.println("OK");
				
				//verify result
				System.out.println("test accountId is " + test_accountId);				
				for(String s:kep.getListOfKeywords()){
					System.out.println("keyword = " + s);
					HashMap<Long, BidData> map = kep.getMapOfPoints(s, MatchType.Broad.getValue());
					if(kep.getBidList(s, MatchType.Broad.getValue()) == null){
						System.out.println("no keyword estimate for the campaign");
					}
					else{
						for(Long b:kep.getBidList(s, MatchType.Broad.getValue())){
							System.out.println("bidAmount = " + b);
							System.out.println("AveClickPerDay = " + kep.getAveClickPerDay(s, MatchType.Broad.getValue(), b));
							System.out.println("AveCPC = " + kep.getAveCPC(s, MatchType.Broad.getValue(), b));
							System.out.println("AvePosition = " + kep.getAvePosition(s, MatchType.Broad.getValue(), b));
							System.out.println("AveTotalDailyMicroCost = " + kep.getAveTotalDailyMicroCost(s, MatchType.Broad.getValue(), b));
						}
					}
				}
				
				if(kep.getListOfKeywords().length == 0)
					errorHandler(new Exception(vMsg + "No TrafficEstimator data returned."));
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(MsnCloudException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//requestCampaignReport
			//String ret = test.requestCampaignReport(1595249L, 130129414L, 10, ReportAggregation.fromString(ReportAggregation._Daily));
			
			//requestKeywordReport
			/*
			DateTime firstDay = new DateTime(2012,3,1,0,0,0,0);
			DateTime lastDay = new DateTime(2012,3,31,0,0,0,0);
			String ret1 = test.requestKeywordReport(1595249L, 130129414L, firstDay, lastDay, ReportAggregation.fromString(ReportAggregation._Daily));	
			*/	
			
			//getReportData
			/*
			Map<String, String[]> ret2 = test.getReportData(ret1, 1595249L);
			Set<String> keys = ret2.keySet();
			Collection<String[]> values = ret2.values();
			logger.info(keys.toString());
			logger.info(values.toString());
			*/
			
			/*
			//getKeywordReport
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordReport:");
			try{
				DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
				DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
				Long test_accountId = 1617055L;
				Long test_campaignId = 130140291L;
				ReportObject[] kwreport = test.getKeywordReport(test_accountId, test_campaignId, firstDay, lastDay, ReportAggregation.Daily);			
				System.out.println("OK");
				System.out.println("test accountId is " + test_accountId);
				System.out.println("test campaignId is " + test_campaignId);
				
				if(kwreport == null){
					System.out.println("no keyword history for the campaign");
				}
				else{
					for(ReportObject t: kwreport){
						System.out.println("->");
						System.out.println("Keyword = " + t.getKeyword());
						System.out.println("BidAmount = " + t.getMicroBidAmount());
						System.out.println("BidMatchType = " + t.getBidMatchType());
						System.out.println("NumberImpressions = " + t.getNumberImpressions());
						System.out.println("NumberClick = " + t.getNumberClick());
						System.out.println("AveragePosition = " + t.getAveragePosition());
						System.out.println("QualityScore = " + t.getQualityScore());
						System.out.println("AverageCPC = " + t.getAverageCPC());
						System.out.println("CreatedDate = " + t.getTransactionDate());						
					}
				}
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
			*/
		
		}
		finally{
			cleanUp();
		}	
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                          MsnAdcenter Test (Impl) FAILED!                         #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                          MsnAdcenter Test (Impl) PASSED!                         #");
			System.out.println("####################################################################################");
		}
		
		return errorCounter;
	}
	
	public int Test_MsnServices_Service(){
		
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
		errorCounter = 0;

		Long campaignId = 0L;
		Long adGroupId = 0L;
		Long adId = 0L;
		Long keywordId = 0L;
		
		String now = String.valueOf(System.currentTimeMillis());
		
		try{
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                         MSN Service Test (Service)                               #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");	
			
				
			//getAccountById			
			System.out.println("------------------------------------------------------------");
			System.out.println("getAccountById:");
			try{
				Account acc = test.getAccountById(accountId);
				System.out.println("OK");
				System.out.println("account name = " + acc.getName());
				System.out.println("account Id = " + acc.getId());
			}
			catch(Exception e){
				errorHandler(e);
			}
				
			//createCampaign
			System.out.println("------------------------------------------------------------");
			System.out.println("createCampaign:");
			try{
				CampaignStatus cpst = null;
				String campaignName = "unit_test_campaign1" + now;
				System.out.println("campaign name = " + campaignName);
				campaignId = test.createCampaign(accountId, campaignName, BudgetLimitType.DailyBudgetStandard,1.00, 5.00, cpst.Paused);
				System.out.println("OK");
				System.out.println("campaignId = " + campaignId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignById:");
			try{
				Campaign cp = test.getCampaignById(accountId, campaignId);
				System.out.println("OK");
				System.out.println("campaign name = " + cp.getName());
				System.out.println("campaign Id = " + cp.getId());
				System.out.println("budget type = " + cp.getBudgetType());
				System.out.println("daily budget = " + cp.getDailyBudget());
				System.out.println("monthly budget = " + cp.getMonthlyBudget());
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getCampaignsByAccountId
			System.out.println("------------------------------------------------------------");
			System.out.println("getCampaignsByAccountId:");
			try{
				Campaign[] cps = test.getCampaignsByAccountId(accountId);
				System.out.println("OK");
				for(Campaign c:cps){
					System.out.println("campaign Id = " + c.getId());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//resumeCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("resumeCampaignById:");
			try{
				test.resumeCampaignById(accountId, campaignId);  //resume
				System.out.println("OK");
				Campaign cp1 = test.getCampaignById(accountId, campaignId);  //check it
				System.out.println("status = " + cp1.getStatus());
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//pauseCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseCampaignById:");
			try{
				test.pauseCampaignById(accountId, campaignId);
				System.out.println("OK");
				Campaign cp1 = test.getCampaignById(accountId, campaignId);  //check it
				System.out.println("status = " + cp1.getStatus());
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//pauseCampaignsByAccountId
			//test.pauseCampaignsByAccountId(1595249L);
					
			//deleteCampaignById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteCampaignById:");
			try{
				Long tmpId = test.createCampaign(accountId, "temp campaign", BudgetLimitType.DailyBudgetStandard, 1.00, 5.00, CampaignStatus.Paused);
				System.out.println("created temp campaign " + tmpId + "and now delete it.");
				test.deleteCampaignById(accountId, tmpId);
				System.out.println("OK");
				Campaign cp = test.getCampaignById(accountId, campaignId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//updateCampaignBudget
			System.out.println("------------------------------------------------------------");
			System.out.println("updateCampaignBudget:");
			try{
				//update daily budget
				double dailyBudget = 2.00;
				System.out.println("Update Daily Budget.");
				test.updateCampaignBudget(accountId, campaignId, BudgetLimitType.DailyBudgetStandard, dailyBudget, 5.00);
				System.out.println("OK");
				Campaign ret1 = test.getCampaignById(accountId, campaignId);	
				System.out.println(ret1.getBudgetType());
				System.out.println(ret1.getDailyBudget());
				//update monthly budget
				System.out.println("Update Monthly Budget.");
				double monthlyBudget = 10.00;
				test.updateCampaignBudget(accountId, campaignId, BudgetLimitType.MonthlyBudgetSpendUntilDepleted, 1.00, monthlyBudget);
				System.out.println("OK");
				Campaign ret2 = test.getCampaignById(accountId, campaignId);	
				System.out.println(ret2.getBudgetType());
				System.out.println(ret1.getMonthlyBudget());
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			
			//setCampaignStateTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setCampaignStateTargets:");
			try{
				Target tgt1 = test.getCampaignTargets(accountId, customerId, campaignId); 
				if(tgt1 != null){
					//delete target if there's already one associated to the entity
					test.deleteCampaignTargets(accountId, customerId, campaignId);
				}
				String[] list = {"US-NY", "US-MA", "US-CA", "US-FL"};
				List<String> states = Arrays.asList(list);
				test.setCampaignStateTargets(accountId, customerId, campaignId, states);
				System.out.println("OK");
				
				//getCampaignTargets
				System.out.println("------------------------------------------------------------");
				System.out.println("getCampaignTargets:");
				Target tgt2 = test.getCampaignTargets(accountId, customerId, campaignId);
				System.out.println("OK");
				StateTargetBid[] bids = tgt2.getLocation().getStateTarget().getBids();
				for(StateTargetBid b:bids){
					System.out.println("state = " + b.getState());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//deleteCampaignTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteCampaignTargets:");
			try{
				Target tgt3 = test.getCampaignTargets(accountId, customerId, campaignId);  //check before change
				if(tgt3!=null) System.out.println("Target is not null");
				test.deleteCampaignTargets(accountId, customerId, campaignId);
				System.out.println("OK");
				tgt3 = test.getCampaignTargets(accountId, customerId, campaignId);  //check after change
				if(tgt3==null) System.out.println("Target is null");
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createAdGroup
			System.out.println("------------------------------------------------------------");
			System.out.println("createAdGroup:");
			try{
				adGroupId = test.createAdGroup(accountId, campaignId);
				System.out.println("OK");
				System.out.println("adGroupId = " + adGroupId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdGroupsByCampaignId
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupsByCampaignId:");
			try{
				AdGroup[] adgrps = test.getAdGroupsByCampaignId(accountId, campaignId);
				System.out.println("OK");
				for(AdGroup a: adgrps){
					System.out.println("adId = " + a.getId());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdGroupById
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdGroupById:");
			try{
				AdGroup adgrp = test.getAdGroupById(accountId, campaignId, adGroupId);
				System.out.println("OK");
				System.out.println("adId = " + adgrp.getId());
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//deleteAdGroupById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdGroupById:");
			try{
				long adgrpid = test.createAdGroup(accountId, campaignId);  //add a group
				System.out.println("created a temp ad group id=" + adgrpid + ", and now we'll delete it.");
				test.deleteAdGroupById(1595249L, 130129414L, adgrpid);  //delete the group
				System.out.println("OK");
				AdGroup adgrp = test.getAdGroupById(accountId, campaignId, adGroupId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//setAdGroupStateTargets, deleteAdGroupTargets and getAdGroupTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setAdGroupStateTargets, deleteAdGroupTargets, getAdGroupTargets:");
			try{
				Target tgt4 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check before change
				if(tgt4 != null){
					//delete target if there's already one associated to the entity
					test.deleteAdGroupTargets(accountId, customerId, adGroupId);
					System.out.println("deleteAdGroupTargets OK");
				}
				String[] list1 = {"US-NY", "US-MA", "US-CA", "US-FL"};
				List<String> states1 = Arrays.asList(list1);
				test.setAdGroupStateTargets(accountId, customerId, adGroupId, states1);			
				System.out.println("setAdGroupStateTargets OK");
				tgt4 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				System.out.println("getAdGroupTargets OK");
				StateTargetBid[] bids1 = tgt4.getLocation().getStateTarget().getBids();
				for(StateTargetBid b:bids1){
					System.out.println("state = " + b.getState());
				}
				test.deleteAdGroupTargets(accountId, customerId, adGroupId);
				System.out.println("deleteAdGroupTargets OK");
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			/*
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
			*/
			
			//setAdGroupCityTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setAdGroupCityTargets:");
			try{
				Target tat5 = test.getAdGroupTargets(accountId, campaignId, adGroupId);  //check before change
				if(tat5 != null){
					//delete target if there's already one associated to the entity
					test.deleteAdGroupTargets(accountId, customerId, adGroupId);
				} 
				String[] list2 = {"Brookline, Boston MA US", "Newton, Boston MA US", "Wellesley, Boston MA US"};
				List<String> cities = Arrays.asList(list2);
				test.setAdGroupCityTargets(accountId, customerId, adGroupId, cities);			
				System.out.println("OK");
				tat5 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				CityTargetBid[] bids2 = tat5.getLocation().getCityTarget().getBids();
				for(CityTargetBid b:bids2){
					System.out.println("city = " + b.getCity());
				}			
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//setAdGroupMetroAreaTargets
			System.out.println("------------------------------------------------------------");
			System.out.println("setAdGroupMetroAreaTargets:");
			try{
				Target tgt6 = test.getAdGroupTargets(accountId, campaignId, adGroupId);  //check before change
				if(tgt6 != null){
					//delete target if there's already one associated to the entity
					test.deleteAdGroupTargets(accountId, customerId, adGroupId);
				} 
				String[] list3 = {"Brooklyn, NY US", "New York, NY US"};
				List<String> metros = Arrays.asList(list3);
				test.setAdGroupMetroAreaTargets(accountId, customerId, adGroupId, metros);			
				System.out.println("OK");
				tgt6 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				MetroAreaTargetBid[] bids3 = tgt6.getLocation().getMetroAreaTarget().getBids();
				for(MetroAreaTargetBid b:bids3){
					System.out.println("city = " + b.getMetroArea());
				}	
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createAd
			System.out.println("------------------------------------------------------------");
			System.out.println("createAd:");
			try{
				String adName = "unit_test_ad" + now;
				adId = test.createAd(accountId, adGroupId, adName, "test content", "https://www.semplest.com/", "https://www.semplest.com/");
				System.out.println("OK");
				System.out.println("adId = " + adId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdById:");
			try{
				Ad ad1 = test.getAdById(accountId, adGroupId, adId);
				System.out.println("OK");
				System.out.println("AdId = " + ad1.getId()
						+ "; status = " + ad1.getStatus().getValue()
						+ "; EditorialStatus = " + ad1.getEditorialStatus().getValue()
						+ "; Type = " + ad1.getType().getValue());
				TextAd ad2 = (TextAd)ad1;
				System.out.println("Title = " + ad2.getTitle()
						+ "; Text = " + ad2.getText()
						+ "; DisplayUrl = " + ad2.getDisplayUrl()
						+ "; DestinationUrl = " + ad2.getDestinationUrl());
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getAdsByAdGroupId			
			System.out.println("------------------------------------------------------------");
			System.out.println("getAdsByAdGroupId:");
			try{
				String adName = "unit_test_ad2" + now;
				adId = test.createAd(accountId, adGroupId, adName, "test2 content", "https://www.semplest2.com/", "https://www.semplest2.com/");
				Ad[] ad3 = test.getAdsByAdGroupId(accountId, adGroupId);
				System.out.println("OK");
				for (Ad x : ad3){
					TextAd a = (TextAd) x;
					System.out.println("Id = " + a.getId()
							+ "; Title = " + a.getTitle()
							+ "; Text = " + a.getText()
							+ "; DisplayUrl = " + a.getDisplayUrl()
							+ "; DestinationUrl = " + a.getDestinationUrl());
				} 		
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//updateAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("updateAdById:");
			try{
				String adTitle = "unit_test_ad_update";
				test.updateAdById(accountId, adGroupId, adId, adTitle, "update content", "https://adcenter.microsoft.com/", "https://adcenter.microsoft.com/");
				System.out.println("OK");
				
				TextAd ad = (TextAd)test.getAdById(accountId, adGroupId, adId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//pauseAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseAdById:");
			try{
				test.pauseAdById(accountId, adGroupId, adId);
				System.out.println("OK");
				
				Ad ad = test.getAdById(accountId, adGroupId, adId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//resumeAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("resumeAdById:");
			try{
				test.resumeAdById(accountId, adGroupId, adId);  //resume the Ad
				System.out.println("OK");
				
				Ad ad = test.getAdById(accountId, adGroupId, adId);
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//deleteAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteAdById:");
			try{
				test.deleteAdById(accountId, adGroupId, adId);
				System.out.println("OK");
				
				Ad ad = test.getAdById(accountId, adGroupId, adId);				
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createKeyword
			System.out.println("------------------------------------------------------------");
			System.out.println("createKeyword:");
			try{
				Bid exactMatchBid = new Bid();
				exactMatchBid.setAmount(2.02);
				keywordId = test.createKeyword(accountId, adGroupId, "nan keyword test", MatchType.Exact, exactMatchBid);			
				System.out.println("OK");
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			 //getKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordById:");
			try{
				Keyword kw1 = test.getKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
				if(kw1 != null){
					System.out.println("Id = " + kw1.getId()
							+ "; text = " + kw1.getText());
				}
				
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//createKeywords
			System.out.println("------------------------------------------------------------");
			System.out.println("createKeywords:");
			try{
				Keyword[] keywords = new Keyword[2];
				keywords[0] = new Keyword();
				keywords[1] = new Keyword();
				keywords[0].setText("nan keyword test 1");
				keywords[1].setText("nan keyword test 2");
				Bid broadMatchBid1 = new Bid();
				broadMatchBid1.setAmount(3.01);
				Bid broadMatchBid2 = new Bid();
				broadMatchBid2.setAmount(3.01);
				keywords[0].setBroadMatchBid(broadMatchBid1);						
				keywords[1].setBroadMatchBid(broadMatchBid2);			
				long[] kwids = test.createKeywords(accountId, adGroupId, keywords);
				System.out.println("OK");
				for(long k: kwids){
					System.out.println("keyword Id = " + k);
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			
			//getKeywordByAdGroupId
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordByAdGroupId:");
			try{
				Keyword[] kws1 = test.getKeywordByAdGroupId(accountId, adGroupId);
				System.out.println("OK");
				for(Keyword k: kws1){
					System.out.println("keyword Id = " + k.getId());
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//updateKeywordBidById
			System.out.println("------------------------------------------------------------");
			System.out.println("updateKeywordBidById:");
			try{
				Bid exactMatchBid = new Bid();
				exactMatchBid.setAmount(5.02);
				test.updateKeywordBidById(accountId, adGroupId, keywordId, MatchType.Exact, exactMatchBid);
				System.out.println("OK");			
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//updateKeywordBidsByIds
			System.out.println("------------------------------------------------------------");
			System.out.println("updateKeywordBidsByIds:");
			try{
				Keyword[] kws = test.getKeywordByAdGroupId(accountId, adGroupId);
				List<BidElement> bidList = new ArrayList<BidElement>();		
				for(Keyword k : kws){
					BidElement be = new BidElement();
					be.setKeywordAdEngineID(k.getId());
					be.setMicroBidAmount(5500000L);
				}		
				test.updateKeywordBidsByIds(1595249L, 754813047L, bidList);
				System.out.println("OK");				
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			
			//pauseKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseKeywordById:");
			try{
				test.pauseKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
				
				Keyword kw1 = test.getKeywordById(accountId, adGroupId, keywordId);
			}
			catch(Exception e){
				errorHandler(e);
			}			
			
			//deleteKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteKeywordById:");
			try{
				test.deleteKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
				Keyword kw1 = test.getKeywordById(accountId, adGroupId, keywordId);
			}
			catch(Exception e){
				errorHandler(e);
			}	
			
			//deleteKeywordsById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteKeywordById:");
			try{
				Keyword[] kws1 = test.getKeywordByAdGroupId(accountId, adGroupId);
				int size = kws1.length;
				long[] kwid = new long[size];
				for(int i = 0; i<size; i++){
					kwid[i] = kws1[i].getId();
				}				
				test.deleteKeywordsById(accountId, adGroupId, kwid);
				System.out.println("OK");
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//getKeywordEstimateByBids
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordEstimateByBids:");
			try{
				String[] kws2 = new String[2];
				kws2[0] = "flower";
				kws2[1] = "rose";
				Long[] bid = new Long[]{6000000L, 7000000L};
				
				Long test_accountId = 1617055L;
				TrafficEstimatorObject kep = test.getKeywordEstimateByBids(test_accountId, kws2, bid, MatchType.Exact);
				System.out.println("OK");
				System.out.println("test accountId is " + test_accountId);
				if(kep == null){
					System.out.println("no keyword estimate for the campaign");
				}
				else{
					for(String s:kep.getListOfKeywords()){
						System.out.println("keyword = " + s);
						HashMap<Long, BidData> map = kep.getMapOfPoints(s, MatchType.Broad.getValue());
						for(Long b:kep.getBidList(s, MatchType.Broad.getValue())){
							System.out.println("bidAmount = " + b);
							System.out.println("AveClickPerDay = " + kep.getAveClickPerDay(s, MatchType.Broad.getValue(), b));
							System.out.println("AveCPC = " + kep.getAveCPC(s, MatchType.Broad.getValue(), b));
							System.out.println("AvePosition = " + kep.getAvePosition(s, MatchType.Broad.getValue(), b));
							System.out.println("AveTotalDailyMicroCost = " + kep.getAveTotalDailyMicroCost(s, MatchType.Broad.getValue(), b));
						}
					}
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			//requestCampaignReport
			//String ret = test.requestCampaignReport(1595249L, 130129414L, 10, ReportAggregation.fromString(ReportAggregation._Daily));
			
			//requestKeywordReport
			/*
			DateTime firstDay = new DateTime(2012,3,1,0,0,0,0);
			DateTime lastDay = new DateTime(2012,3,31,0,0,0,0);
			String ret1 = test.requestKeywordReport(1595249L, 130129414L, firstDay, lastDay, ReportAggregation.fromString(ReportAggregation._Daily));	
			*/	
			
			//getReportData
			/*
			Map<String, String[]> ret2 = test.getReportData(ret1, 1595249L);
			Set<String> keys = ret2.keySet();
			Collection<String[]> values = ret2.values();
			logger.info(keys.toString());
			logger.info(values.toString());
			*/
			
			/*
			//getKeywordReport
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordReport:");
			try{
				DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
				DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
				Long test_accountId = 1617055L;
				Long test_campaignId = 130140291L;
				ReportObject[] kwreport = test.getKeywordReport(test_accountId, test_campaignId, firstDay, lastDay, ReportAggregation.Daily);			
				System.out.println("OK");
				System.out.println("test accountId is " + test_accountId);
				System.out.println("test campaignId is " + test_campaignId);
				
				if(kwreport == null){
					System.out.println("no keyword history for the campaign");
				}
				else{
					for(ReportObject t: kwreport){
						System.out.println("->");
						System.out.println("Keyword = " + t.getKeyword());
						System.out.println("BidAmount = " + t.getMicroBidAmount());
						System.out.println("BidMatchType = " + t.getBidMatchType());
						System.out.println("NumberImpressions = " + t.getNumberImpressions());
						System.out.println("NumberClick = " + t.getNumberClick());
						System.out.println("AveragePosition = " + t.getAveragePosition());
						System.out.println("QualityScore = " + t.getQualityScore());
						System.out.println("AverageCPC = " + t.getAverageCPC());
						System.out.println("CreatedDate = " + t.getTransactionDate());						
					}
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			*/
		
		}
		finally{
			cleanUp();
		}	
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                        Msn Service Test (Service) FAILED!                        #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                         Msn Service Test (Service) PASSED!                       #");
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
			
			Campaign[] allcp = test.getCampaignsByAccountId(accountId);
			for(Campaign c : allcp){
				test.deleteCampaignById(accountId, c.getId());
			}
			System.out.println("clean up done");
		}
		catch(Exception e2){
			System.out.println("clean up failed. please inactive the campaigns manually on UI (to avoid possible charge on your account)!");
		}
	}


}
