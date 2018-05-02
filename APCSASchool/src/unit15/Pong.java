package unit15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.Timer;

import breakouttest.Wall;

import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable 
/*Entire class is made so that with each ball type, game ball can be quickly interchanged. 
Be sure to change all instances before running.  Currently set to regular Ball. */
{
	private Ball ball;
//	private SpeedUpBall ball;
//	private BlinkyBall ball;
//	private InvisibleBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftscore=0;
	private int rightscore=0;
	private Wall left;
	private Wall right;
	private Wall top;
	private Wall bottom;

	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(100,100,25,25,Color.CYAN,4,4);
//		ball = new SpeedUpBall(100,100,25,25,Color.CYAN,2,2);
//		ball = new BlinkyBall(100,100,25,25,Color.CYAN,4,4);
//		ball = new InvisibleBall(100,100,25,25,Color.CYAN,2,2);
		
		leftPaddle = new Paddle(20,100,15,60,Color.RED,5);
		rightPaddle = new Paddle(755,100,15,60,Color.RED,5);
		left = new Wall(0,0,10,600);
		right = new Wall(775,0,10,600);
		top = new Wall(0,0,800,10);
		bottom = new Wall(0,555,800,10);

		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
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


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		left.draw(graphToBack);
		right.draw(graphToBack);
		top.draw(graphToBack);
		bottom.draw(graphToBack);
		graphToBack.setColor(Color.GREEN);
		graphToBack.drawString("Left Score: "+leftscore, 50, 50);
		graphToBack.drawString("Right Score: "+rightscore, 50, 80);
		
		
		//see if ball hits left wall or right wall
		if(!((ball.getX()>=left.getX()+left.getWidth())&&(ball.getX()<=right.getX()-right.getWidth())))
		{
			if(!(ball.getX()>=left.getX()+left.getWidth())){
				rightscore++;
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Right Score: "+(rightscore-1), 50, 80);
				graphToBack.setColor(Color.GREEN);
				graphToBack.drawString("Right Score: "+rightscore, 50, 80);
				ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(ball.getYSpeed());//Does nothing for normal ball but speeds up for SpeedUpBall
			}
			if(!(ball.getX()<=right.getX()-right.getWidth())){
				leftscore++;
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left Score: "+(leftscore-1), 50, 50);
				graphToBack.setColor(Color.GREEN);
				graphToBack.drawString("Left Score: "+leftscore, 50, 50);	
				ball.setXSpeed(-ball.getXSpeed());
				ball.setYSpeed(ball.getYSpeed());
			}
		}
		//see if the ball hits the top or bottom wall 
		if(ball.didCollideBottom(bottom) || ball.didCollideTop(top))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true)
		{
			//move right paddle up and draw it on the window
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true)
		{
			//move right paddle down and draw it on the window
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		//see if the ball hits the left paddle
		if(ball.didCollideLeft(leftPaddle)){
			ball.setYSpeed(ball.getYSpeed());
			ball.setXSpeed(-ball.getXSpeed());
			}
		//see if the ball hits the right paddle
		if(ball.didCollideRight(rightPaddle)){
			ball.setYSpeed(ball.getYSpeed());
			ball.setXSpeed(-ball.getXSpeed());
			}

		//see if the paddles need to be moved
		if(leftPaddle.didCollideTop(top)||leftPaddle.didCollideBottom(bottom)){
			if(leftPaddle.didCollideTop(top))
				leftPaddle.moveDownAndDraw(graphToBack);
			if(leftPaddle.didCollideBottom(bottom))
				leftPaddle.moveUpAndDraw(graphToBack);
			}
		if(rightPaddle.didCollideTop(top)||rightPaddle.didCollideBottom(bottom)){
			if(rightPaddle.didCollideTop(top))
				rightPaddle.moveDownAndDraw(graphToBack);
			if(rightPaddle.didCollideBottom(bottom))
				rightPaddle.moveUpAndDraw(graphToBack);
			}


		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}