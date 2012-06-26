package semplest.bidding.optimization;

import org.apache.log4j.Logger;

import semplest.bidding.naive.Campaign;
import semplest.bidding.optimization.LBFGS.ExceptionWithIflag;

public class LBFGS_Test {

	private static final Logger logger = Logger.getLogger(Campaign.class);
	
  /**
   * illustrates how to use LBFGS
   * @param args
   */
  public static void main(String[] args) {
    double[] y = new double[] {4.0, 6.0}; // initial point
    double f = Math.pow((y[0] - 3), 2) + Math.pow(y[1] - 1, 4); // function value
    double[] g = new double[] {2 * (y[0] - 3), 4 * (y[1] - 1)}; // gradient
    boolean diagco = false; // code for whether user will provide diagonal of Hessian
    double[] diag = new double[2]; // diagonal of H_k, entries don't matter if diagco is false
    int[] iprint = new int[] {1, 1}; // printing parameters
    int[] iflag = new int[] {0}; // indicates that we are initiating the algorithm
    try {
      int nIter = 0;
      while (true) {
        nIter++; // actually number of function evaluations
        double[] yOld = y.clone();
        LBFGS.lbfgs(2, 5, y, f, g, diagco, diag, iprint, 1e-10, 10e-16, iflag);
        if (iflag[0] < 0) {
          System.out.println("Something went wrong in line search!");
        }
        // y has changed; we need to recalculate the function value and gradient
        // at the new point
        f = Math.pow((y[0] - 3), 2) + Math.pow(y[1] - 1, 4);
        g = new double[] {2 * (y[0] - 3), 4 * (y[1] - 1)};

        // check for convergence
        if (nIter > 100 || iflag[0] == 0) {
          System.out.println("Converged, exiting after " + nIter
              + " iterations.");
          break;
        }
      }
    } catch (ExceptionWithIflag e) {
      System.out.println("Caught an exception.");
      logger.error("Problem", e);
    }
  }
}
