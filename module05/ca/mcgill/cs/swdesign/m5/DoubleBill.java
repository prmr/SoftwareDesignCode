package ca.mcgill.cs.swdesign.m5;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Represents a show that consists of the screening of two movies
 * in sequence.
 */
public class DoubleBill implements Show
{
	private Movie aMovie1;
	private Movie aMovie2;
	
	/**
	 * @param pMovie1 The first movie.
	 * @param pMovie2 The second movie.
	 */
	public DoubleBill(Movie pMovie1, Movie pMovie2)
	{
		aMovie1 = pMovie1;
		aMovie2 = pMovie2;
	}

	@Override
	public String description()
	{
		return String.format("%s and %s", aMovie1.description(), aMovie2.description());
	}

	@Override
	public int runningTime()
	{
		return aMovie1.runningTime() + aMovie2.runningTime();
	}

	@Override
	public Iterator<Movie> iterator()
	{
		return Arrays.asList(new Movie[] {aMovie1, aMovie2}).iterator();
	}
}
