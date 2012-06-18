package semplest.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import semplest.server.protocol.KeywordIdRemoveOppositePair;

import com.google.api.adwords.v201109.cm.TextAd;
import com.google.gson.reflect.TypeToken;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountFinancialStatus;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountType;
import com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType;
import com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType;
import com.microsoft.adcenter.api.customermanagement.Entities.Customer;
import com.microsoft.adcenter.api.customermanagement.Entities.CustomerFinancialStatus;
import com.microsoft.adcenter.api.customermanagement.Entities.CustomerLifeCycleStatus;
import com.microsoft.adcenter.api.customermanagement.Entities.Industry;
import com.microsoft.adcenter.api.customermanagement.Entities.LCID;
import com.microsoft.adcenter.api.customermanagement.Entities.LanguageType;
import com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType;
import com.microsoft.adcenter.api.customermanagement.Entities.PersonName;
import com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion;
import com.microsoft.adcenter.api.customermanagement.Entities.ServiceLevel;
import com.microsoft.adcenter.api.customermanagement.Entities.User;
import com.microsoft.adcenter.api.customermanagement.Entities.UserLifeCycleStatus;

public final class SemplestUtils
{
	public static final DateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	public static final DateFormat DATE_FORMAT_YYYYMMDD_HHmmss = new SimpleDateFormat("yyyyMMdd HHmmss");
	public static final Long GOOGLE_MONEY_UNIT = 1000000L;
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final Type TYPE_LIST_OF_STRINGS = new TypeToken<List<String>>(){}.getType();
	public static final Type TYPE_LIST_OF_INTEGERS = new TypeToken<List<Integer>>(){}.getType();
	public static final Type TYPE_LIST_OF_LONGS = new TypeToken<List<Long>>(){}.getType();
	public static final Type TYPE_MAP_OF_STRING_TO_STRING = new TypeToken<Map<String, String>>(){}.getType();
	public static final Type TYPE_LIST_OF_KEYWORD_ID_REMOVE_OPPOSITE_PAIRS = new TypeToken<List<KeywordIdRemoveOppositePair>>(){}.getType();	
	public static final List<Character> ALLOWED_CHARS = Arrays.asList('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','-');
	public static final Character SUBSTITUTION_CHARACTER = '-';
	public static final Integer USER_NAME_MIN_LENGTH = 6;
	public static final Integer USER_NAME_MAX_LENGTH = 20;
	public static final Random RANDOM = new Random();
	
	public static String getRandomAllowedChars(final int lengthGap, List<Character> allowedChars)
	{
		final StringBuilder sb = new StringBuilder();
		final int numAllowedPossibleChars = allowedChars.size();
		for (int i = 0; i < lengthGap; ++i)
		{
			final int randomIndex = RANDOM.nextInt(numAllowedPossibleChars);
			final Character c = allowedChars.get(randomIndex);
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static final String getStringOfSpecifiedLength(final String s, final int minLength, final int maxLength)
	{			
		if (s.length() < minLength)
		{
			final int lengthGap = minLength - s.length();
			final String randomCharsOfLengthGap = getRandomAllowedChars(lengthGap, ALLOWED_CHARS);
			final String result = s + randomCharsOfLengthGap;
			return result;
		}
		else if (s.length() > maxLength)
		{
			final int lengthGap = s.length() - maxLength;
			final String result = s.substring(0, s.length() - lengthGap);
			return result;
		}
		else
		{
			return s;
		}
	}
	
	public static final String getLegalUserName(final String rawUserName)
	{			
		final String sanitizedRawString = sanitizeString(rawUserName);
		return getStringOfSpecifiedLength(sanitizedRawString, USER_NAME_MIN_LENGTH, USER_NAME_MAX_LENGTH);
	}
	
	public static final String sanitizeString(final String s)
	{			
		if ("".equals(getTrimmedNonNullString(s)))
		{
			return "";
		}
	    final char[] charArray = s.trim().toCharArray();
	    final StringBuilder result = new StringBuilder();
	    for (char c : charArray)
	    {
	    	if (ALLOWED_CHARS.contains(c))
	    	{
	    		result.append(c);
	    	}
	    	else
	    	{
	    		result.append(SUBSTITUTION_CHARACTER);
	    	}
	    }
	    return result.toString();
	}
	
	public static final String getMsnAccountString(final Account account)
	{
		final AccountFinancialStatus accountFinancialStatus = account.getAccountFinancialStatus();
		final AccountLifeCycleStatus accountLifeCycleStatus = account.getAccountLifeCycleStatus();
		final AccountType accountType = account.getAccountType();
		final Long billToCustomerId = account.getBillToCustomerId();
		final String countryCode = account.getCountryCode();
		final CurrencyType currencyType = account.getCurrencyType();
		final Long id = account.getId();
		final LanguageType languageType = account.getLanguage();
		final Long lastModifiedByUserId = account.getLastModifiedByUserId();
		final Calendar lastModifiedTime = account.getLastModifiedTime();
		final String name = account.getName();
		final String number = account.getNumber();
		final Long parentCustomerId = account.getParentCustomerId();
		final Long paymentMethodId = account.getPaymentMethodId();
		final PaymentMethodType paymentMethodType = account.getPaymentMethodType();
		final Long primaryUserId = account.getPrimaryUserId();
		return "Account[id=" + id + ",accountFinancialStatus=" + accountFinancialStatus + ",accountLifeCycleStatus=" + accountLifeCycleStatus + ",accountType=" + accountType + ",billToCustomerId=" + billToCustomerId + 
				",countryCode=" + countryCode + ",currencyType=" + currencyType + ",languageType=" + languageType + ",lastModifiedByUserId=" + lastModifiedByUserId + ",lastModifiedTime=" + lastModifiedTime + 
				",name=" + name + ",number=" + number + ",parentCustomerId=" + parentCustomerId + ",paymentMethodId=" + paymentMethodId + ",paymentMethodType=" + paymentMethodType + ",primaryUserId=" + primaryUserId +"]";
	}
	
	
	public static final String getMsnUserString(final User user)
	{
		final ApplicationType applicationType = user.getCustomerAppScope();
		final Long id = user.getId();
		final String jobTitle = user.getJobTitle();
		final LCID lcid = user.getLcid();
		final PersonName personName = user.getName();
		final String firstName = personName.getFirstName();
		final String middleName = personName.getMiddleInitial();
		final String lastName = personName.getLastName();
		final String password = user.getPassword();
		final String secretQuestion = user.getSecretQuestion().getValue();
		final String secretAnswer = user.getSecretAnswer();		
		final UserLifeCycleStatus userLifeCycleStatus = user.getUserLifeCycleStatus();
		final String userName = user.getUserName();
		return "User[id=" + id + ",applicationType=" + applicationType + ",jobTitle=" + jobTitle + ",lcid=" + lcid + ",firstName=" + firstName + ",middleName=" + middleName + ",lastName=" + lastName + ",password=" + password + ",secretQuestion=" + secretQuestion + ",secretAnswer=" + secretAnswer + ",userLifeCycleStatus=" + userLifeCycleStatus + ",userName=" + userName +"]";
	}
	
	public static final String getMsnCustomerString(final Customer customer)
	{
		final Long id = customer.getId();
		final String marketCountry= customer.getMarketCountry();
		final CustomerFinancialStatus customerFinancialStatus = customer.getCustomerFinancialStatus();
		final CustomerLifeCycleStatus customerLifeCycleStatus = customer.getCustomerLifeCycleStatus();
		final Industry industry = customer.getIndustry();
		final String name = customer.getName();
		final String number = customer.getNumber();
		final ServiceLevel serviceLevel = customer.getServiceLevel();
		return "Customer[id=" + id + ",marketCountry=" + marketCountry + ",customerFinancialStatus=" + customerFinancialStatus + ",customerLifeCycleStatus=" + customerLifeCycleStatus + ",industry=" + industry + ",name=" + name + ",number=" + number + ",serviceLevel=" + serviceLevel +"]";
	}
	
	public static final String getTextAdString(final TextAd textAd)
	{
		final Long id = textAd.getId();
		final String desciption1 = textAd.getDescription1();
		final String desciption2 = textAd.getDescription2();
		final String headline = textAd.getHeadline();
		final String displayUrl = textAd.getDisplayUrl();
		final String url = textAd.getUrl();
		return "TextAd[id=" + id + ",desciption1=" + desciption1 + ",desciption2=" + desciption2 + ",headline=" + headline + ",displayUrl=" + displayUrl + ",url=" + url + "]";
	}
		
	public static final String getTrimmedNonNullString(final String s)
	{
		if (s == null) 
		{
			return "";
		}
		else
		{
			return s.trim();
		}
	}
	
	public static String getEasilyReadableString(final List<?> list)
	{
		if (list == null)
		{
			return "";
		}
		int counter = 0;
		final StringBuffer sb = new StringBuffer();
		for (final Object o : list)
		{
			if (sb.length() != 0)
			{
				sb.append(LINE_SEPARATOR);
			}
			sb.append(++counter).append(": ").append(o);
		}
		return sb.toString();
	}
	
	public static String getEasilyReadableString(final Map<?, ?> m)
	{
		if (m == null)
		{
			return "";
		}
		int counter = 0;
		final StringBuffer sb = new StringBuffer();
		for (final Map.Entry<?, ?> mapEntry : m.entrySet())
		{
			if (sb.length() != 0)
			{
				sb.append(LINE_SEPARATOR);
			}
			sb.append(++counter).append(": ").append(mapEntry.getKey()).append(" -> ").append(mapEntry.getValue());
		}
		return sb.toString();
	}
	
	public static String IsNullReturnBlank(String s)
	{
		if (s == null)
		{
			return "";
		}
		else
		{
			return s;
		}
	}
}
