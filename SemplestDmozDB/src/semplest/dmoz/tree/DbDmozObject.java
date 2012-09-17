package semplest.dmoz.tree;

public class DbDmozObject {
	private Long SemplestPK;
	private Long ParentNodeID;
	private String NodeText;
	private String NodeDescription;
	private Long DMOZCategoryID;
	
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
	public String getNodeDescription() {
		return NodeDescription;
	}
	public void setNodeDescription(String nodeDescription) {
		NodeDescription = nodeDescription;
	}
	public Long getDMOZCategoryID() {
		return DMOZCategoryID;
	}
	public void setDMOZCategoryID(Long dmozCategoryID) {
		DMOZCategoryID = dmozCategoryID;
	}
	
}
