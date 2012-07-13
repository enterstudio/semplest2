package semplest.service.google.adwords;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class CampaignInfo {
  private static final Logger logger = Logger.getLogger(
      semplest.service.google.adwords.CampaignInfo.class);  
  static String[] fields = {"Id","Name","Status","Amount", "BiddingStrategy",
    "TargetGoogleSearch","EnhancedCpcEnabled"};
 
  String clid = "";
  Long cid = null;
  AdWordsUser user = null;
  CampaignServiceInterface cs = null;
  Campaign c = null;

  // Interface ---------
  public CampaignInfo( String clientid, Long caid ) throws Exception {
    clid        =  clientid;
    cid         =  caid;
    user        =  new AdWordsUser("adwords@semplest.com","ic0system", 
                    clid, "Icosystem", "2H8l6aUm6K_Q44vDvxs3Og");
    cs          = user.getService( AdWordsService.V201109.CAMPAIGN_SERVICE );
    c           = gCriteria();
  }

  // Get
  // Note budget is in cents
  public int get( String field ){
    String f = field.toLowerCase();
    if( f.equals( "budget")) 
      return (int)( c.getBudget().getAmount().getMicroAmount() / 10000);
    return 0;
  }

  // privates --------------------------------------------------------------
  // - getters ----------------------------------
  private Campaign gCriteria() throws Exception {
    Selector s = new Selector();
    s.setFields( fields );

    Predicate cp = new Predicate("CampaignId", PredicateOperator.EQUALS, 
        new String[]{ cid.toString() });
    s.setPredicates( new Predicate[]{ cp }); 

    // get Campaigns
    Campaign[] cas = filter( cs.get( s ).getEntries() );
    if( cas.length > 0 ) return cas[0];
    else return null;
  }
  
  //- helpers ------------------------------------------------
  //-- filter ------------------------------------------------
  private Campaign[] filter( Campaign[] es ){
    ArrayList<Campaign> ccs = new ArrayList<Campaign>();
    if( es != null )
      for( Campaign c: es )
        if( c != null ) ccs.add( c );
    return ccs.toArray( new Campaign[]{} );
  }

  // ---------------------------------------------------------------------------
  public static void main(String[] args) throws Exception {
    String clientId = "8982168071";
    long campaignId   = 82853361L;
    CampaignInfo ci = new CampaignInfo( clientId, campaignId );
    System.out.println( ci.get( "budget" ));
  }
}

