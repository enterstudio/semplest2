package semplest.service.msn.adcenter;

import com.microsoft.adcenter.v8.AdDistribution;
import com.microsoft.adcenter.v8.AdDistribution_type0;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.AdGroupStatus;
import com.microsoft.adcenter.v8.ArrayOfPublisherCountry;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BiddingModel;
import com.microsoft.adcenter.v8.Date;
import com.microsoft.adcenter.v8.Network;
import com.microsoft.adcenter.v8.PricingModel;
import com.microsoft.adcenter.v8.PublisherCountry;

public class AdGroupBuilder {
	
	private final String[] _adDistribution;
	private final BiddingModel _biddingModel;
	private final Bid _broadMatchBid;
	private final Bid _contentMatchBid;
	private final Date _endDate;
	private final Bid _exactMatchBid;
	private final Long _id;
	private final String _languageAndRegion;
	private final String _name;
	private final String[] _negativeKeywords;
	private final String[] _negativeSiteUrls;
	private final Bid _phraseMatchBid;
	private final PricingModel _pricingModel;
	private final Date _startDate;
	private final AdGroupStatus _status;
	private final PublisherCountry[] publisherCountries;
	private final Network network;
	
	AdGroupBuilder(String[] adDistribution, BiddingModel biddingModel, Bid broadMatchBid, Bid contentMatchBid, Date endDate, Bid exactMatchBid, Long id, String languageAndRegion, String name, String[] negativeKeywords, String[] negativeSiteUrls, Bid phraseMatchBid, PricingModel pricingModel, Date startDate, AdGroupStatus status, PublisherCountry[] publisherCountries, Network network) {
		this._adDistribution = adDistribution;
		this._biddingModel = biddingModel;
		this._broadMatchBid = broadMatchBid;
		this._contentMatchBid = contentMatchBid;
		this._endDate = endDate;
		this._exactMatchBid = exactMatchBid;
		this._id = id;
		this._languageAndRegion = languageAndRegion;
		this._name = name;
		this._negativeKeywords = negativeKeywords;
		this._negativeSiteUrls = negativeSiteUrls;
		this._phraseMatchBid = phraseMatchBid;
		this._pricingModel = pricingModel;
		this._startDate = startDate;
		this._status = status;
		this.publisherCountries = publisherCountries;
		this.network = network;
	}
	
	/**
	 * http://msdn.microsoft.com/en-us/library/bb671956.aspx
	 * EndDate Element
	 * When updating an ad group, to set no end date for the ad group, set the EndDate element to a date equal to or later than January 2, 2050.
	 * When an ad group is added and if no end date is specified, the ad group does not have an end date.
	 * StartDate Element
	 * When adding an ad group, if the StartDate element is null, the current date on the server is used as the start date.
	 */
	
	public static AdGroupBuilder create() {
		PublisherCountry pc = new PublisherCountry();
		pc.setCountry("US"); pc.setIsOptedIn(true);
		return new AdGroupBuilder(new String[] { "Search" }, BiddingModel.Keyword, null, null, null, null, null, "English", "Ad Group Name", null, null, null, PricingModel.Cpc, null, null, new PublisherCountry[] { pc }, Network.OwnedAndOperatedAndSyndicatedSearch);
	}
	
	public AdGroupBuilder withAdDistribution(String[] adDistribution) {
		return new AdGroupBuilder(adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder with(BiddingModel biddingModel) {
		return new AdGroupBuilder(this._adDistribution, biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withBroadMatchBid(Bid broadMatchBid) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withContentMatchBid(Bid contentMatchBid) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withEndDate(Date endDate) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withExactMatchBid(Bid exactMatchBid) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder with(Long id) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withLanguageAndRegion(String languageAndRegion) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withName(String name) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withNegativeKeywords(String[] negativeKeywords) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withNegativeSiteUrls(String[] negativeSiteUrls) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withPhraseMatchBid(Bid phraseMatchBid) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, phraseMatchBid, this._pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder with(PricingModel pricingModel) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, pricingModel, this._startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder withStartDate(Date startDate) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, startDate, this._status, this.publisherCountries, network);
	}
	
	public AdGroupBuilder with(AdGroupStatus status) {
		return new AdGroupBuilder(this._adDistribution, this._biddingModel, this._broadMatchBid, this._contentMatchBid, this._endDate, this._exactMatchBid, this._id, this._languageAndRegion, this._name, this._negativeKeywords, this._negativeSiteUrls, this._phraseMatchBid, this._pricingModel, this._startDate, status, publisherCountries, network);
	}
	
	public AdGroup build() {
		AdGroup adGroup = new AdGroup();
		adGroup.setId(_id);
		AdDistribution ad = new AdDistribution();
		//adGroup.setAdDistribution(_adDistribution);
		adGroup.setAdDistribution(ad);
		adGroup.setBiddingModel(_biddingModel);
		adGroup.setBroadMatchBid(_broadMatchBid);
		adGroup.setContentMatchBid(_contentMatchBid);
		adGroup.setEndDate(_endDate);
		adGroup.setExactMatchBid(_exactMatchBid);
		adGroup.setLanguage(_languageAndRegion);
		adGroup.setName(_name);
		adGroup.setPhraseMatchBid(_phraseMatchBid);
		adGroup.setPricingModel(_pricingModel);
		adGroup.setStartDate(_startDate);
		adGroup.setStatus(_status);
		ArrayOfPublisherCountry apc = new ArrayOfPublisherCountry();
		apc.setPublisherCountry(publisherCountries);
		adGroup.setNetwork(network);
		return adGroup;
	}
}