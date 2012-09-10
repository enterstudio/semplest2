package semplest.keywords.lda;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.DmozLuceneWriter;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.properties.ProjectProperties;

public class KWGenDmozLDAdata3 implements Runnable
{

	private static final Logger logger = Logger.getLogger(KWGenDmozLDAdata3.class);
	public DmozLuceneWriter dl; // Index of categories
	public dictUtils dict;
	public int numTopics;
	public double userInfoWeight;
	public int numKeywordsGoogle;
	public int numKeywordsMSN;
	public static ProjectProperties pr;
	public catUtils cu;

	public KWGenDmozLDAdata3(Map<String, Object> configData) throws IOException
	{
		try
		{
			// pr=new ProjectProperties(configData);
			pr = new ProjectProperties(null);
			numTopics = pr.numTopics;
			userInfoWeight = pr.userInfoWeight;
			numKeywordsGoogle = pr.numKeywordsGoogle;
			numKeywordsMSN = pr.numKeywordsMSN;
			cu = new catUtils();
			logger.info("About to create DmozLuceneWriter");
			dl = new DmozLuceneWriter();
			logger.info("DmozLuceneWriter initialized");
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
			e.printStackTrace();
			throw new IOException("Problem", e);
		}
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(0);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			logger.error("Problem", e);
		}
	}
}
