package semplest.bidding.optimization;


import flanagan.math.*;

class MinimFunct implements MinimisationFunction{

	@Override
	public double function(double[] param) {
		// TODO Auto-generated method stub
		return 0;
	}
}


public class ParameterEstimator {
	
	private ParametricFunction pf = null;
	private Minimisation min = new Minimisation();

	private double [][] input = null;
	private double [][] output = null;
	
	public ParameterEstimator(ParametricFunction pf){
		this.pf=pf;
	}
	
	public void estimateParams(){
		
		// starting point
		double[] start = {-5.0};
		
		// initial step sizes
	    double[] step = {0.2D};

	    // convergence tolerance
	    double ftol = 1e-15;

	    // Nelder and Mead minimisation procedure
//	    min.nelderMead(f, start, step, ftol);
	}
	
	
	
	public static void main(String [] args){
		GaussPdf pdf = new GaussPdf();
		
		ParameterEstimator pe = new ParameterEstimator(pdf);
		
		double [] x = {0.0};
		double [] parameters = {0.0, 1.0};
		System.out.println(pdf.function(x, parameters));
	}
	
	

}
