package semplest.keywords.ldatest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;

import semplest.keywords.javautils.*;
import semplest.keywords.lda.MalletTopic;

import cc.mallet.types.FeatureVectorSequence.Iterator;
import cc.mallet.types.InstanceList;
import cc.mallet.types.Alphabet;
import cc.mallet.types.Instance;

public class GenerateKeywordsFeedback
{

	/**
	 * Second version of the generate Keyword program Will infer topic probabilities from URL and will find closest trained instances Then will generate
	 * a list of general categories for the user to select and will restrict the alphabets to keywords from the industry selected by the user
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		// //Files to store model and instances
		File pipeIOModel = new File("trainedmodelDescAll700.modl");
		File pipeIOInstance = new File("trainedInstancesDescAll700.inst");
		// File pipeIOModel= new File("trainedmodelHTMLBusiness700.modl");
		// File pipeIOInstance= new File("trainedInstancesHTMLBusiness700.inst");
		int numCateg = 10; // Number of categories to consider when generating options for user
		String[] key = new String[numCateg + 1];
		// Map to sort options by relevance (relevance will be number of pair of the common nodes)
		Map<String, Double> options = new HashMap<String, Double>();
		ValueComparator bvcAux = new ValueComparator(options);
		TreeMap<String, Double> sorted_opt = new TreeMap<String, Double>(bvcAux);

		InstanceList inferInst;
		int numWords = 50;

		String url = "http://www.highlandhtsfloral.com/"; // URL
		String data = "";
		double[][] categInd;

		// Create a new MalletTopic object to load from file
		MalletTopic lda = new MalletTopic();
		System.out.println("Loading Model...");
		// Load trained model and instances from file
		lda.loadLDAInst(pipeIOInstance);
		lda.loadLDAModel(pipeIOModel);
		System.out.println("Model Loaded");
		System.out.println("Number of topics: " + lda.getNumTopics());

		// Create data from URL
		List<String> words = TextUtils.validHtmlStems(url);
		System.out.println("Stems from URL: " + words.size());
		// for(int j=0;j<50;j++){words.add("tv");words.add("screen");}
		for (String s : words)
		{
			data = data + " " + s;
			// System.out.print(s+"  ");
		}
		System.out.println(data);
		// Create Instance form url data
		inferInst = lda.CreateInferInstfromData("0", url, data);
		// Find the closest trained instances
		categInd = lda.InstanceClassifierMat(inferInst, 0, 100);

		// ---------------------------------------------------------------------------------------------
		// Create feedback for user

		// Select top Categories and pick common nodes on descriptions
		// System.out.println("Number of cateogories "+categInd[0].length);
		String[] topCat = new String[numCateg];
		String aux, newoption;
		String[] pair = new String[2];
		int i = 0;
		for (int j = 0; j < categInd[0].length; j++)
		{
			aux = lda.getInstanceLabel((int) categInd[0][j]);

			if (catUtils.take(aux, 2).equals("Top/Regional"));
			else
			{
				if (i >= numCateg)
				{
					break;
				}
				topCat[i] = aux;
				// System.out.println(aux);
				i++;
			}
		}
		for (int n = 0; n < topCat.length; n++)
		{
			for (int m = 0; m < n; m++)
			{
				pair[0] = topCat[n];
				pair[1] = topCat[m];
				newoption = catUtils.longestAncestor(pair);
				if (options.containsKey(newoption))
				{
					options.put(newoption, ((Double) options.get(newoption)) + 1.0);
				}
				else
				{
					options.put(newoption, new Double(1));
				}
			}
		}
		Set<String> optKeys = options.keySet();
		/*
		 * Uncomment if you want to print System.out.print("\n\nOptions:\n"); for(String optKey:optKeys){ System.out.println(optKey
		 * +" : "+options.get(optKey)); }
		 */
		// Sort Options
		sorted_opt.putAll(options);

		// Criteria to print categories:
		// 1- # of nodes between 2 and 4, more than 1 repetition
		// 2- More than 4 nodes, at least 1 repetition
		System.out.print("\n\nPlease, select the categories that best fit your product:\n");
		optKeys = sorted_opt.keySet();
		int n = 1;
		int numNodes;
		Double numrepeat;
		ArrayList<String> optList = new ArrayList<String>();
		for (String optKey : optKeys)
		{
			numNodes = catUtils.nodes(optKey);
			// System.out.println("Numnodes: "+ numNodes);
			numrepeat = options.get(optKey);
			if (numNodes > 2 && numNodes < 5 && numrepeat > 1)
			{
				optList.add(optKey);
				System.out.println(n + "- " + optKey);
				n++;
			}
			else
			{
				if (numNodes >= 5 && numrepeat >= 1)
				{
					optList.add(optKey);
					System.out.println(n + "- " + optKey);
					n++;
				}
			}

		}

		// Read Input user
		Scanner scan = new Scanner(System.in);
		String mySentence = scan.nextLine();
		String[] index = mySentence.split(",");
		int[] indexInt = new int[index.length];
		int numNod;
		String instLabel, cataux;
		ArrayList<Integer> auxList;
		Hashtable<String, ArrayList<Integer>> optCateg = new Hashtable<String, ArrayList<Integer>>();
		for (int m = 0; m < index.length; m++)
		{
			indexInt[m] = Integer.parseInt(index[m]) - 1;
		}

		// Create a Hashtable that contains the options selected and the indexes of the instances that satisfy those options
		for (int m = 0; m < lda.getInstances().size(); m++)
		{
			instLabel = lda.getInstanceLabel(m);
			for (n = 0; n < index.length; n++)
			{
				cataux = optList.get(indexInt[n]);
				numNod = catUtils.nodes(cataux);
				if (catUtils.take(instLabel, numNod).equals(catUtils.take(cataux, numNod)))
				{
					if (!optCateg.containsKey(cataux))
						optCateg.put(cataux, new ArrayList<Integer>());
					auxList = optCateg.get(cataux);
					auxList.add(new Integer(m));
					optCateg.put(cataux, auxList);
				}
			}
		}
		/*
		 * Uncoment if you want to print for(String optKey: optCateg.keySet()){ java.util.Iterator<Integer> it= optCateg.get(optKey).iterator();
		 * System.out.println("Categories for option :" +optKey); while(it.hasNext()){ System.out.println("\t\t"+lda.getInstanceLabel(it.next())); } }
		 */

		// **************************************************************************************
		// Now that we have generated a selection of cateogries that we want to use to generate our alphabet,
		// we need to generate that alphabet and infer the word probabilities for each of the word in the alphabet
		TreeMap<String, Double> wordMap = new TreeMap<String, Double>();
		Set<String> keySet;
		java.util.Iterator<String> iterator;
		i = 0;

		// Generating alphabet
		Alphabet newAlph = new Alphabet();
		for (String optKey : optCateg.keySet())
		{
			java.util.Iterator<Integer> it = optCateg.get(optKey).iterator();
			while (it.hasNext())
			{
				// System.out.println("Adding to alphabet category " + optKey);
				newAlph = lda.add2Alphabet(newAlph, lda.getInstances(), it.next());
			}
		}

		// Generating Keywords
		wordMap = lda.inferWordprob(inferInst, 0, newAlph);
		keySet = wordMap.keySet();
		iterator = keySet.iterator();
		System.out.println("Using Alphabet for all cateogories selected:");
		System.out.println("numWords: " + numWords);
		System.out.print("KW Probabil \t\t\t KW");
		System.out.println("");
		String keyword;
		i = 0;
		iterator = keySet.iterator();
		while (i < numWords)
		{
			if (iterator.hasNext())
			{
				keyword = iterator.next();
			}
			else
			{
				keyword = null;
			}
			if (keyword != null)
			{
				System.out.print(wordMap.get(keyword) + "\t\t" + keyword + "\t");
			}
			else
			{
				System.out.print("null\t\t" + "\t\t" + keyword + "\t\t");
			}
			System.out.print("\n");
			i++;
		}

	}

}