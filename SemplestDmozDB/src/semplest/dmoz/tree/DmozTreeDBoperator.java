package semplest.dmoz.tree;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.util.SemplestUtils;

public class DmozTreeDBoperator extends BaseDB {
	
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
	
	private static Integer maxBatchSize = 1000;  //xnxn -change back to 5000 later
	
	public static void main(String[] args){
		try {
			//importDmozTreeToDB();
			DmozTreeNode dmozTree = loadDmozTreeFromDB();
			TreeFuncs.printTree("c:\\dmoz\\loadDbTree.txt", dmozTree);
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
		//for (final List<DmozTreeNode> batch : batches)  //xnxn -uncomment later
		//{			//uncomment later
			List<DmozTreeNode> batch = batches.get(0);  //xnxn -temp. delete later
		
			Long start = System.currentTimeMillis();
			System.out.println("Storing batch #" + counter + " to DB...");
			ArrayList<String> batchSql = new ArrayList<String>();
			for(DmozTreeNode node : batch){
				if(node == null){
					continue;
				}
				Long nodeId = node.getNodeID();
				Long nodeParentId = node.getParentID();
				Long nodeSemplestId = node.getCategoryData() == null? null : (node.getCategoryData().getCategoryId() == null? null : node.getCategoryData().getCategoryId());
				String nodeFullName = node.getName().replace("'", "''");
				String nodeDescription = node.getCategoryData() == null? null : (node.getCategoryData().getDescription() == null? null : node.getCategoryData().getDescription().replace("'", "''"));				
				
				String sqlDmoz = "INSERT INTO DMOZ(DmozNodePK,SemplestID,NodeText,ParentNodeID,NodeDescription) " +
						"VALUES("+ nodeId +"," + nodeSemplestId + ",'" + nodeFullName + "'," + nodeParentId + ",'" + nodeDescription + "');";
				
				batchSql.add(sqlDmoz);
				
				if(node.getCategoryData() == null || node.getCategoryData().getUrlData() == null){
					continue;
				}
				for(String url : node.getCategoryData().getUrlData().keySet()){
					String urlDesc = node.getCategoryData().getUrlData().get(url);
					String sqlUrl = "INSERT INTO URLData(DmozNodeFK,URL,Level,URLDescription) " +
							"VALUES(" + nodeId + ",'" + url.replace("'", "''") + "'," + 1 + "," + urlDesc + ");";
					batchSql.add(sqlUrl);
				}
			}
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
			System.out.println("	took " + (System.currentTimeMillis() - start)*1d/1000 + " secs.");
			counter++;
		//}  //uncomment later
	}	
	
	private static RowMapper<DbDmozObject> dbDmozObjectMapper = new BeanPropertyRowMapper<DbDmozObject>(DbDmozObject.class);
	public static DmozTreeNode loadDmozTreeFromDB(){
		
		System.out.println("Loading dmoz data from DB and building the tree...");
		//Get the top node of the tree from DB		
		String sql = "SELECT DmozNodePK,NodeText,ParentNodeID,NodeDescription,SemplestID FROM DMOZ WHERE ParentNodeID = -1";
		DbDmozObject topNode = jdbcTemplate.query(sql, dbDmozObjectMapper).get(0);
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
	
	//helper methods
	private static void setChildrenNodes (DmozTreeNode currentNode){
		/*
		 * Set up children nodes of a node recursively. Thus build the tree.
		 */
		String sql = "SELECT DmozNodePK,NodeText,ParentNodeID,NodeDescription,SemplestID FROM DMOZ WHERE ParentNodeID = " + currentNode.getNodeID();
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
	private static void setUrlDataThroughTree(DmozTreeNode currentNode){
		/*
		 * get url data for each node from DB, and store to the tree.
		 */
		String sql = "SELECT UrlDataPK,DmozNodeFK,URL,URLDescription,Level,ParentURLDataID FROM URLData WHERE DmozNodeFK = " + currentNode.getNodeID();
		List<DbUrlDataObject> urlsData = jdbcTemplate.query(sql, dbUrlDataObjectMapper);
		
		for(DbUrlDataObject urlData : urlsData){
			currentNode.addUrlData(urlData.getURL(), urlData.getURLDescription());
		}
		
		for(DmozTreeNode childNode : currentNode.getChildrenNodes().values()){
			setUrlDataThroughTree(childNode);
		}
	}
	
	private static void storeTreeToFile(List<DmozTreeNode> dmozTree, String path) throws Exception{
		FileWriter writer = new FileWriter(path);
		writer.write("DmozNodePK | NodeText | ParentNodeID | NodeDescription\n");
		
		for(DmozTreeNode node : dmozTree){		
			writer.append(node.getNodeID() + " | " 
						+ node.getName() + " | "
						+ node.getParentID() + " | "
						+ node.getCategoryData().getDescription() + "\n");
		}		
		
	}

}
