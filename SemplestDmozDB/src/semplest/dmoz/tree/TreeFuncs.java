package semplest.dmoz.tree;

import java.io.FileWriter;
import java.util.HashMap;

public class TreeFuncs {
	
	public static void printTree(String path, DmozTreeNode topNode) throws Exception{
		FileWriter writer = new FileWriter(path);
		printTree(topNode,writer);
		writer.close();
	}
	
	private static void printTree(DmozTreeNode currentNode, FileWriter writer) throws Exception{		
		writer.append( currentNode.getNodeID() + " : " + currentNode.getParentID() + " : " + currentNode.getName() + "\n");			
		for(DmozTreeNode node : currentNode.getChildrenNodes().values()){			
			printTree(node, writer);
		}		
	}
	
	public static HashMap<String,DmozTreeNode> getTreeInMap(DmozTreeNode tree) throws Exception{
		HashMap<String,DmozTreeNode> treeMap = new HashMap<String,DmozTreeNode>();
		
		treeToMap(tree, treeMap);
		
		return treeMap;
	}
	
	private static void treeToMap(DmozTreeNode currentNode, HashMap<String,DmozTreeNode> treeMap) throws Exception{
		treeMap.put(currentNode.getName(), currentNode);
		for(DmozTreeNode node : currentNode.getChildrenNodes().values()){			
			treeToMap(node, treeMap);
		}
	}

}
