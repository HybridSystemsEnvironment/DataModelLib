package edu.ucsc.cross.hse.model.data.packet.header;

import edu.ucsc.cross.hse.model.data.packet.PacketHeader;

public class MinimalHeader implements PacketHeader
{

	private Object idTag;
	private Object source;
	private Object target;

	public MinimalHeader(Object idTag, Object source, Object target)
	{
		this.idTag = idTag;
		this.source = source;
		this.target = target;
	}

	@Override
	public double getHeaderSize()
	{
		// 8 bytes per address + 16 bytes id tag 
		return 32;
	}

	@Override
	public Object getSource()
	{
		return source;
	}

	@Override
	public Object getTarget()
	{
		return target;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getIdTag(Class<T> type)
	{
		if (idTag != null)
		{
			if (idTag.getClass().equals(type))
			{
				return (T) idTag;
			}
		}
		return null;
	}

}
