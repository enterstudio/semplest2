package semplest.dmoz.crawl;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

public class Run {

  private final static int COLLECT_INTERVAL = 5000;

  private ActorRef cactor;
  public int todo = 0;
  Map<Long,String> res;

  // The Actor that talks to the Collector
  public class RActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger( getContext().system(), this );
    private ActorRef collector;

    // Actor Ctr
    public RActor( ActorRef cltr){
      collector = cltr;
      res = new HashMap<Long,String>();
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
    res = new HashMap<Long,String>();
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
  public Map<Long,String> results(){ 
    Map<Long,String> ret = new HashMap<Long,String>();
    ret.putAll(res);
    res.clear();
    return ret;
  }
  public int todo(){ return todo; }


  public static void main( String[] args ) throws Exception 
  {    
    Map<String,List<UrlDataObject>> work = SemplestTreeDB.getUrlsByDomain("top");

    Run r = new Run();
    r.add( work );
    while( true ){
      Map<Long,String> res = r.results();
      if( res.size() > 0 ){
        System.out.println("R:Got " + res.size() + " results, " + r.todo() + " todo");
        for( Map.Entry<Long,String> e: res.entrySet())
        	//implement how to store results
          System.out.println( e.getKey() + " : " + e.getValue() );
      }
      Thread.sleep( 5000 );
    }
  }
}


