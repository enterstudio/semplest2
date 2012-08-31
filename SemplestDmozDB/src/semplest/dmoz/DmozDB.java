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
		final BuildDmozTree dmozTreeBuilder = new BuildDmozTree(dmozDescriptionFile,dmozUrlFile);
		HashMap<String,TreeNode> dmozTree = dmozTreeBuilder.buildAndGetAllDmozTreeNodes();
		
		//Batch and store the tree to database
		final List<Map<String,TreeNode>> batches = SemplestUtils.getBatches(dmozTree, 1000);
		for (final Map<String,TreeNode> batch : batches)
		{			
			ArrayList<String> batchSql = new ArrayList<String>();
			for(TreeNode node : batch.values()){
				String sqlDmoz = "INSERT INTO DMOZ(DmozNodePK,NodeText,ParentNodeID,NodeDescription) " +
						"VALUES("+ node.getNodeID() +",'" + node.getFullName().replace("'", "''") + "'," + node.getParentID() + ",'" + node.getCategoryData().getDescription().replace("'", "''") + "');";	
				
				String sqlUrlData = "";
				for(String url : node.getCategoryData().getUrls()){
					String sqlUrls = "INSERT INTO URLData(DmozNodeFK,URL,Level) " +
							"VALUES(" + node.getNodeID() + ",'" + url.replace("'", "''") + "'," + 1 + ");";
					
					sqlUrlData = sqlUrlData + sqlUrls;
				}
				
				String sqlReq = sqlDmoz + sqlUrlData;
				batchSql.add(sqlReq);
			}
			jdbcTemplate.batchUpdate(batchSql.toArray(new String[batchSql.size()]));
		}
	}	
	
}
