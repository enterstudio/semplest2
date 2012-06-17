package semplest.keywords.ldatest;

import java.io.*;

import semplest.keywords.lda.MalletTopic;



public class LDAInferRandRemove {

	/**
	 * This program takes a saved model, removes a number of instances, retrains the model of those instances
	 * and then finds what are the closest trained instances to the ones removed.
	 * Results are saved into a file.
	 * args[0] : Path to report file
	 * args[1] : Number of instances to test
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		File pipeIOModel= new File("trainedmodelDescAll700.modl");
		File pipeIOInstance= new File("trainedInstancesDescAll700.inst");
		int numRemove = Integer.parseInt(args[1]);
		//numRemove =3621; //Remove if you want to use args as index input!!!
		
		//Create a new MalletTopic object to load from file
		MalletTopic lda = new MalletTopic();
		// Load trained model and instances from file
		lda.loadLDAInst(pipeIOInstance);
		lda.loadLDAModel(pipeIOModel);
		
		//Execute remove, retrain and classify
		lda.RandRemoveAndInfer(numRemove, args[0]);

	}

}
