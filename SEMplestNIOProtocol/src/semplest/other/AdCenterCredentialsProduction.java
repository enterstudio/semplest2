package semplest.other;

import org.apache.log4j.Logger;

public class AdCenterCredentialsProduction implements AdCenterCredentials 
{
	private static final String URI_PROD = "https://adcenterapi.microsoft.com";	
	private static final String CAMPAIGN_MANAGEMENT_URL = "https://adcenterapi.microsoft.com/Api/Advertiser/v8/CampaignManagement/CampaignManagementService.svc?wsdl";
	private static final String CAMPAIGN_MANAGEMENT_NAMESPACE = "https://adcenter.microsoft.com/v8";
	public static final String CUSTOMER_MANAGEMENT_URL = "https://sharedservices.adcenterapi.microsoft.com/Api/CustomerManagement/v8/CustomerManagementService.svc?wsdl";
	private static final String CUSTOMER_MANAGEMENT_NAMESPACE = "https://adcenter.microsoft.com/api/customermanagement";
	private static final String REPORTING_URL = "https://adcenterapi.microsoft.com/Api/Advertiser/v8/Reporting/ReportingService.svc?wsdl";
	private static final String REPORTING_NAMESPACE = "https://adcenter.microsoft.com/v8";
	private static final String AD_INTILLEGENCE_URL = "https://adcenterapi.microsoft.com/Api/Advertiser/v8/CampaignManagement/AdIntelligenceService.svc?wsdl";
	private static final String AD_INTILLEGENCE_NAMESPACE = "https://adcenter.microsoft.com/v8";
	private static final Long PARENT_CUSTOMER_ID = 694122L;
	private final String apiUserName; // = "API_SEMplest";
	private final String apiUserPassword; // = "1s3mpl3st";
	private final String userAccessKey; // = "6LTW1JCMEKIUX3";
	
	private static final Logger log = Logger.getLogger(AdCenterCredentialsProduction.class);
	
	public AdCenterCredentialsProduction(String MSNApiUsername, String MSNApiPassword, String MSNUserAccessKey)
	{
		apiUserName = MSNApiUsername;
		apiUserPassword = MSNApiPassword;
		userAccessKey = MSNUserAccessKey;
		log.info("Using: " + toString());
	}
	
	@Override
	public String getUrlBase() {
		return URI_PROD;
	}
	
	@Override
	public String getCampaignManagementUrl() {
		return CAMPAIGN_MANAGEMENT_URL;
	}
	
	@Override
	public String getCustomerManagementUrl() {
		return CUSTOMER_MANAGEMENT_URL;
	}
	
	@Override
	public String getReportingUrl() {
		return REPORTING_URL;
	}
	
	@Override
	public String getDeveloperToken() {
		return userAccessKey;
	}
	
	@Override
	public String getPassword() {
		return apiUserPassword;
	}
	
	@Override
	public String getUserName() {
		return apiUserName;
	}
	
	@Override
	public boolean isProduction() {
		return true;
	}
	
	@Override
	public String getAdIntelligenceUrl() {
		return AD_INTILLEGENCE_URL;
	}
	
	@Override
	public Long getParentCustomerID() {
		return PARENT_CUSTOMER_ID;
	}
	
	@Override
	public String getCustomerManagementNamespace() {
		return CUSTOMER_MANAGEMENT_NAMESPACE;
	}
	
	@Override
	public String getCampaignManagementNamespace() {
		return CAMPAIGN_MANAGEMENT_NAMESPACE;
	}
	
	@Override
	public String getAdIntelligenceNamespace() {
		return AD_INTILLEGENCE_NAMESPACE;
	}
	
	@Override
	public String getReportingNamespace() {
		return REPORTING_NAMESPACE;
	}

	@Override
	public String toString()
	{
		return "AdCenterCredentialsProduction [apiUserName=" + apiUserName + ", apiUserPassword=" + apiUserPassword + ", userAccessKey=" + userAccessKey + "]";
	}
	
}
