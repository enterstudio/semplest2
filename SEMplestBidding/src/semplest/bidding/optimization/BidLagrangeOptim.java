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
	
	public BidLagrangeOptim(KeyWordInterface key, ParametricFunction f, double lambda){
		this.key=key;
		ClickParams = key.getClickInfo();
		DCostParams = key.getDCostInfo();
		score = key.getQualityScore();
		this.lambda=lambda;
		this.f=f;
	}

	@Override
	public double function(double[] param) {
		return Math.abs(lambda-score*f.derivative(param, ClickParams)/f.derivative(param, DCostParams));
	}

}
