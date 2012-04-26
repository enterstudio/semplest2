package semplest.bidding.naive;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import java.lang.Math.*;
import java.util.ArrayList;

// Bids naiely for an ad-group
//  Sets bid to first-page-cpc for high-volume keywords
//  Sets bid to first-page-cpc + $0.50 for low-volume keywords
//  When first-page-cpc is not available we use the default bid 

public class AGInfo {


  long agId;
  AdGroupCriterionServiceInterface acs = null; 
  String[] fields = {"Id","SystemServingStatus","KeywordText",
    "QualityScore", "FirstPageCpc", "MaxCpc"};
  String testString = "";             // for testing

  // ctr ---------
  public AGInfo(long clientId, long campaignId, long adgroupId )
    throws Exception {
    AdWordsUser user = new AdWordsUser("adwords@semplest.com","ic0system",
        Long.toString(clientId), "Icosystem", "2H8l6aUm6K_Q44vDvxs3Og");
    acs = user.getService(AdWordsService.V201109.ADGROUP_CRITERION_SERVICE );
    agId = adgroupId;

  }
  // interface ---------------------------------------------------------------
  public BiddableAdGroupCriterion[] gCriteria() throws Exception {
    Selector s = new Selector();
    s.setFields( fields );

    // filter 
    Predicate agp = new Predicate("AdGroupId", PredicateOperator.IN, 
        new String[]{ Long.toString( agId ) }); 
    s.setPredicates(new Predicate[]{agp});

    AdGroupCriterion[] es = acs.get( s ).getEntries();
    return filterEntries( es );
  }
  public BiddableAdGroupCriterion gCriterion( String kw) throws Exception {
    Selector s = new Selector();
    s.setFields( fields );

    // filters 
    Predicate agp = new Predicate("AdGroupId", PredicateOperator.IN, 
        new String[]{ Long.toString( agId ) }); 
    Predicate kp = new Predicate("KeywordText", PredicateOperator.EQUALS, 
        new String[]{ kw });  
    s.setPredicates(new Predicate[]{agp,kp});

    AdGroupCriterion[] es = acs.get( s ).getEntries();
    return filterEntries( es )[0];
  }
  // setters -----------
  public void sBid(BiddableAdGroupCriterion cr, int bid ) throws Exception {
    Criterion c = new Criterion();
    c.setId( cr.getCriterion().getId() );
    BiddableAdGroupCriterion bac = new BiddableAdGroupCriterion();
    bac.setAdGroupId( agId );
    bac.setCriterion( c );
    ManualCPCAdGroupCriterionBids bids = new ManualCPCAdGroupCriterionBids();
    bids.setMaxCpc( new Bid( new Money( null, bid * 10000L )));
    bac.setBids( bids );

    AdGroupCriterionOperation op = new AdGroupCriterionOperation();
    op.setOperand( bac );
    op.setOperator( Operator.SET );

    AdGroupCriterion[] res = acs.mutate(
        new AdGroupCriterionOperation[]{op}).getValue(); 
    BiddableAdGroupCriterion b = filterEntries( res )[0];
  }
  //---------------------------------------------------------------------------
  // statics  --------
  public static int gMaxCpc( BiddableAdGroupCriterion bac ){
    AdGroupCriterionBids bids = bac.getBids();
    if( bids != null && bids instanceof ManualCPCAdGroupCriterionBids ){
      ManualCPCAdGroupCriterionBids mbid = 
        (ManualCPCAdGroupCriterionBids)bids;
      if( mbid.getMaxCpc() != null )
        if( mbid.getMaxCpc().getAmount() != null ) 
          return (int)(mbid.getMaxCpc().getAmount().getMicroAmount() / 10000);
    }
    return 0;
  }
  public static int gFPCpc(BiddableAdGroupCriterion bac ){
    if (bac.getFirstPageCpc() != null )
      if (bac.getFirstPageCpc().getAmount() != null )
        return (int)(bac.getFirstPageCpc().getAmount().getMicroAmount() / 10000);
    return 0;
  }
  public static String gKeyword(BiddableAdGroupCriterion bac){
    Criterion c = bac.getCriterion();
    if( c != null && c instanceof Keyword )
      return ((Keyword)c).getText();
    return "";
  }
  public static Boolean gEligible(BiddableAdGroupCriterion bac){
    if (bac.getSystemServingStatus() == SystemServingStatus.ELIGIBLE )
      return true;
    return false;
  }
  // helpers -------
  private BiddableAdGroupCriterion[] filterEntries( AdGroupCriterion[] es ){
    ArrayList<BiddableAdGroupCriterion> bacal = 
      new ArrayList<BiddableAdGroupCriterion>(); 
    for( AdGroupCriterion e : es )
      if( e != null && e instanceof BiddableAdGroupCriterion )
        bacal.add((BiddableAdGroupCriterion) e);
    return bacal.toArray(new BiddableAdGroupCriterion[]{} );
  }
  public String gDatums( BiddableAdGroupCriterion b){
    return String.format("%s :: Bid: %d, FPCpc: %d",
        gKeyword(b),gMaxCpc(b),gFPCpc(b));
  }

  // test and usage ------ 
  public static void main( String[] args) {
    long CLID = 8982168071L;
    long CAID = 76709721L;
    long AGID = 3582397881L;
    int budget = 2500;  // cents

    try { 
      AGInfo a = new AGInfo( CLID, CAID, AGID );
      BiddableAdGroupCriterion bac = a.gCriterion("portrait photography");
      System.out.println( a.gDatums( bac )); 
    } catch (Exception e ){ e.printStackTrace();}
  }
}

