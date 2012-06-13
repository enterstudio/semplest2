package semplest.keywords.javautils;

import java.lang.Math;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

import semplest.keywords.properties.ProjectProperties;

/*
 * Vector Space (vs) tool-box
 * Treats a word-count as a vector in the word-space
 * The basic vector here is a HashMap<String,Integer>
 * 
 * Note; To use counts and avoid fractions, the UNIT vector
 * has length = 1000 rather than 1.
 * 
 */
public class vsUtils {

  private static final int UNIT = 1000;    // The unit-vector length

  // - static interface -----------------------------------------------------------
  // normalize to UNIT length (L2 norm) 
  public static HashMap<String,Integer> cNormalize( HashMap<String,Integer>  wc){
    HashMap<String,Integer> omap = new HashMap<String,Integer>();
    Double d = Math.max( Math.sqrt( sSquares( wc ) ), 1 );
    for( Map.Entry<String,Integer> e: wc.entrySet() )
      omap.put( e.getKey(), (int) Math.round( e.getValue() * UNIT / d ));
    return omap;
  }
  // cosine distance between two vectors (word-counts)
  public static Double cDist( HashMap<String,Integer> a, HashMap<String,Integer> b){
    HashMap<String,Integer> na = cNormalize( a );
    HashMap<String,Integer> nb = cNormalize( b );
    Double dotp = 0.0;
    for( Map.Entry<String,Integer> e: na.entrySet() )
      if( nb.containsKey( e.getKey() ) )
        dotp += e.getValue() * nb.get( e.getKey() );
    return Math.acos( dotp / (UNIT * UNIT * 1.0) );
  }
  // Combine a bunch of vectors (wcs), based on their distance to a reference wc
  public static HashMap<String,Integer> cCombine( 
      HashMap<String, HashMap<String,Integer>> wcs, HashMap<String,Integer> rv ){
    HashMap<String,Double> omap = new HashMap<String,Double>();
    for( Map.Entry<String,HashMap<String,Integer>> wc: wcs.entrySet() ) { 
      Double w = Math.PI/2.0 - cDist( wc.getValue(),rv );  // the weight
      HashMap<String,Integer> nwc = cNormalize( wc.getValue() );
      for( Map.Entry<String,Integer> e: nwc.entrySet() )
        if( omap.containsKey( e.getKey() ) )
          omap.put( e.getKey(), omap.get( e.getKey() ) + e.getValue() * w );
        else
          omap.put( e.getKey(), e.getValue() * w );
    }
    // convert to int, normalize, return
    HashMap<String,Integer> rmap = new HashMap<String,Integer>();
    for( Map.Entry<String,Double> e: omap.entrySet() )
      rmap.put( e.getKey(), (int) Math.round( e.getValue()) );

    return cNormalize( rmap );
  }
  // returns map sorted by word-count in descending order
  public static TreeSet sortMap( HashMap<String,Integer> wc ){
    TreeSet<Map.Entry<String,Integer>> tm = new TreeSet<Map.Entry<String,Integer>>(
        new Comparator<Map.Entry<String,Integer>>(){
          @Override public int compare( Map.Entry<String,Integer> a, 
            Map.Entry<String,Integer> b){ 
              return b.getValue().compareTo( a.getValue());}
          });
    
    tm.addAll( wc.entrySet() );
    return tm;
  }
  // - private helpers -----------------------------------------------
  private static Integer sSquares( HashMap<String,Integer> wc ){
    Integer res = 0;
    for( Map.Entry<String,Integer> e: wc.entrySet() )
      res += e.getValue() * e.getValue();
    return res;
  }

  // - pretty printers ------------
  private static void pWc( String label, HashMap<String,Integer> wc, int n ){
    TreeSet<Map.Entry<String,Integer>> rv = sortMap( wc );
    System.out.print( label + " :: \t" );
    int count = 0;
    for( Map.Entry<String,Integer> e: rv ){
      if ( count > n ) break;
      System.out.printf("%s:%d, ", e.getKey(), e.getValue());
      count++;
    }
    System.out.println();
  }

  //- test ------------------------------------
  // test helper
  private static HashMap<String,Integer> makeM(String ms){
    HashMap<String,Integer> rv = new HashMap<String,Integer>();
    for( String e: ms.split(","))
      rv.put( e.split("->")[0], new Integer( e.split("->")[1]));
    return rv;
  }
  // ------------
  private static void test (){
    HashMap<String,Integer> rv = makeM("a->1,b->1,c->1,d->1");
    HashMap<String,HashMap<String,Integer>> cs = 
      new HashMap<String,HashMap<String,Integer>>();
    cs.put( "a0.5", makeM("a->1,b->1,c->1"));
    cs.put( "b0.0", makeM("a->1,b->1,c->1,d->1"));
    cs.put( "c1.0", makeM("c->1,d->1,e->1"));
    cs.put( "d1.5", makeM("e->1,f->1,g->1"));


    HashMap<String,Integer> cc = cCombine( cs, rv );
    System.out.println( cc );
  }

  // Combine the first n categories from "news bigrams"
  private static void newsTest(int n){
    // read in n categories from news bigrams
    String file = "/semplest/data/dmoz/multiwords/news.txt.2";
    HashMap<String,HashMap<String,Integer>> wcs = ioUtils.readWcs( file, n );
   
    // create a reference word-count
    HashMap<String,Integer> rv = makeM( "blog+post->1,blog+column->1," + 
        "recent+blog->1,feature+post->1,student+union->1,men+basketball->1");

    // combine them (remember how long it took)
    long start = System.currentTimeMillis();
    HashMap<String,Integer> cc = cCombine( wcs, rv );
    long end = System.currentTimeMillis();

    // print the top 10 words (by count) and the time it took to combine 
    pWc("News"+n, cc, 10 );
    System.out.println( "Combining " + n + " cats took " + (end-start) + "ms");
  }

  //-------------------------------------------------------------
  public static void main (String[] args){
    newsTest( 100 );
  }
}

