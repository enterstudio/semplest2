package semplest.dmoz.tree;

public class UrlDataObject {
	private Long UrlDataPK;
	private String Url;
	private String UrlDescription;
	
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
	
}
