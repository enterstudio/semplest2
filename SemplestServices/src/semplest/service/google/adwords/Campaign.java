package semplest.service.google.adwords;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap;

public class Campaign {
  
  static String[] fields = {"Id","CampaignId","LocationName","DisplayType",
    "RadiusInUnits","GeoPoint","Address"};
  String clid = "";
  Long cid = null;
  AdWordsUser user = null;
  CampaignCriterionServiceInterface ccs = null;

  // Interface ---------
  public Campaign( String clientid, Long caid ) throws Exception {
    clid  =  clientid;
    cid   =  caid;
    user  =  GawUtils.getUser( clid );
    ccs = user.getService( AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE );
  }

  public long setGeoLoc( String state ) throws Exception { 
    return sGeoLocation( cCriterion( state )); }
  public long setGeoLoc( Double r, int lat, int lon) throws Exception {
    return sGeoLocation( cProximity( r, lat, lon ));}
  public long setGeoLoc( Double r,String addr, String city, String state) 
    throws Exception { 
    return sGeoLocation( cCriterion( r, addr, city, state, "" ));}
  public long setGeoLoc( Double r, String zip) throws Exception { 
    return sGeoLocation( cCriterion( r, "", "", "", zip ));}
  public long setGeoLoc( Long id ) throws Exception { 
    return sGeoLocation( cLocation( id )); }
  
  public void printCC() throws Exception { pCCs( gCriteria() ); }
  public void pCCs( CampaignCriterion[]  crs) throws Exception {
    for( CampaignCriterion c : crs )
      System.out.println( gResults( c ));
  }

  // privates --------------------------------------------------------------
  // - getters ----------------------------------
  private CampaignCriterion[] gCriteria() throws Exception {
    Selector s = new Selector();
    s.setFields( fields );

    Predicate cp = new Predicate("CampaignId", PredicateOperator.EQUALS, 
            new String[]{ cid.toString() });
    s.setPredicates( new Predicate[]{ cp }); 

    // get CampaignCriterions
    return filter( ccs.get( s ).getEntries() );
    }
  // setter ------------------
  private long sGeoLocation( Criterion c) throws Exception {
    CampaignCriterion cc = new CampaignCriterion();
    cc.setCampaignId( cid );
    cc.setCriterion( c );
    CampaignCriterionOperation o = new CampaignCriterionOperation();
    o.setOperand( cc );
    o.setOperator( Operator.ADD );
    CampaignCriterion[] rs = 
      ccs.mutate(new CampaignCriterionOperation[]{o}).getValue();
    // pCCs( rs );
    return gCaId( rs );
  }
  //- helpers ------------------------------------------------
  //-- filter ------------------------------------------------
  private CampaignCriterion[] filter( CampaignCriterion[] es ){
    ArrayList<CampaignCriterion> ccs = new ArrayList<CampaignCriterion>();
    if( es != null )
      for( CampaignCriterion c: es )
        if( c.getCriterion() != null ) ccs.add( c );
    return ccs.toArray( new CampaignCriterion[]{} );
  }
  // -- Criterion creators --------------
  private Criterion cCriterion( String s ) throws Exception { 
    return cLocation( new LocationInfo( clid ).getId( s ));}
  private Criterion cCriterion( Double r, String a ) throws Exception {
    Map.Entry e = (new GeoLocator( clid )).getLatLon( a );
    return cProximity( r, (Integer)e.getKey(), (Integer) e.getValue());
  }
  private Criterion cCriterion( Double r, 
      String s, String c, String st, String z ) throws Exception {
    Map.Entry e = (new GeoLocator( clid )).getLatLon( s, c, st, z );
    return cProximity( r, (Integer)e.getKey(), (Integer) e.getValue());
  }
  private Criterion cLocation( Long lid ){
    Location l = new Location();
    l.setId( lid );
    return l;
  }
  private Criterion cProximity( Double r, int lat, int lon ){
    GeoPoint gp = new GeoPoint();
    gp.setLatitudeInMicroDegrees(   lat );
    gp.setLongitudeInMicroDegrees(  lon );
    Proximity pr = new Proximity();
    pr.setGeoPoint( gp );
    pr.setRadiusDistanceUnits( ProximityDistanceUnits.MILES );
    pr.setRadiusInUnits( r );
    return pr;
  }
  // print helpers -----------------
  private long gCaId( CampaignCriterion[] cs ){
    if( cs.length < 1 ) return 0L;
    return cs[0].getCampaignId();
  }
  private String gResults( CampaignCriterion cc){
    Long id     = cc.getCampaignId();
    Criterion c = cc.getCriterion();
    String t    = c.getCriterionType();
    String os   = "";
    if( c instanceof Location ){
     Location l = (Location) c;
     os = os + l.getLocationName() + ", " + l.getDisplayType();
    }
    if( c instanceof  Proximity ){
      Proximity p = (Proximity) c;
      os = os + p.getRadiusInUnits() + " :: " + 
           p.getGeoPoint().getLatitudeInMicroDegrees() + "," + 
           p.getGeoPoint().getLongitudeInMicroDegrees();
    }
    return id + ":" + t + " :: " + os;
  }
  
  // ---------------------------------------------------------------------------
  public static void main(String[] args) {

    Double radius = 20.0;
    String addr   = "195 Broadway";
    String city   = "New York";
    String state  = "NY";
    String zip    = "10007";

    try {
      // long caid   = Long.parseLong( GawUtils.cId );
      String clientId = "8982168071";
      long campaignId   = 76709721L;
      Campaign c = new Campaign( clientId, campaignId );
      long ra = c.setGeoLoc( radius, addr, city, state );
      long rz = c.setGeoLoc( radius, zip );
      long rs = c.setGeoLoc( "NY" );
      System.out.println( ra + "," + rs + "," + rz);
      // c.printCC();
    } catch (Exception e ){ e.printStackTrace(); }
  }
}

