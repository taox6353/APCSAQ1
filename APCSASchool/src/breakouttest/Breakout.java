package breakouttest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

import unit15.Ball;
import unit15.Block;
import unit15.Paddle;

import java.awt.event.ActionListener;

public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle Paddle;
	private boolean[] keys;
	private BufferedImage back;
	private Wall left;
	private Wall right;
	private Wall top;
	private Wall bottom;
	private int score;
	
	private Block[][] blocks =new Block[5][4];
	
	public Breakout()
	{
		System.out.println("Xavier Tao\nPeriod 4\nApril 4,2018\nComputer 28");
		
		//set up all variables related to the game
		ball = new Ball(300,300,15,15,Color.CYAN,3,3);
		Paddle = new Paddle(760,340,10,80,Color.RED,5);
		left = new Wall(0,0,10,600);
		right = new Wall(775,0,10,600);
		top = new Wall(0,0,800,10);
		bottom = new Wall(0,555,800,10);
		
		for(int i=0;i<4;i++){
			blocks[0][i] = new Block(10+i*20,50,10,80,Color.MAGENTA);
			blocks[1][i] = new Block(10+i*20,150,10,80,Color.MAGENTA);
			blocks[2][i] = new Block(10+i*20,250,10,80,Color.MAGENTA);
			blocks[3][i] = new Block(10+i*20,350,10,80,Color.MAGENTA);
			blocks[4][i] = new Block(10+i*20,450,10,80,Color.MAGENTA);
		}

		keys = new boolean[2];

    
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
		Paddle.draw(graphToBack);
		left.draw(graphToBack);
		right.draw(graphToBack);
		top.draw(graphToBack);
		bottom.draw(graphToBack);
		graphToBack.setColor(Color.GREEN);
		graphToBack.drawString("Score: "+score, 400, 500);
		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				blocks[i][j].draw(graphToBack);
			}
		}
		
		graphToBack.setColor(Color.GREEN);


		//see if ball hits left wall or right wall
		if(!((ball.getX()>=left.getX()+left.getWidth())&&(ball.getX()<=right.getX()-right.getWidth())))
		{
			if(!(ball.getX()>=left.getX()+left.getWidth())){
				ball.setXSpeed(-ball.getXSpeed());
			}
			if(!(ball.getX()<=right.getX()-right.getWidth())){
				ball = new Ball(ball.getX(),ball.getY(),0,0,Color.GRAY,3,3);
				
				ball = new Ball(300,300,15,15,Color.CYAN,3,3);
				ball.moveAndDraw(graphToBack);
				
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Score: "+(score), 400, 500);
				score = 0;
				graphToBack.setColor(Color.GREEN);
				graphToBack.drawString("Score: "+score, 400, 500);
				
			}
		}
		//see if the ball hits the top or bottom wall
		if(!(ball.getY()>=top.getY()+top.getHeight()))
			ball.setYSpeed(-ball.getYSpeed());
		if(!(ball.getY()<=bottom.getY()-bottom.getHeight()))
			ball.setYSpeed(-ball.getYSpeed());

		if(keys[0] == true)
		{
			//move paddle up
			Paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true)
		{
			//move paddle down
			Paddle.moveDownAndDraw(graphToBack);
			
			
		}
		//see if the ball hits the right paddle
		if(ball.didCollideRight(Paddle))
		{
			ball.setYSpeed(ball.getYSpeed());
			ball.setXSpeed(-ball.getXSpeed());
		}

		for(int i=0;i<5;i++){
			for(int j=0;j<4;j++){
				if(ball.getY()>=blocks[i][j].getY()-10&&ball.getY()<=blocks[i][j].getY()+blocks[i][j].getHeight()+10&&ball.getX()>=blocks[i][j].getX()-10&&ball.getX()<=blocks[i][j].getX()+blocks[i][j].getWidth()+10&&blocks[i][j].getColor()==Color.MAGENTA)
				{
					score++;
					graphToBack.setColor(Color.WHITE);
					blocks[i][j] = new Block(blocks[i][j].getX(), blocks[i][j].getY(), blocks[i][j].getWidth(), blocks[i][j].getHeight(),Color.WHITE);
					graphToBack.drawString("Score: "+(score-1), 400, 500);
					graphToBack.setColor(Color.GREEN);
					graphToBack.drawString("Score: "+score, 400, 500);
					
					blocks[i][j].draw(graphToBack);
					ball.setYSpeed(ball.getYSpeed());
					ball.setXSpeed(-ball.getXSpeed());
				}
						
			}
		}
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
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