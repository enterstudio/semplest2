package semplest.bidding.optimization;


import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;

import semplest.bidding.estimation.Erf;
import semplest.bidding.estimation.Weibull;

public class LagrangeBidFunction implements UnivariateFunction, DifferentiableUnivariateFunction {

	private double [] ClickParams = null;
	private double [] DCostParams = null;
	private double minBid = 0.01;
	private double [] TruncatedParameters; 
	private double [] input;

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
		TruncatedParameters = new double [2];
		TruncatedParameters[0]=minBid+0.1;
		TruncatedParameters[1]=0.002;
		input = new double[1];
	}
	
	@Override
	public double value(double b) {
//		double x = score*wf.derivative(b, ClickParams) - multLagrange*wf.derivative(b, DCostParams);
//		System.out.println("Function val: b="+b +", value=" + x);
//		return score*wf.derivative(b, ClickParams) - multLagrange*wf.derivative(b, DCostParams);
		
		input[0]=b;
//		double x = Math.pow((score*wf.value(b, ClickParams) - multLagrange*wf.value(b, DCostParams))*Erf.function(input, TruncatedParameters),2);
//		System.out.println("Function val: b="+b +", value=" + x);
		return Math.pow((score*wf.derivative(b, ClickParams) - multLagrange*wf.derivative(b, DCostParams))*Erf.function(input, TruncatedParameters),2);
	}

	@Override
	public UnivariateFunction derivative() {
		return new LagrangeBidDerivativeFunction(ClickParams, DCostParams, score, minBid, multLagrange);
	}


}
