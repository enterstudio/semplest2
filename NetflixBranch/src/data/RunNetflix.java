package data;

import java.util.HashMap;
import java.util.Iterator;

import cache.EhCache;


public class RunNetflix
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		try
		{

			NetflixData data = new NetflixData();
			long startTime = System.currentTimeMillis();
			
			Integer maxInDataset = 1000000;
			data.readNetflixDataFromDirectory("C:/netflix/netflix/download/training_set/training_set", maxInDataset); //"c:/tempData"); //
			//int a = data.openReadFile("C:/netflix/netflix/download/training_set/training_set/mv_0006497.txt");
			//int b = data.openReadFile("C:/netflix/netflix/download/training_set/training_set/mv_0006498.txt");
			//int c = data.openReadFile("C:/netflix/netflix/download/training_set/training_set/mv_0006499.txt");
			double seconds = (System.currentTimeMillis() - startTime)/1000.0;
			System.out.println(" Took: " + seconds + "Sec or " + seconds/60. + " minutes");
			
			/*
			createDataSet set = new createDataSet(data);
			int numinfile = set.run("C:/cache/BookDataset.txt", 100000);
			System.out.println("Num in dataset = " + numinfile);
			if (numinfile >= 100000) return;
			*/
			//Get one movie in cache
			EhCache cache = data.getCache();
			//stats
			//System.out.println("In Memory" + cache.getMyCache().calculateInMemorySize() + " Disk " + cache.getMyCache().calculateOnDiskSize());
			
			startTime = System.currentTimeMillis();
			//HashMap<Integer,HashMap<Integer,Double>> corr = data.caculatePearsonMovieCorrelationInParallel();
			//HashMap<Integer,HashMap<Integer,Double>> corr = data.caculatePearsonMovieCorrelation();
			
			RunCorrelationViaThreads runThreads = new RunCorrelationViaThreads(data);
			HashMap<Integer,HashMap<Integer,Double>> corr = runThreads.runCorrelation();
			
			System.out.println("correlation calc Took: " + seconds + "Sec or " + seconds/60. + " minutes");
			
			Iterator<Integer> corrIT = corr.keySet().iterator();
			while (corrIT.hasNext())
			{
				int moviei = corrIT.next();
				Iterator<Integer> corrJIT = corr.get(moviei).keySet().iterator();
				while(corrJIT.hasNext())
				{
					int moviej = corrJIT.next();
					System.out.println("Moviei=" + moviei + " MovieJ=" + moviej + " Corr= " + corr.get(moviei).get(moviej).doubleValue());
				}
				
			}
			/*
			HashMap<Integer,RatingDataObject> test = data.getUserDataForMovie(6497);
			Iterator<Integer> it = test.keySet().iterator();
			while(it.hasNext())
			{
				int userID = it.next();
				System.out.println("UserID=" + userID + " Rating =" +  test.get(userID).getRating());
			}
			*/
			/*
			Iterator<Integer> movieIDIt = data.getAverageMovieRating().keySet().iterator();
			while (movieIDIt.hasNext())
			{
				Integer movieid = movieIDIt.next();
				Double aveRating = data.getAverageMovieRating().get(movieid);
				System.out.println("MovieID=" + movieid + " Aver user Rating=" + aveRating);
			}
			*/
			cache.shutdown();
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
