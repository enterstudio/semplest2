package semplest.keywords.javautils;

public class SimilMeas
{
	// Class that cointains the different similarity measures for two vectors
	public static double KLDiv(double[] p, double[] q)
	{
		// Calculate similarity of two vectors of same length using KL Divergence
		// DivVal = 0 means both vectors are identical.
		double DivVal = 0;
		DivVal = 0.5 * (Div(p, q) + Div(q, p));
		return DivVal;
	}

	public static double Div(double[] p, double[] q)
	{
		// Calculate similarity of two vectors of same length using Divergence
		// DivVal = 0 means both vectors are identical.
		double DivVal = 0;
		for (int i = 0; i < p.length; i++)
		{
			if (p[i] == 0)
			{
				p[i] = Double.MIN_VALUE;
			}
			if (q[i] == 0)
			{
				q[i] = Double.MIN_VALUE;
			}
			DivVal = DivVal + p[i] * ((Math.log(p[i]) - Math.log(q[i])) / Math.log(2));
		}
		return DivVal;
	}

	public static double cosDist(double[] p, double[] q)
	{
		// Calculates cosine distance between two vectors of equals dimensions
		double sumpq = 0;
		double modp = 0;
		double modq = 0;
		if (p.length == q.length)
		{
			for (int i = 0; i < p.length; i++)
			{
				sumpq = sumpq + p[i] * q[i];
				modq = modq + q[i] * q[i];
				modp = modp + p[i] * p[i];
			}
			modq = Math.sqrt(modq);
			modp = Math.sqrt(modp);
		}
		// System.out.println("Mod p: " + modp + "\t" + "Mod q " + modq);
		return sumpq / (modp * modq);
	}
}
