package semplest.keywords.multiwords;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import semplest.keywords.javautils.ioUtils;

public class utils {
	
	public static void tmpToSemplest(String inFileName, String outFileName){
		ArrayList<String> lines = ioUtils.readFile(inFileName);
		String [] tuples;
		StringBuilder buffer2, buffer3;
		int count2, count3;
		
		FileWriter fstream2;
		BufferedWriter out2;
		
		FileWriter fstream3;
		BufferedWriter out3;
		
		try {
			File file =new File(outFileName+".2"); // biwords
			file.delete();
			file.createNewFile();
			
			fstream2 = new FileWriter(outFileName+".2",true);
			out2 = new BufferedWriter(fstream2);

			File file2 =new File(outFileName+".3"); // triwords
			file2.delete();
			file2.createNewFile();
			
			fstream3 = new FileWriter(outFileName+".3",true);
			out3 = new BufferedWriter(fstream3);

			for (String line : lines){
				
				line=line.replaceFirst("^(\\S+)....", "$1|");
				line=line.replaceAll(" \\*\\* ", "|");
				line=line.replaceAll(" ", "+");
				line=line.replaceAll("\\|", " ");
							
				tuples=line.split("\\s+");
							
				buffer2 = new StringBuilder();
				buffer3= new StringBuilder();
				count2=0; count3=0;
				for (int i=1;i<tuples.length;i++){
					if(tuples[i].split("\\+").length==2){
						buffer2.append(tuples[i]+" ");
						count2++;
					} else {
						buffer3.append(tuples[i]+" ");
						count3++;
					}
				}
				
				out2.write(tuples[0]+":"+count2+" "+buffer2+"\n");
				out3.write(tuples[0]+":"+count3+" "+buffer3+"\n");
							
				}

			out2.close();
			out3.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String category = "arts";
//		tmpToSemplest("/semplest/subhojit/data/dmoz/FullExtText/"+category+".txt","/tmp/"+category+".txt");
		tmpToSemplest("/semplest/subhojit/data/dmoz/FullExtText/"+category+".txt","/semplest/data/dmoz/multiwords/"+category+".txt");

	}

}
