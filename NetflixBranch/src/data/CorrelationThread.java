package data;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class CorrelationThread implements Runnable
{

	private NetflixData data = null;
	private HashMap<Integer, HashMap<Integer, Double>> corrResults;
	private int startIndex;
	private int endIndex;
	private CountDownLatch signal;

	public CorrelationThread(NetflixData data, HashMap<Integer, HashMap<Integer, Double>> corrResults, int startIndex, int endIndex,
			CountDownLatch signal)
	{
		this.data = data;
		this.corrResults = corrResults;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.signal = signal;
	}

	@Override
	public void run()
	{
		caculatePearsonMovieCorrelation();
		signal.countDown();

	}

	public void caculatePearsonMovieCorrelation()
	{

		for (int i = startIndex; i < endIndex; i++)
		{
			// compute only the upper triangle corr is symmetrical
			for (int j = 0; j < i; j++)
			{
				int moviei = data.getMovieIDList().get(i);
				int moviej = data.getMovieIDList().get(j);
				if (i != j)
				{
					PairwiseData pairs = new PairwiseData(moviei, moviej);
					pairs.calculatePairwise(data.getUserDataForMovie(moviei), data.getUserDataForMovie(moviej));
					Double cij = calculateCorrelationFromTerms(pairs);
					if (cij.equals(Double.NaN))
					{
						cij = 0.0;
					}
					//make sure thread safe
					synchronized (corrResults)
					{
						if (!corrResults.containsKey(moviei))
						{
							HashMap<Integer, Double> correlations = new HashMap<Integer, Double>();
							correlations.put(moviej, cij);
							corrResults.put(moviei, correlations);
						}
						else
						{
							HashMap<Integer, Double> correlations = corrResults.get(moviei);
							correlations.put(moviej, cij);
						}
					}
				}

			}
			System.out.println("done row " + i);
		}

	}

	private double calculateCorrelationFromTerms(PairwiseData pairs)
	{
		// top term
		double top = 0.0;
		double bottomleft = 0.0;
		double bottomright = 0.0;
		for (int i = 0; i < pairs.getL(); i++)
		{
			double XiMinusXbar = (pairs.getXi().get(i).getRating() - pairs.getXiAve());
			double XjMinusXbar = (pairs.getXj().get(i).getRating() - pairs.getXjAve());
			top = top + (XiMinusXbar * XjMinusXbar);
			bottomleft = bottomleft + Math.pow(XiMinusXbar, 2.0);
			bottomright = bottomright + Math.pow(XjMinusXbar, 2.0);

		}
		top = top / (pairs.getL() - 1);
		bottomleft = bottomleft / (pairs.getL() - 1);
		bottomright = bottomright / (pairs.getL() - 1);
		return top / (Math.sqrt(bottomleft) * Math.sqrt(bottomright));
	}

}
