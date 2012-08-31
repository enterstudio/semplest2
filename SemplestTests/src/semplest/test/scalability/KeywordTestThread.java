package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.test.scalability.EsbTestThread.SERVICE_INDEX;

public class KeywordTestThread implements Runnable
{

	private int sleep_time;
	private FileWriter writer;
	private static String testName = "KEYWORD";
	private HashMap<String, String> wordList;
	// boolean noError = true;

	// private static String testUrl = "http://172.18.9.26:9898/semplest"; //EXP
	// private static String testUrl = "http://VMDEVJAVA1:9898/semplest"; //DEV
	private static String testUrl = "http://NY-semplestDev2:9898/semplest"; // UAT

	public KeywordTestThread(int test_frequency)
	{
		super();
		this.sleep_time = 60000 / test_frequency;

		try
		{
			String reportName = "Test_Scalability_" + testName + "_" + System.currentTimeMillis() + ".csv";
			String reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName;
			// String reportPath = "/semplest/TestReports/ScalabilityTest/" + reportName;

			writer = new FileWriter(reportPath);

			writer.append("Start Date: " + new Date());
			writer.append(',');
			writer.append("Test Frequency: " + test_frequency);
			writer.append('\n');

			writer.append("timestamp");
			writer.append(',');
			writer.append("keyword");
			writer.append(',');
			writer.append("time getCatetories");
			writer.append(',');
			writer.append("num Catetories");
			writer.append(',');
			writer.append("Catetory");
			writer.append(',');
			writer.append("time getKeywords");
			writer.append(',');
			writer.append("num Keywords");
			writer.append(',');
			writer.append("Keywords (#0 | #1 | #2 | #last)");
			writer.append('\n');

			writer.flush();

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		try
		{
			init_wordList();
			int nWord = 0;

			while (true)
			{
				// while(noError){
				try
				{

					KeywordLDAServiceClient client = new KeywordLDAServiceClient(testUrl);

					Date now = new Date();
					writer.append(now.toString());
					writer.append(',');
					writer.flush();

					// Random Keyword
					// Random r = new Random();
					// nWord = r.nextInt(wordList.size());

					int numKeywords = wordList.keySet().size();
					String[] keywords = new String[numKeywords];
					wordList.keySet().toArray(keywords);
					String k = keywords[nWord];
					String url = wordList.get(k);

					// Round robin keywords
					if (++nWord > (numKeywords - 1))
						nWord = 0;

					writer.append(k);
					writer.append(',');
					writer.flush();

					long start = System.currentTimeMillis();
					ArrayList<String> res = client.getCategories(null, k, k, null, null);
					long latency = System.currentTimeMillis() - start;

					writer.append(String.valueOf(latency));
					writer.append(',');
					writer.append(String.valueOf(res.size()));

					ArrayList<String> selectCateg = new ArrayList<String>();

					// select 5 categories
					selectCateg.add(res.get(1));
					selectCateg.add(res.get(2));
					selectCateg.add(res.get(3));
					selectCateg.add(res.get(4));
					selectCateg.add(res.get(5));

					writer.append(',');
					writer.append(res.get(1) + "; " + res.get(2) + "; " + res.get(3) + "; " + res.get(4) + "; " + res.get(5));
					writer.append(',');
					writer.flush();

					start = System.currentTimeMillis();

					KeywordProbabilityObject[] kw = client.getKeywords(selectCateg, null, new String[] { "Google", "MSN" }, k, k, null, url, null, new Integer[] { 300, 300, 100 });
					/*
					 * KeywordProbabilityObject[] kw = client.getKeywords(selectCateg,null, new String[] {"Google", "MSN"}, k, k, null, url, null ,new
					 * Integer[]{50,50});
					 */
					latency = System.currentTimeMillis() - start;

					writer.append(String.valueOf(latency));
					writer.append(',');
					writer.append(String.valueOf(kw.length));
					writer.append(',');
					writer.append(kw[0].getKeyword() + " | " + kw[1].getKeyword() + " | " + kw[2].getKeyword() + " | " + kw[kw.length - 1].getKeyword());
					writer.append('\n');
					writer.flush();

					Thread.sleep(sleep_time);
				}
				catch (Exception e)
				{
					e.printStackTrace();

					try
					{
						writer.append("ERROR:");
						writer.append(',');
						Date now = new Date();
						writer.append(now.toString());
						writer.append(',');
						writer.append(e.getMessage());
						writer.append(',');

						// /*
						writer.append("DETAILS:");
						writer.append(',');
						StackTraceElement[] ste = e.getStackTrace();
						for (StackTraceElement s : ste)
						{
							writer.append(s.getClassName());
							writer.append(':');
							writer.append(s.getMethodName());
							writer.append(':');
							writer.append(String.valueOf(s.getLineNumber()));
							writer.append(',');
						}
						// */
						writer.append('\n');
						writer.flush();

						// noError = false;
						Thread.sleep(sleep_time);
					}
					catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void init_wordList()
	{
		wordList = new HashMap<String, String>();
		wordList.put("wedding flower", "http://www.theknot.com");
		// wordList.put("peanut butter", "http://peanutbutterlovers.com/");
		wordList.put("flat shoes", "http://www.6pm.com");
		wordList.put("black mascara", "http://www.lancome.com/");
		wordList.put("white handbag", "http://www.bloomingdales.com/");
		wordList.put("coffee maker", "http://www.wholelattelove.com");
		wordList.put("science fiction", "http://www.barnesandnoble.com/");
		wordList.put("cranberry cheesecake", "http://www.juniorscheesecake.com/");
		wordList.put("prom dress", "http://www.promgirl.com/");
		wordList.put("hiking gear", "http://www.rei.com/");
	}

}
