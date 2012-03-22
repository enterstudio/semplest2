package semplest.bidding.test;



/*     Example of the use of the class Integration demonstrating
the use of several of the numerical integration methods
in integrating one of two functions, y = a + x*x and y = b + c*x
using the instance methods.

Michael Thomas Flanagan

July 2006
 */

import flanagan.integration.Integration;
import flanagan.integration.IntegralFunction;

//Class to evaluate the function y = a + x*x for a given value of x (function 1).
class Funct1 implements IntegralFunction{

	private double a = 0.0D;

	public double function(double x){
		double y = a + x*x;
		return y;
	}

	public void setA(double a){
		this.a = a;
	}
}

//Class to evaluate the function y = b + c*x for a given value of x (function 2).
class Funct2 implements IntegralFunction{

	private double b = 0.0D, c = 1.0D;

	public double function(double x){
		double y = b + c*x;
		return y;
	}

	public void setB(double b){
		this.b = b;
	}

	public void setC(double c){
		this.c = c;
	}
}

//Class to demonstrate numerical integration methods in class Integration.
public class TestIntegral {

	public static void main(String[] arg){

		// Create instances of the classes holding the function evaluation methods
		Funct1 f1 = new Funct1();
		Funct2 f2 = new Funct2();

		// Assign values to constants in the functions
		f1.setA(10.5);

		f2.setB(7.0);
		f2.setC(-2.3);

		// Create two instances of the Integration class one for each function to be integrated
		Integration intgn1 = new Integration(f1);
		Integration intgn2 = new Integration(f2);

		// Example of Gauss-Legendre quadrature on function 1
		// Call Gauss-Legendre quadrature method to operate on function 1
		// Set limits
		intgn1.setLimits(1.0D, 3.0D);
		// Perform quadrature
		double integralSum0 = intgn1.gaussQuad(32);

		// Output the result
		System.out.println("The 32 point Gausian-Legendre integral of function 1 between the limits 1.0 and 3.0 is " + integralSum0);

		// Call Gauss-Legendre quadrature method to operate on function 2 with the same limits and twice the number of points
		intgn2.setLimits(1.0D, 3.0D);
		integralSum0 = intgn2.gaussQuad(64);
		System.out.println("The 64 point Gausian-Legendre integral of function 2 between the limits 1.0 and 3.0 is " + integralSum0);

		// Example of Gauss-Legendre Quadrature and Trapeziodal rule applied to function 1
		// Reset limits
		intgn1.setLimits(0.0D, 5.0D);
		// Call 16 point Gauss-Legendre quadrature
		double integralSum1 = intgn1.gaussQuad(16);
		// Call 1000 interval trapezium rule
		double integralSum2 = intgn1.trapezium(1000);

		System.out.println("The 16 point Gausian-Legendre integral of function 1 between the limits 0.0 and 5.0 is " + integralSum1);
		System.out.println("The 1000 interval trapezium integral of function 1 between the limits 0.0 and 5.0 is " + integralSum2);

		// Example of Trapeziodal rule and backward rectangular rule applied to function 2 after function constants have been altered
		// Reset b and c
		f2.setB(3.1D);
		f2.setC(5.5D);

		// Reset limits and number of intervals
		intgn2.setLimits(0.0D, 10.0D);

		// Call both methods to operate on function 2
		integralSum1 = intgn2.trapezium(5000);        // 5000 interval trapezium rule
		integralSum2 = intgn2.backward(5000);         // 5000 interval backward rectangular rule

		System.out.println("The 5000 interval trapezium integral of function 2 between the limits 0.0 and 10.0 is " + integralSum1);
		System.out.println("The 5000 interval backward rectangular integral of function 2 between the limits 0.0 and 10.0 is " + integralSum2);

	}
}