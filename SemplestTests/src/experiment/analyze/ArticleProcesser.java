package experiment.analyze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import scala.actors.threadpool.Arrays;

public class ArticleProcesser
{

	// private final String seperators = "\\p{Punct}";
	private final String seperators = " |\\.|\\,";
	private final Integer maxWordsOfPhrase = 5;
	private final Double weightOfFrequency = 0.5;
	private final Double weightOfFlexibility = 0.5;
	private final String defaultWordStoplist = "c:\\temp\\wordstoplist.txt";
	private final String defaultPhraseStoplist = "c:\\temp\\phrasestoplist.txt";

	public static void main(String[] args)
	{
		ArticleProcesser ap = new ArticleProcesser();

		String outputFile = "c:\\temp\\rank.txt";

		String dmozFile = "C:\\temp\\samples\\business\\dmoz.8-12.1.1";
		String category = "top/business/consumer_goods_and_services/home_and_garden/furniture/by_room_or_item/home_entertainment";

		String compareFile1 = "c:\\temp\\samples\\dmoz_health";
		String compareFile2 = "c:\\temp\\samples\\dmoz_science";

		TreeMap<String, Double> rankOfPhrases;
		try
		{
			rankOfPhrases = ap.ProcessDmozData(dmozFile, category);
			ap.OutputReport(outputFile, rankOfPhrases);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void OutputReport(String outputPath, TreeMap<String, Double> rankOfPhrases)
	{
		try
		{
			FileWriter fstream = new FileWriter(outputPath);
			BufferedWriter out = new BufferedWriter(fstream);

			out.write("Date - " + new Date());
			out.append("\n\n");

			for (String s : rankOfPhrases.descendingKeySet())
			{
				out.append(s + " : " + rankOfPhrases.get(s) + "\n");
			}

			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public TreeMap<String, Double> ProcessContent(String content, String stoplistFile) throws Exception
	{
		if (stoplistFile == null)
		{
			stoplistFile = defaultWordStoplist;
		}
		String[] listOfWords = ReadInContent(content);
		String[] listOfStoplistWords = GetStopListWords(stoplistFile);
		String[] listOfFilteredWords = GetFilteredWordList(listOfWords, listOfStoplistWords);
		HashMap<String, Set<Integer>> generatedPhrases = GeneratePhrases(listOfFilteredWords);
		HashMap<String, Double> freqOfPhrases = FrequencyOfPhrases(generatedPhrases, listOfWords.length);
		HashMap<String, Double> flexOfPhrases = FlexibilityOfPhrases(listOfWords, generatedPhrases);
		TreeMap<String, Double> rankedMap = RankPhrases(generatedPhrases, freqOfPhrases, flexOfPhrases);

		return rankedMap;
	}

	public TreeMap<String, Double> ProcessDmozData(String dmozPath, String category) throws Exception
	{
		System.out.println("start");
		Long startTime = System.currentTimeMillis();
		String[] listOfWords = ReadDmozByCategory(dmozPath, category);
		System.out.println("ReadDmozByCategory takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		String[] listOfStoplistWords = GetStopListWords(defaultWordStoplist);
		System.out.println("GetStopListWords takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		String[] listOfFilteredWords = GetFilteredWordList(listOfWords, listOfStoplistWords);
		System.out.println("GetFilteredWordList takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		HashMap<String, Set<Integer>> generatedPhrases = GeneratePhrases(listOfFilteredWords);
		System.out.println("GeneratePhrases takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		HashMap<String, Double> freqOfPhrases = FrequencyOfPhrases(generatedPhrases, listOfWords.length);
		System.out.println("FrequencyOfPhrases takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		HashMap<String, Double> flexOfPhrases = FlexibilityOfPhrases(listOfWords, generatedPhrases);
		System.out.println("FlexibilityOfPhrases takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();
		TreeMap<String, Double> rankedMap = RankPhrases(generatedPhrases, freqOfPhrases, flexOfPhrases);
		System.out.println("RankPhrases takes " + (System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();

		return rankedMap;
	}

	public TreeMap<String, Double> ProcessArticles(String targetFile, String baseFile) throws Exception
	{
		String[] listOfWords = ReadInFile(targetFile);
		String[] listOfGeneralWords = GetGeneralWords(baseFile);
		String[] listOfFilteredWords = GetFilteredWordList(listOfWords, listOfGeneralWords);
		HashMap<String, Set<Integer>> generatedPhrases = GeneratePhrases(listOfFilteredWords);
		HashMap<String, Double> freqOfPhrases = FrequencyOfPhrases(generatedPhrases, listOfWords.length);
		HashMap<String, Double> flexOfPhrases = FlexibilityOfPhrases(listOfWords, generatedPhrases);
		TreeMap<String, Double> rankedMap = RankPhrases(generatedPhrases, freqOfPhrases, flexOfPhrases);

		return rankedMap;
	}

	public TreeMap<String, Double> RankPhrases(HashMap<String, Set<Integer>> generatedPhrases, HashMap<String, Double> frequencyOfPhrases, HashMap<String, Double> flexibilityOfPhrases) throws Exception
	{
		HashMap<String, Double> scoreMap = new HashMap<String, Double>();
		for (String phrase : generatedPhrases.keySet())
		{
			Double prob = frequencyOfPhrases.get(phrase);
			Double flex = flexibilityOfPhrases.get(phrase);
			if (!(prob == null) && !(flex == null))
			{
				Double score = (prob * weightOfFrequency + flex * weightOfFlexibility) * 10000;
				scoreMap.put(phrase, score);
			}
		}
		TreeMap<String, Double> rankedMap = SortMap(scoreMap);

		return rankedMap;
	}

	public HashMap<String, Double> FlexibilityOfPhrases(String[] listOfWords, HashMap<String, Set<Integer>> generatedPhrases) throws Exception
	{
		HashMap<String, FlexibilityOfWord> flexOfPhrases = new HashMap<String, FlexibilityOfWord>();

		for (String phrase : generatedPhrases.keySet())
		{
			int numWords = phrase.split(" ").length;
			Set<Integer> startPoints = generatedPhrases.get(phrase);
			for (Integer startPoint : startPoints)
			{
				FlexibilityOfWord flex;
				if (flexOfPhrases.containsKey(phrase))
				{
					flex = flexOfPhrases.get(phrase);
				}
				else
				{
					flex = new FlexibilityOfWord();
				}
				int ptrToTheLeftWord = startPoint - 1;
				int ptrToTheRightWord = startPoint + numWords + 1;
				if (ptrToTheLeftWord >= 0)
				{
					String leftWord = listOfWords[ptrToTheLeftWord];
					flex.addLeft(leftWord);
				}
				if (ptrToTheRightWord < listOfWords.length)
				{
					String rightWord = listOfWords[ptrToTheRightWord];
					flex.addRight(rightWord);
				}
				flexOfPhrases.put(phrase, flex);
			}
		}

		// process the map
		HashMap<String, Double> finalFlexMap = new HashMap<String, Double>();
		for (String longTailWord : flexOfPhrases.keySet())
		{
			Double flexVal = flexOfPhrases.get(longTailWord).getFlexibility() / listOfWords.length;
			finalFlexMap.put(longTailWord, flexVal);
		}
		return finalFlexMap;
	}

	public HashMap<String, Double> FrequencyOfPhrases(HashMap<String, Set<Integer>> generatedPhrases, Integer numOfAllWords) throws Exception
	{
		HashMap<String, Double> freqOfPhrases = new HashMap<String, Double>();
		for (String phrase : generatedPhrases.keySet())
		{
			String[] words = phrase.trim().split(" ");
			Double freqEntirePhrase = generatedPhrases.get(phrase).size() * 1d;
			freqOfPhrases.put(phrase, (freqEntirePhrase * words.length / numOfAllWords));
		}
		return freqOfPhrases;
	}

	public HashMap<String, Set<Integer>> GeneratePhrases(String[] listOfWords) throws Exception
	{
		HashMap<String, Set<Integer>> phrasesMap = new HashMap<String, Set<Integer>>();
		String[] phraseStopList = GetStopListWords(defaultPhraseStoplist);
		for (int i = 0; i < listOfWords.length; i++)
		{
			if (!listOfWords[i].isEmpty())
			{
				// use it as a start point to form a phrase
				String phrase = "";
				int count = 0;
				for (int ptr = 0; ptr < maxWordsOfPhrase; ptr++)
				{
					int current = i + ptr;
					if (current > listOfWords.length - 1)
					{
						// out of the array
						break;
					}
					if (!listOfWords[current].isEmpty())
					{
						phrase = phrase + " " + listOfWords[current];
					}
					else
					{
						break;
					}
					count++;
				}
				if (count > 1)
				{
					String newPhrase = phrase.trim();
					if (!isPhraseFiltered(newPhrase, phraseStopList))
					{
						Set<Integer> points = phrasesMap.get(newPhrase);
						if (points == null)
						{
							points = new HashSet<Integer>();
						}
						points.add(i);
						phrasesMap.put(newPhrase, points);
					}
				}
			}
		}
		return phrasesMap;
	}

	public boolean isPhraseFiltered(String phrase, String[] stoplistPhrases) throws Exception
	{
		for (String stopPhrase : stoplistPhrases)
		{
			if (stopPhrase.trim().equalsIgnoreCase(phrase.trim()))
			{
				return true;
			}
		}
		return false;
	}

	public String[] GetFilteredWordList(String[] listOfWords, String[] generalWords) throws Exception
	{
		List<String> newListOfWords = Arrays.asList(listOfWords);
		for (int i = 0; i < newListOfWords.size(); i++)
		{
			for (String generalWord : generalWords)
			{
				if (newListOfWords.get(i).equalsIgnoreCase(generalWord))
				{
					newListOfWords.set(i, "");
					break;
				}
			}
		}

		return newListOfWords.toArray(new String[newListOfWords.size()]);
	}

	public String[] GetStopListWords(String path) throws Exception
	{
		Set<String> stopListWords = new HashSet<String>();

		FileInputStream fstream = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ((strLine = br.readLine()) != null)
		{
			stopListWords.add(strLine.trim());
		}
		in.close();

		return stopListWords.toArray(new String[stopListWords.size()]);
	}

	public HashMap<String, Double> FrequencyOfWords(String[] listOfWords) throws Exception
	{
		HashMap<String, Double> freqOfWords = new HashMap<String, Double>();

		HashMap<String, Integer> countOfWords = CountsOfWords(listOfWords);

		Integer totalCounts = 0;
		for (String word : countOfWords.keySet())
		{
			totalCounts = totalCounts + countOfWords.get(word);
		}

		for (String word : countOfWords.keySet())
		{
			Double frequency = (countOfWords.get(word) * 1.0) / totalCounts;
			freqOfWords.put(word, frequency);
		}
		;

		return freqOfWords;
	}

	public HashMap<String, Integer> CountsOfWords(String[] listOfWords) throws Exception
	{
		HashMap<String, Integer> countsOfWords = new HashMap<String, Integer>();
		for (String word : listOfWords)
		{
			if (!word.isEmpty())
			{
				Integer count = 1;
				if (countsOfWords.containsKey(word))
				{
					count = countsOfWords.get(word) + 1;
				}
				countsOfWords.put(word, count);
			}
		}
		return countsOfWords;
	}

	public String[] GetGeneralWords(String path) throws Exception
	{
		String[] listOfWords = ReadInFile(path);
		HashMap<String, Double> probOfWords = FrequencyOfWords(listOfWords);
		TreeMap<String, Double> sortedMap = SortMap(probOfWords);
		return sortedMap.descendingKeySet().toArray(new String[sortedMap.size()]);
	}

	public TreeMap<String, Double> SortMap(HashMap<String, Double> map) throws Exception
	{
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
		sorted_map.putAll(map);
		return sorted_map;
	}

	public String[] ReadInContent(String content) throws Exception
	{
		ArrayList<String> singleWords = new ArrayList<String>();

		String[] words = content.split(seperators);
		for (String s : words)
		{
			singleWords.add(s.trim().toLowerCase());
		}

		return singleWords.toArray(new String[singleWords.size()]);
	}

	public String[] ReadInFile(String path) throws Exception
	{
		ArrayList<String> singleWords = new ArrayList<String>();

		FileInputStream fstream = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ((strLine = br.readLine()) != null)
		{
			String[] words = strLine.split(seperators);
			for (String s : words)
			{
				singleWords.add(s.toLowerCase());
			}
		}
		in.close();

		return singleWords.toArray(new String[singleWords.size()]);
	}

	public String[] ReadDmozByCategory(String path, String category) throws Exception
	{
		ArrayList<String> singleWords = new ArrayList<String>();

		FileInputStream fstream = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		int endIndex = 300;
		while ((strLine = br.readLine()) != null)
		{
			endIndex = strLine.length() > endIndex ? endIndex : strLine.length();
			String ctgr = strLine.substring(0, endIndex).split(" ")[0];
			if (ctgr.equals(category.trim()))
			{
				String[] words = strLine.split(seperators);
				for (String s : words)
				{
					if (s.matches("[a-zA-Z]+$"))
					{
						singleWords.add(s.toLowerCase());
					}
					else
					{
						singleWords.add("");
					}
				}
			}
		}
		in.close();

		return singleWords.toArray(new String[singleWords.size()]);
	}

	private class ValueComparator implements Comparator<String>
	{

		Map<String, Double> base;

		public ValueComparator(Map<String, Double> base)
		{
			this.base = base;
		}

		public int compare(String a, String b)
		{
			return base.get(a).compareTo(base.get(b));
		}
	}

	private class FlexibilityOfWord
	{
		private Set<String> Left;
		private Set<String> Right;

		public FlexibilityOfWord()
		{
			Left = new HashSet<String>();
			Right = new HashSet<String>();
		}

		public Set<String> getLeft()
		{
			return Left;
		}

		public void addLeft(String word)
		{
			Left.add(word);
		}

		public Set<String> getRight()
		{
			return Right;
		}

		public void addRight(String word)
		{
			Right.add(word);
		}

		public Integer getLeftCount()
		{
			return Left.size();
		}

		public Integer getRightCount()
		{
			return Right.size();
		}

		public Double getFlexibility()
		{
			return (Left.size() + Right.size()) * 1d;
		}
	}

}
