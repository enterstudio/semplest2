package semplest.server.protocol;

public enum EmailType
{
	CHANGE_PASSWORD (1, "ChangePassword"),
	CREDIT_CARD_DECLINED (2, "CreditCardDeclined"),
	EXPIRED_ACTIVATION_IDS (3, "ExpiredActivationIds"),
	FORGOTTEN_PASSWORD (4, "ForgottenPassword"),
	PROMOTION_NOT_STARTED (5, "PromotionNotStarted"),
	WELCOME_EMAIL_CHILD (6, "WelcomeEmailChild"),
	WELCOME_EMAIL_PARENT (7, "WelcomeEmailParent"),
	WELCOME_EMAIL_NON_PARENT_USER (8, "WelcomeEmailNonParentUser");
	
	private final Integer code;
	private final String name;
	
	EmailType(final Integer code, final String name)
	{
		this.code = code;
		this.name = name;
	}

	public Integer getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}
	
	public static EmailType fromCode(final Integer code)
	{
		final EmailType[] emailTypes = EmailType.values();
		for (final EmailType emailType : emailTypes)
		{
			if (emailType.getCode().equals(code))
			{
				return emailType;
			}
		}
		return null;
	}
	
}
