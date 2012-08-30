package semplest.dmoz.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class BuildTree {
	
	private static Long uniqueId = 0L;
	
	public static void main(String[] args){
		String path = "C:\\temp\\";
		
		BuildTree tree = new BuildTree();
		
		try {
			HashMap<String,CategoryData> inputData = tree.readInData(path);
			TreeNode topNode = tree.build(inputData);
			//tree.printTree(topNode);
			
			//System.out.println(inputData.size());			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String,CategoryData> readInData(String path) throws Exception{
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

	public TreeNode build(HashMap<String,CategoryData> inputData) throws Exception{					
		TreeNode topNode = new TreeNode();
		topNode.setNodeID(getUniqueId());
		topNode.setChildrenNodes(new HashMap<String,TreeNode>());
		
		for(String cat : inputData.keySet()){
			String[] nodes = cat.split("/");			
			for(int level = 1; level < nodes.length; level++){
				HashMap<String,TreeNode> currentLevelNodes = topNode.getChildrenNodes();
				String nodeName = "top";
				for(int parent = 1; parent < level; parent++){
					String parentNode = nodes[parent];
					nodeName = nodeName + "/" + parentNode;
					if(!currentLevelNodes.containsKey(parentNode)){
						TreeNode newNode = new TreeNode();
						newNode.setNodeID(getUniqueId());
						newNode.setNodeName(nodeName);
						newNode.setChildrenNodes(new HashMap<String,TreeNode>());
						currentLevelNodes.put(parentNode, newNode);
					}
					currentLevelNodes = currentLevelNodes.get(parentNode).getChildrenNodes();
				}
				String thisNode = nodes[level];
				nodeName = nodeName + "/" + thisNode;
				if(!currentLevelNodes.containsKey(thisNode)){
					TreeNode newNode = new TreeNode();
					newNode.setNodeID(getUniqueId());
					newNode.setNodeName(nodeName);
					newNode.setChildrenNodes(new HashMap<String,TreeNode>());
					currentLevelNodes.put(thisNode, newNode);
				}
			}
		}		
		
		return topNode;		
	}	
	
	public void printTree(TreeNode currentNode){
		HashMap<String,TreeNode> nodes = currentNode.getChildrenNodes();
		for(TreeNode node : nodes.values()){
			System.out.println(node.getNodeName() + " : " + node.getNodeID());
			if(node.getChildrenNodes() != null && !node.getChildrenNodes().isEmpty()){				
				printTree(node);
			}
		}
	}
	
	public Long getUniqueId(){
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
