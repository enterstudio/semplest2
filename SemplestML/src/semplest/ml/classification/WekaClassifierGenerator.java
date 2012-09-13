package semplest.ml.classification;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.SMO;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.LogitBoost;
import weka.classifiers.trees.J48;

public class WekaClassifierGenerator {

	public Classifier getWekaClassifier(ClassificationAlgorithm algo) {
		Classifier cl = null;

		if(algo.equals(ClassificationAlgorithm.SVM)){
			cl = new SMO();
		}
		if(algo.equals(ClassificationAlgorithm.DecisionTree)){
			cl = new J48();
		}
		if(algo.equals(ClassificationAlgorithm.NaiveBayes)){
			cl = new NaiveBayes();
		}
		if(algo.equals(ClassificationAlgorithm.LogisticRegression)){
			cl = new Logistic();
		}
		if(algo.equals(ClassificationAlgorithm.AdaBoost)){
			cl = new AdaBoostM1();
		}
		if(algo.equals(ClassificationAlgorithm.LogitBoost)){
			cl = new LogitBoost();
		}
		
		
		return cl;
	}
	
	
	
	
        //wekaClassifier = new J48();
		//wekaClassifier = new NaiveBayes();
		//wekaClassifier = new AdaBoostM1();
		//wekaClassifier = new LogitBoost();
		//wekaClassifier = new Logistic();
		
		/*
		Here is a list of the most important classifiers currently implemented in weka.classifiers:

			a) Classifiers for categorical prediction:
			weka.classifiers.IBk: k-nearest neighbour learner
			weka.classifiers.j48.J48: C4.5 decision trees
			weka.classifiers.j48.PART: rule learner
			weka.classifiers.NaiveBayes: naive Bayes with/without kernels
			weka.classifiers.OneR: Holte's OneR
			weka.classifiers.KernelDensity: kernel density classifier
			weka.classifiers.SMO: support vector machines
			weka.classifiers.Logistic: logistic regression
			weka.classifiers.AdaBoostM1: AdaBoost
			weka.classifiers.LogitBoost: logit boost
			weka.classifiers.DecisionStump: decision stumps (for boosting)
			b) Classifiers for numeric prediction:
			weka.classifiers.LinearRegression: linear regression
			weka.classifiers.m5.M5Prime: model trees
			weka.classifiers.IBk: k-nearest neighbour learner
			weka.classifiers.LWR: locally weighted regression
			weka.classifiers.RegressionByDiscretization: uses categorical classifiers

	    */

}
