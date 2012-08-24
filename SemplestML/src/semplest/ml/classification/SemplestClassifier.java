package semplest.ml.classification;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class SemplestClassifier {


	public static void main(String [] args){


		DataSource source;
		Instances trainData = null;
		Instances testData = null;

		try {
			source = new DataSource("ExampleData/omim_trainingset.arff");
			trainData = source.getDataSet();
			source = new DataSource("ExampleData/omim_hgmd_testset.arff");
			testData = source.getDataSet();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// setting class attribute if the data format does not provide this information
		// For example, the XRFF format saves the class attribute information as well
		if (trainData.classIndex() == -1)
			trainData.setClassIndex(trainData.numAttributes() - 1);

		if (testData.classIndex() == -1)
			testData.setClassIndex(testData.numAttributes() - 1);

		/*
		 for(int i=0; i< trainData.numInstances(); i++){
			 System.out.println(trainData.instance(i));
		 }
		 */


		/*
		 // classifier
		 J48 j48 = new J48();
		 j48.setUnpruned(true);  

		 try {
			 j48.buildClassifier(trainData);
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }


		 for(int i=0; i< testData.numInstances(); i++){
			 double pred = 0.0;
			 try {
				 pred = j48.classifyInstance(testData.instance(i));
			 } catch (Exception e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 System.out.println(testData.instance(i));
			 System.out.print("Sl no: " + testData.instance(i).value(0));
			 System.out.print(", actual: " + testData.classAttribute().value((int) testData.instance(i).classValue()));
			 System.out.println(", predicted: " + testData.classAttribute().value((int) pred));
		 }

		 */

		// train classifier
		Classifier cls = new J48();
		try {
			cls.buildClassifier(trainData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// evaluate classifier and print some statistics
		Evaluation eval = null;
		try {
			eval = new Evaluation(trainData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			eval.evaluateModel(cls, testData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(eval.toSummaryString("\nResults\n=======\n", false));


		Evaluation evalCV = null;
		Classifier clsCV = new J48();

		try {
			evalCV = new Evaluation(trainData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			evalCV.crossValidateModel(clsCV, trainData, 10, new Random());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(evalCV.toSummaryString("\nResults\n=======\n", false));







	}

}
