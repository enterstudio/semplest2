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
		String[] searchTerm = new String[] {data.get("searchTerm")};
		ArrayList<String> res = getCategories(searchTerm);
		return gson.toJson(res);
	}

	@Override
	public ArrayList<String> getCategories(String[] searchTerm) throws Exception
	{
		if(kwGen==null){
			kwGen =  new KWGenDmozLDAServer();
		}
		ArrayList<String> categOpt = kwGen.getCategories(searchTerm);
		if (categOpt == null)
		{
			logger.info("No categories found for " + searchTerm[0]);
			categOpt = new ArrayList<String>();
		}
		return categOpt;
	}


	@Override
	public void initializeService() throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	
}
