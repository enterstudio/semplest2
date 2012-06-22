package semplest.bidding.optimization;

import org.apache.commons.math3.util.MathArrays;

import semplest.bidding.estimation.GammaCurve;
import flanagan.math.ArrayMaths;

public class ClickVolumeFittingProblem extends OptimizationProblem {

  double[] clicks;
  double[] bids;
  double penaltyWeight = 1.0;
  int maxIter = 100;
  double lbfgsConvergenceTol = 1e-6;
  double damping = 0.9;
  double barrierBuffer = 1e-6;
  double convergenceTol = 1e-6;
  double minBid = 0.01;

  /**
   * Default constructor, just takes arrays of clicks and bids
   * @param clicks
   * @param bids
   */
  public ClickVolumeFittingProblem(double[] clicks, double[] bids) {
    this.clicks = clicks;
    this.bids = bids;
  }

  @Override
  public double computeObjective(double[] x) {
    GammaCurve g = new GammaCurve();
    double value = 0;
    for (int i = 0; i < bids.length; i++) {
      double pred = g.function(new double[] {bids[i]}, x);
      // add the squared error between the curve's value and the observed value
      // to the objective
      value += Math.pow(pred - clicks[i], 2);
    }

    // add penalty for shape being close to 1
    double penalty = 0;
    double shape = x[0];
    if (shape >= (1.0 + barrierBuffer)) {
      penalty = Math.log(shape - 1);
    } else {
      penalty = Math.log(barrierBuffer) - (barrierBuffer + 1.0 - shape)
          / barrierBuffer;
    }

    // add penalty for shift being too small
    double shift = x[3];
    double shiftPenalty = 0;
    if (shift >= (minBid + barrierBuffer)) {
      shiftPenalty = Math.log(shift - minBid);
    } else {
      shiftPenalty = Math.log(barrierBuffer) - (barrierBuffer + minBid - shift)
          / barrierBuffer;
    }
    penalty += shiftPenalty;

    return value - penaltyWeight * penalty;
  }

  /**
   * Find initial solution
   * @return Feasible solution vector
   */
  @Override
  public double[] findInitialSolution() {
    double maxClicks = new ArrayMaths(clicks).maximum();
    return new double[] {1.25, 1, maxClicks, minBid + 0.0001};
  }

  /**
   * Solve the (constrained) problem through a series of unconstrained penalized
   * problems.
   * @return Optimal solution
   */
  public double[] solve() {
    // find an initial solution
    double[] currentPoint = findInitialSolution();
    // iterate until convergence is reached
    for (int iter = 0; iter < this.maxIter; iter++) {
      // create a copy of the current point (used to check convergence later)
      double[] oldPoint = currentPoint.clone();

      // decrease the penalty parameter and solve
      penaltyWeight = penaltyWeight * Math.pow(damping, iter);
      barrierBuffer = barrierBuffer * Math.pow(damping, iter);
      LBFGSSolver solver = new LBFGSSolver(this, currentPoint);
      solver.setConvergeTol(lbfgsConvergenceTol);
      solver.iprint = new int[] {-1, 0};
      currentPoint = solver.solve();

      // check for convergence
      double infNorm = MathArrays.distanceInf(oldPoint, currentPoint);
      if (infNorm < convergenceTol) {
        //System.out.println("Convergence condition met, exiting.");
        break;
      }
    }

    return currentPoint;
  }

  /**
   * Set the penalty weight
   * @param w Weight applied to penalty term
   */
  public void setPenaltyWeight(double w) {
    penaltyWeight = w;
  }

  /**
   * Set convergence tolerance
   * @param t Desired tolerance. Optimization stops in Inf-norm between
   *        subsequent points does not exceed thsi value
   */
  public void setConvergenceTol(double t) {
    convergenceTol = t;
  }

  /**
   * Set the barrier buffer
   * @param b Size of buffer. Should be pretty small.
   */
  public void setBarrierBuffer(double b) {
    barrierBuffer = b;
  }

  /**
   * Set the damping factor which decreases the penalty weight and barrier
   * buffer
   * @param d Damping factor
   */
  public void setDamping(double d) {
    damping = d;
  }
}
