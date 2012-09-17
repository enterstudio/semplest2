package semplest.dmoz.tree;

public class DbUrlDataObject {
	private Long UrlDataPK;
	private Long SemplestFK;
	private String URL;
	private String URLDescription;
	private Integer Level;
	private Long ParentURLDataID;
	
	public Long getUrlDataPK() {
		return UrlDataPK;
	}
	public void setUrlDataPK(Long urlDataPK) {
		UrlDataPK = urlDataPK;
	}
	public Long getSemplestFK() {
		return SemplestFK;
	}
	public void setSemplestFK(Long semplestFK) {
		SemplestFK = semplestFK;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getURLDescription() {
		return URLDescription;
	}
	public void setURLDescription(String uRLDescription) {
		URLDescription = uRLDescription;
	}
	public Integer getLevel() {
		return Level;
	}
	public void setLevel(Integer level) {
		Level = level;
	}
	public Long getParentURLDataID() {
		return ParentURLDataID;
	}
	public void setParentURLDataID(Long parentURLDataID) {
		ParentURLDataID = parentURLDataID;
	}	
	
}
