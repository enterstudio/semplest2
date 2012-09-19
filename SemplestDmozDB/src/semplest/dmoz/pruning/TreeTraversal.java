package semplest.dmoz.pruning;

import java.util.Set;

import semplest.dmoz.tree.DmozTreeNode;

public class TreeTraversal {
	
	public static void analyze(DmozTreeNode node, DmozToSemplestFilter filter) throws Exception{
		// Since the tree is not really pruned we need the list of children from 
		// the following call. 
		Set<DmozTreeNode> children = filter.analyzeNode(node); 
		for(DmozTreeNode child : children){
			TreeTraversal.analyze(child, filter);
		}
	}

	public static void prune(DmozTreeNode node, DmozToSemplestFilter filter) throws Exception{
		filter.pruneNode(node);
		for(DmozTreeNode child : node.getChildrenNodes().values()){
			TreeTraversal.prune(child, filter);
		}
	}
	
	
}
