package semplest.service.keywords.lda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import semplest.keywords.lda.KWGenDmozLDAServer3;
import semplest.keywords.javautils.catUtils;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import semplest.util.SemplestUtils;

public class KeywordGeneratorServiceImpl implements SemplestKeywordLDAServiceInterface
{
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordGeneratorServiceImpl.class);
	private static final catUtils cu = new catUtils();
	private KWGenDmozLDAServer3 kwGen;

	public String getCategories(String json) throws Exception
	{
		logger.debug("call  getCategories(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String companyName = data.get("companyName");
		final String searchTerm = data.get("searchTerm");
		final String description = data.get("description");
		final String[] adds = new String[] { data.get("adds") };
		final String url = data.get("url");
		final List<String> res = getCategories(companyName, searchTerm, description, adds, url);
		return gson.toJson(res);
	}

	@Override
	public List<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception
	{
		kwGen = new KWGenDmozLDAServer3(SemplestConfiguration.configData);
		List<String> categOpt = kwGen.getCategories(companyName, searchTerm, description, adds, url);
		if (categOpt == null)
		{
			logger.info("No categories found for " + searchTerm);
			categOpt = new ArrayList<String>();
		}
		return cu.code(categOpt);
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		logger.info("Initialized Keyword generator...");
		kwGen = new KWGenDmozLDAServer3(SemplestConfiguration.configData);
		kwGen.initializeService(null);
	}

	public String getKeywords(String json) throws Exception
	{
		logger.debug("call  getCategories(String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String categoriesString = data.get("categories");
		final List<String> categories = gson.fromJson(categoriesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		final String companyName = data.get("companyName");
		final String searchTerm = data.get("searchTerm");
		final String description = data.get("description");
		final String addsString = data.get("adds");
		final String[] adds = gson.fromJson(addsString, String[].class);
		final String searchEnginesString = data.get("searchEngines");
		final String[] searchEngines = gson.fromJson(searchEnginesString, String[].class);
		final String url = data.get("url");
		final String nGramsString = data.get("nGrams");
		final Integer[] nGrams = gson.fromJson(nGramsString, Integer[].class);
		final String geoTargetsString = data.get("gt");
		final GeoTargetObject[] gt = gson.fromJson(geoTargetsString, GeoTargetObject[].class);
		final KeywordProbabilityObject[] res = getKeywords(categories, companyName, searchEngines, searchTerm, description, adds, url, gt, nGrams);
		return gson.toJson(res);
	}

	@Override
	public KeywordProbabilityObject[] getKeywords(List<String> categories, String companyName, String[] searchEngines, String searchTerm, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception
	{
		kwGen = new KWGenDmozLDAServer3(SemplestConfiguration.configData);
		final List<String> categoriesDecoded = cu.decode(categories);
		KeywordProbabilityObject[] keywords = kwGen.getKeywords(categoriesDecoded, companyName, searchEngines, searchTerm, description, adds, url, gt, nGrams);
		if (keywords == null)
		{
			logger.info("No categories found for " + searchTerm);
			keywords = new KeywordProbabilityObject[0];
		}
		return keywords;
	}

	public String checkStatus(String json) throws Exception
	{
		return checkStatus(null, null);
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception
	{
		return ServiceStatus.Up.getServiceStatusValue();
	}

}
