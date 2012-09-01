package semplest.keywords.javautils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.keywords.classification.Document;

public class CategoryTree
{
	private static final Logger logger = Logger.getLogger(CategoryTree.class);

	private TreeNode root;
	private HashMap<String, TreeNode> nodeHash;
	public int totNodes = 0;
	public int failCount = 0;
	public int depth = 0;

	public CategoryTree()
	{
		root = new TreeNode();
		nodeHash = new HashMap<String, TreeNode>();
		nodeHash.put(new String(""), root);
		totNodes++;
	}

	public boolean addNode(String path)
	{
		String[] splitPath = path.split("/");
		TreeNode presentParent = root;
		int level = splitPath.length, i = 1;
		while (i < level)
		{
			List<TreeNode> presentChildren = presentParent.getChildren();
			boolean foundNextLevel = false;
			for (TreeNode t : presentChildren)
			{
				if (splitPath[i - 1].equals(t.getName()))
				{
					foundNextLevel = true;
					presentParent = t;
					i++;
					break;
				}
			}
			if (!foundNextLevel)
			{
				// System.out.println("Couldn't add to category tree: "+path);
				failCount++;
				return false;
			}

		}
		TreeNode node = new TreeNode(presentParent, splitPath[splitPath.length - 1]);
		presentParent.addChild(node);
		nodeHash.put(path, node);
		totNodes++;
		depth = Math.max(depth, level);
		return true;

		// System.out.println(totNodes);
	}

	public boolean addNode(String path, Document d)
	{
		String[] splitPath = path.split("/");
		TreeNode presentParent = root;
		int level = splitPath.length, i = 1;
		while (i < level)
		{
			List<TreeNode> presentChildren = presentParent.getChildren();
			boolean foundNextLevel = false;
			for (TreeNode t : presentChildren)
			{
				if (splitPath[i - 1].equals(t.getName()))
				{
					foundNextLevel = true;
					presentParent = t;
					i++;
					break;
				}
			}
			if (!foundNextLevel)
			{
				// System.out.println("Couldn't add to category tree: "+path);
				failCount++;
				return false;
			}

		}
		TreeNode node = new TreeNode(presentParent, splitPath[splitPath.length - 1], d);
		presentParent.addChild(node);
		nodeHash.put(path, node);
		totNodes++;
		depth = Math.max(depth, level);
		return true;

		// System.out.println(totNodes);
	}

	public TreeNode getNode(String path)
	{
		return nodeHash.get(path);
	}

	public void traverseTree()
	{
		root.dft(); // depth first traversal
	}

	public void dftGenGraph(String outFile)
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
			out.write("digraph Categories { node [shape = circle];\n");
			root.dftGenGraph(out); // depth first traversal
			out.write("}\n");
			out.close();
		}
		catch (IOException e)
		{
			logger.error("Problem", e);
			System.out.println("Unable to write to new file!!");
		}
	}

	public int getTotNodes()
	{
		return totNodes;
	}

	public int getFailCount()
	{
		return failCount;
	}

}
