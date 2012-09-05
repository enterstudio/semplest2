package semplest.dmoz.tree;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.util.SemplestUtils;

public class DmozImporter extends BaseDB {
	
	public static void main(String[] args){
		try {
			importDmozTreeToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void importDmozTreeToDB() throws Exception{		
		//Read property file for dmoz files paths
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("bin/system.properties");
		properties.load(in);
		in.close();
		
		String dmozTreeFile = properties.getProperty("dmoz.treeFile");
		String categoryCidFile = properties.getProperty("dmoz.idFile");
		String categoryDescriptionFile = properties.getProperty("dmoz.urlFile");
		String categoryUrlsFile = properties.getProperty("dmoz.descriptionFile");		
		
		//Build DMOZ Tree
		System.out.println("Building Dmoz tree and getting all tree nodes...");
		final DmozTreeBuilder dmozTreeBuilder = new DmozTreeBuilder(categoryCidFile, categoryDescriptionFile, categoryUrlsFile);
		dmozTreeBuilder.buildDmozTree();
		List<DmozTreeNode> dmozTree = dmozTreeBuilder.getAllDmozNodes();
		
		//Store DMOZ tree to a file
		System.out.println("Storing Dmoz tree to file...");
		storeTreeToFile(dmozTree, dmozTreeFile);		
	}	
	
	//helper methods
	private static void storeTreeToFile(List<DmozTreeNode> dmozTree, String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		writer.write("DmozNodePK,SemplestID,NodeText,ParentNodeID,NodeDescription\n");
		/*
		for(DmozTreeNode node : dmozTree){		
			writer.append(node.getNodeID() + "," 
						+ node.getCategoryData().getCategoryId() + "," 
						+ node.getFullName() + ","
						+ node.getParentID() + ","
						+ node.getCategoryData().getDescription() + "\n");
		}
		*/
		
		for(int i = 0; i < 100; i++){
			String desc = dmozTree.get(i).getCategoryData() == null? null :  dmozTree.get(i).getCategoryData().getDescription();
			Long id = dmozTree.get(i).getCategoryData() == null? null : dmozTree.get(i).getCategoryData().getCategoryId();
			writer.append(dmozTree.get(i).getNodeID() + "," 
					+ id + "," 
					+ dmozTree.get(i).getFullName() + ","
					+ dmozTree.get(i).getParentID() + ","
					+ desc + "\n");
		}
		
		writer.close();		
	}

}
