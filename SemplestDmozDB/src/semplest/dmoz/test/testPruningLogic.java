package semplest.dmoz.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import semplest.dmoz.pruning.CharDigLeafFilter;
import semplest.dmoz.pruning.DmozToSemplestFilter;
import semplest.dmoz.pruning.DmozToSemplestTreeConverter;
import semplest.dmoz.pruning.MiddleCharDigNodeBypassFilter;
import semplest.dmoz.pruning.NorthAmericaUSMergingFilter;
import semplest.dmoz.pruning.RegionalRemovalFilter;
import semplest.dmoz.tools.DbTreeOperator;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.process.NodeCountProcessor;

public class testPruningLogic {
	
	public static void main(String[] args){
		testPruningLogic test = new testPruningLogic();
		try {
			test.compareTwoTrees();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compareTwoTrees() throws Exception{
		//get original tree
		DmozTreeNode dmozTree = DbTreeOperator.loadTreeFromDB("top");
		
		NodeCountProcessor semplestCountNodeTreeProc = new NodeCountProcessor();
		semplestCountNodeTreeProc.analyzeTree(dmozTree);
		int countNodesInOriginalTree = dmozTree.getTreeNodeCount();

		
		//prune the tree
		DmozToSemplestTreeConverter dmozToSemplestConv = new DmozToSemplestTreeConverter(dmozTree);
		Set<DmozToSemplestFilter> filterSet = new HashSet<DmozToSemplestFilter>();
		filterSet.add(new RegionalRemovalFilter(null));
		filterSet.add(new CharDigLeafFilter(null));
		filterSet.add(new NorthAmericaUSMergingFilter(null));
		filterSet.add(new MiddleCharDigNodeBypassFilter(null));
		dmozToSemplestConv.setFilterSet(filterSet);
		dmozToSemplestConv.prune();			
		
		DmozTreeNode semplestTree = dmozToSemplestConv.getTree();		
		
		AllNodesUrlNumProcesser dmozProc = new AllNodesUrlNumProcesser();
		dmozProc.analyzeTree(dmozTree);
		Map<String, Integer> dmozTreeUrlCountMap = dmozProc.getUrlCountMap();
		
		AllNodesUrlNumProcesser semplestTreeProc = new AllNodesUrlNumProcesser();
		semplestTreeProc.analyzeTree(semplestTree);
		Map<String, Integer> semplestTreeUrlCountMap = semplestTreeProc.getUrlCountMap();
		
		for(String node : semplestTreeUrlCountMap.keySet()){
			if(dmozTreeUrlCountMap.containsKey(node)){
				Integer semplestTreeUrlCount = semplestTreeUrlCountMap.get(node);
				Integer dmozTreeUrlCount = dmozTreeUrlCountMap.get(node);
				if(!semplestTreeUrlCount.equals(dmozTreeUrlCount)){
					System.out.println("### Url Count Mismatch: semplestTreeUrlCount = " + semplestTreeUrlCount + ", dmozTreeUrlCount = " + dmozTreeUrlCount);
				}
			}
		}
		System.out.println("Comparison done." );
		
		semplestCountNodeTreeProc.analyzeTree(semplestTree);
		
		System.out.println("Number of nodes before pruning: "+ countNodesInOriginalTree);
		System.out.println("Number of nodes after pruning: "+ semplestTree.getTreeNodeCount());
	}
	
	public class AllNodesUrlNumProcesser{
		
		private ArrayList<String> urlCounts;
		private boolean storeData = false;
		private Map<String,Integer> urlCountMap = new HashMap<String,Integer>();

		public void analyzeTree(DmozTreeNode topNode) throws Exception {
			urlCounts = new ArrayList<String>();
			storeData = true;
			countNodeUrl(topNode);
		}
		
		private Integer countNodeUrl(DmozTreeNode currentNode){
			Map<String,DmozTreeNode> childrenNodes = currentNode.getChildrenNodes();
			Integer numSubNodeUrls = 0;
			for(DmozTreeNode childNode : childrenNodes.values()){
				Integer numChildUrls = countNodeUrl(childNode);
				numSubNodeUrls = numSubNodeUrls + numChildUrls;
			}
			
			Integer numCurrentNodeUrls = currentNode.getCategoryData() == null? 0 : 
				(currentNode.getCategoryData().getUrlData() == null ? 0 : currentNode.getCategoryData().getUrlData().size());
			
			Integer numAllUrls = numCurrentNodeUrls + numSubNodeUrls;	
			if(storeData){
				urlCounts.add(currentNode.getName() + " : " + numAllUrls);
				urlCountMap.put(currentNode.getName(), numAllUrls);
			}
			currentNode.setTreeURLCount(numAllUrls);
			return numAllUrls;
		}
		
		public Map<String,Integer> getUrlCountMap(){
			return urlCountMap;
		}

		public Integer getCount(DmozTreeNode topNode) throws Exception {
			return countNodeUrl(topNode);
		}

	}
}
