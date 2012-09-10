package semplest.dmoz.tree.filter;

import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeNode;

public class RegionalNodeMerger implements DmozTreeFliter {
	

	@Override
	public void applyFilter(DmozTreeNode dmozTree) {
		DmozTreeNode root = dmozTree;
		while(root.getParentNode()!=null){
			root=root.getParentNode();
		}	
		countNodes(root);
	}
	
	private Integer countNodes(DmozTreeNode currentNode){
		
		
		if(currentNode.getTreeNodeCount()==0){
			return 0;
		}
		
		HashMap<String,DmozTreeNode> childrenNodes = currentNode.getChildrenNodes();
		
		String [] fullName = currentNode.getName().split("/");
		String leafNodeName = fullName[fullName.length-1];

		if(leafNodeName.equals("north_america") || leafNodeName.equals("united_states")){
			currentNode.setTreeNodeCount(0);
			return 0;
		}
		Integer numSubNodes = 0;
		for(DmozTreeNode childNode : childrenNodes.values()){
			Integer numSubTreeNodes = countNodes(childNode);
			numSubNodes = numSubNodes + numSubTreeNodes;
		}
		
		Integer numAllNodes = 1 + numSubNodes;	
		currentNode.setTreeNodeCount(numAllNodes);
		return numAllNodes;
	}
	


}
