package semplest.dmoz;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.util.SemplestUtils;

public class DmozDB extends BaseDB{

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	
	public static Integer getParentNodeID(Integer nodeId) throws Exception{		
		String sql = "SELECT ParentNodeID FROM DMOZ WHERE DmozNodePK = ?";
		
		Integer parentNodeId = jdbcTemplate.queryForInt(sql, new Object[]
				{nodeId});
		
		return parentNodeId;
	}
	
	public static List<Integer> getNodeSiblingIDs(Integer nodeId){
		String sql = "SELECT d.DmozNodePK FROM DMOZ d WHERE ParentNodeID = " +
				"(SELECT d2.ParentNodeID FROM DMOZ d2 WHERE DmozNodePK = ?)";
		
		List<Integer> siblingNodeIds = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{nodeId});
		
		return siblingNodeIds;
	}
	
	public static List<Integer> getChildrenNodeIDs(Integer parentNodeId){
		String sql = "SELECT DmozNodePK FROM DMOZ WHERE ParentNodeID = ?";
		
		List<Integer> childrenNodes = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{parentNodeId});
		
		return childrenNodes;
	}
	
	public static String getNodeDescription(Integer nodeId) throws Exception{		
		String sql = "SELECT d.NodeDescription FROM DMOZ d WHERE DmozNodePK = ?";
		
		String nodeDescription = jdbcTemplate.queryForObject(sql, new Object[]
				{nodeId}, String.class);
		
		return nodeDescription;
	}
	
	public static List<String> getUrls(Integer nodeId, Integer urlLevel){
		String sql = "SELECT u.URL FROM URLData u WHERE DmozNodeFK = ? and Level = ?";
		
		List<String> urls = jdbcTemplate.queryForList(sql, String.class, new Object[]
				{nodeId, urlLevel});
		
		return urls;
	}
	
	public static void loadDmozToDB() throws Exception{
		//Read property file for dmoz files paths
		Properties properties = new Properties();
		FileInputStream in = new FileInputStream("bin/system.properties");
		properties.load(in);
		in.close();
		
		String dmozUrlFile = properties.getProperty("dmoz.urlFile");
		String dmozDescriptionFile = properties.getProperty("dmoz.descriptionFile");
		
		//Build DMOZ Tree
		System.out.println("Get Dmoz tree nodes.");
		final BuildDmozTree dmozTreeBuilder = new BuildDmozTree(dmozDescriptionFile,dmozUrlFile);
		HashMap<String,TreeNode> dmozTree = dmozTreeBuilder.buildAndGetAllDmozTreeNodes();
		
		//Batch and store the tree to database
		final List<Map<String,TreeNode>> batches = SemplestUtils.getBatches(dmozTree, 5000);
		System.out.println("Going to store " + batches.size() + " batchs (of 5000 node entries) to DB.");
		Long counter = 0L;		
		for (final Map<String,TreeNode> batch : batches)
		{			
			Long start = System.currentTimeMillis();
			System.out.println("Storing batch #" + counter + " to DB...");
			ArrayList<String> batchSql = new ArrayList<String>();
			for(TreeNode node : batch.values()){
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
