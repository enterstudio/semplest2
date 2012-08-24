package semplest.keywords.javautils;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

/*
 * Utilities to store/retrieve semplest keywords/descriptions in a Berkeley Database
 */
public class keywordb {

  // - Interface ------------------------

  // keyword-count for a category/categories from a db 
  //  db can be one of "2g","3g","4g","ac" corresponding to 2gram, .. ,autocom
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
  // keyword-counts for all chidren categories of "cat"
  public static Map<String,Map<String,Integer>> children(String cat, String db) 
    throws Exception {
    HashMap<String,Map<String,Integer>> resm = 
      new HashMap<String,Map<String,Integer>>();
    for( Map.Entry<String,String> e: bdb.children( db, cat ).entrySet() )
      resm.put( e.getKey(), ioUtils.toWc( e.getValue() ));
    
    return resm;
  }
  public static Map<String,String> getAll( String db) throws Exception {
    return (bdb.getAll( db ));
  }
  public static String[] getKeys( String db) throws Exception {
    return (bdb.getKeys( db ));
  }
  // dmoz description data for a category
  public static String description( String cat) throws Exception {
    return bdb.get( ddb, cat );
  }
  // - Utilities ------------------------------------------------------
  // combine word-counts from all the databases (2g, 3g, 4g, ac)
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
  
  // - Private ----------------------------------------------------------------
  // The keyword databases (2g => 2grams, 3g => 3grams,., ac => autocompletes)
  // descs => descriptions 
  private static String[] dbs = { "2g","3g","4g","ac"};
  private static String   ddb =   "descs";

  // - Utility --
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
  // - Test routines  ---------------------------------------------------------
  public static void test() throws Exception {
    String[]  cats = {"top/news/weather","top/news/weather/aviation"};
    String    cat = "top/news/satire";
    Map<String, Map<String,Integer>> wc = get( cats );
    Map<String, Map<String,Integer>> descendants = children( cat, "2g" );
    String desc                         = description( cat );

    System.out.println( wc.size()  + " keywords"); 
    for( Map.Entry<String,Map<String,Integer>> es: wc.entrySet() ){
      System.out.println( es.getKey() + "\n" );
      for( Map.Entry<String,Integer> e: es.getValue().entrySet() )
      System.out.println( e.getKey() + " " + e.getValue() );
    }
    System.out.println( "\nChildren of " + cat + "::"); 
    for( Map.Entry<String,Map<String,Integer>> e: descendants.entrySet())
      System.out.println( e.getKey() );
    System.out.println( "\nDescription for " + cat + "::"); 
    System.out.println( desc ); 
  }
  public static void timeTest() throws Exception {
    String db = "4g";
    long st = System.currentTimeMillis();
    Map<String,String> rs = getAll( db );
    String[] ks = getKeys( db );
    long et = System.currentTimeMillis();
    System.out.println("\n\n" + (rs.size() + ks.length) + " records took " 
        + (et - st) + " ms ");
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
//    test();
    timeTest();
  }
}

