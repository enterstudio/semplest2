// written by: Subhojit Som (subhojit@semplest.com)

package semplest.keywords.javautils;

import semplest.keywords.classification.Document;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BuildTree
{
	public static CategoryTree buildYahoo(String catLinkFile)
	{
		CategoryTree cTree = new CategoryTree();
		List<String> lines = ioUtils.readFile(catLinkFile);// semplest.keywords.javautils.readFile( catLinkFile );

		// ArrayList<String> listOfCategories = new ArrayList<String>();

		Set<String> setOfCategories = new HashSet<String>();
		Map<String, String> mapOfCategories = new HashMap<String, String>();

		String pattern = ".*dir.yahoo.com/(\\S+).*(anchor: )(.*)(\\S)";

		int i = 0;
		for (String line : lines)
		{
			if (line.contains("http://dir.yahoo.com") && line.contains("outlink") && !(line.contains("http://dir.yahoo.com/ anchor: Directory")))
			{
				// System.out.println(line);
				// System.out.println(line.replaceAll(pattern, "path: $1, name $3$4"));
				String path = line.replaceAll(pattern, "$1");
				setOfCategories.add(path);
				String name = line.replaceAll(pattern, "$3$4");
				mapOfCategories.put(path, name);
				i++;
			}
		}

		// build tree via multiple passes
		// in pass 1, add only paths ending at level 1 nodes
		// in pass 2, add only paths ending at level 2 nodes
		for (int length = 1; length < 25; length++)
		{
			for (String path : setOfCategories)
			{
				// System.out.println(path);
				String[] splitPath = path.split("/");
				if (splitPath.length == length)
				{
					cTree.addNode(path);
				}
			}
		}

		System.out.println("\nTotal number of raw outlinks: " + i + ", unique: " + mapOfCategories.size());
		System.out.println("Success: " + cTree.getTotNodes());
		System.out.println("Failure: " + cTree.getFailCount());

		return cTree;

	}

	public static CategoryTree buildDmoz(String catLinkFile, String category)
	{
		CategoryTree cTree = new CategoryTree();

		List<String> lines = ioUtils.readFile(catLinkFile);// semplest.keywords.javautils.readFile( catLinkFile );

		Set<String> setOfCategories = new HashSet<String>();
		Map<String, String> mapOfCategories = new HashMap<String, String>();
		Map<String, String> mapOfText = new HashMap<String, String>();

		int i = 0;
		for (String line : lines)
		{
			String path = line.replaceAll(":[0-9]*\\s+(.*)$", "");
			path = path.replaceAll("^top/" + category + "/", "");
			setOfCategories.add(path);
			String[] splitPath = path.split("/");
			String name = splitPath[splitPath.length - 1];
			mapOfCategories.put(path, name);
			String text = line.replaceAll("^\\S+:[0-9]*\\s+(.*)$", "$1");
			mapOfText.put(path, text);
			// HashMap<String,Integer> wordCountMap =
			i++;
		}

		// build tree via multiple passes
		// in pass 1, add only paths ending at level 1 nodes
		// in pass 2, add only paths ending at level 2 nodes
		for (int length = 1; length < 15; length++)
		{
			for (String path : setOfCategories)
			{
				// System.out.println(path);
				String[] splitPath = path.split("/");
				if (splitPath.length == length)
				{
					String text = mapOfText.get(path);
					String[] wordFreq = text.split("\\s+");
					Map<String, Integer> wordFreqHash = new HashMap<String, Integer>();
					for (String s : wordFreq)
					{
						String[] tuple = s.split(":");
						wordFreqHash.put(tuple[0], new Integer(Integer.parseInt(tuple[1])));
					}
					cTree.addNode(path, new Document(wordFreqHash));
				}
			}
		}

		System.out.println("\nTotal number of raw outlinks: " + i + ", unique: " + mapOfCategories.size());
		System.out.println("Success: " + cTree.getTotNodes());
		System.out.println("Failure: " + cTree.getFailCount());

		return cTree;

	}

	// public static void addTextToNodes

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		// String catLinkFile = "/semplest/data/yahoo/all/parsed/outlinks/dump";
		// // String catLinkFile = "/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/yahooDumpSegments/dump";
		// if ( args.length > 0 ) catLinkFile = args[0];
		// CategoryTree tree = BuildTree.buildYahoo(catLinkFile);
		String category = "shopping";
		String catLinkFile = "/semplest/data/dmoz/" + category + "/hCounts.txt";
		// String catLinkFile = "/home/subhojit/Softwares/apache-nutch-1.4-bin/runtime/local/yahooDumpSegments/dump";
		if (args.length > 0)
			catLinkFile = args[0];
		CategoryTree tree = BuildTree.buildDmoz(catLinkFile, category);

		// tree.traverseTree();
		// tree.dftGenGraph("/tmp/graph.txt");

	}

}
