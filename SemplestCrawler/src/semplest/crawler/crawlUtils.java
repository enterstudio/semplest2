package semplest.crawler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.TreeMap;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import semplest.dmoz.SemplestTreeDB;
import semplest.dmoz.tree.UrlDataObject;

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
    	return Jsoup.connect(url).get().toString();
      //return Jsoup.connect( url ).get().body().text();
    } catch (Exception e){ 
      e.printStackTrace();
      return "";
    }
  }
  
  //Generate work for Master
  public static List<List<Queue<UrlDataObject>>> generateWork(String treeName, int bucketNum, int minBucketSize) throws Exception
  {	  	  
	  List<List<Queue<UrlDataObject>>> work = new ArrayList<List<Queue<UrlDataObject>>>();
	  Map<String,List<UrlDataObject>> urlsByDomain = SemplestTreeDB.getUrlsByDomain(treeName);
	  Queue<List<UrlDataObject>> domainQ = new LinkedList<List<UrlDataObject>>();
	  for(Map.Entry<String,List<UrlDataObject>> e : urlsByDomain.entrySet()){
		  domainQ.add(e.getValue());
	  }
	  
	  while(!domainQ.isEmpty()){
		  List<Queue<UrlDataObject>> bucketList = filloutWorkBlock(domainQ, bucketNum, minBucketSize);
		  work.add(bucketList);
	  }
	  
	  return work;
  }
  
  public static List<Queue<UrlDataObject>> filloutWorkBlock(Queue<List<UrlDataObject>> domainQ, int numOfBuckets, int bucketSize)
  {
	  int threshold = 10;
	  int leftoverSize = numOfBuckets;
	  
	  List<Queue<UrlDataObject>> bucketList = new ArrayList<Queue<UrlDataObject>>();
	  
	  if(domainQ.size() <= leftoverSize){
		  for(int i = 0; i < numOfBuckets; i++){
			Queue<UrlDataObject> bucket = new LinkedList<UrlDataObject>();
			bucket.addAll(domainQ.poll());			  
			bucketList.add(bucket);
		  }
	  }
	  else{
		  for(int i = 0; i < numOfBuckets; i++){
			  Queue<UrlDataObject> bucket = new LinkedList<UrlDataObject>();			  
			  while(bucketSize - bucket.size() > threshold){
				  if(domainQ.size() <= leftoverSize){
					  break;
				  }
				  if(!bucket.isEmpty() && (domainQ.peek().size() + bucket.size() - bucketSize > threshold)){
					  break;
				  }
				  bucket.addAll(domainQ.poll());
			  }			  			  
			  bucketList.add(bucket);
		  }
	  }
	  	  
	  
	  return bucketList;
  }
  
  public static void main(String[] args){
	  try{
		  //workGenerator("top/business/financial_services/insurance/agents_and_marketers/employee_benefits");
		  List<List<Queue<UrlDataObject>>> work = generateWork("top/business",5,50);
		  for(List<Queue<UrlDataObject>> w : work){
			  System.out.println("==========");
			  for(Queue<UrlDataObject> l : w){
				  System.out.println(l.size());
			  }
		  }
	  }
	  catch(Exception e){
		  e.printStackTrace();
	  }
  }  
  
}


