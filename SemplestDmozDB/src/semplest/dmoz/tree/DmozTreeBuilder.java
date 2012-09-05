package semplest.dmoz.tree;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

public class DmozTreeBuilder {
	
	private Long uniqueId = 1L;
	private DmozTreeNode topNode;
	
	private String categoryCidFile;
	private String categoryDescriptionFile;
	private String categoryUrlsFile;	
	
	//temp
	private static Long numOfNodes = 0L;
	
	public static void main(String[] args){
		try{
			///*
			DmozTreeBuilder tree = new DmozTreeBuilder();
			tree.buildDmozTree();
			//tree.printTree(tree.getTree());
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
		this.categoryDescriptionFile = properties.getProperty("dmoz.urlFile");
		this.categoryUrlsFile = properties.getProperty("dmoz.descriptionFile");
	}
	
	public DmozTreeBuilder(String categoryCidFile, String categoryDescriptionFile, String categoryUrlsFile) throws Exception{
		this.categoryCidFile = categoryCidFile;
		this.categoryDescriptionFile = categoryDescriptionFile;
		this.categoryUrlsFile = categoryUrlsFile;
	}
	
	public List<DmozTreeNode> getAllDmozNodes(){
		List<DmozTreeNode> allNodes = new ArrayList<DmozTreeNode>();
		
		recordNode(topNode, allNodes);		
		
		return allNodes;
	}
	
	private void recordNode(DmozTreeNode currentNode, List<DmozTreeNode> allNodes){
		allNodes.add(currentNode);
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
		buildTree(inputData);
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
			catData.setUrlsAndDescs(urls);
			allData.put(cat, catData);
		}
		in.close();
		
		return allData;
	}

	private DmozTreeNode buildTree(HashMap<String,DmozCategoryData> inputData) throws Exception{					
		topNode = new DmozTreeNode();
		Long topNodeId = getUniqueId();
		topNode.setNodeID(topNodeId);
		topNode.setParentID(0L);
		topNode.setName("top");
		topNode.setFullName("top");
		topNode.setCategoryData(new DmozCategoryData());
		topNode.setChildrenNodes(new HashMap<String,DmozTreeNode>());
		topNode.setParentNode(topNode);
		
		for(String cat : inputData.keySet()){
			String[] nodes = cat.split("/");			
			DmozCategoryData catData = inputData.get(cat);
			
			DmozTreeNode currentNode = topNode;
			
			//find or create nodes						
			for(int node = 1; node < nodes.length; node++){
				String currentNodeName = nodes[node];
				HashMap<String,DmozTreeNode> currentLevelNodes = currentNode.getChildrenNodes();
				String fullNodeName = currentNode.getFullName() + "/" + currentNodeName;
				if(!currentLevelNodes.containsKey(currentNodeName)){
					DmozTreeNode newNode = new DmozTreeNode();
					newNode.setNodeID(catData.getCategoryId());
					newNode.setParentID(currentNode.getNodeID());
					newNode.setName(currentNodeName);
					newNode.setFullName(fullNodeName);
					newNode.setChildrenNodes(new HashMap<String,DmozTreeNode>());
					newNode.setParentNode(currentNode);
					currentNode.addChildNode(newNode);
				}
				currentNode = currentLevelNodes.get(currentNodeName);
			}			
			currentNode.setCategoryData(catData);			
		}		
		
		return topNode;		
	}	
	
	public void printTree(String path, DmozTreeNode topNode) throws Exception{
		FileWriter writer = new FileWriter(path);
		printTree(topNode,writer);
	}
	
	public void printTree(DmozTreeNode currentNode, FileWriter writer) throws Exception{		
		HashMap<String,DmozTreeNode> nodes = currentNode.getChildrenNodes();		
		writer.append(currentNode.getName() + " : " + currentNode.getFullName() + " : " + currentNode.getNodeID() + " : " + currentNode.getParentID() + "\n");			
		for(DmozTreeNode node : nodes.values()){			
			numOfNodes++;
			if(node.getChildrenNodes() != null && !node.getChildrenNodes().isEmpty()){				
				printTree(node, writer);
			}
		}		
	}
	
	private Long getUniqueId(){
		uniqueId++;
		return uniqueId;
	}
	
	private HashMap<String,String> parseUrls(String lineContent){
		
		return null;
	}
	
}
