//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class Dice 
{
	Random rand = new Random();

	public Dice(){}
	public int[] rolln(int numberOfDice)
	{
		int[] roll = new int[4];
		roll[0] = numberOfDice; //size informed array
		roll[1] = rand.nextInt(5) + 1;
		if(numberOfDice > 1)
		{
			roll[2] = rand.nextInt(5) + 1;
			if(roll[2] > roll[1])
			{
				int tmp = roll[1];
				roll[1] = roll[2];
				roll[2] = tmp;			               
			}
		}
		if(numberOfDice > 2)
		{
			roll[3] = rand.nextInt(5) + 1;
			if(roll[3] > roll[2])
			{
				int tmp = roll[2];
				roll[2] = roll[3];
				roll[3] = tmp;			               
				if(roll[2] > roll[1])
				{
					tmp = roll[1];
					roll[1] = roll[2];
					roll[2] = tmp;			               
				}
			}
		}
		return roll;
	}
}
