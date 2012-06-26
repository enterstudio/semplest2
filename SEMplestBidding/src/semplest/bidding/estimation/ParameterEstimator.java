package semplest.bidding.estimation;

import org.apache.log4j.Logger;

import flanagan.math.Minimisation;
import flanagan.math.MinimisationFunction;

class LeastSquares implements MinimisationFunction {
	
	private static final Logger logger = Logger.getLogger(LeastSquares.class);

  private ParametricFunction pf = null;

  private double[][] input = null;
  private double[] output = null;

  public LeastSquares(ParametricFunction pf, double[][] input, double[] output) {
    this.pf = pf;
    this.input = input;
    this.output = output;
  }

  @Override
  public double function(double[] param) {
    double sum = 0;
    try {
      for (int i = 0; i < input.length; i++) {
        double fVal = pf.function(input[i], param);
        sum += Math.pow(fVal - output[i], 2);
        if (Double.isNaN(sum)) {
          System.out.println(sum + ": x=" + input[0][0] + " " + param[0] + " "
              + param[1] + " " + param[2] + " " + param[3]);
          break;
        }
      }
    } catch (Exception e) {
    	logger.error(e.getMessage(), e);
    }
    return sum;
  }
}

public class ParameterEstimator {

  private LeastSquares lsq;
  private Minimisation min = new Minimisation();

  private double[] startPoint = null;
  private double[] stepSize = null;
  double fTol = 1e-15;
  int maxIter = 10000;

  public ParameterEstimator(ParametricFunction pf, double[][] input,
      double[] output) {
    lsq = new LeastSquares(pf, input, output);
  }

  public void estimateParams() {
    // Nelder and Mead minimisation procedure
    min.nelderMead(lsq, startPoint, stepSize, fTol, maxIter);
  }

  public void suppressNoConvergenceMessage() {
    min.suppressNoConvergenceMessage();
  }

  public void setStartPoint(double[] startPoint) {
    this.startPoint = startPoint;
  }

  public void setStepSize(double[] stepSize) {
    this.stepSize = stepSize;
  }

  public boolean getConvergenceStatus() {
    return min.getConvStatus();
  }

  public double getMinimum() {
    return min.getMinimum();
  }

  public double[] getParamValues() {
    return min.getParamValues();
  }

  // add a constraint to the minimizer
  public void addConstraint(int paramIndex, int conDir, double constraint) {
    min.addConstraint(paramIndex, conDir, constraint);
  }
}
