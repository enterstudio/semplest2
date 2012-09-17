package semplest.dmoz.tools;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DbDmozObject;
import semplest.dmoz.tree.DbUrlDataObject;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.SemplestTreeMapDataObject;
import semplest.dmoz.tree.TreeFuncs;
import semplest.util.SemplestUtils;

public class DmozDbOperator extends BaseDB {
	
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
	
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
		
		String errorLogFile = properties.getProperty("dmoz.errorLogPath");
		String dmozTreeFile = properties.getProperty("dmoz.treeFile");
		String categoryCidFile = properties.getProperty("dmoz.idFile");
		String categoryUrlDescsFile = properties.getProperty("dmoz.urlDescFile");		
		
		TreeFuncs.startLogError("ImportDmozTreeToDB", errorLogFile);
		
		//Build DMOZ Tree
		System.out.println("Building Dmoz tree and getting all tree nodes...");
		final DmozTreeBuilder dmozTreeBuilder = new DmozTreeBuilder(categoryCidFile, categoryUrlDescsFile);
		dmozTreeBuilder.buildDmozTree();
		DmozTreeNode dmozTree = dmozTreeBuilder.getTree();
		List<DmozTreeNode> dmozTreeNodes = TreeFuncs.getTreeInList(dmozTree);
		
		//Store DMOZ tree to a file
		System.out.println("Storing Dmoz tree to file...");
		TreeFuncs.storeTreeToFile(dmozTreeNodes, dmozTreeFile);	
		
		System.out.println("Done.");
		
		addTreeNodes(dmozTreeNodes);
		
		TreeFuncs.endLogError();
	}	
	
	private static RowMapper<DbDmozObject> dbDmozObjectMapper = new BeanPropertyRowMapper<DbDmozObject>(DbDmozObject.class);
	
	public static DmozTreeNode loadDmozTreeFromDB(String categoryName) throws Exception{
		
		System.out.println("Loading dmoz data from DB and building the tree...");
		//Get the top node of the sub-tree from DB		
		String sql = "SELECT DmozNodePK,NodeText,ParentNodeID,NodeDescription,CategoryID FROM DMOZ WHERE NodeText = ?";
		DbDmozObject topNode = jdbcTemplate.query(sql, new Object[]{categoryName}, dbDmozObjectMapper).get(0);
		
		if(topNode == null){
			//the sub-node does not exist
			throw new Exception("The input node " + categoryName + " does not exist in the database.");
		}
		
		DmozTreeNode dmozTree = new DmozTreeNode();
		dmozTree.setNodeID(topNode.getDmozNodePK());
		dmozTree.setParentID(topNode.getParentNodeID());
		dmozTree.setName(topNode.getNodeText());
		dmozTree.setNodeDescription(topNode.getNodeDescription());
		
		//Build the tree
		setChildrenNodes(dmozTree);
		
		System.out.println("Loading url data from DB...");
		//Set UrlData
		setUrlDataThroughTree(dmozTree);
		
		System.out.println("Done.");
		
		return dmozTree;
	}	
	
	public static void addTreeNodes(List<DmozTreeNode> newNodes) throws Exception{
		
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(newNodes, maxBatchSize);
		System.out.println("Going to store " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to DB.");
		Long counter = 0L;		
		for (final List<DmozTreeNode> batch : batches)
		{		
			Long start = System.currentTimeMillis();
			System.out.println("Storing batch #" + counter + " to DB...");
			
			//form sql statement for the batch
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch){
				if(node == null){
					continue;
				}
				Long nodeId = node.getNodeID();
				Long nodeParentId = node.getParentID();
				Long nodeCategoryId = node.getCategoryData() == null? null : (node.getCategoryData().getCategoryId() == null? null : node.getCategoryData().getCategoryId());
				String nodeFullName = node.getName().replace("'", "''");
				String nodeDescription = node.getCategoryData() == null? null : (node.getCategoryData().getDescription() == null? null : node.getCategoryData().getDescription().replace("'", "''"));				
				
				//build sql statement for DMOZ table
				String sqlDmoz = "INSERT INTO DMOZ(DmozNodePK,CategoryID,NodeText,ParentNodeID,NodeDescription) " +
						"VALUES("+ nodeId +"," + nodeCategoryId + ",'" + nodeFullName + "'," + nodeParentId + ",'" + nodeDescription + "');";
				
				batchSql.add(sqlDmoz);
				
				//build sql statements for UrlData table
				for(String url : node.getCategoryData().getUrlData().keySet()){
					String urlDesc = node.getCategoryData().getUrlData().get(url).replace("'", "''");
					String sqlUrl = "INSERT INTO URLData(DmozNodeFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url.replace("'", "''") + "'," + 1 + ",'" + urlDesc + "');";
					batchSql.add(sqlUrl);
				}
			}
			try{
				jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			}catch(Exception e){
				e.printStackTrace();
				TreeFuncs.logError(e.getMessage());
			}
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}		
	}
	
	public static void deleteTreeNodes(List<DmozTreeNode> nodes) throws Exception{
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(nodes, maxBatchSize);
		System.out.println("Going to delete " + batches.size() + " batchs (of " + maxBatchSize + " node entries) from DB.");
		Long counter = 0L;		
		for (final List<DmozTreeNode> batch : batches)
		{		
			Long start = System.currentTimeMillis();
			System.out.println("Deleting batch #" + counter + "...");
			
			//form sql statements for the batch
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch){
				if(node == null){
					continue;
				}
				Long nodeId = node.getNodeID();	
				
				String sqlDmoz = "DELETE FROM DMOZ WHERE DmozNodePK = " + nodeId + ";";				
				batchSql.add(sqlDmoz);
				
				String sqlUrl = "DELETE FROM URLData WHERE DmozNodeFK = " + nodeId + ";";
				batchSql.add(sqlUrl);				
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}		
	}
		
	public static void updateTreeNodes(List<DmozTreeNode> nodes) throws Exception{
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(nodes, maxBatchSize);
		System.out.println("Going to update nodes for " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to DB.");
		Long counter = 0L;		
		for (final List<DmozTreeNode> batch : batches)
		{		
			Long start = System.currentTimeMillis();
			System.out.println("Updating batch #" + counter + "...");
			
			//form sql statements for the batch
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch){
				if(node == null){
					continue;
				}
				
				String sqlDmoz = "UPDATE DMOZ SET " +
						"DmozNodePK = " + node.getNodeID()  + "," + 
						"ParentNodeID = " + node.getParentID() + "," + 		
						"CategoryID = " + node.getCategoryData().getCategoryId() + "," + 	
						"NodeDescription = '" + node.getCategoryData().getDescription().replace("'", "''") + "'" +
						" WHERE NodeText = '" + node.getName().replace("'", "''") + "';";				
				batchSql.add(sqlDmoz);			
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}		
	}
	
	public static void updateUrlData(List<DmozTreeNode> nodes) throws Exception{
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(nodes, maxBatchSize);
		System.out.println("Going to update UrlData of nodes for " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to DB.");
		Long counter = 0L;		
		for (final List<DmozTreeNode> batch : batches)
		{		
			Long start = System.currentTimeMillis();
			System.out.println("Updating batch #" + counter + "...");
			
			//form sql statements for the batch
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch){
				if(node == null){
					continue;
				}
				Long nodeId = node.getNodeID();	
				
				String sqlDeleteOldUrls = "DELETE FROM URLData WHERE DmozNodeFK = " + nodeId + ";";
				batchSql.add(sqlDeleteOldUrls);
				
				if(node.getCategoryData() == null || node.getCategoryData().getUrlData() == null){
					continue;
				}
				for(String url : node.getCategoryData().getUrlData().keySet()){
					String urlDesc = node.getCategoryData().getUrlData().get(url);
					String sqlAddNewUrls = "INSERT INTO URLData(DmozNodeFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url.replace("'", "''") + "'," + 1 + ",'" + urlDesc.replace("'", "''") + "');";
					batchSql.add(sqlAddNewUrls);
				}	
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}	
	}
	
	public static Long getUniqueIdBase() throws Exception{
		String sql = "SELECT MAX(DmozNodePK) FROM DMOZ";
		Long maxIdInDB = jdbcTemplate.queryForLong(sql);
		
		return maxIdInDB + 100;
	}
	
	//helper methods
	private static void setChildrenNodes (DmozTreeNode currentNode) throws Exception{
		/*
		 * Set up children nodes of a node recursively. Thus build the tree.
		 */
		String sql = "SELECT DmozNodePK,NodeText,ParentNodeID,NodeDescription,CategoryID FROM DMOZ WHERE ParentNodeID = " + currentNode.getNodeID();
		List<DbDmozObject> childrenNodes = jdbcTemplate.query(sql, dbDmozObjectMapper);
		
		for(DbDmozObject childNode : childrenNodes){
			DmozTreeNode newNode = new DmozTreeNode();
			newNode.setNodeID(childNode.getDmozNodePK());
			newNode.setParentID(childNode.getParentNodeID());
			newNode.setName(childNode.getNodeText());
			newNode.setNodeDescription(childNode.getNodeDescription());
			
			setChildrenNodes(newNode);
			currentNode.addChildNode(newNode);						
		}
	}
	
	private static RowMapper<DbUrlDataObject> dbUrlDataObjectMapper = new BeanPropertyRowMapper<DbUrlDataObject>(DbUrlDataObject.class);
	private static void setUrlDataThroughTree(DmozTreeNode currentNode) throws Exception{
		/*
		 * get url data for each node from DB, and store to the tree.
		 */
		String sql = "SELECT UrlDataPK,DmozNodeFK,URL,URLDescription,Level,ParentURLDataID FROM URLData WHERE DmozNodeFK = " + currentNode.getNodeID();
		List<DbUrlDataObject> urlsData = jdbcTemplate.query(sql, dbUrlDataObjectMapper);
		
		for(DbUrlDataObject urlData : urlsData){
			currentNode.addUrlData(urlData.getUrlDataPK(), urlData.getURL(), urlData.getURLDescription());			
		}
		
		for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
			setUrlDataThroughTree(childNode);
		}
	}

}
