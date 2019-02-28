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

public class BigHouse extends Canvas
{
   public BigHouse()  //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      bigHouse(window);
   }

   public void bigHouse( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString( "BIG HOUSE ", 50, 50 );

      window.setColor(Color.BLUE);

      window.fillRect( 200, 200, 400, 400 );
      
      window.setColor(Color.WHITE);
      
      window.fillRect( 380, 450, 50, 100 );
      
       window.setColor(Color.YELLOW);
      
      window.fillRect( 280, 250, 50, 50);
              
      window.fillRect( 480, 250, 50, 50 );
      
      window.setColor(Color.GREEN);
      
      window.fillRect( 180, 150, 430, 75);
        

   }
}