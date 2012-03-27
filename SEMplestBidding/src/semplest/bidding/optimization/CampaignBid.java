package semplest.bidding.optimization;

import java.util.ArrayList;

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
		// method TODO
		double [] bidArray = wordList.get(i).getBidInfo();
		double [] ClickArray = wordList.get(i).getClickInfo();
		double [] CPCArray = wordList.get(i).getCPCInfo();
		double [] PosArray = wordList.get(i).getPosInfo();
		double [] DCostArray = wordList.get(i).getDCostInfo();
		
		
		return 0.0;
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
		double k = 0.01;
		bids = new double[wordList.size()];
		while(true){
			for(int i=0; i<bids.length;i++){
				bids[i]=computeOptimumBidForConst(i,k);
			} // for(int i=0; i<bids.length;i++)
			computeExpectedCost();
			System.out.println("Expected Cost: "+expectedCost);
			
			if(Math.abs(expectedCost-maxBid) > tolMaxBid){
				k+=stepSize;
			} else {
				break;
			} // if(Math.abs(expectedCost-maxBid) > tolMaxBid)
		} // while(true)
	} // public void optimizeBids()

}
