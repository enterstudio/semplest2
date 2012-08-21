package semplest.util;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

import semplest.server.encryption.AESBouncyCastle;
import semplest.server.protocol.CustomerHierarchy;
import semplest.server.protocol.CustomerType;
import semplest.server.protocol.EmailTemplate;
import semplest.server.protocol.EmailType;
import semplest.server.protocol.RegistrationLinkDecryptedInfo;
import semplest.server.protocol.adengine.KeywordProbabilityObject;

public class TestSemplestUtils
{
	@Test
	public void testFilterOutDeletedKeywords() throws Exception
	{ 
		final KeywordProbabilityObject keywordNonDeleted1 = new KeywordProbabilityObject();
		keywordNonDeleted1.setIsActive(true);
		keywordNonDeleted1.setIsDeleted(false);
		keywordNonDeleted1.setIsNegative(false);
		keywordNonDeleted1.setIsTargetGoogle(true);
		keywordNonDeleted1.setIsTargetMSN(true);
		keywordNonDeleted1.setKeyword("asdasdsad");
		keywordNonDeleted1.setKeywordPK(123);
		keywordNonDeleted1.setSemplestProbability(0.5);
		final KeywordProbabilityObject keywordNonDeleted2 = new KeywordProbabilityObject();
		keywordNonDeleted2.setIsActive(true);
		keywordNonDeleted2.setIsDeleted(false);
		keywordNonDeleted2.setIsNegative(true);
		keywordNonDeleted2.setIsTargetGoogle(true);
		keywordNonDeleted2.setIsTargetMSN(true);
		keywordNonDeleted2.setKeyword("table");
		keywordNonDeleted2.setKeywordPK(124);
		keywordNonDeleted2.setSemplestProbability(0.75);
		final KeywordProbabilityObject keywordDeleted = new KeywordProbabilityObject();
		keywordDeleted.setIsActive(true);
		keywordDeleted.setIsDeleted(true);
		keywordDeleted.setIsNegative(true);
		keywordDeleted.setIsTargetGoogle(true);
		keywordDeleted.setIsTargetMSN(true);
		keywordDeleted.setKeyword("chair");
		keywordDeleted.setKeywordPK(125);
		keywordDeleted.setSemplestProbability(0.75);
		final List<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		keywords.add(keywordNonDeleted1);
		keywords.add(keywordDeleted);
		keywords.add(keywordNonDeleted2);
		final List<KeywordProbabilityObject> expectedResultKeywords = Arrays.asList(keywordNonDeleted1, keywordNonDeleted2);
		SemplestUtils.filterOutDeletedKeywords(keywords);
		Assert.assertEquals(expectedResultKeywords, keywords);
	}

	@Test
	public void testGetCustomerType_Child() throws Exception
	{
		final CustomerHierarchy hierarchy = new CustomerHierarchy(1, 2, 3, new java.util.Date());
		final CustomerType actualCustomerType = SemplestUtils.getCustomerType(hierarchy);
		final CustomerType expectedCustomerType = CustomerType.CHILD;
		Assert.assertEquals(expectedCustomerType, actualCustomerType);
	}
	
	@Test
	public void testGetCustomerType_Parent() throws Exception
	{
		final CustomerHierarchy hierarchy = new CustomerHierarchy(1, 2, null, new java.util.Date());
		final CustomerType actualCustomerType = SemplestUtils.getCustomerType(hierarchy);
		final CustomerType expectedCustomerType = CustomerType.PARENT;
		Assert.assertEquals(expectedCustomerType, actualCustomerType);
	}
	
	@Test
	public void testGetCustomerType_SingleUser() throws Exception
	{
		final CustomerHierarchy hierarchy = new CustomerHierarchy(1, 2, 2, new java.util.Date());
		final CustomerType actualCustomerType = SemplestUtils.getCustomerType(hierarchy);
		final CustomerType expectedCustomerType = CustomerType.SINGLE_USER;
		Assert.assertEquals(expectedCustomerType, actualCustomerType);
	}
	
	@Test
	public void testGetEmailTemplateForCustomer_CustomerSpecificExists()
	{
		final Integer customerID = 2;	
		final EmailTemplate emailTemplate1 = new EmailTemplate(1, null, EmailType.EXPIRED_ACTIVATION_IDS, "bob@abc.com", "Welcome!", "Hello, nice to meet you.");
		final EmailTemplate emailTemplate2 = new EmailTemplate(2, 2, EmailType.EXPIRED_ACTIVATION_IDS, "john@abc.com", "Welcome to Oz!", "Hi, nice to meet you.");
		final EmailTemplate emailTemplate3 = new EmailTemplate(3, null, EmailType.FORGOTTEN_PASSWORD, "ted@abc.com", "Welcome to NY!", "Hey, nice to meet you.");
		final List<EmailTemplate> emailTemplates = Arrays.asList(emailTemplate1, emailTemplate2, emailTemplate3);
		final EmailTemplate actualEmailTemplate = SemplestUtils.getEmailTemplateForCustomer(customerID, emailTemplates);
		Assert.assertEquals(emailTemplate2, actualEmailTemplate);
	}
	
	@Test
	public void testGetEmailTemplateForCustomer_CustomerSpecificExistsForAnotherCustomer()
	{
		final Integer customerID = 2;	
		final EmailTemplate emailTemplate1 = new EmailTemplate(1, null, EmailType.EXPIRED_ACTIVATION_IDS, "bob@abc.com", "Welcome!", "Hello, nice to meet you.");
		final EmailTemplate emailTemplate2 = new EmailTemplate(2, 6, EmailType.EXPIRED_ACTIVATION_IDS, "john@abc.com", "Welcome to Oz!", "Hi, nice to meet you.");
		final EmailTemplate emailTemplate3 = new EmailTemplate(3, null, EmailType.FORGOTTEN_PASSWORD, "ted@abc.com", "Welcome to NY!", "Hey, nice to meet you.");
		final List<EmailTemplate> emailTemplates = Arrays.asList(emailTemplate1, emailTemplate2, emailTemplate3);
		final EmailTemplate actualEmailTemplate = SemplestUtils.getEmailTemplateForCustomer(customerID, emailTemplates);
		Assert.assertEquals(null, actualEmailTemplate);
	}
	
	@Test
	public void testGetEmailTemplateForNoCustomer_Exists()
	{
		final EmailType emailType = EmailType.EXPIRED_ACTIVATION_IDS;		
		final EmailTemplate emailTemplate1 = new EmailTemplate(1, 6, emailType, "bob@abc.com", "Welcome!", "Hello, nice to meet you.");
		final EmailTemplate emailTemplate2 = new EmailTemplate(2, null, emailType, "john@abc.com", "Welcome to Oz!", "Hi, nice to meet you.");
		final EmailTemplate emailTemplate3 = new EmailTemplate(3, 7, emailType, "stacy@abc.com", "Welcome to NY!", "Hey, nice to meet you.");
		final List<EmailTemplate> emailTemplates = Arrays.asList(emailTemplate1, emailTemplate2, emailTemplate3);
		final EmailTemplate actualEmailTemplate = SemplestUtils.getEmailTemplateForNoCustomer(emailTemplates);
		Assert.assertEquals(emailTemplate2, actualEmailTemplate);
	}
	
	@Test
	public void testGetEmailTemplateForNoCustomer_NotExists()
	{
		final EmailType emailType = EmailType.EXPIRED_ACTIVATION_IDS;		
		final EmailTemplate emailTemplate1 = new EmailTemplate(1, 6, emailType, "bob@abc.com", "Welcome!", "Hello, nice to meet you.");
		final EmailTemplate emailTemplate2 = new EmailTemplate(2, 8, emailType, "john@abc.com", "Welcome to Oz!", "Hi, nice to meet you.");
		final EmailTemplate emailTemplate3 = new EmailTemplate(3, 7, emailType, "stacy@abc.com", "Welcome to NY!", "Hey, nice to meet you.");
		final List<EmailTemplate> emailTemplates = Arrays.asList(emailTemplate1, emailTemplate2, emailTemplate3);
		final EmailTemplate actualEmailTemplate = SemplestUtils.getEmailTemplateForNoCustomer(emailTemplates);
		Assert.assertEquals(null, actualEmailTemplate);
	}
	
	@Test
	public void testGetConcatenatedRegistrationString()
	{
		final Integer userID = 5;
		final Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1994);
		cal.set(Calendar.MONTH, Calendar.JUNE);
		cal.set(Calendar.DAY_OF_MONTH, 25);
		cal.set(Calendar.HOUR_OF_DAY, 10);
		cal.set(Calendar.MINUTE, 45);
		cal.set(Calendar.SECOND, 30);
		cal.set(Calendar.MILLISECOND, 500);
		final java.util.Date dateTime = cal.getTime();
		final String username = "user123";
		final String password = "hey777";
		final String actualResult = SemplestUtils.getConcatenatedRegistrationString(userID, dateTime, username, password);
		final String expectedResult = "USER_ID=5|DATE_TIME=1994-06-25-10-45-30|USER_NAME=user123|PASSWORD=hey777";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	public void testGetDecryptedInfoFromDescryptedString() throws Exception
	{
		final Integer userID = 5;
		final String dateTimeString = "1994-06-25-10-45-30";
		final java.util.Date dateTime = SemplestUtils.DATE_FORMAT_YYYYMMDD_HH_MM_SS.parse(dateTimeString);
		final String username = "user123";
		final String password = "hey777";
		final String decryptedString = "USER_ID=" + userID + "|DATE_TIME=" + dateTimeString + "|USER_NAME=" + username + "|PASSWORD=" + password;
		final RegistrationLinkDecryptedInfo actualResult = SemplestUtils.getDecryptedInfoFromDecryptedString(decryptedString);
		final RegistrationLinkDecryptedInfo expectedResult = new RegistrationLinkDecryptedInfo(userID, dateTime, username, password);
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testIsNullReturnBlank()
	{
		final String s = " ss EE   ";
		final String actualString = SemplestUtils.isNullReturnEmptyString(s);
		final String expectedString = " ss EE   ";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testIsNullReturnBlank_Null()
	{
		final String s = null;
		final String actualString = SemplestUtils.isNullReturnEmptyString(s);
		final String expectedString = "";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testIsNullReturnBlank_Empty()
	{
		final String s = "";
		final String actualString = SemplestUtils.isNullReturnEmptyString(s);
		final String expectedString = "";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetTrimmedNonNullString()
	{
		final String s = " ss EE   ";
		final String actualString = SemplestUtils.getTrimmedNonNullString(s);
		final String expectedString = "ss EE";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetTrimmedNonNullString_Empty()
	{
		final String s = "   ";
		final String actualString = SemplestUtils.getTrimmedNonNullString(s);
		final String expectedString = "";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetTrimmedNonNullString_Null()
	{
		final String s = null;
		final String actualString = SemplestUtils.getTrimmedNonNullString(s);
		final String expectedString = "";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetStringForArray()
	{
		final long[] longArray = new long[]{1L, 5L, 33L};
		final String actualString = SemplestUtils.getStringForArray(longArray);
		final String expectedString = "1, 5, 33";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetStringForArray_Empty()
	{
		final long[] longArray = new long[]{};
		final String actualString = SemplestUtils.getStringForArray(longArray);
		final String expectedString = "";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetStringForArray_Null()
	{
		final long[] longArray = null;
		final String actualString = SemplestUtils.getStringForArray(longArray);
		final String expectedString = "";
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test
	public void testGetBatchesMap()
	{
		final Map<String, Integer> map = new HashMap<String, Integer>();
		final String keyOne = "one";
		final Integer valueOne = 1;
		final String keyTwo = "two";
		final Integer valueTwo = 2;
		final String keyThree = "three";
		final Integer valueThree = 3;
		final String keyFour = "four";
		final Integer valueFour = 4;
		final String keyFive = "five";
		final Integer valueFive = 5;
		map.put(keyOne, valueOne);
		map.put(keyTwo, valueTwo);
		map.put(keyThree, valueThree);
		map.put(keyFour, valueFour);
		map.put(keyFive, valueFive);
		final Map<String, Integer> expectedBatch1 = new HashMap<String, Integer>();
		final Map<String, Integer> expectedBatch2 = new HashMap<String, Integer>();
		final Map<String, Integer> expectedBatch3 = new HashMap<String, Integer>();		
		final List<Map<String, Integer>> expectedBatches = new ArrayList<Map<String, Integer>>();
		final Set<Entry<String, Integer>> entrySet = map.entrySet();		
		final Iterator<Entry<String, Integer>> interator = entrySet.iterator();
		final Entry<String, Integer> entry1 = interator.next();
		final Entry<String, Integer> entry2 = interator.next();
		final Entry<String, Integer> entry3 = interator.next();
		final Entry<String, Integer> entry4 = interator.next();
		final Entry<String, Integer> entry5 = interator.next();
		expectedBatch1.put(entry1.getKey(), entry1.getValue());
		expectedBatch1.put(entry2.getKey(), entry2.getValue());
		expectedBatch2.put(entry3.getKey(), entry3.getValue());
		expectedBatch2.put(entry4.getKey(), entry4.getValue());
		expectedBatch3.put(entry5.getKey(), entry5.getValue());
		expectedBatches.add(expectedBatch1);
		expectedBatches.add(expectedBatch2);
		expectedBatches.add(expectedBatch3);
		final List<Map<String, Integer>> actualBatches = SemplestUtils.getBatches(map, 2);
		Assert.assertEquals(expectedBatches, actualBatches);
	}
	
	@Test
	public void testGetBatchesMap_ListNull()
	{
		final List<Map<String, Integer>> expectedBatches = new ArrayList<Map<String, Integer>>();
		final Map<String, Integer> map = null;
		final List<Map<String, Integer>> actualBatches = SemplestUtils.getBatches(map, 5);
		Assert.assertEquals(expectedBatches, actualBatches);
	}
	
	@Test
	public void testGetBatchesMap_BatchSizeLessThan1()
	{
		try
		{
			SemplestUtils.getBatches(new HashMap<String, Integer>(), 0);
			Assert.fail("Exception should have been thrown because BatchSize is 0 (which is less than 1)");
		}
		catch (IllegalArgumentException e)
		{
			// expected
		}
	}
	
	@Test
	public void testGetBatchesList()
	{
		final List<String> list = new ArrayList<String>();
		final String one = "one";
		final String two = "two";
		final String three = "three";
		final String four = "four";
		final String five = "five";
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		final List<String> expectedBatch1 = new ArrayList<String>();
		final List<String> expectedBatch2 = new ArrayList<String>();
		final List<String> expectedBatch3 = new ArrayList<String>();
		expectedBatch1.add(one);
		expectedBatch1.add(two);
		expectedBatch2.add(three);
		expectedBatch2.add(four);
		expectedBatch3.add(five);
		final List<List<String>> expectedBatches = new ArrayList<List<String>>();
		expectedBatches.add(expectedBatch1);
		expectedBatches.add(expectedBatch2);
		expectedBatches.add(expectedBatch3);
		final List<List<String>> actualBatches = SemplestUtils.getBatches(list, 2);
		Assert.assertEquals(expectedBatches, actualBatches);
	}
	
	@Test
	public void testGetBatchesList_ListNull()
	{
		final List<List<Object>> expectedBatches = new ArrayList<List<Object>>();
		final List<Object> list = null;
		final List<List<Object>> actualBatches = SemplestUtils.getBatches(list, 5);
		Assert.assertEquals(expectedBatches, actualBatches);
	}
	
	@Test
	public void testGetBatchesList_BatchSizeLessThan1()
	{
		try
		{
			SemplestUtils.getBatches(new ArrayList<String>(), 0);
			Assert.fail("Exception should have been thrown because BatchSize is 0 (which is less than 1)");
		}
		catch (IllegalArgumentException e)
		{
			// expected
		}
	}
	
	@Test
	public void testGetRandomAllowedChars()
	{
		Assert.assertEquals(4, SemplestUtils.getRandomAllowedChars(4, SemplestUtils.ALLOWED_CHARS).length());
	}
	
	@Test
	public void testGetStringOfSpecifiedLength()
	{
		Assert.assertEquals("abcdefg", SemplestUtils.getStringOfSpecifiedLength("abcdefg", 3, 10));
		Assert.assertEquals("abcdefg", SemplestUtils.getStringOfSpecifiedLength("abcdefg", 7, 7));
		Assert.assertEquals(8, SemplestUtils.getStringOfSpecifiedLength("abcdefg", 8, 10).length());
		Assert.assertEquals("abcd", SemplestUtils.getStringOfSpecifiedLength("abcdefg", 2, 4));
	}
	
	@Test
	public void testGetEasilyReadableString_ListNull()
	{
		final List<String> list = null;
		final String actualResult = SemplestUtils.getEasilyReadableString(list);
		final String expectedResult = "";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetEasilyReadableString_ListEmpty()
	{
		final List<String> list = new ArrayList<String>();
		final String actualResult = SemplestUtils.getEasilyReadableString(list);
		final String expectedResult = "";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetEasilyReadableString_List()
	{
		final List<String> list = new ArrayList<String>();
		list.add("First String");
		list.add("Second String");
		final String actualResult = SemplestUtils.getEasilyReadableString(list);
		final String expectedResult = "1: First String" + SemplestUtils.LINE_SEPARATOR + "2: Second String";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetEasilyReadableString_MapNull()
	{
		final Map<String, String> map = null;
		final String actualResult = SemplestUtils.getEasilyReadableString(map);
		final String expectedResult = "";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetEasilyReadableString_MapEmpty()
	{
		final Map<String, String> map = new HashMap<String, String>();
		final String actualResult = SemplestUtils.getEasilyReadableString(map);
		final String expectedResult = "";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetEasilyReadableString_Map()
	{
		final Map<String, String> map = new HashMap<String, String>();
		map.put("First Key", "First Value");
		map.put("Second Key", "Second Value");
		final String actualResult = SemplestUtils.getEasilyReadableString(map);
		final String expectedResult = "1: First Key -> First Value" + SemplestUtils.LINE_SEPARATOR + "2: Second Key -> Second Value";
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testStripNonAlphaNumericChars_Empty()
	{
		Assert.assertEquals("", SemplestUtils.sanitizeString(""));
	}

	@Test
	public void testStripNonAlphaNumericChars_Null()
	{
		Assert.assertEquals("", SemplestUtils.sanitizeString(null));
	}
	
	@Test
	public void testStripNonAlphaNumericChars_Spaces()
	{
		Assert.assertEquals("", SemplestUtils.sanitizeString("    "));
	}
	
	@Test
	public void testStripNonAlphaNumericChars()
	{
		Assert.assertEquals("-Q12--q-w-YU----a-B-C---DEf-------g----h-y--IU----", SemplestUtils.sanitizeString("  *Q12^ q_w-YU~`)(a*B&C ^%DEf$#@!<>?g,./'h;y:|IU]}[{  "));
	}
	
}
