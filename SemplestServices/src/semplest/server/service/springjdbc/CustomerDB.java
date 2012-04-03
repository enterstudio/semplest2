package semplest.server.service.springjdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import semplest.server.service.springjdbc.helper.CustomerRowMapper;

public class CustomerDB
{
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) 
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<CustomerObj> getAllCustomers()
    {
    	String strSQL = "select c.CustomerPK, c.Name, c.TotalTargetCycleBudget, cct.CampaignCycleType, cct.CycleInDays, bt.BillType, c.CreatedDate, c.EditedDate from Customer c " +
    					"inner join CampaignCycleType cct on c.CampaignCycleTypeFK = cct.CampaignCycleTypePK " +
    					"inner join BillType bt on c.BillTypeFK = bt.BillTypePK";
    	return jdbcTemplate.query(strSQL, new CustomerRowMapper());
    }

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
