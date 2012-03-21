package semplest.services.msncloud.model;

import com.microsoft.adcenter.v8.AdEditorialStatus;
import com.microsoft.adcenter.v8.AdStatus;
import com.microsoft.adcenter.v8.AdType;
import com.microsoft.adcenter.v8.TextAd;

public class TextAdBuilder {
	
	private final AdEditorialStatus _editorialStatus;
	private final Long _id;
	private final AdStatus _status;
	private final AdType _type;
	private final String _destinationUrl;
	private final String _displayUrl;
	private final String _text;
	private final String _title;
	
	TextAdBuilder(AdEditorialStatus editorialStatus, Long id, AdStatus status, AdType type, String destinationUrl, String displayUrl, String text, String title) {
		this._editorialStatus = editorialStatus;
		this._id = id;
		this._status = status;
		this._type = type;
		this._destinationUrl = destinationUrl;
		this._displayUrl = displayUrl;
		this._text = text;
		this._title = title;
	}
	
	public static TextAdBuilder create() {
		return new TextAdBuilder(null, null, null, null, "http://www.alpineskihouse.com", "alpineskihouse.com", "Alpine Ski House has a great ski selection for you.", "Alpine Ski House");
	}
	
	public TextAdBuilder with(AdEditorialStatus editorialStatus) {
		return new TextAdBuilder(editorialStatus, this._id, this._status, this._type, this._destinationUrl, this._displayUrl, this._text, this._title);
	}
	
	public TextAdBuilder with(Long id) {
		return new TextAdBuilder(this._editorialStatus, id, this._status, this._type, this._destinationUrl, this._displayUrl, this._text, this._title);
	}
	
	public TextAdBuilder with(AdStatus status) {
		return new TextAdBuilder(this._editorialStatus, this._id, status, this._type, this._destinationUrl, this._displayUrl, this._text, this._title);
	}
	
	public TextAdBuilder with(AdType type) {
		return new TextAdBuilder(this._editorialStatus, this._id, this._status, type, this._destinationUrl, this._displayUrl, this._text, this._title);
	}
	
	public TextAdBuilder withDestinationUrl(String destinationUrl) {
		return new TextAdBuilder(this._editorialStatus, this._id, this._status, this._type, destinationUrl, this._displayUrl, this._text, this._title);
	}
	
	public TextAdBuilder withDisplayUrl(String displayUrl) {
		return new TextAdBuilder(this._editorialStatus, this._id, this._status, this._type, this._destinationUrl, displayUrl, this._text, this._title);
	}
	
	public TextAdBuilder withText(String text) {
		return new TextAdBuilder(this._editorialStatus, this._id, this._status, this._type, this._destinationUrl, this._displayUrl, text, this._title);
	}
	
	public TextAdBuilder withTitle(String title) {
		return new TextAdBuilder(this._editorialStatus, this._id, this._status, this._type, this._destinationUrl, this._displayUrl, this._text, title);
	}
	
	public TextAd build() {
		return new TextAd(this._editorialStatus, this._id, this._status, this._type, this._destinationUrl, this._displayUrl, this._text, this._title);
	}
	
}

//	public TextAd(AdEditorialStatus editorialStatus, Long id, AdStatus status, AdType type, String destinationUrl, String displayUrl, String text, String title){
//		this.editorialStatus = editorialStatus;
//		this.id = id;
//		this.status = status;
//		this.type = type;
//		this.destinationUrl = destinationUrl;
//		this.displayUrl = displayUrl;
//		this.text = text;
//		this.title = title;
//	}
