package semplest.keywords.ldatest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import semplest.keywords.lda.MalletTopic;

import cc.mallet.types.InstanceList;

public class LDAdescription2html
{

	/**
	 * Given the description of a website in mallet format, infer the html related to it
	 * 
	 * @param args
	 *          args[0] : Description file to infer args[1] : Path to report file args[2] : Number of iterations to calculate fscore
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		// Model already trained
		File pipeIOModel = new File("trainedmodelHTML.modl");
		File pipeIOInstance = new File("trainedInstancesHTML.inst");
		int numIter = Integer.parseInt(args[2]);
		InstanceList inferInst;
		double[] out;
		// Create a new MalletTopic object to load from file
		MalletTopic lda = new MalletTopic();
		// Load trained model and instances from file
		lda.loadLDAInst(pipeIOInstance);
		lda.loadLDAModel(pipeIOModel);

		// Create Instance List from file
		inferInst = lda.CreateInferInstfromFile(new File(args[0]));
		// Output to file
		PrintStream stdout = System.out;
		System.setOut(new PrintStream(new FileOutputStream(args[1])));
		// Classify and calculate Fscore
		out = lda.calcFscore(inferInst, numIter);
		System.out.println("Fscore Results {Fscore, precision, recall}");
		System.out.println(out[0] + "\t" + out[1] + "\t" + out[2]);
		System.setOut(stdout);
		System.out.println("Report successfuly created in " + args[1]);

	}

}
