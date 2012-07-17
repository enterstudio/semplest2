package semplest.system.tester;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KeywordServiceSystemTest implements SemplestKeywordLDAServiceInterface{
	
	private int errorCounter = 0;
	private String vMsg = "Verification FAILED! ";
	
	KeywordLDAServiceClient keywordService;
	ArrayList<String> categories;
	
	public int Test_KeywordService(String serviceURL){
		try{
			errorCounter = 0;
			
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                          Keyword Service (Client) Test                           #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");	
			
			keywordService = new KeywordLDAServiceClient(serviceURL);
			
			/* ***** List of Methods ***** */
			
			getCategories(null, null, null, null, null);
			getKeywords(null, null, null, null, null, null, null, null, null);
			
			/* ***** End of List of Methods ***** */
			
		}
		catch(Exception e){
			System.out.println("------------------------------------------------------------");
			System.out.println("Other Error: ");
			errorHandler(e);
		}
		
		String result = errorCounter > 0 ? "FAILED" : "PASSED";		
		System.out.println(" ");
		System.out.println("####################################################################################");
		System.out.println("#                      Keyword Service (Client) Test "+result+"!                       #");
		System.out.println("####################################################################################");
		
		
		return errorCounter;
	}

	@Override
	public ArrayList<String> getCategories(String companyName,
			String searchTerm, String description, String[] adds, String url)
			throws Exception {
		
		System.out.println("------------------------------------------------------------");
		System.out.println("getCategories:");		
		
		try{			
			long start = System.currentTimeMillis();
			
			//Make the call
			categories = keywordService.getCategories(null, SystemTestDataModel.keyword_SearchTerm, SystemTestDataModel.keyword_Description, null, null);
			
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("categories took " + sec + " seconds");
			for(String cat : categories){
				System.out.println(cat);
			}
			
			//Verification
			if(categories.size() < 1){
				//no category is returned
				errorHandler(new Exception(vMsg + "No category has been returned."));
			}
		}
		catch(Exception e){
			errorHandler(e);
		}		
		
		return null;
	}

	@Override
	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,
			String companyName, String[] searchEngines, String searchTerm,
			String description, String[] adds, String url,
			GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		
		System.out.println("------------------------------------------------------------");
		System.out.println("getKeywords:");		
		
		ArrayList<String> selectCateg = new ArrayList<String>();
		selectCateg.add(categories.get(1));
		System.out.println("Selected:"+categories.get(1));
		
		try{
			System.out.println("------------------------------------------------------------");
			System.out.println("getKeywords:");		
			long start = System.currentTimeMillis();
			
			//Make the call
			KeywordProbabilityObject[] kw = keywordService.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
					SystemTestDataModel.keyword_SearchTerm, SystemTestDataModel.keyword_Description, null, SystemTestDataModel.keyword_LandingPage, null ,new Integer[]{300,100,100});
			
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("keywords took " + sec + " seconds");
			
			System.out.println("num of keywords we get: " + kw.length);
			System.out.println("the 1st keyword listed below:");
			String kaux=kw[0].getKeyword();
			System.out.println(kaux+" "+kw[0].getSemplestProbability());
			
			//Verification
			if(kw.length < 1){
				//no keyword is returned
				errorHandler(new Exception(vMsg + "No keyword has been returned."));
			}
		}
		catch(Exception e){
			errorHandler(e);
		}	
		
		return null;
	}

	//unrelated methods
	@Override
	public void initializeService(String input) throws Exception {		
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		return null;
	}
	
	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		System.out.println();
		Writer error = new StringWriter();
	    PrintWriter printWriter = new PrintWriter(error);
	    e.printStackTrace(printWriter);
	    System.out.println(error.toString());
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}
}
