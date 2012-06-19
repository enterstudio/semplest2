package semplest.keywords.javautils;

import java.lang.Math;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * Vector Space (vs) tool-box
 * Treats a word-count as a vector in the word-space
 * The basic word-count vector here is a HashMap<String,Integer>
 * 
 * Note; To use counts and avoid fractions, the UNIT vector
 * has length = 1000 rather than 1.
 * 
 */
public class vsUtils {

  private static final int UNIT = 1000;    // The unit-vector length

  // - static interface -------------------------------------------------------
  // length of the vector (L2 norm)
  public static Integer cLen( HashMap<String,Integer> wc){
    return (int) Math.round( Math.sqrt( sSquares( wc ) ) ); }
  // normalize vector to UNIT length (L2 norm) 
  public static Double cNorm( HashMap<String,Integer> wc){
    return ( UNIT * 1.0 / Math.max( Math.sqrt( sSquares( wc ) ), 1.0 ));}
  public static HashMap<String,Integer> cNormalize(HashMap<String,Integer> wc){
    HashMap<String,Integer> omap = new HashMap<String,Integer>();
    Double w = cNorm( wc );
    for( Map.Entry<String,Integer> e: wc.entrySet() )
      omap.put( e.getKey(), (int) Math.round( e.getValue() * w ));
    return omap;
  }
  // add together a collection of vectors (wc) 
  public static HashMap<String,Integer> cAdd( HashMap<String, 
      HashMap<String,Integer>>  wcs){
    HashMap<String,Integer> omap = new HashMap<String,Integer>();
    for( Map.Entry<String,HashMap<String,Integer>> wc: wcs.entrySet() ) 
      for( Map.Entry<String,Integer> e: wc.getValue().entrySet() )
        omap.put( e.getKey(), (omap.containsKey(e.getKey()) ? 
            omap.get(e.getKey()) : 0) + e.getValue());  
    return omap;
  }
  // cosine distance between two vectors 
  // [Note:] we check intersection rather than equality of keywords (as ngram)
  public static Double cDist( HashMap<String,Integer> a,
      HashMap<String,Integer> b){
    HashMap<List<String>,Integer> na = tokenize( cNormalize( a ));
    HashMap<List<String>,Integer> nb = tokenize( cNormalize( b ));
    Double dotp = 0.0;
    for( Map.Entry<List<String>,Integer> ae: na.entrySet() )
      for( Map.Entry<List<String>,Integer> be: nb.entrySet() ){
        ae.getKey().retainAll( be.getKey());
        if( ae.getKey().size() > 0)
          dotp += ae.getValue() * be.getValue();
      }
    return Math.acos( dotp / (UNIT * UNIT * 1.0) );
  }
  // break up ngram Hashmap into collection-of-words Hashmap
  private static HashMap<List<String>,Integer> tokenize( 
      HashMap<String,Integer> m){
    HashMap<List<String>,Integer> res = new HashMap<List<String>,Integer>();
    for( Map.Entry<String,Integer> e: m.entrySet() )
      res.put( new ArrayList( Arrays.asList(e.getKey().split("\\+"))), 
          e.getValue()); 
    return res;
  }

  // Combine a bunch of vectors (wcs), based on their distance to a reference wc
  public static HashMap<String,Integer> cCombine( 
      HashMap<String, HashMap<String,Integer>> wcs, HashMap<String,Integer> rv){
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
  // top n words of word-count (based on count)
  public static String[] topWords( HashMap<String,Integer> wc, Integer n){
    Set<Map.Entry<String,Integer>> rv = jUtils.take( sortMap( wc ), n );
    Set<String> s = new HashSet<String>();
    for( Map.Entry<String,Integer> e: rv )
      s.add( e.getKey() );
    return s.toArray( new String[]{} );
  }
  //------------------------------------------------------------------------
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

  // - wc creator helpers ------------
  private static HashMap<String,Integer> cWc(String[] words ){
    HashMap<String,Integer> rv = new HashMap<String,Integer>();
    for( String w: words)
      rv.put( w, (rv.get(w) == null ? 0 : rv.get(w)) + 1 );
    return rv;
  }
  private static HashMap<String,Integer> cWc(String words ){ 
    return cWc( words.split("\\s+") );
  }
  // ---------------------------------------------------------------------
  //- tests ---------------------------------------------------------------
  private static void test(){
    HashMap<String,Integer> rv = cWc("a b c d");
    HashMap<String,HashMap<String,Integer>> cs = 
      new HashMap<String,HashMap<String,Integer>>();
    cs.put( "a0.5", cWc("a+x+y b+z+g c+g+h+u"));
    cs.put( "b0.0", cWc("a+f b+g c+g+o d+o+h"));
    cs.put( "c1.0", cWc("c+o d+h e+y"));
    cs.put( "d1.5", cWc("e+i f+h g+j"));

    HashMap<String,Integer> cc = cCombine( cs, rv );
    System.out.println( cc );
  }

  private static void Test(String ngramFile, String ancestor, String ref){
    // read in categories from file and pick out those with given ancestor
    HashMap<String,HashMap<String,Integer>> wcs = catUtils.family( 
        ioUtils.readWcs( ngramFile ), ancestor ); 
    
    // create a reference word-count
    HashMap<String,Integer> rv = cWc( ref );

    // combine them (and remember how long it took)
    long start = System.currentTimeMillis();
    HashMap<String,Integer> cc = cCombine( wcs, rv );
    long end = System.currentTimeMillis();

    // print the top 50 words (by count) and the time it took to combine 
    System.out.println( ioUtils.mkString( topWords( cc, 50 ), ", ") );
    System.out.println( "Combining " +wcs.size()+" cats took "
        +(end-start)+ "ms");
  }
  public static String[] generateNgrams(String basePath, String extension,  ArrayList<String> categories, String data, int numKw){
	    // read in categories from file and pick out those with categories selected
		  HashMap<String,HashMap<String,Integer>> wcs = new HashMap<String,HashMap<String,Integer>>();
		  for(String cat : categories){
			 //Building the nGramsFileName 	
			 String[] subCat = cat.split("/");
			 String file = basePath+subCat[1]+extension;
			 HashMap<String,HashMap<String,Integer>> wcsAux = catUtils.family( 
					 ioUtils.readWcs( file ), cat); 
			 wcs.putAll(wcsAux);
		  }
	    
	    // create a reference word-count
		System.out.println(data.length());
	    HashMap<String,Integer> rv = cWc( data );

	    // combine them (remember how long it took)
	    Long start = System.currentTimeMillis();
	    HashMap<String,Integer> cc = cCombine( wcs, rv );
	    System.out.println("Combine Categories seconds " + (System.currentTimeMillis()-start));
	    String [] kw = topWords( cc, numKw );

	    return kw;

}
  //-------------------------------------------------------------
  public static void main (String[] args){
    String file = "/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/shopping.2";
    String head = "top/shopping/flowers/florists/north_america";
    String rngs = "wedding+flowers flower+shops birthday+flowers" + 
        "wedding+bouquets flower+delivery fruit+baskets " + 
        "valentines+day flower+arrangements flowers+plants red+roses" + 
        "fresh+flowers single+rose flower+delivery" ;
    String rwords = "new york realestate autos " + 
        "business finance people politics travel sports " + 
        "wallstreet journal television radio" + 
        "newyork christian science monitor" ;
    Test( file, head, rngs );
  }
}

