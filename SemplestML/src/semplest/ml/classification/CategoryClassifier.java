/**
 * Java program for classifying short text categorys into two classes.
 */

package semplest.ml.classification;


import semplest.ml.datasets.TwentyNews;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.FastVector;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.SMO;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.trees.J48;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
import java.io.*;
//import java.util.Hashtable;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CategoryClassifier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* The training data gathered so far. */
	private Instances m_Data = null;

	/* The filter used to generate the word counts. */
	private StringToWordVector m_Filter = new StringToWordVector();

	/* The actual classifier. */
	private Classifier m_Classifier = new SMO();
	//private Classifier m_Classifier = new J48();
	//private Classifier m_Classifier = new NaiveBayes();
	//private Classifier m_Classifier = new AdaBoostM1();
	//private Classifier m_Classifier = new Logistic();
	
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
	
	
	/* Whether the model is up to date. */
	private boolean m_UpToDate;

	/**
	 * Constructs empty training dataset.
	 */
	public CategoryClassifier(String [] categories) throws Exception {

		String nameOfDataset = "CategoryClassificationProblem";

		// Create vector of attributes.
		FastVector attributes = new FastVector(2);

		// Add attribute for holding categorys.
		attributes.addElement(new Attribute("Category", (FastVector) null));

		// Add class attribute.
		FastVector classValues = new FastVector(categories.length);
		for(int i=0; i<categories.length; i++){
			classValues.addElement(categories[i]);
		}
		attributes.addElement(new Attribute("Class", classValues));

		// Create dataset with initial capacity of 100, and set index of class.
		m_Data = new Instances(nameOfDataset, attributes, 100);
		m_Data.setClassIndex(m_Data.numAttributes() - 1);
	}

	/**
	 * Updates model using the given training category.
	 */
	public void updateData(String text, String classValue) throws Exception {

		// Make text into instance.
		Instance instance = makeInstance(text, m_Data);
		//System.out.println(classValue);
		// Set class value for instance.
		instance.setClassValue(classValue);

		// Add instance to training data.
		m_Data.add(instance);
		m_UpToDate = false;
	}

	/**
	 * Classifies a given text.
	 */
	public String classifyCategory(String text) throws Exception {

		// Check whether classifier has been built.
		if (m_Data.numInstances() == 0) {
			throw new Exception("No classifier available.");
		}

		// Check whether classifier and filter are up to date.
		if (!m_UpToDate) {

			System.out.println("Updating Classifier...");

			// Initialize filter and tell it about the input format.
			m_Filter.setInputFormat(m_Data);

			// Generate word counts from the training data.
			Instances filteredData = Filter.useFilter(m_Data, m_Filter);

			// Rebuild classifier.
			m_Classifier.buildClassifier(filteredData);
			m_UpToDate = true;
		}

		// Make separate little test set so that text
		// does not get added to string attribute in m_Data.
		Instances testset = m_Data.stringFreeStructure();

		// Make text into test instance.
		Instance instance = makeInstance(text, testset);

		// Filter instance.
		m_Filter.input(instance);
		Instance filteredInstance = m_Filter.output();

		// Get index of predicted class value.
		double predicted = m_Classifier.classifyInstance(filteredInstance);

		// Output class value.
		System.err.println("Category classified as : "
				+ m_Data.classAttribute().value((int) predicted));
		return m_Data.classAttribute().value((int) predicted);
	}

	/**
	 * Method that converts a text category into an instance.
	 */
	private Instance makeInstance(String text, Instances data) {

		// Create instance of length two.
		Instance instance = new Instance(2);

		// Set value for category attribute
		Attribute categoryAtt = data.attribute("Category");
		instance.setValue(categoryAtt, categoryAtt.addStringValue(text));

		// Give instance access to attribute information from the dataset.
		instance.setDataset(data);
		return instance;
	}

	
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


		
		String [] classes = {"sci.electronics", "sci.med", "sci.space"};
		//String [] classes = {"comp.os.ms-windows.misc", "comp.sys.mac.hardware", "comp.graphics", "comp.sys.ibm.pc.hardware", "comp.windows.x"};
		//String [] classes = {"sci.electronics", "comp.os.ms-windows.misc"};
		
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
		CategoryClassifier categoryCl;
		try {
			ObjectInputStream modelInObjectFile = new ObjectInputStream(new FileInputStream(modelName));
			categoryCl = (CategoryClassifier) modelInObjectFile.readObject();
			modelInObjectFile.close();
		} catch (FileNotFoundException e) {
			categoryCl = new CategoryClassifier(classes);
		}
		
		
		// add training data
		for(int i=0; i< classes.length; i++){
			for (File f : trainFileClasses.get(i)){
				String text = TwentyNews.getText(f);
				categoryCl.updateData(text, classes[i]);
			}
		}
		
		
		int [] totalCounts = new int[classes.length];
		int [] correctCounts = new int[classes.length];
		
		List<List<File>> testFileClasses = TwentyNews.getFileClasses(testPath, classes);
		for(int i=0; i< classes.length; i++){
			for (File f : testFileClasses.get(i)){
				String text = TwentyNews.getText(f);
				String predictedClass = categoryCl.classifyCategory(text);
				if(predictedClass.equals(classes[i])){
					correctCounts[i]++;
				}
				totalCounts[i]++;
			}
		}
		int total = 0;
		int correct =0;
		for(int i=0; i< classes.length; i++){
			System.out.println("Category "+classes[i]+": correct prediction "+
					correctCounts[i]+" out of total "+totalCounts[i]+". Accuracy: "+((double) correctCounts[i])/totalCounts[i]*100);
			total+=totalCounts[i];
			correct+=correctCounts[i];
		}
		System.out.println("Accuracy: "+((double) correct)/total*100);
		
		
		

		
		
	}

	/*
	public String doCategoryClassify(String categoryName, String modelName,
			String classValue) {
		try {
			// Get category file
			FileReader m = new FileReader(categoryName);
			StringBuffer category = new StringBuffer();
			int l;
			while ((l = m.read()) != -1) {
				category.append((char) l);
			}
			m.close();

			// Get Model file
			if (modelName.length() == 0) {
				throw new Exception("Must provide name of model file.");
			}
			CategoryClassifier categoryCl;
			try {
				ObjectInputStream modelInObjectFile = new ObjectInputStream(
						new FileInputStream(modelName));
				categoryCl = (CategoryClassifier) modelInObjectFile.readObject();
				modelInObjectFile.close();
			} catch (FileNotFoundException e) {
				categoryCl = this;
			}

			String classifierRet = "";
			// Process category.
			if (classValue.length() != 0) {
				categoryCl.updateData(category.toString(), classValue);
			} else {
				classifierRet = categoryCl.classifyCategory(category.toString());
			}

			// Save category classifier object.
			ObjectOutputStream modelOutObjectFile = new ObjectOutputStream(
					new FileOutputStream(modelName));
			modelOutObjectFile.writeObject(categoryCl);
			modelOutObjectFile.close();


			return classifierRet;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	public void saveAs(String filepath)throws Exception{
		ArffSaver saver = new ArffSaver();
		saver.setInstances(m_Data);
		saver.setFile(new File(filepath));
		saver.writeBatch();
	}


	public static void main(String[] options) throws Exception{
		CategoryClassifier mc = new CategoryClassifier();
		mc.doCategoryClassify("data/mytraining/training-0001",
				"model/training", "miss");
		mc.doCategoryClassify("data/mytraining/training-0001",
				"model/training", "");

		//    doMain(options);
	}

	private static void doMain(String[] options) {
		try {

			// Read category file into string.
			String categoryName = Utils.getOption('m', options);
			if (categoryName.length() == 0) {
				throw new Exception("Must provide name of category file.");
			}
			FileReader m = new FileReader(categoryName);
			StringBuffer category = new StringBuffer();
			int l;
			while ((l = m.read()) != -1) {
				category.append((char) l);
			}
			m.close();

			// Check if class value is given.
			String classValue = Utils.getOption('c', options);

			// If model file exists, read it, otherwise create new one.
			String modelName = Utils.getOption('t', options);
			if (modelName.length() == 0) {
				throw new Exception("Must provide name of model file.");
			}
			CategoryClassifier categoryCl;
			try {
				ObjectInputStream modelInObjectFile = new ObjectInputStream(
						new FileInputStream(modelName));
				categoryCl = (CategoryClassifier) modelInObjectFile.readObject();
				modelInObjectFile.close();
			} catch (FileNotFoundException e) {
				categoryCl = new CategoryClassifier();
			}

			// Check if there are any options left
			Utils.checkForRemainingOptions(options);

			// Process category.
			if (classValue.length() != 0) {
				categoryCl.updateData(category.toString(), classValue);
			} else {
				categoryCl.classifyCategory(category.toString());
			}

			// Train data.


			// Save category classifier object.
			ObjectOutputStream modelOutObjectFile = new ObjectOutputStream(
					new FileOutputStream(modelName));
			modelOutObjectFile.writeObject(categoryCl);
			modelOutObjectFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/



}