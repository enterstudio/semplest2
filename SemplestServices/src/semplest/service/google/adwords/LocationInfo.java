package semplest.service.google.adwords;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class LocationInfo {

  private static final Logger logger = Logger.getLogger(LocationInfo.class);

  static String[] fields = {"Id","LocationName","CanonicalName","DisplayType",
    "ParentLocations","Reach"};
  AdWordsUser user = null;
  LocationCriterionServiceInterface lcs = null; 

  public static Map<String,Integer> reach = new HashMap<String,Integer>();

  static {
    reach.put("AL",1390);
    reach.put("AK",324);
    reach.put("AZ",3970);
    reach.put("AR",741);
    reach.put("CA",27800);
    reach.put("CO",4170);
    reach.put("CT",1990);
    reach.put("DE",347);
    reach.put("FL",9880);
    reach.put("GA",7500);
    reach.put("HI",557);
    reach.put("ID",648);
    reach.put("IL",9790);
    reach.put("IN",2310);
    reach.put("IA",1190);
    reach.put("KA",1170);
    reach.put("KY",1490);
    reach.put("LA",1890);
    reach.put("ME",582);
    reach.put("MD",3120);
    reach.put("MA",5710);
    reach.put("MI",5740);
    reach.put("MN",5080);
    reach.put("MS",637);
    reach.put("MO",3350);
    reach.put("MT",367);
    reach.put("NE",865);
    reach.put("NV",1280);
    reach.put("NH",692);
    reach.put("NJ",4949);
    reach.put("NM",728);
    reach.put("NY",13400);
    reach.put("NC",5410);
    reach.put("ND",254);
    reach.put("OH",5780);
    reach.put("OK",1170);
    reach.put("OR",2500);
    reach.put("PA",6200);
    reach.put("RI",511);
    reach.put("SC",1660);
    reach.put("SD",245);
    reach.put("TN",2650);
    reach.put("TX",16600);
    reach.put("UT",1490);
    reach.put("VT",343);
    reach.put("VA",4710);
    reach.put("WA",4830);
    reach.put("WV",455);
    reach.put("WI",3680);
    reach.put("WY",167);
    reach.put("US",190000);
  }

  // Interface -----------------
  public LocationInfo( String clid, AdWordsUser user ) throws Exception {
    this.user  = user; // GawUtils.getUser( clid,  );
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
  // - reach -------
  // The reach (in 000 people)/(% of the US) for a state/states
  public static int reachK( String state){ 
    if( reach.containsKey( state.toUpperCase() ))
      return reach.get( state.toUpperCase() );
    else return 0;
  }
  public static int reachPctUS( String state ){ return 100*reachK(state)/reachK("US");} 
  public static int reachK( String[] states){ 
    int treach = 0;
    for( String state: states ) 
      treach += reachK( state );
    return treach;
  }
  public static int reachPctUS( String[] states){return 100*reachK(states)/reachK("US");} 

  // - getters ----------------------------------
  private LocationCriterion[] getCriteria( String l) throws Exception {
    Selector s = new Selector();
    s.setFields( fields );
    Predicate sp = new Predicate("LocationName",PredicateOperator.IN, new String[]{ l });
    Predicate lp = new Predicate("Locale",PredicateOperator.EQUALS, new String[]{ "en" });
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
  public static void stateTest(){
    try {
      AdWordsUser user = null;
      Long caid = Long.getLong( "" );
      LocationInfo l = new LocationInfo( "", user );
      Long sid = l.getId( "NY" );
      Long cid = l.getId( "NY", "City" );
      Long mid = l.getId( "New York", "Metro" );

      System.out.println( sid + "," + cid + "," + mid );
    } catch (Exception e ){ logger.error("Problem", e);}
  }

  // ---------------------------------------------------------------------------
  public static void main(String[] args) {
    System.out.println( reachK( "NY") );
    System.out.println( reachK( "ct") );
    System.out.println( reachK( "foo") );
    System.out.println( reachPctUS( "NY") );
    System.out.println( reachPctUS( "foo") );
    System.out.println( reachK( "ny ct ma".split("\\s+" )));
    System.out.println( reachPctUS( "ny ct ma".split("\\s+" )));

  }
}

