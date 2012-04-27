package semplest.client.test.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import semplest.server.protocol.ProtocolJSON;

public class TestJson
{

	private static  ObjectMapper mapper = new ObjectMapper();;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		HashMap<String, String> jsonMap = null;// new HashMap<String,String>();
		try
		{
			ProtocolJSON j = new ProtocolJSON();
			/*
			String jsonstr = "{ \"accountID\" : \"100\" ,  \"adgroupID\" : \"333\", \"myList\" : \"[ny,ct,nj]\"  }";
			
			jsonMap = j.getHashMapFromJson(jsonstr);
			Iterator<String> it = jsonMap.keySet().iterator();
			while (it.hasNext())
			{
				String key = it.next();
				System.out.println(key + ":" + jsonMap.get(key));
			}
			jsonstr = "{ \"accountID\" : 100 ,  \"adgroupID\" : 333  }";
			HashMap<String, Integer> jsonMap2 = j.getHashMapFromJson(jsonstr);
			
			it = jsonMap2.keySet().iterator();
			while (it.hasNext())
			{
				String key = it.next();
				System.out.println(key + ":" + jsonMap.get(key));
			}
			
			jsonstr = "[1,2,3,4]";
			ArrayList<Integer> array = j.getListFromJson(jsonstr); 
			for (int i =0; i < array.size(); i++)
			{
				System.out.println(array.get(i));
			}
			//Array of objects
			jsonstr= "[{\"color\": \"red\",	\"value\": \"#f00\"},{\"color\": \"green\",	\"value\": \"#0f0\"}]";
			ArrayList<LinkedHashMap<String, Object>> array2 = j.getListFromJson(jsonstr); 
			for (int i =0; i < array2.size(); i++)
			{
				System.out.println(array2.get(i));
				System.out.println(array2.get(i).get("color"));
			}
			*/
			Long accountId = 100L;
			Long campaignId = 333677L;
			HashMap<String, String> jsonHash = new HashMap<String, String>();
			jsonHash.put("accountId", Long.toString(accountId.longValue()));
			jsonHash.put("campaignId", Long.toString(campaignId.longValue()));
			String json = j.createJSONHashmap(jsonHash);
			System.out.println(json);
			HashMap<String,String> data = j.getHashMapFromJson(json);
			Iterator<String> it = data.keySet().iterator();
			while (it.hasNext())
			{
				String key = it.next();
				System.out.println(key + ":" + new Long(data.get(key)));
			}

			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
