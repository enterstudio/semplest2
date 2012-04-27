package semplest.bidding.optimization;

public interface KeyWordInterface {
	
	public String getKeyWord();
	public double [] getBidInfo();
	public double [] getClickInfo();
	public double [] getCPCInfo();
//	public double [] getPosInfo();
	public double [] getDCostInfo(); // daily cost
	public double getQualityScore();
	public double getMinBid();
	public double getBidValue();
	public void setBidValue(double bidValue);


}
