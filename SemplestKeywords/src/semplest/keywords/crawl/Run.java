package semplest.keywords.crawl;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.util.Map;
import java.util.HashMap;

// The class that provides an interface to the distributed work system
// Usage:
//  Run r = new Run();
//  Map<String,String> work;
//  .......... populate work ...... 
//  r.add( work );
//  while( ! done )
//    Map<String,String> = r.results();
//
//  Note: This Master distributes the work to workers and collects results.
//        It does *not* do retries. It is up to the user to keep track of
//        completion and do retries.

public class Run {

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
      } catch (Exception e){ 
        log.error("Thread.sleep");                               // logging
      }
      getSelf().tell( new Collector.Wakeup() );
    }

    // Message Processing
    public void onReceive( Object msg){
      if( msg instanceof Collector.Answer[] ){
        for( Collector.Answer a : (Collector.Answer[])msg)
          res.put( a.id, a.result );
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
  public void add( Map<String,String> work) {
    for( Map.Entry<String,String> w: work.entrySet() )
      cactor.tell( new Collector.Work( w.getKey(), w.getValue()));
  }
  // Get whatever results are available
  public Map<String,String> results(){ 
    Map<String,String> ret = new HashMap<String,String>();
    for( Map.Entry<String,String> e: res.entrySet())
      ret.put( e.getKey(), e.getValue());
    res.clear();
    return ret;
  }
  public int todo(){ return todo; }

  //--------------------------------------------------------------------
  // Sample Usage
  public static void main( String[] args ) throws Exception {

    String ufile = "/semplest/data/dmoz/all.urls";
    Map<String,String> work = crawlUtils.readUrls( ufile, 10 );

    Run r = new Run();
    r.add( work );
    while( true ){
      Map<String,String> res = r.results();
      // do something with results. In this example we just print a count.
      if( res.size() > 0 ){ 
        System.out.println("R:Got " + res.size() + " results, " + r.todo() + " todo");
        for( Map.Entry<String,String> e: res.entrySet())
          System.out.println( e.getKey() + " : " + e.getValue().substring(0,25) );
      }
      Thread.sleep( 5000 );
    }
  }
}


