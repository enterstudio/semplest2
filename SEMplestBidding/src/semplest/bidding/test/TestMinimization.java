package semplest.bidding.test;


import flanagan.math.*;



// Class to evaluate the function z = a + x^2 + 3y^4
// where a is fixed and the values of x and y
// (x[0] and x[1] in this method) are the
// current values in the minimisation method.
class MinimFunct implements MinimisationFunction{

    private double a = 0.0D;

    // evaluation function
    public double function(double[] x){
        double z = a + x[0]*x[0] +  3.0D*Math.pow(x[1], 4);
        return z;
    }

    // Method to set a
    public void setA(double a){
        this.a = a;
    }
}

class NegGaussPdf implements MinimisationFunction{

    private double sigma = 1.0;
    private double mu = 0.0;
    
    public void setA(double mu){
        this.mu = mu;
    }
	public void setSigma(double sigma){
		this.sigma=sigma;
	}

    // evaluation function
    public double function(double[] x){
    	return - Math.exp(-0.5*Math.pow((x[0]-mu)/sigma,2))/Math.sqrt(2*Math.PI)/sigma;
    }

}

// Class to demonstrate minimisation method, Minimisation nelderMead
public class TestMinimization {

    public static void main(String[] args){

        //Create instance of Minimisation
        Minimisation min = new Minimisation();
        
        NegGaussPdf f = new NegGaussPdf();
        
        double[] start = {-5.0};

        // initial step sizes
        double[] step = {0.2D};

        // convergence tolerance
        double ftol = 1e-15;

        // Nelder and Mead minimisation procedure
        min.nelderMead(f, start, step, ftol);

        // get the minimum value
        double minimum = min.getMinimum();

        // get values of y and z at minimum
         double[] param = min.getParamValues();

         // Output the results to screen
         System.out.println("Minimum = " + minimum);
         System.out.println("Value of x at the minimum = " + param[0]);

    }
}