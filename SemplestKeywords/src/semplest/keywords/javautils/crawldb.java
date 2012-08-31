package semplest.keywords.javautils;

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Utilities to store/retrieve dmoz crawl info 
 */
public class crawldb
{

  // - Interface --------------------------------------------------------
  // Ctr
  public crawldb() throws Exception
  {
    utdb = new cdb(CRAWL_DB_DIR, "urltext", true, false);
    uldb = new cdb(CRAWL_DB_DIR, "urllinks", true, true);
    ctdb = new cdb(CRAWL_DB_DIR, "cattexts", true, true);
    cudb = new cdb(CRAWL_DB_DIR, "caturls", true, true);
  }

  // text for a url
  public String get(String url) throws Exception
  {
    return utdb.get(url);
  }

  // url, text for a category
  public Map<String, String> getuts(String cat) throws Exception
  {
    Map<String, String> uts = new HashMap<String, String>();
    String[] urls = cudb.gets(cat);
    System.out.println(cat + ":" + urls.length);
    for (String url : urls)
    {
      System.out.println(url + ":" + utdb.get(url));
      uts.put(url, utdb.get(url));
    }
    return uts;
  }

  // url, text for a random category
  public Map<String, String> getuts() throws Exception
  {
    return getuts(catUtils.randomCat());
  }

  // category's siblings
  public String[] siblings(String cat) throws Exception
  {
    return catUtils.siblings(cat);
  }

  // cleanup
  public void close()
  {
    utdb.close();
    uldb.close();
    ctdb.close();
    cudb.close();
  }

  // - static ----------------------------------------------------
  // read crawl file and populate database(s)
  public static void create() throws Exception
  {
    // create dbs
    cdb utdb = new cdb(CRAWL_DB_DIR, "urltext", false, false);
    cdb uldb = new cdb(CRAWL_DB_DIR, "urllinks", false, true);
    cdb ctdb = new cdb(CRAWL_DB_DIR, "cattexts", false, true);
    cdb cudb = new cdb(CRAWL_DB_DIR, "caturls", false, true);

    // read crawl line by line (cat by cat) and populate db
    String cfile = CRAWL_DIR + DMOZ_VERSION + "." + CRAWL_VERSION;
    InputStream fis = new FileInputStream(cfile);
    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    String line;
    while ((line = br.readLine()) != null)
    {
      String cat = cat(line);
      Map<String, String> ut = ut(line);
      Map<String, String[]> uls = links(line);
      utdb.add(ut);
      for (Map.Entry<String, String> e : ut.entrySet())
      {
        cudb.add(cat, e.getKey());
        ctdb.add(cat, e.getValue());
      }
      for (Map.Entry<String, String[]> e : uls.entrySet())
        for (String l : e.getValue())
          uldb.add(e.getKey(), l);
    }
    utdb.close();
    uldb.close();
    ctdb.close();
    cudb.close();
  }

  // - Private -------------------------------------------------------------

  private static String DMOZ_VERSION = "dmoz.8-12";
  private static String CRAWL_VERSION = "tl.1";
  private static String CRAWL_DIR = "/semplest/data/dmoz/shopping/";
  private static String CRAWL_DB_DIR = "/semplest/data/dmoz/bdb/crawl";

  private cdb utdb;
  private cdb uldb;
  private cdb ctdb;
  private cdb cudb;

  private static String[] dbs = { "urltext", "urllinks", "cattexts", "caturls" };

  // parsers to parse crawl text entry
  // cat : url1 ::: text1 ::: link1-1 :: link1-2 :: .. :::: url2 ::: text2
  // ::: link2-2 :: link2-2 :: .. :::: ...
  // returns: cat
  private static String cat(String l)
  {
    return l.substring(0, l.indexOf(":")).trim();
  }

  // returns: <url,text>
  private static Map<String, String> ut(String l)
  {
    String body = l.substring(l.indexOf(":") + 1).trim();
    String[] entries = body.split("::::");
    Map<String, String> ut = new HashMap<String, String>();
    for (String entry : entries)
    {
      String[] parts = entry.trim().split(":::");
      if (parts.length >= 2)
        ut.put(parts[0].trim(), parts[1].trim());
    }
    return ut;
  }

  // returns: <url,links[]>
  private static Map<String, String[]> links(String l)
  {
    String body = l.substring(l.indexOf(":") + 1).trim();
    String[] entries = body.split("::::");
    Map<String, String[]> uls = new HashMap<String, String[]>();
    for (String entry : entries)
    {
      String[] parts = entry.trim().split(":::");
      if (parts.length >= 3)
        uls.put(parts[0].trim(), parts[2].split(" :: "));
    }
    return uls;
  }

  // - Test routines ---------------------------------------------------------
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
    System.out.println(url + " : " + urlText);
    for (Map.Entry<String, String> e : uts.entrySet())
      System.out.println(e.getKey() + " : " + e.getValue());
    for (String e : siblings)
      System.out.println("\tsibling : " + e);
    System.out.println("\n\n" + (uts.size() + ruts.size() + siblings.length) + " records took " + (et - st) + " ms ");
  }

  // ---------------------------------------------------------------------
  public static void main(String[] args) throws Exception
  {
    test();
  }
}
