package unit15s;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
	private Ball ball;

	public BallTestTwo()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//instantiate a new Ball
		ball = new Ball(100,100,100,100,Color.CYAN,2,2);

		//test the Ball thoroughly
		System.out.println(ball);
		ball.setXSpeed(5);
		ball.setYSpeed(5);
		System.out.println(ball.equals(new Ball(100,100,100,100,Color.CYAN,2,2))); //should be false due to the change in xSpeed and ySpeed

		//test all constructors
		ball = new Ball(100,100);
		ball = new Ball(100,100,50,50);
		ball = new Ball(100,100,50,50,Color.CYAN);
		ball = new Ball(100,100,50,50,Color.CYAN,10,10);
		

		new Thread(this).start();
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		ball.moveAndDraw(window);

		if(!(ball.getX()>=10 && ball.getX()<=550))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if(!(ball.getY()>=10 && ball.getY()<=450))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}
	}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(19);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}