package unit15s;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
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
	public Ball(int x,int y,int w,int h){
		super(x,y,w,h);
		setColor(Color.BLACK);
		xSpeed = 3;
		ySpeed = 1;
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
      
      Ball c = new Ball(getX(),getY(),getWidth(),getHeight(),getColor());
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