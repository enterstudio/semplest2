package semplest.bidding.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import semplest.bidding.optimization.LBFGSSolver;

public class ioUtils {
	
	private static final Logger logger = Logger.getLogger(ioUtils.class);
  
  // returns nth line of file (indexed from 0) as string
  public static String readLine(String file, int n){
    try {
      BufferedReader r = new BufferedReader(new FileReader(file));
      for( int i=0; i< n; i++)
        r.readLine();
      return r.readLine();
    } catch (Exception e) {
    	logger.error("Problem", e);
      return "";
    }
  }

  // returns lines of file specified and returns as string array
  public static String[] readLine(String file, int[] is){
    Arrays.sort( is );
    int maxi = is[is.length-1];
    String[] lines = new String[ is.length ];

    try {
      BufferedReader r = new BufferedReader(new FileReader(file));
      for( int i=0; i< maxi; i++){
        String line = r.readLine();
        for(int j=0; j< is.length; j++)
          if ( i == is[j] ){
            lines[j] = line;
            break;
          }
      }
    } catch (Exception e) {
    	logger.error("Problem", e);
    }
    return lines;
  }
  // reads file and returns it as an array of strings
  public static ArrayList<String> readFile(String file){
    ArrayList<String> arraybuf = new ArrayList<String>();
    try {
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String line;
      while ((line = br.readLine()) != null) 
        arraybuf.add( line );
    } catch ( Exception e ){ logger.error("Problem", e);}
    return arraybuf; 
  }

  // same as readfile but only returns the specified column 
  public static ArrayList<String> readFile(String file, int col){
    ArrayList<String> arraybuf = new ArrayList<String>();
    try {
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String line;
      while ((line = br.readLine()) != null){
        String[] cols = line.split("\\s+");
        if( cols.length > col )
          arraybuf.add( cols[col] );
      }
    } catch ( Exception e ){ logger.error("Problem", e);}
    return arraybuf; 
  }
  
  // same as readfile but only returns columns 
  public static ArrayList<String[]> readCols(String file ){
    ArrayList<String[]> arraybuf = new ArrayList<String[]>();
    try {
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String line;
      while ((line = br.readLine()) != null)
          arraybuf.add( line.split("\\s+" ));
    } catch ( Exception e ){ logger.error("Problem", e);}
    return arraybuf; 
  }
  // reads file and returns first two columns as a HashMap 
  public static HashMap<String,String> readPair(String file){
    HashMap<String,String> hash = new HashMap<String, String>();
    try {
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String line;
      while ((line = br.readLine()) != null){
        String[] cols = line.split("\\s+");
        if( cols.length >= 2  )
          hash.put( cols[0], cols[1] );
      }
    } catch ( Exception e ){ logger.error("Problem", e);}
    return hash; 
  }
  // reads file and returns it as a map of strings with index
  public static HashMap<String,Integer> readFileIndex(String file){
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    try {
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String line;
      int index = 0;
      while ((line = br.readLine()) != null){
        map.put( line, index );
        index++;
      }
    } catch ( Exception e ){ logger.error("Problem", e);}
    return map; 
  }
  
  // same as readFileIndex but picks out a column in the file (indexed from 0)
  public static HashMap<String,Integer> readFileIndex(String file, int col){
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    try {
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String line;
      int index = 0;
      while ((line = br.readLine()) != null){ 
        String[] cols = line.split("\\s+");
        if( cols.length > col )
          map.put( cols[col], index );
        index++;
      }
    } catch ( Exception e ){ logger.error("Problem", e);}
    return map; 
  }
  
  // Returns the dmoz descriptions as a Map<category><description> 
  static HashMap<String,String> readDescs( String f){
    HashMap<String,String> map = new HashMap<String,String>();
    try {
      BufferedReader r = new BufferedReader(new FileReader(f));
      String line;
      while(( line =  r.readLine()) != null ){
        String[] cols = line.split(" : ");
        if( cols.length >= 2 )
          map.put( cols[0].trim(), cols[1].trim() );
      }
    } catch (Exception e) {
    	logger.error("Problem", e);
    }
    return map;
  }
  
  // Returns the dmoz wordcounts as a Map<category><counts> 
  static HashMap<String,String> readWcounts( String f){
    HashMap<String,String> map = new HashMap<String,String>();
    try {
      BufferedReader r = new BufferedReader(new FileReader(f));
      String line;
      while(( line =  r.readLine()) != null ){
        String[] cols = line.split("\\s+");
        if( cols.length >= 2 ){
          String cat = cols[0].split(":")[0];
          String tail = mkString( 
              java.util.Arrays.copyOfRange( cols, 1, cols.length)," ");
          map.put( cat, tail );
        }
      }
    } catch (Exception e) {
    	logger.error("Problem", e);
    }
    return map;
  }
  // Returns the dmoz wordcounts as a Map<category, Map<word,count>> 
  static HashMap<String,HashMap<String,Integer>> readWcs( String f ){
    HashMap<String,HashMap<String,Integer>> map = 
      new HashMap<String,HashMap<String,Integer>>();
    try {
      BufferedReader r = new BufferedReader(new FileReader(f));
      String line;
      while(( line =  r.readLine()) != null ){
        String[] cols = line.split("\\s+");
        if( cols.length >= 2 ){
          String tail = mkString( 
              java.util.Arrays.copyOfRange( cols, 1, cols.length)," ");
          map.put( cols[0].split(":")[0], toWc( tail ) );
        }
      }
    } catch (Exception e) {
    	logger.error("Problem", e);
    }
    return map;
  }
  //-------------------------------------------------- 
  // Convert an array of strings to one string.
  // Put the 'separator' string between each element.
  public static String mkString(String[] a, String separator) {
    StringBuffer result = new StringBuffer();
    if (a.length > 0) {
      result.append(a[0]);
      for (int i=1; i<a.length; i++) {
        result.append(separator);
        result.append(a[i]);
      }
    }
    return result.toString();
  }
  // convert a semplest wordcount String to a Hashmap<String,Integer>
  public static HashMap<String,Integer> toWc (String s){
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    String[] wcs = s.split("\\s+");
    for(String wc: wcs){
      String[] wca = wc.split(":");
      if( wca.length < 2 ) continue;
      String w = wca[0];
      Integer c = new Integer(wca[1]);
      map.put( w, c );
    }
    return map;
  }


  //Returns the lines of a file as a HashMap with the key as the category of the line
  public static HashMap<String,String> file2Hash(String f){
	  HashMap<String,String> map = new HashMap<String,String>();
	    try {
	      BufferedReader r = new BufferedReader(new FileReader(f));
	      String line;
	      while(( line =  r.readLine()) != null ){
	        String[] cols = line.split(" : ");
	        if( cols.length >= 2 )
	          map.put( cols[0].trim(), line );
	      }
	    } catch (Exception e) {
	    	logger.error("Problem", e);
	    }
	    return map;
  }


  // read a matrix of numbers
  public static double[][] readMatrix(String file){

    // create and initalize
    double[][] mat = new double[0][0];

    try {
      // Get header
      InputStream fis = new FileInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(fis, 
            Charset.forName("UTF-8")));
      String header = br.readLine();
      String[] rc = header.split("\\s+");
      if( rc.length != 2 ) return mat;
      int rows = new Integer(rc[0]);
      int cols = new Integer(rc[1]);

      // initalize
      mat = new double[rows][cols];
      for(int i=0; i<rows; i++)
        for(int j=0; j<cols; j++)
          mat[i][j] = 0;

      // fill where possible
      String line;
      int row = 0;
      while ((line = br.readLine()) != null && row < rows ){ 
        String[] values = line.split("\\s+");
        int maxi = Math.min( values.length, cols );
        for( int col = 0; col < maxi; col++ )
          mat[ row ][ col ] = new Float( values[ col ]);
        row++;
      }
    } catch (Exception e ){
    	logger.error("Problem", e);
    }
    return mat;
  }
  // Matrix --------
  public static void printVec(double[] m){
    System.out.printf("%d: ", m.length);  
    for(int i=0; i<m.length; i++)
      System.out.printf("%7.5f ",m[i]);
    System.out.printf("\n");  
  }
  public static void printVec(int[] m){
    System.out.printf("%d: ", m.length);  
    for(int i=0; i<m.length; i++)
      System.out.printf("%3d ",m[i]);
    System.out.printf("\n");  
  }
  public static void printMatrix(double[][] m){
    System.out.printf("(%d,%d)\n   ", m.length, m[0].length );
    for(int i=0; i<m[0].length; i++)
      System.out.printf("%8d",i);
    for(int i=0; i<m.length; i++){
      System.out.printf("\n%3d",i);  
      for(int j=0; j < m[i].length; j++)
        System.out.printf("%8.2f", m[i][j]);
    }
    System.out.println();
  }
  public static void printMatrix(int[][] m){
    System.out.printf("(%d,%d)\n   ", m.length, m[0].length );
    for(int i=0; i<m[0].length; i++)
      System.out.printf("%7d",i);
    for(int i=0; i<m.length; i++){
      System.out.printf("\n%3d",i);  
      for(int j=0; j < m[i].length; j++)
        System.out.printf("%7d", m[i][j]);
    }
    System.out.println();
  }
  // semplest ----------
  // String is in semplest format (id:count word1:count word2:count ...)
  // return the id 
  public static String docId(String line ){
    return( line.split("\\s+")[0].split(":")[0] );
  }
  
  // return a map of the words and count
  public static HashMap<String,Integer> docWordMap(String line){
    String[] tokens = line.split("\\s+");
    if( tokens.length < 2) return null; 
    
    // words
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    for(int i = 1; i < tokens.length; i++){
      String[] wc = tokens[i].split(":");
      String word = wc[0];
      int wcount = -1;
      if( wc.length >= 2 ){
        try {
          wcount = new Integer( wc[1] ); 
        } catch (Exception e ) {
        	logger.error("Problem", e);
        }
        if( wcount != -1 )
          map.put( word, wcount);
      }
    }
    return map;
  }
  // return a string of the words
  public static String docWords(String line){
    String[] tokens = line.split("\\s+");
    if( tokens.length < 2) return null; 
    
    // words
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    String words = "";
    for(int i = 1; i < tokens.length; i++)
      words += tokens[i].split(":")[0] + " ";
    return words;
  }
  public static HashMap<String,String> topWords(String file ){
    HashMap<String,String> map = new HashMap<String, String>();
    try {
      BufferedReader br = new BufferedReader(new FileReader( file )); 
      String line;
      while ((line = br.readLine()) != null){ 
        String id = docId( line );
        String words = docWords( line );
        map.put(id, words);
      }
    } catch ( Exception e ){ logger.error("Problem", e);}
    return map;
  }
  
  // mallet -----------------
  // String is in semplest format (id:count word1:count word2:count ...)
  // returns string in mallet format Array "id" "label" "word word word...."
  public static ArrayList<String> malletizeLine( String line ){
    String id = "";
    String label = "";
    String words = "";

    String[] tokens = line.split("\\s+");

    // id and label
    String idtoken = tokens[0];
    String[] ids = idtoken.split(":");
    id = ids[0];
    if( ids.length >= 2) label = ids[1];

    // words
    for(int i = 1; i < tokens.length; i++){
      String word = "";
      int wcount = 0;
      String wordstring = "";

      String[] wordcount = tokens[i].split(":");
      word = wordcount[0];
      if( wordcount.length >= 2 ){
        try {
          wcount = new Integer( wordcount[1] ).intValue(); 
        } catch (Exception e ) {
        	logger.error("Problem", e);
        }
        for( int j=0; j< wcount; j++)
          wordstring = wordstring + word + " ";
        words = words + wordstring;
      }
    }
    // construct and return array
    ArrayList<String> arraybuf = new ArrayList<String>();
    arraybuf.add( id ); 
    arraybuf.add( label ); 
    arraybuf.add( words ); 
    return arraybuf;
  }
  
  
  //Split a line and return and ArrayList of all the elements in the line with format
  // element:count (only returns "element", not "count")
  public static ArrayList<String> line2ArrayList(String line){
	  String[] tokens = line.split("\\s+");
	  ArrayList<String> elem = new ArrayList<String>();
	  for(int i=0; i<tokens.length;i++){
		  elem.add(tokens[i].split(":")[0]);
	  }
	  return elem;
  }
  
  //Reads a file and
  //return a Hashmap<Sring nameCategory, ArrayList wordsIncategory>
  public static HashMap<String, ArrayList<String>> file2WordMap(String filePath){
	  ArrayList<String> lines = readFile( filePath );
	  String categname;
	  HashMap<String, ArrayList<String>> wordMap= new HashMap<String, ArrayList<String>>();
      for( String line : lines ){
      	ArrayList<String> tokens = line2ArrayList( line );
      	categname=tokens.remove(0);
      	wordMap.put(categname, tokens);
      }
      return wordMap;
  }
  // doc vector of malletized line
  public static String docIdM(String line ){
    String[] tokens = line.split("\\s+");
    if( tokens.length < 3 ) return "";
    else return tokens[1];
  }
  

  //-------------------------------------------------------------
  public static void main (String[] args){

    String f = "/semplest/data/dmoz/all/hCounts.txt.tw";
    String h = "top/sports/equestrian/breeds/spanish_horses";
    HashMap<String,String> wcs = readWcounts(f);
    System.out.println( wcs.get( h ));

  }
}

