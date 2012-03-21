package semplest.services.msncloud.model;

import com.microsoft.adcenter.api.customermanagement.Entities.Address;

public class AdCenterAddressBuilder {
	
	private final String _addressLine1;
	private final String _addressLine2;
	private final String _addressLine3;
	private final String _addressLine4;
	private final String _city;
	private final String _country;
	private final String _stateOrProvince;
	private final String _zipOrPostalCode;
	private final Long _addressId;
	
	AdCenterAddressBuilder(String addressLine1, String addressLine2, String addressLine3, String addressLine4, String city, String country, String stateOrProvince, String zipOrPostalCode, Long addressId) {
		this._addressLine1 = addressLine1;
		this._addressLine2 = addressLine2;
		this._addressLine3 = addressLine3;
		this._addressLine4 = addressLine4;
		this._city = city;
		this._country = country;
		this._stateOrProvince = stateOrProvince;
		this._zipOrPostalCode = zipOrPostalCode;
		this._addressId = addressId;
	}
	
	public static AdCenterAddressBuilder create() {
		return new AdCenterAddressBuilder("462 Broadway", "Floor 6", null, null, "New York", "US", "NY", "10013", null);
	}
	
	public AdCenterAddressBuilder withAddressLine1(String addressLine1) {
		return new AdCenterAddressBuilder(addressLine1, this._addressLine2, this._addressLine3, this._addressLine4, this._city, this._country, this._stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder withAddressLine2(String addressLine2) {
		return new AdCenterAddressBuilder(this._addressLine1, addressLine2, this._addressLine3, this._addressLine4, this._city, this._country, this._stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder withAddressLine3(String addressLine3) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, addressLine3, this._addressLine4, this._city, this._country, this._stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder withAddressLine4(String addressLine4) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, this._addressLine3, addressLine4, this._city, this._country, this._stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder withCity(String city) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, this._addressLine3, this._addressLine4, city, this._country, this._stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder with(String country) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, this._addressLine3, this._addressLine4, this._city, country, this._stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder withStateOrProvince(String stateOrProvince) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, this._addressLine3, this._addressLine4, this._city, this._country, stateOrProvince, this._zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder withZipOrPostalCode(String zipOrPostalCode) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, this._addressLine3, this._addressLine4, this._city, this._country, this._stateOrProvince, zipOrPostalCode, this._addressId);
	}
	
	public AdCenterAddressBuilder with(Long addressId) {
		return new AdCenterAddressBuilder(this._addressLine1, this._addressLine2, this._addressLine3, this._addressLine4, this._city, this._country, this._stateOrProvince, this._zipOrPostalCode, addressId);
	}
	
	public Address build() {
		Address address = new Address();
		address.setLine1(_addressLine1);
		address.setLine2(_addressLine2);
		address.setLine3(_addressLine3);
		address.setLine4(_addressLine4);
		address.setCity(_city);
		address.setCountryCode(_country);
		address.setStateOrProvince(_stateOrProvince);
		address.setPostalCode(_zipOrPostalCode);
		address.setId(_addressId);
		return address;
	}
}

//	public AdCenterAddress(String addressLine1, String addressLine2, String addressLine3, String addressLine4, String city, CountryCode country, String stateOrProvince, String zipOrPostalCode, Integer addressId){
//		this.addressLine1 = addressLine1;
//		this.addressLine2 = addressLine2;
//		this.addressLine3 = addressLine3;
//		this.addressLine4 = addressLine4;
//		this.city = city;
//		this.country = country;
//		this.stateOrProvince = stateOrProvince;
//		this.zipOrPostalCode = zipOrPostalCode;
//		this.addressId = addressId;
//	}
