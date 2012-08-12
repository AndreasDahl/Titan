package main;

import gfx.GamePanel;

import javax.swing.JFrame;

public class GameWindow {
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gf = new GamePanel(WIDTH, HEIGHT);
		frame.add(gf);
		frame.pack();
		frame.setVisible(true);
		gf.start();
	}
}
