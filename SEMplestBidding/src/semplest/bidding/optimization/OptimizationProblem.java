package semplest.bidding.optimization;

public abstract class OptimizationProblem {

  // step size for finite-difference gradient approximation 
  public static double fdStep = 1e-10;

  /**
   * Compute the objective value
   * @param x Point where objective function is to be evaluated.
   * @return
   */
  public abstract double computeObjective(double[] x);

  /**
   * Default method to compute the gradient of the objective function at the
   * point x. Uses a centered finite-difference approximation.
   * @param x Point where gradient is to be computed.
   * @return
   */
  public double[] computeGradient(double[] x) {

    // initialize the gradient
    double[] grad = new double[x.length];
    for (int i = 0; i < x.length; i++) {
      // increase/decrease value of x[i]
      double[] xPlus = x.clone();
      double[] xMinus = x.clone();
      xPlus[i] = x[i] + fdStep / 2;
      xMinus[i] = x[i] - fdStep / 2;

      // calculate function values at the new points and then compute the
      // approximate gradient value
      double fPlus = this.computeObjective(xPlus);
      double fMinus = this.computeObjective(xMinus);
      grad[i] = (fPlus - fMinus) / fdStep;
    }

    return grad;
  };

  /**
   * Find an initial feasible solution to this problem
   * @return Feasible solution vector
   */
  public abstract double[] findInitialSolution();

}
