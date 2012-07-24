package semplest.server.protocol.bidding;

import java.util.Date;
import java.util.List;

public class AdEngineBidHistoryData {
	
	private String adEngine;
	private String keyword;
	private String matchType;
	private Integer position;
	
	private Double avgBid;
	private Double avgCPC;
	
	private Integer searchVol;
	private Integer clicks;
	private Integer impressions;
	
	private Date startDate;
	private Date endDate;
	
	private Date transactionDate;
	
	public String getAdEngine() {
		return adEngine;
	}
	public void setAdEngine(String adEngine) {
		this.adEngine = adEngine;
	}
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
		return avgCPC;
	}
	public void setAvgCost(Double avgCPC) {
		this.avgCPC = avgCPC;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getSaerchVol() {
		return searchVol;
	}
	public void setSearchVol(Integer saerchVol) {
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


	public AdEngineBidHistoryData(){};

	public AdEngineBidHistoryData(String adEngine, String keyword, String matchType,
			Integer position, Double avgBid, Double avgCPC, Integer saerchVol,
			Integer clicks, Integer impressions, Date startDate, Date endDate,
			Date transactionDate) {
		super();
		this.adEngine = adEngine;
		this.keyword = keyword;
		this.matchType = matchType;
		this.position = position;
		this.avgBid = avgBid;
		this.avgCPC = avgCPC;
		this.searchVol = saerchVol;
		this.clicks = clicks;
		this.impressions = impressions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.transactionDate = transactionDate;
	}
	
	public static String[] getKeywordArray(List<AdEngineBidHistoryData> historyDataList){
		String[]  kwrds = new String[historyDataList.size()];
		for(int i = 0; i< kwrds.length; i++){
			kwrds[i] = historyDataList.get(i).getKeyword();
		}
		return kwrds;
	}
	

	@Override
	public String toString() {
		return "AdEngineBidHistoryData [adEngine = "+ adEngine+", keyword=" + keyword + ", matchType="
				+ matchType + ", position=" + position + ", avgBid=" + avgBid
				+ ", avgCost=" + avgCPC + ", saerchVol=" + searchVol
				+ ", clicks=" + clicks + ", impressions=" + impressions
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", transactionDate=" + transactionDate + "]";
	}
	@Override
	public int hashCode() { // kept transactionDate out
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adEngine == null) ? 0 : adEngine.hashCode());
		result = prime * result + ((avgBid == null) ? 0 : avgBid.hashCode());
		result = prime * result + ((avgCPC == null) ? 0 : avgCPC.hashCode());
		result = prime * result + ((clicks == null) ? 0 : clicks.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((impressions == null) ? 0 : impressions.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result
				+ ((matchType == null) ? 0 : matchType.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result
				+ ((searchVol == null) ? 0 : searchVol.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) { // kept transactionDate out
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdEngineBidHistoryData other = (AdEngineBidHistoryData) obj;
		if (adEngine == null) {
			if (other.adEngine != null)
				return false;
		} else if (!adEngine.equals(other.adEngine))
			return false;
		if (avgBid == null) {
			if (other.avgBid != null)
				return false;
		} else if (!avgBid.equals(other.avgBid))
			return false;
		if (avgCPC == null) {
			if (other.avgCPC != null)
				return false;
		} else if (!avgCPC.equals(other.avgCPC))
			return false;
		if (clicks == null) {
			if (other.clicks != null)
				return false;
		} else if (!clicks.equals(other.clicks))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (impressions == null) {
			if (other.impressions != null)
				return false;
		} else if (!impressions.equals(other.impressions))
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (matchType == null) {
			if (other.matchType != null)
				return false;
		} else if (!matchType.equals(other.matchType))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (searchVol == null) {
			if (other.searchVol != null)
				return false;
		} else if (!searchVol.equals(other.searchVol))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
	
}
