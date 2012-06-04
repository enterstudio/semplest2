package semplest.service.bidding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;


import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.ReportObject;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;

public class KeywordIdeaFromBroadMatchData {
	

	private static final Logger logger = Logger.getLogger(KeywordIdeaFromBroadMatchData.class);


	public static HashMap<String,Integer> getHighVolumeBroadMatchWords(String accountID){
		
		ReportObject[] ret = null;
		HashMap<String,Integer> termImpressionMap = new HashMap<String,Integer>();
		HashMap<String,Integer> termDaysMap = new HashMap<String,Integer>();

		try{
			GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();
			ret = client.getSearchQueryReportForAccount(new SemplestString().toSemplestString(accountID));
		} catch(Exception e){
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
			for(ReportObject r : ret){
				if (r.getBidMatchType().equalsIgnoreCase("broad")){
					if(termImpressionMap.containsKey(r.getSearchTerm())){
						termImpressionMap.put(r.getSearchTerm(), r.getNumberImpressions()+termImpressionMap.get(r.getSearchTerm()));
						termDaysMap.put(r.getSearchTerm(), 1+termDaysMap.get(r.getSearchTerm()));
					} else {
						termImpressionMap.put(r.getSearchTerm(), r.getNumberImpressions());
						termDaysMap.put(r.getSearchTerm(), 1);
					}
				} // if (r.getBidMatchType().equalsIgnoreCase("broad"))
			} // for(ReportObject r : ret)
			
			

		return termImpressionMap;
	}
	
	
    public static List sortByValue(final Map m) {
        List keys = new ArrayList();
        keys.addAll(m.keySet());
        Collections.sort(keys, new Comparator() {
            public int compare(Object o1, Object o2) {
                Object v1 = m.get(o1);
                Object v2 = m.get(o2);
                if (v1 == null) {
                    return (v2 == null) ? 1 : 0;
                }
                else if (v1 instanceof Comparable) {
                    return ((Comparable) v2).compareTo(v1);
                }
                else {
                    return 0;
                }
            }
        });
        return keys;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		String accountID = "2188810777";
		String accountID = "9036397375"; // bethflowers

		HashMap<String,Integer> termImpressionMap = getHighVolumeBroadMatchWords(accountID);
		System.out.printf("Search term and their impressions:\n");
        for (Iterator i = sortByValue(termImpressionMap).iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            System.out.printf("%s: %s\n", key, termImpressionMap.get(key));
        }
	}

}
