package semplest.bidding.optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


import flanagan.math.Minimisation;
import flanagan.math.MinimisationFunction;
import flanagan.plot.PlotGraph;

import semplest.bidding.estimation.ParametricFunction;
import semplest.bidding.estimation.TruncatedSmoothSCurve;



class WordQCPCPair {
	
	String word;
	double QCPC;
	double click;
	double cost;
	double quality;

	
	public WordQCPCPair(String word, double QCPC){
		this.word=word;
		this.QCPC=QCPC;
	}
	
	public WordQCPCPair(String word, double QCPC, double click, double cost, double quality){
		this.word=word;
		this.QCPC=QCPC;
		this.click=click;
		this.cost=cost;
		this.quality=quality;
	}
		
	public double getQCPC(){
		return QCPC;
	}
	public double getCost(){
		return cost;
	}
	public double getClick(){
		return click;
	}
	public String getWord(){
		return word;
	}
}

class WordQCPCPairComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Double d1 = new Double(((WordQCPCPair)o1).getQCPC());
		Double d2 = new Double(((WordQCPCPair)o2).getQCPC());
		return d1.compareTo(d2);
	}
}



class MinimFunct implements MinimisationFunction{

	private ArrayList<KeyWordInterface> wordList = null;
	private double dailyBudget = 0.0;



    // evaluation function
    public double function(double[] x){
		double [] bids = new double[wordList.size()];
    	for(int i=0; i<wordList.size();i++){
			bids[i]=computeOptimumBidForConst(i,x[0]);
		} // for(int i=0; i<wordList.size();i++)
    	double expectedCost=0;
		
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
			}
			i++;
		}    	
//		System.out.println("Function value evaluated at " + x[0] +": "+Math.pow(expectedCost-dailyBudget,2));
        return Math.pow(expectedCost-dailyBudget,2);
        
//		ArrayList<WordQCPCPair> wqcpcList = new ArrayList<WordQCPCPair>();
//		i=0;
//		for (KeyWordInterface key : wordList){
//			f.setMinBid(key.getMinBid());
//			input[0] = bids[i];
//			if (bids[i]>= key.getMinBid())  {
//				double cost=f.function(input, params);
//				params = key.getClickInfo();
//				double clicks=f.function(input, params);
//				wqcpcList.add(new WordQCPCPair(key.getKeyWord(), cost/(key.getQualityScore()*clicks), clicks, cost, key.getQualityScore()));				
//			}
//			i++;
//		}
//		WordQCPCPair [] wqcpcArray = new WordQCPCPair[wqcpcList.size()];
//		for (i=0; i<wqcpcArray.length; i++){
//			wqcpcArray[i]=wqcpcList.get(i);
//		}
//		Arrays.sort(wqcpcArray, new WordQCPCPairComparator());
////        for (i=0; i<wqcpcArray.length; i++){
////        	System.out.println(wqcpcArray[i].getQCPC());
////        }
//		double totCost=0, totClicks=0;
//		for(i=0;i<wqcpcArray.length;i++){
//			totCost+=wqcpcArray[i].getCost();
//			totClicks+=wqcpcArray[i].getClick();
//			if(totCost>=dailyBudget){
//				break;
//			}
//			System.out.println(totCost+" : "+totClicks);
//		}
//		System.out.println("Function value evaluated at " + x[0] +": "+totCost/totClicks);
//		return totCost/totClicks; // CPC
		
    }
    
    private double computeOptimumBidForConst(int i, double k){
		ParametricFunction f = new TruncatedSmoothSCurve();
		f.setMinBid(wordList.get(i).getMinBid());

		BidLagrangeOptim Bid = new BidLagrangeOptim(wordList.get(i), f, k);
        Minimisation min = new Minimisation();
        
//        min.addConstraint(0, -1, wordList.get(i).getMinBid());
//        min.addConstraint(0, +1, 10.00); // max bid allowed
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
//		System.out.println(param[0]);
		return param[0];
	}

    // Method to set variables
    public void setWordList(ArrayList<KeyWordInterface> wordList){
        this.wordList = wordList;
    }
	public void setDailyBudget(double dailyBudget){
		this.dailyBudget=dailyBudget;
	}
} // class MinimFunct implements MinimisationFunction


public class CampaignBid implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8002739489949394209L;
	
	
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
        min.addConstraint(0, -1, 0);
        min.addConstraint(0, +1, 4.00); // max bid allowed
//        min.setNrestartsMax(10);
		
		double[] start = {wordList.get(i).getMinBid()};
        double[] step = {0.1D};
        double ftol = 1e-15;
        int iterMax = 10000;
        
        
        min.suppressNoConvergenceMessage();
        min.nelderMead(Bid, start, step, ftol, iterMax);

////         get the minimum value
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
	
	public HashMap<String,Double> optimizeBids_new(){
		//Create instance of Minimisation
		Minimisation min = new Minimisation();
		MinimFunct func = new MinimFunct();
		func.setWordList(wordList);
		func.setDailyBudget(dailyBudget);

		// initialization
		ArrayList<Double> bidPoints = new ArrayList<Double>();
		double minVal=Double.MAX_VALUE;
		double minPoint=1.0;
		double b = 0;
		while(b<100){
			bidPoints.add(b);
			b=b+0.01;
		}
		double [] x = new double[1];
		double [][] data = PlotGraph.data(1,bidPoints.size());
		for(int i=0; i<bidPoints.size(); i++){
			data[0][i]=bidPoints.get(i);
			x[0]=bidPoints.get(i);
			data[1][i]=func.function(x);
			if(data[1][i]<minVal){
				minVal=data[1][i];
				minPoint=data[0][i];
			}
		}
		

		
		// refine the search zone
		b = minVal-0.011;
		bidPoints.clear();
		while(b<minVal+0.011){
			bidPoints.add(b);
			b=b+0.0001;
		}
		

		
		data = PlotGraph.data(1,bidPoints.size());
		for(int i=0; i<bidPoints.size(); i++){
			data[0][i]=bidPoints.get(i);
			x[0]=bidPoints.get(i);
			data[1][i]=func.function(x);
			if(data[1][i]<minVal){
				minVal=data[1][i];
				minPoint=data[0][i];
			}
		}
		
		PlotGraph pg = new PlotGraph(data);
		pg.plot();
		System.out.println("Minimum occurs at "+minPoint+", and the minimum value is "+minVal);

		
		double[] start = {minVal};

		// initial step sizes
		double[] step = {0.1D};

		// convergence tolerance
		double ftol = 1e-15;

		//        min.addConstraint(0, -1, 0.0);

		// Nelder and Mead minimisation procedure
		min.nelderMead(func, start, step, ftol);

		// get the minimum value
		double minimum = min.getMinimum();

		// get values of y and z at minimum
		double[] param = min.getParamValues();

		// Output the results to screen
		System.out.println("Minimum = " + minimum);
		System.out.println("Value of Lagrange multiplier at the minimum = " + param[0]);
		
		
		
		 
		 

		bids = new double[wordList.size()];
		for(int i=0; i<wordList.size();i++){
			bids[i]=computeOptimumBidForConst(i,param[0]);
//			bids[i]=computeOptimumBidForConst(i,minPoint);
			//			System.out.format("Bid value: %.2f, min bid: %.2f\n", bids[i],wordList.get(i).getMinBid());
		} // for(int i=0; i<wordList.size();i++)
		computeExpectedValues();

		double [] input = new double[1];
		KeyWordInterface key = null;
		ParametricFunction f = new TruncatedSmoothSCurve();

		for(int i=0; i<bids.length;i++){
			key=wordList.get(i);
			input[0]=bids[i];
			f.setMinBid(key.getMinBid());
			//			System.out.print(key.getKeyWord()+":: ");
			if(bids[i]>= key.getMinBid()) {
				System.out.format("%2d :: %30s: Bid value: %1.2f, min bid: %1.2f, quality score: %.1f, expected clicks: %4.1f, expected daily cost: %4.2f, expected quality metric: %4.1f, CPC: %2.2f\n",//, CPQM: %2.2f \n", 
						i+1, key.getKeyWord(), bids[i],key.getMinBid(), key.getQualityScore(),f.function(input, key.getClickInfo()),f.function(input, key.getDCostInfo()),
						key.getQualityScore()*f.function(input, key.getClickInfo()),
						f.function(input, key.getDCostInfo())/f.function(input, key.getClickInfo()));//,
				//					f.function(input, key.getDCostInfo())/key.getQualityScore()*f.function(input, key.getClickInfo()));
			} else {
				bids[i]=0;
				System.out.format("%2d :: %30s: Bid value: 0.00, min bid: %1.2f, quality score: %.1f, expected clicks:  0.0, expected daily cost:  0.00, expected quality metric:  0.0, CPC:  0.00\n",//, CPQM: %2.2f \n", 
						i+1, key.getKeyWord(), key.getMinBid(), key.getQualityScore());//,
			}
		} // for(int i=0; i<bids.length;i++)
		System.out.format("Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f, expected CPC: %.2f \n",
				expectedCost,expectedClicks,expectedQualityMetric, expectedCost/expectedClicks);


		for(int i=0; i<bids.length;i++){
			wordList.get(i).setBidValue(bids[i]);
		}

//		return bids;
		
		HashMap<String,Double> bidData = new HashMap<String,Double>();

		for(int i=0; i<bids.length;i++){
			wordList.get(i).setBidValue(bids[i]);
			bidData.put(wordList.get(i).getKeyWord(), bids[i]);
		}
		
		
		
		return bidData;

	}
	
	
	public HashMap<String,Double> optimizeBids(){
				
		// initialize constant
		double multLagrange = 1.0;
		boolean highCost=true;
		bids = new double[wordList.size()];
		double prevCost=Double.MIN_VALUE;
		double initialDailyBudget = dailyBudget;
		double initialStepSize = stepSize;
		

		ParametricFunction f = new TruncatedSmoothSCurve();

		double [] input = new double[1];
		KeyWordInterface key = null;
		
		int j=0;
//		while(j<200){
		while(true){
			for(int i=0; i<wordList.size();i++){
				bids[i]=computeOptimumBidForConst(i,multLagrange);
				System.out.format("%d:: Keyword: %s, Bid value: %.2f, min bid: %.2f\n", i, wordList.get(i).getKeyWord(), bids[i],wordList.get(i).getMinBid());
			} // for(int i=0; i<wordList.size();i++)
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
					// check if there is any unused keyword
					boolean noUnused = true;
					for(int l=0; l< bids.length; l++){
						if(bids[l]< wordList.get(l).getMinBid()){
							noUnused = false;
							break;
						}
					}
					if(noUnused || (this.dailyBudget>=2*initialDailyBudget)) {
						break;
					} else {
						this.dailyBudget=this.dailyBudget+1;
						this.stepSize=initialStepSize;
					}
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
				System.out.format("%2d :: %30s: Bid value: %1.2f, min bid: %1.2f, quality score: %.1f, expected clicks: %4.1f, expected daily cost: %4.2f, expected quality metric: %4.1f, CPC: %2.2f\n",//, CPQM: %2.2f \n", 
						i+1, key.getKeyWord(), bids[i],key.getMinBid(), key.getQualityScore(),f.function(input, key.getClickInfo()),f.function(input, key.getDCostInfo()),
						key.getQualityScore()*f.function(input, key.getClickInfo()),
						f.function(input, key.getDCostInfo())/f.function(input, key.getClickInfo()));//,
//				System.out.format("%2d :: %s: Bid value: %1.2f, min bid: %1.2f, expected clicks: %4.1f, expected daily cost: %4.2f, expected quality metric: %4.1f, CPC: %2.2f\n",//, CPQM: %2.2f \n", 
//						i+1, key.getKeyWord(), bids[i],key.getMinBid(),f.function(input, key.getClickInfo()),f.function(input, key.getDCostInfo()),
//						key.getQualityScore()*f.function(input, key.getClickInfo()),
//						f.function(input, key.getDCostInfo())/f.function(input, key.getClickInfo()));//,
				//					f.function(input, key.getDCostInfo())/key.getQualityScore()*f.function(input, key.getClickInfo()));
			} else {
				bids[i]=0;
//				bids[i]=key.getMinBid();
				System.out.format("%2d :: %30s: Bid value: 0.00, min bid: %1.2f, expected clicks:    0.0, expected daily cost:    0.00, expected quality metric:    0.0, CPC:  0.00\n",//, CPQM: %2.2f \n", 
						i+1, key.getKeyWord(), key.getMinBid());//,
			}
		} // for(int i=0; i<bids.length;i++)
		System.out.format("Expected Cost: %.2f, expected clicks: %.1f, expected click quality: %.2f, expected CPC: %.2f \n",
				expectedCost,expectedClicks,expectedQualityMetric, expectedCost/expectedClicks);
		
		
		HashMap<String,Double> bidData = new HashMap<String,Double>();

		for(int i=0; i<bids.length;i++){
			wordList.get(i).setBidValue(bids[i]);
			bidData.put(wordList.get(i).getKeyWord(), bids[i]);
		}
		
		
		
		return bidData;
	} // public void optimizeBids()
	
	


}
