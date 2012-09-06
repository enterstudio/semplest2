package semplest.ml.dmoz;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;





import semplest.ml.interfaces.TextAnalyzer;
import semplest.ml.text.LuceneAnalyzer;

public class DmozDataReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		


		
		
		TextAnalyzer analyzer = new LuceneAnalyzer();
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("//fs3/Semplest/data/dmoz/shopping/dmoz.8-12.1.1");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			int count=0;
			String [] cs = null;
			while ((strLine = br.readLine()) != null)   {
				// Print the content on the console
				//System.out.println (strLine);
				count++;
				System.out.println(count);
				String [] components = strLine.split(" : ");
				System.out.println(components[0]+": "+components.length);
				for(int i=1; i<components.length; i++){
					String c=components[i];
					cs = c.split(":::");
					//System.out.println(cs[0]);
					List<String> tokenized_string = analyzer.getTokens(cs[0]);
					//List<String> tokenized_string = analyzer.getStemmedTokens(cs[0]);
					for(String s : tokenized_string){
						System.out.println(s);
					}
				}
				//break;
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}


