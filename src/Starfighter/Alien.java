package Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
//aliens will move side to side all together and will disappear when shot
public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		//add code here
            super.setPos(x, y);
	}

	public Alien(int x, int y, int s)
	{
		//add code here
             super.setPos(x, y);
             speed = s;
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		try
		{
			//URL url = getClass().getResource("images/alien.jpg");
			//image = ImageIO.read(url);
                     image = ImageIO.read(new File("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\JavaGraphics\\src\\Starfighter\\images\\alien.JPG"));
		
                }
		catch(Exception e)
		{
			//feel free to do something here
                    System.out.println("sad");
                    
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{
	   //add code here
            if (direction.equals("LEFT")) {
			setX(getX() - speed);
		} else if (direction.equals("RIGHT")) {
			setX(getX() + speed);
		}else if (direction.equals("UP")) {
			setY(getY() - speed);
		} else if (direction.equals("DOWN")) {
			setY(getY() + speed);
		}
            
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + " " + getSpeed();
	}
}
