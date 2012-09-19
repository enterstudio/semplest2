package semplest.dmoz.tools;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.SemplestTreeMapDataObject;
import semplest.dmoz.tree.TreeFunctions;
import semplest.util.SemplestUtils;

public class DmozImporter
{	
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
		
		String errorLogFile = properties.getProperty("dmoz.errorLogPath");
		String dmozTreeFile = properties.getProperty("dmoz.treeFile");
		String categoryCidFile = properties.getProperty("dmoz.idFile");
		String categoryUrlDescsFile = properties.getProperty("dmoz.urlDescFile");		
		
		TreeFunctions.startLogError("ImportDmozTreeToDB", errorLogFile);
		
		//Build DMOZ Tree
		System.out.println("Building Dmoz tree and getting all tree nodes...");
		final DmozTreeBuilder dmozTreeBuilder = new DmozTreeBuilder(categoryCidFile, categoryUrlDescsFile);
		dmozTreeBuilder.buildDmozTree();
		DmozTreeNode dmozTree = dmozTreeBuilder.getTree();
		List<DmozTreeNode> dmozTreeNodes = TreeFunctions.getTreeInList(dmozTree);
		
		//Store DMOZ tree to a file
		System.out.println("Storing Dmoz tree to file...");
		TreeFunctions.storeTreeToFile(dmozTreeNodes, dmozTreeFile);	
		
		System.out.println("Done.");
		
		DbTreeOperator.addTreeNodes(dmozTreeNodes);
		
		TreeFunctions.endLogError();
	}

}
