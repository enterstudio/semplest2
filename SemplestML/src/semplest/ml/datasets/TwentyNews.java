package semplest.ml.datasets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwentyNews {

	public static String getText(File f) {
		
		StringBuffer buff = new StringBuffer();
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(f);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			//Read File Line By Line
			boolean header = true;
			//System.out.print("\n"+f+": ");
			
			while ((strLine = br.readLine()) != null)   {
				if(strLine.startsWith("Lines:")){
					header = false;
					continue;
				}
				if(!header){
					//System.out.print(strLine+" ");
					buff.append(strLine+" ");
				}
			}
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		return buff.toString();

	}

	public static List<List<File>> getFileClasses(String trainPath, String[] classes) {
		List<List<File>> fileClasses = new ArrayList<List<File>>();
		for(String c : classes){
			List<File> fileClass = new ArrayList<File>();
			File baseClass = new File(trainPath+c);
			for (File f : baseClass.listFiles()) {
				fileClass.add(f);
			}
			fileClasses.add(fileClass);
		}
		return fileClasses;
		
	}
}
