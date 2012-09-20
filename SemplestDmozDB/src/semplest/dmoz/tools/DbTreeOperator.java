package semplest.dmoz.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DbTreeNodeObject;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.UrlDataObject;
import semplest.util.SemplestUtils;

public class DbTreeOperator extends BaseDB 
{
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	

	private static Integer maxBatchSize = 5000;	
	
	
	public static void addTreeNodes(List<DmozTreeNode> newNodes) throws Exception
	{		
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
				String sqlDmoz = "INSERT INTO DMOZ(SemplestPK,DMOZCategoryID,NodeText,ParentNodeID,NodeDescription) " +
						"VALUES("+ nodeId +"," + nodeCategoryId + ",'" + nodeFullName + "'," + nodeParentId + ",'" + nodeDescription + "');";
				
				batchSql.add(sqlDmoz);
				
				//build sql statements for UrlData table
				for(UrlDataObject urlData : node.getCategoryData().getUrlData()){
					String url = urlData.getUrl().replace("'", "''");
					String urlDesc = urlData.getUrlDescription().replace("'", "''");
					String sqlUrl = "INSERT INTO URLData(SemplestFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url + "'," + 1 + ",'" + urlDesc + "');";
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
	
	public static void deleteTreeNodes(List<DmozTreeNode> nodes) throws Exception
	{		
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
				
				String sqlDmoz = "DELETE FROM DMOZ WHERE SemplestPK = " + nodeId + ";";				
				batchSql.add(sqlDmoz);
				
				String sqlUrl = "DELETE FROM URLData WHERE SemplestFK = " + nodeId + ";";
				batchSql.add(sqlUrl);				
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}		
	}
		
	public static void updateTreeNodes(List<DmozTreeNode> nodes) throws Exception
	{		
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
	
	public static void updateUrlData(List<DmozTreeNode> nodes) throws Exception
	{		
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
				
				String sqlDeleteOldUrls = "DELETE FROM URLData WHERE SemplestFK = " + nodeId + ";";
				batchSql.add(sqlDeleteOldUrls);
				
				if(node.getCategoryData() == null || node.getCategoryData().getUrlData() == null){
					continue;
				}
				for(UrlDataObject urlData : node.getCategoryData().getUrlData()){
					String url = urlData.getUrl().replace("'", "''");
					String urlDesc = urlData.getUrlDescription().replace("'", "''");
					String sqlAddNewUrls = "INSERT INTO URLData(SemplestFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url + "'," + 1 + ",'" + urlDesc + "');";
					batchSql.add(sqlAddNewUrls);
				}	
			}
			
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		}	
	}
	
	private static RowMapper<DbTreeNodeObject> dbTreeNodeObjectMapper = new BeanPropertyRowMapper<DbTreeNodeObject>(DbTreeNodeObject.class);
	
	public static DmozTreeNode loadTreeFromDB(String categoryName) throws Exception
	{		
		String sql;
		//get the top node of the sub-tree
		sql = "SELECT SemplestPK,ParentNodeID,NodeText,UrlDataPK,URL,URLDescription FROM DMOZ t " +
				"LEFT JOIN URLData u ON t.SemplestPK = u.SemplestFK " +
				"WHERE t.NodeText = ?";
		List<DbTreeNodeObject> topNodeList = jdbcTemplate.query(sql, new Object[]{categoryName}, dbTreeNodeObjectMapper);
		if(topNodeList == null){
			//the sub-node does not exist
			throw new Exception("The input node " + categoryName + " does not exist in the database.");
		}
		DmozTreeNode topNode = new DmozTreeNode();
		topNode.fromDbTreeNodeObject(topNodeList.get(0));
		
		//get all the nodes of the sub-tree
		System.out.println("Getting tree data and Url data belong to node " + categoryName + " from database.");
		
		String childrenNodesPattern = categoryName + "/%";
		sql = "SELECT SemplestPK,ParentNodeID,NodeText,UrlDataPK,URL,URLDescription FROM DMOZ t " +
				"LEFT JOIN URLData u ON t.SemplestPK = u.SemplestFK " +
				"WHERE t.NodeText like ?";
		List<DbTreeNodeObject> subDbNodes = jdbcTemplate.query(sql, new Object[]{childrenNodesPattern}, dbTreeNodeObjectMapper);		
		
		System.out.println("Processing data and building the tree...");
		//make it a map, easier to process
		Map<Long,Map<String,DmozTreeNode>> subTreeNodes = new HashMap<Long,Map<String,DmozTreeNode>>();
		for(DbTreeNodeObject dbNode : subDbNodes){		
			String nodeName = dbNode.getNodeText();
			Long parentID = dbNode.getParentNodeID();		
			if(subTreeNodes.containsKey(parentID)){
				Map<String,DmozTreeNode> nodesMap = subTreeNodes.get(parentID);
				DmozTreeNode node;
				if(nodesMap.containsKey(nodeName)){
					//the node is already there, just need to add url to it.
					node = nodesMap.get(nodeName);
					if(dbNode.getURL() != null){						
						node.addUrlData(dbNode.getUrlDataPK(), dbNode.getURL(), dbNode.getURLDescription());
					}										
				}
				else{
					node = new DmozTreeNode();
					node.fromDbTreeNodeObject(dbNode);
				}
				nodesMap.put(nodeName, node);
				subTreeNodes.put(parentID, nodesMap);
			}
			else{
				Map<String,DmozTreeNode> newMap = new HashMap<String,DmozTreeNode>();
				DmozTreeNode newNode = new DmozTreeNode();
				newNode.fromDbTreeNodeObject(dbNode);
				newMap.put(newNode.getName(), newNode);
				subTreeNodes.put(parentID, newMap);
			}
		}		
		
		//process the nodes and build the tree
		setChildrenNodes(topNode,subTreeNodes);
		
		System.out.println("Done.");		
		return topNode;
	}
	
	//helper method
	private static void setChildrenNodes(DmozTreeNode currentNode, Map<Long,Map<String,DmozTreeNode>> allNodes){
		Long nodeId = currentNode.getNodeID();
		if(allNodes.containsKey(nodeId)){
			currentNode.setChildrenNodes(allNodes.get(nodeId));
			for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
				setChildrenNodes(childNode,allNodes);
			}
		}		
	}
	
	public static Long getUniqueIdBase() throws Exception{
		String sql = "SELECT MAX(SemplestPK) FROM DMOZ";
		Long maxIdInDB = jdbcTemplate.queryForLong(sql);
		
		return maxIdInDB + 1;
	}
	
	//main
	public static void main(String[] args){
		try {
			System.out.println("start...");
			Long start = System.currentTimeMillis();
			DmozTreeNode dmozTree =  loadTreeFromDB("top");
			System.out.println(System.currentTimeMillis()-start);
			
			TreeFunctions.printTree(dmozTree, "c:\\dmoz\\tempOutput.txt");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
