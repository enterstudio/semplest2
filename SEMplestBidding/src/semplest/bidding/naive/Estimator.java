package semplest.bidding.naive;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

// Gets traffic estimates from Google
public class Estimator {

  KeywordMatchType mtype = KeywordMatchType.EXACT;
  TrafficEstimatorServiceInterface tes = null; 
  long cid = 0;

  // ctr ---------
  public Estimator(long clientId, long campaignId, long adgroupId )
    throws Exception {
    AdWordsUser user = new AdWordsUser("adwords@semplest.com","ic0system",
        Long.toString(clientId), "Icosystem", "2H8l6aUm6K_Q44vDvxs3Og");
    tes = user.getService(AdWordsService.V201109.TRAFFIC_ESTIMATOR_SERVICE );
    cid = campaignId;
  }

  // the cost of a certain bid for a keyeord
  public int gCost( String kw, int bid) throws Exception {
    TrafficEstimatorResult res = gEstimate( kw, bid );
    return gCost( res );
  }

  // privates ---------------------------------------------------------------
  private TrafficEstimatorResult gEstimate(String k, int bid)
    throws Exception {

    KeywordEstimateRequest kw = gKeyword( k, mtype, bid );
    AdGroupEstimateRequest ag = gAdGroup(new KeywordEstimateRequest[]{ kw }); 
    CampaignEstimateRequest c = gCampaign(new AdGroupEstimateRequest[]{ ag });

    // selector
    TrafficEstimatorSelector s = new TrafficEstimatorSelector();
    s.setCampaignEstimateRequests(new CampaignEstimateRequest[]{ c });

    // get estimates 
    TrafficEstimatorResult res = tes.get( s );
    return res;
  }

  private int gCost( TrafficEstimatorResult rs){
    if( rs == null || rs.getCampaignEstimates() == null ) return 0;
    AdGroupEstimate age =  rs.getCampaignEstimates()[0].getAdGroupEstimates()[0];
    if( age == null || age.getKeywordEstimates() == null ) return 0;
    KeywordEstimate ke = age.getKeywordEstimates()[0];
    int acpc = (int)((ke.getMin().getAverageCpc().getMicroAmount() +
          ke.getMax().getAverageCpc().getMicroAmount())/20000);
    float cpd = (ke.getMin().getClicksPerDay() + 
        ke.getMax().getClicksPerDay()) / 2;
    System.out.println( acpc + " , " + cpd );
    return Math.round( acpc * cpd );
  }
  // ------- conveniences                        
  private KeywordEstimateRequest gKeyword(String k, KeywordMatchType t, int c){
    KeywordEstimateRequest req = new KeywordEstimateRequest();
    req.setKeyword( new Keyword (null, null, null, k, t ));
    req.setMaxCpc( new Money(null,  c * 10000L ));
    return req;
  }
  private AdGroupEstimateRequest gAdGroup(KeywordEstimateRequest[] ks){
    AdGroupEstimateRequest req = new AdGroupEstimateRequest();
    req.setKeywordEstimateRequests( ks );
    return req;
  }
  private CampaignEstimateRequest gCampaign(AdGroupEstimateRequest[] ags){
    CampaignEstimateRequest req = new CampaignEstimateRequest();
    req.setCampaignId( cid );
    // req.setCriteria( Array( unitedStates, english) );
    req.setAdGroupEstimateRequests( ags );
    return req;
  }


  public static void main( String[] args) {
    long CLID = 8982168071L;
    long CAID = 76709721L;
    long AGID = 3582397881L;
    int budget = 2500;  // cents

    try { 
      Estimator e = new Estimator( CLID, CAID, AGID );
      System.out.println( e.gCost("portrait photography", 200 )); 
          } catch (Exception e ){ e.printStackTrace();}
  }
}

