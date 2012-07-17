package semplest.system.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum;

public class SystemTestDataModel {

	private static final SystemTestDataModel data = new SystemTestDataModel();
	
	//Semplest Variables
	public static final Integer semplestCustomerId = 19; //Customer 'Semplest System Test' in TEST database
	public static final Integer semplestProductGroupId = 120;	
	public static Integer semplestPromotionId;
	public static String semplestPromotionName;	
	public static ArrayList<ProtocolEnum.AdEngine> adEngineList = new ArrayList<ProtocolEnum.AdEngine>(Arrays.asList(ProtocolEnum.AdEngine.Google, ProtocolEnum.AdEngine.MSN));
	
	public static final String promotionDescription = "search engine marketing tool";
	
	//Ad Engine Variables
	public static final String googleAccountId = "8258218255";		
	public static Long googleCampaignId;
	public static Long googleAdGroupId;
	
	public static final Long msnAccountId = 1714450L;
	public static final Long msnCustomerId = 13068662L;
	public static Long msnCampaignId;
	public static Long msnAdGroupId;
	
	//ADs
	private static final AD ad1 = data.new AD("Simplest SEM", "Dramatically reduces overhead costs", "No hidden costs or fees");
	private static final AD ad2 = data.new AD("An Amazing SEM Tool", "Dramatically reduces overhead costs", "Dramatically reduces overhead costs");
	public static final List<AD> promotionAds = Arrays.asList(ad1, ad2);
	public static List<Integer> promotionAdIds;		
	
	//Keywords (all keywords are set up manually in database)
	public static final List<String> keywords = Arrays.asList("SEM", "Search engine marketing", "online promotion");
	public static final List<Integer> keywordIds = Arrays.asList(154665, 138071, 153406);		
	
	//Negative Keywords		
	public static final List<String> negKeywords = Arrays.asList("startup");
	public static final List<Integer> negKeywordIds = Arrays.asList(154666);		
	public static List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs = new ArrayList<KeywordIdRemoveOppositePair>();
	
	//GeoTargeting
	public static final String address = "195 Broadway";
	public static final String city = "New York";
	public static final Integer stateCode = 32;
	public static final String zipCode = "10007";
	public static final Double longitude = -74.009526;
	public static final Double latitude = 40.710798;
	public static Double radius = 10.00;	
	
	//SiteLinks
	private static final SiteLink siteLink1 = data.new SiteLink("SEMplest");
	private static final SiteLink siteLink2 = data.new SiteLink("semplest");
	public static final List<SiteLink> sitelinks = Arrays.asList(siteLink1, siteLink2);
	
	//Keyword Service Variables
	public static final String keyword_SearchTerm = "rugby sale balls and gloves";
	public static final String keyword_Description = "rugby sale balls and gloves";
	public static final String keyword_LandingPage = "http://www.planetrugby.com";
		
	//helper classes
	public class AD{
		public String adTitle;
		public String adTextLine1;
		public String adTextLine2;
		
		public AD(String adTitle, String adTextLine1, String adTextLine2) {
			super();
			this.adTitle = adTitle;
			this.adTextLine1 = adTextLine1;
			this.adTextLine2 = adTextLine2;
		}		
	}
	
	public class SiteLink{
		public String linkText;
		public String linkUrl;
		public SiteLink(String linkText) {
			super();
			this.linkText = linkText;
			this.linkUrl = "http://www.semplest.com";
		}		
	}

	@Override
	public String toString() {
		return "SystemTestDataModel [semplestCustomerId=" + semplestCustomerId
				+ ", semplestProductGroupId=" + semplestProductGroupId
				+ ", semplestPromotionId=" + semplestPromotionId
				+ ", semplestPromotionName=" + semplestPromotionName
				+ ", adEngineList=" + adEngineList + ", promotionDescription="
				+ promotionDescription + ", googleAccountId=" + googleAccountId
				+ ", googleCampaignId=" + googleCampaignId
				+ ", googleAdGroupId=" + googleAdGroupId + ", msnAccountId="
				+ msnAccountId + ", msnCustomerId=" + msnCustomerId
				+ ", msnCampaignId=" + msnCampaignId + ", msnAdGroupId="
				+ msnAdGroupId + ", ad1=" + ad1 + ", ad2=" + ad2
				+ ", promotionAds=" + promotionAds + ", promotionAdIds="
				+ promotionAdIds + ", keywords=" + keywords + ", keywordIds="
				+ keywordIds + ", negKeywords=" + negKeywords
				+ ", negKeywordIds=" + negKeywordIds
				+ ", keywordIdRemoveOppositePairs="
				+ keywordIdRemoveOppositePairs + ", address=" + address
				+ ", city=" + city + ", stateCode=" + stateCode + ", zipCode="
				+ zipCode + ", longitude=" + longitude + ", latitude="
				+ latitude + ", radius=" + radius + ", siteLink1=" + siteLink1
				+ ", siteLink2=" + siteLink2 + ", sitelinks=" + sitelinks + "]";
	}	
	
}
