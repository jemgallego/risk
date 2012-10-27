//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////

public class Continent 
{
	private String name;
	private int reinforcementValue;
	private Territory[] territories;
	private int numberOfTerritoriesInContinent;
	private int offset;
	
	public Continent(String name)
	{
		this.name = name;
		if(name.equalsIgnoreCase("N. America"))
		{
			offset = 0;
			reinforcementValue = 5;
			numberOfTerritoriesInContinent = 9;

			territories = new Territory[numberOfTerritoriesInContinent];
			territories[0] = new Territory("Alaska");
			territories[0].addAdjacentTerritory("Northwest Territory");
			territories[0].addAdjacentTerritory("Kamchatka");
			territories[0].addAdjacentTerritory("Alberta");

			territories[1] = new Territory("Northwest Territory");
			territories[1].addAdjacentTerritory("Alaska");
			territories[1].addAdjacentTerritory("Alberta");
			territories[1].addAdjacentTerritory("Ontario");
			territories[1].addAdjacentTerritory("Greenland");

			territories[2] = new Territory("Greenland");
			territories[2].addAdjacentTerritory("Northwest Territory");
			territories[2].addAdjacentTerritory("Ontario");
			territories[2].addAdjacentTerritory("Quebec");
			territories[2].addAdjacentTerritory("Iceland");

			territories[3] = new Territory("Alberta");
			territories[3].addAdjacentTerritory("Alaska");
			territories[3].addAdjacentTerritory("Northwest Territory");
			territories[3].addAdjacentTerritory("Ontario");
			territories[3].addAdjacentTerritory("Western United States");

			territories[4] = new Territory("Ontario");
			territories[4].addAdjacentTerritory("Alberta");
			territories[4].addAdjacentTerritory("Northwest Territory");
			territories[4].addAdjacentTerritory("Greenland");
			territories[4].addAdjacentTerritory("Quebec");
			territories[4].addAdjacentTerritory("Eastern United States");
			territories[4].addAdjacentTerritory("Western United States");

			territories[5] = new Territory("Quebec");
			territories[5].addAdjacentTerritory("Eastern United States");
			territories[5].addAdjacentTerritory("Ontario");
			territories[5].addAdjacentTerritory("Greenland");
			
			territories[6] = new Territory("Western United States");
			territories[6].addAdjacentTerritory("Alberta");
			territories[6].addAdjacentTerritory("Ontario");
			territories[6].addAdjacentTerritory("Eastern United States");
			territories[6].addAdjacentTerritory("Central America");

			territories[7] = new Territory("Eastern United States");
			territories[7].addAdjacentTerritory("Central America");
			territories[7].addAdjacentTerritory("Western United States");
			territories[7].addAdjacentTerritory("Ontario");
			territories[7].addAdjacentTerritory("Quebec");

			territories[8] = new Territory("Central America");
			territories[8].addAdjacentTerritory("Western United States");
			territories[8].addAdjacentTerritory("Eastern United States");
			territories[8].addAdjacentTerritory("Venezuela");
		}
		else if(name.equalsIgnoreCase("S. America"))
		{
			offset = 9;
			reinforcementValue = 2;
			numberOfTerritoriesInContinent = 4;
			territories = new Territory[numberOfTerritoriesInContinent];
			territories[0] = new Territory("Venezuela");
			territories[1] = new Territory("Peru");
			territories[2] = new Territory("Brazil");
			territories[3] = new Territory("Argentina");
			
			territories[0].addAdjacentTerritory("Central America");
			territories[0].addAdjacentTerritory("Peru");
			territories[0].addAdjacentTerritory("Brazil");
			territories[1].addAdjacentTerritory("Venezuela");
			territories[1].addAdjacentTerritory("Brazil");
			territories[1].addAdjacentTerritory("Argentina");
			territories[2].addAdjacentTerritory("Venezuela");
			territories[2].addAdjacentTerritory("Peru");
			territories[2].addAdjacentTerritory("Argentina");
			territories[2].addAdjacentTerritory("North Africa");
			territories[3].addAdjacentTerritory("Peru");
			territories[3].addAdjacentTerritory("Brazil");
		}
		else if(name.equalsIgnoreCase("Europe"))
		{
			offset = 13;
			reinforcementValue = 5;
			numberOfTerritoriesInContinent = 7;
			territories = new Territory[numberOfTerritoriesInContinent];
			territories[0] = new Territory("Iceland");
			territories[1] = new Territory("Scandinavia");
			territories[2] = new Territory("Ukraine");
			territories[3] = new Territory("Great Britain");
			territories[4] = new Territory("Northern Europe");
			territories[5] = new Territory("Western Europe");
			territories[6] = new Territory("Southern Europe");
			
			territories[0].addAdjacentTerritory("Greenland");
			territories[0].addAdjacentTerritory("Great Britain");
			territories[1].addAdjacentTerritory("Great Britain");
			territories[1].addAdjacentTerritory("Northern Europe");
			territories[1].addAdjacentTerritory("Ukraine");
			territories[2].addAdjacentTerritory("Scandinavia");
			territories[2].addAdjacentTerritory("Northern Europe");
			territories[2].addAdjacentTerritory("Southern Europe");
			territories[2].addAdjacentTerritory("Middle East");
			territories[2].addAdjacentTerritory("Afghanistan");
			territories[2].addAdjacentTerritory("Ural");
			territories[3].addAdjacentTerritory("Iceland");
			territories[3].addAdjacentTerritory("Scandinavia");
			territories[3].addAdjacentTerritory("Northern Europe");
			territories[3].addAdjacentTerritory("Western Europe");
			territories[4].addAdjacentTerritory("Great Britain");
			territories[4].addAdjacentTerritory("Scandinavia");
			territories[4].addAdjacentTerritory("Ukraine");
			territories[4].addAdjacentTerritory("Southern Europe");
			territories[4].addAdjacentTerritory("Western Europe");
			territories[5].addAdjacentTerritory("Great Britain");
			territories[5].addAdjacentTerritory("Northern Europe");
			territories[5].addAdjacentTerritory("Southern Europe");
			territories[5].addAdjacentTerritory("North Africa");
			territories[6].addAdjacentTerritory("Western Europe");
			territories[6].addAdjacentTerritory("Northern Europe");
			territories[6].addAdjacentTerritory("Ukraine");
			territories[6].addAdjacentTerritory("Middle East");
			territories[6].addAdjacentTerritory("Egypt");
			territories[6].addAdjacentTerritory("North Africa");
		}
		else if(name.equalsIgnoreCase("Africa"))
		{
			offset = 20;
			reinforcementValue = 3;
			numberOfTerritoriesInContinent = 6;
			territories = new Territory[numberOfTerritoriesInContinent];
			territories[0] = new Territory("North Africa");
			territories[1] = new Territory("Egypt");
			territories[2] = new Territory("East Africa");
			territories[3] = new Territory("Congo");
			territories[4] = new Territory("South Africa");
			territories[5] = new Territory("Madagascar");
			
			territories[0].addAdjacentTerritory("Brazil");
			territories[0].addAdjacentTerritory("Western Europe");
			territories[0].addAdjacentTerritory("Southern Europe");
			territories[0].addAdjacentTerritory("Egypt");
			territories[0].addAdjacentTerritory("East Africa");
			territories[0].addAdjacentTerritory("Congo");
			territories[1].addAdjacentTerritory("North Africa");
			territories[1].addAdjacentTerritory("Southern Europe");
			territories[1].addAdjacentTerritory("Middle East");
			territories[1].addAdjacentTerritory("East Africa");
			territories[2].addAdjacentTerritory("North Africa");
			territories[2].addAdjacentTerritory("Egypt");
			territories[2].addAdjacentTerritory("Madagascar");
			territories[2].addAdjacentTerritory("South Africa");
			territories[2].addAdjacentTerritory("Congo");
			territories[3].addAdjacentTerritory("North Africa");
			territories[3].addAdjacentTerritory("East Africa");
			territories[3].addAdjacentTerritory("South Africa");
			territories[4].addAdjacentTerritory("Congo");
			territories[4].addAdjacentTerritory("East Africa");
			territories[4].addAdjacentTerritory("Madagascar");
			territories[5].addAdjacentTerritory("South Africa");
			territories[5].addAdjacentTerritory("East Africa");
		}
		else if(name.equalsIgnoreCase("Asia"))
		{
			offset = 26;
			reinforcementValue = 7;
			numberOfTerritoriesInContinent = 12;
			territories = new Territory[numberOfTerritoriesInContinent];
			territories[0] = new Territory("Ural");
			territories[1] = new Territory("Siberia");
			territories[2] = new Territory("Yakutsk");
			territories[3] = new Territory("Kamchatka");
			territories[4] = new Territory("Irkutsk");
			territories[5] = new Territory("Mongolia");
			territories[6] = new Territory("Afghanistan");
			territories[7] = new Territory("China");
			territories[8] = new Territory("Japan");
			territories[9] = new Territory("Middle East");
			territories[10] = new Territory("India");
			territories[11] = new Territory("Siam");
			
			territories[0].addAdjacentTerritory("Ukraine");
			territories[0].addAdjacentTerritory("Afghanistan");
			territories[0].addAdjacentTerritory("China");
			territories[0].addAdjacentTerritory("Siberia");
			territories[1].addAdjacentTerritory("Ural");
			territories[1].addAdjacentTerritory("China");
			territories[1].addAdjacentTerritory("Mongolia");
			territories[1].addAdjacentTerritory("Irkutsk");
			territories[1].addAdjacentTerritory("Yakutsk");
			territories[2].addAdjacentTerritory("Siberia");
			territories[2].addAdjacentTerritory("Irkutsk");
			territories[2].addAdjacentTerritory("Kamchatka");
			territories[3].addAdjacentTerritory("Yakutsk");
			territories[3].addAdjacentTerritory("Irkutsk");
			territories[3].addAdjacentTerritory("Mongolia");
			territories[3].addAdjacentTerritory("Japan");
			territories[3].addAdjacentTerritory("Alaska");
			territories[4].addAdjacentTerritory("Siberia");
			territories[4].addAdjacentTerritory("Yakutsk");
			territories[4].addAdjacentTerritory("Kamchatka");
			territories[4].addAdjacentTerritory("Mongolia");
			territories[5].addAdjacentTerritory("Siberia");
			territories[5].addAdjacentTerritory("Irkutsk");
			territories[5].addAdjacentTerritory("Kamchatka");
			territories[5].addAdjacentTerritory("Japan");
			territories[5].addAdjacentTerritory("China");
			territories[6].addAdjacentTerritory("Ukraine");
			territories[6].addAdjacentTerritory("Ural");
			territories[6].addAdjacentTerritory("China");
			territories[6].addAdjacentTerritory("India");
			territories[6].addAdjacentTerritory("Middle East");
			territories[7].addAdjacentTerritory("Afghanistan");
			territories[7].addAdjacentTerritory("Ural");
			territories[7].addAdjacentTerritory("Siberia");
			territories[7].addAdjacentTerritory("Mongolia");
			territories[7].addAdjacentTerritory("Siam");
			territories[7].addAdjacentTerritory("India");
			territories[8].addAdjacentTerritory("Mongolia");
			territories[8].addAdjacentTerritory("Kamchatka");
			territories[9].addAdjacentTerritory("Egypt");
			territories[9].addAdjacentTerritory("Southern Europe");
			territories[9].addAdjacentTerritory("Ukraine");
			territories[9].addAdjacentTerritory("Afghanistan");
			territories[9].addAdjacentTerritory("India");
			territories[9].addAdjacentTerritory("East Africa");
			territories[10].addAdjacentTerritory("Middle East");
			territories[10].addAdjacentTerritory("Afghanistan");
			territories[10].addAdjacentTerritory("China");
			territories[10].addAdjacentTerritory("Siam");
			territories[11].addAdjacentTerritory("India");
			territories[11].addAdjacentTerritory("China");
			territories[11].addAdjacentTerritory("Indonesia");
		}
		else if(name.equalsIgnoreCase("Australia"))
		{
			offset = 38;
			reinforcementValue = 2;
			numberOfTerritoriesInContinent = 4;
			territories = new Territory[numberOfTerritoriesInContinent];
			territories[0] = new Territory("Indonesia");
			territories[1] = new Territory("New Guinea");
			territories[2] = new Territory("Western Australia");
			territories[3] = new Territory("Eastern Australia");
		
			territories[0].addAdjacentTerritory("Siam");
			territories[0].addAdjacentTerritory("New Guinea");
			territories[0].addAdjacentTerritory("Western Australia");
			territories[1].addAdjacentTerritory("Indonesia");
			territories[1].addAdjacentTerritory("Western Australia");
			territories[1].addAdjacentTerritory("Eastern Australia");
			territories[2].addAdjacentTerritory("Indonesia");
			territories[2].addAdjacentTerritory("New Guinea");
			territories[2].addAdjacentTerritory("Eastern Australia");
			territories[3].addAdjacentTerritory("Western Australia");
			territories[3].addAdjacentTerritory("New Guinea");
		}
	}
	public Territory getTerritory(int ctr)
	{
		Territory retval = null;
		if(ctr >= offset && ctr < 42)
		{
			retval = territories[ctr-offset];
		}
		return retval;
	}
	public int getOffset()
	{
		return offset;
	}
	public int calculateReinforcements(Player p)
	{
		int sum = 0;
		for(int ctr = 0; ctr < numberOfTerritoriesInContinent; ctr++)
		{
			if(territories[ctr].getOwner() == p.getId())
			{
				sum++;
			}
		}
		if(sum == numberOfTerritoriesInContinent)
		{
			sum += reinforcementValue*3;
		}
		return sum;
		//returns 3 times the value of reinforcements earned from this continent
	}
}
