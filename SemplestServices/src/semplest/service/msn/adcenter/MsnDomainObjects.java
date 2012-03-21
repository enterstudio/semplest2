/* !BEGIN_LICENSE: Copyright 2009 Icosystem Corporation. All Rights Reserved. */

/**
 * @version $Id$
 */

package semplest.service.msn.adcenter;

public class MsnDomainObjects {
	
	public static MsnDomainObjects aNew() {
		return new MsnDomainObjects();
	}
	
	public AdCenterAccountBuilder adCenterAccount() {
		return AdCenterAccountBuilder.create();
	}
	
	public AdCenterAddressBuilder adCenterAddress() {
		return AdCenterAddressBuilder.create();
	}
	
	public AdCenterContactInfoBuilder adCenterContactInfo() {
		return AdCenterContactInfoBuilder.create();
	}
	
	public AdCenterCustomerBuilder adCenterCustomer() {
		return AdCenterCustomerBuilder.create();
	}
	
	public AdCenterUserBuilder adCenterUser() {
		return AdCenterUserBuilder.create();
	}
	
	public AdGroupBuilder adGroup() {
		return AdGroupBuilder.create();
	}
	
	public CampaignBuilder campaign() {
		return CampaignBuilder.create();
	}
	
	public KeywordBuilder keyword() {
		return KeywordBuilder.create();
	}
	
	public TextAdBuilder textAd() {
		return TextAdBuilder.create();
	}
	
}