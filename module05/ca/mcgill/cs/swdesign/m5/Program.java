package ca.mcgill.cs.swdesign.m5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class responsible for managing a program that consists
 * of various shows presented on different days of one week.
 * 
 * This variant show an example of the Command design
 * pattern in use.
 */
public class Program
{
	private Show[] aShows = new Show[Day.values().length];
	private List<Command> aCommands = new ArrayList<>();
	
	/**
	 * Create an empty program.
	 */
	public Program()
	{
		Arrays.fill(aShows, NullShow.DEFAULT);
	}
	
	/**
	 * Clear the program by removing all shows.
	 */
	public void clear()
	{
		Command command = () -> Arrays.fill(aShows, NullShow.DEFAULT);
		aCommands.add(command);
		command.execute();
	}
	
	/**
	 * Adds a new show to the program.
	 * @param pShow The show to add.
	 * @param pDay The day when the show takes place.
	 */
	public void add(Show pShow, Day pDay)
	{
		assert pShow != null && pDay != null;
		Command command = () -> aShows[pDay.ordinal()] = pShow.clone();
		aCommands.add(command);
		command.execute();
	}
	
	
	/**
	 * Removes a show from the program.
	 * @param pDay The day when we want to zap the show.
	 */
	public void remove(Day pDay)
	{
		assert pDay != null;
		Command command = () -> aShows[pDay.ordinal()] = NullShow.DEFAULT;
		aCommands.add(command);
		command.execute();
	}
	
	/**
	 * Note that this is not implemented as a command since 
	 * it does not change the state of the program. This is ultimately
	 * a design decision.
	 * @param pDay The day of the requested show.
	 * @return A copy of the show on a given day.
	 */
	public Show get(Day pDay)
	{
		assert pDay != null;
		return aShows[pDay.ordinal()].clone();
	}
}
