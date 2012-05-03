package semplest.service.google.adwords;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import java.util.ArrayList;

public class LocationInfo {
  
  static String[] fields = {"Id","LocationName","CanonicalName","DisplayType",
    "ParentLocations","Reach"};
  AdWordsUser user = null;
  LocationCriterionServiceInterface lcs = null; 
 
  // Interface -----------------
  public LocationInfo( String clid ) throws Exception {
    user  = GawUtils.getUser( clid );
    lcs = user.getService( AdWordsService.V201109.LOCATION_CRITERION_SERVICE); 
  }
  public Long getId( String s ) throws Exception {return getId( s, "State" ); }
  public Long getId( String s, String t ) throws Exception {
    LocationCriterion[] cr  = getCriteria( s );
    LocationCriterion[] fcr = filter( cr, t );
    if( fcr.length >= 1 )
      return gLid( fcr[0] );
    else return 0L;
  }

  // - getters ----------------------------------
  private LocationCriterion[] getCriteria( String l) throws Exception {
    Selector s = new Selector();
    s.setFields( fields );
    Predicate sp = new Predicate("LocationName",PredicateOperator.IN, 
        new String[]{ l });
    Predicate lp = new Predicate("Locale",PredicateOperator.EQUALS, 
        new String[]{ "en" });
    s.setPredicates( new Predicate[]{sp,lp});
  
    // get CampaignCriterions
    return lcs.get( s );
  }
  // type (t) Can be "State", "City" or "Metro"
  private LocationCriterion[] filter(LocationCriterion[] ls, String t){
    ArrayList<LocationCriterion> flc = new ArrayList<LocationCriterion>();
    for( LocationCriterion l: ls )
     if(l instanceof LocationCriterion && 
         l.getLocation().getDisplayType().equals(t)) flc.add( l );
    return flc.toArray( new LocationCriterion[]{} );
  }
  private String gLs( LocationCriterion lc ){
    String os = lc.getSearchTerm() + "(" + lc.getReach() + ") : ";
    Location l  = lc.getLocation();
    if( l != null )
      os = os +  l.getId() +","+ l.getLocationName() +","+ l.getDisplayType();
    return os;
  }
  private Long gLid( LocationCriterion lc){
    if( lc.getLocation() != null )
      return lc.getLocation().getId();
    else return 0L;
  }

  // ---------------------------------------------------------------------------
  public static void main(String[] args) {
    try {
      Long caid = Long.getLong( GawUtils.cId );
      LocationInfo l = new LocationInfo( GawUtils.clientId );
      Long sid = l.getId( "NY" );
      Long cid = l.getId( "NY", "City" );
      Long mid = l.getId( "New York", "Metro" );

      System.out.println( sid + "," + cid + "," + mid );
    } catch (Exception e ){ e.printStackTrace(); }
  }
}

