package semplest.dmoz.tree.process;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeNode;

public class MergeLeafNodesProcesser implements TreeProcesserInterface{
	
	private ArrayList<String> splittedLeafNodes = new ArrayList<String>();
	
	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception{
		/*
		 * find all the leaf nodes which name is only a letter, such as ../../a or ../../3
		 */
		HashMap<String,DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(childrenNodes.size() == 0 ){
			//this is a leaf
			String leafNodeName = topNode.getName();
			if(leafNodeName.length() == 1 || leafNodeName.matches("[+-]?\\d*(\\.\\d+)?")){
				//this leaf node is a single-letter node
				splittedLeafNodes.add(topNode.getFullName());
			}
		}
		else{
			for(DmozTreeNode childrenNode : childrenNodes.values()){
				analyzeTree(childrenNode);
			}
		}
	}

	@Override
	public DmozTreeNode processTree(DmozTreeNode topNode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void outputReport(String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		for(String node : splittedLeafNodes){
			writer.append(node + "\n");
		}
		writer.close();		
	}

}
