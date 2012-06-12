package semplest.test.unittest;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.SemplestConfiguration;
import semplest.service.keywords.lda.KeywordGeneratorServiceImpl;
import semplest.services.client.api.KeywordLDAServiceClient;

public class KeywordServiceTest {

	private int errorCounter = 0;
	private static String serviceURL = "http://VMDEVJAVA1:9898/semplest";
	
	public static void main(String args[]){
		try{
			KeywordLDAServiceClient client = new KeywordLDAServiceClient("http://172.18.9.22:9898/semplest");
			System.out.println("------------------------------------------------------------");
			System.out.println("getCategories:");		
			long start = System.currentTimeMillis();
			ArrayList<String> res = client.getCategories(null, "rugby sale balls and gloves", "rugby sale balls and gloves", null, null);
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("categories took " + sec + " seconds");
			for (int i = 0; i < res.size(); i++)
			{
				System.out.println(res.get(i));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int Test_KeywordService_Impl(){
		errorCounter = 0;
		
		System.out.println("####################################################################################");
		System.out.println("#                                                                                  #");
		System.out.println("#                           Keyword Service (Impl) Test                            #");
		System.out.println("#                                                                                  #");
		System.out.println("####################################################################################");	
		
		try{
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			
			KeywordGeneratorServiceImpl service = new KeywordGeneratorServiceImpl();
		
			ArrayList<String> res = null;
			try{
				System.out.println("------------------------------------------------------------");
				System.out.println("getCategories:");		
				long start = System.currentTimeMillis();
				res = service.getCategories(null, "rugby sale balls and gloves", "rugby sale balls and gloves", null, null);
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("categories took " + sec + " seconds");
				for (int i = 0; i < res.size(); i++)
				{
					System.out.println(res.get(i));
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			ArrayList<String> selectCateg = new ArrayList<String>();
			selectCateg.add(res.get(0));
			System.out.println("Selected:"+res.get(1));
			
			try{
				System.out.println("------------------------------------------------------------");
				System.out.println("getKeywords:");		
				long start = System.currentTimeMillis();
				KeywordProbabilityObject[] kw = service.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						"rugby sale balls and gloves", "rugby sale balls and gloves", null, "http://www.planetrugby.com", null ,new Integer[]{50,50});
				
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("keywords took " + sec + " seconds");
				
				String kaux=kw[0].getKeyword();
				System.out.println(kaux+" "+kw[0].getSemplestProbability());
			}
			catch(Exception e){
				errorHandler(e);
			}					
		
		}
		catch(Exception e){
			errorHandler(e);
		}
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                       Keyword Service (Impl) Test FAILED!                        #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                       Keyword Service (Impl) Test PASSED!                        #");
			System.out.println("####################################################################################");
		}
		
		return errorCounter;
	}
	
	public int Test_KeywordService_Client(){
		errorCounter = 0;
		
		System.out.println("####################################################################################");
		System.out.println("#                                                                                  #");
		System.out.println("#                          Keyword Service (Client) Test                           #");
		System.out.println("#                                                                                  #");
		System.out.println("####################################################################################");	
		
		try{			
			KeywordLDAServiceClient client = new KeywordLDAServiceClient(serviceURL);
		
			ArrayList<String> res = null;
			try{
				System.out.println("------------------------------------------------------------");
				System.out.println("getCategories:");		
				long start = System.currentTimeMillis();
				res = client.getCategories(null, "rugby sale balls and gloves", "rugby sale balls and gloves", null, null);
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("categories took " + sec + " seconds");
				for (int i = 0; i < res.size(); i++)
				{
					System.out.println(res.get(i));
				}
			}
			catch(Exception e){
				errorHandler(e);
			}
			
			ArrayList<String> selectCateg = new ArrayList<String>();
			selectCateg.add(res.get(0));
			System.out.println("Selected:"+res.get(1));
			
			try{
				System.out.println("------------------------------------------------------------");
				System.out.println("getKeywords:");		
				long start = System.currentTimeMillis();
				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						"rugby sale balls and gloves", "rugby sale balls and gloves", null, "http://www.planetrugby.com", null ,new Integer[]{50,50});
				
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("keywords took " + sec + " seconds");
				
				String kaux=kw[0].getKeyword();
				System.out.println(kaux+" "+kw[0].getSemplestProbability());
			}
			catch(Exception e){
				errorHandler(e);
			}					
		
		}
		catch(Exception e){
			errorHandler(e);
		}
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                      Keyword Service (Client) Test FAILED!                       #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                      Keyword Service (Client) Test PASSED!                       #");
			System.out.println("####################################################################################");
		}
		
		return errorCounter;
	}
	
	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		StackTraceElement[] ste = e.getStackTrace();
		for(StackTraceElement s : ste){
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println();
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}
}
