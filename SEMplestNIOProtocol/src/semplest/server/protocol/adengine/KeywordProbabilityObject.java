package semplest.server.protocol.adengine;
//k.Keyword, pka.IsTargetGoogle, pka.IsTargetMSN, pka.IsActive, pka.IsDeleted, pka.IsNegative, pka.SemplestProbability
public class KeywordProbabilityObject
{
	private String keyword;
	private Double semplestProbability;
	private Boolean isTargetMSN;
	private Boolean isTargetGoogle;
	private Boolean isActive;
	private Boolean isNegative;
	private Boolean isDeleted;
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
	public Boolean getIsActive()
	{
		return isActive;
	}
	public void setIsActive(Boolean isActive)
	{
		this.isActive = isActive;
	}
	public Boolean getIsNegative()
	{
		return isNegative;
	}
	public void setIsNegative(Boolean isNegative)
	{
		this.isNegative = isNegative;
	}
	public Boolean getIsDeleted()
	{
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted)
	{
		this.isDeleted = isDeleted;
	}
	
}
