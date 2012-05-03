package semplest.service.google.adwords;

import com.google.api.adwords.v201109.o.*;
import com.google.api.adwords.v201109.cm.*;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AdWordsService;

// Gets traffic estimates from Google
public class GawUtils {

// String[] campaign = {"ParkWinters","1851386728","80759052","3442703292"}; 
// String[] campaign = {"WeddingFlowers","9886423251","94891718","3200406038"};
  static String[] campaign = {
    "TovahPhoto","8982168071","76709721","3582397881"};
  static String clientId  = campaign[1];
  static String cId       = campaign[2];
  static String agId      = campaign[3];

  public static AdWordsUser getUser( String clid ){
    AdWordsUser user = new AdWordsUser("adwords@semplest.com","ic0system",
        clid, "Icosystem", "2H8l6aUm6K_Q44vDvxs3Og");
    return user;
  }
}

