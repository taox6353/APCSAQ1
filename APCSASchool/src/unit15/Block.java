package unit15;

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block(){
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = Color.BLACK;
	}
	//add other Block constructors - x , y , width, height, color
	public Block(int x,int y){
		xPos = x;
		yPos = y;
		color = Color.BLACK;
	}
	public Block(int x,int y,int w){
		xPos = x;
		yPos = y;
		width = w;
	}
	public Block(int x,int y,int w,int h){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = Color.BLACK;
	}
	public Block(int x,int y,int w,int h,Color c){
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}
	
	//add the other set methods
	//add the other get methods
	
	public void setPos( int x, int y){
		xPos = x;
		yPos = y;
	}
    public void setX( int x ){
    	xPos = x;
    }
    public void setY( int y ){
    	yPos = y;
    }

    public int getX(){
    	return xPos;
    }
    public int getY(){
    	return yPos;
    }
	
   public void setWidth(int w){
	   width = w;
   }
   public int getWidth(){
	   return width;
   }
   public void setHeight(int h){
	   height = h;
   }
   public int getHeight(){
	   return height;
   }
   public void setColor(Color col){
	   color = col;
   }
   public Color getColor(){
	   return color;
   }
   
   
   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(getColor());
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   public void draw(Graphics window, Color col)
   {
	   color = col;
	   window.setColor(color);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   public void remove(Graphics window){
	   window.setColor(Color.WHITE);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
   
	public boolean equals(Object obj)
	{
		Block thing = (Block)obj;
		if(getX()==thing.getX()&&getY()==thing.getY()&&getWidth()==thing.getWidth()&&getHeight()==getHeight()&&getColor()==thing.getColor())
			return true;
		else		
			return false;
	}   
	
   //add a toString() method  - x , y , width, height, color
	public String toString(){
		String output = getX()+" "+getY()+" "+getWidth()+" "+getHeight()+" "+getColor();
		
		return output;
	}
	
	
}