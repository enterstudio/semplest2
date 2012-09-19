package semplest.dmoz.pruning;

import java.io.BufferedWriter;
import java.util.Set;

import semplest.dmoz.tree.DmozTreeNode;

public interface DmozToSemplestFilter {

	public Set<DmozTreeNode> analyzeNode(DmozTreeNode node) throws Exception;
	public void pruneNode(DmozTreeNode node) throws Exception;
	public String getFilterName();
	public BufferedWriter getFileHandler();
	
}
