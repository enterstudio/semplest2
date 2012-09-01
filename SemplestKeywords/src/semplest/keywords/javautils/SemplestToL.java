// written by: Subhojit Som (subhojit@semplest.com)

package semplest.keywords.javautils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

public class SemplestToL
{

	private static final Logger logger = Logger.getLogger(SemplestToL.class);

	/**
	 * Converts semplest format data to LDA format data.
	 * 
	 * @param inFile
	 *          input filename with semplest format data
	 * @param outFile
	 *          output filename where the LDA format data will be written
	 * @param vocabFile
	 *          vocabulary filename
	 * @param startIdx
	 *          index of the first word in the LDA format file (e.g., 0 or 1)
	 */
	public static void convert(String inFile, String outFile, String vocabFile, int startIdx)
	{
		int idx = startIdx;
		List<String> lines = ioUtils.readFile(inFile);
		Map<String, Integer> hashWords = new HashMap<String, Integer>();

		// LDA format word count write
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
			String pattern1 = "\\S+(.*)";
			String pattern2 = "\\s+";

			for (String line : lines)
			{
				// System.out.println(line);
				String dataOnly = line.replaceAll(pattern1, "$1");
				// System.out.println(dataOnly);
				dataOnly = dataOnly.replaceAll("^\\s+", "");
				String[] splitData = dataOnly.split(pattern2);
				// System.out.println(splitData.length+splitData[1]);
				for (int i = 0; i < splitData.length; i++)
				{
					// System.out.println(splitData[i]);
					String[] tuple = splitData[i].split(":");
					// System.out.println(tuple.length);

					Integer value = hashWords.get(tuple[0]);
					// System.out.println(tuple[0]+" "+tuple[1]);

					if (value == null)
					{
						value = new Integer(idx);
						idx++;
						hashWords.put(tuple[0], value);
					}
					out.write(value + ":" + tuple[1] + " ");
				}
				out.write("\n");
			}
			out.close();
		}
		catch (IOException e)
		{
			logger.error("Problem", e);
			System.out.println("File write error!!");
		}

		// vocabulary file write
		Set<String> wordSet = hashWords.keySet();
		String[] wordList = new String[hashWords.size()];
		for (String s : wordSet)
		{
			wordList[hashWords.get(s) - startIdx] = s;
		}
		try
		{
			BufferedWriter vocab = new BufferedWriter(new FileWriter(vocabFile));
			for (int i = 0; i < wordList.length; i++)
			{
				vocab.write(wordList[i] + "\n");
			}
			vocab.close();
		}
		catch (IOException e)
		{
			logger.error("Problem", e);
			System.out.println("File write error!!");
		}
		System.out.println("Successfully converted data. \nNumber of documents processed: " + lines.size() + "\nNumber of unique words found: " + (idx - 1));
	}

	public static void main(String[] args)
	{
		String inFile, outFile, vocabFile;
		int startIdx = 1;
		
		if (args.length == 0)
		{
			inFile = new String("/semplest/data/dmoz/business/hCounts.txt");
		}
		else
		{
			inFile = args[0];
		}
		
		if (args.length == 2)
		{
			outFile = args[1];
		}
		else
		{
			outFile = inFile + ".l";
		}
		
		if (args.length == 3)
		{
			vocabFile = args[2];
		}
		else
		{
			vocabFile = inFile + ".vocab";
		}
		SemplestToL.convert(inFile, outFile, vocabFile, startIdx);
	}
}
