package semplest.bidding.estimation;

public class GaussPdf implements ParametricFunction {


	@Override
	public double function(double[] input, double[] parameters) {
		double mu = parameters[0];
		double sigma = parameters[1];
		double x = input[0];
		return Math.exp(-0.5*Math.pow((x-mu)/sigma,2))/Math.sqrt(2*Math.PI)/sigma;
	}

	@Override
	public double derivative(double[] input, double[] parameters) {
		double mu = parameters[0];
		double sigma = parameters[1];
		double x = input[0];
		return -(x-mu/sigma)*Math.exp(-0.5*Math.pow((x-mu)/sigma,2))/Math.sqrt(2*Math.PI)/sigma;
	}

}
