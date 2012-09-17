package semplest.dmoz.tree;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TreeFunctions {
	
	private static FileWriter logWriter;
	
	public static void printTree(String path, DmozTreeNode topNode) throws Exception{
		FileWriter writer = new FileWriter(path);
		printTree(topNode,writer);
		writer.close();
	}
	
	private static void printTree(DmozTreeNode currentNode, FileWriter writer) throws Exception{		
		writer.append( currentNode.getName() + " : " + currentNode.getNodeID() + " : " + currentNode.getParentID() + " : " + currentNode.getCategoryData().getDescription() + "\n");			
		for(String url : currentNode.getCategoryData().getUrlData().keySet()){
			writer.append( "	" + url + " || " + currentNode.getCategoryData().getUrlData().get(url) + "\n");	
		}
		for(DmozTreeNode node : currentNode.getChildrenNodes().values()){			
			printTree(node, writer);
		}		
	}
	
	public static List<DmozTreeNode> getTreeInList(DmozTreeNode tree) throws Exception{
		HashMap<String,DmozTreeNode> map = getTreeInMap(tree);
		return new ArrayList<DmozTreeNode>(map.values());
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
		
	public static void storeTreeToFile(List<DmozTreeNode> dmozTree, String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		writer.write("SemplestPK || ParentNodeID || DMOZCategoryID || NodeText || NodeDescription \n");
		
		for(DmozTreeNode node : dmozTree){
			writer.append(node.getNodeID() + " || " 
						+ node.getParentID() + " || "
						+ node.getCategoryData().getCategoryId() + " || "
						+ node.getName() + " || "						
						+ node.getCategoryData().getDescription()
						 + "\n");
		}		
		
	}
	
	public static void startLogError(String name, String path) throws Exception{
		String logPath = path + name + ".log";
		logWriter = new FileWriter(logPath);
		logWriter.write("Log of " + name + "\n");
		logWriter.append(new Date() + "\n\n");
	}
	
	public static void logError(String error) throws Exception{
		logWriter.append(error + "\n");
		logWriter.flush();
	}

	public static void endLogError() throws Exception{
		logWriter.close();
	}
}
