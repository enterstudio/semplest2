package semplest.analysis.reports.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.server.protocol.adengine.ReportObject;

public class ReportUtils {
	
	public static void saveSerializedObject(Object obj, String filename) throws IOException{
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filename));
	    out.writeObject(obj);
	    out.close();
	}
	
	public static Object loadSerializedObject(String filename) throws IOException, ClassNotFoundException{
		ObjectInput in = new ObjectInputStream(new FileInputStream(filename));
		Object obj = in.readObject();
	    in.close();
	    return obj;
	}
	
	public static HashMap<String, ArrayList<ReportObject>> compareDataGoogleMsn(ReportObject[] reports){
		HashMap<String, ArrayList<ReportObject>> hashMap =  new HashMap<String, ArrayList<ReportObject>>();
		for(ReportObject rep : reports){
			if(hashMap.containsKey(rep.getKeyword())){
				hashMap.get(rep.getKeyword());
			}
		}
		
		return hashMap;
	}
	public static ArrayList<Double> createbids(double start, double end, double step){
		ArrayList<Double> bids = new ArrayList<Double>();
		Double bid = start;
		
		while(bid<end){
			bids.add(bid);
			bid = bid+step;
		}
		return bids;
	}
	
	public static void saveArrayListString(ArrayList<String> reportLines, String filePath) throws FileNotFoundException{
		PrintStream ps = new PrintStream(new FileOutputStream(new File(filePath)));
		for(String line : reportLines){
			ps.println(line);
		}
	}
	
	public static void combineFPCPCReports(String inReportPath1, String inReportPath2, String outReportPath) throws IOException{
		ArrayList<String> report1 = ReportUtils.readFile(inReportPath1);
		ArrayList<String> report2 = ReportUtils.readFile(inReportPath2);
		ArrayList<String> longestReport;
		ArrayList<String> shortestReport;
		ArrayList<String> newReport = new ArrayList<String>();
		int i=0;
		if(report1.size()>=report2.size()){
			longestReport = report1;
			shortestReport = report2;
			i=0;
		}else{
			longestReport = report2;
			shortestReport = report1;
			i=1;
		}
		for(String line : longestReport){
			String[] partslong =line.split(",");
			int j=0;
			for(j=0; j<shortestReport.size(); j++){
				String[] partsshort = shortestReport.get(j).split(",");
				if(shortestReport.get(j).contains(partslong[0]+","+partslong[1])){
					if(i==0){
						newReport.add(partslong[0]+","+partslong[1]+","+partslong[2]+","+partsshort[2]);
						break;
					}else{
						newReport.add(partslong[0]+","+partslong[1]+","+partsshort[2]+","+partslong[2]);
						break;
					}
				}
			}
			if(j>=shortestReport.size()){
				if(i==0){
					newReport.add(partslong[0]+","+partslong[1]+","+partslong[2]+", -1");
				}else{
					newReport.add(partslong[0]+","+partslong[1]+", -1,"+partslong[2]);
				}
			}
		}
		ReportUtils.saveArrayListString(newReport, outReportPath);
	}
	
	public static ArrayList<ArrayList<String>> trimArrayToMaxLength(ArrayList<String> arrayList, int maxLength){
		ArrayList<ArrayList<String>> trimArray = new ArrayList<ArrayList<String>>();
		int indexStart = 0;
		int indexEnd = maxLength-1;
		while(indexStart<arrayList.size()){
			if(arrayList.size()-indexStart <= maxLength){
				indexEnd = arrayList.size();
			}else{
				indexEnd = indexStart + maxLength-1;
			}
			trimArray.add(new ArrayList<String>(arrayList.subList(indexStart, indexEnd)));
			indexStart = indexEnd+1;
		}
		return trimArray;
	}
	
	public static ArrayList<String> readFile(String path) throws IOException{
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<String> relevantLines = new ArrayList<String>();
		FileInputStream fstream = new FileInputStream(path);
	    // Get the object of DataInputStream
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    while((line = br.readLine())!=null){
	    	lines.add(line);
	    }
	    return lines;
	}
	
	public static void saveReportDataCSV(ReportObject[] reps, String filePath) throws FileNotFoundException{
		PrintStream psData = new PrintStream(new FileOutputStream(new File(filePath+".dat")));
		PrintStream psKw = new PrintStream(new FileOutputStream(new File(filePath+".kw")));
		PrintStream psCol = new PrintStream(new FileOutputStream(new File(filePath+".col")));
		psCol.print("AverageCPC\nAveragePosition\nFirstPageCPC\nBidAmount\nCost\nClicks\nImpressions\nQualityScore\n");
		
		if(reps!=null){
			for(ReportObject rep : reps){
				if(rep.getAverageCPC()!=null)
					psData.print(rep.getAverageCPC().doubleValue()/1000000+", ");
				else
					psData.print(-1+", ");
				if(rep.getAveragePosition()!=null)
					psData.print(rep.getAveragePosition()+", ");
				else
					psData.print(-1+", ");
				if(rep.getFirstPageCPC()!=null)
					psData.print(rep.getFirstPageCPC().doubleValue()/1000000+", ");
				else
					psData.print(-1+", ");
				if(rep.getMicroBidAmount()!=null)
					psData.print(rep.getMicroBidAmount().doubleValue()/1000000+", ");
				else
					psData.print(-1+", ");
				if(rep.getMicroCost()!=null)
					psData.print(rep.getMicroCost().doubleValue()/1000000+", ");
				else
					psData.print(-1+", ");
				if(rep.getNumberClick()!=null)
					psData.print(rep.getNumberClick()+", ");
				else
					psData.print(-1+", ");
				if(rep.getNumberImpressions()!=null)
					psData.print(rep.getNumberImpressions()+", ");
				else
					psData.print(-1+", ");
				if(rep.getQualityScore()!=null)
					psData.print(rep.getQualityScore()+", ");
				else
					psData.print(-1+", ");
				psData.print("\n");
				psKw.println(rep.getKeyword()+", "+rep.getBidMatchType());
			}
		}
		
	}
	
	
	
}
