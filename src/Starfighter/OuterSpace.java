package Starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
        private Ammo ammo1;
        private int counter;
        private Bullets shots;
        private AlienHorde horde;


	

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];
               ship = new Ship(50,50, 50, 50, 3);
               alienOne = new Alien(100,100, 50, 50,3);
               alienTwo = new Alien(200, 100, 50, 50, 5);
               ammo1 = new Ammo(ship.getX() + 22, ship.getY(), 5);
               shots = new Bullets();
               horde = new AlienHorde(28);
               for(int x = 8; x < StarFighter.WIDTH - 100; x += (StarFighter.WIDTH) / 8) 
			for(int y = 22; y < StarFighter.HEIGHT / 1.5; y += (StarFighter.HEIGHT / 1.5) / 4) 
				horde.add(new Alien(x + 20, y, 25, 25, 1));

               
        

		//instantiate other instance variables
		//Ship, Alien

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
         
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
                counter++;
               
                setVisible(true);
                ship.draw(graphToBack);
               
                // alienOne.draw(graphToBack);
                // alienTwo.draw(graphToBack);
                 ammo1.draw(graphToBack);
                 
                for(int a = 0; a < horde.getSize(); a++){
			horde.get(a).move("RIGHT");
			horde.get(a).draw(graphToBack);
                       
		}
		
		for(Alien a : horde.getArray()){
		if (!(a.getX() >= 0 && a.getX() <= 720)){
			a.setSpeed(-a.getSpeed());
		}
	}


		if(keys[0] == true)
		{
			ship.move("LEFT");
                        ammo1.setX(22+ ship.getX());
                        ammo1.setY(ship.getY());
                        
		}
                
                if(keys[1] == true)
		{
			ship.move("RIGHT");
                        ammo1.setX(22+ ship.getX());
                        ammo1.setY(ship.getY());
		}
                
                if(keys[2] == true)
		{
			ship.move("UP");
                        ammo1.setX(22+ ship.getX());
                        ammo1.setY(ship.getY());
		}
                
                if(keys[3] == true)
		{
			ship.move("DOWN");
                        ammo1.setX(22+ ship.getX());
                        ammo1.setY(ship.getY());
       
		}
                
                if (keys[4] == true) {
                    if (counter >= 70) {
				shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 2, ship.getY(), 5));
				counter = 0;
			}
                }
                
                horde.moveEmAll();
		shots.moveEmAll();
		horde.removeDeadOnes(shots.getList());
		shots.cleanEmUp();
		
		
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString(""+horde.getSize(), 740, 530);
		ship.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		horde.drawEmAll(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
                
                 
		//add code to move Ship, Alien, etc.


		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship


	
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

