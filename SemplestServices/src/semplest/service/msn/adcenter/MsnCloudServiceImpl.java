package semplest.service.msn.adcenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedPositionAndTraffic;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCount;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordAndConfidence;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCount;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSuggestion;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear;
import org.joda.time.DateTime;

import semplest.other.AdCenterCredentials;
import semplest.other.AdCenterCredentialsProduction;
import semplest.other.MsnManagementIds;
import semplest.other.MsnTime;
import semplest.other.TimeServer;
import semplest.other.TimeServerImpl;
import semplest.server.protocol.ProtocolEnum.SemplestMatchType;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.UpdateAdRequest;
import semplest.server.protocol.google.UpdateAdsRequestObj;
import semplest.server.protocol.msn.MsnAccountObject;
import semplest.server.protocol.msn.MsnAdObject;
import semplest.server.protocol.msn.MsnKeywordObject;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;
import semplest.util.SemplestUtils;
import au.com.bytecode.opencsv.CSVReader;

import com.google.gson.Gson;
import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.BasicHttpBinding_ICustomerManagementServiceStub;
import com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceLocator;
import com.microsoft.adcenter.api.customermanagement.GetAccountRequest;
import com.microsoft.adcenter.api.customermanagement.GetAccountResponse;
import com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest;
import com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse;
import com.microsoft.adcenter.api.customermanagement.GetCustomersInfoRequest;
import com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse;
import com.microsoft.adcenter.api.customermanagement.ICustomerManagementService;
import com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest;
import com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountInfo;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountLifeCycleStatus;
import com.microsoft.adcenter.api.customermanagement.Entities.AccountType;
import com.microsoft.adcenter.api.customermanagement.Entities.Address;
import com.microsoft.adcenter.api.customermanagement.Entities.AdvertiserAccount;
import com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType;
import com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo;
import com.microsoft.adcenter.api.customermanagement.Entities.CurrencyType;
import com.microsoft.adcenter.api.customermanagement.Entities.Customer;
import com.microsoft.adcenter.api.customermanagement.Entities.CustomerInfo;
import com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat;
import com.microsoft.adcenter.api.customermanagement.Entities.Industry;
import com.microsoft.adcenter.api.customermanagement.Entities.LCID;
import com.microsoft.adcenter.api.customermanagement.Entities.LanguageType;
import com.microsoft.adcenter.api.customermanagement.Entities.PaymentMethodType;
import com.microsoft.adcenter.api.customermanagement.Entities.PersonName;
import com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion;
import com.microsoft.adcenter.api.customermanagement.Entities.TimeZoneType;
import com.microsoft.adcenter.api.customermanagement.Entities.User;
import com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
import com.microsoft.adcenter.v8.*;

public class MsnCloudServiceImpl implements MsnAdcenterServiceInterface // MsnCloudService
{
	private static final Logger log = Logger.getLogger(MsnCloudServiceImpl.class);

	/**
	 * Public methods in this class should throw only 2 kinds of exceptions:
	 * {@link MsnCloudServiceConnectionException} (meaning a timeout, failed to
	 * connect or other problem TALKING to MSN) and
	 * {@link MsnCloudInvalidResponse} meaning a broken protocol (MSN responded
	 * with the wrong thing, meaning a bug on their system or our interface
	 * assumptions are wrong).
	 **/

	private final static long NO_CUSTOMER_ID = Long.MIN_VALUE;

	public static final int DEFAULT_TIMEOUT = 80000;
	private NameServiceUniqueMsn uniqueMsnNameService = new NameServiceUniqueMsnPsuedoRandom();
	private AdCenterCredentials adCenterCredentials = new AdCenterCredentialsProduction();
	private int timeoutMillis = DEFAULT_TIMEOUT;
	private TimeServer timeServer = new TimeServerImpl();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(MsnCloudServiceImpl.class);

	private static String separator = "#";

	public static void main(String[] args) throws Exception
	{
		MsnCloudServiceImpl test = new MsnCloudServiceImpl();
		/*
		 * // ApplicationToken [], DeveloperToken [6LTW1JCMEKIUX3], UserName
		 * [API_SEMplest], Password [1s3mpl3st], CustomerAccountID [7079395] //
		 * AddPromotionToAdEngine
		 * :{"adEngineList":"[\"MSN\"]","productGroupID":"76"
		 * ,"customerID":"12","promotionID":"62"}- null
		 */
		// Will try to create campaign with AccountID [7079395], CampaignName
		// [Used Golf Clubs], BudgetLimitType [DailyBudgetStandard], DailyBudget
		// [259.25925925925924], MonthlyBudget [10.0], CampaignStatus [Active]

		final Long accountId = 5079839L;
		// final Long accountId = 1629687L;
		final String campaignName = "1223_Used Golf Clubs";
		final BudgetLimitType budgetLimitType = BudgetLimitType.DailyBudgetStandard;
		final double dailyBudget = 259.25925925925924d;
		final double monthlyBudget = 10.0;
		final CampaignStatus campaignStatus = CampaignStatus.Active;

		final Long campaignId = test.createCampaign(accountId, campaignName, budgetLimitType, dailyBudget, monthlyBudget, campaignStatus);
		logger.info("Campaign ID created [" + campaignId + "]");

		test.pauseCampaignById(accountId, campaignId);
		test.updateCampaignBudget(accountId, campaignId, budgetLimitType, dailyBudget, monthlyBudget);

		// DateTime firstDay = new DateTime(2011,1,1,0,0,0,0);
		// DateTime lastDay = new DateTime(2012,4,30,0,0,0,0);
		try
		{
			/*
			 * //Pipper Hall Long accountID = 1613923L; Long campaignID =
			 * 120123568L; Long adGroupID = 728133376L; String addr =
			 * null;//"2157 Diamond St"; String city = null;//"San Diego";
			 * String state = "US"; String country = null;//"US"; String zip =
			 * null;//"92109"; Double radius = null;//30.0; Double latitude =
			 * null; //35.707984924316406; Double longitude = null;
			 * //-80.00623321533203;
			 * 
			 * Keyword[] keywords = test.getKeywordByAdGroupId(accountID,
			 * adGroupID);
			 * 
			 * System.out.print(keywords[0].getEditorialStatus().getValue());
			 * System.out.print(keywords[0].getStatus().getValue());
			 * 
			 * test.updateAdGroupDefaultBids(accountID, campaignID, adGroupID,
			 * 2.0, 2.0, 2.0);
			 * 
			 * //test.deleteAllTargetsInCampaign(accountID, campaignID);
			 * //Boolean res = test.setGeoTarget(accountID, campaignID,
			 * latitude, longitude, radius, addr, city, state, country, zip);
			 * //Traffic Estimator //logger.info("Running traffic estimator");
			 * //TrafficEstimatorObject obj =
			 * test.getKeywordEstimateByBids(1633818L, new String[]
			 * {"wedding art portrait photo event"}, new Long[]{100000L} ,
			 * MatchType.Exact);
			 * 
			 * //HashMap<String,Double> map =test.getAccountIDs();
			 * //System.out.println(map.get("_ParkWinters"));
			 * //System.out.println(map.get("_StudioBloom")); //String ret1 =
			 * test.requestKeywordReport(1617082L, 110138069L, firstDay,
			 * lastDay, ReportAggregation.Weekly);
			 * //test.printReportToConsole(ret1, 1595249L); /*
			 * ArrayList<ReportObject> ret = test.getKeywordReport(1617082L,
			 * 110138069L, firstDay, lastDay, ReportAggregation.Daily);
			 * for(ReportObject t: ret){ logger.info("Keyword = " +
			 * t.getKeyword()); logger.info("BidAmount = " +
			 * t.getMicroBidAmount()); logger.info("BidMatchType = " +
			 * t.getBidMatchType()); logger.info("NumberImpressions = " +
			 * t.getNumberImpressions()); logger.info("NumberClick = " +
			 * t.getNumberClick()); logger.info("AveragePosition = " +
			 * t.getAveragePosition()); logger.info("QualityScore = " +
			 * t.getQualityScore()); logger.info("AverageCPC = " +
			 * t.getAverageCPC()); logger.info("CreatedDate = " +
			 * t.getTransactionDate()); logger.info("MicroCost = " +
			 * t.getMicroCost()); logger.info("==========================="); }
			 */
			/*
			 * String ret1 = test.requestKeywordReport(1617082L, 110138069L,
			 * firstDay, lastDay, ReportAggregation.Daily); //getReportData
			 * Map<String, String[]> ret2 = test.getReportData(ret1, 1617082L);
			 * for(String s: ret2.keySet()){ logger.info(s); String[] data =
			 * ret2.get(s); for(String d: data){ logger.info(d); }
			 * logger.info("============="); }
			 */

		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}
	}

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

	public MsnCloudServiceImpl()
	{

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
		logger.debug("call createAccount(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		MsnManagementIds ret = null;
		try
		{
			SemplestString in = new SemplestString();
			in.setSemplestString(data.get("name"));
			ret = createAccount(in);
		}
		catch (MsnCloudException e)
		{
			throw new Exception("Problem creating account for JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public MsnManagementIds createAccount(SemplestString name) throws MsnCloudException
	{
		final String legalName = SemplestUtils.getLegalUserName(name.getSemplestString());
		logger.info("Will try to create MSN customer using name [" + legalName + "]");

		final Address address = new Address();
		address.setLine1("195 Broadway");
		address.setLine2("Floor 24");
		address.setLine3(null);
		address.setLine4(null);
		address.setCity("New York");
		address.setCountryCode("US");
		address.setStateOrProvince("NY");
		address.setPostalCode("10007");
		address.setId(null);

		final ContactInfo contactInfo = new ContactInfo();
		contactInfo.setAddress(address);
		contactInfo.setContactByPhone(null);
		contactInfo.setContactByPostalMail(null);
		contactInfo.setEmail("msn@semplest.com");
		contactInfo.setPhone1("123-456-7890");
		contactInfo.setId(null);
		contactInfo.setEmailFormat(EmailFormat.Html);
		contactInfo.setPhone2("123-456-7891");
		contactInfo.setFax("123-456-7892");
		contactInfo.setHomePhone("123-456-7893");
		contactInfo.setMobile("123-456-7894");

		final SecretQuestion secretQuestion = SecretQuestion.FavoriteMovie;

		final PersonName personName = new PersonName("first name", "last name", null);

		final Customer customer = new Customer();
		customer.setName(legalName);
		customer.setCustomerAddress(address);
		customer.setIndustry(Industry.Other);
		customer.setMarketCountry("US");
		customer.setMarketLanguage(LanguageType.English);

		final User user = new User();
		user.setName(personName);
		user.setContactInfo(contactInfo);
		user.setCustomerAppScope(ApplicationType.Advertiser);
		user.setCustomerId(null);
		user.setPassword("password");
		user.setSecretQuestion(secretQuestion);
		user.setSecretAnswer("Star Wars");
		user.setUserName(legalName);
		user.setJobTitle(null);
		user.setId(null);
		user.setLcid(LCID.EnglishUS);

		final AdvertiserAccount account = new AdvertiserAccount();
		account.setId(null);
		account.setName(legalName);
		account.setNumber(null);
		account.setAccountLifeCycleStatus(AccountLifeCycleStatus.Active);
		account.setLanguage(LanguageType.English);
		account.setPaymentMethodType(PaymentMethodType.Invoice);
		account.setCurrencyType(CurrencyType.USDollar);
		account.setCountryCode("US");
		account.setTimeZone(TimeZoneType.EasternTimeUSCanada);
		account.setAccountType(AccountType.Advertiser);

		try
		{
			final ICustomerManagementService customerManagementService = getCustomerManagementService();
			final long parentCustomerId = adCenterCredentials.getParentCustomerID();
			final ApplicationType applicationType = ApplicationType.Advertiser;
			final SignupCustomerRequest request = new SignupCustomerRequest(customer, user, account, parentCustomerId, applicationType);
			logger.info("Will try to create MSN account using:\n\tCustomer: [" + SemplestUtils.getMsnCustomerString(customer) + "]\n\tUser: ["
					+ SemplestUtils.getMsnUserString(user) + "]\n\tAccount: [" + SemplestUtils.getMsnAccountString(account)
					+ "]\n\tParentCustomerID: [" + parentCustomerId + "],\n\tApplicationType: [" + applicationType + "]");
			final SignupCustomerResponse signupCustomerResponse = customerManagementService.signupCustomer(request);
			logger.info("New MSN account created [" + SemplestUtils.getMsnCustomerResponseString(signupCustomerResponse) + "]");
			final Long accountId = signupCustomerResponse.getAccountId();
			final String accountNumber = signupCustomerResponse.getAccountNumber();
			final Long customerId = signupCustomerResponse.getCustomerId();
			final Long userId = signupCustomerResponse.getUserId();
			return new MsnManagementIds(accountId, accountNumber, customerId, userId);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem creating account for MSN", e);
		}
		catch (ApiFault e)
		{
			logger.info("Problem creating account in MSN", e);
			throw new MsnCloudException("Problem creating account in MSN", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem creating MSN account for Name [" + legalName + "]", e);
		}
	}

	public String getAccountIDs(String json) throws Exception
	{
		logger.debug("call getAccountIDs(String json)" + json);
		HashMap<String, Double> ret = null;
		try
		{
			ret = getAccountIDs();
		}
		catch (MsnCloudException e)
		{
			throw new Exception("Problem getting Account IDs for JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	public Long getCustomerID(String name) throws MsnCloudException
	{
		try
		{
			ICustomerManagementService customerManagementService = getCustomerManagementService();
			GetCustomersInfoRequest req = new GetCustomersInfoRequest();
			req.setCustomerNameFilter(name);
			req.setTopN(1);
			GetCustomersInfoResponse signupCustomerResponse = customerManagementService.getCustomersInfo(req);

			Long customerID = null;

			CustomerInfo[] acInf = signupCustomerResponse.getCustomersInfo();
			if (acInf == null)
			{
				throw new MsnCloudException("No customer corresponding to: " + name);
			}
			else
			{
				customerID = acInf[0].getId();
			}

			return customerID;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem getting Customer ID for Name [" + name + "]", e);
		}
		catch (ApiFault e)
		{
			throw new MsnCloudException("Problem getting Customer ID for Name [" + name + "]", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem getting Customer ID for Name [" + name + "]", e);
		}
	}

	@Override
	public HashMap<String, Double> getAccountIDs() throws MsnCloudException
	{
		try
		{
			ICustomerManagementService customerManagementService = getCustomerManagementService();
			HashMap<String, Double> accountIDs = new HashMap<String, Double>();
			GetAccountsInfoRequest req = new GetAccountsInfoRequest();
			GetAccountsInfoResponse signupCustomerResponse = customerManagementService.getAccountsInfo(req);
			AccountInfo[] acInf = signupCustomerResponse.getAccountsInfo();
			for (int i = 0; i < acInf.length; i++)
			{
				Long accountID = acInf[i].getId();
				String accountName = acInf[i].getName();
				logger.debug("accountName: " + accountName);
				logger.debug("accountID: " + accountID);
				accountIDs.put(accountName, accountID.doubleValue());
			}
			return accountIDs;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem getting Account IDs", e);
		}
		catch (ApiFault e)
		{
			throw new MsnCloudException("Problem getting Account IDs", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem getting Account IDs", e);
		}
	}

	public String getAccountById(String json) throws Exception
	{
		logger.debug("call getAccountById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Account ret = null;
		try
		{
			ret = getAccountById(new Long(data.get("accountId")));
		}
		catch (MsnCloudException e)
		{
			throw new Exception("Problem getting Account by ID using JSON [" + json + "]", e);
		}
		return gson.toJson(new MsnAccountObject(ret));
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
			throw new MsnCloudException("Problem getting Account by ID [" + accountId + "]", e);
		}
		catch (ApiFault e)
		{
			throw new MsnCloudException("Problem getting Account by ID [" + accountId + "]", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem getting Account by ID [" + accountId + "]", e);
		}
	}

	// ==================================
	// Campaign Methods
	// ==================================

	public String createCampaign(String json) throws Exception
	{
		logger.debug("call createCampaign(String json) [" + json + "]");
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Long ret = null;
		try
		{
			ret = createCampaign(new Long(data.get("accountId")), data.get("campaignName"),
					gson.fromJson(data.get("budgetLimitType"), BudgetLimitType.class), Double.valueOf(data.get("dailyBudget")),
					Double.valueOf(data.get("monthlyBudget")), CampaignStatus.fromString(data.get("CampaignStatus")));
		}
		catch (MsnCloudException e)
		{
			throw new Exception("Problem creating Campaign using JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Long createCampaign(Long accountId, String campaignName, BudgetLimitType budgetLimitType, double dailyBudget, double monthlyBudget,
			CampaignStatus campaignStatus) throws MsnCloudException
	{
		/*
		 * Via AdEngine Will try to create campaign with AccountID [5079787],
		 * CampaignName [Used Golf Clubs], BudgetLimitType
		 * [DailyBudgetStandard], DailyBudget [291.66666666666663],
		 * MonthlyBudget [10.0], CampaignStatus [Active] ApplicationToken [],
		 * DeveloperToken [6LTW1JCMEKIUX3], UserName [API_SEMplest], Password
		 * [1s3mpl3st], CustomerAccountID [5079787] Via MSN directly Will try to
		 * create campaign with AccountID [5079787], CampaignName [Used Golf
		 * Clubsqwqwqq], BudgetLimitType [DailyBudgetStandard], DailyBudget
		 * [259.25925925925924], MonthlyBudget [10.0], CampaignStatus [Active]
		 * ApplicationToken [], DeveloperToken [6LTW1JCMEKIUX3], UserName
		 * [API_SEMplest], Password [1s3mpl3st], CustomerAccountID [5079787]
		 */

		logger.info("Will try to create campaign with AccountID [" + accountId + "], CampaignName [" + campaignName + "], BudgetLimitType ["
				+ budgetLimitType + "], DailyBudget [" + dailyBudget + "], MonthlyBudget [" + monthlyBudget + "], CampaignStatus [" + campaignStatus
				+ "]");
		try
		{

			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);

			// return new
			// CampaignBuilder(BudgetLimitType.MonthlyBudgetSpendUntilDepleted,
			// false, null, null, true, "Clothing products for winter", null,
			// 5000.00, "Winter clothing", null, null, null, );
			// Campaign newCampaign =
			// MsnDomainObjects.aNew().campaign().withName(campaignName).with(campaignStatus).with(budgetLimitType).withDailyBudget(dailyBudget).withMonthlyBudget(monthlyBudget).build();

			final Campaign newCampaign = new Campaign();
			newCampaign.setBudgetType(BudgetLimitType.MonthlyBudgetSpendUntilDepleted);
			newCampaign.setConversionTrackingEnabled(true);
			newCampaign.setDailyBudget(dailyBudget);
			newCampaign.setDaylightSaving(true);
			newCampaign.setDescription(campaignName);
			newCampaign.setId(null);
			newCampaign.setMonthlyBudget(monthlyBudget);
			newCampaign.setName(campaignName);
			newCampaign.setStatus(campaignStatus);
			newCampaign.setTimeZone("EasternTimeUSCanada");

			final AddCampaignsResponse addCampaigns;
			final Campaign[] campaign = new Campaign[1];
			campaign[0] = newCampaign;
			final AddCampaignsRequest addCampaignsRequest = new AddCampaignsRequest((long) accountId, campaign);
			logger.info("About to create Campaign in MSN for AccountID [" + addCampaignsRequest.getAccountId() + "], Campaign ["
					+ SemplestUtils.getMsnCampaignString(newCampaign) + "]");
			addCampaigns = campaignManagement.addCampaigns(addCampaignsRequest);
			return addCampaigns.getCampaignIds()[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem creating Campaign using AccountID [" + accountId + "], CampaignName [" + campaignName
					+ "], BudgetLimitType [" + budgetLimitType + "], DailyBudget [" + dailyBudget + "], MonthlyBudget [" + monthlyBudget
					+ "], CampaignStatus [" + campaignStatus + "]", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem creating Campaign using AccountID [" + accountId + "], CampaignName [" + campaignName
					+ "], BudgetLimitType [" + budgetLimitType + "], DailyBudget [" + dailyBudget + "], MonthlyBudget [" + monthlyBudget
					+ "], CampaignStatus [" + campaignStatus + "]", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem creating Campaign using AccountID [" + accountId + "], CampaignName [" + campaignName
					+ "], BudgetLimitType [" + budgetLimitType + "], DailyBudget [" + dailyBudget + "], MonthlyBudget [" + monthlyBudget
					+ "], CampaignStatus [" + campaignStatus + "]", e);
		}
	}

	public String getCampaignById(String json) throws Exception
	{
		logger.debug("call getCampaignById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Campaign ret = null;
		try
		{
			ret = getCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem getting Campaign by ID using JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Campaign getCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		GetCampaignsByIdsResponse campaignsById = null;
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignsById = campaignManagement.getCampaignsByIds(new GetCampaignsByIdsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException("Problem getting Campaign by ID using AccountID [" + accountId + "], CampaignID [" + campaignId + "]", e1);
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException("Problem getting Campaign by ID using AccountID [" + accountId + "], CampaignID [" + campaignId + "]", e2);
		}
		return campaignsById.getCampaigns()[0];
	}

	public String getCampaignsByAccountId(String json) throws Exception
	{
		logger.debug("call getCampaignsByAccountId(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Campaign[] ret = null;
		try
		{
			ret = getCampaignsByAccountId(new Long(data.get("accountId")));
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem getting Campaigns by Account ID using JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Campaign[] getCampaignsByAccountId(Long accountId) throws RemoteException
	{
		GetCampaignsByAccountIdResponse campaigns = null;
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaigns = campaignManagement.getCampaignsByAccountId(new GetCampaignsByAccountIdRequest((long) accountId));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException("Problem getting Campaigns by Account ID [" + accountId + "]", e1);
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException("Problem getting Campaigns by Account ID [" + accountId + "]", e2);
		}
		return campaigns.getCampaigns();
	}

	public String pauseCampaignById(String json) throws Exception
	{
		logger.debug("call pauseCampaignById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			pauseCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem Pausing Campaign by ID using JSON [" + json + "]", e);
		}
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void pauseCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.pauseCampaigns(new PauseCampaignsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String pauseCampaignsByAccountId(String json) throws Exception
	{
		logger.debug("call pauseCampaignsByAccountId(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			pauseCampaignsByAccountId(new Long(data.get("accountId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0); // return 0 if successful
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

		try
		{
			campaignManagement.pauseCampaigns(new PauseCampaignsRequest((long) accountId, campaignIds));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String resumeCampaignById(String json) throws Exception
	{
		logger.debug("call resumeCampaignById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			resumeCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void resumeCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.resumeCampaigns(new ResumeCampaignsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String deleteCampaignById(String json) throws Exception
	{
		logger.debug("call deleteCampaignById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void deleteCampaignById(Long accountId, Long campaignId) throws RemoteException
	{
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.deleteCampaigns(new DeleteCampaignsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String setCampaignStateTargets(String json) throws Exception
	{
		logger.debug("call setCampaignStateTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			setCampaignStateTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("campaignId")),
					Arrays.asList(data.get("states").split(separator)));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeStateTargets(states);

		long statesTargetId = addTargetsToLibrary(campaignManagement, targets);
		SetTargetToCampaignRequest setTargetToCampaignRequest = new SetTargetToCampaignRequest(campaignId, statesTargetId);

		try
		{
			campaignManagement.setTargetToCampaign(setTargetToCampaignRequest);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String deleteCampaignTargets(String json) throws Exception
	{
		logger.debug("call deleteCampaignTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteCampaignTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws RemoteException
	{
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			Target campaignTargets = getCampaignTargets(accountId, customerId, campaignId);
			campaignManagement.deleteTargetFromCampaign(new DeleteTargetFromCampaignRequest(campaignId));
			DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest = new DeleteTargetsFromLibraryRequest(
					new long[] { campaignTargets.getId() });
			campaignManagement.deleteTargetsFromLibrary(deleteTargetsFromLibraryRequest);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String getCampaignTargets(String json) throws Exception
	{
		logger.debug("call getCampaignTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Target ret = null;
		try
		{
			ret = getCampaignTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		long[] campaignIds = { campaignId };
		GetTargetsByCampaignIdsRequest getTargetsByCampaignIdsRequest = new GetTargetsByCampaignIdsRequest(campaignIds);
		GetTargetsByCampaignIdsResponse targetsByCampaignIds = null;
		try
		{
			targetsByCampaignIds = campaignManagement.getTargetsByCampaignIds(getTargetsByCampaignIdsRequest);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		Target[] targets = targetsByCampaignIds.getTargets();
		if ((targets == null) || (targets.length == 0))
		{
			return null;
		}
		return targets[0];
	}

	public String updateCampaignBudget(String json) throws Exception
	{
		logger.debug("call updateCampaignBudget(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			updateCampaignBudget(new Long(data.get("accountId")), new Long(data.get("campaignId")),
					gson.fromJson(data.get("budgetLimitType"), BudgetLimitType.class), Double.valueOf(data.get("dailyBudget")),
					Double.valueOf(data.get("monthlyBudget")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void updateCampaignBudget(Long accountId, Long campaignId, BudgetLimitType budgetLimitType, double dailyBudget, double monthlyBudget)
			throws RemoteException
	{
		logger.info("Will try to change Campaign Budget for AccountID [" + accountId + "], CampaignID [" + campaignId + "], BudgetLimitType [" + budgetLimitType + "], NewDailyBudget [" + dailyBudget + "], NewMonthlyBudget [" + monthlyBudget + "]");
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);

		Campaign campaign = new Campaign();
		campaign.setId(campaignId);
		campaign.setBudgetType(budgetLimitType);
		campaign.setDailyBudget(dailyBudget);
		campaign.setMonthlyBudget(monthlyBudget);
		Campaign[] campaigns = new Campaign[] { campaign };

		UpdateCampaignsRequest updateCampaignsRequest = new UpdateCampaignsRequest();
		updateCampaignsRequest.setAccountId((long) accountId);
		updateCampaignsRequest.setCampaigns(campaigns);

		try
		{
			campaignManagement.updateCampaigns(updateCampaignsRequest);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	// ==================================
	// AdGroup Methods
	// ==================================
	public String createAdGroup(String json) throws Exception
	{
		logger.debug("call createAdGroup(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		long ret = -1;
		try
		{
			ret = createAdGroup(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (ApiFaultDetail e1)
		{
			throw new Exception(e1);
		}
		catch (AdApiFaultDetail e2)
		{
			throw new Exception(e2);
		}
		catch (RemoteException e3)
		{
			throw new Exception(e3);
		}
		return gson.toJson(ret);
	}

	@Override
	public long createAdGroup(Long accountId, Long campaignId) throws Exception
	{
		logger.info("Will try to Create MSN AdGroup for AccountID [" + accountId + "], CampaignID [" + campaignId + "]");
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final String nextAdGroupName = uniqueMsnNameService.getNextAdGroupName();
	
			final PublisherCountry publisherCountry = new PublisherCountry("US", true);
			final PublisherCountry[] publisherCountries = new PublisherCountry[] { publisherCountry };
	
			final AdGroup adGroup = new AdGroup();
			adGroup.setAdDistribution(new String[] { "Search" });
			adGroup.setBiddingModel(BiddingModel.Keyword);
			adGroup.setLanguage("English");
			adGroup.setName(nextAdGroupName);
			adGroup.setPricingModel(PricingModel.Cpc);
			adGroup.setPublisherCountries(publisherCountries);
			adGroup.setNetwork(Network.OwnedAndOperatedAndSyndicatedSearch);
	
			logger.info("About to create MSN AdGroup: " + SemplestUtils.getMsnAdGroupString(adGroup));
	
			final AddAdGroupsResponse addAdGroupsResponse = campaignManagement.addAdGroups(new AddAdGroupsRequest(campaignId, new AdGroup[] { adGroup }));
			final long[] adGroupIds = addAdGroupsResponse.getAdGroupIds();
			logger.info("Got " + adGroupIds.length + " AdGroup Ids from MSN: [" + SemplestUtils.getStringForArray(adGroupIds) + "]");
			final Long adGroupId = adGroupIds[0];
			final SubmitAdGroupForApprovalRequest submitAdGroupRequest = new SubmitAdGroupForApprovalRequest();
			submitAdGroupRequest.setAdGroupId(adGroupId);
			final SubmitAdGroupForApprovalResponse approvalResponse = campaignManagement.submitAdGroupForApproval(submitAdGroupRequest);
			return adGroupId;
		}
		catch (ApiFaultDetail e)
		{
			throw new Exception("Problem Creating MSN AdGroup for AccountID [" + accountId + "], CampaignID [" + campaignId + "]: " + e.dumpToString(), e);
		} 
		catch (AdApiFaultDetail e) 
		{
			throw new Exception("Problem Creating MSN AdGroup for AccountID [" + accountId + "], CampaignID [" + campaignId + "]: " + e.dumpToString(), e);
		} 
		catch (RemoteException e) 
		{
			throw new Exception("Problem Creating MSN AdGroup for AccountID [" + accountId + "], CampaignID [" + campaignId + "]", e);
		}
	}

	@Override
	public Boolean updateAdGroupDefaultBids(Long accountId, Long campaignId, Long adGroupId, Double exactMatchBid, Double phraseMatchBid,
			Double broadMatchBid) throws AdApiFaultDetail, ApiFaultDetail, RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdGroupsByCampaignIdRequest adGroupReq = new GetAdGroupsByCampaignIdRequest();
		adGroupReq.setCampaignId(campaignId);
		GetAdGroupsByCampaignIdResponse adGroupResp = campaignManagement.getAdGroupsByCampaignId(adGroupReq);
		AdGroup[] adGroups = adGroupResp.getAdGroups();
		Bid broadMBid = new Bid(broadMatchBid);
		Bid exactMBid = new Bid(exactMatchBid);
		Bid phraseMBid = new Bid(phraseMatchBid);

		for (int i = 0; i < adGroups.length; i++)
		{
			adGroups[i].setBroadMatchBid(broadMBid);
			adGroups[i].setExactMatchBid(exactMBid);
			adGroups[i].setPhraseMatchBid(phraseMBid);
			adGroups[i].setStatus(null);
			adGroups[i].setBiddingModel(null);
			adGroups[i].setLanguage(null);
			adGroups[i].setPricingModel(null);
			adGroups[i].setPublisherCountries(null);
			adGroups[i].setStartDate(null);
		}

		UpdateAdGroupsRequest updateReq = new UpdateAdGroupsRequest();
		updateReq.setAdGroups(adGroups);
		updateReq.setCampaignId(campaignId);
		UpdateAdGroupsResponse updateResp = campaignManagement.updateAdGroups(updateReq);

		return true;

	}

	public String updateAdGroupDefaultBids(String json) throws Exception
	{
		logger.debug("call updateAdGroupDefaultBids(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Boolean ret = null;
		try
		{

			ret = updateAdGroupDefaultBids((data.get("accountId") == null) ? null : new Long(data.get("accountId")),
					(data.get("campaignId") == null) ? null : new Long(data.get("campaignId")), (data.get("adGroupId") == null) ? null : new Long(
							data.get("adGroupId")), (data.get("exactMatchBid") == null) ? null : Double.valueOf(data.get("exactMatchBid")),
					(data.get("phraseMatchBid") == null) ? null : Double.valueOf(data.get("phraseMatchBid")),
					(data.get("broadMatchBid") == null) ? null : Double.valueOf(data.get("broadMatchBid")));
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	public String getAdGroupsByCampaignId(String json) throws Exception
	{
		logger.debug("call getAdGroupsByCampaignId(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		AdGroup[] ret = null;
		try
		{
			ret = getAdGroupsByCampaignId(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	@Override
	public AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws RemoteException
	{
		logger.debug("accountid=" + accountId + " campaignId =" + campaignId);
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdGroupsByCampaignIdResponse adGroups = null;
		try
		{
			adGroups = campaignManagement.getAdGroupsByCampaignId(new GetAdGroupsByCampaignIdRequest(campaignId));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		return adGroups.getAdGroups();
	}

	public String getAdGroupById(String json) throws Exception
	{
		logger.debug("call getAdGroupById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		AdGroup ret = null;
		try
		{
			ret = getAdGroupById(new Long(data.get("accountId")), new Long(data.get("campaignId")), new Long(data.get("adGroupId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	@Override
	public AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdGroupsByIdsResponse adGroupsByIds = null;
		try
		{
			adGroupsByIds = campaignManagement.getAdGroupsByIds(new GetAdGroupsByIdsRequest(campaignId, new long[] { adGroupId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		return adGroupsByIds.getAdGroups()[0];
	}

	public String deleteAdGroupById(String json) throws Exception
	{
		logger.debug("call deleteAdGroupById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteAdGroupById(new Long(data.get("accountId")), new Long(data.get("campaignId")), new Long(data.get("adGroupId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.deleteAdGroups(new DeleteAdGroupsRequest(campaignId, new long[] { adGroupId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String setAdGroupStateTargets(String json) throws Exception
	{
		logger.debug("call setAdGroupStateTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			setAdGroupStateTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")),
					Arrays.asList(data.get("states").split(separator)));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws Exception
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeStateTargets(states);
		try
		{
			addTargetsToAdGroup(adGroupId, campaignManagement, targets);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		catch (EditorialApiFaultDetail e3)
		{
			throw new RemoteException(e3.dumpToString());
		}
	}

	public String setAdGroupCityTargets(String json) throws Exception
	{
		logger.debug("call setAdGroupCityTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			setAdGroupCityTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")),
					Arrays.asList(data.get("cities").split(separator)));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws RemoteException, ApiFaultDetail,
			AdApiFaultDetail, EditorialApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeCityTargets(cities);
		try
		{
			addTargetsToAdGroup(adGroupId, campaignManagement, targets);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		catch (EditorialApiFaultDetail e3)
		{
			throw new RemoteException(e3.dumpToString());
		}
	}

	public String setAdGroupMetroAreaTargets(String json) throws Exception
	{
		logger.debug("call setAdGroupMetroAreaTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			setAdGroupMetroAreaTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("msnAdGroupId")),
					Arrays.asList(data.get("metroTargets").split(separator)));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws RemoteException,
			ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		Target[] targets = makeMetroAreaTargets(metroTargets);
		try
		{
			addTargetsToAdGroup(msnAdGroupId, campaignManagement, targets);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		catch (EditorialApiFaultDetail e3)
		{
			throw new RemoteException(e3.dumpToString());
		}
	}

	private void addTargetsToAdGroup(Long adGroupId, ICampaignManagementService campaignManagement, Target[] targets) throws RemoteException,
			AdApiFaultDetail, ApiFaultDetail
	{
		long targetId = addTargetsToLibrary(campaignManagement, targets);

		SetTargetToAdGroupRequest setTargetToCampaignRequest = new SetTargetToAdGroupRequest(adGroupId, targetId);
		campaignManagement.setTargetToAdGroup(setTargetToCampaignRequest);
	}

	public String deleteAdGroupTargets(String json) throws Exception
	{
		logger.debug("call deleteAdGroupTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteAdGroupTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws RemoteException
	{
		Target adGroupTargets = getAdGroupTargets(accountId, customerId, adGroupId);
		if (adGroupTargets == null)
		{
			return;
		}
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			campaignManagement.deleteTargetFromAdGroup(new DeleteTargetFromAdGroupRequest(adGroupId));
			DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest = new DeleteTargetsFromLibraryRequest(
					new long[] { adGroupTargets.getId() });
			campaignManagement.deleteTargetsFromLibrary(deleteTargetsFromLibraryRequest);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String getAdGroupTargets(String json) throws Exception
	{
		logger.debug("call getAdGroupTargets(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Target ret = null;
		try
		{
			ret = getAdGroupTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
		GetTargetByAdGroupIdRequest getTargetByAdGroupIdRequest = new GetTargetByAdGroupIdRequest(adGroupId);
		GetTargetByAdGroupIdResponse targetByAdGroupId = null;
		try
		{
			targetByAdGroupId = campaignManagement.getTargetByAdGroupId(getTargetByAdGroupIdRequest);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		return targetByAdGroupId.getTarget();
	}

	// ==================================
	// Ad Methods
	// ==================================
	public String createAd(String json) throws Exception
	{
		logger.debug("call createAd(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		long ret = -1;
		try
		{
			ret = createAd(new Long(data.get("accountId")), new Long(data.get("adGroupId")), data.get("title"), data.get("text"),
					data.get("displayUrl"), data.get("destinationUrl"));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	@Override
	public long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws RemoteException,
			ApiFaultDetail, AdApiFaultDetail
	{
		logger.info("Will try to Create MSN Ad using AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], Title [" + title + "], Text ["
				+ text + "], DisplayURL [" + displayUrl + "], destinationURL [" + destinationUrl + "]");
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		TextAd ad = new TextAd();
		ad.setText(text);
		ad.setTitle(title);
		ad.setDisplayUrl(displayUrl);
		ad.setDestinationUrl(destinationUrl);
		// ad.setEditorialStatus(AdEditorialStatus.Active);
		// TextAd ad =
		// aNew().textAd().withTitle(title).withText(text).withDisplayUrl(displayUrl).withDestinationUrl(destinationUrl).build();
		AddAdsResponse addAds = null;
		try
		{
			addAds = campaignManagement.addAds(new AddAdsRequest(adGroupId, new Ad[]{ad}));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString(), e1);
		}
		catch (EditorialApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString(), e2);
		}
		return addAds.getAdIds()[0];
	}

	public String getAdById(String json) throws Exception
	{
		logger.debug("call getAdById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Ad ret = null;
		try
		{
			ret = getAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(new MsnAdObject(ret));
	}

	@Override
	public Ad getAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdsByIdsResponse adsByIds = null;
		try
		{
			adsByIds = campaignManagement.getAdsByIds(new GetAdsByIdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		return adsByIds.getAds()[0];
	}

	public String getAdsByAdGroupId(String json) throws Exception
	{
		logger.debug("call getAdsByAdGroupId(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Ad[] ret = null;
		try
		{
			ret = getAdsByAdGroupId(new Long(data.get("accountId")), new Long(data.get("adGroupId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		// pack it to MsnAdObject
		MsnAdObject[] ret1 = new MsnAdObject[ret.length];
		for (int i = 0; i < ret.length; i++)
		{
			ret1[i] = new MsnAdObject();
			ret1[i].fromAd(ret[i]);
		}
		return gson.toJson(ret1);
	}

	@Override
	public Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdsByAdGroupIdResponse ads = null;
		try
		{
			ads = campaignManagement.getAdsByAdGroupId(new GetAdsByAdGroupIdRequest(adGroupId));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		return ads.getAds();
	}

	public String updateAdById(String json) throws Exception
	{
		logger.debug("call updateAdById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			updateAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")), data.get("title"),
					data.get("text"), data.get("displayUrl"), data.get("destinationUrl"));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	public Map<UpdateAdRequest, Long> updateAllAdById(UpdateAdsRequestObj request) throws ApiFaultDetail, AdApiFaultDetail, RemoteException
	{
		Long accountID = Long.valueOf(request.getAccountID());
		Long adGroupID = request.getAdGroupID();
		List<UpdateAdRequest> adList = request.getUpdateRequests();

		// result
		Map<UpdateAdRequest, Long> requestToNewAdIdMap = new HashMap<UpdateAdRequest, Long>();
		// go through ads and call update
		for (UpdateAdRequest ad : adList)
		{
			String adText = SemplestUtils.IsNullReturnBlank(ad.getNewDescription1()) + " " + SemplestUtils.IsNullReturnBlank(ad.getNewDescription2());
			updateAdById(accountID, adGroupID, ad.getAdId(), ad.getNewHeadline(), adText.trim(), ad.getNewDisplayURL(), ad.getNewUrl());
			requestToNewAdIdMap.put(ad, ad.getAdId());
		}
		return requestToNewAdIdMap;
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
		try
		{
			campaignManagement.updateAds(new UpdateAdsRequest(adGroupId, new Ad[] { ad }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String pauseAdById(String json) throws Exception
	{
		logger.debug("call pauseAdById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			pauseAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void pauseAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.pauseAds(new PauseAdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String resumeAdById(String json) throws Exception
	{
		logger.debug("call resumeAdById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			resumeAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void resumeAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.resumeAds(new ResumeAdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String deleteAdById(String json) throws Exception
	{
		logger.debug("call deleteAdById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteAdById(Long accountId, Long adGroupId, long adId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.deleteAds(new DeleteAdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	// ==================================
	// Keyword Methods
	// ==================================
	public String createKeyword(String json) throws Exception
	{
		logger.debug("call createKeyword(String json) [" + json + "]");
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		long ret = -1;
		final String matchTypeString = data.get("matchType");
		final MatchType matchType = gson.fromJson(matchTypeString, MatchType.class);
		final String bidString = data.get("bid");
		final Bid bid = gson.fromJson(bidString, Bid.class);
		final String accountIdString = data.get("accountId");
		final Long accountId = Long.valueOf(accountIdString);
		final String adGroupIdString = data.get("adGroupId");
		final Long adGroupId = Long.valueOf(adGroupIdString);
		final String text = data.get("text");
		try
		{
			ret = createKeyword(accountId, adGroupId, text, matchType, bid);
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem creating MSN keyword for JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public void setNegativeKeywords(final Long accountId, final Long campaignId, final List<String> negativeKeywords) throws Exception
	{
		final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			final String[] negativeKeywordsArray = negativeKeywords.toArray(new String[negativeKeywords.size()]);
			final CampaignNegativeKeywords campaignNegativeKeywords = new CampaignNegativeKeywords(campaignId, negativeKeywordsArray);
			final CampaignNegativeKeywords[] campaignNegativeKeywordsArray = new CampaignNegativeKeywords[] { campaignNegativeKeywords };
			final SetNegativeKeywordsToCampaignsRequest request = new SetNegativeKeywordsToCampaignsRequest(accountId, campaignNegativeKeywordsArray);
			final SetNegativeKeywordsToCampaignsResponse response = campaignManagement.setNegativeKeywordsToCampaigns(request);
		}
		catch (AdApiFaultDetail e1)
		{
			throw new Exception(e1.dumpToString(), e1);
		}
		catch (EditorialApiFaultDetail e2)
		{
			throw new Exception(e2.dumpToString(), e2);
		}
	}
	
	public Keyword getKeyword(Long accountId, Long adGroupId, String text, MatchType matchType, Bid bid) throws Exception
	{
		final Keyword keyword = new Keyword();
		keyword.setText(text);
		keyword.setBroadMatchBid(SemplestUtils.MSN_DUMMY_BID);
		keyword.setExactMatchBid(SemplestUtils.MSN_DUMMY_BID);
		keyword.setContentMatchBid(SemplestUtils.MSN_DUMMY_BID);
		keyword.setPhraseMatchBid(SemplestUtils.MSN_DUMMY_BID);
		if (matchType == MatchType.Exact)
		{
			keyword.setExactMatchBid(bid);
		}
		else if (matchType == MatchType.Broad)
		{
			keyword.setBroadMatchBid(bid);	
		}
		else if (matchType == MatchType.Phrase)
		{
			keyword.setPhraseMatchBid(bid);	
		}
		else if (matchType == MatchType.Content)
		{
			keyword.setPhraseMatchBid(bid);	
		}	 
		else 
		{
			throw new Exception("Problem creating MSN keyword for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], Text [" + text + "], Bid [" + bid + "] because the MatchType specified [" + matchType + "] is not known");
		}
		return keyword;
	}

	@Override
	public long createKeyword(Long accountId, Long adGroupId, String text, MatchType matchType, Bid bid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, Exception
	{
		final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		final Keyword keyword = getKeyword(accountId, adGroupId, text, matchType, bid);
		try
		{
			final AddKeywordsResponse addKeywordsResponse = campaignManagement.addKeywords(new AddKeywordsRequest(adGroupId, new Keyword[]{keyword}));
			return addKeywordsResponse.getKeywordIds()[0];
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString(), e1);
		}
		catch (EditorialApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString(), e2);
		}
	}

	public String createKeywords(String json) throws Exception
	{
		logger.debug("call createKeywords(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		long[] ret = null;
		String[] keywordsStr = data.get("keywords").split(separator);
		Keyword[] keywords = new Keyword[keywordsStr.length];
		for (int i = 0; i < keywordsStr.length; i++)
		{
			keywords[i] = gson.fromJson(keywordsStr[i], Keyword.class);
		}
		try
		{
			long[] ret1 = createKeywords(new Long(data.get("accountId")), new Long(data.get("adGroupId")), keywords);
			ret = ret1;
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	public long[] createKeywords(Long accountId, Long adGroupId, Keyword... keywords) throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			final AddKeywordsResponse addKeywords = campaignManagement.addKeywords(new AddKeywordsRequest(adGroupId, keywords));
			return addKeywords.getKeywordIds();
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString(), e1);
		}
		catch (EditorialApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString(), e2);
		}
	}

	public String getKeywordById(String json) throws Exception
	{
		logger.debug("call getKeywordById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Keyword ret = null;
		try
		{
			ret = getKeywordById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("keywordId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(new MsnKeywordObject(ret));
	}

	@Override
	public Keyword getKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetKeywordsByIdsResponse keywordsByIds = null;
		try
		{
			keywordsByIds = campaignManagement.getKeywordsByIds(new GetKeywordsByIdsRequest(adGroupId, new long[] { keywordId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		Keyword[] keywords = keywordsByIds.getKeywords();
		if (keywords.length == 1 && keywords[0] != null)
		{
			return keywords[0];
		}
		return null;
	}

	public String getKeywordByAdGroupId(String json) throws Exception
	{
		logger.debug("call getKeywordByAdGroupId(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Keyword[] ret1 = null;
		try
		{
			ret1 = getKeywordByAdGroupId(new Long(data.get("accountId")), new Long(data.get("adGroupId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		if (ret1 == null)
			return gson.toJson(null);
		MsnKeywordObject[] ret = new MsnKeywordObject[ret1.length];
		for (int i = 0; i < ret1.length; i++)
		{
			ret[i] = new MsnKeywordObject();
			ret[i].fromKeyword(ret1[i]);
		}
		return gson.toJson(ret);
	}

	@Override
	public Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetKeywordsByAdGroupIdResponse keywordsByAdGroupId = null;
		try
		{
			keywordsByAdGroupId = campaignManagement.getKeywordsByAdGroupId(new GetKeywordsByAdGroupIdRequest(adGroupId));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
		return keywordsByAdGroupId.getKeywords();
	}

	public String updateKeywordBidById(String json) throws Exception
	{
		logger.debug("JSON: [" + json + "]");
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final String bidString = data.get("bid");
		final Bid bid = gson.fromJson(bidString, Bid.class);
		final String matchTypeString = data.get("matchType");
		final MatchType matchType = gson.fromJson(matchTypeString, MatchType.class);
		final String accountIdString = data.get("accountId");
		final Long accountId = Long.valueOf(accountIdString);
		final String adGroupIdString = data.get("adGroupId");
		final Long adGroupId = Long.valueOf(adGroupIdString);
		final String keywordIdString = data.get("keywordId");
		final Long keywordId = Long.valueOf(keywordIdString);
		try
		{
			updateKeywordBidById(accountId, adGroupId, keywordId, matchType, bid);
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem Updating MSN KeywordBid by ID for JSON [" + json + "]", e);
		}
		return gson.toJson(0);
	}

	@Override
	public void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, MatchType matchType, Bid bid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, Exception
	{
		logger.info("Will try to Update Keyword Bid by ID for KeywordId [" + keywordId + "], AccountID [" + accountId + "], AdGroupId [" + adGroupId + "], MatchType [" + matchType + "], Bid [" + bid + "]");
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		Keyword keyword = new Keyword();
		keyword.setId(keywordId);
		keyword.setExactMatchBid(SemplestUtils.MSN_DUMMY_BID);
		keyword.setBroadMatchBid(SemplestUtils.MSN_DUMMY_BID);
		keyword.setContentMatchBid(SemplestUtils.MSN_DUMMY_BID);
		keyword.setPhraseMatchBid(SemplestUtils.MSN_DUMMY_BID);
		if (matchType == MatchType.Exact)
		{
			keyword.setExactMatchBid(bid);
		}
		else if (matchType == MatchType.Broad)
		{
			keyword.setBroadMatchBid(bid);			
		}
		else if (matchType == MatchType.Content)
		{
			keyword.setContentMatchBid(bid);	
		}
		else if (matchType == MatchType.Phrase)
		{
			keyword.setPhraseMatchBid(bid);	
		}
		else
		{
			throw new Exception("Problem Updating MSN Keyword Bid By Keyword ID [" + keywordId + "] for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], Bid [" + bid + "] because the MatchType [" + matchType + "] is not found");
		}
		try
		{
			campaignManagement.updateKeywords(new UpdateKeywordsRequest(adGroupId, new Keyword[] { keyword }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public List<Keyword> getKeywords(List<BidElement> bids)
	{
		final List<Keyword> keywords = new ArrayList<Keyword>();
		for (final BidElement bid : bids)
		{
			final Keyword keyword = new Keyword();
			final Long keywordAdEngineID = bid.getKeywordAdEngineID();
			final String matchType = bid.getMatchType();
			final Long microBidAmountLong = bid.getMicroBidAmount();
			final Double microBidAmountDouble = ((double)microBidAmountLong) / 1000000;  
			final Bid keywordBid = new Bid(microBidAmountDouble);
			keyword.setId(keywordAdEngineID);
			
			keyword.setBroadMatchBid(SemplestUtils.MSN_DUMMY_BID);
			keyword.setPhraseMatchBid(SemplestUtils.MSN_DUMMY_BID);
			keyword.setExactMatchBid(SemplestUtils.MSN_DUMMY_BID);
			keyword.setContentMatchBid(SemplestUtils.MSN_DUMMY_BID);
			
			if (SemplestMatchType.Broad.name().equals(matchType))
			{
				keyword.setBroadMatchBid(keywordBid);
			}
			else if (SemplestMatchType.Exact.name().equals(matchType))
			{
				keyword.setExactMatchBid(keywordBid);
			}
			else if (SemplestMatchType.Phrase.name().equals(matchType))
			{
				keyword.setPhraseMatchBid(keywordBid);
			}
			keywords.add(keyword);
		}
		return keywords;
	}

	@Override
	public void updateKeywordBidsByIds(Long accountId, Long adGroupId, List<BidElement> bids) throws RemoteException, ApiFaultDetail, AdApiFaultDetail
	{
		final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		final List<Keyword> keywords = getKeywords(bids);
		final int batchSize = 1000;
		final List<List<Keyword>> keywordBatches = SemplestUtils.getBatches(keywords, batchSize);
		logger.info(keywords.size() + " Keywords broken up into " + keywordBatches.size() + " batches of " + batchSize);
		for (final List<Keyword> keywordBatch : keywordBatches)
		{
			final Keyword[] keywordArray = keywordBatch.toArray(new Keyword[keywordBatch.size()]); 
			try
			{
				campaignManagement.updateKeywords(new UpdateKeywordsRequest(adGroupId, keywordArray));
			}
			catch (AdApiFaultDetail e1)
			{
				throw new RemoteException(e1.dumpToString(), e1);
			}
			catch (EditorialApiFaultDetail e2)
			{
				throw new RemoteException(e2.dumpToString(), e2);
			}	
			try
			{
				Thread.sleep(SemplestUtils.SLEEP_MILLIS_BETWEEN_BATCHES);
			}
			catch(InterruptedException e)
			{
				logger.warn("Got interrupted while trying to sleep, but will just log and ignore");
			}
		}
	}

	public String pauseKeywordById(String json) throws Exception
	{
		logger.debug("call pauseKeywordById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			pauseKeywordById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("keywordId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.pauseKeywords(new PauseKeywordsRequest(adGroupId, new long[] { keywordId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public void pauseKeywordsByIds(Long accountId, Long adGroupId, long[] keywordIds) throws RemoteException
	{
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.pauseKeywords(new PauseKeywordsRequest(adGroupId, keywordIds));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String deleteKeywordById(String json) throws Exception
	{
		logger.debug("call deleteKeywordById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteKeywordById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("keywordId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException
	{
		logger.info("Will try to Delete MSN Keyword for AccountId [" + accountId + "], AdGroupID [" + adGroupId + "], MsnKeywordId [" + keywordId + "]");
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			campaignManagement.deleteKeywords(new DeleteKeywordsRequest(adGroupId, new long[] { keywordId }));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}
	}

	public String deleteKeywordsById(String json) throws Exception
	{
		logger.debug("call deleteKeywordsById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		String keywordIdsStr = data.get("keywordIds");
		long[] keywordIds = gson.fromJson(keywordIdsStr, long[].class);
		try
		{
			deleteKeywordsById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), keywordIds);
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws RemoteException
	{
		logger.info("Will try to Delete these MSN Keywords by MSN Ids for AccountId [" + accountId + "] and AdGroupID [" + adGroupId + "]: " + SemplestUtils.getStringForArray(keywordIds));
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		try
		{
			final DeleteKeywordsResponse response = campaignManagement.deleteKeywords(new DeleteKeywordsRequest(adGroupId, keywordIds));
		}
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString(), e1);
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString(), e2);
		}
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

	public String getKeywordEstimateByBids(String json) throws Exception
	{
		logger.debug("call getKeywordEstimateByBids(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		TrafficEstimatorObject ret = null;
		try
		{
			ret = getKeywordEstimateByBids(new Long(data.get("accountId")), gson.fromJson(data.get("keywords"), String[].class),
					gson.fromJson(data.get("microBidAmount"), Long[].class), gson.fromJson(data.get("matchType"), MatchType.class));
		}
		catch (MsnCloudException e)
		{
			throw new Exception(e);
		}
		return gson.toJson(ret);
	}

	public String deleteAllTargetsInCampaign(String json) throws Exception
	{
		logger.debug("call deleteAllTargetsInCampaign(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			deleteAllTargetsInCampaign(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		}
		catch (Exception e)
		{
			throw new Exception(e);
		}
		return gson.toJson(0);
	}

	@Override
	public void deleteAllTargetsInCampaign(Long accountId, Long campaignId) throws Exception
	{
		try
		{
			Account account = getAccountById(accountId);
			Long customerID = getCustomerID(account.getName());
			logger.info("accountName: " + account.getName());
			if (customerID != null)
			{
				logger.info("customerID: " + customerID);
			}
			else
			{
				throw new MsnCloudException("Problems retrieving customerID");
			}

			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerID);

			// Get targets already isntalled
			GetTargetsByCampaignIdsRequest getTargReq = new GetTargetsByCampaignIdsRequest();
			getTargReq.setCampaignIds(new long[] { campaignId });

			GetTargetsByCampaignIdsResponse getTargResp = campaignManagement.getTargetsByCampaignIds(getTargReq);
			Target[] targetsStored = getTargResp.getTargets();

			// Delete installed targets
			if (targetsStored[0] != null)
			{
				DeleteTargetFromCampaignRequest reqDelTarg = new DeleteTargetFromCampaignRequest();
				reqDelTarg.setCampaignId(campaignId);
				DeleteTargetFromCampaignResponse respDelTar = campaignManagement.deleteTargetFromCampaign(reqDelTarg);
			}

			// Get businesses already installed
			GetBusinessesInfoRequest busreq = new GetBusinessesInfoRequest();
			GetBusinessesInfoResponse busres = campaignManagement.getBusinessesInfo(busreq);
			BusinessInfo[] busInf = busres.getBusinessesInfo();
			long[] storedBusIDs = new long[busInf.length];

			// Delete businesses installed
			DeleteBusinessesRequest delBusReq;
			if (busInf != null && busInf.length > 0 && busInf[0].getId() > 0)
			{
				for (int i = 0; i < busInf.length; i++)
				{
					delBusReq = new DeleteBusinessesRequest();
					delBusReq.setBusinessIds(new long[] { busInf[i].getId() });
					campaignManagement.deleteBusinesses(delBusReq);
				}
			}
		}
		catch (RemoteException e1)
		{
			throw new MsnCloudException(e1);
		}

	}

	private Boolean setBusinessTargetObject(ICampaignManagementService campaignManagement, Target[] targetsStored, Account account, Long campaignId,
			Double radius, String addr, String city, String state, String country, String zip) throws MsnCloudException
	{
		try
		{
			// Generate new name for business based on businesses installed in
			// campaign
			GetBusinessesInfoRequest busreq = new GetBusinessesInfoRequest();
			GetBusinessesInfoResponse busres = campaignManagement.getBusinessesInfo(busreq);
			BusinessInfo[] busInf = busres.getBusinessesInfo();
			int[] busNamesInt = new int[0];
			String name = "0";

			if (busInf != null && busInf.length > 0 && busInf[0].getId() > 0)
			{
				busNamesInt = new int[busInf.length];
				for (int j = 0; j < busInf.length; j++)
				{
					String numbers = busInf[j].getName().replaceAll("\\D", "");
					if (numbers.length() > 0)
					{
						busNamesInt[j] = Integer.parseInt(numbers);
					}
					else
					{
						busNamesInt[j] = j;
					}
				}
				Arrays.sort(busNamesInt);
				name = "" + (busNamesInt[busInf.length - 1] + 1);
			}

			// Create and add business object that will contain location
			// information
			long[] busIDs;
			logger.info("Creating business object with location...");
			Business business = new Business();
			business.setName(name);
			business.setAddressLine1(addr);
			business.setCity(city);
			business.setCountryOrRegion(country);
			business.setStateOrProvince(state);
			business.setZipOrPostalCode(zip);

			AddBusinessesRequest requestBus = new AddBusinessesRequest();
			requestBus.setBusinesses(new Business[] { business });

			AddBusinessesResponse responseBus = campaignManagement.addBusinesses(requestBus);

			busIDs = responseBus.getBusinessIds();

			// Add business object to a target object
			logger.info("Adding Business to Target...");

			BusinessTargetBid bid = new BusinessTargetBid();
			bid.setBusinessId(busIDs[0]);
			bid.setIncrementalBid(IncrementalBidPercentage.ZeroPercent);
			bid.setRadius(radius.intValue());

			if (targetsStored[0] == null)
			{
				Target target = new Target();
				BusinessTarget busTarg = new BusinessTarget();
				busTarg.setBids(new BusinessTargetBid[] { bid });
				LocationTarget locTarget = new LocationTarget();
				locTarget.setBusinessTarget(busTarg);
				target.setLocation(locTarget);

				Target[] targets = new Target[] { target };

				AddTargetsToLibraryRequest requestTar = new AddTargetsToLibraryRequest();
				requestTar.setTargets(targets);
				AddTargetsToLibraryResponse responseTar = campaignManagement.addTargetsToLibrary(requestTar);

				long[] targetIDs = responseTar.getTargetIds();

				// Add target object to campaign
				logger.info("Adding target to campaign...");
				SetTargetToCampaignRequest requestCamp = new SetTargetToCampaignRequest();
				requestCamp.setTargetId(targetIDs[0]);
				requestCamp.setCampaignId(campaignId);
				SetTargetToCampaignResponse responseCamp = campaignManagement.setTargetToCampaign(requestCamp);

			}
			else
			{
				// if target already exists add new business to bid array
				if (targetsStored.length > 1)
				{
					throw new MsnCloudException("Too many targets in this campaign");
				}
				Target targetUpdate = targetsStored[0];
				LocationTarget locUpdate = targetUpdate.getLocation();
				BusinessTarget busTarUpdate = locUpdate.getBusinessTarget();
				BusinessTargetBid[] bidsStored;
				if (busTarUpdate != null)
				{
					bidsStored = new BusinessTargetBid[busTarUpdate.getBids().length + 1];
					for (int j = 0; j < busTarUpdate.getBids().length; j++)
					{
						bidsStored[j] = busTarUpdate.getBids()[j];
					}
					bidsStored[busTarUpdate.getBids().length] = bid;
				}
				else
				{
					bidsStored = new BusinessTargetBid[] { bid };
					busTarUpdate = new BusinessTarget();
				}
				busTarUpdate.setBids(bidsStored);
				// Update location target
				locUpdate.setBusinessTarget(busTarUpdate);
				targetUpdate.setLocation(locUpdate);
				targetUpdate.setIsLibraryTarget(null);
				// Update target in library
				UpdateTargetsInLibraryRequest updateTarRequest = new UpdateTargetsInLibraryRequest();
				updateTarRequest.setTargets(new Target[] { targetUpdate });
				UpdateTargetsInLibraryResponse updateTarResponse = campaignManagement.updateTargetsInLibrary(updateTarRequest);
			}

			// Determine if coordinates resolved and target active
			GetBusinessesByIdsRequest requestStatus = new GetBusinessesByIdsRequest();
			requestStatus.setBusinessIds(busIDs);

			GetBusinessesByIdsResponse responseStatus = campaignManagement.getBusinessesByIds(requestStatus);
			Business[] storedBus = responseStatus.getBusinesses();
			BusinessGeoCodeStatus geoStatus = storedBus[0].getGeoCodeStatus();
			logger.info("GeoCode Status: " + geoStatus.getValue());
			logger.info("Latitude: " + storedBus[0].getLatitudeDegrees());
			logger.info("Longitude: " + storedBus[0].getLongitudeDegrees());
			long res = 0;
			return true;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem", e);
		}
	}

	private Boolean setRadiusTargetObject(ICampaignManagementService campaignManagement, Target[] targetsStored, Account account, Long campaignId,
			Double radius, Double latitude, Double longitude) throws MsnCloudException
	{
		try
		{

			Boolean res = false;
			// Create and add radius object that will contain location
			// information

			logger.info("Creating radius object with location...");
			RadiusTargetBid radiusTar = new RadiusTargetBid();
			radiusTar.setLatitudeDegrees(latitude);
			radiusTar.setLongitudeDegrees(longitude);
			radiusTar.setRadius(radius.intValue());
			radiusTar.setIncrementalBid(IncrementalBidPercentage.ZeroPercent);

			if (targetsStored[0] == null)
			{
				Target target = new Target();
				RadiusTarget radTarg = new RadiusTarget();
				radTarg.setBids(new RadiusTargetBid[] { radiusTar });
				LocationTarget locTarget = new LocationTarget();
				locTarget.setRadiusTarget(radTarg);
				target.setLocation(locTarget);

				Target[] targets = new Target[] { target };
				AddTargetsToLibraryRequest requestTar = new AddTargetsToLibraryRequest();
				requestTar.setTargets(targets);
				AddTargetsToLibraryResponse responseTar = campaignManagement.addTargetsToLibrary(requestTar);

				long[] targetIDs = responseTar.getTargetIds();

				// Add target object to campaign
				logger.info("Adding target to campaign...");
				SetTargetToCampaignRequest requestCamp = new SetTargetToCampaignRequest();
				requestCamp.setTargetId(targetIDs[0]);
				requestCamp.setCampaignId(campaignId);
				SetTargetToCampaignResponse responseCamp = campaignManagement.setTargetToCampaign(requestCamp);
				logger.info("Target loaded");
				res = true;
			}
			else
			{

				// if target already exists add new business to bid array
				if (targetsStored.length > 1)
				{
					throw new MsnCloudException("Too many targets in this campaign");
				}
				Target targetUpdate = targetsStored[0];
				LocationTarget locUpdate = targetUpdate.getLocation();
				RadiusTarget radiusTarUpdate = locUpdate.getRadiusTarget();
				RadiusTargetBid[] bidsStored;
				if (radiusTarUpdate != null)
				{
					bidsStored = new RadiusTargetBid[radiusTarUpdate.getBids().length + 1];
					for (int j = 0; j < radiusTarUpdate.getBids().length; j++)
					{
						bidsStored[j] = radiusTarUpdate.getBids()[j];
					}
					bidsStored[radiusTarUpdate.getBids().length] = radiusTar;
				}
				else
				{
					bidsStored = new RadiusTargetBid[] { radiusTar };
					radiusTarUpdate = new RadiusTarget();
				}
				radiusTarUpdate.setBids(bidsStored);
				// Update location target
				locUpdate.setRadiusTarget(radiusTarUpdate);
				targetUpdate.setLocation(locUpdate);
				targetUpdate.setIsLibraryTarget(null);
				// Update target in library
				UpdateTargetsInLibraryRequest updateTarRequest = new UpdateTargetsInLibraryRequest();
				updateTarRequest.setTargets(new Target[] { targetUpdate });
				UpdateTargetsInLibraryResponse updateTarResponse = campaignManagement.updateTargetsInLibrary(updateTarRequest);
				logger.info("Target Updated");
				res = true;
			}
			return res;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem", e);
		}
	}

	private Boolean setStateTargetObject(ICampaignManagementService campaignManagement, Target[] targetsStored, Account account, Long campaignId,
			String state) throws MsnCloudException
	{
		try
		{
			Boolean res = false;
			logger.info("Creating state object with location...");
			final StateTargetBid stateTar = new StateTargetBid();
			stateTar.setState(state);
			stateTar.setIncrementalBid(IncrementalBidPercentage.ZeroPercent);
			if (targetsStored[0] == null)
			{
				final Target target = new Target();
				final StateTarget statTarg = new StateTarget();
				statTarg.setBids(new StateTargetBid[] { stateTar });
				final LocationTarget locTarget = new LocationTarget();
				locTarget.setStateTarget(statTarg);
				target.setLocation(locTarget);
				final Target[] targets = new Target[] { target };
				final AddTargetsToLibraryRequest requestTar = new AddTargetsToLibraryRequest();
				requestTar.setTargets(targets);
				logger.info("About to request CampaignManagement to AddTargetsToLibrary: [" + SemplestUtils.getMsnAddTargetsToLibraryRequestString(requestTar) + "]");
				final AddTargetsToLibraryResponse responseTar = campaignManagement.addTargetsToLibrary(requestTar);
				final long[] targetIDs = responseTar.getTargetIds();
				logger.info("Adding target to campaign...");
				final SetTargetToCampaignRequest requestCamp = new SetTargetToCampaignRequest();
				requestCamp.setTargetId(targetIDs[0]);
				requestCamp.setCampaignId(campaignId);
				final SetTargetToCampaignResponse responseCamp = campaignManagement.setTargetToCampaign(requestCamp);
				logger.info("Target loaded");
				res = true;
			}
			else
			{
				// if target already exists add new business to bid array
				if (targetsStored.length > 1)
				{
					throw new MsnCloudException("Too many targets in this campaign");
				}
				final Target targetUpdate = targetsStored[0];
				final LocationTarget locUpdate = targetUpdate.getLocation();
				StateTarget stateTarUpdate = locUpdate.getStateTarget();
				StateTargetBid[] bidsStored;
				if (stateTarUpdate != null)
				{
					bidsStored = new StateTargetBid[stateTarUpdate.getBids().length + 1];
					for (int j = 0; j < stateTarUpdate.getBids().length; j++)
					{
						bidsStored[j] = stateTarUpdate.getBids()[j];
					}
					bidsStored[stateTarUpdate.getBids().length] = stateTar;
				}
				else
				{
					bidsStored = new StateTargetBid[] { stateTar };
					stateTarUpdate = new StateTarget();
				}
				stateTarUpdate.setBids(bidsStored);
				locUpdate.setStateTarget(stateTarUpdate);
				targetUpdate.setLocation(locUpdate);
				targetUpdate.setIsLibraryTarget(null);
				final UpdateTargetsInLibraryRequest updateTarRequest = new UpdateTargetsInLibraryRequest();
				updateTarRequest.setTargets(new Target[] { targetUpdate });
				final UpdateTargetsInLibraryResponse updateTarResponse = campaignManagement.updateTargetsInLibrary(updateTarRequest);
				logger.info("Target Updated");
				res = true;
			}
			return res;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem setting state target for Account [" + SemplestUtils.getMsnAccountString(account) + "], CampaignID [" + campaignId + "], State [" + state + "]", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem setting state target for Account [" + SemplestUtils.getMsnAccountString(account) + "], CampaignID [" + campaignId + "], State [" + state + "]", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem setting state target for Account [" + SemplestUtils.getMsnAccountString(account) + "], CampaignID [" + campaignId + "], State [" + state + "]", e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem setting state target for Account [" + SemplestUtils.getMsnAccountString(account) + "], CampaignID [" + campaignId + "], State [" + state + "]", e);
		}
	}

	public String setGeoTarget(String json) throws Exception
	{
		logger.debug("call setGeoTarget(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Boolean ret = null;
		try
		{
			ret = setGeoTarget((data.get("accountId") == null) ? null : new Long(data.get("accountId")), (data.get("campaignId") == null) ? null
					: new Long(data.get("campaignId")), (data.get("latitude") == null) ? null : Double.valueOf(data.get("latitude")),
					(data.get("longitude") == null) ? null : Double.valueOf(data.get("longitude")),
					(data.get("radius") == null) ? null : Double.valueOf(data.get("radius")), (data.get("addr") == null) ? null : data.get("addr"),
					(data.get("city") == null) ? null : data.get("city"), (data.get("state") == null) ? null : data.get("state"),
					(data.get("country") == null) ? null : data.get("country"), (data.get("zip") == null) ? null : data.get("zip"));
		}
		catch (Exception e)
		{
			throw new Exception("Problem setting GeoTarget for JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Boolean setGeoTarget(Long accountId, Long campaignId, Double latitude, Double longitude, Double radius, String addr, String city,
			String state, String country, String zip) throws Exception
	{
		try
		{

			if (radius != null)
			{
				if (radius > 100)
				{
					throw new MsnCloudException("Maximum radius 100 miles");
				}
				else
				{
					radius = new Long(Math.round(radius / 10.0)).doubleValue() * 10;
				}
			}
			Account account = getAccountById(accountId);
			Long customerID = getCustomerID(account.getName());
			logger.info("accountName: " + account.getName());
			if (customerID != null)
			{
				logger.info("customerID: " + customerID);
			}
			else
			{
				throw new MsnCloudException("Problems retrieving customerID");
			}

			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerID);

			// Get targets already installed
			GetTargetsByCampaignIdsRequest getTargReq = new GetTargetsByCampaignIdsRequest();
			getTargReq.setCampaignIds(new long[] { campaignId });

			GetTargetsByCampaignIdsResponse getTargResp = campaignManagement.getTargetsByCampaignIds(getTargReq);
			Target[] targetsStored = getTargResp.getTargets();
			// Consider different cases
			if (radius == null && state != null && state.length() > 0)
			{
				if (!state.contains("US-"))
				{
					state = "US-" + state;
					logger.info("Setting state: " + state);
				}
				return setStateTargetObject(campaignManagement, targetsStored, account, campaignId, state);
			}
			else if (addr != null && city != null && state != null && country != null && zip != null && addr.length() > 0 && city.length() > 0
					&& state.length() > 0 && country.length() > 0 && zip.length() > 0)
			{
				country = "US";
				return setBusinessTargetObject(campaignManagement, targetsStored, account, campaignId, radius, addr, city, state, country, zip);
			}
			else if (radius != null && latitude != null && longitude != null)
			{
				return setRadiusTargetObject(campaignManagement, targetsStored, account, campaignId, radius, latitude, longitude);
			}
			else
			{
				if (!state.contains("US-"))
				{
					state = "US-" + state;
					logger.info("Setting state: " + state);
				}
				return setStateTargetObject(campaignManagement, targetsStored, account, campaignId, state);
			}
		}
		catch (RemoteException e1)
		{
			final String errMsg = "Problem setting MSN GeoTarget for AccountID [" + accountId + "], CampaignID [" + campaignId + "], Latitude ["
					+ latitude + "], Longitude [" + longitude + "], Radius [" + radius + "], Address [" + addr + "], City [" + city + "], State ["
					+ state + "], Country [" + country + "], Zip [" + zip + "]";
			logger.info(errMsg, e1);
			throw new MsnCloudException(errMsg, e1);
		}

	}

	@Override
	public TrafficEstimatorObject getKeywordEstimateByBids(Long accountId, String[] keywords, Long[] microBidAmount, MatchType matchType)
			throws MsnCloudException
	{
		TrafficEstimatorObject ret = new TrafficEstimatorObject();
		try
		{
			// IAdIntelligenceService adInteligenceService =
			// getAdInteligenceService(adCenterCredentials.getParentCustomerID());
			for (int i = 0; i < microBidAmount.length; i++)
			{
				logger.info("bid value estimated - " + microBidAmount[i]);
				IAdIntelligenceService adInteligenceService = getAdInteligenceService(accountId);
				Double bidtest = microBidAmount[i] * 1.00 / 1000000.00;
				GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest = new GetEstimatedPositionByKeywordsRequest(keywords,
						(microBidAmount[i] * 1.00 / 1000000.00), "English", new String[] { "US" }, Currency.USDollar, new MatchType[] { matchType });
				GetEstimatedPositionByKeywordsResponse estimatedPositionByKeywords = adInteligenceService
						.getEstimatedPositionByKeywords(getEstimatedPositionByKeywordsRequest);
				KeywordEstimatedPosition[] keywordEstimatedPositions = estimatedPositionByKeywords.getKeywordEstimatedPositions();
				Long bidAmount = microBidAmount[i]; // .getDoubleDollars();
				for (int j = 0; j < keywordEstimatedPositions.length; j++)
				{
					// for each keyword
					KeywordEstimatedPosition k = keywordEstimatedPositions[j];
					String keyword = k.getKeyword();
					if (k.getEstimatedPositions() != null)
					{
						for (EstimatedPositionAndTraffic et : k.getEstimatedPositions())
						{
							String adPosition = et.getEstimatedAdPosition().getValue();
							Double baseVal = 0.0;
							if (adPosition.contains("SideBar"))
								baseVal = 5.0;
							Double estAdPosition = Double.valueOf(adPosition.substring(adPosition.length() - 1)) + baseVal;
							// Test
							// variables///////////////////////////////////////////////
							Long in1 = new Long((new Double(et.getAverageCPC() * 1000000)).longValue());
							float in2 = (float) (et.getMinClicksPerWeek() / 7.0);
							float in3 = (float) (et.getMaxClicksPerWeek() / 7.0);
							Long in4 = new Long((new Double(et.getMinTotalCostPerWeek() * 1000000 / 7.0).longValue()));
							Long in5 = new Long((new Double(et.getMaxTotalCostPerWeek() * 1000000 / 7.0).longValue()));
							// /////////////////////////////////////////////////////////////*/
							ret.setBidData(keyword, bidAmount, et.getMatchType().toString(),
									new Long((new Double(et.getAverageCPC() * 1000000)).longValue()), new Long((new Double(
											et.getAverageCPC() * 1000000)).longValue()), estAdPosition, estAdPosition, (float) (et
											.getMinClicksPerWeek() / 7.0), (float) (et.getMaxClicksPerWeek() / 7.0),
									new Long((new Double(et.getMinTotalCostPerWeek() * 1000000 / 7.0).longValue())),
									new Long((new Double(et.getMaxTotalCostPerWeek() * 1000000 / 7.0).longValue())));
						}
					}
					else
					{
						ret.setBidData(keyword, bidAmount, null, new Long(0), null, new Double(0), null, null, null, null, null);
					}
				}

			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem", e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem", e);
		}
		return ret;
	}

	/*
	 * Takes an account ID, a String array of keywords, MonthAndYear object
	 * giving the desired month and year to begin collecting data. Uses the MSN
	 * API to get search volume data by keyword, by month from the start month
	 * to the most recent month available Returns a HashMap mapping search terms
	 * (keywords) to int[][] element i of the int[][] holds a 3-element int[]
	 * giving month, year, and search volume for keyword i
	 */
	public HashMap<String, int[][]> getKeywordVolumes(Long accountId, String[] keywords, MonthAndYear startMonth) throws MsnCloudException
	{
		logger.info("Will try to Get Keyword Volumes for AccountID [" + accountId + "], MonthAndYear [" + startMonth + "], " + keywords.length + " Keywords");
		HashMap<String, int[][]> ret = new HashMap<String, int[][]>();
		try
		{
			// get an adIntelligence service
			IAdIntelligenceService aiSvc = getAdInteligenceService(accountId);

			// start forming the search count request
			GetHistoricalSearchCountRequest req = new GetHistoricalSearchCountRequest();
			// we will retrieve search volume starting from startMonth and
			// ending in the last complete month
			MonthAndYear endMonthAndYear = new MonthAndYear();
			Calendar cal = Calendar.getInstance();
			// have to find the most recent complete month
			int currentMonth = cal.get(Calendar.MONTH) + 1;
			int currentYear = cal.get(Calendar.YEAR);
			int endMonth = currentMonth - 1;
			int endYear = currentYear;
			// special case if we're currently in January
			if (currentMonth == 1)
			{
				endMonth = 12;
				endYear = endYear - 1;
			}
			endMonthAndYear.setMonth(endMonth);
			endMonthAndYear.setYear(endYear);
			log.info("Start month and year: " + startMonth.getMonth() + "-" + startMonth.getYear());
			log.info("End month and year: " + endMonth + "-" + endYear);

			// set the fields in the search request
			req.setKeywords(keywords);
			req.setLanguage("English");
			req.setPublisherCountries(new String[] { "US" });
			req.setStartMonthAndYear(startMonth);
			req.setEndMonthAndYear(endMonthAndYear);

			// pass the request and get a response
			log.info("Passing request for search counts.");
			GetHistoricalSearchCountResponse res = aiSvc.getHistoricalSearchCount(req);
			KeywordSearchCount[] searchCounts = res.getKeywordSearchCounts();
			log.info("Received search count from MSN.");

			if (searchCounts == null)
			{
				log.info("Received null search count array from MSN");
			}

			// now get the data we need for each keyword
			for (int j = 0; j < searchCounts.length; j++)
			{
				// for each keyword
				KeywordSearchCount c = searchCounts[j];
				if (c == null)
				{
					continue;
				}
				String keyword = c.getKeyword();
				HistoricalSearchCount[] hscs = c.getHistoricalSearchCounts();

				// if no count data is available for this keyword, skip to the
				// next one
				if (hscs == null)
				{
					continue;
				}

				// create array of arrays holding each month, year, and count
				int nMonths = hscs.length;
				if (nMonths == 0)
				{
					continue;
				}
				int[][] countArray = new int[nMonths][3];
				for (int i = 0; i < nMonths; i++)
				{
					HistoricalSearchCount hsc = hscs[i];
					MonthAndYear monthYear = hsc.getMonthAndYear();
					countArray[i][0] = monthYear.getMonth();
					countArray[i][1] = monthYear.getYear();
					countArray[i][2] = hsc.getSearchCount();
				}
				ret.put(keyword, countArray);
			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem Getting Keyword Volumes for AccountID [" + accountId + "], MonthAndYear [" + startMonth + "], " + keywords.length + " Keywords", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem Getting Keyword Volumes for AccountID [" + accountId + "], MonthAndYear [" + startMonth + "], " + keywords.length + " Keywords", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem Getting Keyword Volumes for AccountID [" + accountId + "], MonthAndYear [" + startMonth + "], " + keywords.length + " Keywords", e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem Getting Keyword Volumes for AccountID [" + accountId + "], MonthAndYear [" + startMonth + "], " + keywords.length + " Keywords", e);
		}

		return ret;
	}

	/*
	 * Get MSN-suggested keywords for a given set of input words. Takes an
	 * account id, a String[] of keywords to get suggestions for, and an int
	 * giving the maximum number of suggestions per input word. Returns a
	 * HashMap mapping input keywords to String[]'s holding the suggested
	 * keywords
	 */
	public HashMap<String, String[]> getKeywordSuggestions(Long accountId, String[] keywords, int maxRecs) throws MsnCloudException
	{
		logger.info("Will try to Get Keyword Suggestions for AccountID [], MaxRecs [], " + keywords.length + " Keywords");
		HashMap<String, String[]> ret = new HashMap<String, String[]>();
		try
		{
			// get an adIntelligence service
			IAdIntelligenceService aiSvc = getAdInteligenceService(accountId);

			// start forming the search count request
			SuggestKeywordsFromExistingKeywordsRequest req = new SuggestKeywordsFromExistingKeywordsRequest();

			// set the fields in the search request
			req.setKeywords(keywords);
			req.setLanguage("English");
			req.setPublisherCountries(new String[] { "US" });
			req.setMaxSuggestionsPerKeyword(maxRecs);

			// pass the request and get a response
			log.info("Passing request for keyword suggestions");
			SuggestKeywordsFromExistingKeywordsResponse res = aiSvc.suggestKeywordsFromExistingKeywords(req);
			KeywordSuggestion[] kwRecs = res.getKeywordSuggestions();

			// now get the data we need for each keyword
			for (int j = 0; j < kwRecs.length; j++)
			{
				// for each keyword
				KeywordSuggestion kwRec = kwRecs[j];
				String keyword = kwRec.getKeyword();
				KeywordAndConfidence[] kwAndConfs = kwRec.getSuggestionsAndConfidence();
				if (kwAndConfs == null)
				{
					continue;
				}
				int nSuggestions = kwAndConfs.length;
				log.info("Got " + nSuggestions + " suggestions for " + keyword);
				if (nSuggestions == 0)
				{
					continue;
				}
				String[] wordRecs = new String[nSuggestions];
				for (int i = 0; i < nSuggestions; i++)
				{
					KeywordAndConfidence kwAndConf = kwAndConfs[i];
					wordRecs[i] = kwAndConf.getSuggestedKeyword();
				}

				ret.put(keyword, wordRecs);
			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Will try to Get Keyword Suggestions for AccountID [], MaxRecs [], " + keywords.length + " Keywords", e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Will try to Get Keyword Suggestions for AccountID [], MaxRecs [], " + keywords.length + " Keywords", e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Will try to Get Keyword Suggestions for AccountID [], MaxRecs [], " + keywords.length + " Keywords", e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Will try to Get Keyword Suggestions for AccountID [], MaxRecs [], " + keywords.length + " Keywords", e);
		}

		return ret;
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
		Target[] targets = { target };
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
		Target[] targets = { target };
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
		Target[] targets = { target };
		return targets;
	}

	public String requestKeywordReport(String json) throws Exception
	{
		logger.debug("call requestKeywordReport(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		String ret = "";
		ReportAggregation aggregation = gson.fromJson(data.get("aggregation"), ReportAggregation.class);
		try
		{
			ret = requestKeywordReport(new Long(data.get("accountId")), new Long(data.get("campaignId")), new DateTime(data.get("firstDay")),
					new DateTime(data.get("lastDay")), aggregation);
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

		return gson.toJson(ret);
	}

	@Override
	public String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation)
			throws RemoteException
	{
		ReportTime time = new MsnTime(firstDay).reportTimeTill(lastDay, timeServer.now());
		return requestKeywordReport(accountId, campaignId, time, aggregation);
	}

	/**
	 * Request a report for account, campaign. Set campaignId == 0 to report on
	 * all campaigns.
	 */
	public String requestKeywordReport(Long accountId, Long campaignId, ReportTime time, ReportAggregation aggregation) throws RemoteException
	{
		KeywordPerformanceReportColumn[] columns;

		columns = new KeywordPerformanceReportColumn[] { KeywordPerformanceReportColumn.Keyword, KeywordPerformanceReportColumn.AveragePosition,
				KeywordPerformanceReportColumn.Clicks, KeywordPerformanceReportColumn.CurrentMaxCpc, KeywordPerformanceReportColumn.QualityScore,
				KeywordPerformanceReportColumn.Impressions, KeywordPerformanceReportColumn.AverageCpc, KeywordPerformanceReportColumn.BidMatchType,
				KeywordPerformanceReportColumn.TimePeriod, KeywordPerformanceReportColumn.CampaignId, KeywordPerformanceReportColumn.Spend };

		final boolean returnOnlyCompleteData = false;
		final String reportName = "Keyword Report for Account " + accountId + " Campaign ";
		// Scope: this campaignId, all ad groups.
		final AccountThroughAdGroupReportScope scope = new AccountThroughAdGroupReportScope(null, null,
				new CampaignReportScope[] { new CampaignReportScope(accountId, campaignId) });
		final KeywordPerformanceReportFilter filter = null;
		final KeywordPerformanceReportRequest request = new KeywordPerformanceReportRequest(ReportFormat.Csv, ReportLanguage.English, reportName
				+ campaignId, returnOnlyCompleteData, aggregation, columns, filter, scope, time);
		return sendReportRequest(accountId, request);
	}

	public String requestCampaignReport(String json) throws Exception
	{
		logger.debug("call requestCampaignReport(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		String ret = "";
		ReportAggregation aggregation = gson.fromJson(data.get("aggregation"), ReportAggregation.class);
		try
		{
			ret = requestCampaignReport(new Long(data.get("accountId")), new Long(data.get("campaignId")), new Integer(data.get("daysInReport")),
					aggregation);
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

		return gson.toJson(ret);
	}

	/**
	 * Request a report for account, campaign. Set campaignId == 0 to report on
	 * all campaigns.
	 * 
	 * @param accountId
	 * @param campaignId
	 */
	@Override
	public String requestCampaignReport(Long accountId, Long campaignId, int daysInReport, ReportAggregation aggregation) throws RemoteException
	{
		CampaignPerformanceReportColumn[] columns = new CampaignPerformanceReportColumn[] { //
		CampaignPerformanceReportColumn.AccountName, CampaignPerformanceReportColumn.AccountNumber, CampaignPerformanceReportColumn.TimePeriod,
				CampaignPerformanceReportColumn.Status, CampaignPerformanceReportColumn.CampaignName, CampaignPerformanceReportColumn.CampaignId,
				CampaignPerformanceReportColumn.CurrencyCode, CampaignPerformanceReportColumn.AdDistribution,
				CampaignPerformanceReportColumn.Impressions, CampaignPerformanceReportColumn.Clicks, CampaignPerformanceReportColumn.Ctr,
				CampaignPerformanceReportColumn.AverageCpc, CampaignPerformanceReportColumn.Spend, CampaignPerformanceReportColumn.AveragePosition,
				CampaignPerformanceReportColumn.Conversions, CampaignPerformanceReportColumn.ConversionRate,
				CampaignPerformanceReportColumn.CostPerConversion, CampaignPerformanceReportColumn.LowQualityClicks,
				CampaignPerformanceReportColumn.LowQualityClicksPercent, CampaignPerformanceReportColumn.LowQualityImpressions,
				CampaignPerformanceReportColumn.LowQualityImpressionsPercent, CampaignPerformanceReportColumn.LowQualityConversions,
				CampaignPerformanceReportColumn.LowQualityConversionRate, CampaignPerformanceReportColumn.AverageCpm,
				CampaignPerformanceReportColumn.AverageCpc };

		final CampaignPerformanceReportFilter filter = null;
		final String title = "Weekly Campaign Report AccountId " + accountId + " CampaignId " + campaignId;
		final ReportLanguage language = ReportLanguage.English;
		final ReportFormat format = ReportFormat.Csv;
		final ReportTime time = new MsnTime(timeServer.now()).asReportTimeEndTimeWithStartingMinusDays(daysInReport);
		AccountThroughCampaignReportScope scope;
		if (campaignId == 0)
		{
			scope = new AccountThroughCampaignReportScope(new long[] { accountId }, null);
		}
		else
		{
			CampaignReportScope[] campaigns = new CampaignReportScope[] { new CampaignReportScope(accountId, campaignId) };
			scope = new AccountThroughCampaignReportScope(null, campaigns);
		}
		final boolean returnOnlyCompleteData = false;

		final CampaignPerformanceReportRequest reportRequest = new CampaignPerformanceReportRequest(format, language, title, returnOnlyCompleteData,
				aggregation, columns, filter, scope, time);

		return sendReportRequest(accountId, reportRequest);
	}

	public String sendReportRequest(Long accountId, final ReportRequest reportRequest) throws RemoteException
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
		catch (AdApiFaultDetail e1)
		{
			throw new RemoteException(e1.dumpToString());
		}
		catch (ApiFaultDetail e2)
		{
			throw new RemoteException(e2.dumpToString());
		}

		String reportId = submitGenerateReportResponse.getReportRequestId();

		return reportId;
	}

	public String getReportData(String json) throws Exception
	{
		logger.debug("call getReportData(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		Map<String, String[]> ret = null;
		try
		{
			ret = getReportData(data.get("reportId"), new Long(data.get("accountId")));
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
		catch (MsnCloudException e)
		{
			throw new Exception(e);
		}

		return gson.toJson(ret);
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
		logger.info("Will try to Get Report As Zip Stream for ReportID [" + reportId + "], AccountID [" + accountId + "]");
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

			try
			{
				// Make the call to get the report status.
				pollGenerateReportResponse = reportingService.pollGenerateReport(pollGenerateReportRequest);
			}
			catch (AdApiFaultDetail e1)
			{
				throw new MsnCloudException("Problem Getting Report As Zip Stream for ReportID [" + reportId + "], AccountID [" + accountId + "]", e1);
			}
			catch (ApiFaultDetail e2)
			{
				throw new MsnCloudException("Problem Getting Report As Zip Stream for ReportID [" + reportId + "], AccountID [" + accountId + "]", e2);
			}

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
					logger.error("Problem", e);
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
		log.error(s.toString());
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
		log.error(s.toString());
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
			final String customerManagementUrl = adCenterCredentials.getCustomerManagementUrl();
			customerManagementServiceLocator.setBasicHttpBinding_ICustomerManagementServiceEndpointAddress(customerManagementUrl);
			ICustomerManagementService customerManagementService = customerManagementServiceLocator.getBasicHttpBinding_ICustomerManagementService();
			BasicHttpBinding_ICustomerManagementServiceStub stub = (BasicHttpBinding_ICustomerManagementServiceStub) customerManagementService;
			stub.setTimeout(timeoutMillis);
			stub.setHeader(namespace, "ApplicationToken", "");
			stub.setHeader(namespace, "DeveloperToken", adCenterCredentials.getDeveloperToken());
			stub.setHeader(namespace, "UserName", adCenterCredentials.getUserName());
			stub.setHeader(namespace, "Password", adCenterCredentials.getPassword());
			logger.info("CustomerManagementService namespace [" + namespace + "], URL [" + customerManagementUrl + "], Credentials ["
					+ adCenterCredentials + "]");
			return customerManagementService;
		}
		catch (ServiceException e)
		{
			throw new RuntimeException("Problem creating CustomerManagementService", e);
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

			final String developerToken = adCenterCredentials.getDeveloperToken();
			final String userName = adCenterCredentials.getUserName();
			final String password = adCenterCredentials.getPassword();
			final String applicationToken = "";
			stub.setHeader(namespace, "ApplicationToken", applicationToken);
			stub.setHeader(namespace, "DeveloperToken", developerToken);
			stub.setHeader(namespace, "UserName", userName);
			stub.setHeader(namespace, "Password", password);
			stub.setHeader(namespace, "CustomerAccountId", accountId);
			if (customerId != NO_CUSTOMER_ID)
			{
				stub.setHeader(namespace, "CustomerId", customerId);
				logger.info("Customer ID [" + customerId + "]");
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
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object>
		 * SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}

	}

	public String getKeywordReport(String json) throws Exception
	{
		logger.debug("call getKeywordReport(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		try
		{
			ReportObject[] ret = getKeywordReport(new Long(data.get("accountId")), new Long(data.get("campaignId")),
					new DateTime(data.get("firstDay")), new DateTime(data.get("lastDay")));
			return gson.toJson(ret);
		}
		catch (MsnCloudException e)
		{
			throw new Exception(e);
		}
	}

	public Double[] getAdGroupDefaultBidValue(Long accountId, Long campaignId, Long adGroupId) throws AdApiFaultDetail, ApiFaultDetail,
			RemoteException
	{

		Double[] defaultBids = new Double[3];
		ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
		GetAdGroupsByCampaignIdRequest adGroupReq = new GetAdGroupsByCampaignIdRequest();
		adGroupReq.setCampaignId(campaignId);
		GetAdGroupsByCampaignIdResponse adGroupResp = campaignManagement.getAdGroupsByCampaignId(adGroupReq);
		AdGroup[] adGroups = adGroupResp.getAdGroups();
		for (AdGroup adG : adGroups)
		{
			if (adG.getId().equals(adGroupId))
			{
				defaultBids[0] = adG.getExactMatchBid().getAmount();
				defaultBids[1] = adG.getPhraseMatchBid().getAmount();
				defaultBids[2] = adG.getBroadMatchBid().getAmount();
			}
		}

		return defaultBids;

	}

	@Override
	public ReportObject[] getKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay) throws Exception
	{

		// requestKeywordReport
		String ret1 = this.requestKeywordReport(accountId, campaignId, firstDay, lastDay, ReportAggregation.Daily);
		AdGroup[] adGroups = this.getAdGroupsByCampaignId(accountId, campaignId);
		if (adGroups.length > 1)
		{
			throw new Exception("More than one adgroup in this campaign");
		}
		Long adGroupId = adGroups[0].getId();
		Double[] defaultBids = this.getAdGroupDefaultBidValue(accountId, campaignId, adGroupId);
		Keyword[] keywords = this.getKeywordByAdGroupId(accountId, adGroupId);

		// getReportData
		Map<String, String[]> ret2 = this.getReportData(ret1, accountId);
		ArrayList<ReportObject> reportObjectList = new ArrayList<ReportObject>();

		if (ret2.get("keyword") != null)
		{
			for (int i = 0; i < ret2.get("keyword").length; i++)
			{
				ReportObject data = new ReportObject();
				data.setAccountID(accountId);
				data.setCampaignID(Long.valueOf(ret2.get("campaignid")[i]));
				data.setKeyword(ret2.get("keyword")[i]);
				data.setBidMatchType(ret2.get("biddedmatchtype")[i]);
				Double maxcpc = 0.0;
				String maxCpcStr = ret2.get("currentmaxcpc")[i];
				if (maxCpcStr.length() > 0)
				{
					maxcpc = new Double(maxCpcStr);
				}
				else
				{
					if (data.getBidMatchType().equalsIgnoreCase("exact"))
						maxcpc = defaultBids[0];
					if (data.getBidMatchType().equalsIgnoreCase("phrase"))
						maxcpc = defaultBids[1];
					if (data.getBidMatchType().equalsIgnoreCase("broad"))
						maxcpc = defaultBids[2];
				}
				maxcpc = maxcpc * 1000000;
				data.setMicroBidAmount(maxcpc.longValue());
				Double microCost = new Double(ret2.get("spend")[i]);
				microCost = microCost * 1000000;
				data.setNumberImpressions(Integer.valueOf(ret2.get("impressions")[i]));
				data.setNumberClick(Integer.valueOf(ret2.get("clicks")[i]));
				data.setAveragePosition(Float.valueOf(ret2.get("averageposition")[i]));
				data.setAverageCPC((long) (Double.valueOf(ret2.get("averagecpc")[i]) * 1000000));
				data.setQualityScore((ret2.get("qualityscore")[i].equals("")) ? -1 : (Integer.valueOf(ret2.get("qualityscore")[i])));
				data.setApprovalStatus(null);
				data.setMicroCost(microCost.longValue());
				data.setFirstPageCPC(-1L);
				String[] t = ret2.get("gregoriandate")[i].split("/");
				data.setTransactionDate(new DateTime(Integer.valueOf(t[2]), Integer.valueOf(t[0]), Integer.valueOf(t[1]), 0, 0, 0, 0).toDate());
				for (int j = 0; j < keywords.length; j++)
				{
					if (keywords[j].equals(ret2.get("keyword")[i]))
					{
						data.setApprovalStatus(keywords[j].getEditorialStatus().getValue());
					}
				}
				reportObjectList.add(data);
			}
		}

		if (reportObjectList.size() == 0)
			return null;

		ReportObject[] ret = new ReportObject[reportObjectList.size()];
		reportObjectList.toArray(ret);
		return ret;
	}
}
