package semplest.services.client.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
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
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.joda.time.DateTime;

import semplest.other.KeywordEstimate;
import semplest.other.Maybe;
import semplest.other.Money;
import semplest.other.MsnCloudKeywordProxy;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.msn.*;
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;

import com.google.gson.Gson;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import flanagan.plot.PlotGraph;
import semplest.services.client.api.MSNAdcenterServiceClient;
/**
 * This test has been generated to create campaigns using MSN  and test the data obtained from them.
 * @author lluis
 *
 */

public class MSNAdcenterServiceClientTest {


	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClientTest.class);
	//Parameters to create campaign and adds
	String accountName = "_PiperHall";
	String url = "www.piperhall.com";
	String productSubcategory = "Event and portrait photos";
	double msnMonthlyBudget = 150.0; //In dolars
			
	//Add1
	String adTitle1 =  "Corporate Event Space";
	String adText1 = "Event space rental located in Fort Worth's W. 7th Street district.";
	//Add2
	String adTitle2 =  "Company Events Fort Worth";
	String adText2 = "Piper Hall is the perfect place for your company party or event.";
	
	//Accounts and campaigns
	Long accountID = 1632282L;
	Long campaignID = 110138069L;
	Long adGroupID = 706138552L;	
	Long addID1 = 907897094L; 
	Long addID2 = 907897096L;
	long[] keywordIDs;
	
	public static void main(String[] args)
	{
		
		try
		{	
			BasicConfigurator.configure();
			MSNAdcenterServiceClientTest msn = new MSNAdcenterServiceClientTest();
			//msn.createCampaign();
			msn.getAccountID();
			logger.info(msn.accountID);
			msn.getIds();
			
			//msn.insertKeywords("/semplest/data/biddingTest/StudioBloom/keywords.txt");
			//msn.insertKeywords2("/semplest/data/biddingTest/PiperHall/keywords.txt");
			//HashMap<String,Double[][]> bidMap=msn.getKeywordEstimates("/semplest/data/biddingTest/PiperHall/keywords.txt", 1500);
			//msn.plotdata(bidMap);
			//logger.info(bidMap);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void getAccountID() throws Exception{
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
		 HashMap<String,Double> accounts = test.getAccountIDs();
		 accountID =  accounts.get(accountName).longValue();
	}
	public void getIds() throws Exception{
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
		Campaign[] ret = test.getCampaignsByAccountId(accountID);
		campaignID = ret[0].getId();
		logger.info("campaignID: "+campaignID);
		AdGroup[] retad = test.getAdGroupsByCampaignId(accountID, campaignID);
		adGroupID = retad[0].getId();
	}
	public void insertKeywords2(String filename) throws Exception{
		
		
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
		//createKeywords
		Keyword[] keywords = new Keyword[1000];
		FileInputStream fstream = new FileInputStream(filename);
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    //Read File Line By Line
	    String strLine;
	    int i=0;
	    while ((strLine = br.readLine()) != null)   {
	    	if(i>=1000){
	    		keywordIDs = test.createKeywords(accountID, adGroupID, keywords);
	    		keywords = new Keyword[500];
	    		i=0;
	    	}
	    		if(i>=keywords.length) break ;
		      // Print the content on the console
		      strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
		      logger.info("Adding "+ strLine);
		      keywords[i] = new Keyword();
		      keywords[i].setText(strLine);
		      Bid exactMatchBid1 = new Bid();
		      exactMatchBid1.setAmount(1.00);
		      Bid defaultBid1 = new Bid();
		      defaultBid1.setAmount(0.00);
		      keywords[i].setExactMatchBid(exactMatchBid1);
		      keywords[i].setBroadMatchBid(defaultBid1);
		      keywords[i].setContentMatchBid(defaultBid1);
		      keywords[i].setPhraseMatchBid(defaultBid1);
	    	i++;
	    }
	    //Close the input stream
	    in.close();
	    keywordIDs = test.createKeywords(accountID, adGroupID, keywords);
	}
	
	public void insertKeywords(String filename) throws Exception{
		
		
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
		//createKeywords
		FileInputStream fstream = new FileInputStream(filename);
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    //Read File Line By Line
	    String strLine;
	    int i=0;
	    while ((strLine = br.readLine()) != null)   {
	   
	      // Print the content on the console
	      strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
	      logger.info("Adding "+ strLine);
	      Bid exactMatchBid1 = new Bid();
	      exactMatchBid1.setAmount(1.00);
	      Bid Bid1 = new Bid();
	      Bid1.setAmount(0.00);
	      long ret = test.createKeyword(accountID, adGroupID, strLine, Bid1, Bid1, exactMatchBid1, Bid1);	
	      logger.info("KeywordID"+ret);
	      i++;
	    }
	    //Close the input stream
	    in.close();

	}
	
	public ArrayList<Double> createbids(double start, double end, double step){
		ArrayList<Double> bids = new ArrayList<Double>();
		Double bid = start;
		
		while(bid<end){
			bids.add(bid);
			bid = bid+step;
		}
		return bids;
	}
	public HashMap<String, Double[][]> getKeywordEstimates(String filename, int numKw) throws Exception{

			MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
			String[] keywords;
			HashMap<String, Double[][]> bidMap = new HashMap<String,Double[][]>();
			
			//Create bid points
			ArrayList<Double> bids = this.createbids(0.1, 10.0, 0.1);
			Double[][] bidDat = new Double[bids.size()][3];

			FileInputStream fstream = new FileInputStream(filename);
		    // Get the object of DataInputStream
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String strLine="";
		    //Read File Line By Line
		    int j=0;
		    int n=0;
		    Long[] bidsMoney = new Long[bids.size()]; 
		    for(int f =0 ; f< bids.size();f++){
		    	long bidL = (long) (bids.get(f)*1000000);
		    	bidsMoney[f] = new Long(bidL);
		    }
		    logger.info("Adding Keywords...");
		    while(j<numKw && strLine!=null){
		    	keywords = new String[100];
		    	int i=0;
			    while ((strLine = br.readLine()) != null)   {
			    	if(i>=keywords.length) break ;
			      // Print the content on the console
			      strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
			      //logger.info("Adding "+ strLine);
			      
			      keywords[i] = strLine;
			      j++;
			      i++;
			    }
			    int v;
			    for(v=0; v<keywords.length; v++){
			    	if(keywords[v]==null) break;
			    }
			    String[] kwTrim = new String[v];
			    for(v=0; v<kwTrim.length; v++){
			    	kwTrim[v] = keywords[v];
			    }
			    
			    TrafficEstimatorObject ret = test.getKeywordEstimateByBids(accountID, kwTrim, bidsMoney, MatchType.Exact);
			    for(String k : ret.getListOfKeywords()){
					logger.info("keyword = " + k);
					v=0;
					if(ret.getBidList(k, MatchType.Exact.getValue())!=null){
						v=0;
						Long[] bidarray = ret.getBidList(k, MatchType.Exact.getValue());
						for(Long bidList:ret.getBidList(k, MatchType.Exact.getValue())){
			
							double averDaylyCPC = (ret.getAveCPC(k, MatchType.Exact.getValue(), bidList))/14.0;
							double averDaylyClicks = (ret.getAveClickPerDay(k, MatchType.Exact.getValue(), bidList))/14.0;
							if(!bidMap.containsKey(k))
								bidDat = new Double[bids.size()][3]; 
							else
								bidDat =bidMap.get(k);

							bidDat[v][0]= bidList.doubleValue();
							bidDat[v][1]= averDaylyCPC;
							bidDat[v][2]= averDaylyClicks;
							bidMap.put(k, bidDat);
							v++;
							
						}
					} else{
						bidMap.put(k, null);
					}
			    }
		    }
			return bidMap;
		}
		    
	
	public void createCampaign() throws Exception{
		//Parameters to create campaign and adds
		
		//MSN service instance
		MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(null);
						
		
		//createAccount
		SemplestString in = new SemplestString();
		in.setSemplestString(accountName);
		MsnManagementIds account = test.createAccount(in);
		logger.info("AccountID: "+account.getAccountId());	
		accountID = account.getAccountId();
		
		
		//createCampaign
		CampaignStatus cpst = null;
		campaignID = test.createCampaign(accountID,productSubcategory, BudgetLimitType.DailyBudgetStandard, (msnMonthlyBudget/16), 
				msnMonthlyBudget, cpst.Paused);
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
	
	public void plotdata(HashMap<String,Double[][]> bidMap) throws IOException{
		PrintStream fileoutput = new PrintStream(new FileOutputStream("/semplest/data/msnData/"+accountName));
		Set<String> keySet = bidMap.keySet();
		for ( String key : keySet ){
			boolean plot=false;
			Double[][] bidData = bidMap.get(key);
			if(bidData !=null){
				//bidData
				double [][] dataclicks = PlotGraph.data(1,bidData.length);
				double [][] datacost = PlotGraph.data(1,bidData.length);
	
		    	// Read in the data
		    	int[] nPoints = new int[bidData.length];
		    	for(int i=0; i< bidData.length ; i++){
		        	if(bidData[i][1] != null){
		        		dataclicks[0][i]=bidData[i][0];       // x-axis data
		           		dataclicks[1][i]=bidData[i][2];     // y-axis data
		           		if(bidData[i][2]>0) plot = true;
		           		datacost[0][i]=bidData[i][0];       // x-axis data
		           		datacost[1][i]=bidData[i][1];     // y-axis data
		           		if(bidData[i][1]>0) plot = true;
		        	}
		        	else{
		        		dataclicks[0][i]=0;       // x-axis data
		           		dataclicks[1][i]=0;     // y-axis data
		           		datacost[0][i]=0;       // x-axis data
		           		datacost[1][i]=0;     // y-axis data
		        	}
		    	}
	
		    	// Create an instance of PlotGraph
		    	if(plot==true){
			    	PlotGraph pgclicks = new PlotGraph(dataclicks);
			    	PlotGraph pgcost = new PlotGraph(datacost);
			    	pgclicks.setGraphTitle("Clicks :"+key);            // Enter graph title
			    	pgcost.setGraphTitle("CPC :"+key);
			    	int[] pointOptions = {1};        // Set point option to open circles on the first graph line and filled circles on the second graph line
			    	pgclicks.setPoint(pointOptions);
			    	pgclicks.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation
			    	
			    	pgcost.setPoint(pointOptions);
			    	pgcost.setLine(1);
			    	// Call plotting method
			    	pgclicks.plot();
			    	pgcost.plot();
			    	PrintStream stdout = System.out;
			    	System.setOut(fileoutput);
			    	System.out.println("Keyword: "+key);
			    	System.out.println("Clicks and CPC");
			    	for(int v= 0; v<dataclicks[0].length;v++){
			    		System.out.println(dataclicks[0][v]+"\t"+dataclicks[1][v]+"\t"+datacost[1][v]+"\t");
			    	}
			    	System.setOut(stdout);
		    	}
			}
		}
		
		/* Old version
		public HashMap<String, Double[][]> getKeywordEstimates(String filename, int numKw) throws Exception{
			MSNAdcenterServiceClient test = new MSNAdcenterServiceClient(BASEURLTEST);
			String[] keywords;
			HashMap<String, Double[][]> bidMap = new HashMap<String,Double[][]>();
			
			//Create bid points
			ArrayList<Double> bids = this.createbids(2.0, 4.0, 0.01);
			Double[][] bidDat = new Double[bids.size()][3];
			int v=0;
			for(Double bidpoint:bids){
				FileInputStream fstream = new FileInputStream(filename);
			    // Get the object of DataInputStream
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
			    String strLine="";
			    //Read File Line By Line
			    int j=0;
			    int n=0;
			    while(j<numKw && strLine!=null){
			    	keywords = new String[1000];
			    	int i=0;
				    while ((strLine = br.readLine()) != null)   {
				    	if(i>=keywords.length) break ;
				      // Print the content on the console
				      strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
				      logger.info("Adding "+ strLine);
				      keywords[i] = strLine;
				      keywords[i] = strLine;
				      j++;
				      i++;
				    }
				    //Close the input stream
				    
				    long bidL = (long) (bidpoint*100000);
					Money bid = new Money(bidL);
					int m=0;
					String[] keywordsaux = new String[1000];
					for(String kw: keywords){
						if(kw!=null){
							keywordsaux[m]=kw;
							m++;
						}
					}
					keywords = new String[m];
					m=0;
					for(String kw: keywordsaux){
						if(kw!=null){
							keywords[m]=kw;
							m++;
						}
					}
					Money[] bids;
					Double amount = 0.05;
		
					
					TrafficEstimatorObject ret = test.getKeywordEstimateByBids(accountID, keywords, bid);
					String[] keywrds = ret.getListOfKeywords();
					for(String k : keywrds){
						

							logger.info("keyword = " + k);
							//for(EstimatedPositionAndTraffic pt : pts){
							if(pts.length>0){
								EstimatedPositionAndTraffic pt = ret.getAvePosition(keyword, bid);//Get only exact match
								double averDaylyCost = (pt.getMaxTotalCostPerWeek()+pt.getMinTotalCostPerWeek())/14.0;
								double averDaylyClicks = (pt.getMinClicksPerWeek()+pt.getMaxClicksPerWeek())/14.0;
								if(!bidMap.containsKey(k.getKeyword()))
									bidDat = new Double[bids.size()][3]; 
								else
									bidDat =bidMap.get(k.getKeyword());
								if(v==1)
									logger.info("here");
								bidDat[v][0]= bidpoint;
								bidDat[v][1]= averDaylyCost;
								bidDat[v][2]= averDaylyClicks;
								bidMap.put(k.getKeyword(), bidDat);
								n++;
							}
						
					}
			    }
				logger.info("Total Number of kw with info: "+ n);
				logger.info("Total Number of kw: "+ j);
				in.close();
				v++;
			}
			return bidMap;
		}*/
	}
	
}
