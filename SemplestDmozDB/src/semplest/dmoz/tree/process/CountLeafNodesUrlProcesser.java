package semplest.dmoz.tree.process;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import semplest.dmoz.tree.DmozTreeNode;

public class CountLeafNodesUrlProcesser implements TreeProcesserInterface{
	private ArrayList<String> urlCounts = new ArrayList<String>();

	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception {
		Map<String, DmozTreeNode> childrenNodes = topNode.getChildrenNodes();
		if(childrenNodes.size() == 0 ){
			//this is a leaf
			int numUrls = topNode.getCategoryData() == null? 0 : 
				(topNode.getCategoryData().getUrlData() == null ? 0 : topNode.getCategoryData().getUrlData().size());
			urlCounts.add(topNode.getName() + " : " + numUrls);
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
		for(String node : urlCounts){
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
