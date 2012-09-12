package semplest.keywords.crawl;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.HashSet;

// Class that distributes and collects work from distributed workers
public class Collector {

  final static int QSIZE = 1000000;         // Internal work queue
  
  public ActorRef cactor;
 
  // ----------------------------------------------------
  // - Interfaces --------
  public interface Computer {
    public String compute( String in );
  }
  public interface Msgs extends Serializable {}
 
  // -----------------
  // - Definition of Messages used for communication--------
  public static class Work implements Msgs {
    public final String id;
    public final String data;
    public Work( String i, String d ){ id = i; data = d; }
  }
  public static class Answer implements Msgs {
    public final String id;
    public final String result;
    public Answer( String i, String r ){ id = i; result = r; }
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

    public CActor(){}

    // Message processing
    public void onReceive( Object msg){
      if( msg instanceof Ready ){
        System.out.printf("C: %s ready, (done/todo): %d,%d\n", 
            ((Ready)msg).id, workQ.size(), results.size());       // logging ?
        Work w = workQ.poll();
        if( w != null ) getSender().tell( w );
      }
      else if ( msg instanceof Result ){
        getSender().tell( results.toArray( new Answer[]{} ));
        results.clear();
        System.out.printf("C: Result:: (done/todo): %d,%d\n", 
            workQ.size(), results.size());                        // logging ?
      }
      else if ( msg instanceof Work )
        workQ.add( (Work) msg );
      else if (msg instanceof Answer ){
        results.add( (Answer) msg );
        Work w = workQ.poll();
        if( w != null ) getSender().tell( w );
      }
      else if (msg instanceof Todo ){
        getSender().tell( new Todo( workQ.size()));
      }
      else 
        System.out.println("Errro" + msg.getClass().getName());  // logging?
    }
  }

  // - The API Interface --------------------------------------------- 
  // - Ctr ---------
  public Collector(){
    String myip = crawlUtils.getIp();

    Config conf = ConfigFactory.parseString(
        "akka {"+
        " actor { provider = \"akka.remote.RemoteActorRefProvider\" } \n" + 
        " remote { netty { hostname = \"" + myip + "\" } } \n" +
        " loglevel = \"ERROR\" \n stdout-loglevel = \"ERROR\" " +
        "} ");
    ActorSystem system = ActorSystem.create("Collector", 
        ConfigFactory.load( conf ));
    cactor = system.actorOf(new Props( new UntypedActorFactory(){
      public UntypedActor create(){
        return new CActor(); 
      }
    }), "cactor");
  }

  // ------------------------------------------------------------------
  public static void main( String[] args ){
  }
}


