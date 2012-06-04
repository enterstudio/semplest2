package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.test.scalability.EsbTestThread.SERVICE_INDEX;


public class KeywordTestThread implements Runnable {

	private int sleep_time;
	private FileWriter writer;
	private static String testName = "KEYWORD";	
	private HashMap<String, String> wordList;
	boolean noError = true;
	
	private static String testUrl = "http://172.18.9.26:9898/semplest";
	

	public KeywordTestThread(int test_frequency) {
		super();
		this.sleep_time = 60000/test_frequency;
		
		try {			
			String reportName = "Test_Scalability_" + testName + "_" + System.currentTimeMillis() + ".csv";
			String reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName;		
			//String reportPath = "/semplest/TestReports/ScalabilityTest/" + reportName;		
		
			writer = new FileWriter(reportPath);
			
			writer.append("Start Date: " + new Date());
			writer.append(',');
			writer.append("Test Frequency: " + test_frequency);
			writer.append('\n');
			
			writer.append("timestamp");
			writer.append(',');
			writer.append("keyword");
			writer.append(',');
			writer.append("getCatetories");
			writer.append(',');
			writer.append("getKeywords");
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
			init_wordList();
			int nWord = 0;
			
			while(true){	
			//while(noError){				
								
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(testUrl);				
				
				Date now = new Date();
				writer.append(now.toString());
				writer.append(',');
				writer.flush();
				
				//Random Keyword
				//Random r = new Random();
				//nWord = r.nextInt(wordList.size());					
								
				int numKeywords = wordList.keySet().size();
				String[] keywords = new String[numKeywords];
				wordList.keySet().toArray(keywords);
				String k = keywords[nWord];
				String url = wordList.get(k);			
				
				//Round robin keywords
				if(++nWord > (numKeywords - 1))
					nWord = 0;				
				
				writer.append(k);
				writer.append(',');
				writer.flush();
				
				long start = System.currentTimeMillis();
				ArrayList<String> res = client.getCategories(null, k, k, null, null);
				long latency = System.currentTimeMillis() - start;
				
				writer.append(String.valueOf(latency));
				writer.append(',');
				writer.flush();
				
				ArrayList<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(5));
				
				start = System.currentTimeMillis();
				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						k, k, null, url, null ,new Integer[]{50,50});
				latency = System.currentTimeMillis() - start;			
				
				writer.append(String.valueOf(latency));
				writer.append('\n');				
				writer.flush();
				
				Thread.sleep(sleep_time);				
			}
		}
		catch(Exception e){
			e.printStackTrace();		
			
			try{
				Date now = new Date();
				writer.append(now.toString());
				writer.append(',');				
				writer.append("ERROR:");
				writer.append(',');
				writer.append(e.getMessage());
				writer.append('\n');
				writer.flush();
				/*
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
				*/
				noError = false;
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
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
	
	private void init_wordList(){
		wordList = new HashMap<String, String>();
		wordList.put("wedding flower", "http://www.theknot.com");
		wordList.put("peanut butter", "http://peanutbutterlovers.com/");
		wordList.put("flat shoes", "http://www.6pm.com");
		wordList.put("black mascara", "http://www.lancome.com/");
		wordList.put("white handbag", "http://www.bloomingdales.com/");
		wordList.put("coffee maker", "http://www.wholelattelove.com");
		wordList.put("science fiction", "http://www.barnesandnoble.com/");
		wordList.put("cranberry cheesecake", "http://www.juniorscheesecake.com/");		
		wordList.put("prom dress", "http://www.promgirl.com/");
		wordList.put("hiking gear", "http://www.rei.com/");
	}

}
