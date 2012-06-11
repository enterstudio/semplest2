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

}
