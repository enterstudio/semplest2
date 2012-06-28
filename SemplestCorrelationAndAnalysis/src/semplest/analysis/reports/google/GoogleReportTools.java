package semplest.analysis.reports.google;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.joda.time.DateTime;

import com.google.api.adwords.v201109.cm.KeywordMatchType;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.analysis.reports.msn.MSNReportTools;
import semplest.analysis.reports.utils.ReportUtils;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.service.SemplestConfiguration;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MSNAdcenterServiceClientTest;

public class GoogleReportTools {

	/**
	 * Class that obtains, generates and stores MSN reports for further analysis
	 *
	 */
	
	private static final Logger logger = Logger.getLogger(MSNAdcenterServiceClientTest.class);
	private String accountName;
	private Long accountId;
	private Long campaignId;
	private Long adGroupID;
	GoogleAdwordsServiceImpl google;

	public static void main(String[] args) throws Exception {
		
		BasicConfigurator.configure();
		//GoogleReportTools repT = new GoogleReportTools("SemplestBiddingTestPiperHall", 6870692153L, 1);
		
		
		/*
		//Create Report Test for a specific campaign
		String firstDay = "20120525"; 
		String lastDay = "20120525";
		ReportObject[] reps = repT.getKeywordReportObjects(firstDay, lastDay);
		ReportUtils.saveSerializedObject(reps, "/semplest/lluis/PiperHallTest/serializedReportGoogle");
		reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/lluis/PiperHallTest/serializedReportGoogle");
		ReportUtils.saveReportDataCSV(reps, "/semplest/lluis/PiperHallTest/testReportGoogle");
		
		
		//Create FPCPC Report
		ArrayList<String> msnReport = ReportUtils.readFile("/semplest/lluis/fpcpcReport.csv");
		ArrayList<String> keywords = new ArrayList<String>();
		for(String line : msnReport){
			String[] parts = line.split(",");
			keywords.add(parts[0].replaceAll("^\\s+", "").replace("\\s+$", ""));
			
		}
		ArrayList<String> fpcpc = repT.getFPCPCreportForKeywords(keywords,"/home/lluis/Downloads/Keywordreport.csv" );
		ReportUtils.saveArrayListString(fpcpc, "/semplest/lluis/fpcpcReportGoogle.csv");
		*/
		
		//Create correlation report
		ArrayList<String> correl = GoogleReportTools.extractFromFilesFpcpcQSComp("/semplest/data/correlations/FpcpcQsComp/ParkWinters/GoogleDownloadedReport20120531.csv", 
				"/semplest/data/correlations/FpcpcQsComp/ParkWinters/keyword_ideas_20120531_1450686_Exact.csv", "Exact");
		ReportUtils.saveArrayListString(correl, "/semplest/data/correlations/FpcpcQsComp/ParkWinters/20120531FpcpcQSCompReportExact" +
				".csv");
		
	}
	
	public ArrayList<String> getFPCPCreportForKeywords(ArrayList<String> kw, String reportFilePath) throws IOException{
		//Takes in a list of keywords and a report downloaded from Google Reports and generates a report for the fpcpc of the specified keywords
		
		
		ArrayList<String> relevantLines = new ArrayList<String>();
		FileInputStream fstream = new FileInputStream(reportFilePath);
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    int i=0;
	    String line;
	    while((line = br.readLine())!=null){
	    	if(i>2){//Avoid headers
	    		String[] parts = line.split(",");
	    		String keyword = parts[1].replaceAll("\\[", "").replaceAll("\\]", "").replace("\"", "");
	    		if(kw.contains(keyword)){
	    			relevantLines.add(keyword+", "+parts[14]+", "+parts[5]);
	    		}
	    	}
	    	i++;
	    }
	    
	    String[] array = relevantLines.toArray(new String[]{});
	    Arrays.sort(array);
	    return new ArrayList<String>(Arrays.asList(array));
	}
	
	public GoogleReportTools(String accountNameIn, Long accountIdIn, int campaignIndex) throws Exception{
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		google = new GoogleAdwordsServiceImpl();
		accountId = accountIdIn;
		accountName = accountNameIn;
		System.out.println(accountId.toString());
		ArrayList<HashMap<String, String>> campaignsByAccountId = google.getCampaignsByAccountId(accountId.toString(), false);
		campaignId = new Long(campaignsByAccountId.get(campaignIndex).get("Id"));

		
		
	}
	
	public  ArrayList<String> storeTrafficEstimatorDataGoogle(String keyword, KeywordMatchType matchType, Long[] bids) throws Exception{
		//Put in an ArrayList<String> all the TrafficEstimator information
		ArrayList<String> lines = new ArrayList<String>();
		lines.add(keyword+", AveClickPerDay, AveCPC, AvePosition, AveTotalDailyMicroCost");
		for(Long bid : bids){
			String newLine = bid+", ";
			HashMap<String, Long> map = new HashMap<String, Long>();
			map.put(keyword, bid);
			TrafficEstimatorObject te = google.getTrafficEstimationForKeywords(accountId.toString(), campaignId,  matchType, map);
			if(te!=null){
			newLine = newLine+te.getAveClickPerDay(keyword, matchType.getValue(), bid)+", ";
			newLine = newLine+te.getAveCPC(keyword, matchType.getValue(), bid)+", ";
			newLine = newLine+te.getAvePosition(keyword, matchType.getValue(), bid)+", ";
			newLine = newLine+te.getAveTotalDailyMicroCost(keyword, matchType.getValue(), bid)+", ";
			}else{
				newLine= newLine+"-1.0, -1.0, -1.0, -1.0,";
			}
			lines.add(newLine);
		}
		
		return lines;
	}
	
	public ReportObject[] getKeywordReportObjects(String firstDay, String lastDay) throws Exception{
		ReportObject[] reps = google.getReportForAccount(accountId.toString(), firstDay, lastDay);
		ArrayList<ReportObject> repList = new ArrayList<ReportObject>();
		if(reps!=null){
			for(ReportObject rep : reps){
				if(rep.getCampaignID().longValue() == campaignId.longValue()){
					repList.add(rep);
				}
			}
		}
		return repList.toArray(new ReportObject[]{});
	}
	
	public static ArrayList<String> extractFromFilesFpcpcQSComp(String keywordReportPath, String keywordToolPath, String matchType) throws Exception{
		

		ArrayList<String> relevantLines = new ArrayList<String>();
		if(!keywordToolPath.toLowerCase().contains(matchType.toLowerCase()))
			throw new Exception("Input file corresponding to a differt match type");
		relevantLines.add("Keyword, FPCPC, Quality Score, Competition Score");
		FileInputStream fstream = new FileInputStream(keywordReportPath);
	    // Read data from keyword report
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    int i=0;
	    String line;
	    while((line = br.readLine())!=null){
	    	if(i>2){//Avoid headers
	    		String[] parts = line.split(",");
	    		String keyword = parts[1].replaceAll("\\[", "").replaceAll("\\]", "").replace("\"", "");
	    		if(parts[14].equalsIgnoreCase(matchType)){
	    			relevantLines.add(keyword+", "+parts[5]+", "+parts[7]);
	    		}
	    	}
	    	i++;
	    }
	    //Read data from keyword tool
	    
	    FileInputStream fstream2 = new FileInputStream(keywordToolPath);
	    DataInputStream in2 = new DataInputStream(fstream2);
	    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
	    HashMap<String,Double> kwCompMap = new HashMap<String, Double>();
	    i=0;
	    while((line = br2.readLine())!=null){
	    	if(i>1){//Avoid headers
		    	String[] parts = line.split(",");
		    	String keyword = parts[0].replaceAll("\\[", "").replaceAll("\\]", "").replace("\"", "");
		    	if(!parts[1].contains("-"))
		    		kwCompMap.put(keyword, Double.valueOf(parts[1]));
	    	}
	    	i++;
	    }
	    
	    //Add competition score to line
	    i=0;
	    for(int j=0; j<relevantLines.size(); j++){
	    	if(i>0){//Avoid headers
	    		line = relevantLines.get(j);
		    	String[] parts = line.split(",");
		    	if(kwCompMap.containsKey(parts[0])){
		    		line=line+", "+ kwCompMap.get(parts[0]);
		    	}else{
		    		line=line+", -1";
		    	}
		    	relevantLines.set(j, line);
	    	}
	    	i++;
	    }
	    return relevantLines;

		
	}
	

}
