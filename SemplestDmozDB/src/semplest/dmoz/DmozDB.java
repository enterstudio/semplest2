package semplest.dmoz;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DmozDbOperator;


public class DmozDB extends BaseDB{

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	
	public static Integer getParentNodeID(Integer nodeId) throws Exception{		
		String sql = "SELECT ParentNodeID FROM DMOZ WHERE DmozNodePK = ?";
		
		Integer parentNodeId = jdbcTemplate.queryForInt(sql, new Object[]
				{nodeId});
		
		return parentNodeId;
	}
	
	public static List<Integer> getNodeSiblingIDs(Integer nodeId) throws Exception{
		String sql = "SELECT d.DmozNodePK FROM DMOZ d WHERE ParentNodeID = " +
				"(SELECT d2.ParentNodeID FROM DMOZ d2 WHERE DmozNodePK = ?)";
		
		List<Integer> siblingNodeIds = jdbcTemplate.queryForList(sql, Integer.class, new Object[]
				{nodeId});
		
		return siblingNodeIds;
	}
	
	public static List<Integer> getChildrenNodeIDs(Integer parentNodeId) throws Exception{
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
	
	public static List<String> getUrls(Integer nodeId, Integer urlLevel) throws Exception{
		String sql = "SELECT u.URL FROM URLData u WHERE DmozNodeFK = ? and Level = ?";
		
		List<String> urls = jdbcTemplate.queryForList(sql, String.class, new Object[]
				{nodeId, urlLevel});
		
		return urls;
	}
	
	public static void getDmozTree(String categoryName) throws Exception{
		DmozDbOperator.loadDmozTreeFromDB(categoryName);
	}
	
}
