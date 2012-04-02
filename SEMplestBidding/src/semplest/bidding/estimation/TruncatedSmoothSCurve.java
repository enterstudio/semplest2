package semplest.bidding.estimation;

//import org.apache.commons.math3.analysis.ParametricUnivariateFunction;

//public class TruncatedSmoothSCurve implements ParametricFunction, ParametricUnivariateFunction{
	public class TruncatedSmoothSCurve implements ParametricFunction {
	
	private double minBid = 0.01;
	private double [] TruncatedParameters; 
	
	public TruncatedSmoothSCurve(){
		TruncatedParameters = new double [2];
		TruncatedParameters[0]=minBid;//+0.1;
		TruncatedParameters[1]=0.002;
	}
	
	public TruncatedSmoothSCurve(double minBid){
		
		this.minBid = minBid;
		TruncatedParameters = new double [2];
		TruncatedParameters[0]=minBid;//+0.1;
		TruncatedParameters[1]=0.002;
	}
	
	
	@Override
	public void setMinBid(double minBid){
		this.minBid = minBid;
		TruncatedParameters[0]=minBid;//+0.1;
		TruncatedParameters[1]=0.002;
	}
	



	@Override
	public double function(double[] input, double[] parameters) {
		return Erf.function(input, parameters)*Erf.function(input, TruncatedParameters);
	}

	@Override
	public double derivative(double[] input, double[] parameters) {
		return Erf.derivative(input, parameters)*Erf.function(input, TruncatedParameters) + Erf.function(input, parameters)*Erf.derivative(input, TruncatedParameters);
	}

//	@Override
//	public double[] gradient(double x, double ... parameters) {
//		double [] input = new double[1];
//		input[0]=x;
//		return null;
//	}
//
//	@Override
//	public double value(double x, double ... parameters) {
//		double [] input = new double[1];
//		input[0]=x;
//		return Erf.function(input, parameters)*Erf.function(input, TruncatedParameters);
//	}

}
