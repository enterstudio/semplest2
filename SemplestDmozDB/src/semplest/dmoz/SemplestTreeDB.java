package semplest.dmoz;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.UrlDataObject;

public class SemplestTreeDB extends BaseDB{	
		
	public static void AddSemplestTree(final List<AddSemplestTreeRequest> addSemplestTreeRequests)
	{				
		//call the store proc in batch
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
	}
}
