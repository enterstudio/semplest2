package semplest.dmoz.tree.process;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeNode;

public class MergeMiddleNodesProcesser implements TreeProcesserInterface{
	
	private ArrayList<String> splittedMiddleNodes = new ArrayList<String>();

	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception{
		/*
		 * find all the middle nodes which name is only a letter or number, such as ../../a/.. or ../../3/..
		 */
		
		/*
		HashMap<String,DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(childrenNodes.size() < 1 ){
			return;
		}
		else{
			String nodeName = topNode.getName();

			if(nodeName.length() == 1 || nodeName.matches("[+-]?\\d*(\\.\\d+)?")){
				//this node is a single-letter node
				splittedMiddleNodes.add(topNode.getFullName());
			}
			
			for(DmozTreeNode childrenNode : childrenNodes.values()){
				analyzeTree(childrenNode);
			}
		}
		*/
		
		HashMap<String,DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(childrenNodes.size() == 0 ){
			//reach the leaf of this branch
			String fullNodeName = topNode.getName();
			for(String nodeName : fullNodeName.trim().split("/")){
				if(nodeName.length() == 1 || nodeName.matches("[+-]?\\d*(\\.\\d+)?")){
					//this branch is spitted at a middle node
					splittedMiddleNodes.add(fullNodeName);
					break;
				}
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
	
	@Override
	public void printReport(String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		for(String node : splittedMiddleNodes){
			writer.append(node + "\n");
		}
		writer.close();		
	}

	@Override
	public Integer getCount(DmozTreeNode topNode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
