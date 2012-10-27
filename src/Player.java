//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////

import java.awt.Color;

public class Player 
{
	private int id;
	private String name;
	private boolean human;
	private boolean alive;
	private Color color;
	private int reinforcementsToPlace;
	private Card cards[] = new Card[10];
	private int  cards_int = 0;

	public Player(int id, String name, boolean human, Color color)
	{
		this.id = id;	
		this.name = name;
		this.human = human;
		this.color = color;
		this.alive = true;
		reinforcementsToPlace = 0;
	}
	public String getName()
	{
		return name;
	}
	public boolean isHuman()
	{
		return human;
	}
	public boolean isAlive()
	{
		return alive;
	}
	public void setAlive(boolean life)
	{
		alive = life;
	}
	public int getId()
	{
		return id;
	}
	public Color getColor()
	{
		return color;
	}
	public String getColorName()
	{
		String retval = new String("Black");
		if (color.toString().equals("java.awt.Color[r=255,g=0,b=0]"))
			retval = new String("Red");
		else if (color.toString().equals("java.awt.Color[r=255,g=175,b=175]"))
			retval = new String("Pink");
		else if (color.toString().equals("java.awt.Color[r=255,g=255,b=0]"))
			retval = new String("Yellow");
		else if (color.toString().equals("java.awt.Color[r=0,g=255,b=0]"))
			retval = new String("Green");
		else if (color.toString().equals("java.awt.Color[r=0,g=0,b=255]"))
			retval = new String("Blue");
		return retval;
	}
	public int getReinforcementsToBePlaced()
	{
		return reinforcementsToPlace;
	}
	public void addReinforcementsToBePlaced(int additions)
	{
		if(additions > 0)
		reinforcementsToPlace += additions;
	}
	public void decReinforcements()
	{
		reinforcementsToPlace--;
	}
	public void calculateInitialReinforcements(int numberOfPlayers)
	{
		// 3 Players: 35
		// 4 Players: 30
		// 5 Players: 25
		// 6 Players: 20
		reinforcementsToPlace = 35 - (numberOfPlayers - 3)*5;
	}
	public void calculateReinforcements(Continent c[])
	{
		reinforcementsToPlace = 0;
		for(int ctr = 0; ctr < 6; ctr++)
		{
			reinforcementsToPlace += c[ctr].calculateReinforcements(this);
		}
		reinforcementsToPlace /= 3;//divides reinforcements by 3 to give the correct amount
		if(reinforcementsToPlace < 3)
		{
			reinforcementsToPlace = 3;//minimum amount = 3			
		}
	}
	public void addCard(Card newCard)
	{
		cards[cards_int] = newCard;
		cards_int++;
	}
	public Card[] getCards()
	{
		return cards;
	}
	public void useCards(int index_1, int index_2, int index_3)
	{
		for(int ctr = index_3; ctr < cards_int; ctr++)
		{
			cards[ctr] = cards[ctr+1];
		}
		cards_int--;
		for(int ctr = index_2; ctr < cards_int; ctr++)
		{
			cards[ctr] = cards[ctr+1];
		}
		cards_int--;
		for(int ctr = index_1; ctr < cards_int; ctr++)
		{
			cards[ctr] = cards[ctr+1];
		}
		cards_int--;
		
		System.out.println("cards_int: " + cards_int);
		for(int ctr = 0; ctr < cards_int; ctr++)
		{
			System.out.println("Ctr: " + ctr + " -- " + cards[ctr].type);
		}
		
	}
}
