package semplest.bidding.optimization;

import org.apache.commons.math3.analysis.UnivariateFunction;

import semplest.bidding.estimation.Weibull;

public class LagrangeBidDerivativeFunction implements UnivariateFunction {

	private double [] ClickParams = null;
	private double [] DCostParams = null;
	private double minBid = 0.01;
	private double multLagrange = 1.0;
	private double score = 1.0;
	
	private Weibull wf = null;
	
	
	public LagrangeBidDerivativeFunction(double [] ClickParams, double [] DCostParams, double score, double minBid, double multLagrange){
		this.ClickParams = ClickParams;
		this.DCostParams = DCostParams;
		this.score = score;
		this.minBid = minBid;
		this.multLagrange = multLagrange;
		this.wf = new Weibull();
	}
	// this method returns the derivative of the bid optimization function
	@Override
	public double value(double b) {
//		double x = score*wf.derivative(b, ClickParams) - multLagrange*wf.derivative(b, DCostParams);
		double x = wf.doublederivative(b, ClickParams);

		System.out.println("Derivative: b="+b +", deriv=" + x);
		return score*wf.doublederivative(b, ClickParams) - multLagrange*wf.doublederivative(b, DCostParams);
	}

}
