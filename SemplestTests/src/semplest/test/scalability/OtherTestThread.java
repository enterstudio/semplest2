package semplest.test.scalability;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import semplest.services.client.api.MSNAdcenterServiceClient;

public class OtherTestThread implements Runnable {

	private int sleep_time;
	private FileWriter writer;
	private static String testName = "ESB";	
	//boolean noError = true;
	
	private static String testUrl = "http://172.18.9.26:9898/semplest";

	public OtherTestThread(int test_frequency) {
		super();
		this.sleep_time = 60000/test_frequency;
		
		try {			
			String reportName = "Test_MemoryLeak_" + testName + "_" + System.currentTimeMillis() + ".csv";
			String reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName;		
			//String reportPath = "/semplest/TestReports/ScalabilityTest/" + reportName;		
		
			writer = new FileWriter(reportPath);
			
			writer.append("Start Date: " + new Date());
			writer.append(',');
			writer.append("Test Frequency: " + test_frequency);
			writer.append('\n');
			
			writer.append("timestamp");			
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
			
			while(true){	
			//while(noError){				
				try{
					//Memory Leak test code
					
					//choose a service that is not available on the ESB
					MSNAdcenterServiceClient client = new MSNAdcenterServiceClient(testUrl);
					
					Date now = new Date();
					writer.append(now.toString());
					writer.append(',');
					writer.flush();
					
					client.getAccountById(1234567L);
					
					Thread.sleep(sleep_time);							
				}
				catch(Exception e){
					e.printStackTrace();		
					
					try{
						writer.append("ERROR:");
						writer.append(',');
						writer.append(e.getMessage());						
						writer.append('\n');
						writer.flush();
						
						//noError = false;
						Thread.sleep(sleep_time);		
					}
					catch(Exception e1){
						e1.printStackTrace();
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
}
