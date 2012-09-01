package semplest.keywords.ldatest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import semplest.keywords.javautils.*;
import semplest.keywords.lda.MalletTopic;

import cc.mallet.types.FeatureVectorSequence.Iterator;
import cc.mallet.types.InstanceList;
import cc.mallet.types.Alphabet;

public class GenerateKeywords
{
	// this is a test comment
	/**
	 * Generate Keywords from and input URL based on trained model Words will belong to the alphabet of the 5 closest instances and will be ordered by
	 * probability of belonging to the URL
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		// //Files to store model and instances
		File pipeIOModel = new File("trainedmodelDescAll700.modl");
		File pipeIOInstance = new File("trainedInstancesDescAll700.inst");
		int numCateg = 6; // Number of categories to consider when generating Keyword Lists
		List<TreeMap<String, Double>> wordMap = new ArrayList<TreeMap<String, Double>>();
		List<Set<String>> keySet = new ArrayList<Set<String>>();
		List<java.util.Iterator<String>> itArray = new ArrayList<java.util.Iterator<String>>();
		TreeMap<String, Double> wordM;
		Set<String> keyS;
		String[] key = new String[numCateg + 1];

		InstanceList inferInst;
		int numWords = 30;
		int i = 0;
		String url = "http://www.bedbathandbeyond.com/default.asp?"; // URL
		// String url = "http://www.statefarm.com/"; //URL
		String data = "";
		double[][] categInd;
		// Create data from URL
		List<String> words = TextUtils.validHtmlStems(url);
		System.out.println("Words from URL " + words.size());
		// Create a new MalletTopic object to load from file
		MalletTopic lda = new MalletTopic();

		// Load trained model and instances from file

		System.out.println("Loading Model...");
		lda.loadLDAInst(pipeIOInstance);
		lda.loadLDAModel(pipeIOModel);
		System.out.println("Model Loaded");
		System.out.println("Number of topics: " + lda.getNumTopics());

		// for(int j=0;j<50;j++){words.add("tv");words.add("screen");}
		for (String s : words)
		{
			// System.out.println( s );
			data = data + " " + s;
			System.out.print(s + "  ");
		}
		// Create Instance form url data
		inferInst = lda.CreateInferInstfromData("0", url, data);
		// Find the closest trained instances
		categInd = lda.InstanceClassifierMat(inferInst, 0);

		// Get a TreeMap with the words and the probabilities of each word to belong to the URL
		/*
		 * //---------------------------------------------------------------------- wordM = lda.inferWordprob(inferInst, 0); keyS = wordM.keySet();
		 * System.out.println("wordMap Size: "+ wordM.size()); for(String keys : keyS){ if(i>=numWords)break;
		 * System.out.println(wordM.get(keys)+"\t"+keys); i++; } //---------------------------------------------------------------------
		 */

		// Get a TreeMap with the words and the probabilities of each word to belong to the URL
		i = 0;
		wordMap.add(lda.inferWordprob(inferInst, 0));
		keySet.add(wordMap.get(0).keySet());
		itArray.add(keySet.get(0).iterator());
		// Get a TreeMap with the words and the probabilities of each word to belong to the top categories until numCateg;
		// Two lists are generated for each category, one will be using the whole alphabet and the other one using only the alphabet
		// from the category.
		for (int j = 0; j < numCateg; j++)
		{
			// System.out.println(lda.getInstanceLabel((int)categInd[0][j]));
			wordMap.add(lda.inferWordprob(lda.getInstances(), (int) categInd[0][j]));
			keySet.add(wordMap.get(j + 1).keySet());
			itArray.add(keySet.get(j + 1).iterator());
		}
		System.out.println("Using complete Alphabet:");
		System.out.println("wordMap Size: " + wordMap.get(0).size());
		System.out.print("General Prob \t\t\tGeneral KW");
		for (int j = 0; j < numCateg; j++)
		{
			System.out.print("\tCategory " + j + " Prob\t\t\tCategory " + j + " KW");
		}
		System.out.println("");
		while (itArray.get(0).hasNext() && i < numWords)
		{
			for (int j = 0; j < numCateg + 1; j++)
			{
				key[j] = itArray.get(j).next();
			}
			for (int j = 0; j < numCateg + 1; j++)
			{
				if (key[j].length() <= 7)
				{
					System.out.print(wordMap.get(0).get(key[j]) + "\t\t" + key[j] + "\t\t");
				}
				else
				{
					System.out.print(wordMap.get(0).get(key[j]) + "\t\t" + key[j] + "\t");
				}
			}
			System.out.print("\n");
			i++;
		}
		wordMap.clear();
		keySet.clear();
		itArray.clear();
		System.out.println();

		// Now the same just using alphabets for each category
		i = 0;
		wordMap.add(lda.inferWordprob(inferInst, 0, lda.createAlphabet4instance(lda.getInstances(), (int) categInd[0][0])));
		keySet.add(wordMap.get(0).keySet());
		itArray.add(keySet.get(0).iterator());
		// Get a TreeMap with the words and the probabilities of each word to belong to the top categories until numCateg;
		// Two lists are generated for each category, one will be using the whole alphabet and the other one using only the alphabet
		// from the category.
		// String wtest= "offer";
		for (int j = 0; j < numCateg; j++)
		{
			// System.out.println(lda.getInstanceLabel((int)categInd[0][j]));
			// Alphabet alph= lda.createAlphabet4instance( lda.getInstances(), (int)categInd[0][j]);
			// System.out.println("In catergory "+lda.getInstanceLabel((int)categInd[0][j])+"we have the word "+wtest+" : "+alph.contains(wtest));
			// System.out.println("Alphabet size Category "+j+" : "+alph.size());
			wordMap.add(lda.inferWordprob(lda.getInstances(), (int) categInd[0][j], lda.createAlphabet4instance(lda.getInstances(), (int) categInd[0][j])));
			keySet.add(wordMap.get(j + 1).keySet());
			itArray.add(keySet.get(j + 1).iterator());
		}
		System.out.println("Using Alphabet for each specific category:");
		System.out.println("(For general KW set, using alphabet for closest category)");
		System.out.print("General Prob \t\t\tGeneral KW");
		for (int j = 0; j < numCateg; j++)
		{
			System.out.print("\tCategory " + j + " Prob\t\t\tCategory " + j + " KW");
		}
		System.out.println("");

		while (i < numWords)
		{
			for (int j = 0; j < numCateg + 1; j++)
			{
				if (itArray.get(j).hasNext())
				{
					key[j] = itArray.get(j).next();
				}
				else
				{
					key[j] = null;
				}
			}
			for (int j = 0; j < numCateg + 1; j++)
			{
				if (key[j] != null && key[j].length() <= 7)
				{
					System.out.print(wordMap.get(j).get(key[j]) + "\t\t" + key[j] + "\t\t");
				}
				else
				{
					if (key[j] != null)
					{
						System.out.print(wordMap.get(j).get(key[j]) + "\t\t" + key[j] + "\t");
					}
					else
					{
						System.out.print("null\t\t" + "\t\t" + key[j] + "\t\t");
					}
				}
			}
			System.out.print("\n");
			i++;
		}
	}
}
