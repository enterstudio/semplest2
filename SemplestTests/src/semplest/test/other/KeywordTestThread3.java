package semplest.test.other;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;


public class KeywordTestThread3 implements Runnable {

	private FileWriter writer;
	private HashMap<String, String> wordList;
	//boolean noError = true;
	
	private String testUrl;
	private String boxName;
	

	public KeywordTestThread3(String box) {
		super();
		
		if(box.equals("DEV")){
			this.testUrl = "http://VMDEVJAVA1:9898/semplest";
		}
		else{
			this.testUrl = "http://172.18.9.26:9898/semplest";
		}
		this.boxName = box;
		init_wordList();				
	}


	@Override
	public void run() {
		try{					
			int numKeywords = wordList.keySet().size();
			
			for(int i = 0; i < numKeywords; i++){	
				try{
					
					String[] keywords = new String[numKeywords];
					wordList.keySet().toArray(keywords);
					String k = keywords[i];
					String url = wordList.get(k);			
					
					String reportName = boxName + "_[" + k + "]_" + System.currentTimeMillis() + ".csv";
					String reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName;		
				
					writer = new FileWriter(reportPath);								
								
					KeywordLDAServiceClient client = new KeywordLDAServiceClient(testUrl);				
					
					Date now = new Date();
					writer.append(now.toString());
					writer.append(',');
					writer.flush();					
					
					long start = System.currentTimeMillis();
					ArrayList<String> res = client.getCategories(null, k, k, null, null);
					long latency = System.currentTimeMillis() - start;
					
					writer.append("time get categories = " + String.valueOf(latency));
					writer.append(',');
					writer.append("num categories = " + String.valueOf(res.size()));	
					writer.append('\n');
					writer.append("Category = " + res.get(5));
					writer.append('\n');
					writer.flush();
					
					ArrayList<String> selectCateg = new ArrayList<String>();
					selectCateg.add(res.get(5));											
					
					start = System.currentTimeMillis();
					KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
							k, k, null, url, null ,new Integer[]{50,50});
					latency = System.currentTimeMillis() - start;			
					
					writer.append("time get keywords = " + String.valueOf(latency));
					writer.append(',');
					writer.append("num keywords = " + String.valueOf(kw.length));
					writer.append('\n');
					writer.flush();					
					
					for(int j = 0; j < kw.length - 1; j++){
						writer.append(kw[j].getKeyword());
						writer.append(',');
						writer.append(String.valueOf(kw[j].getSemplestProbability()));
						writer.append('\n');				
						writer.flush();
					}					
					
					writer.close();
					
				}
				catch(Exception e){
					e.printStackTrace();		
					
					try{
						writer.append("ERROR:");
						writer.append(',');
						Date now = new Date();
						writer.append(now.toString());
						writer.append(',');										
						writer.append(e.getMessage());
						writer.append(',');						
						
						///*
						writer.append("DETAILS:");
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
						//*/
						writer.append('\n');
						writer.flush();
						
						//noError = false;
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
	
	public void runKeyword(String keyword){
		
	}
	
	public void init_wordList(){
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
