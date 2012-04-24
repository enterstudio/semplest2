package semplest.service.msn.adcenter;

import com.microsoft.adcenter.api.customermanagement.Entities.Address;
import com.microsoft.adcenter.api.customermanagement.Entities.Industry;
import com.microsoft.adcenter.api.customermanagement.Entities.LanguageType;

public class AdCenterCustomerBuilder {
	private final String _customerName;
	private final Industry _industryId;
	private final String _marketId;
	private final Address _customerAddress;
	private final Long _customerId;
	private LanguageType marketLanguage;
	
	public AdCenterCustomerBuilder(String _customerName, Industry _industryId, String _marketId, Address _customerAddress, Long _customerId, LanguageType marketLanguage) {
		this._customerName = _customerName;
		this._industryId = _industryId;
		this._marketId = _marketId;
		this._customerAddress = _customerAddress;
		this._customerId = _customerId;
		this.marketLanguage = marketLanguage;
	}
	
	public static AdCenterCustomerBuilder create() {
		return new AdCenterCustomerBuilder("customer name", Industry.Other, "US", MsnDomainObjects.aNew().adCenterAddress().build(), null, LanguageType.English);
	}
	
	public AdCenterCustomerBuilder withCustomerName(String customerName) {
		return new AdCenterCustomerBuilder(customerName, this._industryId, this._marketId, this._customerAddress, this._customerId, marketLanguage);
	}
	
	public AdCenterCustomerBuilder with(Industry industryId) {
		return new AdCenterCustomerBuilder(this._customerName, industryId, this._marketId, this._customerAddress, this._customerId, marketLanguage);
	}
	
	public AdCenterCustomerBuilder withMarketId(String marketId) {
		return new AdCenterCustomerBuilder(this._customerName, this._industryId, marketId, this._customerAddress, this._customerId, marketLanguage);
	}
	
	public AdCenterCustomerBuilder with(Address customerAddress) {
		return new AdCenterCustomerBuilder(this._customerName, this._industryId, this._marketId, customerAddress, this._customerId, marketLanguage);
	}
	
	public AdCenterCustomerBuilder with(Long customerId) {
		return new AdCenterCustomerBuilder(this._customerName, this._industryId, this._marketId, this._customerAddress, customerId, marketLanguage);
	}
	
	public com.microsoft.adcenter.api.customermanagement.Entities.Customer build() {
		com.microsoft.adcenter.api.customermanagement.Entities.Customer customer = new com.microsoft.adcenter.api.customermanagement.Entities.Customer();
		customer.setName(_customerName);
		customer.setIndustry(_industryId);
		customer.setMarketCountry(_marketId);
		customer.setCustomerAddress(_customerAddress);
		customer.setId(_customerId);
		customer.setMarketLanguage(marketLanguage);
		return customer;
	}
}