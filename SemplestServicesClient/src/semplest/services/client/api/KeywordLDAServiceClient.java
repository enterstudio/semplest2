package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import semplest.util.SemplestUtils;

import com.google.gson.Gson;

public class KeywordLDAServiceClient extends ServiceRun implements SemplestKeywordLDAServiceInterface
{
	private static String SERVICEOFFERED = "semplest.service.keywords.lda.KeywordGeneratorService";
	// private static String BASEURLTEST = "http://VMJAVA1:9898/semplest"; ///VMJAVA1 23.22.63.111 NY-semplestDev2
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // /VMJAVA1 23.22.63.111 NY-semplestDev2
	// private static String BASEURLTEST = "http://23.22.63.111:9898/semplest"; ///VMJAVA1 23.22.63.111 NY-semplestDev2
	private static String timeoutMS = "60000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(KeywordLDAServiceClient.class);

	private String baseurl;

	public static void main(String[] args)
	{

		try
		{
			boolean flag = true;
			while (flag)
			{
				System.out.println("**************DEV MACHINE 1*****************");
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(BASEURLTEST);
				long start = System.currentTimeMillis();
				List<String> res = client.getCategories(null, "Best Seafood Dinner in NJ Get NJs best Lobster Dinners Caught Fresh Daily", "Best Seafood Dinner in NJ Get NJs best Lobster Dinners Caught Fresh Daily", null, null);
				double sec = (double) (System.currentTimeMillis() - start) / 1000.0;
				System.out.println("categories took " + sec + " seconds");
				for (int i = 0; i < res.size(); i++)
				{
					System.out.println(res.get(i));
				}

				start = System.currentTimeMillis();
				List<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(1));
				System.out.println("Selected:" + res.get(1));

				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg, null, new AdEngine[] { AdEngine.Google, AdEngine.MSN }, "Lobster Dinners", "lobster, lobster dinners, lobster salad, take out, seafood, fresh fish, fish", null, "http://www.thelobsterhouse.com/home", null, new Integer[] { 300, 100, 100 });
				sec = (double) (System.currentTimeMillis() - start) / 1000.0;
				System.out.println("keywords took " + sec + " seconds.  Number keywords=" + kw.length);

				int i = 0;
				for (KeywordProbabilityObject k : kw)
				{
					if (i >= 10)
					{
						break;
					}
					System.out.println(k.getKeyword() + " " + k.getSemplestProbability());
					i++;
				}

				Thread.sleep(10000);

			}
			while (!flag)
			{

				System.out.println("**************DEV MACHINE 2*****************");
				KeywordLDAServiceClient client = new KeywordLDAServiceClient(BASEURLTEST);
				long start = System.currentTimeMillis();
				List<String> res = client.getCategories(null, "Autographed Football", "Football, QB, WR, RB", null, null);
				double sec = (double) (System.currentTimeMillis() - start) / 1000.0;
				System.out.println("categories took " + sec + " seconds");
				for (int i = 0; i < res.size(); i++)
				{
					System.out.println(res.get(i));
				}

				start = System.currentTimeMillis();
				List<String> selectCateg = new ArrayList<String>();
				selectCateg.add(res.get(5));
				System.out.println("Selected:" + res.get(5));

				KeywordProbabilityObject[] kw = client.getKeywords(selectCateg, null, new AdEngine[] { AdEngine.Google, AdEngine.MSN }, "peanut butter", "peanut butter", null, "http://www.peanutbuttery.com/", null, new Integer[] { 300, 100, 100 });
				sec = (double) (System.currentTimeMillis() - start) / 1000.0;
				System.out.println("keywords took " + sec + " seconds.  Number keywords=" + kw.length);

				String kaux = kw[0].getKeyword();
				System.out.println(kaux + " " + kw[0].getSemplestProbability());
				Thread.sleep(3000);

			}

		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
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
	public List<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception
	{
		Map<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("companyName", companyName);
		jsonHash.put("searchTerm", searchTerm);
		String jsonAdds = gson.toJson(adds, String[].class);
		jsonHash.put("adds", jsonAdds);
		jsonHash.put("description", description);
		jsonHash.put("url", url);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "getCategories", json, timeoutMS);
		return gson.fromJson(returnData, SemplestUtils.TYPE_LIST_OF_STRINGS);
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public KeywordProbabilityObject[] getKeywords(List<String> categories, String companyName, AdEngine[] searchEngines, String searchTerm, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception
	{
		Map<String, String> jsonHash = new HashMap<String, String>();
		String jsonCategories = gson.toJson(categories, ArrayList.class);
		jsonHash.put("categories", jsonCategories);
		jsonHash.put("companyName", companyName);
		jsonHash.put("searchTerm", searchTerm);
		String jsonAdds = gson.toJson(adds, String[].class);
		String jsonSEngines = gson.toJson(searchEngines, String[].class);
		String jsonGt = gson.toJson(gt, GeoTargetObject[].class);
		jsonHash.put("gt", jsonGt);
		jsonHash.put("searchEngines", jsonSEngines);
		jsonHash.put("adds", jsonAdds);
		jsonHash.put("description", description);
		jsonHash.put("url", url);
		String jsonNgrams = gson.toJson(nGrams, Integer[].class);
		jsonHash.put("nGrams", jsonNgrams);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl, SERVICEOFFERED, "getKeywords", json, timeoutMS);
		return gson.fromJson(returnData, KeywordProbabilityObject[].class);
	}

	@Override
	public String checkStatus(String esbUrl, String timeout) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("input", esbUrl);
		String json = protocolJson.createJSONHashmap(jsonHash);
		String ret = runMethod(esbUrl, SERVICEOFFERED, "checkStatus", json, timeout);
		return ret;
	}

}
