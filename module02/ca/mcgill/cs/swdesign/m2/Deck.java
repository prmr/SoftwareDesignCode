package ca.mcgill.cs.swdesign.m2;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

/**
 * A Deck of playing cards.
 *
 */
public final class Deck implements Iterable<Card>
{
	private  Stack<Card> aCards = new Stack<>();
	
	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}
	
	/**
	 * Resets and shuffles the deck so that it contains
	 * all cards in random order.
	 */
	public void shuffle()
	{
		aCards.clear();
		for(Suit suit : Suit.values())
		{
			for(Rank rank : Rank.values())
			{
				aCards.push(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
		
	}
	
	/**
	 * Three different options are shown in parallel here. Clearly in a real program
	 * you would select only one.
	 */
	public void sort()
	{				
		Collections.sort(aCards, new Comparator<Card>()
		{

			@Override
			public int compare(Card pCard1, Card pCard2)
			{
				if (pCard1.getRank() == pCard2.getRank())
				{
					return pCard1.getSuit().compareTo(pCard2.getSuit());
				}
				else
				{
					return pCard1.getRank().ordinal() - pCard2.getRank().ordinal();
				}
			}
		});

		// This version uses the Java 8 lambda expression (closure) feature.
		Collections.sort(aCards, (pCard1, pCard2) -> pCard1.getRank().compareTo(pCard2.getRank()));

		Collections.sort(aCards, new Card.CompareBySuitFirst());
	}
	
	/**
	 * Removes the top card and returns it.
	 * @return The card at the top of the deck.
	 */
	public Card draw()
	{
		return aCards.pop();
	}
	
	/**
	 * @return True if there are no cards in the deck.
	 */
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	/**
	 * @return The top card of the deck without removing it.
	 */
	public Card peek()
	{
		assert !isEmpty();
		return aCards.peek();
	}
}
