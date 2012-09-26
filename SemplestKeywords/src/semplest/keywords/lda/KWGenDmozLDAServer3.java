package semplest.keywords.lda;

/**
 * Production version of the Keyword Generation Server
 * For Crawl 2 were words are not stemmed. Other improvements added, such as google suggestions and keyword 
 * probability independent of number of words 
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.api.adwords.v201109.cm.ApiException;

import scala.actors.threadpool.Arrays;
import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.keywordb;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.EmailType;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.google.KeywordToolStats;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailServiceImpl;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddKeywordBidDataSP;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.server.service.springjdbc.storedproc.GetKeywordForAdEngineSP;

import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import semplest.util.SemplestUtils;
import cc.mallet.types.InstanceList;

public class KWGenDmozLDAServer3 implements SemplestKeywordLDAServiceInterface
{
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer3.class);
	private static KWGenDmozLDAdata3 data;
	private static Map<String, Object> configData;
	SemplestMailServiceImpl mail;

	public KWGenDmozLDAServer3(Map<String, Object> configDataIn) throws Exception
	{
		try
		{
			configData = configDataIn;
			mail = new SemplestMailServiceImpl();
			mail.initializeService(null);
		}
		catch (Exception e)
		{
			logger.error("Problem initializing", e);
			throw e;
		}
	}

	// ***************************************** Category Methods ***************************************************************

	@Override
	public List<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception
	{
		try
		{
			if (searchTerm != null && searchTerm.length() > 0)
			{
				searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
			}
			if (description == null || description.length() <= 0)
			{
				throw new Exception("No description data provided");
			}
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			if (url != null)
			{
				url = TextUtils.formURL(url);
			}
			List<String> categories = getCategories(description);
			return categories;
		}
		catch (Exception e)
		{
			logger.error(e.toString(), e);
			throw e;
		}
	}

	public List<String> getCategories(String searchTerm) throws Exception
	{
		try
		{
			String qs = "";
			String[] res;
			List<String> optList = new ArrayList<String>();
			List<String> optInitial = new ArrayList<String>();
			int numresults = 100; // Number of results from the query
			String qsStem = stemvString(searchTerm, data.dict);
			if (qsStem != null && qsStem.length() > 0)
			{
				logger.info("Stemmed version: [" + qsStem + "]");
				res = data.dl.search(qsStem, numresults);
				for (int i = 0; i < res.length; i++)
				{
					String categories = res[i].trim();
					if (catUtils.validcat(categories))
					{
						optInitial.add(categories);
					}
				}
				// Select repeated patterns
				optList = selectOptions(optInitial);
			}
			return optList;
		}
		catch (Exception e)
		{
			logger.error("Problem getting categories", e);
			throw e;
		}
	}

	private List<String> selectOptions(List<String> optKeys) throws IOException
	{
		// Selects patterns from top categories list to generate options for the user based on pre-defined crieteria
		List<String> ret = new ArrayList<String>();
		// Top 5 results
		for (int i = 0; i < Math.min(optKeys.size(), 5); i++)
		{
			ret.add(optKeys.get(i));
		}
		// Identify repeated patterns in top categories
		Map<String, Double> catPatRepMap = idRepeatedCatPat(optKeys);
		// Filter out just relevant patterns and add to result
		final List<String> relevantOpt = selectRelevantOpt(catPatRepMap);
		ret.addAll(relevantOpt);
		return ret;

	}

	private Map<String, Double> idRepeatedCatPat(List<String> optList)
	{
		Map<String, Double> catRepMap = new HashMap<String, Double>();
		String newoption;
		String[] pair = new String[2];
		for (int n = 0; n < optList.size(); n++)
		{
			for (int m = 0; m < n; m++)
			{
				pair[0] = optList.get(n);
				pair[1] = optList.get(m);
				newoption = catUtils.longestAncestor(pair);
				if (catRepMap.containsKey(newoption))
				{
					catRepMap.put(newoption, ((Double) catRepMap.get(newoption)) + 1.0);
				}
				else
				{
					catRepMap.put(newoption, new Double(1));
				}
			}
		}
		return catRepMap;
	}

	private List<String> selectRelevantOpt(Map<String, Double> catPatRepMap)
	{
		Double numrepeat;
		int numNodes, numNEval = 20;
		Map<String, Double> optList = new HashMap<String, Double>();
		for (String optKey : catPatRepMap.keySet())
		{
			numNodes = catUtils.nodes(optKey);
			numrepeat = catPatRepMap.get(optKey);
			if (numNodes >= 4 && numrepeat > 3)
			{
				if (catUtils.last(optKey).length() > 1)
				{
					final String key = catUtils.take(optKey, numNEval);
					if (!optList.containsKey(key))
					{
						final Double numNods = new Double(numNodes);
						final String k = catUtils.take(optKey, numNEval);
						optList.put(k, numNods);
					}
				}
			}
		}
		ValueComparator bvcAux2 = new ValueComparator(optList);
		TreeMap<String, Double> sorted_opt = new TreeMap<String, Double>(bvcAux2);
		sorted_opt.putAll(optList);
		// Present sorted pattern from most detailed to most general
		List<String> sortOptList = new ArrayList<String>();
		for (String aux : sorted_opt.keySet())
		{
			sortOptList.add(aux);
		}
		return sortOptList;
	}

	@Override
	public KeywordProbabilityObject[] getKeywords(List<String> categories, String companyName, AdEngine[] searchEngines, String productPromotion, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception
	{
		try
		{
			if (productPromotion != null && productPromotion.length() >= 0)
			{
				productPromotion = productPromotion.toLowerCase().replaceAll("\\p{Punct}", " ");
			}
			if (description == null || description.length() == 0)
			{
				throw new Exception("No description provided");
			}
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			// Check Search Engines and decide number of kw per Search Engine
			if (categories == null || categories.size() == 0)
			{
				throw new Exception("No categories provided");
			}
			if (nGrams == null || nGrams.length != 3)
			{
				throw new Exception("Wrong number nGrams provided");
			}
			// Weight data based on percentage
			String data1 = weightData(data.userInfoWeight, url, adds, companyName, productPromotion, description);
			String[] dataCount = data1.split("\\s+");
			if (dataCount.length < 30)
			{
				throw new Exception("Not enough data provided");
			}
			String stemdata1 = stemvStringNoFilter(data1, data.dict);
			int numkw = 0;
			for (AdEngine se : searchEngines)
			{
				if (se == AdEngine.Google)
				{
					if (data.numKeywordsGoogle > numkw)
					{
						numkw = data.numKeywordsGoogle;
					}
				}
				if (se == AdEngine.MSN)
				{
					if (data.numKeywordsMSN > numkw)
					{
						numkw = data.numKeywordsMSN;
					}
				}
			}
			// Get keywords sorted by probability
			final List<AdEngine> srchE = Arrays.asList(searchEngines);
			final List<KeywordProbabilityObject> keywords = getKeywordsSorted(categories, description, stemdata1, srchE, nGrams, numkw);			
			final Double percent = (Double)configData.get("KeywordTopPercent");
			final List<KeywordProbabilityObject> keywordsPartial = SemplestUtils.getSublist(keywords, percent);
			logger.info("Number of Keywords originally [" + keywords.size() + "], Percent to keep [" + percent + "], Final number of keywords [" + keywordsPartial.size() + "]");
			return keywordsPartial.toArray(new KeywordProbabilityObject[keywordsPartial.size()]);
		}
		catch (Exception e)
		{
			logger.error("Problem getting keywords", e);
			throw e;
		}
	}

	private Map<String, String> getCatChildsAndData(List<String> categories) throws Exception
	{
		// Returns a list with the content of the child categories
		Map<String, String> retMap = new HashMap<String, String>();
		long startTime = System.currentTimeMillis();
		Set<String> uniqCat = new HashSet<String>();
		for (String cat : categories)
		{
			uniqCat.addAll(keywordb.children(cat, "2g").keySet());
		}
		for (String cat : uniqCat)
		{
			retMap.put(cat, keywordb.description(cat));
		}
		logger.info("time for categories" + (System.currentTimeMillis() - startTime));
		return retMap;
	}
	
	private List<KeywordProbabilityObject> getKeywordsSorted(List<String> categories, String description, String data1, List<AdEngine> srchE, Integer[] nGrams, int numKw) throws Exception
	{
		try
		{
			// Create a List of the categories that satisfy options selected by the user and ArrayList
			// with data form those categories
			Map<String, String> trainMap = getCatChildsAndData(categories);
			List<String> optCateg = new ArrayList<String>(trainMap.keySet());
			logger.info("Number of categories to add " + trainMap.size());
			// Train LDA for categories selected and return sorted keywords
			// and obtain word probability
			Map<String, Double> wordMap = createWordMap(data1, trainMap, description);
			logger.info("previous wordmap size: " + wordMap.size());
			Double defaultProb = getDefaultProbability(wordMap);
			// Generate a maximum of 5000 keywords nGrams[0] bigrams + nGrams[1] trigrams and the rest split between 4 grams and 5 grams
			List<KeywordProbabilityObject> kwNOTSorted = getKwMultiCombined(optCateg, description, nGrams, wordMap, defaultProb, 5, srchE);
			List<KeywordProbabilityObject> keywords = sortKeywords(kwNOTSorted, numKw);
			// Disable the necessary SE flags
			int j = 0;
			for (AdEngine se : srchE)
			{
				if (se == AdEngine.Google && data.numKeywordsGoogle < keywords.size())
				{
					for (int i = data.numKeywordsGoogle; i < keywords.size(); i++)
					{
						keywords.get(i).setIsTargetGoogle(false);
					}
				}
				if (se == AdEngine.MSN && data.numKeywordsMSN < keywords.size())
				{
					for (int i = data.numKeywordsGoogle; i < keywords.size(); i++)
					{
						keywords.get(i).setIsTargetGoogle(false);
					}
				}
			}

			return keywords;

		}
		catch (Exception e)
		{
			logger.error(e.toString(), e);
			throw e;
		}
	}

	public static List<KeywordProbabilityObject> sortKeywords(List<KeywordProbabilityObject> kwNOTSorted, int numKw)
	{
		final List<KeywordProbabilityObject> sortedKw = new ArrayList<KeywordProbabilityObject>();
		final Map<KeywordProbabilityObject, Double> map = new HashMap<KeywordProbabilityObject, Double>();
		for (KeywordProbabilityObject kw : kwNOTSorted)
		{
			map.put(kw, kw.getSemplestProbability());
		}
		final ValueComparator vc = new ValueComparator(map);
		final TreeMap<KeywordProbabilityObject, Double> tmap = new TreeMap<KeywordProbabilityObject, Double>(vc);
		tmap.putAll(map);
		final Set<KeywordProbabilityObject> set = tmap.keySet();
		int i = 0;
		for (KeywordProbabilityObject kw : set)
		{
			if (i >= numKw)
			{
				break;
			}
			sortedKw.add(kw);
		}
		return sortedKw;
	}

	private Map<String, Double> createWordMap(String data1, Map<String, String> trainMap, String description) throws Exception
	{
		Map<String, Double> wordMap = new HashMap<String, Double>();
		MalletTopic lda = new MalletTopic();
		double alpha = 0.01;
		double beta = 0.01;
		int numiter = 100;
		lda.CreateInstances(trainMap);
		int numTopics = data.numTopics;
		if (trainMap.size() < numTopics)
		{
			numTopics = trainMap.size();
		}
		lda.setNumTopics(numTopics);
		lda.LDAcreateModel(alpha, beta, numiter);
		InstanceList inferInst = lda.CreateInferInstfromData("0", "Test Data", data1);
		// Infer word probability based on input data
		wordMap = lda.inferWordprob(inferInst, 0, true);
		Double maxProb = maxValue(wordMap);
		if (maxProb == null)
		{
			maxProb = 1.0;
		}
		// logger.info("insider word map size:"+wordMap.size());
		String qsStem = this.stemvStringNoFilter(description, data.dict);
		if (qsStem != null)
		{
			String[] terms = qsStem.split("\\s+");
			for (int n = 0; n < terms.length; n++)
			{
				wordMap.put(terms[n], new Double(maxProb));
			}
		}
		return wordMap;
	}

	private static Double maxValue(Map<String, Double> map)
	{
		double max = 0;
		for (String word : map.keySet())
		{
			double prob = map.get(word);
			if (prob > max)
			{
				max = prob;
			}
		}
		return max;
	}

	private List<KeywordProbabilityObject> getKwMultiCombined(List<String> optCateg, String searchTerms, Integer[] nGrams, Map<String, Double> wordMap, Double defaultProb, int nGramsmax, List<AdEngine> srchE) throws Exception
	{
		List<KeywordProbabilityObject> ngrams = new ArrayList<KeywordProbabilityObject>();
		List<KeywordProbabilityObject> googleSug = getGoogleSug(searchTerms, srchE, wordMap, defaultProb, 1000);
		int iter = 0;
		boolean flag = false;
		// go up to three levens on the tree to get enought bigrams and trigrams
		while (iter < 3 && !flag)
		{
			List<String> newOptCateg = new ArrayList<String>(optCateg);
			if (iter != 0)
			{
				List<String> newCategories = new ArrayList<String>();
				for (int n = 0; n < optCateg.size(); n++)
				{
					String parent = catUtils.parent(optCateg.get(n));
					if (catUtils.nodes(parent) > 2)
					{
						newCategories.add(parent);
					}
					else
					{
						newCategories.add(optCateg.get(n));
					}
				}
				Map<String, String> newMap = this.getCatChildsAndData(newCategories);
				newOptCateg = new ArrayList<String>(newMap.keySet());
				newOptCateg = new ArrayList<String>();
			}
			logger.info("Expanding categories");
			ngrams = getKwMulti(searchTerms, newOptCateg, nGrams[0], wordMap, defaultProb, srchE);
			flag = (ngrams.size() > 20);
			iter++;
		}
		List<KeywordProbabilityObject> results = new ArrayList<KeywordProbabilityObject>();
		results.addAll(ngrams);
		results.addAll(googleSug);
		return results;
	}

	private List<KeywordProbabilityObject> getGoogleSug(String searchTerms, List<AdEngine> srchE, Map<String, Double> wordMap, Double defaultProb, int numberResults) throws Exception
	{
		List<KeywordProbabilityObject> kwProb = new ArrayList<KeywordProbabilityObject>();
		List<String> bigrams = generateNgramsFromString(searchTerms, 2, false);
		if (bigrams.isEmpty())
		{
			bigrams.add(searchTerms);
		}
		String[] keywords = bigrams.toArray(new String[bigrams.size()]);
		GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
		boolean repeat = true;
		int countRep = 0;
		List<KeywordToolStats> keyWordIdeaList = new ArrayList<KeywordToolStats>();
		while (countRep <= 1 && repeat)
		{
			try
			{
				keyWordIdeaList = g.getGoogleKeywordIdeas(keywords, numberResults);
				repeat = false;
			}
			catch (ApiException e)
			{
				logger.error(e.dumpToString(), e);
				if (countRep < 1)
				{
					Thread.sleep(5000);
				}
				countRep++;
				if (countRep > 1)
				{
					mail.SendEmail("getKeywords: Exception with Google API", "development@semplest.com", "development@semplest.com", e.dumpToString(), EmailType.PlanText.getEmailValue());
				}
			}
			catch (Exception e)
			{
				logger.error(e.toString(), e);
				if (countRep < 1)
				{
					Thread.sleep(5000);
				}
				countRep++;
				if (countRep > 1)
				{
					mail.SendEmail("getKeywords: Exception with Google API", "development@semplest.com", "development@semplest.com", e.toString(), EmailType.PlanText.getEmailValue());
				}
			}
		}
		List<String> kwrds = new ArrayList<String>();
		for (KeywordToolStats kw : keyWordIdeaList)
		{
			kwrds.add(kw.getKeyword());
		}
		Map<String, Double> kwProbMap = getKwProbability(kwrds, wordMap, "\\s+", defaultProb);
		return kwProbMap2KwProbList(kwProbMap, srchE, numberResults);
	}

	private List<KeywordProbabilityObject> kwProbMap2KwProbList(Map<String, Double> kwProbMap, List<AdEngine> srchE, int numKw)
	{
		List<KeywordProbabilityObject> kwProb = new ArrayList<KeywordProbabilityObject>();
		boolean isGT = false, isMSNT = false;
		if (srchE.contains(AdEngine.Google))
		{
			isGT = true;
		}
		if (srchE.contains(AdEngine.MSN))
		{
			isMSNT = true;
		}
		int i = 0;
		for (String kw : kwProbMap.keySet())
		{
			if (i >= numKw)
			{
				break;
			}
			KeywordProbabilityObject kwP = new KeywordProbabilityObject();
			kwP.setIsTargetGoogle(isGT);
			kwP.setIsTargetMSN(isMSNT);
			kwP.setKeyword(kw.replaceAll("\\p{Punct}", " ").trim().replaceAll(" s ", "'s "));
			kwP.setSemplestProbability(kwProbMap.get(kw));
			kwProb.add(kwP);
			i++;
		}
		return kwProb;
	}

	private List<KeywordProbabilityObject> getKwMulti(String searchTerms, List<String> optCateg, int numkw, Map<String, Double> wordMap, Double defaultProb, List<AdEngine> srchE) throws Exception
	{
		// **************************************************************************************
		// Now that we have generated a selection of categories that we want to use to generate our alphabet,
		// we need to generate that alphabet and infer the word probabilities for each of the words in the alphabet
		Map<String, Double> multWMap = new HashMap<String, Double>();
		for (int nGrams = 2; nGrams <= 4; nGrams++)
		{
			// Generate bigrams and trigrams in search Term and add them to the multi word list to be evaluated
			List<String> descripWords = this.generateNgramsFromString(searchTerms, nGrams, false);
			multWMap.putAll(getKwProbability(descripWords, wordMap, "\\+", defaultProb));
		}
		// Generating Multiword alphabet
		// Extract multiword for each category in the list and multiply probabilities of each subword
		Map<String, Map<String, Integer>> map = keywordb.get(optCateg.toArray(new String[optCateg.size()]));
		List<String> mWords = new ArrayList<String>();
		for (String optKey : map.keySet())
		{
			Map<String, Integer> mapT = map.get(optKey);
			for (String key : mapT.keySet())
			{
				mWords.add(key);
			}
		}
		multWMap.putAll(getKwProbability(mWords, wordMap, "\\+", defaultProb));
		return kwProbMap2KwProbList(multWMap, srchE, numkw);
	}

	private Map<String, Double> getKwProbability(List<String> wordList, Map<String, Double> wordMap, String regSplit, Double defaultProb)
	{
		// Delete this for 60% probability
		defaultProb = 0.0;
		Map<String, Double> multWMap = new HashMap<String, Double>();
		for (String mWrd : wordList)
		{
			String[] subWrds = mWrd.split(regSplit);
			Double wProb = 1.0;
			String kwrd = "";
			String kwstem = "";
			int relevantKw = 0;
			boolean flag = true;
			for (int n = 0; n < subWrds.length; n++)
			{
				String subWstem = this.stemvStringNoFilter(subWrds[n], data.dict).trim();
				// Don't include keywords that have the same stem version in the same keywords Eg. "vis a vis"
				if (!data.dict.commonWord(subWrds[n]))
				{
					if (!kwstem.contains(subWstem))
					{
						if (wordMap.containsKey(subWstem))
						{
							wProb = wProb * wordMap.get(subWstem);
						}
						else
						{
							wProb = wProb * defaultProb;
						}
						kwstem = kwstem + subWstem + " ";
						relevantKw++;
					}
					else
					{
						flag = false;
						break;
					}
				}
				kwrd = kwrd + subWrds[n] + " ";
			}
			if (flag != false && !multWMap.containsKey(kwrd) && relevantKw > 1 && wProb != 0)
			{
				multWMap.put(kwrd, Math.exp(Math.log(wProb) / relevantKw));
			}
		}
		return multWMap;
	}

	private List<String> generateNgramsFromString(String string, int nGrams, boolean stem)
	{
		// Given a string returns an ArrayList of all the nGrams groups of words in the string serperated by a blank space
		List<String> ngrams = new ArrayList<String>();
		if (stem)
		{
			string = this.stemvStringNoFilter(string, data.dict);
		}
		String[] words = string.split("\\s+");
		if (words.length >= nGrams)
		{
			for (int i = 0; i <= words.length - nGrams; i++)
			{
				String newWord = "";
				for (int j = 0; j < nGrams; j++)
				{
					final String currentWord = words[i + j];
					if (currentWord.equalsIgnoreCase("s"))
					{
						newWord = newWord + "'" + currentWord;
					}
					else
					{
						newWord = newWord + "+" + currentWord;
					}
				}
				String word = newWord.replaceAll("\\+$", "").replaceAll("^\\+", "");
				if (!ngrams.contains(word))
				{
					ngrams.add(word);
				}
			}
		}
		return ngrams;
	}

	private String weightData(double weight, String url, String[] adds, String companyName, String productPromotion, String description) throws Exception
	{
		// Combine all data from url, description, ads... and weight them differently

		// Add all data from inputs
		List<String> dataUrl = new ArrayList<String>();
		if (url != null)
		{
			url = TextUtils.formURL(url);
			dataUrl = TextUtils.validHtmlWords(url);
		}
		logger.info("Words from url:" + dataUrl.size());
		// Text from adds
		String userData = "";
		if (adds != null)
		{
			for (int i = 0; i < adds.length; i++)
			{
				userData = userData + " " + adds[i].toLowerCase().replaceAll("\\p{Punct}", " ");
			}
		}
		// Adding all user data
		userData = userData + " " + companyName + " " + productPromotion + " " + description;
		String[] userCount = userData.split("\\s+");
		// If not user data provided, or too few, it will not be used.
		logger.info("Words from user: " + userCount.length);
		if ((userCount.length) < 10)
		{
			logger.info("No user data provided");
			weight = 0;
		}
		if ((userCount.length + dataUrl.size()) < 30)
		{
			throw new Exception("Not enough data provided");
		}
		// Calculate number of repetitions for each set to meet weight criteria

		int repeatUser = 1;
		int repeatUrl = 1;

		if (dataUrl.size() >= userCount.length && weight != 1)
		{
			repeatUser = (int) Math.round(weight * dataUrl.size() / (userCount.length * (1 - weight)));
		}
		if (dataUrl.size() < userCount.length && weight != 0)
		{
			repeatUrl = (int) Math.round(userCount.length * (1 - weight) / (weight * dataUrl.size()));
		}
		if (weight == 0)
		{
			repeatUser = 0;
		}
		if (weight == 1)
		{
			repeatUrl = 0;
		}
		logger.info("Number of times to repeat user data " + repeatUser);
		logger.info("Number of times to repeat ulr data " + repeatUrl);
		double finalweight = 1.0 * (userCount.length * repeatUser) / (dataUrl.size() * repeatUrl + userCount.length * repeatUser);
		logger.info("Final weight of user data" + finalweight);
		// add weighted data from url
		String totaldata = "";
		for (int n = 0; n < repeatUrl; n++)
		{
			for (String s : dataUrl)
			{
				totaldata = totaldata + " " + s;
			}
		}
		// add weighted data from user
		for (int n = 0; n < repeatUser; n++)
		{
			totaldata = totaldata + " " + userData;
		}
		return totaldata;
	}

	@Override
	public void initializeService(String str) throws Exception
	{
		try
		{
			data = new KWGenDmozLDAdata3(configData);
			final Thread thread = new Thread(data);
			thread.start();
		}
		catch (Exception e)
		{
			logger.error("Problem initializing", e);
			throw e;
		}
	}

	private String stemvString(String raws, dictUtils dict) throws Exception
	{
		// Returns the stemmed version of a word
		String os = "";
		boolean flag = false;
		for (String w : raws.split("\\s+"))
		{
			final String wordLowerCase = w.toLowerCase();
			if (!dictUtils.commonWord(wordLowerCase))
			{
				String newword = dictUtils.getRoot(w.toLowerCase());
				if (newword != null)
				{
					os = os + newword + " ";
					flag = true;
				}
			}
		}
		if (!flag)
		{
			throw new Exception("Not a valid description");
		}
		return os;
	}

	private String stemvStringNoFilter(String raws, dictUtils dict)
	{
		// Returns the stemmed version of a word
		String os = "";
		for (String w : raws.split("\\s+"))
		{
			// if(!dict.commonWord(w.toLowerCase())){
			// String aux = dict.getRoot( w.toLowerCase() );
			String aux = dict.getRoot(w.toLowerCase());
			if (aux != null)
			{
				os = os + aux + " ";
			}
			else
			{
				os = os + w + " ";
			}
		}
		return os;
	}

	public KeywordProbabilityObject[] recalculateProbabilities(Integer promotionID) throws Exception
	{
		// Get Promotion data from database
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		final Boolean returnVal = getPromoDataSP.execute(promotionID);
		final PromotionObj promotionData = getPromoDataSP.getPromotionData();
		List<AdsObject> ads = getPromoDataSP.getAds();
		String[] adsText = new String[ads.size()];
		for (int i = 0; i < adsText.length; i++)
		{
			AdsObject ad = ads.get(i);
			adsText[i] = ad.getAdTitle() + " " + ad.getAdTextLine1() + " " + ad.getAdTextLine2();
		}
		String url = promotionData.getLandingPageURL();
		String description = promotionData.getPromotionDescription();
		String productProm = promotionData.getPromotionName();
		final GetKeywordForAdEngineSP getKeywordForAdEngineSP = new GetKeywordForAdEngineSP();
		final List<KeywordProbabilityObject> keywordList = getKeywordForAdEngineSP.execute(promotionID.intValue(), true, true);
		SemplestUtils.filterOutDeletedKeywords(keywordList);

		// Check Search Engines and decide number of kw per Search Engine
		List<String> categories = new ArrayList<String>(SemplestDB.getPromotionCategory(promotionID));
		categories = data.cu.decode(categories);
		if (categories == null || categories.size() == 0)
		{
			throw new Exception("No categories provided");
		}

		// Check promotion data
		if (productProm != null && productProm.length() >= 0)
		{
			productProm = productProm.toLowerCase().replaceAll("\\p{Punct}", " ");
		}
		if (description == null || description.length() == 0)
		{
			throw new Exception("No description provided");
		}
		description = description.toLowerCase().replaceAll("\\p{Punct}", " ");

		// Weight data based on percentage
		String data1 = this.weightData(data.userInfoWeight, url, adsText, "", productProm, description);

		// Create a ArrayList of the categories that satisfy options selected by the user and ArrayList with data form those categories
		Map<String, String> trainMap = getCatChildsAndData(categories);
		List<String> optCateg = new ArrayList<String>(trainMap.keySet());
		logger.info("Number of categories to add " + trainMap.size());

		// Train LDA for categories selected and return sorted keywords and obtain word probability
		Map<String, Double> wordMap = createWordMap(data1, trainMap, description);
		logger.info("previous wordmap size: " + wordMap.size());
		Double defaultProb = getDefaultProbability(wordMap);

		// Calculate Keyword Probability
		List<String> keywords = new ArrayList<String>();
		for (KeywordProbabilityObject kw : keywordList)
		{
			keywords.add(kw.getKeyword().trim());
		}
		Map<String, Double> kwProbMap = getKwProbability(keywords, wordMap, "\\s+", defaultProb);
		List<KeywordProbabilityObject> kwOut = new ArrayList<KeywordProbabilityObject>(kwProbMap.size());
		for (String kw : kwProbMap.keySet())
		{
			for (int j = 0; j < keywordList.size(); j++)
			{
				if (kw.trim().equalsIgnoreCase(keywordList.get(j).getKeyword().trim()))
				{
					KeywordProbabilityObject kwUpd = keywordList.get(j);
					kwUpd.setSemplestProbability(kwProbMap.get(kw));
					kwOut.add(kwUpd);
				}
			}
		}
		kwOut = sortKeywords(kwOut, kwOut.size());
		return kwOut.toArray(new KeywordProbabilityObject[kwOut.size()]);
	}

	private Double getDefaultProbability(Map<String, Double> wordMap) throws FileNotFoundException
	{
		final ValueComparator bvc = new ValueComparator(wordMap);
		final TreeMap<String, Double> sortedMap = new TreeMap<String, Double>(bvc);
		sortedMap.putAll(wordMap);
		final String[] words = sortedMap.keySet().toArray(new String[sortedMap.size()]);
		return wordMap.get(words[(int) (words.length * 0.6)]);
	}

	public static void main(String[] args) throws Exception
	{
		logger.info("Starting");
		new ClassPathXmlApplicationContext("Service.xml");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		logger.info("Initialized Keyword generator...");
		final KWGenDmozLDAServer3 kwGen = new KWGenDmozLDAServer3(null);
		kwGen.initializeService(null);
		final String[] searchTerm = new String[1];
		String userInfo1 = "";
		while (!userInfo1.equals("exit"))
		{
			try
			{
				logger.info("\nPlease, introduce search terms:");
				Scanner scanFile = new Scanner(System.in);
				searchTerm[0] = scanFile.nextLine();
				final String[] adds = new String[1];
				adds[0] = "";
				String description = "";
				logger.info("Search Terms: " + searchTerm[0]);
				final List<String> categOpt = kwGen.getCategories(null, null, searchTerm[0], null, null);
				logger.info("\nCategory options:");
				int m = 0;
				for (String opt : categOpt)
				{
					logger.info(m + "- " + opt);
					m++;
				}
				logger.info("Please, type indexes of categories to select separated by ',':");
				final Scanner scan = new Scanner(System.in);
				final String mySentence = scan.nextLine();
				final String[] indexes = mySentence.split(",");
				final List<String> categories = new ArrayList<String>();
				for (int v = 0; v < indexes.length; v++)
				{
					logger.info(categOpt.get(Integer.parseInt(indexes[v])));
					categories.add(categOpt.get(Integer.parseInt(indexes[v])));
				}
				// categories.add(categOpt.get(0));
				logger.info("Please, introduce path to file containing landing page (type \"exit\" to close) :");
				scanFile = new Scanner(System.in);
				userInfo1 = scanFile.nextLine();
				List<String> words1;
				String url = null;
				String uInf = "";
				if (userInfo1.contains(".clean"))
				{
					words1 = TextUtils.validTextWords(userInfo1);
					for (String word : words1)
					{
						uInf = uInf + " " + word;
					}
				}
				else
				{
					url = userInfo1;
				}
				logger.info("Please, introduce path to file containing user info (type \"exit\" to close) :");
				scanFile = new Scanner(System.in);
				userInfo1 = scanFile.nextLine();
				if (userInfo1.contains(".info"))
				{
					words1 = TextUtils.validTextWords(userInfo1);
					for (String word : words1)
					{
						description = description + " " + word;
					}
				}
				logger.info("Please, introduce path to file containing adds (type \"exit\" to close) :");
				scanFile = new Scanner(System.in);
				userInfo1 = scanFile.nextLine();
				if (userInfo1.contains(".add"))
				{
					words1 = TextUtils.validTextWords(userInfo1);
					for (String word : words1)
					{
						adds[0] = adds[0] + " " + word;
					}
				}
				Double startTime = new Long(System.currentTimeMillis()).doubleValue();
				Integer[] nGrams = { 300, 300, 100 };
				KeywordProbabilityObject[] kw = kwGen.getKeywords(categories, null, new AdEngine[] { AdEngine.Google, AdEngine.MSN }, uInf, searchTerm[0], adds, url, null, nGrams);
				Double endTime = new Long(System.currentTimeMillis()).doubleValue();
				System.out.println("Time for keywords: " + (endTime - startTime));
				for (KeywordProbabilityObject k : kw)
				{
					String kaux = k.getKeyword();
					System.out.print(kaux + " " + k.getSemplestProbability() + ", ");
				}
				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new FileOutputStream("data\\test\\keywordsCrawl2.txt")));
				// System.out.println("\n"+ (n+2)+" word keywords:");
				for (KeywordProbabilityObject k : kw)
				{
					String kaux = k.getKeyword();// .replaceAll("wed", "wedding");
					System.out.println(kaux + ", " + k.getSemplestProbability());
				}
				System.setOut(stdout);
			}
			catch (Exception e)
			{
				logger.error("Problem", e);
			}
		}
	}

	@Override
	public String checkStatus(String input1, String input2) throws Exception
	{
		return null;
	}

}
