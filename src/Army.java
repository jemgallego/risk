// Risk Project - CECS 343
// Joseph Buss, John Gallego, Jonathan Stoner

public class Army 
{
	private int numberOfUnits = 0;
	
	public Army()
	{
		this.numberOfUnits = 0;
	}
	public Army(int owner, int numberOfUnits)
	{
		this.numberOfUnits = numberOfUnits;
	}
	
	public void defend1(){}
	public void defend2(){}
	public void attack1(){}
	public void attack2(){}
	public void attack3(){}
	public void retreat(){}

	public void setNumberOfUnits(int tmp)
	{
		if(tmp > 0)
		{
			numberOfUnits = tmp;
		}
	}
	public int getNumberOfUnits()
	{
		return numberOfUnits;
	}
	public void incrementUnitsBy1()
	{
		numberOfUnits++;
	}
	public void decrementUnitsBy1()
	{
		numberOfUnits--;
	}
	public boolean checkIf0()
	{
		return(numberOfUnits < 1);
	}
	public void mergeArmies(Army a)
	{
		if(a != null && a.getNumberOfUnits() > 0)
		numberOfUnits += (a.getNumberOfUnits()-1);
	}
}