package ca.mcgill.cs.swdesign.m5.icon;

/**
 * Same as version 7. My last example.
 */
public class Card implements Cloneable
{	
	/**
 	 * A card's rank.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS
	}
	
	private Rank aRank; // Invariant: != null
	private Suit aSuit; // Invariant: != null
	
	/**
	 * Create new card.
	 * 
	 * @param pRank The rank.
	 * @param pSuit The suit.
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		aRank = pRank;
		aSuit = pSuit;
	}
	@Override
	public boolean equals(Object pObject)
	{
		if( pObject == null )
		{ 
			return false; 
		}
		if( pObject == this ) 
		{
			return true;
		}
		if( pObject.getClass() != getClass() ) 
		{ 
			return false;
		}
		return aRank == ((Card)pObject).getRank() && aSuit == ((Card)pObject).getSuit();
	}
	
	@Override
	public int hashCode()
	{
		return aSuit.ordinal() * Rank.values().length + aRank.ordinal();
	}
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @post return != null
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 * @post return != null
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
}
