package ca.mcgill.cs.swdesign.m5;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Represents a show that consists of the screening of a single movie.
 */
public class Movie implements Show
{
	private String aTitle;
	private int aYear;
	private int aRunningTime;
	
	/**
	 * @param pTitle The title of the movie
	 * @param pYear The release year of the movide
	 * @param pTime The running time of the movie.
	 */
	public Movie(String pTitle, int pYear, int pTime)
	{
		aTitle = pTitle;
		aYear = pYear;
		aRunningTime = pTime;
	}
	
	@Override
	public Movie clone()
	{
		try
		{
			return (Movie) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}

	@Override
	public String description()
	{
		return String.format("%s (%d)", aTitle, aYear);
	}

	@Override
	public int runningTime()
	{
		return aRunningTime;
	}
	
	@Override
	public Iterator<Movie> iterator()
	{
		return Arrays.asList(new Movie[] {this}).iterator();
	}
}
