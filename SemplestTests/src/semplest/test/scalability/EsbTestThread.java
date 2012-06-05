package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
import semplest.services.client.test.TestService2Client;

public class EsbTestThread implements Runnable{
	
	private int sleep_time;
	private FileWriter writer;
	private static String testName = "ESB";
	boolean noError = true;
	
	private static int num_service = 3;
	
	private static String testUrl = "http://172.18.9.26:9898/semplest";
	
	public enum SERVICE_INDEX {all, test, keyword, bidding, google, msn, mail, adengine};
	private SERVICE_INDEX service_index;	
	
	public EsbTestThread(SERVICE_INDEX service_index, int test_frequency) {
		super();
		this.service_index = service_index;
		this.sleep_time = 60000/test_frequency;
		
		try {			
			String reportName = "Test_Load_" + testName + "_" + System.currentTimeMillis() + ".csv";
			String reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName;		
			//String reportPath = "/semplest/TestReports/ScalabilityTest/" + reportName;		
		
			writer = new FileWriter(reportPath);
			
			writer.append("Start Date: " + new Date());
			writer.append(',');
			writer.append("Test Frequency: " + test_frequency);
			writer.append('\n');
			
			writer.append("Service");
			writer.append(',');
			writer.append("Latency");
			writer.append('\n');
			
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		try{			
			if(service_index == SERVICE_INDEX.all){
				while(true){
				//while(noError){
					try{
						Random r = new Random();
						int randomService = r.nextInt(num_service) + 1;
						SERVICE_INDEX run_service = SERVICE_INDEX.values()[randomService];
						long latency  = Run_Service(run_service);
						writer.append(run_service.name());
						writer.append(',');
						writer.append(String.valueOf(latency));
						writer.append('\n');
						writer.flush();
						Thread.sleep(sleep_time);
					}
					catch(Exception e){
						e.printStackTrace();		
						try {
							writer.append("ERROR:");
							writer.append(',');
							Date now = new Date();
							writer.append(now.toString());
							writer.append(',');
							writer.append(e.getMessage());
							writer.append(',');
							StackTraceElement[] ste = e.getStackTrace();
							for(StackTraceElement s : ste){
								writer.append(s.getClassName());
								writer.append(':');
								writer.append(s.getMethodName());
								writer.append(':');
								writer.append(String.valueOf(s.getLineNumber()));
								writer.append(',');
							}		
							writer.append('\n');
							writer.flush();
							noError = false;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			else{
				while(noError){
					try{
						long latency  = Run_Service(service_index);
						writer.append(service_index.name());
						writer.append(',');
						writer.append(String.valueOf(latency));
						writer.append('\n');
						writer.flush();
						Thread.sleep(sleep_time);
					}
					catch(Exception e){
						e.printStackTrace();		
						try {
							writer.append("ERROR:");
							writer.append(',');
							Date now = new Date();
							writer.append(now.toString());
							writer.append(',');
							writer.append(e.getMessage());
							writer.append(',');
							StackTraceElement[] ste = e.getStackTrace();
							for(StackTraceElement s : ste){
								writer.append(s.getClassName());
								writer.append(':');
								writer.append(s.getMethodName());
								writer.append(':');
								writer.append(String.valueOf(s.getLineNumber()));
								writer.append(',');
							}		
							writer.append('\n');
							writer.flush();
							noError = false;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();		
		}		
		finally{
			try {				
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    
		}
		
	}
		
	private long Run_Service(SERVICE_INDEX service_index){
		try{
			switch(service_index){
			case google:{
				try{					
					GoogleAdwordsServiceClient t = new GoogleAdwordsServiceClient(testUrl);
					String test_accountId = "2188810777";
					long start = System.currentTimeMillis();
					ReportObject[] ret = t.getReportForAccount(test_accountId, "20110101", "20120520");		
					long latency = System.currentTimeMillis() - start;
					return latency;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case msn:{
				try{
					MSNAdcenterServiceClient t = new MSNAdcenterServiceClient(testUrl);
					DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
					DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
					Long test_accountId = 1617055L;
					Long test_campaignId = 130140291L;
					long start = System.currentTimeMillis();
					ReportObject[] ret = t.getKeywordReport(test_accountId, test_campaignId, firstDay, lastDay);
					long latency = System.currentTimeMillis() - start;
					return latency;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case keyword:{
				try{
					KeywordLDAServiceClient client = new KeywordLDAServiceClient(testUrl);
					long start = System.currentTimeMillis();
					ArrayList<String> res = client.getCategories(null, "rugby sale balls and gloves", "rugby sale balls and gloves", null, null);
					long latency = System.currentTimeMillis() - start;
					return latency;
				}
				catch(Exception e){
					e.printStackTrace();
					try{
						writer.append("ERROR:");
						writer.append('\n');
						writer.append(e.getMessage());
						StackTraceElement[] ste = e.getStackTrace();
						for(StackTraceElement s : ste){
							writer.append(s.getClassName());
							writer.append(',');
							writer.append(s.getMethodName());
							writer.append(',');
							writer.append(String.valueOf(s.getLineNumber()));
							writer.append(',');
							writer.append('\n');
						}				
						noError = false;
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
				break;
			}
			case bidding:{
				try{
					SemplestBiddingServiceClient client = new SemplestBiddingServiceClient(testUrl, null);
					BudgetObject budgetData =  new BudgetObject();
					long start = System.currentTimeMillis();
					client.setBidsUpdate(71, "google", budgetData);
					long latency = System.currentTimeMillis() - start;
					return latency;
				}
				catch(Exception e){
					e.printStackTrace();
					try{
						writer.append("ERROR:");
						writer.append('\n');
						writer.append(e.getMessage());
						StackTraceElement[] ste = e.getStackTrace();
						for(StackTraceElement s : ste){
							writer.append(s.getClassName());
							writer.append(',');
							writer.append(s.getMethodName());
							writer.append(',');
							writer.append(String.valueOf(s.getLineNumber()));
							writer.append(',');
							writer.append('\n');
						}				
						noError = false;
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
				}
				break;
			}
			case test:{
				try{
					TestService2Client client = new TestService2Client(testUrl);
					long start = System.currentTimeMillis();
					String ret = client.TestMethod("nan");	
					long latency = System.currentTimeMillis() - start;
					return latency;
				}
				catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			case mail:{
				return 0;
				//break;
			}
			case adengine:{
				return 0;
				//break;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
			try{
				writer.append("ERROR:");
				writer.append('\n');
				writer.append(e.getMessage());
				StackTraceElement[] ste = e.getStackTrace();
				for(StackTraceElement s : ste){
					writer.append(s.getClassName());
					writer.append(',');
					writer.append(s.getMethodName());
					writer.append(',');
					writer.append(String.valueOf(s.getLineNumber()));
					writer.append(',');
					writer.append('\n');
				}				
				noError = false;
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{/*
			try {				
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    */
		}
		return -1;
	}	

}
