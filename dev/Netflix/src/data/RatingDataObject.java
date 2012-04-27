package data;

import java.io.Serializable;

public class RatingDataObject  implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8850503008351619966L;
	private short rating;
	private int ratingDateFromStart;
	
	public RatingDataObject(short aRating, int dateFromSrart)
	{
		this.rating= aRating;
		this.ratingDateFromStart = dateFromSrart;
	}
	public short getRating()
	{
		return rating;
	}
	public int getRatingDateFromStart()
	{
		return ratingDateFromStart;
	}
	

}
