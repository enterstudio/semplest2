
package semplest.analysis.reports.msn;

import java.io.*;
import java.rmi.RemoteException;
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
	private MsnCloudServiceImpl msn;
	
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		MSNReportTools repT = new MSNReportTools("_PiperHall",1);
		String firstDay = "20120526";
		String lastDay = "20120526";
		
		/*
		//Create Report Test for a specific campaign
		ReportObject[] reps = repT.getKeywordReportObjects(firstDay, lastDay);
		ReportUtils.saveSerializedObject(reps, "/semplest/lluis/PiperHallTest/serializedReport");
		reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/lluis/PiperHallTest/serializedReport");
		ReportUtils.saveReportDataCSV(reps, "/semplest/lluis/PiperHallTest/testReport3");
		*/
		
		
		//Create FPCPC Report
		ArrayList<String> fpcpc = repT.getFPCPCreportForCampaign();
		ReportUtils.saveArrayListString(fpcpc, "/semplest/lluis/fpcpcReport.csv");

	}
	
	public MSNReportTools(String acName, int campaignIndex) throws Exception{
		msn = new MsnCloudServiceImpl();
		
		accountName = acName;
		HashMap<String,Double> accounts = msn.getAccountIDs();
		accountId =  accounts.get(accountName).longValue();
		Campaign[] ret = msn.getCampaignsByAccountId(accountId);
		campaignId = ret[campaignIndex].getId();
		logger.info("campaignID: "+campaignId);
		AdGroup[] retad = msn.getAdGroupsByCampaignId(accountId, campaignId);
		adGroupID = retad[0].getId();

	}
	
	
	public ReportObject[] getKeywordReportObjects(String firstDayStr, String lastDayStr) throws Exception{

		DateTime lastDay = new DateTime(Integer.valueOf(lastDayStr.substring(0, 4)),Integer.valueOf(lastDayStr.substring(4, 6)),
				Integer.valueOf(lastDayStr.substring(6, 8)),0,0,0,0);
		DateTime firstDay = new DateTime(Integer.valueOf(firstDayStr.substring(0, 4)),Integer.valueOf(firstDayStr.substring(4, 6)),
				Integer.valueOf(firstDayStr.substring(6, 8)),0,0,0,0);
		ReportObject[] reports =  msn.getKeywordReport(accountId, campaignId, firstDay, lastDay);
		return this.addFPCPCtoReport(reports);
	}
	
	public ArrayList<String> getFPCPCreportForCampaign() throws Exception{
		
		ArrayList<String> ret = new ArrayList<String>();
		Keyword[] keywords = msn.getKeywordByAdGroupId(accountId, adGroupID);
		
		ArrayList<String> kwExact = new ArrayList<String>();
		ArrayList<String> kwPhrase = new ArrayList<String>();
		ArrayList<String> kwBroad = new ArrayList<String>();
		if(keywords!=null){
			for(int i=0; i<keywords.length ; i++){
				if(keywords[i].getExactMatchBid().getAmount()==null || keywords[i].getExactMatchBid().getAmount() > 0)
					kwExact.add(keywords[i].getText());
				if(keywords[i].getPhraseMatchBid().getAmount()==null ||keywords[i].getPhraseMatchBid().getAmount() > 0)
					kwPhrase.add(keywords[i].getText());
				if(keywords[i].getBroadMatchBid().getAmount()==null || keywords[i].getBroadMatchBid().getAmount() > 0)
					kwBroad.add(keywords[i].getText());
			}
		}
		
		TrafficEstimatorObject[] te = this.getTrafficEstimatorforKeywords(kwExact, kwPhrase, kwBroad); 
		Long fpcpc;
		for(String kw : kwExact){
			fpcpc = this.calculateFPCPCfromTrafEst(kw, te[0], MatchType.Exact.getValue());
			if(fpcpc>0){
				ret.add(kw+", Exact, "+ fpcpc.doubleValue()/1000000);
			}
		}
		for(String kw : kwPhrase){
			fpcpc = this.calculateFPCPCfromTrafEst(kw, te[1], MatchType.Phrase.getValue());
			if(fpcpc>0){
				ret.add(kw+", Phrase, "+ fpcpc.doubleValue()/1000000);
			}
		}
		for(String kw : kwBroad){
			fpcpc = this.calculateFPCPCfromTrafEst(kw, te[2], MatchType.Broad.getValue());
			if(fpcpc>0){
				ret.add(kw+", Broad, "+ fpcpc.doubleValue()/1000000);
			}
		}
		
		String[] array = ret.toArray(new String[]{});
	    Arrays.sort(array);
	    return new ArrayList<String>(Arrays.asList(array));
	}
	
	public ReportObject[] addFPCPCtoReport(ReportObject[] reps) throws Exception{
		
		ArrayList<String> kwExact = new ArrayList<String>();
		ArrayList<String> kwPhrase = new ArrayList<String>();
		ArrayList<String> kwBroad = new ArrayList<String>();
		if(reps!=null){
			for(int i=0; i<reps.length ; i++){
				if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Exact.getValue()))
					kwExact.add(reps[i].getKeyword());
				if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Phrase.getValue()))
					kwPhrase.add(reps[i].getKeyword());
				if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Broad.getValue()))
					kwBroad.add(reps[i].getKeyword());
			}
			
			TrafficEstimatorObject[] te = this.getTrafficEstimatorforKeywords(kwExact, kwPhrase, kwBroad);
							
			for(int i=0; i<reps.length ; i++){
				if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Exact.getValue())){
					reps[i]=this.getUpdateFPCPC(reps[i], te[0] , MatchType.Exact.getValue());
				}
				if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Phrase.getValue())){
					reps[i]=this.getUpdateFPCPC(reps[i], te[1] ,MatchType.Phrase.getValue());
				}
				if(reps[i].getBidMatchType().equalsIgnoreCase(MatchType.Broad.getValue())){
					reps[i]=this.getUpdateFPCPC(reps[i], te[2], MatchType.Broad.getValue() );
				}
					
			}
		}
		return reps;
		
	}
	
	public TrafficEstimatorObject[] getTrafficEstimatorforKeywords(ArrayList<String> kwExact, 
			ArrayList<String> kwPhrase, ArrayList<String> kwBroad ) throws MsnCloudException{
		
		TrafficEstimatorObject[] te = new TrafficEstimatorObject[3];
		ArrayList<Double> bids = ReportUtils.createbids(estimateStart, estimateEnd, estimateStep);
		Long[] bidsMoney = new Long[bids.size()]; 
	    for(int f =0 ; f< bids.size();f++){
	    	long bidL = (long) (bids.get(f)*1000000);
	    	bidsMoney[f] = new Long(bidL);
	    }
		
		if(kwExact.size()>0){
			te[0] = new TrafficEstimatorObject();
			ArrayList<ArrayList<String>> kwTrim = ReportUtils.trimArrayToMaxLength(kwExact, 1000);
			for(ArrayList<String> subkwTrim: kwTrim){
				te[0].addGoogleTrafficEstimatorObject(msn.getKeywordEstimateByBids(accountId, subkwTrim.toArray(new String[]{}), 
						bidsMoney, MatchType.Exact), MatchType.Exact.getValue());
			}
			
		}
		
		if(kwPhrase.size()>0){
			te[1] = new TrafficEstimatorObject();
			ArrayList<ArrayList<String>> kwTrim = ReportUtils.trimArrayToMaxLength(kwPhrase, 1000); 
			for(ArrayList<String> subkwTrim: kwTrim){
				te[1].addGoogleTrafficEstimatorObject(msn.getKeywordEstimateByBids(accountId, subkwTrim.toArray(new String[]{}), 
						bidsMoney, MatchType.Phrase), MatchType.Phrase.getValue());
			}
		}
		
		if(kwBroad.size()>0){
			te[2] = new TrafficEstimatorObject();
			ArrayList<ArrayList<String>> kwTrim = ReportUtils.trimArrayToMaxLength(kwBroad, 1000); 
			for(ArrayList<String> subkwTrim: kwTrim){
				te[2].addGoogleTrafficEstimatorObject(msn.getKeywordEstimateByBids(accountId, subkwTrim.toArray(new String[]{}), 
					bidsMoney, MatchType.Broad), MatchType.Broad.getValue());
			}
		}
		return te;
	}
	
	
	public Long calculateFPCPCfromTrafEst(String kw, TrafficEstimatorObject te, String matchType) throws Exception{
		
		Long fpcpc = -1000000L;
		if(te!=null){
				Long[] bids = te.getBidList(kw, matchType);
				if(bids!=null){
				Arrays.sort(bids);
				Long refBid = bids[bids.length-1];
				Long refClicks = te.getAveClickPerDay(kw, matchType, refBid).longValue();
				
				for( Long bid : bids){
					if(refClicks-te.getAveClickPerDay(kw, matchType, bid).longValue()<=0){
						fpcpc = bid;
						break;
					}
				}
			}
		}
		return fpcpc;
	}
	
	public ReportObject getUpdateFPCPC(ReportObject rep, TrafficEstimatorObject te, String matchType) throws Exception{
		Long fpcpc = -1000000L;
		if(te!=null)
			fpcpc = this.calculateFPCPCfromTrafEst(rep.getKeyword(), te, matchType);
		rep.setFirstPageCPC(fpcpc);
		return rep;
	}

}
