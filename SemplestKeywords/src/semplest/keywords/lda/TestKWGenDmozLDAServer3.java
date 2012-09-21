package semplest.keywords.lda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.SemplestConfiguration;

public class TestKWGenDmozLDAServer3
{
	@Test
	public void testGetKeywordsSorted_InOrder() throws Exception
	{		
		final List<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		final List<KeywordProbabilityObject> expectedResultedKeywords = new ArrayList<KeywordProbabilityObject>();
		final KeywordProbabilityObject keyword1 = new KeywordProbabilityObject();
		keyword1.setSemplestProbability(0.7);
		keyword1.setKeyword("keyword1");
		final KeywordProbabilityObject keyword2 = new KeywordProbabilityObject();
		keyword2.setSemplestProbability(0.6);
		keyword2.setKeyword("keyword2");
		final KeywordProbabilityObject keyword3 = new KeywordProbabilityObject();
		keyword3.setSemplestProbability(0.5);
		keyword3.setKeyword("keyword3");
		keywords.add(keyword1);
		keywords.add(keyword2);
		keywords.add(keyword3);
		expectedResultedKeywords.add(keyword1);
		expectedResultedKeywords.add(keyword2);
		expectedResultedKeywords.add(keyword3);
		final List<KeywordProbabilityObject> actualResultedKeywords = KWGenDmozLDAServer3.sortKeywords(keywords, 2);
		Assert.assertEquals(expectedResultedKeywords, actualResultedKeywords);
	}
	
	@Test
	public void testGetKeywordsSorted_InReverseOrder() throws Exception
	{		
		final List<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		final List<KeywordProbabilityObject> expectedResultedKeywords = new ArrayList<KeywordProbabilityObject>();
		final KeywordProbabilityObject keyword1 = new KeywordProbabilityObject();
		keyword1.setSemplestProbability(0.7);
		keyword1.setKeyword("keyword1");
		final KeywordProbabilityObject keyword2 = new KeywordProbabilityObject();
		keyword2.setSemplestProbability(0.6);
		keyword2.setKeyword("keyword2");
		final KeywordProbabilityObject keyword3 = new KeywordProbabilityObject();
		keyword3.setSemplestProbability(0.5);
		keyword3.setKeyword("keyword3");
		keywords.add(keyword3);
		keywords.add(keyword2);
		keywords.add(keyword1);
		expectedResultedKeywords.add(keyword1);
		expectedResultedKeywords.add(keyword2);
		expectedResultedKeywords.add(keyword3);
		final List<KeywordProbabilityObject> actualResultedKeywords = KWGenDmozLDAServer3.sortKeywords(keywords, 2);
		Assert.assertEquals(expectedResultedKeywords, actualResultedKeywords);
	}
	
	@Test
	public void testGetKeywordsSorted_RandomOrder() throws Exception
	{		
		final List<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		final List<KeywordProbabilityObject> expectedResultedKeywords = new ArrayList<KeywordProbabilityObject>();
		final KeywordProbabilityObject keyword1 = new KeywordProbabilityObject();
		keyword1.setSemplestProbability(0.7);
		keyword1.setKeyword("keyword1");
		final KeywordProbabilityObject keyword2 = new KeywordProbabilityObject();
		keyword2.setSemplestProbability(0.6);
		keyword2.setKeyword("keyword2");
		final KeywordProbabilityObject keyword3 = new KeywordProbabilityObject();
		keyword3.setSemplestProbability(0.5);
		keyword3.setKeyword("keyword3");
		keywords.add(keyword2);
		keywords.add(keyword3);
		keywords.add(keyword1);
		expectedResultedKeywords.add(keyword1);
		expectedResultedKeywords.add(keyword2);
		expectedResultedKeywords.add(keyword3);
		final List<KeywordProbabilityObject> actualResultedKeywords = KWGenDmozLDAServer3.sortKeywords(keywords, 2);
		Assert.assertEquals(expectedResultedKeywords, actualResultedKeywords);
	}
}
