// Risk Project - CECS 343
// Joseph Buss, John Gallego, Jonathan Stoner

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Card extends JLabel
{
	String type = "blank";
	public Card(String cardType)
	{

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