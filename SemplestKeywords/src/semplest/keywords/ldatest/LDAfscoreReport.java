package semplest.keywords.ldatest;

import java.io.FileOutputStream;
import java.io.PrintStream;

import semplest.keywords.lda.MalletTopic;

public class LDAfscoreReport
{

	/**
	 * Calculates fscore for classification of trained data for different number of topics a creates a report args[0] path to training file args[1] path
	 * to report args[2] number of instances to evaluate in each iteration
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		int numIter = Integer.parseInt(args[2]);
		// Parameters
		double alpha = 0.01;
		double beta = 0.01;
		// int numiter = 1000;
		// Number of topics to evaluate
		int[] numTopics = { 100, 200, 400, 600, 800, 1000, 5000 };
		double[][] fscoreResults = new double[numTopics.length][];

		// Create a new MalletTopic object to load from file
		MalletTopic lda;
		for (int i = 0; i < numTopics.length; i++)
		{
			lda = new MalletTopic();
			// Set new number of topics
			lda.setNumTopics(numTopics[i]);
			// Create instances for each category
			lda.CreateInstances(args);
			// Train model from Instances
			lda.LDAcreateModel(alpha, beta, numIter);
			// Calculator
			fscoreResults[i] = lda.calcFscore(Integer.parseInt(args[2]));
		}
		PrintStream stdout = System.out;
		System.setOut(new PrintStream(new FileOutputStream(args[1])));
		for (int j = 0; j < fscoreResults.length; j++)
		{
			System.out.println(numTopics[j] + "\t" + fscoreResults[j][0] + "\t" + fscoreResults[j][1] + "\t" + fscoreResults[j][2]);
		}
		System.setOut(stdout);
		System.out.println("Report successfully created");
	}

}
