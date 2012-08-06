package semplest.server.service.springjdbc;

public class MSNGeotargetObject
{
	private String Name;
	private String MSNName;
	private Double latitude;
	private Double longitude;
	public String getMSNName()
	{
		return MSNName;
	}
	public void setMSNName(String mSNName)
	{
		MSNName = mSNName;
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
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
}
