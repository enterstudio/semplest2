package semplest.keywords.javautils;

import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/*
 * Java Language and data-structure Utilities 
 */
public class jUtils
{
	private static final Logger logger = Logger.getLogger(jUtils.class);

	// - Collection utils --------------------------
	// first n entries
	public static <K, V> Map<K, V> take(Map<K, V> m, Integer n)
	{
		Map<K, V> res = new HashMap<K, V>();
		int counter = 0;
		for (Map.Entry<K, V> e : m.entrySet())
		{
			if (counter >= n)
			{
				break;
			}
			res.put(e.getKey(), e.getValue());
			counter++;
		}
		return res;
	}

	public static <K, V> Map<K, V> take(Set<Map.Entry> s, Integer n)
	{
		Map<K, V> res = new HashMap<K, V>();
		int counter = 0;
		for (Map.Entry<K, V> e : s)
		{
			if (counter < n)
			{
				res.put(e.getKey(), e.getValue());
			}
			counter++;
		}
		return res;
	}

	// - printers ----------------------------------
	public static <K, V> void printMap(Map<K, V> m, Integer n)
	{
		int counter = 0;
		for (Map.Entry<K, V> e : m.entrySet())
		{
			if (counter < n)
			{
				System.out.println(e.getKey() + " : " + e.getValue());
			}
			counter++;
		}
	}

	public static <K, V> void printMap(Map<K, V> m)
	{
		printMap(m, 50);
	}

	// - Sorters ----------------------------------------

	public static <K> TreeSet sortMap(Map<K, Integer> wc)
	{
		TreeSet<Map.Entry<K, Integer>> tm = new TreeSet<Map.Entry<K, Integer>>(new Comparator<Map.Entry<K, Integer>>()
		{
			@Override
			public int compare(Map.Entry<K, Integer> a, Map.Entry<K, Integer> b)
			{
				return b.getValue().compareTo(a.getValue());
			}
		});

		tm.addAll(wc.entrySet());
		return tm;
	}

	// Map sorted by value
	public static <K, V extends Comparable<V>> Map<K, V> smap(final Map<K, V> m)
	{
		Map<K, V> svmap = new TreeMap<K, V>(new Comparator<K>()
		{
			public int compare(K k1, K k2)
			{
				int compare = m.get(k2).compareTo(m.get(k1));
				if (compare == 0)
				{
					return 1;
				}
				else
				{
					return compare;
				}
			}
		});
		svmap.putAll(m);
		return svmap;
	}

	// - Date ----------------
	public Calendar gCal(String date)
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		try
		{
			c.setTime(df.parse(date));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Problem", e);
		}
		return c;
	}

	// --------------------------------------------------------------------------
	public static void main(String[] args)
	{
	}

}
