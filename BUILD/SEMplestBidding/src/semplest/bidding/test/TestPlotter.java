package semplest.bidding.test;


/*
*   Class Plotter
*
*   A free standing plotting application that takes data from
*   an input file and plots a graph in a window
*
*   WRITTEN BY: Dr Michael Thomas Flanagan
*
*   DATE:    July 2002
*   UPDATE:  22 June 2003 and 14 August 2004, November 2009
*
*   DOCUMENTATION:
*   See Michael Thomas Flanagan's Java library on-line web page:
*   Plotter.html
*
*   Copyright (c) 2002 - 2009
*
*   PERMISSION TO COPY:
*   Permission to use, copy and modify this software and its documentation for
*   NON-COMMERCIAL purposes is granted, without fee, provided that an acknowledgement
*   to the author, Michael Thomas Flanagan at www.ee.ucl.ac.uk/~mflanaga, appears in all copies.
*
*   Dr Michael Thomas Flanagan makes no representations about the suitability
*   or fitness of the software for any or for a particular purpose.
*   Michael Thomas Flanagan shall not be liable for any damages suffered
*   as a result of using, modifying or distributing this software or its derivatives.
*
***************************************************************************************/

import flanagan.io.*;
import flanagan.plot.*;


public class TestPlotter{
	
	

    	// main method
    	public static void main(String[] argv){

        	int nCurves = 0;        // number of curves
        	int[] nPoints = null;   // number of points per curve
        	int nMax = 0;           // maximum no of points on a curves
        	int ii = 0;             // counter

        	double[][] data = null;	// data points

        	String title =" ";      // plot title
        	String xLeg=" ";        // x axis legend
        	String xUnits=" ";      // x axis units
        	String yLeg=" ";        // y axis legend
        	String yUnits=" ";      // y axis units
        	String fileName=" "; 	// name of file containing input data


        	// Select data file
        	// A text file, named TestPlotter.txt, was been prepared for this example
        	//  and stored in a directory C:\Java6\TestData"
        	// Replace data file name and directory path by your own relevant ones
        	FileChooser fin = new FileChooser("/semplest/subhojit/test/");
        	fileName = fin.selectFile("Choose Data File for Plotting");

            // Read in graph title
        	title = fin.readLine();

        	// Read in the x-axis legend
        	xLeg = fin.readLine();

        	// Read in the x-axis units
        	xUnits = fin.readLine();

        	// Read in the y-axis legend
        	yLeg = fin.readLine();

        	// Read in the y-axis units
        	yUnits = fin.readLine();

            // Read in the number of curves
        	nCurves = fin.readInt();

        	// Read in the number of points on the curve with the largest number of points
        	nMax = fin.readInt();

            // Create a 2-dimensional array of doubles, for storing the data, using the PltGraph initialiszation method
        	data = PlotGraph.data(nCurves,nMax);

        	// Read in the data
        	nPoints = new int[nCurves];
        	ii=0;
        	for(int i=0; i<nCurves; i++){
            		nPoints[i]=fin.readInt();
            		for(int j=0; j<nPoints[i]; j++){
                		data[ii][j]=fin.readDouble();       // x-axis data
                		data[ii+1][j]=fin.readDouble();     // y-axis data
            		}
            		ii+=2;
        	}

        	// Create an instance of PlotGraph
        	PlotGraph pg = new PlotGraph(data);

        	pg.setGraphTitle(title);            // Enter graph title
        	pg.setXaxisLegend(xLeg);            // Enter x-axis legend
        	pg.setXaxisUnitsName(xUnits);       // Enter x-axis units
        	pg.setYaxisLegend(yLeg);            // Enter y-axis legend
        	pg.setYaxisUnitsName(yUnits);       // Enter y-axis units
        	int[] pointOptions = {1, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
        	pg.setPoint(pointOptions);
        	pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

        	// Call plotting method
        	pg.plot();

        	// End program
        	// Replying yes to the end program request in the dialog box displayed on calling this method will close the graph window
        	// Responding no will leave the graph window open - the program may then be ended and the graph window closed by
        	// either clicking on the graph window close icon or typing the appropriate Control Keys, e.g. Control C.
//        	fin.endProgram();
    	}
}


