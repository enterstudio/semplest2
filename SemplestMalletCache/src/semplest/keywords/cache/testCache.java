package semplest.keywords.cache;

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
			for (int i = 0; i <= 1000; i++)
			{
				CacheObj o = new CacheObj(i);
				cache.getMyCache().put(new Element(new Integer(i), o));
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
