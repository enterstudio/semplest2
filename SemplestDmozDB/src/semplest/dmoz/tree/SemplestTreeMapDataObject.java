package semplest.dmoz.tree;

import java.util.HashSet;
import java.util.Set;

public class SemplestTreeMapDataObject {
	private Long OriginalParentNodeID;
	private Set<Long> SemplestUrlDataIDs = new HashSet<Long>();
	
	public void addSemplestUrlDataID(Long SemplestUrlDataID){
		SemplestUrlDataIDs.add(SemplestUrlDataID);
	}
	public void addSemplestUrlDataIDs(Set<Long> semplestUrlDataIDs){
		SemplestUrlDataIDs.addAll(semplestUrlDataIDs);
	}
	public Set<Long> getSemplestUrlDataIDs() {
		return SemplestUrlDataIDs;
	}
	public void setSemplestUrlDataIDs(HashSet<Long> semplestUrlDataIDs) {
		SemplestUrlDataIDs = semplestUrlDataIDs;
	}
	public Long getOriginalParentNodeID() {
		return OriginalParentNodeID;
	}
	public void setOriginalParentNodeID(Long originalParentNodeID) {
		OriginalParentNodeID = originalParentNodeID;
	}
}
