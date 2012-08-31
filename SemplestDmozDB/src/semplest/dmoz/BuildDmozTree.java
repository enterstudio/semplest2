package semplest.dmoz;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import semplest.util.SemplestUtils;

public class BuildDmozTree {
	
	private static Long uniqueId = 0L;
	private static HashMap<String,TreeNode> allNodes = new HashMap<String,TreeNode>();
	private static HashMap<String,CategoryData> inputData;
	private static TreeNode topNode;
	
	private static String categoryDescriptionFile = "c:\\dmoz\\dmoz.descs";
	private static String categoryUrlsFile = "c:\\dmoz\\dmoz.urls";
	
	//temp
	private static Long numOfNodes = 0L;
	
	public static void main(String[] args){
		String emptyNodesFile = "c:\\dmoz\\EmptyNodes.txt";
		
		BuildDmozTree tree = new BuildDmozTree(categoryDescriptionFile, categoryUrlsFile);
		
		try {
			tree.buildAndGetAllDmozTreeNodes();			
			System.out.println(inputData.size());		
			System.out.println(allNodes.size());
			
			FileWriter writer = new FileWriter("c:\\dmoz\\DmozTree.txt");
			for(String node : allNodes.keySet()){
				writer.append(allNodes.get(node).getFullName() + " : " + allNodes.get(node).getCategoryData().toString() + "\n");
			}
			writer.close();	
			
			//tree.getListOfEmptyNodes(emptyNodesFile);
			
			//tree.printTree(topNode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BuildDmozTree(String categoryDescriptionFile, String categoryUrlsFile){
		this.categoryDescriptionFile = categoryDescriptionFile;
		this.categoryUrlsFile = categoryUrlsFile;
	}
	
	public HashMap<String,TreeNode> buildAndGetAllDmozTreeNodes() throws Exception{
		inputData = readInData();
		buildTree(inputData);
		return allNodes;
	}
	
	private HashMap<String,CategoryData> readInData() throws Exception{
		HashMap<String,CategoryData> allData = new HashMap<String,CategoryData>();		
		
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		String strLine;
		
		// 1 --load all descriptions
		fstream = new FileInputStream(categoryDescriptionFile);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split("\\:");
			String cat = lineContents[0].trim();
			String description = lineContents[1].trim();
			CategoryData catData = new CategoryData();
			catData.setDescription(description);
			allData.put(cat, catData);
		}
		in.close();
		
		// 2 --load all urls
		fstream = new FileInputStream(categoryUrlsFile);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" ");
			String cat = lineContents[0].trim();
			String[] urls = Arrays.copyOfRange(lineContents, 2, lineContents.length-1);
			CategoryData catData;
			if(!allData.containsKey(cat)){
				catData = new CategoryData();
			}
			else{
				catData = allData.get(cat);
			}
			catData.setUrls(urls);
			allData.put(cat, catData);
		}
		in.close();
		
		return allData;
	}

	private TreeNode buildTree(HashMap<String,CategoryData> inputData) throws Exception{					
		topNode = new TreeNode();
		Long topNodeId = getUniqueId();
		topNode.setNodeID(topNodeId);
		topNode.setParentID(topNodeId);  //top node's parent is itself
		topNode.setChildrenNodes(new HashMap<String,TreeNode>());
		
		for(String cat : inputData.keySet()){
			String[] nodes = cat.split("/");			
			CategoryData catData = inputData.get(cat);
			
			TreeNode currentParent = topNode;
			String fullNodeName = "top";
			
			//find or create middle nodes						
			for(int node = 1; node < nodes.length - 1; node++){
				String currentNodeName = nodes[node];
				HashMap<String,TreeNode> currentLevelNodes = currentParent.getChildrenNodes();
				fullNodeName = fullNodeName + "/" + currentNodeName;
				if(!currentLevelNodes.containsKey(currentNodeName)){
					TreeNode newNode = new TreeNode();
					newNode.setNodeID(getUniqueId());
					newNode.setParentID(currentParent.getNodeID());
					newNode.setName(currentNodeName);
					newNode.setFullName(fullNodeName);
					newNode.setChildrenNodes(new HashMap<String,TreeNode>());
					currentParent.addChildrenNode(newNode);
				}
				currentParent = currentLevelNodes.get(currentNodeName);
			}		
			
			//create the leaf
			String leafNodeName = nodes[nodes.length-1];
			String fullLeafNodeName = fullNodeName + "/" + leafNodeName;
			TreeNode leafNode = new TreeNode();
			leafNode.setNodeID(getUniqueId());
			leafNode.setParentID(currentParent.getNodeID());
			leafNode.setName(leafNodeName);
			leafNode.setFullName(fullLeafNodeName);			
			leafNode.setCategoryData(catData);
			leafNode.setChildrenNodes(new HashMap<String,TreeNode>());
			
			allNodes.put(leafNode.getFullName(), leafNode);
		}		
		
		return topNode;		
	}	
	
	public void printTree(TreeNode currentNode) throws Exception{		
		HashMap<String,TreeNode> nodes = currentNode.getChildrenNodes();		
		for(TreeNode node : nodes.values()){
			System.out.println(node.getName() + " : " + node.getFullName() + " : " + node.getNodeID() + " : " + node.getParentID());			
			numOfNodes++;
			if(node.getChildrenNodes() != null && !node.getChildrenNodes().isEmpty()){				
				printTree(node);
			}
		}		
	}
	
	private Long getUniqueId(){
		uniqueId++;
		return uniqueId;
	}
	
	public void getListOfEmptyNodes(String outputFile) throws Exception{
		Set<String> allCats = new HashSet<String>();
		allCats.addAll(allNodes.keySet());
		for(String cat : inputData.keySet()){
			allCats.remove(cat.trim());
		}		
		
		FileWriter writer = new FileWriter(outputFile);
		for(String node : allCats){
			writer.append(node + "\n");
		}
		writer.close();		
	}
	
}
