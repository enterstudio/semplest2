package semplest.dmoz.tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.UrlDataObject;

public class DbSemplestTreeOperator extends BaseDB
{	
	private static RowMapper<UrlDataObject> urlDataObjectMapper = new BeanPropertyRowMapper<UrlDataObject>(UrlDataObject.class);
	
	public static List<Long> getNodeIDsOfTree(String categoryName) throws Exception{
		//get all the nodeIDs of this sub-tree
		String topNodeText = categoryName;
		String childrenNodesPattern = categoryName + "/%";
		
		String sql = "SELECT SemplestPK FROM SemplestTree " +
				"WHERE NodeText = ? or NodeText like ?";
		
		List<Long> nodeIDs = jdbcTemplate.queryForList(sql, new Object[]{topNodeText, childrenNodesPattern}, Long.class);
		
		if(nodeIDs == null || nodeIDs.size() == 0){
			//the sub-tree top node does not exist
			throw new Exception("There's no sub-tree belongs to node " + categoryName + " in the database.");
		}
		
		return nodeIDs;
	}
	
	public static Set<Long> getDomainPKsOfTree(String categoryName) throws Exception{
		Set<Long> domainPkSet = new HashSet<Long>();		
		String sql;		
		
		System.out.println("Getting nodeIDs of the tree...");
		
		List<Long> nodeIDs = getNodeIDsOfTree(categoryName);
		
		System.out.println("Done.");
				
		System.out.println("Getting domainPKs of the nodes...");
		
		//for each node, get its domain list
		for(Long nodeID : nodeIDs){			
			System.out.println("getting domainPKs of node " + nodeID);
			
			sql = "SELECT d.DomainPK FROM Domain d " +
					"INNER JOIN SemplestURLData u ON d.DomainPK = u.DomainFK " +
					"INNER JOIN NodeURLAssociation n ON n.URLDataFK = u.UrlDataPK " +
					"WHERE n.SemplestFK = ?";
			List<Long> domainPKList = jdbcTemplate.queryForList(sql, new Object[]{nodeID}, Long.class);
			
			//get the unique domains
			for(Long domainPK : domainPKList){
				domainPkSet.add(domainPK);
			}
		}		
		
		System.out.println("Done.");
		
		return domainPkSet;
	}
	
	public static List<UrlDataObject> getUrlsOfTree(String categoryName) throws Exception
	{		
		String sql;
		String topNodeText = categoryName;
		String childrenNodesPattern = categoryName + "/%";
		
		sql = "SELECT su.UrlDataPK,su.URL,su.DomainFK FROM SemplestURLData su " +
				"INNER JOIN NodeURLAssociation nua ON su.UrlDataPK = nua.URLDataFK " +
				"INNER JOIN SemplestTree st ON st.SemplestPK = nua.SemplestFK " +
				"WHERE NodeText = ? or NodeText like ? ";
		
		List<UrlDataObject> allUrlData = jdbcTemplate.query(sql, new Object[]{topNodeText,childrenNodesPattern}, urlDataObjectMapper);
		
		return allUrlData;
	}
	
	public static List<Long> getUrlPKsByNode(Long nodeID) throws Exception
	{
		String sql;	
		
		sql = "SELECT URLDataFK FROM NodeURLAssociation " +
				"WHERE SemplestFK = ?";
		
		List<Long> urlPKs = jdbcTemplate.queryForList(sql, new Object[]{nodeID}, Long.class);
		
		return urlPKs;
	}
	
	public static List<String> getUrlsByNode(Long nodeID) throws Exception
	{
		String sql;	
		
		sql = "SELECT URL FROM SemplestURLData u " +
				"INNER JOIN NodeURLAssociation a ON u.UrlDataPK = a.URLDataFK " +
				"WHERE a.SemplestFK = ?";
		
		List<String> urls = jdbcTemplate.queryForList(sql, new Object[]{nodeID}, String.class);
		
		return urls;
	}
}
