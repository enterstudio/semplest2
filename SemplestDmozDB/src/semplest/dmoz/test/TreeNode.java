package semplest.dmoz.test;

import java.util.HashMap;

public class TreeNode {
	private Long nodeID;
	private Long parentID;
	private String nodeName;
	private CategoryData categoryData;
	private HashMap<String,TreeNode> childrenNodes;
	private String data;
	
	public Long getNodeID() {
		return nodeID;
	}
	public void setNodeID(Long nodeID) {
		this.nodeID = nodeID;
	}
	public HashMap<String, TreeNode> getChildrenNodes() {
		return childrenNodes;
	}
	public void setChildrenNodes(HashMap<String, TreeNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Long getParentID() {
		return parentID;
	}
	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public CategoryData getCategoryData() {
		return categoryData;
	}
	public void setCategoryData(CategoryData categoryData) {
		this.categoryData = categoryData;
	}	
}
