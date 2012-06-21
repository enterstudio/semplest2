package semplest.bidding.optimization;

import java.util.ArrayList;

import org.apache.commons.math3.util.MathArrays;

/**
 * Class used for computing optimal bids for an ad campaign.
 * @author amichalka
 * 
 */
public class BiddingProblem extends OptimizationProblem {

  /**
   * An ArrayLilst of the keywords and their associated data for this campaign
   */
  private ArrayList<KeyWordInterface> keywords;
  /**
   * Daily budget. Total cost should be below this value
   */
  private double dailyBudget = 0.0;
  /**
   * Starting constraint penalty weight, will be stepped down during
   * optimization
   */
  private double penaltyWeight = 1;
  /**
   * maximum number of iterations allowed in optimization. In practice it is
   * doubtful that this will be met.
   */
  private int maxIter = 100;
  /**
   * In optimization, will stop if Inf-norm of difference between subsequent
   * solutions is smaller than this value
   */
  private double convergenceTol = 1e-4;
  /**
   * Optimization will terminate if percentage improvement between subsequent
   * iterations is less than this value.
   */
  private double minImprovement = 0.01;
  /**
   * Tolerance for the linearized log-barrier, to avoid infinite values. Will be
   * stepped down during optimization.
   */
  private double barrierBuffer = 1e-4;
  /**
   * Factor by which to decrease <code>constraintPenalty</code> and
   * <code>barrierTol</code> in each iteraion of optimization.
   */
  private double damping = 0.5;

  /**
   * Default constructor
   * @param keywords Keywords and the data to use in computing optimal bids
   * @param dailyBudget Total daily budget
   */
  public BiddingProblem(ArrayList<KeyWordInterface> keywords, double dailyBudget) {
    this.keywords = keywords;
    this.dailyBudget = dailyBudget;
  }

  /**
   * Compute the objective value for this problem for a given vector of bids
   * @param x Point where gradient is to be computed.
   * @return Objective value (total quality with log penalty on cost)
   */
  @Override
  public double computeObjective(double[] bids) {
    double totalQuality = 0;
    double totalCost = 0;
    for (int i = 0; i < bids.length; i++) {
      KeyWordInterface kw = keywords.get(i);
      // score for this keyword is its quality score multiplied by expected
      // number of clicks at this bid value
      double bid = bids[i];
      double kwClicks = kw.getClicksAtBid(bid);
      double kwQual = kw.getQualityScore() * kwClicks;
      totalQuality += kwQual;
      double kwCpc = kw.getCpcAtBid(bid);
      totalCost += (kwCpc * kwClicks);
    }

    // compute the penalty
    double penalty = 0;
    if (totalCost > (dailyBudget - barrierBuffer)) {
      // cost is close to the budget, use the linearized value
      penalty = Math.log(barrierBuffer)
          - (totalCost - dailyBudget + barrierBuffer) / barrierBuffer;
    } else {
      // cost is not too large, use regular log penalty
      penalty = Math.log(dailyBudget - totalCost);
    }
    return totalQuality + penaltyWeight * penalty;
  }

  /**
   * Compute the total expected number of clicks for a given bid vector
   * @param bids Vector of bids
   * @return Total number of expected clicks
   */
  public double computeTotalClicks(double[] bids) {
    double totalQuality = 0;
    for (int i = 0; i < bids.length; i++) {
      KeyWordInterface kw = keywords.get(i);
      // score for this keyword is its quality score multiplied by expected
      // number of clicks at this bid value
      double[] bid = new double[] {bids[i]};
      double kwClicks = kw.getClicksAtBid(bid[0]);
      double kwQual = kw.getQualityScore() * kwClicks;
      totalQuality += kwQual;
    }

    return totalQuality;
  }

  /**
   * Compute the total expected daily cost given vector of bids
   * @param bids Point where cost is to be computed.
   * @return Expected total daily cost
   */
  public double computeTotalCost(double[] bids) {

    double totalCost = 0;
    for (int i = 0; i < bids.length; i++) {
      KeyWordInterface kw = keywords.get(i);
      // score for this keyword is its quality score multiplied by expected
      // number of clicks at this bid value
      double bid = bids[i];
      double kwClicks = kw.getClicksAtBid(bid);
      double kwCpc = kw.getCpcAtBid(bid);
      totalCost += (kwCpc * kwClicks);
    }

    return totalCost;
  }

  /**
   * Compute the gradient at a given bid vector
   * @param bids Point where gradient is to be computed.
   * @return Gradient vector
   */
  @Override
  public double[] computeGradient(double[] bids) {

    // initialize an array to hold the gradient and a Gamma curve to compute
    // clicks and CPC
    double[] grad = new double[bids.length];

    // compute total cost for the given bid vector
    double totalCost = computeTotalCost(bids);

    // gradient of the penalized objective function is the gradient of the
    // total clicks function minus a scaled gradient of the total cost
    // function. the scaling only depends on whether or not the total cost is 
    // beyond the break point of the piecewise penalty function.
    // default is case where cost is below break point
    double costDerivScalar = penaltyWeight / (dailyBudget - totalCost);
    if (totalCost > (dailyBudget - barrierBuffer)) {
      // this is the case where cost is above the break point
      costDerivScalar = penaltyWeight / barrierBuffer;
    }

    // compute the gradient
    for (int i = 0; i < bids.length; i++) {
      double bid = bids[i];
      KeyWordInterface kw = keywords.get(i);

      // compute the ith element of the gradient of total cost
      double clickDeriv = kw.getClickDerivAtBid(bid);
      double clickVal = kw.getClicksAtBid(bid);
      double cpcDeriv = kw.getCpcDerivAtBid(bid);
      double cpcVal = kw.getCpcAtBid(bid);
      double costDeriv = clickDeriv * cpcVal + clickVal * cpcDeriv;

      // now compute the ith element of the gradient of the penalized objective
      grad[i] = clickDeriv - costDerivScalar * costDeriv;
    }

    return grad;
  }

  /**
   * Find a starting point for this problem
   * @return Initial vector of bids
   */
  @Override
  public double[] findInitialSolution() {
    double[] bids = new double[keywords.size()];
    for (int i = 0; i < bids.length; i++) {
      // set the initial bid for this keyword to be just above its shift
      // parameter
      double[] clickPar = keywords.get(i).getClickInfo();
      double shift = clickPar[3];
      bids[i] = shift + 0.001;
    }

    return bids;
  }

  /**
   * Solve the (constrained) problem through a series of unconstrained penalized
   * problems.
   * @return Optimal solution
   */
  public double[] solveProblem() {
    // find an initial solution
    double[] currentPoint = findInitialSolution();
    double totalClicks = computeTotalClicks(currentPoint);
    // 
    for (int iter = 0; iter < maxIter; iter++) {
      // create a copy of the current point (used to check convergence later)
      double[] oldPoint = currentPoint.clone();
      double oldClicks = totalClicks;

      // decrease the penalty parameter and solve
      penaltyWeight = penaltyWeight * Math.pow(damping, iter);
      barrierBuffer = barrierBuffer * Math.pow(damping, iter);
      System.out.println("Optimizing with epsilon = " + penaltyWeight);
      System.out.println("Barrier tolerance = " + barrierBuffer);
      LBFGSSolver solver = new LBFGSSolver(this, currentPoint, -1.0);
      currentPoint = solver.solve();
      totalClicks = computeTotalClicks(currentPoint);

      // check for convergence
      double infNorm = MathArrays.distanceInf(oldPoint, currentPoint);
      if (infNorm < convergenceTol) {
        System.out.println("Stopping condition met, exiting.");
        break;
      }

      // check the percentage improvement made, and exit if too small
      double improvement = (totalClicks - oldClicks) / oldClicks * 100;
      if (improvement < minImprovement) {
        System.out.println("Failed to make significant improvement, exiting.");
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
   * Set the minimum percentage improvement in clicks to continue optimizing
   * @param p Desired minimum percentage improvement
   */
  public void setMinImprovement(double p) {
    minImprovement = p;
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
