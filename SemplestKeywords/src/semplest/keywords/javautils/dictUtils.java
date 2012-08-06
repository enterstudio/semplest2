package semplest.keywords.javautils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import semplest.keywords.properties.*;



public class dictUtils
{
  // Document Frequency (DF) 
  // the df is the log-frequency of word-appearances 
  // df( word) = log( # documents in which word appears)
  // SInce we have 300,000 docs, the max value is 18
  static int DF_THRESHOLD = 16;
  static int DF_NG_THRESHOLD = 16;
  static int DF_DEFAULT   = 16;

  // Dictionaty utilities --------------------------
  // the dictionary is made up of three maps 
  // 1) dict  ::  stem => word
  // 2) dicti ::  word => index
  // 3) dictwi::  index => word
  // a word is valid if its stem is in the dictionary
  static String dictfile  = ProjectProperties.dictfile;
  static String dffile    = ProjectProperties.dffile;
  static String docfile   = ProjectProperties.docfile;
  static String twfile    = ProjectProperties.twfile;

  public static Map<String,Integer> dicti = ioUtils.readFileIndex(dictfile, 1);
  public static Map<Integer,String> dictwi = invert(dicti);
  public static Map<String,String> dict = ioUtils.readPair(dictfile);
  public static Map<String,Integer> docsi =  ioUtils.readFileIndex(docfile);
  public static Map<Integer,String> docis = invert(docsi);
  public static final Map<String,String> docs = ioUtils.topWords(twfile);
  public static final Map<String,Integer> df = ioUtils.readCount(dffile);

  // ********* [Note:] Temporary solution. Need to restructure
  public static final Set<String> cw = CommonWordSet();

  /*
  // static methods to load paths from property file
  static {
  if(SEMplestService.properties==null){
  try{
  String PROPSFILE = "../SemplestServices/bin/system.properties";
  SEMplestService.properties = new Properties();
  FileInputStream is;
  is = new FileInputStream(PROPSFILE);
  SEMplestService.properties.load(is);
  is.close();
  } catch (Exception e){logger.error("Problem", e);}
  }
  dictfile= SEMplestService.properties.getProperty("data.stemworddict");
  docfile = SEMplestService.properties.getProperty("data.dmoz.allcats");
  twfile = SEMplestService.properties.getProperty("data.dmoz.alltw");;

  } 
   */

  // a word is valid if its stem is in the dictionary
  public static boolean validWord( String word ){
    return dict.containsKey( getRoot( word ) ) && 
      !cw.contains( word );
  }
  public static boolean commonWord(String word){
    return cw.contains(word);
  }
  // is the stem in the dictionary ?
  public static boolean validStem(String stem ){
    return dicti.containsKey( stem );
  }
  // give the stem of a word (may not be valid English word)
  public static String getRoot( String word ){
    return (new Stemmer()).stem( word );
  }
  // give a valid english word that represent all words that stem to same root
  public static String getStemWord( String word ){
    return dict.get ( getRoot( word ));
  }
  public static boolean validDoc( String doc ){
    return docsi.containsKey( doc );
  }
  public static void loadDict(String file){
    dicti = ioUtils.readFileIndex(file, 1);
    dict = ioUtils.readPair(file);
  }
  public static <V,K> Map<V,K> invert(Map<K,V> map){
    Map<V,K> inv = new HashMap<V,K>();
    for (Entry<K,V> entry : map.entrySet())
      inv.put(entry.getValue(), entry.getKey());
    return inv;
  }
  // document frequency
  public static int df( String word ){
    if( df.containsKey( word ) ) return df.get( word );
    else return DF_DEFAULT;
  }
  public static boolean dfilter( String word ){
    if( df( word) < DF_THRESHOLD) return true;
    else return false;
  }
  public static int ngdf( String ng ){
    String[] words = ng.split("\\+");
    int dfsum = 0;
    for( String w: words)
      dfsum += df( w );
    return dfsum / words.length;
  }
  public static boolean ngdfilter( String ng ){
    if( ngdf( ng ) < DF_NG_THRESHOLD ) return true;
    else return false;
  }


  //-----------------
  public static Set<String> CommonWordSet (){
    String commonWordString = ",a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,de,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,la,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,pdf,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your,";

    String localWordString = ",class,div,escap,document,fals,file,function,floor,http,html,javascript,math,pdf,plugin,protocol,true,tv,var,width,window,write,www,org";

    // the new, north, west etc are included but they are general stopwords 
    String stateWordString = ",north,south,east,west,alabama,alaska,arizona,arkansas,california,canada,colorado,connecticut,delaware,florida,georgia,hawaii,idaho,illinois,indiana,iowa,kansas,kentucky,louisiana,maine,maryland,massachusetts,mexico,michigan,minnesota,mississippi,missouri,montana,nebraska,nevada,hampshire,jersey,mexico,york,carolina,dakota,ohio,oklahoma,oregon,pennsylvania,rhode,carolina,dakota,tennessee,texas,utah,vermont,virginia,washington,wisconsin,wyoming";

    String sitesWordString = ",mozilla,google,yahoo,bing,wikipedia,aol,yippy,ask,netscape";

    String wordString = commonWordString + localWordString + stateWordString + sitesWordString;
    String[] commonWordArray = wordString.split(","); 
    Set<String> cwSet = new HashSet<String> (Arrays.asList(commonWordArray));
    return cwSet;
  }

  //-------------------------------------------------------------
  public static void main (String[] args){
    System.out.println( dicti.size());
    for(Entry<String,String> e: docs.entrySet())
      System.out.println( e.getKey() + " : " + e.getValue() );
  }
}
