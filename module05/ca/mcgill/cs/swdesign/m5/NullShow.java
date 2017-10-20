package ca.mcgill.cs.swdesign.m5;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Realizes the null object pattern for Show.
 */
public final class NullShow implements Show
{
	/*
	 * In many cases null objects can be made singletons
	 * since there is no point in having multiple instances.
	 * 
	 * However, if the null object is part of a cloneable
	 * class hierarchy, then the singleton pattern is 
	 * incompatible with the requirements of the cloning
	 * method, which states that the result of clone()
	 * result in a distinct object.
	 * 
	 * A default instance is provided for convenience, but to
	 * avoid misleading users of the class into thinking it's a 
	 * singleton, the instance is labeled DEFAULT.
	 * 
	 * private NullShow() {}
	 */ 
	public static final NullShow DEFAULT = new NullShow();
	
	@Override
	public Iterator<Movie> iterator()
	{
		return new ArrayList<Movie>().iterator();
	}

	@Override
	public String description()
	{
		return "This is not really a show";
	}

	@Override
	public int runningTime()
	{
		return 0;
	}
	
	@Override
	public NullShow clone()
	{
		try
		{
			return (NullShow) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}

	@Override
	public String toString()
	{
		return "NullShow";
	}
	
	@Override
	public boolean isNull()
	{
		return true;
	}
}
