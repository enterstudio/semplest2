package semplest.dmoz.pruning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import semplest.dmoz.tools.DmozTreeBuilder;
import semplest.dmoz.tree.DmozTreeNode;

public class ConvertDmozToSemplestExample {

	public static void main(String[] args){
		DmozTreeNode dmozTree = null; 
		DmozToSemplestTreeConverter dmozToSemplestConv;
		
		try{
			DmozTreeBuilder treeBuilder = new DmozTreeBuilder();
			treeBuilder.buildDmozTree();
			dmozTree = treeBuilder.getTree();


			dmozToSemplestConv = new DmozToSemplestTreeConverter(dmozTree);
			Set<DmozToSemplestFilter> filterSet = new HashSet<DmozToSemplestFilter>();

			BufferedWriter out=null;


			// add filter to remove top/regional
			filterSet.add(new RegionalRemovalFilter(null));



		// add filter leaf node 
			out = new BufferedWriter(new FileWriter("C:/Users/ssom/Dmoz/TreeAnalysis/CharDigLeafNode.txt"));
			filterSet.add(new CharDigLeafFilter(out));


			// add filter to merge up data from north america and us nodes 
			out = new BufferedWriter(new FileWriter("C:/Users/ssom/Dmoz/TreeAnalysis/NorthAmericaUSMerge.txt"));
			filterSet.add(new NorthAmericaUSMergingFilter(out));


			// add filter to bypass charcter digit intermediate nodes 
			out = new BufferedWriter(new FileWriter("C:/Users/ssom/Dmoz/TreeAnalysis/MiddleCharDigBypass.txt"));
			filterSet.add(new MiddleCharDigNodeBypassFilter(out));

			dmozToSemplestConv.setFilterSet(filterSet);

			//dmozToSemplestConv.analyze();
			dmozToSemplestConv.prune();
			// dmozToSemplestConv.getTree();


			// close all files
			for(DmozToSemplestFilter f : dmozToSemplestConv.getFilterSet()){

				out = f.getFileHandler();
				if(out!=null){
					out.close();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
