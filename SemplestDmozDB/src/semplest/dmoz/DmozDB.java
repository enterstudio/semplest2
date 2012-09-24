package semplest.dmoz;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DbDmozTreeOperator;
import semplest.dmoz.tools.DmozImporter;
import semplest.dmoz.tree.DbTreeNodeObject;
import semplest.dmoz.tree.DbUrlDataObject;
import semplest.dmoz.tree.DmozTreeNode;


public class DmozDB extends BaseDB{

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	
	public static Integer getParentNodeID(Integer nodeId) throws Exception
	{		
		String sql = "SELECT ParentNodeID FROM DMOZ WHERE SemplestPK = ?";
		
		Integer parentNodeId = jdbcTemplate.queryForInt(sql, new Object[]
				{nodeId});
		
		return parentNodeId;
	}
	
	public static List<Integer> getNodeSiblingIDs(Integer nodeId) throws Exception
	{
		String sql = "SELECT d.SemplestPK FROM DMOZ d WHERE ParentNodeID = " +
				"(SELECT d2.ParentNodeID FROM DMOZ d2 WHERE SemplestPK = ?)";
		
		List<Integer> siblingNodeIds = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{nodeId});
		
		return siblingNodeIds;
	}
	
	public static List<Integer> getChildrenNodeIDs(Integer parentNodeId) throws Exception
	{
		String sql = "SELECT SemplestPK FROM DMOZ WHERE ParentNodeID = ?";
		
		List<Integer> childrenNodes = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{parentNodeId});
		
		return childrenNodes;
	}
	
	public static String getNodeDescription(Integer nodeId) throws Exception
	{
		String sql = "SELECT d.NodeDescription FROM DMOZ d WHERE SemplestPK = ?";
		
		String nodeDescription = jdbcTemplate.queryForObject(sql, new Object[]
				{nodeId}, String.class);
		
		return nodeDescription;
	}
	
	public static List<String> getUrls(Integer nodeId, Integer urlLevel) throws Exception
	{
		String sql = "SELECT u.URL FROM URLData u WHERE SemplestFK = ? and Level = ?";
		
		List<String> urls = jdbcTemplate.queryForList(sql, String.class, new Object[]
				{nodeId, urlLevel});
		
		return urls;
	}
	
	public static DmozTreeNode getDmozTree(String categoryName) throws Exception{
		return DbDmozTreeOperator.loadTreeFromDB(categoryName);
	}
	
}
