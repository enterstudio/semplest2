package semplest.dmoz.tools;

import semplest.dmoz.tree.DmozTreeNode;

public class MapBuilder {
	
	public void buildMap() throws Exception{
		//load the tree from the DB
		DmozTreeNode dmozTree = DmozDbOperator.loadDmozTreeFromDB();
		
		//apply processer on the tree, and convert it
		
		
		//now we have the new tree, it has the exactly same nodeID for each node, but different relationship between nodes/node data
		
		
		
	}
	
}
