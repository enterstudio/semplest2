package semplest.keywords.multiwords;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeMap;

import semplest.keywords.javautils.ioUtils;
import semplest.keywords.javautils.dictUtils;

public class MultiWord
{

	private HashMap<String, Integer> indexMap;
	private int[] n; // max gram (for unigram n=[1], for bigram n=[2], for both n=[1,2])
	private ArrayList<String> finalList;

	public MultiWord(int[] n)
	{
		this.n = n;
		indexMap = new HashMap<String, Integer>();
		finalList = new ArrayList<String>();

	}

	private String shiftWords(String[] buffer, String s)
	{
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < buffer.length - 1; i++)
		{
			buffer[i] = buffer[i + 1];
			buff.append(buffer[i] + " ");
		}
		buffer[buffer.length - 1] = s;
		buff.append(s);
		return buff.toString();
	}

	public void BuildNutch(String inFile)
	{ // for the time being nutch format
		ArrayList<String> lines = ioUtils.readFile(inFile);

		String splitPattern = "[^a-z^0-9]";
		String[] words;
		String key;

		boolean nextLineValid = false;
		for (String line : lines)
		{

			if (nextLineValid)
			{
				// parse the text
				line = line.toLowerCase();
				line = line.replaceAll("[^a-z^0-9^\\s]", " ");
				words = line.split(splitPattern);

				for (int i = 0; i < n.length; i++)
				{
					String[] buffer = new String[n[i]];
					int j = 0;
					for (String s : words)
					{
						if (j < n[i])
						{
							if (dictUtils.validWord(s))
							{
								buffer[j] = s;
								j++;
								continue;
							}
						}
						if (dictUtils.validWord(s))
						{
							key = shiftWords(buffer, s);
							// key=s;
							if (indexMap.containsKey(key))
							{
								indexMap.put(key, indexMap.get(key) + 1);
							}
							else
							{
								indexMap.put(key, new Integer(1));
							}
						}
					}
				}

				nextLineValid = false;
				continue;
			}
			if (line.matches("ParseText::"))
			{
				nextLineValid = true;
			}
			else
			{
				nextLineValid = false;
			}
		}

		// Iterator it = indexMap.entrySet().iterator();
		// while (it.hasNext()){
		// System.out.println(it.next());
		// }

		for (String finalS : indexMap.keySet())
		{
			if (indexMap.get(finalS) > 200)
			{
				System.out.println(finalS);
				finalList.add(finalS);
			}
		}

		if (indexMap.containsKey("insured"))
		{
			System.out.println("Yahoo");
		}
		System.out.println("Keyword building completed. Total " + indexMap.size() + " words found.");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		String inFile = "/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/autoInsuranceDumpSegmentsParse/dump";
		int[] n = { 2, 3 };
		MultiWord multWord = new MultiWord(n); // unigram
		multWord.BuildNutch(inFile);

	}

}
