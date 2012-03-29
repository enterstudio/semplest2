package semplest.bidding.optimization;

import java.util.ArrayList;

import flanagan.math.Minimisation;

import semplest.bidding.estimation.ParametricFunction;
import semplest.bidding.estimation.WeibullCurve;

public class CampaignBid {
	
	private ArrayList<KeyWordInterface> wordList;
	private double dailyBudget = 0.0;
	private double expectedCost =0.0;
	private double expectedClicks =0;
	private double expectedQualityMetric =0;
	private double [] bids;
	private double stepSize = 0.001D;
	private double toldailyBudget = 20;
	private double dampingFactor = 0.9D;
	
	
	public CampaignBid(){
		wordList = new ArrayList<KeyWordInterface>();
	}
	
	private double computeOptimumBidForConst(int i, double k){
		
		ParametricFunction f = new WeibullCurve();
		BidLagrangeOptim Bid = new BidLagrangeOptim(wordList.get(i), f, k);
        Minimisation min = new Minimisation();
		
		double[] start = {2.0};
        double[] step = {0.001D};
        double ftol = 1e-15;
        int iterMax = 10000;
        
        
        min.suppressNoConvergenceMessage();
        min.nelderMead(Bid, start, step, ftol, iterMax);

//        // get the minimum value
//        double minimum = min.getMinimum();
        

        // get values of y and z at minimum
         double[] param = min.getParamValues();
		
		return param[0];
	}
	
	private void computeExpectedValues(){
		expectedCost=0;
		expectedClicks=0;
		expectedQualityMetric=0;
		ParametricFunction f = new WeibullCurve();
		double [] input = new double[1];
		double [] params = null;
		int i=0;
		for (KeyWordInterface key : wordList){
			if(bids[i]>=key.getMinBid()+0.01){
				params = key.getDCostInfo();
				input[0] = bids[i];
				expectedCost+=f.function(input, params);
				params = key.getClickInfo();
				expectedClicks+=f.function(input, params);
				expectedQualityMetric+=key.getQualityScore()*f.function(input, params);
			}
			i++;
		}
	}
	
	
	public void addKeyWord(KeyWordInterface keyWord){
		wordList.add(keyWord);
	}
	
	public void setDailyBudget(double dailyBudget){
		this.dailyBudget=dailyBudget;
	}
	
	
	
	public void optimizeBids(){
		
		// initialize constant
		double multLagrange = 0.01;
		boolean highCost=true;
		bids = new double[wordList.size()];
		
		ParametricFunction f = new WeibullCurve();
		double [] input = new double[1];
		KeyWordInterface key = null;
		
		int j=0;
//		while(j<1){
		while(true){
			for(int i=0; i<bids.length;i++){
				bids[i]=Math.max(computeOptimumBidForConst(i,multLagrange),wordList.get(i).getMinBid());
				System.out.format("Bid value: %.2f, min bid: %.2f\n", bids[i],wordList.get(i).getMinBid());
			} // for(int i=0; i<bids.length;i++)
			computeExpectedValues();
			System.out.format("Iteration %d:: Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f\n",j+1,expectedCost,expectedClicks,expectedQualityMetric);
			
			if (j>0){ 
				if (expectedCost<dailyBudget && highCost){
					stepSize=stepSize*dampingFactor;
				} else if (expectedCost>dailyBudget && (!highCost)){
					stepSize=stepSize*dampingFactor;
				}
			}
			
			if (expectedCost<dailyBudget){
				highCost=false;
			} else {
				highCost=true;
			}
			
			if(Math.abs(expectedCost-dailyBudget) < toldailyBudget){
				break;
			} else if (expectedCost<dailyBudget){
				multLagrange-=stepSize;
			} else {
				multLagrange+=stepSize;
			} // if(Math.abs(expectedCost-dailyBudget) < toldailyBudget)
			j++;
			
		} // while(true)
		

		for(int i=0; i<bids.length;i++){
			key=wordList.get(i);
			if(bids[i]>=key.getMinBid()+0.01) { 
				input[0]=bids[i];
				System.out.format(key.getKeyWord()+":: Bid value: %.2f, min bid: %.2f, expected clicks: %.1f, expected daily cost: %.1f\n", bids[i],key.getMinBid(),f.function(input, key.getClickInfo()),f.function(input, key.getDCostInfo()));
			} else {
				System.out.format(key.getKeyWord()+":: Bid value: %.2f, min bid: %.2f, expected clicks: 0.0, expected daily cost: 0.0\n", key.getMinBid(),key.getMinBid());
			}
		} // for(int i=0; i<bids.length;i++)
		
	} // public void optimizeBids()

}
