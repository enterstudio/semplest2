package semplest.keywords.lda;

import java.io.File;

public class LDATrainSEMplestCache {
	/**
	 * Trains model based on dataset and saves model and instances to default file
	 * Arguments
	 * args[0] : path to training data file ( IN SEMplest FORMAT!!)
	 * args[1] : Number of topics
	 * args[2] : Number of Gibbs iterations
	 * args[3] : alpha value
	 * args[4] : beta value
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		//Files to store model and instances
		File pipeIOModel= new File("trainedmodelallHTML700.modl");
		File pipeIOInstance= new File("trainedInstancesallHTML700.inst");
		
		//Instance LDA Topic Modelling
		MalletTopic lda = new MalletTopic();
		double alpha=0.01;
		double beta=0.01;
		int numiter=1000;
		
		// Conditional statement to acomodate existance of arguments
		switch (args.length) {
		default:
			throw new Exception();
		case 5:
			beta = Double.parseDouble(args[4]);
		case 4:
			alpha = Double.parseDouble(args[3]);
		case 3:
			numiter = Integer.parseInt(args[2]);
		case 2:
			lda.setNumTopics(Integer.parseInt(args[1]));
		case 1:
			/*//Create instances for each category
			System.out.println("Creating Training Instances...");
			lda.CreateInstancesSEMplestCache2(args);
			*/
			//Create instances for each category multithreaded
			System.out.println("Creating Training Instances...");
			lda.CreateInstancesSEMplestCacheMultiThread(args, 8);
			
			//Train model from Instances
			System.out.println("Saving Instances...");
			lda.saveLDAInstCache(pipeIOInstance);
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
