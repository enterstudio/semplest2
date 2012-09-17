package semplest.dmoz;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DbTreeOperator;
import semplest.dmoz.tools.DmozImporter;


public class DmozDB extends BaseDB{

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	
	public static Integer getParentNodeID(DBType dbType, Integer nodeId) throws Exception
	{		
		String treeTable = DbTreeOperator.getTreeTableName(dbType);		
		String sql = "SELECT ParentNodeID FROM " + treeTable + " WHERE SemplestPK = ?";
		
		Integer parentNodeId = jdbcTemplate.queryForInt(sql, new Object[]
				{nodeId});
		
		return parentNodeId;
	}
	
	public static List<Integer> getNodeSiblingIDs(DBType dbType, Integer nodeId) throws Exception
	{
		String treeTable = DbTreeOperator.getTreeTableName(dbType);	
		String sql = "SELECT d.SemplestPK FROM " + treeTable + " d WHERE ParentNodeID = " +
				"(SELECT d2.ParentNodeID FROM " + treeTable + " d2 WHERE SemplestPK = ?)";
		
		List<Integer> siblingNodeIds = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{nodeId});
		
		return siblingNodeIds;
	}
	
	public static List<Integer> getChildrenNodeIDs(DBType dbType, Integer parentNodeId) throws Exception
	{
		String treeTable = DbTreeOperator.getTreeTableName(dbType);	
		String sql = "SELECT SemplestPK FROM " + treeTable + " WHERE ParentNodeID = ?";
		
		List<Integer> childrenNodes = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{parentNodeId});
		
		return childrenNodes;
	}
	
	public static String getNodeDescription(DBType dbType, Integer nodeId) throws Exception
	{
		String treeTable = DbTreeOperator.getTreeTableName(dbType);	
		String sql = "SELECT d.NodeDescription FROM " + treeTable + " d WHERE SemplestPK = ?";
		
		String nodeDescription = jdbcTemplate.queryForObject(sql, new Object[]
				{nodeId}, String.class);
		
		return nodeDescription;
	}
	
	public static List<String> getUrls(DBType dbType, Integer nodeId, Integer urlLevel) throws Exception
	{
		String urlDataTable = DbTreeOperator.getUrlDataTableName(dbType);	
		String sql = "SELECT u.URL FROM " + urlDataTable + " u WHERE SemplestFK = ? and Level = ?";
		
		List<String> urls = jdbcTemplate.queryForList(sql, String.class, new Object[]
				{nodeId, urlLevel});
		
		return urls;
	}
	
	public static void getTree(DBType dbType, String categoryName) throws Exception{
		DbTreeOperator.loadTreeFromDB(dbType, categoryName);
	}
	
}
