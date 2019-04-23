package WinterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
public class SimpleSnowFlake extends AbstractShape {
    
    public SimpleSnowFlake(int x, int y, int wid, int ht)
   {
       super(x,y,wid,ht);
   }
   
   public SimpleSnowFlake(int x, int y, int wid, int ht, Color col)
   {
		super(x,y,wid,ht,col);
   }   
   
   public SimpleSnowFlake(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		super(x,y,wid,ht,col,xSpd,ySpd);
   }  
   
   public void draw(Graphics window) {
      // window.setColor(Color.WHITE);
       window.drawOval(super.getXPos(),super.getYPos(), 9, 8);
       
   }
   
   public void moveAndDraw(Graphics window) {
       window.setColor(Color.BLUE);
       draw(window);
       
     // setXPos(getXPos()+getXSpeed());
		//setY
      setYPos(getYPos() + getYSpeed());
      
      window.setColor(Color.WHITE);
      draw(window);
       
       
   }
   
   public String toString() {
       return super.getXPos()+" "+super.getYPos()+" "+super.getWidth()+" "+super.getHeight()+" "+super.getColor()+" "+super.getXSpeed()+" "+super.getYSpeed();
   }
}

