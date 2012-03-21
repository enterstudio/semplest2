package CrawlSite;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Lucene
{

	private static IndexWriter writer; // new index being built
	private static ArrayList<String> indexed;
	private static String beginDomain;

	public static void main(String[] args) throws Exception
	{

		// Directory index = new Directory("/Users/mberg/index"); // new
		// RAMDirectory(); //"/opt/lucene/index";
		FSDirectory index = FSDirectory.open(new File("/Users/mberg/index"));
		boolean create = true;
		String link = "http://www.statefarm.com"; // "http://nutch.apache.org/";
		beginDomain = Domain(link);
		System.out.println(beginDomain);
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		writer = new IndexWriter(index, analyzer, true, IndexWriter.MaxFieldLength.UNLIMITED);
		// IndexWriter(index, new StandardAnalyzer(null),create,new
		// IndexWriter.MaxFieldLength(1000000));
		indexed = new ArrayList<String>();

		// index docs starting at top level 0 to a max depth
		indexDocs(link, 0, 2);

		System.out.println();
		System.out.println("Optimizing...");
		writer.optimize();
		writer.close();

	}

	private static void indexDocs(String url, int depth, int maxDepth) throws Exception
	{

		// index page
		if (depth < maxDepth)
		{
			Document doc = HTMLDocument.Document(url);
			System.out.println("adding " + doc.get("path"));
			try
			{
				indexed.add(doc.get("path"));
				writer.addDocument(doc); // add docs unconditionally

				// get all links on the page then index them
				LnkParser lp = new LnkParser(url);
				URL[] links = lp.ExtractLinks();

				for (URL l : links)
				{
					// make sure the url hasnt already been indexed
					// make sure the url contains the home domain
					// ignore urls with a querystrings by excluding "?" or jump "#"
					if ((!indexed.contains(l.toURI().toString())) && (l.toURI().toString().contains(beginDomain))
							&& (!l.toURI().toString().contains("?"))
							&& (!l.toURI().toString().contains("#")))
					{
						// don't index zip files
						if (!l.toURI().toString().endsWith(".zip"))
						{
							System.out.print(l.toURI().toString());
							indexDocs(l.toURI().toString(), depth++, maxDepth);
						}
					}
				}

			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}

	private static String Domain(String url)
	{
		int firstDot = url.indexOf(".");
		int lastDot = url.lastIndexOf(".");
		return url.substring(firstDot + 1, lastDot);
	}

}
