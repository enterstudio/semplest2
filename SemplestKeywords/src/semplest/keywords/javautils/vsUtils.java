package semplest.keywords.javautils;

import java.lang.Math;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

import org.apache.log4j.Logger;

/*
 * Vector Space (vs) tool-box
 * Treats a word-count as a vector in the word-space
 * The basic word-count vector here is a HashMap<String,Integer>
 * 
 * Note; To use counts and avoid fractions, the UNIT vector
 * has length = 1000 rather than 1.
 * 
 */
public class vsUtils
{
	private static final Logger logger = Logger.getLogger(vsUtils.class);
	private static final int UNIT = 1000; // The unit-vector length

	// - static interface -------------------------------------------------------
	// length of the vector (L2 norm)
	public static Integer cLen(Map<String, Integer> wc)
	{
		return (int) Math.round(Math.sqrt(sSquares(wc)));
	}

	// normalize vector to UNIT length (L2 norm)
	public static Double cNorm(Map<String, Integer> wc)
	{
		return (UNIT * 1.0 / Math.max(Math.sqrt(sSquares(wc)), 1.0));
	}

	public static Map<String, Integer> cNormalize(Map<String, Integer> wc)
	{
		if (null == wc)
			return null;
		Map<String, Integer> omap = new HashMap<String, Integer>();
		Double w = cNorm(wc);
		for (Map.Entry<String, Integer> e : wc.entrySet())
			omap.put(e.getKey(), (int) Math.round(e.getValue() * w));
		return omap;
	}

	// cosine distance between two vectors
	// [Note:] we check intersection rather than equality of keywords (as ngram)
	public static Double cDist(Map<String, Integer> a, Map<String, Integer> b)
	{
		Map<String, Integer> na = ngWc(cNormalize(a));
		Map<String, Integer> nb = ngWc(cNormalize(b));
		Double dotp = 0.0;
		Set<String> common = na.keySet();
		common.retainAll(nb.keySet());
		for (String w : common)
			dotp += na.get(w) * nb.get(w);
		return Math.acos(dotp / (UNIT * UNIT * 1.0));
	}

	// - add vectors together --------------------------------------------------
	// add together a collection of vectors (wc)
	public static Map<String, Integer> cAdd(Map<String, Map<String, Integer>> wcs)
	{
		Map<String, Integer> omap = new HashMap<String, Integer>();
		for (Map.Entry<String, Map<String, Integer>> wc : wcs.entrySet())
			for (Map.Entry<String, Integer> e : wc.getValue().entrySet())
				omap.put(e.getKey(), (omap.containsKey(e.getKey()) ? omap.get(e.getKey()) : 0) + e.getValue());
		return omap;
	}

	// weighted add
	public static Map<String, Integer> cAdd(Map<String, Map<String, Integer>> wcs, Map<String, Double> wts)
	{
		Map<String, Integer> omap = new HashMap<String, Integer>();
		for (Map.Entry<String, Map<String, Integer>> wc : wcs.entrySet())
			for (Map.Entry<String, Integer> e : wc.getValue().entrySet())
				if (wts.containsKey(e.getKey()))
				{
					Double wt = wts.get(e.getKey());
					Integer cv = omap.containsKey(e.getKey()) ? omap.get(e.getKey()) : 0;
					Integer nv = cv + (int) Math.round(e.getValue() * wts.get(e.getKey()));
					omap.put(e.getKey(), nv);
				}
		return omap;
	}

	// sum normalizes before adding
	public static Map<String, Integer> cSum(Map<String, Map<String, Integer>> wcs)
	{
		Map<String, Integer> omap = new HashMap<String, Integer>();
		for (Map.Entry<String, Map<String, Integer>> wc : wcs.entrySet())
		{
			Map<String, Integer> m = wc.getValue();
			Map<String, Integer> n = cNormalize(m);
			for (Map.Entry<String, Integer> e : n.entrySet())
			{
				omap.put(e.getKey(), (omap.containsKey(e.getKey()) ? omap.get(e.getKey()) : 0) + e.getValue());
			}
		}
		return cNormalize(omap);
	}

	// Combine a bunch of vectors (wcs), based on their distance to a reference wc
	public static Map<String, Integer> cCombine(Map<String, Map<String, Integer>> wcs, Map<String, Integer> rv)
	{
		Map<String, Double> omap = new HashMap<String, Double>();
		for (Map.Entry<String, Map<String, Integer>> wc : wcs.entrySet())
		{
			Map<String, Integer> swc = ngWc(wc.getValue()); // ngram-ct to word-ct
			Double w = Math.PI / 2.0 - cDist(swc, rv); // the weight
			System.out.printf("%s :: wt: %.3f Wc sizes(cat,ref) :: (%d,%d)\n", wc.getKey(), w * 100.0, swc.size(), rv.size());
			Map<String, Integer> nwc = cNormalize(wc.getValue());
			for (Map.Entry<String, Integer> e : nwc.entrySet())
				if (omap.containsKey(e.getKey()))
					omap.put(e.getKey(), omap.get(e.getKey()) + e.getValue() * w);
				else
					omap.put(e.getKey(), e.getValue() * w);
		}
		// convert to int, normalize, return
		Map<String, Integer> rmap = new HashMap<String, Integer>();
		for (Map.Entry<String, Double> e : omap.entrySet())
			rmap.put(e.getKey(), (int) Math.round(e.getValue()));

		return cNormalize(rmap);
	}

	// Combine a bunch of vectors (wcs), based on their distance to a reference url
	public static Map<String, Integer> cCombine(Map<String, Map<String, Integer>> wcs, String rurl)
	{
		String urltext = "";
		try
		{
			urltext = TextUtils.HTMLText(rurl);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Problem", e);
		}
		return cCombine(wcs, cWc(urltext));
	}

	// - Utilities -------------------------------------------
	// Ngrams
	// Return individual word-count from ngram word-count
	public static Map<String, Integer> ngWc(Map<String, Integer> ngwcs)
	{
		Map<String, Integer> omap = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> e : ngwcs.entrySet())
			for (String w : e.getKey().split("\\+"))
			{
				int cur = omap.containsKey(w) ? omap.get(w) : 0;
				omap.put(w, cur + e.getValue());
			}
		return omap;
	}

	// returns map sorted by word-count in descending order
	public static TreeSet sortMap(Map<String, Integer> wc)
	{
		TreeSet<Map.Entry<String, Integer>> tm = new TreeSet<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>()
		{
			@Override
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
			{
				return b.getValue().compareTo(a.getValue());
			}
		});

		tm.addAll(wc.entrySet());
		return tm;
	}

	// top n words of word-count (based on count)
	public static String[] topWords(Map<String, Integer> wc, Integer n)
	{
		Map<String, Integer> rv = jUtils.take(sortMap(wc), n);
		return rv.keySet().toArray(new String[] {});
	}

	// ------------------------------------------------------------------------
	// - private helpers -----------------------------------------------
	private static Integer sSquares(Map<String, Integer> wc)
	{
		Integer res = 0;
		for (Map.Entry<String, Integer> e : wc.entrySet())
			if (e != null && e.getValue() != null)
				res += e.getValue() * e.getValue();
			else
				System.out.print(".");
		return res;
	}

	// - pretty printers ------------
	private static void pWc(String label, Map<String, Integer> wc, int n)
	{
		TreeSet<Map.Entry<String, Integer>> rv = sortMap(wc);
		System.out.print(label + " :: \t");
		int count = 0;
		for (Map.Entry<String, Integer> e : rv)
		{
			if (count > n)
				break;
			System.out.printf("%s:%d, ", e.getKey(), e.getValue());
			count++;
		}
		System.out.println();
	}

	// - wc creator helpers ------------
	private static Map<String, Integer> cWc(String[] words)
	{
		Map<String, Integer> rv = new HashMap<String, Integer>();
		for (String w : words)
			rv.put(w, (rv.get(w) == null ? 0 : rv.get(w)) + 1);
		return rv;
	}

	private static Map<String, Integer> cWc(String words)
	{
		return cWc(words.split("\\s+"));
	}

	// ---------------------------------------------------------------------
	// - tests ---------------------------------------------------------------
	private static void test()
	{
		Map<String, Integer> rv = cWc("a b c d");
		Map<String, Map<String, Integer>> cs = new HashMap<String, Map<String, Integer>>();
		cs.put("a0.5", cWc("a+x+y b+z+g c+g+h+u"));
		cs.put("b0.0", cWc("a+f b+g c+g+o d+o+h"));
		cs.put("c1.0", cWc("c+o d+h e+y"));
		cs.put("d1.5", cWc("e+i f+h g+j"));

		Map<String, Integer> cc = cCombine(cs, rv);
		System.out.println(cc);
	}

	private static void Test(String ngramFile, String ancestor, String ref)
	{
		// read in categories from file and pick out those with given ancestor
		Map<String, Map<String, Integer>> wcs = catUtils.family(ioUtils.readWcs(ngramFile), ancestor);

		// create a reference word-count
		Map<String, Integer> rv = cWc(ref);

		// combine them (and remember how long it took)
		long start = System.currentTimeMillis();
		Map<String, Integer> cc = cCombine(wcs, rv);
		long end = System.currentTimeMillis();

		// print the top 50 words (by count) and the time it took to combine
		System.out.println(ioUtils.mkString(topWords(cc, 50), ", "));
		System.out.println("Combining " + wcs.size() + " cats took " + (end - start) + "ms");
	}

	// ------------
	public static String[] generateNgrams(String basePath, String extension, ArrayList<String> categories, String data, int numKw)
	{
		// read in categories from file and pick out those with categories selected
		Map<String, Map<String, Integer>> wcs = new HashMap<String, Map<String, Integer>>();
		for (String cat : categories)
		{
			// Building the nGramsFileName
			String[] subCat = cat.split("/");
			String file = basePath + subCat[1] + extension;
			Map<String, Map<String, Integer>> wcsAux = catUtils.family(ioUtils.readWcs(file), cat);
			wcs.putAll(wcsAux);
		}

		// create a reference word-count
		System.out.println(data.length());
		Map<String, Integer> rv = cWc(data);

		// combine them (remember how long it took)
		Long start = System.currentTimeMillis();
		Map<String, Integer> cc = cCombine(wcs, rv);
		System.out.println("Combine Categories seconds " + (System.currentTimeMillis() - start));
		String[] kw = topWords(cc, numKw);

		return kw;

	}

	// -------------------------------------------------------------
	public static void main(String[] args)
	{
		String file = "/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/shopping.2";
		String head = "top/shopping/flowers/florists/north_america";
		String rngrams = "wedding+flowers flower+shops birthday+flowers" + "wedding+bouquets flower+delivery fruit+baskets " + "valentines+day flower+arrangements flowers+plants red+roses" + "fresh+flowers single+rose flower+delivery";
		String rwords = "wedding flowers birthday " + "bouquets flower delivery fruit baskets " + "valentines day arrangements plants red roses" + "fresh single ";
		Test(file, head, rwords);
	}
}
