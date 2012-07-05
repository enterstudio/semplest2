package semplest.keywords.javautils;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
 * Utilities to read manipulate dmoz keywords 
 */
public class dmozUtils {


  String dir;
  String ending;
  static final String[] topls = {"business","computers","news","shopping"};
//  String[] topls = {"arts","business","computers","games", "health", 
//  "home","news","recreation", "reference", "regional","science",
//  "shopping","society","sports"};

  Map<String, Map<String,Map<String,Integer>>> maps = 
    new HashMap<String,Map<String,Map<String,Integer>>>();

  final static String CATID_FILE = "/semplest/data/dmoz/all.cids";
  Map<String,String> cids = catUtils.catId( CATID_FILE ); 
 
  final static String DESC_FILE = "/semplest/data/dmoz/all.descs";
  // ---------------------------------------------------------------------
  // ctr
  public dmozUtils(String d, String e){ 
    dir = d; ending = e; 
    for( String topl: topls )
      maps.put( topl, null );
  }

  //- public interface --------------
  Map<String,Map<String,Integer>> getTlWcs( String tl ){
    if( maps.get( tl ) == null )
      maps.put( tl, load( tl ));
    return maps.get( tl );
  }
  
    // get wordcount for a single category
  Map<String,Integer> getWc( String cat ){
    String tl = catUtils.topl( cat );
    Map<String,Integer> wc = getTlWcs( tl ).get( cat );
    return wc;
  }

  // get wordcounts for an array of categories
  Map<String,Map<String,Integer>> getWcs( String[] cats ){
    Map<String,Map<String,Integer>> omap = 
      new HashMap<String,Map<String,Integer>>();
    for( String cat: cats )
      if( getWc( cat ) != null )
        omap.put( cat, getWc( cat));
    System.out.println("getWcs: Got " + omap.size() + " word counts");
    return omap;
  }
  
  // return single wordcount for a category and all its descendants 
  Map<String,Integer> sumWc( String c ){
    String[] cats = catUtils.descendants( cids, c );
    System.out.print("Creating a single wc for " + c );
    System.out.println(" " + cats.length + " descendants..");
    Map<String,Map<String,Integer>> t = 
      new HashMap<String,Map<String,Integer>>();
    for( String cat: cats )
      if( getWc( cat ) != null )
        t.put( cat, getWc( cat ));
    System.out.println( "Summing " + t.size() + " word-counts" );
    return vsUtils.cSum( t );
  }

  // combine the word-counts for an array of categories 
  Map<String,Integer> ccombine( String[] cats ){
    Map<String,Map<String,Integer>> t = 
      new HashMap<String,Map<String,Integer>>();
    for( String cat: cats )
      t.put( cat, sumWc( cat ));
    System.out.print( "Adding : " + cats.length + " cats" );
    return vsUtils.cSum( t );
  }
  // combine the word-counts for an array of categories 
  Map<String,Integer> ccombine( String[] cats, String url ){
    Map<String,Map<String,Integer>> t = 
      new HashMap<String,Map<String,Integer>>();
    for( String cat: cats )
      t.put( cat, sumWc( cat ));
    System.out.print( "Combining : " + cats.length + " cats with url" );
    return vsUtils.cCombine( t, url );
  }

  
  //-----------------------------------------------------------------
  private Map<String,Map<String,Integer>> load( String tl ){
    String f = dir + tl + ending;
    if( maps.containsKey( tl )){
      System.out.print("\nLoading " + f + "....");
      return ioUtils.readWcs( f );
    } 
    else return new HashMap<String,Map<String,Integer>>();
  }
  //-------------------
  private static Map<String,Integer> dFilter( Map<String,Integer> wc){
    Map<String,Integer> omap = new HashMap<String,Integer>();
    for( Map.Entry<String,Integer> e: wc.entrySet() )
      if( dictUtils.ngdfilter( e.getKey() ))
        omap.put( e.getKey(), e.getValue());
    return omap;
  }
  // Choose only cats in "topls"
  private static String[] cFilter( String[] cats ){
    ArrayList<String> al = new ArrayList<String>();
    for( String cat: cats)
      if( Arrays.asList( topls ).contains( catUtils.topl( cat ) ))
        al.add( cat );
    return al.toArray( new String[]{} );
  }
  
  // - Testing ----------------------------------------------------
  public static void interactiveTest() throws Exception {
    String DIR = "/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/";
    String ENDING = ".2";
    int NUM_RESULTS = 50;
    dmozUtils du = new dmozUtils( DIR, ENDING );
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
    
    // Lucene
    DmozLucene dl = new DmozLucene();
    DmozLucene.loadDesc(dl, DESC_FILE );

    // Get Input from user in a loop
    while (true) {
      System.out.printf("Enter keywords : ");
      String q = br.readLine();
      System.out.printf("(Optional) Url : ");
      String url = br.readLine();

      // Get categories from Lucene, choose only thos in topl
      String[] cats = dl.search( TextUtils.stemvString( q )); 
      String[] fcats = cFilter( cats ); 
      System.out.printf("Using %d of %d cats returned by Lucene\n", 
          fcats.length, cats.length );

      // Add
      Map<String,Integer> res = du.ccombine( fcats );
      Map<String,Integer> fres = dFilter( res );
      System.out.printf("\n--------------------------\n");
      System.out.printf("\nKeeping %d of %d results \n", 
          fres.size(), res.size() );
      System.out.printf("Printing first %d results from summing %d cats\n\n",
          NUM_RESULTS,  fcats.length);
      jUtils.printMap( jUtils.take( jUtils.smap( fres ), NUM_RESULTS) );
      System.out.printf("\n--------------------------\n");

      // Combine
      if( TextUtils.isValidUrl( url )){
        Map<String,Integer> wres = du.ccombine( fcats, url );
        Map<String,Integer> fwres = dFilter( wres );
        System.out.printf("\n--------------------------\n");
        System.out.printf("\nKeeping %d of %d results \n", 
            fwres.size(), wres.size() );
        System.out.printf("First %d results combining relative to %s\n\n", 
            NUM_RESULTS,  url);
        jUtils.printMap( jUtils.take( jUtils.smap( fwres ), NUM_RESULTS) );
        System.out.printf("\n--------------------------\n");
      }
    }
  }

  // -------------------------
  public static void main (String[] args) throws Exception {
    interactiveTest();
  }
}
