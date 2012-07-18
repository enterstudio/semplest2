package semplest.system.tester;

import java.util.ArrayList;

import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KeywordServiceSystemTest implements SemplestKeywordLDAServiceInterface{
	
	private String serviceName = "Keyword";
	private int errorCounter = 0;
	
	private KeywordLDAServiceClient keywordService;
	private ArrayList<String> categories;
	
	public int Test_KeywordService(String serviceURL){
		try{
			SystemTestFunc.PrintServiceHead(serviceName);			
			errorCounter = 0;
			
			keywordService = new KeywordLDAServiceClient(serviceURL);
			
			/* ***** List of Methods ***** */
			
			getCategories(null, null, null, null, null);
			getKeywords(null, null, null, null, null, null, null, null, null);
			
			/* ***** End of List of Methods ***** */
			
		}
		catch(Exception e){
			SystemTestFunc.PrintLineSeperator();
			SystemTestFunc.ErrorHandler(e);
			errorCounter++;
		}
		
		SystemTestFunc.PrintServiceEnd(serviceName, errorCounter);		
		return errorCounter;
	}

	@Override
	public ArrayList<String> getCategories(String companyName,
			String searchTerm, String description, String[] adds, String url)
			throws Exception {
		
		SystemTestFunc.PrintLineSeperator();			
		try{			
			long start = System.currentTimeMillis();
			
			System.out.println("getCategories(null, " + SystemTestDataModel.keyword_SearchTerm + ", " + SystemTestDataModel.keyword_Description + ", null, null)");		
			categories = keywordService.getCategories(null, SystemTestDataModel.keyword_SearchTerm, SystemTestDataModel.keyword_Description, null, null);
			
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("categories took " + sec + " seconds");
			for(String cat : categories){
				System.out.println(cat);
			}
			
			//Verification
			if(categories.size() < 1){
				//no category is returned
				SystemTestFunc.ErrorHandler("No category has been returned.");
				errorCounter++;
			}
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
			errorCounter++;
		}		
		
		return null;
	}

	@Override
	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,
			String companyName, String[] searchEngines, String searchTerm,
			String description, String[] adds, String url,
			GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		
		SystemTestFunc.PrintLineSeperator();		
		try{			
			ArrayList<String> selectCateg = new ArrayList<String>();
			selectCateg.add(categories.get(1));
			System.out.println("Selected:"+categories.get(1));	
			
			long start = System.currentTimeMillis();
			
			System.out.println("getKeywords(selectCateg,null, [Google, MSN], " + SystemTestDataModel.keyword_SearchTerm + ", " + SystemTestDataModel.keyword_Description + 
					", null, " + SystemTestDataModel.keyword_LandingPage + ", null , [300,100,100]");
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
				SystemTestFunc.ErrorHandler("No keyword has been returned.");
				errorCounter++;
			}
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
			errorCounter++;
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
}
