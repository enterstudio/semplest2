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
		
		if(node.getName().equals("top/regional")){
			return childSet;
		}
		boolean detectedNode = false;
		boolean detectionVetoed = false;
		Set<String> childrenToCharDigNode = new HashSet<String>();
		for(String s : childNodes.keySet()){
			DmozTreeNode child = childNodes.get(s);
			String [] nameArr = child.getName().split("/");
			if(nameArr[nameArr.length-1].matches("[0-9a-z]")){
				detectedNode = true;
				for(String ch : child.getChildrenNodes().keySet()){
					String [] grandChildNameArr = ch.split("/");
					if(child.getChildrenNodes().get(ch).getChildrenNodes().size()>0){
						detectionVetoed = true;
						//writeData(ch+": "+grandChildNameArr[grandChildNameArr.length-1]+" :: "+child.getChildrenNodes().get(ch).getChildrenNodes().size());
					}
					childrenToCharDigNode.add(grandChildNameArr[grandChildNameArr.length-1]);
				}
			}
			childSet.add(child);
		}
		if(detectedNode && !detectionVetoed) {
			//System.out.println(childrenToCharDigNode.size());
			String text = node.getName() + " " + detectedNode + " "+detectionVetoed;
			writeData(text);
		}
		return childSet;
	}

	@Override
	public void pruneNode(DmozTreeNode node) throws Exception {
		if(node.getName().equals("top/regional")){
			return;
		}

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
