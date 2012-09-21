package semplest.dmoz.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			String treeName = "top/business/financial_services";		
			Integer maxBatchSize = 500;
			
			TreeFunctions.startLogError("SemplestTreeBuilder", "c:\\dmoz\\");
			
			//load the entire tree from the DB
			DmozTreeNode dmozTree = DbTreeOperator.loadTreeFromDB(treeName);
			
			//apply processors on the tree, and convert it
			DmozTreeNode semplestTree = applyFilters(dmozTree);
			
			//get request list
			List<DmozTreeNode> semplestTreeNodes = TreeFunctions.getTreeInList(semplestTree);
			List<AddSemplestTreeRequest> requests = formAddSemplestTreeRequest(semplestTreeNodes);
			
			//put the tree maps in database
			List<List<AddSemplestTreeRequest>> batches = SemplestUtils.getBatches(requests, maxBatchSize);
			
			System.out.println("Start to store " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to DB.");
			Long start = System.currentTimeMillis();
			int count = 0;
			for(List<AddSemplestTreeRequest> batch : batches){
				System.out.println(" - Storing batch #" + count);
				try{
					SemplestTreeDB.AddSemplestTree(batch);
				}
				catch(Exception e){
					TreeFunctions.logError(e.getMessage());
				}
				count++;
				System.out.println("	So far took " + (System.currentTimeMillis() - start)/1000 + " secs.");
			}		
				
			System.out.println("In total took " + (System.currentTimeMillis() - start)/1000 + " secs.");		
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
	private static String getDomain(String url)
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
	
}
