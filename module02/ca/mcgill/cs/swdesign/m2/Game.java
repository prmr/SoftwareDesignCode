package ca.mcgill.cs.swdesign.m2;

public class Game
{
	private Deck aDeck = new Deck();
	
	public Game()
	{
		aDeck.shuffle();
		System.out.println(aDeck);
		aDeck.sortByRank();
		System.out.println(aDeck);
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
}
