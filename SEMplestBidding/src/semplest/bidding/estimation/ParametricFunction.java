package semplest.bidding.estimation;

public interface ParametricFunction {
	
	double function(double [] input, double [] parameters);

	double derivative(double[] input, double[] parameters);

	void setMinBid(double minBid);
	
	Double getScalingCoeff(double[] parameters);
}
