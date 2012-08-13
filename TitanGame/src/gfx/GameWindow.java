package gfx;

import java.awt.event.KeyEvent;

import gfx.GamePanel;

import javax.swing.JFrame;

import logic.Game;

import controller.InputHandler;
import controller.Key;

public class GameWindow extends GamePanel {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 320;
	private static final int HEIGHT = 320;
	private static InputHandler input;
	
	private Game game;
	public static Key w, a, s, d;
	
	public GameWindow(int width, int height) {
		super(width, height);
		
		initGame();
		initControl();
	}
	
	private void initGame() {
		game = new Game();
		setComponent(game);
	}
	
	private void initControl() {
		input = new InputHandler();
		w = new Key(input, KeyEvent.VK_W);
		a = new Key(input, KeyEvent.VK_A);
		s = new Key(input, KeyEvent.VK_S);
		d = new Key(input, KeyEvent.VK_D);
		addKeyListener(input);
		setInputHandler(input);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gp = new GameWindow(WIDTH, HEIGHT);
		frame.add(gp);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(input);
		gp.start();
	}
}
