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
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Game_Setup extends JFrame implements ActionListener
{	
    private Container container = getContentPane();	

    //GUI COMPONENTS
    private JButton cf_Confirm_btn = new JButton();

    //RADIO BUTTONS FOR SELECTING NUMBER OF PLAYERS
    private JRadioButton np_2Players_rad = new JRadioButton();
    private JRadioButton np_3Players_rad = new JRadioButton();
    private JRadioButton np_4Players_rad = new JRadioButton();
    private JRadioButton np_5Players_rad = new JRadioButton();
    private JRadioButton np_6Players_rad = new JRadioButton();
    private int numberOfPlayers_int = 6;

    //COLOR CHOICES
	String p_Colors[] = {"Red","Pink","Yellow","Green","Blue","Black"};
	Color p_Colors_[] = {Color.RED,Color.PINK,Color.YELLOW,Color.GREEN,Color.BLUE,Color.BLACK};

	//Player 1
	JPanel p1_pnl = new JPanel();
    JButton p1_Type_btn = new JButton();
    JTextField p1_Name_txt = new JTextField();
    JComboBox p1_Color_cmb = new JComboBox(p_Colors);
	int p1_Color_int = 0;

    //Player 2
	JPanel p2_pnl = new JPanel();
    JButton p2_Type_btn = new JButton();
    JTextField p2_Name_txt = new JTextField();
    JComboBox p2_Color_cmb = new JComboBox(p_Colors);
	int p2_Color_int = 1;
	
    //Player 3
	JPanel p3_pnl = new JPanel();
    JButton p3_Type_btn = new JButton();
    JTextField p3_Name_txt = new JTextField();
    JComboBox p3_Color_cmb = new JComboBox(p_Colors);
	int p3_Color_int = 2;
	
    //Player 4
	JPanel p4_pnl = new JPanel();
    JButton p4_Type_btn = new JButton();
    JTextField p4_Name_txt = new JTextField();
    JComboBox p4_Color_cmb = new JComboBox(p_Colors);
	int p4_Color_int = 3;

    //Player 5
	JPanel p5_pnl = new JPanel();
    JButton p5_Type_btn = new JButton();
    JTextField p5_Name_txt = new JTextField();
    JComboBox p5_Color_cmb = new JComboBox(p_Colors);
	int p5_Color_int = 4;
	
    //Player 6
	JPanel p6_pnl = new JPanel();
    JButton p6_Type_btn = new JButton();
    JTextField p6_Name_txt = new JTextField();
    JComboBox p6_Color_cmb = new JComboBox(p_Colors);
	int p6_Color_int = 5;

	public Game_Setup()
	{
		this.setSize(420,520);
		this.setVisible(true);
		this.setLocation(300, 200);
		this.setTitle("RISK: 2003 Edition");

    	container.setLayout(null);
    	container.setBackground(Color.LIGHT_GRAY);

//Declare Game Type GUI components
    	JPanel gt_pnl = new JPanel();
    	gt_pnl.setBounds(0,0,200,100);
    	gt_pnl.setBackground(Color.LIGHT_GRAY);
    	gt_pnl.setLayout(null);
    	this.add(gt_pnl);
    	
        JLabel gt_Prompt_lbl = new JLabel();
        gt_Prompt_lbl.setText("Game Type:");
        gt_Prompt_lbl.setBounds(10,10,210,20);
        gt_pnl.add(gt_Prompt_lbl);
        
        ButtonGroup gt_RadioButtons_grp = new ButtonGroup();
        
        JRadioButton gt_2Player_rad = new JRadioButton();
        gt_2Player_rad.setText("2-Player");
        gt_2Player_rad.setBounds(10,30,100,20);
        gt_2Player_rad.setEnabled(false);
        gt_2Player_rad.addActionListener(this);
        gt_RadioButtons_grp.add(gt_2Player_rad);
        gt_pnl.add(gt_2Player_rad);

        JRadioButton gt_Mission_rad = new JRadioButton();
        gt_Mission_rad.setText("Mission");
        gt_Mission_rad.setBounds(10,50,100,20);
        gt_Mission_rad.setEnabled(false);
        gt_Mission_rad.addActionListener(this);
        gt_RadioButtons_grp.add(gt_Mission_rad);
        gt_pnl.add(gt_Mission_rad);

        JRadioButton gt_Conquest_rad = new JRadioButton();
        gt_Conquest_rad.setText("Conquest");
        gt_Conquest_rad.setBounds(10,70,100,20);
        gt_Conquest_rad.addActionListener(this);
        gt_Conquest_rad.setSelected(true);	//Make this the default selection
        gt_RadioButtons_grp.add(gt_Conquest_rad);
        gt_pnl.add(gt_Conquest_rad);
        
//Declare Number of Players GUI components
    	JPanel np_pnl = new JPanel();
    	np_pnl.setBounds(200,0,200,100);
    	np_pnl.setBackground(Color.LIGHT_GRAY);
    	np_pnl.setLayout(null);
    	this.add(np_pnl);
    	
        JLabel np_Prompt_lbl = new JLabel();
        np_Prompt_lbl.setText("Number Of Players In Game:");
        np_Prompt_lbl.setBounds(0,10,200,20);
        np_pnl.add(np_Prompt_lbl);
        
        ButtonGroup np_RadioButtons_grp = new ButtonGroup();
        
        np_2Players_rad.setText("2 Players");
        np_2Players_rad.setBounds(0,30,100,20);
        np_2Players_rad.setEnabled(false);
        np_2Players_rad.addActionListener(this);
        np_RadioButtons_grp.add(np_2Players_rad);
        np_pnl.add(np_2Players_rad);
        
        np_3Players_rad.setText("3 Players");
        np_3Players_rad.setBounds(0,50,100,20);
        np_3Players_rad.addActionListener(this);
        np_RadioButtons_grp.add(np_3Players_rad);
        np_pnl.add(np_3Players_rad);

        np_4Players_rad.setText("4 Players");
        np_4Players_rad.setBounds(0,70,100,20);
        np_4Players_rad.addActionListener(this);
        np_RadioButtons_grp.add(np_4Players_rad);
        np_pnl.add(np_4Players_rad);

        np_5Players_rad.setText("5 Players");
        np_5Players_rad.setBounds(100,30,100,20);
        np_5Players_rad.addActionListener(this);
        np_RadioButtons_grp.add(np_5Players_rad);
        np_pnl.add(np_5Players_rad);

        np_6Players_rad.setText("6 Players");
        np_6Players_rad.setBounds(100,50,100,20);
        np_6Players_rad.addActionListener(this);
        np_6Players_rad.setSelected(true);	//Make this the default selection
        np_RadioButtons_grp.add(np_6Players_rad);
        np_pnl.add(np_6Players_rad);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 1's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	p1_pnl.setBounds(0,120,210,100);
    	p1_pnl.setBackground(Color.LIGHT_GRAY);
    	p1_pnl.setLayout(null);
    	this.add(p1_pnl);
    	
    	//PLAYER 1 HEADING
        JLabel p1_Prompt_lbl = new JLabel();
        p1_Prompt_lbl.setText("Player 1");
        p1_Prompt_lbl.setBounds(20,0,200,20);
        p1_pnl.add(p1_Prompt_lbl);
                
        JLabel p1_NamePrompt_lbl = new JLabel();
        p1_NamePrompt_lbl.setText("Name: ");
        p1_NamePrompt_lbl.setBounds(40,20,60,20);
        p1_pnl.add(p1_NamePrompt_lbl);
        
        JLabel p1_TypePrompt_lbl = new JLabel();
        p1_TypePrompt_lbl.setText("Type: ");
        p1_TypePrompt_lbl.setBounds(40,40,60,20);
        p1_pnl.add(p1_TypePrompt_lbl);

        JLabel p1_ColorPrompt_lbl = new JLabel();
        p1_ColorPrompt_lbl.setText("Color: ");
        p1_ColorPrompt_lbl.setBounds(40,60,60,20);
        p1_pnl.add(p1_ColorPrompt_lbl);
        
    	//PLAYER 1 Name
        p1_Name_txt.setText("Player 1");
        p1_Name_txt.setBounds(100,20,100,20);
        p1_pnl.add(p1_Name_txt);
        
    	//PLAYER 1 Human/Computer
        p1_Type_btn.setText("Human");
        p1_Type_btn.setBounds(100,40,100,20);
        p1_Type_btn.addActionListener(this);
        p1_pnl.add(p1_Type_btn);
        
    	//PLAYER 1 Color
        p1_Color_cmb.setBounds(100,60,100,20);
        p1_Color_cmb.setSelectedItem(p1_Color_cmb.getItemAt(p1_Color_int));
        p1_Color_cmb.addActionListener(this);
        p1_pnl.add(p1_Color_cmb);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 2's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	p2_pnl.setBounds(0,220,210,100);
    	p2_pnl.setBackground(Color.LIGHT_GRAY);
    	p2_pnl.setLayout(null);
    	this.add(p2_pnl);
    	
        JLabel p2_Prompt_lbl = new JLabel();
        p2_Prompt_lbl.setText("Player 2");
        p2_Prompt_lbl.setBounds(20,0,200,20);
        p2_pnl.add(p2_Prompt_lbl);
                
        JLabel p2_NamePrompt_lbl = new JLabel();
        p2_NamePrompt_lbl.setText("Name: ");
        p2_NamePrompt_lbl.setBounds(40,20,60,20);
        p2_pnl.add(p2_NamePrompt_lbl);
        
        JLabel p2_TypePrompt_lbl = new JLabel();
        p2_TypePrompt_lbl.setText("Type: ");
        p2_TypePrompt_lbl.setBounds(40,40,60,20);
        p2_pnl.add(p2_TypePrompt_lbl);

        JLabel p2_ColorPrompt_lbl = new JLabel();
        p2_ColorPrompt_lbl.setText("Color: ");
        p2_ColorPrompt_lbl.setBounds(40,60,60,20);
        p2_pnl.add(p2_ColorPrompt_lbl);
        
    	//PLAYER 2 Name
        p2_Name_txt.setText("Player 2");
        p2_Name_txt.setBounds(100,20,100,20);
        p2_pnl.add(p2_Name_txt);
        
    	//PLAYER 2 Human/Computer
        p2_Type_btn.setText("Human");
        p2_Type_btn.setBounds(100,40,100,20);
        p2_Type_btn.addActionListener(this);
        p2_pnl.add(p2_Type_btn);
        
    	//PLAYER 2 Color
        p2_Color_cmb.setBounds(100,60,100,20);
        p2_Color_cmb.setSelectedItem(p2_Color_cmb.getItemAt(p2_Color_int));
        p2_Color_cmb.addActionListener(this);
        p2_pnl.add(p2_Color_cmb);


//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 3's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	p3_pnl.setBounds(0,320,210,100);
    	p3_pnl.setBackground(Color.LIGHT_GRAY);
    	p3_pnl.setLayout(null);
    	this.add(p3_pnl);
    	
        JLabel p3_Prompt_lbl = new JLabel();
        p3_Prompt_lbl.setText("Player 3");
        p3_Prompt_lbl.setBounds(20,0,200,20);
        p3_pnl.add(p3_Prompt_lbl);
                
        JLabel p3_NamePrompt_lbl = new JLabel();
        p3_NamePrompt_lbl.setText("Name: ");
        p3_NamePrompt_lbl.setBounds(40,20,60,20);
        p3_pnl.add(p3_NamePrompt_lbl);
        
        JLabel p3_TypePrompt_lbl = new JLabel();
        p3_TypePrompt_lbl.setText("Type: ");
        p3_TypePrompt_lbl.setBounds(40,40,60,20);
        p3_pnl.add(p3_TypePrompt_lbl);

        JLabel p3_ColorPrompt_lbl = new JLabel();
        p3_ColorPrompt_lbl.setText("Color: ");
        p3_ColorPrompt_lbl.setBounds(40,60,60,20);
        p3_pnl.add(p3_ColorPrompt_lbl);
        
        // Player 3 Name
        p3_Name_txt.setText("Player 3");
        p3_Name_txt.setBounds(100,20,100,20);
        p3_pnl.add(p3_Name_txt);
        
        // Player 3 Human/Computer
        p3_Type_btn.setText("Human");
        p3_Type_btn.setBounds(100,40,100,20);
        p3_Type_btn.addActionListener(this);
        p3_pnl.add(p3_Type_btn);
        
        // Player 3 Color
        p3_Color_cmb.setBounds(100,60,100,20);
        p3_Color_cmb.setSelectedItem(p3_Color_cmb.getItemAt(p3_Color_int));
        p3_Color_cmb.addActionListener(this);
        p3_pnl.add(p3_Color_cmb);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 4's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	p4_pnl.setBounds(210,120,210,100);
    	p4_pnl.setBackground(Color.LIGHT_GRAY);
    	p4_pnl.setLayout(null);
    	this.add(p4_pnl);
    	
        JLabel p4_Prompt_lbl = new JLabel();
        p4_Prompt_lbl.setText("Player 4");
        p4_Prompt_lbl.setBounds(10,0,200,20);
        p4_pnl.add(p4_Prompt_lbl);
                
        JLabel p4_NamePrompt_lbl = new JLabel();
        p4_NamePrompt_lbl.setText("Name: ");
        p4_NamePrompt_lbl.setBounds(30,20,60,20);
        p4_pnl.add(p4_NamePrompt_lbl);
        
        JLabel p4_TypePrompt_lbl = new JLabel();
        p4_TypePrompt_lbl.setText("Type: ");
        p4_TypePrompt_lbl.setBounds(30,40,60,20);
        p4_pnl.add(p4_TypePrompt_lbl);

        JLabel p4_ColorPrompt_lbl = new JLabel();
        p4_ColorPrompt_lbl.setText("Color: ");
        p4_ColorPrompt_lbl.setBounds(30,60,60,20);
        p4_pnl.add(p4_ColorPrompt_lbl);
        
        // Player 4 Name
        p4_Name_txt.setText("Player 4");
        p4_Name_txt.setBounds(90,20,100,20);
        p4_pnl.add(p4_Name_txt);
        
        // Player 4 Human/Computer
        p4_Type_btn.setText("Human");
        p4_Type_btn.setBounds(90,40,100,20);
        p4_Type_btn.addActionListener(this);
        p4_pnl.add(p4_Type_btn);
        
        // Player 4 Color
        p4_Color_cmb.setBounds(90,60,100,20);
        p4_Color_cmb.setSelectedItem(p4_Color_cmb.getItemAt(p4_Color_int));
        p4_Color_cmb.addActionListener(this);
        p4_pnl.add(p4_Color_cmb);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 5's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	p5_pnl.setBounds(210,220,210,100);
    	p5_pnl.setBackground(Color.LIGHT_GRAY);
    	p5_pnl.setLayout(null);
    	this.add(p5_pnl);
    	
    	JLabel p5_Prompt_lbl = new JLabel();
        p5_Prompt_lbl.setText("Player 5");
        p5_Prompt_lbl.setBounds(10,0,200,20);
        p5_pnl.add(p5_Prompt_lbl);
                
        JLabel p5_NamePrompt_lbl = new JLabel();
        p5_NamePrompt_lbl.setText("Name: ");
        p5_NamePrompt_lbl.setBounds(30,20,60,20);
        p5_pnl.add(p5_NamePrompt_lbl);
        
        JLabel p5_TypePrompt_lbl = new JLabel();
        p5_TypePrompt_lbl.setText("Type: ");
        p5_TypePrompt_lbl.setBounds(30,40,60,20);
        p5_pnl.add(p5_TypePrompt_lbl);

        JLabel p5_ColorPrompt_lbl = new JLabel();
        p5_ColorPrompt_lbl.setText("Color: ");
        p5_ColorPrompt_lbl.setBounds(30,60,60,20);
        p5_pnl.add(p5_ColorPrompt_lbl);
        
        // Player 5 Name
        p5_Name_txt.setText("Player 5");
        p5_Name_txt.setBounds(90,20,100,20);
        p5_pnl.add(p5_Name_txt);
        
        // Player 5 Human/Computer
        p5_Type_btn.setText("Human");
        p5_Type_btn.setBounds(90,40,100,20);
        p5_Type_btn.addActionListener(this);
        p5_pnl.add(p5_Type_btn);
        
        // Player 5 Color
        p5_Color_cmb.setBounds(90,60,100,20);
        p5_Color_cmb.setSelectedItem(p5_Color_cmb.getItemAt(p5_Color_int));
        p5_Color_cmb.addActionListener(this);
        p5_pnl.add(p5_Color_cmb);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 6's GUI components
 //////////////////////////////////////////////////////////////////////////////////////////
    	p6_pnl.setBounds(210,320,210,100);
    	p6_pnl.setBackground(Color.LIGHT_GRAY);
    	p6_pnl.setLayout(null);
    	this.add(p6_pnl);
    	
        JLabel p6_Prompt_lbl = new JLabel();
        p6_Prompt_lbl.setText("Player 6");
        p6_Prompt_lbl.setBounds(10,0,200,20);
        p6_pnl.add(p6_Prompt_lbl);
                
        JLabel p6_NamePrompt_lbl = new JLabel();
        p6_NamePrompt_lbl.setText("Name: ");
        p6_NamePrompt_lbl.setBounds(30,20,60,20);
        p6_pnl.add(p6_NamePrompt_lbl);
        
        JLabel p6_TypePrompt_lbl = new JLabel();
        p6_TypePrompt_lbl.setText("Type: ");
        p6_TypePrompt_lbl.setBounds(30,40,60,20);
        p6_pnl.add(p6_TypePrompt_lbl);

        JLabel p6_ColorPrompt_lbl = new JLabel();
        p6_ColorPrompt_lbl.setText("Color: ");
        p6_ColorPrompt_lbl.setBounds(30,60,60,20);
        p6_pnl.add(p6_ColorPrompt_lbl);
        
        // Player 6 Name
        p6_Name_txt.setText("Player 6");
        p6_Name_txt.setBounds(90,20,100,20);
        p6_pnl.add(p6_Name_txt);
        
        // Player 6 Human/Computer
        p6_Type_btn.setText("Human");
        p6_Type_btn.setBounds(90,40,100,20);
        p6_Type_btn.addActionListener(this);
        p6_pnl.add(p6_Type_btn);
        
        // Player 6 Color
        p6_Color_cmb.setBounds(90,60,100,20);
        p6_Color_cmb.setSelectedItem(p6_Color_cmb.getItemAt(p6_Color_int));
        p6_Color_cmb.addActionListener(this);
        p6_pnl.add(p6_Color_cmb);

//Declare Confirmation GUI components
    	JPanel cf_pnl = new JPanel();
    	cf_pnl.setBounds(0,400,400,100);
    	cf_pnl.setBackground(Color.LIGHT_GRAY);
    	cf_pnl.setLayout(null);
    	this.add(cf_pnl);
    	
    	cf_Confirm_btn.setText("Start Game");
    	cf_Confirm_btn.setBounds(50,20,300,50);
    	cf_Confirm_btn.addActionListener(this);
    	cf_pnl.add(cf_Confirm_btn);
	}

//////////////////////////////////////////////////////////////////////////////////////////
//EVENT HANDLING:
//////////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e) 
	{
		//HANDLE COMBOBOX
		if(e.getSource()instanceof JComboBox)
		{
			if(e.getSource() == p1_Color_cmb)
			{
				p1_Color_int = p1_Color_cmb.getSelectedIndex();
			}
			else if(e.getSource() == p2_Color_cmb)
			{
				p2_Color_int = p2_Color_cmb.getSelectedIndex();
			}
			else if(e.getSource() == p3_Color_cmb)
			{
				p3_Color_int = p3_Color_cmb.getSelectedIndex();
			}
			else if(e.getSource() == p4_Color_cmb)
			{
				p4_Color_int = p4_Color_cmb.getSelectedIndex();
			}
			else if(e.getSource() == p5_Color_cmb)
			{
				p5_Color_int = p5_Color_cmb.getSelectedIndex();
			}
			else if(e.getSource() == p6_Color_cmb)
			{
				p6_Color_int = p6_Color_cmb.getSelectedIndex();
			}
		}
		//HANDLE BUTTONS
		else if(e.getSource()instanceof JButton)
		{
			JButton tmp_btn = null;
			tmp_btn = (JButton)e.getSource();
			
			if(tmp_btn == cf_Confirm_btn)
			{
				//Ensure no two colors are the same
				if(	p1_Color_int != p2_Color_int
						&& (p1_Color_int != p3_Color_int || numberOfPlayers_int < 3)
						&& (p2_Color_int != p3_Color_int || numberOfPlayers_int < 3)
						&& (p1_Color_int != p4_Color_int || numberOfPlayers_int < 4)
						&& (p2_Color_int != p4_Color_int || numberOfPlayers_int < 4)
						&& (p3_Color_int != p4_Color_int || numberOfPlayers_int < 4)
						&& (p1_Color_int != p5_Color_int || numberOfPlayers_int < 5)
						&& (p2_Color_int != p5_Color_int || numberOfPlayers_int < 5)
						&& (p3_Color_int != p5_Color_int || numberOfPlayers_int < 5)
						&& (p4_Color_int != p5_Color_int || numberOfPlayers_int < 5)
						&& (p1_Color_int != p6_Color_int || numberOfPlayers_int < 6)
						&& (p2_Color_int != p6_Color_int || numberOfPlayers_int < 6)
						&& (p3_Color_int != p6_Color_int || numberOfPlayers_int < 6)
						&& (p4_Color_int != p6_Color_int || numberOfPlayers_int < 6)
						&& (p5_Color_int != p6_Color_int || numberOfPlayers_int < 6))
				{
					startGame();
				}
				else
				{
					JOptionPane.showMessageDialog(this,
							"Select colors for all player","INVALID OPTION:", 0);
				}
			}
			else if(tmp_btn == p1_Type_btn)
			{
				if(p1_Type_btn.getText().equalsIgnoreCase("Human"))
					p1_Type_btn.setText("Computer");
				else
					p1_Type_btn.setText("Human");					
			}
			else if(tmp_btn == p2_Type_btn)
			{
				if(p2_Type_btn.getText().equalsIgnoreCase("Human"))
					p2_Type_btn.setText("Computer");
				else
					p2_Type_btn.setText("Human");					
			}
			else if(tmp_btn == p3_Type_btn)
			{
				if(p3_Type_btn.getText().equalsIgnoreCase("Human"))
					p3_Type_btn.setText("Computer");
				else
					p3_Type_btn.setText("Human");					
			}
			else if(tmp_btn == p4_Type_btn)
			{
				if(p4_Type_btn.getText().equalsIgnoreCase("Human"))
					p4_Type_btn.setText("Computer");
				else
					p4_Type_btn.setText("Human");					
			}
			else if(tmp_btn == p5_Type_btn)
			{
				if(p5_Type_btn.getText().equalsIgnoreCase("Human"))
					p5_Type_btn.setText("Computer");
				else
					p5_Type_btn.setText("Human");					
			}
			else if(tmp_btn == p6_Type_btn)
			{
				if(p6_Type_btn.getText().equalsIgnoreCase("Human"))
					p6_Type_btn.setText("Computer");
				else
					p6_Type_btn.setText("Human");					
			}
		}
		//HANDLE RADIO BUTTONS
		else if(e.getSource() instanceof JRadioButton)
		{
			JRadioButton tmp_rad = (JRadioButton)e.getSource();			
			if(tmp_rad == np_3Players_rad)
			{
				numberOfPlayers_int = 3;
				p3_pnl.setVisible(true);
				p4_pnl.setVisible(false);
				p5_pnl.setVisible(false);
				p6_pnl.setVisible(false);
			}
			else if(tmp_rad == np_4Players_rad)
			{
				numberOfPlayers_int = 4;
				p3_pnl.setVisible(true);
				p4_pnl.setVisible(true);
				p5_pnl.setVisible(false);
				p6_pnl.setVisible(false);
			}
			else if(tmp_rad == np_5Players_rad)
			{
				numberOfPlayers_int = 5;
				p3_pnl.setVisible(true);
				p4_pnl.setVisible(true);
				p5_pnl.setVisible(true);
				p6_pnl.setVisible(false);
			}
			else if(tmp_rad == np_6Players_rad)
			{
				numberOfPlayers_int = 6;
				p3_pnl.setVisible(true);
				p4_pnl.setVisible(true);
				p5_pnl.setVisible(true);
				p6_pnl.setVisible(true);
			}
		}
	}	
	private void startGame()
	{
		//Initialize Players
		Player[] players = new Player[6];
		players[0] = new Player(0,
				p1_Name_txt.getText(),
				p1_Type_btn.getText().equalsIgnoreCase("Human"),
				p_Colors_[p1_Color_cmb.getSelectedIndex()]);
		players[1] = new Player(1,
				p2_Name_txt.getText(),
				p2_Type_btn.getText().equalsIgnoreCase("Human"),
				p_Colors_[p2_Color_cmb.getSelectedIndex()]);
		players[2] = new Player(2,
				p3_Name_txt.getText(),
				p3_Type_btn.getText().equalsIgnoreCase("Human"),
				p_Colors_[p3_Color_cmb.getSelectedIndex()]);
		players[3] = new Player(3,
				p4_Name_txt.getText(),
				p4_Type_btn.getText().equalsIgnoreCase("Human"),
				p_Colors_[p4_Color_cmb.getSelectedIndex()]);
		players[4] = new Player(4,
				p5_Name_txt.getText(),
				p5_Type_btn.getText().equalsIgnoreCase("Human"),
				p_Colors_[p5_Color_cmb.getSelectedIndex()]);
		players[5] = new Player(5,
				p6_Name_txt.getText(),
				p6_Type_btn.getText().equalsIgnoreCase("Human"),
				p_Colors_[p6_Color_cmb.getSelectedIndex()]);

		Random rand = new Random();//Select player to go first
		Game_Core game = new Game_Core
			(players,numberOfPlayers_int,rand.nextInt(numberOfPlayers_int));

		game.setSize(1007,628);
		game.setVisible(true);
        this.setVisible(false);
	}
}
