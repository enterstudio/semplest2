package semplest.bidding.optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.Logger;


import flanagan.math.Minimisation;


import semplest.bidding.estimation.GammaCurve;
import semplest.bidding.estimation.ParametricFunction;


public class BidOptimizer implements java.io.Serializable {
	
	private static final Logger logger = Logger.getLogger(BidOptimizer.class);

	

	private static final long serialVersionUID = -7298418379123108818L;
	
	
	private ArrayList<KeyWordInterface> wordList;
	private double dailyBudget = 0.0;
	private double totalDailyCost = 0.0;
	private double totalDailyClicks =0.0;
	private double targetCPC = 0.0;
	private double [] bids;
	private double tolDailyBudget = 1.0;
	private int maxIter = 10000;
	private double stepSize = 0.01;
	
	
	public BidOptimizer(){
		wordList = new ArrayList<KeyWordInterface>();
	}
	
	public String [] getKeywords(){
		String [] keys = new String[wordList.size()];
		for(int i=0; i<keys.length; i++){
			keys[i]=wordList.get(i).getKeyWord();
		}
		return keys;
	}
	
	public void addKeyWord(KeyWordInterface keyWord){
		wordList.add(keyWord);
	}
	
	public void setDailyBudget(double dailyBudget){
		this.dailyBudget=dailyBudget;
	}
	public double getTotalDailyCost() {
		return totalDailyCost;
	}
	public double getTotalDailyClicks() {
		return totalDailyClicks;
	}
	public double getTargetCPC() {
		return targetCPC;
	}


	public HashMap<String,Double> getCPCPercentilePoint(double percentileValue, double marginFactor, double maxBid){

		HashMap<String,Double> bidData = new HashMap<String,Double>();
		
		double [] bidArray = new double[wordList.size()]; 

	    ParametricFunction f = new GammaCurve();

		for(int i=0;i<wordList.size();i++){
			double [] cpcParam = wordList.get(i).getCPCInfo();
			Double amplitude = f.getScalingCoeff(cpcParam);
			bidData.put(wordList.get(i).getKeyWord(), getBidForTargetCPC(wordList.get(i).getCPCInfo(), amplitude*percentileValue/100.0));
			bidArray[i]=bidData.get(wordList.get(i).getKeyWord());			
		}

		Arrays.sort(bidArray);
		double medianBid = bidArray[bidArray.length/2];
		double upperBound = Math.min(maxBid, medianBid*marginFactor);
		for(int i=0;i<wordList.size();i++){
			bidData.put(wordList.get(i).getKeyWord(),Math.min(bidData.get(wordList.get(i).getKeyWord()),upperBound));
		}
		
		totalDailyCost = 0;
		totalDailyClicks = 0;
		double [] input = new double[1];
		
		for(int i=0;i<wordList.size();i++){
			input[0]=bidData.get(wordList.get(i).getKeyWord());
			totalDailyCost+=f.function(input, wordList.get(i).getDCostInfo());
			totalDailyClicks+=f.function(input, wordList.get(i).getClickInfo());

		} // for(int i=0;i<wordList.size();i++)
		
		targetCPC = Math.min(maxBid, totalDailyCost/totalDailyClicks);
		
		return bidData;
	}
	
		
	public HashMap<String,Double> optimizeBids(){
		HashMap<String,Double> bidData = new HashMap<String,Double>();
	    ParametricFunction f = new GammaCurve();
	    double [] input = new double[1];
	    int progression = 0;

	    bids = new double[wordList.size()];

	    targetCPC = 0.1;
		int j=0;
		while(true){
			
			totalDailyCost = 0;
			totalDailyClicks = 0;
			
			for(int i=0;i<wordList.size();i++){
				bids[i]=getBidForTargetCPC(wordList.get(i).getCPCInfo(), targetCPC); // find the bid that achieves the target CPC
				
				input[0]=bids[i];
				totalDailyCost+=f.function(input, wordList.get(i).getDCostInfo());
				totalDailyClicks+=f.function(input, wordList.get(i).getClickInfo());

			} // for(int i=0;i<wordList.size();i++)
			
			logger.info("Estimated CPC: "+targetCPC+", Target cost: "+dailyBudget+", Estimated budget: "+totalDailyCost);

			
			if(totalDailyCost< dailyBudget){
				targetCPC+=stepSize;
				if(progression==-1){
					stepSize=0.1*stepSize;
				}
				progression = 1;
			} else{
				targetCPC-=stepSize;
				if(progression==1){
					stepSize=0.1*stepSize;	
				}
				progression = -1;
			} // if(totalDailyCost< dailyBudget)
				
			j++;
			if(j==maxIter || (Math.abs(totalDailyCost - dailyBudget) < tolDailyBudget)){
				break;
			}
		} // while(true) 
		
	
		for(int i=0; i<bids.length;i++){
			bids[i]=Math.min(bids[i],3*targetCPC);
			wordList.get(i).setBidValue(bids[i]);
			bidData.put(wordList.get(i).getKeyWord(), bids[i]);
		}		
		return bidData;
	}
	
	private double getBidForTargetCPC(double [] params, double targetCPC){
		
	    ParametricFunction f = new GammaCurve();

		RootFinderFunction rootFinderFunc = new RootFinderFunction(f, targetCPC, params);
        Minimisation min = new Minimisation();
        
        //min.addConstraint(0, -1, wordList.get(i).getMinBid());
        min.addConstraint(0, -1, 0.05);
        //min.addConstraint(0, +1, 4.00); // max bid allowed
        //min.setNrestartsMax(10);
		
		//double[] start = {wordList.get(i).getMinBid()};
		double[] start = {3.0};
        double[] step = {0.1D};
        double ftol = 1e-15;
        int iterMax = 10000;
        
        
        min.suppressNoConvergenceMessage();
        min.nelderMead(rootFinderFunc, start, step, ftol, iterMax);

        ////get the minimum value
        //double minimum = min.getMinimum();
        //System.out.println("***** Minimum value: "+minimum);
        

        // get values of params at minimum
         double[] param = min.getParamValues();
         
         //wordList.get(i).setBidValue(param[0]);
		
		return param[0];
	}
	


}
