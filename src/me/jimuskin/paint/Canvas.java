package me.jimuskin.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Canvas extends JPanel implements MouseMotionListener, MouseInputListener{
	private static final long serialVersionUID = 5947352431859280339L;
	
	private Color color = Color.black;
	private int thickness = 20;
	
	private int x = -30, y = - 30;
	private boolean done = false;
	private boolean erase = false;
	private boolean fill = false;
	
	private List<Paint> canvas = new ArrayList<Paint>();
	
	public Canvas(){
		setBorder(BorderFactory.createDashedBorder(Color.black));
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		addPaintbars(g);
		
		for(Paint paint : canvas){
			System.out.println(paint.getWidth());
			if(paint.getWidth() == -1){
				System.out.println("a");
				g.setColor(paint.getColor());
				g.fillRect( paint.getX(), paint.getY(), paint.getThickness(), paint.getThickness());
			}else{
				System.out.println("aa");
				this.fill(paint.getColor(), g);
			}
			
		}
		
		if(x + thickness  > 200){
			thickness = (x - 200) * -1;
		}
		
		if(fill){
			this.fill(color, g);
			canvas.add(new Paint(g.getColor(), 0, 0, 500, 200));
			fill = false;
		}else{
			g.setColor(color);

			if(erase){
				g.setColor(Color.white);
			}else{
				g.setColor(color);
			}
			g.fillRect(x, y, thickness, thickness);
			canvas.add(new Paint(g.getColor(), x, y, thickness));
		}
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		thickness = 20;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setThickness(int thickness){
		if(thickness > 20) thickness = 20;
		this.thickness = thickness;
	}
	
	private void fill(Color color, Graphics graphics){
		graphics.setColor(color);
		graphics.fillRect(0, 0, 200, 500);
	}
	
	private void addPaintbars(Graphics graphics){
		this.fill(Color.white, graphics);
		
		for(Colours colour : Colours.values()){
			graphics.setColor(colour.getColor());
			graphics.fillRect(colour.getX(), colour.getY(), colour.getWidth(), colour.getHeight());
		}
		for(Images image : Images.values())
			graphics.drawImage(image.getImage(), image.getX(), image.getY(), null);
		
		done = true;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
			if(event.getButton() == MouseEvent.BUTTON3){
				erase = true;
			}
			x = event.getX();
			y = event.getY();
			
			repaint();
	}

	@Override
	public void mousePressed(MouseEvent event) {
		for(Colours colour : Colours.values()){
			if(event.getX() >= colour.getX() && event.getX() <= (colour.getX() + colour.getWidth())){
				if(event.getY() >= colour.getY() && event.getY() <= (colour.getY() + colour.getHeight())){
					if(event.getClickCount() >= 2){
						this.color = colour.getColor();
						return;
					}
				}
			}
		}
		for(Images image : Images.values()){
			if(event.getX() >= image.getX() && event.getX() <= (image.getX() + image.getWidth())){
				if(event.getY() >= image.getY() && event.getY() <= (image.getY() + image.getHeight())){
					if(event.getClickCount() >= 2){
						if(image.getImage() == Images.getImageFromString("paint").getImage()){
							fill = true;
							repaint();
						}
						return;
					}
				}
			}
		}
		
		if(event.getButton() == MouseEvent.BUTTON3)
			erase = true;
		else
			erase = false;
		x = event.getX();
		y = event.getY();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent event) {}

	@Override
	public void mouseDragged(MouseEvent event) {
		if(event.getButton() == MouseEvent.BUTTON3)
			erase = true;
		else
			erase = false;
		
			x = event.getX();
			y = event.getY();
			repaint();
	}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent event) {}
}