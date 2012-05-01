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
	private Double averagePosition;
	private Integer averageCPC;
	private Integer qualityScore;
	private String approvalStatus;
	private Integer firstPageCPC;
	private Date createdDate;
	private Long microCost;
	
	
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
	public Double getAveragePosition()
	{
		return averagePosition;
	}
	public void setAveragePosition(Double averagePosition)
	{
		this.averagePosition = averagePosition;
	}
	public Integer getAverageCPC()
	{
		return averageCPC;
	}
	public void setAverageCPC(Integer averageCPC)
	{
		this.averageCPC = averageCPC;
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
	public Integer getFirstPageCPC()
	{
		return firstPageCPC;
	}
	public void setFirstPageCPC(Integer firstPageCPC)
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

	

}
