package semplest.server.protocol.adengine;

public class GoogleBidObject
{

	private Long bidID;
	private String keyword;
	private Long microBidAmount;
	private String approvalStatus;
	private String matchType;
	private Long firstPageCpc;
	private Integer qualityScore;
	private String status;
	
	public Long getBidID()
	{
		return bidID;
	}
	public void setBidID(Long bidID)
	{
		this.bidID = bidID;
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
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	
}
