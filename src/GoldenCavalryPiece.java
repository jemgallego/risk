//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////

public class GoldenCavalryPiece
{
	private int setCounter = 1; 
	private int reinforcements[] = {0,4,6,8,10,12,15};
	private int nextSetVal;
	
	public int checkNextSetValue()
	{
		if (setCounter <= 6)
		{
			return reinforcements[setCounter];
		}
		else 
		{
			return nextSetVal;
		}
	}
	public int getNextSetValue()
	{
		if (setCounter <= 6)
		{
			nextSetVal = reinforcements[setCounter]; 
			increaseSetValue();
	 
			return nextSetVal;
		}
		else 
		{
			nextSetVal += 5;
			increaseSetValue();
			
			return nextSetVal;
		}
	}
	private void increaseSetValue()
	{
		setCounter += 1;
	}
}
