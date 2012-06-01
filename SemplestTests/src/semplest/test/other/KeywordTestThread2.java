package semplest.test.other;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;

public class KeywordTestThread2 implements Runnable{

	private int sleep_time;	
	
	private HashMap<String, String> wordList;
	
	public KeywordTestThread2(int sleep_time) {
		super();
		this.sleep_time = sleep_time;
	}

	@Override
	public void run() {
		try{		
			init_wordList();
			
			while(true){
				
				Date now = new Date();				
				System.out.println("KEYWORD SERVICE >>> " 
				+ now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());
				
				KeywordLDAServiceClient ts = new KeywordLDAServiceClient(null);
				
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(null);
				long start = System.currentTimeMillis();
				
				Random r = new Random();
				int rWord = r.nextInt(wordList.size());
				String[] keywords = new String[wordList.keySet().size()];
				wordList.keySet().toArray(keywords);
				String k = keywords[rWord];
				String url = wordList.get(k);
				System.out.println("-> " + k + " -> " + url);
				
				ArrayList<String> res = client.getCategories(null, k, k, null, null);
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				//System.out.println("categories took " + sec + " seconds");				
				
				start = System.currentTimeMillis();
				ArrayList<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(5));
				
				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						k, k, null, url, null ,new Integer[]{50,50});
				sec = (double) (System.currentTimeMillis() - start)/1000.0;
				//System.out.println("keywords took " + sec + " seconds");
				
				System.out.println("--- " + (System.currentTimeMillis() - start));
				
				Thread.sleep(sleep_time);				
			}
		}
		catch(Exception e){
			e.printStackTrace();			
		}
	}		
	
	private void init_wordList(){
		wordList = new HashMap<String, String>();
		wordList.put("wedding flower", "http://www.theknot.com");
		wordList.put("peanut butter", "http://peanutbutterlovers.com/");
		wordList.put("flat shoes", "http://www.6pm.com");
		wordList.put("black mascara", "http://www.lancome.com/");
		wordList.put("black handbag", "http://www.bloomingdales.com/");
		wordList.put("coffee maker", "http://www.wholelattelove.com");
		wordList.put("science fiction", "http://www.barnesandnoble.com/");
		wordList.put("cranberry cheesecake", "http://www.juniorscheesecake.com/");		
	}
}
