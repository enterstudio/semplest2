package semplest.keywords.classification;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import semplest.keywords.javautils.*;

//import cc.mallet.util.*;
import cc.mallet.types.*;
import cc.mallet.pipe.*;
//import cc.mallet.pipe.iterator.*;
import cc.mallet.classify.*;

public class MalletClassifier
{
	// ************Atributes ********
	private InstanceList instances;
	private NaiveBayes model;
	private NaiveBayesTrainer trainer;

	public void CreateInstancesSEMplest(String[] directories) throws Exception
	{
		// Creates Instances from a file in SEMplest format
		// Begin by importing documents from text to feature sequences
		final List<Pipe> pipeList = initPipeList();
		// Temporal instance were we will transform SEMplest data to Mallet data
		instances = new InstanceList(new SerialPipes(pipeList));
		String file = "/semplest/data/dmoz/small/hCounts.txt";
		if (directories.length > 0)
		{
			file = directories[0];
		}
		final List<String> lines = ioUtils.readFile(file);
		System.out.println("Number of lines: " + lines.size());
		for (String line : lines)
		{
			// System.out.println("Adding Category " + i);
			List<String> tokens = ioUtils.malletizeLine(line);
			instances.addThruPipe(new Instance(tokens.get(2), tokens.get(0), tokens.get(1), null));
		}
	}

	public List<Pipe> initPipeList()
	{
		// Creates the list of pipes that will be used in all the InstanceList across the object
		final List<Pipe> pipeList = new ArrayList<Pipe>();

		// Pipes: lowercase, tokenize, remove stopwords, map to features
		pipeList.add(new CharSequenceLowercase());
		pipeList.add(new CharSequence2TokenSequence(Pattern.compile("\\p{L}[\\p{L}\\p{P}]+\\p{L}")));
		pipeList.add(new TokenSequenceRemoveStopwords(new File("stoplists/en.txt"), "UTF-8", false, false, false));
		// pipeList.add( new TokenSequence2FeatureSequence());

		// Rather than storing tokens as strings, convert
		// them to integers by looking them up in an alphabet.
		pipeList.add(new TokenSequence2FeatureSequence());

		// Do the same thing for the "target" field:
		// convert a class label string to a Label object,
		// which has an index in a Label alphabet.
		pipeList.add(new Target2Label());

		// Now convert the sequence of features to a sparse vector,
		// mapping feature IDs to counts.
		pipeList.add(new FeatureSequence2FeatureVector());

		// Print out the features and the label
		// pipeList.add(new PrintInputAndTarget());

		return pipeList;
	}

	public void createModel() throws Exception
	{
		trainer = new NaiveBayesTrainer();
		System.out.println("Training Model");
		model = trainer.train(instances);
	}

	public void classify()
	{
		for (Instance I : instances)
		{
			Classification c = model.classify(I);
			System.out.println("Classification: True label: " + I.getTarget() + ", Inferred label: " + c.getLabeling().getBestLabel());
		}

	}

	// ----------------------- File Managing Methods---------------------------------------------
	public void saveObject(File serializedFile, Object obj) throws IOException
	{
		// Saves the current model
		System.out.println(serializedFile);
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

	public void saveClassifierModel(File serializedFile) throws IOException
	{
		// Saves the current model
		this.saveObject(serializedFile, model);
	}

	public void saveInst(File serializedFile) throws IOException
	{
		// Saves the current instances from an InstanceListCache object
		// We retrieve instances from Cache and serialize them
		this.saveObject(serializedFile, instances);
	}

	// --------------------------Get Attributes-------------------------------------------------------
	public InstanceList getInstanceList()
	{
		return instances;
	}
}
