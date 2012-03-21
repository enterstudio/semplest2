package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;
import org.gridgain.grid.GridJobResult;
import org.gridgain.grid.GridTaskSplitAdapter;

import cache.EhCache;

public class RunCorrelationOnGrid extends
		GridTaskSplitAdapter<CorrelationJobData, HashMap<Integer, HashMap<Integer, Double>>>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1841979736406443492L;

	/*
	 * reduce returns the pearson correlation matrix
	 */
	@Override
	public HashMap<Integer, HashMap<Integer, Double>> reduce(List<GridJobResult> results)
			throws GridException
	{
		HashMap<Integer, HashMap<Integer, Double>> pearsonCorr = new HashMap<Integer, HashMap<Integer, Double>>();
		Iterator<GridJobResult> resultsIT = results.iterator();
		while (resultsIT.hasNext())
		{
			CorrelationResult r =  resultsIT.next().getData();

			if (!pearsonCorr.containsKey(r.getMoviei()))
			{
				HashMap<Integer, Double> correlations = new HashMap<Integer, Double>();
				correlations.put(r.getMoviej(), r.getCorrelation());
				pearsonCorr.put(r.getMoviei(), correlations);
			}
			else
			{
				HashMap<Integer, Double> correlations = pearsonCorr.get(r.getMoviei());
				correlations.put(r.getMoviej(), r.getCorrelation());
			}
		}
		return pearsonCorr;
	}

	@Override
	protected Collection<? extends GridJob> split(int arg0, CorrelationJobData movieData)
			throws GridException
	{
		List<GridJob> jobs = new ArrayList<GridJob>();

		int len = movieData.getLen();
		for (int i = movieData.getStart(); i < movieData.getEnd(); i++)
		{
			// compute only the upper triangle corr is symmetrical
			for (int j = 0; j < i; j++)
			{
				int moviei =  movieData.getMovieIDList().get(i);
				int moviej = movieData.getMovieIDList().get(j);
				HashMap<Integer, RatingDataObject> datai = this.getUserDataForMovie(moviei, movieData.getCache());
				HashMap<Integer, RatingDataObject> dataj = this.getUserDataForMovie(moviej, movieData.getCache());

				if (i != j)
				{
					jobs.add(new CorrelationInParallel(moviei,moviej,datai,dataj));
				}
			}
		}
		return jobs;
	}
	
	private HashMap<Integer, RatingDataObject> getUserDataForMovie(int movieID,EhCache cache)
	{
		if (cache != null)
		{
			Object userData = cache.getMyCache().get(new Integer(movieID)).getObjectValue();
			return (HashMap<Integer, RatingDataObject>) userData;
		}
		else
		{
			return null;
		}
	}

}
