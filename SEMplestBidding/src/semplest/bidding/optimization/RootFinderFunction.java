package semplest.bidding.optimization;

import semplest.bidding.estimation.ParametricFunction;
import flanagan.math.MinimisationFunction;

public class RootFinderFunction implements MinimisationFunction {
	
	double target = 0.0;
	ParametricFunction f;
	double [] params = null;

	
	public RootFinderFunction(ParametricFunction f, double target, double [] params) {

		this.target=target;
		this.f=f;
		this.params=params;
	}

	@Override
	public double function(double[] in) {
		
		return Math.pow((f.function(in, params)-target),2);
		
	}

}


