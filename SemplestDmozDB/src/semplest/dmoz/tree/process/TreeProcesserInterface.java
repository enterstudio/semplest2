package semplest.dmoz.tree.process;

import semplest.dmoz.tree.DmozTreeNode;

public interface TreeProcesserInterface {
	public void analyzeTree(DmozTreeNode topNode) throws Exception;
	public DmozTreeNode processTree(DmozTreeNode topNode) throws Exception;
	public void printReport(String path) throws Exception;
}
