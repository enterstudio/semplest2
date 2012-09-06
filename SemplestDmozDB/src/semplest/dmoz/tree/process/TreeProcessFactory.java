package semplest.dmoz.tree.process;

public class TreeProcessFactory {
	
	public static TreeProcesserInterface getTreeProcessor(TreeProcessorType type) throws Exception {
		
		TreeProcesserInterface processor = null;
		if(type.equals(TreeProcessorType.URL_COUNT_TREE)){
			processor = new AllNodesUrlNumProcesser();
		} else {
			throw new Exception("[TreeProcessFactory]: Type "+type.name()+" not yet implemented!");
		}
		return processor;	
	}
}
