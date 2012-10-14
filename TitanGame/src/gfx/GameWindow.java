package gfx;

import java.awt.event.KeyEvent;

import gfx.GamePanel;

import javax.swing.JFrame;

import logic.Room;

import controller.InputHandler;
import controller.Key;

public class GameWindow extends GamePanel {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 160;
	private static final int HEIGHT = 160;
	private static InputHandler input;
	public static JFrame frame;
	
	private Room game;
	public static Key w, a, s, d;
	
	public GameWindow(int width, int height) {
		super(width, height, 4);
		
		initGame();
		initControl();
	}
	
	private void initGame() {
		game = new Room();
		setComponent(game);
	}
	
	private void initControl() {
		input = new InputHandler();
		w = new Key();
		input.addKey(KeyEvent.VK_W, w);
		a = new Key();
		input.addKey(KeyEvent.VK_A, a);
		s = new Key();
		input.addKey(KeyEvent.VK_S, s);
		d = new Key();
		input.addKey(KeyEvent.VK_D, d);
		addKeyListener(input);
		setInputHandler(input);
	}
	
	public static void main(String[] args) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePanel gp = new GameWindow(WIDTH, HEIGHT);
		frame.add(gp);
		frame.pack();
		frame.addKeyListener(input);
		frame.setVisible(true);
		gp.start();
	}
}
