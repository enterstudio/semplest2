package semplest.bidding.optimization;


import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;

public class LagrangeBidFunction implements UnivariateFunction, DifferentiableUnivariateFunction {

	private double [] ClickParams = null;
	private double [] DCostParams = null;
	private double minBid = 0.01;
	private double multLagrange = 1.0;
	
	public LagrangeBidFunction (double [] ClickParams, double [] DCostParams, double minBid, double multLagrange) {
		this.ClickParams = ClickParams;
		this.DCostParams = DCostParams;
		this.minBid = minBid;
		this.multLagrange = multLagrange;
	}
	
	@Override
	public double value(double b) {
		return 0;
	}

	@Override
	public UnivariateFunction derivative() {
		// TODO Auto-generated method stub
		return null;
	}


}
