package semplest.dmoz.tree.process;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeNode;

public class NodeCountProcessor implements TreeProcesserInterface {
	
	private ArrayList<String> nodeCounts;
	private boolean storeData = false;

	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception {
		nodeCounts = new ArrayList<String>();
		storeData = true;
		countNodes(topNode);
	}

	@Override
	public DmozTreeNode processTree(DmozTreeNode topNode) throws Exception {
		return null;
	}

	@Override
	public void printReport(String path) throws Exception {
		if(nodeCounts==null){
			throw new Exception("You need to first analyze the tree before calling printReport().");
		}
		FileWriter writer = new FileWriter(path);
		for(String node : nodeCounts){
			writer.append(node + "\n");
		}
		writer.close();	
	}
	
	private Integer countNodes(DmozTreeNode currentNode){

		HashMap<String,DmozTreeNode> childrenNodes = currentNode.getChildrenNodes();
		Integer numSubNodes = 0;
		for(DmozTreeNode childNode : childrenNodes.values()){
			Integer numSubTreeNodes = countNodes(childNode);
			numSubNodes = numSubNodes + numSubTreeNodes;
		}
		
		
		
		Integer numAllNodes = 1 + numSubNodes;	
		//System.out.println(currentNode.getFullName() + " : " + numAllUrls);
		if(storeData){
			nodeCounts.add(currentNode.getName() + " : " + numAllNodes);
		}

		currentNode.setTreeNodeCount(numAllNodes);
		return numAllNodes;
	}

	@Override
	public Integer getCount(DmozTreeNode topNode) throws Exception {
		return countNodes(topNode);
	}
}
