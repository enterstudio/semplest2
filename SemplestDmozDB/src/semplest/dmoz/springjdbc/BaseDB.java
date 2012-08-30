package semplest.dmoz.springjdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

public class BaseDB
{
	public static JdbcTemplate jdbcTemplate;
	public static TransactionTemplate jdbcTransaction; 

    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTransaction = TransactionManager.txTemplate;
    }

}
