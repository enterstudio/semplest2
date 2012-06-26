package semplest.service.google.adwords;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import java.util.ArrayList;
import java.util.AbstractMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class GeoLocator {
	
	private static final Logger logger = Logger.getLogger(GeoLocator.class);
  
  AdWordsUser user = null;
  GeoLocationServiceInterface gls = null;

  // Interface -----------
  // - ctr
  public GeoLocator( String clid, AdWordsUser user) throws Exception {
    this.user  = user; //GawUtils.getUser( clid );
    gls   = user.getService( AdWordsService.V201109.GEO_LOCATION_SERVICE );
  }
  public Map.Entry<Integer,Integer>  getLatLon( 
      String s, String c, String st, String z) throws Exception {
    return gLL( getLocations( cAddress( s, c, st, z )) );
  }
  public Map.Entry<Integer,Integer> getLatLon( String a) throws Exception {
    String[] as = a.split(",");
    if (as.length >= 4 )
      return gLL( getLocations( cAddress( as[0], as[1], as[2], as[3] )));
    else return new AbstractMap.SimpleEntry(0,0);
  }

  // Private -----------------------------------------------------------
  // - getters --
  private GeoLocation[] getLocations( Address a ) throws Exception {
    GeoLocationSelector s = new GeoLocationSelector(); 
    s.setAddresses( new Address[]{ a } ); 
    return filter( gls.get( s ));
  }
  // - filter (return only valid locations) --
  private GeoLocation[] filter( GeoLocation[] ls) {
    ArrayList<GeoLocation> fls = new ArrayList<GeoLocation>();
    for( GeoLocation l: ls ){
      if( l == null ) break; 
      if( l instanceof InvalidGeoLocation ) break; 
      if( l instanceof GeoLocation ) fls.add( l );
    }
    return fls.toArray( new GeoLocation[]{} );
  }
  // - helpers --
  private String gLs( GeoLocation l ){
    return l.getAddress().getStreetAddress() + ":: (lt/ln): " +
    l.getGeoPoint().getLatitudeInMicroDegrees()   + "," + 
    l.getGeoPoint().getLongitudeInMicroDegrees();   
  }
  private Map.Entry<Integer,Integer> gLL(GeoLocation[] ls) {
    if (ls.length > 0 )
      return new AbstractMap.SimpleEntry( 
        ls[0].getGeoPoint().getLatitudeInMicroDegrees(), 
        ls[0].getGeoPoint().getLongitudeInMicroDegrees());  
    else return new AbstractMap.SimpleEntry(0,0);
  }
  private Address cAddress(String s, String c, String st, String z){
    Address a = new Address();
    if( s   != "") a.setStreetAddress( s );
    if( c   != "") a.setCityName( c );
    if( st  != "") a.setProvinceCode( "US-" + st );
    if( z   != "") a.setPostalCode( z );
      a.setCountryCode("US");
    return a;
  }

  // ---------------------------------------------------------------------------
  public static void main(String[] args) {
    String address  = "195 Broadway";
    String city     = "New York";
    String state    = "NY";
    String zip      = "10007";
    try {
    	AdWordsUser user = null;
      GeoLocator gl = new GeoLocator( "",user);
      Map.Entry<Integer,Integer> ll = gl.getLatLon( address, city, state, zip ); 
      System.out.println( ll );
    } catch( Exception e){logger.error("Problem", e); }
  }
}

