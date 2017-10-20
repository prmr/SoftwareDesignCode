package ca.mcgill.cs.swdesign.m5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Composite role in the Composite design pattern. 
 * Represents a show that is a combination of other shows.
 * Implements interface Show so that a CompositeShow can be
 * treated as a show anywhere in the code.
 */
public class CompositeShow implements Show
{
	private String aName;
	private List<Show> aShows = new ArrayList<>();
	
	/**
	 * @param pName The name of the show.
	 * @param pShows The shows that compose this show.
	 */
	public CompositeShow(String pName, Show... pShows)
	{
		aName = pName;
		for( Show show : pShows )
		{
			aShows.add(show);
		}
	}
	
	/* (non-Javadoc)
	 * Performs a deep copy of the composite object, resulting
	 * in a completely distinct object graph.
	 * @see java.lang.Object#clone()
	 */
	@Override
	public CompositeShow clone()
	{
		try
		{
			CompositeShow clone = (CompositeShow) super.clone();
			clone.aShows = new ArrayList<>();
			for( Show show : aShows)
			{
				clone.aShows.add(show.clone());
			}
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}

	@Override
	public String description()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("[Show: " + aName);
		for( Show show : aShows )
		{
			builder.append(show.description());
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int runningTime()
	{
		int total = 0;
		for( Show show : aShows )
		{
			total += show.runningTime();
		}
		
		return total;
	}

	@Override
	public Iterator<Movie> iterator()
	{
		List<Movie> movies = new ArrayList<>();
		for( Show show : aShows )
		{
			for( Movie m : show )
			{
				movies.add(m);
			}
		}
		return movies.iterator();
	}
}
