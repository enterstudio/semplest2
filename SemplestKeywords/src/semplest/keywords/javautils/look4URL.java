package semplest.keywords.javautils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class look4URL
{

	/**
	 * This class will take a URL as an input, and it will try to find it in the dmoz database, if it succeeds, it will return a list of categories that
	 * contain it. args[0] : URL
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		// Path to the dmoz url file

		FileInputStream fstream = new FileInputStream("/semplest/data/dmoz/all.urls");
		String url = "-- http://www.laserblazers.com ";
		String[] urlparts = url.split("/");
		String mainURL = url;
		List<String> categories;
		for (String part : urlparts)
		{
			if (!part.contains("http:") && part.length() != 0)
			{
				mainURL = part;
				break;
			}
		}
		System.out.println(mainURL);
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		String[] lineParts;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null)
		{
			if (strLine.contains(mainURL))
			{
				lineParts = strLine.split(":");
				System.out.println(lineParts[0]);
			}
		}

	}

}
