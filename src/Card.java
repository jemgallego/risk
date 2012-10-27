//////////////////////////////////////////////////////////////////////////////////
//								RISK PROJECT									//
//								  CECS 343										//
//------------------------------------------------------------------------------//
//								TEAM MEMBERS:									//
//								Joseph Buss										//
//								John Gallego									//
//								Jonathan Stoner									//
//////////////////////////////////////////////////////////////////////////////////
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class Card extends JLabel
{
	//used for inputing images
	private JFileChooser tempFC = new JFileChooser();

	String type = "blank";
	public Card(String cardType)
	{
		//initialize image file path
		tempFC.setCurrentDirectory(new File("C:"));
        String tempFP = tempFC.getCurrentDirectory().getAbsolutePath();
        tempFC.setCurrentDirectory(new File(tempFP));

		type = cardType;
		this.setIcon(addIcon(type));
	}

	public void handOver()
	{
		//Not Yet Implemented.
	}
	private ImageIcon addIcon(String fileName)
	{
    	ImageIcon icon = null;
    	BufferedImage img = null;
    	try 
    	{
    	    img = ImageIO.read(new File(tempFC.getCurrentDirectory().getAbsolutePath()
    				+ "\\src\\Images\\" + fileName));
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