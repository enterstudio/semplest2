package semplest.keywords.javautils; 

import java.io.File;
import java.io.IOError;
import java.io.IOException;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.Iterator;

// Class to test LSA implementation
public class lsaTests {

  public static final String suffix = ".st";

  public String file;
  public LSA lsa;

  // ctor
  public lsaTests(String f){
    file = f;
    lsa = new LSA(f + suffix);
  }

  //-----------------------------------------------------
  // Utilities --------- 
  public void vPrint(double[] v){
    for(int i=0; i<v.length; i++)
      System.out.printf("%3d:%5.6f\t",i,v[i]);
    System.out.println(v.length);
  }
  public void vPrint(double[] v1, double[] v2){
    if( v1.length != v2.length ) return;
    for(int i=0; i<v1.length; i++)
      if( i < 100 )
        if( v1[i] != v2[i] )
          System.out.printf("%3d : %10.8f, %10.8f\n",i,v1[i], v2[i]);
  }

  public int matchDistance( int doci, int n){
    int[] bestDocs = lsa.similarDocs( ioUtils.docVector(file,doci) );
    int dsum = 0; 
    for(int i = 0; i < n; i++)
      dsum += Math.abs( doci - bestDocs[i] ) - i;
    return (dsum / n);
  }
  
  // Tests ------------------------------------------------------------
  public void printMatches(int doci, int n){
    System.out.printf("\n\nDoc Matches :: ");
    int[] doc = ioUtils.docVector(file, doci );
    int[] rdoc = lsa.svd.document(doci);
    int[] bestDocs = lsa.similarDocs( doc );
    long error = vecUtils.absdiff( doc, rdoc );
    int perror = (int) Math.ceil( error * 100 / vecUtils.sum( doc ));
    System.out.printf("Doc  error: (p %d, abs %d)\n", perror, error ); 
    System.out.printf("Doc  words: %s\n",getTopWords(  doc, 8)); 
    System.out.printf("RDoc words: %s\n",getTopWords( rdoc, 8)); 
    
    printDocInfo(doc);
    System.out.printf("%orig %d %s\n", 0, doci, dictUtils.docs[ doci ] );
    for(int i = 0; i < n; i++){
      System.out.printf("%4d %d %s\n\t%s\n", i, bestDocs[i], 
        dictUtils.docs[ bestDocs[i] ], getTopWords( bestDocs[i] ));
    }
  }
  public void printDocInfo( int[] doc ){
    System.out.printf("words(uniq,tot): %d,%d\n", vecUtils.nonzero( doc),
        vecUtils.sum( doc )); 
  }
  // Get the top words for a document/category (mci)
  public String getTopWords (int di){
    int[] mci = lsa.topWords( di );
    String os = "";
    for(int i=0; i<mci.length; i++)
      os = os + dictUtils.dictwi.get(mci[i]) + ",";
    return os;
  }
  // Get the top words for a document/category (subspace)
  public String getTopWords (int di, int no){
    int[] topWi = lsa.topWords( di );
    String os = "";
    for(int i = topWi.length-1; i > topWi.length - no; i--)
      os = os + dictUtils.dictwi.get(topWi[i] ) + ",";
    return os;
  }
  // Get the top words for a document
  public String getTopWords (int[] doc, int no){
    int[] topWi = vecUtils.sortIndices( doc);
    String os = "";
    for(int i=topWi.length-1; i > topWi.length - no; i--)
      os = os + dictUtils.dictwi.get( topWi[i] ) + ",";
    return os;
  }

  // a doc's distance to itself in the subspace (rounding error)
  public double distanceToItself(int di){
    int[] doc = ioUtils.docVector( file, di );
    double dist = vecUtils.ncdist( lsa.svd.toSSDoc(doc), lsa.svd.dmat[di] );
    return dist;
  }
  public void printDI( int di ){
    System.out.printf("%d : dist to itself %10.2f\n",di, distanceToItself(di));
  }
  // Test the cross correlation accuracy (orig space vs subspace)
  public double ccError(int no){
    double d[][]   = new double[ no ][];
    double dss[][] = new double[ no ][];
    for(int i = 0; i< no; i++){
      d[i]  = lsa.svd.toSSDoc( ioUtils.docVector(file, i ));
      dss[i] = lsa.svd.dmat[ i ];
    }
    double osum = 0, ssum = 0;
    for(int i = 0; i< no; i++)
      for( int j = 0; j< no; j++){
        double dd = vecUtils.ncdist( d[i], d[j] );
        double sd = vecUtils.ncdist( dss[i], dss[j] );
        osum += dd;
        ssum += sd;
        //        System.out.printf("%d,%d : %8.2f, %8.2f\n", i,j, dd, sd );
      }
    return  Math.abs( osum - ssum ) / (no * no * 1.0);
  }
  public void printCCE( int no ){
    System.out.printf("Cross correlation Error to (%d) : %8.2f\n",
        no, ccError(no));
  }

  // Test the accuracy of wordcount recreation ifrom subspace
  public double wcError(int num){
    long error = 0;
    for(int i = 0; i< num; i++){
      int d = lsa.randomDoc();
      int[] doc  = ioUtils.docVector( file, d );
      int[] rdoc = lsa.svd.document( d );
      error += vecUtils.absdiff( doc, rdoc);
    }
    return error / num;
  }
  public void printWCE( int no ){
    System.out.printf("Average Wordcount Error : %8.2f\n", wcError(no));
  }


  // ---------------------------------------------------------------
  public static final String ddir = "/semplest/data/dmoz/all/";
  public static final String dtfile = "hCounts.txt";
  public static final String dipath = ddir + dtfile;
  public static final int num = 10;


  public static void main(String[] args){
    String file = dipath;
    if( args.length > 0 )
      file = args[0];

    lsaTests t = new lsaTests( file );
    //    t.lsa.svd.tfIdf();

    //    t.printCCE( num );
    //    t.printDI( num );
    t.printWCE( num );
    for( int i = 0; i < 10; i++ )
      t.printMatches( t.lsa.randomDoc(), num );
    //      t.printMatches( i,  num );
  }
}
