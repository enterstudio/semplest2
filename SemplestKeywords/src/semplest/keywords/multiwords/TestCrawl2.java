package semplest.keywords.multiwords;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.TextUtils;
import semplest.keywords.scalautils.*;

public class TestCrawl2
{

	private static final Logger logger = Logger.getLogger(TestCrawl2.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		String ss = "http://www.parishilton.com";
		String urls = TextUtils.HTMLLinkString(ss);

		Crawler c = new Crawler();
		// System.out.println("Adding urls: "+urls);
		// c.add( "parishilton", urls );
		System.out.println("Adding urls: " + ss);
		c.add("parishilton", ss);

		try
		{
			Thread.sleep(30000);
		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}

		String[] results = c.fetch();
		for (String res : results)
		{
			System.out.println(res);
		}
	}

}