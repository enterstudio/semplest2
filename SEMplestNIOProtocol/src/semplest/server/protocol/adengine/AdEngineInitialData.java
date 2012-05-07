package semplest.server.protocol.adengine;

import semplest.server.protocol.ProtocolEnum.SemplestMatchType;

public class AdEngineInitialData
{
	private Long defaultMicroBid;
	private SemplestMatchType semplestMatchType;
	public Long getDefaultMicroBid()
	{
		return defaultMicroBid;
	}
	public void setDefaultMicroBid(Long defaultMicroBid)
	{
		this.defaultMicroBid = defaultMicroBid;
	}
	public SemplestMatchType getSemplestMatchType()
	{
		return semplestMatchType;
	}
	public void setSemplestMatchType(SemplestMatchType semplestMatchType)
	{
		this.semplestMatchType = semplestMatchType;
	}

}
