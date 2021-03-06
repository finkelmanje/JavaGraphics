package JohnFinkelman_starfighter;

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
//	private Alien alienOne;
//	private Alien alienTwo;
	private int score;
	private boolean lose;

	/* uncomment once you are ready for this part
	 */
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	private ArrayList<Ammo> alienshots;
//	private Alien[][] alienz;
	private PowerUp pu;
	private boolean puActivated = false;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		
		ship = new Ship(100,450,2);
		//alienOne = new Alien(20,0,3);
		//alienTwo = new Alien(680,0,3);
		shots = new ArrayList<Ammo>();
		alienshots = new ArrayList<Ammo>();
		score = 0;
		lose = false;
		pu = new PowerUp();
		
//		alienz = new Alien[2][2];
		aliens = new ArrayList<Alien>();
		
		
		Aliens a = new Aliens();
//		alienz = a.getList();
		
		for(int i=0;i<a.getList().length;i++){
			for(int j=0;j<a.getList()[0].length;j++){
				aliens.add(a.getList()[i][j]);
			}
		}
		
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
		
		graphToBack.setColor(Color.CYAN);
		graphToBack.drawString("Score: " + score, 500, 500);
		ship.draw(graphToBack);
		pu.draw(graphToBack);
		
		for(int i=0;i<aliens.size();i++){
			aliens.get(i).draw(graphToBack);
		}
		
		//alienOne.draw(graphToBack);
		//alienTwo.draw(graphToBack);
		
		
		

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		
		//add code to move stuff
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		if(keys[4] == true)
		{
			int col = (int)(Math.random()*99+1);
			if(col>90)
				shots.add(new Ammo(ship.getX()+36,ship.getY(),3));
			else
				shots.add(new Ammo(ship.getX()+36,ship.getY(),2));
			keys[4] = false;
		}
		
		if(ship.getX()+80>=pu.getX() &&	ship.getX()<=pu.getX()&&ship.getY()+80 >= pu.getY() &&ship.getY()<=pu.getY()){
			pu.setPos(2500, 2500);
			puActivated = true;
		}
		
		if(puActivated){
			ship.drawPU(graphToBack);
		}
		
		
		
		
		
		
		
		
		
		for(int i=0;i<aliens.size(); i++){
			int thispos = (int)(Math.random()*700);
			if(thispos<aliens.get(i).getX()-400||thispos>aliens.get(i).getX()+400){
				alienshots.add(new Ammo(aliens.get(i).getX()+36,aliens.get(i).getY(),1));
			}
		}
		
		
		for(int i=0;i<alienshots.size() - 8;i++){
			alienshots.get(i).aliendraw(graphToBack);
			if(puActivated==false){
                            
				if(ship.getX()+80>=alienshots.get(i).getX() &&	ship.getX()<=alienshots.get(i).getX()&&	ship.getY()+80 >= alienshots.get(i).getY() &&	ship.getY()<=alienshots.get(i).getY()){
					graphToBack.setColor(Color.BLACK);
					graphToBack.drawString("Score: " + score, 500, 500);
					score -= 2;
					graphToBack.setColor(Color.CYAN);
					graphToBack.drawString("Score: " + score, 500, 500);
					alienshots.get(i).setPos(5000,0);
				}
			}
			else if(puActivated){
				if(ship.getX()+80>=alienshots.get(i).getX() &&	ship.getX()<=alienshots.get(i).getX()&&	ship.getY()+80 >= alienshots.get(i).getY() &&	ship.getY()<=alienshots.get(i).getY()){
					alienshots.get(i).setPos(5000,0);
				}
			}
				
			
		}
		
		for(int i=0;i<shots.size();i++){
			shots.get(i).draw(graphToBack);
//			
			for(int a=0;a<aliens.size();a++){
				if((aliens.get(a).getX()+80>=shots.get(i).getX()&&aliens.get(a).getX()<=shots.get(i).getX())&&
						(aliens.get(a).getY()+80>=shots.get(i).getY()&&aliens.get(a).getY()<=shots.get(i).getY())){
					aliens.get(a).setPos(1200, 1200);
					aliens.remove(aliens.get(a));
					graphToBack.setColor(Color.BLACK);
					graphToBack.drawString("Score: " + score, 500, 500);
					score += 500;
					graphToBack.setColor(Color.CYAN);
					graphToBack.drawString("Score: " + score, 500, 500);
					shots.get(i).setPos(5000,0);
					
				}
			}
		}
			
		
		
//		
		
		//add in collision detection
		for(int i=0;i<aliens.size();i++){
			if(aliens.get(i).getX()<10||aliens.get(i).getX()>700){
				aliens.get(i).setSpeed((aliens.get(i).getSpeed())*-1);
			}
		}
		

		for(int a=0;a<aliens.size();a++){
				if((aliens.get(a).getX()+80>=ship.getX()&&aliens.get(a).getX()<=ship.getX())&&
						(aliens.get(a).getY()+80>=ship.getY()&&aliens.get(a).getY()<=ship.getY())){
	
                                                score-=50;
						
					
				}
                                
                                 if ((aliens.get(a).getX()+80>=ship.getX()&&aliens.get(a).getX()<=ship.getX())&&
						(aliens.get(a).getY()+80>=ship.getY()&&aliens.get(a).getY()<=ship.getY()) && score < -4000) {
                                    lose = true;
                                }
		}
		
		if(!lose&&aliens.size()==0){
			for(int i=0;i<alienshots.size();i++){
				alienshots.get(i).setPos(5000,0);
			}
			graphToBack.setColor(Color.CYAN);
			graphToBack.drawString("YOU WON WITH A SCORE OF "+score+"! ", 250, 250);
		}
		
		if(lose){
			for(int b=0;b<aliens.size();b++){
				aliens.remove(b);
			}
			for(int i=0;i<alienshots.size();i++){
				alienshots.get(i).setPos(5000,0);
			}
                        
			graphToBack.setColor(Color.CYAN);
			graphToBack.drawString("You lost by taking too much damage!", 250, 250);
			ship.setPos(8000, 8000);
		}
		

		twoDGraph.drawImage(back, null, 0, 0);
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

