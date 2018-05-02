package unit15;

import java.awt.Color;
import java.awt.Graphics;

import breakouttest.Wall;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
	   setHeight(10);
	   setWidth(10);
	   speed = 5;
	   setColor(Color.BLACK);
	   
   }
   //add the other Paddle constructors
   public Paddle(int x,int y){
	   super(x,y);
	   setWidth(10);
	   setHeight(10);
	   speed = 5;
   }
   public Paddle(int x,int y,int w){
	   super(x,y,w);
	   setHeight(10);
	   setColor(Color.BLACK);
	   speed = 30;
	   
   }
   public Paddle(int x,int y,int w, int h,int s){
	   super(x,y,w,h);
	   speed = s;
   }
   public Paddle(int x,int y,int w,int h,Color col,int s){
	   super(x,y,w,h,col);
	   speed = s;
   }

   
   
   public void moveUpAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(),getY(),getWidth(),getHeight());
	   
		//paddle moves vertically only
      setY(getY()-speed);
		//draw the paddle at its new location
      window.setColor(getColor());
	  window.fillRect(getX(),getY(),getWidth(),getHeight());
   }

   public void moveDownAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(),getY(),getWidth(),getHeight());
	   
		//paddle moves vertically only
      setY(getY()+speed);
		//draw the paddle at its new location
      window.setColor(getColor());
	  window.fillRect(getX(),getY(),getWidth(),getHeight());
   }
   public void moveRightAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(),getY(),getWidth(),getHeight());
	   
		//paddle moves right
      setX(getX()+speed);
		//draw the paddle at its new location
      window.setColor(getColor());
	  window.fillRect(getX(),getY(),getWidth(),getHeight());
   }
   public void moveLeftAndDraw(Graphics window)
   {
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(),getY(),getWidth(),getHeight());
	   
		//paddle moves left
      setX(getX()-speed);
		//draw the paddle at its new location
      window.setColor(getColor());
	  window.fillRect(getX(),getY(),getWidth(),getHeight());
   }
   
   public boolean didCollideTop(Object obj){
	   Wall n = (Wall)obj;
	   if(getY()<=n.getY()+n.getHeight())
			return true;
	   else
		   return false;
   }
   public boolean didCollideBottom(Object obj){
	   Wall n = (Wall)obj;
	   if(getY()>=n.getY()-n.getHeight())
			return true;
	   else
		   return false;
   }
   public boolean didCollideLeft(Object obj){
	   Wall n = (Wall)obj;
	   if(getX()<=n.getX()+n.getWidth())
			return true;
	   else
		   return false;
   }
   public boolean didCollideRight(Object obj){
	   Wall n = (Wall)obj;
	   if(getX()>=n.getX()-n.getWidth())
			return true;
	   else
		   return false;
   }

   //add get methods
   public int getSpeed(){
	   return speed;
   }
   
   //setter
   public void setSpeed(int i){
	   speed = i;
   }
   
   //add a toString() method
   public String toString(){
	   String output = getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor()+" "+getSpeed();
	   
	   return output;
   }
}