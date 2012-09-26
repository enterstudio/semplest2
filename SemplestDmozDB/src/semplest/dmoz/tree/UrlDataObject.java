package semplest.dmoz.tree;

import java.io.Serializable;

public class UrlDataObject implements Serializable{
	private Long UrlDataPK;
	private String Url;
	private String UrlDescription;
	private Long DomainFK;
	
	public Long getUrlDataPK() {
		return UrlDataPK;
	}
	public void setUrlDataPK(Long urlDataPK) {
		UrlDataPK = urlDataPK;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getUrlDescription() {
		return UrlDescription;
	}
	public void setUrlDescription(String urlDescription) {
		UrlDescription = urlDescription;
	}
	public Long getDomainFK() {
		return DomainFK;
	}
	public void setDomainFK(Long domainFK) {
		DomainFK = domainFK;
	}
	
}
