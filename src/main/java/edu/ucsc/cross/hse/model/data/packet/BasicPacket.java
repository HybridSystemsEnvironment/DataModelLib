package edu.ucsc.cross.hse.model.data.packet;

import edu.ucsc.cross.hse.core.modeling.DataStructure;
import edu.ucsc.cross.hse.model.data.Data;

public class BasicPacket extends DataStructure implements Packet
{

	private PacketHeader header;
	private Data payload;
	private PacketStatus status;

	public BasicPacket(PacketHeader header, Data payload)
	{
		status = PacketStatus.IDLE;
		this.header = header;
		this.payload = payload;
	}

	@Override
	public PacketHeader getHeader()
	{
		// TODO Auto-generated method stub
		return header;
	}

	@Override
	public Data getPayload()
	{
		// TODO Auto-generated method stub
		return payload;
	}

	@Override
	public Double getTotalSize()
	{
		// TODO Auto-generated method stub
		return payload.getSize() + header.getHeaderSize();
	}

	@Override
	public Double getDepartureTime()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getDeliveryTime()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacketStatus getStatus()
	{
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public void updateStatus(PacketStatus new_status)
	{
		// TODO Auto-generated method stub
		status = new_status;
	}

}
