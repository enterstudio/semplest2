package semplest.keywords.javautils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class WordTagUtils
{
	// Initialize the tagger
	MaxentTagger tagger;

	public WordTagUtils() throws IOException, ClassNotFoundException
	{
		tagger = new MaxentTagger("data/taggers/bidirectional-distsim-wsj-0-18.tagger");
	}

	public String tagWords(String sentence)
	{
		// The tagged string
		return tagger.tagString(sentence);
	}

	public Map<String, List<String>> tagWordsMap(String sentence)
	{
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		String[] ret = tagger.tagString(sentence).split("\\s+");
		for (String wordTag : ret)
		{
			int index = wordTag.lastIndexOf("/");
			if (index >= 0)
			{
				String word = wordTag.substring(0, index);
				String type = wordTag.substring(index + 1, wordTag.length());
				System.out.println(word + ", " + type);
				if (map.containsKey(word))
				{
					map.get(word).add(type);
				}
				else
				{
					List<String> list = new ArrayList<String>();
					list.add(type);
					map.put(word, list);
				}
			}

		}
		return map;
	}

	public static void main(String[] args) throws Exception
	{
		WordTagUtils wordTag = new WordTagUtils();
		String tagged = wordTag.tagWords("run is a group of people that run very fast");
		Map<String, List<String>> map = wordTag.tagWordsMap("run is a group of people that run very fast");
		for (String word : map.keySet())
		{
			List<String> list = map.get(word);
			System.out.print("\n" + word + ": ");
			for (String type : list)
			{
				System.out.print(type + ", ");
			}
		}
		// Output the result
		System.out.println("\n" + tagged);
	}

}
