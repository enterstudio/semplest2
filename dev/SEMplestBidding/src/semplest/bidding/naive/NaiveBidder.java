package semplest.bidding.naive;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

// import java.lang.Math.*;
import java.util.Comparator;
import java.util.Arrays;

// Bids naiely for an ad-group
//  Sets bid to first-page-cpc for high-volume keywords
//  Sets bid to first-page-cpc + $0.50 for low-volume keywords
//  When first-page-cpc is not available we use the default bid 

public class NaiveBidder {

  public static int DELAY_MS = 1000;

  AGInfo    a = null;
  Estimator e = null;

  // ctr ---------
  public NaiveBidder(long clientId, long campaignId, long adgroupId )
    throws Exception {
    a = new AGInfo( clientId, campaignId, adgroupId );
    e = new Estimator( clientId, campaignId, adgroupId );
  }

  // interface ---------
  // sets bids (specify the daily budget in cents )
  public int bid( int dailyBudget ) throws Exception {

    // Get the keywords and sort them by first-page-cpc
    BiddableAdGroupCriterion[] bacs = a.gCriteria();
    bacs = sortEntries( bacs ); 

    int remainingBudget = dailyBudget;
    int totalCost = 0;
    for( BiddableAdGroupCriterion bac : bacs ){ 
      // get data for each keyword
      int fpcpc   = a.gFPCpc(   bac );
      int maxcpc  = a.gMaxCpc(  bac );
      String kw   = a.gKeyword( bac );
      boolean eligible = a.gEligible( bac ); 

      // bidding logic (if eligible, bid fpcpc, else fpcpc + 50)
      int bidamount = 0;
      if( eligible ){
        if( remainingBudget > 0 ){
          bidamount       = fpcpc;
          int cost        = e.gCost( kw, bidamount );
          totalCost       = totalCost + cost;
          remainingBudget = remainingBudget - cost; 
        }
      }
      else               
        bidamount = fpcpc + 50;

      bidamount = bidamount > dailyBudget ? dailyBudget : bidamount; 
      if( bidamount != maxcpc && bidamount > 0 ){ 
        a.sBid( bac, bidamount);
        Thread.sleep( DELAY_MS );
        System.out.printf("%s :: Bid(old,new) : (%d,%d)c\tRem. Budget :: %d\n", 
            kw,maxcpc,bidamount, remainingBudget );
      }
    }
    System.out.printf("Spent: %dc, Unused: %dc\n", totalCost, remainingBudget ); 
    return totalCost;
  }

  // bidding helper -------
  private BiddableAdGroupCriterion[] sortEntries(BiddableAdGroupCriterion[] es ){
    Arrays.sort( es, new Comparator(){
      public int compare(Object f,Object g){
        BiddableAdGroupCriterion x = (BiddableAdGroupCriterion) f;
        BiddableAdGroupCriterion y = (BiddableAdGroupCriterion) g;
        if(!a.gEligible(x) && !a.gEligible(y))  return 0;
        if( a.gEligible(x) && !a.gEligible(y))  return -1;
        if(!a.gEligible(x) &&  a.gEligible(y))  return 1;
        if( a.gFPCpc(x)    <=  a.gFPCpc(y))      return -1;
        return 1;
      }
    });
    return es;
  }
  // test and usage ------ 
  public static void main( String[] args) {
    long CLID = 8982168071L;
    long CAID = 76709721L;
    long AGID = 3582397881L;
    int budget = 2500;  // cents

    try { 
      NaiveBidder nb = new NaiveBidder( CLID, CAID, AGID);
      int spent = nb.bid( budget );
    } catch (Exception e ){ e.printStackTrace();}
  }
}

