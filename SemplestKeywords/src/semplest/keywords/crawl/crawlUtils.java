package semplest.keywords.crawl;

import java.util.Map;
import java.util.HashMap;
import java.io.*;

import org.jsoup.Jsoup;

public class crawlUtils {
  // get my Ip address
  public static String getIp(){
    try {
      return (new java.net.Socket("www.google.com", 80 )).
        getLocalAddress().getHostAddress();
    } catch (Exception e) {e.printStackTrace(); }
    return "";
  }

  // reads url file and returns as a HashMap
  public static Map<String, String> readUrls(String file) throws Exception {
    Map<String, String> hash = new HashMap<String, String>();
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(file)));
    String line;
    int count = 0;
    while ((line = br.readLine()) != null) {
      count++; if( count > 10 ) break;
      int index = line.indexOf(':');
      hash.put( line.substring(0,index).trim(), 
          line.substring(index+1).trim());
    }
    return hash;
  }
  
  // Jsoup
  // visible text
  public static String htmlText( String url ) {
    try {
      return Jsoup.connect( url ).get().body().text();
    } catch (Exception e){ 
      e.printStackTrace();
      return "";
    }
  }

}


