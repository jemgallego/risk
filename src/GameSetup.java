// Risk Project - CECS 343
// Joseph Buss, John Gallego, Jonathan Stoner

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
public class GameSetup extends JFrame implements ActionListener
{	
    private Container container = getContentPane();	
    private JButton startGameButton = new JButton();

    // Game Type Panel 
    private JPanel gameTypePanel = new JPanel();
    private JLabel gameTypeLabel = new JLabel(); 
    private ButtonGroup gameTypeOption = new ButtonGroup();
    private JRadioButton TwoPlayerOption = new JRadioButton();
    private JRadioButton MissionOption = new JRadioButton();
    private JRadioButton ConquestOption = new JRadioButton();
    
    //RADIO BUTTONS FOR SELECTING NUMBER OF PLAYERS
    private JPanel numberOfPlayersPanel = new JPanel();
    private JLabel numberOfPlayersLabel = new JLabel();
    private ButtonGroup numberOfPlayersOption = new ButtonGroup();
    private JRadioButton TwoPlayerGame = new JRadioButton();
    private JRadioButton ThreePlayerGame = new JRadioButton();
    private JRadioButton FourPlayerGame = new JRadioButton();
    private JRadioButton FivePlayerGame = new JRadioButton();
    private JRadioButton SixPlayerGame = new JRadioButton();

    private int numberOfPlayers = 6; // Default number of players

    //COLOR CHOICES
	String colorNames[] = {"Red","Pink","Yellow","Green","Blue","Black"};
	Color color[] = {Color.RED,Color.PINK,Color.YELLOW,Color.GREEN,Color.BLUE,Color.BLACK};

	//Player 1
	JPanel player1Panel = new JPanel();
    JButton player1Toggle = new JButton();
    JTextField player1Name = new JTextField();
    JComboBox player1ComboBox = new JComboBox(colorNames);
	int player1Color = 0;

    //Player 2
	JPanel player2Panel = new JPanel();
    JButton player2Toggle = new JButton();
    JTextField player2Name = new JTextField();
    JComboBox player2ComboBox = new JComboBox(colorNames);
	int player2Color = 1;
	
    //Player 3
	JPanel player3Panel = new JPanel();
    JButton player3Toggle = new JButton();
    JTextField player3Name = new JTextField();
    JComboBox player3ComboBox = new JComboBox(colorNames);
	int player3Color = 2;
	
    //Player 4
	JPanel player4Panel = new JPanel();
    JButton player4Toggle = new JButton();
    JTextField player4Name = new JTextField();
    JComboBox player4ComboBox = new JComboBox(colorNames);
	int player4Color = 3;

    //Player 5
	JPanel player5Panel = new JPanel();
    JButton player5Toggle = new JButton();
    JTextField player5Name = new JTextField();
    JComboBox player5ComboBox = new JComboBox(colorNames);
	int player5Color = 4;
	
    //Player 6
	JPanel player6Panel = new JPanel();
    JButton player6Toggle = new JButton();
    JTextField player6Name = new JTextField();
    JComboBox player6ComboBox = new JComboBox(colorNames);
	int player6Color = 5;

	public GameSetup()
	{
		this.setSize(420,520);
		this.setVisible(true);
		this.setLocation(600, 200);
		this.setTitle("RISK: 2003 Edition");

    	container.setLayout(null);
  
    	// SETUP: Game Type Panel
    	gameTypePanel.setBounds(0,0,200,100);
    	gameTypePanel.setLayout(null);
    	this.add(gameTypePanel);
    	
        gameTypeLabel.setText("Game Type:");
        gameTypeLabel.setBounds(10,10,210,20);
        gameTypePanel.add(gameTypeLabel);
        
        TwoPlayerOption.setText("2-Player");
        TwoPlayerOption.setBounds(10,30,100,20);
        TwoPlayerOption.setEnabled(false);
        TwoPlayerOption.addActionListener(this);
        gameTypeOption.add(TwoPlayerOption);
        gameTypePanel.add(TwoPlayerOption);

        MissionOption.setText("Mission");
        MissionOption.setBounds(10,50,100,20);
        MissionOption.setEnabled(false);
        MissionOption.addActionListener(this);
        gameTypeOption.add(MissionOption);
        gameTypePanel.add(MissionOption);

        ConquestOption.setText("Conquest");
        ConquestOption.setBounds(10,70,100,20);
        ConquestOption.addActionListener(this);
        ConquestOption.setSelected(true);	//Make this the default selection
        gameTypeOption.add(ConquestOption);
        gameTypePanel.add(ConquestOption);
        
        // SETUP: Number Of Players Panel
    	numberOfPlayersPanel.setBounds(200,0,200,100);
    	numberOfPlayersPanel.setLayout(null);
    	this.add(numberOfPlayersPanel);
    	
        numberOfPlayersLabel.setText("Number Of Players In Game:");
        numberOfPlayersLabel.setBounds(0,10,200,20);
        numberOfPlayersPanel.add(numberOfPlayersLabel);
        
        TwoPlayerGame.setText("2 Players");
        TwoPlayerGame.setBounds(0,30,100,20);
        TwoPlayerGame.setEnabled(false);
        TwoPlayerGame.addActionListener(this);
        numberOfPlayersOption.add(TwoPlayerGame);
        numberOfPlayersPanel.add(TwoPlayerGame);
        
        ThreePlayerGame.setText("3 Players");
        ThreePlayerGame.setBounds(0,50,100,20);
        ThreePlayerGame.addActionListener(this);
        numberOfPlayersOption.add(ThreePlayerGame);
        numberOfPlayersPanel.add(ThreePlayerGame);

        FourPlayerGame.setText("4 Players");
        FourPlayerGame.setBounds(0,70,100,20);
        FourPlayerGame.addActionListener(this);
        numberOfPlayersOption.add(FourPlayerGame);
        numberOfPlayersPanel.add(FourPlayerGame);

        FivePlayerGame.setText("5 Players");
        FivePlayerGame.setBounds(100,30,100,20);
        FivePlayerGame.addActionListener(this);
        numberOfPlayersOption.add(FivePlayerGame);
        numberOfPlayersPanel.add(FivePlayerGame);

        SixPlayerGame.setText("6 Players");
        SixPlayerGame.setBounds(100,50,100,20);
        SixPlayerGame.addActionListener(this);
        SixPlayerGame.setSelected(true);	//Make this the default selection
        numberOfPlayersOption.add(SixPlayerGame);
        numberOfPlayersPanel.add(SixPlayerGame);

        // Declare Player 1's GUI Component
    	player1Panel.setBounds(0,120,210,100);
    	player1Panel.setLayout(null);
    	this.add(player1Panel);
    	
    	//PLAYER 1 HEADING
        JLabel player1Label = new JLabel();
        player1Label.setText("Player 1");
        player1Label.setBounds(20,0,200,20);
        player1Panel.add(player1Label);
                
        JLabel p1_NamePrompt_lbl = new JLabel();
        p1_NamePrompt_lbl.setText("Name: ");
        p1_NamePrompt_lbl.setBounds(40,20,60,20);
        player1Panel.add(p1_NamePrompt_lbl);
        
        JLabel p1_TypePrompt_lbl = new JLabel();
        p1_TypePrompt_lbl.setText("Type: ");
        p1_TypePrompt_lbl.setBounds(40,40,60,20);
        player1Panel.add(p1_TypePrompt_lbl);

        JLabel p1_ColorPrompt_lbl = new JLabel();
        p1_ColorPrompt_lbl.setText("Color: ");
        p1_ColorPrompt_lbl.setBounds(40,60,60,20);
        player1Panel.add(p1_ColorPrompt_lbl);
        
    	//PLAYER 1 Name
        player1Name.setText("Player 1");
        player1Name.setBounds(100,20,100,20);
        player1Panel.add(player1Name);
        
    	//PLAYER 1 Human/Computer
        player1Toggle.setText("Human");
        player1Toggle.setBounds(100,40,100,20);
        player1Toggle.addActionListener(this);
        player1Panel.add(player1Toggle);
        
    	//PLAYER 1 Color
        player1ComboBox.setBounds(100,60,100,20);
        player1ComboBox.setSelectedItem(player1ComboBox.getItemAt(player1Color));
        player1ComboBox.addActionListener(this);
        player1Panel.add(player1ComboBox);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 2's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	player2Panel.setBounds(0,220,210,100);
    	player2Panel.setLayout(null);
    	this.add(player2Panel);
    	
        JLabel p2_Prompt_lbl = new JLabel();
        p2_Prompt_lbl.setText("Player 2");
        p2_Prompt_lbl.setBounds(20,0,200,20);
        player2Panel.add(p2_Prompt_lbl);
                
        JLabel p2_NamePrompt_lbl = new JLabel();
        p2_NamePrompt_lbl.setText("Name: ");
        p2_NamePrompt_lbl.setBounds(40,20,60,20);
        player2Panel.add(p2_NamePrompt_lbl);
        
        JLabel p2_TypePrompt_lbl = new JLabel();
        p2_TypePrompt_lbl.setText("Type: ");
        p2_TypePrompt_lbl.setBounds(40,40,60,20);
        player2Panel.add(p2_TypePrompt_lbl);

        JLabel p2_ColorPrompt_lbl = new JLabel();
        p2_ColorPrompt_lbl.setText("Color: ");
        p2_ColorPrompt_lbl.setBounds(40,60,60,20);
        player2Panel.add(p2_ColorPrompt_lbl);
        
    	//PLAYER 2 Name
        player2Name.setText("Player 2");
        player2Name.setBounds(100,20,100,20);
        player2Panel.add(player2Name);
        
    	//PLAYER 2 Human/Computer
        player2Toggle.setText("Human");
        player2Toggle.setBounds(100,40,100,20);
        player2Toggle.addActionListener(this);
        player2Panel.add(player2Toggle);
        
    	//PLAYER 2 Color
        player2ComboBox.setBounds(100,60,100,20);
        player2ComboBox.setSelectedItem(player2ComboBox.getItemAt(player2Color));
        player2ComboBox.addActionListener(this);
        player2Panel.add(player2ComboBox);


//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 3's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	player3Panel.setBounds(0,320,210,100);
    	player3Panel.setLayout(null);
    	this.add(player3Panel);
    	
        JLabel p3_Prompt_lbl = new JLabel();
        p3_Prompt_lbl.setText("Player 3");
        p3_Prompt_lbl.setBounds(20,0,200,20);
        player3Panel.add(p3_Prompt_lbl);
                
        JLabel p3_NamePrompt_lbl = new JLabel();
        p3_NamePrompt_lbl.setText("Name: ");
        p3_NamePrompt_lbl.setBounds(40,20,60,20);
        player3Panel.add(p3_NamePrompt_lbl);
        
        JLabel p3_TypePrompt_lbl = new JLabel();
        p3_TypePrompt_lbl.setText("Type: ");
        p3_TypePrompt_lbl.setBounds(40,40,60,20);
        player3Panel.add(p3_TypePrompt_lbl);

        JLabel p3_ColorPrompt_lbl = new JLabel();
        p3_ColorPrompt_lbl.setText("Color: ");
        p3_ColorPrompt_lbl.setBounds(40,60,60,20);
        player3Panel.add(p3_ColorPrompt_lbl);
        
        // Player 3 Name
        player3Name.setText("Player 3");
        player3Name.setBounds(100,20,100,20);
        player3Panel.add(player3Name);
        
        // Player 3 Human/Computer
        player3Toggle.setText("Human");
        player3Toggle.setBounds(100,40,100,20);
        player3Toggle.addActionListener(this);
        player3Panel.add(player3Toggle);
        
        // Player 3 Color
        player3ComboBox.setBounds(100,60,100,20);
        player3ComboBox.setSelectedItem(player3ComboBox.getItemAt(player3Color));
        player3ComboBox.addActionListener(this);
        player3Panel.add(player3ComboBox);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 4's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	player4Panel.setBounds(210,120,210,100);
    	player4Panel.setLayout(null);
    	this.add(player4Panel);
    	
        JLabel p4_Prompt_lbl = new JLabel();
        p4_Prompt_lbl.setText("Player 4");
        p4_Prompt_lbl.setBounds(10,0,200,20);
        player4Panel.add(p4_Prompt_lbl);
                
        JLabel p4_NamePrompt_lbl = new JLabel();
        p4_NamePrompt_lbl.setText("Name: ");
        p4_NamePrompt_lbl.setBounds(30,20,60,20);
        player4Panel.add(p4_NamePrompt_lbl);
        
        JLabel p4_TypePrompt_lbl = new JLabel();
        p4_TypePrompt_lbl.setText("Type: ");
        p4_TypePrompt_lbl.setBounds(30,40,60,20);
        player4Panel.add(p4_TypePrompt_lbl);

        JLabel p4_ColorPrompt_lbl = new JLabel();
        p4_ColorPrompt_lbl.setText("Color: ");
        p4_ColorPrompt_lbl.setBounds(30,60,60,20);
        player4Panel.add(p4_ColorPrompt_lbl);
        
        // Player 4 Name
        player4Name.setText("Player 4");
        player4Name.setBounds(90,20,100,20);
        player4Panel.add(player4Name);
        
        // Player 4 Human/Computer
        player4Toggle.setText("Human");
        player4Toggle.setBounds(90,40,100,20);
        player4Toggle.addActionListener(this);
        player4Panel.add(player4Toggle);
        
        // Player 4 Color
        player4ComboBox.setBounds(90,60,100,20);
        player4ComboBox.setSelectedItem(player4ComboBox.getItemAt(player4Color));
        player4ComboBox.addActionListener(this);
        player4Panel.add(player4ComboBox);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 5's GUI components
//////////////////////////////////////////////////////////////////////////////////////////
    	player5Panel.setBounds(210,220,210,100);
    	player5Panel.setLayout(null);
    	this.add(player5Panel);
    	
    	JLabel p5_Prompt_lbl = new JLabel();
        p5_Prompt_lbl.setText("Player 5");
        p5_Prompt_lbl.setBounds(10,0,200,20);
        player5Panel.add(p5_Prompt_lbl);
                
        JLabel p5_NamePrompt_lbl = new JLabel();
        p5_NamePrompt_lbl.setText("Name: ");
        p5_NamePrompt_lbl.setBounds(30,20,60,20);
        player5Panel.add(p5_NamePrompt_lbl);
        
        JLabel p5_TypePrompt_lbl = new JLabel();
        p5_TypePrompt_lbl.setText("Type: ");
        p5_TypePrompt_lbl.setBounds(30,40,60,20);
        player5Panel.add(p5_TypePrompt_lbl);

        JLabel p5_ColorPrompt_lbl = new JLabel();
        p5_ColorPrompt_lbl.setText("Color: ");
        p5_ColorPrompt_lbl.setBounds(30,60,60,20);
        player5Panel.add(p5_ColorPrompt_lbl);
        
        // Player 5 Name
        player5Name.setText("Player 5");
        player5Name.setBounds(90,20,100,20);
        player5Panel.add(player5Name);
        
        // Player 5 Human/Computer
        player5Toggle.setText("Human");
        player5Toggle.setBounds(90,40,100,20);
        player5Toggle.addActionListener(this);
        player5Panel.add(player5Toggle);
        
        // Player 5 Color
        player5ComboBox.setBounds(90,60,100,20);
        player5ComboBox.setSelectedItem(player5ComboBox.getItemAt(player5Color));
        player5ComboBox.addActionListener(this);
        player5Panel.add(player5ComboBox);

//////////////////////////////////////////////////////////////////////////////////////////
//Declare Player 6's GUI components
 //////////////////////////////////////////////////////////////////////////////////////////
    	player6Panel.setBounds(210,320,210,100);
    	player6Panel.setLayout(null);
    	this.add(player6Panel);
    	
        JLabel p6_Prompt_lbl = new JLabel();
        p6_Prompt_lbl.setText("Player 6");
        p6_Prompt_lbl.setBounds(10,0,200,20);
        player6Panel.add(p6_Prompt_lbl);
                
        JLabel p6_NamePrompt_lbl = new JLabel();
        p6_NamePrompt_lbl.setText("Name: ");
        p6_NamePrompt_lbl.setBounds(30,20,60,20);
        player6Panel.add(p6_NamePrompt_lbl);
        
        JLabel p6_TypePrompt_lbl = new JLabel();
        p6_TypePrompt_lbl.setText("Type: ");
        p6_TypePrompt_lbl.setBounds(30,40,60,20);
        player6Panel.add(p6_TypePrompt_lbl);

        JLabel p6_ColorPrompt_lbl = new JLabel();
        p6_ColorPrompt_lbl.setText("Color: ");
        p6_ColorPrompt_lbl.setBounds(30,60,60,20);
        player6Panel.add(p6_ColorPrompt_lbl);
        
        // Player 6 Name
        player6Name.setText("Player 6");
        player6Name.setBounds(90,20,100,20);
        player6Panel.add(player6Name);
        
        // Player 6 Human/Computer
        player6Toggle.setText("Human");
        player6Toggle.setBounds(90,40,100,20);
        player6Toggle.addActionListener(this);
        player6Panel.add(player6Toggle);
        
        // Player 6 Color
        player6ComboBox.setBounds(90,60,100,20);
        player6ComboBox.setSelectedItem(player6ComboBox.getItemAt(player6Color));
        player6ComboBox.addActionListener(this);
        player6Panel.add(player6ComboBox);

//Declare Confirmation GUI components
    	JPanel cf_pnl = new JPanel();
    	cf_pnl.setBounds(0,400,400,100);
    	cf_pnl.setLayout(null);
    	this.add(cf_pnl);
    	
    	startGameButton.setText("Start Game");
    	startGameButton.setBounds(60,20,300,50);
    	startGameButton.addActionListener(this);
    	cf_pnl.add(startGameButton);
	}

//////////////////////////////////////////////////////////////////////////////////////////
//EVENT HANDLING:
//////////////////////////////////////////////////////////////////////////////////////////
	public void actionPerformed(ActionEvent e) 
	{
		//HANDLE COMBOBOX
		if(e.getSource()instanceof JComboBox)
		{
			if(e.getSource() == player1ComboBox)
			{
				player1Color = player1ComboBox.getSelectedIndex();
			}
			else if(e.getSource() == player2ComboBox)
			{
				player2Color = player2ComboBox.getSelectedIndex();
			}
			else if(e.getSource() == player3ComboBox)
			{
				player3Color = player3ComboBox.getSelectedIndex();
			}
			else if(e.getSource() == player4ComboBox)
			{
				player4Color = player4ComboBox.getSelectedIndex();
			}
			else if(e.getSource() == player5ComboBox)
			{
				player5Color = player5ComboBox.getSelectedIndex();
			}
			else if(e.getSource() == player6ComboBox)
			{
				player6Color = player6ComboBox.getSelectedIndex();
			}
		}
		//HANDLE BUTTONS
		else if(e.getSource()instanceof JButton)
		{
			JButton tmp_btn = null;
			tmp_btn = (JButton)e.getSource();
			
			if(tmp_btn == startGameButton)
			{
				//Ensure no two color are the same
				if(	player1Color != player2Color
						&& (player1Color != player3Color || numberOfPlayers < 3)
						&& (player2Color != player3Color || numberOfPlayers < 3)
						&& (player1Color != player4Color || numberOfPlayers < 4)
						&& (player2Color != player4Color || numberOfPlayers < 4)
						&& (player3Color != player4Color || numberOfPlayers < 4)
						&& (player1Color != player5Color || numberOfPlayers < 5)
						&& (player2Color != player5Color || numberOfPlayers < 5)
						&& (player3Color != player5Color || numberOfPlayers < 5)
						&& (player4Color != player5Color || numberOfPlayers < 5)
						&& (player1Color != player6Color || numberOfPlayers < 6)
						&& (player2Color != player6Color || numberOfPlayers < 6)
						&& (player3Color != player6Color || numberOfPlayers < 6)
						&& (player4Color != player6Color || numberOfPlayers < 6)
						&& (player5Color != player6Color || numberOfPlayers < 6))
				{
					startGame();
				}
				else
				{
					JOptionPane.showMessageDialog(this,
							"Select color for all player","INVALID OPTION:", 0);
				}
			}
			else if(tmp_btn == player1Toggle)
			{
				if(player1Toggle.getText().equalsIgnoreCase("Human"))
					player1Toggle.setText("Computer");
				else
					player1Toggle.setText("Human");					
			}
			else if(tmp_btn == player2Toggle)
			{
				if(player2Toggle.getText().equalsIgnoreCase("Human"))
					player2Toggle.setText("Computer");
				else
					player2Toggle.setText("Human");					
			}
			else if(tmp_btn == player3Toggle)
			{
				if(player3Toggle.getText().equalsIgnoreCase("Human"))
					player3Toggle.setText("Computer");
				else
					player3Toggle.setText("Human");					
			}
			else if(tmp_btn == player4Toggle)
			{
				if(player4Toggle.getText().equalsIgnoreCase("Human"))
					player4Toggle.setText("Computer");
				else
					player4Toggle.setText("Human");					
			}
			else if(tmp_btn == player5Toggle)
			{
				if(player5Toggle.getText().equalsIgnoreCase("Human"))
					player5Toggle.setText("Computer");
				else
					player5Toggle.setText("Human");					
			}
			else if(tmp_btn == player6Toggle)
			{
				if(player6Toggle.getText().equalsIgnoreCase("Human"))
					player6Toggle.setText("Computer");
				else
					player6Toggle.setText("Human");					
			}
		}
		//HANDLE RADIO BUTTONS
		else if(e.getSource() instanceof JRadioButton)
		{
			JRadioButton tmp_rad = (JRadioButton)e.getSource();			
			if(tmp_rad == ThreePlayerGame)
			{
				numberOfPlayers = 3;
				player3Panel.setVisible(true);
				player4Panel.setVisible(false);
				player5Panel.setVisible(false);
				player6Panel.setVisible(false);
			}
			else if(tmp_rad == FourPlayerGame)
			{
				numberOfPlayers = 4;
				player3Panel.setVisible(true);
				player4Panel.setVisible(true);
				player5Panel.setVisible(false);
				player6Panel.setVisible(false);
			}
			else if(tmp_rad == FivePlayerGame)
			{
				numberOfPlayers = 5;
				player3Panel.setVisible(true);
				player4Panel.setVisible(true);
				player5Panel.setVisible(true);
				player6Panel.setVisible(false);
			}
			else if(tmp_rad == SixPlayerGame)
			{
				numberOfPlayers = 6;
				player3Panel.setVisible(true);
				player4Panel.setVisible(true);
				player5Panel.setVisible(true);
				player6Panel.setVisible(true);
			}
		}
	}	
	private void startGame()
	{
		//Initialize Players
		Player[] players = new Player[6];
		players[0] = new Player(0,
				player1Name.getText(),
				player1Toggle.getText().equalsIgnoreCase("Human"),
				color[player1ComboBox.getSelectedIndex()]);
		players[1] = new Player(1,
				player2Name.getText(),
				player2Toggle.getText().equalsIgnoreCase("Human"),
				color[player2ComboBox.getSelectedIndex()]);
		players[2] = new Player(2,
				player3Name.getText(),
				player3Toggle.getText().equalsIgnoreCase("Human"),
				color[player3ComboBox.getSelectedIndex()]);
		players[3] = new Player(3,
				player4Name.getText(),
				player4Toggle.getText().equalsIgnoreCase("Human"),
				color[player4ComboBox.getSelectedIndex()]);
		players[4] = new Player(4,
				player5Name.getText(),
				player5Toggle.getText().equalsIgnoreCase("Human"),
				color[player5ComboBox.getSelectedIndex()]);
		players[5] = new Player(5,
				player6Name.getText(),
				player6Toggle.getText().equalsIgnoreCase("Human"),
				color[player6ComboBox.getSelectedIndex()]);

		Random rand = new Random();//Select player to go first
		GameCore game = new GameCore
			(players,numberOfPlayers,rand.nextInt(numberOfPlayers));

		game.setSize(1007,628);
		game.setVisible(true);
        this.setVisible(false);
	}
}
