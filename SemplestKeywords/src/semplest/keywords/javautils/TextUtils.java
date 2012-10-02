package semplest.keywords.javautils;

import org.htmlparser.Parser;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.beans.StringBean;
import org.htmlparser.beans.LinkBean;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;
import org.htmlparser.filters.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class TextUtils
{

	private static final Logger logger = Logger.getLogger(TextUtils.class);
	public static final Set<String> sw = StopWordSet();
	public static final String commonWordString = ",&,a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,de,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,la,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,pdf,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your,";
	public static final String GSUrl = "http://www.google.com/search?q=";
	public static final String GJSUrl = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";

	// HTML parsing utilities ---------------------
	// ------------------
	// recursively collect nodes that match filter
	private static NodeList getNodes(Node n, NodeFilter filter) throws ParserException
	{
		NodeList list = new NodeList();
		n.collectInto(list, filter);
		NodeList c = n.getChildren();
		if (null != c)
		{
			for (NodeIterator e = c.elements(); e.hasMoreNodes();)
			{
				e.nextNode().collectInto(list, filter);
			}
		}
		return list;
	}

	// Returns a fully formed url
	public static String formURL(String url)
	{
		String newurl;
		if (url.contains("http://") || url.contains("https://"))
		{
			newurl = url;
		}
		else
		{
			newurl = "http://" + url;
		}
		return newurl;
	}

	// Return a list/Array of text strings from a web-page inside tag "filter"
	public static List<String> getLinks(String url, NodeFilter filter) throws ParserException
	{
		Parser parser = getParser(url);
		NodeList list = new NodeList();
		for (NodeIterator e = parser.elements(); e.hasMoreNodes();)
		{
			list.add(getNodes(e.nextNode(), filter));
		}
		List<String> strings = new ArrayList<String>();
		for (NodeIterator i = list.elements(); i.hasMoreNodes();)
		{
			Node n = i.nextNode();
			if (n instanceof LinkTag)
			{ // text
				String link = ((LinkTag) n).extractLink();
				if (!strings.contains(link))
				{
					strings.add(((LinkTag) n).extractLink());
				}
			}
		}
		return strings;
	}

	// Create a node filter
	public static NodeFilter makeFilter()
	{
		NodeFilter[] fa = new NodeFilter[3];
		fa[0] = new HasAttributeFilter("HREF");
		fa[1] = new TagNameFilter("A");
		fa[2] = new HasParentFilter(new TagNameFilter("H3"));
		NodeFilter filter = new AndFilter(fa);
		return filter;
	}

	// ----------------------- Stemming ----------------------------------
	public static Set<String> StopWordSet()
	{
		String[] stopWordArray = commonWordString.split(",");
		Set<String> swSet = new HashSet<String>(Arrays.asList(stopWordArray));
		return swSet;
	}

	// Stem a word eliminating stop words from list
	public static String stemNSW(String word)
	{
		return isNSW(getRoot(word.toLowerCase()));
	}

	// give the stem of a word (may not be valid English word)
	public static String getRoot(String word)
	{
		return (new Stemmer()).stem(word);
	}

	// Return word if is not stop word or empty array if it is
	public static String isNSW(String word)
	{
		if (sw.contains(word))
		{
			return "";
		}
		return word;
	}

	// - Google Utilities ----------------------------------
	public static String[] gsUrls(String sstring) throws Exception
	{
		return gsData(sstring, "url");
	}

	// field can be one of {"url","title","content"}
	public static String[] gsData(String sstring, String field) throws Exception
	{
		URL url = new URL(GJSUrl + sstring.replaceAll("\\s+", "+"));
		URLConnection c = url.openConnection();
		BufferedReader r = new BufferedReader(new InputStreamReader(c.getInputStream()));
		String l, rs = "";
		while ((l = r.readLine()) != null)
		{
			rs = rs + l;
		}
		JSONObject json = (JSONObject) (new JSONParser()).parse(rs);
		JSONObject resp = (JSONObject) json.get("responseData");
		JSONArray ja = (JSONArray) resp.get("results");
		String[] surls = new String[ja.size()];
		for (int i = 0; i < ja.size(); i++)
		{
			surls[i] = getText((String) (((JSONObject) ja.get(i)).get(field)));
		}
		return surls;
	}

	// Get text from google page from a google search term
	public static String gsText(String sstring) throws Exception
	{
		String res = "";
		for (String s : gsUrls(sstring))
		{
			res = res + HTMLText(s) + " ";
		}
		return res;
	}

	// ----------------------------
	// recursively process nodes and get text(top level is <html>)
	private static List<String> getText(Node n, String filter) throws ParserException
	{
		List<String> strArray = new ArrayList<String>();
		String parentTag = "";
		TagNode parent = (TagNode) n.getParent();
		if (parent != null)
		{
			parentTag = parent.getTagName();
		}
		if (n instanceof TextNode)
		{ // text
			TextNode tn = (TextNode) n;
			System.out.println(parentTag + ":" + tn.getText().trim());
			System.out.println(((TagNode) n).getTagName());
			if (filter.equals("") || filter.equalsIgnoreCase(parentTag))
			{
				String text = tn.getText().trim();
				text = text.replace("&nbsp;", " "); // remove non-breaking spaces
				if (text.length() > 0 && !text.matches("\\s+"))
				{
					strArray.add(text);
				}
			}
		}
		else
		{ // a tag or remark
			NodeList nl = n.getChildren();
			if (null != nl)
			{
				for (NodeIterator ni = nl.elements(); ni.hasMoreNodes();)
				{
					strArray.addAll(getText(ni.nextNode(), filter));
				}
			}
		}
		return strArray;
	}

	// --
	public static Boolean isValidUrl(String url) throws Exception
	{
		final int CONNECT_TIMEOUT = 1000;
		final int READ_TIMEOUT = 5000;
		try
		{
			java.net.URLConnection conn = (new java.net.URL(url)).openConnection();
			conn.setConnectTimeout(CONNECT_TIMEOUT);
			conn.setReadTimeout(READ_TIMEOUT);
			conn.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
			conn.setRequestProperty("Accept","*/*");
			java.io.InputStream is = conn.getInputStream();
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	// Return links from a url
	// Make sure that the links are fully qualified
	public static URL[] HTMLLinks(String url) throws Exception
	{
		// Get the links

		URLConnection conn = (new java.net.URL(url)).openConnection();
		conn.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
		conn.setRequestProperty("Accept","*/*");

		LinkBean sb = new LinkBean();
		sb.setURL(url);
		sb.setConnection(conn);
		URL[] outlinks = sb.getLinks();

		// make links fully qualified
		URI baseURI = null;
		try
		{
			baseURI = new URI(url);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			return new URL[0];
		}

		// ----
		List<URL> fqurls = new ArrayList<URL>();
		for (int i = 0; i < outlinks.length; i++)
		{
			URL fqurl = null;
			try
			{
				fqurl = baseURI.resolve(outlinks[i].toURI()).toURL();
			}
			catch (Exception e)
			{
				logger.error(e.getMessage(), e);
			}
			if (fqurl != null)
			{
				fqurls.add(fqurl);
			}
		}
		return fqurls.toArray(new URL[fqurls.size()]);
	}

	// Return strings from a url
	public static String HTMLText(String url) throws Exception
	{
		if (!isValidUrl(url))
		{
			return "";
		}
		String outs = "";

		StringBean sb = new StringBean();
		sb.setLinks(false);
		sb.setReplaceNonBreakingSpaces(true);
		sb.setCollapse(false);
		sb.setURL(url);
		try
		{
			outs = sb.getStrings();
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return outs;
	}

	// returns string from a html string
	public static String getText(String html) throws Exception
	{
		StringBean sb = new StringBean();
		sb.setLinks(false);
		Parser p = Parser.createParser(html, null);
		p.visitAllNodesWith(sb);
		return sb.getStrings();
	}

	// Return links from a url as a string of space separated urls
	public static String HTMLLinkString(String url) throws Exception
	{
		URL[] links = HTMLLinks(url);
		String urls = "";
		for (URL link : links)
		{
			urls = urls + link.toString() + " ";
		}
		return urls.trim();
	}

	// Return links from a url as a string of space separated urls
	public static String HTMLLinkString(String url, String filter) throws Exception
	{
		URL[] links = HTMLLinks(url);
		String urls = "";
		for (URL link : links)
		{
			String slink = link.toString();
			if (slink.contains(filter))
			{
				urls = urls + slink + " ";
			}
		}
		return urls.trim();
	}

	// Get a list of all the urls upto <levels> deep within
	public static String HTMLLinkString(String root, int level) throws Exception
	{
		String urls = "";
		if (0 == level)
		{
			return urls;
		}
		urls = HTMLLinkString(root);
		for (String u : urls.split("\\s+"))
		{
			urls = urls + " " + HTMLLinkString(u, level - 1);
		}
		return urls.trim();
	}

	// Get a list of all the urls upto <levels> deep
	// But only the urls that contain the string "filter"
	public static String HTMLLinkString(String root, int level, String filter) throws Exception
	{
		String urls = "";
		if (0 == level)
		{
			return urls;
		}
		urls = HTMLLinkString(root, filter);
		for (String u : urls.split("\\s+"))
		{
			if (u.contains(filter))
			{
				urls = urls + " " + HTMLLinkString(u, level - 1, filter);
			}
		}
		return urls.trim();
	}

	// Return a list/Array of text strings from a web-page inside tag "filter"
	public static List<String> HTMLStrings(String url, String filter) throws ParserException
	{
		List<String> strings = new ArrayList<String>();
		Parser parser = getParser(url);
		for (NodeIterator i = parser.elements(); i.hasMoreNodes();)
		{
			strings.addAll(getText(i.nextNode(), filter.toUpperCase()));
		}
		return strings;
	}

	// Return text from a web-page inside tag "filter"
	public static String HTMLText(String url, String filter) throws ParserException
	{
		String text = "";
		List<String> sList;
		Parser parser = getParser(url);
		for (NodeIterator i = parser.elements(); i.hasMoreNodes();)
		{
			sList = getText(i.nextNode(), filter.toUpperCase());
			Iterator<String> it = sList.iterator();
			while (it.hasNext())
			{
				text = text + " " + it.next();
			}
		}
		return text;
	}

	// return words from a url, stemmed and validated
	public static List<String> validHtmlStems(String url)
	{
		String htmlString = "";
		try
		{
			htmlString = HTMLText(url);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		List<String> words = getWords(htmlString);
		List<String> validWords = validStems(words);
		return validWords;
	}

	// Return stemmed words from a web page, in our dictionary
	public static List<String> validStems(List<String> words)
	{
		Stemmer stemmer = new Stemmer();
		ArrayList<String> goodWords = new ArrayList<String>();
		for (String word : words)
		{
			String stem = stemmer.stem(word);
			if (dictUtils.dict.containsKey(stem))
			{
				goodWords.add(stem);
			}
		}
		return goodWords;
	}

	// return words from a url, stemmed and validated
	public static List<String> validHtmlWords(String url)
	{
		String htmlString = "";
		try
		{
			htmlString = HTMLText(url);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		List<String> words = getWords(htmlString);
		List<String> validWords = validWords(words);
		return validWords;
	}

	public static List<String> validTextWords(String url)
	{
		String htmlString = "";
		try
		{
			htmlString = FileText(url);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		List<String> words = getWords(htmlString);
		List<String> validWords = validWords(words);
		return validWords;
	}

	public static String FileText(String filepath) throws IOException
	{
		FileInputStream fstream = new FileInputStream(filepath);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String data = "";
		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null)
		{
			// Print the content on the console
			data = data + strLine;
		}
		// Close the input stream
		in.close();
		return data;
	}

	public static void getUniqueKeywords(String[] filepaths, String outputfile) throws IOException
	{
		List<String> kw = new ArrayList<String>();
		PrintStream out = new PrintStream(new FileOutputStream(outputfile));
		for (String path : filepaths)
		{
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			// Get the object of DataInputStream
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			// Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				String word = strLine.replaceAll("\\s+$", "").replaceAll("^\\s+", "");
				// Print the content on the console
				if (!kw.contains(word))
				{
					out.println(word);
					kw.add(word);
				}
			}
			// Close the input stream
			in.close();
		}

	}

	public static void changeKeywordMatchtoExact(String filepath) throws IOException
	{
		FileInputStream fstream = new FileInputStream(filepath);
		DataInputStream in = new DataInputStream(fstream);
		// Get the object of DataInputStream
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String outputfile = filepath + "Exact";
		String strLine;
		PrintStream stdout = System.out;
		PrintStream out = new PrintStream(new FileOutputStream(outputfile));
		System.setOut(out);
		// Read File Line By Line
		while ((strLine = br.readLine()) != null)
		{
			// Print the content on the console
			System.out.println("[" + strLine.replaceAll("\\s+$", "").replaceAll("^\\s+", "") + "]");
		}
		System.setOut(stdout);

		// Close the input stream
		in.close();
	}

	// Return stemmed words from a web page, in our dictionary
	public static List<String> validWords(List<String> words)
	{
		Stemmer stemmer = new Stemmer();
		List<String> goodWords = new ArrayList<String>();
		for (String word : words)
		{
			String stem = stemmer.stem(word);
			if (dictUtils.dict.containsKey(stem))
			{
				goodWords.add(dictUtils.dict.get(stem));
			}
		}
		return goodWords;
	}

	// get words from string
	public static List<String> getWords(String text)
	{
		String lower = text.toLowerCase();
		String noPunct = lower.replaceAll("\\W", " ");
		String noNum = noPunct.replaceAll("[0-9]", " ");
		List<String> words = Arrays.asList(noNum.split("\\s+"));
		return words;
	}

	// Create a parser with the right properties (needed for Google search)
	public static Parser getParser(String url)
	{
		try
		{
			java.net.URLConnection conn = (new java.net.URL(url)).openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla");
			Parser p = new Parser(conn);
			return p;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public static Set<String> cleanWordSet(Set<String> mixedWordSet)
	{
		mixedWordSet.removeAll(dictUtils.CommonWordSet());
		return mixedWordSet;
	}

	public static String timeElapsed(double msCount)
	{
		return ((int) (msCount / 60000)) + "min " + ((msCount % 60000 / 1000)) + "sec";
	}

	// Synonyms from words.bighugelabs.com
	public static String getSynonyms(String word) throws Exception
	{
		final String prefix = "http://words.bighugelabs.com/api/2/";
		final String apikey = "febc1a7d186b265748dac5331d603093/";
		final String url = prefix + apikey + word + "/";
		final String text = HTMLText(url);
		String res = "";
		for (String s : text.split("[\\n\\r\\f]+"))
		{
			res = res + s.substring(s.lastIndexOf('|') + 1) + ",";
		}
		return res;
	}

	// -----------------
	// Stem a word
	public static String stem(String word)
	{
		return (new Stemmer()).stem(word);
	}

	// Stem a string (of words) and return a string of *valid* english words
	public static String stemvString(String raws)
	{
		String os = "";
		for (String w : raws.split("\\s+"))
		{
			os = os + dictUtils.getStemWord(w) + " ";
		}
		return os;
	}

	// Stem a sentence removing stop words
	public static String stemSentNSW(String raw)
	{
		String os = "";
		for (String w : raw.split("\\s+"))
		{
			os = os + dictUtils.stemNSW(w) + " ";
		}
		return os;
	}

	// -------------------------------------------------------------
	public static void main(String[] args) throws Exception
	{
		for (String s : gsData(args[0], args[1]))
		{
			System.out.println(s);
		}
	}
}
