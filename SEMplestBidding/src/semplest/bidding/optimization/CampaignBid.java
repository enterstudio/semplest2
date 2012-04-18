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
	private double dampingFactor = 0.99D;
	
	
	public CampaignBid(){
		wordList = new ArrayList<KeyWordInterface>();
	}
	
	public String [] getKeywords(){
		String [] keys = new String[wordList.size()];
		for(int i=0; i<keys.length; i++){
			keys[i]=wordList.get(i).getKeyWord();
		}
		return keys;
	}
	
	
	private double computeOptimumBidForConst(int i, double k){
		ParametricFunction f = new TruncatedSmoothSCurve();
		f.setMinBid(wordList.get(i).getMinBid());

		BidLagrangeOptim Bid = new BidLagrangeOptim(wordList.get(i), f, k);
        Minimisation min = new Minimisation();
        
//        min.addConstraint(0, -1, wordList.get(i).getMinBid());
        min.addConstraint(0, +1, 10.00); // max bid allowed
//        min.setNrestartsMax(10);
		
		double[] start = {wordList.get(i).getMinBid()};
        double[] step = {0.1D};
        double ftol = 1e-15;
        int iterMax = 10000;
        
        
        min.suppressNoConvergenceMessage();
        min.nelderMead(Bid, start, step, ftol, iterMax);

//        // get the minimum value
//        double minimum = min.getMinimum();
//        System.out.println("***** Minimum value: "+minimum);
        

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
			if (bids[i]>= key.getMinBid())  {
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
	
	
	
	public double [] optimizeBids(){
		
		// initialize constant
		double multLagrange = 0.01;
		boolean highCost=true;
		bids = new double[wordList.size()];
		double prevCost=Double.MIN_VALUE;
		

		ParametricFunction f = new TruncatedSmoothSCurve();

		double [] input = new double[1];
		KeyWordInterface key = null;
		
		int j=0;
//		while(j<200){
		while(true){
			for(int i=0; i<bids.length;i++){
				bids[i]=computeOptimumBidForConst(i,multLagrange);
//				System.out.format("Bid value: %.2f, min bid: %.2f\n", bids[i],wordList.get(i).getMinBid());
			} // for(int i=0; i<bids.length;i++)
			computeExpectedValues();
			System.out.format("Iteration %d:: Lagrange mult: %f, Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f\n",j+1,multLagrange,expectedCost,expectedClicks,expectedQualityMetric);
			
			if (j>0){ 
				if (expectedCost<dailyBudget && highCost){
					stepSize=stepSize*dampingFactor;
//					System.out.println("1: Step-size reduced!");
				} else if (expectedCost>dailyBudget && (!highCost)){
					stepSize=stepSize*dampingFactor;
//					System.out.println("2: Step-size reduced!");
				}
				
				if(Math.abs(expectedCost-prevCost) < 1e-6) {
					System.out.println("BREAKING 1");
					break;
				}
			}
			
			if (expectedCost<dailyBudget){
				highCost=false;
			} else {
				highCost=true;
			}
			
			System.out.println("Expected cost: "+expectedCost+", Daily cost: "+dailyBudget);
			if(Math.abs(expectedCost-dailyBudget) < toldailyBudget){
				System.out.println("BREAKING 2");
				break;
			} else if (expectedCost<dailyBudget){
				multLagrange-=stepSize;
//				System.out.println("Lagrange mult reduced!");
			} else {
				multLagrange+=stepSize;
//				System.out.println("Lagrange mult increased!");
			} // if(Math.abs(expectedCost-dailyBudget) < toldailyBudget)
			multLagrange=Math.max(multLagrange, 0.01);
			j++;
			
			prevCost=expectedCost;
			
		} // while(true)
		

		for(int i=0; i<bids.length;i++){
			key=wordList.get(i);
			input[0]=bids[i];
			f.setMinBid(key.getMinBid());
//			System.out.print(key.getKeyWord()+":: ");
			if(bids[i]>= key.getMinBid()) {
				System.out.format("%2d :: %s: Bid value: %1.2f, min bid: %1.2f, expected clicks: %4.1f, expected daily cost: %4.2f, expected quality metric: %4.1f, CPC: %2.2f\n",//, CPQM: %2.2f \n", 
						i+1, key.getKeyWord(), bids[i],key.getMinBid(),f.function(input, key.getClickInfo()),f.function(input, key.getDCostInfo()),
						key.getQualityScore()*f.function(input, key.getClickInfo()),
						f.function(input, key.getDCostInfo())/f.function(input, key.getClickInfo()));//,
				//					f.function(input, key.getDCostInfo())/key.getQualityScore()*f.function(input, key.getClickInfo()));
			} else {
				System.out.format("%2d :: %s: Bid value: 0.00, min bid: %1.2f, expected clicks:    0.0, expected daily cost:    0.00, expected quality metric:    0.0, CPC:  0.00\n",//, CPQM: %2.2f \n", 
						i+1, key.getKeyWord(), key.getMinBid());//,
			}
		} // for(int i=0; i<bids.length;i++)
		System.out.format("Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f, expected CPC: %.2f \n",
				expectedCost,expectedClicks,expectedQualityMetric, expectedCost/expectedClicks);
		
		
		for(int i=0; i<bids.length;i++){
			wordList.get(i).setBidValue(bids[i]);
		}
		
		return bids;
	} // public void optimizeBids()

}
