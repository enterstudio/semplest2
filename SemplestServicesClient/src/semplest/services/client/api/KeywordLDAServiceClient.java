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
	private static String BASEURLTEST = "http://localhost:9898/semplest";  //VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordLDAServiceClient.class);
	
	private String baseurl;
	
	
	public static void main(String[] args)
	{

		try
		{
			KeywordLDAServiceClient client = new KeywordLDAServiceClient("http://VMJAVA1:9898/semplest");
			long start = System.currentTimeMillis();
			ArrayList<String> res = client.getCategories(null, "coffee machine", null, null, null);
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("categories took " + sec + " seconds");
			for (int i = 0; i < res.size(); i++)
			{
				System.out.println(res.get(i));
			}
			
			start = System.currentTimeMillis();
			ArrayList<String> selectCateg = new ArrayList<String>();
			selectCateg.add(res.get(1));
			System.out.println("Selected:"+res.get(1));
			
			ArrayList<ArrayList<KeywordProbabilityObject>> kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"},
					"coffee machine", null, null, "http://www.wholelattelove.com/", null ,new Integer[]{50,50});
			sec = (double) (System.currentTimeMillis() - start)/1000.0;
			for(int n=0; n<4; n++){
				System.out.println("\n"+ (n+2)+" word keywords:");
				for(KeywordProbabilityObject k: kw.get(n)){
					String kaux=k.getKeyword().replaceAll("wed", "wedding");
					System.out.print(kaux+" "+k.getSemplestProbability()+", ");
				}
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
	public ArrayList<ArrayList<KeywordProbabilityObject>> getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String searchTerm, String description, String[] adds, String url, GeoTargetObject gt, Integer[] nGrams) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		String jsonCategories = gson.toJson(categories, ArrayList.class);
		jsonHash.put("categories", jsonCategories);
		jsonHash.put("companyName", companyName);
		jsonHash.put("searchTerm", searchTerm);
		String jsonAdds = gson.toJson(adds, String[].class);
		String jsonSEngines = gson.toJson(searchEngines, String[].class);
		String jsonGt = gson.toJson(gt , GeoTargetObject.class);
		jsonHash.put("gt", jsonGt);
		jsonHash.put("searchEngines", jsonSEngines);
		jsonHash.put("adds", jsonAdds);
		jsonHash.put("description", description);
		jsonHash.put("url", url);
		String jsonNgrams =  gson.toJson(nGrams, Integer[].class);
		jsonHash.put("nGrams", jsonNgrams);
		String json = protocolJson.createJSONHashmap(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getKeywords", json, timeoutMS);
		return gson.fromJson(returnData,ArrayList.class);
	}

}
