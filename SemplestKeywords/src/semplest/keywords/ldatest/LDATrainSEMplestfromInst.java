package semplest.keywords.ldatest;

import java.io.File;

import semplest.keywords.lda.MalletTopic;


public class LDATrainSEMplestfromInst {
	/**
	 * Trains model based on dataset and saves model and instances to default file
	 * Arguments
	 * args[0] : path to training data file ( In SEMplest FORMAT!!)
	 * args[1] : path to  instance document saved
	 * args[2] : Number of topics
	 * args[3] : Number of Gibbs iterations
	 * args[4] : alpha value
	 * args[5] : beta value
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		//Files to store model and instances
		File pipeIOModel= new File("trainedmodelHTMLAll700.modl");
		File pipeIOInstance= new File("trainedInstancesHTMLAll700.inst");
		
		//Instance LDA Topic Modelling
		MalletTopic lda = new MalletTopic();
		double alpha=0.01;
		double beta=0.01;
		int numiter=1000;
		
		// Conditional statement to acomodate existance of arguments
		switch (args.length) {
		default:
			throw new Exception();
		case 6:
			beta = Double.parseDouble(args[5]);
		case 5:
			alpha = Double.parseDouble(args[4]);
		case 4:
			numiter = Integer.parseInt(args[3]);
		case 3:
			lda.setNumTopics(Integer.parseInt(args[2]));
		case 2:
			pipeIOInstance = new File(args[1]);
			pipeIOModel = new File(args[1].replace(".inst", ".modl"));
		case 1:

			System.out.println("Loading Instances");
			lda.loadLDAInst(pipeIOInstance);
			//Train model from Instances
			System.out.println("Training Model...");
			lda.LDAcreateModel(alpha, beta, numiter);
			//Writing to file
			System.out.println("Saving Model...");
			lda.saveLDAModel(pipeIOModel);

			System.out.println("Model successfuly created");
			//System.out.println("" + alpha + " " + beta + " " + numiter );
		} 		

		/*//Optional printing of results		
		int InstInd = 0;		
		System.out.println("Printing Words and Topics from Category " + InstInd);
		lda.LDAprintTrainedInst(InstInd);
		System.out.println("Show top 10 words in topics with proportions for Category " + InstInd);
		lda.LDAprintNkeywordsperTopic(InstInd, 10);
		*/
	}
}
