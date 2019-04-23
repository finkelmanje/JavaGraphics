package Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;
        private boolean shoot;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		super.setPos(x, y);
	}

	public Ammo(int x, int y, int s)
	{
		//add code
            super.setPos(x, y);
            speed = s;
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
		//add code to draw the ammo
            window.setColor(Color.YELLOW);
            window.fillRect(super.getX(), super.getY(), 5, 5);
            
	}
	
	
	public void move( String direction )
	{
		//add code to draw the ammo
            if(shoot = true) {
             if (direction.equals("UP")) {
                
                setY(getY() - speed);    
            }
            }
	}
        
        public void canShoot(boolean ok) {
            shoot = ok;
        }

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
