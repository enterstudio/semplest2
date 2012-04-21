package semplest.server.service.springjdbc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class SetScheduleCompleteSP extends StoredProcedure 
{
	private static final String SPROC_NAME = "SetScheduleComplete";
	
	public SetScheduleCompleteSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME );
		declareParameter(new SqlParameter("ScheduleID", Types.INTEGER));
		declareParameter(new SqlParameter("IsSucceedD", Types.BIT));
		//declareParameter(new SqlOutParameter("titles", , new TitleMapper()));
        compile();


	}
	public Map execute(Integer ScheduleID, boolean IsSuccessful) {
        Map inputs = new HashMap();
        inputs.put("ScheduleID", ScheduleID);
        inputs.put("IsSuccessful", IsSuccessful);
        return super.execute(inputs);
    }




}
