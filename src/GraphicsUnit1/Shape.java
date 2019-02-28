package GraphicsUnit1;

//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

   public Shape(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
                width = wid;
                height = ht;
                color = col;
   }


   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(xPos, yPos, width, height);
      
      window.setColor(Color.RED);
      window.fillRect(xPos + xPos/22, yPos + yPos/12, width - 10, height - 30);
      
      window.setColor(Color.GREEN);
      window.fillOval(xPos + xPos/12, yPos + yPos/5, width - 30, height - 70);
      
      window.setColor(Color.BLUE);
      window.draw3DRect(xPos, yPos, width, height, true);
      
      window.drawLine(xPos, yPos, xPos - 20, yPos - 20);
      
      window.drawLine(xPos + width, yPos, xPos + width + 20, yPos - 20);
      
 
      
      

      //draw whatever you want
      //    ^
      //  [ :: ]
      //    ()

   }

   //BONUS
   //add in set and get methods for all instance variables

   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}