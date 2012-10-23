package semplest.service.keyword;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

import semplest.server.protocol.adengine.GetCategoriesRequest;
import semplest.util.SemplestUtils;

public class TestKeywordServiceImpl
{	
	private final KeywordServiceImpl service;
	private final Integer numMinimumWords = 5;
	private final Integer targetNumCategories = 10;
	private final String luceneDirectory = "data/dmoz/lucene/";
	private final String dmozDescriptionFile = "data/dmoz/all/all.descs";
	private final String log4jPropertyFile = "properties/log4j_server.properties";
	private final String validCategoryTypes = "arts,business,computers,games,health,home,news,recreation,reference,science,shopping,society,sports";
	private final String mockSearchResult1 = "top/business/companies/johnson_and_johnson";
	private final String mockSearchResult2 = "top/sports/teams/ny_knicks";
	private final Integer targetNumKeywords = 1500;
	
	public TestKeywordServiceImpl()
	{
		final Properties properties = new Properties();
		properties.put("NUM_MINIMUM_WORDS", "" + numMinimumWords);
		properties.put("TARGET_NUM_CATEGORIES", "" + targetNumCategories);
		properties.put("LUCENE_DIRECTORY", luceneDirectory);
		properties.put("DMOZ_DESCRIPTION_FILE", dmozDescriptionFile);
		properties.put("LOG4J_PROPERTY_FILE", log4jPropertyFile);
		properties.put("VALID_CATEGORY_TYPES", validCategoryTypes);
		properties.put("TARGET_NUM_KEYWORDS", "" + targetNumKeywords);	
		final KeywordProperties keywordProperties = new KeywordPropertiesMockImpl(properties);		
		final LuceneProvider luceneProvider = new LuceneProviderMockImpl(Arrays.asList(mockSearchResult1, mockSearchResult2));		
		service = new KeywordServiceImpl(keywordProperties, luceneProvider);		
	}
	
	@Test
	public void testGetCategories_ValidRequest() throws Exception
	{
		final GetCategoriesRequest request = new GetCategoriesRequest(Sets.<String>newHashSet("Term 1", "Term 2", "Term 3", "Term 4"));
		final List<String> actualResults = service.getCategories(request);
		final List<String> expectedResults = Arrays.asList(mockSearchResult1, mockSearchResult2);
		assertEquals(expectedResults, actualResults);
	}
	
	@Test
	public void testGetCategories_InvalidRequest()
	{
		final GetCategoriesRequest request = new GetCategoriesRequest(Sets.<String>newHashSet("Term 1", "Term 2"));
		try
		{
			service.getCategories(request);
			fail("Exception should have been thrown");
		}
		catch (Exception e)
		{
			final String exceptionMessage = e.getMessage();
			assertTrue(exceptionMessage.contains("Problem performing Get Categories"));
		}
	}
		
	@Test
	public void testStem()
	{
		final Set<String> words = new HashSet<String>(Arrays.asList("JUnit is so very easy your grandma can use it while browsing the web on mozilla browser and advertising on google and bing"));
		final Set<String> actualResult = service.stem(words);
		final Set<String> expectedResult = new HashSet<String>(Arrays.asList("mozilla is it can so bing advertis your web us the veri and while easi brows browser on JUnit googl grandma"));
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetSanitizedCategories()
	{
		final String categoryInvalid1 = null;
		final String categoryInvalid2 = "doesn't start with 'top'";
		final String categoryInvalid3 = "top/too_few_tokens";
		final String categoryInvalid4 = "top/last_token_too_short/a";
		final String categoryValid1 = "top/reference/wikipedia/thomas_jefferson";
		final String categoryValid2 = "top/science/galaxy/milkyway";
		final List<String> categories = Arrays.asList(categoryInvalid1, categoryValid1, categoryInvalid2, categoryValid2, categoryInvalid3, categoryInvalid4);
		final List<String> actualResult = KeywordServiceImpl.getSanitizedCategories(categories);
		final List<String> expectedResult = Arrays.asList(categoryValid1, categoryValid2);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetValidCategories()
	{
		final String categoryTooShort = "too_short";
		final String categoryValid1 = "top/arts/davinchi/monalisa";
		final String categoryInvalid = "top/invalid";
		final String categoryValid2 = "top/science/galaxy/milkyway";
		final List<String> categories = Arrays.asList(categoryTooShort, categoryValid1, categoryInvalid, categoryValid2);
		final List<String> validCategoryTypeList = Arrays.asList(validCategoryTypes.split(","));
		final List<String> actualResult = KeywordServiceImpl.getValidCategories(categories, validCategoryTypeList);
		final List<String> expectedResult = Arrays.asList(categoryValid1, categoryValid2);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testCheckIsValid_ShouldFail_Null()
	{
		final String actualResult = service.checkIsValid(null);
		final String expectedResult = SemplestUtils.TERMS_ARE_EMPTY;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCheckIsValid_ShouldFail_EmptySet()
	{
		final String actualResult = service.checkIsValid(new HashSet<String>());
		final String expectedResult = SemplestUtils.TERMS_ARE_EMPTY;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCheckIsValid_ShouldFail_TooFewWords()
	{
		final Set<String> terms = new HashSet<String>();
		terms.addAll(Arrays.asList("Less than 5 terms"));
		final String actualResult = service.checkIsValid(terms);
		final String expectedResult = "Number of total words [" + 4 + "] is less than minimum of [" + numMinimumWords + "]";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCheckIsValid_ShouldSucceed_ExactNumWords()
	{
		final Set<String> terms = new HashSet<String>();
		terms.addAll(Arrays.asList("Exactly 5 number of terms"));
		final String actualResult = service.checkIsValid(terms);
		final String expectedResult = null;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testCheckIsValid_ShouldSucceed_ManyWords()
	{
		final Set<String> terms = new HashSet<String>();
		terms.addAll(Arrays.asList("JUnit is awesomely useful, reducing errors and reducing manual testing time.", "JUnit gives us the ability to maintain a complex and evolving system."));
		final String actualResult = service.checkIsValid(terms);
		final String expectedResult = null;
		assertEquals(expectedResult, actualResult);
	}

}
