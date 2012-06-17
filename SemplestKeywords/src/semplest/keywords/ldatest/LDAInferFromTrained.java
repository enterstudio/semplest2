package semplest.keywords.ldatest;

import java.io.File;

import semplest.keywords.lda.MalletTopic;


import cc.mallet.types.InstanceList;

public class LDAInferFromTrained {

	/**
	 * Infers the 6 closest trained categories of the one given by the index
	 * args[0] : index of the trained instance to evaluate
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		File pipeIOModel= new File("trainedmodelnewsTEST700.modl");
		File pipeIOInstance= new File("trainedInstancesnewsTEST700.inst");
		//int instIndex = Integer.parseInt(args[0]);
		
		int instIndex =1325; //Remove if you want to use args as index input!!!
		
		//Create a new MalletTopic object to load from file
		MalletTopic lda = new MalletTopic();
		System.out.println("Executing LDAInferFromTrained");
		// Load trained model and instances from file
		lda.loadLDAInst(pipeIOInstance);
		lda.loadLDAModel(pipeIOModel);
		lda.InstanceClassifier(instIndex);				
	}

}
