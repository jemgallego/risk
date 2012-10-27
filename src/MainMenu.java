//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JFrame implements ActionListener
{
	//Creates the frame object
    private static MainMenu frame;
    
    //Creates a container object
    private Container container = getContentPane();	
        
    //Declare the buttons
    JButton newGame_btn = new JButton();
	JButton loadGame_btn = new JButton();
	JButton directions_btn = new JButton();
	JButton exit_btn = new JButton();
	
	public MainMenu()
	{		
    	container.setLayout(null);
    	
        //Set Background image
		JLabel background_lbl = new JLabel();
		BufferedImage img = null;
    	try 
    	{
    		JFileChooser tempFC = new javax.swing.JFileChooser();
    		tempFC.setCurrentDirectory(new File("C:"));
            String tempFP = tempFC.getCurrentDirectory().getAbsolutePath();
            tempFC.setCurrentDirectory(new File(tempFP));
            
    	    img = ImageIO.read(new File("/Users/Jem/Desktop/workspace/risk/src/Images/mainMenu.jpg"));
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
    	if(img != null)
    	{
    		ImageIcon icon = new ImageIcon(img);
    		background_lbl = new JLabel(icon);
    		background_lbl.setBounds(0,0,400,450);
    	}
    	
    	//Initialize the New Game button
    	newGame_btn.setVisible(true);
    	newGame_btn.setEnabled(true);
    	newGame_btn.setText("NEW GAME");
    	newGame_btn.setBounds(100,100,200,50);
		newGame_btn.addActionListener(this);
    	this.add(newGame_btn);

    	//Initialize the Load Game button
    	loadGame_btn.setVisible(true);
    	loadGame_btn.setEnabled(false);
    	loadGame_btn.setText("LOAD GAME");
    	loadGame_btn.setBounds(100,175,200,50);
		loadGame_btn.addActionListener(this);
    	this.add(loadGame_btn);

    	//Initialize the Directions button
    	directions_btn.setVisible(true);
    	directions_btn.setEnabled(true);
    	directions_btn.setText("DIRECTIONS");
    	directions_btn.setBounds(100,250,200,50);
		directions_btn.addActionListener(this);
    	this.add(directions_btn);

    	//Initialize the Exit button
    	exit_btn.setVisible(true);
    	exit_btn.setEnabled(true);
    	exit_btn.setText("EXIT GAME");
    	exit_btn.setBounds(100,325,200,50);
		exit_btn.addActionListener(this);
    	this.add(exit_btn);

    	//add last so it will be underneath
    	this.add(background_lbl);
	}
	
	public static void main(String[] args)
	{			
        final int FRAME_WIDTH = 400;
		final int FRAME_HEIGHT = 450;

		//initializes the frame object
        frame = new MainMenu();

        //set frame size
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        //Center the frame
        frame.setLocation(300,200);
       
        //Set frame title
		frame.setTitle("RISK: 2003 Edition :: MAIN MENU");
		
		//Handle closing window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Make frame visible
		frame.setVisible (true);
	}
///////////////////////////////////////////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton tmp_btn = null;
		if(e.getSource() instanceof JButton)
		{
			tmp_btn = (JButton)e.getSource();
		}
		if(tmp_btn == newGame_btn)
		{
	        startGame();
		}
		else if (tmp_btn == loadGame_btn)
		{
	        JOptionPane.showMessageDialog(frame, "Currently Not Available");
		}
		else if (tmp_btn == directions_btn)
		{
	        JOptionPane.showMessageDialog(frame, 
	        "Directions can be found at: http://www.hasbro.com/common/instruct/Risk_2003.pdf");
		}
		else if (tmp_btn == exit_btn)
		{
			System.exit(0);
		}
	}

///////////////////////////////////////////////////////////////////////////////////

	private void startGame()
	{
		new Game_Setup();
        frame.setVisible(false);
	}

}
