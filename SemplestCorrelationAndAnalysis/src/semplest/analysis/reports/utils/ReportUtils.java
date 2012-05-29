package semplest.analysis.reports.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
	
	public static ArrayList<Double> createbids(double start, double end, double step){
		ArrayList<Double> bids = new ArrayList<Double>();
		Double bid = start;
		
		while(bid<end){
			bids.add(bid);
			bid = bid+step;
		}
		return bids;
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
				psKw.println(rep.getKeyword());
			}
		}
		
	}
	
	
	
}
