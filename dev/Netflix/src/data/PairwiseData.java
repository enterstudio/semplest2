package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PairwiseData 
{
	private ArrayList<RatingDataObject> Xi = new ArrayList<RatingDataObject>();

	private ArrayList<RatingDataObject> Xj = new ArrayList<RatingDataObject>();
	private int L = 0;
	private Double XiAve = 0.0;
	private Double XjAve = 0.0;

	private int i;
	private int j;

	public PairwiseData(int i, int j)
	{
		this.i = i;
		this.j = j;
	}

	public void calculatePairwise(HashMap<Integer, RatingDataObject> XiList,HashMap<Integer, RatingDataObject> XjList)
	{
		// go through XiList and check if there is any in common with
		Iterator<Integer> XiIT = XiList.keySet().iterator();
		while (XiIT.hasNext())
		{
			int XiUser = XiIT.next();
			if (XjList.containsKey(XiUser))
			{
				this.Xi.add(XiList.get(XiUser));
				this.Xj.add(XjList.get(XiUser));
				L++;
				// use ave var to sum first
				XiAve = XiAve + XiList.get(XiUser).getRating();
				XjAve = XjAve + XjList.get(XiUser).getRating();

			}
		}
		if (L != 0)
		{
			XiAve = XiAve / L;
			XjAve = XjAve / L;
		}
	}

	public ArrayList<RatingDataObject> getXi()
	{
		return Xi;
	}

	public ArrayList<RatingDataObject> getXj()
	{
		return Xj;
	}

	public int getL()
	{
		return L;
	}

	public Double getXiAve()
	{
		return XiAve;
	}

	public Double getXjAve()
	{
		return XjAve;
	}

	public int getI()
	{
		return i;
	}

	public int getJ()
	{
		return j;
	}

}

