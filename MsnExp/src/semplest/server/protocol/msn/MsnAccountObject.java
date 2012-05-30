package semplest.server.protocol.msn;

import java.util.Calendar;

import org.apache.axis2.databinding.types.UnsignedByte;

import com.microsoft.adcenter.api.customermanagement.entities.*;

public class MsnAccountObject {
	
	private AccountFinancialStatus AccountFinancialStatus;
	private AccountLifeCycleStatus AccountLifeCycleStatus;
	private AccountType AccountType;
	private String BillToCustomerId;  //make it from Long to String, just in case it's the same value as ParentCustomerId
	private String CountryCode;
	private CurrencyType CurrencyType;
	private Long Id;
	private LanguageType Language;
	//private Long LastModifiedByUserId;
	private Calendar LastModifiedTime;
	private String Name;
	private String Number;
	private Long ParentCustomerId;
	private UnsignedByte PauseReason;
	private Long PaymentMethodId;
	private PaymentMethodType PaymentMethodType;
	private Long PrimaryUserId;
	// private byte[] TimeStamp;  //This array may cause json crash. Need to convert it to a plain number, such as Long.
	private TimeZoneType TimeZone;
	
	public MsnAccountObject(){
		
	}
	
	public MsnAccountObject(Account account){
		this.fromAccount(account);		
	}
	
	public void fromAccount(Account account){
		if(account == null) return;
		
		AccountFinancialStatus = account.getAccountFinancialStatus();
		AccountLifeCycleStatus = account.getAccountLifeCycleStatus();
		AccountType = account.getAccountType();
		BillToCustomerId = String.valueOf(account.getBillToCustomerId());
		CountryCode = account.getCountryCode();
		CurrencyType = account.getCurrencyType();
		Id = account.getId();
		Language = account.getLanguage();
		//LastModifiedByUserId = account.getLastModifiedByUserId();
		LastModifiedTime = account.getLastModifiedTime();
		Name = account.getName();
		Number = account.getNumber();
		ParentCustomerId = account.getParentCustomerId();
		PauseReason = account.getPauseReason();
		PaymentMethodId = account.getPaymentMethodId();
		PaymentMethodType = account.getPaymentMethodType();
		PrimaryUserId = account.getPrimaryUserId();
		TimeZone = account.getTimeZone();
	}
	
	public Account toAccount(){
		Account ret = new Account();
		
		ret.setAccountFinancialStatus(AccountFinancialStatus);
		ret.setAccountLifeCycleStatus(AccountLifeCycleStatus);
		ret.setAccountType(AccountType);
		ret.setBillToCustomerId(Long.valueOf(BillToCustomerId));
		ret.setCountryCode(CountryCode);
		ret.setCurrencyType(CurrencyType);
		ret.setId(Id);
		ret.setLanguage(Language);
		//ret.setLastModifiedByUserId(LastModifiedByUserId);
		ret.setLastModifiedTime(LastModifiedTime);
		ret.setName(Name);
		ret.setNumber(Number);
		ret.setParentCustomerId(ParentCustomerId);
		ret.setPauseReason(PauseReason);
		ret.setPaymentMethodId(PaymentMethodId);
		ret.setPaymentMethodType(PaymentMethodType);
		ret.setPrimaryUserId(PrimaryUserId);
		ret.setTimeZone(TimeZone);
		
		return ret;
	}
	
	public AccountFinancialStatus getAccountFinancialStatus() {
		return AccountFinancialStatus;
	}
	public void setAccountFinancialStatus(
			AccountFinancialStatus accountFinancialStatus) {
		AccountFinancialStatus = accountFinancialStatus;
	}
	public AccountLifeCycleStatus getAccountLifeCycleStatus() {
		return AccountLifeCycleStatus;
	}
	public void setAccountLifeCycleStatus(
			AccountLifeCycleStatus accountLifeCycleStatus) {
		AccountLifeCycleStatus = accountLifeCycleStatus;
	}
	public AccountType getAccountType() {
		return AccountType;
	}
	public void setAccountType(AccountType accountType) {
		AccountType = accountType;
	}
	public String getBillToCustomerId() {
		return BillToCustomerId;
	}
	public void setBillToCustomerId(String billToCustomerId) {
		BillToCustomerId = billToCustomerId;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public CurrencyType getCurrencyType() {
		return CurrencyType;
	}
	public void setCurrencyType(CurrencyType currencyType) {
		CurrencyType = currencyType;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public LanguageType getLanguage() {
		return Language;
	}
	public void setLanguage(LanguageType language) {
		Language = language;
	}
	/*
	public Long getLastModifiedByUserId() {
		return LastModifiedByUserId;
	}
	public void setLastModifiedByUserId(Long lastModifiedByUserId) {
		LastModifiedByUserId = lastModifiedByUserId;
	}
	*/
	public Calendar getLastModifiedTime() {
		return LastModifiedTime;
	}
	public void setLastModifiedTime(Calendar lastModifiedTime) {
		LastModifiedTime = lastModifiedTime;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public Long getParentCustomerId() {
		return ParentCustomerId;
	}
	public void setParentCustomerId(Long parentCustomerId) {
		ParentCustomerId = parentCustomerId;
	}
	public UnsignedByte getPauseReason() {
		return PauseReason;
	}
	public void setPauseReason(UnsignedByte pauseReason) {
		PauseReason = pauseReason;
	}
	public Long getPaymentMethodId() {
		return PaymentMethodId;
	}
	public void setPaymentMethodId(Long paymentMethodId) {
		PaymentMethodId = paymentMethodId;
	}
	public PaymentMethodType getPaymentMethodType() {
		return PaymentMethodType;
	}
	public void setPaymentMethodType(PaymentMethodType paymentMethodType) {
		PaymentMethodType = paymentMethodType;
	}
	public Long getPrimaryUserId() {
		return PrimaryUserId;
	}
	public void setPrimaryUserId(Long primaryUserId) {
		PrimaryUserId = primaryUserId;
	}
	public TimeZoneType getTimeZone() {
		return TimeZone;
	}
	public void setTimeZone(TimeZoneType timeZone) {
		TimeZone = timeZone;
	}
	
	

}
