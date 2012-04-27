package semplest.other;

import static semplest.other.Lists.map;
import static semplest.other.Money.zero;
import static semplest.other.KeywordEstimate.invalidEstimate;
import static semplest.other.KeywordEstimate.validEstimate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import semplest.server.keyword.Keyword;


public class KeywordEstimates {
	private Map<Keyword, List<KeywordEstimate>> estimatesByKeyword = new HashMap<Keyword, List<KeywordEstimate>>();
	private Set<Money> bidLevels = new LinkedHashSet<Money>();
	
	public KeywordEstimates(List<KeywordEstimate> estimates) {
		for (KeywordEstimate estimate : estimates) {
			List<KeywordEstimate> keywordsEstimates = estimatesByKeyword.get(estimate.getKeyword());
			if (keywordsEstimates == null) {
				keywordsEstimates = new ArrayList<KeywordEstimate>();
				estimatesByKeyword.put(estimate.getKeyword(), keywordsEstimates);
			}
			keywordsEstimates.add(estimate);
			bidLevels.add(estimate.getBid());
		}
	}
	
	public List<KeywordEstimate> getEstimates() {
		ArrayList<KeywordEstimate> estimates = new ArrayList<KeywordEstimate>();
		for (List<KeywordEstimate> estimatesForKeyword : estimatesByKeyword.values()) {
			estimates.addAll(estimatesForKeyword);
		}
		return estimates;
	}
	
	public Set<Keyword> getKeywords() {
		return estimatesByKeyword.keySet();
	}
	
	public Set<Money> getBidLevels() {
		return new LinkedHashSet<Money>(bidLevels);
	}
	
	public List<KeywordEstimate> getEstimates(Keyword keyword) {
		return estimatesByKeyword.get(keyword);
	}
	
	public KeywordEstimatePair getSuroundingEstimatePair(Keyword keyword, Money bid) {
		List<KeywordEstimate> estimates = estimatesByKeyword.get(keyword);
		if (estimates.isEmpty()) {
			throw new Defect("we could not find any keywords for: " + keyword + " in this collection");
		}
		Collections.sort(estimates, new Comparator<KeywordEstimate>() {
			@Override
			public int compare(KeywordEstimate o1, KeywordEstimate o2) {
				return o1.getBid().compareTo(o2.getBid());
			}
		});
		
		int i = 0;
		for (KeywordEstimate estimate : estimates) {
			Money isThisTheBid = estimate.getBid();
			if (isThisTheBid.equals(bid)) {
				return new KeywordEstimatePair(estimate, estimate, bid);
			}
			if (bid.lessThan(isThisTheBid)) {
				KeywordEstimate lesser;
				if (i == 0) {
					// this would only occur if the bid level is less than the bid level of the lowest-available estimate.  throw a defect
					throw new Defect("Attempting to find surrounding bids for bid level " + bid + " on keyword '" + keyword + "', but this level is lower than the lowest-possible bid level " + isThisTheBid + ", suggesting we have placed a bid that is lower than the minimum allowed..");
				} else {
					lesser = estimates.get(i - 1);
				}
				return new KeywordEstimatePair(lesser, estimate, bid);
			}
			i++;
		}
		throw new Defect("we could not find any keywords for: " + keyword + " in this collection!! with bid: " + bid + " in\n" + estimates);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estimatesByKeyword == null) ? 0 : estimatesByKeyword.hashCode());
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
		KeywordEstimates other = (KeywordEstimates) obj;
		if (estimatesByKeyword == null) {
			if (other.estimatesByKeyword != null)
				return false;
		} else if (!estimatesByKeyword.equals(other.estimatesByKeyword))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return estimatesByKeyword.values().toString();
	}
	
	public KeywordEstimate getEstimate(Keyword keyword, Money bid) {
		List<KeywordEstimate> estimates = getEstimates(keyword);
		for (KeywordEstimate estimate : estimates) {
			if (estimate.getBid().equals(bid)) {
				return estimate;
			}
		}
		throw new Defect("could not find the estimate you were looking for: " + keyword + " " + bid);
	}
	
	public KeywordEstimate getLinearnlyInterpolatedEstimate(Keyword keyword, Money bid) {
		if ((estimatesByKeyword == null) || estimatesByKeyword.isEmpty()) {
			throw new Defect("KeywordEstimates collection has no KeywordEstimates for query " + keyword + " " + bid);
		}
		KeywordEstimatePair suroundingEstimate = getSuroundingEstimatePair(keyword, bid);
		if (suroundingEstimate.lesser == suroundingEstimate.greater) {
			return suroundingEstimate.lesser;
		}
		return suroundingEstimate.interpolate();
	}
	
	public static class KeywordEstimatePair {
		public final KeywordEstimate lesser;
		public final KeywordEstimate greater;
		public final Keyword keyword;
		public final Money midPointBid;
		public final long midPoint;
		
		public KeywordEstimatePair(KeywordEstimate lesser, KeywordEstimate greater, Money midPointBid) {
			this.lesser = lesser;
			this.greater = greater;
			this.keyword = greater.getKeyword();
			if (!lesser.getKeyword().equals(this.keyword)) {
				throw new Defect("Attempting to interpolate between estimates with different keywords: " + lesser.getKeyword() + " and " + greater.getKeyword());
			}
			this.midPointBid = midPointBid;
			this.midPoint = midPointBid.getMilliCents();
		}
		
		public boolean areBothValid() {
			return lesser.isValid() && greater.isValid();
		}
		
		public boolean bothHaveValidPosition() {
			return lesser.hasValidPosition() && greater.hasValidPosition();
		}
		
		public KeywordEstimate interpolate() {
			long x1 = lesser.getBid().getMilliCents();
			long x2 = greater.getBid().getMilliCents();
			
			int imp1 = lesser.getImpressions();
			int imp2 = greater.getImpressions();
			double impSlope = slope(x1, imp1, x2, imp2);
			double impYIntercept = yIntercept(x1, imp1, impSlope);
			double newImp = y(impSlope, midPoint, impYIntercept);
			
			long costMilliCents1 = lesser.getCost().getMilliCents();
			long costMilliCents2 = greater.getCost().getMilliCents();
			double costSlope = slope(x1, costMilliCents1, x2, costMilliCents2);
			double costYIntercept = yIntercept(x1, costMilliCents1, costSlope);
			double newCostMilliCents = y(costSlope, midPoint, costYIntercept);
			
			double clicks1 = lesser.getClicks();
			double clicks2 = greater.getClicks();
			double clicksSlope = slope(x1, clicks1, x2, clicks2);
			double clicksYIntercept = yIntercept(x1, clicks1, clicksSlope);
			double newClicks = y(clicksSlope, midPoint, clicksYIntercept);
			
			double avgPos1 = lesser.getAvgPos();
			double avgPos2 = greater.getAvgPos();
			double avgPosSlope = slope(x1, avgPos1, x2, avgPos2);
			double avgYIntercept = yIntercept(x1, avgPos1, avgPosSlope);
			double newAvgPos = y(avgPosSlope, midPoint, avgYIntercept);
			newAvgPos = Math.floor(100000 * newAvgPos) / 100000;
			
			// this interpolated estimate is only valid if both endpoints used in the interpolation are valid.  its position is valid only if the positions n the endpoints are valid.
			if (!lesser.hasValidPosition() || !greater.hasValidPosition()) {
				newAvgPos = 0;
			}
			boolean validMidpoint = lesser.isValid() && greater.isValid();
			KeywordEstimate interpolatedEstimate;
			if (validMidpoint) {
				interpolatedEstimate = validEstimate(keyword, midPointBid, (int) newImp, newClicks, Money.withMilliCents((long) newCostMilliCents), newAvgPos);
			} else {
				interpolatedEstimate = invalidEstimate(keyword, midPointBid, (int) newImp, newClicks, Money.withMilliCents((long) newCostMilliCents), newAvgPos);
			}
			
			return interpolatedEstimate;
		}
		
		public static double yIntercept(double x1, double y1, double slope) {
			return y1 - (slope * x1);
		}
		
		public static double slope(double x1, double y1, double x2, double y2) {
			return (y2 - y1) / (x2 - x1);
		}
		
		public static double y(double slope, double x, double yIntercept) {
			return slope * x + yIntercept;
		}
		
	}
	
	public KeywordEstimate getEstimateForBidLevelClosestTo(Keyword keyword, Money bid) {
		KeywordEstimatePair suroundingEstimate = getSuroundingEstimatePair(keyword, bid);
		long greaterBid = suroundingEstimate.greater.getBid().getMilliCents();
		long lesserBid = suroundingEstimate.lesser.getBid().getMilliCents();
		long distanceToGreaterBid = greaterBid - bid.getMilliCents();
		long distanceToLesserBid = bid.getMilliCents() - lesserBid;
		
		return distanceToLesserBid < distanceToGreaterBid ? suroundingEstimate.lesser : suroundingEstimate.greater;
	}
	
	public KeywordEstimates swapOutEstimate(final KeywordEstimate estimate) {
		return new KeywordEstimates(map(getEstimates(), estimate.swapChecker()));
	}
	
	public boolean is0CostWord(Keyword keyword) {
		Money sum = zero();
		for (KeywordEstimate keywordEstimate : getEstimates(keyword)) {
			sum = sum.plus(keywordEstimate.getCost());
		}
		if (sum.equals(zero()))
			return true;
		
		return false;
	}
	
	public boolean isKeywordWithAllInvalidEstimates(Keyword keyword) {
		boolean hasOnlyInvalidEstimates = true;
		for (KeywordEstimate estimate : getEstimates(keyword)) {
			if (estimate.isValid()) {
				hasOnlyInvalidEstimates = false;
				break;
			}
		}
		return hasOnlyInvalidEstimates;
	}
	
	public int getTotalNumberOfReestimatesFor(Keyword keyword) {
		int sum = 0;
		for (KeywordEstimate keywordEstimate : getEstimates(keyword)) {
			sum += keywordEstimate.getNumberOfReEstimates();
		}
		return sum;
	}
}
