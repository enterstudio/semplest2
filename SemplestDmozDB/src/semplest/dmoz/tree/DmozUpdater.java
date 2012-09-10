package semplest.dmoz.tree;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DmozUpdater {
	
	private static HashMap<String,DmozTreeNode> nodesToBeDeleted;
	private static HashMap<String,DmozTreeNode> nodesToBeAdded;
	private static HashMap<String,DmozTreeNode> nodesToUpdateUrlData;
	private static HashMap<String,DmozTreeNode> nodesToChangeParentId;
	
	public static void main(String[] args){
		try {
			//compareCidFiles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateNodesInDB() throws Exception{
		compareDbTreeAndNewTree();
		DmozDbOperator.deleteTreeNodes(getNodesToBeDeleted());
		DmozDbOperator.addTreeNodes(getNodesToBeAdded());
		DmozDbOperator.updateTreeNode(getNodesToChangeParentId());
		DmozDbOperator.updateUrlData(getNodesToUpdateUrlData());
	}
	
	public static List<DmozTreeNode> getNodesToBeDeleted(){
		return new ArrayList<DmozTreeNode>(nodesToBeDeleted.values());
	}
	
	public static List<DmozTreeNode> getNodesToBeAdded(){
		return new ArrayList<DmozTreeNode>(nodesToBeAdded.values());
	}
	
	public static List<DmozTreeNode> getNodesToChangeParentId(){
		return new ArrayList<DmozTreeNode>(nodesToChangeParentId.values());
	}
	
	public static List<DmozTreeNode> getNodesToUpdateUrlData(){
		return new ArrayList<DmozTreeNode>(nodesToUpdateUrlData.values());
	}
	
	public static void compareDbTreeAndNewTree() throws Exception{
		//Get the tree from DB
		DmozTreeNode dmozTree = DmozDbOperator.loadDmozTreeFromDB();		
		HashMap<String,DmozTreeNode> dbTreeMap = TreeFuncs.getTreeInMap(dmozTree);
		
		//Get the new tree
		DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
		treeBuilder.buildDmozTree();
		HashMap<String,DmozTreeNode> newTreeMap = treeBuilder.getAllDmozNodesInMap();
		
		nodesToBeDeleted = new HashMap<String,DmozTreeNode>();
		nodesToBeDeleted.putAll(dbTreeMap);
		nodesToBeDeleted.keySet().removeAll(newTreeMap.keySet());
		
		nodesToBeAdded = new HashMap<String,DmozTreeNode>();
		nodesToBeAdded.putAll(newTreeMap);
		nodesToBeAdded.keySet().removeAll(dbTreeMap.keySet());		
		
		nodesToChangeParentId = detectParentNodeChange(dbTreeMap, newTreeMap);
		
		nodesToUpdateUrlData = detectUrlDataChange(dbTreeMap, newTreeMap);
	}
	
	private static HashMap<String,DmozTreeNode> detectParentNodeChange(HashMap<String,DmozTreeNode> oldTree, HashMap<String,DmozTreeNode> newTree) throws Exception{
		HashMap<String,DmozTreeNode> nodesHaveParentNodeChange = new HashMap<String,DmozTreeNode>();
		for(String cat : oldTree.keySet()){			
			if(newTree.containsKey(cat)){
				//detect if there's any parent node change
				Long oldParent = oldTree.get(cat).getParentID();
				Long newParent = newTree.get(cat).getParentID();
				
				if(!oldParent.equals(newParent)){
					//if there's any change, update to new one
					nodesHaveParentNodeChange.put(cat, newTree.get(cat));
				}
			}
		}
		
		return nodesHaveParentNodeChange;
	}
	
	private static HashMap<String,DmozTreeNode> detectUrlDataChange(HashMap<String,DmozTreeNode> oldTree, HashMap<String,DmozTreeNode> newTree) throws Exception{
		HashMap<String,DmozTreeNode> urlUpdateNodes = new HashMap<String,DmozTreeNode>();
		for(String cat : oldTree.keySet()){			
			if(newTree.containsKey(cat)){
				//if it's an existing node, see if there's any change on urlData in the new tree.				
				HashMap<String,String> oldUrlData = oldTree.get(cat).getCategoryData().getUrlData();
				HashMap<String,String> newUrlData = newTree.get(cat).getCategoryData().getUrlData();
				
				if(!oldUrlData.keySet().equals(newTree.keySet())){
					//if there's any change, update to new one
					urlUpdateNodes.put(cat, newTree.get(cat));
				}
			}
		}
		
		return urlUpdateNodes;
	}
	
	public static void compareCidFiles() throws Exception{		
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
		
		HashMap<String,String> cids1 = new HashMap<String,String>();
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
		
		HashMap<String,String> cids2 = new HashMap<String,String>();
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
		HashMap<String,String> checkDelete = new HashMap<String,String>();
		checkDelete.putAll(cids1);
		checkDelete.keySet().removeAll(cids2.keySet());
		for(String cat : checkDelete.keySet()){
			System.out.println(cat + " - " + checkDelete.get(cat));
		}
		System.out.println("* Done.");
		
		System.out.println("================= Added Nodes =================");
		//check new nodes
		HashMap<String,String> checkAdd = new HashMap<String,String>();
		checkAdd.putAll(cids2);
		checkAdd.keySet().removeAll(cids1.keySet());
		for(String cat : checkAdd.keySet()){
			System.out.println(cat + " - " + checkAdd.get(cat));
		}
		System.out.println("* Done.");
		
	}
}
