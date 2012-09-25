package semplest.dmoz.tools;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import semplest.dmoz.DmozDB;
import semplest.dmoz.SemplestTreeDB;
import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.pruning.CharDigLeafFilter;
import semplest.dmoz.pruning.DmozToSemplestFilter;
import semplest.dmoz.pruning.DmozToSemplestTreeConverter;
import semplest.dmoz.pruning.MiddleCharDigNodeBypassFilter;
import semplest.dmoz.pruning.NorthAmericaUSMergingFilter;
import semplest.dmoz.pruning.RegionalRemovalFilter;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.UrlDataObject;
import semplest.util.SemplestUtils;

public class SemplestTreeBuilder {
	
	public static void main(String[] args)
	{		
		try{		
			String treeName = "top";	
			
			TreeFunctions.startLogError("SemplestTreeBuilder", "c:\\dmoz\\");
			
			//load the entire tree from the DB
			DmozTreeNode dmozTree = DmozDB.getDmozTree(treeName);
			
			//apply processors on the tree, and convert it
			DmozTreeNode semplestTree = applyFilters(dmozTree);
			
			//get request list
			List<DmozTreeNode> semplestTreeNodes = TreeFunctions.getTreeInList(semplestTree);
			List<AddSemplestTreeRequest> requests = formAddSemplestTreeRequest(semplestTreeNodes);
			
			//write the data to a file
			FileWriter writer = new FileWriter("c:\\dmoz\\SemplestTree.txt");
			writer.write("");
			for(AddSemplestTreeRequest req : requests){
				writer.append(req.getDMOZSemplestPK() + "," + req.getDMOZURLDataPK() + "," + req.getDomain() + "\r\n");
			}
			writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				TreeFunctions.endLogError();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static DmozTreeNode applyFilters(DmozTreeNode dmozTree) throws Exception
	{		
		DmozToSemplestTreeConverter dmozToSemplestConv = new DmozToSemplestTreeConverter(dmozTree);
		Set<DmozToSemplestFilter> filterSet = new HashSet<DmozToSemplestFilter>();
		filterSet.add(new RegionalRemovalFilter(null));
		filterSet.add(new CharDigLeafFilter(null));
		filterSet.add(new NorthAmericaUSMergingFilter(null));
		filterSet.add(new MiddleCharDigNodeBypassFilter(null));
		dmozToSemplestConv.setFilterSet(filterSet);
		dmozToSemplestConv.prune();			
		
		DmozTreeNode semplestTree = dmozToSemplestConv.getTree();	
		
		return semplestTree;
	}
	
	public static List<AddSemplestTreeRequest> formAddSemplestTreeRequest(List<DmozTreeNode> semplestTreeNodes) throws Exception{
		//form the request list
		final List<AddSemplestTreeRequest> addSemplestTreeRequests = new ArrayList<AddSemplestTreeRequest>();
		for(DmozTreeNode node : semplestTreeNodes){
			List<UrlDataObject> list = node.getCategoryData().getUrlData();
			for(UrlDataObject urlData : list){				
				AddSemplestTreeRequest request = new AddSemplestTreeRequest();
				request.setDMOZSemplestPK(node.getNodeID());
				request.setDMOZURLDataPK(urlData.getUrlDataPK());				
				request.setDomain(getDomain(urlData.getUrl()));
				
				addSemplestTreeRequests.add(request);
			}
		}	
		
		return addSemplestTreeRequests;
	}	
	
	//helper method
	private static String getDomain(String url) throws Exception
	{
		String[] parts = url.split("://");
		String subUrl;
		if(parts.length > 1){
			subUrl = parts[1];
		}
		else{
			subUrl = parts[0];
		}
		int index = subUrl.indexOf("/");
		String domain;
		if(index > 0){
			domain = subUrl.substring(0, index);
		}
		else{
			domain = subUrl;
		}
		
		return domain;
	}
	
	//verification method
	public static void verifySemplestTree() throws Exception{
		String treeName = "top";
		DmozTreeNode dmozTree = DmozDB.getDmozTree(treeName);
		DmozTreeNode semplestTree = applyFilters(dmozTree);
		
		System.out.println("Start to verify the Semplest Tree...");
		
		//randomly choose 100 nodes to verify the db
		List<DmozTreeNode> semplestTreeNodes = TreeFunctions.getTreeInList(semplestTree);
		for(int i = 0; i < 100; i++){
			//choose random node
			int randomNum = (int)(Math.random()*(semplestTreeNodes.size()-1)); 
			DmozTreeNode randomNode = semplestTreeNodes.get(randomNum);
			
			Long nodeID = randomNode.getNodeID();
			String nodeName = randomNode.getName();
			
			System.out.println("# " + i + ": Verifying node " + nodeID + "-" + nodeName);
								
			//get url info of the tree			
			List<String> treeUrls = randomNode.getCategoryData().getUrls();			
			//get url info from the db
			List<String> DbUrls = DbSemplestTreeOperator.getUrlsByNode(nodeID);
			
			//compare the url info from tree and from db
			if(treeUrls.size() != DbUrls.size()){
				//number of urlData in tree and in db doesn't match
				System.out.println("	ERROR: number of urlData in tree = " + treeUrls.size() + ", number of urlData in db = " + DbUrls.size());
			}
			for(String url : treeUrls){
				if(!DbUrls.contains(url.trim())){
					//there's an url missing in the db
					System.out.println("	ERROR: url " + url + " is missing in the DB.");
				}
			}
		}
		
		System.out.println("Done.");
	}
	
}
