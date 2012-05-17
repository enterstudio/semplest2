package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

import com.google.gson.Gson;

public class KeywordLDAServiceClient extends ServiceRun implements SemplestKeywordLDAServiceInterface 
{
	private static String SERVICEOFFERED = "semplest.service.keywords.lda.KeywordGeneratorService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest";  //VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordLDAServiceClient.class);
	
	private String baseurl;
	
	
	public static void main(String[] args)
	{

		try
		{
			boolean flag = true;
			while(flag){
				System.out.println("**************DEV MACHINE 1*****************");
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(BASEURLTEST);
				long start = System.currentTimeMillis();
				ArrayList<String> res = client.getCategories(null, "rugby sale", "rugby sale", null, null);
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("categories took " + sec + " seconds");
				for (int i = 0; i < res.size(); i++)
				{
					System.out.println(res.get(i));
				}
				
				start = System.currentTimeMillis();
				ArrayList<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(0));
				System.out.println("Selected:"+res.get(1));
				
				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						"rugby sale", "rugby sale", null, "http://www.planetrugby.com", null ,new Integer[]{50,50});
				sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("keywords took " + sec + " seconds");
				Thread.sleep(3000);
				
				
					String kaux=kw[0].getKeyword();
					System.out.println(kaux+" "+kw[0].getSemplestProbability());		
	
			}
			while(!flag){
				
				System.out.println("**************DEV MACHINE 2*****************");
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(BASEURLTEST);
				long start = System.currentTimeMillis();
				ArrayList<String> res = client.getCategories(null, "peanut butter", "peanut butter", null, null);
				double sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("categories took " + sec + " seconds");
				for (int i = 0; i < res.size(); i++)
				{
					System.out.println(res.get(i));
				}
				
				start = System.currentTimeMillis();
				ArrayList<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(5));
				System.out.println("Selected:"+res.get(5));
				
				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
						"peanut butter", "peanut butter", null, "http://peanutbutterlovers.com/", null ,new Integer[]{50,50});
				sec = (double) (System.currentTimeMillis() - start)/1000.0;
				System.out.println("keywords took " + sec + " seconds");
				Thread.sleep(1800000);
				
				String kaux=kw[0].getKeyword();
				System.out.println(kaux+" "+kw[0].getSemplestProbability());
		

			}
		
		}
		catch (Exception e)
		{
			//logger.error(e.getSemplestErrorID() + e.getSemplestErrorMessage());
			e.printStackTrace();
		}
	}
		
	public KeywordLDAServiceClient(String baseurl)
	{
		if (baseurl == null)
		{
			this.baseurl = BASEURLTEST;
		}
		else
		{
			this.baseurl = baseurl;
		}
	}
	
	@Override
	public ArrayList<String>  getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("companyName", companyName);
		jsonHash.put("searchTerm", searchTerm);
		String jsonAdds = gson.toJson(adds, String[].class);
		jsonHash.put("adds", jsonAdds);
		jsonHash.put("description", description);
		jsonHash.put("url", url);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getCategories", json, timeoutMS);
		return gson.fromJson(returnData,ArrayList.class);
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String searchTerm, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String jsonCategories = gson.toJson(categories, ArrayList.class);
		jsonHash.put("categories", jsonCategories);
		jsonHash.put("companyName", companyName);
		jsonHash.put("searchTerm", searchTerm);
		String jsonAdds = gson.toJson(adds, String[].class);
		String jsonSEngines = gson.toJson(searchEngines, String[].class);
		String jsonGt = gson.toJson(gt , GeoTargetObject[].class);
		jsonHash.put("gt", jsonGt);
		jsonHash.put("searchEngines", jsonSEngines);
		jsonHash.put("adds", jsonAdds);
		jsonHash.put("description", description);
		jsonHash.put("url", url);
		String jsonNgrams =  gson.toJson(nGrams, Integer[].class);
		jsonHash.put("nGrams", jsonNgrams);
		String json = protocolJson.createJSONHashmap(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getKeywords", json, timeoutMS);
		return gson.fromJson(returnData,KeywordProbabilityObject[].class);
	}

}
