package semplest.server.service.springjdbc;

import java.sql.Timestamp;

public class DefaultBidObject
{
	private Long MicroDefaultBid;
	private Timestamp DefaultBidEditedDate;
	public Long getMicroDefaultBid()
	{
		return MicroDefaultBid;
	}
	public void setMicroDefaultBid(Long microDefaultBid)
	{
		MicroDefaultBid = microDefaultBid;
	}
	public Timestamp getDefaultBidEditedDate()
	{
		return DefaultBidEditedDate;
	}
	public void setDefaultBidEditedDate(Timestamp defaultBidEditedDate)
	{
		DefaultBidEditedDate = defaultBidEditedDate;
	}

}
