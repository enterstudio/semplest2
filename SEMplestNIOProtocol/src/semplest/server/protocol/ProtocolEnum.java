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
	
	public static enum MatchType
	{
		Exact,Broad,Phrase;
		public static boolean existsMatchType(String matchType)
		{
			if (matchType != null)
			{
				for (MatchType val : MatchType.values())
				{
					if (val.name().equalsIgnoreCase(matchType))
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
		Email("semplest.services.client.api.SemplestMailServiceClient");
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
