package me.jimuskin.paint;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {
	
	public Main(){
		JFrame frame = new JFrame("Paint");
		
		JTextField field = new JTextField();
		field.setBounds(10, 10, 75, 30);
		field.setText("10");
		frame.add(field);
		
		frame.setContentPane(new Canvas());
		frame.pack();
		
		Dimension dimension = new Dimension(300, 500);
		frame.setSize(dimension);
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		new Main();
	}
}