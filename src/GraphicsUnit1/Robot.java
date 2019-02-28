package GraphicsUnit1;

//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      head(window);
      
      //call other methods
      upperBody(window);
      
      lowerBody(window);
   }

   public void head( Graphics window )
   {
      window.setColor(Color.YELLOW);

      window.fillOval(300, 100, 200, 100);
      
      window.setColor(Color.GREEN);
      window.fillOval(325, 120, 40, 25);
      window.fillOval(425, 120, 40, 25);
      
      window.setColor(Color.BLACK);
      window.fillOval(390, 148, 15, 15);
      
       window.setColor(Color.RED);
       window.fillArc(360, 165, 70 , 25, 0, -180);

		//add more code here
				
   }

   public void upperBody( Graphics window )
   {

		//add more code here
      window.setColor(Color.BLUE);

      window.fillRect( 330, 250, 130, 130 );
      
      window.setColor(Color.BLACK);
      
      window.drawLine(330, 250, 150 , 150);
      
      window.drawLine(460, 250, 640 , 150);
   }

   public void lowerBody( Graphics window )
   {

		//add more code here
      window.setColor(Color.GRAY);

      window.fillRect( 330, 400, 130, 130 );
      
      window.setColor(Color.BLACK);
      
      window.drawLine(330, 530, 150 , 630);
      
      window.drawLine(460, 530, 640 , 630);
   }
}