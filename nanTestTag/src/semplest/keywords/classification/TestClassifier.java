
package semplest.keywords.classification;

import java.io.File;

public class TestClassifier {
	/**
	 * Trains model based on dataset and saves model and instances to default file
	 * Arguments
	 * args[0] : path to training data file ( In SEMplest FORMAT!!)
	 * args[1] : path to the file that will contain model and instances
	 * args[2] : Number of topics
	 * args[3] : Number of Gibbs iterations
	 * args[4] : alpha value
	 * args[5] : beta value
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		//Files to store model and instances
		File pipeIOModel= new File("subhojitTest.modl");
		File pipeIOInstance= new File("subhojitTest.inst");
		
		//Instance LDA Topic Modelling
//		MalletTopic lda = new MalletTopic();
		MalletClassifier classifier = new MalletClassifier();

		
		// Conditional statement to accomodate existance of arguments
		switch (args.length) {
		default:
			throw new Exception();
		case 2:
			pipeIOModel= new File(args[1]+".modl");
			pipeIOInstance = new File(args[1]+".inst");
		case 1:
			//Create instances for each category
			System.out.println("Creating Training Instances...");

			classifier.CreateInstancesSEMplest(args);
			System.out.println("Saving Instances");
//			System.out.println(classifier.getInstanceList().get(0).getData());
//			lda.saveLDAInst(pipeIOInstance);
			classifier.saveInst(pipeIOInstance);
			//Train model from Instances
			classifier.createModel();
			//Writing to file
			System.out.println("Saving Model...");
//			lda.saveLDAModel(pipeIOModel);
			classifier.saveClassifierModel(pipeIOModel);
			System.out.println("Model successfully created");
			
			// it classifies the trainging set itself (for the time being)
			classifier.classify();
			
			
		} 		


	}

}
