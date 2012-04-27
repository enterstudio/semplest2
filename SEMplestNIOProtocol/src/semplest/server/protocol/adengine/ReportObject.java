package semplest.server.protocol.adengine;

import org.joda.time.DateTime;

public class ReportObject
{

	private Long accountID;
	private Long campaignID;
	private String Keyword;
	private Integer BidAmount;
	private String BidMatchType;
	private Integer NumberImpressions;
	private Integer NumberClick;
	private Double AveragePosition;
	private Integer AverageCPC;
	private Integer QualityScore;
	private String ApprovalStatus;
	private Integer FirstPageCPC;
	private DateTime CreatedDate;

	public String getKeyword()
	{
		return Keyword;
	}

	public void setKeyword(String keyword)
	{
		Keyword = keyword;
	}

	public Integer getBidAmount()
	{
		return BidAmount;
	}

	public void setBidAmount(Integer bidAmount)
	{
		BidAmount = bidAmount;
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
		return NumberImpressions;
	}

	public void setNumberImpressions(Integer numberImpressions)
	{
		NumberImpressions = numberImpressions;
	}

	public Integer getNumberClick()
	{
		return NumberClick;
	}

	public void setNumberClick(Integer numberClick)
	{
		NumberClick = numberClick;
	}

	public Double getAveragePosition()
	{
		return AveragePosition;
	}

	public void setAveragePosition(Double averagePosition)
	{
		AveragePosition = averagePosition;
	}

	public Integer getAverageCPC()
	{
		return AverageCPC;
	}

	public void setAverageCPC(Integer averageCPC)
	{
		AverageCPC = averageCPC;
	}

	public Integer getQualityScore()
	{
		return QualityScore;
	}

	public void setQualityScore(Integer qualityScore)
	{
		QualityScore = qualityScore;
	}

	public String getApprovalStatus()
	{
		return ApprovalStatus;
	}

	public void setApprovalStatus(String approvalStatus)
	{
		ApprovalStatus = approvalStatus;
	}

	public Integer getFirstPageCPC()
	{
		return FirstPageCPC;
	}

	public void setFirstPageCPC(Integer firstPageCPC)
	{
		FirstPageCPC = firstPageCPC;
	}

	public DateTime getCreatedDate()
	{
		return CreatedDate;
	}

	public void setCreatedDate(DateTime createdDate)
	{
		CreatedDate = createdDate;
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

}
