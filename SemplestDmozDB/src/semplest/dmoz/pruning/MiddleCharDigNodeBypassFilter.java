package semplest.dmoz.pruning;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import semplest.dmoz.tree.DmozTreeNode;

public class MiddleCharDigNodeBypassFilter implements DmozToSemplestFilter {

	BufferedWriter out = null; 

	public MiddleCharDigNodeBypassFilter(BufferedWriter out) {
		super();
		this.out = out;
	}
	
	private void writeData(String text){
		
		if(out!=null){
			try {
				out.write("[MiddleCharDigNodeBypass] "+text+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("[MiddleCharDigNodeBypass] "+text);
		}
		
	}
	@Override
	public Set<DmozTreeNode> analyzeNode(DmozTreeNode node) throws Exception {
		Map<String,DmozTreeNode> childNodes = node.getChildrenNodes();
		Set<DmozTreeNode> childSet = new HashSet<DmozTreeNode>(); 
		boolean detectedNode = false;
		for(String s : childNodes.keySet()){
			DmozTreeNode child = childNodes.get(s);
			String [] nameArr = child.getName().split("/");
			//if(nameArr[nameArr.length-1].matches("[a-z]") && child.getChildrenNodes().size()==0 && !child.getName().startsWith("top/regional")){
			if(nameArr[nameArr.length-1].matches("[0-9a-z]") && child.getChildrenNodes().size()>0){
				detectedNode = true;
			}
			childSet.add(child);
		}
		if(detectedNode) {
			String text = node.getName();
			writeData(text);
		}
		return childSet;
	}

	@Override
	public void pruneNode(DmozTreeNode node) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getFilterName() {
		return "Middle char digit node bypass filter";
	}



	@Override
	public BufferedWriter getFileHandler() {
		return out;
	}

}
