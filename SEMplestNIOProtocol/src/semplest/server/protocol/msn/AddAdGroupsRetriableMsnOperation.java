package semplest.server.protocol.msn;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.server.protocol.google.MsnEditorialApiFaultDetail;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.v8.AddAdGroupsRequest;
import com.microsoft.adcenter.v8.AddAdGroupsResponse;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.ICampaignManagementService;

public class AddAdGroupsRetriableMsnOperation extends AbstractRetriableMsnOperation<AddAdGroupsResponse>
{
	private static final Logger logger = Logger.getLogger(AddAdGroupsRetriableMsnOperation.class);
	
	private final ICampaignManagementService campaignManagement;
	private final AddAdGroupsRequest request;
	
	public AddAdGroupsRetriableMsnOperation(final ICampaignManagementService campaignManagement, final AddAdGroupsRequest request, final Integer maxRetries)
	{
		super(maxRetries);
		this.campaignManagement = campaignManagement;
		this.request = request;
	}
		
	public AddAdGroupsRequest getAddKeywordsRequest()
	{
		return request;
	}
				
	@Override
	protected AddAdGroupsResponse porformCustomOperation() throws AdApiFaultDetail, EditorialApiFaultDetail, RemoteException
	{
		final Long campaignId = request.getCampaignId();
		logger.info("Will try to process AddAdGroupsRequest for CampaignID [" + campaignId + "]");
		return campaignManagement.addAdGroups(request);
	}
	
	@Override
	public void filterRequest(final List<MsnEditorialApiFaultDetail> msnList)
	{
		logger.info("Not filtering out any AdGroups, will try to process again if still under the retry limit");
	}
}
