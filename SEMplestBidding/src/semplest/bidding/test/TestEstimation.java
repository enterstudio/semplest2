package semplest.bidding.test;

import java.util.Random;

import semplest.bidding.estimation.*;

public class TestEstimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double [][] x = new double[10][1];
		double [] y = new double[x.length];

		Random r = new Random();
		ParametricFunction f = new GaussPdf();
		double [] params = {0, 1};
		
		try {
			for (int i=0; i< x.length; i++){
				x[i][0]=r.nextDouble();
				y[i]=f.function(x[i], params);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		ParameterEstimator pe = ParameterEstimator(f, x, y);
		
		
	}

}
