package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import org.w3c.tidy.Out;

public class createDataSet
{
	private NetflixData data;
	public createDataSet(NetflixData data)
	{
		this.data = data;
	}
	public int run(String outURL, int numInFile)
	{
		PrintWriter out = null;
		int num =0;
		try
		{
			
			FileWriter outFile = new FileWriter(outURL);
			out = new PrintWriter(outFile);
			boolean done = false;
			int movieID = 1;
			while(!done)
			{
				 HashMap<Integer, RatingDataObject> userData  = data.getUserDataForMovie(movieID);
				 if (userData != null)
				 {
					 Iterator<Integer> userIT = userData.keySet().iterator();
					 while (userIT.hasNext())
					 {
						 Integer userid = userIT.next();
						 RatingDataObject r = userData.get(userid);
						 out.println(String.valueOf(movieID) + "," + String.valueOf(userid) + "," + String.valueOf(r.getRating()));
						 num++;
					 }
					 
				 }
				 if (num >= numInFile)
				 {
					 done = true;
					 out.close();
				 }
				 else
				 {
					 movieID++;
				 }
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			if (out !=null) out.close();
			e.printStackTrace();
		}
		return num;
	}

}
