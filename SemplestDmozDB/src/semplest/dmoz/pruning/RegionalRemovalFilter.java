package semplest.dmoz.pruning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import semplest.dmoz.tree.DmozTreeNode;

public class RegionalRemovalFilter implements DmozToSemplestFilter {
	
	BufferedWriter out = null; 

	public RegionalRemovalFilter(BufferedWriter out) {
		super();
		this.out = out;
	}
	
	private void writeData(String text){
		
		if(out!=null){
			try {
				out.write("[RegionalRemovalFilter] "+text+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("[RegionalRemovalFilter] "+text);
		}
		
	}
	
	@Override
	public Set<DmozTreeNode> analyzeNode(DmozTreeNode node) throws Exception {
		if(node.getName().equals("top")){
			Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
			if(childNodes.containsKey("top/regional")){
				writeData("Regional category exists!");
			} else {
				writeData("Regional category does not exist!");
			}
		}
		return (new HashSet<DmozTreeNode>());
	}

	@Override
	public void pruneNode(DmozTreeNode node) throws Exception {
		if(node.getName().equals("top")){
			Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
			if(childNodes.containsKey("top/regional")){
				writeData("Removing regional category!");
				childNodes.remove("top/regional");
				if(node.getChildrenNodes().containsKey("top/regional")){
					throw new Exception("Unable to remove regional category!");
				}
			}
		}
	}

	@Override
	public String getFilterName() {
		return "Regional category removal filter";
	}



	@Override
	public BufferedWriter getFileHandler() {
		return out;
	}

}
