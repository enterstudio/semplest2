package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.joda.time.DateTime;

import com.microsoft.adcenter.v8.ReportAggregation;

import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.services.client.api.GoogleAdwordsServiceClient;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.api.MSNAdcenterServiceClient;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.test.scalability.ScalabilityTests.SERVICE_INDEX;

public class EsbTestThread implements Runnable{

	private SERVICE_INDEX service_index;	
	private int sleep_time;
	private String report_path;
	
	private static int num_service = 4;
	
	private static String testUrl = "http://VMDEVJAVA1:9898/semplest";
	
	public EsbTestThread(SERVICE_INDEX service_index, int test_frequency, String report_path) {
		super();
		this.service_index = service_index;
		this.sleep_time = 60000/test_frequency;
		this.report_path = report_path;
	}


	@Override
	public void run() {
		try{
			if(service_index == SERVICE_INDEX.all){
				while(true){
					Random r = new Random();
					int randomService = r.nextInt(num_service) + 1;
					System.out.println("Sending request to " + SERVICE_INDEX.values()[randomService].toString());
					Run_Service(SERVICE_INDEX.values()[randomService]);
					Thread.sleep(sleep_time);
				}
			}
			else{
				while(true){
					Run_Service(service_index);
					Thread.sleep(sleep_time);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");			
				FileWriter fstream = new FileWriter(report_path);
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("Stop running ESB test thread (frequency " + (60000/sleep_time) + "/min) at time " + new Date());
				out.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
		
	private void Run_Service(ScalabilityTests.SERVICE_INDEX service_index){
		try{
			switch(service_index){
			case service_google:{
				try{					
					GoogleAdwordsServiceClient t = new GoogleAdwordsServiceClient(testUrl);
					String test_accountId = "2188810777";
					ReportObject[] ret = t.getReportForAccount(test_accountId, "20110101", "20120520");					
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case service_msn:{
				try{
					MSNAdcenterServiceClient t = new MSNAdcenterServiceClient(testUrl);
					DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
					DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
					Long test_accountId = 1617055L;
					Long test_campaignId = 130140291L;
					ReportObject[] ret = t.getKeywordReport(test_accountId, test_campaignId, firstDay, lastDay, ReportAggregation.Daily);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case service_keyword:{
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(testUrl);
				ArrayList<String> res = client.getCategories(null, "rugby sale balls and gloves", "rugby sale balls and gloves", null, null);
				
				break;
			}
			case service_bidding:{
				SemplestBiddingServiceClient client = new SemplestBiddingServiceClient(testUrl, null);
				BudgetObject budgetData =  new BudgetObject();
				client.setBidsUpdate(71, "google", budgetData);
				
				break;
			}
			case service_mail:{
				
				break;
			}
			case service_adengine:{
				
				break;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	

}
