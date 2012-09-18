package semplest.dmoz.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import semplest.dmoz.DBType;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DbTreeNodeObject;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
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
				TreeFunctions.logError(e.getMessage());
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
	
	private static RowMapper<DbTreeNodeObject> dbTreeNodeObjectMapper = new BeanPropertyRowMapper<DbTreeNodeObject>(DbTreeNodeObject.class);
	
	public static DmozTreeNode loadTreeFromDB(DBType dbType, String categoryName) throws Exception
	{
		String treeTable = getTreeTableName(dbType);
		String urlDataTable = getUrlDataTableName(dbType);
		
		String sql;
		//get the top node of the sub-tree
		sql = "SELECT SemplestPK,ParentNodeID,NodeText,URL,URLDescription FROM " + treeTable + " t " +
				"LEFT JOIN " + urlDataTable + " u ON t.SemplestPK = u.SemplestFK " +
				"WHERE t.NodeText = ?";
		List<DbTreeNodeObject> topNodeList = jdbcTemplate.query(sql, new Object[]{categoryName}, dbTreeNodeObjectMapper);
		if(topNodeList == null){
			//the sub-node does not exist
			throw new Exception("The input node " + categoryName + " does not exist in the database of " + dbType.name() + ".");
		}
		DmozTreeNode topNode = new DmozTreeNode();
		topNode.fromDbTreeNodeObject(topNodeList.get(0));
		
		//get all the nodes of the sub-tree
		String childrenNodesPattern = categoryName + "/%";
		sql = "SELECT SemplestPK,ParentNodeID,NodeText,URL,URLDescription FROM " + treeTable + " t " +
				"LEFT JOIN " + urlDataTable + " u ON t.SemplestPK = u.SemplestFK " +
				"WHERE t.NodeText like ?";
		List<DbTreeNodeObject> subDbNodes = jdbcTemplate.query(sql, new Object[]{childrenNodesPattern}, dbTreeNodeObjectMapper);		
		
		//make it a map, easier to process
		Map<Long,HashMap<String,DmozTreeNode>> subTreeNodes = new HashMap<Long,HashMap<String,DmozTreeNode>>();
		for(DbTreeNodeObject dbNode : subDbNodes){		
			String nodeName = dbNode.getNodeText();
			Long parentID = dbNode.getParentNodeID();		
			if(subTreeNodes.containsKey(parentID)){
				HashMap<String,DmozTreeNode> nodesMap = subTreeNodes.get(parentID);
				DmozTreeNode node;
				if(nodesMap.containsKey(nodeName)){
					//the node is already there, just need to add url to it.
					node = nodesMap.get(nodeName);
					node.addUrlData(dbNode.getURL(), dbNode.getURLDescription());
				}
				else{
					node = new DmozTreeNode();
					node.fromDbTreeNodeObject(dbNode);
				}
				nodesMap.put(nodeName, node);
				subTreeNodes.put(parentID, nodesMap);
			}
			else{
				HashMap<String,DmozTreeNode> newMap = new HashMap<String,DmozTreeNode>();
				DmozTreeNode newNode = new DmozTreeNode();
				newNode.fromDbTreeNodeObject(dbNode);
				newMap.put(newNode.getName(), newNode);
				subTreeNodes.put(parentID, newMap);
			}
		}		
		
		//process the nodes and build the tree
		setChildrenNodes(topNode,subTreeNodes);
		
		return topNode;
	}
	
	//helper method
	private static void setChildrenNodes(DmozTreeNode currentNode, Map<Long,HashMap<String,DmozTreeNode>> allNodes){
		Long nodeId = currentNode.getNodeID();
		if(allNodes.containsKey(nodeId)){
			currentNode.setChildrenNodes(allNodes.get(nodeId));
			for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
				setChildrenNodes(childNode,allNodes);
			}
		}		
	}
	
	public static Long getUniqueIdBase(DBType dbType) throws Exception{
		String treeTable = getTreeTableName(dbType);
		String sql = "SELECT MAX(SemplestPK) FROM " + treeTable;
		Long maxIdInDB = jdbcTemplate.queryForLong(sql);
		
		return maxIdInDB + 1;
	}
	
	public static String getTreeTableName(DBType dbType) throws Exception{
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
	
	public static String getUrlDataTableName(DBType dbType) throws Exception{
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
	
	//main
	public static void main(String[] args){
		try {
			System.out.println("start...");
			Long start = System.currentTimeMillis();
			DmozTreeNode dmozTree =  loadTreeFromDB(DBType.DMOZ_TREE,"top");
			System.out.println(System.currentTimeMillis()-start);
			
			TreeFunctions.printTree(dmozTree, "c:\\dmoz\\tempOutput.txt");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
