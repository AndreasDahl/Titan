package test;

import gfx.GamePanel;

import javax.swing.JFrame;

public class TestWindow {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gf = new GamePanel(600, 600);
		frame.add(gf);
		frame.pack();
		frame.setVisible(true);
		gf.start();
	}
}
