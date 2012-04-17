package semplest.bidding.estimation;

import java.util.HashMap;
import java.util.Iterator;

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
		Iterator it = bidVsTarget.entrySet().iterator();
		int i=0;
		while(it.hasNext()) {
			bidArray[i]=(Double) it.next();
		}
		return bidArray;
	}
	

}
