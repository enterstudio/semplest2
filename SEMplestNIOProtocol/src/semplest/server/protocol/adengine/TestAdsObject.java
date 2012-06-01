package semplest.server.protocol.adengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class TestAdsObject
{
	@Test
	public void testAdEngineAdIdComparator()
	{
		final List<AdsObject> listTobeSorted = new ArrayList<AdsObject>();
		final AdsObject ad1 = new AdsObject(1, 2, "adTitle1_1", "adTextLine1_1", "adTextLine2_1", 1L);
		final AdsObject ad2 = new AdsObject(11, 22, "adTitle1_2", "adTextLine1_2", "adTextLine2_2", 2L);
		final AdsObject ad3 = new AdsObject(111, 222, "adTitle1_3", "adTextLine1_3", "adTextLine2_3", 3L);
		final AdsObject ad4 = new AdsObject(1111, 2222, "adTitle1_4", "adTextLine1_4", "adTextLine2_4", null);
		listTobeSorted.add(ad2);
		listTobeSorted.add(ad4);
		listTobeSorted.add(ad1);
		listTobeSorted.add(ad3);
		final List<AdsObject> expectedSortedList = new ArrayList<AdsObject>();
		expectedSortedList.add(ad3);
		expectedSortedList.add(ad2);
		expectedSortedList.add(ad1);
		expectedSortedList.add(ad4);
		Collections.sort(listTobeSorted, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
		Assert.assertEquals(expectedSortedList, listTobeSorted);
	}
}

