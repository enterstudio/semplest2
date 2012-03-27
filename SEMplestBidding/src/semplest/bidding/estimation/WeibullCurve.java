package semplest.bidding.estimation;

public class WeibullCurve implements ParametricFunction {

	
	// This is not a distribution function. The parameter[2] is a scaling and if it is set to 1 then
	// we get a distribution function.
	@Override
	public double function(double[] input, double[] parameters) {
		
		// parameters[0]=lambda, parameters[1]=theta, parmaters[2]=amplitude, parameters[3]=scaling
		switch (parameters.length){
		case 2:
			return Math.max(0.0, 1-Math.exp(-Math.pow((input[0]/parameters[0]),parameters[1])));
		case 3:
			return Math.max(0.0, parameters[2]*(1-Math.exp(-Math.pow((input[0]/parameters[0]),parameters[1]))));
		case 4:
			return Math.max(0.0, parameters[3]+parameters[2]*(1-Math.exp(-Math.pow((input[0]/parameters[0]),parameters[1]))));
		default: 
			return 0;
		}
	}
}
