package semplest.bidding.estimation;

import org.apache.commons.math3.analysis.ParametricUnivariateFunction;

public class Weibull implements ParametricUnivariateFunction {

	@Override
	public double[] gradient(double x, double... parameters) {
		double [] gradient = new double[3];
		double lambda = parameters[0];
		double theta = parameters[1];
		double scaling = parameters[2];
		
		gradient[0]=scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow((x/lambda),2*theta)*(theta/lambda);
		gradient[1]=scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow((x/lambda),theta)*Math.log(x/lambda);
		gradient[2]=1-Math.exp(-Math.pow((x/lambda),theta));
		return gradient;
	}

	@Override
	public double value(double x, double... parameters) {
		double lambda = parameters[0];
		double theta = parameters[1];
		double scaling = parameters[2];
		
		if (x<=0) {
			return 0;
		} else {
			return scaling*(1-Math.exp(-Math.pow((x/lambda),theta)));
		}
	}
	
	public double derivative(double x, double... parameters) {
		double lambda = parameters[0];
		double theta = parameters[1];
		double scaling = parameters[2];

		if (x<=0) {
			return 0;
		} else {
			return scaling*Math.exp(-Math.pow((x/lambda),theta))*(theta/lambda)*Math.pow(x/lambda, theta-1);
		}	
		
	}
	
	
	public double doublederivative(double x, double... parameters) {
		double lambda = parameters[0];
		double theta = parameters[1];
		double scaling = parameters[2];

		if (x<=0) {
			return 1e-6;
		} else {
			return scaling*Math.exp(-Math.pow((x/lambda),theta))*(theta/lambda)*Math.pow(x/lambda, theta-2)*(theta-1-theta*Math.pow(x/lambda, theta));
		}	
		
	}


}
