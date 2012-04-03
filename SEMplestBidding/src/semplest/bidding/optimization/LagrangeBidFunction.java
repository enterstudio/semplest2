package semplest.bidding.optimization;


import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;

import semplest.bidding.estimation.Weibull;

public class LagrangeBidFunction implements UnivariateFunction, DifferentiableUnivariateFunction {

	private double [] ClickParams = null;
	private double [] DCostParams = null;
	private double minBid = 0.01;
	private double multLagrange = 1.0;
	private double score = 1.0;
	
	private Weibull wf = null;
	
	
	public LagrangeBidFunction (double [] ClickParams, double [] DCostParams, double score, double minBid, double multLagrange) {
		this.ClickParams = ClickParams;
		this.DCostParams = DCostParams;
		this.score = score;
		this.minBid = minBid;
		this.multLagrange = multLagrange;
		this.wf = new Weibull();
	}
	
	@Override
	public double value(double b) {
		return score*wf.value(b, ClickParams) - multLagrange*wf.value(b, DCostParams);
	}

	@Override
	public UnivariateFunction derivative() {
		return new LagrangeBidDerivativeFunction(ClickParams, DCostParams, score, minBid, multLagrange);
	}


}
