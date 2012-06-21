/**
 *
 */
package semplest.bidding.estimation;

import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.special.Gamma;

/**
 * @author amichalka
 * 
 */
public class GammaCurve implements ParametricFunction {

  /**
   * Scaled and shifted gamma PDF
   * @return Scaled
   * @param input Point at which to evaluate the function
   * @param param Paramers (shape rate amplitude shift)
   */
  @Override
  public double derivative(double[] input, double[] parameters) {
    // shape and rate parameters must be provided
    double shape = parameters[0];
    double rate = parameters[1];
    // shifting and scaling parameters may be excluded
    double amplitude = 1.0;

    // compute the result. will depend on how many parameters were provided
    double x = input[0];
    if (parameters.length >= 3) {
      amplitude = parameters[2];
    }
    if (parameters.length >= 4) {
      x = x - parameters[3];
    }
    if (x <= 0 || shape <= 0 || rate <= 0) {
      return 0.0;
    }

    // compute the value of the scaled density at x
    // if the value is NaN, use Apache's implementation
    // WARNING: the Apache GammaDistribution.density() uses the shape/scale
    // parameterization, instead of the shape/rate
    double val = Math.pow(rate, shape) * Math.pow(x, shape - 1.0)
        * Math.exp(-Gamma.logGamma(shape) - rate * x);
    if (Double.isNaN(val)) {
      GammaDistribution g = new GammaDistribution(shape, 1.0 / rate);
      return amplitude * g.density(x);
    } else {
      return amplitude * val;
    }
  }

  /**
   * Scaled and shifted gamma CDF
   * @return Scaled
   * @param input Point at which to evaluate the function
   * @param param Paramers (shape rate amplitude shift)
   */
  @Override
  public double function(double[] input, double[] parameters) {
    // shape and rate must be provided
    double shape = parameters[0];
    double rate = parameters[1];
    // amplitude is optional
    double amplitude = 1.0;

    // compute the result. will depend on how many parameters were provided
    double x = input[0];
    if (parameters.length >= 3) {
      amplitude = parameters[2];
    }
    if (parameters.length >= 4) {
      x = x - parameters[3];
    }

    if (x <= 0 || shape <= 0 || rate <= 0) {
      return 0.0;
    }

    return amplitude * Gamma.regularizedGammaP(shape, x * rate);
  }

  /* (non-Javadoc)
   * @see semplest.bidding.estimation.ParametricFunction#setMinBid(double)
   */
  @Override
  public void setMinBid(double minBid) {
    // do nothing
  }

  /**
   * Some test cases to make sure the function() and derivative() methods work
   * @param args
   */
  public static void main(String[] args) {
    double[] x = new double[] {0.25};
    double[] params = new double[] {2.0, 3.0};
    GammaCurve g = new GammaCurve();
    double result = g.function(x, params);
    System.out.println("Expected: 0.1733585, got: " + result);
    result = g.derivative(x, params);
    System.out.println("Expected: 1.062825, got: " + result);

    // now add scaling
    params = new double[] {.35, 1.1, 5.0};
    result = g.function(x, params);
    System.out.println("Expected: 3.335246, got: " + result);
    result = g.derivative(x, params);
    System.out.println("Expected: 3.797362, got: " + result);

    // now try with shifting and scaling
    params = new double[] {0.5, 4.0, 1.5, 0.1};
    result = g.function(x, params);
    System.out.println("Expected: 1.090017, got: " + result);
    result = g.derivative(x, params);
    System.out.println("Expected: 2.398413, got: " + result);
  }

}
