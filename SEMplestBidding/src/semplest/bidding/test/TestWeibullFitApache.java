package semplest.bidding.test;


import java.util.Random;

import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.optimization.fitting.CurveFitter;
import org.apache.commons.math3.optimization.general.LevenbergMarquardtOptimizer;

import flanagan.plot.PlotGraph;

import semplest.bidding.estimation.Weibull;


public class TestWeibullFitApache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double [] x = new double[5];
		double [] y = new double[x.length];
		
		double [][] data =  PlotGraph.data(2,x.length);

		Random r = new Random();
		ParametricUnivariateFunction f = new Weibull();
		double [] params = {2, 1, 1};
		
		try {
			for (int i=0; i< x.length; i++){
				x[i]=r.nextDouble();
				y[i]=f.value(x[i], params);
				data[0][i]=x[i];
				data[1][i]=y[i];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CurveFitter fitter = new CurveFitter(new LevenbergMarquardtOptimizer());
		for (int i=0; i<x.length; i++){
			fitter.addObservedPoint(x[i],y[i]);
		}
		
		double [] initialGuess = {0.5, 0.5, 0.5};

		double [] EstParams = fitter.fit(f, initialGuess);
		
		
		for (int i=0; i< x.length; i++){
			y[i]=f.value(x[i], params);
			data[2][i]=x[i];
			data[3][i]=y[i];
		}
		
        
//        System.out.println("The minimum value is "+minimum);
        System.out.print("The minimum occurs at ");
        for(int i=0; i<EstParams.length; i++){
        	System.out.print(EstParams[i]+" ");
        }
        System.out.print("\nThe true parameter values were ");
        for(int i=0; i<params.length; i++){
        	System.out.print(params[i]+" ");
        }
        
        
    	// Create an instance of PlotGraph
    	PlotGraph pg = new PlotGraph(data);

//    	pg.setGraphTitle(title);            // Enter graph title
//    	pg.setXaxisLegend(xLeg);            // Enter x-axis legend
//    	pg.setXaxisUnitsName(xUnits);       // Enter x-axis units
//    	pg.setYaxisLegend(yLeg);            // Enter y-axis legend
//    	pg.setYaxisUnitsName(yUnits);       // Enter y-axis units
    	int[] pointOptions = {1, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
    	pg.setPoint(pointOptions);
    	pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

    	// Call plotting method
    	pg.plot();
	}

}
