package semplest.bidding.optimization;

import semplest.bidding.optimization.LBFGS.ExceptionWithIflag;
import flanagan.math.ArrayMaths;

/**
 * Solver class, solves OptimizationProblems using LBFGS algorithm
 * @author amichalka
 * 
 */
public class LBFGSSolver {

  double[] currentSol; // current solution
  boolean diagco = false; // code for whether or not diagonal will be provided
  double[] diag; // initial diagonal for Hessian
  int[] iprint = new int[] {1, 1}; // printing control
  int[] iflag; // indicator of stage of algorithm
  int n; // problem dimension
  int m; // number of Hessian updates to retain
  OptimizationProblem p; // problem to be solved
  double fnScale = 1.0; // function scaling value, negative for maximization
  // maxIter is maximum number of iterations of LBFGS to perform. it is very
  // unlikely that this will be reached, it is mostly to prevent infinite
  // cycling
  int maxIter = 5000;
  // convergeTol is tolerance for convergence, see LBFGS documentation (where
  // it is called 'eps') for detail
  double convergeTol = 1e-4;
  // estimate of machine precision
  private double precision = estimateMachinePrecision();

  /**
   * estimate machine precision (taken from wikipedia). Apparently it is
   * important to get this right in the LBFGS algorithm
   * @return Estimate of machine precision
   */
  double estimateMachinePrecision() {
    float machEps = 1.0f;

    do {
      machEps /= 2.0f;
    } while ((float) (1.0 + (machEps / 2.0)) != 1.0);

    return (double) machEps;
  }

  /**
   * 
   * @param p Problem you want to solve
   * @param initialPoint Initial feasible solution
   * @param fnScale amount to scale the function values and gradients (negative
   *        for maximization)
   */
  public LBFGSSolver(OptimizationProblem p, double[] initialPoint,
      double fnScale) {
    this.currentSol = initialPoint;
    this.diag = new double[initialPoint.length];
    this.iflag = new int[] {0};
    this.n = currentSol.length;
    this.m = 7;
    this.fnScale = fnScale;
    this.p = p;
    this.convergeTol = 1e-6 * Math.sqrt(n);
  }

  /**
   * Constructor defaulting to minimization
   * @param p Problem you want to solve
   * @param initialPoint Initial feasible solution
   */
  public LBFGSSolver(OptimizationProblem p, double[] initialPoint) {

    this.currentSol = initialPoint;
    this.diag = new double[initialPoint.length];
    this.iflag = new int[] {0};
    this.n = currentSol.length;
    this.m = 7;
    this.fnScale = 1.0;
    this.p = p;
    this.convergeTol = 1e-6 * Math.sqrt(n);
  }

  // solve the optimization problem
  public double[] solve() {

    // compute initial function value and gradient (and scale by fnScale)
    double f = fnScale * p.computeObjective(currentSol);
    double[] g = p.computeGradient(currentSol);
    g = new ArrayMaths(g).times(fnScale).array();

    while (true) {
      try {
        LBFGS.lbfgs(n, m, currentSol, f, g, diagco, diag, iprint, convergeTol,
            precision, iflag);
      } catch (ExceptionWithIflag e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      // if iflag[0] is negative, there was a problem in line search
      if (iflag[0] < 0) {
        //System.out.println("Something went wrong in line search!");
        break;
      }
      // solution has changed; we need to recalculate the function value 
      // and gradient at the new point
      f = fnScale * p.computeObjective(currentSol);
      g = p.computeGradient(currentSol);
      g = new ArrayMaths(g).times(fnScale).array();

      // check for convergence
      if (iflag[0] == 0) {
        //System.out.println("Converged!!");
        break;
      }
    }

    return currentSol;
  }

  /**
   * set convergence tolerance
   * @param tol Tolerance, should be positive and not too small
   */
  void setConvergeTol(double tol) {
    this.convergeTol = tol;
  }

  /**
   * set printing control parameters
   * @param printControl See LBFGS documentation for usage
   */
  void setiPrint(int[] printControl) {
    this.iprint = printControl;
  }

  /**
   * Set the number of Hessian updates to remember
   * @param m Number of updates to remember
   */
  void setMemory(int m) {
    this.m = m;
  }
}