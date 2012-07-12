package semplest.service.msn.adcenter;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.service.SemplestConfiguration;

import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.Keyword;

import flanagan.plot.PlotGraph;
/**
 * This test has been generated to create campaigns using MSN  and test the data obtained from them.
 * @author lluis
 *
 */

public class MSNAdcenterServiceClientTest {


	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClientTest.class);
	//Parameters to create campaign and adds
	String accountName = "-WeddingHairReduced2";
	String accountNumber = "X1660053";
	String url = "www.WeddingChannel.com";
	String productSubcategory = "Wedding Hair";
	double msnMonthlyBudget = 300.0; //In dolars
			
	//Add1
	String adTitle1 =  "Bridal Hair Style Ideas";
	String adText1 = "Browse hundreds of bridal hair style pictures. View images";
	//Add2
	String adTitle2 = "";
	String adText2 = "";
	
	String addr = "";//"2157 Diamond St";
	String city = "";//"San Diego";
	String state = "CA";
	String country = "US";//"US";
	String zip = "";//"92109";
	Double radius = null;//30.0;
	Double latitude = null; 
	Double longitude = null; 
	
	//Accounts and campaigns
	Long accountID ;
	Long campaignID ;
	Long adGroupID ;	
	Long addID1 ; 
	Long addID2 ;
	long[] keywordIDs;
	
	public static void main(String[] args)
	{
		
		try
		{	
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
		
			BasicConfigurator.configure();
			MSNAdcenterServiceClientTest msn = new MSNAdcenterServiceClientTest();
			
			
			//msn.createCampaign();
			msn.getAccountID();
			//logger.info(msn.accountID);
			//msn.getIds();
			//msn.updateStatus(true);
			
			//msn.setGeoTarget();
			/*Calendar cal = Calendar.getInstance();
			MonthAndYear startMonth = new MonthAndYear();
			startMonth.setMonth(cal.get(Calendar.MONTH) + 1);
			startMonth.setYear(cal.get(Calendar.YEAR) - 1);
			*/
			//msn.insertKeywords("/semplest/data/biddingTest/Recruiting/keywords.txt");
			//msn.updateBidAllKeywords();
			//msn.deletaAllKeywords();
			//msn.insertKeywords2("/semplest/data/biddingTest/WeddingHair/msnSuggestedKw.txt");
			//HashMap<String, Double[][]> bidMap=msn.getKeywordEstimates("/semplest/data/biddingTest/PiperHall/keywords.txt", 1500);
			//msn.plotdata(bidMap);
			
			/*
			HashMap<String, int[][]> volMap = msn.getKeywordVolumes("\\\\fs3\\semplest\\data\\biddingTest\\PiperHall\\keywords.txt", startMonth);
            String outfile = "\\\\fs3\\semplest\\data\\msnData\\PiperHall_volume.dat";
			msn.writeVolumeDataToFile(volMap, outfile);
			
			HashMap<String, String[]> wordMap = msn.getSuggestedKeywords("\\\\fs3\\semplest\\data\\biddingTest\\SummitFlowersNJ\\keywords.txt");
            String outfile = "\\\\fs3\\semplest\\data\\msnData\\SummitFlowersNJ_suggestions.dat";
            
			
			//HashMap<String,String[]> wordMap = msn.getSuggestedKeywordsfromarray(new String[]{"wedding flowers", "flower centerpieces", "floral shop", "flower arrangement"});
			HashMap<String, String[]> wordMap = msn.getSuggestedKeywords("/semplest/data/biddingTest/WeddingHair/30topkw.txt", 100);
			String outfile = "/semplest/data/biddingTest/WeddingHair/msnSuggestedKw.txt";
			msn.writeSuggestionsToFile2(wordMap, outfile);*/
			//logger.info(bidMap);
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}

	}
	
	public HashMap<String,String[]> getSuggestedKeywordsfromarray(String[] kw) throws Exception{
		
		HashMap<String,String[]> wordMap = new HashMap<String,String[]>();
		// get the keyword volume info for this batch
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
	    HashMap<String, String[]> ret = test.getKeywordSuggestions(accountID, kw, 100);

	    // add the results for this batch of keywords
	    for (String keyword : ret.keySet()) {
	    	wordMap.put(keyword, ret.get(keyword));
	    }
	    return wordMap;
	}
	
	public void updateStatus(Boolean isActive) throws Exception{
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		HashMap<Long, Boolean> map = new HashMap<Long,Boolean>();
		Keyword[] kw =test.getKeywordByAdGroupId(accountID, adGroupID);
		for(Keyword kwrd : kw){
			System.out.println(kwrd.getText()+" : "+isActive);
			map.put(kwrd.getId(), isActive);
		}
		test.updateKeywordStatus(accountID, adGroupID, map);
	}
	
	public void deletaAllKeywords() throws Exception{
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		Keyword[] kw =test.getKeywordByAdGroupId(accountID, adGroupID);
		long[] kwIds;
		if(kw.length<=1000){
			kwIds = new long[kw.length];
		}else{
			kwIds = new long[1000];
		}
		for(int i = 0 ; i<kwIds.length; i++){
			kwIds[i] = kw[i].getId();
		}
		keywordIDs = kwIds;
		test.deleteKeywordsById(accountID, adGroupID, keywordIDs);
	}
	
	public void updateBidAllKeywords() throws Exception{
		int kwLimit = 1000;
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		Keyword[] kw =test.getKeywordByAdGroupId(accountID, adGroupID);
		
		int j=0;
		while (j<kw.length){
			int remain = kw.length-j;

			if(remain>=kwLimit){
				remain = kwLimit;
			}
			ArrayList<BidElement> bids = new ArrayList<BidElement>();
			for(int i = 0 ; i<remain && j<kw.length ; i++){
				BidElement bid = new BidElement();
				bid.setKeyword(kw[j].getText());
				bid.setKeywordAdEngineID(kw[j].getId());
				bid.setMatchType("Broad");
				bid.setMicroBidAmount(new Long(1000000));
	
			}
			
			try {
				test.updateKeywordBidsByIds(accountID, adGroupID, bids);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void setGeoTarget() throws Exception{

		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		test.deleteAllTargetsInCampaign(accountID, campaignID);
		Boolean res = test.setGeoTarget(accountID, campaignID, latitude, longitude, radius, addr, city, state, country, zip);
	}
	
	public void getAccountID() throws Exception{
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		 HashMap<String,Long> accounts = test.getAccountIDs();
		 accountID =  accounts.get(accountNumber).longValue();
	}
	public void getIds() throws Exception{
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		Campaign[] ret = test.getCampaignsByAccountId(accountID);
		campaignID = ret[0].getId();
		logger.info("campaignID: "+campaignID);
		AdGroup[] retad = test.getAdGroupsByCampaignId(accountID, campaignID);
		adGroupID = retad[0].getId();
	}
	/*
	public void insertKeywords2(String filename) throws Exception{
		
		
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
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
	    		keywords = new Keyword[1000];
	    		i=0;
	    	}
	    		if(i>=keywords.length) break ;
		      // Print the content on the console
		      strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
		      logger.info("Adding "+ strLine);
		      keywords[i] = new Keyword();
		      keywords[i].setText(strLine);
		      Bid exactMatchBid1 = new Bid();
		      exactMatchBid1.setAmount(2.00);
		      Bid defaultBid1 = new Bid();
		      defaultBid1.setAmount(0.00);
		      keywords[i].setExactMatchBid(null);
		      keywords[i].setBroadMatchBid(null);
		      keywords[i].setContentMatchBid(defaultBid1);
		      keywords[i].setPhraseMatchBid(defaultBid1);
	    	i++;
	    }
	    //Close the input stream
	    in.close();
	    ArrayList<Keyword> kw = new ArrayList<Keyword>();
	    for(int v=0; v<keywords.length; v++){
	    	if(keywords[v]==null) {
	    		break;
	    	}else{
	    		kw.add(keywords[v]);
	    	}
	    }
	    keywords = kw.toArray(new Keyword[]{}); 
	   keywordIDs = test.createKeywords(accountID, adGroupID, keywords);
	}*/
	
	public void insertKeywords(String filename) throws Exception{
		
		
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
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
	      Bid exactMatchBid = new Bid();
	      exactMatchBid.setAmount(1.00);
	      long ret = test.createKeyword(accountID, adGroupID, strLine, MatchType.Exact, exactMatchBid);	
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

			MsnCloudServiceImpl test = new MsnCloudServiceImpl();
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
		    logger.info("Estimating Keywords...");
		    while(j<numKw && strLine!=null){
		    	keywords = new String[1000];
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
			
							double averDaylyCPC = (ret.getAveCPC(k, MatchType.Exact.getValue(), bidList));
							double averDaylyClicks = (ret.getAveClickPerDay(k, MatchType.Exact.getValue(), bidList));
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
	
	// Method to retrieve volume data (search counts) for a set of keywords
	// given in a text file, starting from a specified month and ending
	// in the most recent month possible
	public HashMap<String, int[][]> getKeywordVolumes(String filename,
			                                          MonthAndYear startMonth)
			                                          throws Exception{

		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		String[] keywords;
		HashMap<String, int[][]> volMap = new HashMap<String, int[][]>();
		
		// Prepare to read in the file of keywords
		FileInputStream fstream = new FileInputStream(filename);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine = "";
	    
	    //Read keyword file line By line
	    int j = 0;
	    logger.info("Retrieving bid volumes.");
	    //while (j < numKw && strLine != null){
		while (strLine != null){
	    	keywords = new String[1000];
	    	int i=0;
		    while ((strLine = br.readLine()) != null)   {
		    	if(i>=keywords.length) break;
		        // Print the content on the console
		        strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
		      
		        keywords[i] = strLine;
		        //j++;
		        i++;
		    }
		    
		    // place the keywords into a shortened list
		    // first find how many non-null keywords there are left
		    int v;
		    for(v = 0; v < keywords.length; v++){
		    	if(keywords[v] == null) break;
		    }
		    // place all of the non-null keywords into their own array
		    String[] kwTrim = new String[v];
		    for(v=0; v < kwTrim.length; v++){
		    	kwTrim[v] = keywords[v];
		    }

		    // get the keyword volume info for this batch
		    HashMap<String, int[][]> ret =
		    	test.getKeywordVolumes(accountID, kwTrim, startMonth);

		    // add the results for this batch of keywords
		    for (String keyword : ret.keySet()) {
		    	volMap.put(keyword, ret.get(keyword));
		    }
	    }
		
		return volMap;
	}
	
	// Method to retrieve volume data (search counts) for a set of keywords
	// given in a text file
	// maxRecs is the maximum number of suggestions per keyword.
	public HashMap<String, String[]> getSuggestedKeywords(String filename,
			                                              int maxRecs)
			                                              throws Exception {

		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		String[] keywords;
		HashMap<String, String[]> wordMap = new HashMap<String, String[]>();
		
		// Prepare to read in the file of keywords
		FileInputStream fstream = new FileInputStream(filename);
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine = "";
	    
	    //Read keyword file line By line
	    int j = 0;
	    logger.info("Retrieving suggested keywords.");
	    while (strLine != null){
	    	keywords = new String[1000];
	    	int i=0;
		    while ((strLine = br.readLine()) != null)   {
		    	if(i >= keywords.length) break;
		        // Print the content on the console
		        strLine = strLine.replaceAll("\\[", "").replaceAll("\\]", "");
		      
		        keywords[i] = strLine;
		        i++;
		    }
		    
		    // place the keywords into a shortened list
		    // first find how many non-null keywords there are left
		    int v;
		    for(v = 0; v < keywords.length; v++){
		    	if(keywords[v] == null) break;
		    }
		    // place all of the non-null keywords into their own array
		    String[] kwTrim = new String[v];
		    for(v=0; v < kwTrim.length; v++){
		    	kwTrim[v] = keywords[v];
		    }

		    // get the keyword volume info for this batch
		    HashMap<String, String[]> ret =
		    	test.getKeywordSuggestions(accountID, kwTrim, maxRecs);

		    // add the results for this batch of keywords
		    for (String keyword : ret.keySet()) {
		    	wordMap.put(keyword, ret.get(keyword));
		    }
	    }
		
		return wordMap;
	}
	
	// Method to retrieve volume data (search counts) for a set of keywords
	// given in a text file
	// this is an overloading which does not take the maximum number of
	// recommendations - defaults to 10
	public HashMap<String, String[]> getSuggestedKeywords(String filename)
														  throws Exception {
		return getSuggestedKeywords(filename, 10);
	}
		    
	
	public void createCampaign() throws Exception{
		//Parameters to create campaign and adds
		
		//MSN service instance
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
						
		
		//createAccount
		SemplestString in = new SemplestString();
		in.setSemplestString(accountName);
		semplest.other.MsnManagementIds account = test.createAccount(in);
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
		//addID2 = test.createAd(accountID, adGroupID, adTitle2, adText2, url, url);
		logger.info("adID1: "+addID1);	
		logger.info("adID2: "+addID2);
	}
	
	public void plotdata(HashMap<String,Double[][]> bidMap) throws IOException{
		PrintStream fileoutput = new PrintStream(new FileOutputStream("/semplest/data/msnData/comp/"+accountNumber));
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
	}
	
	// take search volume data and write it to a specified file
	// data is provided as a hash map, taking strings (keywords) to an array
	// of arrays. each top-level array holds three integers: month, year, and
	// search volume for that month
	public void writeVolumeDataToFile(HashMap<String, int[][]> volMap,
			                          String outfile) 
	                                  throws IOException {
		logger.info("Writing to: " + outfile);
		PrintStream fileoutput = new PrintStream(new FileOutputStream(outfile));
		String s = "";
		
		for (String key : volMap.keySet()) {
			int[][] volData = volMap.get(key);
			if(volData != null) {
		    	fileoutput.println("Keyword: " + key);
		    	fileoutput.println("Month, Year, Volume");
		    	for(int v = 0; v < volData.length; v++){
		    		s = volData[v][0]+"\t"+volData[v][1]+"\t"+volData[v][2];
		    		fileoutput.println(s);
		    	}
			}
		}
	}
	//Write a file with unique keywords
	public void writeSuggestionsToFile2(HashMap<String, String[]> wordMap, String outfile) throws IOException {
		logger.info("Writing to: " + outfile);
		PrintStream fileoutput = new PrintStream(new FileOutputStream(new File(outfile)));
		ArrayList<String> keywords = new ArrayList<String>();
		
		for (String key : wordMap.keySet()) {
			String[] recs = wordMap.get(key);
			if(!keywords.contains(key)){
				keywords.add(key);
				fileoutput.println(key);
			}
			if(recs != null) {
		    	for(String kw : recs) {
		    		String[] split = kw.split("\\s+");
		    		if(!keywords.contains(kw) && split.length>1){
		    			keywords.add(kw);
		    			fileoutput.println(kw);
		    		}
		    	}
			}
		}
	
	}
		
	// take keyword suggestion data and write it to a specified file
	// data is provided as a hash map, taking strings (keywords) to a
	// String array of suggested keywords
	public void writeSuggestionsToFile(HashMap<String, String[]> wordMap,
			                           String outfile) 
	                                   throws IOException {
		logger.info("Writing to: " + outfile);
		PrintStream fileoutput = new PrintStream(new FileOutputStream(new File(outfile)));
		
		for (String key : wordMap.keySet()) {
			String[] recs = wordMap.get(key);
			if(recs != null) {
		    	fileoutput.println("Keyword: " + key);
		    	fileoutput.println("Suggestions");
		    	for(int v = 0; v < recs.length; v++) {
		    		fileoutput.println(recs[v]);
		    	}
			}
		}
	}
	
	
	
	
	
}
