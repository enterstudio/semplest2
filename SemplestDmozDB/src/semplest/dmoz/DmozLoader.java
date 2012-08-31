package semplest.dmoz;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import semplest.server.protocol.DmozEntry;
import semplest.server.protocol.DmozFileType;
import semplest.server.protocol.DmozTree;
import semplest.util.SemplestUtils;

public class DmozLoader
{
	private static final Logger logger = Logger.getLogger(DmozLoader.class);
	
	private final String dmozIdFile;
	private final String dmozUrlFile;
	private final String dmozDescriptionFile;
	
	public DmozLoader(final String dmozIdFile, final String dmozUrlFile, final String dmozDescriptionFile)
	{
		this.dmozIdFile = dmozIdFile;
		this.dmozUrlFile = dmozUrlFile;
		this.dmozDescriptionFile = dmozDescriptionFile;
	}
	
	public static Map<List<String>, DmozEntry> getDmozEntries(final String file, final DmozFileType fileType) throws Exception
	{
		logger.info("Will parse Dmoz Entries from File [" + file + "] of Type [" + fileType + "]");
		final Map<List<String>, DmozEntry> entries = new HashMap<List<String>, DmozEntry>();		
		final FileInputStream fstream;
		try
		{
			fstream = new FileInputStream(file);
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not find file [" + file + "]");
		}
		final DataInputStream in = new DataInputStream(fstream);
		final BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		int counter = 0;
		try
		{
			while ((line = br.readLine()) != null) 
			{
				++counter;
				if (counter % 40000 == 0)
				{
					logger.info("Progress update: parsed " + counter + " lines");					
				}
				final DmozEntry dmozEntry;
				if (fileType == DmozFileType.ID)
				{
					dmozEntry = getDmozIdEntry(line);
				}
				else if (fileType == DmozFileType.URL)
				{
					dmozEntry = getDmozUrlEntry(line);
				}
				else if (fileType == DmozFileType.DESCRIPTION)
				{
					dmozEntry = getDmozDescriptionEntry(line);
				}
				else
				{
					throw new Exception("Cannot process the following line because DmozFileType [" + fileType + "] is unknown: [" + line + "]");
				}
				final List<String> levelNames = dmozEntry.getLevelNames();
				entries.put(levelNames, dmozEntry);
			}
		}
		catch (IOException e)
		{
			throw new Exception("Problem parsing file [" + file + "], the last line successfully read (if not null) is [" + line + "]");
		}
		try
		{
			in.close();
			fstream.close();
		}
		catch (IOException e)
		{
			logger.error("Problem closing DataInputStream.  Logging, but otherwise ignoring");
		}
		return entries;
	}
	
	public static DmozEntry getDmozIdEntry(final String line) throws Exception
	{
		final String delimiter = " : ";
		final String pathDelimiter = "/";
		final String[] pathAndId = line.split(delimiter);
		final int numTokens = pathAndId.length;
		if (numTokens != 2)
		{
			throw new Exception("Expected only 2 tokens when splitting this line using delimeter [" + delimiter + "], but got " + numTokens + ": [" + line + "]");
		}
		final String path = pathAndId[0].trim();
		final String idString = pathAndId[1].trim();
		final String[] pathLevels = path.split(pathDelimiter);
		final List<String> pathLevelList = getTrimmedStringList(pathLevels);
		final Long id = Long.valueOf(idString);
		final DmozEntry dmozEntry = new DmozEntry(pathLevelList);
		dmozEntry.setId(id);
		return dmozEntry;
	}
	
	public static List<String> getTrimmedStringList(final String[] strings)
	{
		final List<String> list = new ArrayList<String>();
		for (final String string : strings)
		{
			list.add(SemplestUtils.getTrimmedNonNullString(string));
		}
		return list;
	}
	
	public static DmozEntry getDmozDescriptionEntry(final String line) throws Exception
	{
		final String delimiter = " : ";
		final String pathDelimiter = "/";
		final String[] pathAndDescription = line.split(delimiter);
		final int numTokens = pathAndDescription.length;
		final int expectedNumTokens = 2;
		if (numTokens != expectedNumTokens)
		{
			throw new Exception("Expected only " + expectedNumTokens + " tokens when splitting this line using delimeter [" + delimiter + "], but got " + numTokens + ": [" + line + "]");
		}
		final String path = pathAndDescription[0].trim();
		final String descriptionString = pathAndDescription[1].trim();
		final String[] pathLevels = path.split(pathDelimiter);
		final List<String> pathLevelList = getTrimmedStringList(pathLevels);
		final String description = SemplestUtils.getTrimmedNonNullString(descriptionString);
		final DmozEntry dmozEntry = new DmozEntry(pathLevelList);
		dmozEntry.setDescription(description);
		return dmozEntry;
	}
	
	public static DmozEntry getDmozUrlEntry(final String line) throws Exception
	{
		final String delimiter = " : ";
		final String pathDelimiter = "/";
		final String urlDelimiter = " ";
		final String[] tokens = line.split(delimiter);
		final int numTokens = tokens.length;
		final int expectedNumTokens = 2;
		if (numTokens != expectedNumTokens)
		{
			throw new Exception("Expected only " + expectedNumTokens + " tokens when splitting this line using delimeter [" + delimiter + "], but got " + numTokens + ": [" + line + "]");
		}
		final String path = tokens[0].trim();
		final String urlStrings = tokens[1].trim();
		final String[] pathLevels = path.split(pathDelimiter);
		final List<String> pathLevelList = Arrays.asList(pathLevels);
		final String[] urls = urlStrings.split(urlDelimiter);
		final List<String> urlList = getTrimmedStringList(urls);
		final DmozEntry dmozEntry = new DmozEntry(pathLevelList);
		dmozEntry.setUrls(urlList);
		return dmozEntry;
	}
	
	public List<DmozEntry> engage() throws Exception
	{
		logger.info("Starting processing with DmozIdFile [" + dmozIdFile + "], DmozUrlFile [" + dmozUrlFile + "], DmozDescriptionFile [" + dmozDescriptionFile + "]");
		final List<DmozEntry> entries = getDmozEntries();
		logger.info("Generated " + entries.size() + " DMOZ UNIFIED entries");
		//logger.info(SemplestUtils.getEasilyReadableString(entries));
		final DmozTree tree = getDmozTree(entries);
		final String treeString = SemplestUtils.getEasilyReadableString(tree);
		logger.info("Tree:\n" + treeString);
		//logger.info("Tree:\n" + tree);
		//System.out.println("Tree:\n" + tree);	
		
		return entries;
	}
	
	public DmozTree getDmozTree(List<DmozEntry> entries)
	{
		final DmozTree tree = new DmozTree();
		for (final DmozEntry entry : entries)
		{
			tree.add(entry);
		}
		return tree;
	}
	
	public List<DmozEntry> getDmozEntries() throws Exception
	{
		final Map<List<String>, DmozEntry> dmozIdEntries = getDmozEntries(dmozIdFile, DmozFileType.ID);
		logger.info("Generated " + dmozIdEntries.size() + " DMOZ ID Entries from file [" + dmozIdFile + "]");
		final Map<List<String>, DmozEntry> dmozUrlEntries = getDmozEntries(dmozUrlFile, DmozFileType.URL);
		logger.info("Generated " + dmozUrlEntries.size() + " DMOZ URL Entries from file [" + dmozUrlFile + "]");
		final Map<List<String>, DmozEntry> dmozDescriptionEntries = getDmozEntries(dmozDescriptionFile, DmozFileType.DESCRIPTION);
		logger.info("Generated " + dmozDescriptionEntries.size() + " DMOZ Description Entries from file [" + dmozDescriptionFile + "]");
		final List<DmozEntry> unifiedDmozEntries = new ArrayList<DmozEntry>();
		final Set<List<String>> keys = dmozIdEntries.keySet();
		for (final List<String> key : keys)
		{
			final DmozEntry idEntry = dmozIdEntries.get(key);
			final Long id = idEntry.getId();
			final DmozEntry urlEntry = dmozUrlEntries.get(key);
			final List<String> urls = urlEntry.getUrls();
			final DmozEntry descriptionEntry = dmozDescriptionEntries.get(key);
			final String description = descriptionEntry.getDescription();
			final DmozEntry unifiedEntry = new DmozEntry(key, id, urls, description);
			unifiedDmozEntries.add(unifiedEntry);
		}
		return unifiedDmozEntries;
	}
	
	public static void main(final String[] args) throws Exception 
	{		
		try
		{
			logger.info("Starting DMOZ Loader");
			final String dmozIdFile = "Z:\\data\\dmoz\\dmoz.8-12_test.cids";
			final String dmozUrlFile = "Z:\\data\\dmoz\\dmoz.8-12_test.urls";
			final String dmozDescriptionFile = "Z:\\data\\dmoz\\dmoz.8-12_test.descs";			
			final DmozLoader dmozLoader = new DmozLoader(dmozIdFile, dmozUrlFile, dmozDescriptionFile);
			dmozLoader.engage();
		}
		catch (Exception e)
		{
			final String errMsg = "Problem running DMOZ Loader";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}
}
