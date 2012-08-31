/**
 * Implementation of Latent Dirichlet Allocation (LDA) for Topic Modelling
 * Based on MALLET library from UMASS version 
 * SEMplest Inc. February 2012
 */
package semplest.keywords.lda;

// Import utilities from Mallet
import cc.mallet.util.*;
import cc.mallet.types.*;
import cc.mallet.pipe.*;
import cc.mallet.pipe.iterator.*;
import cc.mallet.topics.*;

import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.*;
import semplest.keywords.properties.ProjectProperties;

//Find variable numThreads for multiple thread execution
public class MalletTopic
{
	// ************Atributes ********
	private InstanceList instances;
	private ParallelTopicModel model;
	private int numTopics;
	private double initalpha;
	private double initbeta;
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer2.class);
	private double[] testprobab; // Probability distribution of the last test data infered from this model;

	// ************Methods *****************
	// ---------- Constructor Methods-----------
	public MalletTopic() throws Exception
	{
		numTopics = 256;
		instances = null;
		model = null;
		initalpha = 0.01;
		initbeta = 0.01;

	}

	public MalletTopic(String[] directories) throws Exception
	{
		this.CreateInstances(directories);
		numTopics = 256;
		initalpha = 0.01;
		initbeta = 0.01;
		this.LDAcreateModel(initalpha, initbeta, 1000);
	}

	// ---------------Set and get methods-----------

	public void setInstances(InstanceList inst)
	{
		instances = inst;
	}

	public void setModel(ParallelTopicModel mod)
	{
		model = mod;
	}

	public void setNumTopics(int ntopics)
	{
		numTopics = ntopics;
	}

	public InstanceList getInstances()
	{
		return instances;
	}

	public ParallelTopicModel getModel()
	{
		return model;
	}

	public int getNumTopics()
	{
		return numTopics;
	}

	public double[][] getTrainTopicDist()
	{
		double[][] trainTopicDistr;
		int instnum = instances.size();
		trainTopicDistr = new double[instnum][numTopics];

		for (int i = 0; i < instnum; i++)
		{
			// System.arraycopy(model.getTopicProbabilities(i), 0, trainTopicDistr[i], 0, numTopics);
			trainTopicDistr[i] = model.getTopicProbabilities(i);
		}
		return trainTopicDistr;
	}

	public String getInstanceLabel(int instIndex)
	{

		String labelinf = (String) instances.get(instIndex).getTarget();
		return labelinf;
	}

	public Instance removeInstance(int instIndex)
	{
		return instances.remove(instIndex);
	}

	public double[] getTestProb()
	{
		return testprobab;
	}

	// --------------- Performance Evaluation Methods-----------------------

	public double[] calcFscore(int numIter) throws FileNotFoundException
	{
		// Calculates calculates precision recall and Fscore for the calssification of the instances trained.
		// Randomly chooses a numIter number of instances and finds the closest one in the training set. If the closes one
		// corresponds to the one tested we have a perfect match
		// precision = TP/(TP+FP) -> Fraction of classified instances that have been properly classified
		// recall = TP/(TP+FN) -> Fraction of all the instances that have been properly classified.
		// In our case precision = recall, but if we ever set a minimum score for classification the would difer.
		// Fscore = (precision*recall)/(precision + recall)
		// output = {Fscore, precision, recall}

		double[] out;
		out = this.calcFscore(instances, numIter);
		return out;
	}

	public double[] calcFscore(InstanceList testInst, int numIter) throws FileNotFoundException
	{
		// Calculates calculates precision recall and Fscore for the calssification of the instances
		// in testInst (from description datasets).
		// Randomly chooses a numIter number of instances and finds the closest one in the training set. If the closes one
		// corresponds to the one tested we have a perfect match
		// Takes the intances of testInst from start to finish and calculates Fscore, precision and recall
		// output = {Fscore, precision, recall}
		String classResult;
		int[] randIndex = MathUtils.randIntArray(numIter, 0, testInst.size());
		double tp = 0;
		double fp = 0;
		double fn = 0;
		double fscore, precision, recall;
		for (int i = 0; i < numIter; i++)
		{
			classResult = this.InstanceClassifier(testInst, randIndex[i]);
			logger.info("Iteration " + i);
			if (classResult.equals((String) testInst.get(randIndex[i]).getTarget()))
			{
				tp = tp + 1;
			}
			else
			{
				fp = fp + 1;
				fn = fn + 1;
			}
		}

		precision = tp / (tp + fp);
		recall = tp / (tp + fn);
		fscore = 2 * (precision * recall / (precision + recall));
		double[] out = { fscore, precision, recall };
		return out;
	}

	public void RandRemoveAndInfer(int numRemove, String reportpath) throws Exception
	{
		// Removes a numRemove number of instances from the training set, then retrains and infers the
		// closest trained categories for the untrained data
		// Creates a report with the results;

		// Copy main instance to a new one and remove random intances
		MalletTopic newLDA = new MalletTopic();
		Instance instanceAux;
		newLDA.setInstances((InstanceList) instances.clone());
		newLDA.setNumTopics(numTopics);
		int numInst = instances.size();
		logger.info("Size of newLDA" + newLDA.getInstances().size() + "\t" + numInst);
		int[] randIndex;
		randIndex = MathUtils.randIntArray(numRemove, 0, numInst);
		// Instances have to be extracted from last to first, otherwise, indexes will not correspond
		// to the original ones
		Arrays.sort(randIndex);
		for (int i = 0; i < numRemove; i++)
		{
			logger.info("Index" + randIndex[numRemove - i - 1]);
			newLDA.removeInstance(randIndex[numRemove - i - 1]);
		}
		// Train new model with removed instances and create instanceList to infer
		newLDA.LDAcreateModel(initalpha, initbeta, model.numIterations);
		InstanceList testing = new InstanceList(newLDA.getInstances().getPipe());
		// Change data from feature sequence to string in the instance and add it through pipe
		for (int j = 0; j < numRemove; j++)
		{
			instanceAux = this.getStringInstancefromFeatureSequenceInstance(instances.get(randIndex[j]));
			testing.addThruPipe(instanceAux);
		}
		PrintStream stdout = System.out;
		if (reportpath != null)
		{
			// Change standard output to a report file
			System.setOut(new PrintStream(new FileOutputStream(reportpath)));
			for (int n = 0; n < numRemove; n++)
			{
				newLDA.InstanceClassifier(testing, n);
			}
		}
		System.setOut(stdout);
		logger.info("Report successfuly created");
	}

	public Instance getStringInstancefromFeatureSequenceInstance(Instance inst)
	{
		// Take an instance which data is a FeatureSequence and returns an instance which data is a StringBuilder
		Instance instaux = (Instance) inst.clone();
		FeatureSequence instFeat = (FeatureSequence) instaux.getData();
		String instString = instFeat.toString();
		if (instaux.isLocked())
			instaux.unLock();
		instaux.setData(instString);
		return instaux;
	}

	public TreeMap<String, Double> inferWordprob(double[] topicDistribution, Alphabet specdataAlphabet)
	{
		// Calculates the probability of each word in the specdataAlphabet to belong to the instIndex Instance of the
		// inferInst InstanceList.
		// A sorted TreeMap with all the words and the infered probabilities is returned
		// Takes any alphabet to compute the word probability

		Alphabet dataAlphabet = instances.getDataAlphabet(); // Full data alphabet

		// Get an array of sorted sets of word ID/count pairs
		ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();
		// System.out.println(dataAlphabet.size());
		HashMap<String, Double> wordMap = new HashMap<String, Double>(dataAlphabet.size());
		ValueComparator bvc = new ValueComparator(wordMap);
		TreeMap<String, Double> sorted_map = new TreeMap(bvc);
		double wordProb;
		String word;
		// Show top numwords words in topics with proportions for the instIndex document
		for (int topic = 0; topic < numTopics; topic++)
		{

			Iterator<IDSorter> iterator = topicSortedWords.get(topic).iterator();

			double topicProb = topicDistribution[topic];
			double sum = 0;
			// System.out.println(topicDistribution.length + "\t"+topicProb);
			IDSorter idCountPair;
			while (iterator.hasNext())
			{
				idCountPair = iterator.next();
				word = (String) dataAlphabet.lookupObject(idCountPair.getID());
				if (specdataAlphabet.contains(word))
					sum = sum + idCountPair.getWeight();
			}
			Iterator<IDSorter> iterator2 = topicSortedWords.get(topic).iterator();
			// System.out.println("Size of Topic Sorted words :"+topicSortedWords.get(topic).size());
			while (iterator2.hasNext())
			{
				idCountPair = iterator2.next();
				wordProb = topicProb * (idCountPair.getWeight() / sum);
				// System.out.println(wordProb);
				word = (String) dataAlphabet.lookupObject(idCountPair.getID());
				if (specdataAlphabet.contains(word))
				{
					if (wordMap.containsKey(word))
					{
						wordMap.put(word, new Double((Double) wordMap.get(word) + wordProb));
					}
					else
					{
						wordMap.put(word, new Double(wordProb));
					}
				}
			}
		}
		// logger.debug("Size of wordMap in inferWord: "+ wordMap.size());
		sorted_map.putAll(wordMap);
		// logger.debug("Size of sorted_map in inferWord: "+ wordMap.size());
		return sorted_map;
	}

	public HashMap<String, Double> inferWordprob(double[] topicDistribution, Alphabet specdataAlphabet, boolean tag)
	{
		// Calculates the probability of each word in the specdataAlphabet to belong to the instIndex Instance of the
		// inferInst InstanceList.
		// A sorted TreeMap with all the words and the infered probabilities is returned
		// Takes any alphabet to compute the word probability

		Alphabet dataAlphabet = instances.getDataAlphabet(); // Full data alphabet

		// Get an array of sorted sets of word ID/count pairs
		ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();
		// logger.debug(dataAlphabet.size());
		HashMap<String, Double> wordMap = new HashMap<String, Double>(dataAlphabet.size());
		// ValueComparator bvc = new ValueComparator(wordMap);
		// TreeMap<String,Double> sorted_map = new TreeMap(bvc);
		double wordProb;
		String word;
		// Show top numwords words in topics with proportions for the instIndex document
		for (int topic = 0; topic < numTopics; topic++)
		{

			Iterator<IDSorter> iterator = topicSortedWords.get(topic).iterator();

			double topicProb = topicDistribution[topic];
			double sum = 0;
			// logger.debug(topicDistribution.length + "\t"+topicProb);
			IDSorter idCountPair;
			while (iterator.hasNext())
			{
				idCountPair = iterator.next();
				word = (String) dataAlphabet.lookupObject(idCountPair.getID());
				if (specdataAlphabet.contains(word))
					sum = sum + idCountPair.getWeight();
			}
			Iterator<IDSorter> iterator2 = topicSortedWords.get(topic).iterator();
			// logger.debug("Size of Topic Sorted words :"+topicSortedWords.get(topic).size());
			while (iterator2.hasNext())
			{
				idCountPair = iterator2.next();
				wordProb = topicProb * (idCountPair.getWeight() / sum);
				// logger.debug(wordProb);
				word = (String) dataAlphabet.lookupObject(idCountPair.getID());
				// logger.info("Word in mallet topic: "+ word);
				if (specdataAlphabet.contains(word))
				{
					if (wordMap.containsKey(word))
					{
						wordMap.put(word, new Double((Double) wordMap.get(word) + wordProb));
					}
					else
					{
						wordMap.put(word, new Double(wordProb));
					}
				}
			}
		}

		return wordMap;
	}

	public TreeMap<String, Double> inferWordprob(InstanceList inferInst, int instIndex)
	{
		// Calculates the probability of each word in the full alphabet to belong to the instIndex Instance of the
		// inferInst InstanceList.
		// A sorted TreeMap with all the words and the infered probabilities is returned
		Alphabet dataAlphabet = instances.getDataAlphabet();
		// logger.debug("Alphabet size "+dataAlphabet.size());
		TreeMap<String, Double> sorted_map;
		sorted_map = this.inferWordprob(inferInst, instIndex, dataAlphabet);

		return sorted_map;
	}

	public HashMap<String, Double> inferWordprob(InstanceList inferInst, int instIndex, boolean tag)
	{
		// Calculates the probability of each word in the full alphabet to belong to the instIndex Instance of the
		// inferInst InstanceList.
		// A sorted TreeMap with all the words and the infered probabilities is returned
		Alphabet dataAlphabet = instances.getDataAlphabet();
		logger.info("Alphabet size " + dataAlphabet.size());
		HashMap<String, Double> map;
		map = this.inferWordprob(inferInst, instIndex, dataAlphabet, true);

		return map;
	}

	public TreeMap<String, Double> inferWordprob(InstanceList inferInst, int instIndex, Alphabet specdataAlphabet)
	{
		// Calculates the probability of each word in the specdataAlphabet to belong to the instIndex Instance of the
		// inferInst InstanceList.
		// A sorted TreeMap with all the words and the infered probabilities is returned
		// Takes any alphabet to compute the word probability

		double[] topicDistribution = this.InferFromTestInstance(inferInst, instIndex);
		TreeMap<String, Double> sorted_map;
		sorted_map = this.inferWordprob(topicDistribution, specdataAlphabet);

		return sorted_map;
	}

	public HashMap<String, Double> inferWordprob(InstanceList inferInst, int instIndex, Alphabet specdataAlphabet, boolean flag)
	{
		// Calculates the probability of each word in the specdataAlphabet to belong to the instIndex Instance of the
		// inferInst InstanceList.
		// A sorted TreeMap with all the words and the infered probabilities is returned
		// Takes any alphabet to compute the word probability

		double[] topicDistribution = this.InferFromTestInstance(inferInst, instIndex);
		HashMap<String, Double> map;
		map = this.inferWordprob(topicDistribution, specdataAlphabet, true);

		return map;
	}

	public void InstanceClassifier(int instIndex)
	{
		this.InstanceClassifier(instances, instIndex);
	}

	public String InstanceClassifier(InstanceList inferInst, int instIndex)
	{
		// Returns the string of the best match
		double[][] minNelem = this.InstanceClassifierMat(inferInst, instIndex);
		return this.getInstanceLabel((int) minNelem[0][0]);
	}

	public double[][] InstanceClassifierMat(InstanceList inferInst, int instIndex)
	{
		return this.InstanceClassifierMat(inferInst, instIndex, 10);
	}

	public double[][] InstanceClassifierMat(InstanceList inferInst, int instIndex, int numCateg)
	{
		// Finds the 10 closes Instances from the trained Instancelist to the Instance stored in inferInst[instIndex]
		// Returns 2D array of doubles with [index(0) or probability (1)][category rank]
		// one column for each category in the rank
		double[][] TrainedTopicDistr;
		double[] InferTopicDistr;
		double[] InstanceDiv;
		double[][] minNelem;

		double timetest1 = System.currentTimeMillis();

		// Infer Topic Distribution for instance instIndex
		InferTopicDistr = this.InferFromTestInstance(inferInst, instIndex);
		TrainedTopicDistr = this.getTrainTopicDist();
		InstanceDiv = new double[TrainedTopicDistr.length];

		// logger.debug("INFERED IN :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		// timetest1= System.currentTimeMillis();

		logger.info("Number of Instances Trained " + InstanceDiv.length);
		for (int i = 0; i < TrainedTopicDistr.length; i++)
		{
			// InstanceDiv[i] = SimilMeas.KLDiv(TrainedTopicDistr[i], InferTopicDistr);
			InstanceDiv[i] = 1 - SimilMeas.cosDist(TrainedTopicDistr[i], InferTopicDistr);
			// logger.debug(""+InstanceDiv[i]);
		}

		// logger.debug("DISTANCES CALC IN :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		// timetest1= System.currentTimeMillis();

		// Find the 6 closer instances to the one infered
		minNelem = MathUtils.minNelem(InstanceDiv, numCateg);

		// logger.debug("TOP 100 OBTAINED IN :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));

		// Print labels and values of 6 closest instances
		String labelinf = (String) inferInst.get(instIndex).getTarget();
		logger.info("Current Instance Evaluated: " + labelinf);

		// Print labels and values of 6 closest instances
		logger.info("Closest instances: ");
		// Print out first 10 elements
		for (int j = 0; j < 10; j++)
		{
			logger.info(minNelem[1][j] + "\t" + this.getInstanceLabel((int) minNelem[0][j]));
		}

		return minNelem;
	}

	// ------------ Utility Methods-------------------------------------

	public void CreateInstances(String[] directories) throws Exception
	{

		// Begin by importing documents from text to feature sequences
		ArrayList<Pipe> pipeList = this.initPipeList();

		instances = new InstanceList(new SerialPipes(pipeList));

		Reader fileReader = new InputStreamReader(new FileInputStream(new File(directories[0])), "UTF-8");
		instances.addThruPipe(new CsvIterator(fileReader, Pattern.compile("^(\\S*)[\\s,]*(\\S*)[\\s,]*(.*)$"), 3, 2, 1)); // data, label, name fields
	}

	public void CreateInstancesSEMplest(String[] directories) throws Exception
	{
		// Creates Instances from a file in SEMplest format with file containing traning data in directories[0]
		String file = ProjectProperties.smallhCounts;
		if (directories.length > 0)
			file = directories[0];
		ArrayList<String> lines = ioUtils.readFile(file);
		this.CreateInstancesSEMplest(lines);

	}

	public void CreateInstancesSEMplest(ArrayList<String> lines)
	{
		// Creates Instances from a file in SEMplest format

		// Begin by importing documents from text to feature sequences
		ArrayList<Pipe> pipeList = this.initPipeList();
		// Temporal instance were we will transform SEMplest data to Mallet data
		int i = 0;

		instances = new InstanceList(new SerialPipes(pipeList));
		logger.debug("Number of lines: " + lines.size());
		for (String line : lines)
		{
			logger.debug("Adding Category " + i);
			logger.debug(line);
			ArrayList<String> tokens = ioUtils.malletizeLine(line);
			instances.addThruPipe(new Instance(tokens.get(2), tokens.get(0), tokens.get(1), null));
			i++;
		}
	}

	public void CreateInstances(ArrayList<String> lines)
	{
		// Creates Instances from a file in SEMplest format

		// Begin by importing documents from text to feature sequences
		ArrayList<Pipe> pipeList = this.initPipeList();
		// Temporal instance were we will transform SEMplest data to Mallet data
		int i = 0;

		instances = new InstanceList(new SerialPipes(pipeList));
		// logger.debug("Number of lines: "+lines.size());
		for (String line : lines)
		{
			logger.debug("Adding Category " + i);
			// logger.info("instance line size "+ line.length());
			String[] elem = line.split(":");
			instances.addThruPipe(new Instance(elem[1], "" + i, elem[0], null));
			i++;
		}
		// logger.info("instances alphabet size: "+ instances.getAlphabet().size());
	}

	public void CreateInstances(Map<String, String> trainLines)
	{
		// Creates Instances from a file in SEMplest format

		// Begin by importing documents from text to feature sequences
		ArrayList<Pipe> pipeList = this.initPipeList();
		// Temporal instance were we will transform SEMplest data to Mallet data
		int i = 0;

		instances = new InstanceList(new SerialPipes(pipeList));
		// logger.debug("Number of lines: "+lines.size());
		for (String line : trainLines.keySet())
		{
			logger.debug("Adding Category " + i);
			instances.addThruPipe(new Instance(trainLines.get(line), "" + i, line, null));
			i++;
		}
		// logger.info("instances alphabet size: "+ instances.getAlphabet().size());
	}

	/*
	 * public void CreateInstancesSEMplestCache(String[] directories) throws Exception { // Creates Instances from a file in SEMplest format
	 * 
	 * // Begin by importing documents from text to feature sequences ArrayList<Pipe> pipeList = initPipeList(); // Temporal instance were we will
	 * transform SEMplest data to Mallet data int i=0; // Pipes: lowercase, tokenize, remove stopwords, map to features instances = new
	 * InstanceListCache (new SerialPipes(pipeList)); String file = "/semplest/data/dmoz/small/hCounts.txt"; if ( directories.length > 0 ) file =
	 * directories[0]; ArrayList<String> lines = ioUtils.readFile( file ); System.out.println("Number of lines: "+lines.size()); for( String line :
	 * lines ){ System.out.println("Adding Category " + i); ArrayList<String> tokens = ioUtils.malletizeLine( line ); instances.addThruPipe(new
	 * Instance(tokens.get(2),tokens.get(0),tokens.get(1),null)); i++; }
	 * 
	 * }
	 * 
	 * public void CreateInstancesSEMplestCache2(String[] directories) throws Exception { // Creates Instances from a file in SEMplest format uses
	 * less memory than version 1
	 * 
	 * // Begin by importing documents from text to feature sequences ArrayList<Pipe> pipeList = this.initPipeList(); // Temporal instance were we
	 * will transform SEMplest data to Mallet data int i=0;
	 * 
	 * instances = new InstanceListCache (new SerialPipes(pipeList)); String file = "/semplest/data/dmoz/small/hCounts.txt"; if ( directories.length >
	 * 0 ) file = directories[0]; InputStream fis = new FileInputStream(file); BufferedReader br = new BufferedReader(new InputStreamReader(fis,
	 * Charset.forName("UTF-8"))); String line; while ((line = br.readLine()) != null) { System.out.println("Adding Category " + i); ArrayList<String>
	 * tokens = ioUtils.malletizeLine( line ); instances.addThruPipe(new Instance(tokens.get(2),tokens.get(0),tokens.get(1),null)); i++; }
	 * 
	 * }
	 */
	/*
	 * public void CreateInstancesSEMplestCacheMultiThread(String[] directories, int numThreads) throws Exception { // Creates Instances from a file
	 * in SEMplest format using MultiThread
	 * 
	 * // Begin by importing documents from text to feature sequences ArrayList<Pipe> pipeList = initPipeList();
	 * 
	 * // Temporal instance were we will transform SEMplest data to Mallet data instances = new InstanceListCache (new SerialPipes(pipeList)); String
	 * file = "/semplest/data/dmoz/small/hCounts.txt"; if ( directories.length > 0 ) file = directories[0]; ArrayList<String> lines =
	 * ioUtils.readFile( file ); int numLinesIter = lines.size()/numThreads; // Create multiple threads to import all the lines; for( int i=0;
	 * i<numThreads; i++ ){ if( i==numThreads-1){ MalletThreadObj threadObj = new MalletThreadObj(instances, 0, i*numLinesIter,
	 * (i+1)*numLinesIter+(lines.size()%numThreads)-1, lines); new Thread(threadObj).start(); } else { MalletThreadObj threadObj = new
	 * MalletThreadObj(instances, 0, i*numLinesIter, (i+1)*numLinesIter-1, lines); new Thread(threadObj).start(); } }
	 * 
	 * }
	 */
	public Alphabet createAlphabet4instance(InstanceList instList, int instIndex)
	{
		FeatureSequence tokens = (FeatureSequence) instList.get(instIndex).getData();
		Alphabet dataAlphabet = instList.getDataAlphabet();
		String[] words = new String[tokens.getLength()];

		for (int position = 0; position < tokens.getLength(); position++)
		{
			words[position] = (String) dataAlphabet.lookupObject(tokens.getIndexAtPosition(position));
		}
		Alphabet alph = new Alphabet(words);
		/*
		 * logger.debug("Words in category "+this.getInstanceLabel(instIndex)+" : "); for (int i=0;i<words.length;i++) logger.debug(words[i]+"\t");
		 * logger.debug("\n");
		 */
		return alph;
	}

	public Alphabet add2Alphabet(Alphabet alph, InstanceList instList, int instIndex)
	{
		FeatureSequence tokens = (FeatureSequence) instList.get(instIndex).getData();
		Alphabet dataAlphabet = instList.getDataAlphabet();
		String[] words = new String[tokens.getLength()];

		for (int position = 0; position < tokens.getLength(); position++)
		{
			words[position] = (String) dataAlphabet.lookupObject(tokens.getIndexAtPosition(position));
		}
		alph.lookupIndices(words, true);
		return alph;
	}

	public void LDAcreateModel(double alpha_t, double beta_w, int numIter) throws Exception
	{
		// Create a model, for example, with numTopics topics, alpha_t = 0.01, beta_w = 0.01
		// Note that the first parameter is passed as the sum over topics, while
		// the second is the parameter for a single dimension of the Dirichlet prior.
		initalpha = alpha_t;
		initbeta = beta_w;

		int numThreads = ProjectProperties.numThreads;
		// logger.info("num Threads: " + numThreads);
		model = new ParallelTopicModel(numTopics, 1.0, 0.01);
		logger.info("Loading Instances into Model");
		// logger.info("training model instances alphabet size "+ instances.getAlphabet().size());
		model.addInstances(instances);

		// Use two parallel samplers, which each look at one half the corpus and combine
		// statistics after every iteration.
		// model.setNumThreads(numThreads);

		// Run the model for numIter iterations and stop (this is for testing only,
		// for real applications, use 1000 to 2000 iterations)
		model.setNumIterations(numIter);
		if (numThreads > 1)
			model.setNumThreads(numThreads);
		logger.info("Estimating Model...");
		model.estimate();
	}

	public double[] InferFromTestInstance(InstanceList testing, int TestIndex)
	{
		// Get the Probability Distribution for instance TestIndex in the testing InstanceList
		// Prints out the probability of the Top Topic in the distribution
		TopicInferencer inferencer = model.getInferencer();
		double[] testProbabilities = inferencer.getSampledDistribution(testing.get(TestIndex), 100, 1, 5);
		// logger.debug("0 \t" + testProbabilities[0]);
		testprobab = testProbabilities;
		return testProbabilities;
	}

	public InstanceList CreateInferInstfromFile(File testFile) throws UnsupportedEncodingException, FileNotFoundException
	{
		// Create an InstanceList from a file using same pipe than this MalletTopic to infer topic
		// probability distributions from trained topics in model.
		InstanceList testing = new InstanceList(instances.getPipe());
		Reader fileReader = new InputStreamReader(new FileInputStream(testFile), "UTF-8");
		testing.addThruPipe(new CsvIterator(fileReader, Pattern.compile("^(\\S*)[\\s,]*(\\S*)[\\s,]*(.*)$"), 3, 2, 1)); // data, label, name fields
		return testing;
	}

	public InstanceList CreateInferInstfromData(String name, String label, String data)
	{
		// Name, Label and Data defined by Mallet
		Instance instAux = new Instance(data, label, name, null);
		InstanceList testing = new InstanceList(instances.getPipe());
		testing.addThruPipe(instAux);
		return testing;

	}

	public InstanceList CreateInferInstfromTopic(int topicIndex) throws Exception
	{
		// Create a new test instance set with high probability of topic topicIndex
		ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();
		StringBuilder topicIndexText = new StringBuilder();
		Iterator<IDSorter> iterator = topicSortedWords.get(0).iterator();
		Alphabet dataAlphabet = instances.getDataAlphabet();

		int rank = 0;
		while (iterator.hasNext() && rank < 5)
		{
			IDSorter idCountPair = iterator.next();
			topicIndexText.append(dataAlphabet.lookupObject(idCountPair.getID()) + " ");
			rank++;
		}
		// Create a new instance named "test instance" with empty target and source fields.
		InstanceList testing = new InstanceList(instances.getPipe());
		testing.addThruPipe(new Instance(topicIndexText.toString(), null, "test instance", null));

		return testing;
	}

	public ArrayList<Pipe> initPipeList()
	{
		// Creates the list of pipes that will be used in all the InstanceList across the object
		ArrayList<Pipe> pipeList = new ArrayList<Pipe>();
		String stoplist = ProjectProperties.stoplist;
		// Pipes: lowercase, tokenize, remove stopwords, map to features
		pipeList.add(new CharSequenceLowercase());
		pipeList.add(new CharSequence2TokenSequence(Pattern.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")));
		pipeList.add(new TokenSequenceRemoveStopwords(new File(stoplist), "UTF-8", false, false, false));
		pipeList.add(new TokenSequence2FeatureSequence());

		return pipeList;

	}

	// ----------------------- File Managing Methods---------------------------------------------
	public void saveObject(File serializedFile, Object obj) throws IOException
	{
		// Saves the current model
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializedFile));
		oos.writeObject(obj);
		oos.close();
	}

	public Object loadObject(File serializedFile) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		// Loads the model saved in serializedFile
		Object obj = new Object();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serializedFile));
		obj = ois.readObject();
		ois.close();
		return obj;
	}

	public void saveLDAModel(File serializedFile) throws IOException
	{
		// Saves the current model
		this.saveObject(serializedFile, model);
	}

	public void saveLDAInst(File serializedFile) throws IOException
	{
		// Saves the current instances from an InstanceListCache object
		// We retrieve instances from Cache and serialize them
		this.saveObject(serializedFile, instances);
	}

	/*
	 * public void saveLDAInstCache(File serializedFile) throws IOException { //Seves current instance based on Cache implementation of
	 * InstanceListCache ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serializedFile)); for(int i=0; i<instances.size();i++){
	 * System.out.println("Saving Instance "+i); oos.writeObject(instances.get(i)); } oos.close();
	 * 
	 * }
	 */
	public void loadLDAModel(File serializedFile) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		// Loads the model saved in serializedFile
		model = (ParallelTopicModel) this.loadObject(serializedFile);
		numTopics = model.getNumTopics();
	}

	public void loadLDAInst(File serializedFile) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		// Loads the model saved in serializedFile
		instances = (InstanceList) this.loadObject(serializedFile);
	}

	/*
	 * public void loadLDAInstCache(File serializedFile) throws ClassNotFoundException { try{ //Loads current instance based on Cache implementation
	 * of InstanceListCache // Creates Instances from a file in SEMplest format
	 * 
	 * 
	 * ArrayList<Pipe> pipeList = this.initPipeList();
	 * 
	 * InstanceList instListAux = new InstanceListCache (new SerialPipes(pipeList)); instances = instListAux; Instance instAux; ObjectInputStream ois
	 * = new ObjectInputStream (new FileInputStream(serializedFile)); int i=0;
	 * 
	 * while((instAux = (Instance) ois.readObject()) != null){ instances.add(instAux); System.out.println("Loading Instance "+i); i++; } }catch
	 * (IOException ioE){ System.out.println("Instances Loaded"); }
	 * 
	 * }
	 * 
	 * public void loadLDAInstCacheMultiThread(File serializedFile) throws ClassNotFoundException { try{ //Loads current instance based on Cache
	 * implementation of InstanceListCache // Creates Instances from a file in SEMplest format ArrayList<Pipe> pipeList = this.initPipeList();
	 * 
	 * InstanceList instListAux = new InstanceListCache (new SerialPipes(pipeList)); instances = instListAux; Instance instAux; ObjectInputStream ois
	 * = new ObjectInputStream (new FileInputStream(serializedFile)); int i=0;
	 * 
	 * while((instAux = (Instance) ois.readObject()) != null){ instances.add(instAux); System.out.println("Loading Instance "+i); i++; } }catch
	 * (IOException ioE){ System.out.println("Instances Loaded"); }
	 * 
	 * }
	 */
	// --------------------- Printing methods -----------------------------------------------------
	public void LDAprintTrainedInst(int instIndex) throws Exception
	{

		// Show the words and topics in the document (instance) instIndex

		// The data alphabet maps word IDs to strings
		Alphabet dataAlphabet = instances.getDataAlphabet();

		FeatureSequence tokens = (FeatureSequence) model.getData().get(instIndex).instance.getData();
		LabelSequence topics = model.getData().get(instIndex).topicSequence;

		Formatter out = new Formatter(new StringBuilder(), Locale.US);
		for (int position = 0; position < tokens.getLength(); position++)
		{
			out.format("%s-%d ", dataAlphabet.lookupObject(tokens.getIndexAtPosition(position)), topics.getIndexAtPosition(position));
		}
		logger.info(out);

	}

	public void LDAprintTrainedInst(int[] instIndexes) throws Exception
	{
		// Shows the words and topics in between category(instance) instIndex[0] and instIndex[1]
		for (int i = 0; i < (instIndexes[1] - instIndexes[0]); i++)
			this.LDAprintTrainedInst(i + instIndexes[0]);
	}

	public void LDAprintNkeywordsperTopic(int instIndex, int numwords) throws Exception
	{
		// Shows the words and topics in category(instance) instIndex
		// Estimate the topic distribution of the instance instIndex,
		// given the current Gibbs state.
		double[] topicDistribution = model.getTopicProbabilities(instIndex);

		// Get an array of sorted sets of word ID/count pairs
		ArrayList<TreeSet<IDSorter>> topicSortedWords = model.getSortedWords();
		Formatter out = new Formatter(new StringBuilder(), Locale.US);
		Alphabet dataAlphabet = instances.getDataAlphabet();

		// Show top numwords words in topics with proportions for the instIndex document
		for (int topic = 0; topic < numTopics; topic++)
		{
			Iterator<IDSorter> iterator = topicSortedWords.get(topic).iterator();

			out = new Formatter(new StringBuilder(), Locale.US);
			out.format("%d\t%.3f\t", topic, topicDistribution[topic]);
			int rank = 0;
			while (iterator.hasNext() && rank < numwords)
			{
				IDSorter idCountPair = iterator.next();
				out.format("%s (%.0f) ", dataAlphabet.lookupObject(idCountPair.getID()), idCountPair.getWeight());
				rank++;
			}
			logger.info(out);
		}
	}

	// ***************************** MAIN ************************************************
	public static void main(String[] args) throws Exception
	{

	}

}
