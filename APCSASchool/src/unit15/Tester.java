package unit15;

import javax.swing.JFrame;

import breakouttest.Breakout;

import java.awt.Component;

public class Tester extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Tester()
	{
		super("PONG TESTER");
		setSize(WIDTH,HEIGHT);
		
		//getContentPane().add(new BlockTestTwo());		
		
		//uncomment when you are ready to test the Ball
		//getContentPane().add(new BallTestTwo());
		
//		PaddleTestTwo padTest = new PaddleTestTwo();
//		((Component)padTest).setFocusable(true);			
//		getContentPane().add(new PaddleTestTwo());//padTest);
		
		//uncomment to test pong
//		Pong pong = new Pong();
//		((Component)pong).setFocusable(true);			
//		getContentPane().add(pong);
		
		//uncomment to test breakout
		Breakout bo = new Breakout();
		((Component)bo).setFocusable(true);			
		getContentPane().add(bo);
		
		//uncomment to test airhockey
//		AirHockey ah = new AirHockey();
//		((Component)ah).setFocusable(true);	
//		getContentPane().add(ah);
		
				
		setVisible(true);
	}
	
	public static void main( String args[] )
	{
		Tester run = new Tester();
	}
}