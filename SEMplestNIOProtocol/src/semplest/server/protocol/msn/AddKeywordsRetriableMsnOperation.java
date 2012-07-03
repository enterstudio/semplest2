package semplest.server.protocol.msn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import semplest.server.protocol.google.MsnEditorialApiFaultDetail;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.v8.AddKeywordsRequest;
import com.microsoft.adcenter.v8.AddKeywordsResponse;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.ICampaignManagementService;
import com.microsoft.adcenter.v8.Keyword;

public class AddKeywordsRetriableMsnOperation extends AbstractRetriableMsnOperation<AddKeywordsResponse>
{
	private static final Logger logger = Logger.getLogger(AddKeywordsRetriableMsnOperation.class);
	
	private final ICampaignManagementService campaignManagement;
	private final AddKeywordsRequest request;
	private final Map<Integer, String> filteredOutKeywordPkToCommentMap = new HashMap<Integer, String>();
	private final Map<Keyword, Integer> keywordToPkMap;
	
	public AddKeywordsRetriableMsnOperation(final ICampaignManagementService campaignManagement, final AddKeywordsRequest request, final Map<Keyword, Integer> keywordToPkMap, final Integer maxRetries)
	{
		super(maxRetries);
		this.campaignManagement = campaignManagement;
		this.request = request;
		this.keywordToPkMap = keywordToPkMap;
	}
		
	public AddKeywordsRequest getAddKeywordsRequest()
	{
		return request;
	}
	
	public Map<Integer, String> getFilteredOutKeywordPkToCommentMap()
	{
		return filteredOutKeywordPkToCommentMap;
	}
			
	@Override
	protected AddKeywordsResponse porformCustomOperation() throws AdApiFaultDetail, EditorialApiFaultDetail, RemoteException
	{
		logger.info("Will try to add " + request.getKeywords().length + " Keywords");
		return campaignManagement.addKeywords(request);
	}
	
	public void filterRequest(final List<MsnEditorialApiFaultDetail> msnList)
	{
		final Keyword[] keywords = request.getKeywords();
		final Map<Integer, String> indexToCommentMap = getIndexToCommentMapOfBadItems(msnList);
		final List<Keyword> filteredKeywords = new ArrayList<Keyword>();
		for (int i = 0; i < keywords.length; ++i)
		{
			final Keyword currentKeyword = keywords[i];
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
		final Keyword[] filteredKeywordArray = filteredKeywords.toArray(new Keyword[filteredKeywords.size()]);
		request.setKeywords(filteredKeywordArray);
	}
}
