package edu.ucsc.cross.hse.model.data;

import java.util.ArrayList;

public interface Data
{

	public Object getId();

	public double getSize();

	public <D> D getData(Class<D> data);

	public <D> ArrayList<D> getDataSet(Class<D> data);

	public Data copy();

}
