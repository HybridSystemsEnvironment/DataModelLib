package edu.ucsc.cross.hse.model.data.packet;

public interface PacketHeader
{

	public Object getSource();

	public Object getTarget();

	public double getHeaderSize();

	public <T> T getIdTag(Class<T> type);

}
