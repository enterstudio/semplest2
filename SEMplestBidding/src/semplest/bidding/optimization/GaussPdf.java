package semplest.bidding.optimization;

public class GaussPdf extends ParametricFunction {

	
//	@Override
//	public double function(double[] input) throws Exception  {
//		throw new Exception("Parameters must be specified for Gaussian distribution");
////		return 0;
//	}

	@Override
	public double function(double[] input, double[] parameters) {
		return Math.exp(-0.5*Math.pow((input[0]-parameters[0])/parameters[1],2))/Math.sqrt(2*Math.PI)/parameters[1];
	}

}
