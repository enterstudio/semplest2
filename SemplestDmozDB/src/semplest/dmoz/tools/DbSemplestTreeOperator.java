package semplest.dmoz.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import semplest.dmoz.DmozDB;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DmozTreeNode;

public class DbSemplestTreeOperator extends BaseDB{
	
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
		
		List<Long> nodeIDs = getNodeIDsOfTree(categoryName);
				
		//for each node, get its domain list
		for(Long nodeID : nodeIDs){			
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
		
		return domainPkSet;
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
