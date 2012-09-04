package semplest.dmoz.process;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;

import semplest.dmoz.tree.DmozTreeNode;

public class EmptyNodesProcesser implements TreeProcesserInterface {

	HashSet<String> nodes = new HashSet<String>();
	
	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception {
		HashMap<String,DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(topNode.getCategoryData() == null || topNode.getCategoryData().isEmpty()){
			nodes.add(topNode.getFullName());
		}
		if(childrenNodes.size() == 0 ){
			return;
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
		for(String node : nodes){
			writer.append(node + "\n");
		}
		writer.close();	
	}

}
