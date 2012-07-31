package semplest.server.protocol.msn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import semplest.server.protocol.google.MsnEditorialApiFaultDetail;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.v8.CampaignNegativeKeywords;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.ICampaignManagementService;
import com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsRequest;
import com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse;

public class AddNegativeKeywordsRetriableMsnOperation extends AbstractRetriableMsnOperation<SetNegativeKeywordsToCampaignsResponse>
{
	private static final Logger logger = Logger.getLogger(AddNegativeKeywordsRetriableMsnOperation.class);
	
	private final ICampaignManagementService campaignManagement;
	private final SetNegativeKeywordsToCampaignsRequest request;
	private final Map<Integer, String> filteredOutKeywordPkToCommentMap = new HashMap<Integer, String>();
	private final Map<CampaignNegativeKeywords, Integer> keywordToPkMap;
	
	public AddNegativeKeywordsRetriableMsnOperation(final ICampaignManagementService campaignManagement, final SetNegativeKeywordsToCampaignsRequest request, final Map<CampaignNegativeKeywords, Integer> keywordToPkMap, final Integer maxRetries)
	{
		super(maxRetries);
		this.campaignManagement = campaignManagement;
		this.request = request;
		this.keywordToPkMap = keywordToPkMap;
	}
		
	public SetNegativeKeywordsToCampaignsRequest getSetNegativeKeywordsToCampaignsRequest()
	{
		return request;
	}
	
	public Map<Integer, String> getFilteredOutKeywordPkToCommentMap()
	{
		return filteredOutKeywordPkToCommentMap;
	}
			
	@Override
	protected SetNegativeKeywordsToCampaignsResponse porformCustomOperation() throws AdApiFaultDetail, EditorialApiFaultDetail, RemoteException
	{
		logger.info("Will try to add " + request.getCampaignNegativeKeywords().length + " Negative Keywords");
		return campaignManagement.setNegativeKeywordsToCampaigns(request);
	}
	
	public void filterRequest(final List<MsnEditorialApiFaultDetail> msnList)
	{
		final CampaignNegativeKeywords[] keywords = request.getCampaignNegativeKeywords();
		final Map<Integer, String> indexToCommentMap = getIndexToCommentMapOfBadItems(msnList);
		final List<CampaignNegativeKeywords> filteredKeywords = new ArrayList<CampaignNegativeKeywords>();
		for (int i = 0; i < keywords.length; ++i)
		{
			final CampaignNegativeKeywords currentKeyword = keywords[i];
			if (!indexToCommentMap.containsKey(i))
			{
				filteredKeywords.add(currentKeyword);
			}
			else
			{
				final String comment = indexToCommentMap.get(i);
				final Integer keyworkPk = keywordToPkMap.get(currentKeyword);
				filteredOutKeywordPkToCommentMap.put(keyworkPk, comment);
			}
		}
		final CampaignNegativeKeywords[] filteredKeywordArray = filteredKeywords.toArray(new CampaignNegativeKeywords[filteredKeywords.size()]);
		request.setCampaignNegativeKeywords(filteredKeywordArray);
	}
}
