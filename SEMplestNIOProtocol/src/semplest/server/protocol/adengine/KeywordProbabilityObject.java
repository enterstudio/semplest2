package semplest.server.protocol.adengine;

public class KeywordProbabilityObject
{
	private String keyword;
	private Double semplestProbability;
	private Boolean isTargetMSN;
	private Boolean isTargetGoogle;
	public String getKeyword()
	{
		return keyword;
	}
	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}
	public Double getSemplestProbability()
	{
		return semplestProbability;
	}
	public void setSemplestProbability(Double semplestProbability)
	{
		this.semplestProbability = semplestProbability;
	}
	public Boolean getIsTargetMSN()
	{
		return isTargetMSN;
	}
	public void setIsTargetMSN(Boolean isTargetMSN)
	{
		this.isTargetMSN = isTargetMSN;
	}
	public Boolean getIsTargetGoogle()
	{
		return isTargetGoogle;
	}
	public void setIsTargetGoogle(Boolean isTargetGoogle)
	{
		this.isTargetGoogle = isTargetGoogle;
	}
	
}
