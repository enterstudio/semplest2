package semplest.dmoz.tree;

public class DbTreeNodeObject {
	private Long SemplestPK;
	private Long ParentNodeID;
	private String NodeText;
	private String URL;
	private String URLDescription;
	private Long UrlDataPK;
	
	public Long getSemplestPK() {
		return SemplestPK;
	}
	public void setSemplestPK(Long semplestPK) {
		SemplestPK = semplestPK;
	}
	public Long getParentNodeID() {
		return ParentNodeID;
	}
	public void setParentNodeID(Long parentNodeID) {
		ParentNodeID = parentNodeID;
	}
	public String getNodeText() {
		return NodeText;
	}
	public void setNodeText(String nodeText) {
		NodeText = nodeText;
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
	public Long getUrlDataPK() {
		return UrlDataPK;
	}
	public void setUrlDataPK(Long urlDataPK) {
		UrlDataPK = urlDataPK;
	}	
}
