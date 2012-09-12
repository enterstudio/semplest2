package semplest.server.protocol.msn;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.server.protocol.google.MsnEditorialApiFaultDetail;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.ICampaignManagementService;
import com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest;
import com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse;

public class SubmitAdGroupRequestRetriableMsnOperation extends AbstractRetriableMsnOperation<SubmitAdGroupForApprovalResponse>
{
	private static final Logger logger = Logger.getLogger(SubmitAdGroupRequestRetriableMsnOperation.class);
	
	private final ICampaignManagementService campaignManagement;
	private final SubmitAdGroupForApprovalRequest request;
	
	public SubmitAdGroupRequestRetriableMsnOperation(final ICampaignManagementService campaignManagement, final SubmitAdGroupForApprovalRequest request, final Integer maxRetries)
	{
		super(maxRetries);
		this.campaignManagement = campaignManagement;
		this.request = request;
	}
				
	@Override
	protected SubmitAdGroupForApprovalResponse porformCustomOperation() throws AdApiFaultDetail, EditorialApiFaultDetail, RemoteException
	{
		final Long adGroupId = request.getAdGroupId();
		logger.info("Will try to process SubmitAdGroupForApprovalRequest for AdGroupID [" + adGroupId + "]");
		return campaignManagement.submitAdGroupForApproval(request);
	}
	
	@Override
	public void filterRequest(final List<MsnEditorialApiFaultDetail> msnList)
	{
		logger.info("Not filtering out any SubmitAdGroupForApprovalRequests, will try to process again if still under the retry limit");
	}
}
