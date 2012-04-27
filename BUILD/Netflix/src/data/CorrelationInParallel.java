package data;

import java.util.HashMap;

import org.gridgain.grid.GridException;
import org.gridgain.grid.GridJob;

public class CorrelationInParallel implements GridJob 
{

	private int moviei;
	private int moviej;
	HashMap<Integer, RatingDataObject> datai;
	HashMap<Integer, RatingDataObject> dataj;
	
	public CorrelationInParallel(int i, int j,HashMap<Integer, RatingDataObject> datai, HashMap<Integer, RatingDataObject> dataj)
	{
		moviei= i;
		moviej = j;
		this.datai = datai;
		this.dataj = dataj;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8562332919586285250L;

	@Override
	public void cancel()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object execute() throws GridException
	{
		PairwiseData pairs = new PairwiseData(moviei,moviej);
		pairs.calculatePairwise(datai,dataj);
		return calculateCorrelationFromTermsReturnResult(pairs);
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

	

}
