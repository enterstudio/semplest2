package semplest.service.google.adwords;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import semplest.server.protocol.google.GoogleSiteLink;

import com.google.api.adwords.v201109_1.cm.Sitelink;
import com.google.api.adwords.v201109_1.cm.SitelinksExtension;

public class TestGoogleAdwordsServiceImpl
{
	@Test
	public void testGetSitelinkIds_Empty() throws Exception
	{
		final List<SitelinksExtension> emptySitelinksExtensions = new ArrayList<SitelinksExtension>();
		final List<Long> actualIds = GoogleAdwordsServiceImpl.getIds(emptySitelinksExtensions);
		final List<Long> expectedIds = new ArrayList<Long>();
		Assert.assertEquals(expectedIds, actualIds);
	}
	
	@Test
	public void testGetSitelinkIds_Null() throws Exception
	{
		final List<Long> actualIds = GoogleAdwordsServiceImpl.getIds(null);
		final List<Long> expectedIds = new ArrayList<Long>();
		Assert.assertEquals(expectedIds, actualIds);
	}
	
	@Test
	public void testGetSitelinkIds() throws Exception
	{		
		final SitelinksExtension sitelinksExtension1 = new SitelinksExtension(12L, "type1", null);
		final SitelinksExtension sitelinksExtension2 = new SitelinksExtension(452L, "type2", null);
		final List<SitelinksExtension> sitelinksExtensions = new ArrayList<SitelinksExtension>();
		sitelinksExtensions.add(sitelinksExtension1);
		sitelinksExtensions.add(sitelinksExtension2);
		final List<Long> actualIds = GoogleAdwordsServiceImpl.getIds(sitelinksExtensions);
		final List<Long> expectedIds = new ArrayList<Long>();
		expectedIds.add(12L);
		expectedIds.add(452L);		
		Assert.assertEquals(expectedIds, actualIds);
	}
	
	@Test
	public void testGetMatchingSitelinks_EmptySitelinksExtensions() throws Exception
	{
		final List<SitelinksExtension> emptySitelinksExtensions = new ArrayList<SitelinksExtension>();		
		final GoogleSiteLink googleSiteLink = new GoogleSiteLink("linkText1", "http://www.sitelink.com");
		final List<GoogleSiteLink> siteLinks = new ArrayList<GoogleSiteLink>();
		siteLinks.add(googleSiteLink);
		final List<SitelinksExtension> actualMatchingSitelinksExtensions = GoogleAdwordsServiceImpl.getMatchingSitelinks(emptySitelinksExtensions, siteLinks);
		final List<Long> emptyExpectedMatchingSitelinksExtensions = new ArrayList<Long>();
		Assert.assertEquals(emptyExpectedMatchingSitelinksExtensions, actualMatchingSitelinksExtensions);
	}
	
	@Test
	public void testGetMatchingSitelinks_NullSitelinksExtensions() throws Exception
	{
		final List<SitelinksExtension> nullSitelinksExtensions = null;		
		final GoogleSiteLink googleSiteLink = new GoogleSiteLink("linkText1", "http://www.sitelink.com");
		final List<GoogleSiteLink> siteLinks = new ArrayList<GoogleSiteLink>();
		siteLinks.add(googleSiteLink);
		final List<SitelinksExtension> actualMatchingSitelinksExtensions = GoogleAdwordsServiceImpl.getMatchingSitelinks(nullSitelinksExtensions, siteLinks);
		final List<Long> emptyExpectedMatchingSitelinksExtensions = new ArrayList<Long>();
		Assert.assertEquals(emptyExpectedMatchingSitelinksExtensions, actualMatchingSitelinksExtensions);
	}
	
	@Test
	public void testGetMatchingSitelinks_EmptySitelinks() throws Exception
	{
		final SitelinksExtension sitelinksExtension = new SitelinksExtension(12L, "type1", null);
		final List<SitelinksExtension> sitelinksExtensions = new ArrayList<SitelinksExtension>();
		sitelinksExtensions.add(sitelinksExtension);
		final List<GoogleSiteLink> emptySiteLinks = new ArrayList<GoogleSiteLink>();
		final List<SitelinksExtension> actualMatchingSitelinksExtensions = GoogleAdwordsServiceImpl.getMatchingSitelinks(sitelinksExtensions, emptySiteLinks);
		final List<Long> emptyExpectedMatchingSitelinksExtensions = new ArrayList<Long>();
		Assert.assertEquals(emptyExpectedMatchingSitelinksExtensions, actualMatchingSitelinksExtensions);
	}
	
	@Test
	public void testGetMatchingSitelinks_NullSitelinks() throws Exception
	{
		final SitelinksExtension sitelinksExtension = new SitelinksExtension(12L, "type1", null);
		final List<SitelinksExtension> sitelinksExtensions = new ArrayList<SitelinksExtension>();
		sitelinksExtensions.add(sitelinksExtension);
		final List<GoogleSiteLink> nullSiteLinks = null;
		final List<SitelinksExtension> actualMatchingSitelinksExtensions = GoogleAdwordsServiceImpl.getMatchingSitelinks(sitelinksExtensions, nullSiteLinks);
		final List<Long> emptyExpectedMatchingSitelinksExtensions = new ArrayList<Long>();
		Assert.assertEquals(emptyExpectedMatchingSitelinksExtensions, actualMatchingSitelinksExtensions);
	}
	
	@Test
	public void testGetMatchingSitelinks() throws Exception
	{
		final Sitelink[] sitelinksArray1 = new Sitelink[]{new Sitelink("linkText1", "http://www.sitelink.com"), new Sitelink("linkText2", "http://www.sitelink2.com")};
		final Sitelink[] sitelinksArray2 = new Sitelink[]{new Sitelink("linkText3", "http://www.sitelink3.com")};
		final Sitelink[] sitelinksArray3 = new Sitelink[]{new Sitelink("linkText4", "http://www.sitelink4.com")};
		final SitelinksExtension sitelinksExtension1 = new SitelinksExtension(12L, "type1", sitelinksArray1);
		final SitelinksExtension sitelinksExtension2 = new SitelinksExtension(13L, "type3", sitelinksArray2);
		final SitelinksExtension sitelinksExtension3 = new SitelinksExtension(14L, "type4", sitelinksArray3);
		final List<SitelinksExtension> sitelinksExtensions = new ArrayList<SitelinksExtension>();
		sitelinksExtensions.add(sitelinksExtension1);
		sitelinksExtensions.add(sitelinksExtension2);
		sitelinksExtensions.add(sitelinksExtension3);
		final List<GoogleSiteLink> siteLinks = new ArrayList<GoogleSiteLink>();
		final GoogleSiteLink siteLink1 = new GoogleSiteLink("linkText1", "http://www.sitelink.com");
		final GoogleSiteLink siteLink2 = new GoogleSiteLink("linkText4", "http://www.sitelink4.com");
		siteLinks.add(siteLink1);
		siteLinks.add(siteLink2);
		final List<SitelinksExtension> actualMatchingSitelinksExtensions = GoogleAdwordsServiceImpl.getMatchingSitelinks(sitelinksExtensions, siteLinks);
		final List<SitelinksExtension> expectedMatchingSitelinksExtensions = new ArrayList<SitelinksExtension>();
		expectedMatchingSitelinksExtensions.add(sitelinksExtension1);
		expectedMatchingSitelinksExtensions.add(sitelinksExtension3);
		Assert.assertEquals(expectedMatchingSitelinksExtensions, actualMatchingSitelinksExtensions);
	}

	
}
