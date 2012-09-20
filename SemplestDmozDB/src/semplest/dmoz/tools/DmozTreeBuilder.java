package semplest.dmoz.tools;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import semplest.dmoz.tree.DmozCategoryDataObject;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.UrlDataObject;

public class DmozTreeBuilder {
	
	private static String topNodeName = "top";
	
	private Long uniqueId = 0L;
	private DmozTreeNode topNode;
	
	private String categoryCidFile;
	private String categoryUrlsFile;		
	
	public static void main(String[] args){
		try{			
			DmozTreeBuilder tree = new DmozTreeBuilder();
			tree.buildDmozTree();
			TreeFunctions.printTree(tree.getTree(), "c:\\dmoz\\BuiltTree.txt");
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
		this.categoryUrlsFile = properties.getProperty("dmoz.urlDescFile");
	}
	
	public DmozTreeBuilder(String categoryCidFile, String categoryUrlsFile) throws Exception{
		this.categoryCidFile = categoryCidFile;
		this.categoryUrlsFile = categoryUrlsFile;
	}
	
	public DmozTreeNode getTree(){
		return topNode;
	}
	
	public void buildDmozTree() throws Exception{
		System.out.println("Loading Dmoz data...");
		Map<String,DmozCategoryDataObject> inputData = readInData();
		System.out.println("Building Dmoz tree...");
		buildTree(inputData);
		//assignTreeIDs(topNode);
		System.out.println("Done.");
	}
	
	private Map<String,DmozCategoryDataObject> readInData() throws Exception{
		Map<String,DmozCategoryDataObject> allData = new HashMap<String,DmozCategoryDataObject>();		
		
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
			DmozCategoryDataObject catData = new DmozCategoryDataObject();
			catData.setCategoryId(Long.valueOf(categoryId));
			allData.put(cat, catData);
		}
		in.close();

		// 2 --load category description, and all urls/url descs.
		fstream = new FileInputStream(categoryUrlsFile);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		
		while ((strLine = br.readLine()) != null){
			String[] lineContents = strLine.split(" ");
			String cat = lineContents[0].trim();
			List<UrlDataObject> urls = parseUrls(strLine);
			String catDesc = parseCategoryDesc(strLine);
			DmozCategoryDataObject catData;
			if(!allData.containsKey(cat)){
				catData = new DmozCategoryDataObject();
			}
			else{
				catData = allData.get(cat);
			}
			catData.setUrlData(urls);
			catData.setDescription(catDesc);
			allData.put(cat, catData);
		}
		in.close();
		
		return allData;
	}

	private DmozTreeNode buildTree(Map<String,DmozCategoryDataObject> inputData) throws Exception{		
		
		//set up the top node
		topNode = new DmozTreeNode();
		Long topNodeId = getUniqueId();
		topNode.setNodeID(topNodeId);
		topNode.setParentID(-1L);
		topNode.setName(topNodeName);
		topNode.setParentNode(null);
		DmozCategoryDataObject topCatData = inputData.containsKey("top")? inputData.get("top") : new DmozCategoryDataObject();
		topNode.setCategoryData(topCatData);
		
		//process each category, and build the tree
		for(String cat : inputData.keySet()){
			String[] nodes = cat.split("/");			
			DmozCategoryDataObject catData = inputData.containsKey(cat)? inputData.get(cat) : new DmozCategoryDataObject();
			
			DmozTreeNode currentNode = topNode;
			
			//find or create nodes						
			for(int node = 1; node < nodes.length; node++){
				String currentLevelName = nodes[node];
				Map<String,DmozTreeNode> currentLevelNodes = currentNode.getChildrenNodes();
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
	
	private DmozTreeNode assignTreeIDs(DmozTreeNode topNode) throws Exception{
		//This method assign node PK by it's categoryID from DMOZ.
		//It's unused now.
		
		topNode.setNodeID(topNode.getCategoryData().getCategoryId());
		topNode.setParentID(-1L);
		
		assignParentChildrenIDs(topNode);
		
		return topNode;
	}
	
	private void assignParentChildrenIDs(DmozTreeNode currentNode) throws Exception{
		currentNode.setNodeID(currentNode.getCategoryData().getCategoryId());
		currentNode.setParentID(currentNode.getParentNode().getCategoryData().getCategoryId());
		for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
			assignParentChildrenIDs(childNode);
		}
	}
	
	private Long getUniqueId(){
		uniqueId++;
		return uniqueId;
	}
	
	private List<UrlDataObject> parseUrls(String lineContent) throws Exception{
		List<UrlDataObject> urlAndDesc = new ArrayList<UrlDataObject>();
		
		String urlcluster = lineContent.split(" : ")[1].split(" ::: ")[0].trim();
		String[] urlAndDescs = urlcluster.split(" :: ");
		for(String urlInfo : urlAndDescs){
			int index = urlInfo.trim().indexOf(" ");			
			String url = urlInfo.substring(0,index).trim();
			String desc = urlInfo.substring(index+1).trim();
			UrlDataObject urlData = new UrlDataObject();
			urlData.setUrl(url);
			urlData.setUrlDescription(desc);
			urlAndDesc.add(urlData);
		}
		
		return urlAndDesc;
	}
	
	private String parseCategoryDesc(String lineContent) throws Exception{
		String[] descs = lineContent.split(" ::  ::: ");
		if(descs.length < 2){
			return null;
		}
		return lineContent.split(" ::  ::: ")[1];
	}
	
}
