package semplest.bidding.test;

import flanagan.plot.*;

public class TestPlotFunction {
	
	
	public static double GaussPdf(double x, double mu, double sigma){
		return Math.exp(-0.5*Math.pow((x-mu)/sigma,2))/Math.sqrt(2*Math.PI)/sigma;
	}
	
	public static double WeiBull(double x, double lambda, double theta){
		return 1-Math.exp(-Math.pow((x/lambda),theta));
	}
	// main method
	public static void main(String[] argv){

    	int nPoints = 201;   // number of points per curve


    	double[][] data = null;	// data points

    	String title ="Testing Plot";      // plot title
    	String xLeg="x";        // x axis legend
    	String xUnits="arb";      // x axis units
    	String yLeg="y";        // y axis legend
    	String yUnits="arb";      // y axis units

        // Create a 2-dimensional array of doubles, for storing the data, using the PltGraph initialiszation method
    	data = PlotGraph.data(1,nPoints);

    	double [] x = new double[nPoints];
    	double [] y = new double[nPoints];
    	
    	for(int i=0; i<nPoints; i++){
//    		x[i]=-10+((double)i)*0.1;
//    		y[i]=GaussPdf(x[i],0.0,1.0);
    		x[i]=((double)i)*0.001;
    		y[i]=WeiBull(x[i],0.1,0.2);
    	}

    	for (int i=0; i<nPoints; i++){
    		data[0][i]=x[i];
    		data[1][i]=y[i];
    	}
    	
 

    	// Create an instance of PlotGraph
    	PlotGraph pg = new PlotGraph(data);

    	pg.setGraphTitle(title);            // Enter graph title
    	pg.setXaxisLegend(xLeg);            // Enter x-axis legend
    	pg.setXaxisUnitsName(xUnits);       // Enter x-axis units
    	pg.setYaxisLegend(yLeg);            // Enter y-axis legend
    	pg.setYaxisUnitsName(yUnits);       // Enter y-axis units
    	int[] pointOptions = {1}; //, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
    	pg.setPoint(pointOptions);
    	pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

    	// Call plotting method
    	pg.plot();

    	// End program
    	// Replying yes to the end program request in the dialog box displayed on calling this method will close the graph window
    	// Responding no will leave the graph window open - the program may then be ended and the graph window closed by
    	// either clicking on the graph window close icon or typing the appropriate Control Keys, e.g. Control C.
//    	fin.endProgram();
	}
}
