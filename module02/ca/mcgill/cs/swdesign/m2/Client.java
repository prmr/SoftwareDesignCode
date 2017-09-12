package ca.mcgill.cs.swdesign.m2;

/**
 * Stand-in for the rest of the program.
 *
 */
public final class Client
{
	private Client()
	{}
	
	/**
	 * Driver program.
	 * @param pArgs not used.
	 */
	public static void main(String[] pArgs)
	{
		Deck deck = new Deck();
		deck.shuffle();
		
		for( Card card : deck)
		{
			System.out.println(card);
		}
	}
}
