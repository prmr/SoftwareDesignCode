package ca.mcgill.cs.swdesign.m5.icon;

import java.util.Collections;
import java.util.Stack;

import ca.mcgill.cs.swdesign.m5.icon.Card.Rank;
import ca.mcgill.cs.swdesign.m5.icon.Card.Suit;

/**
 * A deck of cards.
 */
public class Deck
{
	private Stack<Card> aCards;
	
	/**
	 * Creates an empty deck.
	 */ 
	public Deck()
	{
		aCards = new Stack<Card>();
	}
	
	
	/**
	 * Resets the deck with all 52 cards and shuffles it. 
	 */
	public void shuffle()
	{
		aCards.clear();
		for( Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values())
			{
				aCards.push(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}
	
	/**
	 * @return True if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return The top card in the deck.
	 * @pre !isEmpty()
	 */
	public Card draw()
	{
		assert !isEmpty();
		return aCards.pop();
	}
}
