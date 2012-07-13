package semplest.server.protocol.adengine;

import java.util.Date;

public class KeywordDataObject implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long keywordAdEngineID;
	private String keyword;
	private Long microBidAmount;
	private String approvalStatus;
	private String matchType;
	private Long firstPageCpc;
	private Integer qualityScore;
	private Boolean IsEligibleForShowing = true;
	private Boolean isNegative = false;
	
	private Date createdDate;
	
	public Date getCreatedDate(){
		return createdDate;
	}
	public void setCreatedDate(Date createdDatein){
		createdDate = createdDatein;
	}
	public Long getBidID()
	{
		return keywordAdEngineID;
	}
	public void setBidID(Long keywordAdEngineID)
	{
		this.keywordAdEngineID = keywordAdEngineID;
	}
	public String getKeyword()
	{
		return keyword;
	}
	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}
	public Long getMicroBidAmount()
	{
		return microBidAmount;
	}
	public void setMicroBidAmount(Long microBidAmount)
	{
		this.microBidAmount = microBidAmount;
	}
	public String getApprovalStatus()
	{
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus)
	{
		this.approvalStatus = approvalStatus;
	}
	public String getMatchType()
	{
		return matchType;
	}
	public void setMatchType(String matchType)
	{
		this.matchType = matchType;
	}
	public Long getFirstPageCpc()
	{
		return firstPageCpc;
	}
	public void setFirstPageCpc(Long firstPageCpc)
	{
		this.firstPageCpc = firstPageCpc;
	}
	public Integer getQualityScore()
	{
		return qualityScore;
	}
	public void setQualityScore(Integer qualityScore)
	{
		this.qualityScore = qualityScore;
	}
	
	public Boolean isNegative()
	{
		return isNegative;
	}
	public void setNegative(Boolean isNegative)
	{
		this.isNegative = isNegative;
	}
	public Boolean isIsEligibleForShowing()
	{
		return IsEligibleForShowing;
	}
	public void setIsEligibleForShowing(Boolean isEligibleForShowing)
	{
		IsEligibleForShowing = isEligibleForShowing;
	}
	
	@Override
	public String toString()
	{
		return "KeywordDataObject [keywordAdEngineID=" + keywordAdEngineID + ", keyword=" + keyword + ", microBidAmount=" + microBidAmount + ", approvalStatus=" + approvalStatus + ", matchType=" + matchType + ", firstPageCpc=" + firstPageCpc + ", qualityScore=" + qualityScore
				+ ", IsEligibleForShowing=" + IsEligibleForShowing + ", isNegative=" + isNegative + ", createdDate=" + createdDate + "]";
	}
	
	
}
