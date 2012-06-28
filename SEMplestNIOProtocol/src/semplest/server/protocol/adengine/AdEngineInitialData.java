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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defaultMicroBid == null) ? 0 : defaultMicroBid.hashCode());
		result = prime * result
				+ ((networkSetting == null) ? 0 : networkSetting.hashCode());
		result = prime
				* result
				+ ((semplestMatchType == null) ? 0 : semplestMatchType
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdEngineInitialData other = (AdEngineInitialData) obj;
		if (defaultMicroBid == null) {
			if (other.defaultMicroBid != null)
				return false;
		} else if (!defaultMicroBid.equals(other.defaultMicroBid))
			return false;
		if (networkSetting == null) {
			if (other.networkSetting != null)
				return false;
		} else if (!networkSetting.equals(other.networkSetting))
			return false;
		if (semplestMatchType == null) {
			if (other.semplestMatchType != null)
				return false;
		} else if (!semplestMatchType.equals(other.semplestMatchType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdEngineInitialData [defaultMicroBid=" + defaultMicroBid
				+ ", semplestMatchType=" + semplestMatchType
				+ ", networkSetting=" + networkSetting + "]";
	}
	
	

}
