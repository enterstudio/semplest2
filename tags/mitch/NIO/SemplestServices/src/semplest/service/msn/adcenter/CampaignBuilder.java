package semplest.service.msn.adcenter;

import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;

public class CampaignBuilder {
	
	private final BudgetLimitType _budgetType;
	private final Boolean _conversionTrackingEnabled;
	private final String _conversionTrackingScript;
	private final Double _dailyBudget;
	private final Boolean _daylightSaving;
	private final String _description;
	private final Long _id;
	private final Double _monthlyBudget;
	private final String _name;
	private final String[] _negativeKeywords;
	private final String[] _negativeSiteUrls;
	private final CampaignStatus _status;
	private final String _timeZone;
	
	CampaignBuilder(BudgetLimitType budgetType, Boolean conversionTrackingEnabled, String conversionTrackingScript, Double dailyBudget, Boolean daylightSaving, String description, Long id, Double monthlyBudget, String name, String[] negativeKeywords, String[] negativeSiteUrls, CampaignStatus status, String timeZone) {
		this._budgetType = budgetType;
		this._conversionTrackingEnabled = conversionTrackingEnabled;
		this._conversionTrackingScript = conversionTrackingScript;
		this._dailyBudget = dailyBudget;
		this._daylightSaving = daylightSaving;
		this._description = description;
		this._id = id;
		this._monthlyBudget = monthlyBudget;
		this._name = name;
		this._negativeKeywords = negativeKeywords;
		this._negativeSiteUrls = negativeSiteUrls;
		this._status = status;
		this._timeZone = timeZone;
	}
	
	public static CampaignBuilder create() {
		return new CampaignBuilder(BudgetLimitType.MonthlyBudgetSpendUntilDepleted, false, null, null, true, "Clothing products for winter", null, 5000.00, "Winter clothing", null, null, null, "PacificTimeUSCanadaTijuana");
	}
	
	public CampaignBuilder with(BudgetLimitType budgetType) {
		return new CampaignBuilder(budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withConversionTrackingEnabled(Boolean conversionTrackingEnabled) {
		return new CampaignBuilder(this._budgetType, conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withConversionTrackingScript(String conversionTrackingScript) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withDailyBudget(Double dailyBudget) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withDaylightSaving(Boolean daylightSaving) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withDescription(String description) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder with(Long id) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withMonthlyBudget(Double monthlyBudget) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withName(String name) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, name, this._negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withNegativeKeywords(String[] negativeKeywords) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, negativeKeywords, this._negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder withNegativeSiteUrls(String[] negativeSiteUrls) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, negativeSiteUrls, this._status, this._timeZone);
	}
	
	public CampaignBuilder with(CampaignStatus status) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, status, this._timeZone);
	}
	
	public CampaignBuilder withTimeZone(String timeZone) {
		return new CampaignBuilder(this._budgetType, this._conversionTrackingEnabled, this._conversionTrackingScript, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._negativeKeywords, this._negativeSiteUrls, this._status, timeZone);
	}
	
	public Campaign build() {
		return new Campaign(this._budgetType, this._conversionTrackingEnabled, this._dailyBudget, this._daylightSaving, this._description, this._id, this._monthlyBudget, this._name, this._status, this._timeZone);
	}
}