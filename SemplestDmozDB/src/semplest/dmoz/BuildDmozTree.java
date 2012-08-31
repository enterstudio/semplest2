package semplest.dmoz;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class BuildDmozTree {
	
	private final static String defaultPath = "C:\\temp\\";
	private static Long uniqueId = 0L;
	private static HashMap<String,TreeNode> allNodes = new HashMap<String,TreeNode>();
	
	private String categoryDescriptionFile;
	private String categoryUrlsFile;
	
	//temp
	private static Long numOfNodes = 0L;
	
	public static void main(String[] args){
		String path = "C:\\temp\\";
		
		BuildDmozTree tree = new BuildDmozTree(null, null);
		
		try {
			HashMap<String,CategoryData> inputData = tree.readInData(path);
			TreeNode topNode = tree.buildTree(inputData);
			tree.printTree(topNode);
			
			System.out.println(inputData.size());		
			System.out.println(numOfNodes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BuildDmozTree(String categoryDescriptionFile, String categoryUrlsFile){
		this.categoryDescriptionFile = categoryDescriptionFile;
		this.categoryUrlsFile = categoryUrlsFile;
	}
	
	public HashMap<String,TreeNode> buildAndGetAllDmozTreeNodes() throws Exception{
		HashMap<String,CategoryData> inputData = readInData(defaultPath);
		buildTree(inputData);
		return allNodes;
	}
	
	private HashMap<String,CategoryData> readInData(String path) throws Exception{
		HashMap<String,CategoryData> allData = new HashMap<String,CategoryData>();
		
		String categoryDescription = path + "dmoz.descs";
		String categoryUrls = path + "dmoz.urls";
		
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		String strLine;
		
		// 1 --load all descriptions
		fstream = new FileInputStream(categoryDescription);
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
		fstream = new FileInputStream(categoryUrls);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split("\\:");
			String cat = lineContents[0].trim();
			String[] urls = lineContents[1].trim().split(" ");
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
		TreeNode topNode = new TreeNode();
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
			for(int node = 1; node < nodes.length; node++){
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
	
	public void printTree(TreeNode currentNode){
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
	
	public void getListOfEmptyNodes(String path) throws Exception{
		HashSet<String> allCats = new HashSet<String>();
		
		String categoryCids = path + "dmoz.cids";
		String categoryDescription = path + "dmoz.descs";
		String categoryUrls = path + "dmoz.urls";		
		
		FileInputStream fstream;
		DataInputStream in;
		BufferedReader br;
		String strLine;
		
		//1
		fstream = new FileInputStream(categoryCids);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split("\\:");
			String cat = lineContents[0].trim();
			allCats.add(cat);
		}
		in.close();
		
		//2
		fstream = new FileInputStream(categoryDescription);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String cat = strLine.split("\\:")[0].trim();
			allCats.remove(cat);
		}
		in.close();
		
		//3
		fstream = new FileInputStream(categoryUrls);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String cat = strLine.split("\\:")[0].trim();
			allCats.remove(cat);
		}
		in.close();		
		
		FileWriter writer = new FileWriter(path + "EmptyNodes.txt");
		for(String node : allCats){
			writer.append(node + "\n");
		}
		writer.close();
		
	}
	
}
