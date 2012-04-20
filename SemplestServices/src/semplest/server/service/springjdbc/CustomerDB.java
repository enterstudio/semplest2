package semplest.server.service.springjdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.service.springjdbc.helper.CustomerRowMapper;

public class CustomerDB extends BaseDB
{
	private static final RowMapper<CustomerObj> CustomerObjMapper = new BeanPropertyRowMapper(CustomerObj.class); 
	
    public List<CustomerObj> getAllCustomers()
    {
    	
    	String strSQL = "select c.CustomerPK, c.Name, c.TotalTargetCycleBudget, cct.ProductGroupCycleType, cct.CycleInDays, bt.BillType, c.CreatedDate, c.EditedDate from Customer c " +
    			"inner join ProductGroupCycleType cct on c.ProductGroupCycleTypeFK = cct.ProductGroupCycleTypePK " +
    			"inner join BillType bt on c.BillTypeFK = bt.BillTypePK";
    	return jdbcTemplate.query(strSQL, CustomerObjMapper); //new CustomerRowMapper());
    }

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
