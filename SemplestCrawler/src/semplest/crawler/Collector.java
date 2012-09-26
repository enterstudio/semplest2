package semplest.crawler;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import semplest.dmoz.tree.UrlDataObject;

// Class that distributes and collects work from distributed workers
public class Collector {

  final static int QSIZE = 1000000;
  
  public ActorRef cactor;
  
  // - Interfaces --------
  public interface Computer {
    public Map<String,String> compute( List<UrlDataObject> urlData );
  }
  public interface Msgs extends Serializable {}
  
  // - Messages --------
  public static class Work implements Msgs {
    public final String id;
    public final List<UrlDataObject> urlData;
    public Work( String i, List<UrlDataObject> u ){ id = i; urlData = u; }
  }
  public static class Answer implements Msgs {
    public final Map<String,String> result;
    public Answer( Map<String,String> r ){ result = r; }
  }
  public static class Ready implements Msgs {
    public final String id;
    public Ready( String i ){ id = i; }
  }
  public static class Todo implements Msgs {
    public final int cnt;
    public Todo( int c ){ cnt = c; }
  }
  public static class Result implements Msgs {
    public Result(){}
  }
  public static class Write implements Msgs {
    public Write(){}
  }
  public static class Wakeup implements Msgs {
    public Wakeup(){}
  } 

  // - The Actor ---------
  public static class CActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger( getContext().system(), this );
    public ArrayBlockingQueue<Work> workQ = new ArrayBlockingQueue<Work>( 
        Collector.QSIZE);
    public HashSet<Answer> results = new HashSet<Answer>();    
    public Integer resultsReturned = 0;

    public CActor(){}

    // Message processing
    public void onReceive( Object msg){
      if( msg instanceof Ready ){
        System.out.printf("C: %s ready, (done/todo): %d,%d\n", ((Ready)msg).id, 
            workQ.size(), results.size());
        Work w = workQ.poll();
        if( w != null ) getSender().tell( w );
      }
      else if ( msg instanceof Result ){
        getSender().tell( results.toArray( new Answer[]{} ));        
        results.clear();
        System.out.printf("C: Result:: (done/todo): %d,%d\n", 
            workQ.size(), results.size());        
      }
      else if ( msg instanceof Work ){
        workQ.add( (Work) msg );
      }
      else if (msg instanceof Answer ){
        results.add( (Answer) msg );
        resultsReturned++;
        //Work w = workQ.poll();
        //if( w != null ) getSender().tell( w );
      }
      else if (msg instanceof Todo ){
        getSender().tell( new Todo( workQ.size()));
      }
      else{
        System.out.println("Error" + msg.getClass().getName());
      }
      Status.WorkQueueSize = workQ.size();
      Status.NumOfResultsCollected = resultsReturned;
    }
  }

  // - The Interface -----------------------------------------------------------
  // - Ctr ---------
  public Collector(){
    String myip = crawlUtils.getIp();

    Config conf = ConfigFactory.parseString(
        "akka {"+
        " actor { provider = \"akka.remote.RemoteActorRefProvider\" } \n" + 
        " remote { netty { hostname = \"" + myip + "\" } } \n" +
        " loglevel = \"ERROR\" \n stdout-loglevel = \"ERROR\" " +
        "} ");
    ActorSystem system = ActorSystem.create("Collector", ConfigFactory.load( conf ));
    cactor = system.actorOf(new Props( new UntypedActorFactory(){
      public UntypedActor create(){
        return new CActor(); 
      }
    }), "cactor");
  }

  // ----------------------------------------------------------------------------
  public static void main( String[] args ){
    Collector collector = new Collector();
  }
}


