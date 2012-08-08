package semplest.server.protocol.msn;

import java.util.ArrayList;
import java.util.List;

public class MSNGeotargetObject
{
	private List<String> states;
	private List<String> metro;
	private List<String> city;
	private Integer totalSize = null;
	
	public MSNGeotargetObject()
	{
		states = new ArrayList<String>();
		metro = new ArrayList<String>();
		city = new ArrayList<String>();
	}

	public Integer getTotalSize()
	{
		return totalSize;
	}

	public void setTotalSize(Integer totalSize)
	{
		this.totalSize = totalSize;
	}

	public List<String> getStates()
	{
		return states;
	}

	public List<String> getMetro()
	{
		return metro;
	}

	public List<String> getCity()
	{
		return city;
	}
	
	public void addCity(String city)
	{
		this.city.add(city);
	}
	public void addState(String state)
	{
		this.states.add(state);
	}
	public void addMetro(String metro)
	{
		this.metro.add(metro);
	}

	public void setStates(List<String> states)
	{
		this.states = states;
	}

	public void setMetro(List<String> metro)
	{
		this.metro = metro;
	}

	public void setCity(List<String> city)
	{
		this.city = city;
	}
	
}
