package semplest.service.msn.adcenter;

import static semplest.service.msn.adcenter.MsnDomainObjects.aNew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.joda.time.DateTime;

import semplest.other.AdCenterCredentials;
import semplest.other.KeywordEstimate;
import semplest.other.Maybe;
import semplest.other.Money;
import semplest.other.MsnTime;
import semplest.other.SemplestError;
import semplest.other.TimeServer;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolJSON;
import au.com.bytecode.opencsv.CSVReader;

import com.google.gson.Gson;
import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.BasicHttpBinding_ICustomerManagementServiceStub;
import com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceLocator;
import com.microsoft.adcenter.api.customermanagement.GetAccountRequest;
import com.microsoft.adcenter.api.customermanagement.GetAccountResponse;
import com.microsoft.adcenter.api.customermanagement.ICustomerManagementService;
import com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest;
import com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType;
import com.microsoft.adcenter.api.customermanagement.Entities.Customer;
import com.microsoft.adcenter.api.customermanagement.Entities.User;
import com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
import com.microsoft.adcenter.v8.AccountThroughAdGroupReportScope;
import com.microsoft.adcenter.v8.AccountThroughCampaignReportScope;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.AdIntelligenceServiceLocator;
import com.microsoft.adcenter.v8.AddAdGroupsRequest;
import com.microsoft.adcenter.v8.AddAdGroupsResponse;
import com.microsoft.adcenter.v8.AddAdsRequest;
import com.microsoft.adcenter.v8.AddAdsResponse;
import com.microsoft.adcenter.v8.AddCampaignsRequest;
import com.microsoft.adcenter.v8.AddCampaignsResponse;
import com.microsoft.adcenter.v8.AddKeywordsRequest;
import com.microsoft.adcenter.v8.AddKeywordsResponse;
import com.microsoft.adcenter.v8.AddTargetsToLibraryRequest;
import com.microsoft.adcenter.v8.AddTargetsToLibraryResponse;
import com.microsoft.adcenter.v8.ApiFaultDetail;
import com.microsoft.adcenter.v8.BasicHttpBinding_IAdIntelligenceServiceStub;
import com.microsoft.adcenter.v8.BasicHttpBinding_ICampaignManagementServiceStub;
import com.microsoft.adcenter.v8.BasicHttpBinding_IReportingServiceStub;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignManagementServiceLocator;
import com.microsoft.adcenter.v8.CampaignPerformanceReportColumn;
import com.microsoft.adcenter.v8.CampaignPerformanceReportFilter;
import com.microsoft.adcenter.v8.CampaignPerformanceReportRequest;
import com.microsoft.adcenter.v8.CampaignReportScope;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.CityTarget;
import com.microsoft.adcenter.v8.CityTargetBid;
import com.microsoft.adcenter.v8.DeleteAdGroupsRequest;
import com.microsoft.adcenter.v8.DeleteAdsRequest;
import com.microsoft.adcenter.v8.DeleteCampaignsRequest;
import com.microsoft.adcenter.v8.DeleteKeywordsRequest;
import com.microsoft.adcenter.v8.DeleteTargetFromAdGroupRequest;
import com.microsoft.adcenter.v8.DeleteTargetFromCampaignRequest;
import com.microsoft.adcenter.v8.DeleteTargetsFromLibraryRequest;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdRequest;
import com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse;
import com.microsoft.adcenter.v8.GetAdGroupsByIdsRequest;
import com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse;
import com.microsoft.adcenter.v8.GetAdsByAdGroupIdRequest;
import com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse;
import com.microsoft.adcenter.v8.GetAdsByIdsRequest;
import com.microsoft.adcenter.v8.GetAdsByIdsResponse;
import com.microsoft.adcenter.v8.GetCampaignsByAccountIdRequest;
import com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse;
import com.microsoft.adcenter.v8.GetCampaignsByIdsRequest;
import com.microsoft.adcenter.v8.GetCampaignsByIdsResponse;
import com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest;
import com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse;
import com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdRequest;
import com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse;
import com.microsoft.adcenter.v8.GetKeywordsByIdsRequest;
import com.microsoft.adcenter.v8.GetKeywordsByIdsResponse;
import com.microsoft.adcenter.v8.GetTargetByAdGroupIdRequest;
import com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse;
import com.microsoft.adcenter.v8.GetTargetsByCampaignIdsRequest;
import com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse;
import com.microsoft.adcenter.v8.IAdIntelligenceService;
import com.microsoft.adcenter.v8.ICampaignManagementService;
import com.microsoft.adcenter.v8.IReportingService;
import com.microsoft.adcenter.v8.IncrementalBidPercentage;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.KeywordPerformanceReportColumn;
import com.microsoft.adcenter.v8.KeywordPerformanceReportFilter;
import com.microsoft.adcenter.v8.KeywordPerformanceReportRequest;
import com.microsoft.adcenter.v8.LocationTarget;
import com.microsoft.adcenter.v8.MetroAreaTarget;
import com.microsoft.adcenter.v8.MetroAreaTargetBid;
import com.microsoft.adcenter.v8.PauseAdsRequest;
import com.microsoft.adcenter.v8.PauseCampaignsRequest;
import com.microsoft.adcenter.v8.PauseKeywordsRequest;
import com.microsoft.adcenter.v8.PollGenerateReportRequest;
import com.microsoft.adcenter.v8.PollGenerateReportResponse;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.ReportFormat;
import com.microsoft.adcenter.v8.ReportLanguage;
import com.microsoft.adcenter.v8.ReportRequest;
import com.microsoft.adcenter.v8.ReportRequestStatus;
import com.microsoft.adcenter.v8.ReportRequestStatusType;
import com.microsoft.adcenter.v8.ReportTime;
import com.microsoft.adcenter.v8.ReportingServiceLocator;
import com.microsoft.adcenter.v8.ResumeAdsRequest;
import com.microsoft.adcenter.v8.ResumeCampaignsRequest;
import com.microsoft.adcenter.v8.SetTargetToAdGroupRequest;
import com.microsoft.adcenter.v8.SetTargetToCampaignRequest;
import com.microsoft.adcenter.v8.StateTarget;
import com.microsoft.adcenter.v8.StateTargetBid;
import com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest;
import com.microsoft.adcenter.v8.SubmitGenerateReportRequest;
import com.microsoft.adcenter.v8.SubmitGenerateReportResponse;
import com.microsoft.adcenter.v8.Target;
import com.microsoft.adcenter.v8.TextAd;
import com.microsoft.adcenter.v8.UpdateAdsRequest;
import com.microsoft.adcenter.v8.UpdateCampaignsRequest;
import com.microsoft.adcenter.v8.UpdateKeywordsRequest;

public class MsnCloudServiceImpl implements semplest.services.client.interfaces.MsnAdcenterServiceInterface //MsnCloudService
{
	private static final Logger LOG = Logger.getLogger(MsnCloudServiceImpl.class);

	/**
	 * Public methods in this class should throw only 2 kinds of exceptions:
	 * {@link MsnCloudServiceConnectionException} (meaning a timeout, failed to
	 * connect or other problem TALKING to MSN) and
	 * {@link MsnCloudInvalidResponse} meaning a broken protocol (MSN responded
	 * with the wrong thing, meaning a bug on their system or our interface
	 * assumptions are wrong).
	 **/

	private final static long NO_CUSTOMER_ID = Long.MIN_VALUE;

	public static final int DEFAULT_TIMEOUT = 80000; // 80 seconds. See
														// setTimeout :P
	private final NameServiceUniqueMsn uniqueMsnNameService;
	private final AdCenterCredentials adCenterCredentials;
	private int timeoutMillis = DEFAULT_TIMEOUT;
	private final TimeServer timeServer;
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	//private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(MsnCloudServiceImpl.class);

	@Override
	public boolean isProduction()
	{
		return adCenterCredentials.isProduction();
	}

	/**
	 * Timeout used internally by soap connections. This means that requests
	 * sent out will not wait forever, instead they will timeout after these
	 * milliseconds and fail.
	 */
	@Override
	public void setTimeout(int milliseconds)
	{
		this.timeoutMillis = milliseconds;
	}

	public MsnCloudServiceImpl(AdCenterCredentials adCenterCredentials, TimeServer timeServer)
	{
		this(new NameServiceUniqueMsnPsuedoRandom(), adCenterCredentials, timeServer);
	}

	public MsnCloudServiceImpl(NameServiceUniqueMsn uniqueMsnUserNameService, AdCenterCredentials adCenterCredentials, TimeServer timeServer)
	{
		this.uniqueMsnNameService = uniqueMsnUserNameService;
		this.adCenterCredentials = adCenterCredentials;
		this.timeServer = timeServer;
	}

	// ==================================
	// Account Methods
	// ==================================
	
	public String createAccount(String json) throws Exception
	{
		logger.debug("call createAccount(String[] json)" + json);
		HashMap<String,String> data = protocolJson.getHashMapFromJson(json);
		String[] input = {data.get("name"),null};
		MsnManagementIds mngId = createAccount(input);
		//convert result to Json String
		return gson.toJson(mngId);
	}
	
	@Override
	public MsnManagementIds createAccount(String[] name) throws MsnCloudException
	{
		Customer customer = aNew().adCenterCustomer().withCustomerName(name[0]).build();
		User user = aNew().adCenterUser().withUserName(name[0]).build();
		Account account = aNew().adCenterAccount().withAccountName(name[0]).build();

		try
		{
			ICustomerManagementService customerManagementService = getCustomerManagementService();
			SignupCustomerResponse signupCustomerResponse = customerManagementService.signupCustomer(new SignupCustomerRequest(customer, user,
					account, adCenterCredentials.getParentCustomerID(), ApplicationType.Advertiser));
			return new MsnManagementIds(signupCustomerResponse.getAccountId(), signupCustomerResponse.getCustomerId(),
					(long) signupCustomerResponse.getUserId());
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException(e);
		}
		catch (ApiFault e)
		{
			throw new MsnCloudException(e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException(e);
		}
	}

	@Override
	public Account getAccountById(Long accountId) throws MsnCloudException
	{
		GetAccountResponse account;
		try
		{
			ICustomerManagementService customerManagementService = getCustomerManagementService();
			account = customerManagementService.getAccount(new GetAccountRequest(accountId));
			return account.getAccount();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException(e);
		}
		catch (ApiFault e)
		{
			throw new MsnCloudException(e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException(e);
		}
	}

	// ==================================
	// Campaign Methods
	// ==================================
	@Override
	public Long createCampaign(Long accountId, String campaignName, double dailyBudget, double monthlyBudget, CampaignStatus CampaignStatus)
			throws MsnCloudException
	{
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			Campaign newCampaign = aNew().campaign().withName(campaignName).with(CampaignStatus)
					.with(BudgetLimitType.MonthlyBudgetSpendUntilDepleted).withDailyBudget(dailyBudget).withMonthlyBudget(monthlyBudget).build();
			AddCampaignsResponse addCampaigns;
			addCampaigns = campaignManagement.addCampaigns(new AddCampaignsRequest((long) accountId, new Campaign[]
			{ newCampaign }));
			return addCampaigns.getCampaignIds()[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException(e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException(e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException(e);
		}
	}

	@Override
	public Campaign getCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetCampaignsByIdsResponse campaignsById = campaignManagement.getCampaignsByIds(new GetCampaignsByIdsRequest((long) accountId, new long[]
		{ campaignId }));
		return campaignsById.getCampaigns()[0];
	}

	@Override
	public Campaign[] getCampaignsByAccountId(Long accountId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetCampaignsByAccountIdResponse campaigns = campaignManagement.getCampaignsByAccountId(new GetCampaignsByAccountIdRequest((long) accountId));
		return campaigns.getCampaigns();
	}

	@Override
	public void pauseCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.pauseCampaigns(new PauseCampaignsRequest((long) accountId, new long[]
		{ campaignId }));
	}

	@Override
	public void pauseCampaignsByAccountId(Long accountId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		Campaign[] campaigns = getCampaignsByAccountId(accountId);

		int length = campaigns.length;
		long[] campaignIds = new long[length];
		for (int i = 0, size = length; i < size; i++)
		{
			campaignIds[i] = campaigns[i].getId();
		}

		campaignManagement.pauseCampaigns(new PauseCampaignsRequest((long) accountId, campaignIds));
	}

	@Override
	public void resumeCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.resumeCampaigns(new ResumeCampaignsRequest((long) accountId, new long[]
		{ campaignId }));
	}

	@Override
	public void deleteCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.deleteCampaigns(new DeleteCampaignsRequest((long) accountId, new long[]
		{ campaignId }));
	}

	@Override
	public void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeStateTargets(states);

		long statesTargetId = addTargetsToLibrary(campaignManagement, targets);
		SetTargetToCampaignRequest setTargetToCampaignRequest = new SetTargetToCampaignRequest(campaignId, statesTargetId);
		campaignManagement.setTargetToCampaign(setTargetToCampaignRequest);
	}

	@Override
	public void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target campaignTargets = getCampaignTargets(accountId, customerId, campaignId);
		campaignManagement.deleteTargetFromCampaign(new DeleteTargetFromCampaignRequest(campaignId));
		DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest = new DeleteTargetsFromLibraryRequest(new long[]
		{ campaignTargets.getId() });
		campaignManagement.deleteTargetsFromLibrary(deleteTargetsFromLibraryRequest);
	}

	@Override
	public Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		long[] campaignIds =
		{ campaignId };
		GetTargetsByCampaignIdsRequest getTargetsByCampaignIdsRequest = new GetTargetsByCampaignIdsRequest(campaignIds);
		GetTargetsByCampaignIdsResponse targetsByCampaignIds = campaignManagement.getTargetsByCampaignIds(getTargetsByCampaignIdsRequest);
		Target[] targets = targetsByCampaignIds.getTargets();
		if ((targets == null) || (targets.length == 0))
		{
			return null;
		}
		return targets[0];
	}

	@Override
	public void updateCampaignBudget(Long accountId, Long campaignId, double dailyBudget, double monthlyBudget) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);

		Campaign campaign = new Campaign();
		campaign.setId(campaignId);
		campaign.setDailyBudget(dailyBudget);
		campaign.setMonthlyBudget(monthlyBudget);
		Campaign[] campaigns = new Campaign[]
		{ campaign };

		UpdateCampaignsRequest updateCampaignsRequest = new UpdateCampaignsRequest();
		updateCampaignsRequest.setAccountId((long) accountId);
		updateCampaignsRequest.setCampaigns(campaigns);

		campaignManagement.updateCampaigns(updateCampaignsRequest);
	}

	// ==================================
	// AdGroup Methods
	// ==================================
	@Override
	public long createAdGroup(Long accountId, Long campaignId) throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		String nextAdGroupName = uniqueMsnNameService.getNextAdGroupName();
		AdGroup build = aNew().adGroup().withName(nextAdGroupName).build();
		AddAdGroupsResponse addAdGroups = campaignManagement.addAdGroups(new AddAdGroupsRequest(campaignId, new AdGroup[]
		{ build }));
		final Long adGroupId = addAdGroups.getAdGroupIds()[0];
		SubmitAdGroupForApprovalRequest submitAdGroupRequest = new SubmitAdGroupForApprovalRequest();
		submitAdGroupRequest.setAdGroupId(adGroupId);
		campaignManagement.submitAdGroupForApproval(submitAdGroupRequest);
		return adGroupId;
	}

	public String getAdGroupsByCampaignId(String json) throws Exception
	{
		logger.debug("call getAdGroupsByCampaignId(String json)" + json);
		HashMap<String,String> data = protocolJson.getHashMapFromJson(json);
		AdGroup[] adgroups = getAdGroupsByCampaignId(new Long(data.get("accountId")),new Long (data.get("campaignId")));
		//convert result to Json String
		return gson.toJson(adgroups);
		//return "{  \"adgroupName\" : \"" + adgroups[0].getName() + "\" }";
	}
	@Override
	public AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws RemoteException
	{
		logger.debug("accountid=" + accountId + " campaignId =" + campaignId);
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdGroupsByCampaignIdResponse adGroups = campaignManagement.getAdGroupsByCampaignId(new GetAdGroupsByCampaignIdRequest(campaignId));
		return adGroups.getAdGroups();
	}

	@Override
	public AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdGroupsByIdsResponse adGroupsByIds = campaignManagement.getAdGroupsByIds(new GetAdGroupsByIdsRequest(campaignId, new long[]
		{ adGroupId }));
		return adGroupsByIds.getAdGroups()[0];
	}

	@Override
	public void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.deleteAdGroups(new DeleteAdGroupsRequest(campaignId, new long[]
		{ adGroupId }));
	}

	@Override
	public void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeStateTargets(states);
		addTargetsToAdGroup(adGroupId, campaignManagement, targets);
	}

	@Override
	public void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws RemoteException, ApiFaultDetail,
			AdApiFaultDetail, EditorialApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeCityTargets(cities);
		addTargetsToAdGroup(adGroupId, campaignManagement, targets);
	}

	@Override
	public void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws RemoteException,
			ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeMetroAreaTargets(metroTargets);
		addTargetsToAdGroup(msnAdGroupId, campaignManagement, targets);
	}

	
	private void addTargetsToAdGroup(Long adGroupId, ICampaignManagementService campaignManagement, Target[] targets) throws RemoteException,
			AdApiFaultDetail, ApiFaultDetail
	{
		long targetId = addTargetsToLibrary(campaignManagement, targets);

		SetTargetToAdGroupRequest setTargetToCampaignRequest = new SetTargetToAdGroupRequest(adGroupId, targetId);
		campaignManagement.setTargetToAdGroup(setTargetToCampaignRequest);
	}

	@Override
	public void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws RemoteException
	{
		Target adGroupTargets = getAdGroupTargets(accountId, customerId, adGroupId);
		if (adGroupTargets == null)
		{
			return;
		}
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		campaignManagement.deleteTargetFromAdGroup(new DeleteTargetFromAdGroupRequest(adGroupId));
		DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest = new DeleteTargetsFromLibraryRequest(new long[]
		{ adGroupTargets.getId() });
		campaignManagement.deleteTargetsFromLibrary(deleteTargetsFromLibraryRequest);
	}

	@Override
	public Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		GetTargetByAdGroupIdRequest getTargetByAdGroupIdRequest = new GetTargetByAdGroupIdRequest(adGroupId);
		GetTargetByAdGroupIdResponse targetByAdGroupId = campaignManagement.getTargetByAdGroupId(getTargetByAdGroupIdRequest);
		return targetByAdGroupId.getTarget();
	}

	// ==================================
	// Ad Methods
	// ==================================
	@Override
	public long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws RemoteException,
			ApiFaultDetail, AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		TextAd ad = new TextAd();
		ad.setText(text);
		ad.setTitle(title);
		ad.setDisplayUrl(displayUrl);
		ad.setDestinationUrl(destinationUrl);
		// ad.setEditorialStatus(AdEditorialStatus.Active);
		// TextAd ad =
		// aNew().textAd().withTitle(title).withText(text).withDisplayUrl(displayUrl).withDestinationUrl(destinationUrl).build();
		AddAdsResponse addAds = campaignManagement.addAds(new AddAdsRequest(adGroupId, new Ad[]
		{ ad }));
		return addAds.getAdIds()[0];
	}

	@Override
	public Ad getAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdsByIdsResponse adsByIds = campaignManagement.getAdsByIds(new GetAdsByIdsRequest(adGroupId, new long[]
		{ adId }));
		return adsByIds.getAds()[0];
	}

	@Override
	public Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdsByAdGroupIdResponse ads = campaignManagement.getAdsByAdGroupId(new GetAdsByAdGroupIdRequest(adGroupId));
		return ads.getAds();
	}

	@Override
	public void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl)
			throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);

		Ad ad = getAdById(accountId, adGroupId, adId);
		ad.setEditorialStatus(null);
		ad.setStatus(null);
		if (ad instanceof TextAd)
		{
			TextAd textAd = (TextAd) ad;
			textAd.setTitle(title);
			textAd.setText(text);
			textAd.setDisplayUrl(displayUrl);
			textAd.setDestinationUrl(destinationUrl);
		}
		campaignManagement.updateAds(new UpdateAdsRequest(adGroupId, new Ad[]
		{ ad }));
	}

	@Override
	public void pauseAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.pauseAds(new PauseAdsRequest(adGroupId, new long[]
		{ adId }));
	}

	@Override
	public void resumeAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.resumeAds(new ResumeAdsRequest(adGroupId, new long[]
		{ adId }));
	}

	@Override
	public void deleteAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.deleteAds(new DeleteAdsRequest(adGroupId, new long[]
		{ adId }));
	}

	// ==================================
	// Keyword Methods
	// ==================================
	@Override
	public long createKeyword(Long accountId, Long adGroupId, String text, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid,
			Bid phraseMatchBid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		Keyword keyword = aNew().keyword().withText(text).withBroadMatchBid(broadMatchBid).withContentMatchBid(contentMatchBid)
				.withExactMatchBid(exactMatchBid).withPhraseMatchBid(phraseMatchBid).build();
		AddKeywordsResponse addKeywords = campaignManagement.addKeywords(new AddKeywordsRequest(adGroupId, new Keyword[]
		{ keyword }));
		return addKeywords.getKeywordIds()[0];
	}

	public long[] createKeywords(Long accountId, Long adGroupId, MsnCloudKeywordProxy... keywords) throws RemoteException, ApiFaultDetail,
			AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		int length = keywords.length;
		Keyword[] keywordsMsn = new Keyword[length];
		for (int i = 0; i < length; i++)
		{
			MsnCloudKeywordProxy msnSemKeyword = keywords[i];
			keywordsMsn[i] = aNew().keyword().withText(msnSemKeyword.getText()).withBroadMatchBid(msnSemKeyword.getBroadMatchBid())
					.withContentMatchBid(msnSemKeyword.getContentMatchBid()).withExactMatchBid(msnSemKeyword.getExactMatchBid())
					.withPhraseMatchBid(msnSemKeyword.getPhraseMatchBid()).build();
		}
		AddKeywordsResponse addKeywords = campaignManagement.addKeywords(new AddKeywordsRequest(adGroupId, keywordsMsn));
		return addKeywords.getKeywordIds();
	}

	@Override
	public Maybe<Keyword> getKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetKeywordsByIdsResponse keywordsByIds = campaignManagement.getKeywordsByIds(new GetKeywordsByIdsRequest(adGroupId, new long[]
		{ keywordId }));
		Keyword[] keywords = keywordsByIds.getKeywords();
		if (keywords.length == 1 && keywords[0] != null)
		{
			return Maybe.just(keywords[0]);
		}
		return Maybe.nothing();
	}

	@Override
	public Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetKeywordsByAdGroupIdResponse keywordsByAdGroupId = campaignManagement.getKeywordsByAdGroupId(new GetKeywordsByAdGroupIdRequest(adGroupId));
		return keywordsByAdGroupId.getKeywords();
	}

	@Override
	public void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid,
			Bid phraseMatchBid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		Keyword keyword = new Keyword();
		keyword.setId(keywordId);
		keyword.setBroadMatchBid(broadMatchBid);
		keyword.setContentMatchBid(contentMatchBid);
		keyword.setExactMatchBid(exactMatchBid);
		keyword.setPhraseMatchBid(phraseMatchBid);
		campaignManagement.updateKeywords(new UpdateKeywordsRequest(adGroupId, new Keyword[]
		{ keyword }));
	}

	@Override
	public void updateKeywordBidsByIds(Long accountId, Long adGroupId, long[] keywordId, Bid[] broadMatchBid, Bid[] contentMatchBid,
			Bid[] exactMatchBid, Bid[] phraseMatchBid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		if (keywordId == null)
		{
			return;
		}

		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);

		int len = keywordId.length;
		Keyword[] ret = new Keyword[len];
		for (int i = 0; i < len; i++)
		{
			ret[i] = makeKeywordFromArrays(i, keywordId, broadMatchBid, contentMatchBid, exactMatchBid, phraseMatchBid);
		}

		campaignManagement.updateKeywords(new UpdateKeywordsRequest(adGroupId, ret));
	}

	private Keyword makeKeywordFromArrays(int index, long[] keywordId, Bid[] broadMatchBidArr, Bid[] contentMatchBidArr, Bid[] exactMatchBidArr,
			Bid[] phraseMatchBidArr)
	{
		long id = keywordId[index];
		Bid broadMatchBid = (broadMatchBidArr == null ? null : broadMatchBidArr[index]);
		Bid contentMatchBid = (contentMatchBidArr == null ? null : contentMatchBidArr[index]);
		Bid exactMatchBid = (exactMatchBidArr == null ? null : exactMatchBidArr[index]);
		Bid phraseMatchBid = (phraseMatchBidArr == null ? null : phraseMatchBidArr[index]);
		return aNew().keyword().withText(null).with(id).withBroadMatchBid(broadMatchBid).withContentMatchBid(contentMatchBid)
				.withExactMatchBid(exactMatchBid).withPhraseMatchBid(phraseMatchBid).build();
	}

	@Override
	public void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.pauseKeywords(new PauseKeywordsRequest(adGroupId, new long[]
		{ keywordId }));
	}

	public void pauseKeywordsByIds(Long accountId, Long adGroupId, long[] keywordIds) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.pauseKeywords(new PauseKeywordsRequest(adGroupId, keywordIds));
	}

	@Override
	public void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.deleteKeywords(new DeleteKeywordsRequest(adGroupId, new long[]
		{ keywordId }));
	}

	@Override
	public void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		campaignManagement.deleteKeywords(new DeleteKeywordsRequest(adGroupId, keywordIds));
	}

	// ==================================
	// Keyword Estimates
	// ==================================
	// @Override
	// public KeywordEstimate getKeywordEstimateByBid(Long accountId, String
	// keyword, double broadMatchBid, double exactMatchBid, double
	// phraseMatchBid) throws RemoteException, ApiFaultDetail,
	// MsnServiceException {
	//
	// KeywordEstimate[] keywordEstimates = getKeywordEstimateByBids(accountId,
	// new String[] { keyword }, new double[] { broadMatchBid }, new double[] {
	// exactMatchBid }, new double[] { phraseMatchBid });
	// return keywordEstimates[0];
	// }
	//

	@Override
	public KeywordEstimatedPosition[] getKeywordEstimateByBids(String[] keywords, Money bid) throws MsnCloudException
	{
		try
		{
			IAdIntelligenceService adInteligenceService = getAdInteligenceService(adCenterCredentials.getParentCustomerID());
			GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest = new GetEstimatedPositionByKeywordsRequest(keywords,
					bid.getDoubleDollars(), "English", new String[]
					{ "US" }, Currency.USDollar, new MatchType[]
					{ MatchType.Exact, MatchType.Phrase, MatchType.Broad });
			GetEstimatedPositionByKeywordsResponse estimatedPositionByKeywords;
			estimatedPositionByKeywords = adInteligenceService.getEstimatedPositionByKeywords(getEstimatedPositionByKeywordsRequest);
			return estimatedPositionByKeywords.getKeywordEstimatedPositions();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException(e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException(e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException(e);
		}
	}

	//
	// private KeywordEstimate[] getKeywordEstimateByBidsMsn(Long accountId,
	// List<KeywordBid> keywordBids) throws RemoteException, AdApiFaultDetail,
	// ApiFaultDetail {
	// if (keywordBids.size() < 1) {
	// return new KeywordEstimate[0];
	// }
	// GetKeywordEstimatesByBidsRequest request = new
	// GetKeywordEstimatesByBidsRequest();
	// request.setAccountId((long) accountId);
	// request.setCurrency(CurrencyType._USDollar);
	// request.setKeywordBids(keywordBids.toArray(new KeywordBid[0]));
	// PricingModel pricingModel = PricingModel.Cpc;
	// request.setPricingModel(pricingModel);
	//
	// ICampaignManagementService campaignManagementService =
	// getCampaignManagementService(accountId);
	// GetKeywordEstimatesByBidsResponse keywordEstimatesByBids =
	// campaignManagementService.getKeywordEstimatesByBids(request);
	// return keywordEstimatesByBids.getKeywordEstimates();
	// }
	//
	// private KeywordBid makeKeywordBid(String keyword, double broadMatchBid,
	// double exactMatchBid, double phraseMatchBid) {
	// KeywordBidBuilder keywordBidBuilder = aNew().keywordBid().with(keyword);
	// KeywordBid keywordBid = keywordBidBuilder.build();
	// keywordBid.setBroadMatchBid(broadMatchBid);
	// keywordBid.setExactMatchBid(exactMatchBid);
	// keywordBid.setPhraseMatchBid(phraseMatchBid);
	// return keywordBid;
	// }

	// ==================================
	// Target Methods
	// ==================================
	private long addTargetsToLibrary(ICampaignManagementService campaignManagement, Target[] targets) throws RemoteException
	{
		AddTargetsToLibraryRequest addTargetsToLibraryRequest = new AddTargetsToLibraryRequest();
		addTargetsToLibraryRequest.setTargets(targets);

		AddTargetsToLibraryResponse addTargetsToLibraryResponse = campaignManagement.addTargetsToLibrary(addTargetsToLibraryRequest);
		long[] targetIds = addTargetsToLibraryResponse.getTargetIds();
		return targetIds[0];
	}

	private Target[] makeStateTargets(List<String> states)
	{
		int size = states.size();
		StateTargetBid[] bids = new StateTargetBid[size];
		for (int i = 0; i < size; i++)
		{
			bids[i] = new StateTargetBid(IncrementalBidPercentage.ZeroPercent, states.get(i)); // We
																								// set
																								// extra
																								// bit
																								// to
																								// zero
																								// and
																								// target
																								// all
																								// locations
																								// to
																								// false
																								// so
																								// we
																								// only
																								// hit
																								// the
																								// desired
																								// states
		}
		StateTarget stateTarget = new StateTarget(bids);

		LocationTarget location = new LocationTarget();
		location.setStateTarget(stateTarget);
		location.setTargetAllLocations(false); // We set extra bit to zero and
												// target all locations to false
												// so we only hit the desired
												// states

		Target target = new Target();
		target.setLocation(location);
		target.setName("States Targets");
		Target[] targets =
		{ target };
		return targets;
	}

	private Target[] makeCityTargets(List<String> city)
	{
		int size = city.size();
		CityTargetBid[] bids = new CityTargetBid[size];
		for (int i = 0; i < size; i++)
		{
			CityTargetBid bid = new CityTargetBid(city.get(i), IncrementalBidPercentage.ZeroPercent);
			bids[i] = bid;
		}
		CityTarget cityTarget = new CityTarget(bids);

		LocationTarget location = new LocationTarget();
		location.setCityTarget(cityTarget);
		location.setTargetAllLocations(false);

		Target target = new Target();
		target.setLocation(location);
		Target[] targets =
		{ target };
		return targets;
	}

	private Target[] makeMetroAreaTargets(List<String> metroAreas)
	{
		int size = metroAreas.size();
		MetroAreaTargetBid[] bids = new MetroAreaTargetBid[size];
		for (int i = 0; i < size; i++)
		{
			MetroAreaTargetBid bid = new MetroAreaTargetBid(IncrementalBidPercentage.ZeroPercent, metroAreas.get(i));
			bids[i] = bid;
		}
		MetroAreaTarget metroAreaTarget = new MetroAreaTarget(bids);

		LocationTarget location = new LocationTarget();
		location.setMetroAreaTarget(metroAreaTarget);
		location.setTargetAllLocations(false);

		Target target = new Target();
		target.setLocation(location);
		Target[] targets =
		{ target };
		return targets;
	}

	@Override
	public String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation)
	{
		ReportTime time = new MsnTime(firstDay).reportTimeTill(lastDay, timeServer.now());
		return requestKeywordReport(accountId, campaignId, time, aggregation);
	}

	/**
	 * Request a report for account, campaign. Set campaignId == 0 to report on
	 * all campaigns.
	 */
	public String requestKeywordReport(Long accountId, Long campaignId, ReportTime time, ReportAggregation aggregation)
	{
		KeywordPerformanceReportColumn[] columns;
		if (aggregation == ReportAggregation.Summary)
		{
			columns = new KeywordPerformanceReportColumn[]
			{ KeywordPerformanceReportColumn.Keyword, KeywordPerformanceReportColumn.AveragePosition, KeywordPerformanceReportColumn.Impressions,
					KeywordPerformanceReportColumn.Clicks, KeywordPerformanceReportColumn.CurrentMaxCpc, KeywordPerformanceReportColumn.Conversions,
					KeywordPerformanceReportColumn.Spend, KeywordPerformanceReportColumn.AccountName, KeywordPerformanceReportColumn.AdDistribution,
					KeywordPerformanceReportColumn.AdGroupName, KeywordPerformanceReportColumn.CampaignName,
					KeywordPerformanceReportColumn.LanguageAndRegion
			// ,KeywordPerformanceReportColumn.AdType
			// ,KeywordPerformanceReportColumn.PricingModel
			};
		}
		else
		{
			columns = new KeywordPerformanceReportColumn[]
			{ KeywordPerformanceReportColumn.Keyword, KeywordPerformanceReportColumn.TimePeriod, KeywordPerformanceReportColumn.AveragePosition,
					KeywordPerformanceReportColumn.Impressions, KeywordPerformanceReportColumn.Clicks, KeywordPerformanceReportColumn.Conversions,
					KeywordPerformanceReportColumn.Spend, KeywordPerformanceReportColumn.CurrentMaxCpc, KeywordPerformanceReportColumn.AccountName,
					KeywordPerformanceReportColumn.AdDistribution, KeywordPerformanceReportColumn.AdGroupName,
					KeywordPerformanceReportColumn.CampaignName, KeywordPerformanceReportColumn.LanguageAndRegion
			// ,KeywordPerformanceReportColumn.AdType
			// ,KeywordPerformanceReportColumn.PricingModel
			};
		}

		final boolean returnOnlyCompleteData = false;
		final String reportName = "Keyword Report for Account " + accountId + " Campaign ";
		// Scope: this campaignId, all ad groups.
		final AccountThroughAdGroupReportScope scope = new AccountThroughAdGroupReportScope(null, null, new CampaignReportScope[]
		{ new CampaignReportScope(accountId, campaignId) });
		final KeywordPerformanceReportFilter filter = null;
		final KeywordPerformanceReportRequest request = new KeywordPerformanceReportRequest(ReportFormat.Csv, ReportLanguage.English, reportName
				+ campaignId, returnOnlyCompleteData, aggregation, columns, filter, scope, time);
		return sendReportRequest(accountId, request);
	}

	/**
	 * Request a report for account, campaign. Set campaignId == 0 to report on
	 * all campaigns.
	 * 
	 * @param accountId
	 * @param campaignId
	 */
	@Override
	public String requestCampaignReport(Long accountId, int campaignId, int daysInReport, ReportAggregation aggregation)
	{
		CampaignPerformanceReportColumn[] columns = new CampaignPerformanceReportColumn[]
		{ //
		CampaignPerformanceReportColumn.AccountName, CampaignPerformanceReportColumn.AccountNumber, CampaignPerformanceReportColumn.TimePeriod,
				CampaignPerformanceReportColumn.Status, CampaignPerformanceReportColumn.CampaignName, CampaignPerformanceReportColumn.CampaignId,
				CampaignPerformanceReportColumn.CurrencyCode, CampaignPerformanceReportColumn.AdDistribution,
				CampaignPerformanceReportColumn.Impressions, CampaignPerformanceReportColumn.Clicks, CampaignPerformanceReportColumn.Ctr,
				CampaignPerformanceReportColumn.AverageCpc, CampaignPerformanceReportColumn.Spend, CampaignPerformanceReportColumn.AveragePosition,
				CampaignPerformanceReportColumn.Conversions, CampaignPerformanceReportColumn.ConversionRate,
				CampaignPerformanceReportColumn.CostPerConversion, CampaignPerformanceReportColumn.LowQualityClicks,
				CampaignPerformanceReportColumn.LowQualityClicksPercent, CampaignPerformanceReportColumn.LowQualityImpressions,
				CampaignPerformanceReportColumn.LowQualityImpressionsPercent, CampaignPerformanceReportColumn.LowQualityConversions,
				CampaignPerformanceReportColumn.LowQualityConversionRate, CampaignPerformanceReportColumn.AverageCpm };

		final CampaignPerformanceReportFilter filter = null;
		final String title = "Weekly Campaign Report AccountId " + accountId + " CampaignId " + campaignId;
		final ReportLanguage language = ReportLanguage.English;
		final ReportFormat format = ReportFormat.Csv;
		final ReportTime time = new MsnTime(timeServer.now()).asReportTimeEndTimeWithStartingMinusDays(daysInReport);
		AccountThroughCampaignReportScope scope;
		if (campaignId == 0)
		{
			scope = new AccountThroughCampaignReportScope(new long[]
			{ accountId }, null);
		}
		else
		{
			CampaignReportScope[] campaigns = new CampaignReportScope[]
			{ new CampaignReportScope(accountId, campaignId) };
			scope = new AccountThroughCampaignReportScope(null, campaigns);
		}
		final boolean returnOnlyCompleteData = false;

		final CampaignPerformanceReportRequest reportRequest = new CampaignPerformanceReportRequest(format, language, title, returnOnlyCompleteData,
				aggregation, columns, filter, scope, time);

		return sendReportRequest(accountId, reportRequest);
	}

	public String sendReportRequest(Long accountId, final ReportRequest reportRequest)
	{
		// Create the service operation request object, and then assign values.
		SubmitGenerateReportRequest submitGenerateReportRequest = new SubmitGenerateReportRequest();
		submitGenerateReportRequest.setReportRequest(reportRequest);

		// Make the call to queue the report.
		IReportingService reportingService = getReportingService(accountId);
		SubmitGenerateReportResponse submitGenerateReportResponse;
		try
		{
			submitGenerateReportResponse = reportingService.submitGenerateReport(submitGenerateReportRequest);
		}
		catch (ApiFaultDetail fault)
		{
			printApiFaultDetail(fault);
			throw new SemplestError(fault);
		}
		catch (AdApiFaultDetail fault)
		{
			printAdApiFaultDetail(fault);
			throw new SemplestError(fault);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			throw new SemplestError(e);
		}

		String reportId = submitGenerateReportResponse.getReportRequestId();

		return reportId;
	}

	@Override
	public Map<String, String[]> getReportData(String reportId, Long accountId) throws RemoteException, MsnCloudException
	{
		final InputStreamReader streamReader = new InputStreamReader(getReportStream(reportId, accountId));
		CSVReader reader = new CSVReader(streamReader);
		try
		{
			HashMap<String, String[]> map = new HashMap<String, String[]>();
			List<String[]> rows = reader.readAll();
			boolean foundReportDataMarker = false;
			int scanRow = 0;
			while (!foundReportDataMarker && (scanRow < rows.size()))
			{
				final String[] rowData = rows.get(scanRow);
				if ((rowData.length == 0) || ((rowData.length == 1) && rowData[0].equals("")))
				{
					foundReportDataMarker = true;
				}
				scanRow++;
			}
			final int firstRow = scanRow;
			if (!foundReportDataMarker || (firstRow >= rows.size()))
			{
				throw new MsnCloudException("CSV data marker not found");
			}
			if (rows.size() < 1)
			{
				throw new MsnCloudException("No headers in CSV report");
			}
			String[] headers = rows.get(firstRow);
			int dataRows = 0;
			for (int column = 0; column < headers.length; column++)
			{
				String name = headers[column].toLowerCase();
				List<String> data = new ArrayList<String>();
				for (int row = firstRow + 1; row < rows.size(); row++)
				{
					if (rows.get(row).length != headers.length)
					{
						break;
					}
					data.add(rows.get(row)[column]);
				}
				map.put(name, data.toArray(new String[0]));
				dataRows = data.size();
			}
			for (String[] data : map.values())
			{
				if (data.length != dataRows)
				{
					throw new MsnCloudException("Inconsistent data lengths on CSV report");
				}
			}
			return map;
		}
		catch (IOException e)
		{
			throw new RemoteException("Downloading Report CSV", e);
		}
	}

	public void printReportToConsole(String reportId, Long accountId) throws RemoteException, MsnCloudException
	{
		InputStream is = getReportStream(reportId, accountId);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s;
		try
		{
			while ((s = br.readLine()) != null)
			{
				System.out.println(s);
			}
		}
		catch (IOException e)
		{
			throw new RemoteException("Error reading report stream", e);
		}
	}

	public InputStream getReportStream(String reportId, Long accountId) throws RemoteException, MsnCloudException
	{
		InputStream stream = getReportAsZipStream(reportId, accountId);
		ZipInputStream zip = new ZipInputStream(stream);
		ZipEntry entry;
		try
		{
			entry = zip.getNextEntry();
		}
		catch (IOException e)
		{
			throw new RemoteException("Reading ZIP stream", e);
		}
		if (entry != null)
		{
			return zip;
		}
		throw new MsnCloudException("Empty report zip package");
	}

	private InputStream getReportAsZipStream(String reportId, Long accountId) throws MsnCloudException, RemoteException
	{
		PollGenerateReportRequest pollGenerateReportRequest = null;
		PollGenerateReportResponse pollGenerateReportResponse = null;

		ReportRequestStatus reportRequestStatus = null;
		ReportRequestStatusType status = null;

		IReportingService reportingService = getReportingService(accountId);

		final int waitSeconds = 2;
		final int maxWaitSeconds = 90;
		int elapsedSeconds = 0;
		// int waitMinutes = 15;
		// int maxWaitMinutes = 120;
		// int elapsedMinutes = 0;
		// Poll to get the status of the report until it is complete.
		do
		{
			pollGenerateReportRequest = new PollGenerateReportRequest();
			pollGenerateReportRequest.setReportRequestId(reportId);

			// Make the call to get the report status.
			pollGenerateReportResponse = reportingService.pollGenerateReport(pollGenerateReportRequest);

			// Display the TrackingId that was returned in the response header.
			BasicHttpBinding_IReportingServiceStub stub = (BasicHttpBinding_IReportingServiceStub) reportingService;
			stub.setTimeout(timeoutMillis);

			reportRequestStatus = pollGenerateReportResponse.getReportRequestStatus();

			status = reportRequestStatus.getStatus();

			// If the report was created, download it.

			if (ReportRequestStatusType.Success == status)
			{
				String downloadURLString = null;
				URL downloadUrl = null;
				// Open a connection to the URL where the report is available.
				downloadURLString = reportRequestStatus.getReportDownloadUrl();
				try
				{
					downloadUrl = new URL(downloadURLString);
				}
				catch (MalformedURLException e)
				{
					throw new MsnCloudException(e);
				}
				try
				{
					return downloadUrl.openStream();
				}
				catch (IOException e)
				{
					throw new RemoteException("Downloading Report", e);
				}
			}
			else if (ReportRequestStatusType.Pending == status)
			{
				// The report is not yet ready.

				// Wait the specified number of minutes before you poll.
				try
				{
					Thread.sleep(waitSeconds * 1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				elapsedSeconds += waitSeconds;

				continue;
			}
			else
			{
				throw new MsnCloudException("Unexpected Report Status " + status);
			}

		}
		while (elapsedSeconds < maxWaitSeconds);
		throw new RemoteException("Timeout waiting on report");

	}

	private void printAdApiFaultDetail(AdApiFaultDetail fault)
	{
		StringBuilder s = new StringBuilder();

		s.append("AdApiFaultDetail exception encountered.\n");
		s.append(String.format("Tracking ID: %s\n", fault.getTrackingId()));

		// Display API error information.
		for (int i = 0; i < fault.getErrors().length; i++)
		{
			s.append("Error encountered:\n");
			s.append(String.format("\tMessage: %s\n", fault.getErrors()[i].getMessage()));
			s.append(String.format("\tDetail: %s\n", fault.getErrors()[i].getDetail()));
			s.append(String.format("\tErrorCode: %s\n", fault.getErrors()[i].getErrorCode()));
			s.append(String.format("\tCode: %s\n", fault.getErrors()[i].getCode()));
		}
		LOG.error(s.toString());
	}

	private void printApiFaultDetail(ApiFaultDetail fault)
	{
		StringBuilder s = new StringBuilder();
		s.append("ApiFaultDetail exception encountered.\n");
		s.append(String.format("Tracking ID: %s\n", fault.getTrackingId()));

		// Display service operation error information.
		for (int i = 0; i < fault.getOperationErrors().length; i++)
		{
			s.append("Operation error encountered:\n");
			s.append(String.format("\tMessage: %s\n", fault.getOperationErrors()[i].getMessage()));
			s.append(String.format("\tDetails: %s\n", fault.getOperationErrors()[i].getDetails()));
			s.append(String.format("\tErrorCode: %s\n", fault.getOperationErrors()[i].getErrorCode()));
			s.append(String.format("\tCode: %s\n", fault.getOperationErrors()[i].getCode()));
		}

		// Display batch error information.
		for (int i = 0; i < fault.getBatchErrors().length; i++)
		{
			s.append(String.format("Batch error encountered for array index %s.\n", fault.getBatchErrors()[i].getIndex()));
			s.append(String.format("\tMessage: %s\n", fault.getBatchErrors()[i].getMessage()));
			s.append(String.format("\tDetails: %s\n", fault.getBatchErrors()[i].getDetails()));
			s.append(String.format("\tErrorCode: %s\n", fault.getBatchErrors()[i].getErrorCode()));
			s.append(String.format("\tCode: %s\n", fault.getBatchErrors()[i].getCode()));
		}
		LOG.error(s.toString());
	}

	// ==================================
	// Helper Methods
	// ==================================
	private ICustomerManagementService getCustomerManagementService()
	{
		try
		{
			String namespace = adCenterCredentials.getCustomerManagementNamespace();
			CustomerManagementServiceLocator customerManagementServiceLocator = new CustomerManagementServiceLocator();
			customerManagementServiceLocator.setBasicHttpBinding_ICustomerManagementServiceEndpointAddress(adCenterCredentials
					.getCustomerManagementUrl());

			ICustomerManagementService customerManagementService = customerManagementServiceLocator.getBasicHttpBinding_ICustomerManagementService();
			BasicHttpBinding_ICustomerManagementServiceStub stub = (BasicHttpBinding_ICustomerManagementServiceStub) customerManagementService;
			stub.setTimeout(timeoutMillis);
			stub.setHeader(namespace, "ApplicationToken", "");
			stub.setHeader(namespace, "DeveloperToken", adCenterCredentials.getDeveloperToken());
			stub.setHeader(namespace, "UserName", adCenterCredentials.getUserName());
			stub.setHeader(namespace, "Password", adCenterCredentials.getPassword());

			return customerManagementService;
		}
		catch (ServiceException e)
		{
			throw new RuntimeException(e);
		}
	}

	private ICampaignManagementService getCampaignManagementService(Long accountId)
	{
		return getCampaignManagementService(accountId, NO_CUSTOMER_ID);
	}

	private ICampaignManagementService getCampaignManagementService(Long accountId, long customerId)
	{
		try
		{
			String namespace = adCenterCredentials.getCampaignManagementNamespace();
			CampaignManagementServiceLocator campaignManagementServiceLocator = new CampaignManagementServiceLocator();
			campaignManagementServiceLocator.setBasicHttpBinding_ICampaignManagementServiceEndpointAddress(adCenterCredentials
					.getCampaignManagementUrl());

			ICampaignManagementService campaignManagementService = campaignManagementServiceLocator.getBasicHttpBinding_ICampaignManagementService();
			BasicHttpBinding_ICampaignManagementServiceStub stub = (BasicHttpBinding_ICampaignManagementServiceStub) campaignManagementService;
			stub.setTimeout(timeoutMillis);
			stub.setHeader(namespace, "ApplicationToken", "");
			stub.setHeader(namespace, "DeveloperToken", adCenterCredentials.getDeveloperToken());
			stub.setHeader(namespace, "UserName", adCenterCredentials.getUserName());
			stub.setHeader(namespace, "Password", adCenterCredentials.getPassword());
			stub.setHeader(namespace, "CustomerAccountId", accountId);
			if (customerId != NO_CUSTOMER_ID)
			{
				stub.setHeader(namespace, "CustomerId", customerId);
			}

			return campaignManagementService;
		}
		catch (ServiceException e)
		{
			throw new RuntimeException(e);
		}
	}

	private IAdIntelligenceService getAdInteligenceService(Long accountId)
	{
		try
		{
			String namespace = adCenterCredentials.getAdIntelligenceNamespace();
			AdIntelligenceServiceLocator adIntelligenceServiceLocator = new AdIntelligenceServiceLocator();
			adIntelligenceServiceLocator.setBasicHttpBinding_IAdIntelligenceServiceEndpointAddress(adCenterCredentials.getAdIntelligenceUrl());

			IAdIntelligenceService adIntelligenceService = adIntelligenceServiceLocator.getBasicHttpBinding_IAdIntelligenceService();
			BasicHttpBinding_IAdIntelligenceServiceStub stub = (BasicHttpBinding_IAdIntelligenceServiceStub) adIntelligenceService;
			stub.setTimeout(timeoutMillis);
			stub.setHeader(namespace, "ApplicationToken", "");
			stub.setHeader(namespace, "DeveloperToken", adCenterCredentials.getDeveloperToken());
			stub.setHeader(namespace, "UserName", adCenterCredentials.getUserName());
			stub.setHeader(namespace, "Password", adCenterCredentials.getPassword());
			stub.setHeader(namespace, "CustomerAccountId", accountId);

			return adIntelligenceService;
		}
		catch (ServiceException e)
		{
			throw new RuntimeException(e);
		}
	}

	private IReportingService getReportingService(Long accountId)
	{
		String namespace = adCenterCredentials.getReportingNamespace();
		IReportingService reportingService = null;
		ReportingServiceLocator reportServiceLocator = null;
		BasicHttpBinding_IReportingServiceStub stub = null;
		reportServiceLocator = new ReportingServiceLocator();
		reportServiceLocator.setBasicHttpBinding_IReportingServiceEndpointAddress(adCenterCredentials.getReportingUrl());

		try
		{
			reportingService = reportServiceLocator.getBasicHttpBinding_IReportingService();
			stub = (BasicHttpBinding_IReportingServiceStub) reportingService;

			// Assign values for the credentials and the developer token.
			stub.setHeader(namespace, "ApplicationToken", "");
			stub.setHeader(namespace, "DeveloperToken", adCenterCredentials.getDeveloperToken());
			stub.setHeader(namespace, "UserName", adCenterCredentials.getUserName());
			stub.setHeader(namespace, "Password", adCenterCredentials.getPassword());
			stub.setHeader(namespace, "CustomerAccountId", accountId);

			return reportingService;
		}
		catch (ServiceException e)
		{
			throw new SemplestError(e);
		}
	}

	@Override
	public long[] createKeywords(Long accountId, Long adGroupId, semplest.other.MsnCloudKeywordProxy... keywords) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeywordEstimate getKeywordEstimateByBid(Long accountId, String keyword, double broadMatchBid, double exactMatchBid, double phraseMatchBid)
			throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KeywordEstimate[] getKeywordEstimateByBids(Long accountId, String[] keywords, double[] broadMatchBids, double[] exactMatchBids,
			double[] phraseMatchBids) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
}
