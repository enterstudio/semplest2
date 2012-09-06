package semplest.dmoz.tree.process;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeNode;

public class AllNodesUrlNumProcesser implements TreeProcesserInterface{
	
	private ArrayList<String> urlCounts = new ArrayList<String>();

	@Override
	public void analyzeTree(DmozTreeNode topNode) throws Exception {
		countNodeUrl(topNode);
	}

	@Override
	public DmozTreeNode processTree(DmozTreeNode topNode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printReport(String path) throws Exception {
		FileWriter writer = new FileWriter(path);
		for(String node : urlCounts){
			writer.append(node + "\n");
		}
		writer.close();	
	}
	
	private Integer countNodeUrl(DmozTreeNode currentNode){
		HashMap<String,DmozTreeNode> childrenNodes = currentNode.getChildrenNodes();
		Integer numSubNodeUrls = 0;
		for(DmozTreeNode childNode : childrenNodes.values()){
			Integer numChildUrls = countNodeUrl(childNode);
			numSubNodeUrls = numSubNodeUrls + numChildUrls;
		}
		
		Integer numCurrentNodeUrls = currentNode.getCategoryData() == null? 0 : 
			(currentNode.getCategoryData().getUrlData() == null ? 0 : currentNode.getCategoryData().getUrlData().size());
		
		Integer numAllUrls = numCurrentNodeUrls + numSubNodeUrls;		
		urlCounts.add(currentNode.getFullName() + " : " + numAllUrls);
		
		return numAllUrls;
	}

}
