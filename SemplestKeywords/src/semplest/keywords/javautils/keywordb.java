package semplest.keywords.javautils;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;


/* Utilities to store/retrieve semplest keywords in a Berkeley Database
 */
public class keywordb {

  // - Privates ------------
  // The keyword databases (2 => 2grams, 3 => 3grams, ..., 23 => autocompletes)
  private static String[] dbs = {"2","3","4","23"};

  // - Interface ------------------------
  // db can be one of "2","3","4","23" corresponding to 2gram, .. ,autocom
  public static Map<String,Integer> get( String cat, String db) throws Exception {
    return ioUtils.toWc( bdb.get( db, cat ) );
  }
  public static Map<String,Map<String,Integer>> get( String[] cats, String db) 
    throws Exception {
    Map<String,String> res = bdb.get( db, cats );

    HashMap<String,Map<String,Integer>> resm = 
      new HashMap<String,Map<String,Integer>>();
    for( Map.Entry<String,String> e: res.entrySet() )
     resm.put( e.getKey(), ioUtils.toWc( e.getValue() )); 

    return resm;
  }
  // - Utilities -----------------------------------------------------
  // combine wcs from all databases 
  public static Map<String,Integer> get( String cat) throws Exception {
    HashMap<String,Integer> resm = new HashMap<String,Integer>();
    for( String db : dbs ){
      Map<String,Integer> wc = ioUtils.toWc( bdb.get( db, cat ) );
      for( Map.Entry<String,Integer> e: wc.entrySet() ){
        Integer cur = resm.containsKey( e.getKey()) ? resm.get( e.getKey()) : 0; 
        resm.put( e.getKey(), Math.max( e.getValue(), cur ));  
      }
    }
    return resm;
  }
  public static Map<String,Map<String,Integer>> get( String[] cats) 
    throws Exception {
    HashMap<String, Map<String,Integer>> resm
      = new HashMap<String,Map<String,Integer>>();
 
    for( String db : dbs ){
      Map<String,Map<String,Integer>> wcs = get(cats, db );
      for( Map.Entry<String,Map<String,Integer>> e: wcs.entrySet())
        if( resm.containsKey( e.getKey() ))
          resm.put( e.getKey(), cWc( e.getValue(), resm.get( e.getKey())));
        else 
          resm.put( e.getKey(), e.getValue());
    }
    return resm;
  }
  
  // - Private -----------
  // Combine word-counts by using the maximum-count
  private static Map<String,Integer> cWc(Map<String,Integer> a, 
      Map<String,Integer> b){
    HashMap<String,Integer> res = new HashMap<String,Integer>();
    HashSet<String> abkeys = new HashSet<String>();
    abkeys.addAll( a.keySet()); 
    abkeys.addAll( b.keySet()); 
    for( String k: abkeys ){
      Integer v = a.containsKey( k ) ? a.get( k ) : 0;
      v         = b.containsKey( k ) ? Math.max( b.get( k ), v ) : v;   
      res.put( k, v);
    }
    return res;
  }
  // - Test routines  ------------------------
  public static void test() throws Exception {
    String[] cats = {"top/news/weather","top/news/weather/aviation"};
    Map<String, Map<String,Integer>> wc = get( cats );
    System.out.println( wc.size()  + " keywords"); 
    for( Map.Entry<String,Map<String,Integer>> es: wc.entrySet() ){
      System.out.println( es.getKey() + "\n" );
      for( Map.Entry<String,Integer> e: es.getValue().entrySet() )
      System.out.println( e.getKey() + " " + e.getValue() );
    }
  }
  public static void timeTest() throws Exception {
    int COUNT = 1000;
    String[] cats = getCats( COUNT );  
    long st = System.currentTimeMillis();
    Map<String,Map<String,Integer>> r = get( cats );
    long et = System.currentTimeMillis();
    int mms = (int)(( et - st ) / COUNT);
    System.out.println("\n\n" + COUNT + " cats took " + mms + " ms each");
  }
  private static String[] getCats( int num ){
    String FILE = "/semplest/data/dmoz/all.cids";
    String[] lines = ioUtils.readLines( FILE, num );
    String[] res = new String[ num ];
    for( int i =0; i< num; i++ )
      res[ i ] = lines[ i ].substring( 0, lines[i].indexOf(":") -1);
    return res;
  }

  // ---------------------------------------------------------------------
  public static void main(String[] args) throws Exception {
    test();
    timeTest();
  }
}

