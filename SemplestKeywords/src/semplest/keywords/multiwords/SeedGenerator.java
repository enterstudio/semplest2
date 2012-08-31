package semplest.keywords.multiwords;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.ioUtils;

public class SeedGenerator
{

	private static final Logger logger = Logger.getLogger(SeedGenerator.class);

	private String inFileName;
	private String outFileName;
	private String patternInCategory;

	public SeedGenerator(String in, String out, String pattern)
	{
		inFileName = in;
		outFileName = out;
		patternInCategory = pattern;
	}

	public SeedGenerator(String in, String out)
	{
		inFileName = in;
		outFileName = out;
		patternInCategory = ""; // this means all categories to be processed
	}

	public void genSeeds()
	{
		ArrayList<String> lines = ioUtils.readFile(inFileName);
		String[] webLinks;
		try
		{
			FileWriter fstream = new FileWriter(outFileName);
			BufferedWriter out = new BufferedWriter(fstream);

			if (patternInCategory.equals(""))
			{
				for (String line : lines)
				{
					line = line.replaceFirst("^\\S+ : ", "");
					webLinks = line.split("\\s+");
					for (String link : webLinks)
					{
						out.write(link + "\n");
					}
				}
			}
			else
			{
				for (String line : lines)
				{
					if (line.contains(patternInCategory))
					{
						line = line.replaceFirst("^\\S+ : ", "");
						webLinks = line.split("\\s+");
						for (String link : webLinks)
						{
							out.write(link + "\n");
						}
					}
				}
			}

			out.close();

		}
		catch (IOException e)
		{
			logger.error("Problem", e);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String category = "society";
		String inFile = "/semplest/data/dmoz/all.urls";
		String outFile = "/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/dmoz/" + category + "/urls/seed.txt";
		// String outFile = "/tmp/urls/seed.txt";

		// SeedGenerator s = new SeedGenerator(inFile,outFile);
		SeedGenerator s = new SeedGenerator(inFile, outFile, "top/" + category);
		s.genSeeds();

	}

}
