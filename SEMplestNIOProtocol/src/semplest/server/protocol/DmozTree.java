package semplest.server.protocol;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import semplest.util.SemplestUtils;

public class DmozTree
{
	private final DmozNode topNode;
	
	public DmozTree()
	{		
		this.topNode = new DmozNode(1L, 1L);
	}
	
	public DmozNode getTopNode()
	{
		return topNode;
	}
		
	public void add(final DmozEntry entry)
	{
		final List<String> levels = entry.getLevelNames();
		final Iterator<String> iterator = levels.iterator();
		final DmozNode leaf = getLeaf(topNode, iterator, entry);
		final Set<DmozEntry> entries = leaf.getEntries();
		entries.add(entry);
	}
	
	public DmozNode getLeaf(final DmozNode node, final Iterator<String> iterator, final DmozEntry entry)
	{
		if (iterator.hasNext())
		{
			final String level = iterator.next();
			final Map<String, DmozNode> children = node.getChildren();
			final DmozNode child;
			if (children.containsKey(level))
			{
				child = children.get(level);				
			}
			else
			{
				final Long pk = SemplestUtils.getNextDmozNodePK();
				final Long parentPk = node.getPk();
				child = new DmozNode(pk, parentPk);
				children.put(level, child);
			}
			getLeaf(child, iterator, entry);
		}
		return node;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((topNode == null) ? 0 : topNode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DmozTree other = (DmozTree) obj;
		if (topNode == null)
		{
			if (other.topNode != null)
				return false;
		}
		else if (!topNode.equals(other.topNode))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "DmozTree [topNode=" + topNode + "]";
	}
	
	
	
}
