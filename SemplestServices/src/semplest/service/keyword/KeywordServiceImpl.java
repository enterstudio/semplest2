package semplest.service.keyword;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.protocol.adengine.GetCategoriesRequest;
import semplest.server.protocol.adengine.GetKeywordsRequest;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.KeywordServiceInterface;
import semplest.util.SemplestUtils;

public class KeywordServiceImpl implements KeywordServiceInterface
{
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordServiceImpl.class);

	public String getCategories(String json) throws Exception
	{
		logger.info("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String requestString = data.get("request");
		final GetCategoriesRequest request = gson.fromJson(requestString, GetCategoriesRequest.class);
		final List<String> res = getCategories(request);
		return gson.toJson(res);
	}

	@Override
	public List<String> getCategories(final GetCategoriesRequest request) throws Exception
	{
		final String operationDescription = "Get Categories for [" + request + "]";
		logger.info("Will try to " + operationDescription);
		
		//TODO: change this
		return null;
	}
	
	public String getKeywords(String json) throws Exception
	{
		logger.info("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String requestString = data.get("request");
		final GetKeywordsRequest request = gson.fromJson(requestString, GetKeywordsRequest.class);
		final List<KeywordProbabilityObject> keywords = getKeywords(request);
		return gson.toJson(keywords);
	}

	@Override
	public List<KeywordProbabilityObject> getKeywords(final GetKeywordsRequest request) throws Exception
	{
		final String operationDescription = "Get Keywords for [" + request + "]";
		logger.info("Will try to " + operationDescription);
		
		// TODO: change this 
		return null;
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception
	{
		return ServiceStatus.Up.getServiceStatusValue();
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		logger.info("Starting to initialize");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		logger.info("Finished initializing");
	}

}
