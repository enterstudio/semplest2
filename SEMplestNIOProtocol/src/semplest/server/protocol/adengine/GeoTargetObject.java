package semplest.server.protocol.adengine;

public class GeoTargetObject
{
	private String address;
	private String city;
	private String state;
	private String zip;
	private Double latitude;
	private Double longitude;
	private Double radius;
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getZip()
	{
		return zip;
	}
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public Double getLatitude()
	{
		return latitude;
	}
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}
	public Double getRadius()
	{
		return radius;
	}
	public void setRadius(Double radius)
	{
		this.radius = radius;
	}
}
