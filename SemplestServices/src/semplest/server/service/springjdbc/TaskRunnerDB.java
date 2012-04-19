package semplest.server.service.springjdbc;

import java.util.List;

import semplest.server.service.springjdbc.helper.ScheduleTaskRowMapper;

public class TaskRunnerDB extends BaseDB
{
    public List<TaskRunnerObj> getScheduleTasks(Integer SchedulerPK)
    {
    	try
		{
			String strSQL = "select t.ServiceName,t.MethodName,t.Parameters,s.SchedulePK,st.TaskExecutionOrder from Schedule s " +
					"inner join ScheduleTaskAssociation st on s.SchedulePK = st.ScheduleFK " +
					"inner join Task t on t.TaskPK = st.TaskFK " +
					"where s.SchedulePK = ? and s.IsEnabled = 1 " +
					"order by st.TaskExecutionOrder";
			return jdbcTemplate.query(strSQL, new Object[] {SchedulerPK}, new ScheduleTaskRowMapper());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }


}
