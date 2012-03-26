package semplest.bidding.estimation;

public class WeibullCurve implements ParametricFunction {

	@Override
	public double function(double[] input, double[] parameters) {
		// parameters[0]=lambda, parameters[1]=theta, parmaters[2]=amplitude
		return parameters[2]*(1-Math.exp(-Math.pow((input[0]/parameters[0]),parameters[1])));
	}
}
