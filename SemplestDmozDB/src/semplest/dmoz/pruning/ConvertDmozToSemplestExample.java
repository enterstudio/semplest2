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
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		dmozToSemplestConv = new DmozToSemplestTreeConverter(dmozTree);
		Set<DmozToSemplestFilter> filterSet = new HashSet<DmozToSemplestFilter>();
		
		
		
		// add filter to remove top/regional
		filterSet.add(new RegionalRemovalFilter(null));
		
			
		// add filter leaf node 
		try{
			// Create file 
			FileWriter fstream = new FileWriter("C:/Users/ssom/Dmoz/TreeAnalysis/CharDigLeafNode.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			filterSet.add(new CharDigLeafFilter(out));
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		
		// add filter to merge up data from north america and us nodes 
		try{
			// Create file 
			FileWriter fstream = new FileWriter("C:/Users/ssom/Dmoz/TreeAnalysis/NorthAmericaUSMerge.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			filterSet.add(new NorthAmericaUSMergingFilter(out));
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
		
		// add filter to bypass charcter digit intermediate nodes 
		try{
			// Create file 
			FileWriter fstream = new FileWriter("C:/Users/ssom/Dmoz/TreeAnalysis/MiddleCharDigBypass.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			filterSet.add(new MiddleCharDigNodeBypassFilter(out));
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		

		dmozToSemplestConv.setFilterSet(filterSet);
				
		try{
			dmozToSemplestConv.analyze();
			//dmozToSemplestConv.prune();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		// close all files
		for(DmozToSemplestFilter f : dmozToSemplestConv.getFilterSet()){
			try {
				BufferedWriter out = f.getFileHandler();
				if(out!=null){
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
