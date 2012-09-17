package semplest.dmoz.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import semplest.dmoz.DBType;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;

public class SemplestTreeBuilder {
	
	public void buildMap() throws Exception
	{
		Map<Long,Long> semplestDmozNodesMap = new HashMap<Long,Long>();
		Map<Long,Long> semplestUrlDataMap = new HashMap<Long,Long>();
		
		//load the entire tree from the DB
		DmozTreeNode dmozTree = DbTreeOperator.loadTreeFromDB(DBType.DMOZ_TREE, "top");
		
		//apply processors on the tree, and convert it
		//TODO
		
		//now we have the new tree, it has the exactly same nodeID for each node, but different relationship between nodes/node data
		//generate tree map
		List<DmozTreeNode> treeNodesList = TreeFunctions.getTreeInList(dmozTree);
		
		for(DmozTreeNode treeNode : treeNodesList)
		{
			Long nodeId = treeNode.getNodeID();
			Long parentId = treeNode.getParentID();				
			Set<Long> urlIds = treeNode.getSemplestTreeMapData().getSemplestUrlDataIDs();
			
			semplestDmozNodesMap.put(nodeId, parentId);
			
			for(Long urlId : urlIds)
			{
				semplestUrlDataMap.put(nodeId, urlId);
			}
		}
		
		//put the tree maps in database
		//TODO
		
	}
	
	private void storeSemplestDmozMap(Map<Long,Long> semplestDmozNodesMap){
		
	}
	
	private void storeSemplestUrlDataMap(Map<Long,Long> semplestUrlDataMap){
		
	}
	
}
