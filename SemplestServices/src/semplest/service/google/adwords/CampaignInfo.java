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

  // - Static Interface ---------
  // Note: budget is in cents
  public static int get( AdWordsUser user, Long caid, String field ) 
    throws Exception {
    Campaign c = gCriteria( user, caid);
    String f = field.toLowerCase();
    if( f.equals( "budget")) 
      return (int)( c.getBudget().getAmount().getMicroAmount() / 10000);
    return 0;
  }


  // privates --------------------------------------------------------------
  // - getters ----------------------------------
  private static Campaign gCriteria( AdWordsUser u, Long cid) throws Exception{
    Selector s = new Selector();
    s.setFields( fields );

    Predicate cp = new Predicate("CampaignId", PredicateOperator.EQUALS, 
        new String[]{ cid.toString() });
    s.setPredicates( new Predicate[]{ cp }); 

    // get Campaigns
    CampaignServiceInterface cs = u.getService( 
        AdWordsService.V201109.CAMPAIGN_SERVICE );
    Campaign[] cas = cs.get( s ).getEntries();
    if( cas.length > 0 ) return cas[0];
    else return null;
  }
  
  // ---------------------------------------------------------------------------
  public static void main(String[] args) throws Exception {
    String clientId = "8982168071";
    long campaignId   = 82853361L;
    AdWordsUser user  =  new AdWordsUser("adwords@semplest.com","ic0system", 
                    clientId, "Icosystem", "2H8l6aUm6K_Q44vDvxs3Og");
    int ci = CampaignInfo.get( user, campaignId, "budget" );
    System.out.println( ci );
  }
}

