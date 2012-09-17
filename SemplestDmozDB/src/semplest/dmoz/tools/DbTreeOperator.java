package semplest.dmoz.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.DBType;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DbDmozObject;
import semplest.dmoz.tree.DbUrlDataObject;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFuncs;
import semplest.util.SemplestUtils;

public class DbTreeOperator extends BaseDB 
{
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	

	private static Integer maxBatchSize = 5000;	
	
	
	public static void addTreeNodes(DBType dbType, List<DmozTreeNode> newNodes) throws Exception
	{
		String treeTable = getTreeTableName(dbType);
		String urlDataTable = getUrlDataTableName(dbType);		
		
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(newNodes, maxBatchSize);
		System.out.println("Going to store " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to " + dbType.name() + ".");
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
				String sqlDmoz = "INSERT INTO " + treeTable + "(SemplestPK,DMOZCategoryID,NodeText,ParentNodeID,NodeDescription) " +
						"VALUES("+ nodeId +"," + nodeCategoryId + ",'" + nodeFullName + "'," + nodeParentId + ",'" + nodeDescription + "');";
				
				batchSql.add(sqlDmoz);
				
				//build sql statements for UrlData table
				for(String url : node.getCategoryData().getUrlData().keySet()){
					String urlDesc = node.getCategoryData().getUrlData().get(url).replace("'", "''");
					String sqlUrl = "INSERT INTO " + urlDataTable + "(SemplestFK,URL,Level,URLDescription) " +
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
	
	public static void deleteTreeNodes(DBType dbType, List<DmozTreeNode> nodes) throws Exception
	{
		String treeTable = getTreeTableName(dbType);
		String urlDataTable = getUrlDataTableName(dbType);	
		
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(nodes, maxBatchSize);
		System.out.println("Going to delete " + batches.size() + " batchs (of " + maxBatchSize + " node entries) from " + dbType.name() + ".");
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
				
				String sqlDmoz = "DELETE FROM " + treeTable + " WHERE SemplestPK = " + nodeId + ";";				
				batchSql.add(sqlDmoz);
				
				String sqlUrl = "DELETE FROM " + urlDataTable + " WHERE SemplestFK = " + nodeId + ";";
				batchSql.add(sqlUrl);				
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}		
	}
		
	public static void updateTreeNodes(DBType dbType, List<DmozTreeNode> nodes) throws Exception
	{
		String treeTable = getTreeTableName(dbType);
		
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(nodes, maxBatchSize);
		System.out.println("Going to update nodes for " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to " + dbType.name() + ".");
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
				
				String sqlDmoz = "UPDATE " + treeTable + " SET " +
						"SemplestPK = " + node.getNodeID()  + "," + 
						"ParentNodeID = " + node.getParentID() + "," + 		
						"DMOZCategoryID = " + node.getCategoryData().getCategoryId() + "," + 	
						"NodeDescription = '" + node.getCategoryData().getDescription().replace("'", "''") + "'" +
						" WHERE NodeText = '" + node.getName().replace("'", "''") + "';";				
				batchSql.add(sqlDmoz);			
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}		
	}
	
	public static void updateUrlData(DBType dbType, List<DmozTreeNode> nodes) throws Exception
	{
		String urlDataTable = getUrlDataTableName(dbType);	
		
		final List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(nodes, maxBatchSize);
		System.out.println("Going to update UrlData of nodes for " + batches.size() + " batchs (of " + maxBatchSize + " node entries) to " + dbType.name() + ".");
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
				
				String sqlDeleteOldUrls = "DELETE FROM " + urlDataTable + " WHERE SemplestFK = " + nodeId + ";";
				batchSql.add(sqlDeleteOldUrls);
				
				if(node.getCategoryData() == null || node.getCategoryData().getUrlData() == null){
					continue;
				}
				for(String url : node.getCategoryData().getUrlData().keySet()){
					String urlDesc = node.getCategoryData().getUrlData().get(url);
					String sqlAddNewUrls = "INSERT INTO " + urlDataTable + "(SemplestFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url.replace("'", "''") + "'," + 1 + ",'" + urlDesc.replace("'", "''") + "');";
					batchSql.add(sqlAddNewUrls);
				}	
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}	
	}
	
	private static RowMapper<DbDmozObject> dbDmozObjectMapper = new BeanPropertyRowMapper<DbDmozObject>(DbDmozObject.class);
	
	public static DmozTreeNode loadTreeFromDB(DBType dbType, String categoryName) throws Exception
	{
		String treeTable = getTreeTableName(dbType);
		String urlDataTable = getUrlDataTableName(dbType);		
		
		//Get the top node of the sub-tree from DB		
		String sql = "SELECT SemplestPK,NodeText,ParentNodeID,NodeDescription,DMOZCategoryID FROM " + treeTable + " WHERE NodeText = ?";
		DbDmozObject topNode = jdbcTemplate.query(sql, new Object[]{categoryName}, dbDmozObjectMapper).get(0);
		
		if(topNode == null){
			//the sub-node does not exist
			throw new Exception("The input node " + categoryName + " does not exist in the database of " + dbType.name() + ".");
		}
		
		System.out.println("Loading tree data from " + dbType.name() + " and building the tree...");
		
		DmozTreeNode dmozTree = new DmozTreeNode();
		dmozTree.setNodeID(topNode.getSemplestPK());
		dmozTree.setParentID(topNode.getParentNodeID());
		dmozTree.setName(topNode.getNodeText());
		dmozTree.setNodeDescription(topNode.getNodeDescription());
		
		//Build the tree
		setChildrenNodes(dmozTree, treeTable);
		
		System.out.println("Loading url data from " + dbType.name() + "...");
		//Set UrlData
		setUrlDataThroughTree(dmozTree, urlDataTable);
		
		System.out.println("Done.");
		
		return dmozTree;
	}	
	
	public static Long getUniqueIdBase(DBType dbType) throws Exception{
		String treeTable = getTreeTableName(dbType);
		String sql = "SELECT MAX(SemplestPK) FROM " + treeTable;
		Long maxIdInDB = jdbcTemplate.queryForLong(sql);
		
		return maxIdInDB + 1;
	}
	
	//helper methods
	private static void setChildrenNodes (DmozTreeNode currentNode, String treeTable) throws Exception{
		/*
		 * Set up children nodes of a node recursively. Thus build the tree.
		 */
		String sql = "SELECT SemplestPK,NodeText,ParentNodeID,NodeDescription,DMOZCategoryID FROM " + treeTable + " WHERE ParentNodeID = " + currentNode.getNodeID();
		List<DbDmozObject> childrenNodes = jdbcTemplate.query(sql, dbDmozObjectMapper);
		
		for(DbDmozObject childNode : childrenNodes){
			DmozTreeNode newNode = new DmozTreeNode();
			newNode.setNodeID(childNode.getSemplestPK());
			newNode.setParentID(childNode.getParentNodeID());
			newNode.setName(childNode.getNodeText());
			newNode.setNodeDescription(childNode.getNodeDescription());
			
			setChildrenNodes(newNode, treeTable);
			currentNode.addChildNode(newNode);						
		}
	}
	
	private static RowMapper<DbUrlDataObject> dbUrlDataObjectMapper = new BeanPropertyRowMapper<DbUrlDataObject>(DbUrlDataObject.class);
	private static void setUrlDataThroughTree(DmozTreeNode currentNode, String urlDataTable) throws Exception{
		/*
		 * get url data for each node from DB, and store to the tree.
		 */
		String sql = "SELECT UrlDataPK,SemplestFK,URL,URLDescription,Level,ParentURLDataID FROM " + urlDataTable + " WHERE SemplestFK = " + currentNode.getNodeID();
		List<DbUrlDataObject> urlsData = jdbcTemplate.query(sql, dbUrlDataObjectMapper);
		
		for(DbUrlDataObject urlData : urlsData){
			currentNode.addUrlData(urlData.getUrlDataPK(), urlData.getURL(), urlData.getURLDescription());			
		}
		
		for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
			setUrlDataThroughTree(childNode, urlDataTable);
		}
	}
	
	private static String getTreeTableName(DBType dbType) throws Exception{
		if(dbType.equals(DBType.DMOZ_TREE)){
			return "DMOZ";
		}
		else if(dbType.equals(DBType.SEMPLEST_TREE)){
			return "SemplestTree";
		}
		else{
			throw new Exception("Database specified is not available.");
		}
	}
	
	private static String getUrlDataTableName(DBType dbType) throws Exception{
		if(dbType.equals(DBType.DMOZ_TREE)){
			return "URLData";
		}
		else if(dbType.equals(DBType.SEMPLEST_TREE)){
			return "SemplestURLData";
		}
		else{
			throw new Exception("Database specified is not available.");
		}
	}
}
