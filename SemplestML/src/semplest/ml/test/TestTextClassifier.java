package semplest.ml.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.List;

import semplest.ml.classification.ClassificationAlgorithm;
import semplest.ml.classification.TextClassifier;
import semplest.ml.datasets.TwentyNews;
import weka.classifiers.Evaluation;

public class TestTextClassifier {



	public static void main(String[] args) throws Exception{

		//		comp.os.ms-windows.misc comp.sys.mac.hardware 
		//		comp.graphics comp.sys.ibm.pc.hardware comp.windows.x 
		//		
		//		rec.motorcycles rec.sport.hockey rec.autos rec.sport.baseball
		//		
		//		alt.atheism misc.forsale   
		//		
		//		sci.space sci.crypt sci.electronics sci.med
		//		
		//		talk.politics.guns talk.politics.misc talk.politics.mideast talk.religion.misc                
		//		soc.religion.christian  



		//String [] classes = {"sci.electronics", "sci.med", "sci.space"};
		//String [] classes = {"comp.os.ms-windows.misc", "comp.sys.mac.hardware", "comp.graphics", "comp.sys.ibm.pc.hardware", "comp.windows.x"};
		String [] classes = {"sci.electronics", "comp.os.ms-windows.misc"};

		String trainPath = "C://Users/ssom/Data/20news-bydate/20news-bydate-train/";
		String testPath = "C://Users/ssom/Data/20news-bydate/20news-bydate-test/";



		List<List<File>> trainFileClasses = TwentyNews.getFileClasses(trainPath, classes);

		for(int i=0; i<trainFileClasses.size();i++){
			System.out.println("Class "+i+" training data: "+trainFileClasses.get(i).size());
		}

		String modelName = "modelFile";
		// Get Model file
		if (modelName.length() == 0) {
			throw new Exception("Must provide name of model file.");
		}
		TextClassifier cl;
		try {
			ObjectInputStream modelInObjectFile = new ObjectInputStream(new FileInputStream(modelName));
			cl = (TextClassifier) modelInObjectFile.readObject();
			modelInObjectFile.close();
		} catch (FileNotFoundException e) {
			cl = new TextClassifier(classes, "_NodeNameShouldGoHere_", ClassificationAlgorithm.SVM);
		}


		// Add training data
		for(int i=0; i< classes.length; i++){
			for (File f : trainFileClasses.get(i)){
				String text = TwentyNews.getText(f);
				cl.addTrainingData(text, classes[i]);
			}
		}

		Evaluation eval = cl.crossValidateModel(10);
		System.out.println(eval.toSummaryString());


//		int [] totalCounts = new int[classes.length];
//		int [] correctCounts = new int[classes.length];
//
//		List<List<File>> testFileClasses = TwentyNews.getFileClasses(testPath, classes);
//		for(int i=0; i< classes.length; i++){
//			for (File f : testFileClasses.get(i)){
//				String text = TwentyNews.getText(f);
//				String predictedClass = cl.classify(text);
//				if(predictedClass.equals(classes[i])){
//					correctCounts[i]++;
//				}
//				totalCounts[i]++;
//			}
//		}
//		int total = 0;
//		int correct =0;
//		for(int i=0; i< classes.length; i++){
//			System.out.println("Category "+classes[i]+": correct prediction "+
//					correctCounts[i]+" out of total "+totalCounts[i]+". Accuracy: "+((double) correctCounts[i])/totalCounts[i]*100);
//			total+=totalCounts[i];
//			correct+=correctCounts[i];
//		}
//		System.out.println("Accuracy: "+((double) correct)/total*100);

	}

}
