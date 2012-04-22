package semplest.server.service.springjdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SetScheduleJobCompleteSP extends StoredProcedure 
{
	private static final String SPROC_NAME = "SetScheduleJobComplete";
	private static final RowMapper<ScheduleJobObj> ScheduleJobObjMapper = new BeanPropertyRowMapper(ScheduleJobObj.class); 
	
	public SetScheduleJobCompleteSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME );
		declareParameter(new SqlReturnResultSet("nextScheduledJob", ScheduleJobObjMapper));   
		declareParameter(new SqlParameter("ScheduleJobID", Types.INTEGER));
		declareParameter(new SqlParameter("IsSucceedful", Types.BIT));
		//declareParameter(new SqlOutParameter("titles", , new TitleMapper()));
        compile();


	}
	/*
	 * returns the next schedule job to run
	 */
	public ScheduleJobObj execute(Integer ScheduleID, boolean IsSuccessful) {
        Map<String, Object> inputs = new HashMap<String, Object>();
        inputs.put("ScheduleJobID", ScheduleID);
        inputs.put("IsSuccessful", IsSuccessful);
        Map results  = super.execute(inputs);
        if (results.get("nextScheduledJob") == null)   
        {   
             return null;   
        }   
        else  
        {   
            return (ScheduleJobObj) results.get("nextScheduledJob");   
        } 
    }




}
