package semplest.bidding.estimation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EstimatorData {
	
	HashMap<Double,Double> targetVsBid;
	
	public EstimatorData(){
		targetVsBid = new HashMap<Double,Double>();
	}
	
	public void addData(double bid, double data){
		targetVsBid.put(new Double(bid), new Double(data));
	}
	
	public void addData(Double bid, Double data){
		targetVsBid.put(bid, data);
	}
	
	public Double getData(Double bid){
		return targetVsBid.get(bid);
	}
	
	public Double [] getBidArray(){
		Double [] bidArray = new Double[targetVsBid.size()];
		Set<Double> bidSet = targetVsBid.keySet();
		int i=0;
		for(Double bid : bidSet){
			bidArray[i]=bid;
			i++;
		}
		return bidArray;
	}
	
	public double [] getData(Double [] bids){
		double [] dataArray = new double[bids.length];
		for (int i=0; i<bids.length; i++){
			dataArray[i]=targetVsBid.get(bids[i]).doubleValue();
		}
		return dataArray;
	}
	

}
