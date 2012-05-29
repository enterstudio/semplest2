package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.joda.time.DateTime;

import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.services.client.api.GoogleAdwordsServiceClient;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.api.MSNAdcenterServiceClient;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.test.scalability.ScalabilityTests.SERVICE_INDEX;

import com.microsoft.adcenter.v8.ReportAggregation;

public class KeywordTestThread implements Runnable {

	private int sleep_time;
	private String report_path;
	
	private static String testUrl = "http://VMDEVJAVA1:9898/semplest";
	
	public KeywordTestThread(int test_frequency, String report_path) {
		super();
		this.sleep_time = 60000/test_frequency;
		this.report_path = report_path;
	}


	@Override
	public void run() {
		try{
			while(true){
				System.out.println("KEYWORD SERVICE TEST: Sending request");
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(testUrl);
				ArrayList<String> res = client.getCategories(null, "rugby sale balls and gloves", "rugby sale balls and gloves", null, null);
				ArrayList<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(0));				
				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						"rugby sale balls and gloves", "rugby sale balls and gloves", null, "http://www.planetrugby.com", null ,new Integer[]{50,50});
				Thread.sleep(sleep_time);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				FileWriter fstream = new FileWriter(report_path);
				BufferedWriter out = new BufferedWriter(fstream);
				out.append("ERROR!!! - KEYWORD SERVICE TEST - " + e.getMessage());
				out.close();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			try{
				FileWriter fstream = new FileWriter(report_path);
				BufferedWriter out = new BufferedWriter(fstream);
				out.append("Stop running Keyword Service Test thread (frequency " + (60000/sleep_time) + "/min) at >>> " + new Date());
				out.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}		

}
