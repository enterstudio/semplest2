package semplest.keywords.javautils;

/**
 * Given an input text and a list of categories, it finds the noun phrases from the input text that contain any of the keywords 
 * associated with the categories inputed
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import scala.actors.threadpool.Arrays;
import semplest.keywords.properties.ProjectProperties;
import semplest.nlp.SemplestNLP;
import semplest.nlp.SemplestOpenNLP;

public class ExpandNounPhrase
{

	private static final Logger logger = Logger.getLogger(ExpandNounPhrase.class);
	private DataBuffer db;
	List<String> stemdict;

	public static void main(String[] args) throws IOException
	{
		List<String> cats = new ArrayList<String>();
		cats.add("top/shopping/antiques_and_collectibles/furniture/english_antiques");
		// List<String> in = ioUtils.readFile("/home/lluis/test.txt");
		String url = "http://susansilverantiques.com/category/tables/";
		Map<String, List<String>> tagMap = JSoupUtils.getTagContent(url);
		List<String> in = tagMap.get("html");
		ExpandNounPhrase exp = new ExpandNounPhrase(null);
		List<String> aux = exp.expandNounPhrase(cats, in);
		for (String w : aux)
		{
			System.out.println(w);
		}

	}

	public ExpandNounPhrase(HashMap<String, Object> configData) throws IOException
	{
		db = new DataBuffer(configData);

	}

	// Select noun phrases from text that contain a multi word from selected categories
	public List<String> expandNounPhrase(List<String> categories, List<String> text)
	{
		long start = System.currentTimeMillis();
		List<String> multWStemL = getMultWStem(categories);
		List<String> nounPL = getNounPhrase(text);
		List<String> nounPLStem = stemList(nounPL);
		cleanNP(nounPL, nounPLStem);
		Set<String> ret = new HashSet<String>();
		for (String multWStem : multWStemL)
		{
			if (multWStem.contains("antiqu engl"))
				System.currentTimeMillis();
			for (int i = 0; i < nounPL.size(); i++)
				if (!ret.contains(nounPL.get(i)) && cleanWhite(nounPLStem.get(i)).contains(cleanWhite(multWStem)))
				{
					nounPLStem.remove(i);
					ret.add(nounPL.remove(i).toLowerCase());
					i--;
				}
		}
		logger.info("time for expanding noun phrases : " + (System.currentTimeMillis() - start));
		return Arrays.asList(ret.toArray(new String[ret.size()]));
	}

	private void cleanNP(List<String> nounPL, List<String> nounPLStem)
	{
		for (int i = 0; i < nounPLStem.size(); i++)
		{
			if (nounPLStem.get(i).isEmpty() || nounPLStem.get(i).split("\\s+").length <= 1)
			{
				nounPLStem.remove(i);
				nounPL.remove(i);
				i--;
			}

		}
	}

	// Get noun phrases from input text
	public List<String> getNounPhrase(List<String> text)
	{
		long start = System.currentTimeMillis();
		SemplestNLP nlp = db.nlp;
		logger.info("time to load NLP :" + (start - System.currentTimeMillis()));
		List<String> ret = new ArrayList<String>();
		for (String line : text)
		{
			List<List<String>> sent = nlp.getNounBlocksFromText(line, 1);
			for (List<String> subL : sent)
				ret.addAll(subL);
		}
		return ret;
	}

	// Stem a list of Strings
	public List<String> stemList(List<String> list)
	{
		List<String> ret = new ArrayList<String>();
		for (String sent : list)
		{
			sent = sent.replaceAll("\\p{Punct}", " ");
			String nw = "";
			for (String word : sent.split("\\s+"))
			{
				nw = nw + " " + TextUtils.stemNSW(word).trim();
			}
			nw = nw.trim();
			if (!nw.isEmpty() && nw.split("\\s+").length > 1)
				ret.add(nw);
			else
				ret.add("");
		}
		return ret;
	}

	// Get multiwords from appropiate source and stem them.
	public List<String> getMultWStem(List<String> categories)
	{
		List<String> multW = db.getMultWSetfromMem(categories);
		Set<String> ret = new HashSet<String>();
		for (String word : multW)
		{
			String aux = word.replaceAll("\\+", " ");
			if (!aux.isEmpty())
				ret.add(aux);
		}
		List<String> stemList = stemList(Arrays.asList(ret.toArray(new String[ret.size()])));
		List<String> retL = new ArrayList<String>();
		for (String stem : stemList)
			if (!stem.isEmpty())
				retL.add(stem);
		return retL;
	}

	// Cleans white spaces in a String
	public String cleanWhite(String in)
	{
		return in.replaceAll("\\s+", " ").trim();
	}

	// ************************************************************************************************************
	private static class DataBuffer
	{
		private Map<String, MultiWordCollect[]> mWords; // Colections of multiwords with origin as key
		private ProjectProperties pr; // Properties loaded from file or database
		private static final Map<String, String> sources = getSrcNameExt();
		SemplestNLP nlp = new SemplestOpenNLP();

		public static Map<String, String> getSrcNameExt()
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("bigrams", ".2");
			map.put("trigrams", ".3");
			map.put("fourgrams", ".4");

			return map;
		}

		DataBuffer(HashMap<String, Object> configData) throws IOException
		{
			pr = new ProjectProperties(configData);
			mWords = new HashMap<String, MultiWordCollect[]>();
			for (String key : sources.keySet())
			{
				insertMultiWSet(key, sources.get(key));
			}
		}

		// Insert Words from
		public void insertMultiWSet(String key, String fileExt)
		{
			MultiWordCollect[] mC = new MultiWordCollect[pr.nGramsSubC.length];
			logger.info("loading multiwords [" + key + "]");
			for (int i = 0; i < mC.length; i++)
			{
				String path = pr.baseMultiWPath + pr.nGramsSubC[i] + fileExt;
				logger.info("\tloading file:" + path);
				mC[i] = new MultiWordCollect(pr.nGramsSubC[i], path);
			}
			mWords.put(key, mC);
		}

		// Returns a list containing multiwords from all the sources
		public List<String> getMultWSetfromMem(List<String> categories)
		{
			List<String> ret = new ArrayList<String>();
			for (String cat : categories)
			{
				for (String key : mWords.keySet())
				{
					int mIndex = getnGramSubCatInd(cat);
					List<String> auxL = mWords.get(key)[mIndex].getwordsInCateg(cat);
					ret.addAll(auxL);
				}
			}
			return ret;
		}

		public int getnGramSubCatInd(String categ)
		{
			// Return index of the subcategory containing the category inspected
			for (int i = 0; i < pr.nGramsSubC.length; i++)
			{
				if (catUtils.take(categ, 2).contains(pr.nGramsSubC[i]))
					return i;
			}
			return -1;
		}

	}

}
