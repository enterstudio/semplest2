package semplest.dmoz.tree;

import java.io.FileInputStream;
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
		
		String dmozUrlFile = properties.getProperty("dmoz.urlFile");
		String dmozDescriptionFile = properties.getProperty("dmoz.descriptionFile");
		
		//Build DMOZ Tree
		System.out.println("Get Dmoz tree nodes.");
		final DmozTreeBuilder dmozTreeBuilder = new DmozTreeBuilder(dmozDescriptionFile,dmozUrlFile);
		dmozTreeBuilder.buildDmozTree();
		HashMap<String,DmozTreeNode> dmozTree = dmozTreeBuilder.getAllDmozEntries();
		
		//Batch and store the tree to database
		final List<Map<String,DmozTreeNode>> batches = SemplestUtils.getBatches(dmozTree, 5000);
		System.out.println("Going to store " + batches.size() + " batchs (of 5000 node entries) to DB.");
		Long counter = 0L;		
		for (final Map<String,DmozTreeNode> batch : batches)
		{			
			Long start = System.currentTimeMillis();
			System.out.println("Storing batch #" + counter + " to DB...");
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch.values()){
				if(node == null){
					continue;
				}
				Long nodeId = node.getNodeID();
				Long nodeParentId = node.getParentID();
				String nodeFullName = node.getFullName().replace("'", "''");
				String nodeDescription = node.getCategoryData() == null? null : (node.getCategoryData().getDescription() == null? null : node.getCategoryData().getDescription().replace("'", "''"));				
				
				String sqlDmoz = "INSERT INTO DMOZ(DmozNodePK,NodeText,ParentNodeID,NodeDescription) " +
						"VALUES("+ nodeId +",'" + nodeFullName + "'," + nodeParentId + ",'" + nodeDescription + "');";
				
				batchSql.add(sqlDmoz);
				
				if(node.getCategoryData() == null || node.getCategoryData().getUrls() == null){
					continue;
				}
				for(String url : node.getCategoryData().getUrls()){
					String sqlUrl = "INSERT INTO URLData(DmozNodeFK,URL,Level) " +
							"VALUES(" + nodeId + ",'" + url.replace("'", "''") + "'," + 1 + ");";
					batchSql.add(sqlUrl);
				}
			}
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}
	}	

}
