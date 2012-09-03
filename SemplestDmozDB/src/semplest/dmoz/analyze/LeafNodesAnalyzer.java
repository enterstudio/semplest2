package semplest.dmoz.analyze;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.tree.DmozTreeBuilder;
import semplest.dmoz.tree.DmozTreeNode;

public class LeafNodesAnalyzer implements TreeAnalyzerInterface{
	
	private ArrayList<String> singeLetterLeafNodes = new ArrayList<String>();
	
	public static void main(String[] args){
		try{
			LeafNodesAnalyzer test = new LeafNodesAnalyzer();
			
			DmozTreeBuilder treeHandler = new DmozTreeBuilder(null,null);
			test.analyzeTree(treeHandler);
			test.outputReport("c:\\dmoz\\SingleLetterLeafNodes.txt");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void analyzeTree(DmozTreeBuilder dmozTreeHandler) throws Exception{
		/*
		 * find all the leaf nodes which name is only a letter, such as ../../a
		 */
		
		dmozTreeHandler.buildAndGetAllDmozTreeNodes();
		HashMap<String, DmozTreeNode> allTreeNodes = dmozTreeHandler.getAllDmozEntries();
		
		for(String catName : allTreeNodes.keySet()){
			String[] nodes = catName.trim().split("/");
			String leafNodeName = nodes[nodes.length - 1];
			if(leafNodeName.length() == 1){
				//this leaf node is a 1-letter node
				singeLetterLeafNodes.add(catName);
			}
		}
	}
	
	public void outputReport(String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		for(String node : singeLetterLeafNodes){
			writer.append(node + "\n");
		}
		writer.close();		
	}

}
