package ca.mcgill.cs.swdesign.m1;

import ca.mcgill.cs.swdesign.m1.Card7.Suit;
import ca.mcgill.cs.swdesign.m1.Card7.Rank;

/** This client class is a stand in for any client code. 
 *  This version is adapted to work with Card7 
 */
public final class Client
{ 
	private Client()
	{}
	
	/**
	 * @param pArgs Not used here
	 */
	public static void main(String[] pArgs)
	{
		for( Rank rank : Rank.values() )
		{
			for( Suit suit : Suit.values() )
			{
				System.out.println(new Card7(rank, suit));
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	

}
