// Risk Project - CECS 343
// Joseph Buss, John Gallego, Jonathan Stoner

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Battle extends JPanel implements ActionListener
{	

	//JPanel
	private JPanel dice_pnl = new JPanel();
	private JPanel battle_pnl = new JPanel();
	private JPanel attacker_pnl = new JPanel();
	private JPanel defender_pnl = new JPanel();
	
    //Buttons
    private JButton attack1_btn = new JButton();
    private JButton attack2_btn = new JButton();
    private JButton attack3_btn = new JButton();
    private JButton cancel_btn = new JButton();
    private JButton defend1_btn = new JButton();
    private JButton defend2_btn = new JButton();

    //Labels
	private JLabel remainingAttackers_lbl = new JLabel();
	private JLabel remainingDefenders_lbl = new JLabel();
	
	private JLabel attackerBackground_lbl = new JLabel();
	private JLabel defenderBackground_lbl = new JLabel();
	private JLabel background_lbl = new JLabel();
	
    private JLabel red_die1_lbl = new JLabel();
    private JLabel red_die2_lbl = new JLabel();
    private JLabel red_die3_lbl = new JLabel();
    private JLabel white_die1_lbl = new JLabel();
    private JLabel white_die2_lbl = new JLabel();

	
    //Integers
    private int numberOfAttackers_int = 0;
    private int numberOfDefenders_int = 0;
    
    //Territories
    Territory a;
    Territory d;
    
	public Battle(Player attacking_ply, Player defending_ply, Territory a, Territory d)
	{	
		//Set Territories
		this.a = a;
		this.d = d;
		        
		this.setSize(758,425);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.black);
				
////////////////////////////////////////////////////////////////////////////////
/**/		
		// Dice Placement
		red_die1_lbl = addImage("redDie5.png",300,130);
	    red_die2_lbl = addImage("redDie1.png",300,200);
	    red_die3_lbl = addImage("redDie2.png",300,270);

	    white_die1_lbl = addImage("whiteDie2.png",400,160);
	    white_die2_lbl = addImage("whiteDie3.png",400,230);
/**/
	    red_die1_lbl.setVisible(false);
	    red_die2_lbl.setVisible(false);
	    red_die3_lbl.setVisible(false);
	    white_die1_lbl.setVisible(false);
	    white_die2_lbl.setVisible(false);
/**/	    
	    battle_pnl.add(red_die1_lbl);
	    battle_pnl.add(red_die2_lbl);
	    battle_pnl.add(red_die3_lbl);
	    battle_pnl.add(white_die1_lbl);
	    battle_pnl.add(white_die2_lbl);
	        
////////////////////////////////////////////////////////////////////////////////
	    
        //Declare Attacker's Components
		attacker_pnl.setBounds(50,50,200,325);
		attacker_pnl.setVisible(true);
		attacker_pnl.setLayout(null);
		
		JLabel attackerName = new JLabel();
		attackerName.setText(attacking_ply.getName());
		attackerName.setBounds(25,20,150,20);
		attackerName.setVisible(true);
		attacker_pnl.add(attackerName);

		remainingAttackers_lbl.setText(a.getArmy().getNumberOfUnits()+" Units Remaining");
		remainingAttackers_lbl.setBounds(25,40,150,20);
		remainingAttackers_lbl.setVisible(true);
		attacker_pnl.add(remainingAttackers_lbl);
		
        attack1_btn.setText("Attack With 1");
    	attack1_btn.setBounds(25,80,150,40);
    	attack1_btn.addActionListener(this);
    	attacker_pnl.add(attack1_btn);

    	attack2_btn.setText("Attack With 2");
    	attack2_btn.setBounds(25,140,150,40);
    	attack2_btn.addActionListener(this);
    	attacker_pnl.add(attack2_btn);
 
        attack3_btn.setText("Attack With 3");
    	attack3_btn.setBounds(25,200,150,40);
    	attack3_btn.addActionListener(this);
    	attacker_pnl.add(attack3_btn);
  
        cancel_btn.setText("Cancel Attack");
    	cancel_btn.setBounds(25,260,150,40);
    	cancel_btn.addActionListener(this);
    	attacker_pnl.add(cancel_btn);
    	
		attackerBackground_lbl = addImage("battlePanel.jpg", 0,0);
		attacker_pnl.add(attackerBackground_lbl);

    	battle_pnl.add(attacker_pnl);
    	    	
    	//Declare Defender's Components
    	defender_pnl.setBounds(508,50,200,325);
		defender_pnl.setLayout(null);
		
		JLabel defenderName_lbl = new JLabel();
		defenderName_lbl.setText(defending_ply.getName());
		defenderName_lbl.setBounds(25,20,150,20);
		defenderName_lbl.setVisible(true);
		defender_pnl.add(defenderName_lbl);

		remainingDefenders_lbl.setText(d.getArmy().getNumberOfUnits()+" Units Remaining");
		remainingDefenders_lbl.setBounds(25,40,150,20);
		remainingDefenders_lbl.setVisible(true);
		defender_pnl.add(remainingDefenders_lbl);

        defend1_btn.setText("Defend With 1");
        defend1_btn.setBounds(25,80,150,40);
        defend1_btn.setEnabled(false);
        defend1_btn.addActionListener(this);
        defender_pnl.add(defend1_btn);

        defend2_btn.setText("Defend With 2");
        defend2_btn.setBounds(25,140,150,40);
        defend2_btn.setEnabled(false);
        defend2_btn.addActionListener(this);
        defender_pnl.add(defend2_btn);

		defenderBackground_lbl = addImage("battlePanel.jpg", 0,0);
		defender_pnl.add(defenderBackground_lbl);
		
        battle_pnl.add(defender_pnl);
        
        //Attack buttons' initial state        
		if(a.getArmy().getNumberOfUnits() < 4)
			attack3_btn.setEnabled(false);
		if(a.getArmy().getNumberOfUnits() < 3)
			attack2_btn.setEnabled(false);
		if(a.getArmy().getNumberOfUnits() < 2)
			attack1_btn.setEnabled(false);
	
		
		battle_pnl.setBounds(0,0,758,425);
		battle_pnl.setVisible(true);
		battle_pnl.setLayout(null);
		background_lbl = addImage("battleBackground.jpg", 0,0);
		battle_pnl.add(background_lbl);
		this.add(battle_pnl);

	}		
	
//////////////////////////////////////////////////////////////////////////////////////////
//EVENT HANDLING:
//////////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e) 
	{
		//HANDLE BUTTONS
		if(e.getSource()instanceof JButton)
		{
			JButton tmp_btn = null;
			tmp_btn = (JButton)e.getSource();
			if(tmp_btn == attack1_btn)
			{
			    numberOfAttackers_int = 1;
			    attack1_btn.setEnabled(false);
				attack2_btn.setEnabled(false);
				attack3_btn.setEnabled(false);
				cancel_btn.setEnabled(false);
				if(d.getArmy().getNumberOfUnits() > 0)
					defend1_btn.setEnabled(true);
				if(d.getArmy().getNumberOfUnits() > 1)
					defend2_btn.setEnabled(true);
				
			    red_die1_lbl.setVisible(false);
			    red_die2_lbl.setVisible(false);
			    red_die3_lbl.setVisible(false);
			    white_die1_lbl.setVisible(false);
			    white_die2_lbl.setVisible(false);
			}
			else if(tmp_btn == attack2_btn)
			{
			    numberOfAttackers_int = 2;
			    attack1_btn.setEnabled(false);
				attack2_btn.setEnabled(false);
				attack3_btn.setEnabled(false);
				cancel_btn.setEnabled(false);				
				if(d.getArmy().getNumberOfUnits() > 0)
					defend1_btn.setEnabled(true);
				if(d.getArmy().getNumberOfUnits() > 1)
					defend2_btn.setEnabled(true);
				
			    red_die1_lbl.setVisible(false);
			    red_die2_lbl.setVisible(false);
			    red_die3_lbl.setVisible(false);
			    white_die1_lbl.setVisible(false);
			    white_die2_lbl.setVisible(false);
			}
			else if(tmp_btn == attack3_btn)
			{
			    numberOfAttackers_int = 3;
				attack1_btn.setEnabled(false);
				attack2_btn.setEnabled(false);
				attack3_btn.setEnabled(false);
				cancel_btn.setEnabled(false);
				if(d.getArmy().getNumberOfUnits() > 0)
					defend1_btn.setEnabled(true);
				if(d.getArmy().getNumberOfUnits() > 1)
					defend2_btn.setEnabled(true);
				
			    red_die1_lbl.setVisible(false);
			    red_die2_lbl.setVisible(false);
			    red_die3_lbl.setVisible(false);
			    white_die1_lbl.setVisible(false);
			    white_die2_lbl.setVisible(false);
			}
			else if(tmp_btn == cancel_btn)
			{
				endOfBattle("Attacker Retreated",false);
			}
			else if(tmp_btn == defend1_btn)
			{
			    numberOfDefenders_int = 1;
				defend1_btn.setEnabled(false);
				defend2_btn.setEnabled(false);
				getResults();
			}
			else if(tmp_btn == defend2_btn)
			{
			    numberOfDefenders_int = 2;
				defend1_btn.setEnabled(false);
				defend2_btn.setEnabled(false);
				getResults();
			}
		}
	}
	private void getResults()
	{	    
		Dice dice = new Dice();
		int attack[] = dice.rolln(numberOfAttackers_int);
		int defense[] = dice.rolln(numberOfDefenders_int);
		
		red_die1_lbl.setIcon(addIcon("redDie"+attack[1]+".png"));		
		red_die1_lbl.setVisible(true);
		if(numberOfAttackers_int > 1)
		{
			red_die2_lbl.setIcon(addIcon("redDie"+attack[2]+".png"));
		    red_die2_lbl.setVisible(true);
		}
		if(numberOfAttackers_int > 2)
		{
			red_die3_lbl.setIcon(addIcon("redDie"+attack[3]+".png"));		
		    red_die3_lbl.setVisible(true);
		}
		white_die1_lbl.setIcon(addIcon("whiteDie"+defense[1]+".png"));		
	    white_die1_lbl.setVisible(true);
		if(numberOfDefenders_int > 1)
		{
			white_die2_lbl.setIcon(addIcon("whiteDie"+defense[2]+".png"));		
			white_die2_lbl.setVisible(true);
		}
	
		int attackerCasualties = 0;
		int defenderCasualties = 0;
				
		int victor1 = getHighest(attack,defense);
		if(victor1==0)//defender was higher or equal
		{
			attackerCasualties++;
			a.getArmy().decrementUnitsBy1();
		}
		else //attacker was higher
		{
			defenderCasualties++;			
			d.getArmy().decrementUnitsBy1();
		}
		if(numberOfDefenders_int == 2 && numberOfAttackers_int > 1)
		{
			int victor2 = getSecondHighest(attack,defense);
			if(victor2==0)//defender was higher or equal
			{
				attackerCasualties++;
				a.getArmy().decrementUnitsBy1();
			}
			else //attacker was higher
			{
				defenderCasualties++;			
				d.getArmy().decrementUnitsBy1();
			}
		}
		remainingAttackers_lbl.setText(a.getArmy().getNumberOfUnits()+" Units Remaining");
		remainingDefenders_lbl.setText(d.getArmy().getNumberOfUnits()+" Units Remaining");

		GameCore.status.setText("<html>Attacker Suffered<br>" 
				+ attackerCasualties + " Casualties<br>"
				+ "Defender Suffered<br>" 
				+ defenderCasualties + " Casualties"
				+ "</html>");

		if(a.getArmy().getNumberOfUnits()< 2)
		{
			endOfBattle("Attacker Lost",false);
		}
		if(d.getArmy().getNumberOfUnits()< 1)
		{
			endOfBattle("Attacker Won",true);
			d.setControl(a.getOwner());
			//TODO allow the attack to choice how many units to advance
			d.getArmy().mergeArmies(a.getArmy());
			a.getArmy().setNumberOfUnits(1);
		}

		//Prepare for next wave of attack
		if(a.getArmy().getNumberOfUnits() > 1)
		attack1_btn.setEnabled(true);
		if(a.getArmy().getNumberOfUnits() > 2)
		attack2_btn.setEnabled(true);
		if(a.getArmy().getNumberOfUnits() > 3)
		attack3_btn.setEnabled(true);
		cancel_btn.setEnabled(true);
	}
		
	//attacker and defender arrays are presorted from highest to lowest
	private int getHighest(int[] attacker, int[] defender)
	{
		int retval = 0;//return 0 if defender is highest
		if(attacker[1] > defender[1])//strict inequality because tie goes to defender
		{
			retval = -1;//return -1 if attacker is highest
		}
		return retval;
	}
	//attacker and defender arrays are presorted from highest to lowest
	private int getSecondHighest(int[] attacker, int[] defender)
	{
		int retval = 0;//return 0 if defender is highest
		if(attacker[2] > defender[2])//strict inequality because tie goes to defender
		{
			retval = -1;//return -1 if attacker is highest
		}
		return retval;
	}
	private void endOfBattle(String message, boolean retval)
	{
		GameCore.t1 = a;
		GameCore.t2 = d;
		GameCore.battleRaging = false;
		if(retval == true)
		GameCore.territoryConquered = retval;

		battle_pnl.setVisible(false);
		attacker_pnl.setVisible(false);
		defender_pnl.setVisible(false);
		
		this.setBackground(Color.black);
		JLabel endMessage_lbl = new JLabel();
		endMessage_lbl.setForeground(Color.WHITE);
		endMessage_lbl.setBounds(0,0,this.getWidth(),this.getHeight());
		endMessage_lbl.setText("<html>"
				+ message
				+"<br>(click to continue)" +
				"</html>");

		//prompts the user to click which restores control to Game Core
		endMessage_lbl.setFont(endMessage_lbl.getFont().deriveFont(64.0f));
		this.add(endMessage_lbl);
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
		private ImageIcon addIcon(String fileName)
		{
        	ImageIcon icon = null;
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
	        	icon = new ImageIcon(img);
	    	}
	    	return icon;
		}//END addIcon METHOD
}
