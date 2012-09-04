package semplest.dmoz.test;

import java.util.ArrayList;

import semplest.dmoz.process.EmptyNodesProcesser;
import semplest.dmoz.process.LeafNodesMergeProcesser;
import semplest.dmoz.process.LeafNodesUrlProcesser;
import semplest.dmoz.process.MiddleNodesMergeProcesser;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DmozTreeBuilder;
import semplest.dmoz.tree.DmozTreeNode;

public class testTree extends BaseDB {
	
	public ArrayList<DmozTreeNode> sqlBatch = new ArrayList<DmozTreeNode>();
	
	public static void main(String[] args){
		try{
			DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
			treeBuilder.buildAndGetAllDmozTreeNodes();
			DmozTreeNode dmozTree = treeBuilder.getTree();
			
			/*
			LeafNodesMergeProcesser leafNodesMerger = new LeafNodesMergeProcesser();
			leafNodesMerger.analyzeTree(dmozTree);
			leafNodesMerger.outputReport("c:\\dmoz\\AnalyzeLeafNodesReport.txt");
			*/
			/*
			MiddleNodesMergeProcesser middleNodesMerger = new MiddleNodesMergeProcesser();
			middleNodesMerger.analyzeTree(dmozTree);
			middleNodesMerger.outputReport("c:\\dmoz\\AnalyzeMiddleNodesReport.txt");
			*/
			/*
			LeafNodesUrlProcesser leafNodesUrl = new LeafNodesUrlProcesser();
			leafNodesUrl.analyzeTree(dmozTree);
			leafNodesUrl.outputReport("c:\\dmoz\\LeafNodesUrls.txt");
			*/
			
			EmptyNodesProcesser emptyNodes = new EmptyNodesProcesser();
			emptyNodes.analyzeTree(dmozTree);
			emptyNodes.outputReport("c:\\dmoz\\EmptyNodes.txt");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
