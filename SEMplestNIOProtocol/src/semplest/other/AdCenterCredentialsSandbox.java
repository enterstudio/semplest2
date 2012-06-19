package semplest.other;

import org.apache.log4j.Logger;


public class AdCenterCredentialsSandbox implements AdCenterCredentials 
{
	private static final String URI_SAND = "https://sandboxapi.adcenter.microsoft.com";
	private static final String CAMPAIGN_MANAGEMENT_URL = "https://sandboxapi.adcenter.microsoft.com/Api/Advertiser/v8/CampaignManagement/CampaignManagementService.svc?wsdl";
	public static final String CUSTOMER_MANAGEMENT_URL = "https://sharedservices-sbx.adcenterapi.microsoft.com/Api/CustomerManagement/v8/CustomerManagementService.svc?wsdl";
	private static final String REPORTING_URL = "https://sandboxapi.adcenter.microsoft.com/Api/Advertiser/v8/Reporting/ReportingService.svc?wsdl";
	//	private static final String AD_INTELLIGENCE_URL = "https://sandboxapi.adcenter.microsoft.com/Api/Advertiser/v8/CampaignManagement/AdIntelligenceService.svc?wsdl";
	private final String apiUserName = "API_SEMplest_SB";
	private final String apiUserPassword = "bing123";
	private final String userAccessKey = "1B907FIJP42U";
	
	private static final Logger log = Logger.getLogger(AdCenterCredentialsSandbox.class);
	
	public AdCenterCredentialsSandbox()
	{
		log.info("Using: " + toString());
	}
	
	@Override
	public String getUrlBase() {
		return URI_SAND;
	}
	
	@Override
	public String getCampaignManagementUrl() {
		return CAMPAIGN_MANAGEMENT_URL;
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
		return false;
	}
	
	@Override
	public String getCustomerManagementUrl() {
		return CUSTOMER_MANAGEMENT_URL;
	}
	
	@Override
	public String getAdIntelligenceUrl() {
		throw new Defect("No V8 Sandbox as of 9/26/2011");
	}
	
	@Override
	public Long getParentCustomerID() {
		throw new Defect("Unused in Sandbox");
	}
	
	@Override
	public String getCustomerManagementNamespace() {
		throw new Defect("Unused in Sandbox");
	}
	
	@Override
	public String getCampaignManagementNamespace() {
		throw new Defect("Unused in Sandbox");
	}
	
	@Override
	public String getAdIntelligenceNamespace() {
		throw new Defect("Unused in Sandbox");
	}
	
	@Override
	public String getReportingNamespace() {
		throw new Defect("Unused in Sandbox");
	}

	@Override
	public String toString()
	{
		return "AdCenterCredentialsSandbox [apiUserName=" + apiUserName + ", apiUserPassword=" + apiUserPassword + ", userAccessKey=" + userAccessKey + "]";
	}
	
}
