package semplest.analysis.reports.msn;

import java.util.ArrayList;

import semplest.analysis.reports.utils.ReportUtils;

import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class GetTrafficEstimatorMSN {
	
	public static void main(String args[]) throws Exception{
		String accountName = "-WeddingHairReduced2";
		
		//Long[] bids = {100000L, 700000L, 1000000L, 3000000L, 5000000L, 7000000L};
		MSNReportTools msn = new MSNReportTools(accountName,  0);
		ArrayList<Long> bidsArray = msn.createMicroBids(0.1, 10.0, 0.1);
		Long[] bids = bidsArray.toArray(new Long[bidsArray.size()]);
		ArrayList<String> lines = new ArrayList<String>();
		lines.addAll(msn.storeTrafficEstimatorDataMSN("hair styles", KeywordMatchType.BROAD, bids));
		lines.addAll(msn.storeTrafficEstimatorDataMSN("wedding rings", KeywordMatchType.EXACT, bids));
		ReportUtils.saveArrayListString(lines, "/semplest/data/dailyReportObjects/WeddingHairReduced/TrafficEstimatorMSN.csv");
	}

}
