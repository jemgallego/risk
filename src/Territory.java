//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////

public class Territory
{
	private int owner;
	private String name;
	private String[] adjacentTerritories;
	private int numberOfAdjacentTerritories;
	private Army units;
	
	public Territory(String name)
	{
		this.name = name;
		this.owner = -1;
		numberOfAdjacentTerritories = 0;
		adjacentTerritories = new String[10];
		units = new Army();
	}
	public boolean claimTerritory(int player)
	{
		boolean retval = false;
		if(owner == -1)
		{
			retval = true;
			owner = player;
			units.incrementUnitsBy1();
		}
		return retval;
	}
	public void addAdjacentTerritory(String territory)
	{
		adjacentTerritories[numberOfAdjacentTerritories] = new String(territory);
		numberOfAdjacentTerritories += 1;
	}
	public boolean setControl(int player)
	{
		boolean retval = false;
		if(player >= 0 && player < 6)
		{
			retval = true;
			owner = player;
		}
		return retval;
	}
	public void setArmy(Army a)
	{
		units = a;
	}
	public Army getArmy()
	{
		return units;
	}
	public String getName()
	{
		return name;
	}
	public int getOwner()
	{
		return owner;
	}
	public boolean isAdjacent(Territory territory)
	{
		boolean retval = false;
		for(int ctr = 0; ctr < numberOfAdjacentTerritories && retval == false; ctr++)
		{
			retval = adjacentTerritories[ctr].equalsIgnoreCase(territory.getName());
		}
		return retval;
	}
}
