package semplest.other;

import java.util.Comparator;

import semplest.server.keyword.Keyword;



public class KeywordEstimate implements PerformanceData {
	
	private final Keyword keyword;
	private final Money bid;
	private final int impressions;
	private final Money cpc;
	private final Money cost;
	private final double avgPos;
	private int numberOfReEstimates;
	private final double clicks;
	private final boolean isValid;
	
	public KeywordEstimate() {
		this.keyword = null;
		this.bid = null;
		this.impressions = 0;
		this.cpc = null;
		this.cost = null;
		this.avgPos = 0;
		this.numberOfReEstimates = 0;
		this.clicks = 0;
		this.isValid = false;
	}
	
	public static KeywordEstimate validEstimate(Keyword keyword, Money bid, int impressions, double clicks, Money cost, double avgPos) {
		return new KeywordEstimate(keyword, true, bid, impressions, clicks, cost, avgPos, 0);
	}
	
	public static KeywordEstimate invalidEstimate(Keyword keyword, Money bid, int impressions, double clicks, Money cost, double avgPos) {
		return new KeywordEstimate(keyword, false, bid, impressions, clicks, cost, avgPos, 0);
	}
	
	private KeywordEstimate(Keyword keyword, boolean isValid, Money bid, int impressions, double clicks, Money cost, double avgPos, int numberOfReestimates) {
		this.keyword = keyword;
		this.isValid = isValid;
		this.bid = bid;
		this.impressions = impressions;
		this.cost = cost;
		this.cpc = calculateCpcFromClicksAndCost(clicks, cost);
		this.avgPos = avgPos;
		this.numberOfReEstimates = numberOfReestimates;
		this.clicks = clicks;
	}
	
	public KeywordEstimate updateEstimate(int impressions, double clicks, Money cost, double avgPos) {
		return new KeywordEstimate(keyword, true, bid, impressions, clicks, cost, avgPos, numberOfReEstimates);
	}
	
	public KeywordEstimate updateEstimatePreservesValidity(int impressions, double clicks, Money cost, double avgPos) {
		return new KeywordEstimate(keyword, isValid, bid, impressions, clicks, cost, avgPos, numberOfReEstimates);
	}
	
	private Money calculateCpcFromClicksAndCost(double clicks, Money cost) {
		Money cpc = clicks == 0 ? Money.zero() : Money.withMilliCents((long) (((double) cost.getMilliCents()) / clicks));
		return cpc;
	}
	
	public int getNumberOfReEstimates() {
		return numberOfReEstimates;
	}
	
	public Keyword getKeyword() {
		return keyword;
	}
	
	public Money getBid() {
		return bid;
	}
	
	public int getImpressions() {
		return impressions;
	}
	
	public Money getCpc() {
		return cpc;
	}
	
	public Money getCost() {
		return cost;
	}
	
	public double getAvgPos() {
		return avgPos;
	}
	
	public double getClicks() {
		return clicks;
	}
	
	public boolean matchesOnBidAndKeyword(KeywordEstimate estimate) {
		return estimate.getKeyword().equals(keyword) && estimate.getBid().equals(bid);
	}
	
	public static KeywordEstimate invalid(Keyword keyword) {
		return new KeywordEstimate(keyword, false, Money.zero(), 0, 0, Money.zero(), 0, 0);
	}
	
	public KeywordEstimate incrementNumberOfReestimations() {
		return new KeywordEstimate(keyword, true, bid, impressions, clicks, cost, avgPos, numberOfReEstimates + 1);
	}
	
	public KeywordEstimate transformImpressions(double rate) {
		return updateEstimate(reEstimateImpressions(rate), clicks, cost, avgPos);
	}
	
	public KeywordEstimate transformClicks(double rate) {
		return updateEstimate(impressions, reEstimateClicks(rate), cost, avgPos);
	}
	
	public KeywordEstimate transformCost(double rate) {
		return updateEstimate(impressions, clicks, reEstimateCost(rate), avgPos);
	}
	
	public KeywordEstimate transformAvgPos(double rate) {
		return updateEstimate(impressions, clicks, cost, reEstimatePosition(rate));
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	// NOTE: it's possible for impressions to be estimated down to 0 while retaining a valid value for avgPos.
	public boolean hasValidPosition() {
		return avgPos > 0;
	}
	
	private int reEstimateImpressions(double impressionRate) {
		return (int) (impressions * impressionRate);
	}
	
	private double reEstimateClicks(double clicksRate) {
		return clicksRate * clicks;
	}
	
	private Money reEstimateCost(double estCostRate) {
		return cost.times(estCostRate);
	}
	
	private double reEstimatePosition(double avgPosRate) {
		return avgPos * avgPosRate;
	}
	
	public KeywordEstimate updateEstimateWithClicks(double newImp, double clicks, double newCostMilliCents, double newAvgPos) {
		return updateEstimate((int) newImp, clicks, Money.withMilliCents((long) newCostMilliCents), newAvgPos);
	}
	
	public KeywordEstimate updateEstimateWithBid(Money newBid) {
		return new KeywordEstimate(keyword, isValid, newBid, impressions, clicks, cost, avgPos, 0);
	}
	
	public static F<KeywordEstimate, String> toKeywordString() {
		return new F<KeywordEstimate, String>() {
			
			@Override
			public String apply(KeywordEstimate a) {
				return a.getKeyword().getKeywordString();
			}
		};
	}
	
	public static F<KeywordEstimate, String> toImpressionString() {
		return new F<KeywordEstimate, String>() {
			
			@Override
			public String apply(KeywordEstimate a) {
				return a.getImpressions() + "";
			}
		};
	}
	
	public static F<KeywordEstimate, Keyword> keywordEstimateToKeyword() {
		return new F<KeywordEstimate, Keyword>() {
			@Override
			public Keyword apply(KeywordEstimate a) {
				return a.keyword;
			}
		};
	}
	
	public static F<KeywordEstimate, Money> keywordEstimateToBid() {
		return new F<KeywordEstimate, Money>() {
			@Override
			public Money apply(KeywordEstimate a) {
				return a.getBid();
			}
		};
	}
	
	public static Comparator<KeywordEstimate> byBidAscending() {
		return new Comparator<KeywordEstimate>() {
			@Override
			public int compare(KeywordEstimate o1, KeywordEstimate o2) {
				return o1.getBid().compareTo(o2.getBid());
			}
		};
	}
	
	public static Filter<KeywordEstimate> valid() {
		return new Filter<KeywordEstimate>() {
			@Override
			public Boolean apply(KeywordEstimate a) {
				return a.isValid();
			}
		};
	}
	
	public static Filter<KeywordEstimate> invalid() {
		return new Filter<KeywordEstimate>() {
			@Override
			public Boolean apply(KeywordEstimate a) {
				return !a.isValid();
			}
		};
	}
	
	public static Filter<KeywordEstimate> invalidAvgPos() {
		return new Filter<KeywordEstimate>() {
			@Override
			public Boolean apply(KeywordEstimate a) {
				return !a.hasValidPosition();
			}
		};
	}
	
	public F<KeywordEstimate, KeywordEstimate> swapChecker() {
		return new F<KeywordEstimate, KeywordEstimate>() {
			@Override
			public KeywordEstimate apply(KeywordEstimate a) {
				if (a.getBid().equals(getBid()) && a.getKeyword().equals(getKeyword())) {
					return KeywordEstimate.this;
				}
				return a;
			}
		};
	}
	
	public KeywordEstimate updateEstimate(KeywordEstimate keywordEstimate) {
		return updateEstimate(keywordEstimate.getImpressions(), keywordEstimate.getClicks(), keywordEstimate.getCost(), keywordEstimate.getAvgPos());
	}
	
	public KeywordEstimate withAvgPos(double avgPos2) {
		return updateEstimate(impressions, clicks, cost, avgPos2);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgPos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bid == null) ? 0 : bid.hashCode());
		temp = Double.doubleToLongBits(clicks);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((cpc == null) ? 0 : cpc.hashCode());
		result = prime * result + impressions;
		result = prime * result + (isValid ? 1231 : 1237);
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + numberOfReEstimates;
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
		KeywordEstimate other = (KeywordEstimate) obj;
		if (Double.doubleToLongBits(avgPos) != Double.doubleToLongBits(other.avgPos))
			return false;
		if (bid == null) {
			if (other.bid != null)
				return false;
		} else if (!bid.equals(other.bid))
			return false;
		if (Double.doubleToLongBits(clicks) != Double.doubleToLongBits(other.clicks))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (cpc == null) {
			if (other.cpc != null)
				return false;
		} else if (!cpc.equals(other.cpc))
			return false;
		if (impressions != other.impressions)
			return false;
		if (isValid != other.isValid)
			return false;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.equals(other.keyword))
			return false;
		if (numberOfReEstimates != other.numberOfReEstimates)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "KeywordEstimate [keyword=" + keyword + ", bid=" + bid + ", impressions=" + impressions + ", cpc=" + cpc + ", cost=" + cost + ", avgPos=" + avgPos + ", numberOfReEstimates=" + numberOfReEstimates + ", clicks=" + clicks + ", isValid=" + isValid + "]";
	}
}