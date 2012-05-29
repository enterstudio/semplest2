package semplest.test.other;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import semplest.services.client.test.TestServiceClient;

public class ServiceTestThread implements Runnable{

	private int sleep_time;	
	private String reportPath;
	private FileWriter writer;
	
	public ServiceTestThread(int sleep_time) {
		super();
		this.sleep_time = sleep_time;
	}

	@Override
	public void run() {
		try{	
			String reportName = "sc_" + System.currentTimeMillis();
			reportPath = "Z:\\TestReports\\PerformanceTest\\" + reportName + ".csv";		
			writer = new FileWriter(reportPath);	 
		    writer.append("Computation");
		    writer.append(',');
		    writer.append("Response");
		    writer.append('\n');
		 
			while(true){
				Date now = new Date();				
				System.out.println("TEST SERVICE >>> " 
				+ now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());
				
				TestServiceClient ts = new TestServiceClient();
				
				long start = System.currentTimeMillis();
				String ret = ts.TestMethod("nan");	
				long time = System.currentTimeMillis() - start;
				System.out.println("--- " + ret + " >>> " + time);
				
				String[] ret1 = ret.split("=");
				writer.append(ret1[1]);
			    writer.append(',');
			    writer.append(String.valueOf(time));
			    writer.append('\n');  			
			    
			    writer.flush();
				
				Thread.sleep(sleep_time);				
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
