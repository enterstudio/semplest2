package semplest.dmoz.test;

import java.util.ArrayList;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DmozTreeBuilder;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.process.EmptyNodesProcesser;
import semplest.dmoz.tree.process.MergeLeafNodesProcesser;
import semplest.dmoz.tree.process.CountLeafNodesUrlProcesser;
import semplest.dmoz.tree.process.MergeMiddleNodesProcesser;

public class testTree extends BaseDB {
	
	public ArrayList<DmozTreeNode> sqlBatch = new ArrayList<DmozTreeNode>();
	
	public static void main(String[] args){
		try{
			DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
			treeBuilder.buildAndGetAllDmozTreeNodes();
			DmozTreeNode dmozTree = treeBuilder.getTree();
			
			/*
			MergeLeafNodesProcesser leafNodesMerger = new MergeLeafNodesProcesser();
			leafNodesMerger.analyzeTree(dmozTree);
			leafNodesMerger.outputReport("c:\\dmoz\\AnalyzeLeafNodesReport.txt");
			*/
			/*
			MergeMiddleNodesProcesser middleNodesMerger = new MergeMiddleNodesProcesser();
			middleNodesMerger.analyzeTree(dmozTree);
			middleNodesMerger.outputReport("c:\\dmoz\\AnalyzeMiddleNodesReport.txt");
			*/
			/*
			CountLeafNodesUrlProcesser leafNodesUrl = new CountLeafNodesUrlProcesser();
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
