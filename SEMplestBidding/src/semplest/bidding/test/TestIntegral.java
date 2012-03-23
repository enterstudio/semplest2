package semplest.bidding.test;



import flanagan.integration.Integration;
import flanagan.integration.IntegralFunction;


class GaussPdf implements IntegralFunction{
	private double mu = 0;
	private double sigma = 1;
	
	public void setMu(double mu){
		this.mu=mu;
	}
	
	public void setSigma(double sigma){
		this.sigma=sigma;
	}
	
	public double function(double x){
		return Math.exp(-0.5*Math.pow((x-mu)/sigma,2))/Math.sqrt(2*Math.PI)/sigma;
	}
}



//Class to demonstrate numerical integration methods in class Integration.
public class TestIntegral {

	public static void main(String[] arg){


		GaussPdf f = new GaussPdf();
		f.setMu(1);
		f.setSigma(2);
		Integration intgn3 = new Integration(f);
		intgn3.setLimits(-10, 1);
		double integralSum3 = intgn3.gaussQuad(32);
		System.out.println("The 32 point Gausian-Legendre integral of Gaussian pdf between the limits -10 and 1 is " + integralSum3);
		double integralSum3_1 = intgn3.trapezium(1000);
		System.out.println("The 1000 point interval trapezium integral of Gaussian pdf between the limits -10 and 1 is " + integralSum3_1);

		// Assign values to constants in the functions

	}
}