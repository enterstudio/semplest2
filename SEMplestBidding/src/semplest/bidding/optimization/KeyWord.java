package semplest.bidding.optimization;

import semplest.bidding.estimation.GammaCurve;
import semplest.bidding.estimation.ParameterEstimator;
import semplest.bidding.estimation.ParametricFunction;
import semplest.bidding.estimation.TruncatedSmoothSCurve;
import flanagan.math.ArrayMaths;
import flanagan.plot.PlotGraph;

public class KeyWord implements KeyWordInterface, java.io.Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -4557533990626640318L;

  private String name = null;
  private double score = 1.0;
  private double[] bid = null;
  private double minBid = 0.01;
  private double bidValue = Double.MIN_VALUE;
  private double numTol = 1e-15;

  // model parameters
  private double[] ClickParams = null;
  private double[] CPCParams = null;
  private double[] DCostParams = null;
  // parametric curve to calculate click and cpc values for given bids
  private ParametricFunction curveForm = new GammaCurve();

  // private double [] DCostParams2 = null;
  // private double [] ClickParams2 = null;

  public KeyWord(String name, double score, double[] bid, double[] Clicks,
      double[] CPC, double[] Pos, double[] DCost, Double cutoff, Double clickFactor) {
    this.name = name;
    this.score = score;
    this.bid = bid;

    if (cutoff != null) {
      minBid = cutoff.doubleValue();
    }

    //CPCParams=estimateModelParams(CPC, false);
    //DCostParams=estimateModelParams(DCost, false);
    //ClickParams=estimateModelParams(Clicks, false);
    // int nBids = bid.length;
    // System.out.println("Got " + nBids + "Bids: ");
    // for (int j = 0; j < nBids; j++) {
    // System.out.println("Bid: " + bid[j] + ", cost: " + DCost[j] + ", clicks:
    // " + Clicks[j]);
    // }
    
    
    CPCParams = estimateCpcParams(CPC);
    ClickParams = estimateClicksParams(Clicks,score,clickFactor);
    DCostParams = estimateDCostParams();
    
    //plotOptimizationFunction(1.0);

  }

  @Override
  public void setBidValue(double bidValue) {
    this.bidValue = bidValue;
  }

  @Override
  public double getBidValue() {
    return bidValue;
  }

  /*
  private double[] estimateModelParams(double[] fitData, boolean plotGraphs) {
    int noValidBidDataPoints = 0;
    for (int i = 0; i < bid.length; i++) {
      if (fitData[i] > 0.0001) {
        noValidBidDataPoints++;
      }
    }
    double[][] input = new double[noValidBidDataPoints][1];
    double[] output = new double[noValidBidDataPoints];

    int j = 0;
    for (int i = 0; i < bid.length; i++) {
      if (fitData[i] > 0.0001) {
        input[j][0] = bid[i];
        output[j] = fitData[i];
        j++;
      }
    }

    // ParametricFunction f = new TruncatedSmoothSCurve(minBid);
    ParametricFunction f = new TruncatedSmoothSCurve(0.0);
    ParameterEstimator pe = new ParameterEstimator(f, input, output);
    double[] startPoint = {1.5, 1.0, 0.5};// , 0.5};
    startPoint[0] = minBid - 1.0;
    startPoint[2] = output[output.length - 1];
    pe.setStartPoint(startPoint);
    double[] stepSize = {0.001D, 0.001D, 0.001D};// , 0.01D};
    pe.setStepSize(stepSize);
    pe.suppressNoConvergenceMessage();
    pe.estimateParams();

    // get the minimum value
    // double minimum = pe.getMinimum();

    // get values of y and z at minimum
    double[] EstParams = pe.getParamValues();
    System.out.format("Param0: %.2f, param1: %.2f, param2: %.2f\n",
        EstParams[0], EstParams[1], EstParams[2]);

    if (!plotGraphs) {
      return EstParams;
    }

    double[][] data = PlotGraph.data(2, bid.length);
    double[] in = new double[1];

    for (int i = 0; i < bid.length; i++) {
      data[0][i] = bid[i];
      data[1][i] = fitData[i];
      data[2][i] = bid[i];
      in[0] = bid[i];
      data[3][i] = f.function(in, EstParams);
      // data[3][i]=fitData[i];

    }

    PlotGraph pg = new PlotGraph(data);

    pg.setGraphTitle(name); // Enter graph title
    // pg.setXaxisLegend(xLeg); // Enter x-axis legend
    // pg.setXaxisUnitsName(xUnits); // Enter x-axis units
    // pg.setYaxisLegend(yLeg); // Enter y-axis legend
    // pg.setYaxisUnitsName(yUnits); // Enter y-axis units
    int[] pointOptions = {1, 4}; // , 4}; // Set point option to open circles
    // on the first graph line and filled
    // circles on the second graph line
    pg.setPoint(pointOptions);
    pg.setLine(1); // Set line option to a continuous lines and a 200 point
    // cubic spline interpolation

    // Call plotting method
    pg.plot();

    return EstParams;

  }
  */

  /**
   * Estimate the parameters for the bid -> clicks curve This uses a scaled and
   * shifted gamma cdf with some extra constraints
   * 
   * @param clickVals: double[] of click values corresponding to bids
   * @return
   */
  private double[] estimateClicksParams(double[] clickVals, double score, double clickFactor) {

    // put the input/output data in the right formats for fitting
    double[][] input = new double[bid.length][1];
    double[] output = new double[bid.length];
    for (int i = 0; i < bid.length; i++) {
      input[i][0] = bid[i]*10.0/score;
      output[i] = clickVals[i]/clickFactor;
    }

    /*
     * fit using a scaled and shifted gamma cdf parameters are {shape, rate,
     * amplitude, shift} shape, rate and amplitude must be non-negative in this
     * case we enforce two extra constraints: 1. shift >= minBid (curve stays at
     * 0 until at least minBid) 2. shape >= 1 (this makes sure the curve has an
     * 'S' shape and is differentiable everywhere)
     */
    ParametricFunction f = new GammaCurve();
    ParameterEstimator pe = new ParameterEstimator(f, input, output);
    pe.addConstraint(0, -1, 1 + numTol); // shape >= 1
    pe.addConstraint(1, -1, numTol); // rate >= 0
    pe.addConstraint(2, -1, numTol); // amplitude >= 0
    pe.addConstraint(3, -1, minBid + numTol); // shift >= minBid

    // set the start point and step sizes, then do the fitting
    double maxClicks = new ArrayMaths(clickVals).maximum();
    double[] startPoint = {1.1, 1.0, maxClicks, minBid + 0.1};
    pe.setStartPoint(startPoint);
    double[] stepSize = {0.001, 0.001, 0.001, 0.001};
    pe.setStepSize(stepSize);
    // pe.suppressNoConvergenceMessage();
    pe.estimateParams();
    boolean converge = pe.getConvergenceStatus();
//    if (!converge) {
//    	System.out.println("NO CONVERGENCE");
//      return null;
//    }

    // get the optimal values
    double[] optPar = pe.getParamValues();
    System.out.println("Clicks parameters for " + name);
    String msg = "shape: %.4f, rate: %.4f, amplitude: %.4f, shift: %.4f\n";
    System.out.format(msg, optPar[0], optPar[1], optPar[2], optPar[3]);
    
    
    /*
    
    double [][] data = PlotGraph.data(2,bid.length);
    double [] in = new double[1];
  
    for(int i=0; i<bid.length; i++){
		data[0][i]=input[i][0];
		data[1][i]=output[i];
		data[2][i]=input[i][0];
		in[0]=input[i][0];
		data[3][i]=f.function(in, optPar);

	}
    
	PlotGraph pg = new PlotGraph(data);

	pg.setGraphTitle(name);            // Enter graph title
	int[] pointOptions = {1, 4}; //, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
	pg.setPoint(pointOptions);
	pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

	// Call plotting method
	pg.plot();
	*/
    

    return optPar;
  }

  /**
   * Estimate the parameters for the bid -> clicks curve This uses a scaled
   * gamma cdf with some extra constraints
   * 
   * @param cpcVals: double[] of cpc values corresponding to bids
   * @return
   */
  private double[] estimateCpcParams(double[] cpcVals) {

    // put the input/output data in the right formats for fitting
    double[][] input = new double[bid.length][1];
    double[] output = new double[bid.length];
    for (int i = 0; i < bid.length; i++) {
      input[i][0] = bid[i];
      output[i] = cpcVals[i];
    }

    /*
     * fit using a scaled and shifted gamma cdf. 
     * parameters are {shape, rate, amplitude}. All must be non-negative,
     * and in this case we enforce one extra constraint: 
     *   1. shape <=  1 (this makes sure the curve is concave and starts
     *      increasing from 0 immediately)
     */
    ParametricFunction f = new GammaCurve();
    ParameterEstimator pe = new ParameterEstimator(f, input, output);
    pe.addConstraint(0, -1, numTol); // shape >= 0
    pe.addConstraint(0, 1, 1 - numTol); // shape <= 1
    pe.addConstraint(1, -1, numTol); // rate >= 0
    pe.addConstraint(2, -1, numTol); // amplitude >= 0

    // set the start point and step sizes, then do the fitting
    double maxCpc = new ArrayMaths(cpcVals).maximum();
    double[] startPoint = {0.5, 1.0, maxCpc};
    pe.setStartPoint(startPoint);
    double[] stepSize = {0.001, 0.001, 0.001};
    pe.setStepSize(stepSize);
    //pe.suppressNoConvergenceMessage();
    pe.estimateParams();
    boolean converge = pe.getConvergenceStatus();
//    if (!converge) {
//      // optimization didn't converge
//    	System.out.println("NO CONVERGENCE");
//      return null;
//    }

    // get the optimal values
    double[] optPar = pe.getParamValues();
    double optVal = pe.getMinimum();
    System.out.println("CPC parameters for " + name);
    String msg = "shape: %.8f, rate: %.8f, amplitude: %.4f\n";
    System.out.format(msg, optPar[0], optPar[1], optPar[2]);
    
    
    /*
    
    double [][] data = PlotGraph.data(2,bid.length);
    double [] in = new double[1];
  
    for(int i=0; i<bid.length; i++){
		data[0][i]=input[i][0];
		data[1][i]=output[i];
		data[2][i]=input[i][0];
		in[0]=input[i][0];
		data[3][i]=f.function(in, optPar);

	}
    
	PlotGraph pg = new PlotGraph(data);

	pg.setGraphTitle(name);            // Enter graph title
	int[] pointOptions = {1, 4}; //, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
	pg.setPoint(pointOptions);
	pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

	// Call plotting method
	pg.plot();
	*/
       

    return optPar;
  }
  
  
  
  private double[] estimateDCostParams() {

	    // put the input/output data in the right formats for fitting
	    ParametricFunction f0 = new GammaCurve();
	    double[][] input = new double[bid.length][1];
	    double[] output = new double[bid.length];
	    double [] f0In = new double[1];
	    for (int i = 0; i < bid.length; i++) {
	      input[i][0] = bid[i];
	      f0In[0]=bid[i];
	      output[i] = f0.function(f0In, CPCParams)*f0.function(f0In, ClickParams);
	    }

	    /*
	     * fit using a scaled and shifted gamma cdf. 
	     * parameters are {shape, rate, amplitude}. All must be non-negative,
	     * and in this case we enforce one extra constraint: 
	     *   1. shape <=  1 (this makes sure the curve is concave and starts
	     *      increasing from 0 immediately)
	     */
	    ParametricFunction f = new GammaCurve();
	    ParameterEstimator pe = new ParameterEstimator(f, input, output);
	    
	    double dCost = new ArrayMaths(output).maximum();

	    
	    pe.addConstraint(0, -1, 1 + numTol); // shape >= 1
	    pe.addConstraint(1, -1, numTol); // rate >= 0
	    pe.addConstraint(2, -1, numTol); // amplitude >= 0
	    pe.addConstraint(3, -1, minBid + numTol); // shift >= minBid
	    double[] startPoint = {1.1, 1.0, dCost, minBid + 0.1};
	    double[] stepSize = {0.001, 0.001, 0.001, 0.001};
	    
	    
//	    pe.addConstraint(0, -1, numTol); // shape >= 0
//	    pe.addConstraint(0, 1, 1 - numTol); // shape <= 1
//	    pe.addConstraint(1, -1, numTol); // rate >= 0
//	    pe.addConstraint(2, -1, numTol); // amplitude >= 0
//	    double[] startPoint = {0.5, 1.0, dCost};
//	    double[] stepSize = {0.001, 0.001, 0.001};
	    
	    pe.setStartPoint(startPoint);

	    pe.setStepSize(stepSize);
	    //pe.suppressNoConvergenceMessage();
	    pe.estimateParams();
	    boolean converge = pe.getConvergenceStatus();
//	    if (!converge) {
//	      // optimization didn't converge
//	    	System.out.println("NO CONVERGENCE");
//	      return null;
//	    }

	    // get the optimal values
	    double[] optPar = pe.getParamValues();
	    double optVal = pe.getMinimum();
	    System.out.println("CPC parameters for " + name);
	    String msg = "shape: %.8f, rate: %.8f, amplitude: %.4f\n";
	    System.out.format(msg, optPar[0], optPar[1], optPar[2]);
	    
	    
	    /*
	    
	    double [][] data = PlotGraph.data(2,bid.length);
	    double [] in = new double[1];
	  
	    for(int i=0; i<bid.length; i++){
			data[0][i]=input[i][0];
			data[1][i]=output[i];
			data[2][i]=input[i][0];
			in[0]=input[i][0];
			data[3][i]=f.function(in, optPar);

		}
	    
		PlotGraph pg = new PlotGraph(data);

		pg.setGraphTitle(name);            // Enter graph title
		int[] pointOptions = {1, 4}; //, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
		pg.setPoint(pointOptions);
		pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

		// Call plotting method
		pg.plot();
		*/
	       

	    return optPar;
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

  // return expected number of clicks for given bid
  public double getClicksAtBid(double bid) {
    return curveForm.function(new double[] {bid}, ClickParams);
  }

  // return derivative of expected number of clicks for given bid
  public double getClickDerivAtBid(double bid) {
    return curveForm.derivative(new double[] {bid}, ClickParams);
  }

  // return expected cpc for given bid
  public double getCpcAtBid(double bid) {
    return curveForm.function(new double[] {bid}, CPCParams);
  }

  // return derivative of expected cpc for given bid
  public double getCpcDerivAtBid(double bid) {
    return curveForm.derivative(new double[] {bid}, CPCParams);
  }

  // @Override
  // public double[] getPosInfo() {
  // // TODO Auto-generated method stub
  // return Pos;
  // }

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
  
  private void plotOptimizationFunction(double lambda){
	  ParametricFunction f = new GammaCurve();
	  BidLagrangeOptim Bid = new BidLagrangeOptim(this, f, lambda);
	  BidLagrangeOptim Bid2 = new BidLagrangeOptim(this, f, 2*lambda);
	  
	  double [] b = new double[200];
	  for(int i=0; i<b.length;i++){
		  b[i]=0.1+i*0.1;
	  }
	  
	  double [][] data = PlotGraph.data(2,b.length);
	  double [] in = new double[1];

	  for(int i=0; i<b.length; i++){
		  data[0][i]=b[i];
		  in[0]=data[0][i];
		  data[1][i]=Bid.function(in);
		  data[2][i]=b[i];
		  data[3][i]=Bid2.function(in);
	  }

	  PlotGraph pg = new PlotGraph(data);

	  pg.setGraphTitle(name);            // Enter graph title
	  int[] pointOptions = {1, 4};        // Set point option to open circles on the first graph line and filled circles on the second graph line
	  pg.setPoint(pointOptions);
	  pg.setLine(1);                      // Set line option to a continuous lines and a 200 point cubic spline interpolation

	  // Call plotting method
	  pg.plot();

  }

}
