package semplest.analysis.reports.google;

import java.util.ArrayList;

import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class GetTrafficEstimatorGoogle {
	
	public static void main(String args[]) throws Exception{
		String accountName = "Wedding Hair REduced";
		Long accountId = 1419144853L;
		Long[] bids = {100000L, 700000L, 1000000L, 3000000L, 5000000L};
		GoogleReportTools g = new GoogleReportTools(accountName, accountId, 0);
		ArrayList<String> lines = new ArrayList<String>();
		lines.addAll(g.storeTrafficEstimatorDataGoogle("bridal", KeywordMatchType.EXACT, bids));
		lines.addAll(g.storeTrafficEstimatorDataGoogle("bridesmaid hairstyles", KeywordMatchType.BROAD, bids));
	}

}
