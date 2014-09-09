package me.jimuskin.paint;

import java.awt.Color;

public class Paint {
	
	private int x,y, thickness;
	private Color color;
	
	private int height = -1, width = -1;
	
	public Paint(Color color, int x, int y, int thickness){
		this.color = color;
		this.x = x;
		this.y = y;
		this.thickness = thickness;
	}
	
	public Paint(Color color, int x, int y, int height, int width){
		this.color = color;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getThickness(){
		return thickness;
	}
	
	public Color getColor(){
		return color;
	}
}