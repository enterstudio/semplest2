package semplest.bidding.optimization;

import java.util.ArrayList;

import flanagan.math.Minimisation;

import semplest.bidding.estimation.ParametricFunction;
import semplest.bidding.estimation.WeibullCurve;

public class CampaignBid {
	
	private ArrayList<KeyWordInterface> wordList;
	private double maxBid = 0.0;
	private double expectedCost =0.0;
	private double [] bids;
	private double stepSize = 0.01D;
	private double tolMaxBid = 0.01;
	
	
	public CampaignBid(){
		wordList = new ArrayList<KeyWordInterface>();
	}
	
	private double computeOptimumBidForConst(int i, double k){
		
		ParametricFunction f = new WeibullCurve();
		BidLagrangeOptim Bid = new BidLagrangeOptim(wordList.get(i), f, k);
        Minimisation min = new Minimisation();
		
		double[] start = {-5.0};
        double[] step = {0.2D};
        double ftol = 1e-15;

        min.nelderMead(Bid, start, step, ftol);

        // get the minimum value
        double minimum = min.getMinimum();

//        // get values of y and z at minimum
//         double[] param = min.getParamValues();
		
		return minimum;
	}
	
	private void computeExpectedCost(){
		// method TODO
	}
	
	
	public void addKeyWord(KeyWordInterface keyWord){
		wordList.add(keyWord);
	}
	
	public void setMaxBid(double maxBid){
		this.maxBid=maxBid;
	}
	
	
	
	public void optimizeBids(){
		
		// initialize constant
		double multLagrange = 0.01;
		bids = new double[wordList.size()];
		while(true){
			for(int i=0; i<bids.length;i++){
				bids[i]=computeOptimumBidForConst(i,multLagrange);
				System.out.println("Bid value: " + bids[i]);
			} // for(int i=0; i<bids.length;i++)
			System.exit(0);
			computeExpectedCost();
			System.out.println("Expected Cost: "+expectedCost);
			
			if(Math.abs(expectedCost-maxBid) > tolMaxBid){
				multLagrange+=stepSize;
			} else {
				break;
			} // if(Math.abs(expectedCost-maxBid) > tolMaxBid)
		} // while(true)
	} // public void optimizeBids()

}
