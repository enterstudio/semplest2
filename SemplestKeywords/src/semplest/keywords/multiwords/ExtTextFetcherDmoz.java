package semplest.keywords.multiwords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.MultiWords;
import semplest.keywords.javautils.XmlUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.scalautils.*;

public class ExtTextFetcherDmoz
{
	private static final Logger logger = Logger.getLogger(ExtTextFetcherDmoz.class);

	private String inFileName;
	private String outFileName;
	private String patternInCategory;

	public ExtTextFetcherDmoz(String in, String out, String pattern)
	{
		inFileName = in;
		outFileName = out;
		patternInCategory = pattern;
	}

	public ExtTextFetcherDmoz(String in, String out)
	{
		inFileName = in;
		outFileName = out;
		patternInCategory = ""; // this means all categories to be processed
	}

	public void fetchMultiWords(int[] n, int minCount)
	{

		Crawler c = new Crawler();

		List<String> lines = ioUtils.readFile(inFileName);
		Set<String> tags = new HashSet<String>();
		String urls, tag;

		String[] results;

		FileWriter fstream;
		BufferedWriter out;

		FileWriter fstream2;
		BufferedWriter out2;

		List<String> list = null;

		int totalJobs, doneSoFar = 0;

		if (patternInCategory.equals(""))
		{

			for (String line : lines)
			{
				urls = line.replaceFirst("^\\S+ : ", "");
				tag = line.replaceFirst(" :.*$", "");
				tags.add(tag);
				c.add(tag, urls);
			}
		}
		else
		{
			// int k=0;
			for (String line : lines)
			{
				tag = line.replaceFirst(" :.*$", "");
				if (tag.contains(patternInCategory))
				{
					urls = line.replaceFirst("^\\S+ : ", "");
					tags.add(tag);
					c.add(tag, urls);
					// k++;
					// if(k==5)
					// break;
				}
			}
		}

		totalJobs = tags.size();

		// create and empty file
		try
		{
			File file = new File(outFileName);
			file.delete();
			file.createNewFile();

			// for text
			File fileText = new File(outFileName + ".orig");
			fileText.delete();
			fileText.createNewFile();

		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}

		// continue until all are done
		while (!tags.isEmpty())
		{
			try
			{ // try:sleep
				Thread.sleep(3000);
			}
			catch (Exception e)
			{
				logger.error("Problem", e);
			} // try: sleep

			// fetch from Worker
			results = c.fetch();
			if (results.length > 0)
			{
				System.out.println("I am happy. I found " + results.length + " results...................");

				try
				{ // try: IO
					fstream = new FileWriter(outFileName, true);
					out = new BufferedWriter(fstream);

					fstream2 = new FileWriter(outFileName + ".orig", true);
					out2 = new BufferedWriter(fstream2);

					for (int i = 0; i < results.length; i++)
					{ // for every unit of work
						// extract the tag first
						tag = results[i].replaceAll(" .*", "");
						out.write(tag);
						list = MultiWords.getMultiWords(results[i], n, minCount);
						out2.write(results[i] + "\n");
						for (int j = 0; j < n.length; j++)
						{
							out.write(" ** " + list.get(j));
						}
						out.write("\n");
						doneSoFar++;
						tags.remove(tag);
						System.out.println("MultiWordExtraction: " + doneSoFar + " out of " + totalJobs + " done so far. Waiting for " + tags.size() + " jobs to complete.");
					}
					out.close();
					out2.close();
				}
				catch (IOException e)
				{
					logger.error("Problem", e);
				} // try: IO

			}
			else
			{
				System.out.println("I am sad. I didn't find anything....... still waiting for " + tags.size() + " jobs.");
			}
		} // while

	}

	public void fetchMultiWordsSubsequent(int[] n, int minCount)
	{

		Crawler c = new Crawler();

		List<String> lines = ioUtils.readFile(inFileName);

		Set<String> tags = new HashSet<String>();

		String urls, tag;

		String[] results;

		FileWriter fstream;
		BufferedWriter out;

		FileWriter fstream2;
		BufferedWriter out2;

		List<String> doneLines = ioUtils.readFile(outFileName);
		Set<String> doneTags = new HashSet<String>();
		for (String line : doneLines)
		{
			line = line.replaceAll(" .*$", "");
			doneTags.add(line);
		}

		List<String> list = null;

		int totalJobs, doneSoFar = 0;

		if (patternInCategory.equals(""))
		{

			for (String line : lines)
			{
				urls = line.replaceFirst("^\\S+ : ", "");
				tag = line.replaceFirst(" :.*$", "");
				if (!doneTags.contains(tag))
				{
					tags.add(tag);
					c.add(tag, urls);
				}
			}
		}
		else
		{

			for (String line : lines)
			{
				tag = line.replaceFirst(" :.*$", "");
				if (tag.contains(patternInCategory))
				{
					urls = line.replaceFirst("^\\S+ : ", "");
					if (!doneTags.contains(tag))
					{
						tags.add(tag);
						c.add(tag, urls);
					}

				}
			}
		}

		totalJobs = tags.size();

		// continue until all are done
		while (!tags.isEmpty())
		{

			try
			{ // try:sleep
				Thread.sleep(3000);
			}
			catch (Exception e)
			{
				logger.error("Problem", e);
			} // try: sleep

			// fetch from Worker
			results = c.fetch();
			if (results.length > 0)
			{
				System.out.println("I am happy. I found " + results.length + " results...................");

				try
				{ // try: IO
					fstream = new FileWriter(outFileName, true);
					out = new BufferedWriter(fstream);

					fstream2 = new FileWriter(outFileName + ".orig.2", true);
					out2 = new BufferedWriter(fstream2);

					for (int i = 0; i < results.length; i++)
					{ // for every unit of work
						// extract the tag first
						tag = results[i].replaceAll(" .*", "");
						out.write(tag);
						list = MultiWords.getMultiWords(results[i], n, minCount);

						out2.write(results[i] + "\n");

						for (int j = 0; j < n.length; j++)
						{
							out.write(" ** " + list.get(j));
						}
						out.write("\n");
						doneSoFar++;
						tags.remove(tag);
						System.out.println("MultiWordExtraction: " + doneSoFar + " out of " + totalJobs + " done so far. Waiting for " + tags.size() + " jobs to complete.");
					}

					out.close();
					out2.close();

				}
				catch (IOException e)
				{
					logger.error("Problem", e);
				} // try: IO

			}
			else
			{
				System.out.println("I am sad. I didn't find anything....... still waiting for " + tags.size() + " jobs.");
			}
		} // while

	}

	public void MultiWordsNoFetch(int[] n, int minCount)
	{
		// ArrayList<String> lines = ioUtils.readFile(inFileName);
		String text = "", tag = "";
		FileWriter fstream;
		BufferedWriter out = null;
		List<String> list = null;
		int count = 0;
		try
		{ // try: IO

			fstream = new FileWriter(outFileName);
			out = new BufferedWriter(fstream);

			/*
			 * Sets up a file reader to read the file passed on the command line one character at a time
			 */
			FileReader input = new FileReader(inFileName);

			/*
			 * Filter FileReader through a Buffered read to read a line at a time
			 */
			BufferedReader bufRead = new BufferedReader(input);

			String line; // String that holds current file line
			// Read first line
			line = bufRead.readLine();
			count++;

			// Read through file one line at time. Print line # and line
			while (line != null)
			{
				if (patternInCategory.equals(""))
				{
					text = line.replaceFirst("^\\S+ : ", "");
					tag = line.replaceFirst(" :.*$", "");
				}
				else
				{
					tag = line.replaceFirst(" :.*$", "");
					if (tag.contains(patternInCategory))
					{
						text = line.replaceFirst("^\\S+ : ", "");
					}
				}
				// System.out.println(tag);
				// System.out.println(text);
				// System.out.println(text.split("\\s+").length);

				out.write(tag);
				list = MultiWords.getMultiWords(text, n, minCount);
				// System.out.println(list.size());

				for (int j = 0; j < n.length; j++)
				{
					out.write(" ** " + list.get(j));
				}
				out.write("\n");

				line = bufRead.readLine();
				count++;

				if (count % 1000 == 0)
				{
					System.out.println("Done processing " + count + " categories.");
				}
			}

			bufRead.close();

		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}
		System.out.println("Finished processing. Processed " + count + " categories.");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		int[] n = { 2, 3, 4, 5 };
		int minCount = 3;
		String category, outFile;
		String inFile;

		switch (args.length)
		{
			default:
				throw new Exception("Proper arguments are not provided!!");
			case 3:
				category = args[0];
				outFile = args[1] + "/" + category + ".txt";
				inFile = args[2];
			case 2:
				category = args[0];
				outFile = args[1] + "/" + category + ".txt";
		}

		// inFile="/semplest/data/dmoz/all.urls";
		// ExtTextFetcherDmoz fetcher = new ExtTextFetcherDmoz(inFile,outFile,"top/"+category);
		// // fetcher.fetchMultiWords(n,minCount);
		// fetcher.fetchMultiWordsSubsequent(n,minCount);
		// System.out.println("Yahoo!!! Done with all the fetching for category "+category+"!!! I am feeling great!!");

		System.out.println("Ignoring category parameter!!!");
		// inFile="/semplest/data/dmoz/all/hCounts.new";
		inFile = "/tmp/hCounts.new";
		outFile = args[1];
		ExtTextFetcherDmoz fetcher = new ExtTextFetcherDmoz(inFile, outFile, "");
		// fetcher.fetchMultiWords(n,minCount);
		// fetcher.fetchMultiWordsSubsequent(n,minCount);
		fetcher.MultiWordsNoFetch(n, minCount);
		System.out.println("Yahoo!!! Completely done!!! I am feeling great!!");

		System.exit(0);

	}

}
