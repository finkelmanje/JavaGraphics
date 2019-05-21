package JohnFinkelman_starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private Image puimage;

	public Ship()
	{
		this(0,0,2);
	}

	public Ship(int x, int y)
	{
		this(x,y,2);
	}

	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
                    
                     URL url = getClass().getResource("images/ship.jpg");
			image = ImageIO.read(url);
                        
                        URL url1 = getClass().getResource("images/ship.jpgWithShield.jpg");
			puimage = ImageIO.read(url1);
                        
                                              
			
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("File could not be found or read. ");
		}
	}
//	public Ship(int x, int y, int s)
//	{
//		super(x, y);
//		speed=s;
//		try
//		{
//			image = ImageIO.read(new File("src/starfighter/ship.jpg"));
//		}
//		catch(Exception e)
//		{
//			//feel free to do something here
//			System.out.println("File could not be found or read. ");
//		}
//	}


	public void setSpeed(int s)
	{
	   //add more code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
	}
	public void drawPU(Graphics window)
	{
		window.drawImage(puimage,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return "Ship" + " " + getX() + " " + getY() + " " + getSpeed();
	}
}