package semplest.crawler;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import semplest.dmoz.tree.UrlDataObject;

// The worker of the distributed computing system
// As many workers as necessary are creates(with the ip adress of the master)
//  Workers periodically announce they are free to do work 
//  The master sends them work of form String w;
//  The worker does computaion on the work string and returns a result String
//  The master saves the work and sends new work if there is work to be done
//  A worker needs an imlementation the interface Collector.Computer
//    which requires the function "String Compute(String w)"

public class Worker {	
	
  // - The Actor ------------------------------------------------
  public static class WActor extends UntypedActor  {
    boolean working = false;
    ActorRef collector;
    Collector.Computer computor;
    String id;

    // Actor Ctr
    public WActor( ActorRef cltr, Collector.Computer c){
      collector = cltr;
      computor  = c;
      try {
        id = java.net.InetAddress.getLocalHost().getHostName() + ":" +
          Thread.currentThread().getId();
      } catch (Exception e){ e.printStackTrace(); }
      askForWork();
    }

    // Actor Message processing
    public void askForWork(){
      try 
      {
        Thread.sleep( 10000 );
      } 
      catch (Exception e)
      {
    	  e.printStackTrace(); 
      }
      
      
      
      
      
      getSelf().tell( new Collector.Wakeup() );
    }

    public void onReceive( Object msg){
      if( msg instanceof Collector.Work )
      {
        working = true;
        System.out.println("Got Work !");
        Collector.Work w = (Collector.Work)msg;
        collector.tell( new Collector.Answer( computor.compute( w.urlData ) ), getSelf() );
        working = false;
      }
      else if( msg instanceof Collector.Wakeup )
      {
        if( !working )
        {
          collector.tell( new Collector.Ready( id ), getSelf() );
          System.out.println(id + " :: Sending Ready Message");
          askForWork();
        }
      }
    }

  }

  // The Interface -------------------------------------------------------
  // - Ctr ------------------------------------------------------
  public Worker( String ip, int workers, final Collector.Computer c ){
    String port = "2552";
    String messageFrameSize = CrawlerProperties.AkkaMessageFrameSize;
    Config conf = ConfigFactory.parseString(
        "akka {" +
        "  actor  { provider = \"akka.remote.RemoteActorRefProvider\" } \n " +
        "  remote { netty { port = 2553 } } \n" +
        " loglevel = \"ERROR\" \n stdout-loglevel = \"ERROR\" \n" +
        " remote.netty.message-frame-size = " + messageFrameSize + " \n" +
        "} "
        );
    String remoteAddr = "akka://Collector@" + ip + ":" + port + "/user/cactor";
    ActorSystem system = ActorSystem.create("Collector", 
        ConfigFactory.load( conf ));
    final ActorRef collector= system.actorFor( remoteAddr );
    
    for( int i=0; i< new Integer( workers); i++)
      system.actorOf(new Props( new UntypedActorFactory(){
        public UntypedActor create(){
          return new WActor( collector, c ); 
        }
      }));

  }
  
  public static void main( String[] args )
  {
	String ip = "172.18.11.213";
    if( args.length > 0 ) ip = args[0];
    int workers = 3;
    if( args.length > 1 ) workers = Integer.parseInt( args[1]);   
    final Integer sleepIntervalBetweenUrls = CrawlerProperties.SleepIntervalBetweenUrls;
    
	  final SimpleLogger logger = new SimpleLogger(CrawlerProperties.WorkerLogFile);	  
	  try{
		    Collector.Computer c = new Collector.Computer(){
		      public Map<String,String> compute( List<Queue<UrlDataObject>> urlData) {
		    	  Map<String,String> resMap = new HashMap<String,String>();
		    	  RoundRobin work = new RoundRobin(urlData);
		    	  Integer sleepInterval = sleepIntervalBetweenUrls / urlData.size();
		    	  
		    	  while(!work.isEmpty()){
		    		  UrlDataObject url = work.getNextWork();
		    		  try {
		    			  if(url == null){
		    				  Thread.sleep(sleepInterval);
		    			  }
		    			  else{
		    				  //get raw html data from url
				            String res = crawlUtils.htmlText( url.getUrl() );
				            resMap.put(url.getUrlDataPK().toString(), res);
				            if(res.length() == 0){
				            	logger.message(url.getUrl());
				            }
		    			  }			        	 
			          } 
			          catch( Exception e)
			          { 
			        	  e.printStackTrace();
			        	  logger.error(e.getMessage());
			          }
		    	  }
		       
		        return resMap;
		      }
		    };
		    
		    Worker worker = new Worker( ip, workers, c); 
	  }
	  catch(Exception e){
		  logger.error(e.getMessage());
	  }
  }
}


