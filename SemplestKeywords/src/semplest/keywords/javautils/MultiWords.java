
package semplest.keywords.javautils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MultiWords {
	
	
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
	
	
	public static ArrayList<String> getMultiWords(String in, int [] n, int minCount){
		
		
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
				if (dictUtils.validWord(s)){ // if in dictionary
					key=MultiWords.shiftWords(buffer, s);
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

			int k=0;
			//for (String finalS : indexMap.keySet()){
			Iterator it = listEntrySet.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();
				if((Integer) entry.getValue() > minCount){
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

			
		} // for(int i=0; i<n.length; i++){
		
		return list;
	} // public static ArrayList<String> getMultiWords(String in, int [] n, int minCount)

}