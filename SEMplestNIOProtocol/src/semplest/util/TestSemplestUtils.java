package semplest.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class TestSemplestUtils
{
	@Test
	public void testGetBatches()
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
	public void testGetBatches_ListNull()
	{
		final List<List<Object>> expectedBatches = new ArrayList<List<Object>>();
		final List<List<Object>> actualBatches = SemplestUtils.getBatches(null, 5);
		Assert.assertEquals(expectedBatches, actualBatches);
	}
	
	@Test
	public void testGetBatches_BatchSizeLessThan1()
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
