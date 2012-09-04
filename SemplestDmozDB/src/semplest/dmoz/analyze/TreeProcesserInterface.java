package semplest.dmoz.analyze;

import semplest.dmoz.tree.DmozTreeNode;

public interface TreeProcesserInterface {
	public void analyzeTree(DmozTreeNode topNode) throws Exception;
	public DmozTreeNode processTree(DmozTreeNode topNode) throws Exception;
}
