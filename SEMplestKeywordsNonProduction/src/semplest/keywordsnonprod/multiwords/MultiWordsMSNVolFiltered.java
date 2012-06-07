
package semplest.keywordsnonprod.multiwords;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear;

import semplest.keywords.javautils.dictUtils;
import semplest.service.msn.adcenter.MsnCloudException;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class MultiWordsMSNVolFiltered {
	
	
	private static String shiftWords(String [] buffer, String s){
		StringBuffer buff = new StringBuffer();
		for (int i=0; i<buffer.length-1; i++){
			buffer[i]=buffer[i+1];
			buff.append(buffer[i]+" ");
		}
		buffer[buffer.length-1]=s;
		buff.append(s);
		return buff.toString();
	}
	
	
	public static ArrayList<String> getMultiWords(String in, int [] n, int minCount, MsnCloudServiceImpl msn){
		
		
		ArrayList<String> list = new ArrayList<String>();
		
		
		in=in.replaceAll("   ", " ");
		in=in.replaceAll("  ", " ");
		String [] words = in.split(" ");
		//String [] words = in.split("\\s+");
		
		for(int i=0; i<n.length; i++){
			
			StringBuilder out = new StringBuilder();
			String key;
			HashMap<String,Integer> indexMap = new HashMap<String,Integer>();
			
			String [] buffer = new String[n[i]];
			int j=0;
			for (String s : words){
				if(j<n[i]){ // the intial buffer building
					if (dictUtils.validWord(s)) {
						buffer[j]=s;
						j++;
						continue;
					}
				} // if(j<n[i])
				//if (dictUtils.validWord(s)){ // if in dictionary
				if (s.length()>2){
					//System.out.println(s+":"+s.length());
					key=MultiWordsMSNVolFiltered.shiftWords(buffer, s);
//					key=s;
					if (indexMap.containsKey(key)){
						indexMap.put(key, indexMap.get(key)+1);
					} else {
						indexMap.put(key, new Integer(1));
					}
				}
			} // for (String s : words){
			
			List listEntrySet = new LinkedList(indexMap.entrySet());
			Collections.sort(listEntrySet, new Comparator() {
				public int compare(Object o1, Object o2) {
					return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
				}
			});
			
			Set<String> keySet = indexMap.keySet(); 
			String [] keywords = keySet.toArray(new String[keySet.size()]);
			System.out.println("Number of selected keywords: "+keywords.length);
			HashMap<String, Integer> kwVolMap = getVolume(msn, keywords);

			int k=0;
			//for (String finalS : indexMap.keySet()){
			Iterator it = listEntrySet.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();
				if((Integer) entry.getValue() > minCount && kwVolMap.get((String) entry.getKey())!=null){
					k++;
					out.append(((String) entry.getKey()).replaceAll(" ", "+")+":"+entry.getValue()+" ");
					if(k==200) {
						break;
					}
				}
			}
			if(out.length()>0) // if there is anything written at all!
				out.setLength(out.length()-1); // delete the last 
			
			
//			list.add(out.toString()); 
			list.add(k+" "+out.toString()); // changed for crawl level 2
			System.out.println(out);

			
		} // for(int i=0; i<n.length; i++){
		
		return list;
	} // public static ArrayList<String> getMultiWords(String in, int [] n, int minCount)
	
	
	public static HashMap<String, Integer> getVolume(MsnCloudServiceImpl msn, String[] keywords) {
		
		
		Long accountID = null;
		Calendar cal = Calendar.getInstance();
		MonthAndYear startMonth = new MonthAndYear();
		startMonth.setMonth(cal.get(Calendar.MONTH) + 1);
		startMonth.setYear(cal.get(Calendar.YEAR) - 1);
		
		
		HashMap<String,Integer> keywordVolumeMap = new HashMap<String,Integer>();
		
		
		try {
			String [] kws;
			int numIters =1;
			if(keywords.length>1000){
				numIters = keywords.length/1000;
				if(keywords.length%1000 > 0){
					numIters++;
				}
			}
			int startIndex = 0;
			for(int iter=0; iter<numIters; iter++){
				if(numIters==1){
					kws=keywords;
				} else {
					if(iter==numIters-1){ // last iteration
						kws=new String[keywords.length%1000];
						for(int j=0;j<kws.length;j++){
							kws[j]=keywords[j+startIndex];
						}
					} else {
						kws=new String[1000];
						for(int j=0;j<1000;j++){
							kws[j]=keywords[j+startIndex];
						}
						startIndex+=1000;
					}
				}
				HashMap<String, int[][]> kwVolume = msn.getKeywordVolumes(accountID, kws, startMonth);
				for(String s : keywords){
					int [][] res = kwVolume.get(s);
					if(res!=null){
						int sum=0;
						for (int i=0; i< res.length; i++){
							sum+=res[i][2];
							//System.out.println(res[i][0]+"-"+res[i][1]+":"+res[i][2]);
						}
						keywordVolumeMap.put(s,sum/res.length);
						System.out.println(s+":"+sum/res.length);
					} else{
						keywordVolumeMap.put(s,null);
					}

				}
			}
		} catch (MsnCloudException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return keywordVolumeMap;

	}

}