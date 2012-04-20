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

public class NaiveBidder {

  long agId;
  AdGroupCriterionServiceInterface acs; 
  String[] fields = {"Id","SystemServingStatus","KeywordText",
      "QualityScore", "FirstPageCpc", "MaxCpc"};
  String testString = "";             // for testing
  // ctr ---------
  public NaiveBidder(long clientId, long campaignId, long adgroupId )
    throws Exception {
    AdWordsUser user = new AdWordsUser("adwords@semplest.com","ic0system",
        Long.toString(clientId), "Icosystem", "2H8l6aUm6K_Q44vDvxs3Og");
    acs = user.getService(AdWordsService.V201109.ADGROUP_CRITERION_SERVICE );
    agId = adgroupId;

  }
  // interface ---------
  // sets bids (specify the daily budget in cents )
  public void sBids( int dailyBudget ) throws Exception {
    for( BiddableAdGroupCriterion bac : gCriteria() ){
      int fpcpc   = gFPCpc(   bac );
      int maxcpc  = gMaxCpc(  bac );
      String kw   = gKeyword( bac );
      int bidamount = Math.min( dailyBudget, fpcpc );
      if ( bac.getSystemServingStatus() == SystemServingStatus.RARELY_SERVED )
        bidamount = Math.min( dailyBudget, fpcpc + 50 );

      if( bidamount != maxcpc ){ 
        sBid( bac, bidamount);
        System.out.println( 
          String.format("%s Maxcpc(old,new): (%d,%d)c", kw, maxcpc, bidamount ));
      }
    }
  }

  // privates ---------------------------------
  private BiddableAdGroupCriterion[] gCriteria() throws Exception {
    Selector s = new Selector();
    s.setFields( fields );

    // filters 
    Predicate agp = new Predicate("AdGroupId", PredicateOperator.IN, 
        new String[]{ Long.toString( agId ) }); 
    // [Note: For testing]
    if( testString != "" ){
      Predicate kp = new Predicate("KeywordText", PredicateOperator.EQUALS, 
        new String[]{ testString });  
      s.setPredicates(new Predicate[]{agp,kp});
    }

    AdGroupCriterion[] es = acs.get( s ).getEntries();
    return filterEntries( es );
  }

  // getters --------
  private int gMaxCpc( BiddableAdGroupCriterion bac ){
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
  private int gFPCpc(BiddableAdGroupCriterion bac ){
    if (bac.getFirstPageCpc() != null )
      if (bac.getFirstPageCpc().getAmount() != null )
        return (int)(bac.getFirstPageCpc().getAmount().getMicroAmount() / 10000);
    return 0;
  }
  private String gKeyword(BiddableAdGroupCriterion bac){
    Criterion c = bac.getCriterion();
    if( c instanceof Keyword )
      return ((Keyword)c).getText();
    else 
      return "";
  }
  // setters -----------
  private void sBid(BiddableAdGroupCriterion cr, int bid ) throws Exception {
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
  // helpers -------
  private BiddableAdGroupCriterion[] filterEntries( AdGroupCriterion[] es ){
    ArrayList<BiddableAdGroupCriterion> bacal = 
      new ArrayList<BiddableAdGroupCriterion>(); 
    for( AdGroupCriterion e : es )
      if( e != null && e instanceof BiddableAdGroupCriterion )
        bacal.add((BiddableAdGroupCriterion) e);
    return bacal.toArray(new BiddableAdGroupCriterion[]{} );
  }
  private String gDatums(BiddableAdGroupCriterion b){
    return String.format("%s %d %d",gKeyword(b), gMaxCpc(b), gFPCpc(b));
  }


  // test and usage -------------------------------------------------------- 
  public static void main( String[] args) {
    long CLID = 9886423251L;
    long CAID = 94891718L;
    long AGID = 3200406038L;

    try { 
      NaiveBidder n = new NaiveBidder( CLID, CAID, AGID );
      n.sBids( 1000 );
      } catch (Exception e ){ e.printStackTrace();}
    }
  }

