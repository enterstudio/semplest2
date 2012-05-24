package semplest.server.protocol.adengine;

import java.util.Date;
/*

CREATE TABLE [dbo].[AdvertisingEngineBidData](
	[AdvertisingEngineBidDataPK] [varchar](50) NOT NULL,
	[KeywordBidFK] [int] NULL,
	[MicroBidAmount] [int] NOT NULL,
	[NumberImpressions] [int] NOT NULL,
	[NumberClick] [int] NOT NULL,
	[AveragePosition] [int] NOT NULL,
	[AverageCPC] [money] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,

 */
public class ReportObject
{

	private Long accountID;
	private Long campaignID;
	private String Keyword;
	private Date transactionDate;
	private Long microBidAmount;
	private String BidMatchType;
	private Integer numberImpressions;
	private Integer numberClick;
	private Float averagePosition;
	private Long averageCPC;
	private Integer qualityScore;
	private String approvalStatus;
	private Long firstPageCPC;
	private Date createdDate;
	private Long microCost;
	
	// added for search query report
	private String searchTerm;

	
	
	public String getSearchTerm() {
		return searchTerm;
	}
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	public Long getAccountID()
	{
		return accountID;
	}
	public void setAccountID(Long accountID)
	{
		this.accountID = accountID;
	}
	public Long getCampaignID()
	{
		return campaignID;
	}
	public void setCampaignID(Long campaignID)
	{
		this.campaignID = campaignID;
	}
	public String getKeyword()
	{
		return Keyword;
	}
	public void setKeyword(String keyword)
	{
		Keyword = keyword;
	}
	public Long getMicroBidAmount()
	{
		return microBidAmount;
	}
	public void setMicroBidAmount(Long microBidAmount)
	{
		this.microBidAmount = microBidAmount;
	}
	public String getBidMatchType()
	{
		return BidMatchType;
	}
	public void setBidMatchType(String bidMatchType)
	{
		BidMatchType = bidMatchType;
	}
	public Integer getNumberImpressions()
	{
		return numberImpressions;
	}
	public void setNumberImpressions(Integer numberImpressions)
	{
		this.numberImpressions = numberImpressions;
	}
	public Integer getNumberClick()
	{
		return numberClick;
	}
	public void setNumberClick(Integer numberClick)
	{
		this.numberClick = numberClick;
	}
	
	public Integer getQualityScore()
	{
		return qualityScore;
	}
	public void setQualityScore(Integer qualityScore)
	{
		this.qualityScore = qualityScore;
	}
	public String getApprovalStatus()
	{
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus)
	{
		this.approvalStatus = approvalStatus;
	}
	public Long getFirstPageCPC()
	{
		return firstPageCPC;
	}
	public void setFirstPageCPC(Long firstPageCPC)
	{
		this.firstPageCPC = firstPageCPC;
	}
	
	public Date getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}
	public Date getTransactionDate()
	{
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate)
	{
		this.transactionDate = transactionDate;
	}
	public Long getMicroCost()
	{
		return microCost;
	}
	public void setMicroCost(Long microCost)
	{
		this.microCost = microCost;
	}
	public Float getAveragePosition()
	{
		return averagePosition;
	}
	public void setAveragePosition(Float averagePosition)
	{
		this.averagePosition = averagePosition;
	}
	public Long getAverageCPC()
	{
		return averageCPC;
	}
	public void setAverageCPC(Long averageCPC)
	{
		this.averageCPC = averageCPC;
	}

	

}
