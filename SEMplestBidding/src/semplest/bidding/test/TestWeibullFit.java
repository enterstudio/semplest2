package semplest.bidding.test;

import java.util.Random;

import org.apache.log4j.Logger;

import semplest.bidding.estimation.*;

public class TestWeibullFit {

	private static final Logger logger = Logger.getLogger(TestWeibullFit.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [][] x = new double[5][1];
		double [] y = new double[x.length];

		Random r = new Random();
		ParametricFunction f = new WeibullCurve();
		double [] params = {2, 1, 1};
		
		try {
			for (int i=0; i< x.length; i++){
				x[i][0]=r.nextDouble();
				y[i]=f.function(x[i], params);
			}
		} catch (Exception e) {
			logger.error("Problem", e);
		}
		
		ParameterEstimator pe = new ParameterEstimator(f, x, y);
		double [] startPoint = {0.5, 0.5, 0.5};
		pe.setStartPoint(startPoint);
		double [] stepSize = {0.01D, 0.01D, 0.01D};
		pe.setStepSize(stepSize);
		pe.estimateParams();
		
        // get the minimum value
        double minimum = pe.getMinimum();

        // get values of y and z at minimum
        double[] EstParams = pe.getParamValues();
        
        System.out.println("The minimum value is "+minimum);
        System.out.print("The minimum occurs at ");
        for(int i=0; i<EstParams.length; i++){
        	System.out.print(EstParams[i]+" ");
        }
        System.out.print("\nThe true parameter values were ");
        for(int i=0; i<params.length; i++){
        	System.out.print(params[i]+" ");
        }
	}

}
