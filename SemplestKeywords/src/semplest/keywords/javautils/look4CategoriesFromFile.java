package semplest.keywords.javautils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.htmlparser.util.ParserException;

import cc.mallet.types.InstanceList;

import semplest.keywords.lda.KWGenLDAStatus;
import semplest.keywords.lda.MalletTopic;

public class look4CategoriesFromFile
{

	/**
	 * This class will take the top categories and present a report for results args[0] = input keywords file; args[1] = report file; (optional)
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		// Categories are retrieved and scored. Everytime a category is found it is added to a HashMap with its score.
		// The score will be 100-position in search. Every time a category is repeated, its score will be added for each of
		// the positions where it is found. Finally, categories are ranked.
		HashMap<String, Double> categMap = new HashMap<String, Double>();
		ValueComparator bvcAux = new ValueComparator(categMap);
		TreeMap<String, Double> sorted_opt = new TreeMap<String, Double>(bvcAux);
		;
		int results = 100; // number of results to obtain from dmoz search
		int maxiter = 10; // maximum number of iterations
		int maxtopresults = 10; // Maximum number of results to report
		int topresults;
		// File containing sorted words for each category
		String wordsFile = "/semplest/data/dmoz/all/hCounts.txt.tw";
		String trainCategFile = "/semplest/data/dmoz/all/hCounts.txt.f";
		DataInputStream in;
		BufferedReader br;
		String strLine;
		String dmozSearch = "/semplest/data/dmozTest/dmozsearchresults.txt";
		PrintStream testlog = new PrintStream(new FileOutputStream("/semplest/lluis/testlog.txt"));
		testlog = System.out;
		PrintStream stdoutG = System.out;

		// Read keywords to test
		DataInputStream inResults = new DataInputStream(new FileInputStream(dmozSearch));
		BufferedReader brResults = new BufferedReader(new InputStreamReader(inResults));
		// Read File Line By Line
		String pattern, categories;
		Double value;

		pattern = brResults.readLine();
		while (pattern != null)
		{
			ArrayList<String> optInitial = new ArrayList<String>();
			categMap = new HashMap<String, Double>();
			bvcAux = new ValueComparator(categMap);
			sorted_opt = new TreeMap<String, Double>(bvcAux);
			System.setOut(stdoutG);
			// System.out.println(pattern);
			System.setOut(testlog);
			System.out.println(pattern);
			pattern = brResults.readLine();
			int numresults = 0;
			while (pattern != null && !pattern.contains("Keywords evaluated"))
			{
				categories = pattern;
				categories = categories.replaceAll("\\s", "");
				if (catUtils.validcat(categories))
				{
					if (categMap.containsKey(categories))
					{
						value = (Double) categMap.get(categories);
						value = value + results - numresults; // Set new score for category
					}
					else
					{
						value = new Double(results - numresults);
						// System.out.println(value+"\t"+categories);

					}
					categMap.put(categories, value);
					numresults++;
					optInitial.add(categories);

				}
				pattern = brResults.readLine();
			}

			sorted_opt.putAll(categMap);
			Set<String> keys = sorted_opt.keySet();
			// ------------------------------------------------------------------------------------------------
			System.out.println("\nWords for top Categories");
			// Show words for top categories
			// Read File Line By Line
			topresults = 0;
			for (String key : keys)
			{
				in = new DataInputStream(new FileInputStream(wordsFile));
				br = new BufferedReader(new InputStreamReader(in));
				while ((strLine = br.readLine()) != null)
				{
					String[] splitline = strLine.split(":");
					splitline[0] = splitline[0].replaceAll("_", "");
					if (key.equals(splitline[0]))
					{
						System.out.println(strLine);
						topresults++;
						break;
					}
				}
				if (topresults >= maxtopresults)
					break;
			}
			// --------------------------------------------------------------------------------------------------------
			// Train LDA for top 5 categories and return sorted keywords

			// Create ArrayList with data for training from top categories
			System.out.println("\nTraining data for LDA:");
			ArrayList<String> trainLines = new ArrayList<String>();
			topresults = 0;

			for (String key : keys)
			{
				in = new DataInputStream(new FileInputStream(trainCategFile));
				br = new BufferedReader(new InputStreamReader(in));
				while ((strLine = br.readLine()) != null)
				{
					String[] splitline = strLine.split(":");
					splitline[0] = splitline[0].replaceAll("_", "");
					if (key.equals(splitline[0]))
					{
						// System.out.println(strLine);
						trainLines.add(strLine);
						topresults++;
						break;
					}
				}
				if (topresults >= maxtopresults)
					break;
				in.close();
				br.close();
			}

			// Instanciate topic model
			MalletTopic lda = new MalletTopic();
			double alpha = 0.01;
			double beta = 0.01;
			int numiter = 100;
			// Create instances from training data
			PrintStream stdout = System.out;
			PrintStream stderr = System.err;
			System.setOut(new PrintStream(new FileOutputStream("/semplest/lluis/trainingLog.txt")));
			System.setErr(new PrintStream(new FileOutputStream("/semplest/lluis/trainingLog.txt")));
			lda.CreateInstancesSEMplest(trainLines);
			lda.setNumTopics(3);
			lda.LDAcreateModel(alpha, beta, numiter);
			System.out.close();
			System.err.close();
			System.setOut(stdout);
			System.setErr(stderr);
			// Ask for user data to sort words
			System.setOut(stdoutG);
			System.out.println("Please, introduce path to file containing user info (type \"exit\" to close) :");
			Scanner scanFile = new Scanner(System.in);
			System.setOut(testlog);
			String userInfo1 = scanFile.nextLine();
			ArrayList<String> words1;

			if (userInfo1.contains(".clean"))
				words1 = TextUtils.validTextWords(userInfo1);
			else
				words1 = TextUtils.validHtmlWords(userInfo1);

			String data1 = "";
			for (String s : words1)
			{
				data1 = data1 + " " + s;
				// System.out.print(s+"  ");
			}
			// Create Instance form url data
			InstanceList inferInst;
			double[][] categInd;
			TreeMap<String, Double> wordM;
			inferInst = lda.CreateInferInstfromData("0", userInfo1, data1);
			// Find the closest trained instances
			// categInd=lda.InstanceClassifierMat(inferInst, 0);
			// Get a TreeMap with the words and the probabilities of each word to belong to the URL

			wordM = lda.inferWordprob(inferInst, 0);

			Set<String> keyS = wordM.keySet();
			System.out.println("wordMap Size: " + wordM.size());
			int i = 0;
			for (String keys2 : keyS)
			{
				if (i >= 50)
					break;
				System.out.print(" " + keys2 + ",");
				i++;
			}

			// --------------------------------------------------------------------------------------------------------
			// Select repeated patterns
			ArrayList<String> optList = selectOptions(optInitial, 20);
			System.out.println("\nSorted general options:");
			for (String opt : optList)
			{
				System.out.println(opt);
			}
			System.setOut(stdoutG);
			System.out.println("Press a key to continue");
			System.in.read();
			System.setOut(testlog);
			System.out.println("*******************************************************************************************************\n");

		}
		testlog.close();
		inResults.close();
		brResults.close();

	}

	private static ArrayList<String> selectOptions(ArrayList<String> optKeys, int numNEval) throws IOException
	{
		// Selects patterns from top categories list to generate options for the user based on pre-defined crieteria
		// Criteria to select subcategories:
		// 1- # of nodes between 2 and 4, more than 1 repetition
		// 2- More than 4 nodes, at least 1 repetition

		HashMap<String, Double> optList = new HashMap<String, Double>();
		ValueComparator bvcAux = new ValueComparator(optList);
		TreeMap<String, Double> sorted_opt = new TreeMap<String, Double>(bvcAux);

		int numNodes;
		// Identify repeated patterns in top categories
		String aux, newoption;
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

		HashMap<String, Double> optList2 = new HashMap<String, Double>();
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

		Set<String> sorted_optKeys2 = sorted_opt2.keySet();
		ArrayList<String> arrayOpt = new ArrayList<String>();
		for (String key : sorted_optKeys2)
		{
			arrayOpt.add(key);
		}
		return arrayOpt;

	}

}
