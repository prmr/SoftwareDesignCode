package ca.mcgill.cs.swdesign.m5;

/**
 * Represents any kind of show involving the screening of one or more movies.
 * All subtypes of show should be iterable over movies and Cloneable.
 */
public interface Show extends Iterable<Movie>, Cloneable
{
	/**
	 * @return A description of the show.
	 */
	String description();
	
	
	/**
	 * @return The running time of the show.
	 */
	int runningTime();
	
	/**
	 * Support for the null object pattern. By default
	 * the object is not-null. Should be overriden in the 
	 * NullObject class.
	 * @return True If it's a reference to the NullShow instance
	 */
	default boolean isNull() 
	{ 
		return false; 
	}
	
	/**
	 * @return a clone
	 */
	Show clone();
}
