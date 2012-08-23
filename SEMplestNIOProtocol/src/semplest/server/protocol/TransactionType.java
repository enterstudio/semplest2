package semplest.server.protocol;

public enum TransactionType
{
	MEDIA_SPEND(1, "MediaSpend"),
	SEMPLEST_MEDIA_SPEND_FEE(2, "SemplestMediaSpendFee"),
	SEMPLEST_FLAT_FEE(3, "SemplestFlatFee");
	
	private final Integer pk;
	private final String name;
	
	private TransactionType(Integer pk, String name)
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
	
	public static TransactionType fromCode(final Integer code)
	{
		final TransactionType[] types = TransactionType.values();
		for (final TransactionType type : types)
		{
			if (type.getPk().equals(code))
			{
				return type;
			}
		}
		return null;
	}
	
	public static TransactionType fromName(final String name)
	{
		final TransactionType[] types = TransactionType.values();
		for (final TransactionType type : types)
		{
			if (type.getName().equals(name))
			{
				return type;
			}
		}
		return null;
	}
}
