package semplest.dmoz.tree;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import semplest.util.SemplestUtils;

public class DmozTreeBuilder {
	
	private static Long uniqueId = 0L;
	private static HashMap<String,DmozTreeNode> allNodes = new HashMap<String,DmozTreeNode>();
	private static HashMap<String,DmozCategoryData> inputData;
	private static DmozTreeNode topNode;
	
	private static String categoryDescriptionFile;
	private static String categoryUrlsFile;
	
	//temp
	private static Long numOfNodes = 0L;
	
	public static void main(String[] args){
		try{
			DmozTreeBuilder tree = new DmozTreeBuilder();
			tree.buildAndGetAllDmozTreeNodes();
			System.out.println(tree.inputData.size());
			System.out.println(tree.allNodes.size());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public DmozTreeBuilder() throws Exception{
		//Read property file for dmoz files paths
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("bin/system.properties");
		properties.load(in);
		in.close();
		
		this.categoryDescriptionFile = properties.getProperty("dmoz.urlFile");
		this.categoryUrlsFile = properties.getProperty("dmoz.descriptionFile");
	}
	
	public DmozTreeBuilder(String categoryDescriptionFile, String categoryUrlsFile) throws Exception{
		this.categoryDescriptionFile = categoryDescriptionFile;
		this.categoryUrlsFile = categoryUrlsFile;
	}
	
	public HashMap<String,DmozTreeNode> getAllDmozEntries(){
		return allNodes;
	}
	
	public DmozTreeNode getTree(){
		return topNode;
	}
	
	public void buildAndGetAllDmozTreeNodes() throws Exception{
		System.out.println("Loading Dmoz data...");
		inputData = readInData();
		System.out.println("Building Dmoz tree...");
		buildTree(inputData);
		System.out.println("Done.");
	}
	
	private HashMap<String,DmozCategoryData> readInData() throws Exception{
		HashMap<String,DmozCategoryData> allData = new HashMap<String,DmozCategoryData>();		
		
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
			DmozCategoryData catData = new DmozCategoryData();
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
			HashSet<String> urls = new HashSet<String>();
			for(int i = 2; i < lineContents.length; i++){
				urls.add(lineContents[i]);
			}
			DmozCategoryData catData;
			if(!allData.containsKey(cat)){
				catData = new DmozCategoryData();
			}
			else{
				catData = allData.get(cat);
			}
			catData.setUrls(urls.toArray(new String[urls.size()]));
			allData.put(cat, catData);
		}
		in.close();
		
		return allData;
	}

	private DmozTreeNode buildTree(HashMap<String,DmozCategoryData> inputData) throws Exception{					
		topNode = new DmozTreeNode();
		Long topNodeId = getUniqueId();
		topNode.setNodeID(topNodeId);
		topNode.setParentID(topNodeId);  //top node's parent is itself
		topNode.setName("top");
		topNode.setFullName("top");
		topNode.setCategoryData(new DmozCategoryData());
		topNode.setChildrenNodes(new HashMap<String,DmozTreeNode>());
		
		for(String cat : inputData.keySet()){
			String[] nodes = cat.split("/");			
			DmozCategoryData catData = inputData.get(cat);
			
			DmozTreeNode currentParent = topNode;
			
			//find or create middle nodes						
			for(int node = 1; node < nodes.length - 1; node++){
				String currentNodeName = nodes[node];
				HashMap<String,DmozTreeNode> currentLevelNodes = currentParent.getChildrenNodes();
				String fullNodeName = currentParent.getFullName() + "/" + currentNodeName;
				if(!currentLevelNodes.containsKey(currentNodeName)){
					DmozTreeNode newNode = new DmozTreeNode();
					newNode.setNodeID(getUniqueId());
					newNode.setParentID(currentParent.getNodeID());
					newNode.setName(currentNodeName);
					newNode.setFullName(fullNodeName);
					newNode.setChildrenNodes(new HashMap<String,DmozTreeNode>());
					currentParent.addChildrenNode(newNode);
				}
				currentParent = currentLevelNodes.get(currentNodeName);
			}		
			
			//create the leaf
			String leafNodeName = nodes[nodes.length-1];
			String fullLeafNodeName = currentParent.getFullName() + "/" + leafNodeName;
			DmozTreeNode leafNode = new DmozTreeNode();
			leafNode.setNodeID(getUniqueId());
			leafNode.setParentID(currentParent.getNodeID());
			leafNode.setName(leafNodeName);
			leafNode.setFullName(fullLeafNodeName);			
			leafNode.setCategoryData(catData);
			leafNode.setChildrenNodes(new HashMap<String,DmozTreeNode>());
			currentParent.addChildrenNode(leafNode);
			
			allNodes.put(leafNode.getFullName(), leafNode);
		}		
		
		return topNode;		
	}	
	
	public void printTree(DmozTreeNode currentNode) throws Exception{		
		HashMap<String,DmozTreeNode> nodes = currentNode.getChildrenNodes();		
		for(DmozTreeNode node : nodes.values()){
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
	
}
