package semplest.keywords.lda;

import java.io.File;


public class LDATrain {

	/**
	 * Trains model based on dataset and saves model and instances to default file
	 * Arguments
	 * args[0] : path to training data file ( IN MALLET FORMAT!!)
	 * args[1] : Number of topics
	 * args[2] : Number of Gibbs iterations
	 * args[3] : alpha value
	 * args[4] : beta value
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		//Files to store model and instances
		File pipeIOModel= new File("traineDescAllbutR.modl");
		File pipeIOInstance= new File("traineDescAllbutR.inst");
		
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
			//Create instances for each category
			lda.CreateInstances(args);
			//Train model from Instances
			lda.LDAcreateModel(alpha, beta, numiter);
			//Writing to file
			lda.saveLDAModel(pipeIOModel);
			lda.saveLDAInst(pipeIOInstance);
			//System.out.println("" + alpha + " " + beta + " " + numiter );
		} 		

		/* Optional printing of results		
		int InstInd = 0		
		System.out.println("Printing Words and Topics from Category " + InstInd);
		topicModelingTest.LDAprintTrainedInst(InstInd);
		System.out.println("Show top 10 words in topics with proportions for Category " + InstInd);
		topicModelingTest.LDAprintNkeywordsperTopic(InstInd, 10);
		*/
	}

}
