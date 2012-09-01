package semplest.keywords.memorysegm;

import java.util.*;
import java.io.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.keywords.ldatest.KWGenDmozLDAdata3;

/**
 * The purpose of this class is to provide tools to split large files containing category information into smaller files that can be loaded into
 * memory in real time.
 * 
 * @author lluis
 * 
 */

public class CatSplitter implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3739542623678622166L;
	private static final Logger logger = Logger.getLogger(CatSplitter.class);
	private String[] allCats;
	private int numSubFiles;
	private String destinFolder;
	private String outputFileName;
	private String extension;

	public CatSplitter(int numSubFiles, String destinFolder, String outputFileName, String extension)
	{
		this.numSubFiles = numSubFiles;
		this.destinFolder = destinFolder;
		this.outputFileName = outputFileName;
		this.extension = extension;

	}

	public String[] getAllCats()
	{
		return allCats;
	}

	public static void saveSerializedCatSplitter(String path, CatSplitter splitter) throws FileNotFoundException, IOException
	{
		ObjectOutputStream obj_out = new ObjectOutputStream(new FileOutputStream(path));
		obj_out.writeObject(splitter);
	}

	public static CatSplitter loadSerializedCatSplitter(String path) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream obj_in = new ObjectInputStream(new FileInputStream(path));
		return (CatSplitter) obj_in.readObject();
	}

	public void loadAllCats(String inputFile) throws FileNotFoundException
	{
		List<String> allCatsList = new ArrayList<String>();
		Scanner sc = new Scanner(new FileInputStream(inputFile));
		logger.info("loading all categories...");
		long start = System.currentTimeMillis();
		while (sc.hasNext())
		{
			String[] split = sc.nextLine().split(":");
			if (split[0].indexOf("top/") == 0)
			{
				allCatsList.add(split[0]);
			}
		}
		allCats = allCatsList.toArray(new String[allCatsList.size()]);
		Arrays.sort(allCats);
		logger.info("time to load categories : " + (System.currentTimeMillis() - start) + " msec");
	}

	private PrintStream[] openAllOutputFiles() throws FileNotFoundException
	{
		PrintStream[] outputs = new PrintStream[numSubFiles];
		for (int i = 0; i < outputs.length; i++)
		{
			outputs[i] = new PrintStream(new FileOutputStream(destinFolder + outputFileName + "_" + i + extension));
		}
		return outputs;
	}

	private void closeAllOutputFiles(PrintStream[] outputs)
	{
		for (PrintStream output : outputs)
		{
			output.close();
		}
	}

	public void splitCatFile(String inputFile) throws FileNotFoundException
	{
		String line, cat;
		String[] split;
		PrintStream[] outputs = openAllOutputFiles();

		Scanner sc = new Scanner(new FileInputStream(inputFile));
		if (allCats == null)
		{
			loadAllCats(inputFile);
		}
		int catsPerFile = (int) Math.ceil(1.0 * allCats.length / numSubFiles);
		// Read line by line
		logger.info("generating subfiles...");
		long start = System.currentTimeMillis();
		while (sc.hasNext())
		{
			line = sc.nextLine();
			split = line.split(":");
			cat = split[0].trim();
			if (split[0].indexOf("top/") == 0)
			{
				// Find index of category
				int index = Arrays.binarySearch(allCats, cat);
				if (index >= 0)
				{
					PrintStream output = outputs[index / catsPerFile];
					output.println(line);
				}
			}
		}
		logger.info("time to generate subfiles : " + (System.currentTimeMillis() - start) + " msec");
		closeAllOutputFiles(outputs);
	}

	public List<String> getCatData(List<String> categories) throws FileNotFoundException
	{
		logger.info("retrieving category information from files...");
		long start = System.currentTimeMillis();
		int catsPerFile = (int) Math.ceil(1.0 * allCats.length / numSubFiles);
		List<String> outData = new ArrayList<String>(categories.size());
		Map<Integer, Set<String>> indexCatMap = new HashMap<Integer, Set<String>>(numSubFiles);
		for (String cat : categories)
		{
			int indexCat = Arrays.binarySearch(allCats, cat);
			Integer indexFile = indexCat / catsPerFile;
			if (indexCatMap.containsKey(indexFile))
			{
				indexCatMap.get(indexFile).add(cat);
			}
			else
			{
				HashSet<String> aux = new HashSet<String>();
				aux.add(cat);
				indexCatMap.put(indexFile, aux);
			}
		}
		Set<Integer> keySet = indexCatMap.keySet();
		for (int key : keySet)
		{
			Set<String> catSet = indexCatMap.get(key);
			String line, cat;
			String[] split;
			Scanner sc = new Scanner(new FileInputStream(destinFolder + outputFileName + "_" + key + extension));
			while (sc.hasNext())
			{
				line = sc.nextLine();
				split = line.split(":");
				cat = split[0].trim();
				if (catSet.contains(cat))
				{
					outData.add(line);
				}
			}
			sc.close();
		}
		logger.info("time to retrieve " + outData.size() + " categories : " + (System.currentTimeMillis() - start) + "msec");
		return outData;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////

	public void splitCatFile2HashMap(String inputFile, int catsPerFile) throws FileNotFoundException
	{
		Map<String, String> cat2fileMap = new HashMap<String, String>();
		Scanner sc = new Scanner(new FileInputStream(inputFile));
		int catCount = 0;
		int fileCount = 0;
		String outputFile = destinFolder + outputFileName + fileCount + extension;
		PrintStream outputStream = new PrintStream(new FileOutputStream(outputFile));
		logger.info("Generating file: " + outputFile);
		// Read line by line
		logger.info("Creating hashmap...");
		long start = System.currentTimeMillis();
		while (sc.hasNext())
		{
			String line = sc.nextLine();
			String[] split = line.split(":");
			String cat = split[0].trim();
			// Create category if it does not exist in map
			if (!cat2fileMap.containsKey(cat))
			{
				if (catCount >= catsPerFile)
				{
					// If # of categories per file exceeded, create a new file
					fileCount++;
					outputFile = destinFolder + outputFileName + "_" + fileCount + ".txt";
					outputStream = new PrintStream(new FileOutputStream(destinFolder + outputFileName + fileCount + ".txt"));
					logger.info("Generating file: " + outputFile);
					catCount = 0;
				}
				outputStream.println(line);
				cat2fileMap.put(cat, outputFile);
				catCount++;
			}
			else
			{
				logger.info(line);
			}
		}
		logger.info("time to create hashmap : " + (System.currentTimeMillis() - start));

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int[] randIndexArray(int sizeOut, int maxNum)
	{
		int[] ret = new int[sizeOut];
		for (int i = 0; i < sizeOut; i++)
		{
			ret[i] = (int) (Math.random() * (maxNum - 1));
		}
		return ret;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
			String[] subCats = { "arts" };// ,"business", "computers","games", "health", "home", "news", "recreation",
			// "regional", "reference", "science","society", "shopping","sports"};
			// BasicConfigurator.configure();
			for (String subCat : subCats)
			{
				System.out.println("PROCESSING: " + subCat);
				CatSplitter splitter = new CatSplitter(3000, "/home/lluis/Documents/splitTest/" + subCat + "/", subCat, ".2.txt");
				splitter.splitCatFile("/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/" + subCat + ".2");
				// splitter.splitCatFile2HashMap("/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/business.2", "/home/lluis/Documents/splitTest/",
				// "business",".2.txt",100);
				saveSerializedCatSplitter("/home/lluis/Documents/splitTest/" + subCat + "/" + subCat + ".spl", splitter);
				/*
				 * long start = System.currentTimeMillis(); CatSplitter splitter2 =
				 * CatSplitter.loadSerializedCatSplitter("/home/lluis/Documents/splitTest/arts.spl"); String[] cats = splitter2.getAllCats();
				 * System.out.println("Time to load serialized : "+(System.currentTimeMillis()-start)+"msec"); int[] randInd = randIndexArray(1000,
				 * cats.length); ArrayList<String> categories = new ArrayList<String>(); for(int i: randInd){ categories.add(cats[i]); }
				 * splitter2.getCatData(categories);
				 */
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("Problem", e);
		}

	}
}
