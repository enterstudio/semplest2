package semplest.dmoz.tree;

import java.util.HashMap;

public class DmozTreeNode {
	private Long nodeID;
	private Long parentID;
	private String name;
	private String fullName;
	private DmozCategoryData categoryData;
	private HashMap<String,DmozTreeNode> childrenNodes;	
	private DmozTreeNode parentNode;
	
	public void addChildNode(DmozTreeNode newNode){
		this.childrenNodes.put(newNode.getName(), newNode);
	}

	public void addUrlData(HashMap<String,String> urlData){
		categoryData.addUrlData(urlData);
	}

	public Long getNodeID() {
		return nodeID;
	}


	public void setNodeID(Long nodeID) {
		this.nodeID = nodeID;
	}


	public Long getParentID() {
		return parentID;
	}


	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public DmozCategoryData getCategoryData() {
		return categoryData;
	}


	public void setCategoryData(DmozCategoryData categoryData) {
		this.categoryData = categoryData;
	}


	public HashMap<String, DmozTreeNode> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(HashMap<String, DmozTreeNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}

	public DmozTreeNode getParentNode() {
		return parentNode;
	}


	public void setParentNode(DmozTreeNode parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public String toString() {
		return "DmozTreeNode [nodeID=" + nodeID + ", parentID=" + parentID
				+ ", name=" + name + ", fullName=" + fullName;
	}
	
}
