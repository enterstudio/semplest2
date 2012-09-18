package semplest.dmoz.tree.filter;

import java.util.HashMap;
import java.util.Map;

import semplest.dmoz.tree.DmozTreeNode;

public class LowUrlNodeMerger implements DmozTreeFliter {
	

	private int minUrlCount=0;

	public LowUrlNodeMerger(int minUrlCount) {
		super();
		this.minUrlCount = minUrlCount;
	}

	


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
		

		if(currentNode.getTreeURLCount()<minUrlCount){
			currentNode.setTreeNodeCount(0);
			return 0;
		}
		
		Map<String,DmozTreeNode> childrenNodes = currentNode.getChildrenNodes();

		
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
