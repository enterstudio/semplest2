package semplest.keywords.javautils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import scala.actors.threadpool.Arrays;

import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.HirstStOnge;
import edu.cmu.lti.ws4j.impl.JiangConrath;
import edu.cmu.lti.ws4j.impl.LeacockChodorow;
import edu.cmu.lti.ws4j.impl.Lesk;
import edu.cmu.lti.ws4j.impl.Lin;
import edu.cmu.lti.ws4j.impl.Path;
import edu.cmu.lti.ws4j.impl.Resnik;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import edu.cmu.lti.ws4j.util.WS4JConfiguration;

public class WNSimilarity
{

	private static ILexicalDatabase db = new NictWordNet();
	private static RelatednessCalculator rcs;/*
											 * {new HirstStOnge(db), new LeacockChodorow(db), new Lesk(db), new WuPalmer(db), new Resnik(db), new
											 * JiangConrath(db), new Lin(db), new Path(db) };
											 */

	public WNSimilarity()
	{
		rcs = new Resnik(db);
	}

	public WNSimilarity(RelatednessCalculator rc)
	{
		rcs = rc;
	}

	public Map<String, Double> wnDist(List<String> refToken, List<String> targToken)
	{
		Map<String, Double> map = new HashMap<String, Double>();
		WS4JConfiguration.getInstance().setMFS(true);
		for (String targ : targToken)
			if (!map.containsKey(targ))
			{
				double max = 0;
				for (String ref : refToken)
				{
					if (targ.equalsIgnoreCase("cakes"))
					{
						double aux = max / refToken.size();
					}
					double s = rcs.calcRelatednessOfWords(ref, targ);
					max = max + s;
					System.out.println(rcs.getClass().getName() + "\t" + s);

				}
				map.put(targ, new Double(max / refToken.size()));
			}

		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Double> sortedMap = new TreeMap<String, Double>(bvc);
		sortedMap.putAll(map);
		return sortedMap;

	}

	// Test routines ----------------------------------------------------------------
	public static List<String> getUrlWords(String url) throws IOException
	{
		List<String> targL = new ArrayList<String>();
		Map<String, List<String>> tagMap = JSoupUtils.getTagContent(url);
		List<String> in = tagMap.get("html");
		for (String line : in)
		{
			targL.addAll(TextUtils.getWords(line));
		}
		return targL;
	}

	public static String[] getDBWords(String[] cats) throws Exception
	{
		Set<String> retS = new HashSet<String>();
		Map<String, Map<String, Integer>> wc = keywordb.get(cats);
		for (Map.Entry<String, Map<String, Integer>> es : wc.entrySet())
		{
			for (Map.Entry<String, Integer> e : es.getValue().entrySet())
			{
				String[] words = e.getKey().split("\\+");
				for (String word : words)
				{
					retS.add(word);
				}
			}
		}
		return retS.toArray(new String[retS.size()]);
	}

	public static void main(String[] args) throws Exception
	{
		String ref = "English antique furniture, georgian and regency furniture, interior designers, fine english furniture";
		List<String> refL = TextUtils.getWords(ref);
		// List<String> targL = getUrlWords("http://susansilverantiques.com/");
		String[] targA = getDBWords(new String[] { "top/shopping/antiques_and_collectibles/furniture/english_antiques" });
		List<String> targL = Arrays.asList(targA);
		long t0 = System.currentTimeMillis();
		RelatednessCalculator[] rcs = { new Resnik(db), new JiangConrath(db) };
		PrintStream pr = new PrintStream(new FileOutputStream("/home/lluis/reportWNave2.txt"));
		for (RelatednessCalculator rc : rcs)
		{
			WNSimilarity sc = new WNSimilarity(rc);
			pr.println(rc.getClass().getName());
			Map<String, Double> wMap = sc.wnDist(refL, targL);
			int i = 0;
			for (String key : wMap.keySet())
			{
				if (i < 50)
					pr.println(key + " : " + wMap.get(key));
				else
					break;
				i++;
			}
			pr.println("-------------------------------------------------------------------------------------------------------");
			System.out.println("Done in " + (System.currentTimeMillis() - t0) + " msec.");
			System.out.println("Map size : " + wMap.size());
		}

	}
}
