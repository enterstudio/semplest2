package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import semplest.server.service.springjdbc.CustomerObj;

public class CustomerRSExtractor implements ResultSetExtractor<CustomerObj>
{

	@Override
	public CustomerObj extractData(ResultSet rs) throws SQLException, DataAccessException
	{
		CustomerObj customer = new CustomerObj();
		customer.setBillType(rs.getString("BillType"));
		customer.setCampaignCycleType(rs.getString("ProductGroupCycleType"));
		customer.setCreatedDate(rs.getTimestamp("CreatedDate"));
		customer.setCustomerPK(rs.getInt("CustomerPK"));
		customer.setCycleInDays(rs.getInt("CycleInDays"));
		customer.setEditedDate(rs.getTimestamp("EditedDate"));
		customer.setName(rs.getString("Name"));
		customer.setTotalTargetCycleBudget(rs.getDouble("TotalTargetCycleBudget"));
		
		return customer;
		
	}

}
