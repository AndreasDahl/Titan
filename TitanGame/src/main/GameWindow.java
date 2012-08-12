package main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import gfx.GamePanel;

import javax.swing.JFrame;

import controller.InputHandler;
import controller.Key;

public class GameWindow {
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	private static InputHandler input;
	public static Key w, a, s, d;
	
	public enum noget {
		GRASS, DIRT, BLACK
	}
	
	private static void initControl() {
		input = new InputHandler();
		w = new Key( input, KeyEvent.VK_W);
		a = new Key( input, KeyEvent.VK_A);
		s = new Key( input, KeyEvent.VK_S);
		d = new Key( input, KeyEvent.VK_D);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gf = new GamePanel(WIDTH, HEIGHT);
		frame.add(gf);
		gf.setPreferredSize(new Dimension(320, 320));
		frame.pack();
		frame.setVisible(true);
		gf.setComponent(new Game());
		gf.start();
	}
}
