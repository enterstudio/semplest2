package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		customer.setCampaignCycleType(rs.getString("CampaignCycleType"));
		customer.setCreatedDate(rs.getDate("CreatedDate"));
		customer.setCustomerPK(rs.getInt("CustomerPK"));
		customer.setCycleInDays(rs.getInt("CycleInDays"));
		customer.setEditedDate(rs.getDate("EditedDate"));
		customer.setName(rs.getString("Name"));
		customer.setTotalCycleTargetBudget(rs.getDouble("TotalCycleTargetBudget"));
		
		return customer;
		
	}

}
