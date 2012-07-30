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
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		GeoTargetObject other = (GeoTargetObject) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		}
		else if (!address.equals(other.address))
			return false;
		if (city == null)
		{
			if (other.city != null)
				return false;
		}
		else if (!city.equals(other.city))
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
		if (radius == null)
		{
			if (other.radius != null)
				return false;
		}
		else if (!radius.equals(other.radius))
			return false;
		if (state == null)
		{
			if (other.state != null)
				return false;
		}
		else if (!state.equals(other.state))
			return false;
		if (zip == null)
		{
			if (other.zip != null)
				return false;
		}
		else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "GeoTargetObject [address=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", radius=" + radius + "]";
	}
	
}
