package semplest.keywords.javautils;

import java.util.HashMap;
import java.util.Map;

public class sampleWords {

  final String f = "/semplest/data/dmoz/all/hCounts.txt.tw";
  final String dfile = "dmoz/all/all.descs";
  
  Map<String,String> wcs;
  DmozLucene dl;

  public sampleWords(){
    wcs = ioUtils.readWcounts(f);
    dl = new DmozLucene();
    loadDesc( dl, dfile);
  }
  private void loadDesc( DmozLucene dl, String f){
    Map<String,String> map = ioUtils.readDescs( f );
    for(Map.Entry<String,String> e : map.entrySet())
      dl.add( e.getKey(), e.getValue() );
    dl.done();
  }

  // Public interface ----------
  public String getWords( String q ){
    String cleanq = TextUtils.stemvString( q );
    if( cleanq.length() < 2 ) return "";
    String[] res = dl.search( cleanq );
    if( res.length < 1 ) return "";
//    System.out.println( res[0] );
    return wcs.get( res[0] );
  }

  //------------
  public static void main( String[] args) {
    sampleWords sw = new sampleWords();
    
    String samplequery = "ski snowboard pants jacket";
    System.out.println( sw.getWords( samplequery ) );
  }
}


