package semplest.dmoz.pruning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import semplest.dmoz.tree.DmozCategoryDataObject;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.UrlDataObject;

public class NorthAmericaUSMergingFilter implements DmozToSemplestFilter {

	BufferedWriter out = null; 

	public NorthAmericaUSMergingFilter(BufferedWriter out) {
		super();
		this.out = out;
	}
	
	private void writeData(String text){
		if(out!=null){
			try {
				out.write("[NorthAmericaUSFilter] "+text+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("[NorthAmericaUSFilter] "+text);
		}
	}
	
	@Override
	public Set<DmozTreeNode> analyzeNode(DmozTreeNode node) throws Exception {
		Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
		Set<DmozTreeNode> childSet = new HashSet<DmozTreeNode>(); 
		boolean pruneSubtree = false;
		for(String s : childNodes.keySet()){
			DmozTreeNode child = childNodes.get(s);
			String [] nameArr = child.getName().split("/");
			if(nameArr[nameArr.length-1].matches("north_america") || nameArr[nameArr.length-1].matches("united_states")){
				pruneSubtree = true;
			} else {
				childSet.add(child);
			}
		}
		if(pruneSubtree) {
			String text = node.getName();
			writeData(text);
		}
		return childSet;
	}

	@Override
	public void pruneNode(DmozTreeNode node) throws Exception {
		Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
		Map<String,DmozTreeNode> copiedNodes = new HashMap<String,DmozTreeNode>();
		copiedNodes.putAll(childNodes);

		
		for(String s : childNodes.keySet()){
			DmozTreeNode child = childNodes.get(s);
			String [] nameArr = child.getName().split("/");
			if(nameArr[nameArr.length-1].matches("north_america") || nameArr[nameArr.length-1].matches("united_states")) {
				writeData(node.getName()+ ":"+nameArr[nameArr.length-1]+": "+node.getCategoryData().getUrlData().size());
				//node.getCategoryData().getUrlData().putAll(child.getCategoryData().getUrlData());
				NorthAmericaUSMergingFilter.mergeRecursively(node.getCategoryData().getUrlData(),child);
				writeData(node.getName()+ ":"+nameArr[nameArr.length-1]+": "+node.getCategoryData().getUrlData().size());
				copiedNodes.remove(s);
			}
		}
		if(copiedNodes.size()!=childNodes.size()){
			writeData("Updated childNodes..."+node.getName()+", present child count = "+node.getChildrenNodes().size());
			node.setChildrenNodes(copiedNodes);
			writeData("Updated childNodes..."+node.getName()+", present child count = "+node.getChildrenNodes().size());

		}
	}

	private static void mergeRecursively(List<UrlDataObject> urlData, DmozTreeNode node) {
		Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
		urlData.addAll(node.getCategoryData().getUrlData());
		for(String s : childNodes.keySet()){
			NorthAmericaUSMergingFilter.mergeRecursively(urlData,childNodes.get(s));
		}
	}

	@Override
	public String getFilterName() {
		return "North America and US merging filter";
	}



	@Override
	public BufferedWriter getFileHandler() {
		return out;
	}

}
