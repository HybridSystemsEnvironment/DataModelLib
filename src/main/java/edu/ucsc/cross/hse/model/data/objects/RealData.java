package edu.ucsc.cross.hse.model.data.objects;

import java.util.ArrayList;

import com.be3short.data.cloning.ObjectCloner;
import com.carrotsearch.sizeof.RamUsageEstimator;

import edu.ucsc.cross.hse.model.data.Data;

public class RealData implements Data
{

	private Object id;
	/**
	 * File Content Mapping : Stores all file contents
	 */
	private ArrayList<Object> fileContents;

	/**
	 * Create a new object collection and adds any objects specified as inputs
	 * 
	 * @param <T>
	 * 
	 * @param object
	 *            an object (or objects) to be added to the collection
	 */
	@SafeVarargs
	public <T> RealData(T... data)
	{
		id = this.toString();
		initializeObjectMap();
		addObject(data);
	}

	/**
	 * Add objects to the file
	 * 
	 * @param object
	 *            an object (or objects) to be added to the collection
	 */

	@SuppressWarnings("unchecked")
	public <T> void addObject(T... content)
	{
		for (T content_item : content)
		{

			if (content_item != null)
			{
				storeObject(content_item);
			}
		}
	}

	/**
	 * Get an object from the file. Returns the first object in the list if
	 * there are multiple objects of the specified class in the collection, or
	 * returns null if there are no objects of the specified class in the
	 * collections
	 * 
	 * @param object_class
	 *            class of the object to be retrieved
	 * 
	 * @return the first object in the list if there are multiple objects of the
	 *         specified class in the collection, or returns null if there are
	 *         no objects of the specified class in the collections
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getData(Class<T> object_class)
	{
		T content = null;
		for (Object obj : fileContents)
		{
			if (obj.getClass().equals(object_class) || obj.getClass() == object_class)
			{
				content = ((T) obj);
				break;
			}
		}
		return content;
	}

	/**
	 * Returns a list of stored objects of the specified class.
	 * 
	 * @param object_class
	 *            class of the list of contents to be retrieved
	 * 
	 * @return content list containing objects of specified content type
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> ArrayList<T> getDataSet(Class<T> object_class)
	{
		ArrayList<T> contents = new ArrayList<T>();
		for (Object obj : fileContents)
		{
			if (obj.getClass().equals(object_class))
			{
				contents.add((T) obj);
			}
		}
		return contents;
	}

	/**
	 * Initializes the content mapping with lists for all of the system objects
	 */
	private void initializeObjectMap()
	{
		fileContents = new ArrayList<Object>();

	}

	/**
	 * Processes the storage of internal contents
	 * 
	 * @param object
	 *            to be stored
	 */
	private <T> void storeObject(T object)
	{
		fileContents.add(object);

	}

	@Override
	public double getSize()
	{

		return RamUsageEstimator.sizeOfAll(fileContents);
	}

	@Override
	public Object getId()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Data copy()
	{
		// TODO Auto-generated method stub
		RealData data = (RealData) ObjectCloner.xmlClone(this);
		data.id = id;
		return data;
	}

}