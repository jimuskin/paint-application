package me.jimuskin.paint;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Images {
	
	PAINT("paint", new File("src/me/jimuskin/paint/images/paintbucket.png"), 220, 320);
	
	
	private Image image;
	private int x,y;
	private String name;
	
	private Images(String name, File file, int x, int y){
		try {
			image = ImageIO.read(new File("src/me/jimuskin/paint/images/paintbucket.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getHeight(){
		return image.getHeight(null);
	}
	
	public int getWidth(){
		return image.getWidth(null);
	}
	
	public Image getImage(){
		return image;
	}
	
	private String getName(){
		return name;
	}
	
	public static Images getImageFromString(String image){
		for(Images img : Images.values()){
			if(img.getName().equalsIgnoreCase(image))
				return img;
		}
		return null;
	}
}