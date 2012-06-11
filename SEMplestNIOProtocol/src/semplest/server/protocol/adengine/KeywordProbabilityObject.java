package semplest.server.protocol.adengine;

public class KeywordProbabilityObject
{
	private Integer keywordPK;
	private String keyword;
	private Double semplestProbability;
	private Boolean isTargetMSN;
	private Boolean isTargetGoogle;
	private Boolean isActive;
	private Boolean isNegative;
	private Boolean isDeleted;
		
	
	public Integer getKeywordPK()
	{
		return keywordPK;
	}
	public void setKeywordPK(Integer keywordPK)
	{
		this.keywordPK = keywordPK;
	}
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
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isDeleted == null) ? 0 : isDeleted.hashCode());
		result = prime * result + ((isNegative == null) ? 0 : isNegative.hashCode());
		result = prime * result + ((isTargetGoogle == null) ? 0 : isTargetGoogle.hashCode());
		result = prime * result + ((isTargetMSN == null) ? 0 : isTargetMSN.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((keywordPK == null) ? 0 : keywordPK.hashCode());
		result = prime * result + ((semplestProbability == null) ? 0 : semplestProbability.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeywordProbabilityObject other = (KeywordProbabilityObject) obj;
		if (isActive == null)
		{
			if (other.isActive != null)
				return false;
		}
		else if (!isActive.equals(other.isActive))
			return false;
		if (isDeleted == null)
		{
			if (other.isDeleted != null)
				return false;
		}
		else if (!isDeleted.equals(other.isDeleted))
			return false;
		if (isNegative == null)
		{
			if (other.isNegative != null)
				return false;
		}
		else if (!isNegative.equals(other.isNegative))
			return false;
		if (isTargetGoogle == null)
		{
			if (other.isTargetGoogle != null)
				return false;
		}
		else if (!isTargetGoogle.equals(other.isTargetGoogle))
			return false;
		if (isTargetMSN == null)
		{
			if (other.isTargetMSN != null)
				return false;
		}
		else if (!isTargetMSN.equals(other.isTargetMSN))
			return false;
		if (keyword == null)
		{
			if (other.keyword != null)
				return false;
		}
		else if (!keyword.equals(other.keyword))
			return false;
		if (keywordPK == null)
		{
			if (other.keywordPK != null)
				return false;
		}
		else if (!keywordPK.equals(other.keywordPK))
			return false;
		if (semplestProbability == null)
		{
			if (other.semplestProbability != null)
				return false;
		}
		else if (!semplestProbability.equals(other.semplestProbability))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "KeywordProbabilityObject [keywordPK=" + keywordPK + ", keyword=" + keyword + ", semplestProbability=" + semplestProbability
				+ ", isTargetMSN=" + isTargetMSN + ", isTargetGoogle=" + isTargetGoogle + ", isActive=" + isActive + ", isNegative=" + isNegative
				+ ", isDeleted=" + isDeleted + "]";
	}
	
}
