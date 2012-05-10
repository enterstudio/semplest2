package semplest.server.protocol.adengine;

import semplest.server.protocol.ProtocolEnum.SemplestMatchType;

public class AdEngineInitialData
{
	private Long defaultMicroBid;
	private String semplestMatchType;
	private String networkSetting;

	

	public String getNetworkSetting() {
		return networkSetting;
	}
	public void setNetworkSetting(String networkSetting) {
		this.networkSetting = networkSetting;
	}
	
	public Long getDefaultMicroBid()
	{
		return defaultMicroBid;
	}
	public void setDefaultMicroBid(Long defaultMicroBid)
	{
		this.defaultMicroBid = defaultMicroBid;
	}
	public String getSemplestMatchType()
	{
		return semplestMatchType;
	}
	public void setSemplestMatchType(String semplestMatchType)
	{
		this.semplestMatchType = semplestMatchType;
	}
	

}
