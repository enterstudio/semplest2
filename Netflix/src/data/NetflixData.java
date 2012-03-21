package data;

import gridGain3_5.StartGrid;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.ehcache.Element;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridException;
import org.gridgain.grid.GridTaskFuture;

import cache.EhCache;

public class NetflixData
{
	private static int batch = 50;

	private SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-DD");
	private java.util.Date startDate;
	private EhCache cache = null;
	private HashMap<Integer, Double> averageMovieRating = new HashMap<Integer, Double>();
	private ArrayList<Integer> movieIDList = new ArrayList<Integer>();

	public HashMap<Integer, Double> getAverageMovieRating()
	{
		return averageMovieRating;
	}

	public NetflixData() throws ParseException
	{
		cache = new EhCache();
		startDate = YYYY_MM_DD.parse("1998-01-01");
	}

	/*
	 * readin all file from the directory
	 */
	public void readNetflixDataFromDirectory(String url, Integer maxInDataset) throws Exception
	{

		//
		File dir = new File(url);
		if (!dir.isDirectory())
		{
			throw new Exception(url + " must be a directory");
		}
		String[] listOfFiles = dir.list();
		int total = 0;
		for (int i = 0; i < listOfFiles.length; i++)
		{
			System.out.print("Reading in data from " + dir.getAbsolutePath() + "/" + listOfFiles[i]);
			int num = openReadFile(dir.getAbsolutePath() + "/" + listOfFiles[i]);
			total = total + num;
			if (maxInDataset != null && total >= maxInDataset.intValue())
			{
				return;
			}
			System.out.println(" num in file = " + num + " Total count = " + total);
		}
	}
	
	protected int openReadFile(String file)
	{

		DataInputStream in = null;
		FileInputStream fstream = null;
		try
		{

			// Open the file that is the first
			// command line parameter
			fstream = new FileInputStream(file);
			// Get the object of DataInputStream
			in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int row = 1;
			int count = 0;
			Integer movieid = -1;
			Double totalUserRating = 0.0;
			HashMap<Integer, RatingDataObject> userRatingData = new HashMap<Integer, RatingDataObject>();
			while ((strLine = br.readLine()) != null)
			{
				// first row in the file is movie ID
				if (row == 1)
				{
					// get the movie ID
					String[] movieLine = strLine.split("[:]");
					movieid = new Integer(Integer.parseInt(movieLine[0].trim()));
					movieIDList.add(movieid);
					row++;
				}
				else
				// data row
				{
					String[] userLine = strLine.split("[,]");
					if (userLine.length == 3)
					{

						int days = daysBetween(YYYY_MM_DD.parse(userLine[2].trim()), startDate);
						RatingDataObject r = new RatingDataObject(Short.parseShort(userLine[1].trim()), days);
						userRatingData.put(Integer.parseInt(userLine[0].trim()), r);
						totalUserRating = totalUserRating + r.getRating();

						count++;
					}

				}
			}
			// store results
			averageMovieRating.put(movieid, totalUserRating / count);
			Element ele = new Element(movieid, userRatingData);
			cache.getMyCache().put(ele);
			// System.out.println("Cached " + movie);
			// Close the input stream
			in.close();
			fstream.close();
			return count;
		}
		catch (Exception e)
		{// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			if (in != null)
			{
				try
				{
					in.close();
					fstream.close();
				}
				catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return -1;
		}

	}

	public HashMap<Integer, HashMap<Integer, Double>> caculatePearsonMovieCorrelation()
	{
		HashMap<Integer, HashMap<Integer, Double>> pearsonCorr = new HashMap<Integer, HashMap<Integer, Double>>();
		// go through and calculate averages for movie i and j for only those
		// users in common
		int len = movieIDList.size();
		for (int i = 0; i < len; i++)
		{
			// compute only the upper triangle corr is symmetrical
			for (int j = 0; j < i; j++)
			{
				int moviei = movieIDList.get(i);
				int moviej = movieIDList.get(j);
				if (i != j)
				{
					PairwiseData pairs = new PairwiseData(moviei, moviej);
					pairs.calculatePairwise(this.getUserDataForMovie(moviei), this.getUserDataForMovie(moviej));
					double cij = calculateCorrelationFromTerms(pairs);

					if (!pearsonCorr.containsKey(moviei))
					{
						HashMap<Integer, Double> correlations = new HashMap<Integer, Double>();
						correlations.put(moviej, cij);
						pearsonCorr.put(moviei, correlations);
					}
					else
					{
						HashMap<Integer, Double> correlations = pearsonCorr.get(moviei);
						correlations.put(moviej, cij);
					}
				}

			}
			System.out.println("done row " + i);
		}
		return pearsonCorr;
	}

	public HashMap<Integer, HashMap<Integer, Double>> caculatePearsonMovieCorrelationInParallel() throws IllegalStateException, GridException
	{

		int startIndex = 0;
		int endIndex = startIndex + batch;
		int len = this.movieIDList.size();
		HashMap<Integer, HashMap<Integer, Double>> pearsonCorrTotal = new HashMap<Integer, HashMap<Integer, Double>>();
		//
		StartGrid.startGrid();
		Grid grid = StartGrid.getLocalGrid();

		// Execute Hello World task.
		CorrelationJobData data = new CorrelationJobData();
		data.setCache(cache);
		data.setLen(len);
		data.setMovieIDList(movieIDList);

		boolean done = false;
		while (!done)
		{
			data.setStart(startIndex);
			data.setEnd(endIndex);
			System.out.println("Starting index=" + startIndex + " End=" + endIndex);

			GridTaskFuture<HashMap<Integer, HashMap<Integer, Double>>> future = grid.execute(RunCorrelationOnGrid.class, data);

			// Wait for task completion.
			HashMap<Integer, HashMap<Integer, Double>> pearsonCorr = future.get();
			pearsonCorrTotal.putAll(pearsonCorr);

			System.out.println("Completed index=" + startIndex + " End=" + endIndex + ":" + future.duration());

			startIndex = endIndex + 1;
			if (startIndex > len)
			{
				done = true;
			}
			endIndex = endIndex + batch;
			if (endIndex > len)
			{
				endIndex = len;
			}
		}

		StartGrid.StopGrid();
		return pearsonCorrTotal;

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

	private CorrelationResult calculateCorrelationFromTermsReturnResult(PairwiseData pairs)
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
		CorrelationResult res = new CorrelationResult();
		res.setCorrelation(top / (Math.sqrt(bottomleft) * Math.sqrt(bottomright)));
		res.setMoviei(pairs.getI());
		res.setMoviej(pairs.getJ());
		return res;
	}

	

	public HashMap<Integer, RatingDataObject> getUserDataForMovie(int movieID)
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

	private int daysBetween(java.util.Date d1, java.util.Date d2)
	{
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public EhCache getCache()
	{
		return cache;
	}

	public ArrayList<Integer> getMovieIDList()
	{
		return movieIDList;
	}
	 

}
