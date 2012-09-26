package semplest.server.job;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import semplest.util.SemplestUtils;

public class Cleaner
{
	private static final Logger log = Logger.getLogger(Cleaner.class);
	
	public static void main(final String[] args)
	{
		PropertyConfigurator.configure("properties/log4j_server.properties");
		BasicConfigurator.configure();	
		final List<String> dirsToClean = Arrays.asList("C:/SemplestCommon/data/msn");
		final int numDaysBack = 30;
		
		log.info("Will prune files these " + dirsToClean.size() + " directories older than " + numDaysBack + " days back:\n" + SemplestUtils.getEasilyReadableString(dirsToClean));
		final long currentTimeMillis = System.currentTimeMillis();
		for (final String dir : dirsToClean)
		{
			log.info("Will prune dir [" + dir + "]");
			final File dirFile = new File(dir);
			final File[] files = dirFile.listFiles();
			final Map<String, Long> fileToAgeMap = new HashMap<String, Long>();
			for (final File file : files)
			{
				if (!file.isDirectory())
				{
					final long lastModifiedMillis = file.lastModified();
					final long diffMillis = currentTimeMillis - lastModifiedMillis;
					final long diffDays = diffMillis / SemplestUtils.DAY;
					final String filePath = file.getAbsolutePath();
					fileToAgeMap.put(filePath, diffDays);
				}
			}
			System.out.println("Found " + fileToAgeMap.size() + " non-directory files.  File <-> Age map:\n" + SemplestUtils.getEasilyReadableString(fileToAgeMap));
			final Set<Entry<String, Long>> entrySet = fileToAgeMap.entrySet();
			for (final Entry<String, Long> entry : entrySet)
			{
				final String fileName = entry.getKey();
				final Long daysOld = entry.getValue();
				if (daysOld > numDaysBack)
				{
					log.info("Will need to delete file [" + fileName + "] because it's " + daysOld + " days old, which is more than the limit of [" + numDaysBack + "]");
					final File file = new File(fileName);	
					final boolean isDeleteSuccessful = file.delete();					
					if (!isDeleteSuccessful)
					{
						log.warn("Problem deleting file [" + fileName + "]");
					}
				}
			}
		}
	}
}
