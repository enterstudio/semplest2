package semplest.service.msn.adcenter;

import com.microsoft.adcenter.api.customermanagement.entities.Account;
import com.microsoft.adcenter.api.customermanagement.entities.AccountLifeCycleStatus;
import com.microsoft.adcenter.api.customermanagement.entities.AccountType;
import com.microsoft.adcenter.api.customermanagement.entities.AdvertiserAccount;
import com.microsoft.adcenter.api.customermanagement.entities.CurrencyType;
import com.microsoft.adcenter.api.customermanagement.entities.LanguageType;
import com.microsoft.adcenter.api.customermanagement.entities.PaymentMethodType;
import com.microsoft.adcenter.api.customermanagement.entities.TimeZoneType;

public class AdCenterAccountBuilder {
	private final Long _accountId;
	private final String _accountName;
	private final String _accountNumber;
	private final AccountLifeCycleStatus _status;
	private final LanguageType _preferredLanguageType;
	private final Long _billToCustomerId;
	private final PaymentMethodType _paymentOptionsType;
	private final CurrencyType _preferredCurrencyType;
	private String countryCode;
	private TimeZoneType timeZone;
	private AccountType accountType;
	
	AdCenterAccountBuilder(Long accountId, String accountName, String accountNumber, AccountLifeCycleStatus status, LanguageType preferredLanguageType, Long billToCustomerId, PaymentMethodType paymentOptionsType, CurrencyType preferredCurrencyType, String countryCode, TimeZoneType timeZone, AccountType accountType) {
		this._accountId = accountId;
		this._accountName = accountName;
		this._accountNumber = accountNumber;
		this._status = status;
		this._preferredLanguageType = preferredLanguageType;
		this._billToCustomerId = billToCustomerId;
		this._paymentOptionsType = paymentOptionsType;
		this._preferredCurrencyType = preferredCurrencyType;
		this.countryCode = countryCode;
		this.timeZone = timeZone;
		this.accountType = accountType;
	}
	
	public static AdCenterAccountBuilder create() {
		return new AdCenterAccountBuilder(null, "unused", null, AccountLifeCycleStatus.Active, LanguageType.English, null, PaymentMethodType.Invoice, CurrencyType.USDollar, "US", TimeZoneType.EasternTimeUSCanada, AccountType.Advertiser);
	}
	
	public AdCenterAccountBuilder withAccountId(Long accountId) {
		return new AdCenterAccountBuilder(accountId, this._accountName, this._accountNumber, this._status, this._preferredLanguageType, this._billToCustomerId, this._paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder withAccountName(String accountName) {
		return new AdCenterAccountBuilder(this._accountId, accountName, this._accountNumber, this._status, this._preferredLanguageType, this._billToCustomerId, this._paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder withAccountNumber(String accountNumber) {
		return new AdCenterAccountBuilder(this._accountId, this._accountName, accountNumber, this._status, this._preferredLanguageType, this._billToCustomerId, this._paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder with(AccountLifeCycleStatus status) {
		return new AdCenterAccountBuilder(this._accountId, this._accountName, this._accountNumber, status, this._preferredLanguageType, this._billToCustomerId, this._paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder with(LanguageType preferredLanguageType) {
		return new AdCenterAccountBuilder(this._accountId, this._accountName, this._accountNumber, this._status, preferredLanguageType, this._billToCustomerId, this._paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder withBillToCustomerId(Long billToCustomerId) {
		return new AdCenterAccountBuilder(this._accountId, this._accountName, this._accountNumber, this._status, this._preferredLanguageType, billToCustomerId, this._paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder with(PaymentMethodType paymentOptionsType) {
		return new AdCenterAccountBuilder(this._accountId, this._accountName, this._accountNumber, this._status, this._preferredLanguageType, this._billToCustomerId, paymentOptionsType, this._preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public AdCenterAccountBuilder with(CurrencyType preferredCurrencyType) {
		return new AdCenterAccountBuilder(this._accountId, this._accountName, this._accountNumber, this._status, this._preferredLanguageType, this._billToCustomerId, this._paymentOptionsType, preferredCurrencyType, this.countryCode, this.timeZone, this.accountType);
	}
	
	public Account build() {
		AdvertiserAccount account = new AdvertiserAccount();
		account.setId(_accountId);
		account.setName(_accountName);
		account.setNumber(_accountNumber);
		account.setAccountLifeCycleStatus(_status);
		account.setLanguage(_preferredLanguageType);
		account.setBillToCustomerId(_billToCustomerId);
		account.setPaymentMethodType(_paymentOptionsType);
		account.setCurrencyType(_preferredCurrencyType);
		account.setCountryCode(countryCode);
		account.setTimeZone(timeZone);
		account.setAccountType(accountType);
		
		return account;
	}
}