/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JohnFinkelman_starfighter;

/**
 *
 * @author Anatom-e
 */
import java.awt.Graphics;
import java.io.File;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;


import javax.imageio.ImageIO;

public class PowerUp extends MovingThing {
	
	static int X = (int)(Math.random()*700);
	static int Y = (int)(Math.random()*200+300);
	Image image;
	
	public PowerUp(){
		super(X,Y);
		try
		{
                    
                      URL url = getClass().getResource("images/pu.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("File could not be found or read. ");
		}
	}

	public void setSpeed(int s) {
		
	}

	public int getSpeed() {
		return 0;
	}

	public void draw(Graphics window) {
		window.drawImage(image,getX(),getY(),40,40,null);
		
	}
        
        public String toString()
	{
		return " PowerUp works";
	}
}
