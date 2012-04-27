package data;

import java.util.ArrayList;

import cache.EhCache;

public class CorrelationJobData
{
	private int len;
	private int start;
	private int end;
	private EhCache cache;
	private ArrayList<Integer> movieIDList;
	
	public int getLen()
	{
		return len;
	}
	public void setLen(int len)
	{
		this.len = len;
	}
	public EhCache getCache()
	{
		return cache;
	}
	public void setCache(EhCache cache)
	{
		this.cache = cache;
	}
	public ArrayList<Integer> getMovieIDList()
	{
		return movieIDList;
	}
	public void setMovieIDList(ArrayList<Integer> movieIDList)
	{
		this.movieIDList = movieIDList;
	}
	public int getStart()
	{
		return start;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getEnd()
	{
		return end;
	}
	public void setEnd(int end)
	{
		this.end = end;
	}

}
