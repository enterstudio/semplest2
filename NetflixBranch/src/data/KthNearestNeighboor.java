package data;

import java.util.HashMap;

public class KthNearestNeighboor
{
	private final int k;
	
	public KthNearestNeighboor(int k)
	{
		this.k = k;
	}
	
	public double calculateScoreEstimate(int moviei, HashMap<Integer,HashMap<Integer,Double>> corr)
	{
		HashMap<Integer,Double> corrForMovie = corr.get(moviei);
		
		
		return 0.0;
	}

}
