package semplest.bidding.estimation;

public class WeibullCurve implements ParametricFunction {

	
	@Override
	public double function(double[] input, double[] parameters) {
		
		double lambda;
		double theta;
		double scaling;
		double shifting;
		double x = input[0];
		switch (parameters.length){
		case 2:
			lambda = parameters[0];
			theta = parameters[1];
//			return Math.max(0.0, 1-Math.exp(-Math.pow((x/lambda),theta)));
			return 1-Math.exp(-Math.pow((x/lambda),theta));
		case 3:
			lambda = parameters[0];
			theta = parameters[1];
			scaling = parameters[2];
//			return Math.max(0.0, scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
			return scaling*(1-Math.exp(-Math.pow((x/lambda),theta)));
		case 4:
			lambda = parameters[0];
			theta = parameters[1];
//			theta=2;
			scaling = parameters[2];
			shifting = parameters[3];
			x=x-shifting;
//			return Math.max(0.0, scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
			return scaling*(1-Math.exp(-Math.pow((x/lambda),theta)));
		default: 
			return 0;
		}
	}
	
	@Override
	public double derivative(double[] input, double[] parameters) {
		
		double lambda;
		double theta;
		double scaling;
		double shifting;
		double x = input[0];
		switch (parameters.length){
		case 2:
			lambda = parameters[0];
			theta = parameters[1];
//			return Math.max(0, Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
			return Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x);
		case 3:
			lambda = parameters[0];
			theta = parameters[1];
			scaling = parameters[2];
//			return Math.max(0, scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
			return scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x);
		case 4:
			lambda = parameters[0];
			theta = parameters[1];
//			theta=2;
			scaling = parameters[2];
			shifting = parameters[3];
			x=x-shifting;
//			return Math.max(0, scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
			return scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x);
		default: 
			return 0;
		}
	}

	@Override
	public void setMinBid(double minBid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getScalingCoeff(double[] parameters) {

		double scaling;
		switch (parameters.length){
		case 2:
			
			return null;
		case 3:
			scaling = parameters[2];
//			return Math.max(0.0, scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
			return new Double(scaling);
		case 4:
			scaling = parameters[2];
			return new Double(scaling);
		default: 
			return null;
		}
	}
}

//package semplest.bidding.estimation;
//
//public class WeibullCurve implements ParametricFunction {
//
//	
//	@Override
//	public double function(double[] input, double[] parameters) {
//		
//		double lambda;
//		double theta;
//		double scaling;
//		double bias;
//		double x = input[0];
//		switch (parameters.length){
//		case 2:
//			lambda = parameters[0];
//			theta = parameters[1];
//			return Math.max(0.0, 1-Math.exp(-Math.pow((x/lambda),theta)));
//		case 3:
//			lambda = parameters[0];
//			theta = parameters[1];
//			scaling = parameters[2];
//			return Math.max(0.0, scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
//		case 4:
//			lambda = parameters[0];
//			theta = parameters[1];
//			scaling = parameters[2];
//			bias = parameters[3];
//			return Math.max(0.0, bias+scaling*(1-Math.exp(-Math.pow((x/lambda),theta))));
//		default: 
//			return 0;
//		}
//	}
//	
//	@Override
//	public double derivative(double[] input, double[] parameters) {
//		
//		double lambda;
//		double theta;
//		double scaling;
////		double bias;
//		double x = input[0];
//		switch (parameters.length){
//		case 2:
//			lambda = parameters[0];
//			theta = parameters[1];
//			return Math.max(0, Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
//		case 3:
//		case 4:
//			lambda = parameters[0];
//			theta = parameters[1];
//			scaling = parameters[2];
//			return Math.max(0, scaling*Math.exp(-Math.pow((x/lambda),theta))*Math.pow(x/lambda, theta)*(theta/x));
//		default: 
//			return 0;
//		}
//	}
//}
