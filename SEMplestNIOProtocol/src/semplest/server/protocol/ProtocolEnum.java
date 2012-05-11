package semplest.server.protocol;

import java.util.HashMap;


public class ProtocolEnum {
	
	private static HashMap<String,HashMap<String, String>> matchTypeMap = new HashMap<String,HashMap<String, String>>();
	static {
		HashMap<String,String> googleMap = new HashMap<String,String>();
		googleMap.put("exact","EXACT");
		googleMap.put("broad","BROAD");
		googleMap.put("phrase","PHRASE");
		matchTypeMap.put("google", googleMap);
		
		HashMap<String,String> msnMap = new HashMap<String,String>();
		msnMap.put("exact","Exact");
		msnMap.put("broad","Broad");
		msnMap.put("phrase","Phrase");
		matchTypeMap.put("msn", msnMap);
	}
	
	
	/*
	 * ENUMS
	 */
	public static enum ScheduleFrequency
	{
		Now, Daily, Weekly, Monthly, TenMinutes;
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
	public static enum AdEngine
	{
		MSN,Google;
		public static boolean existsAdEngine(String adEngine)
		{
			if (adEngine != null)
			{
				for (AdEngine val : AdEngine.values())
				{
					if (val.name().equalsIgnoreCase(adEngine))
					{
						return true;

					}
				}

			}
			return false;
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
		
		public static enum SemplestCompetitionType
		{
			Comp,NonComp,NotSelected,NoInfo;
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
		public static String getSearchEngineMatchType(String matchType, String adEngine) throws Exception {
			if(!SemplestMatchType.existsMatchType(matchType)) {
				throw new Exception("Invalid matchtype "+matchType+"!!");
			} 
			if(!AdEngine.existsAdEngine(adEngine)) {
				throw new Exception("Invalid ad engine "+adEngine+"!!");
			}
			return matchTypeMap.get(adEngine.toLowerCase()).get(matchType.toLowerCase());
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
		ExecuteBidProcess("semplest.services.client.api.SemplestAdEngineServiceClient");;
		
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
	
	public static void main(String [] args) {
		try {
			System.out.println(ProtocolEnum.SemplestMatchType.getSearchEngineMatchType("EXact", "Msn"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
