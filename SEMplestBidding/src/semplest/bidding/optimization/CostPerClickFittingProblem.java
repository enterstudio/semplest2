package semplest.bidding.optimization;

import org.apache.commons.math3.util.MathArrays;

import semplest.bidding.estimation.GammaCurve;
import flanagan.math.ArrayMaths;

public class CostPerClickFittingProblem extends OptimizationProblem {

  // TODO: getters/setters
  double[] cpc;
  double[] bids;
  double penaltyWeight = 1.0;
  int maxIter = 100;
  double lbfgsConvergenceTol = 1e-6;
  double damping = 0.9;
  double barrierBuffer = 1e-6;
  double convergenceTol = 1e-6;

  public CostPerClickFittingProblem(double[] cpc, double[] bids) {
    this.cpc = cpc;
    this.bids = bids;
  }

  /**
   * Compute the objective value (Sum of squared errors plus penalty)
   * @return penalized objective value
   */
  @Override
  public double computeObjective(double[] x) {

    GammaCurve g = new GammaCurve();
    double value = 0;
    for (int i = 0; i < bids.length; i++) {
      double pred = g.function(new double[] {bids[i]}, x);
      // add the squared error between the curve's value and the observed value
      // to the objective
      value += Math.pow(pred - cpc[i], 2);
    }

    // now need to calculate the penalty on the shape parameter
    double penalty = 0;
    double shape = x[0]; // shape parameter, needs to be in (0, 1)
    // first, penalty for shape being close to 1
    if (shape > (1.0 - barrierBuffer)) {
      // shape is close to barrier, use linearized penalty
      penalty = Math.log(barrierBuffer) - (shape - 1.0 + barrierBuffer)
          / barrierBuffer;
    } else {
      // shape is not too close, use regular log penalty
      penalty = (Math.log(1 - shape));
    }

    // now penalty for shape being close to 0
    double extraPenalty = 0;
    if (shape >= barrierBuffer) {
      extraPenalty = Math.log(shape);
    } else {
      extraPenalty = Math.log(barrierBuffer) - (barrierBuffer - shape)
          / barrierBuffer;
    }
    penalty += extraPenalty;
    value -= penaltyWeight * penalty;

    return value;
  }

  /**
   * Find initial solution
   * @return Feasible solution vector
   */
  @Override
  public double[] findInitialSolution() {
    double maxCpc = new ArrayMaths(cpc).maximum();
    return new double[] {0.75, 1, maxCpc};
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
   *        subsequent points does not exceed this value
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
