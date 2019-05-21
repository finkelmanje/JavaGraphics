package JohnFinkelman_starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

 import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Locatable
{
	private int xPos;
	private int yPos;

	public MovingThing()
	{
		//add more code
		xPos = 50;
		yPos = 50;
	}

	public MovingThing(int x, int y)
	{
		//add more code
		xPos = x;
		yPos = y;
	}

	public void setPos( int x, int y)
	{
		//add more code
		xPos = x;
		yPos = y;
	}


	public void setX(int x)
	{
		//add more code
		xPos = x;
	}


	public void setY(int y)
	{
		//add more code
		yPos = y;
	}

	public int getX()
	{
		return xPos;
	}


	public int getY()
	{
		return yPos;
	}

	public abstract void setSpeed( int s );
	public abstract int getSpeed();
	public abstract void draw(Graphics window);

	public void move(String direction)
	{
		if(direction.equals("LEFT"))
	      setX(getX()-getSpeed());

      //add more code to complete the move method
		if(direction.equals("RIGHT"))
			setX(getX()+getSpeed());
		
		if(direction.equals("UP"))
			setY(getY()-getSpeed());
		
		if(direction.equals("DOWN"))
			setY(getY()+getSpeed());
	}

	public String toString()
	{
		return "MovingThing";
	}
}