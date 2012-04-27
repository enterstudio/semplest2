package semplest.other;

public interface AdCenterCredentials {
	public String getUrlBase();
	
	public String getCampaignManagementUrl();
	
	public String getCustomerManagementUrl();
	
	public String getReportingUrl();
	
	public String getDeveloperToken();
	
	public String getUserName();
	
	public String getPassword();
	
	public boolean isProduction();
	
	public String getAdIntelligenceUrl();
	
	public Long getParentCustomerID();
	
	public String getCustomerManagementNamespace();
	
	public String getCampaignManagementNamespace();
	
	public String getAdIntelligenceNamespace();
	
	public String getReportingNamespace();
	
}
