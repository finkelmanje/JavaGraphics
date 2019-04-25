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
     //   private boolean shoot;

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
            if (direction.equals("RIGHT") && getX() + getSpeed() < 800 - getWidth()) {
			setX(getX() + getSpeed());
		}
		if (direction.equals("LEFT") && getX() - getSpeed() >= 0) {
			setX(getX() - getSpeed());
		}
		if (direction.equals("UP") && getY() - getSpeed() >= 0) {
			setY(getY() - getSpeed());
		}
		if (direction.equals("DOWN") && getY() + getSpeed() < 600 - getHeight()) {
			setY(getY() + getSpeed());
		}
            
            }
        
        public boolean Collide(MovingThing mt) {
		if (partialCollision(this.getX(), this.getY() + this.getHeight() / 2, mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth(), this.getY() + this.getHeight() / 2, mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth() / 2, this.getY(), mt))
			return true;
		else if (partialCollision(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight(), mt))
			return true;
		return false;
	}
        
        private boolean partialCollision(int pointX, int pointY, MovingThing move) {
		return pointX > move.getX() && pointX < move.getX() + move.getWidth() && pointY > move.getY() && pointY < move.getY() + move.getHeight();
	}
	
        
      //  public void canShoot(boolean ok) {
         //   shoot = ok;
      //  }

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
