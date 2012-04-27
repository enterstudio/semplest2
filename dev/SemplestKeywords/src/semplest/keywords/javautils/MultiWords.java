
package semplest.keywords.javautils;

import java.util.ArrayList;
import java.util.HashMap;

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
		
		String [] words = in.split("\\s+");
		
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
			
			
			for (String finalS : indexMap.keySet()){
				if(indexMap.get(finalS) > minCount){
					out.append(finalS+":"+indexMap.get(finalS)+"|");
				}
			}
			if(out.length()>0) // if there is anything written at all!
				out.setLength(out.length()-1); // delete the last 
			
			list.add(out.toString());
			
		} // for(int i=0; i<n.length; i++){
		
		return list;
	} // public static ArrayList<String> getMultiWords(String in, int [] n, int minCount)

}