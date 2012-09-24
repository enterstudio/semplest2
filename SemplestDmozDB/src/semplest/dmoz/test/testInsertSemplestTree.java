package semplest.dmoz.test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.dmoz.SemplestTreeSqlCall;
import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.pruning.CharDigLeafFilter;
import semplest.dmoz.pruning.DmozToSemplestFilter;
import semplest.dmoz.pruning.DmozToSemplestTreeConverter;
import semplest.dmoz.pruning.NorthAmericaUSMergingFilter;
import semplest.dmoz.pruning.RegionalRemovalFilter;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DbDmozTreeOperator;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.TreeFunctions;
import semplest.dmoz.tree.UrlDataObject;
import semplest.util.SemplestUtils;

public class testInsertSemplestTree extends BaseDB{
	
	public static void main(String[] args){
		try {
			testInsertSemplestTree test = new testInsertSemplestTree();
			test.insertTreeToDB();
			/*
			DmozTreeNode dmozTree = DbDmozTreeOperator.loadTreeFromDB("top");
			List<DmozTreeNode> treeNodes = TreeFunctions.getTreeInList(dmozTree);
			AddSemplestTree(treeNodes);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertTreeToDB() throws Exception{
		//load the entire tree from the DB
		DmozTreeNode dmozTree = DbDmozTreeOperator.loadTreeFromDB("top/business/financial_services");
		
		//apply processors on the tree, and convert it
		//TODO				
		DmozToSemplestTreeConverter dmozToSemplestConv = new DmozToSemplestTreeConverter(dmozTree);
		Set<DmozToSemplestFilter> filterSet = new HashSet<DmozToSemplestFilter>();
		filterSet.add(new RegionalRemovalFilter(null));
		filterSet.add(new CharDigLeafFilter(null));
		filterSet.add(new NorthAmericaUSMergingFilter(null));
		dmozToSemplestConv.setFilterSet(filterSet);
		dmozToSemplestConv.prune();			
		
		DmozTreeNode semplestTree = dmozToSemplestConv.getTree();		
		
		//put the tree maps in database
		List<DmozTreeNode> semplestTreeNodes = TreeFunctions.getTreeInList(semplestTree);	
		
		List<List<DmozTreeNode>> batches = SemplestUtils.getBatches(semplestTreeNodes, 50);
		
		Long start = System.currentTimeMillis();
		int count = 1;
		for(List<DmozTreeNode> batch : batches){
			System.out.println("storing batch #" + count);
			System.out.println("batch size is " + batch.size());
			//SemplestTreeSqlCall.runSemplestTree(batch);
			//AddSemplestTree(batch);
			count++;
		}			
		System.out.println("Storing data to DB took " + (System.currentTimeMillis() - start)/1000 + "secs.");
		
	}
	
	public List<AddSemplestTreeRequest> formRequests(final List<DmozTreeNode> semplestTreeNodes){
		//form the request list
		final List<AddSemplestTreeRequest> addSemplestTreeRequests = new ArrayList<AddSemplestTreeRequest>();
		for(DmozTreeNode node : semplestTreeNodes){
			List<UrlDataObject> list = node.getCategoryData().getUrlData();
			for(UrlDataObject urlData : list){				
				AddSemplestTreeRequest request = new AddSemplestTreeRequest();
				request.setDMOZSemplestPK(node.getNodeID());
				request.setDMOZURLDataPK(urlData.getUrlDataPK());
				request.setDomain(getDomain(urlData.getUrl()));
				
				addSemplestTreeRequests.add(request);
			}
		}	
		
		System.out.println("Number of requests = " + addSemplestTreeRequests.size());
		
		return addSemplestTreeRequests;
	}
	
	public void AddSemplestTree(final List<DmozTreeNode> semplestTreeNodes)
	{
		//form the request list
		final List<AddSemplestTreeRequest> addSemplestTreeRequests = formRequests(semplestTreeNodes);		
		
		//call the store proc in batch
		Long start = System.currentTimeMillis();
		
		
		/*
		String sql = "{call AddSemplestTree(?,?,?)}";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				AddSemplestTreeRequest request = addSemplestTreeRequests.get(i);
				ps.setLong(1, request.getDMOZSemplestPK());
				ps.setLong(2, request.getDMOZURLDataPK());
				ps.setString(3, request.getDomain());
			}

			@Override
			public int getBatchSize()
			{
				return addSemplestTreeRequests.size();
			}
		});
		*/
		System.out.println("Storing data to DB took " + (System.currentTimeMillis() - start)/1000 + "secs.");
	}
	
	//helper method
	private String getDomain(String url)
	{
		String[] parts = url.split("://");
		String subUrl;
		if(parts.length > 1){
			subUrl = parts[1];
		}
		else{
			subUrl = parts[0];
		}
		int index = subUrl.indexOf("/");
		String domain;
		if(index > 0){
			domain = subUrl.substring(0, index);
		}
		else{
			domain = subUrl;
		}
		
		return domain;
	}
}
