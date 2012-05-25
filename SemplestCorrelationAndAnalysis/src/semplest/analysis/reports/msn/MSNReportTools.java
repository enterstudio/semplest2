
package semplest.analysis.reports.msn;

import java.io.*;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.joda.time.DateTime;

import semplest.analysis.reports.utils.ReportUtils;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.service.msn.adcenter.MSNAdcenterServiceClientTest;
import semplest.service.msn.adcenter.MsnCloudException;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;


import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.ReportAggregation;



/**
 * Class that obtains, generates and stores MSN reports for further analysis
 *
 */
public class MSNReportTools {
	
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClientTest.class);
	private String accountName;
	private Long accountId;
	private Long campaignId;
	private Long adGroupID; 
	private Double estimateStart = 0.1;
	private Double estimateEnd = 10.0;
	private Double estimateStep = 0.1;
	
	
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		MSNReportTools repT = new MSNReportTools("_ParkWinters",0);
		DateTime lastDay = new DateTime(2012,5,23,0,0,0,0);
		DateTime firstDay = new DateTime(2012,5,22,0,0,0,0);
		ReportObject[] reps = repT.getKeywordReportObjects(firstDay, lastDay);
		ReportUtils.saveSerializedObject(reps, "/semplest/lluis/PiperHallTest/serializedReport");
		reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/lluis/PiperHallTest/serializedReport");
		ReportUtils.saveReportDataCSV(reps, "/semplest/lluis/PiperHallTest/testReport3");

	}
	
	MSNReportTools(String acName, int campaignIndex) throws Exception{
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		
		accountName = acName;
		HashMap<String,Double> accounts = test.getAccountIDs();
		accountId =  accounts.get(accountName).longValue();
		Campaign[] ret = test.getCampaignsByAccountId(accountId);
		campaignId = ret[campaignIndex].getId();
		logger.info("campaignID: "+campaignId);
		AdGroup[] retad = test.getAdGroupsByCampaignId(accountId, campaignId);
		adGroupID = retad[0].getId();
	}
	
	
	public ReportObject[] getKeywordReportObjects(DateTime firstDay, DateTime lastDay) throws Exception{
		MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
		ReportObject[] reports =  msn.getKeywordReport(accountId, campaignId, firstDay, lastDay);
		return this.addFPCPCtoReport(reports);
	}
	
	
	
	public ReportObject[] addFPCPCtoReport(ReportObject[] reps) throws Exception{
		MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
		
		ArrayList<Double> bids = ReportUtils.createbids(estimateStart, estimateEnd, estimateStep);
		Long[] bidsMoney = new Long[bids.size()]; 
	    for(int f =0 ; f< bids.size();f++){
	    	long bidL = (long) (bids.get(f)*1000000);
	    	bidsMoney[f] = new Long(bidL);
	    }
		
		ArrayList<String> kwExact = new ArrayList<String>();
		ArrayList<String> kwPhrase = new ArrayList<String>();
		ArrayList<String> kwBroad = new ArrayList<String>();
		
		for(int i=0; i<reps.length ; i++){
			if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Exact.getValue()))
				kwExact.add(reps[i].getKeyword());
			if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Phrase.getValue()))
				kwPhrase.add(reps[i].getKeyword());
			if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Broad.getValue()))
				kwBroad.add(reps[i].getKeyword());
		}
		
		TrafficEstimatorObject teExact = null;
		TrafficEstimatorObject tePhrase = null;
		TrafficEstimatorObject teBroad = null;
		
		if(kwExact.size()>0){
			teExact = msn.getKeywordEstimateByBids(accountId, kwExact.toArray(new String[]{}), 
					bidsMoney, MatchType.Exact);
		}
		
		if(kwPhrase.size()>0){
			tePhrase = msn.getKeywordEstimateByBids(accountId, kwPhrase.toArray(new String[]{}), 
					bidsMoney, MatchType.Phrase);
		}
		
		if(kwBroad.size()>0){
			teBroad = msn.getKeywordEstimateByBids(accountId, kwBroad.toArray(new String[]{}), 
					bidsMoney, MatchType.Broad);
		}
			
		for(int i=0; i<reps.length ; i++){
			if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Exact.getValue())){
				reps[i]=this.getUpdateFPCPC(reps[i], teExact , MatchType.Exact.getValue());
			}
			if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Phrase.getValue())){
				reps[i]=this.getUpdateFPCPC(reps[i], tePhrase ,MatchType.Phrase.getValue());
			}
			if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Broad.getValue())){
				reps[i]=this.getUpdateFPCPC(reps[i], teBroad, MatchType.Broad.getValue() );
			}
				
		}

		return reps;
		
	}
	
	public ReportObject getUpdateFPCPC(ReportObject rep, TrafficEstimatorObject te, String matchType) throws Exception{
		Long fpcpc = -1000000L;
		if(te!=null){
				Long[] bids = te.getBidList(rep.getKeyword(), matchType);
				if(bids!=null){
				Arrays.sort(bids);
				Long refBid = bids[bids.length-1];
				Long refClicks = te.getAveClickPerDay(rep.getKeyword(), matchType, refBid).longValue();
				
				for( Long bid : bids){
					if(refClicks-te.getAveClickPerDay(rep.getKeyword(), matchType, bid).longValue()<=0){
						fpcpc = bid;
						break;
					}
				}
			}
		}
		rep.setFirstPageCPC(fpcpc);
		return rep;
	}

}
