package semplest.system.tester;

import java.util.ArrayList;
import java.util.List;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KeywordServiceTest implements SemplestKeywordLDAServiceInterface{
	
	private String serviceName = "Keyword";
	
	private KeywordLDAServiceClient keywordService;
	private List<String> retCategories;
	
	public static void main(String[] args){
		String serviceURL = "http://VMDEVJAVA1:9898/semplest";
		
		KeywordServiceTest test = new KeywordServiceTest();
		test.Test_KeywordService(serviceURL);
	}
	
	public int Test_KeywordService(String serviceURL){
		try{
			SystemTestFunc.PrintServiceHeader(serviceName);			
			SystemTestDataModel.errorCounter = 0;
			
			keywordService = new KeywordLDAServiceClient(serviceURL);
			
			/* ***** List of Methods ***** */
			
			getCategories(null, null, null, null, null);
			getKeywords(null, null, null, null, null, null, null, null, null);
			
			/* ***** End of List of Methods ***** */
			
		}
		catch(Exception e){
			SystemTestFunc.PrintLineSeperator();
			SystemTestFunc.ErrorHandler(e);
		}
		
		SystemTestFunc.PrintServiceFooter(serviceName, SystemTestDataModel.errorCounter);		
		SystemTestDataModel.keywordErrors = SystemTestDataModel.errorCounter;
		return SystemTestDataModel.errorCounter;
	}

	@Override
	public ArrayList<String> getCategories(String companyName,
			String searchTerm, String description, String[] adds, String url)
			throws Exception {
		
		SystemTestFunc.PrintLineSeperator();					
		long start = System.currentTimeMillis();
		
		SystemTestFunc.PrintMethodCall("getCategories(null, " + SystemTestDataModel.keyword_SearchTerm + ", " + SystemTestDataModel.keyword_Description + ", null, null)");		
		try{	
			retCategories = keywordService.getCategories(null, SystemTestDataModel.keyword_SearchTerm, SystemTestDataModel.keyword_Description, null, null);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}		
		
		double sec = (double) (System.currentTimeMillis() - start)/1000.0;
		System.out.println(" - getCategories took " + sec + " seconds");
		for(String cat : retCategories){
			System.out.println(cat);
		}
		
		//Verification
		if(retCategories.size() < 1){
			//no category is returned
			SystemTestFunc.ErrorHandler("No category has been returned.");
		}
		
		return null;
	}

	@Override
	public KeywordProbabilityObject[] getKeywords(List<String> categories,String companyName, AdEngine[] searchEngines, 
			String promotionName, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		
		SystemTestFunc.PrintLineSeperator();		
					
		ArrayList<String> selectCateg = new ArrayList<String>();
		selectCateg.add(retCategories.get(1));
		System.out.println("Selected:"+retCategories.get(1));	
		
		KeywordProbabilityObject[] kw = null;
		
		long start = System.currentTimeMillis();
		
		SystemTestFunc.PrintMethodCall("getKeywords(selectCateg,null, SystemTestDataModel.keyword_AdEngineList, " +
				"SystemTestDataModel.keyword_SearchTerm, SystemTestDataModel.keyword_Description, null, SystemTestDataModel.keyword_LandingPage, null ,SystemTestDataModel.keyword_nGramsList)");
		try{
			kw = keywordService.getKeywords(selectCateg,null, SystemTestDataModel.keyword_AdEngineList,
					SystemTestDataModel.keyword_SearchTerm, SystemTestDataModel.keyword_Description, null, SystemTestDataModel.keyword_LandingPage, null ,SystemTestDataModel.keyword_nGramsList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		double sec = (double) (System.currentTimeMillis() - start)/1000.0;
		System.out.println(" - getkeywords took " + sec + " seconds");
		
		//Verification
		if(kw == null || kw.length < 1){
			//no keyword is returned
			SystemTestFunc.ErrorHandler("No keyword has been returned.");
		}	
		
		System.out.println("num of keywords we get: " + kw.length);
		System.out.println("the 1st keyword listed below:");
		String kaux=kw[0].getKeyword();
		System.out.println(kaux+" "+kw[0].getSemplestProbability());
		
		
		
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
