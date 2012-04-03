package semplest.bidding.optimization;


import flanagan.math.*;
import semplest.bidding.estimation.*;


public class BidLagrangeOptim implements MinimisationFunction {
	
	KeyWordInterface key = null;
	double lambda = 1.0;
	ParametricFunction f;
	double [] ClickParams =null;
	double [] DCostParams = null;
	double score = 1.0;
	double minBid = 0.01;
	
	public BidLagrangeOptim(KeyWordInterface key, ParametricFunction f, double lambda) {
		this.key=key;
		ClickParams = key.getClickInfo();
		DCostParams = key.getDCostInfo();
		score = key.getQualityScore();
		minBid = key.getMinBid();
		this.lambda=lambda;
		this.f=f;
	}

	@Override
	public double function(double[] param) {
		
		return Math.pow(score*f.derivative(param, ClickParams)-lambda*f.derivative(param, DCostParams),2);
	}

}
