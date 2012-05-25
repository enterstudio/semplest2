package semplest.service.msn.adcenter;

import com.microsoft.adcenter.api.customermanagement.Entities.Address;
import com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo;
import com.microsoft.adcenter.api.customermanagement.Entities.EmailFormat;

public class AdCenterContactInfoBuilder {
	private final String _phone1;
	private final String _phone2;
	private final String _fax;
	private final String _homePhone;
	private final String _mobile;
	private final String _email;
	private final EmailFormat _userContactEmailFormat;
	private final Boolean _userContactPost;
	private final Boolean _userContactPhone;
	private final Address _address;
	
	public AdCenterContactInfoBuilder(String _phone1, String _phone2, String _fax, String _homePhone, String _mobile, String _email, EmailFormat _userContactEmailFormat, Boolean _userContactPost, Boolean _userContactPhone, Address _address) {
		this._phone1 = _phone1;
		this._phone2 = _phone2;
		this._fax = _fax;
		this._homePhone = _homePhone;
		this._mobile = _mobile;
		this._email = _email;
		this._userContactEmailFormat = _userContactEmailFormat;
		this._userContactPost = _userContactPost;
		this._userContactPhone = _userContactPhone;
		this._address = _address;
	}
	
	public static AdCenterContactInfoBuilder create() {
		return new AdCenterContactInfoBuilder("123-456-7890", null, null, "123-456-7890", null, "test@icosystem.com", null, null, null, AdCenterAddressBuilder.create().build());
	}
	
	public AdCenterContactInfoBuilder withPhone1(String phone1) {
		return new AdCenterContactInfoBuilder(phone1, this._phone2, this._fax, this._homePhone, this._mobile, this._email, this._userContactEmailFormat, this._userContactPost, this._userContactPhone, this._address);
	}
	
	public AdCenterContactInfoBuilder withPhone2(String phone2) {
		return new AdCenterContactInfoBuilder(this._phone1, phone2, this._fax, this._homePhone, this._mobile, this._email, this._userContactEmailFormat, this._userContactPost, this._userContactPhone, this._address);
	}
	
	public AdCenterContactInfoBuilder withFax(String fax) {
		return new AdCenterContactInfoBuilder(this._phone1, this._phone2, fax, this._homePhone, this._mobile, this._email, this._userContactEmailFormat, this._userContactPost, this._userContactPhone, this._address);
	}
	
	public AdCenterContactInfoBuilder withHomePhone(String homePhone) {
		return new AdCenterContactInfoBuilder(this._phone1, this._phone2, this._fax, homePhone, this._mobile, this._email, this._userContactEmailFormat, this._userContactPost, this._userContactPhone, this._address);
	}
	
	public AdCenterContactInfoBuilder withMobile(String mobile) {
		return new AdCenterContactInfoBuilder(this._phone1, this._phone2, this._fax, this._homePhone, mobile, this._email, this._userContactEmailFormat, this._userContactPost, this._userContactPhone, this._address);
	}
	
	public ContactInfo build() {
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setEmail(_email);
		contactInfo.setEmailFormat(_userContactEmailFormat);
		contactInfo.setContactByPostalMail(_userContactPost);
		contactInfo.setContactByPhone(_userContactPhone);
		contactInfo.setPhone1(_phone1);
		contactInfo.setPhone2(_phone2);
		contactInfo.setFax(_fax);
		contactInfo.setHomePhone(_homePhone);
		contactInfo.setMobile(_mobile);
		contactInfo.setAddress(_address);
		return contactInfo;
	}
	
}