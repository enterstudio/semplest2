package semplest.dmoz.tree.process;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeNode;

public class MergeLeafNodesProcesser implements TreeProcesserInterface{
	
	private ArrayList<String> splitLeafNodes = new ArrayList<String>();
	
	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception{
		/*
		 * find all the leaf nodes which name is only a letter, such as ../../a or ../../3
		 */
		HashMap<String,DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(childrenNodes.size() == 0 ){
			//this is a leaf
			/*
			String leafNodeName = topNode.getName();
			if(leafNodeName.length() == 1 || leafNodeName.matches("[+-]?\\d*(\\.\\d+)?")){
				//this leaf node is a single-letter node
				splitLeafNodes.add(topNode.getFullName());
			}
			*/
		}
		else{
			for(DmozTreeNode childrenNode : childrenNodes.values()){
				if(childrenNode.getName().length() == 1 || childrenNode.getName().matches("[+-]?\\d*(\\.\\d+)?")){
					splitLeafNodes.add(topNode.getFullName());
					break;
				}
				else{
					analyzeTree(childrenNode);
				}
			}
		}
	}

	@Override
	public DmozTreeNode processTree(DmozTreeNode topNode) throws Exception {
		/*
		 * merge all the leaf nodes which name is only a letter, such as ../../a or ../../3, to its parent node
		 */
		HashMap<String,DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(childrenNodes.size() == 0 ){
			//this is a leaf
			String leafNodeName = topNode.getName();
			if(leafNodeName.length() == 1 || leafNodeName.matches("[+-]?\\d*(\\.\\d+)?")){
				//this leaf node is a single-letter node
				splitLeafNodes.add(topNode.getFullName());
			}
		}
		else{
			for(DmozTreeNode childrenNode : childrenNodes.values()){
				analyzeTree(childrenNode);
			}
		}
		return null;
	}
	
	@Override
	public void printReport(String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		for(String node : splitLeafNodes){
			writer.append(node + "\n");
		}
		writer.close();		
	}

}
