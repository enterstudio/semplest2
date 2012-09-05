package semplest.dmoz.tree;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.util.SemplestUtils;

public class DmozImporter extends BaseDB {
	
	private static Integer maxBatchSize = 5000;
	
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
		String categoryDescriptionFile = properties.getProperty("dmoz.descriptionFile");
		String categoryUrlsFile = properties.getProperty("dmoz.urlFile");		
		
		//Build DMOZ Tree
		System.out.println("Building Dmoz tree and getting all tree nodes...");
		final DmozTreeBuilder dmozTreeBuilder = new DmozTreeBuilder(categoryCidFile, categoryDescriptionFile, categoryUrlsFile);
		dmozTreeBuilder.buildDmozTree();
		List<DmozTreeNode> dmozTree = dmozTreeBuilder.getAllDmozNodes();
		
		//Store DMOZ tree to a file
		System.out.println("Storing Dmoz tree to file...");
		storeTreeToFile(dmozTree, dmozTreeFile);	
		
		System.out.println("Done.");
		
		//Batch and store the tree to database
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(dmozTree, maxBatchSize);
		System.out.println("Going to store " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to DB.");
		Long counter = 0L;		
		for (final List<DmozTreeNode> batch : batches)
		{			
			Long start = System.currentTimeMillis();
			System.out.println("Storing batch #" + counter + " to DB...");
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch){
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
				
				if(node.getCategoryData() == null || node.getCategoryData().getUrlsAndDescs() == null){
					continue;
				}
				for(String url : node.getCategoryData().getUrlsAndDescs().keySet()){
					String urlDesc = node.getCategoryData().getUrlsAndDescs().get(url);
					String sqlUrl = "INSERT INTO URLData(DmozNodeFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url.replace("'", "''") + "'," + 1 + "," + urlDesc + ");";
					batchSql.add(sqlUrl);
				}
			}
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}
	}	
	
	//helper methods
	private static void storeTreeToFile(List<DmozTreeNode> dmozTree, String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		writer.write("DmozNodePK|NodeText|ParentNodeID|NodeDescription\n");
		
		for(DmozTreeNode node : dmozTree){		
			writer.append(node.getNodeID() + "," 
						+ node.getFullName() + ","
						+ node.getParentID() + ","
						+ node.getCategoryData().getDescription() + "\n");
		}		
		
	}

}
