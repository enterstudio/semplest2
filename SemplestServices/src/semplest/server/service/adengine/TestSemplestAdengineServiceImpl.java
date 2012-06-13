package semplest.server.service.adengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.google.GoogleAddAdRequest;

public class TestSemplestAdengineServiceImpl
{

	@Test
	public void testBackfillAdEngineAdID()
	{
		final Integer promotionAdsPK1 = 1;
		final Integer promotionAdsPK2 = 2;
		final Integer promotionFK1 = 11;
		final Integer promotionFK2 = 22;
		final String adTitle1 = "AdTitle1";
		final String adTitle2 = "AdTitle2";
		final String adTextLine1_1 = "AdTextLine1_1";
		final String adTextLine1_2 = "AdTextLine1_2";
		final String adTextLine2_1 = "AdTextLine2_1";
		final String adTextLine2_2 = "AdTextLine2_2";
		final Long adEngineAdID1 = 111L;
		final Long adEngineAdID2 = 222L;
		final boolean isDeleted1 = false;
		final boolean isDeleted2 = true;
		final java.util.Date createdDate1 = new java.util.Date();
		final java.util.Date createdDate2 = new java.util.Date(System.currentTimeMillis() + 1);
		final java.util.Date deletedDate1 = new java.util.Date(System.currentTimeMillis() + 2);
		final java.util.Date deletedDate2 = new java.util.Date(System.currentTimeMillis() + 3);
		final AdsObject ad1 = new AdsObject(promotionAdsPK1, promotionFK1, adTitle1, adTextLine1_1, adTextLine2_1, null, isDeleted1, createdDate1, deletedDate1);
		final AdsObject ad2 = new AdsObject(promotionAdsPK2, promotionFK2, adTitle2, adTextLine1_2, adTextLine2_2, null, isDeleted2, createdDate2, deletedDate2);		
		final List<AdsObject> actualAds = new ArrayList<AdsObject>();
		actualAds.add(ad1);
		actualAds.add(ad2);
		final GoogleAddAdRequest googleAddAdRequest1 = new GoogleAddAdRequest(promotionAdsPK1, adTitle1, adTextLine1_1, adTextLine2_1);
		final GoogleAddAdRequest googleAddAdRequest2 = new GoogleAddAdRequest(promotionAdsPK2, adTitle2, adTextLine1_2, adTextLine2_2);		
		final Map<GoogleAddAdRequest, Long> requestToAdEngineAdIdMap = new HashMap<GoogleAddAdRequest, Long>();
		requestToAdEngineAdIdMap.put(googleAddAdRequest1, adEngineAdID1);
		requestToAdEngineAdIdMap.put(googleAddAdRequest2, adEngineAdID2);		
		SemplestAdengineServiceImpl.backfillAdEngineAdID(actualAds, requestToAdEngineAdIdMap);
		final AdsObject expectedAd1 = new AdsObject(promotionAdsPK1, promotionFK1, adTitle1, adTextLine1_1, adTextLine2_1, adEngineAdID1, isDeleted1, createdDate1, deletedDate1);
		final AdsObject expectedAd2 = new AdsObject(promotionAdsPK2, promotionFK2, adTitle2, adTextLine1_2, adTextLine2_2, adEngineAdID2, isDeleted2, createdDate2, deletedDate2);
		final List<AdsObject> expectedAds = new ArrayList<AdsObject>();
		expectedAds.add(expectedAd1);
		expectedAds.add(expectedAd2);
		Assert.assertEquals(expectedAds, actualAds);
	}

}
