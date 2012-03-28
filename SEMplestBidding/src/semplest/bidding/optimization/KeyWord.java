package semplest.bidding.optimization;

import flanagan.plot.PlotGraph;
import semplest.bidding.estimation.*;

public class KeyWord implements KeyWordInterface {
	
	private String name = "";
	private double score = 1.0;
	private double [] bid = null;
	private double [] Clicks = null;
	private double [] CPC = null;
	private double [] Pos = null;
	private double [] DCost = null;
	
	
	// model parameters
	private double [] ClickParams = null; 
	private double [] CPCParams = null; 
	private double [] DCostParams = null; 
//	private double [] ScoreParams = null;

	
	public KeyWord(String name, double score, double [] bid, double [] Clicks, double [] CPC, double [] Pos, double [] DCost){
		this.name=name;
		this.score=score;
		this.bid=bid;
		this.Clicks=Clicks;
		this.CPC=CPC;
		this.Pos=Pos;
		this.DCost=DCost;
		
		CPCParams=estimateModelParams(CPC, false);
		DCostParams=estimateModelParams(DCost, false);
		ClickParams=estimateModelParams(Clicks, false);

	}
	
	private double [] estimateModelParams(double [] fitData, boolean plotGraphs){
		int noValidBidDataPoints = 0;
		for(int i=0; i<bid.length; i++){
			if(fitData[i]>0.001){
				noValidBidDataPoints++;
			}
		}
		double [][] input = new double[noValidBidDataPoints][1];
		double [] output = new double[noValidBidDataPoints];

		int j=0;
		for (int i=0; i<bid.length; i++){
			if(fitData[i]>0.001){
				input[j][0]=bid[i];
				output[j]=fitData[i];
				j++;
			}
		}
		
		ParametricFunction f = new WeibullCurve();
		ParameterEstimator pe = new ParameterEstimator(f, input, output);
		double [] startPoint = {0.5, 1.5, 0.5, 0.0};
		startPoint[startPoint.length-1]=0.2*output[output.length-1];
		pe.setStartPoint(startPoint);
		double [] stepSize = {0.01D, 0.01D, 0.01D, 0.0};
		pe.setStepSize(stepSize);
		pe.estimateParams();
		
		// get the minimum value
        double minimum = pe.getMinimum();

        // get values of y and z at minimum
        double [] EstParams = pe.getParamValues();
        
        if (!plotGraphs){
        	return EstParams;
        }
        
        System.out.println("The minimum value is "+minimum);
        System.out.print("The minimum occurs at ");
        for(int i=0; i<EstParams.length; i++){
        	System.out.print(EstParams[i]+" ");
        }
//        System.out.println("");
        
        double [][] data = PlotGraph.data(2,bid.length);
        double [] in = new double[1];
      
        for(int i=0; i<bid.length; i++){
    		data[0][i]=bid[i];
    		data[1][i]=fitData[i];
    		data[2][i]=bid[i];
    		in[0]=bid[i];
    		data[3][i]=f.function(in, EstParams);
    	}
        
    	PlotGraph pg = new PlotGraph(data);

//    	pg.setGraphTitle(title);            // Enter graph title
//    	pg.setXaxisLegend(xLeg);            // Enter x-axis legend
//    	pg.setXaxisUnitsName(xUnits);       // Enter x-axis units
//    	pg.setYaxisLegend(yLeg);            // Enter y-axis legend
//    	pg.setYaxisUnitsName(yUnits);       // Enter y-axis units
    	int[] pointOptions = {1, 4}; //, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
    	pg.setPoint(pointOptions);
    	pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

    	// Call plotting method
    	pg.plot();
    	
    	return EstParams;
        	
	}

	@Override
	public String getKeyWord() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double[] getBidInfo() {
		// TODO Auto-generated method stub
		return bid;
	}

	@Override
	public double[] getClickInfo() {
		// TODO Auto-generated method stub
		return ClickParams;
	}

	@Override
	public double[] getCPCInfo() {
		// TODO Auto-generated method stub
		return CPCParams;
	}

//	@Override
//	public double[] getPosInfo() {
//		// TODO Auto-generated method stub
//		return Pos;
//	}

	@Override
	public double[] getDCostInfo() {
		// TODO Auto-generated method stub
		return DCostParams;
	}	
	
	@Override
	public double getQualityScore() {
		// TODO Auto-generated method stub
		return score;
	}

}
