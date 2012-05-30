package semplest.analysis.reports.google;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.joda.time.DateTime;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.analysis.reports.msn.MSNReportTools;
import semplest.analysis.reports.utils.ReportUtils;
import semplest.server.protocol.adengine.ReportObject;
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
		GoogleReportTools repT = new GoogleReportTools("SemplestBiddingTestPiperHall", 6870692153L, 1);
		
		
		/*
		//Create Report Test for a specific campaign
		String firstDay = "20120525"; 
		String lastDay = "20120525";
		ReportObject[] reps = repT.getKeywordReportObjects(firstDay, lastDay);
		ReportUtils.saveSerializedObject(reps, "/semplest/lluis/PiperHallTest/serializedReportGoogle");
		reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/lluis/PiperHallTest/serializedReportGoogle");
		ReportUtils.saveReportDataCSV(reps, "/semplest/lluis/PiperHallTest/testReportGoogle");
		*/
		
		//Create FPCPC Report
		ArrayList<String> msnReport = ReportUtils.readFile("/semplest/lluis/fpcpcReport.csv");
		ArrayList<String> keywords = new ArrayList<String>();
		for(String line : msnReport){
			String[] parts = line.split(",");
			keywords.add(parts[0].replaceAll("^\\s+", "").replace("\\s+$", ""));
			
		}
		ArrayList<String> fpcpc = repT.getFPCPCreportForKeywords(keywords,"/home/lluis/Downloads/Keywordreport.csv" );
		ReportUtils.saveArrayListString(fpcpc, "/semplest/lluis/fpcpcReportGoogle.csv");
		
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
	    		String keyword = parts[1].replaceAll("\\[", "").replaceAll("\\]", "");//.replace("\"", "");
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
	
	public ReportObject[] getKeywordReportObjects(String firstDay, String lastDay) throws Exception{
		ReportObject[] reps = google.getReportForAccount(accountId.toString(), firstDay, lastDay);
		ArrayList<ReportObject> repList = new ArrayList<ReportObject>();
		for(ReportObject rep : reps){
			if(rep.getCampaignID().longValue() == campaignId.longValue()){
				repList.add(rep);
			}
		}
		return repList.toArray(new ReportObject[]{});
	}
	

}
