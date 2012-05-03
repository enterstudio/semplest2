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
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.CityTargetBid;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.MetroAreaTargetBid;
import com.microsoft.adcenter.v8.MobileAd;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.StateTargetBid;
import com.microsoft.adcenter.v8.Target;

import semplest.other.Money;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject.BidData;
import semplest.service.msn.adcenter.MsnCloudException;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;


public class MsnServiceTest {
	
	MsnCloudServiceImpl test = new MsnCloudServiceImpl();
	
	private int errorCounter = 0;
	
	public static Long accountId = 1629687L;	
	public static Long customerId = 13068662L;
	public static Long userId = 1701206L;
	
	public int Test_MsnReport(){
		
		try{			
			DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
			DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
			
			ArrayList<ReportObject> ret = test.getKeywordReport(1617082L, 110138069L, firstDay, lastDay, ReportAggregation.Daily);
			
			for(ReportObject t: ret){
				System.out.println("Keyword = " + t.getKeyword());
				System.out.println("BidAmount = " + t.getMicroBidAmount());
				System.out.println("BidMatchType = " + t.getBidMatchType());
				System.out.println("NumberImpressions = " + t.getNumberImpressions());
				System.out.println("NumberClick = " + t.getNumberClick());
				System.out.println("AveragePosition = " + t.getAveragePosition());
				System.out.println("QualityScore = " + t.getQualityScore());
				System.out.println("AverageCPC = " + t.getAverageCPC());
				System.out.println("CreatedDate = " + t.getTransactionDate());
				System.out.println("MicroCost = " + t.getMicroCost());
				System.out.println("===========================");
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
			return 1;
		}
		return 0;
	}
	
	public int Test_createAccount(){
		
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		try{
			System.out.println("==========================================");
			System.out.println("Test Method:");
			System.out.println("createAccount");
			System.out.println("--------------------");
			SemplestString in = new SemplestString();			
			in.setSemplestString("semplest_unit_test");
			System.out.println("account name = "+ in.getSemplestString());
			MsnManagementIds ret = test.createAccount(in);		
			System.out.println("OK");
			System.out.println("AccountId = "+ ret.getAccountId());
			System.out.println("CustomerId = "+ ret.getCustomerId());
			System.out.println("UserId = "+ ret.getUserId());
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
			
			return 1;
		}
		return 0;
	}
	
	public int Test_MsnServices_Standalone(){
		
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();

		Long campaignId = 0L;
		Long adGroupId = 0L;
		Long adId = 0L;
		Long keywordId = 0L;
		
		String now = String.valueOf(System.currentTimeMillis());
		
		try{
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                        MSN Service Test (Standalone)                             #");
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
			catch(MsnCloudException e){
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
			}
			catch(RemoteException e){
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
			}
			catch(RemoteException e){
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
			catch(RemoteException e){
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
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(MsnCloudException e){
				errorHandler(e);
			}
			
			//updateCampaignBudget
			System.out.println("------------------------------------------------------------");
			System.out.println("updateCampaignBudget:");
			try{
				test.updateCampaignBudget(accountId, campaignId, BudgetLimitType.MonthlyBudgetSpendUntilDepleted, 2.00, 10.00);
				System.out.println("OK");
			}
			catch(RemoteException e){
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
			}
			catch(RemoteException e){
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
			catch(RemoteException e){
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
			}
			catch(RemoteException e){
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
			}
			catch(RemoteException e){
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
			}
			catch(RemoteException e){
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
				tgt6 = test.getAdGroupTargets(accountId, customerId, adGroupId);  //check after change
				MetroAreaTargetBid[] bids3 = tgt6.getLocation().getMetroAreaTarget().getBids();
				for(MetroAreaTargetBid b:bids3){
					System.out.println("city = " + b.getMetroArea());
				}	
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
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//getAdById
			/*
			System.out.println("==========================================");
			System.out.println("Test Method:");
			System.out.println("getAdById");
			System.out.println("--------------------");	
			Ad ad1 = test.getAdById(accountId, adGroupId, adId);
			System.out.println("OK");
			System.out.println("AdId = " + ad1.getId()
					+ "; status = " + ad1.getStatus().getValue()
					+ "; EditorialStatus = " + ad1.getEditorialStatus().getValue()
					+ "; Type = " + ad1.getType().getValue());
			MobileAd ad2 = (MobileAd)ad1;
			System.out.println("Title = " + ad2.getTitle()
					+ "; Text = " + ad2.getText()
					+ "; DisplayUrl = " + ad2.getDisplayUrl()
					+ "; DestinationUrl = " + ad2.getDestinationUrl());
			*/
			
			//getAdsByAdGroupId
			/*
			System.out.println("==========================================");
			System.out.println("Test Method:");
			System.out.println("getAdsByAdGroupId");
			System.out.println("--------------------");	
			Ad[] ad3 = test.getAdsByAdGroupId(accountId, adGroupId);
			System.out.println("OK");
			for (Ad x : ad3){
				MobileAd a = (MobileAd) x;
				System.out.println("Id = " + a.getId()
						+ "; Title = " + a.getTitle()
						+ "; Text = " + a.getText()
						+ "; DisplayUrl = " + a.getDisplayUrl()
						+ "; DestinationUrl = " + a.getDestinationUrl());
			} 
			*/
			
			//updateAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("updateAdById:");
			try{
				String adName = "unit_test_ad_update";
				test.updateAdById(accountId, adGroupId, adId, adName, "update content", "https://adcenter.microsoft.com/", "https://adcenter.microsoft.com/");
				System.out.println("OK");
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//pauseAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseAdById:");
			try{
				test.pauseAdById(accountId, adGroupId, adId);
				System.out.println("OK");
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//resumeAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("resumeAdById:");
			try{
				test.resumeAdById(accountId, adGroupId, adId);  //resume the Ad
				System.out.println("OK");
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//deleteAdById
			System.out.println("------------------------------------------------------------");
			System.out.println("resumeAdById:");
			try{
				test.deleteAdById(accountId, adGroupId, adId);
				System.out.println("OK");
			}
			catch(RemoteException e){
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
				keywordId = test.createKeyword(accountId, adGroupId, "nan keyword test", broadMatchBid, contentMatchBid, exactMatchBid, phraseMatchBid);			
				System.out.println("OK");
			}
			catch(RemoteException e){
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
			catch(RemoteException e){
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
				test.updateKeywordBidById(accountId, adGroupId, keywordId, broadMatchBid, contentMatchBid, exactMatchBid, phraseMatchBid);
				System.out.println("OK");
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//updateKeywordBidsByIds
			/*
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
			*/
			
			//pauseKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("pauseKeywordById:");
			try{
				test.pauseKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			
			
			//deleteKeywordById
			System.out.println("------------------------------------------------------------");
			System.out.println("deleteKeywordById:");
			try{
				test.deleteKeywordById(accountId, adGroupId, keywordId);
				System.out.println("OK");
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			
			//deleteKeywordsById
			/*
			long[] keywordIds = new long[2];
			keywordIds[0] = 8099371836L;
			keywordIds[1] = 8099436288L;
			test.deleteKeywordsById(1595249L, 754813047L, keywordIds);
			*/
			
			//getKeywordEstimateByBids
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordEstimateByBids:");
			try{
				String[] kws2 = new String[2];
				kws2[0] = "flower";
				kws2[1] = "rose";
				Money[] bid = new Money[]{new Money(6000000), new Money(7000000)};
				TrafficEstimatorObject kep = test.getKeywordEstimateByBids(accountId, kws2, bid, MatchType.Exact);
				System.out.println("OK");
				for(String s:kep.getListOfKeywords()){
					System.out.println("keyword = " + s);
					HashMap<Double, BidData> map = kep.getMapOfPoints(s, MatchType.Broad.getValue());
					for(Double b:kep.getBidList(s, MatchType.Broad.getValue())){
						System.out.println("bidAmount = " + b);
						System.out.println("AveClickPerDay = " + kep.getAveClickPerDay(s, MatchType.Broad.getValue(), b));
						System.out.println("AveCPC = " + kep.getAveCPC(s, MatchType.Broad.getValue(), b));
						System.out.println("AvePosition = " + kep.getAvePosition(s, MatchType.Broad.getValue(), b));
						System.out.println("AveTotalDailyMicroCost = " + kep.getAveTotalDailyMicroCost(s, MatchType.Broad.getValue(), b));
					}
				}
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
			
			//getKeywordReport
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywordReport:");
			try{
				DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
				DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
				ArrayList<ReportObject> kwreport = test.getKeywordReport(accountId, campaignId, firstDay, lastDay, ReportAggregation.Daily);			
				System.out.println("OK");
				for(ReportObject t: kwreport){
					System.out.println("Keyword = " + t.getKeyword());
					System.out.println("BidAmount = " + t.getMicroBidAmount());
					System.out.println("BidMatchType = " + t.getBidMatchType());
					System.out.println("NumberImpressions = " + t.getNumberImpressions());
					System.out.println("NumberClick = " + t.getNumberClick());
					System.out.println("AveragePosition = " + t.getAveragePosition());
					System.out.println("QualityScore = " + t.getQualityScore());
					System.out.println("AverageCPC = " + t.getAverageCPC());
					System.out.println("CreatedDate = " + t.getTransactionDate());
					System.out.println("===========================");
				}
			}
			catch(RemoteException e){
				errorHandler(e);
			}
			catch(Exception e){
				errorHandler(e);
			}
		
		}
		finally{
			cleanUp();
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
	
	public int testFailed(){
		System.out.println(" ");
		System.out.println("####################################################################################");
		System.out.println("#                       Msn Service Test (Standalone) FAILED!                      #");
		System.out.println("####################################################################################");
		return -1;
	}
	
	public int testPassed(){
		System.out.println(" ");
		System.out.println("####################################################################################");
		System.out.println("#                       Msn Service Test (Standalone) PASSED!                      #");
		System.out.println("####################################################################################");
		return 0;
	}


}
