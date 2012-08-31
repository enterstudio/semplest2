package semplest.keywords.ldatest;

import java.io.File;

import semplest.keywords.lda.MalletTopic;

import cc.mallet.types.*;

public class LDAInferFromFile
{

	/**
	 * Infer topic distribution for an input category list from the latest dataset trained. find 6 closest trained category and their distances
	 * args[0] : path input category list file
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		// Files to store model and instances
		File pipeIOModel = new File("trainedmodel.modl");
		File pipeIOInstance = new File("trainedInstances.inst");
		InstanceList inferInst;
		int instIndex = 3;
		// Create a new MalletTopic object to load from file
		MalletTopic lda = new MalletTopic();

		// Load trained model and instances from file
		lda.loadLDAInst(pipeIOInstance);
		lda.loadLDAModel(pipeIOModel);

		// Load Instance List with trained pipe
		inferInst = lda.CreateInferInstfromFile(new File(args[0]));
		lda.InstanceClassifier(inferInst, instIndex);

	}

}
