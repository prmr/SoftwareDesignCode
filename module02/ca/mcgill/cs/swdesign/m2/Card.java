package ca.mcgill.cs.swdesign.m2;

import java.util.Comparator;

/**
 * Example of a Comparable card.
 */
public class Card implements Comparable<Card>
{
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	private final Rank aRank;
	private final Suit aSuit;
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * Copy constructor.
	 * @param pCard The card to copy.
	 */
	public Card( Card pCard )
	{
		aRank = pCard.aRank;
		aSuit = pCard.aSuit;
	}
	
	/**
	 * Non-anonymous static inner class implementation of Comparator.
	 */
	static class CompareBySuitFirst implements Comparator<Card>
	{
		@Override
		public int compare(Card pCard1, Card pCard2)
		{
			if( pCard1.getSuit() == pCard2.getSuit() )
			{
				return pCard1.getRank().compareTo(pCard2.getRank());
			}
			else
			{
				return pCard1.getSuit().ordinal() - pCard2.getSuit().ordinal();
			}
		}
	}
	
	/**
	 * Factory method.
	 * @return A comparator that compares cards by rank.
	 */
	public static Comparator<Card> createByRankComparator()
	{
		return new Comparator<Card>() 
		{
			@Override
			public int compare(Card pCard1, Card pCard2)
			{
				if( pCard1.getRank() == pCard2.getRank() )
					{
						return pCard1.getSuit().compareTo(pCard2.getSuit());
					}
					else
					{
						return pCard1.getRank().ordinal() - pCard2.getRank().ordinal();
					}
			}
		};
	}
	
	/**
 	 * A card's rank. The Rank object is a part of a Card object.
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
		CLUBS, DIAMONDS, SPADES, HEARTS;
		
		/**
		 * The color of a Card's suit.
		 */
		enum Color
		{
			RED, BLACK;
		}
		
		/**
		 * @return The suit's color.
		 */
		public Color getColor()
		{
			if( this == CLUBS || this == SPADES )
			{
				return Color.BLACK;
			}
			else
			{
				return Color.RED;
			}
		}
		
		@Override
		public String toString()
		{
			return name().substring(0, 1) + name().substring(1, name().length()).toLowerCase();
		}
	}
	

	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 */
	public Rank getRank()
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	@Override
	public String toString()
	{
		return getRank() + " of " + getSuit();
	}

	@Override
	public int compareTo(Card pCard)
	{
		if( getSuit() == pCard.getSuit() )
		{
			return getRank().compareTo(pCard.getRank());
		}
		else
		{
			return getSuit().ordinal() - pCard.getSuit().ordinal();
		}
	}
}
