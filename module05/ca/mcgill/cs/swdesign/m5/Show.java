package ca.mcgill.cs.swdesign.m5;

/**
 * Represents any kind of show involving the screening of one or more movies.
 */
public interface Show extends Iterable<Movie>
{
	/**
	 * @return A description of the show.
	 */
	String description();
	
	
	/**
	 * @return The running time of the show.
	 */
	int runningTime();
}
