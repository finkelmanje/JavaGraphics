package Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,2);
	}

	public Alien(int x, int y)
	{
		this(x,y,2);
	}

	public Alien(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
                    //URL url = getClass().getResource("images/ship.jpg");
			//image = ImageIO.read(url);
			image = ImageIO.read(new File("src/Starfighter/images/alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Image not found. ");
		}
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
		move("RIGHT");
		
		

	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
