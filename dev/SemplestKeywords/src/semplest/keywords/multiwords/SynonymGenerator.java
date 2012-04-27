package semplest.keywords.multiwords;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


public class SynonymGenerator
{
	private static String preUrl = "http://words.bighugelabs.com/api/2/febc1a7d186b265748dac5331d603093/";
	
	public static void main(String[] args)
	{
		String word = "auto";
		String url = preUrl + word + "/json";
		
		try
		{
			Client client = Client.create();
			 WebResource webResource = client.resource(url);
			 String s = webResource.get(String.class);
			 System.out.println(s);
			 JSONObject jsonObj = (JSONObject) JSONValue.parse(s);
			 System.out.println(jsonObj.get("noun").toString());
			 System.out.println();
			 
			 JSONObject syn = (JSONObject) JSONValue.parse(jsonObj.get("noun").toString());
			 System.out.println(syn.get("syn"));
		} 
		catch (Exception e)
		{
			System.out.println("No Synonyms not found for " + word);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
