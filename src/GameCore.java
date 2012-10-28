// Risk Project - CECS 343
// Joseph Buss, John Gallego, Jonathan Stoner

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class GameCore extends JFrame implements ActionListener
{
//////////////////////////////////////////////////////////////////////////////////
//	VARIABLE DECLARATION
//////////////////////////////////////////////////////////////////////////////////

	//Used for smooth return from battle
	public static boolean battleRaging = false;
	public static boolean territoryConquered = false;
	public static Territory t1 = new Territory("t1");
	public static Territory t2 = new Territory("t2");
	
	//Needed for JOptionPane to be called from the mouse listener
	private GameCore frame;

	//Needed to handle mouse input
	private MouseListener listener_mouse;
	
	//Store Player values
	private int numberOfPlayers;
	private Player players[];
    
	//Panels
	private JPanel map_pnl = new JPanel();
	private JPanel battle_pnl = new JPanel();
	private JPanel sideBar1_pnl = new JPanel();
	private JPanel sideBar2_pnl = new JPanel();
	private JPanel sideBar3_pnl = new JPanel();
	private JPanel placeReinforcements_pnl = new JPanel();
	private JPanel attackPhase_pnl = new JPanel();
	private JPanel fortifyPhase_pnl = new JPanel();
	private JPanel bottomBar_pnl = new JPanel();
	
	//Labels
	public static JLabel status = new JLabel();
	JLabel p1_Name_lbl = new JLabel();
	JLabel p2_Name_lbl = new JLabel();
	JLabel p3_Name_lbl = new JLabel();
	JLabel p4_Name_lbl = new JLabel();
	JLabel p5_Name_lbl = new JLabel();
	JLabel p6_Name_lbl = new JLabel();
	JLabel p1_Icon = new JLabel();
	JLabel p2_Icon = new JLabel();
	JLabel p3_Icon = new JLabel();
	JLabel p4_Icon = new JLabel();
	JLabel p5_Icon = new JLabel();
	JLabel p6_Icon = new JLabel();
	JLabel turnIndicator_lbl = new JLabel();
	   int turnIndicator_int;//Possible Values: 0,1,2,3,4,5
	JLabel reinforcementsToBePlaced_lbl = new JLabel();
	JLabel zone_lbls[] = new JLabel[42];

	//Buttons
    JButton endAttackPhase_btn;
    JButton endFortifyPhase_btn;
    
    //Deck of cards
	JLabel card_lbls[] = new JLabel[9];
	Deck d = new Deck();
	
	//Keeps track of the value of card sets
	GoldenCavalryPiece gcp = new GoldenCavalryPiece();
	JLabel reinforcements_lbl = new JLabel();
	
	//Continents
	Continent continents[] = new Continent[6];

//////////////////////////////////////////////////////////////////////////////////
//	CONSTRUCTOR
//////////////////////////////////////////////////////////////////////////////////
	public GameCore(Player[] players, int numberOfPlayers, int firstPlayer)
	{
		frame = this;
		this.setTitle("RISK: 2003 Edition");
		this.getContentPane().setLayout(null);;
		this.setVisible(true);
		this.setBounds(300,200, 1007,628);
		
		turnIndicator_int = firstPlayer;
		this.numberOfPlayers = numberOfPlayers;
		this.players = new Player[numberOfPlayers];
		for(int ctr = 0; ctr < numberOfPlayers; ctr++)
		{
			this.players[ctr] = players[ctr];
		}
			    
	    initializeZoneLabels();	//Top layer
	    initializePanels();		//Bottom layer
	    
	    //Players may begin claiming territories until all are claimed
	    startClaimTerritoryPhase();
	}
	
//////////////////////////////////////////////////////////////////////////////////
//	INITIALIZATION METHODS
//////////////////////////////////////////////////////////////////////////////////
	private void initializePanels()
	{	
//		Map: 758 x 425
//		bottomBar: 758 x 175
//		sideBar1: 242 x 219
//		sideBar2: 242 x 232
//		sideBar3: 242 x 149
		
/////////Add Map Panel//////////////////////////////////////////////////////
    	map_pnl.setBounds(0,0,758,425);
    	map_pnl.setLayout(null);
        JLabel map = addImage("map.JPG", 0, 0);
        map_pnl.add(map);
    	this.add(map_pnl);
    	
    	continents[0] = new Continent("N. America");
    	continents[1] = new Continent("S. America");
    	continents[2] = new Continent("Europe");
    	continents[3] = new Continent("Africa");
    	continents[4] = new Continent("Asia");
    	continents[5] = new Continent("Australia");
    	
/////////Add Bottom Panel//////////////////////////////////////////////////////
    	bottomBar_pnl.setBounds(0,425,758,175);
    	bottomBar_pnl.setLayout(null);    

		reinforcements_lbl.setFont(reinforcements_lbl.getFont().deriveFont(42.0f));
        reinforcements_lbl.setText(String.valueOf(gcp.checkNextSetValue()));
        reinforcements_lbl.setBounds(670, 100, 50, 50);
        reinforcements_lbl.setVisible(true);
        reinforcements_lbl.setForeground(Color.DARK_GRAY);
        bottomBar_pnl.add(reinforcements_lbl);
        
    	//Add cardPanel
		JLabel cardPanel = addImage("cardPanel.JPG",55,65);
		for(int ctr = 0; ctr < 9; ctr++)
		{
			card_lbls[ctr] = new JLabel();
			card_lbls[ctr].setBounds(55 + ctr*60,65,60,68);			
			bottomBar_pnl.add(card_lbls[ctr]);
		}		
        bottomBar_pnl.add(cardPanel);
        
    	//Add bottomBar background
    	JLabel bottomBar = addImage("bottomBar1.JPG", 0,0);
        bottomBar_pnl.add(bottomBar);
    	this.add(bottomBar_pnl);
    	
//////////Add Side Panel 1//////////////////////////////////////////////////////
    	sideBar1_pnl.setBounds(758,0,242,219);
    	sideBar1_pnl.setBackground(Color.LIGHT_GRAY);
    	sideBar1_pnl.setLayout(null);    
        JLabel sideBar1 = addImage("sideBar1.JPG", 0,0);
        sideBar1_pnl.add(sideBar1);
    	this.add(sideBar1_pnl);

    	// Player 1
		p1_Name_lbl.setText(players[0].getName());
		p1_Name_lbl.setBounds(100,20, 100,20);
		p1_Name_lbl.setVisible(true);
		sideBar1.add(p1_Name_lbl);
		if (players[0].isHuman())
			p1_Icon = addImage("human" + players[0].getColorName() + ".PNG", 55,20);
		else
			p1_Icon = addImage("com" + players[0].getColorName() + ".PNG", 55,20);	
		sideBar1.add(p1_Icon);
		
		//  Player 2
		p2_Name_lbl.setText(players[1].getName());
		p2_Name_lbl.setBounds(100,50, 100,20);
		p2_Name_lbl.setVisible(true);
		sideBar1.add(p2_Name_lbl);
		if (players[1].isHuman())
			p1_Icon = addImage("human" + players[1].getColorName() + ".PNG", 55,50);
		else
			p1_Icon = addImage("com" + players[1].getColorName() + ".PNG", 55,50);	
		sideBar1.add(p1_Icon);

		//  Player 3
		p3_Name_lbl.setText(players[2].getName());
		p3_Name_lbl.setBounds(100,80, 100,20);
		p3_Name_lbl.setVisible(true);
		sideBar1.add(p3_Name_lbl);
		if (players[2].isHuman())
			p1_Icon = addImage("human" + players[2].getColorName() + ".PNG", 55,80);
		else
			p1_Icon = addImage("com" + players[2].getColorName() + ".PNG", 55,80);	
		sideBar1.add(p1_Icon);

		//  Player 4
		if(numberOfPlayers > 3)
		{
			p4_Name_lbl.setText(players[3].getName());
			p4_Name_lbl.setBounds(100,110, 100,20);
			p4_Name_lbl.setVisible(true);
			sideBar1.add(p4_Name_lbl);
			if (players[3].isHuman())
				p1_Icon = addImage("human" + players[3].getColorName() + ".PNG", 55,110);
			else
				p1_Icon = addImage("com" + players[3].getColorName() + ".PNG", 55,110);	
			sideBar1.add(p1_Icon);
		}
		//  Player 5
		if(numberOfPlayers > 4)
		{
			p5_Name_lbl.setText(players[4].getName());
			p5_Name_lbl.setBounds(100,140, 100,20);
			p5_Name_lbl.setVisible(true);
			sideBar1.add(p5_Name_lbl);
			if (players[4].isHuman())
				p1_Icon = addImage("human" + players[4].getColorName() + ".PNG", 55,140);
			else
				p1_Icon = addImage("com" + players[4].getColorName() + ".PNG", 55,140);	
			sideBar1.add(p1_Icon);
		}
		//  Player 6
		if(numberOfPlayers == 6)
		{
			p6_Name_lbl.setText(players[5].getName());
			p6_Name_lbl.setBounds(100,170, 100,20);
			p6_Name_lbl.setVisible(true);
			sideBar1.add(p6_Name_lbl);
			if (players[5].isHuman())
				p1_Icon = addImage("human" + players[5].getColorName() + ".PNG", 55,170);
			else
				p1_Icon = addImage("com" + players[5].getColorName() + ".PNG", 55,170);	
			sideBar1.add(p1_Icon);
		}

		turnIndicator_lbl = addImage("arrow.png", 10, 30 + 30*turnIndicator_int-12);
		turnIndicator_lbl.setVisible(true);
		sideBar1.add(turnIndicator_lbl);
		   	
//////////Add Side Panel 2//////////////////////////////////////////////////////
    	sideBar2_pnl.setBounds(758,219,242,232);
    	sideBar2_pnl.setBackground(Color.DARK_GRAY);
    	sideBar2_pnl.setLayout(null);    
        JLabel sideBar2 = addImage("sideBar2.JPG", 0,0);
        sideBar2_pnl.add(status);
    	status.setVisible(true);
    	status.setBounds(50,20,150,200);

        sideBar2_pnl.add(status);
    	sideBar2_pnl.add(sideBar2);
    	this.add(sideBar2_pnl);
 
//////////Add Side Panel 3//////////////////////////////////////////////////////
    	//Default panel 3
    	sideBar3_pnl.setVisible(true);
    	sideBar3_pnl.setBounds(758,451,242,149);
    	sideBar3_pnl.setLayout(null);    
        JLabel sideBar3 = addImage("sideBar3.JPG", 0,0);
        sideBar3_pnl.add(sideBar3);
    	this.add(sideBar3_pnl);

    	//Panel 3 while reinforcements are being placed
    	placeReinforcements_pnl.setBounds(758,451,242,149);
    	placeReinforcements_pnl.setLayout(null);    
    	placeReinforcements_pnl.setVisible(false);
        JLabel placeReinforcements = addImage("sideBar3.JPG", 0,0);
        reinforcementsToBePlaced_lbl = new JLabel();
        reinforcementsToBePlaced_lbl.setBounds(20,20,200,100);
        reinforcementsToBePlaced_lbl.setVisible(true);
        placeReinforcements_pnl.add(reinforcementsToBePlaced_lbl);
        placeReinforcements_pnl.add(placeReinforcements);
    	this.add(placeReinforcements_pnl);

    	//Panel 3 while in attack phase    	
    	attackPhase_pnl.setBounds(758,451,242,149);
    	attackPhase_pnl.setLayout(null);
    	attackPhase_pnl.setVisible(false);
        JLabel attackPhase = addImage("sideBar3.JPG", 0,0);
        endAttackPhase_btn = new JButton("End Attack");
        endAttackPhase_btn.setBounds(50,50,150,50);
        endAttackPhase_btn.setVisible(false);
        endAttackPhase_btn.addActionListener(this);
        attackPhase_pnl.add(endAttackPhase_btn);        
        attackPhase_pnl.add(attackPhase);
        this.add(attackPhase_pnl);

    	//Panel 3 while in fortify phase
    	fortifyPhase_pnl.setBounds(758,451,242,149);
    	fortifyPhase_pnl.setLayout(null);
    	attackPhase_pnl.setVisible(false);
        JLabel fortifyPhase = addImage("sideBar3.JPG", 0,0);
        endFortifyPhase_btn = new JButton("End Turn");
        endFortifyPhase_btn.setBounds(50,50,150,50);
        endFortifyPhase_btn.setVisible(false);
        endFortifyPhase_btn.addActionListener(this);
        fortifyPhase_pnl.add(endFortifyPhase_btn);        
        fortifyPhase_pnl.add(fortifyPhase);
        this.add(fortifyPhase_pnl);
}
	
	private void initializeZoneLabels()
	{		
		for(int ctr = 0; ctr < 42; ctr++)
		{
			zone_lbls[ctr] = new JLabel("0");
			map_pnl.add(zone_lbls[ctr]);
			zone_lbls[ctr].setForeground(Color.WHITE);
		}
		zone_lbls[0].setBounds(81,47,20,20);
		zone_lbls[1].setBounds(138,46,20,20);
		zone_lbls[2].setBounds(248,57,20,20);
		zone_lbls[3].setBounds(125,95,20,20);
		zone_lbls[4].setBounds(203,103,20,20);
		zone_lbls[5].setBounds(278,138,20,20);
		zone_lbls[6].setBounds(124,137,20,20);
		zone_lbls[7].setBounds(191,165,20,20);
		zone_lbls[8].setBounds(128,191,20,20);
		zone_lbls[9].setBounds(170,250,20,20);
		zone_lbls[10].setBounds(154,290,20,20);
		zone_lbls[11].setBounds(200,295,20,20);
		zone_lbls[12].setBounds(145,361,20,20);
		zone_lbls[13].setBounds(345,108,20,20);
		zone_lbls[14].setBounds(395,115,20,20);
		zone_lbls[15].setBounds(443,123,20,20);
		zone_lbls[16].setBounds(343,155,20,20);
		zone_lbls[17].setBounds(374,162,20,20);
		zone_lbls[18].setBounds(353,201,20,20);
		zone_lbls[19].setBounds(407,196,20,20);
		zone_lbls[20].setBounds(344,288,20,20);
		zone_lbls[21].setBounds(409,249,20,20);
		zone_lbls[22].setBounds(414,285,20,20);
		zone_lbls[23].setBounds(391,335,20,20);
		zone_lbls[24].setBounds(405,376,20,20);
		zone_lbls[25].setBounds(479,361,20,20);
		zone_lbls[26].setBounds(512,106,20,20);
		zone_lbls[27].setBounds(550,105,20,20);
		zone_lbls[28].setBounds(587,84,20,20);
		zone_lbls[29].setBounds(667,102,20,20);
		zone_lbls[30].setBounds(586,116,20,20);
		zone_lbls[31].setBounds(577,150,20,20);
		zone_lbls[32].setBounds(503,178,20,20);
		zone_lbls[33].setBounds(549,179,20,20);
		zone_lbls[34].setBounds(636,180,20,20);
		zone_lbls[35].setBounds(456,217,20,20);
		zone_lbls[36].setBounds(512,210,20,20);
		zone_lbls[37].setBounds(555,210,20,20);
		zone_lbls[38].setBounds(595,275,20,20);
		zone_lbls[39].setBounds(672,272,20,20);
		zone_lbls[40].setBounds(610,344,20,20);
		zone_lbls[41].setBounds(665,328,20,20);
	}
	
// END INITIALIZATION METHODS

//////////////////////////////////////////////////////////////////////////////////
//	UPDATE METHODS
//////////////////////////////////////////////////////////////////////////////////
	private void updateTurnIndicator()
	{
		turnIndicator_int++;
		if(turnIndicator_int >= numberOfPlayers)
		{
			turnIndicator_int = 0;
		}
		turnIndicator_lbl.setLocation(10, 30 + 30*turnIndicator_int - 12);
		
        //handle computer interactions
        ai_Controll();
	}	
	private void updateTurnIndicator2()
	{
		turnIndicator_int++;
		if(turnIndicator_int >= numberOfPlayers)
		{
			turnIndicator_int = 0;
		}
		turnIndicator_lbl.setLocation(10, 30 + 30*turnIndicator_int - 12);

		//begin of turn
		if(!players[turnIndicator_int].isAlive())
		{
			//skip eliminated players
			updateTurnIndicator2();
		}
		phase_PlaceReinforcements();

		if(!players[turnIndicator_int].isHuman() 
        		&& (listener_mouse instanceof MouseClass_1))
        {
        	for(int ctr = 41; ctr >= 0; ctr--)
        	{
        		if(continents[getContinent(ctr)].getTerritory(ctr).getOwner() == -1)
        		{
        			((MouseClass_1)listener_mouse).claimTerritoryAI(ctr);
        			ctr = -1;//jump to end of for loop
        		}
        	}
        }
		else if(!players[turnIndicator_int].isHuman() 
        		&& (listener_mouse instanceof MouseClass_2))
        {
        	for(int ctr = 0; ctr < 42; ctr++)
        	{
        		if(continents[getContinent(ctr)].getTerritory(ctr).getOwner() == turnIndicator_int)
        		{
        			((MouseClass_2)listener_mouse).initialReinforcementsAI(ctr);
        			ctr = 42;//jump to end of for loop
        		}
        	}
        }
	}	
	private void updatePlaceReinforcementsPanel()
	{
		reinforcementsToBePlaced_lbl.setText("<html>" 
	    		+ players[turnIndicator_int].getName() + "<br>"
	    		+ "Remaining Reinforcements: "
	    		+ players[turnIndicator_int].getReinforcementsToBePlaced()
	    		+ "</html>");
	}
//////////////////////////////////////////////////////////////////////////////////
//	AI METHODS
//////////////////////////////////////////////////////////////////////////////////
	//Automate Computer Claims on Territories
	private void ai_Controll()
	{
	    if(!players[turnIndicator_int].isHuman() 
	    		&& (listener_mouse instanceof MouseClass_1))
	    {
	    	for(int ctr = 41; ctr >= 0; ctr--)
	    	{
	    		if(continents[getContinent(ctr)].getTerritory(ctr).getOwner() == -1)
	    		{
	    			((MouseClass_1)listener_mouse).claimTerritoryAI(ctr);
	    			ctr = -1;//jump to end of for loop
	    		}
	    	}
	    }
	    else if(!players[turnIndicator_int].isHuman() 
	    		&& (listener_mouse instanceof MouseClass_2))
	    {
	    	if(((MouseClass_2)listener_mouse).getNumberOfReinforcements() > 0)
	    	{
		    	for(int ctr = 0; ctr < 42; ctr++)
		    	{
		    		if(continents[getContinent(ctr)].getTerritory(ctr).getOwner() == turnIndicator_int)
		    		{
		    			((MouseClass_2)listener_mouse).initialReinforcementsAI(ctr);
		    			ctr = 42;//jump to end of for loop
		    		}
		    	}
		    }
	    	else
	    	{
				JOptionPane.showMessageDialog(frame, 
						"All Initial Reinforcements Have Been Placed.\n" 
				       	+ "Normal Turn Sequence Comencing");
				phase_PlaceReinforcements();
	    	}
	    }
	}
// END AI METHODS
	
//////////////////////////////////////////////////////////////////////////////////
//	PHASE METHODS
//////////////////////////////////////////////////////////////////////////////////
//INITIAL PHASES
	private void startClaimTerritoryPhase()
	{
		listener_mouse = new MouseClass_1();	
	    this.addMouseListener(listener_mouse);
	    if(players[turnIndicator_int].isHuman() == false)
	    {//Jump-Start the AI
	    	for(int ctr = 41; ctr >= 0; ctr--)
        	{
        		if(continents[getContinent(ctr)].getTerritory(ctr).getOwner() == -1)
        		{
        			((MouseClass_1)listener_mouse).claimTerritoryAI(ctr);
        			ctr = -1;//jump to end of for loop
        		}
        	}
	    }
	}
	private void startInitialReinforcementsPhase()
	{
		this.removeMouseListener(listener_mouse);
	    for(int ctr = 0; ctr < numberOfPlayers; ctr++)
	    {
	    	players[ctr].calculateInitialReinforcements(numberOfPlayers);
	    }
	    placeReinforcements_pnl.setVisible(true);
	    sideBar3_pnl.setVisible(false);
	    updatePlaceReinforcementsPanel();
	    listener_mouse = new MouseClass_2();
	    this.addMouseListener(listener_mouse);
	    if(players[turnIndicator_int].isHuman() == false)
	    {//Jump-Start the AI
	    	for(int ctr = 41; ctr >= 0; ctr--)
        	{
        		if(continents[getContinent(ctr)].getTerritory(ctr).getOwner() 
        				== turnIndicator_int)
        		{
        			((MouseClass_2)listener_mouse).initialReinforcementsAI(ctr);
        			ctr = -1;//jump to end of for loop
        		}
        	}
	    }
	}
//////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
//REPEATED SEQUENCES
	//REGULAR TURN SEQUENCE: PLACE REINFORCEMENT, ATTACK PHASE, FORTIFY TERRITORY
	private void phase_PlaceReinforcements()
	{
		//remove past phase components
		this.removeMouseListener(listener_mouse);
        fortifyPhase_pnl.setVisible(false);
        endFortifyPhase_btn.setVisible(false);

		//Display the current player's turn has started
        status.setText("<html>" 
        		+ "It is now the turn  of " + players[turnIndicator_int].getName()
        		+ "<br>-Reinforcement Phase-"
        		+ "</html>");

        //set-up current phase components
        placeReinforcements_pnl.setVisible(true);
		players[turnIndicator_int].calculateReinforcements(continents);
		updatePlaceReinforcementsPanel();
		listener_mouse = new MouseClass_ReinforcementPhase();
	    this.addMouseListener(listener_mouse);
	    
	    //Show Player's cards
	    Card tmp[] = players[turnIndicator_int].getCards();
	    for(int ctr = 0; tmp[ctr] != null; ctr++)
	    {
	    	card_lbls[ctr].setIcon(tmp[ctr].getIcon());
	    }
	}
	private void phase_Attack()
	{
		territoryConquered = false;
        this.removeMouseListener(listener_mouse);
        placeReinforcements_pnl.setVisible(false);

        status.setText("<html>" 
        		+ "-Attack Phase-"
        		+ "</html>");
        
        attackPhase_pnl.setVisible(true);		
        endAttackPhase_btn.setVisible(true);
        listener_mouse = new MouseClass_AttackPhase();
	    this.addMouseListener(listener_mouse);
	}
	private void phase_Fortify()
	{
        this.removeMouseListener(listener_mouse);
        attackPhase_pnl.setVisible(false);
        endAttackPhase_btn.setVisible(false);

        status.setText("<html>" 
        		+ "-Fortify Phase-"
        		+ "</html>");

        fortifyPhase_pnl.setVisible(true);
        endFortifyPhase_btn.setVisible(true);
		listener_mouse = new MouseClass_FortifyPhase();
	    this.addMouseListener(listener_mouse);
	}

	//END PHASE METHODS
	
//////////////////////////////////////////////////////////////////////////////////////////
//BATLLE
//////////////////////////////////////////////////////////////////////////////////////////
	private void startBattle(int source, int target)
	{
		battleRaging = true;
		battle_pnl = new Battle(players[turnIndicator_int],
    			players[continents[getContinent(target)]
    			                   .getTerritory(target).getOwner()],
    			continents[getContinent(source)].getTerritory(source),
    			continents[getContinent(target)].getTerritory(target));

		this.removeMouseListener(listener_mouse);
		listener_mouse = new MouseClass_InBattle();
		this.addMouseListener(listener_mouse);

		frame.add(battle_pnl);
		battle_pnl.setVisible(true);
		map_pnl.setVisible(false);
		endAttackPhase_btn.setEnabled(false);
	}
	public void endBattle()
	{
		Color tmpColorId = null;
		for(int ctr = 0; ctr < 42; ctr++)
		{
			if(continents[getContinent(ctr)].getTerritory(ctr).getName()
					.equalsIgnoreCase(t1.getName()))
			{
				continents[getContinent(ctr)].getTerritory(ctr).setArmy(t1.getArmy());
				continents[getContinent(ctr)].getTerritory(ctr).setControl(t1.getOwner());
				zone_lbls[ctr].setText(""+t1.getArmy().getNumberOfUnits());
				zone_lbls[ctr].setForeground(players[t1.getOwner()].getColor());
			}
			if(continents[getContinent(ctr)].getTerritory(ctr).getName()
					.equalsIgnoreCase(t2.getName()))
			{
				continents[getContinent(ctr)].getTerritory(ctr).setArmy(t2.getArmy());
				continents[getContinent(ctr)].getTerritory(ctr).setControl(t2.getOwner());
				zone_lbls[ctr].setText(""+t2.getArmy().getNumberOfUnits());
				tmpColorId = zone_lbls[ctr].getForeground();
				zone_lbls[ctr].setForeground(players[t2.getOwner()].getColor());
			}
		}
		if(t1.getOwner() == t2.getOwner())//territory was conquered
		{
			checkPlayerEliminated(tmpColorId);
		}
		map_pnl.setVisible(true);
		battle_pnl.setVisible(false);
		
		this.removeMouseListener(listener_mouse);
		listener_mouse = new MouseClass_AttackPhase();
	    this.addMouseListener(listener_mouse);
		endAttackPhase_btn.setEnabled(true);
	}
//////////////////////////////////////////////////////////////////////////////////////////
//END BATTLE
//////////////////////////////////////////////////////////////////////////////////////////

	private void checkPlayerEliminated(Color colorId)
	{
		boolean eliminated = true;
		int tmpId = 0;
		for(boolean found = false; tmpId < numberOfPlayers && found == false; tmpId++)
		{
			found = (players[tmpId].getColor() == colorId);
		}
		tmpId--; //undo the last increment
		for(int ctr = 0; ctr < 42 && eliminated == true; ctr++)
		{
			eliminated = !(continents[getContinent(ctr)].getTerritory(ctr).getOwner() == tmpId);
		}
		players[tmpId].setAlive(!eliminated);
		if(eliminated)	//If a player is defeated
		{			  	//	check to see if any other opponents remain
			JOptionPane.showMessageDialog(this, 
					players[tmpId].getName() + " has been defeated");
			int numberAlive = 0;
			for(int ctr = 0; ctr < numberOfPlayers; ctr++)
			{
				//Update visibility of players names
				p1_Name_lbl.setVisible(players[0].isAlive());
				p2_Name_lbl.setVisible(players[1].isAlive());
				p3_Name_lbl.setVisible(players[2].isAlive());
				if(numberOfPlayers > 3)
				p4_Name_lbl.setVisible(players[3].isAlive());
				if(numberOfPlayers > 4)
				p5_Name_lbl.setVisible(players[4].isAlive());
				if(numberOfPlayers > 5)
				p6_Name_lbl.setVisible(players[5].isAlive());
				
				if(players[ctr].isAlive())
				{
					numberAlive++;
				}
			}
			if(numberAlive == 1)//All other players have been eliminated
			{	//The game has been completed
				victory(turnIndicator_int);
			}
		}
	}
	private void victory(int victor)
	{
		JOptionPane.showMessageDialog(this,players[victor].getName() + " has won!");
		new MainMenu();
	}
//////////////////////////////////////////////////////////////////////////////////////////
//UTILITY METHODS:
//////////////////////////////////////////////////////////////////////////////////////////
	//This method returns a label with the image corresponding to fileName
	private JLabel addImage(String fileName, int locX, int locY)
	{
		JLabel label = null;
    	BufferedImage img = null;
    	try 
    	{
    	    img = ImageIO.read(new File("images/" + fileName));
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
    	if(img != null)//execute if and only if ImageIO.read was successful
    	{
        	ImageIcon icon = new ImageIcon(img);
            label = new JLabel(icon, JLabel.CENTER);
            label.setVisible(true);
            label.setBounds(locX,locY,img.getWidth(),img.getHeight());
    	}
		return label;
	}//END addImage METHOD
	
//////////////////////////////////////////////////////////////////////////////////////////
//EVENT HANDLING:
//////////////////////////////////////////////////////////////////////////////////////////
	//------------------------------//
	//		CLAIM TERRITORIES		//
	//------------------------------//
	private class MouseClass_1 implements MouseListener
	{
		private int numberClaimed = 0;
		public void mousePressed(MouseEvent event)
		{
			int tmp = getClickZone(event.getX(), event.getY()-25);
			basicClick(tmp);
			if(tmp != -1)
			{
				if(claimTerritory(tmp))
				{
					zone_lbls[tmp].setText(""+1);
					zone_lbls[tmp].setForeground(players[turnIndicator_int].getColor());
					updateTurnIndicator();
					numberClaimed++;
					if(numberClaimed == 42)
					{
				        JOptionPane.showMessageDialog(frame, 
		        		"All Territories Have Been Claimed\n" +
		        		"Now Place Initial Reinforcements");
				        startInitialReinforcementsPhase();
					}
				}
				else
				{
			        JOptionPane.showMessageDialog(frame, 
			        		"That Territory Is Already Claimed");
				}
			}
		}
		public void mouseReleased(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}	
		public void claimTerritoryAI(int tmp)
		{
			if(claimTerritory(tmp))
			{
				zone_lbls[tmp].setText("1");
				zone_lbls[tmp].setForeground(players[turnIndicator_int].getColor());
				updateTurnIndicator();
				numberClaimed++;
				if(numberClaimed == 42)
				{
			        JOptionPane.showMessageDialog(frame, 
	        		"All Territories Have Been Claimed\n" +
	        		"Now Place Initial Reinforcements");
			        startInitialReinforcementsPhase();
				}
			}
		}
		private boolean claimTerritory(int tmp)
		{
			boolean retval = false;
			int tmpContinent = getContinent(tmp);

			String tmpS = new String(players[turnIndicator_int].getName());
			if(continents[tmpContinent].getTerritory(tmp).getOwner() != -1)
			{
				tmpS = players[continents[tmpContinent].getTerritory(tmp).getOwner()].getName();
			}
			else
			{
				retval = continents[tmpContinent].getTerritory(tmp).claimTerritory(players[turnIndicator_int].getId());
			}
			status.setText("<html>Territory Name:<br>" 
					+ continents[tmpContinent].getTerritory(tmp).getName() 
					+ "<br>Controlling Player:<br>"
					+ tmpS
					+ "<br>Number Of Units:<br>"
					+ continents[tmpContinent].getTerritory(tmp).getArmy().getNumberOfUnits()
					+ "</html>");
			return retval;
		}
	}//End of MouseClass_1

	//----------------------------------//
	//	PLACE INITIAL Reinforcements	//
	//----------------------------------//
	private class MouseClass_2 implements MouseListener
	{
		private int numberOfReinforcements;

		public MouseClass_2()
		{
			//Total number of reinforcements to be added;
			numberOfReinforcements = numberOfPlayers*(35-5*(numberOfPlayers-3));
		}
		public void mousePressed(MouseEvent event)
		{
			int tmp = getClickZone(event.getX(), event.getY()-25);
			basicClick(tmp);
			int tmpContinent = getContinent(tmp);
			if(tmpContinent != -1 && numberOfReinforcements > 0)
			{
				if(continents[tmpContinent].getTerritory(tmp).getOwner() 
						== players[turnIndicator_int].getId())
				{
					players[turnIndicator_int].decReinforcements();
					continents[tmpContinent].getTerritory(tmp).getArmy().incrementUnitsBy1();
					zone_lbls[tmp].setText("" +
							continents[tmpContinent].getTerritory(tmp).getArmy().getNumberOfUnits());
					updateTurnIndicator();
					updatePlaceReinforcementsPanel();
					numberOfReinforcements--;
				}
				else
				{
			        JOptionPane.showMessageDialog(frame, 
	        		"Unable To Renforce Enemy Territory!");					
				}
			}
			if(numberOfReinforcements < 1)
			{
				JOptionPane.showMessageDialog(frame, 
						"All Initial Reinforcements Have Been Placed.\n" 
			        	+ "Normal Turn Sequence Comencing");
				phase_PlaceReinforcements();
			}
		}
		public void mouseReleased(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}	
		public int getNumberOfReinforcements()
		{
			return numberOfReinforcements;
		}
		public void initialReinforcementsAI(int tmp)
		{
			basicClick(tmp);
			int tmpContinent = getContinent(tmp);
			if(tmpContinent != -1 && numberOfReinforcements > 0)
			{
				if(continents[tmpContinent].getTerritory(tmp).getOwner() 
						== players[turnIndicator_int].getId())
				{
					players[turnIndicator_int].decReinforcements();
					continents[tmpContinent].getTerritory(tmp).getArmy().incrementUnitsBy1();
					zone_lbls[tmp].setText("" +
							continents[tmpContinent].getTerritory(tmp).getArmy().getNumberOfUnits());
					updatePlaceReinforcementsPanel();
					numberOfReinforcements--;
					updateTurnIndicator();
				}
				else
				{
			        JOptionPane.showMessageDialog(frame, 
	        		"Unable To Renforce Enemy Territory!");					
				}
			}
		}
	}//End of MouseClass_2

	//-------------------------------------//
	//	TURN SEQUENCE: Reinforcement Phase //
	//-------------------------------------//
	private class MouseClass_ReinforcementPhase implements MouseListener
	{
		private int selectedCardIndexes[] = new int[3];
		private int index_int = 0;
		
		public void mousePressed(MouseEvent event)
		{
			if(players[turnIndicator_int].getReinforcementsToBePlaced() > 0)
			{
				int tmp = getClickZone(event.getX(), event.getY()-25);
				basicClick(tmp);
				int tmpContinent = getContinent(tmp);
				if(tmpContinent != -1)
				{
					if(continents[tmpContinent].getTerritory(tmp).getOwner() 
							== players[turnIndicator_int].getId())
					{
						players[turnIndicator_int].decReinforcements();
						continents[tmpContinent].getTerritory(tmp).getArmy().incrementUnitsBy1();
						zone_lbls[tmp].setText("" +
								continents[tmpContinent].getTerritory(tmp).getArmy().getNumberOfUnits());
						updatePlaceReinforcementsPanel();
						if(players[turnIndicator_int].getReinforcementsToBePlaced() == 0)
						{
							//Next Phase
							phase_Attack();
						}
					}
					else
					{
				        JOptionPane.showMessageDialog(frame, 
		        		"Unable To Reinforce Enemy Territory!");					
					}
				}
				else
				{
					if(event.getX() > 60 && event.getX() < 600
							&& event.getY() > 515 && event.getY() < 580)
					{
						//indexes
						selectedCardIndexes[index_int] = ((event.getX()/60) - 1);
						if(index_int > 0 && selectedCardIndexes[index_int] > selectedCardIndexes[index_int-1])
						{//Sort indexes as they are added
							int tmpVal = selectedCardIndexes[index_int-1];
							selectedCardIndexes[index_int-1] = selectedCardIndexes[index_int];
							selectedCardIndexes[index_int] = tmpVal;
						}
						index_int++;
						
						Card tmpCards[] = players[turnIndicator_int].getCards();
						if(index_int == 3 && tmpCards[selectedCardIndexes[0]] != null
								&& tmpCards[selectedCardIndexes[1]] != null
								&& tmpCards[selectedCardIndexes[2]] != null)
						{
							boolean valid = false;
							
							if(tmpCards[selectedCardIndexes[0]].type
								.equalsIgnoreCase(tmpCards[selectedCardIndexes[1]].type)
								&& tmpCards[selectedCardIndexes[0]].type
								.equalsIgnoreCase(tmpCards[selectedCardIndexes[2]].type))
							{
								//all the same
								valid = true;
							}           
							else if((!tmpCards[selectedCardIndexes[0]].type.equalsIgnoreCase
							    (tmpCards[selectedCardIndexes[1]].type)) &&
							   (!tmpCards[selectedCardIndexes[0]].type.equalsIgnoreCase
								(tmpCards[selectedCardIndexes[2]].type)) &&
							   (!tmpCards[selectedCardIndexes[1]].type.equalsIgnoreCase
								(tmpCards[selectedCardIndexes[2]].type)))
							{
								//all different
								valid = true;
							}
							else if((tmpCards[selectedCardIndexes[0]].type.equalsIgnoreCase
								    ("wildcard.JPG")) ||
								    (tmpCards[selectedCardIndexes[1]].type.equalsIgnoreCase
								    ("wildcard.JPG")) ||
									(tmpCards[selectedCardIndexes[2]].type.equalsIgnoreCase
									("wildcard.JPG"))) 
							{
								//has a wild
								valid = true;
							}
							
							if(valid)
							{
								//use the cards
								System.out.println("INDEXES: " + selectedCardIndexes[0] + " " 
										+ selectedCardIndexes[1] + " " + selectedCardIndexes[2]);
																
								players[turnIndicator_int].useCards(selectedCardIndexes[0],
										selectedCardIndexes[1], selectedCardIndexes[2]);
								int additions = gcp.getNextSetValue();
								players[turnIndicator_int].addReinforcementsToBePlaced(additions);
								
								//Alert User Of Valid Set
								JOptionPane.showMessageDialog(frame,"SET TURNED IN");
								//Update The Remaining Reinforcements Display
								updatePlaceReinforcementsPanel();
								//Update GCP Display
						        reinforcements_lbl.setText(String.valueOf(gcp.checkNextSetValue()));
						        //Update Card Images
						        Card tmpCardsUpdate[] = players[turnIndicator_int].getCards();
							    for(int ctr = 0; ctr < 9; ctr++)
							    {
							    	if(tmpCardsUpdate[ctr] != null)
							    	card_lbls[ctr].setIcon(tmpCardsUpdate[ctr].getIcon());
							    	else
							    	card_lbls[ctr].setIcon(null);	
							    }	
							}
							
							//deselect all cards
							index_int = 0;
						}
						else if(index_int == 3)
						{
							//one of the clicks was in an invalid location.
							index_int = 0;
						}
					}
				}
			}
		}
		public void mouseReleased(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}	
	}//End of MouseClass_ReinforcementPhase

	//------------------------------//
	//	TURN SEQUENCE: Attack Phase	//
	//------------------------------//
	private class MouseClass_AttackPhase implements MouseListener
	{
		private int source = -1;
		private int target = -1;
		public void mousePressed(MouseEvent event)
		{
				int tmp = getClickZone(event.getX(), event.getY()-25);
				basicClick(tmp);
				int tmpContinent = getContinent(tmp);
				if(tmpContinent != -1)
				{
					if(continents[tmpContinent].getTerritory(tmp).getOwner() 
							== players[turnIndicator_int].getId())
					{
						source = tmp;
					}
					else if(source == -1)
					{
				        JOptionPane.showMessageDialog(frame, 
		        		"Choose a controlled territory with which to attack!");
					}
					else if(!(continents[getContinent(source)].getTerritory(source)
							.isAdjacent(continents[tmpContinent].getTerritory(tmp))))
					{
				        JOptionPane.showMessageDialog(frame, 
		        		"Choose an adjacent enemy territory to attack");
				        source = -1;
					}
					else
					{
						target = tmp;
						startBattle(source,target);
					}
				}
		}
		public void mouseReleased(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}	
	}//End of MouseClass_AttackPhase
	private class MouseClass_InBattle implements MouseListener
	{
		public void mousePressed(MouseEvent event)
		{
			if(!battleRaging)
			{
				endBattle();
			}
		}
		public void mouseReleased(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}	
	}//End of MouseClass_InBattle
	//----------------------------------//
	//	TURN SEQUENCE: Fortify Phase	//
	//----------------------------------//
	private class MouseClass_FortifyPhase implements MouseListener
	{
		private int source = -1;
		private int target = -1;
		private boolean fortified_bool = false;

		public void mousePressed(MouseEvent event)
		{
				int tmp = getClickZone(event.getX(), event.getY()-25);
				basicClick(tmp);
				int tmpContinent = getContinent(tmp);
				if(tmpContinent != -1 && (continents[tmpContinent].getTerritory(tmp)
						.getOwner() == players[turnIndicator_int].getId()) 
						&& fortified_bool == false)
				{
					if(source == -1)
					{
						source = tmp;
					}
					else if(continents[getContinent(source)].getTerritory(source)
							.isAdjacent(continents[tmpContinent].getTerritory(tmp)))
					{
						target = tmp;

						//transfer all but one unit.
						continents[getContinent(target)].getTerritory(target)
							.getArmy().mergeArmies(continents[getContinent(source)]
							                       .getTerritory(source).getArmy());
						continents[getContinent(source)].getTerritory(source).getArmy()
							.setNumberOfUnits(1);
						//Update Map Labels
						zone_lbls[source].setText(""+continents[getContinent(source)]
						        .getTerritory(source).getArmy().getNumberOfUnits());
						zone_lbls[target].setText(""+continents[getContinent(target)]
						        .getTerritory(target).getArmy().getNumberOfUnits());
						fortified_bool = true;
					}
					else
					{
						JOptionPane.showMessageDialog(frame, 
		        		"Territories are not adjacent\nTry again.");
						source = -1;
					}
				}
				else if(tmpContinent != -1 && fortified_bool == false)
				{
					JOptionPane.showMessageDialog(frame, 
			        		"You can only fortify one of your own territories");
					source = -1;
				}
				else
				{
					JOptionPane.showMessageDialog(frame, 
	        		"You can only fortify one territory per turn");
				}
		}
		public void mouseReleased(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseEntered(MouseEvent event){}
		public void mouseExited(MouseEvent event){}	
	}//End of MouseClass_FortifyPhase

//////////////////////////////////////////////////////////////////////////////////////////
//MOUSE UTILITY METHODS:
//////////////////////////////////////////////////////////////////////////////////////////
	private int getClickZone(int x, int y)
	{
		int tolerance = 5;
		int retval = -1;
		for(int ctr = 0; ctr < 42 && retval == -1; ctr++)
		{
			if(x > zone_lbls[ctr].getX() - tolerance 
					&& x < (zone_lbls[ctr].getX()
							+ zone_lbls[ctr].getWidth()) + tolerance
					&& y > zone_lbls[ctr].getY() - tolerance
					&& y < (zone_lbls[ctr].getY()
							+ zone_lbls[ctr].getHeight()) + tolerance)
			{
				retval = ctr;
			}
		}
		return retval;
	}
	private int getContinent(int tmp)
	{
		int retval = -1;
		if(tmp >= 0 && tmp < 9)//N. America
		{
			retval = 0;
		}
		else if(tmp >= 9 && tmp < 13)//S. America
		{
			retval = 1;
		}
		else if(tmp >= 13 && tmp < 20)//Europe
		{
			retval = 2;
		}
		else if(tmp >= 20 && tmp < 26)//Africa
		{
			retval = 3;
		}
		else if(tmp >= 26 && tmp < 38)//Asia
		{
			retval = 4;
		}
		else if(tmp >= 38 && tmp < 42)//Australia
		{
			retval = 5;
		}
		return retval;
	}
	private void basicClick(int tmp)
	{
		int tmpContinent = getContinent(tmp);
		
		String tmpS = new String("Unclaimed");
		if(tmpContinent != -1)
		{
			if(continents[tmpContinent].getTerritory(tmp).getOwner() != -1)
			{
				tmpS = players[continents[tmpContinent].getTerritory(tmp).getOwner()].getName();
			}			
			status.setText("<html>Territory Name:<br>" 
					+ continents[tmpContinent].getTerritory(tmp).getName() 
					+ "<br>Controlling Player:<br>"
					+ tmpS
					+ "<br>Number Of Units:<br>"
					+ continents[tmpContinent].getTerritory(tmp).getArmy().getNumberOfUnits()
					+ "</html>");
		}
	}
	
//////END OF MOUSE UTILITY METHODS//////

	public void actionPerformed(ActionEvent e) 
	{
		JButton tmp_btn = null;
		if(e.getSource() instanceof JButton)
		{
			tmp_btn = (JButton)e.getSource();
		}
		if(tmp_btn == endAttackPhase_btn)
		{
			phase_Fortify();
		}
		else if(tmp_btn == endFortifyPhase_btn)
		{
			if(territoryConquered)
			{
				JOptionPane.showMessageDialog(this, "CARD EARNED");
				players[turnIndicator_int].addCard(d.draw());
			}
			for(int ctr = 0; ctr < 9; ctr++)
			{
				card_lbls[ctr].setIcon(null);
			}
			updateTurnIndicator2();
		}
	}
}//END OF Game_Core CLASS

