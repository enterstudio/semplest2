package semplest.dmoz.tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import semplest.dmoz.SemplestTreeDB;
import semplest.dmoz.pruning.CharDigLeafFilter;
import semplest.dmoz.pruning.DmozToSemplestFilter;
import semplest.dmoz.pruning.DmozToSemplestTreeConverter;
import semplest.dmoz.pruning.NorthAmericaUSMergingFilter;
import semplest.dmoz.pruning.RegionalRemovalFilter;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;

public class SemplestTreeBuilder {
	
	public static void main(String[] args) throws Exception
	{		
		//load the entire tree from the DB
		DmozTreeNode dmozTree = DbTreeOperator.loadTreeFromDB("top/business/financial_services");
		
		//apply processors on the tree, and convert it
		//TODO				
		DmozToSemplestTreeConverter dmozToSemplestConv = new DmozToSemplestTreeConverter(dmozTree);
		Set<DmozToSemplestFilter> filterSet = new HashSet<DmozToSemplestFilter>();
		filterSet.add(new RegionalRemovalFilter(null));
		filterSet.add(new CharDigLeafFilter(null));
		filterSet.add(new NorthAmericaUSMergingFilter(null));
		dmozToSemplestConv.setFilterSet(filterSet);
		dmozToSemplestConv.prune();			
		
		DmozTreeNode semplestTree = dmozToSemplestConv.getTree();			
		
		//put the tree maps in database
		List<DmozTreeNode> semplestTreeNodes = TreeFunctions.getTreeInList(semplestTree);
		SemplestTreeDB.AddSemplestTree(semplestTreeNodes);
		
	}
	
}
