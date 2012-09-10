package semplest.dmoz.tree;

public class DbDmozObject {
	private Long DmozNodePK;
	private Long ParentNodeID;
	private String NodeText;
	private String NodeDescription;
	private Long CategoryID;
	
	public Long getDmozNodePK() {
		return DmozNodePK;
	}
	public void setDmozNodePK(Long dmozNodePK) {
		DmozNodePK = dmozNodePK;
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
	public Long getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(Long categoryID) {
		CategoryID = categoryID;
	}
	
}
