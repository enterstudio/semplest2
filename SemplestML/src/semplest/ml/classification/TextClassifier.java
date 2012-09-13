/**
 * Java program for classifying short texts into different classes.
 */

package semplest.ml.classification;


import semplest.ml.datasets.TwentyNews;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.FastVector;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.*;

import java.util.List;
import java.util.Random;

public class TextClassifier implements Serializable {
	
	/* Synchronization in this class is presently implemented to ensure 
	 * proper execution and data corruption. But it doesn't check for situations
	 * where adding training data and classification tasks are carried out 
	 * simultaneously in order to reduce the complexity. 
	 * It's not a situation we are likely to face while crawling 
	 * and building model or classifying. 
	*/
	
	private final String FEATURE = "Feature";
	private final String TARGET = "Target";

	private static final long serialVersionUID = -1444835775445070762L;

	// The training data gathered so far. 
	private Instances textTrainingData; // stores raw text data
	
	// Generate word counts from the training data.
	private Instances wordCountTrainingData; // stores word-count vector 

	// The filter used to generate the word count wordCountTrainingData from textTrainingData 
	private StringToWordVector textToWordCountConverter = new StringToWordVector();
	
	// Whether the classifier model is up to date. 
	private boolean isClassifierModelUpToDate = false;
	
	// Whether the m_filteredData is up to date
	private boolean isWordCountDataUpToDate = false;
	
	// The Weka classifier. 
	private Classifier wekaClassifier = null;


	/**
	 * Constructs empty training dataset. The classes array contains the name of the categories
	 * and the name parameter is the name of the classifier model
	 */
	public TextClassifier(String [] classes, String name, ClassificationAlgorithm algo) throws Exception {

		String nameOfDataset = name;

		// Create vector of attributes.
		FastVector attributes = new FastVector(2);

		// Add attribute for holding text.
		attributes.addElement(new Attribute(FEATURE, (FastVector) null));

		// Add class attribute.
		FastVector classValues = new FastVector(classes.length);
		for(int i=0; i<classes.length; i++){
			classValues.addElement(classes[i]);
		}
		attributes.addElement(new Attribute(TARGET, classValues));

		// Create dataset with initial capacity of 100, and set index of class.
		textTrainingData = new Instances(nameOfDataset, attributes, 100);
		textTrainingData.setClassIndex(textTrainingData.numAttributes() - 1);
		
		// Initialize filter and tell it about the input format.
		textToWordCountConverter.setInputFormat(textTrainingData);
		
		WekaClassifierGenerator wekaFactory = new WekaClassifierGenerator();
		wekaClassifier = wekaFactory.getWekaClassifier(algo);
		
	}

	
	/**
	 * Add training data. 
	 */
	public void addTrainingData(String text, String classValue) throws Exception {

		// Make text into instance.
		Instance instance = makeInstance(text, textTrainingData);
		// Set class value for instance.
		instance.setClassValue(classValue);

		// Add instance to training data.
		synchronized(this) {
			textTrainingData.add(instance);
			isClassifierModelUpToDate = false;
			isWordCountDataUpToDate = false;
		}
	}

	
	private void updateWordCountData() throws Exception{
		// Check whether there is any training data
		if (textTrainingData.numInstances() == 0) {
			throw new Exception("No training data available.");
		}
		
		synchronized(this) {
			if(!isWordCountDataUpToDate) {

				System.out.println("Updating Word-count Data...");

				// Generate word counts from the training data.
				wordCountTrainingData = Filter.useFilter(textTrainingData, textToWordCountConverter);
				isWordCountDataUpToDate = true;

				System.out.println("Word-count data is now updated.");

			}
		}
	}
	
	
	private void updateModel() throws Exception{
				
		updateWordCountData();

		// Check whether classifier and filter are up to date.
		synchronized(this) {
			if (!isClassifierModelUpToDate) {

				System.out.println("Updating Model...");

				// Rebuild classifier.
				wekaClassifier.buildClassifier(wordCountTrainingData);
				isClassifierModelUpToDate = true;

				System.out.println("Model is now updated.");
			}
		}
	}

	
	/**
	 * Classifies a given text.
	 */
	public String classify(String text) throws Exception {

		updateModel();

		// Make separate little test set so that text
		// does not get added to string attribute in m_Data.
		Instances testset = textTrainingData.stringFreeStructure();

		// Make text into test instance.
		Instance instance = makeInstance(text, testset);

		// Filter instance.
		textToWordCountConverter.input(instance);
		Instance filteredInstance = textToWordCountConverter.output();

		// Get index of predicted class value.
		double predicted;
		synchronized(this) {
			predicted = wekaClassifier.classifyInstance(filteredInstance);
		}
		
		// Output class value.
		System.out.println("Category classified as : "
				+ textTrainingData.classAttribute().value((int) predicted));
		return textTrainingData.classAttribute().value((int) predicted);
	}
	
	
	/**
	 * Method that converts a text data into an instance.
	 */
	private Instance makeInstance(String text, Instances data) {

		// Create instance of length two.
		Instance instance = new Instance(2);

		// Set value for category attribute
		Attribute categoryAtt = data.attribute(FEATURE);
		instance.setValue(categoryAtt, categoryAtt.addStringValue(text));

		// Give instance access to attribute information from the dataset.
		instance.setDataset(data);
		return instance;
	}
	
	
	public Evaluation crossValidateModel(int fold) throws Exception {

		updateWordCountData();

		// Test the model
		Evaluation eTest = new Evaluation(wordCountTrainingData);
		
		try {
			System.out.println("Performaing "+fold+" fold Cross-validation...");
			synchronized(this){
				eTest.crossValidateModel(wekaClassifier, wordCountTrainingData, fold, new Random());
			}
			System.out.println("Cross validation complete. Error rate is "+eTest.errorRate());


		} catch (Exception e) {
			e.printStackTrace();
		}
		return eTest;
	}
	
//	public Evaluation evaluateWithTestData(Instances textTestData) throws Exception {
//		
//		updateModel();
//		
//		// Test the model
//		Evaluation eTest = null;
//
//		try {
//			// Generate word counts from the test data.
//			Instances wordCountTestData = Filter.useFilter(textTestData, textToWordCountConverter);
//			eTest = new Evaluation(wordCountTestData);
//
//			wordCountTestData = Filter.useFilter(textTestData, textToWordCountConverter);
//			eTest.evaluateModel(wekaClassifier, wordCountTestData);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return eTest;
//	}
	


	
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
		
		
		int [] totalCounts = new int[classes.length];
		int [] correctCounts = new int[classes.length];
		
		List<List<File>> testFileClasses = TwentyNews.getFileClasses(testPath, classes);
		for(int i=0; i< classes.length; i++){
			for (File f : testFileClasses.get(i)){
				String text = TwentyNews.getText(f);
				String predictedClass = cl.classify(text);
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