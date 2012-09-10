package semplest.dmoz.tree;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class DmozTreeBuilder {
	
	private static String topNodeName = "top";
	
	private Long uniqueId = 1L;
	private DmozTreeNode topNode;
	
	private String categoryCidFile;
	private String categoryDescriptionFile;
	private String categoryUrlsFile;		
	
	public static void main(String[] args){
		try{
			///*
			DmozTreeBuilder tree = new DmozTreeBuilder();
			tree.buildDmozTree();
			tree.printTree("c:\\dmoz\\dmoz.tree",tree.getTree());
			//*/
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
		
		this.categoryCidFile = properties.getProperty("dmoz.idFile");
		this.categoryDescriptionFile = properties.getProperty("dmoz.descriptionFile");
		this.categoryUrlsFile = properties.getProperty("dmoz.urlFile");
	}
	
	public DmozTreeBuilder(String categoryCidFile, String categoryDescriptionFile, String categoryUrlsFile) throws Exception{
		this.categoryCidFile = categoryCidFile;
		this.categoryDescriptionFile = categoryDescriptionFile;
		this.categoryUrlsFile = categoryUrlsFile;
	}
	
	public List<DmozTreeNode> getAllDmozNodes(){
		HashMap<String,DmozTreeNode> allNodes = new HashMap<String,DmozTreeNode>();
		
		recordNode(topNode, allNodes);		
		
		return new ArrayList(allNodes.values());
	}
	
	public HashMap<String,DmozTreeNode> getAllDmozNodesInMap(){
		HashMap<String,DmozTreeNode> allNodes = new HashMap<String,DmozTreeNode>();
		
		recordNode(topNode, allNodes);		
		
		return allNodes;
	}
	
	private void recordNode(DmozTreeNode currentNode, HashMap<String,DmozTreeNode> allNodes){
		allNodes.put(currentNode.getName(),currentNode);
		HashMap<String,DmozTreeNode> nodes = currentNode.getChildrenNodes();				
		for(DmozTreeNode node : nodes.values()){			
			if(node.getChildrenNodes() != null && !node.getChildrenNodes().isEmpty()){				
				recordNode(node, allNodes);
			}
		}
	}
	
	public DmozTreeNode getTree(){
		return topNode;
	}
	
	public void buildDmozTree() throws Exception{
		System.out.println("Loading Dmoz data...");
		HashMap<String,DmozCategoryData> inputData = readInData();
		System.out.println("Building Dmoz tree...");
		DmozTreeNode dmozTree = buildTree(inputData);
		//topNode = assignTreeIDs(dmozTree);
		System.out.println("Done.");
	}
	
	private HashMap<String,DmozCategoryData> readInData() throws Exception{
		HashMap<String,DmozCategoryData> allData = new HashMap<String,DmozCategoryData>();		
		
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		String strLine;
		
		// 1 -- load all cids
		fstream = new FileInputStream(categoryCidFile);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" : ");
			String cat = lineContents[0].trim();
			String categoryId = lineContents[1].trim();
			DmozCategoryData catData = new DmozCategoryData();
			catData.setCategoryId(Long.valueOf(categoryId));
			allData.put(cat, catData);
		}
		in.close();
		
		// 2 --load all descriptions
		fstream = new FileInputStream(categoryDescriptionFile);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" : ");
			String cat = lineContents[0].trim();
			String description = lineContents[1].trim();
			DmozCategoryData catData;
			if(!allData.containsKey(cat)){
				catData = new DmozCategoryData();
			}
			else{
				catData = allData.get(cat);
			}
			catData.setDescription(description);
			allData.put(cat, catData);
		}
		in.close();
		
		// 3 --load all urls
		fstream = new FileInputStream(categoryUrlsFile);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" ");
			String cat = lineContents[0].trim();
			HashMap<String,String> urls = parseUrls(strLine);
			DmozCategoryData catData;
			if(!allData.containsKey(cat)){
				catData = new DmozCategoryData();
			}
			else{
				catData = allData.get(cat);
			}
			catData.setUrlData(urls);
			allData.put(cat, catData);
		}
		in.close();
		
		return allData;
	}

	private DmozTreeNode buildTree(HashMap<String,DmozCategoryData> inputData) throws Exception{					
		topNode = new DmozTreeNode();
		Long topNodeId = getUniqueId();
		topNode.setNodeID(topNodeId);
		topNode.setParentID(-1L);
		topNode.setName(topNodeName);
		topNode.setParentNode(null);
		//topNode.setCategoryData(inputData.get("top"));
		
		for(String cat : inputData.keySet()){
			String[] nodes = cat.split("/");			
			DmozCategoryData catData = inputData.containsKey(cat)? inputData.get(cat) : new DmozCategoryData();
			
			DmozTreeNode currentNode = topNode;
			
			//find or create nodes						
			for(int node = 1; node < nodes.length; node++){
				String currentLevelName = nodes[node];
				HashMap<String,DmozTreeNode> currentLevelNodes = currentNode.getChildrenNodes();
				String fullNodeName = currentNode.getName() + "/" + currentLevelName;
				if(!currentLevelNodes.containsKey(fullNodeName)){
					DmozTreeNode newNode = new DmozTreeNode();
					newNode.setNodeID(getUniqueId());
					newNode.setParentID(currentNode.getNodeID());
					newNode.setName(fullNodeName);
					newNode.setParentNode(currentNode);
					currentNode.addChildNode(newNode);
				}
				currentNode = currentLevelNodes.get(fullNodeName);
			}			
			currentNode.setCategoryData(catData);			
		}		
				
		return topNode;		
	}	
	
	private DmozTreeNode assignTreeIDs(DmozTreeNode topNode){
		topNode.setNodeID(topNode.getCategoryData().getCategoryId());
		topNode.setParentID(-1L);
		
		assignParentChildrenIDs(topNode);
		
		return topNode;
	}
	
	private void assignParentChildrenIDs(DmozTreeNode currentNode){
		currentNode.setNodeID(currentNode.getCategoryData().getCategoryId());
		currentNode.setParentID(currentNode.getParentNode().getCategoryData().getCategoryId());
		for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
			assignParentChildrenIDs(childNode);
		}
	}
	
	public void printTree(String path, DmozTreeNode topNode) throws Exception{
		FileWriter writer = new FileWriter(path);
		printTree(topNode,writer);
	}
	
	private void printTree(DmozTreeNode currentNode, FileWriter writer) throws Exception{		
		writer.append(currentNode.getName() + " : " + currentNode.getNodeID() + " : " + currentNode.getParentID() + "\n");			
		for(DmozTreeNode node : currentNode.getChildrenNodes().values()){			
			printTree(node, writer);
		}		
	}
	
	private Long getUniqueId(){
		uniqueId++;
		return uniqueId;
	}
	
	private HashMap<String,String> parseUrls(String lineContent){
		HashMap<String,String> urlAndDesc = new HashMap<String,String>();
		
		String urlcluster = lineContent.split(" : ")[1];
		String[] urls = urlcluster.split(" ");
		for(String url : urls){
			urlAndDesc.put(url, null);
		}
		
		return urlAndDesc;
	}
	
}
