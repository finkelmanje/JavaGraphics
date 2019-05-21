package JohnFinkelman_starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;

public class StarFighter extends JFrame
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public StarFighter()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace theGame = new OuterSpace();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
                
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
                System.out.println("John Finkelman, Period 1, May 8, Computer#25");
		StarFighter run = new StarFighter();
	}
}