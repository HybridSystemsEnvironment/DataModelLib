package edu.ucsc.cross.hse.model.data.objects;

import java.util.ArrayList;

import edu.ucsc.cross.hse.model.data.Data;

public class SimulatedData implements Data
{

	private double simulatedSize;

	public SimulatedData(double simulated_size)
	{

		simulatedSize = simulated_size;
	}

	@Override
	public double getSize()
	{
		// TODO Auto-generated method stub
		return simulatedSize;
	}

	@Override
	public <D> D getData(Class<D> data)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <D> ArrayList<D> getDataSet(Class<D> data)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getId()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
