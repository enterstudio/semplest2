package semplest.server.protocol.msn;

public class MSNGeotargetObject
{
	private String Name;
	private String MSNName;
	private Double latitude;
	private Double longitude;
	
	public MSNGeotargetObject() {}
	
	public MSNGeotargetObject(String name, String mSNName, Double latitude, Double longitude)
	{
		Name = name;
		MSNName = mSNName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
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
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MSNName == null) ? 0 : MSNName.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MSNGeotargetObject other = (MSNGeotargetObject) obj;
		if (MSNName == null)
		{
			if (other.MSNName != null)
				return false;
		}
		else if (!MSNName.equals(other.MSNName))
			return false;
		if (Name == null)
		{
			if (other.Name != null)
				return false;
		}
		else if (!Name.equals(other.Name))
			return false;
		if (latitude == null)
		{
			if (other.latitude != null)
				return false;
		}
		else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null)
		{
			if (other.longitude != null)
				return false;
		}
		else if (!longitude.equals(other.longitude))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "MSNGeotargetObject [Name=" + Name + ", MSNName=" + MSNName + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
