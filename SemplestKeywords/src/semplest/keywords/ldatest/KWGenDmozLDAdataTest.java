package semplest.keywords.ldatest;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.properties.ProjectProperties;

public class KWGenDmozLDAdataTest implements Runnable
{

	private static final Logger logger = Logger.getLogger(KWGenDmozLDAdataTest.class);
	public DmozLucene dl; // Index of categories
	public HashMap<String, String> TrainingData;
	public dictUtils dict;
	private static String dfile = ProjectProperties.dfile;
	private static String baseMultiWPath = ProjectProperties.baseMultiWPath;
	public MultiWordCollect biGrams; // Collection of bigrams for each subcategory sorted by categories
	public MultiWordCollect triGrams; // Collection of trigrams for each subcategory sorted by categories
	private static String[] nGramsSubC = ProjectProperties.nGramsSubC;
	private static String nGramsC = ProjectProperties.nGramsC;
	public static ProjectProperties pr;

	public KWGenDmozLDAdataTest() throws IOException
	{
		/*
		 * //Load property file if necessary for paths if(SEMplestService.properties==null){ String PROPSFILE =
		 * "../SemplestServices/bin/system.properties"; SEMplestService.properties = new Properties(); FileInputStream is = new
		 * FileInputStream(PROPSFILE); SEMplestService.properties.load(is); is.close(); }
		 * 
		 * dfile = SEMplestService.properties.getProperty("data.dmoz.all.alldesc");
		 */
		try
		{
			pr = new ProjectProperties();
			logger.info("create DmozLucene()");
			dl = new DmozLucene();
			logger.info("Indexing dmoz description data...");
			DmozLucene.loadDesc(dl, dfile);
			logger.info("Data indexed!");

			logger.info("Loading training data...");
			TrainingData = ioUtils.file2Hash(dfile);
			logger.info("Data loaded");

			logger.info("Loading stem dictionary...");
			dict = new dictUtils();
			logger.info("Dictionary loaded");

			logger.info("Loading Bigrams for each subcategory");
			String biPath = baseMultiWPath + nGramsC + ".txt.2";
			logger.info("Loading" + biPath);
			biGrams = new MultiWordCollect(nGramsC, biPath);

			logger.info("Loading Trigrams for each subcategory");
			String triPath = baseMultiWPath + nGramsC + ".txt.3";
			logger.info("Loading" + triPath);
			triGrams = new MultiWordCollect(nGramsC, triPath);

		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			throw new IOException(e.getMessage(), e);
		}

	}

	public int getnGramSubCatInd(String categ)
	{
		// Return index of the subcategory containing the category inspected
		for (int i = 0; i < nGramsSubC.length; i++)
		{
			if (catUtils.take(categ, 2).contains(nGramsSubC[i]))
				return i;
		}
		return -1;
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(0);
		}
		catch (InterruptedException e)
		{
			logger.error("Problem", e);
		}
	}
}
