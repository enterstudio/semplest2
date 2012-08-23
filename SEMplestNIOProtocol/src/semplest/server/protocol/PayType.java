package semplest.server.protocol;

public enum PayType
{
	CREDIT_CARD(1, "CreditCard"),
	INVOICE(2, "Invoice"),
	NO_PAY(3, "NoPay");
	
	private final Integer pk;
	private final String name;
	
	private PayType(Integer pk, String name)
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
	
	public static PayType fromCode(final Integer code)
	{
		final PayType[] payTypes = PayType.values();
		for (final PayType payType : payTypes)
		{
			if (payType.getPk().equals(code))
			{
				return payType;
			}
		}
		return null;
	}
	
	public static PayType fromName(final String name)
	{
		final PayType[] payTypes = PayType.values();
		for (final PayType payType : payTypes)
		{
			if (payType.getName().equals(name))
			{
				return payType;
			}
		}
		return null;
	}
	
}
