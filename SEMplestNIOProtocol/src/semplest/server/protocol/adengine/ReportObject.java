package semplest.server.protocol.adengine;

import java.io.Serializable;
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
public class ReportObject implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -978406788879282975L;
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
	private Long adGroupID;
	private Long keywordID;
	
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
	public Long getKeywordID() {
		return keywordID;
	}
	public void setKeywordID(Long keywordID) {
		this.keywordID = keywordID;
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
	public Long getAdGroupID() {
		return adGroupID;
	}
	public void setAdGroupID(Long adGroupID) {
		this.adGroupID = adGroupID;
	}

	/*
	public Long getKeywordID() {
		return keywordID;
	}
	public void setKeywordID(Long keywordID) {
		this.keywordID = keywordID;
	}
	*/
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BidMatchType == null) ? 0 : BidMatchType.hashCode());
		result = prime * result + ((Keyword == null) ? 0 : Keyword.hashCode());
		result = prime * result + ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result + ((adGroupID == null) ? 0 : adGroupID.hashCode());
		result = prime * result + ((approvalStatus == null) ? 0 : approvalStatus.hashCode());
		result = prime * result + ((averageCPC == null) ? 0 : averageCPC.hashCode());
		result = prime * result + ((averagePosition == null) ? 0 : averagePosition.hashCode());
		result = prime * result + ((campaignID == null) ? 0 : campaignID.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((firstPageCPC == null) ? 0 : firstPageCPC.hashCode());
		//result = prime * result + ((keywordID == null) ? 0 : keywordID.hashCode());
		result = prime * result + ((microBidAmount == null) ? 0 : microBidAmount.hashCode());
		result = prime * result + ((microCost == null) ? 0 : microCost.hashCode());
		result = prime * result + ((numberClick == null) ? 0 : numberClick.hashCode());
		result = prime * result + ((numberImpressions == null) ? 0 : numberImpressions.hashCode());
		result = prime * result + ((qualityScore == null) ? 0 : qualityScore.hashCode());
		result = prime * result + ((searchTerm == null) ? 0 : searchTerm.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
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
		ReportObject other = (ReportObject) obj;
		if (BidMatchType == null)
		{
			if (other.BidMatchType != null)
				return false;
		}
		else if (!BidMatchType.equals(other.BidMatchType))
			return false;
		if (Keyword == null)
		{
			if (other.Keyword != null)
				return false;
		}
		else if (!Keyword.equals(other.Keyword))
			return false;
		if (accountID == null)
		{
			if (other.accountID != null)
				return false;
		}
		else if (!accountID.equals(other.accountID))
			return false;
		if (adGroupID == null)
		{
			if (other.adGroupID != null)
				return false;
		}
		else if (!adGroupID.equals(other.adGroupID))
			return false;
		if (approvalStatus == null)
		{
			if (other.approvalStatus != null)
				return false;
		}
		else if (!approvalStatus.equals(other.approvalStatus))
			return false;
		if (averageCPC == null)
		{
			if (other.averageCPC != null)
				return false;
		}
		else if (!averageCPC.equals(other.averageCPC))
			return false;
		if (averagePosition == null)
		{
			if (other.averagePosition != null)
				return false;
		}
		else if (!averagePosition.equals(other.averagePosition))
			return false;
		if (campaignID == null)
		{
			if (other.campaignID != null)
				return false;
		}
		else if (!campaignID.equals(other.campaignID))
			return false;
		if (createdDate == null)
		{
			if (other.createdDate != null)
				return false;
		}
		else if (!createdDate.equals(other.createdDate))
			return false;
		if (firstPageCPC == null)
		{
			if (other.firstPageCPC != null)
				return false;
		}
		else if (!firstPageCPC.equals(other.firstPageCPC))
			return false;
		/*
		if (keywordID == null)
		{
			if (other.keywordID != null)
				return false;
		}
		else if (!keywordID.equals(other.keywordID))
			return false;
			*/
		if (microBidAmount == null)
		{
			if (other.microBidAmount != null)
				return false;
		}
		else if (!microBidAmount.equals(other.microBidAmount))
			return false;
		if (microCost == null)
		{
			if (other.microCost != null)
				return false;
		}
		else if (!microCost.equals(other.microCost))
			return false;
		if (numberClick == null)
		{
			if (other.numberClick != null)
				return false;
		}
		else if (!numberClick.equals(other.numberClick))
			return false;
		if (numberImpressions == null)
		{
			if (other.numberImpressions != null)
				return false;
		}
		else if (!numberImpressions.equals(other.numberImpressions))
			return false;
		if (qualityScore == null)
		{
			if (other.qualityScore != null)
				return false;
		}
		else if (!qualityScore.equals(other.qualityScore))
			return false;
		if (searchTerm == null)
		{
			if (other.searchTerm != null)
				return false;
		}
		else if (!searchTerm.equals(other.searchTerm))
			return false;
		if (transactionDate == null)
		{
			if (other.transactionDate != null)
				return false;
		}
		else if (!transactionDate.equals(other.transactionDate))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "ReportObject [accountID=" + accountID + ", campaignID=" + campaignID + ", Keyword=" + Keyword + ", transactionDate=" + transactionDate + ", microBidAmount=" + microBidAmount + ", BidMatchType=" + BidMatchType + ", numberImpressions=" + numberImpressions + ", numberClick="
				+ numberClick + ", averagePosition=" + averagePosition + ", averageCPC=" + averageCPC + ", qualityScore=" + qualityScore + ", approvalStatus=" + approvalStatus + ", firstPageCPC=" + firstPageCPC + ", createdDate=" + createdDate + ", microCost=" + microCost + ", adGroupID="
				+ adGroupID + /*", keywordID=" + keywordID  + */", searchTerm=" + searchTerm + "]";
	}

	

}
