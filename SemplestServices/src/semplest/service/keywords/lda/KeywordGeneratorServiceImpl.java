package semplest.service.keywords.lda;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import semplest.keywords.lda.KWGenDmozLDAServer;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KeywordGeneratorServiceImpl implements SemplestKeywordLDAServiceInterface
{
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordGeneratorServiceImpl.class);
	
	private KWGenDmozLDAServer kwGen;
	public String getCategories(String json) throws Exception
	{
		logger.debug("call  getCategories(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String companyName = data.get("companyName");
		String searchTerm = data.get("searchTerm");
		String description = data.get("description");
		String[] adds = new String[]{data.get("adds")};
		String url = data.get("url");
		ArrayList<String> res = getCategories(companyName,searchTerm,description,adds, url);
		return gson.toJson(res);
	}

	@Override
	public ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception
	{
		
		kwGen =  new KWGenDmozLDAServer();
		ArrayList<String> categOpt = kwGen.getCategories(companyName,searchTerm,description,adds, url);
		if (categOpt == null)
		{
			logger.info("No categories found for " + searchTerm);
			categOpt = new ArrayList<String>();
		}
		return categOpt;
	}


	@Override
	public void initializeService(String input) throws Exception
	{
		logger.info("Initialized Keyword generator...");
		kwGen =  new KWGenDmozLDAServer();
		kwGen.initializeService(null);
		
	}
	
	public String getKeywords(String json) throws Exception
	{
		logger.debug("call  getCategories(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		ArrayList<String> categories = data.get("categories");
		String companyName = data.get("companyName");
		String searchTerm = data.get("searchTerm");
		String description = data.get("description");
		String[] adds = new String[]{data.get("adds")};
		String url = data.get("url");
		Integer[] nGrams = data.get("nGrams");
		ArrayList<ArrayList<String>> res = getKeywords(categories,companyName, searchTerm, description, adds, url, nGrams);
		return gson.toJson(res);
	}

	@Override
	public ArrayList<ArrayList<String>> getKeywords(ArrayList<String> categories,String companyName, String searchTerm, String description, String[] adds, String url, Integer[] nGrams) throws Exception {
		kwGen =  new KWGenDmozLDAServer();
		ArrayList<ArrayList<String>> keywords = kwGen.getKeywords(categories,companyName, searchTerm,description, adds, url, nGrams);
		if (keywords == null)
		{
			logger.info("No categories found for " + searchTerm);
			keywords = new ArrayList<ArrayList<String>>();
		}
		return keywords;
	}
	
}
