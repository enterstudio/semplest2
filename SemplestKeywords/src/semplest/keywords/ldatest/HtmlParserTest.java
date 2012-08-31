package semplest.keywords.ldatest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

import org.apache.log4j.Logger;
import org.htmlparser.util.ParserException;

import semplest.keywords.javautils.*;
import semplest.keywords.lda.KWGenDmozLDAServer2;

public class HtmlParserTest
{
	static PrintStream pr;
	private static final Logger logger = Logger.getLogger(HtmlParserTest.class);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		// test.printDOM("http://susansilverantiques.com/");
		String inurl = "http://www.hrblock.com/";
		// viewTagInfo(inurl, "b");
		recordData(inurl);
		/*
		 * HashMap<String, ArrayList<String>> data= readData("/semplest/lluis/keywordExp/urldata.txt"); HashMap<String, Double> wCount =
		 * getWordCount(data); sortAndPrintMap(wCount);
		 */

	}

	public static void sortAndPrintMap(HashMap<String, Double> map) throws FileNotFoundException
	{
		// pr = new PrintStream(new FileOutputStream("/semplest/lluis/keywordExp/wordmap.txt"));
		pr = System.out;
		ValueComparator bvc = new ValueComparator(map);
		TreeMap<String, Double> sorted = new TreeMap<String, Double>(bvc);
		sorted.putAll(map);
		for (String key : sorted.keySet())
		{
			pr.println(key + " : " + map.get(key));
		}
		System.out.println("Number of words : " + map.size());
	}

	public static HashMap<String, Double> getWordCount(HashMap<String, ArrayList<String>> data)
	{
		HashMap<String, Double> wordMap = new HashMap<String, Double>();
		for (String url : data.keySet())
		{
			for (String line : data.get(url))
			{
				line = line.toLowerCase();
				line = line.replaceAll("\\p{Punct}", " ");
				line = line.replaceAll("[0-9]+", "");
				String[] words = line.split("\\s+");
				for (String word : words)
				{
					if (wordMap.containsKey(word))
					{
						wordMap.put(word, wordMap.get(word) + 1);
					}
					else
					{
						wordMap.put(word, new Double(0.0));
					}
				}
			}
		}

		return wordMap;
	}

	public static void printRawHTML(String urlS) throws Exception
	{

		URL url = new URL(urlS);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null)
		{
			System.out.println(line);
		}

		/*
		 * HTMLEditorKit htmlKit = new HTMLEditorKit();
		 * 
		 * //Only start from body HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument(); htmlDoc.dump(System.out);
		 */
	}

	public static HashMap<String, ArrayList<String>> readData(String path) throws FileNotFoundException
	{
		HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
		Scanner sc = new Scanner(new FileInputStream(path));
		String latestUrl = new String();
		while (sc.hasNext())
		{
			String line = sc.nextLine();
			if (line.indexOf("http") == 0)
			{
				latestUrl = line;
				data.put(line, new ArrayList<String>());
			}
			else
			{
				data.get(latestUrl).add(line);
			}
		}
		return data;
	}

	public static void recordData(String inurl) throws Exception
	{
		// pr = new PrintStream(new FileOutputStream("http://en.wikipedia.org/wiki/HAProxy"));
		pr = System.out;
		long start = System.currentTimeMillis();
		pr.println(inurl + "****************************************************************");
		printList(cleanUrlText(TextUtils.HTMLText(inurl)));
		String urls = TextUtils.HTMLLinkString(inurl, inurl);
		String[] url = urls.split("\\s+");
		HashSet<String> urlMap = new HashSet<String>(url.length);
		urlMap.add(inurl);
		for (String ur : url)
		{
			/*
			 * if(!urlMap.contains(ur)){ pr.println(ur+"***************************************************************"); try{
			 * printList(cleanUrlText(TextUtils.HTMLText(ur))); }catch(Exception e){ System.out.println("Error with url :"+ ur); e.printStackTrace();
			 * } urlMap.add(ur); }
			 */
		}
		pr.println("Time elapsed" + (start - System.currentTimeMillis()));
		pr.close();
	}

	public static void viewTagInfo(String inurl, String tag) throws Exception
	{
		// pr = new PrintStream(new FileOutputStream("/semplest/lluis/keywordExp/urldata.txt"));
		pr = System.out;
		long start = System.currentTimeMillis();
		pr.println(inurl + "****************************************************************");
		printList(cleanUrlText(TextUtils.HTMLText(inurl, tag)));
		String urls = TextUtils.HTMLLinkString(inurl, inurl);
		String[] url = urls.split("\\s+");
		HashSet<String> urlMap = new HashSet<String>(url.length);
		urlMap.add(inurl);
		for (String ur : url)
		{
			if (!urlMap.contains(ur))
			{
				pr.println(ur + "***************************************************************");
				try
				{
					printList(cleanUrlText(TextUtils.HTMLText(ur, tag)));
				}
				catch (Exception e)
				{
					System.out.println("Error with url :" + ur);
					e.printStackTrace();
					logger.error("Problem", e);
				}
				urlMap.add(ur);
			}
		}
		pr.println("Time elapsed" + (start - System.currentTimeMillis()));

	}

	public static ArrayList<String> cleanUrlText(String in)
	{
		ArrayList<String> out = new ArrayList<String>();
		String[] split = in.split("\\n");
		for (String line : split)
		{
			line = line.trim();
			if (!line.isEmpty())
			{
				out.add(line);
			}
		}
		return out;
	}

	public static void printList(List<String> in)
	{
		for (String el : in)
		{
			pr.println(el);
		}
	}

}
