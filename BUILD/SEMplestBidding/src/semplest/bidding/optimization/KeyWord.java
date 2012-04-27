package semplest.bidding.optimization;



import flanagan.plot.PlotGraph;
import semplest.bidding.estimation.*;

public class KeyWord implements KeyWordInterface, java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4557533990626640318L;
	
	private String name = "";
	private double score = 1.0;
	private double [] bid = null;
	private double minBid = 0.01;
	private double bidValue = Double.MIN_VALUE;
	
	
	// model parameters
	private double [] ClickParams = null; 
	private double [] CPCParams = null; 
	private double [] DCostParams = null; 
//	private double [] DCostParams2 = null; 
//	private double [] ClickParams2 = null; 

	
	public KeyWord(String name, double score, double [] bid, double [] Clicks, double [] CPC, double [] Pos, double [] DCost, Double cutoff){
		this.name=name;
		this.score=score;
		this.bid=bid;
		
		if (cutoff==null){
			for(int i=0; i<bid.length; i++){
				if(Clicks[i]<0.0001){
					minBid = bid[i];
				} else {
					//				minBid = bid[i];
					break;
				}
			}
		} else {
			minBid = cutoff.doubleValue();
		}
		
				
		
//		CPCParams=estimateModelParams(CPC, true);
		DCostParams=estimateModelParams(DCost, true);
		ClickParams=estimateModelParams(Clicks, false);
		
		

	}
	
	@Override
	public void setBidValue(double bidValue){
		this.bidValue=bidValue;
	}	
	
	@Override
	public double getBidValue(){
		return bidValue;
	}
	
	private double [] estimateModelParams(double [] fitData, boolean plotGraphs){
		int noValidBidDataPoints = 0;
		for(int i=0; i<bid.length; i++){
			if(fitData[i]>0.0001){
				noValidBidDataPoints++;
			}
		}
		double [][] input = new double[noValidBidDataPoints][1];
		double [] output = new double[noValidBidDataPoints];

		int j=0;
		for (int i=0; i<bid.length; i++){
			if(fitData[i]>0.0001){
				input[j][0]=bid[i];
				output[j]=fitData[i];
				j++;
			}
		}
		

//		ParametricFunction f = new TruncatedSmoothSCurve(minBid);
		ParametricFunction f = new TruncatedSmoothSCurve(0.0);
		ParameterEstimator pe = new ParameterEstimator(f, input, output);
		double [] startPoint = {1.5, 1.0, 0.5};//, 0.5};
		startPoint[0]=minBid-1.0;
		startPoint[2]=output[output.length-1];
		pe.setStartPoint(startPoint);
		double [] stepSize = {0.001D, 0.001D, 0.001D};//, 0.01D};
		pe.setStepSize(stepSize);
		pe.suppressNoConvergenceMessage();
		pe.estimateParams();
		
//		 get the minimum value
//        double minimum = pe.getMinimum();

        // get values of y and z at minimum
        double [] EstParams = pe.getParamValues();
//        System.out.format("Param0: %.2f, param1: %.2f, param2: %.2f\n",EstParams[0],EstParams[1],EstParams[2]);
        
        if (!plotGraphs){
        	return EstParams;
        }
        

        
        double [][] data = PlotGraph.data(2,bid.length);
        double [] in = new double[1];
      
        for(int i=0; i<bid.length; i++){
    		data[0][i]=bid[i];
    		data[1][i]=fitData[i];
    		data[2][i]=bid[i];
    		in[0]=bid[i];
    		data[3][i]=f.function(in, EstParams);
//    		data[3][i]=fitData[i];

    	}
        
    	PlotGraph pg = new PlotGraph(data);

    	pg.setGraphTitle(name);            // Enter graph title
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
		return DCostParams;
	}	
	
	@Override
	public double getQualityScore() {
		return score;
	}

	@Override
	public double getMinBid() {
		return minBid;
	}

}
