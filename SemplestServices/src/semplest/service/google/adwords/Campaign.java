package semplest.service.google.adwords;

import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.google.CampaignCriterionMutateRetriableGoogleOperation;
import semplest.util.SemplestUtils;

public class Campaign 
{
  private static final Logger logger = Logger.getLogger(semplest.service.google.adwords.Campaign.class);  
  static String[] fields = {"Id","CampaignId","LocationName","DisplayType", "RadiusInUnits","GeoPoint","Address"};
  String clid = "";
  Long cid = null;
  AdWordsUser user = null;
  CampaignCriterionServiceInterface ccs = null;

  // Interface ---------
  public Campaign( String clientid, Long caid, AdWordsUser user ) 
    throws Exception 
  {
    clid  =  clientid;
    cid   =  caid;
    this.user  =  user;
    ccs = user.getService( AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE );
  }

  public void addGeoLoc(final List<GeoTargetObject> geoTargets) 
    throws Exception 
  {
    for (final GeoTargetObject geoTarget : geoTargets)
    {
      final Double radius = geoTarget.getRadius();
      final String addr = geoTarget.getAddress();
      final String city = geoTarget.getCity();
      final String state = geoTarget.getState();
      final String zip = geoTarget.getZip();
      if (radius <= 0)
      {
        setGeoLoc(state);
      }
      else
      {
        setGeoLoc(radius, addr, city, state, zip);
      }
    }
  }

  public void removeAllGeoLoc(final Long campaignId) throws Exception 
  { 
    logger.info("Will try to remove all Geo Locations for Campaign [" + campaignId + "]");
    final CampaignCriterionServiceInterface campaignCriterionService = user.getService(AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE);
    final Selector selector = new Selector();
    selector.setFields(fields);
    final Predicate cp = new Predicate("CampaignId", PredicateOperator.EQUALS, new String[]{"" + campaignId});
    selector.setPredicates(new Predicate[]{cp});
    final CampaignCriterionPage page = campaignCriterionService.get(selector);
    final CampaignCriterion[] campaignCriterion = page.getEntries();
    final List<Long> existingProximityIds = new ArrayList<Long>();	    
    for (int i = 0; i < campaignCriterion.length; ++i)
    {
      final CampaignCriterion campaignCriteria = campaignCriterion[i];
      final Criterion criterion = campaignCriteria.getCriterion();			
      if (criterion.getType() == CriterionType.PROXIMITY)
      {
        existingProximityIds.add(criterion.getId());
      }
    }
    logger.info("Found " + existingProximityIds.size() + " Proximity IDs within Google Adwords: [" + existingProximityIds + "]");
    if (existingProximityIds.isEmpty())
    {
      return;
    }
    final List<CampaignCriterionOperation> removeProximityOperations = new ArrayList<CampaignCriterionOperation>();
    for (final Long proximityId : existingProximityIds)
    {
      final Criterion removeProximityCriterion = new Criterion();
      removeProximityCriterion.setId(proximityId);
      removeProximityCriterion.setType(CriterionType.PROXIMITY);
      final CampaignCriterion removeProximityCampaignCriterion = new CampaignCriterion();
      removeProximityCampaignCriterion.setCampaignId(campaignId);
      removeProximityCampaignCriterion.setCriterion(removeProximityCriterion);
      final CampaignCriterionOperation removeProximityOperation = new CampaignCriterionOperation();
      removeProximityOperation.setOperand(removeProximityCampaignCriterion);
      removeProximityOperation.setOperator(Operator.REMOVE);
      removeProximityOperations.add(removeProximityOperation);
    }
    final CampaignCriterionOperation[] removeProximityOperationsArray = removeProximityOperations.toArray(new CampaignCriterionOperation[removeProximityOperations.size()]);
    
    
    final CampaignCriterionMutateRetriableGoogleOperation retriableOperation = new CampaignCriterionMutateRetriableGoogleOperation(ccs, removeProximityOperationsArray, SemplestUtils.DEFAULT_RETRY_COUNT); 
    
    final CampaignCriterion[] resultCampaignCriterionArray = retriableOperation.performOperation().getValue();
    final List<Long> resultCriterionIds = new ArrayList<Long>();
    for (int i = 0; i < resultCampaignCriterionArray.length; ++i)
    {
      final CampaignCriterion resultCampaignCriterion = resultCampaignCriterionArray[i];
      final Long resultCriterionId = resultCampaignCriterion.getCriterion().getId();
      resultCriterionIds.add(resultCriterionId);
    }
    logger.info("Criterion IDs returned from Google Adwords call to remove all Proximities: [" + resultCriterionIds + "]");
  }

  // Set
  public long setGeoLoc( String state ) throws Exception 
  { 
    return sGeoLocation( cCriterion( state )); 
  }
  public long setGeoLoc( Double r, int lat, int lon) throws Exception 
  {
    return sGeoLocation( cProximity( r, lat, lon ));
  }
  public long setGeoLoc( Double r, Double lat, Double lon) throws Exception 
  {
    return sGeoLocation( cProximity(r, (int)(lat*1000000), (int)(lon*1000000)));
  }
  public long setGeoLoc(Double r, String addr, String city, String state, String zip) throws Exception 
  { 
    return sGeoLocation( cCriterion( r, addr, city, state, zip ));
  }
  public long setGeoLoc( Long id ) throws Exception 
  { 
    return sGeoLocation( cLocation( id )); 
  }

  // Get
  public String[] getGeoLocs() throws Exception 
  {
    ArrayList<String> res = new ArrayList<String>();
    for( CampaignCriterion c : gCriteria())
    {
      res.add( gResults( c ) );
    }
    return res.toArray( new String[]{} );
  }

  // Print
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
    final CampaignCriterionOperation[] operations = new CampaignCriterionOperation[]{o};
    final CampaignCriterionMutateRetriableGoogleOperation retriableOperation = new CampaignCriterionMutateRetriableGoogleOperation(ccs, operations, SemplestUtils.DEFAULT_RETRY_COUNT);     
    CampaignCriterion[] rs = retriableOperation.performOperation().getValue();
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
    return cLocation( new LocationInfo( clid, user ).getId( s ));}
  private Criterion cCriterion( Double r, String a ) throws Exception {
    Map.Entry e = (new GeoLocator( clid, user )).getLatLon( a );
    return cProximity( r, (Integer)e.getKey(), (Integer) e.getValue());
  }
  private Criterion cCriterion( Double r, 
      String s, String c, String st, String z ) throws Exception {
    Map.Entry e = (new GeoLocator( clid, user )).getLatLon( s, c, st, z );
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
    Double lat    = 38.5294;
    Double lon    = -12.9701;

    try {
      // long caid   = Long.parseLong( GawUtils.cId );
      String clientId = "8982168071";
      long campaignId   = 76709721L;
//      AdWordsUser user =  GawUtils.getUser( clientId );
      AdWordsUser user = null; 
      // new AdWordsUser(email, password, accountId, userAgent, 
      // developerToken, useSandbox);
      Campaign c = new Campaign( clientId, campaignId, user );
      long ra = c.setGeoLoc( radius, addr, city, state, zip );
      long rs = c.setGeoLoc( "NY" );
      long rz = c.setGeoLoc( radius, lat, lon );

      String[] res = c.getGeoLocs();
      for( String r : res )
        System.out.println(r);

    } catch (Exception e ){ logger.error("Problem", e); }
  }
}

