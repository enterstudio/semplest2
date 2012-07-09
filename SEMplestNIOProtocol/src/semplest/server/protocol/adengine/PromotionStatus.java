package semplest.server.protocol.adengine;

public enum PromotionStatus
{
	PENDING (1, "Pending"),
	LIVE    (2, "Live"),
	PAUSED  (3, "Paused"),
	ENDED   (4, "Live"),
	DELETED (5, "Deleted");
	
	private final Integer pk;
	private final String name;
	
	PromotionStatus(final Integer pk, final String name)
	{
		this.pk = pk;
		this.name = name;
	}

	public Integer getPk()
	{
		return pk;
	}

	public String getName()
	{
		return name;
	}
	
	public static PromotionStatus fromValue(final int pk)
    {
        for (PromotionStatus type: PromotionStatus.values())
        {
            if (type.getPk() == pk)
            {
                return type;
            }
        }
        throw new IllegalArgumentException("No PromotionStatus found for PK [" + pk + "]");
    }
	
	public static PromotionStatus fromValue(final String name)
    {
        for (PromotionStatus type: PromotionStatus.values())
        {
            if (type.getName().equals(name))
            {
                return type;
            }
        }
        throw new IllegalArgumentException("No PromotionStatus found for Name [" + name + "]");
    }
	
	public static Boolean isValidPromotionStatus(final int pk)
	{
		for (PromotionStatus type: PromotionStatus.values())
        {
            if (type.getPk() == pk)
            {
                return true;
            }
        }
        return false;
	}
	
	public static Boolean isValidPromotionStatus(final String name)
	{
		for (PromotionStatus type: PromotionStatus.values())
        {
            if (type.getName().equals(name))
            {
                return true;
            }
        }
        return false;
	}
	
}
