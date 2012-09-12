package semplest.keywords.crawl;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.HashSet;

// The worker of the distributed computing system
// 
// As many workers as necessary are constructed (with master's ip-adress)
//  When free workers announce to master they are able to do work 
//  The master sends them work of form String w;
//  The worker does computation on the work string and returns a result String
//  The master saves the work and sends new work if there is work to be done
//  A worker needs to implement the interface Collector.Computer
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
      } catch (Exception e){ e.printStackTrace(); }      // logging? 
      askForWork();
    }

    // Periodically ask for work if free
    public void askForWork(){
      try {
        Thread.sleep( 5000 );
      } catch (Exception e){ 
        e.printStackTrace();                              // logging ?
      }
      getSelf().tell( new Collector.Wakeup() );
    }
    // Actor Message Processing
    public void onReceive( Object msg){
      if( msg instanceof Collector.Work ){
        working = true;
        System.out.println("Got Work !");
        Collector.Work w = (Collector.Work)msg;
        collector.tell( new Collector.Answer( w.id, computor.compute( w.data ) ) );
        working = false;
      }
      else if( msg instanceof Collector.Wakeup ){
        if( ! working ){
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
    Config conf = ConfigFactory.parseString(
        "akka {" +
        "  actor  { provider = \"akka.remote.RemoteActorRefProvider\" } \n " +
        "  remote { netty { port = 2553 } } \n" +
        " loglevel = \"ERROR\" \n stdout-loglevel = \"ERROR\" " +
        "} "
        );
    String remoteAddr = "akka://Collector@" + ip + ":" + port + "/user/cactor";
    ActorSystem system = ActorSystem.create("Collector", 
        ConfigFactory.load( conf ));
    final ActorRef collector= system.actorFor( remoteAddr );
   
    // Create workers-num of new worker threads
    for( int i=0; i< new Integer( workers); i++)
      system.actorOf(new Props( new UntypedActorFactory(){
        public UntypedActor create(){
          return new WActor( collector, c ); 
        }
      }));

  }

  // ------------------------------------------------------------------------------
  // - Example usage
  //    Implement the interface Collector.Computer
  //     implement the function "String Compute(String w)"
  //    Construct Worker
  public static void main( String[] args ){
    String ip = "127.0.1.1";
    if( args.length > 0 ) ip = args[0];
    int workers = 3;
    if( args.length > 1 ) workers = Integer.parseInt( args[1]);

    Collector.Computer c = new Collector.Computer(){
      // example here assumes input is a space-separated list of urls
      // returns text associated with each url, " :: " separated
      public String compute( String w) {
        String res = "";
        for( String url : w.split("\\s+"))
          try {
            res = res + crawlUtils.htmlText( url ) + " :: ";
          } catch( Exception e){ e.printStackTrace(); }
        return res;
      }
    };
    
    Worker worker = new Worker( ip, workers, c); 
  }
}


