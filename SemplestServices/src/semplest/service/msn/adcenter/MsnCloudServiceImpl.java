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
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedPositionAndTraffic;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCount;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCountPeriodic;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordAndConfidence;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordHistoricalPerformanceByDevice;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordKPI;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCount;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCountByDevice;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSuggestion;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TimeInterval;
import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.other.AdCenterCredentials;
import semplest.other.AdCenterCredentialsProduction;
import semplest.other.AdCenterCredentialsSandbox;
import semplest.other.MsnManagementIds;
import semplest.other.MsnTime;
import semplest.other.TimeServer;
import semplest.other.TimeServerImpl;
import semplest.server.encryption.AESBouncyCastle;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.SemplestMatchType;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.GeoTargetType;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.bidding.AdEngineBidHistoryData;
import semplest.server.protocol.google.UpdateAdRequest;
import semplest.server.protocol.google.UpdateAdsRequestObj;
import semplest.server.protocol.msn.AddKeywordsRetriableMsnOperation;
import semplest.server.protocol.msn.AddNegativeKeywordsRetriableMsnOperation;
import semplest.server.protocol.msn.MsnAccountObject;
import semplest.server.protocol.msn.MsnAdObject;
import semplest.server.protocol.msn.MsnCloudException;
import semplest.server.protocol.msn.MsnCreateKeywordsResponse;
import semplest.server.protocol.msn.MsnKeywordObject;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.MsnAdcenterServiceInterface;
import semplest.util.SemplestUtils;
import au.com.bytecode.opencsv.CSVReader;

import com.google.gson.Gson;
import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.BasicHttpBinding_ICustomerManagementServiceStub;
import com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceLocator;
import com.microsoft.adcenter.api.customermanagement.DeleteAccountRequest;
import com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse;
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
import com.microsoft.adcenter.v8.*;

public class MsnCloudServiceImpl implements MsnAdcenterServiceInterface
{
	private static final Logger log = Logger.getLogger(MsnCloudServiceImpl.class);

	/**
	 * Public methods in this class should throw only 2 kinds of exceptions: {@link MsnCloudServiceConnectionException} (meaning a timeout, failed to
	 * connect or other problem TALKING to MSN) and {@link MsnCloudInvalidResponse} meaning a broken protocol (MSN responded with the wrong thing,
	 * meaning a bug on their system or our interface assumptions are wrong).
	 **/

	private final static long NO_CUSTOMER_ID = Long.MIN_VALUE;

	public static final int DEFAULT_TIMEOUT = 80000;
	private NameServiceUniqueMsn uniqueMsnNameService = null; // new NameServiceUniqueMsnPsuedoRandom();
	private AdCenterCredentials adCenterCredentials = null; // new AdCenterCredentialsProduction();
	private int timeoutMillis = DEFAULT_TIMEOUT;
	private TimeServer timeServer = null; // new TimeServerImpl();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(MsnCloudServiceImpl.class);

	private static Boolean useSandbox;

	private static String separator = "#";

	public static void main(String[] args) throws Exception
	{

		/*
		 * // ApplicationToken [], DeveloperToken [6LTW1JCMEKIUX3], UserName [API_SEMplest], Password [1s3mpl3st], CustomerAccountID [7079395] //
		 * AddPromotionToAdEngine :{"adEngineList":"[\"MSN\"]","productGroupID":"76" ,"customerID":"12","promotionID":"62"}- null
		 */
		// Will try to create campaign with AccountID [7079395], CampaignName
		// [Used Golf Clubs], BudgetLimitType [DailyBudgetStandard], DailyBudget
		// [259.25925925925924], MonthlyBudget [10.0], CampaignStatus [Active]

		// final Long accountId = 1629687L;
		final String campaignName = "1223_Used Golf Clubs";
		final BudgetLimitType budgetLimitType = BudgetLimitType.DailyBudgetStandard;
		final double dailyBudget = 259.25925925925924d;
		final double monthlyBudget = 10.0;
		final CampaignStatus campaignStatus = CampaignStatus.Active;
		try
		{
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			MsnCloudServiceImpl msn = new MsnCloudServiceImpl();

			final String accountID = "1758634";
			final Long accountIdLong = 1758634L;
			final Long adGroupID = 709890649L;
			final Long campaignID = 110207618L;
			/*
			 * final UpdateAdRequest updRequest = new UpdateAdRequest(1525522391L, "Some new headline4", "new desc 14", " new desc 24",
			 * "www.Fareed.com", "http://www.Fareed.com", 700); final List<UpdateAdRequest> updateRequests = Arrays.asList(updRequest); final
			 * UpdateAdsRequestObj updateRequest = new UpdateAdsRequestObj(accountID, adGroupID, updateRequests); msn.updateAllAdById(updateRequest);
			 */
			final Map<GeoTargetObject, GeoTargetType> geoTargetVsTypeMap = new HashMap<GeoTargetObject, GeoTargetType>();
			final GeoTargetObject g1 = new GeoTargetObject();
			g1.setState("NJ");
			geoTargetVsTypeMap.put(g1, GeoTargetType.STATE);
			msn.updateGeoTargets(accountIdLong, campaignID, geoTargetVsTypeMap);

			/*
			 * DateTime firstDay = new DateTime(2011,1,1,0,0,0,0); DateTime lastDay = new DateTime(2012,8,30,0,0,0,0); ReportObject[] ret =
			 * msn.getKeywordReport(1774491L, 51103550L, firstDay, lastDay); for(ReportObject ro : ret){ System.out.println(ro.toString()); }
			 */
			/*
			 * Map<String, ProtocolEnum.SemplestMatchType> map = new HashMap<String, ProtocolEnum.SemplestMatchType>();
			 * 
			 * map.put("aoidfnainef", SemplestMatchType.Exact); map.put("wedding bouquet", SemplestMatchType.Exact); map.put("wedding flowers",
			 * SemplestMatchType.Broad); List<AdEngineBidHistoryData> list = msn.getBidHistoryData(map, 14);
			 * 
			 * for (AdEngineBidHistoryData examp : list) { logger.info(examp.toString()); }
			 */

			// msn.createKeyword(1758634L, 709270153L, "Sneakers", MatchType.Exact, new Bid(0.55));
			// 1758634L
			// 1714527L
			// final List<AccountMigrationStatusesInfo> statuses = msn.getAccountMigrationStatuses(1707019L, 16L);
			// System.out.println(SemplestUtils.getEasilyReadableString(statuses));

			/*
			 * final Long accountId = 1745721L; Long adGroupID = 709082613L; MsnCloudServiceImpl msn = new MsnCloudServiceImpl(); final Map<Keyword,
			 * Integer> keywordToPkMap = new HashMap<Keyword, Integer>(); final String keywordText = "MyTest1"; final Integer keywordPK = 0; final Bid
			 * bid = new Bid(); final Double bidAmount = SemplestUtils.MSN_DEFAULT_BID_AMOUNT; bid.setAmount(bidAmount); final SemplestMatchType
			 * semplestMatchTypeEnum = SemplestMatchType.Exact; final com.microsoft.adcenter.v8.Keyword msnKeyword; if (semplestMatchTypeEnum ==
			 * SemplestMatchType.Broad) { msnKeyword = msn.getKeyword(accountId, adGroupID, keywordText, MatchType.Broad, bid); } else if
			 * (semplestMatchTypeEnum == SemplestMatchType.Exact) { msnKeyword = msn.getKeyword(accountId, adGroupID, keywordText, MatchType.Exact,
			 * bid); } else if (semplestMatchTypeEnum == SemplestMatchType.Phrase) { msnKeyword = msn.getKeyword(accountId, adGroupID, keywordText,
			 * MatchType.Phrase, bid); } else { throw new Exception("is not a known SemplestMatchType"); } keywordToPkMap.put(msnKeyword, keywordPK);
			 * MsnCreateKeywordsResponse res = msn.createKeywords(accountId, adGroupID, keywordToPkMap);
			 * 
			 * System.out.println("Done");
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
	 * Timeout used internally by soap connections. This means that requests sent out will not wait forever, instead they will timeout after these
	 * milliseconds and fail.
	 */
	@Override
	public void setTimeout(int milliseconds)
	{
		this.timeoutMillis = milliseconds;
	}

	public MsnCloudServiceImpl() throws Exception
	{
		try
		{
			final String key = (String) SemplestConfiguration.configData.get("SemplestEncryptionkey");
			final AESBouncyCastle aes = AESBouncyCastle.getInstance(key);
			final String user = (String) SemplestConfiguration.configData.get("MSNApiUsername");
			final String pass = aes.decrypt((String) SemplestConfiguration.configData.get("MSNApiPassword"));
			final String userAccessKey = (String) SemplestConfiguration.configData.get("MSNUserAccessKey");
			useSandbox = (Boolean) SemplestConfiguration.configData.get("MSNUseSandbox");
			if (useSandbox)
			{
				adCenterCredentials = new AdCenterCredentialsSandbox(user, pass, userAccessKey);
			}
			else
			{
				adCenterCredentials = new AdCenterCredentialsProduction(user, pass, userAccessKey);
			}
			logger.info("Initialized MSN API sandbox=" + useSandbox);
			this.uniqueMsnNameService = new NameServiceUniqueMsnPsuedoRandom();
			this.timeServer = new TimeServerImpl();
		}
		catch (Exception e)
		{
			final String errMsg = "Unable to initialize MSN API";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
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

	public String createAccount(String json) throws Exception
	{
		logger.debug("JSON [" + json + "]");
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		MsnManagementIds ret = null;
		try
		{
			final SemplestString in = new SemplestString();
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
		final String rawName = name.getSemplestString();
		final String legalName = SemplestUtils.getLegalUserName(rawName);
		final String operationDescription = "Create MSN customer using RawName [" + rawName + "] which is turned into LegalName [" + legalName + "]";
		logger.info("Will try to " + operationDescription);

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
			logger.info("Will try to create MSN account using:\n\tCustomer: [" + SemplestUtils.getMsnCustomerString(customer) + "]\n\tUser: [" + SemplestUtils.getMsnUserString(user) + "]\n\tAccount: [" + SemplestUtils.getMsnAccountString(account) + "]\n\tParentCustomerID: [" + parentCustomerId
					+ "],\n\tApplicationType: [" + applicationType + "]");
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
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getAccountIDs(String json) throws Exception
	{
		logger.debug("call getAccountIDs(String json)" + json);
		final Map<String, Long> ret;
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
		final String operationDescription = "Get Customer ID for Name [" + name + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICustomerManagementService customerManagementService = getCustomerManagementService();
			final GetCustomersInfoRequest req = new GetCustomersInfoRequest();
			req.setCustomerNameFilter(name);
			req.setTopN(1);
			final GetCustomersInfoResponse signupCustomerResponse = customerManagementService.getCustomersInfo(req);
			final Long customerID;
			final CustomerInfo[] acInf = signupCustomerResponse.getCustomersInfo();
			if (acInf == null)
			{
				throw new MsnCloudException("Problem doing " + operationDescription + " because no customer found corresponding to: " + name);
			}
			else
			{
				customerID = acInf[0].getId();
			}
			return customerID;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public Map<String, Long> getAccountIDs() throws MsnCloudException
	{
		final String operationDescription = "Get Account IDs";
		logger.info("Will try to do " + operationDescription);
		try
		{
			final ICustomerManagementService customerManagementService = getCustomerManagementService();
			final Map<String, Long> accountIDs = new HashMap<String, Long>();
			final GetAccountsInfoRequest req = new GetAccountsInfoRequest();
			final GetAccountsInfoResponse signupCustomerResponse = customerManagementService.getAccountsInfo(req);
			final AccountInfo[] acInf = signupCustomerResponse.getAccountsInfo();
			for (int i = 0; i < acInf.length; i++)
			{
				final Long accountID = acInf[i].getId();
				// String accountName = acInf[i].getName();
				String accountNumber = acInf[i].getNumber();
				logger.debug("accountNumber: " + accountNumber);
				logger.debug("accountID: " + accountID);
				accountIDs.put(accountNumber, accountID);
			}
			return accountIDs;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public List<Long> getActiveAccountIDs() throws MsnCloudException
	{
		final String operationDescription = "Get Active Account IDs";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICustomerManagementService customerManagementService = getCustomerManagementService();
			final List<Long> accountIDs = new ArrayList<Long>();
			final GetAccountsInfoRequest req = new GetAccountsInfoRequest();
			final GetAccountsInfoResponse signupCustomerResponse = customerManagementService.getAccountsInfo(req);
			final AccountInfo[] acInf = signupCustomerResponse.getAccountsInfo();
			for (AccountInfo accInfo : acInf)
			{
				if (accInfo.getAccountLifeCycleStatus().getValue().equalsIgnoreCase("active"))
				{
					accountIDs.add(accInfo.getId());
				}
			}
			return accountIDs;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public boolean deleteAccountById(Account account) throws MsnCloudException
	{
		final String operationDescription = "Delete Account By ID for Account [" + SemplestUtils.getMsnAccountString(account) + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICustomerManagementService customerManagementService = getCustomerManagementService();
			final DeleteAccountRequest req = new DeleteAccountRequest();
			req.setAccountId(account.getId());
			req.setTimeStamp(account.getTimeStamp());
			final DeleteAccountResponse res = customerManagementService.deleteAccount(req);
			return true;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
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
		final String operationDescription = "Get Account by ID for AccountID [" + accountId + "]";
		logger.info("Will try to " + operationDescription);
		GetAccountResponse account;
		try
		{
			final ICustomerManagementService customerManagementService = getCustomerManagementService();
			account = customerManagementService.getAccount(new GetAccountRequest(accountId));
			return account.getAccount();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	// ==================================
	// Data gathering methods
	// ==================================

	public List<AdEngineBidHistoryData> getBidHistoryData(Map<String, ProtocolEnum.SemplestMatchType> keywordMatchType, Integer position) throws Exception
	{
		final String operationDescription = "Get Bid History Data for Position [" + position + "] and KeywordMatchType [" + keywordMatchType + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			if (keywordMatchType == null || keywordMatchType.isEmpty())
			{
				throw new Exception("The keyword map is empty");
			}
			final List<AdEngineBidHistoryData> dataList = new ArrayList<AdEngineBidHistoryData>(keywordMatchType.size());
			final Set<String> keywordSet = keywordMatchType.keySet();
			final IAdIntelligenceService adInteligenceService = getAdInteligenceService(1707019L);
			final Date transactionDate = new Date();
			final Date endDate = new Date();
			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -30);
			final Date startDate = cal.getTime();
			// Generate output objects
			for (String kwrd : keywordSet)
			{
				final AdEngineBidHistoryData historyData = new AdEngineBidHistoryData();
				historyData.setAdEngine(ProtocolEnum.AdEngine.MSN.toString());
				historyData.setKeyword(kwrd);
				historyData.setMatchType(keywordMatchType.get(kwrd).toString());
				historyData.setPosition(position);
				historyData.setStartDate(startDate);
				historyData.setEndDate(endDate);
				historyData.setTransactionDate(transactionDate);
				dataList.add(historyData);
			}
			// Batch to maximum number of 1000 keywords per call
			final List<List<AdEngineBidHistoryData>> batchedList = SemplestUtils.getBatches(dataList, 200);
			final List<AdEngineBidHistoryData> dataListResult = new ArrayList<AdEngineBidHistoryData>();
			for (List<AdEngineBidHistoryData> subList : batchedList)
			{
				// Get volume information
				subList = getHistoricVolume(subList, adInteligenceService);
				// Get keyword performace information
				final Map<String, List<AdEngineBidHistoryData>> matchTypeMap = AdEngineBidHistoryData.batchByMatchType(subList);
				final Set<String> mtSet = matchTypeMap.keySet();
				final List<AdEngineBidHistoryData> newdataList = new ArrayList<AdEngineBidHistoryData>();
				for (final String mt : mtSet)
				{
					subList = matchTypeMap.get(mt);
					subList = getHistoricData(subList, position, adInteligenceService);
					newdataList.addAll(subList);
				}
				dataListResult.addAll(newdataList);
			}
			return dataListResult;
		}
		catch (Exception e)
		{
			throw new Exception("Problem doing " + operationDescription, e);
		}
	}

	public List<AdEngineBidHistoryData> getHistoricVolume(List<AdEngineBidHistoryData> keywords, IAdIntelligenceService adInteligenceService) throws Exception
	{
		final String operationDescription = "Get Historic Volume for keywords [" + keywords + "]";
		logger.info("Will try to " + operationDescription);
		// Populates AdEngineBidHistoryData objects with information about search volume
		final String[] kwrds = AdEngineBidHistoryData.getKeywordArray(keywords);
		final GetHistoricalSearchCountByDeviceRequest q = new GetHistoricalSearchCountByDeviceRequest();
		q.setKeywords(kwrds);
		q.setPublisherCountries(new String[] { "US" });
		q.setLanguage("English");
		q.setTimePeriodRollup("Daily");
		q.setStartTimePeriod(gDMY(-30));
		q.setEndTimePeriod(gDMY(0));
		GetHistoricalSearchCountByDeviceResponse r;
		try
		{
			r = adInteligenceService.getHistoricalSearchCountByDevice(q);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		if (keywords.size() != r.getKeywordSearchCounts().length)
		{
			throw new Exception("Problem doing " + operationDescription + " because number of SearchCounts [" + r.getKeywordSearchCounts().length + "] and keywords [" + keywords.size() + "] do not match");
		}
		for (int i = 0; i < r.getKeywordSearchCounts().length; i++)
		{
			KeywordSearchCountByDevice k = r.getKeywordSearchCounts()[i];
			logger.debug("Keyword: " + k.getKeyword());
			if (!k.getKeyword().equalsIgnoreCase(keywords.get(i).getKeyword()))
			{
				throw new Exception("Problem doing " + operationDescription + " because returned keyword [" + k.getKeyword() + "] does not match with requested keyword [" + keywords.get(i).getKeyword() + "]");
			}
			if (k.getDevice() != null && k.getHistoricalSearchCounts() != null && k.getHistoricalSearchCounts().length > 0)
			{
				int count = 0;
				for (HistoricalSearchCountPeriodic dailyCount : k.getHistoricalSearchCounts())
				{
					count = count + dailyCount.getSearchCount();
				}
				logger.debug("- Volume: " + count);
				keywords.get(i).setSearchVol(count);
			}
		}
		return keywords;
	}

	public List<AdEngineBidHistoryData> getHistoricData(List<AdEngineBidHistoryData> keywords, Integer position, IAdIntelligenceService adInteligenceService) throws Exception
	{
		final String operationDescription = "Get Historic Data for Position [], " + keywords.size() + " Keywords [" + keywords + "]";
		final String[] kwrds = AdEngineBidHistoryData.getKeywordArray(keywords);
		final SemplestMatchType matchType = AdEngineBidHistoryData.getListMatchType(keywords);
		final AdPosition adposition = getAdPosition(position);
		final GetHistoricalKeywordPerformanceByDeviceRequest q = new GetHistoricalKeywordPerformanceByDeviceRequest();
		q.setKeywords(kwrds);
		q.setPublisherCountries(new String[] { "US" });
		q.setLanguage("English");
		q.setTimeInterval(TimeInterval.Last30Days);
		q.setMatchTypes(new MatchType[] { semplestMatchTypeToMsnMatchType(matchType) });
		q.setTargetAdPosition(adposition);
		GetHistoricalKeywordPerformanceByDeviceResponse r;
		try
		{
			r = adInteligenceService.getHistoricalKeywordPerformanceByDevice(q);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		if (keywords.size() != r.getKeywordHistoricalPerformances().length)
		{
			throw new Exception("Number of KeywordPerformances and keywords do not match");
		}
		for (int i = 0; i < r.getKeywordHistoricalPerformances().length; i++)
		{
			final KeywordHistoricalPerformanceByDevice k = r.getKeywordHistoricalPerformances()[i];
			logger.debug("Keyword : " + k.getKeyword());
			if (!k.getKeyword().equalsIgnoreCase(keywords.get(i).getKeyword()))
			{
				throw new Exception("Returned keyword does not match with requested keyword");
			}
			if (k.getDevice() != null && k.getKeywordKPIs() != null)
			{
				for (KeywordKPI p : k.getKeywordKPIs())
				{
					if (p.getMatchType().equals(semplestMatchTypeToMsnMatchType(matchType)) && p.getAdPosition().equals(adposition))
					{
						keywords.get(i).setAvgBid(p.getAverageBid());
						keywords.get(i).setAvgCPC(p.getAverageCPC());
						keywords.get(i).setClicks(p.getClicks());
						keywords.get(i).setImpressions(p.getImpressions());
					}
				}
			}
		}
		return keywords;

	}

	public AdPosition getAdPosition(Integer position) throws Exception
	{
		if (position < 1 || position > 14)
		{
			throw new Exception("Invalid position value. Values should range from 1 to 14");
		}
		String positionString = null;
		if (position < 5)
		{
			positionString = "MainLine" + position;
		}
		else
		{
			positionString = "SideBar" + (position - 4);
		}
		AdPosition adPosition = AdPosition.fromValue(positionString);
		return adPosition;
	}

	public static MatchType semplestMatchTypeToMsnMatchType(SemplestMatchType semplestMatchType)
	{
		MatchType matchType = null;
		if (semplestMatchType.toString().equalsIgnoreCase(MatchType.Exact.getValue()))
		{
			matchType = MatchType.Exact;
		}
		else if (semplestMatchType.toString().equalsIgnoreCase(MatchType.Phrase.getValue()))
		{
			matchType = MatchType.Phrase;
		}
		else if (semplestMatchType.toString().equalsIgnoreCase(MatchType.Broad.getValue()))
		{
			matchType = MatchType.Broad;
		}
		return matchType;
	}

	public DayMonthAndYear gDMY(int pastDays)
	{
		Calendar c = Calendar.getInstance();
		try
		{
			c.add(Calendar.DATE, pastDays);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		DayMonthAndYear dmy = new DayMonthAndYear();
		dmy.setDay(c.get(Calendar.DATE));
		dmy.setMonth(c.get(Calendar.MONTH) + 1);
		dmy.setYear(c.get(Calendar.YEAR));
		return dmy;
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
			ret = createCampaign(new Long(data.get("accountId")), data.get("campaignName"), gson.fromJson(data.get("budgetLimitType"), BudgetLimitType.class), Double.valueOf(data.get("dailyBudget")), Double.valueOf(data.get("monthlyBudget")), CampaignStatus.fromString(data.get("CampaignStatus")));
		}
		catch (MsnCloudException e)
		{
			throw new Exception("Problem creating Campaign using JSON [" + json + "]", e);
		}
		return gson.toJson(ret);
	}

	@Override
	public Long createCampaign(Long accountId, String campaignName, BudgetLimitType budgetLimitType, double dailyBudget, double monthlyBudget, CampaignStatus campaignStatus) throws MsnCloudException
	{
		final String operationDescription = "Create Campaign with AccountID [" + accountId + "], CampaignName [" + campaignName + "], BudgetLimitType [" + budgetLimitType + "], DailyBudget [" + dailyBudget + "], MonthlyBudget [" + monthlyBudget + "], CampaignStatus [" + campaignStatus + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement;
			try
			{
				campaignManagement = getCampaignManagementService(accountId);
			}
			catch (Exception e)
			{
				throw new MsnCloudException("Problem doing " + operationDescription, e);
			}

			// return new
			// CampaignBuilder(BudgetLimitType.MonthlyBudgetSpendUntilDepleted,
			// false, null, null, true, "Clothing products for winter", null,
			// 5000.00, "Winter clothing", null, null, null, );
			// Campaign newCampaign =
			// MsnDomainObjects.aNew().campaign().withName(campaignName).with(campaignStatus).with(budgetLimitType).withDailyBudget(dailyBudget).withMonthlyBudget(monthlyBudget).build();

			final Campaign newCampaign = new Campaign();
			newCampaign.setBudgetType(budgetLimitType);
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
			logger.info("About to create Campaign in MSN for AccountID [" + addCampaignsRequest.getAccountId() + "], Campaign [" + SemplestUtils.getMsnCampaignString(newCampaign) + "]");
			addCampaigns = campaignManagement.addCampaigns(addCampaignsRequest);
			return addCampaigns.getCampaignIds()[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getCampaignById(String json) throws Exception
	{
		logger.debug("call getCampaignById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Campaign ret = getCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(ret);
	}

	@Override
	public Campaign getCampaignById(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Get Campaign By ID using AccountID [" + accountId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		final GetCampaignsByIdsResponse campaignsById;

		ICampaignManagementService campaignManagement;
		try
		{
			campaignManagement = getCampaignManagementService(accountId);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		try
		{
			campaignsById = campaignManagement.getCampaignsByIds(new GetCampaignsByIdsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return campaignsById.getCampaigns()[0];
	}

	public String getCampaignsByAccountId(String json) throws Exception
	{
		logger.debug("call getCampaignsByAccountId(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Campaign[] ret = getCampaignsByAccountId(new Long(data.get("accountId")));
		return gson.toJson(ret);
	}

	@Override
	public Campaign[] getCampaignsByAccountId(Long accountId) throws MsnCloudException
	{
		final String operationDescription = "Get Campaigns By Account ID for AccountID [" + accountId + "]";
		logger.info("Will try to " + operationDescription);
		final GetCampaignsByAccountIdResponse campaigns;
		final ICampaignManagementService campaignManagement;
		try
		{
			campaignManagement = getCampaignManagementService(accountId);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		try
		{
			campaigns = campaignManagement.getCampaignsByAccountId(new GetCampaignsByAccountIdRequest((long) accountId));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return campaigns.getCampaigns();
	}

	public String pauseCampaignById(String json) throws Exception
	{
		logger.debug("call pauseCampaignById(String json)" + json);
		HashMap<String, String> data = protocolJson.getHashMapFromJson(json);
		pauseCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(0);
	}

	@Override
	public void unpauseCampaignById(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Unpause Campaign By ID for AccountID [" + accountId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final long[] campaignIds = new long[] { campaignId };
			final ResumeCampaignsRequest request = new ResumeCampaignsRequest(accountId, campaignIds);
			campaignManagement.resumeCampaigns(request);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public void pauseCampaignById(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Pause Campaign By ID using AccountID [" + accountId + "] and CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final PauseCampaignsRequest request = new PauseCampaignsRequest((long) accountId, new long[] { campaignId });
			campaignManagement.pauseCampaigns(request);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String pauseCampaignsByAccountId(String json) throws Exception
	{
		logger.debug("call pauseCampaignsByAccountId(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		pauseCampaignsByAccountId(new Long(data.get("accountId")));
		return gson.toJson(0);
	}

	@Override
	public void pauseCampaignsByAccountId(Long accountId) throws MsnCloudException
	{
		final String operationDescription = "Pause Campaign by AccountID for AccountID [" + accountId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Campaign[] campaigns = getCampaignsByAccountId(accountId);
			final int length = campaigns.length;
			final long[] campaignIds = new long[length];
			for (int i = 0, size = length; i < size; i++)
			{
				campaignIds[i] = campaigns[i].getId();
			}
			campaignManagement.pauseCampaigns(new PauseCampaignsRequest((long) accountId, campaignIds));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String resumeCampaignById(String json) throws Exception
	{
		logger.debug("call resumeCampaignById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		resumeCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(0);
	}

	@Override
	public void resumeCampaignById(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Resume Campaign By ID for AccountID [" + accountId + "] and CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.resumeCampaigns(new ResumeCampaignsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteCampaignById(String json) throws Exception
	{
		logger.debug("call deleteCampaignById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteCampaignById(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void deleteCampaignById(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Delete Campaign By ID for AccountID [" + accountId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.deleteCampaigns(new DeleteCampaignsRequest((long) accountId, new long[] { campaignId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String setCampaignStateTargets(String json) throws Exception
	{
		logger.debug("call setCampaignStateTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		setCampaignStateTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("campaignId")), Arrays.asList(data.get("states").split(separator)));
		return gson.toJson(0); // return 0 if successful
	}

	@Override
	public void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws MsnCloudException
	{
		final String operationDescription = "Set Campaign State Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], CampaignID [" + campaignId + "], States [" + states + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final Target[] targets = makeStateTargets(states);
			long statesTargetId = addTargetsToLibrary(campaignManagement, targets);
			final SetTargetToCampaignRequest setTargetToCampaignRequest = new SetTargetToCampaignRequest(campaignId, statesTargetId);
			campaignManagement.setTargetToCampaign(setTargetToCampaignRequest);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteCampaignTargets(String json) throws Exception
	{
		logger.debug("call deleteCampaignTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteCampaignTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("campaignId")));
		return gson.toJson(0);
	}

	public List<AccountMigrationStatusesInfo> getAccountMigrationStatuses(final Long accountId, final Long customerId) throws MsnCloudException
	{
		final String operationDescription = "Get Account Migration statuses for AccountID [" + accountId + "], CustomerID [" + customerId + "]";
		logger.info("Will try to " + operationDescription);
		logger.info("Will try to get Migration Status for AccountId [" + accountId + "], CustomerID [" + customerId + "]");
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final long[] accountIds = new long[] { accountId };
			final GetAccountMigrationStatusesRequest request = new GetAccountMigrationStatusesRequest(accountIds, "KeywordByMatchType");
			final GetAccountMigrationStatusesResponse reponse = campaignManagement.getAccountMigrationStatuses(request);
			final AccountMigrationStatusesInfo[] statuses = reponse.getMigrationStatuses();
			final List<AccountMigrationStatusesInfo> statusesList = Arrays.asList(statuses);
			return statusesList;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Delete Campaign Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final Target campaignTargets = getCampaignTargets(accountId, customerId, campaignId);
			campaignManagement.deleteTargetFromCampaign(new DeleteTargetFromCampaignRequest(campaignId));
			final DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest = new DeleteTargetsFromLibraryRequest(new long[] { campaignTargets.getId() });
			campaignManagement.deleteTargetsFromLibrary(deleteTargetsFromLibraryRequest);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getCampaignTargets(String json) throws Exception
	{
		logger.debug("call getCampaignTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Target ret = getCampaignTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("campaignId")));
		return gson.toJson(ret);
	}

	@Override
	public Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Get Campaign Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final long[] campaignIds = { campaignId };
			final GetTargetsByCampaignIdsRequest getTargetsByCampaignIdsRequest = new GetTargetsByCampaignIdsRequest(campaignIds);
			final GetTargetsByCampaignIdsResponse targetsByCampaignIds = campaignManagement.getTargetsByCampaignIds(getTargetsByCampaignIdsRequest);
			final Target[] targets = targetsByCampaignIds.getTargets();
			if (targets == null || targets.length == 0)
			{
				return null;
			}
			return targets[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String updateCampaignBudget(String json) throws Exception
	{
		logger.debug("call updateCampaignBudget(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		updateCampaignBudget(new Long(data.get("accountId")), new Long(data.get("campaignId")), gson.fromJson(data.get("budgetLimitType"), BudgetLimitType.class), Double.valueOf(data.get("dailyBudget")), Double.valueOf(data.get("monthlyBudget")));
		return gson.toJson(0);
	}

	@Override
	public void updateCampaignBudget(Long accountId, Long campaignId, BudgetLimitType budgetLimitType, double dailyBudget, double monthlyBudget) throws MsnCloudException
	{
		final String operationDescription = "Update Campaign Budget for AccountID [" + accountId + "], CampaignID [" + campaignId + "], BudgetLimitType [" + budgetLimitType + "], DailyBudget [" + dailyBudget + "], MonthlyBudget [" + monthlyBudget + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Campaign campaign = new Campaign();
			campaign.setId(campaignId);
			campaign.setBudgetType(budgetLimitType);
			campaign.setDailyBudget(dailyBudget);
			campaign.setMonthlyBudget(monthlyBudget);
			final Campaign[] campaigns = new Campaign[] { campaign };
			final UpdateCampaignsRequest updateCampaignsRequest = new UpdateCampaignsRequest();
			updateCampaignsRequest.setAccountId((long) accountId);
			updateCampaignsRequest.setCampaigns(campaigns);
			campaignManagement.updateCampaigns(updateCampaignsRequest);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	// ==================================
	// AdGroup Methods
	// ==================================
	public String createAdGroup(String json) throws Exception
	{
		logger.debug("call createAdGroup(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final long ret = createAdGroup(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(ret);
	}

	@Override
	public long createAdGroup(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Create AdGroup for AccountID [" + accountId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
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
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public Boolean updateAdGroupDefaultBids(Long accountId, Long campaignId, Long adGroupId, Double exactMatchBid, Double phraseMatchBid, Double broadMatchBid) throws MsnCloudException
	{
		final String operationDescription = "Update AdGroup (Default Bids) for AccountID [" + accountId + "], CampaignID [" + campaignId + "], AdGroupID [" + adGroupId + "], ExactMatachBid [" + exactMatchBid + "], PhraseMatchBid [" + phraseMatchBid + "], BroadMatchBid [" + broadMatchBid + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetAdGroupsByCampaignIdRequest adGroupReq = new GetAdGroupsByCampaignIdRequest();
			adGroupReq.setCampaignId(campaignId);
			final GetAdGroupsByCampaignIdResponse adGroupResp = campaignManagement.getAdGroupsByCampaignId(adGroupReq);
			final AdGroup[] adGroups = adGroupResp.getAdGroups();
			final Bid broadMBid = new Bid(broadMatchBid);
			final Bid exactMBid = new Bid(exactMatchBid);
			final Bid phraseMBid = new Bid(phraseMatchBid);
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
			final UpdateAdGroupsRequest updateReq = new UpdateAdGroupsRequest();
			updateReq.setAdGroups(adGroups);
			updateReq.setCampaignId(campaignId);
			final UpdateAdGroupsResponse updateResp = campaignManagement.updateAdGroups(updateReq);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return true;
	}

	public String updateAdGroupDefaultBids(String json) throws Exception
	{
		logger.debug("call updateAdGroupDefaultBids(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Boolean ret = updateAdGroupDefaultBids((data.get("accountId") == null) ? null : new Long(data.get("accountId")), (data.get("campaignId") == null) ? null : new Long(data.get("campaignId")), (data.get("adGroupId") == null) ? null : new Long(data.get("adGroupId")),
				(data.get("exactMatchBid") == null) ? null : Double.valueOf(data.get("exactMatchBid")), (data.get("phraseMatchBid") == null) ? null : Double.valueOf(data.get("phraseMatchBid")), (data.get("broadMatchBid") == null) ? null : Double.valueOf(data.get("broadMatchBid")));
		return gson.toJson(ret);
	}

	public String getAdGroupsByCampaignId(String json) throws Exception
	{
		logger.debug("call getAdGroupsByCampaignId(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final AdGroup[] ret = getAdGroupsByCampaignId(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(ret);
	}

	@Override
	public AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Get AdGroup By Campaign ID for AccountID [" + accountId + "], CampaignID [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetAdGroupsByCampaignIdResponse adGroups = campaignManagement.getAdGroupsByCampaignId(new GetAdGroupsByCampaignIdRequest(campaignId));
			return adGroups.getAdGroups();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getAdGroupById(String json) throws Exception
	{
		logger.debug("call getAdGroupById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final AdGroup ret = getAdGroupById(new Long(data.get("accountId")), new Long(data.get("campaignId")), new Long(data.get("adGroupId")));
		return gson.toJson(ret);
	}

	@Override
	public AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Get AdGroup By ID for AccountID [" + accountId + "], CampaignID [" + campaignId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetAdGroupsByIdsResponse adGroupsByIds = campaignManagement.getAdGroupsByIds(new GetAdGroupsByIdsRequest(campaignId, new long[] { adGroupId }));
			return adGroupsByIds.getAdGroups()[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteAdGroupById(String json) throws Exception
	{
		logger.debug("call deleteAdGroupById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteAdGroupById(new Long(data.get("accountId")), new Long(data.get("campaignId")), new Long(data.get("adGroupId")));
		return gson.toJson(0);
	}

	@Override
	public void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Get Delete AdGroup ID for AccountID [" + accountId + "], CampaignID [" + campaignId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final DeleteAdGroupsRequest request = new DeleteAdGroupsRequest(campaignId, new long[] { adGroupId });
			campaignManagement.deleteAdGroups(request);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String setAdGroupStateTargets(String json) throws Exception
	{
		logger.debug("call setAdGroupStateTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		setAdGroupStateTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")), Arrays.asList(data.get("states").split(separator)));
		return gson.toJson(0);
	}

	@Override
	public void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws MsnCloudException
	{
		final String operationDescription = "Set AdGroup State Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], AdGroupID [" + adGroupId + "], States [" + states + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final Target[] targets = makeStateTargets(states);
			addTargetsToAdGroup(adGroupId, campaignManagement, targets);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String setAdGroupCityTargets(String json) throws Exception
	{
		logger.debug("call setAdGroupCityTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		setAdGroupCityTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")), Arrays.asList(data.get("cities").split(separator)));
		return gson.toJson(0);
	}

	@Override
	public void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws MsnCloudException
	{
		final String operationDescription = "Set AdGroup City Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], AdGroupID [" + adGroupId + "], Cities [" + cities + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final Target[] targets = makeCityTargets(cities);
			addTargetsToAdGroup(adGroupId, campaignManagement, targets);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String setAdGroupMetroAreaTargets(String json) throws Exception
	{
		logger.debug("call setAdGroupMetroAreaTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Long accountId = new Long(data.get("accountId"));
		final long customerId = new Long(data.get("customerId"));
		final long msnAdGroupId = new Long(data.get("msnAdGroupId"));
		final List<String> metroTargets = Arrays.asList(data.get("metroTargets").split(separator));
		setAdGroupMetroAreaTargets(accountId, customerId, msnAdGroupId, metroTargets);
		return gson.toJson(0);
	}

	@Override
	public void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws MsnCloudException
	{
		final String operationDescription = "Set AdGroup Metro Area Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], MsnAdGroupID [" + msnAdGroupId + "], MetroTargets [" + metroTargets + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final Target[] targets = makeMetroAreaTargets(metroTargets);
			addTargetsToAdGroup(msnAdGroupId, campaignManagement, targets);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	private void addTargetsToAdGroup(Long adGroupId, ICampaignManagementService campaignManagement, Target[] targets) throws MsnCloudException
	{
		final String operationDescription = "Add Targets To AdGroup for AdGroupID [" + adGroupId + "], Targets [" + SemplestUtils.getMsnTargetString(targets, false) + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			long targetId = addTargetsToLibrary(campaignManagement, targets);
			final SetTargetToAdGroupRequest setTargetToCampaignRequest = new SetTargetToAdGroupRequest(adGroupId, targetId);
			campaignManagement.setTargetToAdGroup(setTargetToCampaignRequest);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteAdGroupTargets(String json) throws Exception
	{
		logger.debug("call deleteAdGroupTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteAdGroupTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")));
		return gson.toJson(0);
	}

	@Override
	public void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Delete AdGroup Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final Target adGroupTargets = getAdGroupTargets(accountId, customerId, adGroupId);
			if (adGroupTargets == null)
			{
				return;
			}
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			campaignManagement.deleteTargetFromAdGroup(new DeleteTargetFromAdGroupRequest(adGroupId));
			final DeleteTargetsFromLibraryRequest deleteTargetsFromLibraryRequest = new DeleteTargetsFromLibraryRequest(new long[] { adGroupTargets.getId() });
			campaignManagement.deleteTargetsFromLibrary(deleteTargetsFromLibraryRequest);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getAdGroupTargets(String json) throws Exception
	{
		logger.debug("call getAdGroupTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Target ret = getAdGroupTargets(new Long(data.get("accountId")), new Long(data.get("customerId")), new Long(data.get("adGroupId")));
		return gson.toJson(ret);
	}

	@Override
	public Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Get AdGroup Targets for AccountID [" + accountId + "], CustomerID [" + customerId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerId);
			final GetTargetByAdGroupIdRequest getTargetByAdGroupIdRequest = new GetTargetByAdGroupIdRequest(adGroupId);
			final GetTargetByAdGroupIdResponse targetByAdGroupId = campaignManagement.getTargetByAdGroupId(getTargetByAdGroupIdRequest);
			return targetByAdGroupId.getTarget();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	// ==================================
	// Ad Methods
	// ==================================
	public String createAd(String json) throws Exception
	{
		logger.debug("call createAd(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final long ret = createAd(new Long(data.get("accountId")), new Long(data.get("adGroupId")), data.get("title"), data.get("text"), data.get("displayUrl"), data.get("destinationUrl"));
		return gson.toJson(ret);
	}

	@Override
	public long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws MsnCloudException
	{
		final String operationDescription = "Create Ad for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], Title [" + title + "], Text [" + text + "], DisplayURL [" + displayUrl + "], DestinationURL [" + destinationUrl + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final TextAd ad = new TextAd();
			ad.setText(text);
			ad.setTitle(title);
			ad.setDisplayUrl(displayUrl);
			ad.setDestinationUrl(destinationUrl);
			final AddAdsResponse addAds = campaignManagement.addAds(new AddAdsRequest(adGroupId, new Ad[] { ad }));
			return addAds.getAdIds()[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getAdById(String json) throws Exception
	{
		logger.debug("call getAdById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Ad ret = getAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		return gson.toJson(new MsnAdObject(ret));
	}

	@Override
	public Ad getAdById(Long accountId, Long adGroupId, long adId) throws MsnCloudException
	{
		final String operationDescription = "Get Ad by ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], AdID [" + adId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final Account account = getAccountById(accountId);
			final String accountName = account.getName();
			logger.info("MSN Account Name: " + accountName);
			final Long msnCustomerID = getCustomerID(accountName);
			if (msnCustomerID != null)
			{
				logger.info("MSN customerID: " + msnCustomerID);
			}
			else
			{
				throw new MsnCloudException("Problems retrieving MsnCustomerID for AccountID [" + accountId + "]");
			}
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, msnCustomerID);
			final long[] adIds = new long[] { adId };
			final GetAdsByIdsRequest request = new GetAdsByIdsRequest(adGroupId, adIds);
			final GetAdsByIdsResponse response = campaignManagement.getAdsByIds(request); 
			final Ad[] ads = response.getAds(); 
			return ads[0];
/*
			final GetAdsByAdGroupIdRequest adGroupIdrequest = new GetAdsByAdGroupIdRequest(adGroupId);
			final GetAdsByAdGroupIdResponse response = campaignManagement.getAdsByAdGroupId(adGroupIdrequest);
			final Ad[] ads = response.getAds();
			Ad theAd = null;
			for (final Ad ad : ads)
			{
				final long currentAdId = ad.getId();
				logger.info(currentAdId);
				theAd = ad;
			}
			return theAd;
*/
			/*
			 * f
			 */
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getAdsByAdGroupId(String json) throws Exception
	{
		logger.debug("call getAdsByAdGroupId(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Ad[] ret = getAdsByAdGroupId(new Long(data.get("accountId")), new Long(data.get("adGroupId")));
		final MsnAdObject[] ret1 = new MsnAdObject[ret.length];
		for (int i = 0; i < ret.length; i++)
		{
			ret1[i] = new MsnAdObject();
			ret1[i].fromAd(ret[i]);
		}
		return gson.toJson(ret1);
	}

	@Override
	public Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Get Ads By AdGroup ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetAdsByAdGroupIdResponse ads = campaignManagement.getAdsByAdGroupId(new GetAdsByAdGroupIdRequest(adGroupId));
			return ads.getAds();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String updateAdById(String json) throws Exception
	{
		logger.debug("call updateAdById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		updateAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")), data.get("title"), data.get("text"), data.get("displayUrl"), data.get("destinationUrl"));
		return gson.toJson(0);
	}

	public Map<UpdateAdRequest, Long> updateAllAdById(UpdateAdsRequestObj request) throws MsnCloudException
	{
		final String operationDescription = "Update All Ads By ID for Request [" + request + "]";
		final String operationDescriptionPretty = "Update All Ads By ID for Request [" + request.toStringPretty() + "]";
		logger.info("Will try to " + operationDescriptionPretty);
		try
		{
			final Long accountID = Long.valueOf(request.getAccountID());
			final Long adGroupID = request.getAdGroupID();
			final List<UpdateAdRequest> adList = request.getUpdateRequests();
			final Map<UpdateAdRequest, Long> requestToNewAdIdMap = new HashMap<UpdateAdRequest, Long>();
			for (UpdateAdRequest ad : adList)
			{
				final String adText = SemplestUtils.isNullReturnEmptyString(ad.getNewDescription1()) + " " + SemplestUtils.isNullReturnEmptyString(ad.getNewDescription2());
				final Long adId = ad.getAdId();
				updateAdById(accountID, adGroupID, adId, ad.getNewHeadline(), adText.trim(), ad.getNewDisplayURL(), ad.getNewUrl());
				requestToNewAdIdMap.put(ad, adId);
			}
			return requestToNewAdIdMap;
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl) throws MsnCloudException
	{
		final String operationDescription = "Update ad By ID for AccountID [" + adGroupId + "], AdGroupId [" + adGroupId + "], AdId [" + adId + "], Title [" + title + "], Text [" + text + "], DisplayUrl [" + displayUrl + "], DestinationURL [" + destinationUrl + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Ad ad = getAdById(accountId, adGroupId, adId);
			ad.setEditorialStatus(null);
			ad.setStatus(null);
			if (ad instanceof TextAd)
			{
				final TextAd textAd = (TextAd) ad;
				textAd.setTitle(title);
				textAd.setText(text);
				textAd.setDisplayUrl(displayUrl);
				textAd.setDestinationUrl(destinationUrl);
			}
			else
			{
				throw new Exception("Ad for MsnID [] is not a TextAd, but is " + ad.getType() + ", which is unexpected, so will not update it");
			}
			final Ad[] ads = new Ad[] { ad };
			final UpdateAdsRequest request = new UpdateAdsRequest(adGroupId, ads);
			final UpdateAdsResponse response = campaignManagement.updateAds(request);
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String pauseAdById(String json) throws Exception
	{
		logger.debug("call pauseAdById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		pauseAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		return gson.toJson(0);
	}

	@Override
	public void pauseAdById(Long accountId, Long adGroupId, long adId) throws MsnCloudException
	{
		final String operationDescription = "Pause Ad By ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], AdID [" + adId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.pauseAds(new PauseAdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String resumeAdById(String json) throws Exception
	{
		logger.debug("call resumeAdById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		resumeAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		return gson.toJson(0);
	}

	@Override
	public void resumeAdById(Long accountId, Long adGroupId, long adId) throws MsnCloudException
	{
		final String operationDescription = "Resume Ad By ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], AdID [" + adId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.resumeAds(new ResumeAdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteAdById(String json) throws Exception
	{
		logger.debug("call deleteAdById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteAdById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("adId")));
		return gson.toJson(0);
	}

	@Override
	public void deleteAdById(Long accountId, Long adGroupId, long adId) throws MsnCloudException
	{
		final String operationDescription = "Delete Ad By ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], AdID [" + adId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.deleteAds(new DeleteAdsRequest(adGroupId, new long[] { adId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	// ==================================
	// Keyword Methods
	// ==================================
	public String createKeyword(String json) throws Exception
	{
		logger.debug("call createKeyword(String json) [" + json + "]");
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final String matchTypeString = data.get("matchType");
		final MatchType matchType = gson.fromJson(matchTypeString, MatchType.class);
		final String bidString = data.get("bid");
		final Bid bid = gson.fromJson(bidString, Bid.class);
		final String accountIdString = data.get("accountId");
		final Long accountId = Long.valueOf(accountIdString);
		final String adGroupIdString = data.get("adGroupId");
		final Long adGroupId = Long.valueOf(adGroupIdString);
		final String text = data.get("text");
		final long ret = createKeyword(accountId, adGroupId, text, matchType, bid);
		return gson.toJson(ret);
	}

	@Override
	public Map<Integer, String> setNegativeKeywords(final Long accountId, final Long campaignId, final Map<String, Integer> negativeKeywordToPkMap) throws MsnCloudException
	{
		final String operationDescription = "Set Negative Keywords for AccountID [" + accountId + "], CampaignID [" + campaignId + "], NegativeKeywords [" + negativeKeywordToPkMap + "]";
		logger.info("Will try to " + operationDescription);
		final Map<Integer, String> filteredPkToCommentMap = new HashMap<Integer, String>();
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Set<Entry<String, Integer>> entrySet = negativeKeywordToPkMap.entrySet();
			for (final Entry<String, Integer> entry : entrySet)
			{
				final String negativeKeyword = entry.getKey();
				final Integer pk = entry.getValue();
				final String[] negativeKeywordsArray = new String[] { negativeKeyword };
				final CampaignNegativeKeywords campaignNegativeKeywords = new CampaignNegativeKeywords(campaignId, negativeKeywordsArray);
				final CampaignNegativeKeywords[] campaignNegativeKeywordsArray = new CampaignNegativeKeywords[] { campaignNegativeKeywords };
				final SetNegativeKeywordsToCampaignsRequest request = new SetNegativeKeywordsToCampaignsRequest(accountId, campaignNegativeKeywordsArray);
				final Map<CampaignNegativeKeywords, Integer> negKeywordToPkMap = new HashMap<CampaignNegativeKeywords, Integer>();
				negKeywordToPkMap.put(campaignNegativeKeywords, pk);
				final AddNegativeKeywordsRetriableMsnOperation operation = new AddNegativeKeywordsRetriableMsnOperation(campaignManagement, request, negKeywordToPkMap, SemplestUtils.DEFAULT_RETRY_COUNT);
				operation.performOperation();
				final Map<Integer, String> currentFilteredPkToCommentMap = operation.getFilteredOutKeywordPkToCommentMap();
				filteredPkToCommentMap.putAll(currentFilteredPkToCommentMap);
			}
			return filteredPkToCommentMap;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public Keyword getKeyword(Long accountId, Long adGroupId, String text, MatchType matchType, Bid bid) throws Exception
	{
		final Keyword keyword = new Keyword();
		keyword.setText(text);
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
	public long createKeyword(Long accountId, Long adGroupId, String text, MatchType matchType, Bid bid) throws MsnCloudException
	{
		final String operationDescription = "Create Keyword for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], Text [" + text + "], MatchType [" + matchType + "], Bid [" + bid + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Keyword keyword = getKeyword(accountId, adGroupId, text, matchType, bid);
			final AddKeywordsResponse addKeywordsResponse = campaignManagement.addKeywords(new AddKeywordsRequest(adGroupId, new Keyword[] { keyword }));
			return addKeywordsResponse.getKeywordIds()[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public static String getKeywordsString(final Keyword... keywords)
	{
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keywords.length; ++i)
		{
			final Keyword k = keywords[i];
			if (sb.length() != 0)
			{
				sb.append(SemplestUtils.LINE_SEPARATOR);
			}
			sb.append(i).append(": ").append(k.getText());
		}
		return sb.toString();
	}

	public Map<String, Long> getKeywordToMsnIdMap(final Keyword[] keywords, final long[] msnKeywordIds)
	{
		final Map<String, Long> keywordToMsnIdMap = new HashMap<String, Long>();
		for (int i = 0; i < keywords.length; ++i)
		{
			final Keyword keyword = keywords[i];
			final long msnId = msnKeywordIds[i];
			final String keywordText = keyword.getText();
			keywordToMsnIdMap.put(keywordText, msnId);
		}
		return keywordToMsnIdMap;
	}

	@Override
	public MsnCreateKeywordsResponse createKeywords(final Long accountId, final Long adGroupId, final Map<Keyword, Integer> keywordToPkMap) throws MsnCloudException
	{
		final String operationDescription = "Create Keywords for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], " + keywordToPkMap.size() + " Keywords<->PK map [<potentially too many to list>]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Set<Keyword> keywordSet = keywordToPkMap.keySet();
			final Keyword[] keywords = keywordSet.toArray(new Keyword[keywordSet.size()]);
			final AddKeywordsRequest request = new AddKeywordsRequest(adGroupId, keywords);
			final AddKeywordsRetriableMsnOperation retriableOperation = new AddKeywordsRetriableMsnOperation(campaignManagement, request, keywordToPkMap, SemplestUtils.DEFAULT_RETRY_COUNT);
			final AddKeywordsResponse response = retriableOperation.performOperation();
			final Map<Integer, String> filteredOutKeywordPkToCommentMap = retriableOperation.getFilteredOutKeywordPkToCommentMap();
			final AddKeywordsRequest latestFilteredRequest = retriableOperation.getAddKeywordsRequest();
			final Keyword[] latestFilteredKeywords = latestFilteredRequest.getKeywords();
			final long[] msnKeywordIds = response.getKeywordIds();
			final Map<String, Long> keywordToMsnIdMap = getKeywordToMsnIdMap(latestFilteredKeywords, msnKeywordIds);
			final MsnCreateKeywordsResponse msnCreateKeywordsResponse = new MsnCreateKeywordsResponse(keywordToMsnIdMap, filteredOutKeywordPkToCommentMap);
			return msnCreateKeywordsResponse;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getKeywordById(String json) throws Exception
	{
		logger.debug("call getKeywordById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Keyword ret = getKeywordById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("keywordId")));
		return gson.toJson(new MsnKeywordObject(ret));
	}

	@Override
	public Keyword getKeywordById(Long accountId, Long adGroupId, long keywordId) throws MsnCloudException
	{
		final String operationDescription = "Create Keywords for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], KeywordID [" + keywordId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetKeywordsByIdsResponse keywordsByIds = campaignManagement.getKeywordsByIds(new GetKeywordsByIdsRequest(adGroupId, new long[] { keywordId }));
			final Keyword[] keywords = keywordsByIds.getKeywords();
			if (keywords.length == 1 && keywords[0] != null)
			{
				return keywords[0];
			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return null;
	}

	public String getKeywordByAdGroupId(String json) throws Exception
	{
		logger.debug("call getKeywordByAdGroupId(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Keyword[] ret1 = getKeywordByAdGroupId(new Long(data.get("accountId")), new Long(data.get("adGroupId")));
		if (ret1 == null)
		{
			return gson.toJson(null);
		}
		final MsnKeywordObject[] ret = new MsnKeywordObject[ret1.length];
		for (int i = 0; i < ret1.length; i++)
		{
			ret[i] = new MsnKeywordObject();
			ret[i].fromKeyword(ret1[i]);
		}
		return gson.toJson(ret);
	}

	@Override
	public Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Create Keywords By AdGroup ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetKeywordsByAdGroupIdResponse keywordsByAdGroupId = campaignManagement.getKeywordsByAdGroupId(new GetKeywordsByAdGroupIdRequest(adGroupId));
			return keywordsByAdGroupId.getKeywords();
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
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
		updateKeywordBidById(accountId, adGroupId, keywordId, matchType, bid);
		return gson.toJson(0);
	}

	@Override
	public void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, MatchType matchType, Bid bid) throws MsnCloudException
	{
		final String operationDescription = "Update Keywords Bid By ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], KeywordID [" + keywordId + "], MatchType [" + matchType + "], Bid [" + bid + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final Keyword keyword = new Keyword();
			keyword.setId(keywordId);
			keyword.setStatus(KeywordStatus.Paused);
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
			campaignManagement.updateKeywords(new UpdateKeywordsRequest(adGroupId, new Keyword[] { keyword }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public Boolean updateKeywordStatus(Long accountID, Long adGroupID, Map<Long, Boolean> kwCriterionIsActive) throws MsnCloudException
	{
		final String operationDescription = "Update Keyword Status for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], KeywordData [" + SemplestUtils.getEasilyReadableString(kwCriterionIsActive) + "]";
		logger.info("Will try to " + operationDescription);
		final List<List<Long>> kwBatchPause;
		final List<List<Long>> kwBatchResume;
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountID);
			if (!kwCriterionIsActive.keySet().isEmpty())
			{
				final List<Long> kwListIdsPause = new ArrayList<Long>();
				final List<Long> kwListIdsResume = new ArrayList<Long>();
				for (Long kwIdfromMap : kwCriterionIsActive.keySet())
				{
					if (kwCriterionIsActive.get(kwIdfromMap))
					{
						kwListIdsResume.add(kwIdfromMap);
					}
					else if (!kwCriterionIsActive.get(kwIdfromMap))
					{
						kwListIdsPause.add(kwIdfromMap);
					}
					else
					{
						throw new Exception("Not a valid value in Map for KewyordId [" + kwIdfromMap + "]");
					}
				}
				kwBatchResume = SemplestUtils.getBatches(kwListIdsResume, 1000);
				kwBatchPause = SemplestUtils.getBatches(kwListIdsPause, 1000);
			}
			else
			{
				throw new Exception("The input map is empty");
			}
			for (List<Long> kwListPause : kwBatchPause)
			{
				if (!kwListPause.isEmpty())
				{
					long[] kwIds = new long[kwListPause.size()];
					int index = 0;
					for (Long kw : kwListPause)
					{
						kwIds[index++] = kw;
					}
					final PauseKeywordsRequest pauseReq = new PauseKeywordsRequest();
					pauseReq.setAdGroupId(adGroupID);
					pauseReq.setKeywordIds(kwIds);
					campaignManagement.pauseKeywords(pauseReq);
				}
			}
			for (List<Long> kwListResume : kwBatchResume)
			{
				if (!kwListResume.isEmpty())
				{
					long[] kwIds = new long[kwListResume.size()];
					int index = 0;
					for (Long kw : kwListResume)
					{
						kwIds[index++] = kw;
					}
					final ResumeKeywordsRequest resumeReq = new ResumeKeywordsRequest();
					resumeReq.setAdGroupId(adGroupID);
					resumeReq.setKeywordIds(kwIds);
					campaignManagement.resumeKeywords(resumeReq);
				}
			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return true;
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
			final Double microBidAmountDouble = (microBidAmountLong == null ? null : new Double(((double) microBidAmountLong) / 1000000));
			final Bid keywordBid = new Bid(microBidAmountDouble);
			keyword.setId(keywordAdEngineID);
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
	public void updateKeywordBidsByIds(Long accountId, Long adGroupId, List<BidElement> bids) throws MsnCloudException
	{
		final String operationDescription = "Update Keyword Bids By Ids for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], BidElements [" + bids + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final List<Keyword> keywords = getKeywords(bids);
			final int batchSize = 1000;
			final List<List<Keyword>> keywordBatches = SemplestUtils.getBatches(keywords, batchSize);
			logger.info(keywords.size() + " Keywords broken up into " + keywordBatches.size() + " batches of " + batchSize);
			for (final List<Keyword> keywordBatch : keywordBatches)
			{
				final Keyword[] keywordArray = keywordBatch.toArray(new Keyword[keywordBatch.size()]);
				campaignManagement.updateKeywords(new UpdateKeywordsRequest(adGroupId, keywordArray));
			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String pauseKeywordById(String json) throws Exception
	{
		logger.debug("call pauseKeywordById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		pauseKeywordById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("keywordId")));
		return gson.toJson(0);
	}

	@Override
	public void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws MsnCloudException
	{
		final String operationDescription = "Pause Keyword By ID for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], KeywordID [" + keywordId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.pauseKeywords(new PauseKeywordsRequest(adGroupId, new long[] { keywordId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public void pauseKeywordsByIds(Long accountId, Long adGroupId, long[] keywordIds) throws MsnCloudException
	{
		final String operationDescription = "Pause Keyword By IDs for AccountID [" + accountId + "], AdGroupID [" + adGroupId + "], KeywordID [" + Arrays.asList(keywordIds) + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.pauseKeywords(new PauseKeywordsRequest(adGroupId, keywordIds));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteKeywordById(String json) throws Exception
	{
		logger.debug("call deleteKeywordById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteKeywordById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), new Long(data.get("keywordId")));
		return gson.toJson(0);
	}

	@Override
	public void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws MsnCloudException
	{
		final String operationDescription = "Delete Keyword By ID for AccountID [" + accountId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			campaignManagement.deleteKeywords(new DeleteKeywordsRequest(adGroupId, new long[] { keywordId }));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String deleteKeywordsById(String json) throws Exception
	{
		logger.debug("call deleteKeywordsById(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final String keywordIdsStr = data.get("keywordIds");
		final long[] keywordIds = gson.fromJson(keywordIdsStr, long[].class);
		deleteKeywordsById(new Long(data.get("accountId")), new Long(data.get("adGroupId")), keywordIds);
		return gson.toJson(0);
	}

	@Override
	public void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws MsnCloudException
	{
		final String operationDescription = "Delete Keywords By ID for AccountId [" + accountId + "], AdGroupID [" + adGroupId + "], KeywordIds [" + SemplestUtils.getStringForArray(keywordIds) + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final DeleteKeywordsResponse response = campaignManagement.deleteKeywords(new DeleteKeywordsRequest(adGroupId, keywordIds));
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
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
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final TrafficEstimatorObject ret = getKeywordEstimateByBids(new Long(data.get("accountId")), gson.fromJson(data.get("keywords"), String[].class), gson.fromJson(data.get("microBidAmount"), Long[].class), gson.fromJson(data.get("matchType"), MatchType.class));
		return gson.toJson(ret);
	}

	public String deleteAllTargetsInCampaign(String json) throws Exception
	{
		logger.debug("call deleteAllTargetsInCampaign(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		deleteAllTargetsInCampaign(new Long(data.get("accountId")), new Long(data.get("campaignId")));
		return gson.toJson(0);
	}

	@Override
	public void deleteAllTargetsInCampaign(Long accountId, Long campaignId) throws MsnCloudException
	{
		final String operationDescription = "Delete All Targets In Campaign for AccountId [" + accountId + "], CampaignId [" + campaignId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final Account account = getAccountById(accountId);
			final Long customerID = getCustomerID(account.getName());
			logger.info("accountName: " + account.getName());
			if (customerID != null)
			{
				logger.info("customerID: " + customerID);
			}
			else
			{
				throw new MsnCloudException("Problems retrieving customerID");
			}
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, customerID);

			// Get targets already isntalled
			final GetTargetsByCampaignIdsRequest getTargReq = new GetTargetsByCampaignIdsRequest();
			getTargReq.setCampaignIds(new long[] { campaignId });

			final GetTargetsByCampaignIdsResponse getTargResp = campaignManagement.getTargetsByCampaignIds(getTargReq);
			Target[] targetsStored = getTargResp.getTargets();

			// Delete installed targets
			if (targetsStored[0] != null)
			{
				final DeleteTargetFromCampaignRequest reqDelTarg = new DeleteTargetFromCampaignRequest();
				reqDelTarg.setCampaignId(campaignId);
				final DeleteTargetFromCampaignResponse respDelTar = campaignManagement.deleteTargetFromCampaign(reqDelTarg);
			}

			// Get businesses already installed
			final GetBusinessesInfoRequest busreq = new GetBusinessesInfoRequest();
			final GetBusinessesInfoResponse busres = campaignManagement.getBusinessesInfo(busreq);
			final BusinessInfo[] busInf = busres.getBusinessesInfo();
			final long[] storedBusIDs = new long[busInf.length];

			// Delete businesses installed
			if (busInf != null && busInf.length > 0 && busInf[0].getId() > 0)
			{
				for (int i = 0; i < busInf.length; i++)
				{
					final DeleteBusinessesRequest delBusReq = new DeleteBusinessesRequest();
					delBusReq.setBusinessIds(new long[] { busInf[i].getId() });
					campaignManagement.deleteBusinesses(delBusReq);
				}
			}
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}

	}

	private Boolean setBusinessTargetObject(ICampaignManagementService campaignManagement, Target[] targetsStored, Account account, Long campaignId, Double radius, String addr, String city, String state, String country, String zip) throws MsnCloudException
	{
		final String operationDescription = "Set Business Target Object for Account [" + SemplestUtils.getMsnAccountString(account) + "], CampaignId [" + campaignId + "], Radius [" + radius + "], Address [" + addr + "], City [" + city + "], State [" + state + "], Country [" + country + "], Zip ["
				+ zip + "], Targets [" + SemplestUtils.getMsnTargetString(targetsStored, false) + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final GetBusinessesInfoRequest busreq = new GetBusinessesInfoRequest();
			final GetBusinessesInfoResponse busres = campaignManagement.getBusinessesInfo(busreq);
			final BusinessInfo[] busInf = busres.getBusinessesInfo();
			final int[] busNamesInt;
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
			final long[] busIDs;
			logger.info("Creating business object with location...");
			final Business business = new Business();
			business.setName(name);
			business.setAddressLine1(addr);
			business.setCity(city);
			business.setCountryOrRegion(country);
			business.setStateOrProvince(state);
			business.setZipOrPostalCode(zip);
			final AddBusinessesRequest requestBus = new AddBusinessesRequest();
			requestBus.setBusinesses(new Business[] { business });
			final AddBusinessesResponse responseBus = campaignManagement.addBusinesses(requestBus);
			busIDs = responseBus.getBusinessIds();
			logger.info("Adding Business to Target...");
			final BusinessTargetBid bid = new BusinessTargetBid();
			bid.setBusinessId(busIDs[0]);
			bid.setIncrementalBid(IncrementalBidPercentage.ZeroPercent);
			bid.setRadius(radius.intValue());
			if (targetsStored[0] == null)
			{
				final Target target = new Target();
				final BusinessTarget busTarg = new BusinessTarget();
				busTarg.setBids(new BusinessTargetBid[] { bid });
				final LocationTarget locTarget = new LocationTarget();
				locTarget.setBusinessTarget(busTarg);
				target.setLocation(locTarget);
				final Target[] targets = new Target[] { target };
				final AddTargetsToLibraryRequest requestTar = new AddTargetsToLibraryRequest();
				requestTar.setTargets(targets);
				final AddTargetsToLibraryResponse responseTar = campaignManagement.addTargetsToLibrary(requestTar);
				final long[] targetIDs = responseTar.getTargetIds();
				// Add target object to campaign
				logger.info("Adding target to campaign...");
				final SetTargetToCampaignRequest requestCamp = new SetTargetToCampaignRequest();
				requestCamp.setTargetId(targetIDs[0]);
				requestCamp.setCampaignId(campaignId);
				final SetTargetToCampaignResponse responseCamp = campaignManagement.setTargetToCampaign(requestCamp);
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
				locUpdate.setBusinessTarget(busTarUpdate);
				targetUpdate.setLocation(locUpdate);
				targetUpdate.setIsLibraryTarget(null);
				final UpdateTargetsInLibraryRequest updateTarRequest = new UpdateTargetsInLibraryRequest();
				updateTarRequest.setTargets(new Target[] { targetUpdate });
				final UpdateTargetsInLibraryResponse updateTarResponse = campaignManagement.updateTargetsInLibrary(updateTarRequest);
			}
			// Determine if coordinates resolved and target active
			final GetBusinessesByIdsRequest requestStatus = new GetBusinessesByIdsRequest();
			requestStatus.setBusinessIds(busIDs);
			final GetBusinessesByIdsResponse responseStatus = campaignManagement.getBusinessesByIds(requestStatus);
			final Business[] storedBus = responseStatus.getBusinesses();
			final BusinessGeoCodeStatus geoStatus = storedBus[0].getGeoCodeStatus();
			logger.info("GeoCode Status: " + geoStatus.getValue());
			logger.info("Latitude: " + storedBus[0].getLatitudeDegrees());
			logger.info("Longitude: " + storedBus[0].getLongitudeDegrees());
			return true;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String updateGeoTargets(String json) throws Exception
	{
		logger.debug("call updateGeoTargets(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final String accountIdString = data.get("accountId");
		final Long accountId = Long.valueOf(accountIdString);
		final String campaignIdString = data.get("campaignId");
		final Long campaignId = Long.valueOf(campaignIdString);
		final String geoTargetVsTypeMapString = data.get("geoTargetVsTypeMap");
		final Map<GeoTargetObject, GeoTargetType> geoTargetVsTypeMap = gson.fromJson(geoTargetVsTypeMapString, SemplestUtils.TYPE_MAP_OF_GEO_TARGET_OBJECT_TO_GEO_TARGET_TYPE);
		final Boolean ret = updateGeoTargets(accountId, campaignId, geoTargetVsTypeMap);
		return gson.toJson(ret);
	}

	@Override
	public Boolean updateGeoTargets(final Long accountId, final Long campaignId, final Map<GeoTargetObject, GeoTargetType> geoTargetVsTypeMap) throws MsnCloudException
	{
		final String operationDescription = "Update Geo Targets for AccountID [" + accountId + "], CampaignID [" + campaignId + "], GeoTarget<->Type map [" + geoTargetVsTypeMap + "]";
		final String operationDescriptionPretty = "Update Geo Targets for AccountID [" + accountId + "], CampaignID [" + campaignId + "], GeoTarget<->Type map\n" + SemplestUtils.getEasilyReadableString(geoTargetVsTypeMap);
		logger.info("Will try to " + operationDescriptionPretty);
		try
		{

			final Account account = getAccountById(accountId);
			final String accountName = account.getName();
			logger.info("MSN Account Name: " + accountName);
			final Long msnCustomerID = getCustomerID(accountName);
			if (msnCustomerID != null)
			{
				logger.info("MSN customerID: " + msnCustomerID);
			}
			else
			{
				throw new MsnCloudException("Problems retrieving MsnCustomerID for AccountID [" + accountId + "]");
			}
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId, msnCustomerID);

			// delete existing geo targets
			final GetTargetsByCampaignIdsRequest getTargetsRequest = new GetTargetsByCampaignIdsRequest(new long[] { campaignId });
			final GetTargetsByCampaignIdsResponse getTargetResponse = campaignManagement.getTargetsByCampaignIds(getTargetsRequest);
			final Target[] existingTargets = getTargetResponse.getTargets();
			final List<Long> existingTargetIds = new ArrayList<Long>();
			for (final Target target : existingTargets)
			{
				if (target != null)
				{
					final Long targetId = target.getId();
					if (targetId != null)
					{
						existingTargetIds.add(targetId);
					}
				}
			}
			if (existingTargetIds.isEmpty())
			{
				logger.info("No previous GeoTargets found, so won't try to delete them as part of GeoTarget refresh");
			}
			else
			{
				logger.info("IDs for existing targets that we'll delete before refreshing with new ones:" + existingTargetIds);
				final long[] targetIdArray = new long[existingTargetIds.size()];
				for (int i = 0; i < existingTargetIds.size(); ++i)
				{
					targetIdArray[i] = existingTargetIds.get(i);
				}
				final DeleteTargetFromCampaignRequest deleteRequest = new DeleteTargetFromCampaignRequest(campaignId);
				final DeleteTargetFromCampaignResponse deleteResponse = campaignManagement.deleteTargetFromCampaign(deleteRequest);
			}

			// add latest geo targets
			final AddTargetsToLibraryRequest addRequest = new AddTargetsToLibraryRequest();
			final List<StateTargetBid> stateBids = new ArrayList<StateTargetBid>();
			final List<RadiusTargetBid> radiusBids = new ArrayList<RadiusTargetBid>();
			final Set<Entry<GeoTargetObject, GeoTargetType>> entrySet = geoTargetVsTypeMap.entrySet();
			for (final Entry<GeoTargetObject, GeoTargetType> entry : entrySet)
			{
				final GeoTargetType type = entry.getValue();
				final GeoTargetObject getTarget = entry.getKey();
				if (GeoTargetType.STATE == type)
				{
					final StateTargetBid stateTargetBid = new StateTargetBid();
					stateTargetBid.setIncrementalBid(IncrementalBidPercentage.ZeroPercent);
					final String state = getTarget.getState();
					final String usState = "US-" + state;
					stateTargetBid.setState(usState);
					stateBids.add(stateTargetBid);
				}
				else if (GeoTargetType.GEO_POINT == type)
				{
					final RadiusTargetBid radiusTargetBid = new RadiusTargetBid();
					radiusTargetBid.setIncrementalBid(IncrementalBidPercentage.ZeroPercent);
					final double latitudeDegrees = getTarget.getLatitude();
					final double longitudeDegrees = getTarget.getLongitude();
					final double radius = getTarget.getRadius();
					radiusTargetBid.setLatitudeDegrees(latitudeDegrees);
					radiusTargetBid.setLongitudeDegrees(longitudeDegrees);
					final int radiusInt = (int) radius;
					radiusTargetBid.setRadius(radiusInt);
					radiusBids.add(radiusTargetBid);
				}
				else
				{
					throw new MsnCloudException("Problem doing " + operationDescription + " beucase encountered GeoTargetType [" + type + "] that is not either [" + GeoTargetType.STATE + "] or [" + GeoTargetType.GEO_POINT + "]");
				}
			}
			final Target target = new Target();
			final LocationTarget location = new LocationTarget();

			logger.info("Prepared " + stateBids.size() + " State Target Bids and " + radiusBids.size() + " Radius Target Bids");
			if (stateBids.isEmpty() && radiusBids.isEmpty())
			{
				logger.info("No State or Radius Rargets were generated, so doing nothing");
				return true;
			}
			if (!stateBids.isEmpty())
			{
				final StateTarget stateTarget = new StateTarget();
				final StateTargetBid[] stateTargetBids = stateBids.toArray(new StateTargetBid[stateBids.size()]);
				stateTarget.setBids(stateTargetBids);
				location.setStateTarget(stateTarget);
			}
			if (!radiusBids.isEmpty())
			{
				final RadiusTarget radiusTarget = new RadiusTarget();
				final RadiusTargetBid[] radiusTargetBids = radiusBids.toArray(new RadiusTargetBid[radiusBids.size()]);
				radiusTarget.setBids(radiusTargetBids);
				location.setRadiusTarget(radiusTarget);
			}
			target.setLocation(location);
			final Target[] targetArray = new Target[] { target };
			addRequest.setTargets(targetArray);
			final AddTargetsToLibraryResponse response = campaignManagement.addTargetsToLibrary(addRequest);
			final long[] targetIds = response.getTargetIds();
			logger.info("Resulting Target Ids: " + SemplestUtils.getStringForArray(targetIds));
			for (final long targetId : targetIds)
			{
				logger.info("Will try to set Target for ID [" + targetId + "] into Campaign for ID [" + campaignId + "]");
				final SetTargetToCampaignRequest setTargetRequest = new SetTargetToCampaignRequest();
				setTargetRequest.setTargetId(targetId);
				setTargetRequest.setCampaignId(campaignId);
				final SetTargetToCampaignResponse setTargetResponse = campaignManagement.setTargetToCampaign(setTargetRequest);
			}
			return true;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public TrafficEstimatorObject getKeywordEstimateByBids(Long accountId, String[] keywords, Long[] microBidAmount, MatchType matchType) throws MsnCloudException
	{
		final String operationDescription = "Get Keyword Estimate By Bids [" + accountId + "], Keywords [" + Arrays.asList(keywords) + "], MicroBidAmounts [" + Arrays.asList(microBidAmount) + "], MatchType [" + matchType + "]";
		logger.info("Will try to " + operationDescription);
		logger.info("Will try to get Keyword Estimate by Bids using AccountID [" + accountId + "], " + keywords.length + " Keywords, " + microBidAmount.length + " MicroBidAmounts, MatchType [" + matchType + "]");
		final List<String> keywordList = Arrays.asList(keywords);
		final List<Long> microBidAmountList = Arrays.asList(microBidAmount);
		logger.info("Keywords:\n" + SemplestUtils.getEasilyReadableString(keywordList));
		logger.info("MicroBidAmounts:\n" + SemplestUtils.getEasilyReadableString(microBidAmountList));
		TrafficEstimatorObject ret = new TrafficEstimatorObject();
		try
		{
			// IAdIntelligenceService adInteligenceService =
			// getAdInteligenceService(adCenterCredentials.getParentCustomerID());
			for (int i = 0; i < microBidAmount.length; i++)
			{
				logger.info("bid value estimated - " + microBidAmount[i]);
				final IAdIntelligenceService adInteligenceService = getAdInteligenceService(accountId);
				final Double bidtest = microBidAmount[i] * 1.00 / 1000000.00;
				final GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest = new GetEstimatedPositionByKeywordsRequest(keywords, (microBidAmount[i] * 1.00 / 1000000.00), "English", new String[] { "US" }, Currency.USDollar, new MatchType[] { matchType });
				final GetEstimatedPositionByKeywordsResponse estimatedPositionByKeywords = adInteligenceService.getEstimatedPositionByKeywords(getEstimatedPositionByKeywordsRequest);
				final KeywordEstimatedPosition[] keywordEstimatedPositions = estimatedPositionByKeywords.getKeywordEstimatedPositions();
				final Long bidAmount = microBidAmount[i]; // .getDoubleDollars();
				for (int j = 0; j < keywordEstimatedPositions.length; j++)
				{
					final KeywordEstimatedPosition k = keywordEstimatedPositions[j];
					final String keyword = k.getKeyword();
					if (k.getEstimatedPositions() != null)
					{
						for (EstimatedPositionAndTraffic et : k.getEstimatedPositions())
						{
							final String adPosition = et.getEstimatedAdPosition().getValue();
							Double baseVal = 0.0;
							if (adPosition.contains("SideBar"))
							{
								baseVal = 5.0;
							}
							Double estAdPosition = Double.valueOf(adPosition.substring(adPosition.length() - 1)) + baseVal;
							// Test
							// variables///////////////////////////////////////////////
							Long in1 = new Long((new Double(et.getAverageCPC() * 1000000)).longValue());
							float in2 = (float) (et.getMinClicksPerWeek() / 7.0);
							float in3 = (float) (et.getMaxClicksPerWeek() / 7.0);
							Long in4 = new Long((new Double(et.getMinTotalCostPerWeek() * 1000000 / 7.0).longValue()));
							Long in5 = new Long((new Double(et.getMaxTotalCostPerWeek() * 1000000 / 7.0).longValue()));
							// /////////////////////////////////////////////////////////////*/
							ret.setBidData(keyword, bidAmount, et.getMatchType().toString(), new Long((new Double(et.getAverageCPC() * 1000000)).longValue()), new Long((new Double(et.getAverageCPC() * 1000000)).longValue()), estAdPosition, estAdPosition, (float) (et.getMinClicksPerWeek() / 7.0),
									(float) (et.getMaxClicksPerWeek() / 7.0), new Long((new Double(et.getMinTotalCostPerWeek() * 1000000 / 7.0).longValue())), new Long((new Double(et.getMaxTotalCostPerWeek() * 1000000 / 7.0).longValue())));
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
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return ret;
	}

	/*
	 * Takes an account ID, a String array of keywords, MonthAndYear object giving the desired month and year to begin collecting data. Uses the MSN
	 * API to get search volume data by keyword, by month from the start month to the most recent month available Returns a HashMap mapping search
	 * terms (keywords) to int[][] element i of the int[][] holds a 3-element int[] giving month, year, and search volume for keyword i
	 */
	public HashMap<String, int[][]> getKeywordVolumes(Long accountId, String[] keywords, MonthAndYear startMonth) throws MsnCloudException
	{
		final String operationDescription = "Get Keyword Volumes [" + accountId + "], Keywords [" + Arrays.asList(keywords) + "], MonthAndYear [" + startMonth + "]";
		logger.info("Will try to " + operationDescription);
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
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
		return ret;
	}

	/*
	 * Get MSN-suggested keywords for a given set of input words. Takes an account id, a String[] of keywords to get suggestions for, and an int
	 * giving the maximum number of suggestions per input word. Returns a HashMap mapping input keywords to String[]'s holding the suggested keywords
	 */
	public HashMap<String, String[]> getKeywordSuggestions(Long accountId, String[] keywords, int maxRecs) throws MsnCloudException
	{
		final String operationDescription = "Get Keyword Suggestions [" + accountId + "], Keywords [" + Arrays.asList(keywords) + "], MaxRecs [" + maxRecs + "]";
		logger.info("Will try to " + operationDescription);
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
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
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
	private long addTargetsToLibrary(ICampaignManagementService campaignManagement, Target[] targets) throws MsnCloudException
	{
		final String operationDescription = "Add Targets To Library for Targets [" + SemplestUtils.getMsnTargetString(targets, false) + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final AddTargetsToLibraryRequest addTargetsToLibraryRequest = new AddTargetsToLibraryRequest();
			addTargetsToLibraryRequest.setTargets(targets);
			final AddTargetsToLibraryResponse addTargetsToLibraryResponse = campaignManagement.addTargetsToLibrary(addTargetsToLibraryRequest);
			long[] targetIds = addTargetsToLibraryResponse.getTargetIds();
			return targetIds[0];
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
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
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final ReportAggregation aggregation = gson.fromJson(data.get("aggregation"), ReportAggregation.class);
		final String ret = requestKeywordReport(new Long(data.get("accountId")), new Long(data.get("campaignId")), new DateTime(data.get("firstDay")), new DateTime(data.get("lastDay")), aggregation);
		return gson.toJson(ret);
	}

	@Override
	public String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation) throws MsnCloudException
	{
		final String operationDescription = "Request Keyword Report for AccountID [" + accountId + "], CampaignID [" + campaignId + "], FirstDay [" + firstDay + "], LastDay [" + lastDay + "], Aggregation [" + aggregation + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final ReportTime time = new MsnTime(firstDay).reportTimeTill(lastDay, timeServer.now());
			return requestKeywordReport(accountId, campaignId, time, aggregation);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	/**
	 * Request a report for account, campaign. Set campaignId == 0 to report on all campaigns.
	 * 
	 * @throws MsnCloudException
	 */
	public String requestKeywordReport(Long accountId, Long campaignId, ReportTime time, ReportAggregation aggregation) throws MsnCloudException
	{
		final String operationDescription = "Request Keyword Report for AccountID [" + accountId + "], CampaignID [" + campaignId + "], ReportTime [" + time + "], ReportAggregation [" + aggregation + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			KeywordPerformanceReportColumn[] columns;
			columns = new KeywordPerformanceReportColumn[] { KeywordPerformanceReportColumn.Keyword, KeywordPerformanceReportColumn.KeywordId, KeywordPerformanceReportColumn.AveragePosition, KeywordPerformanceReportColumn.Clicks, KeywordPerformanceReportColumn.CurrentMaxCpc,
					KeywordPerformanceReportColumn.QualityScore, KeywordPerformanceReportColumn.Impressions, KeywordPerformanceReportColumn.AverageCpc, KeywordPerformanceReportColumn.BidMatchType, KeywordPerformanceReportColumn.TimePeriod, KeywordPerformanceReportColumn.CampaignId,
					KeywordPerformanceReportColumn.Spend };
			final boolean returnOnlyCompleteData = false;
			final String reportName = "Keyword Report for Account " + accountId + " Campaign ";
			// Scope: this campaignId, all ad groups.
			final AccountThroughAdGroupReportScope scope = new AccountThroughAdGroupReportScope(null, null, new CampaignReportScope[] { new CampaignReportScope(accountId, campaignId) });
			final KeywordPerformanceReportFilter filter = null;
			final KeywordPerformanceReportRequest request = new KeywordPerformanceReportRequest(ReportFormat.Csv, ReportLanguage.English, reportName + campaignId, returnOnlyCompleteData, aggregation, columns, filter, scope, time);
			return sendReportRequest(accountId, request);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String requestCampaignReport(String json) throws Exception
	{
		logger.debug("call requestCampaignReport(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final ReportAggregation aggregation = gson.fromJson(data.get("aggregation"), ReportAggregation.class);
		final String ret = requestCampaignReport(new Long(data.get("accountId")), new Long(data.get("campaignId")), new Integer(data.get("daysInReport")), aggregation);
		return gson.toJson(ret);
	}

	/**
	 * Request a report for account, campaign. Set campaignId == 0 to report on all campaigns.
	 * 
	 * @param accountId
	 * @param campaignId
	 * @throws MsnCloudException
	 */
	@Override
	public String requestCampaignReport(Long accountId, Long campaignId, int daysInReport, ReportAggregation aggregation) throws MsnCloudException
	{
		final String operationDescription = "Request Campaign Report for AccountID [" + accountId + "], CampaignID [" + campaignId + "], DaysInReport [" + daysInReport + "], Aggregation [" + aggregation + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			CampaignPerformanceReportColumn[] columns = new CampaignPerformanceReportColumn[] { CampaignPerformanceReportColumn.AccountName, CampaignPerformanceReportColumn.AccountNumber, CampaignPerformanceReportColumn.TimePeriod, CampaignPerformanceReportColumn.Status,
					CampaignPerformanceReportColumn.CampaignName, CampaignPerformanceReportColumn.CampaignId, CampaignPerformanceReportColumn.CurrencyCode, CampaignPerformanceReportColumn.AdDistribution, CampaignPerformanceReportColumn.Impressions, CampaignPerformanceReportColumn.Clicks,
					CampaignPerformanceReportColumn.Ctr, CampaignPerformanceReportColumn.AverageCpc, CampaignPerformanceReportColumn.Spend, CampaignPerformanceReportColumn.AveragePosition, CampaignPerformanceReportColumn.Conversions, CampaignPerformanceReportColumn.ConversionRate,
					CampaignPerformanceReportColumn.CostPerConversion, CampaignPerformanceReportColumn.LowQualityClicks, CampaignPerformanceReportColumn.LowQualityClicksPercent, CampaignPerformanceReportColumn.LowQualityImpressions, CampaignPerformanceReportColumn.LowQualityImpressionsPercent,
					CampaignPerformanceReportColumn.LowQualityConversions, CampaignPerformanceReportColumn.LowQualityConversionRate, CampaignPerformanceReportColumn.AverageCpm, CampaignPerformanceReportColumn.AverageCpc };
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
			final CampaignPerformanceReportRequest reportRequest = new CampaignPerformanceReportRequest(format, language, title, returnOnlyCompleteData, aggregation, columns, filter, scope, time);
			return sendReportRequest(accountId, reportRequest);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String sendReportRequest(Long accountId, final ReportRequest reportRequest) throws MsnCloudException
	{
		final String operationDescription = "Send Request Report for AccountID [" + accountId + "], ReportRequest [" + reportRequest + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final SubmitGenerateReportRequest submitGenerateReportRequest = new SubmitGenerateReportRequest();
			submitGenerateReportRequest.setReportRequest(reportRequest);
			final IReportingService reportingService = getReportingService(accountId);
			final SubmitGenerateReportResponse submitGenerateReportResponse = reportingService.submitGenerateReport(submitGenerateReportRequest);
			final String reportId = submitGenerateReportResponse.getReportRequestId();
			return reportId;
		}
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	public String getReportData(String json) throws Exception
	{
		logger.debug("call getReportData(String json)" + json);
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final Map<String, String[]> ret = getReportData(data.get("reportId"), new Long(data.get("accountId")));
		return gson.toJson(ret);
	}

	@Override
	public Map<String, String[]> getReportData(String reportId, Long accountId) throws MsnCloudException
	{
		final String operationDescription = "Get Report Data for AccountID [" + accountId + "], ReportId [" + reportId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final InputStreamReader streamReader = new InputStreamReader(getReportStream(reportId, accountId));
			CSVReader reader = new CSVReader(streamReader);
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
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
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

	private InputStream getReportAsZipStream(String reportId, Long accountId) throws RemoteException, MsnCloudException
	{
		final String operationDescription = "Get Report As Zip Stream for AccountID [" + accountId + "], ReportId [" + reportId + "]";
		logger.info("Will try to " + operationDescription);
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
	public ICustomerManagementService getCustomerManagementService()
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
			logger.info("CustomerManagementService namespace [" + namespace + "], URL [" + customerManagementUrl + "], Credentials [" + adCenterCredentials + "]");
			return customerManagementService;
		}
		catch (ServiceException e)
		{
			throw new RuntimeException("Problem creating CustomerManagementService", e);
		}
	}

	private ICampaignManagementService getCampaignManagementService(Long accountId) throws Exception
	{
		return getCampaignManagementService(accountId, NO_CUSTOMER_ID);
	}

	private ICampaignManagementService getCampaignManagementService(Long accountId, long customerId) throws Exception
	{
		final String namespace = adCenterCredentials.getCampaignManagementNamespace();
		final CampaignManagementServiceLocator campaignManagementServiceLocator = new CampaignManagementServiceLocator();
		campaignManagementServiceLocator.setBasicHttpBinding_ICampaignManagementServiceEndpointAddress(adCenterCredentials.getCampaignManagementUrl());
		final ICampaignManagementService campaignManagementService;
		try
		{
			campaignManagementService = campaignManagementServiceLocator.getBasicHttpBinding_ICampaignManagementService();
		}
		catch (ServiceException e)
		{
			throw new Exception("Problem getting a handle on CampaignManagementService using AccountID [" + accountId + "], CustomerID [" + customerId + "]");
		}
		final BasicHttpBinding_ICampaignManagementServiceStub stub = (BasicHttpBinding_ICampaignManagementServiceStub) campaignManagementService;
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
	public void initializeService(String input) throws InterruptedException
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
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
		final Map<String, String> data = protocolJson.getHashMapFromJson(json);
		final ReportObject[] ret = getKeywordReport(new Long(data.get("accountId")), new Long(data.get("campaignId")), new DateTime(data.get("firstDay")), new DateTime(data.get("lastDay")));
		return gson.toJson(ret);
	}

	public Double[] getAdGroupDefaultBidValue(Long accountId, Long campaignId, Long adGroupId) throws MsnCloudException
	{
		final String operationDescription = "Get AdGroup Default Bid Value for AccountID [" + accountId + "], CampaignID [" + campaignId + "], AdGroupID [" + adGroupId + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			final Double[] defaultBids = new Double[3];
			final ICampaignManagementService campaignManagement = getCampaignManagementService(accountId);
			final GetAdGroupsByCampaignIdRequest adGroupReq = new GetAdGroupsByCampaignIdRequest();
			adGroupReq.setCampaignId(campaignId);
			final GetAdGroupsByCampaignIdResponse adGroupResp = campaignManagement.getAdGroupsByCampaignId(adGroupReq);
			final AdGroup[] adGroups = adGroupResp.getAdGroups();
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
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public ReportObject[] getKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay) throws MsnCloudException
	{
		final String operationDescription = "Get AdGroup Default Bid Value for AccountID [" + accountId + "], CampaignID [" + campaignId + "], FirstDay [" + firstDay + "], LastDay [" + lastDay + "]";
		logger.info("Will try to " + operationDescription);
		try
		{
			String ret1 = requestKeywordReport(accountId, campaignId, firstDay, lastDay, ReportAggregation.Daily);
			AdGroup[] adGroups = getAdGroupsByCampaignId(accountId, campaignId);
			if (adGroups.length > 1)
			{
				throw new Exception("More than one adgroup in this campaign");
			}
			Long adGroupId = adGroups[0].getId();
			Double[] defaultBids = this.getAdGroupDefaultBidValue(accountId, campaignId, adGroupId);
			Keyword[] keywords = this.getKeywordByAdGroupId(accountId, adGroupId);
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
					data.setKeywordID(Long.valueOf(ret2.get("keywordid")[i]));
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
		catch (AdApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (ApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (EditorialApiFaultDetail e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription + ": " + e.dumpToString(), e);
		}
		catch (Exception e)
		{
			throw new MsnCloudException("Problem doing " + operationDescription, e);
		}
	}

	@Override
	public String checkStatus(String input1, String input2)
	{
		return ServiceStatus.Up.getServiceStatusValue();
	}
}
