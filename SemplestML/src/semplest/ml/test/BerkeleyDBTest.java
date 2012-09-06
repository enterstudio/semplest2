package semplest.ml.test;

import java.util.Map;

import semplest.keywords.javautils.crawldb;

public class BerkeleyDBTest {

	public static void test() throws Exception
	{
		String cat = "top/shopping/flowers/florists/north_america/united_states/indiana";
		String url = "http://www.sitka-flowers.com/";

		crawldb db = new crawldb(); // open db

		long st = System.currentTimeMillis();
		String urlText = db.get(url); // get text for a url
		String[] siblings = db.siblings(cat); // get a cat's siblings
		Map<String, String> uts = db.getuts(cat); // get links,text for cat
		Map<String, String> ruts = db.getuts(); // get links,text for random cat
		long et = System.currentTimeMillis();
		db.close();

		// print results
		 String rs = "";
	    for( String s: uts.values()) rs = rs + s;
	    System.out.println( url + " ::: " +  urlText + "\n\n");
	    System.out.println("category :: " + cat );
	    System.out.println("urls: "+uts.size()+", text(chars): "+rs.length()+"\n");
	    for (String e : siblings)
	    {
	      System.out.println("sibling : " + e);
	    }
		System.out.println("\n\n" + (uts.size() + ruts.size() + siblings.length) + " records took " + (et - st) + " ms ");
	}

	// ---------------------------------------------------------------------
	public static void main(String[] args) throws Exception
	{
		test();
	}

}
