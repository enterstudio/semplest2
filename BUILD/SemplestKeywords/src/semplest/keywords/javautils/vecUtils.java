package semplest.keywords.javautils;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Comparator;

public class vecUtils {
  
  //---- normalize vector (L2 norm) O(s)
  public static double[] normalize( double[] vec){
    double[] res = new double[ vec.length ];
    double length = 0;
    for (double v: vec )
      length += v * v;
    length = Math.sqrt( length );
    for( int i=0; i< vec.length; i++)
      res[i] = vec[i] / length;
    return res;
  }

  // --- sum of a vector
  public static double sum( double[] vec){
    double sum = 0;
    for (double v: vec )
      sum += v;
    return sum;
  }
  public static long sum( int[] vec){
    long sum = 0;
    for (int v: vec )
      if( v != 0)
        sum += v;
    return sum;
  }
  public static int nonzero( int[] vec){
    int s = 0;
    for (int v: vec )
      if( v > 0 )
        s += 1;
    return s;
  }
  // magnitude
  public static double magnitude( double[] v){
    double sum = 0;
    for(int i=0; i< v.length; i++)
      sum += v[i] * v[i];
    return Math.sqrt( sum );
  }
  public static long magnitude( int[] v){
    long sum = 0;
    for(int i=0; i< v.length; i++)
      sum += v[i] * v[i];
    return Math.round((Math.sqrt( sum )));
  }

  // dot product
  public static double dotP(double[] v1, double[] v2){
    assert ( v1.length == v2.length );
    double sum = 0;
    for( int i=0; i< v1.length; i++)
      sum += v1[i] * v2[i];
    return sum;
  }
  public static long dotP(int[] v1, int[] v2){
    assert ( v1.length == v2.length );
    long sum = 0;
    for( int i=0; i< v1.length; i++)
      if( v1[i] != 0 && v2[i] != 0)
        sum += v1[i] * v2[i];
    return sum;
  }

  // compare vectors (first normalize) 
  public static double ncdist (double[] v1, double[] v2){
    assert ( v1.length == v2.length );
    double dotp = dotP(v1,v2);
    if ( dotp < 1.0e-45f ) return 2 * Math.PI;
    double m12 = magnitude( v1 ) * magnitude( v2 );
    m12 = Math.max( m12, 1.0e-45f );
    double ndist =  dotp / m12;
    ndist = ndist > 1 ? 1 : ndist;
    ndist = ndist < -1 ? -1 : ndist;
    return Math.acos(ndist);
  }
  public static double ncdist (int[] v1, int[] v2){
    assert ( v1.length == v2.length );
    long dotp = dotP(v1,v2);
    if ( dotp == 0 ) return 2 * Math.PI;
    long m12 = magnitude( v1 ) * magnitude( v2 );
    m12 = Math.max( m12, 1 );
    double ndist = (dotp * 1.0) / (m12 * 1.0);
    ndist = ndist > 1 ? 1 : ndist;
    ndist = ndist < -1 ? -1 : ndist;
    return Math.acos(ndist);
  }
  public static long absdiff(int[] v1, int[] v2){
    assert ( v1.length == v2.length );
    long sum = 0;
    for( int i=0; i<v1.length; i++)
      if ( v1[i] != 0 || v2[0] != 0)
        sum += Math.abs( v1[i] - v2[i] );
    return sum;
  }

  // sort vector and return indices  
  public static int[] sortIndices( int[] v){
    TreeMap<Integer,List<Integer>> map = new TreeMap<Integer,List<Integer>>();
    for(int i = 0; i < v.length; i++) {
      List<Integer> ind = map.get(v[i]);
      if(ind == null){
        ind = new ArrayList<Integer>();
        map.put(v[i], ind);
      }
      ind.add(i);
    }
    // Now flatten the list
    List<Integer> indices = new ArrayList<Integer>();
    for(List<Integer> arr : map.values())
      indices.addAll(arr);
    return toint( indices.toArray(new Integer[indices.size() ])); 
  }
  // sort vector and return indices  
  public static int[] sortIndices( double[] v){
    TreeMap<Double,List<Integer>> map = new TreeMap<Double,List<Integer>>();
    for(int i = 0; i < v.length; i++) {
      List<Integer> ind = map.get(v[i]);
      if(ind == null){
        ind = new ArrayList<Integer>();
        map.put(v[i], ind);
      }
      ind.add(i);
    }
    // Now flatten the list
    List<Integer> indices = new ArrayList<Integer>();
    for(List<Integer> arr : map.values())
      indices.addAll(arr);
    return toint( indices.toArray(new Integer[indices.size() ])); 
  }
  //----- 
  public static int[] reverse ( int[] v){
    int[] res = new int[ v.length ];
    for( int i=0, j=v.length-1; i<v.length; i++, j--)
      res[j] = v[i];
    return res;
  }

  // ints 
  public static int[] toint ( Integer[] v){
    int[] res = new int[ v.length ];
    for( int i=0; i<v.length; i++)
      res[i] = v[i];
    return res;
  }
  public static int[][] toint( double[][] v){
    int[][] out = new int[v.length][v[0].length];
    for(int i = 0; i < v.length; i++)
      for(int j = 0; j < v[i].length; j++)
        out[i][j] = (int) v[i][j];
    return out;
  }

    // ---------------------------------------------------------------
    public static void main(String[] args) {
      int[] t = { 2, 5, 6, 7, 4, 2, 3, 5, 9, 2};
      int[] tsi = sortIndices( t );
      for(int i : tsi )
        System.out.printf("%d,",i);

    }
  }
