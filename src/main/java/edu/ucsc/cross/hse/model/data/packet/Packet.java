package edu.ucsc.cross.hse.model.data.packet;

import edu.ucsc.cross.hse.model.data.Data;

public interface Packet
{

	public PacketHeader getHeader();

	public Data getPayload();

	public Double getTotalSize();

	public Double getDepartureTime();

	public Double getDeliveryTime();

	public PacketStatus getStatus();

	public void updateStatus(PacketStatus new_status);
}
