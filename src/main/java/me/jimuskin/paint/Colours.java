package me.jimuskin.paint;

import java.awt.Color;

public enum Colours {
	BLACK(Color.black, 210, 20, 30, 30),
	WHITE(Color.white, 260, 20, 30, 30),
	BLUE(Color.blue, 210, 70, 30, 30),
	RED(Color.red, 260, 70, 30, 30),
	GREEN(Color.green, 210, 120, 30, 30),
	YELLOW(Color.yellow, 260, 120, 30, 30),
	CYAN(Color.cyan, 210, 170, 30, 30),
	MAGENTA(Color.magenta, 260, 170, 30, 30),
	GRAY(Color.gray, 210, 270, 30, 30),
	DARK_GRAY(Color.darkGray, 260, 270, 30, 30),
	ORANGE(Color.orange, 210, 220, 30, 30),
	PINK(Color.pink, 260, 220, 30, 30);
	
	
	private Color color;
	private int x, y, width, height;
	
	private Colours(Color color, int x, int y, int width, int height){
		this.color =  color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Color getColor(){
		return color;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}