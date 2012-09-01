package semplest.dmoz.tree;

import java.util.HashMap;

public class TreeNode {
	private Long nodeID;
	private Long parentID;
	private String name;
	private String fullName;
	private CategoryData categoryData;
	private HashMap<String,TreeNode> childrenNodes;	
	
	public void addChildrenNode(TreeNode newNode){
		this.childrenNodes.put(newNode.getName(), newNode);
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


	public CategoryData getCategoryData() {
		return categoryData;
	}


	public void setCategoryData(CategoryData categoryData) {
		this.categoryData = categoryData;
	}


	public HashMap<String, TreeNode> getChildrenNodes() {
		return childrenNodes;
	}


	public void setChildrenNodes(HashMap<String, TreeNode> childrenNodes) {
		this.childrenNodes = childrenNodes;
	}
}
