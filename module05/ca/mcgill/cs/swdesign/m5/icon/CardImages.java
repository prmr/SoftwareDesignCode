package ca.mcgill.cs.swdesign.m5.icon;


import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A class to store and manage images of the 52 cards.
 */
public final class CardImages 
{
	private static final String IMAGE_SUFFIX = ".gif";
	private static final String[] RANK_CODES = {"2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k", "a"};
	private static final String[] SUIT_CODES = {"c", "d", "s", "h"};	
	
	private static Map<String, ImageIcon> aCards = new HashMap<String, ImageIcon>();
	
	private CardImages()
	{}
	
	/**
	 * Demo/tester to ensure the card images can correctly 
	 * be found on the classpath.
	 * 
	 * @param pArgs Not used.
	 */
	public static void main(String[] pArgs)
	{
		JFrame frame = new JFrame();
		frame.add(new JLabel(CardImages.getBack()));
		frame.pack();
		frame.setVisible(true);
		
	}
	
	/**
	 * Return the image of a card.
	 * @param pCard the target card
	 * @return An icon representing the chosen card.
	 */
	public static ImageIcon getCard( Card pCard )
	{
		return getCard( getCode( pCard ) );
	}
	
	/**
	 * Return an image of the back of a card.
	 * @return An icon representing the back of a card.
	 */
	public static ImageIcon getBack()
	{
		return getCard( "b" );
	}
	
	/**
	 * Return an image of the joker.
	 * @return An icon representing the joker.
	 */
	public static ImageIcon getJoker()
	{
		return getCard( "j" );
	}
	
	private static String getCode( Card pCard )
	{
		return RANK_CODES[ pCard.getRank().ordinal() ] + SUIT_CODES[ pCard.getSuit().ordinal() ];		
	}
	
	private static ImageIcon getCard( String pCode )
	{
		ImageIcon lIcon = (ImageIcon) aCards.get( pCode );
		if( lIcon == null )
		{
			lIcon = new ImageIcon(CardImages.class.getClassLoader().getResource( pCode + IMAGE_SUFFIX ));
			aCards.put( pCode, lIcon );
		}
		return lIcon;
	}
}
