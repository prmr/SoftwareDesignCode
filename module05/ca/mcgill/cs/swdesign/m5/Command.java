package ca.mcgill.cs.swdesign.m5;

/**
 * Command interface in the Command design 
 * pattern. Used to encapsulate commands applied
 * to operations on a Program.
 */
public interface Command
{
	/**
	 * Execute the command.
	 */
	void execute();
}
