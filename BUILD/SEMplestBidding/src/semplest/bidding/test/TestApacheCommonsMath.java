package semplest.bidding.test;

import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.general.LevenbergMarquardtOptimizer;

public class TestApacheCommonsMath {
	
	public static void main(String[] args) {
		
		TestQuadraticProblem problem = new TestQuadraticProblem();

		 problem.addPoint(1, 34.234064369);
		 problem.addPoint(2, 68.2681162306);
		 problem.addPoint(3, 118.6158990846);
		 problem.addPoint(4, 184.1381972386);
		 problem.addPoint(5, 266.5998779163);
		 problem.addPoint(6, 364.1477352516);
		 problem.addPoint(7, 478.0192260919);
		 problem.addPoint(8, 608.1409492707);
		 problem.addPoint(9, 754.5988686671);
		 problem.addPoint(10, 916.1288180859);

		 LevenbergMarquardtOptimizer optimizer = new LevenbergMarquardtOptimizer();

		 final double[] weights = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		 final double[] initialSolution = {1, 1, 1};

		 PointVectorValuePair optimum = optimizer.optimize(100,
		                                                   problem,
		                                                   problem.calculateTarget(),
		                                                   weights,
		                                                   initialSolution);

		 final double[] optimalValues = optimum.getPoint();

		 System.out.println("A: " + optimalValues[0]);
		 System.out.println("B: " + optimalValues[1]);
		 System.out.println("C: " + optimalValues[2]);

	}

}
