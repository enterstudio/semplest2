package semplest.dmoz.pruning;


import java.util.HashSet;
import java.util.Set;

import semplest.dmoz.tree.DmozTreeNode;


public class DmozToSemplestTreeConverter {
	
	private DmozTreeNode root;
	private Set<DmozToSemplestFilter> filterSet;

	public Set<DmozToSemplestFilter> getFilterSet() {
		return filterSet;
	}

	public void setFilterSet(Set<DmozToSemplestFilter> filterSet) {
		this.filterSet = filterSet;
	}
	
	public void addFilterSet(Set<DmozToSemplestFilter> filterSet) {
		this.filterSet.addAll(filterSet);
	}
	
	public DmozToSemplestTreeConverter(DmozTreeNode root){
		this.root = root;
		filterSet = new HashSet<DmozToSemplestFilter>();
	}
	
	public void addFilter(DmozToSemplestFilter filter){
		filterSet.add(filter);
	}
	
	public void analyze() throws Exception{
		for(DmozToSemplestFilter filter : filterSet){
			System.out.println("[DmozToSemplestTreeConverter] Analyzing tree with filter: "+filter.getFilterName());
			TreeTraversal.analyze(root, filter);
		}
	}
	
	public void prune() throws Exception{
		for(DmozToSemplestFilter filter : filterSet){
			System.out.println("[DmozToSemplestTreeConverter] Pruning tree with filter: "+filter.getFilterName());
			TreeTraversal.prune(root, filter);
		}
	}
	
	

}
