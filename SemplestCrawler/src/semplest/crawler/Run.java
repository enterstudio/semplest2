package semplest.crawler;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

import semplest.db.berkeleydb.BerkeleyDB;
import semplest.db.berkeleydb.BerkeleyDB_Static;
import semplest.dmoz.SemplestTreeDB;
import semplest.dmoz.tree.UrlDataObject;

// The class that provides an interface to the distributed work system
// Usage:
//  Run r = new Run();
//  Map<String,String> work;
//  .......... populate work ...... 
//  r.add( wmap );
//  while( ! done )
//    Map<String,String> = r.results();
//
//  Note: The Master distributes the work to workers and collects results.
//        It doe *not* do retries. It is up to the user to keep track of
//        completion and do retries.

public class Run 
{
  private final static int COLLECT_INTERVAL = 5000;

  private ActorRef cactor;
  public int todo = 0;
  Map<String,String> res;

  // The Actor that talks to the Collector
  public class RActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger( getContext().system(), this );
    private ActorRef collector;

    // Actor Ctr
    public RActor( ActorRef cltr){
      collector = cltr;
      res = new HashMap<String,String>();
      collectResults();
    }
    public void collectResults(){
      try {
        Thread.sleep( Run.COLLECT_INTERVAL );
      } catch (Exception e){ e.printStackTrace(); }
      getSelf().tell( new Collector.Wakeup() );
    }

    // Message Processing
    public void onReceive( Object msg){
      if( msg instanceof Collector.Answer[] ){
        for( Collector.Answer a : (Collector.Answer[])msg)
          res.putAll( a.result );
      }
      else if( msg instanceof Collector.Wakeup ){
        collector.tell( new Collector.Result(), getSelf());
        collector.tell( new Collector.Todo(0),  getSelf());
        collectResults();
      }
      else if( msg instanceof Collector.Todo ){
        todo = ((Collector.Todo)msg).cnt;
      }
    }

  }

  // -Interface -------------------------------------------------
  // - Ctr -
  public Run() throws Exception {
    res = new HashMap<String,String>();
    initialize();     // start the collector and local actor
  }

  private void initialize(){
    cactor = (new Collector()).cactor;
    String myip = crawlUtils.getIp();
    Config conf = ConfigFactory.parseString(
        "akka {" +
        "  actor  { provider = \"akka.remote.RemoteActorRefProvider\" } \n " +
        " remote { netty { hostname = \"" + myip + "\" \n  port = 2554 } } \n" +
        " loglevel = \"ERROR\" \n stdout-loglevel = \"ERROR\" " +
        "} "
        );

    ActorSystem system = ActorSystem.create("Collector", 
        ConfigFactory.load( conf ));
    ActorRef actor = system.actorOf(new Props( new UntypedActorFactory(){
      public UntypedActor create(){
        return (new RActor( cactor )); 
      }
    }));
  }

  // - Interface ------------------------------------------------------------
  // send all the required work to the COllector
  public void add( Map<String,List<UrlDataObject>> work) {
    for( Map.Entry<String,List<UrlDataObject>> w: work.entrySet() )
      cactor.tell( new Collector.Work( w.getKey(), w.getValue()));
  }
  public Map<String,String> results(){ 
    Map<String,String> ret = new HashMap<String,String>();
    ret.putAll(res);
    res.clear();
    return ret;
  }
  public int todo(){ return todo; }


  public static void main( String[] args )
  {    	  		
	  String treeName = "top";
	  if( args.length > 0 ) {
		  treeName = args[0];
	  }
	  
		String dbDir = CrawlerProperties.BerkeleyDbDirectory;
		String dbID = CrawlerProperties.BerkeleyDbID;
		String logFile = CrawlerProperties.MasterLogFile;
		
		SimpleLogger logger = new SimpleLogger(logFile);
		BerkeleyDB_Static.setDirectory(dbDir);
	  
		try
		{							  
			System.out.println("Starting master and loading work. Please wait...");
			
			//Generate work. group urls by domain.
			Map<String,List<UrlDataObject>> work = SemplestTreeDB.getUrlsByDomain(treeName);
			Status.TotalWorkSize = work.size();
			
			System.out.println("Work loaded. Master is ready to go.");
			logger.info("Master Started.");
			logger.info("Total amount of work: " + Status.TotalWorkSize);			
			
			//Run the master, and collect results.
			Run r = new Run();
			r.add( work );
			while( !Status.isDone() ){
			  Map<String,String> res = r.results();
			  if( res.size() > 0 ){
				  logger.info("Work Queue length: " + Status.WorkQueueSize + ", Results Collected: " + Status.NumOfResultsCollected);
			    //Store results to BerkeleyDB
			    BerkeleyDB_Static.add(dbID, res);
			  }
			  Thread.sleep( 5000 );
			}
			logger.info("Crawler finished at " + new Date() + ". Total amount of work: " + Status.TotalWorkSize + ". Work finished by crawler: " + Status.NumOfResultsCollected);
		}
		catch(Exception e){
			e.printStackTrace();		 
			logger.error(e.getMessage());
		}
  }
	  
}


