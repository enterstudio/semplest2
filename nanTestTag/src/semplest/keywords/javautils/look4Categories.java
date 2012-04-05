package semplest.keywords.javautils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import org.htmlparser.util.ParserException;

public class look4Categories {

	/**
	 * This class will use dmoz search to get the categories for some keywords, generates a file with the categories
	 * args[0] = input keywords file;
	 * args[1] = report file; (optional)
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//Categories are retrieved and scored. Everytime a category is found it is added to a HashMap with its score.
		//The score will be 100-position in search. Every time a category is repeated, its score will be added for each of 
		// the positions where it is found. Finally, categories are ranked.
		HashMap<String,Double> categMap;
		ValueComparator bvcAux;
		TreeMap<String,Double> sorted_opt;
		int results=100; //number of results to obtain from dmoz search
		int maxiter=10; //maximum number of iterations
		int maxtopresults =5; //Maximum number of results to report
		int topresults;
		//File containing sorted words for each category
		String wordsFile = "/semplest/data/dmoz/all/hCounts.txt.tw";
		//String wordsFile = "/semplest/data/dmozTest/test";
		ArrayList<String> patternL=new ArrayList<String>();
		DataInputStream in;
		BufferedReader br;
		String strLine;
		PrintStream stdout = System.out;
		System.setOut(new PrintStream(new FileOutputStream("/semplest/lluis/dmozsearchresults.txt")));
		
		// Read keywords to test
		in = new DataInputStream(new FileInputStream(args[0]));
		br = new BufferedReader(new InputStreamReader(in));
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
				patternL.add(strLine);
		}

		
		for(String pattern:patternL){
			categMap = new HashMap<String, Double>();
			bvcAux = new ValueComparator(categMap);
			sorted_opt = new TreeMap<String,Double>(bvcAux);
			pattern=pattern.replaceAll("\\s", "+");
			System.out.println("Keywords evaluated: "+pattern);
			String text = TextUtils.HTMLText("http://www.dmoz.org/search?q="+pattern);
			String categories;
			Double value;
			int n=0;
			int numresults=0;
			while(numresults<results && n<maxiter){
				String[] lines = text.split("\n");
				for(int i=0;i<lines.length;i++){
					if(numresults>=results) break;
					if(lines[i].contains("--")){
						categories = lines[i+1];
						categories = categories.replaceAll("\\s", "");
						categories = categories.toLowerCase();
						categories = categories.replaceAll(":", "/");
						categories = "top/"+categories;
						System.out.println(categories);
						if(catUtils.validcat(categories)){
							if(categMap.containsKey(categories)){
								value=(Double) categMap.get(categories);
								value=value+new Double(1); //Set new score for category
							} else{
								value= new Double(results-numresults);
							}
							categMap.put(categories, value);
							//System.out.println(value+"\t"+categories);
							numresults++;
						}
					}
				}
				n++;
				Thread.sleep(1000);
				text = TextUtils.HTMLText("http://www.dmoz.org/search?q="+pattern+"&start="+n*20+"&type=next&all=no&cat=");
			}
			/*
			sorted_opt.putAll(categMap);
			Set<String> keys = sorted_opt.keySet();
			in = new DataInputStream(new FileInputStream(wordsFile));
			br = new BufferedReader(new InputStreamReader(in));
			String[] lines = new String[maxtopresults];
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				String[] splitline = strLine.split(":");
				topresults =0;
				splitline[0]=splitline[0].replaceAll("_","");
				for(String key:keys){
					if (key.equals(splitline[0])){
						lines[topresults] = strLine;
					}
					topresults++;
					//System.out.println("key"+key);
					//System.out.println("category "+splitline[0]);
					//System.out.println("line "+strLine);
					if (topresults>=maxtopresults) break;
				}
			}
			for (int v=0;v<lines.length;v++){
				
				System.out.println(lines[v]);
			}
			System.out.println("\n\n");*/
		}
		System.setOut(stdout);
		System.out.println("Report finished");
		
	}
	
}
