package semplest.keywords.javautils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class look4Categories {

	/**
	 * This class will take a URL as an input, and it will try to find it in the dmoz database,
	 * if it succeeds, it will return a list of categories that contain it.
	 * args[0] : URL
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Path to the dmoz url file
		
		FileInputStream fstream = new FileInputStream("/semplest/data/dmoz/all/all.descs");
		String words="peanut butter";
	    ArrayList<String> desc1 = TextUtils.getWords( words );
	    ArrayList<String> desc = TextUtils.validWords( desc1 );
		ArrayList<String> categories;

		for (String descWord :desc){
			System.out.print(descWord+"\t");
		}
		
		System.out.print("\n");
		
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		String[] lineParts;
		//Read File Line By Line
		boolean flag = false;
		while ((strLine = br.readLine()) != null)   {
			ArrayList<String> line1 = TextUtils.getWords( strLine );
		    ArrayList<String> line2 = TextUtils.validWords( line1 );
			for (String word:desc){
				for(String lineword:line2){
					if(lineword.equals(word)){
						System.out.println("contains "+lineword);
						flag=true;
						break;
					}else{flag=false;}
				}
				if(!flag){break;}
			}
		  	if (flag){
		  		lineParts=strLine.split(":");
		  		System.out.println(lineParts[0]);
		  	}
		}
				
	}

}
