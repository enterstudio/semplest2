package semplest.analysis.reports.google;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
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
		String lastDay = "2012523";
		String firstDay = "2012522"; 
		ReportObject[] reps = repT.getKeywordReportObjects(firstDay, lastDay);
		ReportUtils.saveSerializedObject(reps, "/semplest/lluis/PiperHallTest/serializedReportGoogle");
		reps = (ReportObject[]) ReportUtils.loadSerializedObject("/semplest/lluis/PiperHallTest/serializedReportGoogle");
		ReportUtils.saveReportDataCSV(reps, "/semplest/lluis/PiperHallTest/testReportGoogle");

	}
	
	public GoogleReportTools(String accountNameIn, Long accountIdIn, int campaignIndex) throws Exception{
		
		//ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
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
		ArrayList<HashMap<String, String>> campaignsByAccountId = google.getCampaignsByAccountId(accountId.toString(), false);
		campaignId = new Long(campaignsByAccountId.get(0).get("Id"));

		
		
	}
	
	public ReportObject[] getKeywordReportObjects(String firstDay, String lastDay) throws Exception{
		ReportObject[] reps = google.getReportForAccount(accountId.toString(), firstDay, lastDay);
		ArrayList<ReportObject> repList = new ArrayList<ReportObject>();
		for(ReportObject rep : reps){
			if(rep.getCampaignID().longValue() == accountId.longValue()){
				repList.add(rep);
			}
		}
		return repList.toArray(new ReportObject[]{});
	}
	

}
