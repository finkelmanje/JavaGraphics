package GraphicsUnit1;

//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600; //final is constant to make graphics constant

	public GraphicsRunner()
	{
		super("Graphics Runner"); //sets title

		setSize(WIDTH,HEIGHT); //jframe type of method

	//	getContentPane().add(new SmileyFace());
		
		//add other classes to run them 
		//BigHouse, Robot, or ShapePanel 
                
        //        getContentPane().add(new BigHouse());
        
        getContentPane().add(new Robot());

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops program when window closed
	}

	public static void main( String args[] )
	{
		GraphicsRunner run = new GraphicsRunner();
	}
}