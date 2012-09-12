package semplest.keywords.crawl;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

// Some useful utilities

public class crawlUtils {
  // get my Ip address
  public static String getIp(){
    try {
      return (new java.net.Socket("www.google.com", 80 )).
        getLocalAddress().getHostAddress();
    } catch (Exception e) {e.printStackTrace(); }  // logging ?
    return "";
  }

  // reads a dmoz url file and returns first n entries as a HashMap
  public static Map<String, String> readUrls(String file, int n) 
    throws Exception {
    Map<String, String> hash = new HashMap<String, String>();
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(file)));
    String line;
    int count = 0;
    while ((line = br.readLine()) != null) {
      count++; 
      if( count > n ) break;
      int index = line.indexOf(':');
      hash.put( line.substring(0,index).trim(), 
          line.substring(index+1).trim());
    }
    return hash;
  }
  // returns urls that belong to domain durl
  public static String[] domainFilter( String[] urls, String durl) 
    throws Exception {
    String host = (new java.net.URL( durl )).getHost();
    ArrayList<String> al = new ArrayList<String>();
    for( String url: urls )
      if( url.contains( host ))
        al.add( url );
    return al.toArray( new  String[]{});
  }
  
  // - Jsoup -----------------------
  // visible text
  public static String htmlText( String url ) {
    try {
      return Jsoup.connect( url ).get().body().text();
    } catch (Exception e){                       // logging ?
      e.printStackTrace();
      return "";                                 // return codes ?
    }
  }
  public static String[] htmlLinks( String url ) {
    ArrayList<String> al = new ArrayList<String>();
    try {
      for( Element link : Jsoup.connect( url ).get().select("a[href]"))
        al.add( link.attr("abs:href"));
    } catch (Exception e){                       
      e.printStackTrace();                      // logging ?
    } 
    return al.toArray( new  String[]{});
  }

  // ------------------------------------------------------------
  public static void main( String[] args ){
    for( String l: htmlLinks("http://www.semplest.com"))
      System.out.println( l );
  }

}


