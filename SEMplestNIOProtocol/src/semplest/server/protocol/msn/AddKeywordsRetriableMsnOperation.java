package semplest.server.protocol.msn;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	
	public AddKeywordsRetriableMsnOperation(ICampaignManagementService campaignManagement, AddKeywordsRequest request, final Integer maxRetries)
	{
		super(maxRetries);
		this.campaignManagement = campaignManagement;
		this.request = request;
	}
			
	@Override
	protected AddKeywordsResponse porformCustomOperation() throws AdApiFaultDetail, EditorialApiFaultDetail, RemoteException
	{
		logger.info("Will try to add " + request.getKeywords().length + " Keywords");
		return campaignManagement.addKeywords(request);
	}
	
	public void filterRequest(final List<MsnEditorialApiFaultDetail> msnList)
	{
		final Set<Integer> indecesOfBadKeywords = getIndexesOfBadItems(msnList);
		final Keyword[] keywords = request.getKeywords();
		final List<Keyword> filteredKeywords = new ArrayList<Keyword>();
		for (int i = 0; i < keywords.length; ++i)
		{
			if (!indecesOfBadKeywords.contains(i))
			{
				filteredKeywords.add(keywords[i]);
			}
		}
		final Keyword[] filteredKeywordArray = filteredKeywords.toArray(new Keyword[filteredKeywords.size()]);
		request.setKeywords(filteredKeywordArray);
	}
}
