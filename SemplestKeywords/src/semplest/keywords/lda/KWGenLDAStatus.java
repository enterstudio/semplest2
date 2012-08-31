package semplest.keywords.lda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import cc.mallet.types.InstanceList;

//Keeps states of each of the KWGenLDAqueries.
public class KWGenLDAStatus
{
	public String InstanceID;
	public String[] topCat; // Array of the top numCateg categories classified
	public TreeMap<String, Double> wordMap; // sorted map of keywords and probabilities for last run of getKW
	public boolean ready4kw, genericMade; // Final list of categories has been generated.
	public ArrayList<String> optList;
	public String data; // Input data for the kwgenerator;
	public InstanceList inferInst; // Instance of the input data;
	public double[] probDistInf; // Probability distribution of the last inferInst;
	public HashMap<String, Double> options; // Map of repeated patterns and counts
	public int indexFinCat; // index of the final subcategory selected
	public int numCateg; // Number of categories to consider when generating options for user

	public KWGenLDAStatus(String id)
	{
		InstanceID = id;
		ready4kw = false; // Not ready to generate keywords
		numCateg = 10;
		topCat = new String[numCateg];
	}

	public KWGenLDAStatus()
	{
		InstanceID = "Default";
		ready4kw = false; // Not ready to generate keywords
		numCateg = 10;
		topCat = new String[numCateg];
	}
}
