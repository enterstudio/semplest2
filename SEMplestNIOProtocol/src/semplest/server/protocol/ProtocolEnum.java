package semplest.server.protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;


public class ProtocolEnum 
{
	private static final Logger logger = Logger.getLogger(ProtocolEnum.class);
	
	private static HashMap<AdEngine,HashMap<String, String>> matchTypeMap = new HashMap<AdEngine,HashMap<String, String>>();
	
	static 
	{
		HashMap<String,String> googleMap = new HashMap<String,String>();
		googleMap.put("exact","EXACT");
		googleMap.put("broad","BROAD");
		googleMap.put("phrase","PHRASE");
		matchTypeMap.put(AdEngine.Google, googleMap);
		
		HashMap<String,String> msnMap = new HashMap<String,String>();
		msnMap.put("exact","Exact");
		msnMap.put("broad","Broad");
		msnMap.put("phrase","Phrase");
		matchTypeMap.put(AdEngine.MSN, msnMap);
	}
	
	
	/*
	 * ENUMS - Latin-1
	 */
	public static enum EmailType
	{
		PlanText("text/plain; charset=ISO-8859-1"), HTML("text/html; charset=ISO-8859-1");
		private String val;

		public String getEmailValue()
		{
			return val;
		}

		private EmailType(String value)
		{
			val = value;
		}

	}
	public static enum ScheduleFrequency
	{
		Now, Daily, Weekly, Monthly, TenMinutes,Hour, TwoHour, ThreeHour, SixHour ;
		public static boolean existsFrequency(String freq)
		{
			if (freq != null)
			{
				for (ScheduleFrequency val : ScheduleFrequency.values())
				{
					if (val.name().equalsIgnoreCase(freq))
					{
						return true;

					}
				}

			}
			return false;
		}
	}
	
	public static enum PromotionBiddingType
	{
		Initial,Ongoing;
	}
	
	public static enum AdEngine
	{
		MSN    (1),
		Google (2);
		
		private final int code;
		
		AdEngine(final int code)
		{
			this.code = code;
		}
		
		public int getCode()
		{
			return code;
		}
		
		public static boolean existsAdEngine(String adEngine)
		{
			if (adEngine != null)
			{
				for (AdEngine val : AdEngine.values())
				{
					if (val.name().equals(adEngine))
					{
						return true;

					}
				}
			}
			return false;
		}
		
		public static void validateAdEngine(final String adEngine)
		{
			if (!AdEngine.existsAdEngine(adEngine))
			{
				throw new IllegalArgumentException("AdEngine specified [" + adEngine + "] is not valid");
			}
		}
		
		public static void validateAdEngines(final List<String> adEngines)
		{
			for (final String adEngine : adEngines)
			{
				validateAdEngine(adEngine);
			}
		}
		
		public static AdEngine getAdEngine(final int code)
		{
			final AdEngine[] adEngines = AdEngine.values();
			for (final AdEngine adEngine : adEngines)
			{
				if (adEngine.getCode() == code)
				{
					return adEngine;
				}
			}
			return null;
		}
		
		public static List<AdEngine> getAdEngines(final List<String> adEngineStrings)
		{
			final List<AdEngine> adEngineList = new ArrayList<AdEngine>();
			for (final String adEngineString : adEngineStrings)
			{
				final AdEngine adEngine = AdEngine.valueOf(adEngineString);
				adEngineList.add(adEngine);
			}
			return adEngineList;
		}
	}
	
	public static enum SemplestMatchType
	{
		Exact,Broad,Phrase;
		public static boolean existsMatchType(String matchType)
		{
			if (matchType != null)
			{
				for (SemplestMatchType val : SemplestMatchType.values())
				{
					if (val.name().equalsIgnoreCase(matchType))
					{
						return true;

					}
				}

			}
			return false;
		}
		

		public static String getSearchEngineMatchType(String matchType, AdEngine adEngine) throws Exception 
		{
			if(!SemplestMatchType.existsMatchType(matchType)) 
			{
				throw new Exception("Invalid matchtype "+matchType+"!!");
			} 
			return matchTypeMap.get(adEngine).get(matchType.toLowerCase());
		}	
	}
	
	public static enum SemplestCompetitionType
	{
		//Comp,NonComp,NotSelected,NoInfo;
		NotSelected,UnderExperiment,Rejected,Accepted, // these are the ones finally in use
		Comp,NonComp,NoInfo; // these are due to legacy reason

		public static boolean existsCompetitionType(String competitionType)
		{
			if (competitionType != null)
			{
				for (SemplestCompetitionType val : SemplestCompetitionType.values())
				{
					if (val.name().equalsIgnoreCase(competitionType))
					{
						return true;

					}
				}

			}
			return false;
		}
	}
	
	public static enum NetworkSetting
	{
		SearchOnly,displayNetwork;
		public static boolean existsNetworkSetting(String networkSetting)
		{
			if (networkSetting != null)
			{
				for (NetworkSetting val : NetworkSetting.values())
				{
					if (val.name().equalsIgnoreCase(networkSetting))
					{
						return true;

					}
				}

			}
			return false;
		}
	}
	public static enum ClientServiceName
	{
		Email("semplest.services.client.api.SemplestMailServiceClient"),
		GoogleReport("semplest.services.client.api.GoogleAdwordsServiceClient"),
		MsnReport("semplest.services.client.api.MSNAdcenterServiceClient"),
		AddPromotionToAdEngine("semplest.services.client.api.SemplestAdEngineServiceClient"),
		ExecuteBidProcess("semplest.services.client.api.SemplestAdEngineServiceClient"),
		AddAds("semplest.services.client.api.SemplestAdEngineServiceClient"),
		AddNegativeKeywords("semplest.services.client.api.SemplestAdEngineServiceClient"),
		AddKeywords("semplest.services.client.api.SemplestAdEngineServiceClient"),
		UpdateAds("semplest.services.client.api.SemplestAdEngineServiceClient"),
		DeleteAd("semplest.services.client.api.SemplestAdEngineServiceClient"),
		UpdateGeoTargeting("semplest.services.client.api.SemplestAdEngineServiceClient"),
		UpdateBudget("semplest.services.client.api.SemplestAdEngineServiceClient"),
		EndPromotion("semplest.services.client.api.SemplestAdEngineServiceClient"),
		PausePromotion("semplest.services.client.api.SemplestAdEngineServiceClient"),
		DeletePromotion("semplest.services.client.api.SemplestAdEngineServiceClient"),
		UnpausePromotion("semplest.services.client.api.SemplestAdEngineServiceClient"),
		DeleteKeyword("semplest.services.client.api.SemplestAdEngineServiceClient"),
		RefreshSiteLinksForAd("semplest.services.client.api.SemplestAdEngineServiceClient"),
		PauseProductGroup("semplest.services.client.api.SemplestAdEngineServiceClient"),		
		ChangePromotionStartDate("semplest.services.client.api.SemplestAdEngineServiceClient");
		
		private String val;

		public String getClientServiceNameValue()
		{
			return val;
		}

		private ClientServiceName(String value)
		{
			val = value;
		}

	}
	
	public static enum ServiceStatus
	{
		Up("Up"), 
		Down("Down");
		
		private String val;

		public String getServiceStatusValue()
		{
			return val;
		}

		private ServiceStatus(String value)
		{
			val = value;
		}

	}
	
	public static void main(String [] args) {
		try {
			System.out.println(ProtocolEnum.SemplestMatchType.getSearchEngineMatchType("EXact", AdEngine.MSN));
		} catch (Exception e) {
			logger.error("Problem", e);
		}
	}

	

}
