package semplest.bidding.estimation;

public class WeibullCurve implements ParametricFunction {

	
	@Override
	public double function(double[] input, double[] parameters) {
		
		double lambda;
		double theta;
		double scaling;
		double bias;
		double x = input[0];
		switch (parameters.length){
		case 2:
			lambda = parameters[0];
			theta = parameters[1];
			return Math.max(0.0, 1-Math.exp(-Math.pow((x/lambda),theta)));
		case 3:
			lambda = parameters[0];
			theta = parameters[1];
			scaling = parameters[2];
			return Math.max(0.0, scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
		case 4:
			lambda = parameters[0];
			theta = parameters[1];
			scaling = parameters[2];
			bias = parameters[3];
			return Math.max(0.0, bias+scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
		default: 
			return 0;
		}
	}
	
	@Override
	public double derivative(double[] input, double[] parameters) {
		
		double lambda;
		double theta;
		double scaling;
//		double bias;
		double x = input[0];
		switch (parameters.length){
		case 2:
			lambda = parameters[0];
			theta = parameters[1];
			return Math.max(0, Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
		case 3:
		case 4:
			lambda = parameters[0];
			theta = parameters[1];
			scaling = parameters[2];
			return Math.max(0, scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
		default: 
			return 0;
		}
	}
}
