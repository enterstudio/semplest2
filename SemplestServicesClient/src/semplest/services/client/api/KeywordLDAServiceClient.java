package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import com.google.api.adwords.v201109.mcm.Account;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KeywordLDAServiceClient extends ServiceRun implements SemplestKeywordLDAServiceInterface 
{
	private static String SERVICEOFFERED = "semplest.service.keywords.lda.KeywordGeneratorService";
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";  //VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordLDAServiceClient.class);
	
	private String baseurl;
	
	
	public static void main(String[] args)
	{

		try
		{
			KeywordLDAServiceClient client = new KeywordLDAServiceClient(null);
			long start = System.currentTimeMillis();
			ArrayList<String> res = client.getCategories(null, "insurance", null, null, null);
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("categories took " + sec + " seconds");
			for (int i = 0; i < res.size(); i++)
			{
				System.out.println(res.get(i));
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
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
		jsonHash.put("description", description);
		jsonHash.put("url", url);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST,SERVICEOFFERED, "getCategories", json, timeoutMS);
		return gson.fromJson(returnData,ArrayList.class);
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ArrayList<String>> getKeywords(ArrayList<String> categories,String companyName, String searchTerm, String description, String[] adds, String url, Integer[] nGrams) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
