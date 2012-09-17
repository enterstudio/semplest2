package semplest.dmoz.test;

import java.util.ArrayList;
import java.util.HashMap;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DmozTreeBuilder;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.process.AllNodesUrlNumProcesser;
import semplest.dmoz.tree.process.EmptyNodesProcesser;
import semplest.dmoz.tree.process.MergeLeafNodesProcesser;
import semplest.dmoz.tree.process.CountLeafNodesUrlProcesser;
import semplest.dmoz.tree.process.MergeMiddleNodesProcesser;

public class testTree extends BaseDB {
	
	public ArrayList<DmozTreeNode> sqlBatch = new ArrayList<DmozTreeNode>();
	
	public static void main(String[] args){
		try{
			DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
			treeBuilder.buildDmozTree();
			DmozTreeNode dmozTree = treeBuilder.getTree();
			//List<DmozTreeNode> allNodes = treeBuilder.getAllDmozNodes();
			//TreeFunctions.printTree("c:\\dmoz\\dmoz.tree", dmozTree);
			
			
			/*
			MergeLeafNodesProcesser leafNodesMerger = new MergeLeafNodesProcesser();
			leafNodesMerger.analyzeTree(dmozTree);
			leafNodesMerger.printReport("c:\\dmoz\\SplitLeafNodesReport.txt");
			*/
			/*
			MergeMiddleNodesProcesser middleNodesMerger = new MergeMiddleNodesProcesser();
			middleNodesMerger.analyzeTree(dmozTree);
			middleNodesMerger.printReport("c:\\dmoz\\SplitMiddleNodesReport.txt");
			*/
			/*
			CountLeafNodesUrlProcesser leafNodesUrl = new CountLeafNodesUrlProcesser();
			leafNodesUrl.analyzeTree(dmozTree);
			leafNodesUrl.printReport("c:\\dmoz\\LeafNodesUrls.txt");
			*/
			/*
			EmptyNodesProcesser emptyNodes = new EmptyNodesProcesser();
			emptyNodes.analyzeTree(dmozTree);
			emptyNodes.printReport("c:\\dmoz\\EmptyNodes.txt");
			*/
			/*
			AllNodesUrlNumProcesser allNodesUrl = new AllNodesUrlNumProcesser();
			allNodesUrl.analyzeTree(dmozTree);
			allNodesUrl.printReport("c:\\dmoz\\AllNodesUrlCount.txt");
			*/
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
