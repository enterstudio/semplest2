package semplest.keywords.javautils;

import java.util.*;

public class ValueComparator implements Comparator
{
	// Used to sort values in a Hash Map ( see main for an example)
	Map base;

	public ValueComparator(Map base)
	{
		this.base = base;
	}

	public int compare(Object a, Object b)
	{

		if ((Double) base.get(a) < (Double) base.get(b))
		{
			return 1;
		}
		else if ((Double) base.get(a) == (Double) base.get(b))
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

	public static void main(String[] args)
	{

		Map<String, Double> map = new HashMap<String, Double>();
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Double> sorted_map = new TreeMap(bvc);

		map.put("A", 99.5);
		map.put("B", 67.4);
		map.put("C", 67.5);
		map.put("D", 67.3);

		System.out.println("unsorted map");
		for (String key : map.keySet())
		{
			System.out.println("key/value: " + key + "/" + map.get(key));
		}

		sorted_map.putAll(map);

		System.out.println("results");
		for (String key : sorted_map.keySet())
		{
			System.out.println("key/value: " + key + "/" + sorted_map.get(key));
		}
	}

}
