package semplest.keywordsnonprod.multiwords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

import semplest.keywords.properties.ProjectProperties;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class GenGramsFromCrawlMSNVolFiltered {
	
	public static void parseFile(String inFile, String outFile, int minCount, int n){
		
		try {

			FileInputStream fstream = new FileInputStream(inFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			
			
			
			
			FileWriter fstreamW = new FileWriter(outFile);
			BufferedWriter out = new BufferedWriter(fstreamW);

			
			String strLine;
			String s;
			
			MsnCloudServiceImpl msn = new MsnCloudServiceImpl();

			//HashSet<String> categorySet = new HashSet<String>();
			//int i=0;
			while ((strLine = br.readLine()) != null)   {
				//i++;
				String [] segments = strLine.split(" : ");
				//if(!categorySet.contains(segments[0]) && segments.length>1){
				if(segments.length>1){

					//categorySet.add(segments[0]);
					s=MultiWordsMSNVolFiltered.getMultiWords(segments[1].toLowerCase(), n, minCount,msn);
					//System.out.print(i+": "+segments[0]+":");
					out.write(segments[0]+":");
					//System.out.println(s);
					out.write(s+"\n");

//					if(i==5){
//						break;
//					}
				} // if(segments.length>1)
			}
			in.close();
			out.close();

		} catch (Exception e) {//Catch exception if any
			e.printStackTrace();
			//System.err.println("Error: " + e.getMessage());
		}
		
	}

	public static void main(String args[])
	{
		try {
			ProjectProperties projProp = new ProjectProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String inFile="//fs3/Semplest/data/dmoz/"+args[0]+"/hTest.2";
//		String outFile="//fs3/Semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/"+args[0]+"."+args[1];
		String inFile="/semplest/data/dmoz/"+args[0]+"/hTest.2";
		String outFile="/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/"+args[0]+"."+args[1];
		int minCount = 2;
		GenGramsFromCrawlMSNVolFiltered.parseFile(inFile, outFile,minCount,Integer.valueOf(args[1]));
		
//		try{
//			FileInputStream fstream = new FileInputStream(inFile);
//			DataInputStream in = new DataInputStream(fstream);
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			String strLine;
//			int i=0;
//			while ((strLine = br.readLine()) != null) {
//				i++;
//				String [] spl = strLine.split("\\s+");
//				System.out.println(i+": "+spl[0]+": "+spl.length);
//			}
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		
	}
}

