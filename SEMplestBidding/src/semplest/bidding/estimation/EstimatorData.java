package semplest.bidding.estimation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EstimatorData {
	
	HashMap<Double,Double> bidVsTarget;
	
	public EstimatorData(){
		bidVsTarget = new HashMap<Double,Double>();
	}
	
	public void addData(double bid, double data){
		bidVsTarget.put(new Double(bid), new Double(data));
	}
	
	public void addData(Double bid, Double data){
		bidVsTarget.put(bid, data);
	}
	
	public Double getData(Double bid){
		return bidVsTarget.get(bid);
	}
	
	public Double [] getBidArray(){
		Double [] bidArray = new Double[bidVsTarget.size()];
		Set<Double> bidSet = bidVsTarget.keySet();
		int i=0;
		for(Double bid : bidSet){
			bidArray[i]=bid;
			i++;
		}
		return bidArray;
	}
	

}
