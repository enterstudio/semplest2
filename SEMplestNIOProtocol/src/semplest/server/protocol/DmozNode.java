package semplest.server.protocol;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DmozNode
{
	private final Long pk;
	private final Long parentPk;
	private final Set<DmozEntry> entries;
	private final Map<String, DmozNode> children;
	
	public DmozNode(final Long pk, final Long parentPk)
	{
		this.pk = pk;
		this.parentPk = parentPk;
		entries = new HashSet<DmozEntry>();
		children = new LinkedHashMap<String, DmozNode>();
	}
		
	public Long getPk()
	{
		return pk;
	}

	public Map<String, DmozNode> getChildren()
	{
		return children;
	}

	public Set<DmozEntry> getEntries()
	{
		return entries;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
		result = prime * result + ((parentPk == null) ? 0 : parentPk.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		DmozNode other = (DmozNode) obj;
		if (children == null)
		{
			if (other.children != null)
				return false;
		}
		else if (!children.equals(other.children))
			return false;
		if (entries == null)
		{
			if (other.entries != null)
				return false;
		}
		else if (!entries.equals(other.entries))
			return false;
		if (parentPk == null)
		{
			if (other.parentPk != null)
				return false;
		}
		else if (!parentPk.equals(other.parentPk))
			return false;
		if (pk == null)
		{
			if (other.pk != null)
				return false;
		}
		else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "DmozNode [pk=" + pk + ", parentPk=" + parentPk + ", entries=" + entries + ", children=" + children + "]";
	}
		
}
