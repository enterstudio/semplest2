package semplest.keywords.ldatest;

/**
 * Production version of the Keyword Generation Server
 * Using vector space implementation
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import scala.actors.threadpool.Arrays;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.javautils.vsUtils;
import semplest.keywords.lda.*;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;

import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import cc.mallet.types.InstanceList;

public class KWGenDmozLDAdataVS
{// implements SemplestKeywordLDAServiceInterface{

	private static final Logger logger = Logger.getLogger(KWGenDmozLDAdataVS.class);
	// Search index for categories
	private static KWGenDmozLDAdata3 data;
	private static Map<String, Object> configData;

	public KWGenDmozLDAdataVS(Map<String, Object> configDataIn)
	{
		configData = configDataIn;
	}

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
			List<String> categories = this.getCategories(description);
			return categories;
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
			throw e;
		}
	}

	public List<String> getCategories(String searchTerm) throws Exception
	{
		// Get category results from dmoz query
		try
		{
			String qs = "";
			String[] res;
			String categories;
			List<String> optList = new ArrayList<String>();
			List<String> optInitial = new ArrayList<String>();
			int numresults = 100; // Number of results from the query
			qs = searchTerm;
			String qsStem = this.stemvString(qs, data.dict);
			if (qsStem != null && qsStem.length() > 0)
			{
				logger.debug(qsStem);
				res = data.dl.search(qsStem, numresults);
				for (int i = 0; i < res.length; i++)
				{
					categories = res[i].replaceAll("\\s+", "");
					if (catUtils.validcat(categories))
					{
						optInitial.add(categories);
					}
					// logger.debug(categories);
				}
				// Select repeated patterns
				optList = selectOptions(optInitial);
			}
			return optList;
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
			throw e;
		}
	}

	public KeywordProbabilityObject[] getKeywords(List<String> categories, String companyName, AdEngine[] searchEngines, String searchTerm, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception
	{
		try
		{
			if (searchTerm != null || searchTerm.length() >= 0)
			{
				searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
			}
			if (description == null || description.length() == 0)
			{
				throw new Exception("No description provided");
			}
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			int[] numKw = new int[searchEngines.length];
			int j = 0;
			for (AdEngine se : searchEngines)
			{
				if (se == AdEngine.Google)
				{
					numKw[j] = data.numKeywordsGoogle;
				}
				else if (se == AdEngine.MSN)
				{
					numKw[j] = data.numKeywordsMSN;
				}
				else
				{
					numKw[j] = 0;
				}
				j++;
			}

			if (categories == null || categories.size() == 0)
			{
				throw new Exception("No categories provided");
			}
			if (nGrams == null || nGrams.length != 2)
			{
				throw new Exception("Wrong number nGrams provided");
			}

			String data1 = "";

			data1 = this.weightData(data.userInfoWeight, url, adds, companyName, searchTerm, description);
			String[] dataCount = data1.split("\\s+");
			if (dataCount.length < 10)
			{
				throw new Exception("Not enough data provided");
			}

			/*
			 * String stemdata1 = new String(); stemdata1 = this.stemvStringNoFilter( data1, data.dict );
			 */
			String stemdata1 = data1;
			int numkw = 0;
			for (int i = 0; i < numKw.length; i++)
			{
				if (numKw[i] > numkw)
				{
					numkw = numKw[i];
				}
			}

			final List<AdEngine> sEngines = Arrays.asList(searchEngines);
			List<List<KeywordProbabilityObject>> keywords = getKeywords(categories, description, stemdata1, numkw, sEngines, nGrams);
			List<KeywordProbabilityObject> keywordsList = new ArrayList<KeywordProbabilityObject>();
			int num = 0;
			for (List<KeywordProbabilityObject> list1 : keywords)
			{
				for (KeywordProbabilityObject kw : list1)
				{
					for (int n = 0; n < searchEngines.length; n++)
					{
						AdEngine se = searchEngines[n];
						if (se == AdEngine.Google && num >= numKw[n])
						{
							kw.setIsTargetGoogle(false);
						}
						else if (se == AdEngine.MSN && num >= numKw[n])
						{
							kw.setIsTargetMSN(false);
						}
					}
					keywordsList.add(kw);
					num++;
				}
			}
			return keywordsList.toArray(new KeywordProbabilityObject[] {});
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
			throw e;
		}
	}

	public List<List<KeywordProbabilityObject>> getKeywords(List<String> categories, String searchTerm, String data1, int numkw, List<AdEngine> srchE, Integer[] nGrams) throws Exception
	{
		try
		{

			List<List<KeywordProbabilityObject>> keywordsfull = new ArrayList<List<KeywordProbabilityObject>>();
			List<List<KeywordProbabilityObject>> keywords = new ArrayList<List<KeywordProbabilityObject>>();
			/*
			 * //Create a ArrayList of the categories that satisfy options selected by the user and ArrayList //with data form those categories long
			 * startTime = System.currentTimeMillis(); ArrayList<String> optCateg = new ArrayList<String>();
			 * 
			 * Set<String> labels = data.TrainingData.keySet(); ArrayList<String> trainLines = new ArrayList<String>(); String cataux; for (String label :
			 * labels){ for (int n=0; n<categories.size();n++){ cataux = categories.get(n); if( label.indexOf( cataux ) == 0 ) { //logger.debug(label);
			 * optCateg.add(label); //Gather training data trainLines.add(data.TrainingData.get(label)); } } }
			 * 
			 * 
			 * long endTime = System.currentTimeMillis(); logger.info("time for categories" + (endTime-startTime));
			 * logger.info("Number of categories to add " + trainLines.size()); //Train LDA for categories selected and return sorted keywords //and obtain
			 * word probability
			 * 
			 * HashMap<String, Double> wordMap= this.createWordMap(data1, trainLines, searchTerm); logger.info("previous wordmap size: "+ wordMap.size());
			 * //Rank monograms by probability ValueComparator bvc = new ValueComparator(wordMap); TreeMap<String,Double> wordM = new TreeMap(bvc);
			 * wordM.putAll(wordMap); logger.info("wordMap Size: "+ wordM.size());
			 * 
			 * logger.info("Generating Kewyords"); Set<String> kwSet = wordM.keySet();
			 */
			// Generate a maximum of 5000 keywords nGrams[0] bigrams + nGrams[1] trigrams and the rest split between 4 grams and 5 grams
			keywordsfull = getKwMultiCombined(categories, searchTerm, nGrams, 5, srchE, data1);
			int kwCount = 0;
			int iter = 0;
			List<KeywordProbabilityObject> finalkwList;
			for (List<KeywordProbabilityObject> kwList : keywordsfull)
			{
				if (iter < 2)
				{
					finalkwList = kwList;
				}
				else
				{
					finalkwList = new ArrayList<KeywordProbabilityObject>();
				}
				int remain = numkw - kwCount;
				int num2Gen = 0;
				// fourgrams and fivegrams
				if (iter == 2)
				{
					num2Gen = remain / 2;
				}
				if (iter == 3)
				{
					num2Gen = remain;
				}
				int j = 0;
				for (KeywordProbabilityObject keyw : kwList)
				{
					if (j >= num2Gen)
					{
						break;
					}
					finalkwList.add(keyw);
					j++;
				}

				kwCount = kwCount + finalkwList.size();
				iter++;
				keywords.add(finalkwList);
			}

			return keywords;
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
			throw e;
		}
	}

	private List<String> expandCategories(List<String> newCategories) throws Exception
	{
		List<String> optCateg = new ArrayList<String>();
		Set<String> labels = data.TrainingData.keySet();
		String cataux;
		for (String label : labels)
		{
			for (int n = 0; n < newCategories.size(); n++)
			{
				cataux = newCategories.get(n);
				if (label.indexOf(cataux) == 0)
				{
					if (!optCateg.contains(label))
					{
						// logger.debug(label);
						optCateg.add(label);
					}
				}
			}
		}
		return optCateg;
	}

	private Map<String, Double> createWordMap(String data1, List<String> trainLines, String searchTerm) throws Exception
	{
		Map<String, Double> wordMap = new HashMap<String, Double>();
		MalletTopic lda = new MalletTopic();
		double alpha = 0.01;
		double beta = 0.01;
		int numiter = 100;
		logger.info("Number of categories" + trainLines.size());

		lda.CreateInstances(trainLines);
		int numTopics = data.numTopics;
		if (trainLines.size() < numTopics)
		{
			numTopics = trainLines.size();
		}
		lda.setNumTopics(numTopics);
		lda.LDAcreateModel(alpha, beta, numiter);
		InstanceList inferInst;
		inferInst = lda.CreateInferInstfromData("0", "Test Data", data1);
		// logger.info("inferInst alphabet size: "+ inferInst.getAlphabet().size());

		// Infer word probability based on input data
		wordMap = lda.inferWordprob(inferInst, 0, true);
		// logger.info("insider word map size:"+wordMap.size());
		String qsStem = this.stemvStringNoFilter(searchTerm, data.dict);
		if (searchTerm != null)
		{
			String[] terms = qsStem.split("\\s+");
			for (int n = 0; n < terms.length; n++)
			{
				wordMap.put(terms[n], new Double(1.0));
			}
		}
		return wordMap;

	}

	private List<List<KeywordProbabilityObject>> getKwMultiCombined(List<String> optCateg, String searchTerms, Integer[] nGrams, int nGramsmax, List<AdEngine> srchE, String data1) throws Exception
	{

		// Returns 4 grams combining 2 and 3 grams
		List<KeywordProbabilityObject> bigrams = getKwMulti(searchTerms, optCateg, nGrams[0], data1, 2, srchE);
		List<KeywordProbabilityObject> trigrams = getKwMulti(searchTerms, optCateg, nGrams[1], data1, 3, srchE);
		int iter = 0;
		/*
		 * while (iter<3 && (bigrams.size()<10 || trigrams.size()<10)){ ArrayList<String> newCategories = new ArrayList<String>(); for (int n=0;
		 * n<optCateg.size();n++){ String parent = catUtils.parent(optCateg.get(n)); if(catUtils.nodes(parent)>2) newCategories.add(parent); else
		 * newCategories.add(optCateg.get(n)); } optCateg= newCategories; ArrayList<String> newOptCateg = this.expandCategories(optCateg); bigrams =
		 * getKwMulti(searchTerms, newOptCateg, nGrams[0], data1, 2, srchE); trigrams = getKwMulti(searchTerms, newOptCateg, nGrams[1], data1, 3, srchE);
		 * logger.info("Expanding categories"); iter++;
		 * 
		 * }
		 */
		List<List<KeywordProbabilityObject>> results = new ArrayList<List<KeywordProbabilityObject>>();
		results.add(bigrams);
		results.add(trigrams);
		/*
		 * HashMap<String,ArrayList<String>> biGMap= new HashMap<String,ArrayList<String>>(); // Create Hashmap of biwords; for(KeywordProbabilityObject
		 * base: bigrams){ String[] words = base.getKeyword().split("\\s+"); ArrayList<String> aux; for(int i=0; i<words.length; i++){
		 * if(biGMap.containsKey(words[i])){ aux = biGMap.get(words[i]); aux.add(base.getKeyword()); }else{ aux = new ArrayList<String>();
		 * aux.add(base.getKeyword()); biGMap.put(words[i], aux); } } }
		 * 
		 * 
		 * logger.info("Creating nGrams bigger than 3..."); //Extend keyword list if(nGramsmax>=4){ for(int m = 4; m<=nGramsmax; m++){
		 * ArrayList<KeywordProbabilityObject> tempArray = new ArrayList<KeywordProbabilityObject>(); HashMap<String,Double> temp = new
		 * HashMap<String,Double>(); ValueComparator bvc = new ValueComparator(temp); TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
		 * ArrayList<KeywordProbabilityObject> baseList = results.get(m-3); for(KeywordProbabilityObject base: baseList){ String[] words =
		 * base.getKeyword().split("\\s+"); ArrayList<String> aux; for(int i=0; i<words.length; i++){ if(biGMap.containsKey(words[i])){
		 * aux=biGMap.get(words[i]); for(String gr: aux){
		 * 
		 * boolean flag=false; String[] prts = gr.split("\\s+"); for(int n=0;n<prts.length;n++){ String stembase= this.stemvStringNoFilter(
		 * base.getKeyword(), data.dict); stembase = stembase.replaceAll("\\s+", ""); String stempart = this.stemvStringNoFilter( prts[n], data.dict);
		 * stempart = stempart.replaceAll("\\s+", ""); String stemwrdsi = this.stemvStringNoFilter( words[i], data.dict); stemwrdsi =
		 * stemwrdsi.replaceAll("\\s+", ""); if(!stempart.equals(stemwrdsi) && stembase.contains(stempart)){ flag=true; break; } } if(!flag){ String kwnew
		 * = base.getKeyword().replace(words[i],gr); kwnew = kwnew.replaceAll("\\s+", " "); temp.put(kwnew,this.calculateKWProb(kwnew, wordMap)); } } } }
		 * } sorted_map.putAll(temp); Set<String> keySet = sorted_map.keySet(); for(String key: keySet){ KeywordProbabilityObject kProb = new
		 * KeywordProbabilityObject(); if(srchE.contains(SearchEngine.Google)) kProb.setIsTargetGoogle(true); else kProb.setIsTargetGoogle(false);
		 * if(srchE.contains(SearchEngine.MSN)) kProb.setIsTargetMSN(true); else kProb.setIsTargetMSN(false); kProb.setKeyword(key);
		 * kProb.setSemplestProbability(temp.get(key)); tempArray.add(kProb); } results.add(tempArray); } }
		 */
		return results;

	}

	private Double calculateKWProb(String keyword, Map<String, Double> wordMap) throws Exception
	{
		String[] kwPart = keyword.split("\\s+");
		double wProb = 1;
		for (int i = 0; i < kwPart.length; i++)
		{
			if (wordMap.containsKey(kwPart[i]))
			{
				wProb = wProb * wordMap.get(kwPart[i]);
			}
			else
			{
				wProb = 0;
				break;
			}
		}
		return new Double(wProb);
	}

	private List<KeywordProbabilityObject> getKwMulti(String searchTerms, List<String> optCateg, int numkw, String data1, int nGrams, List<AdEngine> srchE) throws Exception
	{
		// Generates keywords with nGrams words

		String basePath = data.pr.baseMultiWPath;
		String extension = ".2";
		List<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		// Select bigrams or trigrams based on nGrams value
		switch (nGrams)
		{
			case 2:
				extension = ".2";
				break;
			case 3:
				extension = ".3";
				break;
			default:
				throw new Exception("nGrams value not valid");
		}

		/*
		 * //************************************************************************************** // Now that we have generated a selection of
		 * categories that we want to use to generate our alphabet, // we need to generate that alphabet and infer the word probabilities for each of the
		 * words in the alphabet HashMap<String, Double> multWMap = new HashMap<String, Double>(); ValueComparator bvc = new ValueComparator(multWMap);
		 * TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc); int i=0; Set<String> keySet; java.util.Iterator<String> iterator;
		 * 
		 * String[] subWrds; String kwrd; double wProb; boolean in=true;
		 * 
		 * //Generate bigrams and trigrams in search Term and add them to the multi word list to be evaluated ArrayList<String> descripWords =
		 * this.generateNgramsFromString(searchTerms, nGrams);
		 * 
		 * 
		 * // Generating Multiword alphabet // Extract multiword for each category in the list and multiply probabilities of each subword for(String
		 * optKey: optCateg){ int mIndex= data.getnGramSubCatInd(optKey); ArrayList<String> mWords= new ArrayList<String>(); ArrayList<String> auxArray =
		 * nGramsA[mIndex].getwordsInCateg(optKey); if(descripWords!=null) mWords.addAll(descripWords); if(auxArray!=null) mWords.addAll(auxArray); if
		 * (mWords != null){ for(String mWrd:mWords){ subWrds=mWrd.split("\\+"); wProb=1.0; kwrd=""; String kwstem = ""; boolean flag = true; for(int
		 * n=0;n<subWrds.length;n++){ String subWstem = this.stemvStringNoFilter( subWrds[n], data.dict).replaceAll("\\s+", "");
		 * if(!wordMap.containsKey(subWstem) || kwstem.contains(subWstem)){ flag=false; break; } kwrd=kwrd+subWrds[n]+" "; kwstem = kwstem+subWstem+" "; }
		 * if(flag!=false && !multWMap.containsKey(kwrd)){ for(int n=0;n<subWrds.length;n++){ String subWstem = this.stemvStringNoFilter( subWrds[n],
		 * data.dict).replaceAll("\\s+", ""); wProb=wProb*wordMap.get(subWstem); } multWMap.put(kwrd, wProb); }
		 * 
		 * } } } //Once the alphabet and probabilities have been generated, sort by probability. sorted_map.putAll(multWMap);
		 * 
		 * //Generating Keywords keySet=sorted_map.keySet();
		 * 
		 * String keyword; i=0; iterator=keySet.iterator();
		 */

		String[] kw = vsUtils.generateNgrams(basePath, extension, optCateg, data1, numkw);
		List<String> kwList = Arrays.asList(kw);
		List<String> descripWords = this.generateNgramsFromString(searchTerms, nGrams);
		kwList.addAll(descripWords);
		for (int i = 0; i < kwList.size() && i < numkw; i++)
		{
			String keyword = kwList.get(i);
			KeywordProbabilityObject kProb = new KeywordProbabilityObject();
			if (srchE.contains(AdEngine.Google))
			{
				kProb.setIsTargetGoogle(true);
			}
			else
			{
				kProb.setIsTargetGoogle(false);
			}
			if (srchE.contains(AdEngine.MSN))
			{
				kProb.setIsTargetMSN(true);
			}
			else
			{
				kProb.setIsTargetMSN(false);
			}
			kProb.setKeyword(keyword);
			kProb.setSemplestProbability(new Double(1.0 * (kwList.size() - i) / kwList.size()));
			keywords.add(kProb);
		}

		return keywords;

	}

	private List<String> generateNgramsFromString(String string, int nGrams)
	{
		// Given a string returns an ArrayList of all the nGrams groups of words in the string serperated by a blank space
		List<String> ngrams = new ArrayList<String>();
		string = this.stemvStringNoFilter(string, data.dict);
		String[] words = string.split("\\s+");
		if (words.length >= nGrams)
		{
			for (int i = 0; i <= words.length - nGrams; i++)
			{
				String newWord = "";
				for (int j = 0; j < nGrams; j++)
				{
					newWord = newWord + "+" + words[i + j];
				}
				ngrams.add(newWord.replaceAll("\\+$", "").replaceAll("^\\+", ""));
			}
		}
		return ngrams;
	}

	private static List<String> selectOptions(List<String> optKeys) throws IOException
	{
		// Selects patterns from top categories list to generate options for the user based on pre-defined crieteria

		int numNEval = 20;
		Map<String, Double> optList = new HashMap<String, Double>();
		ValueComparator bvcAux = new ValueComparator(optList);
		TreeMap<String, Double> sorted_opt = new TreeMap<String, Double>(bvcAux);

		int numNodes;
		// Identify repeated patterns in top categories
		String newoption;
		String[] pair = new String[2];
		for (int n = 0; n < optKeys.size(); n++)
		{
			for (int m = 0; m < n; m++)
			{
				pair[0] = optKeys.get(n);
				pair[1] = optKeys.get(m);
				newoption = catUtils.longestAncestor(pair);
				if (optList.containsKey(newoption))
				{
					optList.put(newoption, ((Double) optList.get(newoption)) + 1.0);
				}
				else
				{
					optList.put(newoption, new Double(1));
				}
			}
		}

		sorted_opt.putAll(optList);

		// Filter out just relevant patterns
		Map<String, Double> optList2 = new HashMap<String, Double>();
		ValueComparator bvcAux2 = new ValueComparator(optList2);
		TreeMap<String, Double> sorted_opt2 = new TreeMap<String, Double>(bvcAux2);
		Double numrepeat;
		Set<String> optKeys2 = sorted_opt.keySet();
		for (String optKey : optKeys2)
		{
			numNodes = catUtils.nodes(optKey);
			numrepeat = optList.get(optKey);
			if (numNodes >= 4 && numrepeat > 3)
			{
				if (catUtils.last(optKey).length() > 1)
				{
					if (!optList2.containsKey(catUtils.take(optKey, numNEval)))
					{
						optList2.put(catUtils.take(optKey, numNEval), new Double(numNodes));
					}
				}
			}
		}

		sorted_opt2.putAll(optList2);
		// Present sorted pattern form most relevant to less relevant
		Set<String> sorted_optKeys2 = sorted_opt2.keySet();
		List<String> arrayOpt = new ArrayList<String>();
		// Add top 3
		int numtop;
		if (sorted_optKeys2.size() < 5)
		{
			numtop = 5;
		}
		else
		{
			numtop = 4;
		}
		int numresults = 0;
		for (int i = 0; i < optKeys.size(); i++)
		{
			if (numresults >= numtop)
			{
				break;
			}
			// String key = catUtils.init(optKeys.get(i));
			String key = optKeys.get(i);
			if (!arrayOpt.contains(key))
			{
				arrayOpt.add(key);
				numresults++;
			}
		}
		// Add rest of the patterns
		for (String key : sorted_optKeys2)
		{
			if (!arrayOpt.contains(key))
			{
				arrayOpt.add(key);
			}
		}
		return arrayOpt;
	}

	private String weightData(double weight, String url, String[] adds, String companyName, String searchTerm, String description) throws Exception
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
		userData = userData + " " + companyName + " " + searchTerm + " " + description;
		String[] userCount = userData.split("\\s+");
		// If not user data provided, or too few, it will not be used.
		logger.info("Words from user: " + userCount.length);
		if ((userCount.length) < 10)
		{
			logger.info("No user data provided");
			weight = 0;
		}
		if ((userCount.length + dataUrl.size()) < 10)
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

	public void initializeService(String str) throws Exception
	{
		try
		{
			data = new KWGenDmozLDAdata3(configData);
			Thread thread = new Thread(data);
			thread.start();
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
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
			if (!dict.commonWord(w.toLowerCase()))
			{
				String newword = dict.getStemWord(w.toLowerCase());
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
			if (!dict.commonWord(w.toLowerCase()))
			{
				String aux = dict.getStemWord(w.toLowerCase());
				if (aux != null)
				{
					os = os + aux + " ";
				}
				else
				{
					os = os + w + " ";
				}
			}
		}
		return os;
	}

	private Map<String, String> createReverseStemMap(String description)
	{
		Map<String, Map<String, Double>> reverseMapCount = new HashMap<String, Map<String, Double>>();
		Map<String, String> reverseMap = new HashMap<String, String>();
		String wordStem;
		for (String word : description.split("\\s+"))
		{
			wordStem = this.stemvStringNoFilter(word, data.dict).replaceAll("\\s+", "");
			if (wordStem != null && wordStem.length() > 0)
			{
				Map<String, Double> wordCount;
				if (reverseMapCount.containsKey(wordStem))
				{
					wordCount = reverseMapCount.get(wordStem);
					if (wordCount.containsKey(word))
					{
						wordCount.put(word, wordCount.get(word) + 1);
					}
					else
					{
						wordCount.put(word, new Double(1));
					}
				}
				else
				{
					wordCount = new HashMap<String, Double>();
					wordCount.put(word, new Double(1));
				}
				reverseMapCount.put(wordStem, wordCount);
			}
		}

		Set<String> keySet = reverseMapCount.keySet();
		for (String key : keySet)
		{
			Map<String, Double> wordCount = reverseMapCount.get(key);
			Set<String> wordSet = wordCount.keySet();
			if (wordSet.size() > 0)
			{
				String maxWord = "";
				Double maxValue = 0.0;
				for (String word : wordSet)
				{
					if (wordCount.get(word) >= maxValue)
					{
						maxValue = wordCount.get(word);
						maxWord = word;
					}
				}
				reverseMap.put(key, maxWord);
			}
		}

		return reverseMap;
	}

	private KeywordProbabilityObject backStemming(KeywordProbabilityObject kw, Map<String, String> reverseMap)
	{
		String words[] = kw.getKeyword().split("\\s+");
		String backStem = "";
		for (String word : words)
		{
			String newWord = reverseMap.get(word);
			if (newWord != null)
			{
				backStem = backStem + " " + newWord;
			}
			else
			{
				backStem = backStem + " " + word;
			}
		}
		kw.setKeyword(backStem);
		return kw;
	}

	public static void main(String[] args) throws Exception
	{

		BasicConfigurator.configure();

		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 * 
		 * ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml"); Object object = new Object();
		 * SemplestConfiguration configDB = new SemplestConfiguration(object); Thread configThread = new Thread(configDB); configThread.start();
		 * synchronized (object) { object.wait(); } /* Init Keyword Data
		 */
		logger.info("Initialized Keyword generator...");

		// KWGenDmozLDAServer kwGen = new KWGenDmozLDAServer(SemplestConfiguration.configData);
		KWGenDmozLDAdataVS kwGen = new KWGenDmozLDAdataVS(null);
		kwGen.initializeService(null);
		String[] searchTerm = new String[1];
		String userInfo1 = "";
		BasicConfigurator.configure();
		while (!userInfo1.equals("exit"))
		{
			try
			{
				logger.info("\nPlease, introduce search terms:");
				Scanner scanFile = new Scanner(System.in);
				searchTerm[0] = scanFile.nextLine();
				String[] adds = new String[1];
				adds[0] = "";
				String description = "";

				logger.info("Search Terms: " + searchTerm[0]);
				List<String> categOpt = kwGen.getCategories(null, null, searchTerm[0], null, null);
				logger.info("\nCategory options:");
				int m = 0;
				for (String opt : categOpt)
				{
					logger.info(m + "- " + opt);
					m++;
				}
				logger.info("Please, type indexes of categories to select separated by ',':");
				Scanner scan = new Scanner(System.in);
				String mySentence = scan.nextLine();
				String[] indexes = mySentence.split(",");

				List<String> categories = new ArrayList<String>();
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
				Integer[] nGrams = { 100, 100 };
				KeywordProbabilityObject[] kw = kwGen.getKeywords(categories, null, new AdEngine[] { AdEngine.Google, AdEngine.MSN }, uInf, searchTerm[0], adds, url, null, nGrams);
				Double endTime = new Long(System.currentTimeMillis()).doubleValue();
				System.out.println("Time for keywords: " + (endTime - startTime));
				for (KeywordProbabilityObject k : kw)
				{
					String kaux = k.getKeyword();
					System.out.print(kaux + " " + k.getSemplestProbability() + ", ");
				}

				PrintStream stdout = System.out;
				System.setOut(new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/keywordsCrawl2.txt")));

				// System.out.println("\n"+ (n+2)+" word keywords:");
				for (KeywordProbabilityObject k : kw)
				{
					String kaux = k.getKeyword();// .replaceAll("wed", "wedding");
					System.out.println(kaux);
				}

				System.setOut(stdout);

			}
			catch (Exception e)
			{
				logger.error("Problem", e);
			}
		}
	}
	/*
	 * public static void main(String[] args) {
	 * 
	 * try { KWGenDmozLDAServer client = new KWGenDmozLDAServer(); client.initializeService(null); long start = System.currentTimeMillis();
	 * ArrayList<String> res = client.getCategories(null, "peanut butter", null, null, null); double sec = (double) (System.currentTimeMillis() -
	 * start)/1000.0; System.out.println("categories took " + sec + " seconds"); for (int i = 0; i < res.size(); i++) { System.out.println(res.get(i));
	 * }
	 * 
	 * start = System.currentTimeMillis(); ArrayList<String> selectCateg = new ArrayList<String>(); selectCateg.add(res.get(1));
	 * System.out.println("Selected:"+res.get(1)); ArrayList<ArrayList<String>> kw = client.getKeywords(selectCateg,null, "peanut butter", null, null,
	 * "http://peanutbutterlovers.com/", new Integer[]{50,50}); sec = (double) (System.currentTimeMillis() - start)/1000.0;
	 * System.out.println("keywords took " + sec + " seconds"); for(int n=0; n<kw.size(); n++){ System.out.println("\n"+ (n+2)+" word keywords:");
	 * for(String k: kw.get(n)){ System.out.print(k+", "); } }
	 * 
	 * } catch (Exception e) { //logger.error(e.getSemplestErrorID() + e.getSemplestErrorMessage()); e.printStackTrace(); } }
	 */

}
