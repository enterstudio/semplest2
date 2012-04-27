
package semplest.keywords.multiwords;

import semplest.keywords.javautils.TextUtils;
import semplest.keywords.scalautils.*;

public class TestCrawl2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "http://www.parishilton.com";
	    String urls = TextUtils.HTMLLinkString( ss );

	    
	    Crawler c = new Crawler(); 
//	    System.out.println("Adding urls: "+urls);
//	    c.add( "parishilton", urls );
	    System.out.println("Adding urls: "+ss);
	    c.add( "parishilton", ss );


	    try {
	      Thread.sleep( 30000 ); 
	    } catch( Exception e) {
	      e.printStackTrace();
	    }

	    String[] results = c.fetch();
	    for( String res: results)  
	      System.out.println( res );
	}

}