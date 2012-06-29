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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
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
		KeywordProbabilityObject other = (KeywordProbabilityObject) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
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
