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

}
