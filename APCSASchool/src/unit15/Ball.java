package unit15;

import java.awt.Color;
import java.awt.Graphics;

import breakouttest.Wall;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
	}
	//add the other Ball constructors
	public Ball(int x, int y){
		super(x,y);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y,int h){
		super(x,y);
		setWidth(10);
		setHeight(h);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x,int y,int w,int h){
		super(x,y,w,h);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x,int y,int w,int h,int xS,int yS){
		super(x,y,w,h);
		setColor(Color.BLACK);
		xSpeed = xS;
		ySpeed = yS;
	}
	public Ball(int x,int y,int w,int h,Color col){
		super(x,y,w,h,col);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x,int y,int w,int h,Color col,int xS,int yS){
		super(x,y,w,h,col);
		xSpeed = xS;
		ySpeed = yS;
	}
   //add the set methods
   public void setXSpeed(int xs){
	   xSpeed = xs;
   }
   public void setYSpeed(int ys){
	   ySpeed = ys;
   }
 //add the get methods
   public int getXSpeed(){
	   return xSpeed;
   }
   public int getYSpeed(){
	   return ySpeed;
   }
	
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   window.setColor(Color.WHITE);
	   window.fillOval(getX(),getY(),getWidth(),getHeight());
	   
      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      window.setColor(getColor());
	  window.fillOval(getX(),getY(),getWidth(),getHeight());
   }
   
   public boolean didCollideLeft(Object obj){
	   Paddle p = (Paddle)obj;
	   //see if the ball hits the left paddle
	 		if((getX()<=p.getX()+p.getWidth()+Math.abs(getXSpeed()))
	 				&&(getY()>=p.getY()
	 				&&(getY()<=p.getY()+p.getHeight())
	 				||(getY()+getHeight()>=p.getY())
	 				&&(getY()+getHeight()<p.getY()+p.getHeight())))
	 		{	
	 			if(getX()<=p.getX()+p.getWidth()-Math.abs(getXSpeed())){
	 				return true;
	 			}
	 			else
	 				return false;
	 		}
	 		else
	 			return false;
   }
   public boolean didCollideRight(Object obj){
	   Paddle p = (Paddle)obj;
	   //see if the ball hits the right paddle
	   if((getX()>=p.getX()-p.getWidth()-Math.abs(getXSpeed()))
				&&(getY()>=p.getY()
				&&(getY()<=p.getY()+p.getHeight())
				||(getY()+getHeight()>=p.getY())
				&&(getY()+getHeight()<p.getY()+p.getHeight())))
		{
			if(getX()>=p.getX()-p.getWidth()+Math.abs(getXSpeed())){
				return true;
			}
			else
				return false;
		}
	   else
		   return false;
   }
   public boolean didCollideTop(Object obj){
	   Wall n = (Wall)obj;
	   if(!(getY()>=n.getY()+n.getHeight()))
			return true;
	   else
		   return false;
   }
   public boolean didCollideBottom(Object obj){
	   Wall n = (Wall)obj;
	   if(!(getY()<=n.getY()-n.getHeight()))
			return true;
	   else
		   return false;
   }
   public boolean didCollidePaddle(Object obj){
	   Paddle n = (Paddle)obj;
	   if(getY()>=n.getY()&&getX()>=n.getX()&&getX()<=n.getX()+n.getWidth()&&getY()<=n.getY()+n.getHeight())
			return true;
	   else
		   return false;
   }
   public boolean didCollideBlock(Object obj){
	   Block n = (Block)obj;
	   if(getY()>=n.getY()-10&&getY()<=n.getY()+n.getHeight()+10&&getX()>=n.getX()-10&&getX()<=n.getX()+n.getWidth()+10)
			return true;
	   else
		   return false;
   }
   public void remove(Graphics window){
	   window.setColor(Color.WHITE);
	   window.fillOval(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Ball thing = (Ball)obj;
		if(getX()==thing.getX()&&getY()==thing.getY()&&getWidth()==thing.getWidth()&&getHeight()==getHeight()&&getColor()==thing.getColor()&&getXSpeed()==thing.getXSpeed()&&getYSpeed()==thing.getYSpeed()){
			return true;
		}
		return false;
	}   

   //add a toString() method
	public String toString(){
		String output = getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor()+" "+getXSpeed()+" "+getYSpeed();
		
		return output;
	}

}