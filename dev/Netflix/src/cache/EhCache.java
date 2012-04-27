package cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class EhCache
{

	private CacheManager managerInstance = null;
	private Cache myCache = null;

	public EhCache()
	{
		managerInstance = new CacheManager(EhCache.class.getResource( "/cacheSetting/ehcache.xml"));
		System.out.println(managerInstance.getActiveConfigurationText());
		myCache = managerInstance.getCache("movieCache");
		//Move data to xml file
		/*
		myCache = new Cache(new CacheConfiguration("testCache", maxElements)
				.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
				.overflowToDisk(true)
				.eternal(false)
				.timeToLiveSeconds(60)
				.timeToIdleSeconds(30)
				.diskPersistent(false)
				.diskStorePath("c:/cache")
				.diskExpiryThreadIntervalSeconds(0));
				*/
        //add cache
		//managerInstance.addCache(myCache);

	}

	public void shutdown()
	{
		managerInstance.shutdown();
	}

	public long getCacheSize()
	{
		return myCache.calculateInMemorySize();
	}

	public Cache getMyCache()
	{
		return myCache;
	}

}
