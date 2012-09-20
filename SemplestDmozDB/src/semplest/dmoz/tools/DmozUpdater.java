package semplest.dmoz.tools;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.UrlDataObject;

public class DmozUpdater {
	
	private Map<String,DmozTreeNode> nodesToBeDeleted;
	private Map<String,DmozTreeNode> nodesToBeAdded;
	private Map<String,DmozTreeNode> nodesToUpdateUrlData;
	
	private static Long uniqueId;
	
	public static void main(String[] args){
		try {
			DmozUpdater updateDmozDB = new DmozUpdater();
			updateDmozDB.updateNodesInDB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateNodesInDB() throws Exception{
		setUniqueIdBase();
		compareDbTreeAndNewTree();
		DbTreeOperator.deleteTreeNodes(getNodesToBeDeleted());
		DbTreeOperator.addTreeNodes(getNodesToBeAdded());
		DbTreeOperator.updateUrlData(getNodesToUpdateUrlData());
		saveChangeToLog();
	}
	
	public List<DmozTreeNode> getNodesToBeDeleted(){
		return new ArrayList<DmozTreeNode>(nodesToBeDeleted.values());
	}
	
	public List<DmozTreeNode> getNodesToBeAdded(){
		return new ArrayList<DmozTreeNode>(nodesToBeAdded.values());
	}
	
	public List<DmozTreeNode> getNodesToUpdateUrlData(){
		return new ArrayList<DmozTreeNode>(nodesToUpdateUrlData.values());
	}
	
	public void compareDbTreeAndNewTree() throws Exception{
		//Get the entire tree from DB
		DmozTreeNode dmozTree = DbTreeOperator.loadTreeFromDB("top");		
		Map<String,DmozTreeNode> dbTreeMap = TreeFunctions.getTreeInMap(dmozTree);
		
		//Get the new tree
		DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
		treeBuilder.buildDmozTree();
		DmozTreeNode newTree = treeBuilder.getTree();
		refreshTreeNodeIDs(dbTreeMap, newTree);
		Map<String,DmozTreeNode> newTreeMap = TreeFunctions.getTreeInMap(newTree);
		
		nodesToBeDeleted = processNodesToBeDeleted(dbTreeMap,newTreeMap);		
		nodesToBeAdded = processNodesToBeAdded(dbTreeMap,newTreeMap);				
		nodesToUpdateUrlData = detectUrlDataChange(dbTreeMap, newTreeMap);
	}
	
	public void saveChangeToLog() throws Exception{
		//Read property file for dmoz files paths
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("bin/system.properties");
		properties.load(in);
		in.close();
		
		String path = properties.getProperty("dmoz.updater.changeLog");
		
		//Save the nodes info
		FileWriter writer = new FileWriter(path);
		
		writer.write("Time of update - " + new Date() + "\n");
		writer.append("Format - " + "Category Name : Node PK : Parent Node ID");
		
		writer.append("------- Nodes that got deleted from DB -------\n");
		for(DmozTreeNode node : nodesToBeDeleted.values()){
			writer.append(node.getName() + " : " + node.getNodeID() + " : " + node.getParentID() + "\n");
		}
		
		writer.append("------- Nodes that are added to DB -------\n");
		for(DmozTreeNode node : nodesToBeAdded.values()){
			writer.append(node.getName() + " : " + node.getNodeID() + " : " + node.getParentID() + "\n");
		}
		
		writer.append("------- Nodes that got URL data updated to DB -------\n");
		for(DmozTreeNode node : nodesToUpdateUrlData.values()){
			writer.append(node.getName() + " : " + node.getNodeID() + " : " + node.getParentID() + "\n");
		}		
		
		writer.close();
	}
	
	private void refreshTreeNodeIDs(Map<String,DmozTreeNode> dbTreeMap, DmozTreeNode newTree) throws Exception{
		Long nodeId = dbTreeMap.get(newTree.getName()).getNodeID();
		newTree.setNodeID(nodeId);
		newTree.setParentID(-1L);
		
		assignParentChildrenIDs(dbTreeMap,newTree);
	}
	
	private void assignParentChildrenIDs(Map<String,DmozTreeNode> dbTreeMap, DmozTreeNode currentNode) throws Exception{
		if(dbTreeMap.containsKey(currentNode.getName())){
			//this node exists in the old tree
			DmozTreeNode correspondingNode = dbTreeMap.get(currentNode.getName());		
			Long nodeId = correspondingNode.getNodeID();
			Long parentId = correspondingNode.getParentID();
			currentNode.setNodeID(nodeId);
			currentNode.setParentID(parentId);
		}
		else{
			//it's a new node. assign new ID, and get parentID.
			Long nodeId = getUniqueId();
			Long parentId = currentNode.getParentNode().getNodeID();
			currentNode.setNodeID(nodeId);
			currentNode.setParentID(parentId);
		}
		for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
			assignParentChildrenIDs(dbTreeMap,childNode);
		}
	}
	
	private Map<String,DmozTreeNode> processNodesToBeDeleted(Map<String,DmozTreeNode> dbTreeMap, Map<String,DmozTreeNode> newTreeMap) throws Exception{
		Map<String,DmozTreeNode> nodesToBeDeleted = new HashMap<String,DmozTreeNode>();
		Map<String,DmozTreeNode> nodesList = new HashMap<String,DmozTreeNode>();
		
		nodesList.putAll(dbTreeMap);
		nodesList.keySet().removeAll(newTreeMap.keySet());
		
		//get sub-tree of each node
		for(DmozTreeNode node : nodesList.values()){
			Map<String, DmozTreeNode> subTreeNodes = TreeFunctions.getTreeInMap(node);
			nodesToBeDeleted.putAll(subTreeNodes);
		}
		
		return nodesToBeDeleted;
	}
	
	private Map<String,DmozTreeNode> processNodesToBeAdded(Map<String,DmozTreeNode> dbTreeMap, Map<String,DmozTreeNode> newTreeMap) throws Exception{
		Map<String,DmozTreeNode> nodesToBeAdded = new HashMap<String,DmozTreeNode>();
		
		nodesToBeAdded.putAll(newTreeMap);
		nodesToBeAdded.keySet().removeAll(dbTreeMap.keySet());		
		
		return nodesToBeAdded;
	}
	
	private Map<String,DmozTreeNode> detectUrlDataChange(Map<String,DmozTreeNode> oldTree, Map<String,DmozTreeNode> newTree) throws Exception{
		Map<String,DmozTreeNode> urlUpdateNodes = new HashMap<String,DmozTreeNode>();
		for(String cat : oldTree.keySet()){			
			if(newTree.containsKey(cat)){
				//if it's an existing node, see if there's any change on urlData in the new tree.				
				List<UrlDataObject> oldUrlData = oldTree.get(cat).getCategoryData().getUrlData();
				List<UrlDataObject> newUrlData = newTree.get(cat).getCategoryData().getUrlData();
				
				if(oldUrlData.size() != newUrlData.size()){
					//if there's any change, update to new one
					urlUpdateNodes.put(cat, newTree.get(cat));
				}
			}
		}
		
		return urlUpdateNodes;
	}
	
	private Long getUniqueId(){
		uniqueId++;
		return uniqueId;
	}
	
	public void setUniqueIdBase() throws Exception{
		uniqueId = DbTreeOperator.getUniqueIdBase();
	}
	
	public void compareCidFiles() throws Exception{		
		PrintStream out = new PrintStream(new FileOutputStream("c:\\dmoz\\temp.txt"));
		System.setOut(out);
		
		String cidFile1 = "c:\\dmoz\\dmoz.cids";
		String cidFile2 = "c:\\dmoz\\all.cids";
		
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		String strLine;
		
		//load in file 1
		fstream = new FileInputStream(cidFile1);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		Map<String,String> cids1 = new HashMap<String,String>();
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" : ");
			String cat = lineContents[0].trim();
			String cid = lineContents[1].trim();
			
			cids1.put(cat, cid);
		}
		in.close();
		
		//load in file2
		fstream = new FileInputStream(cidFile2);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		Map<String,String> cids2 = new HashMap<String,String>();
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" : ");
			String cat = lineContents[0].trim();
			String cid = lineContents[1].trim();
			
			cids2.put(cat, cid);
		}
		in.close();
		
		//check changed cids
		System.out.println("================= Cids that changed for same category =================");
		for(String cat : cids1.keySet()){
			if(cids2.containsKey(cat)){
				if(!cids2.get(cat).equals(cids1.get(cat))){
					System.out.println(cat + " - " + cids1.get(cat) + " : " + cids2.get(cat));
				}
			}			
		}
		System.out.println("* Done.");
				
		System.out.println("================= Deleted Nodes =================");
		//check to be deleted nodes
		Map<String,String> checkDelete = new HashMap<String,String>();
		checkDelete.putAll(cids1);
		checkDelete.keySet().removeAll(cids2.keySet());
		for(String cat : checkDelete.keySet()){
			System.out.println(cat + " - " + checkDelete.get(cat));
		}
		System.out.println("* Done.");
		
		System.out.println("================= Added Nodes =================");
		//check new nodes
		Map<String,String> checkAdd = new HashMap<String,String>();
		checkAdd.putAll(cids2);
		checkAdd.keySet().removeAll(cids1.keySet());
		for(String cat : checkAdd.keySet()){
			System.out.println(cat + " - " + checkAdd.get(cat));
		}
		System.out.println("* Done.");
		
	}
}
