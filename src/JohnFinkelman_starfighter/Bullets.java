package JohnFinkelman_starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammoList;

	public Bullets()
	{
		ammoList = new ArrayList<Ammo>();
	}

	public void add(Ammo ammo)
	{
		ammoList.add(ammo);
	}
		
	public void drawEmAll(Graphics window)
	{
		for (Ammo ammo : ammoList)
		{
			ammo.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Ammo ammo : ammoList)
		{
			ammo.move("UP");
		}
	}

	public void cleanEmUp()
	{
		for (int i = 0; i < ammoList.size(); i++)
		{
			if (ammoList.get(i).getY() - ammoList.get(i).getSpeed() < 0)
			{
				ammoList.remove(i);
				i--;
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammoList;
	}

	public String toString()
	{
		String a = "";
		for (Ammo ammo : ammoList)
		{
			a += ammo.toString();
		}
		return a;
	}
}

