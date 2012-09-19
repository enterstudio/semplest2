package semplest.dmoz.pruning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import semplest.dmoz.tree.DmozTreeNode;

public class CharDigLeafFilter implements DmozToSemplestFilter {
	
	BufferedWriter out = null; 

	public CharDigLeafFilter(BufferedWriter out) {
		super();
		this.out = out;
	}
	
	private void writeData(String text){
		
		if(out!=null){
			try {
				out.write("[CharDigLeafFilter] "+text+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("[CharDigLeafFilter] "+text);
		}
		
	}
	
	
	@Override
	public Set<DmozTreeNode> analyzeNode(DmozTreeNode node) {
		Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
		Set<DmozTreeNode> childSet = new HashSet<DmozTreeNode>(); 
		boolean pruneSubtree = false;
		for(String s : childNodes.keySet()){
			DmozTreeNode child = childNodes.get(s);
			String [] nameArr = child.getName().split("/");
			//if(nameArr[nameArr.length-1].matches("[a-z]") && child.getChildrenNodes().size()==0 && !child.getName().startsWith("top/regional")){
			if(nameArr[nameArr.length-1].matches("[0-9a-z]") && child.getChildrenNodes().size()==0){
				pruneSubtree = true;
			}
			childSet.add(child);
		}
		if(pruneSubtree) {
			String text = node.getName();
			writeData(text);
		}
		return childSet;
	}

	@Override
	public void pruneNode(DmozTreeNode node) {
		Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
		Map<String,DmozTreeNode> copiedNodes = new HashMap<String,DmozTreeNode>();
		copiedNodes.putAll(childNodes);

		
		for(String s : childNodes.keySet()){
			DmozTreeNode child = childNodes.get(s);
			String [] nameArr = child.getName().split("/");
			if(nameArr[nameArr.length-1].matches("[0-9a-z]") && child.getChildrenNodes().size()==0){ // detect leaf node
				writeData(node.getName()+ ":"+nameArr[nameArr.length-1]+": "+node.getCategoryData().getUrlData().size());
				node.getCategoryData().getUrlData().putAll(child.getCategoryData().getUrlData());
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

	@Override
	public String getFilterName() {
		return "Character and digit leaf node filter";
	}



	@Override
	public BufferedWriter getFileHandler() {
		return out;
	}

}
