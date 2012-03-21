package semplest.service.msn.adcenter;

import com.microsoft.adcenter.api.customermanagement.Entities.ApplicationType;
import com.microsoft.adcenter.api.customermanagement.Entities.ContactInfo;
import com.microsoft.adcenter.api.customermanagement.Entities.LCID;
import com.microsoft.adcenter.api.customermanagement.Entities.PersonName;
import com.microsoft.adcenter.api.customermanagement.Entities.SecretQuestion;
import com.microsoft.adcenter.api.customermanagement.Entities.User;

public class AdCenterUserBuilder {
	private final String _userName;
	private final String _password;
	private final String _firstName;
	private final String _lastName;
	private final String _middleInitial;
	private final String _jobTitle;
	private final LCID _languageLCID;
	private final String _secretAnswer;
	private final SecretQuestion _secretQuestion;
	private final ContactInfo _contactInfo;
	private final Long _userId;
	private final Long _customerId;
	private ApplicationType customerAppScope;
	
	AdCenterUserBuilder(String userName, String password, String firstName, String lastName, String middleInitial, String jobTitle, LCID languageLCID, String secretAnswer, SecretQuestion secretQuestion, ContactInfo contactInfo, Long userId, Long customerId, ApplicationType customerAppScope) {
		this._userName = userName;
		this._password = password;
		this._firstName = firstName;
		this._lastName = lastName;
		this._middleInitial = middleInitial;
		this._jobTitle = jobTitle;
		this._languageLCID = languageLCID;
		this._secretAnswer = secretAnswer;
		this._secretQuestion = secretQuestion;
		this._contactInfo = contactInfo;
		this._userId = userId;
		this._customerId = customerId;
		this.customerAppScope = customerAppScope;
	}
	
	public static AdCenterUserBuilder create() {
		return new AdCenterUserBuilder("User", "password", "first name", "last name", null, null, LCID.EnglishUS, "Star Wars", SecretQuestion.FavoriteMovie, MsnDomainObjects.aNew().adCenterContactInfo().build(), null, null, ApplicationType.Advertiser);
	}
	
	public AdCenterUserBuilder withUserName(String userName) {
		return new AdCenterUserBuilder(userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withPassword(String password) {
		return new AdCenterUserBuilder(this._userName, password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withFirstName(String firstName) {
		return new AdCenterUserBuilder(this._userName, this._password, firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withLastName(String lastName) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withMiddleInitial(String middleInitial) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withJobTitle(String jobTitle) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder with(LCID languageLCID) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withSecretAnswer(String secretAnswer) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, secretAnswer, this._secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder with(SecretQuestion secretQuestion) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, secretQuestion, this._contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder with(ContactInfo contactInfo) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, contactInfo, this._userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withUserId(Long userId) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, userId, this._customerId, customerAppScope);
	}
	
	public AdCenterUserBuilder withCustomerId(Long customerId) {
		return new AdCenterUserBuilder(this._userName, this._password, this._firstName, this._lastName, this._middleInitial, this._jobTitle, this._languageLCID, this._secretAnswer, this._secretQuestion, this._contactInfo, this._userId, customerId, customerAppScope);
	}
	
	public User build() {
		User user = new User();
		user.setUserName(_userName);
		user.setPassword(_password);
		user.setName(new PersonName(_firstName, _lastName, _middleInitial));
		user.setJobTitle(_jobTitle);
		user.setContactInfo(_contactInfo);
		user.setLcid(_languageLCID);
		user.setSecretAnswer(_secretAnswer);
		user.setSecretQuestion(_secretQuestion);
		user.setId(_userId);
		user.setCustomerId(_customerId);
		user.setCustomerAppScope(customerAppScope);
		return user;
	}
}