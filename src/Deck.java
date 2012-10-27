//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////
import java.util.Collections;
import java.util.ArrayList;

public class Deck
{
	ArrayList<Integer> deck = new ArrayList<Integer>();
	Card drawCard;
	int ctr = 0;
	boolean status;

	public Deck()
	{		
		for(int i=0; i < 44; i++)
		{
			deck.add(i);
		}
		Collections.shuffle(deck);		
	}
	
	public Card draw()
	{			
		if (deck.get(ctr) >= 0 && deck.get(ctr) <= 13)
			drawCard = new Card("helmet.JPG");
		if (deck.get(ctr) >= 14 && deck.get(ctr) <= 27)
			drawCard = new Card("horse.JPG");
		if (deck.get(ctr) >= 28 && deck.get(ctr) <= 41)
			drawCard = new Card("warrior.JPG");
		if (deck.get(ctr) >= 42 && deck.get(ctr) <= 43)
			drawCard = new Card("wildcard.JPG");
		
		ctr++;
		return drawCard;	
	}
	
	public boolean isEmpty()
	{	
		if (ctr > 43)
			status = true;
		else 
			status = false;
		
		return status;
	}
}

