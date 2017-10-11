package ca.mcgill.cs.swdesign.m2;

import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

public class Deck
{
	private final Stack<Card> aCards;
	
	public Deck(Deck pDeck)
	{
		aCards = new Stack<>();
		for(Card card : pDeck.aCards)
		{
			aCards.add(card);
		}
	}
	
	public void sortBySuit()
	{
		Collections.sort(aCards, (o1,o2) ->
			o1.getSuit().compareTo(o2.getSuit())
			);
	}
	
	public void sortByRank()
	{
		Collections.sort(aCards, (o1,o2) ->
		o1.getRank().compareTo(o2.getRank())
		);
	}
	
	public Collection<Card> getCards()
	{
		return Collections.unmodifiableCollection(aCards);
	}
	
	public Deck()
	{
		aCards = new Stack<>();
		shuffle();
	}
	
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	public Card draw() throws EmptyDeckException
	{
		if( isEmpty() )
		{
			throw new EmptyDeckException();
		}
		return aCards.pop();
	}
	
	public void shuffle()
	{
		aCards.clear();
		for(Suit suit : Suit.values() )
		{
			for( Rank rank : Rank.values())
			{
				aCards.push(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}
	
	@Override
	public String toString()
	{
		StringWriter writer = new StringWriter();
		for( Card card : aCards )
		{
			writer.append(card.toString() + "\n");
		}
		return writer.toString();
	}
}
