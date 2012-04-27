package cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Element;

public class testCache
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			EhCache cache = new EhCache();
			for (int i = 0; i <= 400000; i++)
			{
				CacheObj o = new CacheObj(i);
				cache.getMyCache().put(new Element(new Integer(i), o));
				System.out.println("inputing element" + i);
				//System.out.println(cache.getMyCache().calculateInMemorySize());
			}
			CacheObj aux;
			for (int i = 0; i <= 400000; i++)
			{
			aux = (CacheObj) cache.getMyCache().get(i).getValue();
				System.out.println("outputing element" + aux);
				//System.out.println(cache.getMyCache().calculateInMemorySize());
			}
			cache.shutdown();
		}
		catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalStateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (CacheException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
