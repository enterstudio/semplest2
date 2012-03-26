package semplest.keywords.multiwords;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import semplest.keywords.javautils.MultiWords;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.scalautils.*;


public class ExtTextFetcherDmoz {
	
	
	private String inFileName;
	private String outFileName;
	private String patternInCategory;
	
	
	public ExtTextFetcherDmoz(String in, String out, String pattern){
		inFileName=in;
		outFileName=out;
		patternInCategory=pattern;
	}
	
	public ExtTextFetcherDmoz(String in, String out){
		inFileName=in;
		outFileName=out;
		patternInCategory=""; // this means all categories to be processed
	}
	
	public void fetchMultiWords(int [] n, int minCount){
		
	    Crawler c = new Crawler(); 

		ArrayList<String> lines = ioUtils.readFile(inFileName);
		HashSet<String> tags = new HashSet<String>();
		String urls, tag;
		
		String [] results;
		
		FileWriter fstream;
		BufferedWriter out;
	
		FileWriter fstream2;
		BufferedWriter out2;
		
		ArrayList<String> list=null;
		
		int totalJobs, doneSoFar=0;


		if (patternInCategory.equals("")){

			for (String line: lines){
				urls=line.replaceFirst("^\\S+ : ", "");
				tag=line.replaceFirst(" :.*$", "");
				tags.add(tag);
				c.add(tag,urls);
			}
		} else {

//			int k=0;
			for (String line: lines){
				tag=line.replaceFirst(" :.*$", "");
				if (tag.contains(patternInCategory)){
					urls=line.replaceFirst("^\\S+ : ", "");
					tags.add(tag);
					c.add(tag,urls);
//					k++;
//					if(k==5)
//						break;
				}
			}
		}
		
		totalJobs=tags.size();
		
		// create and empty file
		try {
			File file =new File(outFileName);
			file.delete();
			file.createNewFile();

			// for text
			File fileText =new File(outFileName+".orig");
			fileText.delete();
			fileText.createNewFile();
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		// continue until all are done
		while(!tags.isEmpty()) {
			
			try{ // try:sleep
				Thread.sleep(3000);
			} catch( Exception e) {
				e.printStackTrace();
			} // try: sleep
			
			// fetch from Worker
			results = c.fetch();
			if (results.length > 0) {				
				System.out.println("I am happy. I found "+ results.length+" results...................");

				try { // try: IO
					fstream = new FileWriter(outFileName,true);
					out = new BufferedWriter(fstream);

					fstream2 = new FileWriter(outFileName+".orig",true);
					out2 = new BufferedWriter(fstream2);

					for(int i=0;i<results.length; i++){  // for every unit of work
						// extract the tag first
						tag=results[i].replaceAll(" .*", "");
						out.write(tag);
						list=MultiWords.getMultiWords(results[i], n, minCount);
						
						out2.write(results[i]+"\n");
						
						for (int j=0;j<n.length;j++){
							out.write(" ** "+list.get(j));
						}
						out.write("\n");
						doneSoFar++;
						tags.remove(tag);
						System.out.println("MultiWordExtraction: "+doneSoFar+" out of "+totalJobs+" done so far. Waiting for "+tags.size()+" jobs to complete.");
					}
					
					out.close();
					out2.close();

				} catch (IOException e) {
					e.printStackTrace();
				} // try: IO
			
			} else
				System.out.println("I am sad. I didn't find anything....... still waiting for "+tags.size()+" jobs.");
	
		} // while
		
	}
	

public void fetchMultiWordsSubsequent(int [] n, int minCount){
		
	    Crawler c = new Crawler(); 

		ArrayList<String> lines = ioUtils.readFile(inFileName);
		
		HashSet<String> tags = new HashSet<String>();

		String urls, tag;
		
		String [] results;
		
		FileWriter fstream;
		BufferedWriter out;
	
		FileWriter fstream2;
		BufferedWriter out2;
		
		
		ArrayList<String> doneLines = ioUtils.readFile(outFileName);
		HashSet<String> doneTags = new HashSet<String>();
		for (String line : doneLines){
			line=line.replaceAll(" .*$","");
			doneTags.add(line);
		}
		
		
		
		ArrayList<String> list=null;
		
		int totalJobs, doneSoFar=0;


		if (patternInCategory.equals("")){

			for (String line: lines){
				urls=line.replaceFirst("^\\S+ : ", "");
				tag=line.replaceFirst(" :.*$", "");
				if(!doneTags.contains(tag)){						
					tags.add(tag);
					c.add(tag,urls);
				}
			}
		} else {

			for (String line: lines){
				tag=line.replaceFirst(" :.*$", "");
				if (tag.contains(patternInCategory)){
					urls=line.replaceFirst("^\\S+ : ", "");
					if(!doneTags.contains(tag)){						
						tags.add(tag);
						c.add(tag,urls);
					}

				}
			}
		}
				
		totalJobs=tags.size();
		

		
		// continue until all are done
		while(!tags.isEmpty()) {
			
			try{ // try:sleep
				Thread.sleep(3000);
			} catch( Exception e) {
				e.printStackTrace();
			} // try: sleep
			
			// fetch from Worker
			results = c.fetch();
			if (results.length > 0) {				
				System.out.println("I am happy. I found "+ results.length+" results...................");

				try { // try: IO
					fstream = new FileWriter(outFileName,true);
					out = new BufferedWriter(fstream);

					fstream2 = new FileWriter(outFileName+".orig.2",true);
					out2 = new BufferedWriter(fstream2);

					for(int i=0;i<results.length; i++){  // for every unit of work
						// extract the tag first
						tag=results[i].replaceAll(" .*", "");
						out.write(tag);
						list=MultiWords.getMultiWords(results[i], n, minCount);
						
						out2.write(results[i]+"\n");
						
						for (int j=0;j<n.length;j++){
							out.write(" ** "+list.get(j));
						}
						out.write("\n");
						doneSoFar++;
						tags.remove(tag);
						System.out.println("MultiWordExtraction: "+doneSoFar+" out of "+totalJobs+" done so far. Waiting for "+tags.size()+" jobs to complete.");
					}
					
					out.close();
					out2.close();

				} catch (IOException e) {
					e.printStackTrace();
				} // try: IO
			
			} else
				System.out.println("I am sad. I didn't find anything....... still waiting for "+tags.size()+" jobs.");
	
		} // while
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		int [] n = {2,3};
		int minCount = 3;
		String category, outFile;
		String inFile="/semplest/data/dmoz/all.urls";
		
		switch (args.length){
		default: 
			throw new Exception("Proper arguments are not provided!!");
		case 3:
			category=args[0];
			outFile=args[1]+"/"+category+".txt";
			inFile=args[2];
		case 2:
			category=args[0];
			outFile=args[1]+"/"+category+".txt";
		}

		ExtTextFetcherDmoz fetcher = new ExtTextFetcherDmoz(inFile,outFile,"top/"+category);
//		fetcher.fetchMultiWords(n,minCount);
		fetcher.fetchMultiWordsSubsequent(n,minCount);
		System.out.println("Yahoo!!! Done with all the fetching for category "+category+"!!! I am feeling great!!");

		System.exit(0);

	}

}
