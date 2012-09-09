package semplest.dmoz.tree;

import java.util.HashMap;

public class DmozTreeNode {
	private Long nodeID;
	private Long parentID;
	private String nodeName;
	private DmozCategoryData categoryData = new DmozCategoryData();
	private HashMap<String,DmozTreeNode> childrenNodes = new HashMap<String,DmozTreeNode>();	
	private DmozTreeNode parentNode;

	private int treeURLCount;
	private int treeNodeCount;
	
	public DmozTreeNode(){
		this.categoryData = new DmozCategoryData();
		this.childrenNodes = new HashMap<String,DmozTreeNode>();
	}
	
	public void addChildNode(DmozTreeNode newNode){
		this.childrenNodes.put(newNode.getName(), newNode);
	}

	public void addUrlData(HashMap<String,String> urlData){
		categoryData.addUrlData(urlData);
	}
	
	public void addUrlData(String url, String urlDesc){
		categoryData.addUrlData(url,urlDesc);
	}
	
	public void setNodeDescription(String description){
		categoryData.setDescription(description);
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
		return nodeName;
	}


	public void setName(String nodeName) {
		this.nodeName = nodeName;
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
	
	public int getTreeURLCount() {
		return treeURLCount;
	}

	public void setTreeURLCount(int treeURLCount) {
		this.treeURLCount = treeURLCount;
	}

	public int getTreeNodeCount() {
		return treeNodeCount;
	}

	public void setTreeNodeCount(int treeNodeCount) {
		this.treeNodeCount = treeNodeCount;
	}


	@Override
	public String toString() {
		return "DmozTreeNode [nodeID=" + nodeID + ", parentID=" + parentID
				+ ", nodeName=" + nodeName;
	}
	
}
