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
		StringBuilder buffer2, buffer3, buffer4, buffer5;
		int count2, count3, count4, count5;
		
		FileWriter fstream2;
		BufferedWriter out2;
		
		FileWriter fstream3;
		BufferedWriter out3;
		
		FileWriter fstream4;
		BufferedWriter out4;	
		
		FileWriter fstream5;
		BufferedWriter out5;
		
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
			
			File file4 =new File(outFileName+".4"); // biwords
			file4.delete();
			file4.createNewFile();
			
			fstream4 = new FileWriter(outFileName+".4",true);
			out4 = new BufferedWriter(fstream4);
			
			File file5 =new File(outFileName+".5"); // biwords
			file5.delete();
			file5.createNewFile();
			
			fstream5 = new FileWriter(outFileName+".5",true);
			out5 = new BufferedWriter(fstream5);
			
			

			for (String line : lines){
				
				line=line.replaceFirst("^(\\S+)....", "$1|");
				line=line.replaceAll(" \\*\\* ", "|");
				line=line.replaceAll(" ", "+");
				line=line.replaceAll("\\|", " ");
							
				tuples=line.split("\\s+");
							
				buffer2 = new StringBuilder();
				buffer3= new StringBuilder();
				buffer4= new StringBuilder();
				buffer5= new StringBuilder();

				count2=0; count3=0; count4=0; count5=0;
				for (int i=1;i<tuples.length;i++){
					switch (tuples[i].split("\\+").length) {
		            case 2:  
						buffer2.append(tuples[i]+" ");
						count2++;
						break;
		            case 3:
						buffer3.append(tuples[i]+" ");
						count3++;
						break;
		            case 4:
						buffer4.append(tuples[i]+" ");
						count4++;
						break;
		            case 5:
						buffer5.append(tuples[i]+" ");
						count5++;
						break;
					default:
						System.out.println("Found length: "+tuples[i].split("\\+").length);
						break;
					}
							
						
				}
				
				out2.write(tuples[0]+":"+count2+" "+buffer2+"\n");
				out3.write(tuples[0]+":"+count3+" "+buffer3+"\n");
				out4.write(tuples[0]+":"+count4+" "+buffer4+"\n");
				out5.write(tuples[0]+":"+count5+" "+buffer5+"\n");
							
				}

			out2.close();
			out3.close();
			out4.close();
			out5.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String category = "reference";
//		tmpToSemplest("/semplest/subhojit/data/dmoz/FullExtText/"+category+".txt","/tmp/"+category+".txt");
//		tmpToSemplest("/semplest/subhojit/data/dmoz/FullExtText/"+category+".txt","/semplest/data/dmoz/multiwords/"+category+".txt");
//		tmpToSemplest("/tmp/subhojit.txt","/semplest/data/dmoz/multiwords/all.txt");


	}

}
