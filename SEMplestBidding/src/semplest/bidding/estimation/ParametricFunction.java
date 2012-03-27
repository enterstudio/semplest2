package semplest.bidding.estimation;

public interface ParametricFunction {
	
	public double function(double [] input, double [] parameters);

	public double derivative(double[] input, double[] parameters);
}
