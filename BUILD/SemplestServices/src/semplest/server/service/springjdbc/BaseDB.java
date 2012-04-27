package semplest.server.service.springjdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDB
{
	public static JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) 
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
