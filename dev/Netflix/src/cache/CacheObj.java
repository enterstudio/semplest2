package cache;

import java.io.Serializable;
import java.util.ArrayList;

public class CacheObj  implements Serializable
{

	
	private static final long serialVersionUID = -2909459704034116023L;
	private ArrayList<Integer> data = new ArrayList<Integer>();
	public  ArrayList<Integer> getData()
	{
		return data;
	}
	public CacheObj(int i)
	{
		data.add(i);
	}
	
	public String toString(){
		return data.toString();
	}

}
