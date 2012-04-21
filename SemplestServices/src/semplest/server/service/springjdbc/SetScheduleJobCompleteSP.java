package semplest.server.service.springjdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class SetScheduleJobCompleteSP extends StoredProcedure 
{
	private static final String SPROC_NAME = "SetScheduleJobComplete";
	
	public SetScheduleJobCompleteSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME );
		declareParameter(new SqlParameter("ScheduleJobID", Types.INTEGER));
		declareParameter(new SqlParameter("IsSucceedful", Types.BIT));
		//declareParameter(new SqlOutParameter("titles", , new TitleMapper()));
        compile();


	}
	public Map execute(Integer ScheduleID, boolean IsSuccessful) {
        Map inputs = new HashMap();
        inputs.put("ScheduleJobID", ScheduleID);
        inputs.put("IsSuccessful", IsSuccessful);
        return super.execute(inputs);
    }




}
