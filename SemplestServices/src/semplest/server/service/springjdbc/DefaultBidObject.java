package semplest.server.service.springjdbc;

//import java.sql.Timestamp;
import java.util.Date;

public class DefaultBidObject
{
	private Long MicroDefaultBid;
	private Date DefaultBidEditedDate;
	public Long getMicroDefaultBid()
	{
		return MicroDefaultBid;
	}
	public void setMicroDefaultBid(Long microDefaultBid)
	{
		MicroDefaultBid = microDefaultBid;
	}
	public Date getDefaultBidEditedDate()
	{
		return DefaultBidEditedDate;
	}
	public void setDefaultBidEditedDate(Date defaultBidEditedDate)
	{
		DefaultBidEditedDate = defaultBidEditedDate;
	}

}
