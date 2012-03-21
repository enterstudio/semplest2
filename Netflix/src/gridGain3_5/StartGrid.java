package gridGain3_5;

import org.gridgain.grid.Grid;
import org.gridgain.grid.GridFactory;
import org.gridgain.grid.GridTaskFuture;

public class StartGrid
{
	public static Grid localGrid = null;
	
	public static Grid getLocalGrid()
	{
		return localGrid;
	}

	public StartGrid()
	{
		
	}
	
	public static void startGrid()
	{
		if (localGrid == null)
		{
			try
			{
				GridFactory.start();
				localGrid = GridFactory.grid();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				localGrid = null;
			}
			
		}
	}
	public static void StopGrid()
	{
		GridFactory.stop(true);
	}
	
	public static Object runOnGrid(Object obj,final String test) throws Exception
	{
		
		if (localGrid == null)
		{
			StartGrid.startGrid();
		}
		
		GridTaskFuture<Object> future = localGrid.execute(obj.getClass().getName(), test); //TestGridTask.class
		return future.get();
		
	}
	

}
