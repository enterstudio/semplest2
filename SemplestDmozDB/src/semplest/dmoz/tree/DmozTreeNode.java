package semplest.dmoz.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DmozTreeNode {
	private Long nodeID;
	private Long parentID;
	private String nodeName;
	private DmozCategoryDataObject categoryData = new DmozCategoryDataObject();
	private Map<String,DmozTreeNode> childrenNodes = new HashMap<String,DmozTreeNode>();	
	private DmozTreeNode parentNode;
	
	private SemplestTreeMapDataObject semplestTreeMapData = new SemplestTreeMapDataObject();

	private int treeURLCount;
	private int treeNodeCount;
	
	public DmozTreeNode(){
		this.categoryData = new DmozCategoryDataObject();
		this.childrenNodes = new HashMap<String,DmozTreeNode>();
	}
	
	public void addChildNode(DmozTreeNode newNode){
		this.childrenNodes.put(newNode.getName(), newNode);
	}

	public void addUrlData(List<UrlDataObject> urlData){
		categoryData.addUrlData(urlData);
	}
	
	public void addUrlData(String url, String urlDesc){
		categoryData.addUrlData(url,urlDesc);
	}
	
	public void addUrlData(Long urlID, String url, String urlDesc){
		categoryData.addUrlData(urlID,url,urlDesc);
	}
	
	public void setNodeDescription(String description){
		categoryData.setDescription(description);
	}
	
	public void fromDbTreeNodeObject(DbTreeNodeObject object){
		this.nodeID = object.getSemplestPK();
		this.parentID = object.getParentNodeID();
		this.nodeName = object.getNodeText();
		if(object.getURL() != null){
			this.categoryData.addUrlData(object.getUrlDataPK(), object.getURL(), object.getURLDescription());
		}		
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


	public DmozCategoryDataObject getCategoryData() {
		return categoryData;
	}


	public void setCategoryData(DmozCategoryDataObject categoryData) {
		this.categoryData = categoryData;
	}


	public Map<String, DmozTreeNode> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(Map<String, DmozTreeNode> childrenNodes) {
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

	public SemplestTreeMapDataObject getSemplestTreeMapData() {
		return semplestTreeMapData;
	}

	public void setSemplestTreeMapData(SemplestTreeMapDataObject semplestTreeMapData) {
		this.semplestTreeMapData = semplestTreeMapData;
	}

	@Override
	public String toString() {
		return "DmozTreeNode [nodeID=" + nodeID + ", parentID=" + parentID
				+ ", nodeName=" + nodeName;
	}
	
}
