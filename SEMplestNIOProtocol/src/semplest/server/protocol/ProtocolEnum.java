package semplest.server.protocol;


public class ProtocolEnum {
	
	
	/*
	 * ENUMS
	 */
	public static enum ScheduleFrequency
	{
		Now, Daily, Weekly, Monthly;
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
		
		public static String getGoogleMatchType(String matchType) throws Exception {
			if(SemplestMatchType.existsMatchType(matchType)) {
				return matchType.toUpperCase();
			} else {
				throw new Exception("Invalid matchtype "+matchType+"!!");
			}
		}
	}
	
	public static enum NetworkSetting
	{
		SearchOnly,SearchNetwork;
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
		MsnReport("semplest.services.client.api.MSNAdcenterServiceClient")
		;
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

	

}
