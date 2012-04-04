package semplest.bidding.optimization;

import java.util.ArrayList;


import flanagan.math.Minimisation;

import semplest.bidding.estimation.ParametricFunction;
import semplest.bidding.estimation.TruncatedSmoothSCurve;


public class CampaignBid {
	
	private ArrayList<KeyWordInterface> wordList;
	private double dailyBudget = 0.0;
	private double expectedCost =0.0;
	private double expectedClicks =0;
	private double expectedQualityMetric =0;
	private double [] bids;
	private double stepSize = 1.0D;
	private double toldailyBudget = 1;
	private double dampingFactor = 0.1D;
	
	
	public CampaignBid(){
		wordList = new ArrayList<KeyWordInterface>();
	}
	
	
	private double computeOptimumBidForConst(int i, double k){
		
		ParametricFunction f = new TruncatedSmoothSCurve();
		f.setMinBid(wordList.get(i).getMinBid());

		BidLagrangeOptim Bid = new BidLagrangeOptim(wordList.get(i), f, k);
        Minimisation min = new Minimisation();
		
		double[] start = {1.5};
        double[] step = {0.1D};
        double ftol = 1e-15;
        int iterMax = 1000;
        
        
//        min.suppressNoConvergenceMessage();
        min.nelderMead(Bid, start, step, ftol, iterMax);

//        // get the minimum value
//        double minimum = min.getMinimum();
        

        // get values of y and z at minimum
         double[] param = min.getParamValues();
         
//         wordList.get(i).setBidValue(param[0]);
		
		return param[0];
	}
	
	private void computeExpectedValues(){
		expectedCost=0;
		expectedClicks=0;
		expectedQualityMetric=0;

		ParametricFunction f = new TruncatedSmoothSCurve();

		double [] input = new double[1];
		double [] params = null;
		int i=0;
		for (KeyWordInterface key : wordList){
			f.setMinBid(key.getMinBid());
			params = key.getDCostInfo();
			input[0] = bids[i];
			expectedCost+=f.function(input, params);
			params = key.getClickInfo();
			expectedClicks+=f.function(input, params);
			expectedQualityMetric+=key.getQualityScore()*f.function(input, params);
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
		double prevCost=Double.MIN_VALUE;
		

		ParametricFunction f = new TruncatedSmoothSCurve();

		double [] input = new double[1];
		KeyWordInterface key = null;
		
		int j=0;
//		while(j<20){
		while(true){
			for(int i=0; i<bids.length;i++){
				bids[i]=computeOptimumBidForConst(i,multLagrange);
//				System.out.format("Bid value: %.2f, min bid: %.2f\n", bids[i],wordList.get(i).getMinBid());
			} // for(int i=0; i<bids.length;i++)
			computeExpectedValues();
			System.out.format("Iteration %d:: Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f\n",j+1,expectedCost,expectedClicks,expectedQualityMetric);
			
			if (j>0){ 
				if (expectedCost<dailyBudget && highCost){
					stepSize=stepSize*dampingFactor;
//					System.out.println("Step-size reduced!");
				} else if (expectedCost>dailyBudget && (!highCost)){
					stepSize=stepSize*dampingFactor;
//					System.out.println("Step-size reduced!");
				}
				
				if(Math.abs(expectedCost-prevCost) < 1e-6)
					break;
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
			
			prevCost=expectedCost;
			
		} // while(true)
		

		for(int i=0; i<bids.length;i++){
			key=wordList.get(i);
			input[0]=bids[i];
			f.setMinBid(key.getMinBid());
//			System.out.print(key.getKeyWord()+":: ");
			System.out.format("%2d :: Bid value: %1.2f, min bid: %1.2f, expected clicks: %4.1f, expected daily cost: %4.2f, expected quality metric: %4.1f, CPC: %2.2f\n",//, CPQM: %2.2f \n", 
					i+1, bids[i],key.getMinBid(),f.function(input, key.getClickInfo()),f.function(input, key.getDCostInfo()),
					key.getQualityScore()*f.function(input, key.getClickInfo()),
					f.function(input, key.getDCostInfo())/f.function(input, key.getClickInfo()));//,
//					f.function(input, key.getDCostInfo())/key.getQualityScore()*f.function(input, key.getClickInfo()));
		} // for(int i=0; i<bids.length;i++)
		System.out.format("Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f, expected CPC: %.2f \n",
				expectedCost,expectedClicks,expectedQualityMetric, expectedCost/expectedClicks);
		
		
	} // public void optimizeBids()

}
