package semplest.bidding.estimation;

public class TruncatedSmoothSCurve implements ParametricFunction {
	
	private double minBid = 0.01;
	private double [] TruncatedParameters; 
	
	public TruncatedSmoothSCurve(){
		TruncatedParameters = new double [2];
		TruncatedParameters[0]=minBid+0.01;
		TruncatedParameters[1]=0.002;
	}
	
	public TruncatedSmoothSCurve(double minBid){
		
		this.minBid = minBid;
		TruncatedParameters = new double [2];
		TruncatedParameters[0]=minBid+0.01;
		TruncatedParameters[1]=0.002;
	}
	
	
	@Override
	public void setMinBid(double minBid){
		this.minBid = minBid;
		TruncatedParameters[0]=minBid+0.01;
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

}
