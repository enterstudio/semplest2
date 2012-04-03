package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import semplest.server.service.springjdbc.CustomerObj;

public class CustomerRowMapper implements RowMapper<CustomerObj>
{

	@Override
	public CustomerObj mapRow(ResultSet rs, int row) throws SQLException
	{
		CustomerRSExtractor extractor = new CustomerRSExtractor();
		return extractor.extractData(rs);
	}

}
