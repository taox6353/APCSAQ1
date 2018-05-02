package breakouttest;

import java.awt.Color;
import java.awt.Graphics;

import unit15.Block;

public class Wall extends Block {
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Wall(){
		super(100,100);
	}
	public Wall(int x,int y,int w,int h){
		super(x,y,w,h);
		this.x=x;
		this.y=y;
		width=w;
		height=h;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void draw(Graphics window)
	   {
	      window.setColor(Color.GRAY);
	      window.fillRect(getX(), getY(), getWidth(), getHeight());
	   }
}