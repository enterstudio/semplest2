package semplest.server.protocol.bidding;

import java.util.Date;

public class MSNBidHistoryData {
	
	private String keyword;
	private String matchType;
	private Integer position;
	
	private Double avgBid;
	private Double avgCost;
	
	private Integer searchVol;
	private Integer clicks;
	private Integer impressions;
	
	private Date startDate;
	private Date endDate;
	
	private Date transactionDate;
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public Integer getPosition() {
		return position;
	}
	public Double getAvgBid() {
		return avgBid;
	}
	public void setAvgBid(Double avgBid) {
		this.avgBid = avgBid;
	}
	public Double getAvgCost() {
		return avgCost;
	}
	public void setAvgCost(Double avgCost) {
		this.avgCost = avgCost;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getSaerchVol() {
		return searchVol;
	}
	public void setSaerchVol(Integer saerchVol) {
		this.searchVol = saerchVol;
	}
	public Integer getClicks() {
		return clicks;
	}
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}
	public Integer getImpressions() {
		return impressions;
	}
	public void setImpressions(Integer impressions) {
		this.impressions = impressions;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public MSNBidHistoryData(){};

	public MSNBidHistoryData(String keyword, String matchType,
			Integer position, Double avgBid, Double avgCost, Integer saerchVol,
			Integer clicks, Integer impressions, Date startDate, Date endDate,
			Date transactionDate) {
		super();
		this.keyword = keyword;
		this.matchType = matchType;
		this.position = position;
		this.avgBid = avgBid;
		this.avgCost = avgCost;
		this.searchVol = saerchVol;
		this.clicks = clicks;
		this.impressions = impressions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.transactionDate = transactionDate;
	}
	

	@Override
	public String toString() {
		return "MSNBidHistoryData [keyword=" + keyword + ", matchType="
				+ matchType + ", position=" + position + ", avgBid=" + avgBid
				+ ", avgCost=" + avgCost + ", saerchVol=" + searchVol
				+ ", clicks=" + clicks + ", impressions=" + impressions
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", transactionDate=" + transactionDate + "]";
	}
	

}
